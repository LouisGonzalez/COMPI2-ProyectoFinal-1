/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembler;

import cuartetos.Nodo;
import java.util.ArrayList;

/**
 *
 * @author luisGonzalez
 */
public class Generacion {

    public static String varArreglo = "";
    public boolean esHeap = false;
    public static String codigoResto, codigoMain;
    public static String metodoActual = "";
    
    public String codigoFormal(ArrayList<Nodo> ejecutable, ArrayList<Objetos> misObjetos){
        String codigo = "";
        codigo += "title *falta titulo*\n"
                + "include irvine32.inc\n";
        for (int i = 0; i < ejecutable.size(); i++) {
            if (ejecutable.get(i).getOperacion().equals("TEMP")) {
                misObjetos.add(new Objetos("DWORD", ejecutable.get(i).getVar(), 0));
            } else if (ejecutable.get(i).getOperacion().equals("PRINT")) {
                misObjetos.add(new Objetos("BYTE", "mensaje" + i, ejecutable.get(i).getVar()));
            }
        }
        codigo += ".data\n";
        codigo += "stack DW 100000 DUP(0)\n"
                + "heap DW 100000 DUP(0)\n";
        for (int i = 0; i < misObjetos.size(); i++) {
            if (misObjetos.get(i).getTipo().equals("BYTE")) {
                codigo += misObjetos.get(i).getId() + " " + misObjetos.get(i).getTipo() + " " + misObjetos.get(i).getDato() + ",0" + "\n";
            } else {
                codigo += misObjetos.get(i).getId() + " " + misObjetos.get(i).getTipo() + " " + misObjetos.get(i).getDato() + "\n";
            }
        }
        codigo += ".code\n";

        codigoResto = "";
        codigoMain = "";
        metodoActual = "";
        codigoResto = generarCodigo(ejecutable, misObjetos, 0, false);
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println(codigoResto);
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println(codigoMain);
        codigo += codigoMain;
        codigo += codigoResto;
        codigo += "END main";
        return codigo;
    }

    public String generarCodigo(ArrayList<Nodo> ejecutable, ArrayList<Objetos> misObjetos, int iterador, boolean entro) {
        String codigo  = "";
        for (int i = iterador; i < ejecutable.size(); i++) {
            if (ejecutable.get(i).getOperacion().equals("PRINT")) {
                codigo += "mov edx,offset mensaje" + i + "\n"
                        + "call writestring";
            } else if (ejecutable.get(i).getOperacion().equals("SCANF")) {
                codigo += "call readdec\n"
                        + "mov " + ejecutable.get(i).getVar() + "," + "eax\n";
            } else if (ejecutable.get(i).getOperacion().equals("suma")) {
                codigo += "mov eax,0\n"
                        + "add eax," + ejecutable.get(i).getDato1() + "\n"
                        + "add eax," + ejecutable.get(i).getDato2() + "\n"
                        + "mov " + ejecutable.get(i).getVar() + ",eax\n"
                        + "mov eax,0\n";
            } else if (ejecutable.get(i).getOperacion().equals("resta")) {
                codigo += "mov eax,0\n"
                        + "add eax," + ejecutable.get(i).getDato1() + "\n"
                        + "sub eax," + ejecutable.get(i).getDato2() + "\n"
                        + "mov " + ejecutable.get(i).getVar() + ",eax\n"
                        + "mov eax,0\n";
            } else if (ejecutable.get(i).getOperacion().equals("mult")) {
                codigo += "mov eax,"+ejecutable.get(i).getDato1()+"\n"
                        + "mov ebx,"+ejecutable.get(i).getDato2()+"\n"
                        + "mul ebx\n"
                        + "mov "+ejecutable.get(i).getVar()+",eax\n"
                        + "mov ebx,0\n"
                        + "mov eax,0\n";
            } else if (ejecutable.get(i).getOperacion().equals("div")) {    
                codigo += "mov edx,0\n"
                        + "mov eax,"+ejecutable.get(i).getDato1()+"\n"
                        + "mov ebx,"+ejecutable.get(i).getDato2()+"\n"
                        + "div ebx\n"
                        + "mov "+ejecutable.get(i).getVar()+",eax\n"
                        + "mov edx,0\n"
                        + "mov eax,0\n"
                        + "mov ebx,0\n";
            } else if (ejecutable.get(i).getOperacion().equals("modulo")) {
                codigo += "mov edx,0\n"
                        + "mov eax,"+ejecutable.get(i).getDato1()+"\n"
                        + "mov ebx,"+ejecutable.get(i).getDato2()+"\n"
                        + "div ebx\n"
                        + "mov "+ejecutable.get(i).getVar()+",edx\n"
                        + "mov edx,0\n"
                        + "mov eax,0\n"
                        + "mov ebx,0\n";
            } else if (ejecutable.get(i).getOperacion().equals("ETIQUETA")) {
                codigo += ejecutable.get(i).getDato1() + ":\n";
            } else if (ejecutable.get(i).getOperacion().equals("asig")) {
                String var1, asignado;
                if(esArreglo(ejecutable.get(i).getDato1().toString())){
                    if(esHeap){
                        var1 = "heap["+varArreglo+"]";
                    } else {
                        var1 = "stack["+varArreglo+"]";
                    }
                    varArreglo = "";
                } else {
                    var1 = ejecutable.get(i).getDato1().toString();
                }
                if(esArreglo(ejecutable.get(i).getVar())){
                    if(esHeap){
                        asignado = "heap["+varArreglo+"]";
                    } else {
                        asignado = "stack["+varArreglo+"]";
                    }
                    varArreglo = "";
                } else {
                    asignado = ejecutable.get(i).getVar();
                }
                //seccion de asignacion
                codigo += "mov "+asignado+","+var1+"\n";
            } else if(ejecutable.get(i).getOperacion().equals("GOTO")){
                codigo += "jmp "+ejecutable.get(i).getVar()+"\n";
            } else if(ejecutable.get(i).getOperacion().equals("CALL")){
                codigo += "call "+quitarParentesis(ejecutable.get(i).getDato1().toString())+"\n";
            } else if(ejecutable.get(i).getOperacion().equals("CREACION_METODO")){
                if(ejecutable.get(i).getVar().equals("main")){
                    if(entro){
                        codigo += ejecutable.get(i).getVar()+" proc\n";
                        metodoActual = ejecutable.get(i).getVar();
                    } else {
                        codigoMain = generarCodigo(ejecutable, misObjetos, i, true);
                        break;
                    }
                } else {
                    codigo += ejecutable.get(i).getVar()+" proc\n";
                    metodoActual = ejecutable.get(i).getVar();
                }
            } else if(ejecutable.get(i).getOperacion().equals("FIN_METODO")){
                if(metodoActual.equals("main")){
                    codigo += "EXIT\n"
                            + "main ENDP\n";
                } else {
                    codigo += "ret\n"
                            + metodoActual + " endp\n";
                }
                metodoActual = "";
            } else if(ejecutable.get(i).getOperacion().equals("CLSCR")){
                //no hace nada
            } else if(ejecutable.get(i).getOperacion().equals("GETCH")){
                //no hace nada
            } else if(ejecutable.get(i).getOperacion().equals("RETURN")){
                //no hace nada
            } else if(ejecutable.get(i).getOperacion().equals("PARAM")){
                //no hace nada
            } else if(ejecutable.get(i).getOperacion().equals("TEMP")){
                //no hace nada
            } else {
                String[] posIf = ejecutable.get(i).getOperacion().split(" ");
                if(posIf[0].equals("IF")){
                    codigo += ".IF("+ejecutable.get(i).getDato1()+" "+posIf[1]+" "+ejecutable.get(i).getDato2()+")\n"
                            + "jmp "+ejecutable.get(i).getVar()+"\n"
                            + ".ENDIF\n";
                }
            }
        }
        return codigo;
    }
    
    public String quitarParentesis(String metodo){
        String aDevolver = "";
        for (int i = 0; i < metodo.length()-3; i++) {
            aDevolver += metodo.charAt(i);
        }
        return aDevolver;
    }

    //metodo que verifica si la variable es un valor de la pila o stack
    public boolean esArreglo(String palabra) {
        boolean esArreglo = false;
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == '[') {
                for (int j = i; j < palabra.length(); j++) {
                    if (palabra.charAt(j) == 't' && palabra.charAt(j+1) != ')') {
                        varArreglo = "";
                        for (int k = j; k < palabra.length(); k++) {
                            if (palabra.charAt(k) != ']') {
                                varArreglo += palabra.charAt(k);
                            } else {
                                break;
                            }
                        }
                        break;
                    }

                }
                if (palabra.charAt(0) == 's') {
                    esHeap = false;
                } else {
                    esHeap = true;
                }
                esArreglo = true;
                break;
            }
        }
        return esArreglo;
    }

}
