/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoCuartetos;

import Tablas.TablaSimbolos;
import cuartetos.Nodo;
import gramaticaVB.SintaxVB;
import interfaz.PanelPrincipal;
import java.util.ArrayList;
import manejoExe.ExeVb;
import objetos.ObjetosVB;
import objetos.Variable;
import objetosApoyo.NodoBoolean;
import verificaciones.VerifVB;

/**
 *
 * @author luisGonzalez
 */
public class ManejoVb {

    public String definirTemporal(TablaSimbolos tabla) {
        String t = "t" + tabla.getObVb().getContVars();
        tabla.getObVb().setContVars(tabla.getObVb().getContVars() + 1);
        return t;
    }

    public String definirEtiqueta2(ObjetosVB jv) {
        int suma = jv.getContEt() + 1;
        jv.setContEt(suma);
        String et = "et_" + suma;
        return et;
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
    
    /*---------------------------------------- LLAMADO A METODOS ----------------------------------------------*/
    
    public String devolverEtiquetaMetodo(TablaSimbolos tabla, String idMetodo, ArrayList<NodoBoolean> etiquetas, int linea){
        invocarMetodo(tabla, idMetodo, etiquetas, linea);
        String idTotal = encontrarIdMetodo(tabla, idMetodo);
        String posReturn = buscarPosicionMemoria(tabla, "return", idTotal);
        int posMemoria = determinarSizeAmbito(tabla, idTotal);
        if(!posReturn.equals("")){
            String t = definirTemporal(tabla);
            tabla.getObVb().getCuarpeta().add(new Nodo("suma", "p", posMemoria, t, null));
            String t2 = definirTemporal(tabla);
            tabla.getObVb().getCuarpeta().add(new Nodo("suma", t, posReturn, t2, null));
            String t3 = definirTemporal(tabla);
            tabla.getObVb().getCuarpeta().add(new Nodo("asig", "stack["+t2+"]", null, t3, null));
            return t3;
        } else {
            return "";
        }
    }
    
    public void invocarMetodo(TablaSimbolos tabla, String idMetodo, ArrayList<NodoBoolean> etiquetas, int linea){
        VerifVB verif = new VerifVB();
        ExeVb exe = new ExeVb();
        ManejoC manejoc = new ManejoC();
        String parametros = "";
        for (int i = 0; i < etiquetas.size(); i++) {
            if(i == 0){
                parametros = etiquetas.get(i).getTipo();
            } else {
                parametros += "_"+etiquetas.get(i).getTipo();
            }
        }
        String [] arregloParam = parametros.split("_");
        String varTotal = manejoc.encontrarIdMetodo(tabla, idMetodo, "", "VB");
        if(verificarParametrosCorrectos(tabla, varTotal, arregloParam, verif, linea)){
            pasoParametros(tabla, varTotal, etiquetas, exe);
            int posVar = determinarSizeAmbito(tabla, varTotal);
            tabla.getObVb().getCuarpeta().add(new Nodo("suma", "p", posVar, "p", null));
            tabla.getObVb().getCuarpeta().add(new Nodo("CALL", varTotal+"();", null, null, null));
            tabla.getObVb().getCuarpeta().add(new Nodo("resta", "p", posVar, "p", null));
            
        }
    }
    
    public void pasoParametros(TablaSimbolos tabla, String ambito, ArrayList<NodoBoolean> etiquetas, ExeVb exe){
        int cont = 0;
        int posVar = determinarSizeAmbito(tabla, ambito);
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if(tabla.getTablaExe().get(i).getRol().equals("parametro") && tabla.getTablaExe().get(i).getAmbito().equals(ambito) && tabla.getTablaExe().get(i).getLenguaje().equals("VB")){
                if(!tabla.getTablaExe().get(i).isChequeado()){
                    String t = definirTemporal(tabla);
                    tabla.getObVb().getCuarpeta().add(new Nodo("suma", "p", posVar, t, null));
                    String t2 = definirTemporal(tabla);
                    tabla.getObVb().getCuarpeta().add(new Nodo("suma", t, tabla.getTablaExe().get(i).getPosMemoria(), t2, null));
                    tabla.getObVb().getCuarpeta().add(new Nodo("asig", etiquetas.get(cont).getId(), null, "stack["+t2+"]", null));
                    tabla.getTablaExe().get(i).setChequeado(true);
                    cont++;
                }
            }
        }
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            tabla.getTablaExe().get(i).setChequeado(false);
        }
    }
    
    public boolean verificarParametrosCorrectos(TablaSimbolos tabla, String id, String[] arregloParam, VerifVB verif, int linea){
        boolean todoCorrecto = true;
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if(tabla.getTablaExe().get(i).getRol().equals("metodo") && tabla.getTablaExe().get(i).getId().equals(id) && tabla.getTablaExe().get(i).getLenguaje().equals("VB")){
                if(!tabla.getTablaExe().get(i).getListParametros().equals("")){
                    String[] arregloParam2 = tabla.getTablaExe().get(i).getListParametros().split("_");
                    if(arregloParam.length == arregloParam2.length){
                        for (int j = 0; j < arregloParam.length; j++) {
                            if(!arregloParam[j].equals(arregloParam2[j])){
                                if(!verif.verificarPadre(tabla.getObVb(), arregloParam[j], arregloParam2[j], tabla.getObVb().getTablaTipos())){
                                    todoCorrecto = false;
                                    PanelPrincipal.errores += "Fila: " + linea + " Tipo de error: SEMANTICO - Causa: Parametros equivocados en metodo: " + id + " dentro de archivo VB\n";
                                    break;
                                }
                            }
                        }
                        if(todoCorrecto){
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
    
    public String encontrarIdMetodo(TablaSimbolos tabla, String idMetodo){
        String id = idMetodo;
        String aDevolver = "";
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if(tabla.getTablaExe().get(i).getRol().equals("metodo") && tabla.getTablaExe().get(i).getLenguaje().equals("VB")){
                String[] arreglo = tabla.getTablaExe().get(i).getId().split("_");
                if(arreglo[0].equals(idMetodo)){
                    aDevolver = tabla.getTablaExe().get(i).getId();
                    break;
                }
            }
        }
        return aDevolver;
    }
    
    public int determinarSizeAmbito(TablaSimbolos tabla, String ambito){
        int size = 0;
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if(tabla.getTablaExe().get(i).getId().equals(ambito) && tabla.getTablaExe().get(i).getLenguaje().equals("VB")){
                size = tabla.getTablaExe().get(i).getSize();
                break;
            }
        }
        return size;
    }

    /*----------------------------------------- METODOS ----------------------------------------------------*/
    public void crearMetodo(ObjetosVB vb, String idMetodo, ArrayList<Variable> parametros, String tipo) {
        String nombre;
        String param = parametros(parametros);
        if (parametros.isEmpty()) {
            nombre = "VB_" + idMetodo;
        } else {
            nombre = "VB_" + idMetodo + "_" + param;
        }
        vb.getCuarpeta().add(new Nodo("CREACION_METODO", tipo, null, nombre, null));
        //agregar puntero
        String et = "t" + vb.getContVars();
        vb.setContVars(vb.getContVars() + 1);

    }

    /*  PENDIENTE
    //Agrega los parametros al stack segun su posicion
    public void agregarParametrosStack(TablaSimbolos tabla, ArrayList<Variable> parametros, String idMetodo){
        for (int i = 0; i < parametros.size(); i++) {
            for (int j = 0; j < tabla.getTablaExe().size(); j++) {
                if(parametros.get(i).getId().equals(tabla.getTablaExe().get(j).getId())){
                    if(tabla.getTablaExe().get(j).getAmbito().equals(idMetodo)){
                        //agregar los parametros al stack
                        
                    }
                }
            }
            
        }
    }*/
    public void finMetodo(ObjetosVB vb) {
        vb.getCuarpeta().add(new Nodo("FIN_METODO", null, null, null, null));
    }

    public String parametros(ArrayList<Variable> listVariables) {
        String var = "";
        for (int i = 0; i < listVariables.size(); i++) {
            if (i < listVariables.size() - 1) {
                var += listVariables.get(i).getTipo() + "_";
            } else {
                var += listVariables.get(i).getTipo();
            }
        }
        return var;
    }

    /*------------------------------------- CREACION VARIABLES -----------------------------------------------*/
    public void crearVariable(ObjetosVB vb, String id, String tipo) {
        vb.getCuarpeta().add(new Nodo("CREACION_VAR", tipo, null, id, null));
    }

    /*------------------------------------- ASIGNACION VARIABLES ---------------------------------------------*/
    public String agregarOperacion(TablaSimbolos tabla, String ladoA, String ladoB, String tipo, String idMetodo) {
        String var = "t" + tabla.getObVb().getContVars();
        tabla.getObVb().setContVars(tabla.getObVb().getContVars() + 1);
        tabla.getObVb().getCuarpeta().add(new Nodo(tipo, ladoA, ladoB, var, null));
        return var;
    }

    //metodo que se utiliza cuando una variable esta igualada a tan solo 
    public String operacionIndividual(TablaSimbolos tabla, String idVar, String idMetodo) {
        String aDevolver = "";
        if (!esId(idVar)) {
            aDevolver = idVar;
        } else {
            String t = "t" + tabla.getObVb().getContVars();
            tabla.getObVb().setContVars(tabla.getObVb().getContVars() + 1);
            String valMemoria = buscarPosicionMemoria(tabla, idVar, idMetodo);
            tabla.getObVb().getCuarpeta().add(new Nodo("suma", "p", valMemoria, t, null));
            aDevolver = "t" + tabla.getObVb().getContVars();
            tabla.getObVb().setContVars(tabla.getObVb().getContVars() + 1);
            tabla.getObVb().getCuarpeta().add(new Nodo("asig", "stack[" + t + "]", null, aDevolver, null));
        }
        return aDevolver;
    }
    
    public String etiquetaId(TablaSimbolos tabla, String idVar, String idMetodo){
        String t = definirTemporal(tabla);
        String valMemoria = buscarPosicionMemoria(tabla, idVar, idMetodo);
        tabla.getObVb().getCuarpeta().add(new Nodo("suma", "p", valMemoria, t, null));
        String t2 = definirTemporal(tabla);
        tabla.getObVb().getCuarpeta().add(new Nodo("asig", "stack["+t+"]", null, t2, null));
        return t2;
    }

    //busca dentro de la pila la posicion de una variable
    public String buscarPosicionMemoria(TablaSimbolos tabla, String idVar, String idMetodo) {
        String valor = "";
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if (tabla.getTablaExe().get(i).getId().equals(idVar)) {
                if (tabla.getTablaExe().get(i).getAmbito().equals(idMetodo) && tabla.getTablaExe().get(i).getLenguaje().equals("VB")) {
                    valor = tabla.getTablaExe().get(i).getPosMemoria().toString();
                    break;
                }
            }
        }
        if (valor.equals("")) {
            valor = idVar;
        }
        return valor;
    }

    //verifica si un id dentro de una operacion es un id - numero - char
    public boolean esId(String cadena) {
        String primerItem = Character.toString(cadena.charAt(0));
        if (primerItem.equals("'")) {
            return false;
        } else {
            try {
                Integer.parseInt(cadena);
                return false;
            } catch (NumberFormatException e) {
                try {
                    Double.parseDouble(cadena);
                    return false;
                } catch (NumberFormatException ee) {
                    return true;
                }
            }
        }
    }

    public String agregarOperacionFor(ObjetosVB vb, ArrayList<ArrayList<Nodo>> pilaFor, String ladoA, String ladoB, String tipo) {
        String var = "t" + vb.getContVars();
        vb.setContVars(vb.getContVars() + 1);
        pilaFor.get(pilaFor.size() - 1).add(new Nodo(tipo, ladoA, ladoB, var, null));
        return var;
    }

    public void agregarValorVar(TablaSimbolos tabla, String id, String val, String idMetodo) {
        if (val != null) {
            String t = "t" + tabla.getObVb().getContVars();
            tabla.getObVb().setContVars(tabla.getObVb().getContVars() + 1);
            String valMemoria = buscarPosicionMemoria(tabla, id, idMetodo);
            tabla.getObVb().getCuarpeta().add(new Nodo("suma", "p", valMemoria, t, null));
            tabla.getObVb().getCuarpeta().add(new Nodo("asig", val, null, "stack[" + t + "]", null));
        }
    }

    /*-------------------------------------- MANEJO BOOLEANOS -------------------------------------------------*/
    public NodoBoolean concatenarOperacion(ObjetosVB vb, NodoBoolean ladoA, NodoBoolean ladoB, String tipoOp) {
        VerifVB verif = new VerifVB();
        String var = "t" + vb.getContVars();
        vb.setContVars(vb.getContVars() + 1);
        if (!ladoA.getTipo().equals("") && !ladoB.getTipo().equals("")) {
            String tip = verif.verificarTipoOperacion(vb, ladoA.getTipo(), ladoB.getTipo());
            vb.getCuarpeta().add(new Nodo(tipoOp, ladoA.getId(), ladoB.getId(), var, null));
            return new NodoBoolean(tip, var);
        } else {
            vb.getCuarpeta().add(new Nodo(tipoOp, ladoA.getId(), ladoB.getId(), var, null));
            return new NodoBoolean("", var);
        }
    }

    public NodoBoolean devolverEtiquetaId(TablaSimbolos tabla, String idVar, String idMetodo, String tipo, boolean negativo){
        String t = definirTemporal(tabla);
        String posMemoria = buscarPosicionMemoria(tabla, idVar, idMetodo);
        tabla.getObVb().getCuarpeta().add(new Nodo("suma", "p", posMemoria, t, null));
        String t2 = definirTemporal(tabla);
        tabla.getObVb().getCuarpeta().add(new Nodo("asig", "stack["+t+"]", null, t2, null));
        if(negativo){
            t2 = "-"+t2;
        }
        return new NodoBoolean(tipo, t2);
    }

    public ArrayList<Nodo> agregarBooleans(ObjetosVB vb, ArrayList<ArrayList<Nodo>> pilaFalsas, NodoBoolean lado1, NodoBoolean lado2, String op, int jerarquia) {
        VerifVB verif = new VerifVB();
        if (!lado1.getTipo().equals("") && !lado2.getTipo().equals("")) {
            verif.verificarTipoOperacion(vb, lado1.getTipo(), lado2.getTipo());
        }
        ArrayList<Nodo> list = new ArrayList<>();
        String et = definirEtiqueta2(vb);
        list.add(new Nodo("IF " + op, lado1.getId(), lado2.getId(), et, jerarquia));
        int sum = vb.getContEt() + 1;
        vb.setContEt(sum);
        String et2 = "et_" + sum;
        SintaxVB.aux2 = et2;
        list.add(new Nodo("GOTO", null, null, et2, jerarquia));
        pilaFalsas.get(pilaFalsas.size() - 1).add(new Nodo("ETIQUETA", et2, null, null, jerarquia));
        list.add(new Nodo("ETIQUETA", et, null, null, jerarquia));
        return list;
    }

    /*---------------------------------------------- NOT -----------------------------------------------------*/
    public ArrayList<Nodo> cambiarGotos(ArrayList<Nodo> booleano) {
        String goto1 = booleano.get(0).getVar();
        String goto2 = booleano.get(1).getVar();
        booleano.get(0).setVar(goto2);
        booleano.get(1).setVar(goto1);
        return booleano;
    }

    /*--------------------------------------------- AND -------------------------------------------------------*/
    public ArrayList<Nodo> manejoAnd(ArrayList<Nodo> ladoA, ArrayList<Nodo> ladoB) {
        for (int i = 0; i < ladoB.size(); i++) {
            ladoA.add(ladoB.get(i));
        }
        return ladoA;
    }

    /*--------------------------------------------- OR --------------------------------------------------------*/
    public void manejoOr(ObjetosVB vb, ArrayList<Boolean> usoPila, ArrayList<ArrayList<Nodo>> pilaCuarpeta, ArrayList<Nodo> ladoA, ArrayList<Nodo> ladoB, int jerarquia) {
        if (SintaxVB.inst) {
            if (ladoA == null) {
                pilaCuarpeta.get(pilaCuarpeta.size() - 1).add(new Nodo("ETIQUETA", SintaxVB.aux3, null, null, jerarquia));
                SintaxVB.aux3 = "";
            }
            ladoB.add(new Nodo("GOTO", null, null, SintaxVB.etInst, jerarquia));
            for (int i = 0; i < ladoB.size(); i++) {
                pilaCuarpeta.get(pilaCuarpeta.size() - 1).add(ladoB.get(i));
            }
        } else {
            String ultimoGoto = obtenerUltimoGoTo(ladoA, jerarquia);
            SintaxVB.inst = true;
            SintaxVB.etInst = ladoA.get(ladoA.size() - 1).getDato1().toString();
            for (int i = 0; i < ladoA.size(); i++) {
                vb.getCuarpeta().add(ladoA.get(i));
            }
            ladoB.add(new Nodo("GOTO", null, null, SintaxVB.etInst, jerarquia));
            pilaCuarpeta.add(new ArrayList<>());
            usoPila.set(usoPila.size() - 1, true);
            pilaCuarpeta.get(pilaCuarpeta.size() - 1).add(new Nodo("ETIQUETA", ultimoGoto, null, null, jerarquia));
            for (int i = 0; i < ladoB.size(); i++) {
                pilaCuarpeta.get(pilaCuarpeta.size() - 1).add(ladoB.get(i));
            }
        }
    }

    /*------------------------------------ IF - ELSEIF - ELSE -------------------------------------------------*/
    public void primerChequeoIf(ObjetosVB vb, ArrayList<Nodo> booleano) {
        if (!SintaxVB.inst) {
            for (int i = 0; i < booleano.size(); i++) {
                vb.getCuarpeta().add(booleano.get(i));
            }
        }
        SintaxVB.inst = false;
        SintaxVB.etInst = "";
    }

    public void segundoChequeoIf(ObjetosVB vb, ArrayList<Boolean> usoPila, ArrayList<ArrayList<Nodo>> pilaCuarpeta, ArrayList<ArrayList<Nodo>> pilaFalsas, int jerarquia) {
        ManejoCondiciones manejo = new ManejoCondiciones();
        if (!pilaCuarpeta.isEmpty()) {
            if (usoPila.get(usoPila.size() - 1)) {
                manejo.eliminarEtiquetasVB(vb, pilaCuarpeta.get(pilaCuarpeta.size() - 1), pilaFalsas.get(pilaFalsas.size() - 1));
                for (int i = 0; i < pilaFalsas.get(pilaFalsas.size() - 1).size(); i++) {
                    pilaCuarpeta.get(pilaCuarpeta.size() - 1).add(pilaFalsas.get(pilaFalsas.size() - 1).get(i));
                }
                for (int i = 0; i < pilaCuarpeta.get(pilaCuarpeta.size() - 1).size(); i++) {
                    vb.getCuarpeta().add(pilaCuarpeta.get(pilaCuarpeta.size() - 1).get(i));
                }
                pilaCuarpeta.remove(pilaCuarpeta.size() - 1);
            } else {
                manejo.eliminarEtiquetasVB(vb, null, pilaFalsas.get(pilaFalsas.size() - 1));
                for (int i = 0; i < pilaFalsas.get(pilaFalsas.size() - 1).size(); i++) {
                    vb.getCuarpeta().add(pilaFalsas.get(pilaFalsas.size() - 1).get(i));
                }
            }
            usoPila.remove(usoPila.size() - 1);
        } else {
            manejo.eliminarEtiquetasVB(vb, null, pilaFalsas.get(pilaFalsas.size() - 1));
            for (int i = 0; i < pilaFalsas.get(pilaFalsas.size() - 1).size(); i++) {
                vb.getCuarpeta().add(pilaFalsas.get(pilaFalsas.size() - 1).get(i));
            }
        }
        pilaFalsas.remove(pilaFalsas.size() - 1);
    }

    /*------------------------------------------- WHILE ------------------------------------------------------*/
    public void agregarWhile(ObjetosVB vb, ArrayList<Nodo> booleano, int jerarquia) {
        String etWhile = "etWhile_" + vb.getContEtWhile();
        vb.setContEtWhile(vb.getContEtWhile() + 1);
        vb.getCuarpeta().add(new Nodo("ETIQUETA", etWhile, null, null, jerarquia));
        primerChequeoIf(vb, booleano);
    }

    public void retornoWhile(ObjetosVB vb, ArrayList<Boolean> usoPila, ArrayList<ArrayList<Nodo>> pilaCuarpeta, ArrayList<ArrayList<Nodo>> pilaFalsas, int jerarquia) {
        ManejoCondiciones manejo = new ManejoCondiciones();
        String etWhile = buscarUltimoWhile(vb, jerarquia);
        vb.getCuarpeta().add(new Nodo("GOTO", null, null, etWhile, jerarquia));
        segundoChequeoIf(vb, usoPila, pilaCuarpeta, pilaFalsas, jerarquia);
        manejo.agregarEtiquetaFinVB(vb, jerarquia);
    }

    public String buscarUltimoWhile(ObjetosVB vb, int jerarquia) {
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

    public String agregarEtiquetaFinWhile(ObjetosVB vb, int jerarquia) {
        String etWhile = "";
        for (int i = 0; i < vb.getCuarpeta().size(); i++) {
            if (vb.getCuarpeta().get(i).getOperacion().equals("GOTO")) {
                if (vb.getCuarpeta().get(i).getNivel() == jerarquia) {
                    etWhile = vb.getCuarpeta().get(i).getVar();
                }
            }
        }
        return etWhile;
    }

    /*-------------------------------------- DO WHILE -----------------------------------------------------*/
    public void agregarDoWhile(ObjetosVB vb, int jerarquia) {
        String etWhile = "etWhile_" + vb.getContEtWhile();
        vb.getCuarpeta().add(new Nodo("ETIQUETA", etWhile, null, null, jerarquia));
        vb.setContEtWhile(vb.getContEtWhile() + 1);

    }

    public void agregarCondicionWhile(ObjetosVB vb, ArrayList<Boolean> usoPila, ArrayList<Nodo> booleano, ArrayList<ArrayList<Nodo>> pilaCuarpeta, ArrayList<ArrayList<Nodo>> pilaFalsas, int jerarquia) {
        ManejoCondiciones manejo = new ManejoCondiciones();
        String etWhile = buscarUltimoWhile(vb, jerarquia);
        primerChequeoIf(vb, booleano);
        vb.getCuarpeta().add(new Nodo("GOTO", null, null, etWhile, jerarquia));
        segundoChequeoIf(vb, usoPila, pilaCuarpeta, pilaFalsas, jerarquia);
        manejo.agregarEtiquetaFinVB(vb, jerarquia);
    }

    /*------------------------------------- SWITCH CASE ---------------------------------------------------*/
    public String devolverVarSwitch(TablaSimbolos tabla, String idVar, String idMetodo) {
        String t = definirTemporal(tabla);
        String valMemoria = buscarPosicionMemoria(tabla, idVar, idMetodo);
        tabla.getObVb().getCuarpeta().add(new Nodo("suma", "p", valMemoria, t, null));
        String t2 = definirTemporal(tabla);
        tabla.getObVb().getCuarpeta().add(new Nodo("asig", "stack[" + t + "]", null, t2, null));
        return t2;
    }

    public void agregarCaseSwitch(ObjetosVB vb, int jerarquia, String comparacion1, String comparacion2, String tipoOp) {
        String et = definirEtiqueta2(vb);
        vb.getCuarpeta().add(new Nodo("IF " + tipoOp, comparacion1, comparacion2, et, jerarquia));
        String et2 = definirEtiqueta2(vb);
        vb.getCuarpeta().add(new Nodo("GOTO", null, null, et2, jerarquia));
        vb.getCuarpeta().add(new Nodo("ETIQUETA", et, null, null, jerarquia));
    }

    public void agregarFinCase(ObjetosVB vb, ArrayList<String> arrayFinales, int jerarquia) {
        vb.getCuarpeta().add(new Nodo("GOTO", null, null, arrayFinales.get(arrayFinales.size() - 1), jerarquia));
        String et = obtenerUltimoGoTo(vb.getCuarpeta(), jerarquia);
        vb.getCuarpeta().add(new Nodo("ETIQUETA", et, null, null, jerarquia));
    }

    /*----------------------------------------- FOR ------------------------------------------------------*/
    public void agregarFor(ObjetosVB vb, ArrayList<ArrayList<Nodo>> pilaFalsas, String id1, String ladoA, String ladoB, int jerarquia, String tipoVar) {
        if (!tipoVar.equals("")) {
            vb.getCuarpeta().add(new Nodo("CREACION_VAR", tipoVar, null, id1, jerarquia));
        }
        vb.getCuarpeta().add(new Nodo("asig", ladoA, null, id1, null));
        String etFor = "etFor_" + vb.getContFor();
        vb.setContFor(vb.getContFor() + 1);
        vb.getCuarpeta().add(new Nodo("ETIQUETA", etFor, null, null, jerarquia));
        String et = definirEtiqueta2(vb);
        vb.getCuarpeta().add(new Nodo("IF <=", id1, ladoB, et, jerarquia));
        int sum = vb.getContEt() + 1;
        vb.setContEt(sum);
        String et2 = "et_" + sum;
        vb.getCuarpeta().add(new Nodo("GOTO", null, null, et2, jerarquia));
        pilaFalsas.get(pilaFalsas.size() - 1).add(new Nodo("ETIQUETA", et2, null, null, jerarquia));
        vb.getCuarpeta().add(new Nodo("ETIQUETA", et, null, null, jerarquia));

    }

    public void retornoFor(ObjetosVB vb, ArrayList<Boolean> usoPila, ArrayList<ArrayList<Nodo>> pilaFor, String id, ArrayList<ArrayList<Nodo>> pilaCuarpeta, ArrayList<ArrayList<Nodo>> pilaFalsas, int jerarquia) {
        ManejoCondiciones manejo = new ManejoCondiciones();
        String etFor = buscarUltimoFor(vb, jerarquia);
        for (int i = 0; i < pilaFor.get(pilaFor.size() - 1).size(); i++) {
            vb.getCuarpeta().add(pilaFor.get(pilaFor.size() - 1).get(i));
        }
        pilaFor.remove(pilaFor.size() - 1);
        vb.getCuarpeta().add(new Nodo("GOTO", null, null, etFor, jerarquia));
        segundoChequeoIf(vb, usoPila, pilaCuarpeta, pilaFalsas, jerarquia);
        manejo.agregarEtiquetaFinVB(vb, jerarquia);
    }

    public void agregarAuxPilaFor(ObjetosVB vb, ArrayList<ArrayList<Nodo>> pilaFor, String numero, String varAsignar) {
        String et = "t" + vb.getContVars();
        vb.setContVars(vb.getContVars() + 1);
        pilaFor.get(pilaFor.size() - 1).add(new Nodo("suma", numero, varAsignar, et, null));
        pilaFor.get(pilaFor.size() - 1).add(new Nodo("asig", et, null, varAsignar, null));
    }

    public String buscarUltimoFor(ObjetosVB vb, int jerarquia) {
        String etFor = "";
        for (int i = 0; i < vb.getCuarpeta().size(); i++) {
            if (vb.getCuarpeta().get(i).getOperacion().equals("ETIQUETA")) {
                String[] arreglo = vb.getCuarpeta().get(i).getDato1().toString().split("_");
                if (arreglo[0].equals("etFor")) {
                    if (vb.getCuarpeta().get(i).getNivel() == jerarquia) {
                        etFor = vb.getCuarpeta().get(i).getDato1().toString();
                    }
                }
            }
        }
        return etFor;
    }

    /*------------------------------------------- INPUTS ------------------------------------------------------*/
    public void crearScanf(TablaSimbolos tabla, String id, String tipo, String idMetodo) {
        String t = definirTemporal(tabla);
        if (tipo.equals("Integer")) {
            tabla.getObVb().getCuarpeta().add(new Nodo("SCANF", "%d", null, t, null));
        } else if (tipo.equals("Float")) {
            tabla.getObVb().getCuarpeta().add(new Nodo("SCANF", "%f", null, t, null));
        } else if (tipo.equals("Char")) {
            tabla.getObVb().getCuarpeta().add(new Nodo("SCANF", "%c", null, t, null));
        }
        String posMemoria = buscarPosicionMemoria(tabla, id, idMetodo);
        String t2 = definirTemporal(tabla);
        tabla.getObVb().getCuarpeta().add(new Nodo("suma", "p", posMemoria, t2, null));
        tabla.getObVb().getCuarpeta().add(new Nodo("asig", t, null, "stack["+t2+"]", null));
    }

    /*-------------------------------------------- RETURNS ----------------------------------------------------*/
    public void crearReturn(TablaSimbolos tabla, String id, String idMetodo) {
            String var = definirTemporal(tabla);
            String valMemoria = buscarPosicionMemoria(tabla, "return", idMetodo);
            tabla.getObVb().getCuarpeta().add(new Nodo("suma", "p", valMemoria, var, null));
            tabla.getObVb().getCuarpeta().add(new Nodo("asig", id, null, "stack["+var+"]", null));
    }

    /*------------------------------------------- MENSAJES ---------------------------------------------------*/
    public String concatenarMensajes(ObjetosVB vb, String ladoA, String ladoB) {
        String et = "t" + vb.getContVars();
        vb.setContVars(vb.getContVars() + 1);
        vb.getCuarpeta().add(new Nodo("asig", ladoA, ladoB, et, null));
        return et;
    }

    public String concatenarMensajes2(TablaSimbolos tabla, String idVar, String ladoB, String idMetodo) {
        if (esId(idVar)) {
            String t = definirTemporal(tabla);
            String valMemoria = buscarPosicionMemoria(tabla, idVar, idMetodo);
            tabla.getObVb().getCuarpeta().add(new Nodo("suma", "p", valMemoria, t, null));
            String t2 = definirTemporal(tabla);
            tabla.getObVb().getCuarpeta().add(new Nodo("asig", "stack[" + t + "]", null, t2, null));
            String t3 = definirTemporal(tabla);
            tabla.getObVb().getCuarpeta().add(new Nodo("asig", t2, ladoB, t3, null));
            return t3;
        } else {
            return concatenarMensajes(tabla.getObVb(), idVar, ladoB);
        }
    }

    public void mostrarMensaje(ObjetosVB vb, String id) {
        vb.getCuarpeta().add(new Nodo("PRINT", null, null, id, null));
    }

}
