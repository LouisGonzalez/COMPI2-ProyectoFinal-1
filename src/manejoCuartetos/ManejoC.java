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
    
    /*------------------------------------- CREACION VARIABLES ------------------------------------------------*/
    
    public void crearVariable(ObjetosC c, String id, String tipo){
        c.getCuarpeta().add(new Nodo("CREACION_VAR", tipo, null, id, null));
    }
    
    public void crearVariableConValor(ObjetosC c, String id, String tipo, NodoOperacion valor){
        c.getCuarpeta().add(new Nodo("CREACION_VAR", tipo, null, id, null));
        if(valor != null){
            c.getCuarpeta().add(new Nodo("asig", valor, null, id, null));
        }
    } 
    
    public void asignarValor(ObjetosC c, String id, String valor){
        c.getCuarpeta().add(new Nodo("asig", valor, null, id, null));
    }
    
    /*-------------------------------------- MANEJO OPERACIONES -----------------------------------------------*/

    public String agregarOperacion(ObjetosC c, String ladoA, String ladoB, String tipo){
        String var = "t"+c.getContVars();
        c.setContVars(c.getContVars()+1);
        c.getCuarpeta().add(new Nodo(tipo, ladoA, ladoB, var, null));
        return var;
    }

    /*----------------------------------------- MANEJO BOOLEANOS ----------------------------------------------*/
    
    public NodoBoolean concatenarOperacion(ObjetosC c, NodoBoolean ladoA, NodoBoolean ladoB, String tipoOp){
        VerifC verif = new VerifC();
        String var = "t"+c.getContVars();
        c.setContVars(c.getContVars()+1);
        if(!ladoA.getTipo().equals("") && !ladoB.getTipo().equals("")){
            String tip = verif.verifOpCondicional(c, ladoA.getTipo(), ladoB.getTipo());
            c.getCuarpeta().add(new Nodo(tipoOp, ladoA.getId(), ladoB.getId(), var, null));
            return new NodoBoolean(tip, var);
        } else {
            c.getCuarpeta().add(new Nodo(tipoOp, ladoA.getId(), ladoB.getId(), var, null));
            return new NodoBoolean("", var);
        }
    }
    
    public ArrayList<Nodo> agregarBooleans(ObjetosC c, ArrayList<ArrayList<Nodo>> pilaFalsas, NodoBoolean ladoA, NodoBoolean ladoB, String op, int jerarquia){
        VerifC verif = new VerifC();
        if(!ladoA.getTipo().equals("") && !ladoB.getTipo().equals("")){
            verif.verifOpCondicional(c, ladoA.getTipo(), ladoB.getTipo());
        }
        ArrayList<Nodo> list = new ArrayList<>();
        String et = definirEtiqueta2(c);
        list.add(new Nodo("IF "+op, ladoA.getId(), ladoB.getId(), et, jerarquia));
        int sum = c.getContEt()+1;
        c.setContEt(sum);
        String et2 = "et_"+sum;
        SintaxC.aux2 = et2;
        list.add(new Nodo("GOTO", null, null, et2, jerarquia));
        pilaFalsas.get(pilaFalsas.size()-1).add(new Nodo("ETIQUETA", et2, null, null, jerarquia));
        list.add(new Nodo("ETIQUETA", et, null, null, jerarquia));
        return list;
    }
    
    public ArrayList<Nodo> agregarVerdadero(ObjetosC c, ArrayList<ArrayList<Nodo>> pilaFalsas, int jerarquia){
        ArrayList<Nodo> list = new ArrayList<>();
        String et = definirEtiqueta2(c);
        list.add(new Nodo("IF ==", "1", "1", et, jerarquia));
        int sum = c.getContEt()+1;
        c.setContEt(sum);
        String et2 = "et_"+sum;
        SintaxC.aux2 = et2;
        list.add(new Nodo("GOTO", null, null, et2, jerarquia));
        pilaFalsas.get(pilaFalsas.size()-1).add(new Nodo("ETIQUETA", et2, null, null, jerarquia));
        list.add(new Nodo("ETIQUETA", et, null, null, jerarquia));
        return list;
    }
    
    public ArrayList<Nodo> agregarFalso(ObjetosC c, ArrayList<ArrayList<Nodo>> pilaFalsas, int jerarquia){
        ArrayList<Nodo> list = new ArrayList<>();
        String et = definirEtiqueta2(c);
        list.add(new Nodo("IF ==", "1", "2", et, jerarquia));
        int sum = c.getContEt()+1;
        c.setContEt(sum);
        String et2 = "et_"+sum;
        SintaxC.aux2 = et2;
        list.add(new Nodo("GOTO", null, null, et2, jerarquia));
        pilaFalsas.get(pilaFalsas.size()-1).add(new Nodo("ETIQUETA", et2, null, null, jerarquia));
        list.add(new Nodo("ETIQUETA", et, null, null, jerarquia));
        return list;
    }
    
    /*------------------------------------------- AND ----------------------------------------------------*/
     
    public ArrayList<Nodo> manejoAnd(ArrayList<Nodo> ladoA, ArrayList<Nodo> ladoB){
        for (int i = 0; i < ladoB.size(); i++) {
            ladoA.add(ladoB.get(i));
        }
        return ladoA;
    }  
    
    /*------------------------------------------ OR --------------------------------------------------------*/
    
    public void manejoOr(ObjetosC c, ArrayList<ArrayList<Nodo>> pilaCuarpeta, ArrayList<Nodo> ladoA, ArrayList<Nodo> ladoB, int jerarquia){
        if(SintaxC.inst){
            if(ladoA == null){
                pilaCuarpeta.get(pilaCuarpeta.size()-1).add(new Nodo("ETIQUETA", SintaxC.aux3, null, null, jerarquia));
                SintaxC.aux3 = "";
            }
            ladoB.add(new Nodo("GOTO", null, null, SintaxC.etInst, jerarquia));
            for (int i = 0; i < ladoB.size(); i++) {
                pilaCuarpeta.get(pilaCuarpeta.size()-1).add(ladoB.get(i));
            }
        } else {
            String ultimoGoto = obtenerUltimoGoTo(ladoA, jerarquia);
            SintaxC.inst = true;
            SintaxC.etInst = ladoA.get(ladoA.size()-1).getDato1().toString();
            for (int i = 0; i < ladoA.size(); i++) {
                c.getCuarpeta().add(ladoA.get(i));
            }
            ladoB.add(new Nodo("GOTO", null, null, SintaxC.etInst, jerarquia));
            pilaCuarpeta.add(new ArrayList<>());
            pilaCuarpeta.get(pilaCuarpeta.size()-1).add(new Nodo("ETIQUETA", ultimoGoto, null, null, jerarquia));
            for (int i = 0; i < ladoB.size(); i++) {
                pilaCuarpeta.get(pilaCuarpeta.size()-1).add(ladoB.get(i));
            }
        }
    }
    
    /*------------------------------------ IF - ELSEIF - ELSE ------------------------------------------------ */

    public void primerChequeoIf(ObjetosC c, ArrayList<Nodo> booleano){
        if(!SintaxC.inst){
            for (int i = 0; i < booleano.size(); i++) {
                c.getCuarpeta().add(booleano.get(i));
            }
        }
        SintaxC.inst = false;
        SintaxC.etInst = "";
    }
    
    public void segundoChequeoIf(ObjetosC c, ArrayList<ArrayList<Nodo>> pilaCuarpeta, ArrayList<ArrayList<Nodo>> pilaFalsas, int jerarquia){
        ManejoCondiciones manejo = new ManejoCondiciones();
        if(!pilaCuarpeta.isEmpty()){
            manejo.eliminarEtiquetasC(c, pilaCuarpeta.get(pilaCuarpeta.size()-1), pilaFalsas.get(pilaFalsas.size()-1));
            for (int i = 0; i < pilaFalsas.get(pilaFalsas.size()-1).size(); i++) {
                pilaCuarpeta.get(pilaCuarpeta.size()-1).add(pilaFalsas.get(pilaFalsas.size()-1).get(i));
            }
            for (int i = 0; i < pilaCuarpeta.get(pilaCuarpeta.size()-1).size(); i++) {
                c.getCuarpeta().add(pilaCuarpeta.get(pilaCuarpeta.size()-1).get(i));
            }
            pilaCuarpeta.remove(pilaCuarpeta.size()-1);
        } else {
            manejo.eliminarEtiquetasC(c, null, pilaFalsas.get(pilaFalsas.size()-1));
            for (int i = 0; i < pilaFalsas.get(pilaFalsas.size()-1).size(); i++) {
                c.getCuarpeta().add(pilaFalsas.get(pilaFalsas.size()-1).get(i));
            }
        }
        pilaFalsas.remove(pilaFalsas.size()-1);
    }

}





