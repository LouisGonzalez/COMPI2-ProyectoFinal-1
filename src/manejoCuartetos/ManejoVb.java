/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoCuartetos;

import cuartetos.Nodo;
import gramaticaVB.SintaxVB;
import java.util.ArrayList;
import objetos.ObjetosVB;
import objetosApoyo.NodoBoolean;
import verificaciones.VerifVB;

/**
 *
 * @author luisGonzalez
 */
public class ManejoVb {
    
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

    /*------------------------------------- CREACION VARIABLES -----------------------------------------------*/
    
    public void crearVariable(ObjetosVB vb, String id, String tipo) {
        vb.getCuarpeta().add(new Nodo("CREACION_VAR", tipo, null, id, null));
    }

    /*------------------------------------- ASIGNACION VARIABLES ---------------------------------------------*/
    
    public String agregarOperacion(ObjetosVB vb, String ladoA, String ladoB, String tipo) {
        String var = "t" + vb.getContVars();
        vb.setContVars(vb.getContVars() + 1);
        vb.getCuarpeta().add(new Nodo(tipo, ladoA, ladoB, var, null));
        return var;
    }
    
    public String agregarOperacionFor(ObjetosVB vb, ArrayList<ArrayList<Nodo>> pilaFor,  String ladoA, String ladoB, String tipo){
        String var = "t"+vb.getContVars();
        vb.setContVars(vb.getContVars()+1);
        pilaFor.get(pilaFor.size()-1).add(new Nodo(tipo, ladoA, ladoB, var, null));
        return var;
    }
    
    public void agregarValorVar(ObjetosVB vb, String id, String val) {
        if (val != null) {
            vb.getCuarpeta().add(new Nodo("asig", val, null, id, null));
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

    /*--------------------------------------------- AND -------------------------------------------------------*/
    
    public ArrayList<Nodo> manejoAnd(ArrayList<Nodo> ladoA, ArrayList<Nodo> ladoB) {
        for (int i = 0; i < ladoB.size(); i++) {
            ladoA.add(ladoB.get(i));
        }
        return ladoA;
    }

    /*--------------------------------------------- OR --------------------------------------------------------*/
    
    public void manejoOr(ObjetosVB vb, ArrayList<ArrayList<Nodo>> pilaCuarpeta, ArrayList<Nodo> ladoA, ArrayList<Nodo> ladoB, int jerarquia) {
        if (!SintaxVB.inst) {
            String ultimoGoto = obtenerUltimoGoTo(pilaCuarpeta.get(pilaCuarpeta.size() - 1), jerarquia);
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
    
    public void segundoChequeoIf(ObjetosVB vb, ArrayList<ArrayList<Nodo>> pilaCuarpeta, ArrayList<ArrayList<Nodo>> pilaFalsas, int jerarquia) {
        ManejoCondiciones manejo = new ManejoCondiciones();
        if (!pilaCuarpeta.isEmpty()) {
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
        pilaFalsas.remove(pilaFalsas.size() - 1);
    }

    /*------------------------------------------- WHILE ------------------------------------------------------*/
    
    public void agregarWhile(ObjetosVB vb, ArrayList<Nodo> booleano, int jerarquia) {
        String etWhile = "etWhile_" + vb.getContEtWhile();
        vb.setContEtWhile(vb.getContEtWhile() + 1);
        vb.getCuarpeta().add(new Nodo("ETIQUETA", etWhile, null, null, jerarquia));
        primerChequeoIf(vb, booleano);
    }
    
    public void retornoWhile(ObjetosVB vb, ArrayList<ArrayList<Nodo>> pilaCuarpeta, ArrayList<ArrayList<Nodo>> pilaFalsas, int jerarquia) {
        ManejoCondiciones manejo = new ManejoCondiciones();
        String etWhile = buscarUltimoWhile(vb, jerarquia);
        vb.getCuarpeta().add(new Nodo("GOTO", null, null, etWhile, jerarquia));
        segundoChequeoIf(vb, pilaCuarpeta, pilaFalsas, jerarquia);
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
    
    public void agregarCondicionWhile(ObjetosVB vb, ArrayList<Nodo> booleano, ArrayList<ArrayList<Nodo>> pilaCuarpeta, ArrayList<ArrayList<Nodo>> pilaFalsas, int jerarquia) {
        ManejoCondiciones manejo = new ManejoCondiciones();
        String etWhile = buscarUltimoWhile(vb, jerarquia);
        primerChequeoIf(vb, booleano);
        vb.getCuarpeta().add(new Nodo("GOTO", etWhile, null, null, jerarquia));
        segundoChequeoIf(vb, pilaCuarpeta, pilaFalsas, jerarquia);
        manejo.agregarEtiquetaFinVB(vb, jerarquia);
    }

    /*------------------------------------- SWITCH CASE ---------------------------------------------------*/
    
    public void agregarCaseSwitch(ObjetosVB vb, int jerarquia, String comparacion1, String comparacion2, String tipoOp) {
        String et = definirEtiqueta2(vb);
        vb.getCuarpeta().add(new Nodo("IF" + tipoOp, comparacion1, comparacion2, et, jerarquia));
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
        if(!tipoVar.equals("")){
            vb.getCuarpeta().add(new Nodo("CREACION_VAR", tipoVar, null, id1, jerarquia));
        }
        vb.getCuarpeta().add(new Nodo("asig", ladoA, null, id1, null));
        String etFor = "etFor_"+vb.getContFor();
        vb.setContFor(vb.getContFor()+1);
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
    
    public void retornoFor(ObjetosVB vb, ArrayList<ArrayList<Nodo>> pilaFor, String id, ArrayList<ArrayList<Nodo>> pilaCuarpeta, ArrayList<ArrayList<Nodo>> pilaFalsas, int jerarquia) {
        ManejoCondiciones manejo = new ManejoCondiciones();
        String etFor = buscarUltimoFor(vb, jerarquia);
        for (int i = 0; i < pilaFor.get(pilaFor.size() - 1).size(); i++) {
            vb.getCuarpeta().add(pilaFor.get(pilaFor.size() - 1).get(i));
        }
        pilaFor.remove(pilaFor.size() - 1);
        vb.getCuarpeta().add(new Nodo("GOTO", null, null, etFor, jerarquia));
        segundoChequeoIf(vb, pilaCuarpeta, pilaFalsas, jerarquia);
        manejo.agregarEtiquetaFinVB(vb, jerarquia);
    }
    
    public void agregarAuxPilaFor(ObjetosVB vb, ArrayList<ArrayList<Nodo>> pilaFor, String numero, String varAsignar){
        String et = "t"+vb.getContVars();
        vb.setContVars(vb.getContVars()+1);
        pilaFor.get(pilaFor.size()-1).add(new Nodo("suma", numero, varAsignar, et, null));
        pilaFor.get(pilaFor.size()-1).add(new Nodo("asig", et, null, varAsignar, null));
    }
    
    public String buscarUltimoFor(ObjetosVB vb, int jerarquia) {
        String etFor = "";
        for (int i = 0; i < vb.getCuarpeta().size(); i++) {
            if (vb.getCuarpeta().get(i).getOperacion().equals("ETIQUETA")) {
                String[] arreglo = vb.getCuarpeta().get(i).getDato1().toString().split("_");
                if (arreglo[0].equals("etFor")) {
                    if (vb.getCuarpeta().get(i).getNivel() == jerarquia) {
                        etFor = vb.getCuarpeta().get(i).getDato1().toString();
                        break;
                    }
                }
            }
        }
        return etFor;
    }                                             
                        
    /*------------------------------------------- INPUTS ------------------------------------------------------*/
    
    public void crearScanf(ObjetosVB vb, String id, String tipo){
        if(tipo.equals("Integer")){
            vb.getCuarpeta().add(new Nodo("SCANF", "%d", null, id, null));
        } else if(tipo.equals("Float")){
            vb.getCuarpeta().add(new Nodo("SCANF", "%f", null, id, null));
        } else if(tipo.equals("Char")){
            vb.getCuarpeta().add(new Nodo("SCANF", "%c", null, id, null));
        }
    }
    
}
