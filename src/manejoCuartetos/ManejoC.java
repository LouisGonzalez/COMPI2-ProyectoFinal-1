/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoCuartetos;

import Tablas.TablaSimbolos;
import cuartetos.Nodo;
import gramaticaC.SintaxC;
import interfaz.PanelPrincipal;
import java.util.ArrayList;
import manejoExe.ExeC;
import manejoExe.ExeJava;
import objetos.ObjetosC;
import objetosApoyo.NodoBoolean;
import objetosApoyo.NodoOperacion;
import verificaciones.VerifC;

/**
 *
 * @author luisGonzalez
 */
public class ManejoC {

    public String definirEtiqueta2(ObjetosC jv) {
        int suma = jv.getContEt() + 1;
        jv.setContEt(suma);
        String et = "et_" + suma;
        return et;
    }

    public String definirTemporal(ObjetosC c) {
        String t = "t" + c.getContVars();
        c.setContVars(c.getContVars() + 1);
        return t;
    }

    public String etiquetaNegativa(TablaSimbolos tabla, String et) {
        String t = definirTemporal(tabla.getObC());
        tabla.getObC().getCuarpeta().add(new Nodo("asig", "-" + et, null, t, null));
        return t;
    }

    public String obtenerUltimoGoTo(ArrayList<Nodo> jv, int jerarquia) {
        String et = "";
        for (int i = 0; i < jv.size(); i++) {
            if (jv.get(i).getOperacion().equals("GOTO")) {
                if (jv.get(i).getNivel() == jerarquia) {
                    String[] arreglo = jv.get(i).getVar().split("_");
                    if (arreglo[0].equals("et")) {
                        et = jv.get(i).getVar();
                    }
                }
            }
        }
        return et;
    }
    
    public void modificarConstructores(TablaSimbolos tabla){
        for (int i = 0; i < tabla.getObJava().getCuarpeta().size(); i++) {
            if(tabla.getObJava().getCuarpeta().get(i).getOperacion().equals("suma")){
                if(tabla.getObJava().getCuarpeta().get(i).getDato1().equals("h") && tabla.getObJava().getCuarpeta().get(i).getVar().equals("h")){
                    String arreglo[] = tabla.getObJava().getCuarpeta().get(i).getDato2().toString().split("_");
                    if(arreglo.length == 3){
                        if(arreglo[0].equals("VALOR") && arreglo[1].equals("CLASE")){
                            for (int j = 0; j < tabla.getTablaExe().size(); j++) {
                                if(tabla.getTablaExe().get(j).getId().equals(arreglo[2]) && tabla.getTablaExe().get(j).getAmbito().equals("global") && tabla.getTablaExe().get(j).getLenguaje().equals("JV")){
                                    tabla.getObJava().getCuarpeta().get(i).setDato2(tabla.getTablaExe().get(j).getSize());
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    

    /*-------------------------------------- INICIALIZACION PILA - HEAP -----------------------------------------*/
    public void inicializaciones(TablaSimbolos tabla) {
        tabla.getObC().getCuarpeta().add(new Nodo("asig", 0, null, "p", null));
        tabla.getObC().getCuarpeta().add(new Nodo("asig", "0", null, "h", null));
    }

    /*------------------------------------------- MANEJO PILA ---------------------------------------------------*/
    public String buscarPosicionMemoria(TablaSimbolos tabla, String idVar) {
        String posMemoria = "";
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if (tabla.getTablaExe().get(i).getId().equals(idVar)) {
                if (tabla.getTablaExe().get(i).getAmbito().equals("global") && tabla.getTablaExe().get(i).getRol().equals("variable")) {
                    posMemoria = tabla.getTablaExe().get(i).getPosMemoria().toString();
                    break;
                }
            }
        }
        return posMemoria;
    }


    /*------------------------------------------- METODO MAIN --------------------------------------------------*/
    public void crearMain(ObjetosC c) {
        c.getCuarpeta().add(new Nodo("CREACION_METODO", "int", null, "main", null));
    }

    public void finMain(ObjetosC c) {
        c.getCuarpeta().add(new Nodo("RETURN", null, null, null, null));
        c.getCuarpeta().add(new Nodo("FIN_METODO", null, null, "main", null));
    }

    /*---------------------------------------- MANEJO CLASES ------------------------------------------------*/
    public void invocacionParametros(ObjetosC c, String id) {
        c.getCuarpeta().add(new Nodo("PARAM", null, null, id, null));
    }

    public String nuevaPosicionPila(TablaSimbolos tabla) {
        int suma = 0;
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if (tabla.getTablaExe().get(i).getAmbito().equals("global") && tabla.getTablaExe().get(i).getRol().equals("variable")) {
                suma = suma + 1;
            }
        }
        tabla.getObC().getCuarpeta().add(new Nodo("suma", "p", Integer.toString(suma), "p", null));
        return Integer.toString(suma);
    }

    public void agregarMetodoVoid(TablaSimbolos tabla, ArrayList<NodoBoolean> listParametros) {
        String parametros = "";
        if (listParametros != null) {
            if (!listParametros.isEmpty()) {
                for (int i = 0; i < listParametros.size(); i++) {
                    if (i == 0) {
                        parametros = listParametros.get(i).getTipo();
                    } else {
                        parametros += "_" + listParametros.get(i).getTipo();
                    }
                }
            }
        }

    }

    public void agregarConstructor(TablaSimbolos tabla, String idClase, String id, int totalParam, ArrayList<NodoBoolean> listParametros) {
        String parametros = "";
        if (listParametros != null) {
            if (!listParametros.isEmpty()) {
                for (int i = 0; i < listParametros.size(); i++) {
                    if (i == 0) {
                        parametros = listParametros.get(i).getTipo();
                    } else {
                        parametros += "_" + listParametros.get(i).getTipo();
                    }
                }
            }
        }
        Integer nodoConstructor = buscarConstructorIndicado(tabla, parametros, idClase);
        ExeC exe = new ExeC();
        if (nodoConstructor != null) {
            String constructor = tabla.getTablaExe().get(nodoConstructor).getId();
            //asignacion de los parametros para el constructor
            pasoDeParametros(tabla, constructor, listParametros, exe, "JV");
            String metodoLlamar = constructor + "();";
            //cambio de posicion al puntero del stack
            int posVar = exe.determinarPosVar(tabla);
            tabla.getObC().getCuarpeta().add(new Nodo("suma", "p", Integer.toString(posVar), "p", null));
            tabla.getObC().getCuarpeta().add(new Nodo("CALL", "JV_"+metodoLlamar, null, null, null));
            tabla.getObC().getCuarpeta().add(new Nodo("resta", "p", Integer.toString(posVar), "p", null));
            //asignacion heap 
            Integer nodoReturn = buscarReturnMetodos(tabla, "this", constructor);
            if (nodoReturn != null) {
                //obtener casilla de return del constructor
                String t = definirTemporal(tabla.getObC());
                tabla.getObC().getCuarpeta().add(new Nodo("suma", "p", Integer.toString(posVar), t, null));
                String t2 = definirTemporal(tabla.getObC());
                tabla.getObC().getCuarpeta().add(new Nodo("suma", t, tabla.getTablaExe().get(nodoReturn).getPosMemoria().toString(), t2, null));
                String t3 = definirTemporal(tabla.getObC());
                tabla.getObC().getCuarpeta().add(new Nodo("asig", "stack[(int)" + t2 + "]", null, t3, null));
                //obtener casilla del constructor
                String posMemoria = buscarPosicionMemoria(tabla, id);
                String t4 = definirTemporal(tabla.getObC());
                tabla.getObC().getCuarpeta().add(new Nodo("suma", "p", posMemoria, t4, null));
                tabla.getObC().getCuarpeta().add(new Nodo("asig", t3, null, "stack[(int)" + t4 + "]", null));
            }
        } 
    }

    public Integer buscarReturnMetodos(TablaSimbolos tabla, String id, String ambito) {
        Integer nodoReturn = null;
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if (tabla.getTablaExe().get(i).getId().equals(id) && tabla.getTablaExe().get(i).getAmbito().equals(ambito)) {
                nodoReturn = i;
                break;
            }
        }
        return nodoReturn;
    }

    //CON EL PASO DE PARAMETROS HECHO FALTA VER ERROR QUE SI METO UNA VARIABLE QUIE NO EXISTE TRUENA EN C, TERMINAR INVOCACION DE METODOS EN C, USO DE HEAP TAMBIEN Y YA ESTA CREO
    public void pasoDeParametros(TablaSimbolos tabla, String constructor, ArrayList<NodoBoolean> etiquetas, ExeC exe, String lenguaje) {
        int cont = 0;
        int posVar = exe.determinarPosVar(tabla);
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if (tabla.getTablaExe().get(i).getRol().equals("parametro") && tabla.getTablaExe().get(i).getAmbito().equals(constructor) && tabla.getTablaExe().get(i).getLenguaje().equals(lenguaje)) {
                if (!tabla.getTablaExe().get(i).isChequeado()) {
                    String t1 = definirTemporal(tabla.getObC());
                    tabla.getObC().getCuarpeta().add(new Nodo("suma", "p", posVar, t1, null));
                    String t2 = definirTemporal(tabla.getObC());
                    tabla.getObC().getCuarpeta().add(new Nodo("suma", t1, tabla.getTablaExe().get(i).getPosMemoria().toString(), t2, null));
                    tabla.getObC().getCuarpeta().add(new Nodo("asig", etiquetas.get(cont).getId(), null, "stack[(int)" + t2 + "]", null));
                    tabla.getTablaExe().get(i).setChequeado(true);
                    cont++;
                }
            }
        }
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            tabla.getTablaExe().get(i).setChequeado(false);
        }
    }
    
    public void asignacionValThis(TablaSimbolos tabla, String ambito, String objetoClase, ExeC exe){
        int totalGlobales = exe.determinarPosVar(tabla);
        String t = definirTemporal(tabla.getObC());
        String posMemoria = buscarPosicionMemoria(tabla, objetoClase);
        tabla.getObC().getCuarpeta().add(new Nodo("suma", "p", posMemoria, t, null));
        String t2 = definirTemporal(tabla.getObC());
        tabla.getObC().getCuarpeta().add(new Nodo("asig","stack[(int)"+t+"]", null, t2, null));
        
        String t3 = definirTemporal(tabla.getObC());
        tabla.getObC().getCuarpeta().add(new Nodo("suma", "p", totalGlobales, t3, null));
        String t4 = definirTemporal(tabla.getObC());
        tabla.getObC().getCuarpeta().add(new Nodo("suma", t3, "0", t4, null));
        tabla.getObC().getCuarpeta().add(new Nodo("asig", t2, null, "stack[(int)"+t4+"]", null));
    }

    public Integer buscarConstructorIndicado(TablaSimbolos tabla, String parametros, String idClase) {
        VerifC verif = new VerifC();
        String[] arregloParam = parametros.split("_");
        String id = "";
        if (!parametros.equals("")) {
            id = idClase + "_" + idClase + "_" + parametros;
        } else {
            id = idClase + "_" + idClase;
        }
        boolean todoCorrecto = true;
        Integer iterador = null;
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if (tabla.getTablaExe().get(i).getId().equals(id) && tabla.getTablaExe().get(i).getAmbito().equals(idClase) && tabla.getTablaExe().get(i).getRol().equals("constructor")) {
                if (!tabla.getTablaExe().get(i).getListParametros().equals("")) {
                    String[] arregloParam2 = tabla.getTablaExe().get(i).getListParametros().split("_");
                    if (arregloParam2.length == arregloParam.length) {
                        for (int j = 0; j < arregloParam.length; j++) {
                            if (!arregloParam[j].equals(arregloParam2[j])) {
                                if (!verif.verificarPadre(tabla.getObC(), arregloParam[j], arregloParam2[j])) {
                                    todoCorrecto = false;
                                    break;
                                }
                            }

                        }
                        if (todoCorrecto) {
                            iterador = i;
                            break;
                        }
                    }
                } else {
                    if(parametros.equals("")){
                        iterador = i;
                        break;
                    } 
                }
            }
        }
        return iterador;
    }

    /*------------------------------------------ METODOS ----------------------------------------------------*/

    public void crearMetodo(TablaSimbolos tabla, String idMetodo, String idClase, String lenguaje, ArrayList<NodoBoolean> etiquetas, int linea, String objetoClase) {
        VerifC verif = new VerifC();
        ExeC exe = new ExeC();
        int posMemoria = exe.determinarPosVar(tabla);
        String parametros = "";
        for (int i = 0; i < etiquetas.size(); i++) {
            if (i == 0) {
                parametros = etiquetas.get(i).getTipo();
            } else {
                parametros += "_" + etiquetas.get(i).getTipo();
            }
        }
        if (lenguaje.equals("VB")) {
            String[] arregloParam = parametros.split("_");
            String id = "";
            if (!parametros.equals("")) {
                id = idMetodo + "_" + parametros;
            } else {
                id = idMetodo;
            }
            String varTotal = encontrarIdMetodo(tabla, idMetodo, "", "VB");
            if (verificarParametrosCorrectos(tabla, varTotal, lenguaje, arregloParam, verif, linea)) {
                pasoDeParametros(tabla, varTotal, etiquetas, exe, lenguaje);
                tabla.getObC().getCuarpeta().add(new Nodo("suma", "p", posMemoria, "p", null));
                tabla.getObC().getCuarpeta().add(new Nodo("CALL", "VB_"+varTotal + "();", null, null, null));
                tabla.getObC().getCuarpeta().add(new Nodo("resta", "p", posMemoria, "p", null));
            }
        } else if (lenguaje.equals("JV")) {
            if (!idClase.equals("")) {
                String[] arregloParam = parametros.split("_");
                String id = "";
                if (!parametros.equals("")) {
                    id = idClase + "_" + idMetodo + "_" + parametros;
                } else {
                    id = idClase + "_" + idMetodo;
                }
                String varTotal = encontrarIdMetodo(tabla, idMetodo, idClase, "JV");
                if (verificarParametrosCorrectos(tabla, varTotal, lenguaje, arregloParam, verif, linea)) {
                    pasoDeParametros(tabla, varTotal, etiquetas, exe, lenguaje);
                    asignacionValThis(tabla, varTotal, objetoClase, exe);
                    tabla.getObC().getCuarpeta().add(new Nodo("suma", "p", posMemoria, "p", null));
                    tabla.getObC().getCuarpeta().add(new Nodo("CALL", "JV_"+varTotal + "();", null, null, null));
                    tabla.getObC().getCuarpeta().add(new Nodo("resta", "p", posMemoria, "p", null));
                }
            } 
        } else if (lenguaje.equals("PY")) {
            pasoDeParametros(tabla, idMetodo, etiquetas, exe, lenguaje);
            tabla.getObC().getCuarpeta().add(new Nodo("suma", "p", posMemoria, "p", null));
            tabla.getObC().getCuarpeta().add(new Nodo("CALL", "PY_"+idMetodo + "();", null, null, null));
            tabla.getObC().getCuarpeta().add(new Nodo("resta", "p", posMemoria, "p", null));
        }
    }

    public String encontrarIdMetodo(TablaSimbolos tabla, String idMetodo, String idClase, String lenguaje) {
        String id = "";
        if (lenguaje.equals("VB")) {
            id = idMetodo;
        } else if (lenguaje.equals("JV")) {
            id = idClase + "_" + idMetodo;
        }
        String aDevolver = "";
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if (tabla.getTablaExe().get(i).getRol().equals("metodo") && tabla.getTablaExe().get(i).getLenguaje().equals(lenguaje)) {
                if (lenguaje.equals("VB")) {
                    String[] arreglo = tabla.getTablaExe().get(i).getId().split("_");
                    if (arreglo[0].equals(id)) {
                        aDevolver = tabla.getTablaExe().get(i).getId();
                        break;
                    }
                } else if (lenguaje.equals("JV")) {
                    String[] arreglo = tabla.getTablaExe().get(i).getId().split("_");
                    String id2 = arreglo[0] + "_" + arreglo[1];
                    if (id.equals(id2)) {
                        aDevolver = tabla.getTablaExe().get(i).getId();
                        break;
                    }
                }
            }
        }
        return aDevolver;
    }

    public boolean verificarParametrosCorrectos(TablaSimbolos tabla, String id, String lenguaje, String[] arregloParam, VerifC verif, int linea) {
        boolean todoCorrecto = true;
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if (tabla.getTablaExe().get(i).getId().equals(id) && tabla.getTablaExe().get(i).getRol().equals("metodo") && tabla.getTablaExe().get(i).getLenguaje().equals(lenguaje)) {
                if (!tabla.getTablaExe().get(i).getListParametros().equals("")) {
                    String[] arregloParam2 = tabla.getTablaExe().get(i).getListParametros().split("_");
                    if (arregloParam2.length == arregloParam.length) {
                        for (int j = 0; j < arregloParam.length; j++) {
                            if (!arregloParam[j].equals(arregloParam2[j])) {
                                System.out.println(arregloParam[j] + " ---- " + arregloParam2[j]);
                                if (!verif.verificarPadre(tabla.getObC(), arregloParam[j], arregloParam2[j])) {
                                    todoCorrecto = false;
                                    PanelPrincipal.errores += "Fila: " + linea + " Tipo de error: SEMANTICO - Causa: Parametros equivocados en metodo: " + id + "\n";
                                    break;
                                }
                            }

                        }
                        if (todoCorrecto) {
                            break;
                        }
                    } else {
                        todoCorrecto = false;
                    }
                } 
            }
        }
        return todoCorrecto;
    }

    /*------------------------------------- CREACION VARIABLES ------------------------------------------------*/
    public void crearVariable(ObjetosC c, String id, String tipo) {
        //    c.getCuarpeta().add(new Nodo("CREACION_VAR", tipo, null, id, null));

    }

    public void crearConstante(TablaSimbolos tabla, String id, String valEt) {
        String t = definirTemporal(tabla.getObC());
        String posMemoria = buscarPosicionMemoria(tabla, id);
        tabla.getObC().getCuarpeta().add(new Nodo("suma", "p", posMemoria, t, null));
        tabla.getObC().getCuarpeta().add(new Nodo("asig", valEt, null, "stack[(int)" + t + "]", null));
    }

    public void crearVariableConValor(TablaSimbolos tabla, String id, String tipo, NodoOperacion valor) {
        if (valor != null) {
            String t = definirTemporal(tabla.getObC());
            String posMemoria = buscarPosicionMemoria(tabla, id);
            tabla.getObC().getCuarpeta().add(new Nodo("suma", "p", posMemoria, t, null));
            tabla.getObC().getCuarpeta().add(new Nodo("asig", valor.getId(), null, "stack[(int)" + t + "]", null));
        }
    }

    public void asignarValor(TablaSimbolos tabla, String id, String valor) {
        String t = definirTemporal(tabla.getObC());
        String posMemoria = buscarPosicionMemoria(tabla, id);
        tabla.getObC().getCuarpeta().add(new Nodo("suma", "p", posMemoria, t, null));
        tabla.getObC().getCuarpeta().add(new Nodo("asig", valor, null, "stack[(int)" + t + "]", null));
    }

    /*-------------------------------------- MANEJO OPERACIONES -----------------------------------------------*/
    public String agregarOperacion(ObjetosC c, String ladoA, String ladoB, String tipo) {
        String var = "t" + c.getContVars();
        c.setContVars(c.getContVars() + 1);
        c.getCuarpeta().add(new Nodo(tipo, ladoA, ladoB, var, null));
        return var;
    }

    public String etiquetaId(TablaSimbolos tabla, String idVar) {
        String t = definirTemporal(tabla.getObC());
        String posMemoria = buscarPosicionMemoria(tabla, idVar);
        tabla.getObC().getCuarpeta().add(new Nodo("suma", "p", posMemoria, t, null));
        String t2 = definirTemporal(tabla.getObC());
        tabla.getObC().getCuarpeta().add(new Nodo("asig", "stack[(int)" + t + "]", null, t2, null));
        return t2;
    }

    public String etiquetaArreglo(TablaSimbolos tabla, String et, String idArreglo) {
        String t = definirTemporal(tabla.getObC());
        String posMemoria = buscarPosicionMemoria(tabla, idArreglo);
        tabla.getObC().getCuarpeta().add(new Nodo("suma", et, posMemoria, t, null));
        String t2 = definirTemporal(tabla.getObC());
        tabla.getObC().getCuarpeta().add(new Nodo("suma", "p", t, t2, null));
        String t3 = definirTemporal(tabla.getObC());
        tabla.getObC().getCuarpeta().add(new Nodo("asig", "stack[(int)" + t2 + "]", null, t3, null));
        return t3;
    }

    public String operacionMetodo(TablaSimbolos tabla, String idMetodo, String idClase, String lenguaje, ArrayList<NodoBoolean> etiquetas, int linea, String objetoClase) {
        //asignacion de parametros
        ExeC exe = new ExeC();
        crearMetodo(tabla, idMetodo, idClase, lenguaje, etiquetas, linea, objetoClase);
        String idTotal = "";
        if (lenguaje.equals("PY")) {
            idTotal = idMetodo;
        } else {
            idTotal = encontrarIdMetodo(tabla, idMetodo, idClase, lenguaje);
        }
        //obtener valor de return
        System.out.println(idTotal);
        Integer posReturn = buscarReturnMetodos(tabla, "return", idTotal);
        int posMemoria = exe.determinarPosVar(tabla);
        if (posReturn != null) {
            String t = definirTemporal(tabla.getObC());
            tabla.getObC().getCuarpeta().add(new Nodo("suma", "p", posMemoria, t, null));
            String t2 = definirTemporal(tabla.getObC());
            tabla.getObC().getCuarpeta().add(new Nodo("suma", t, tabla.getTablaExe().get(posReturn).getPosMemoria(), t2, null));
            String t3 = definirTemporal(tabla.getObC());
            tabla.getObC().getCuarpeta().add(new Nodo("asig", "stack[(int)" + t2 + "]", null, t3, null));
            return t3;
        } else {
            System.out.println("ENTRO AQUI POR ALGUNA RAZON");
            return "";
        }
    }

    public String operacionMetodo2(ObjetosC c, String idMetodo, int totalParam) {
        String var = "t" + c.getContVars();
        c.setContVars(c.getContVars() + 1);
        c.getCuarpeta().add(new Nodo("CALL", idMetodo, Integer.toString(totalParam), var, null));
        String var2 = "t" + c.getContVars();
        c.setContVars(c.getContVars() + 1);
        c.getCuarpeta().add(new Nodo("asig", "-" + var, null, var, null));
        return var2;
    }

    /*----------------------------------------- MANEJO BOOLEANOS ----------------------------------------------*/
    public NodoBoolean concatenarOperacion(ObjetosC c, NodoBoolean ladoA, NodoBoolean ladoB, String tipoOp) {
        VerifC verif = new VerifC();
        String var = "t" + c.getContVars();
        c.setContVars(c.getContVars() + 1);
        if (!ladoA.getTipo().equals("") && !ladoB.getTipo().equals("")) {
            String tip = verif.verifOpCondicional(c, ladoA.getTipo(), ladoB.getTipo());
            c.getCuarpeta().add(new Nodo(tipoOp, ladoA.getId(), ladoB.getId(), var, null));
            return new NodoBoolean(tip, var);
        } else {
            c.getCuarpeta().add(new Nodo(tipoOp, ladoA.getId(), ladoB.getId(), var, null));
            return new NodoBoolean("", var);
        }
    }

    public NodoBoolean devolverEtiquetaId(TablaSimbolos tabla, String idVar, String tipo, boolean negativo) {
        String t = definirTemporal(tabla.getObC());
        String posMemoria = buscarPosicionMemoria(tabla, idVar);
        tabla.getObC().getCuarpeta().add(new Nodo("suma", "p", posMemoria, t, null));
        String t2 = definirTemporal(tabla.getObC());
        tabla.getObC().getCuarpeta().add(new Nodo("asig", "stack[(int)" + t + "]", null, t2, null));
        if (negativo) {
            t2 = "-" + t2;
        }
        return new NodoBoolean(tipo, t2);
    }

    public ArrayList<Nodo> agregarBooleans(ObjetosC c, ArrayList<ArrayList<Nodo>> pilaFalsas, NodoBoolean ladoA, NodoBoolean ladoB, String op, int jerarquia) {
        VerifC verif = new VerifC();
        if (!ladoA.getTipo().equals("") && !ladoB.getTipo().equals("")) {
            verif.verifOpCondicional(c, ladoA.getTipo(), ladoB.getTipo());
        }
        ArrayList<Nodo> list = new ArrayList<>();
        String et = definirEtiqueta2(c);
        list.add(new Nodo("IF " + op, ladoA.getId(), ladoB.getId(), et, jerarquia));
        int sum = c.getContEt() + 1;
        c.setContEt(sum);
        String et2 = "et_" + sum;
        SintaxC.aux2 = et2;
        list.add(new Nodo("GOTO", null, null, et2, jerarquia));
        pilaFalsas.get(pilaFalsas.size() - 1).add(new Nodo("ETIQUETA", et2, null, null, jerarquia));
        list.add(new Nodo("ETIQUETA", et, null, null, jerarquia));
        return list;
    }

    public ArrayList<Nodo> agregarVerdadero(ObjetosC c, ArrayList<ArrayList<Nodo>> pilaFalsas, int jerarquia) {
        ArrayList<Nodo> list = new ArrayList<>();
        String et = definirEtiqueta2(c);
        list.add(new Nodo("IF ==", "1", "1", et, jerarquia));
        int sum = c.getContEt() + 1;
        c.setContEt(sum);
        String et2 = "et_" + sum;
        SintaxC.aux2 = et2;
        list.add(new Nodo("GOTO", null, null, et2, jerarquia));
        pilaFalsas.get(pilaFalsas.size() - 1).add(new Nodo("ETIQUETA", et2, null, null, jerarquia));
        list.add(new Nodo("ETIQUETA", et, null, null, jerarquia));
        return list;
    }

    public ArrayList<Nodo> agregarFalso(ObjetosC c, ArrayList<ArrayList<Nodo>> pilaFalsas, int jerarquia) {
        ArrayList<Nodo> list = new ArrayList<>();
        String et = definirEtiqueta2(c);
        list.add(new Nodo("IF ==", "1", "2", et, jerarquia));
        int sum = c.getContEt() + 1;
        c.setContEt(sum);
        String et2 = "et_" + sum;
        SintaxC.aux2 = et2;
        list.add(new Nodo("GOTO", null, null, et2, jerarquia));
        pilaFalsas.get(pilaFalsas.size() - 1).add(new Nodo("ETIQUETA", et2, null, null, jerarquia));
        list.add(new Nodo("ETIQUETA", et, null, null, jerarquia));
        return list;
    }

    /*------------------------------------------- NOT ----------------------------------------------------*/
    public ArrayList<Nodo> cambiarGotos(ArrayList<Nodo> booleano) {
        String goto1 = booleano.get(0).getVar();
        String goto2 = booleano.get(1).getVar();
        booleano.get(0).setVar(goto2);
        booleano.get(1).setVar(goto1);
        return booleano;
    }

    /*------------------------------------------- AND ----------------------------------------------------*/
    public ArrayList<Nodo> manejoAnd(ArrayList<Nodo> ladoA, ArrayList<Nodo> ladoB) {
        for (int i = 0; i < ladoB.size(); i++) {
            ladoA.add(ladoB.get(i));
        }
        return ladoA;
    }

    /*------------------------------------------ OR --------------------------------------------------------*/
    public void manejoOr(ObjetosC c, ArrayList<Boolean> usoPila, ArrayList<ArrayList<Nodo>> pilaCuarpeta, ArrayList<Nodo> ladoA, ArrayList<Nodo> ladoB, int jerarquia) {
        if (SintaxC.inst) {
            if (ladoA == null) {
                pilaCuarpeta.get(pilaCuarpeta.size() - 1).add(new Nodo("ETIQUETA", SintaxC.aux3, null, null, jerarquia));
                SintaxC.aux3 = "";
            }
            ladoB.add(new Nodo("GOTO", null, null, SintaxC.etInst, jerarquia));
            for (int i = 0; i < ladoB.size(); i++) {
                pilaCuarpeta.get(pilaCuarpeta.size() - 1).add(ladoB.get(i));
            }
        } else {
            String ultimoGoto = obtenerUltimoGoTo(ladoA, jerarquia);
            SintaxC.inst = true;
            SintaxC.etInst = ladoA.get(ladoA.size() - 1).getDato1().toString();
            for (int i = 0; i < ladoA.size(); i++) {
                c.getCuarpeta().add(ladoA.get(i));
            }
            ladoB.add(new Nodo("GOTO", null, null, SintaxC.etInst, jerarquia));
            pilaCuarpeta.add(new ArrayList<>());
            usoPila.set(usoPila.size() - 1, true);
            pilaCuarpeta.get(pilaCuarpeta.size() - 1).add(new Nodo("ETIQUETA", ultimoGoto, null, null, jerarquia));
            for (int i = 0; i < ladoB.size(); i++) {
                pilaCuarpeta.get(pilaCuarpeta.size() - 1).add(ladoB.get(i));
            }
        }
    }

    /*------------------------------------ IF - ELSEIF - ELSE ------------------------------------------------ */
    public void primerChequeoIf(ObjetosC c, ArrayList<Nodo> booleano) {
        if (!SintaxC.inst) {
            for (int i = 0; i < booleano.size(); i++) {
                c.getCuarpeta().add(booleano.get(i));
            }
        }
        SintaxC.inst = false;
        SintaxC.etInst = "";
    }

    public void segundoChequeoIf(ObjetosC c, ArrayList<Boolean> usoPila, ArrayList<ArrayList<Nodo>> pilaCuarpeta, ArrayList<ArrayList<Nodo>> pilaFalsas, int jerarquia) {
        ManejoCondiciones manejo = new ManejoCondiciones();
        if (!pilaCuarpeta.isEmpty()) {
            if (usoPila.get(usoPila.size() - 1)) {
                manejo.eliminarEtiquetasC(c, pilaCuarpeta.get(pilaCuarpeta.size() - 1), pilaFalsas.get(pilaFalsas.size() - 1));
                for (int i = 0; i < pilaFalsas.get(pilaFalsas.size() - 1).size(); i++) {
                    pilaCuarpeta.get(pilaCuarpeta.size() - 1).add(pilaFalsas.get(pilaFalsas.size() - 1).get(i));
                }
                for (int i = 0; i < pilaCuarpeta.get(pilaCuarpeta.size() - 1).size(); i++) {
                    c.getCuarpeta().add(pilaCuarpeta.get(pilaCuarpeta.size() - 1).get(i));
                }
                pilaCuarpeta.remove(pilaCuarpeta.size() - 1);
            } else {
                manejo.eliminarEtiquetasC(c, null, pilaFalsas.get(pilaFalsas.size() - 1));
                for (int i = 0; i < pilaFalsas.get(pilaFalsas.size() - 1).size(); i++) {
                    c.getCuarpeta().add(pilaFalsas.get(pilaFalsas.size() - 1).get(i));
                }
            }
            usoPila.remove(usoPila.size() - 1);
        } else {
            manejo.eliminarEtiquetasC(c, null, pilaFalsas.get(pilaFalsas.size() - 1));
            for (int i = 0; i < pilaFalsas.get(pilaFalsas.size() - 1).size(); i++) {
                c.getCuarpeta().add(pilaFalsas.get(pilaFalsas.size() - 1).get(i));
            }
        }
        pilaFalsas.remove(pilaFalsas.size() - 1);
    }

    /*-------------------------------------------- WHILE -----------------------------------------------------*/
   
    public void agregarPreludioWhile(TablaSimbolos tabla, int jerarquia){
        String etWhile = "etWhile_"+tabla.getObC().getContWhile();
        tabla.getObC().setContWhile(tabla.getObC().getContWhile()+1);
        tabla.getObC().getCuarpeta().add(new Nodo("ETIQUETA", etWhile, null, null, jerarquia));
    }
    
    public void agregarWhile(ObjetosC c, ArrayList<Nodo> booleano, int jerarquia) {
        primerChequeoIf(c, booleano);
    }

    public void retornoWhile(ObjetosC c, ArrayList<Boolean> usoPila, ArrayList<ArrayList<Nodo>> pilaCuarpeta, ArrayList<ArrayList<Nodo>> pilaFalsas, int jerarquia) {
        ManejoCondiciones manejo = new ManejoCondiciones();
        String etWhile = buscarUltimoWhile(c, jerarquia);
        c.getCuarpeta().add(new Nodo("GOTO", null, null, etWhile, jerarquia));
        segundoChequeoIf(c, usoPila, pilaCuarpeta, pilaFalsas, jerarquia);
        manejo.agregarEtiquetaFinC(c, jerarquia);
    }

    public String buscarUltimoWhile(ObjetosC vb, int jerarquia) {
        String etWhile = "";
        for (int i = 0; i < vb.getCuarpeta().size(); i++) {
            if (vb.getCuarpeta().get(i).getOperacion().equals("ETIQUETA")) {
                String[] arreglo = vb.getCuarpeta().get(i).getDato1().toString().split("_");
                if (arreglo[0].equals("etWhile")) {
                    if (vb.getCuarpeta().get(i).getNivel() == jerarquia) {
                        etWhile = vb.getCuarpeta().get(i).getDato1().toString();
                    }
                }
            }
        }
        return etWhile;
    }

    public String agregarEtiquetaFinWhile(ObjetosC c, int jerarquia) {
        String etWhile = "";
        for (int i = 0; i < c.getCuarpeta().size(); i++) {
            if (c.getCuarpeta().get(i).getOperacion().equals("GOTO")) {
                if (c.getCuarpeta().get(i).getNivel() == jerarquia) {
                    etWhile = c.getCuarpeta().get(i).getVar();
                }
            }
        }
        return etWhile;
    }

    /*------------------------------------------- DO WHILE ----------------------------------------------------*/
    public void agregarDoWhile(ObjetosC c, int jerarquia) {
        String etWhile = "etWhile_" + c.getContWhile();
        c.getCuarpeta().add(new Nodo("ETIQUETA", etWhile, null, null, jerarquia));
        c.setContWhile(c.getContWhile() + 1);
    }

    public void agregarCondicionWhile(ObjetosC c, ArrayList<Boolean> usoPila, ArrayList<Nodo> booleano, ArrayList<ArrayList<Nodo>> pilaCuarpeta, ArrayList<ArrayList<Nodo>> pilaFalsas, int jerarquia) {
        ManejoCondiciones manejo = new ManejoCondiciones();
        String etWhile = buscarUltimoWhile(c, jerarquia);
        primerChequeoIf(c, booleano);
        c.getCuarpeta().add(new Nodo("GOTO", etWhile, null, null, jerarquia));
        segundoChequeoIf(c, usoPila, pilaCuarpeta, pilaFalsas, jerarquia);
        manejo.agregarEtiquetaFinC(c, jerarquia);
    }

    /*-------------------------------------------- FOR --------------------------------------------------------*/
    
    public void agregarPreludioFor(TablaSimbolos tabla, String id1, String valId1, int jerarquia){
        String posMemoria = buscarPosicionMemoria(tabla, id1);
        String t = definirTemporal(tabla.getObC());
        tabla.getObC().getCuarpeta().add(new Nodo("suma", "p", posMemoria, t, null));
        tabla.getObC().getCuarpeta().add(new Nodo("asig", valId1, null, "stack[(int)" + t + "]", jerarquia));
        String etFor = "etFor_" + tabla.getObC().getContFor();
        tabla.getObC().setContFor(tabla.getObC().getContFor() + 1);
        tabla.getObC().getCuarpeta().add(new Nodo("ETIQUETA", etFor, null, null, jerarquia));
        
    }
    
    public void agregarFor(TablaSimbolos tabla, String id1, String valId1, ArrayList<Nodo> booleano, int jerarquia, String tipo) {
        primerChequeoIf(tabla.getObC(), booleano);
    }

    public void retornarFor(TablaSimbolos tabla, ArrayList<Boolean> usoPila, String id, String varAumento, String varAumento2, ArrayList<ArrayList<Nodo>> pilaCuarpeta, ArrayList<ArrayList<Nodo>> pilaFalsas, int jerarquia) {
        ManejoCondiciones manejo = new ManejoCondiciones();
        String etFor = buscarUltimoFor(tabla.getObC(), jerarquia);
        String t = definirTemporal(tabla.getObC());
        String posMemoria = buscarPosicionMemoria(tabla, varAumento);
        tabla.getObC().getCuarpeta().add(new Nodo("suma", "p", posMemoria, t, null));
        String t2 = definirTemporal(tabla.getObC());
        tabla.getObC().getCuarpeta().add(new Nodo("asig", "stack[(int)" + t + "]", null, t2, null));
        String t3 = definirTemporal(tabla.getObC());
        tabla.getObC().getCuarpeta().add(new Nodo("suma", t2, varAumento2, t3, null));
        String t4 = definirTemporal(tabla.getObC());
        String posMemoria2 = buscarPosicionMemoria(tabla, id);
        tabla.getObC().getCuarpeta().add(new Nodo("suma", "p", posMemoria2, t4, null));
        tabla.getObC().getCuarpeta().add(new Nodo("asig", t3, null, "stack[(int)" + t4 + "]", null));
        tabla.getObC().getCuarpeta().add(new Nodo("GOTO", null, null, etFor, jerarquia));
        segundoChequeoIf(tabla.getObC(), usoPila, pilaCuarpeta, pilaFalsas, jerarquia);
        manejo.agregarEtiquetaFinC(tabla.getObC(), jerarquia);
    }

    public String buscarUltimoFor(ObjetosC jv, int jerarquia) {
        String etFor = "";
        for (int i = 0; i < jv.getCuarpeta().size(); i++) {
            if (jv.getCuarpeta().get(i).getOperacion().equals("ETIQUETA")) {
                String[] arreglo = jv.getCuarpeta().get(i).getDato1().toString().split("_");
                if (arreglo[0].equals("etFor")) {
                    if (jv.getCuarpeta().get(i).getNivel() == jerarquia) {
                        etFor = jv.getCuarpeta().get(i).getDato1().toString();
                    }
                }
            }
        }
        return etFor;
    }

    /*------------------------------------------- SWITCH CASE -----------------------------------------------*/
    public void agregarCaseSwitch(ObjetosC c, int jerarquia, String comparacion1, String comparacion2, String tipoOp) {
        String et = definirEtiqueta2(c);
        c.getCuarpeta().add(new Nodo("IF " + tipoOp, comparacion1, comparacion2, et, jerarquia));
        String et2 = definirEtiqueta2(c);
        c.getCuarpeta().add(new Nodo("GOTO", null, null, et2, jerarquia));
        c.getCuarpeta().add(new Nodo("ETIQUETA", et, null, null, jerarquia));
    }

    public void agregarFinCase(ObjetosC c, ArrayList<String> arrayFinales, int jerarquia) {
        c.getCuarpeta().add(new Nodo("GOTO", null, null, arrayFinales.get(arrayFinales.size() - 1), jerarquia));
        String et = obtenerUltimoGoTo(c.getCuarpeta(), jerarquia);
        c.getCuarpeta().add(new Nodo("ETIQUETA", et, null, null, jerarquia));
    }

    /*-------------------------------------------- GETCH -----------------------------------------------------*/
    public void crearGetch(TablaSimbolos tabla, String id, boolean arreglo) {
        String t = definirTemporal(tabla.getObC());
        if(id != null){
            if(arreglo){
                tabla.getObC().getCuarpeta().add(new Nodo("GETCH", null, null, id, null));
            } else {
                String posMemoria = buscarPosicionMemoria(tabla, id);
                tabla.getObC().getCuarpeta().add(new Nodo("suma", "p", posMemoria, t, null));
                tabla.getObC().getCuarpeta().add(new Nodo("GETCH", null, null, "stack[(int)"+t+"]", null));
            }   
        } else {
            tabla.getObC().getCuarpeta().add(new Nodo("GETCH", null, null, null, null));
        }
    }

    /*------------------------------------------- CLRSL -----------------------------------------------------*/
    public void crearClscr(ObjetosC c) {
        c.getCuarpeta().add(new Nodo("CLSCR", null, null, null, null));
    }

    /*------------------------------------------- SCANF ------------------------------------------------------*/
    public void crearScanf(TablaSimbolos tabla, String id, String tipo, boolean arreglo) {
        String t = definirTemporal(tabla.getObC());
        if (tipo.equals("Integer")) {
            tabla.getObC().getCuarpeta().add(new Nodo("SCANF", "\"%f\"", null, t, null));
        } else if (tipo.equals("Float")) {
            tabla.getObC().getCuarpeta().add(new Nodo("SCANF", "\"%f\"", null, t, null));
        } else if (tipo.equals("Char")) {
            tabla.getObC().getCuarpeta().add(new Nodo("SCANF", "\"%f\"", null, t, null));
        }
        if(arreglo){
            tabla.getObC().getCuarpeta().add(new Nodo("asig", t, null, id, null));
        } else {
            String t2 = definirTemporal(tabla.getObC());
            String posMemoria = buscarPosicionMemoria(tabla, id);
            tabla.getObC().getCuarpeta().add(new Nodo("suma", "p", posMemoria, t2, null));
            tabla.getObC().getCuarpeta().add(new Nodo("asig", t, null, "stack[(int)"+t2+"]", null));
        }
    }

    /*------------------------------------------ ARREGLOS ----------------------------------------------------*/
    public int definirSize(TablaSimbolos tabla, ArrayList<String> casillas, String id) {
        int size = 0;
        if (casillas.size() > 1) {
            String et = "";
            for (int i = 0; i < casillas.size() - 1; i++) {
                if (i == 0) {
                    String t = definirTemporal(tabla.getObC());
                    System.out.println(t + " = " + casillas.get(i) + " * " + casillas.get(i + 1));
                    size = Integer.parseInt(casillas.get(i)) * Integer.parseInt(casillas.get(i + 1));
                    et = t;
                } else {
                    String t = definirTemporal(tabla.getObC());
                    System.out.println(t + " = " + et + " * " + casillas.get(i + 1));
                    size = size * Integer.parseInt(casillas.get(i + 1));
                    et = t;
                }
            }
            System.out.println("Tamano del arreglo: " + size);
            //   System.out.println(et);
        } else {
            size = Integer.parseInt(casillas.get(0));
            System.out.println("Tamano del arreglo: " + size);
        }
        return size;
    }

    public String acumularSuma(TablaSimbolos tabla, String idArreglo, int iterador, String valCasilla, String etCarril) {
        ArrayList<String> dimensiones = buscarDimensionesVector(tabla.getObC(), idArreglo);
        if (dimensiones.size() > iterador) {
            String aDevolver = "";
            String aux = "";
            for (int i = iterador; i < dimensiones.size(); i++) {
                if (i == iterador) {
                    String t = definirTemporal(tabla.getObC());
                    aux = t;
                    tabla.getObC().getCuarpeta().add(new Nodo("mult", valCasilla, dimensiones.get(i), t, null));
                } else {
                    String t = definirTemporal(tabla.getObC());
                    tabla.getObC().getCuarpeta().add(new Nodo("mult", aux, dimensiones.get(i), t, null));
                    aux = t;
                }
            }
            aDevolver = aux;
            if (!etCarril.equals("")) {
                String t = definirTemporal(tabla.getObC());
                tabla.getObC().getCuarpeta().add(new Nodo("suma", aux, etCarril, t, null));
                aDevolver = t;
            }
            return aDevolver;
        } else if (dimensiones.size() == iterador) {
            String aDevolver = "";
            if(dimensiones.size() > 1){
                String t = definirTemporal(tabla.getObC());
                tabla.getObC().getCuarpeta().add(new Nodo("suma", valCasilla, 1, t, null));
                aDevolver = t;
                if (!etCarril.equals("")) {
                    String t2 = definirTemporal(tabla.getObC());
                    tabla.getObC().getCuarpeta().add(new Nodo("suma", etCarril, t, t2, null));
                    aDevolver = t2;
                }
            } else {
                    String t2 = definirTemporal(tabla.getObC());
                    tabla.getObC().getCuarpeta().add(new Nodo("asig", valCasilla, null, t2, null));
                    aDevolver = t2;
            }
            return aDevolver;
        } else {
            return "";
        }
    }

    public ArrayList<String> buscarDimensionesVector(ObjetosC c, String idArreglo) {
        ArrayList<String> aDevolver = new ArrayList<>();
        for (int i = 0; i < c.getListArreglos().size(); i++) {
            if (c.getListArreglos().get(i).getId().equals(idArreglo)) {
                aDevolver = c.getListArreglos().get(i).getDimensiones();
                break;
            }
        }
        return aDevolver;
    }

    public String encontrarNodoArreglo(TablaSimbolos tabla, String et, String idArreglo) {
        String posMemoria = buscarPosicionMemoria(tabla, idArreglo);
        String t = definirTemporal(tabla.getObC());
        tabla.getObC().getCuarpeta().add(new Nodo("suma", posMemoria, et, t, null));
        String t2 = definirTemporal(tabla.getObC());
        tabla.getObC().getCuarpeta().add(new Nodo("suma", "p", t, t2, null));
        return "stack[(int) " + t2 + "]";
    }

    public void asignarValorNodo(TablaSimbolos tabla, String posStack, String et) {
        tabla.getObC().getCuarpeta().add(new Nodo("asig", et, null, posStack, null));
    }
    
    /*-------------------------------------------- MENSAJES -------------------------------------------------------*/
    
    public void mostrarMensaje(TablaSimbolos tabla, String id, String mascara){
        tabla.getObC().getCuarpeta().add(new Nodo("PRINT", mascara, null, id, null));
    }
    
    public void mostrarQuiebre(TablaSimbolos tabla){
        tabla.getObC().getCuarpeta().add(new Nodo("PRINT", null, null, "\"\\n\"", null));
    }

}
