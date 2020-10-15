/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoCuartetos;

import cuartetos.Nodo;
import gramaticaC.SintaxC;
import java.util.ArrayList;
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
    
    /*---------------------------------------- METODO MAIN --------------------------------------------------*/

    public void crearMain(ObjetosC c){
        c.getCuarpeta().add(new Nodo("CREACION_METODO", "void", null, "main", null));
    }
    
    public void finMain(ObjetosC c){
        c.getCuarpeta().add(new Nodo("FIN_METODO", null, null, null, null));
    }
    
    /*---------------------------------------- MANEJO CLASES ------------------------------------------------*/

    public void invocacionParametros(ObjetosC c, String id){
        c.getCuarpeta().add(new Nodo("PARAM", null, null, id, null));
    }
    
    
    
    public void agregarConstructor(ObjetosC c, String idClase, String id, int totalParam){
        String id2 = "JV_"+idClase+"_"+idClase;
        c.getCuarpeta().add(new Nodo("CALL", id2, Integer.toString(totalParam), id, null));
    }
    
    /*------------------------------------------ METODOS ----------------------------------------------------*/
    
    public void metodoVoid(ObjetosC c, String id, int totalParam){
        c.getCuarpeta().add(new Nodo("CALL", id, Integer.toString(totalParam), null, null));
    }
    
    
    /*------------------------------------- CREACION VARIABLES ------------------------------------------------*/
    public void crearVariable(ObjetosC c, String id, String tipo) {
        c.getCuarpeta().add(new Nodo("CREACION_VAR", tipo, null, id, null));
    }

    public void crearVariableConValor(ObjetosC c, String id, String tipo, NodoOperacion valor) {
        c.getCuarpeta().add(new Nodo("CREACION_VAR", tipo, null, id, null));
        if (valor != null) {
            c.getCuarpeta().add(new Nodo("asig", valor, null, id, null));
        }
    }

    public void asignarValor(ObjetosC c, String id, String valor) {
        c.getCuarpeta().add(new Nodo("asig", valor, null, id, null));
    }

    /*-------------------------------------- MANEJO OPERACIONES -----------------------------------------------*/
    public String agregarOperacion(ObjetosC c, String ladoA, String ladoB, String tipo) {
        String var = "t" + c.getContVars();
        c.setContVars(c.getContVars() + 1);
        c.getCuarpeta().add(new Nodo(tipo, ladoA, ladoB, var, null));
        return var;
    }
    
    public String operacionMetodo(ObjetosC c, String idMetodo, int totalParam){
        String var = "t" + c.getContVars();
        c.setContVars(c.getContVars()+1);
        c.getCuarpeta().add(new Nodo("CALL", idMetodo, Integer.toString(totalParam), var, null));
        return var;
        
    }
    
    public String operacionMetodo2(ObjetosC c, String idMetodo, int totalParam){
        String var = "t" + c.getContVars();
        c.setContVars(c.getContVars()+1);
        c.getCuarpeta().add(new Nodo("CALL", idMetodo, Integer.toString(totalParam), var, null));
        String var2 = "t"+c.getContVars();
        c.setContVars(c.getContVars()+1);
        c.getCuarpeta().add(new Nodo("asig", "-"+var, null, var, null));
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
    
    public ArrayList<Nodo> cambiarGotos(ArrayList<Nodo> booleano){
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
            usoPila.remove(usoPila.size()-1);
        } else {
            manejo.eliminarEtiquetasC(c, null, pilaFalsas.get(pilaFalsas.size() - 1));
            for (int i = 0; i < pilaFalsas.get(pilaFalsas.size() - 1).size(); i++) {
                c.getCuarpeta().add(pilaFalsas.get(pilaFalsas.size() - 1).get(i));
            }
        }
        pilaFalsas.remove(pilaFalsas.size() - 1);
    }

    /*-------------------------------------------- WHILE -----------------------------------------------------*/
    public void agregarWhile(ObjetosC c, ArrayList<Nodo> booleano, int jerarquia) {
        String etWhile = "etWhile_" + c.getContWhile();
        c.setContWhile(c.getContWhile() + 1);
        c.getCuarpeta().add(new Nodo("ETIQUETA", etWhile, null, null, jerarquia));
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
    public void agregarFor(ObjetosC c, String id1, String valId1, ArrayList<Nodo> booleano, int jerarquia, String tipo) {
        if (!tipo.equals("")) {
            c.getCuarpeta().add(new Nodo("CREACION_VAR", tipo, null, id1, null));
        }

        c.getCuarpeta().add(new Nodo("asig", valId1, null, id1, null));
        String etFor = "etFor_" + c.getContFor();
        c.setContFor(c.getContFor() + 1);
        c.getCuarpeta().add(new Nodo("ETIQUETA", etFor, null, null, jerarquia));
        primerChequeoIf(c, booleano);
    }

    public void retornarFor(ObjetosC c, ArrayList<Boolean> usoPila, String id, String varAumento, String varAumento2, ArrayList<ArrayList<Nodo>> pilaCuarpeta, ArrayList<ArrayList<Nodo>> pilaFalsas, int jerarquia) {
        ManejoCondiciones manejo = new ManejoCondiciones();
        String etFor = buscarUltimoFor(c, jerarquia);
        c.getCuarpeta().add(new Nodo("asig", varAumento, varAumento2, id, null));
        c.getCuarpeta().add(new Nodo("GOTO", null, null, etFor, jerarquia));
        segundoChequeoIf(c, usoPila, pilaCuarpeta, pilaFalsas, jerarquia);
        manejo.agregarEtiquetaFinC(c, jerarquia);
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
    
    public void agregarCaseSwitch(ObjetosC c, int jerarquia, String comparacion1, String comparacion2, String tipoOp){
        String et = definirEtiqueta2(c);
        c.getCuarpeta().add(new Nodo("IF " + tipoOp, comparacion1, comparacion2, et, jerarquia));
        String et2 = definirEtiqueta2(c);
        c.getCuarpeta().add(new Nodo("GOTO", null, null, et2, jerarquia));
        c.getCuarpeta().add(new Nodo("ETIQUETA", et, null, null, jerarquia));
    }
    
    public void agregarFinCase(ObjetosC c, ArrayList<String> arrayFinales, int jerarquia){
        c.getCuarpeta().add(new Nodo("GOTO", null, null, arrayFinales.get(arrayFinales.size() - 1), jerarquia));
        String et = obtenerUltimoGoTo(c.getCuarpeta(), jerarquia);
        c.getCuarpeta().add(new Nodo("ETIQUETA", et, null, null, jerarquia));
    }
    
    /*-------------------------------------------- GETCH -----------------------------------------------------*/
    
    public void crearGetch(ObjetosC c, String id){
        c.getCuarpeta().add(new Nodo("GETCH", null, null, id, null));
    }

    /*------------------------------------------- CLRSL -----------------------------------------------------*/
    
    public void crearClscr(ObjetosC c){
        c.getCuarpeta().add(new Nodo("CLSCR", null, null, null, null));
    }

    /*------------------------------------------- SCANF ------------------------------------------------------*/
    
    public void crearScanf(ObjetosC c, String id, String tipo){
        if(tipo.equals("Integer")){
            c.getCuarpeta().add(new Nodo("SCANF", "%d", null, id, null));
        } else if(tipo.equals("Float")){
            c.getCuarpeta().add(new Nodo("SCANF", "%f", null, id, null));
        } else if(tipo.equals("Char")){
            c.getCuarpeta().add(new Nodo("SCANF", "%c", null, id, null));
        }
    }
    
}
