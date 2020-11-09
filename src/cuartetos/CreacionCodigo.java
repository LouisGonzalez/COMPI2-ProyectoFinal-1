/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuartetos;

import Tablas.TablaSimbolos;
import java.util.ArrayList;

/**
 *
 * @author luisGonzalez
 */
public class CreacionCodigo {
    
    public String crearCodigo(ArrayList<Nodo> cuarpeta){
        String codigo = "";
        for (int i = 0; i < cuarpeta.size(); i++) {
            if(cuarpeta.get(i).getOperacion().equals("CREACION_METODO")){
                if(!cuarpeta.get(i).getVar().equals("main")) codigo += "void "+cuarpeta.get(i).getVar()+" {\n";
            } else if(cuarpeta.get(i).getOperacion().equals("FIN_METODO")){
                if(i != cuarpeta.size()-1) codigo += "}\n";
            } else if(cuarpeta.get(i).getOperacion().equals("ETIQUETA")){
                codigo += cuarpeta.get(i).getDato1()+":\n";
            } else if(cuarpeta.get(i).getOperacion().equals("GOTO")){
                codigo += "goto "+cuarpeta.get(i).getVar()+":\n";
            } else if(cuarpeta.get(i).getOperacion().equals("CREACION_VAR")){
                if(!cuarpeta.get(i).getDato1().equals("")){
                    if(cuarpeta.get(i).getDato1().equals("Integer")){
                        codigo += "int "+cuarpeta.get(i).getVar()+";\n";
                    } else if(cuarpeta.get(i).getDato1().equals("Char")){
                        codigo += "char "+cuarpeta.get(i).getVar()+";\n";
                    } else if(cuarpeta.get(i).getDato1().equals("Float")) {
                        codigo += "float "+cuarpeta.get(i).getVar()+";\n";
                    } 
                } 
            
            } else if(cuarpeta.get(i).getOperacion().equals("asig")){
                codigo += cuarpeta.get(i).getVar()+" = "+cuarpeta.get(i).getDato1()+";\n";
            } else if(cuarpeta.get(i).getOperacion().equals("PRINT")){
                codigo += "print "+cuarpeta.get(i).getVar()+"\n";
            } else if(cuarpeta.get(i).getOperacion().equals("mult")){
                codigo += cuarpeta.get(i).getVar()+" = "+cuarpeta.get(i).getDato1()+" * "+cuarpeta.get(i).getDato2()+";\n";
            } else if(cuarpeta.get(i).getOperacion().equals("resta")){
                codigo += cuarpeta.get(i).getVar()+" = "+cuarpeta.get(i).getDato1()+" - "+cuarpeta.get(i).getDato2()+";\n";
            } else if(cuarpeta.get(i).getOperacion().equals("div")){
                codigo += cuarpeta.get(i).getVar()+" = "+cuarpeta.get(i).getDato1()+" / "+cuarpeta.get(i).getDato2()+";\n";
            } else if(cuarpeta.get(i).getOperacion().equals("suma")){
                codigo += cuarpeta.get(i).getVar()+" = "+cuarpeta.get(i).getDato1()+" + "+cuarpeta.get(i).getDato2()+";\n";
            } else if(cuarpeta.get(i).getOperacion().equals("modulo")){
                codigo += cuarpeta.get(i).getVar()+" = "+cuarpeta.get(i).getDato1()+" % "+cuarpeta.get(i).getDato2()+";\n";
            } else if(cuarpeta.get(i).getOperacion().equals("SCANF")){
                codigo += "read "+cuarpeta.get(i).getVar()+"\n";
            } else if(cuarpeta.get(i).getOperacion().equals("CALL")){
                   codigo += cuarpeta.get(i).getDato1()+"\n";
            } else if(cuarpeta.get(i).getOperacion().equals("PARAM")){
                codigo += "param "+cuarpeta.get(i).getVar()+"\n";
            } else if(cuarpeta.get(i).getOperacion().equals("CLSCR")){
                codigo += "clscr()\n";
            } else if(cuarpeta.get(i).getOperacion().equals("GETCH")){
                if(cuarpeta.get(i).getVar() != null){
                    codigo += cuarpeta.get(i).getVar()+" = "+"getch()\n";
                } else {
                    codigo += "getch()\n";
                }
            } else {
                String[] posIf = cuarpeta.get(i).getOperacion().split(" ");
                if(posIf[0].equals("IF")){
                    codigo += "if "+cuarpeta.get(i).getDato1()+" "+posIf[1]+" "+cuarpeta.get(i).getDato2()+" goto "+cuarpeta.get(i).getVar()+"\n";
                }
            }
        }
        return codigo;
    }
    
    public void unificarCuarpetas(ArrayList<Nodo> cuarpeta, TablaSimbolos tabla){
        for (int i = 0; i < tabla.getObVb().getCuarpeta().size(); i++) {
            cuarpeta.add(tabla.getObVb().getCuarpeta().get(i));
        }
        
        for (int i = 0; i < tabla.getObJava().getCuarpeta().size(); i++) {
            cuarpeta.add(tabla.getObJava().getCuarpeta().get(i));
        }
        
        for (int i = 0; i < tabla.getObPython().getCuarpeta().size(); i++) {
            cuarpeta.add(tabla.getObPython().getCuarpeta().get(i));
        }
        
        for (int i = 0; i < tabla.getObC().getCuarpeta().size(); i++) {
            cuarpeta.add(tabla.getObC().getCuarpeta().get(i));
        }
    }
    
}
