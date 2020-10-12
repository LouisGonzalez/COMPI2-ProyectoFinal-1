/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoCuartetos;

import Operaciones.OperacionesPY;
import cuartetos.Nodo;
import gramaticaPYTHON.SintaxPYTHON;
import gramaticaVB.SintaxVB;
import java.util.ArrayList;
import objetos.ObjetosPYTHON;
import objetosApoyo.NodoBoolean;
import verificaciones.VerifPY;

/**
 *
 * @author luisGonzalez
 */
public class ManejoPython {

    public String definirEtiqueta2(ObjetosPYTHON jv) {
        int suma = jv.getContEt() + 1;
        jv.setContEt(suma);
        String et = "et_" + suma;
        return et;
    }

    public Integer ultimaEtiquetaFinal(ObjetosPYTHON py, int jerarquia){
        Integer nodo = null;
        for (int i = 0; i < py.getCuarpeta().size(); i++) {
            if(py.getCuarpeta().get(i).getOperacion().equals("ETIQUETA")){
                if(py.getCuarpeta().get(i).getNivel() == jerarquia){
                    String[] arreglo = py.getCuarpeta().get(i).getDato1().toString().split("_");
                    if(arreglo[0].equals("etFin")){
                        nodo = i;
                    }
                }
            }
        }
        return nodo;
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

    /*--------------------------------------- MANEJO DE VARIABLES -----------------------------------------------*/
    public void agregarVariable(ObjetosPYTHON py, String idVar, NodoBoolean valoresVar) {
        OperacionesPY op = new OperacionesPY();
        if (!op.asignarVariables(py, idVar, valoresVar.getTipo())) {
            py.getCuarpeta().add(new Nodo("CREACION_VAR", valoresVar.getTipo(), null, idVar, null));
        }
        py.getCuarpeta().add(new Nodo("asig", valoresVar.getId(), null, idVar, null));
    }

    public void asignacionesMultiples(ObjetosPYTHON py, ArrayList<String> identificadores, ArrayList<NodoBoolean> valores) {
        OperacionesPY op = new OperacionesPY();
        if (valores != null) {
            if (identificadores.size() == valores.size()) {
                for (int i = 0; i < identificadores.size(); i++) {
                    if (!op.asignarVariables(py, identificadores.get(i), valores.get(i).getTipo())) {
                        py.getCuarpeta().add(new Nodo("CREACION_VAR", valores.get(i).getTipo(), null, identificadores.get(i), null));
                    }
                    py.getCuarpeta().add(new Nodo("asig", valores.get(i).getId(), null, identificadores.get(i), null));
                }
            }
        }
    }

    /*---------------------------------------- MANEJO BOOLEANOS -------------------------------------------------*/
    public NodoBoolean concatenarOperacion(ObjetosPYTHON py, NodoBoolean ladoA, NodoBoolean ladoB, String tipoOp) {
        VerifPY verif = new VerifPY();
        String var = "t" + py.getContVars();
        py.setContVars(py.getContVars() + 1);
        py.getCuarpeta().add(new Nodo(tipoOp, ladoA.getId(), ladoB.getId(), var, null));
        if (!ladoA.getTipo().equals("") && !ladoB.getTipo().equals("")) {
            String tip = verif.verificarTipoOperacion(py, ladoA.getTipo(), ladoB.getTipo());
            return new NodoBoolean(tip, var);
        } else {
            return new NodoBoolean("", var);
        }

    }

    public ArrayList<Nodo> agregarBooleans(ObjetosPYTHON py, ArrayList<ArrayList<Nodo>> pilaFalsas, NodoBoolean ladoA, NodoBoolean ladoB, String op) {
        VerifPY verif = new VerifPY();
        if (!ladoA.getTipo().equals("") && !ladoB.getTipo().equals("")) {
            verif.verificarTipoOperacion(py, ladoA.getTipo(), ladoB.getTipo());
        }
        ArrayList<Nodo> list = new ArrayList<>();
        String et = definirEtiqueta2(py);
        list.add(new Nodo("IF " + op, ladoA.getId(), ladoB.getId(), et, SintaxPYTHON.jerarquia));
        int sum = py.getContEt() + 1;
        py.setContEt(sum);
        String et2 = "et_" + sum;
        SintaxPYTHON.aux2 = et2;
        list.add(new Nodo("GOTO", null, null, et2, SintaxPYTHON.jerarquia));
        pilaFalsas.get(pilaFalsas.size() - 1).add(new Nodo("ETIQUETA", et2, null, null, SintaxPYTHON.jerarquia));
        list.add(new Nodo("ETIQUETA", et, null, null, SintaxPYTHON.jerarquia));
        return list;
    }

    /*--------------------------------------------- AND --------------------------------------------------------*/
    public ArrayList<Nodo> manejoAnd(ArrayList<Nodo> ladoA, ArrayList<Nodo> ladoB) {
        for (int i = 0; i < ladoB.size(); i++) {
            ladoA.add(ladoB.get(i));
        }
        return ladoA;
    }

    /*--------------------------------------------- OR ---------------------------------------------------------*/

    public void manejoOr(ObjetosPYTHON py, ArrayList<ArrayList<Nodo>> pilaCuarpeta, ArrayList<Nodo> ladoA, ArrayList<Nodo> ladoB) {
        if (SintaxPYTHON.inst) {
            if (ladoA == null) {
                pilaCuarpeta.get(pilaCuarpeta.size() - 1).add(new Nodo("ETIQUETA", SintaxPYTHON.aux3, null, null, SintaxPYTHON.jerarquia));
                SintaxPYTHON.aux3 = "";
            }
            ladoA.add(new Nodo("GOTO", null, null, SintaxPYTHON.etInst, SintaxPYTHON.jerarquia));
            for (int i = 0; i < ladoB.size(); i++) {
                pilaCuarpeta.get(pilaCuarpeta.size() - 1).add(ladoB.get(i));
            }
        } else {
            String ultimoGoto = obtenerUltimoGoTo(ladoA, SintaxPYTHON.jerarquia);
            SintaxPYTHON.inst = true;
            SintaxPYTHON.etInst = ladoA.get(ladoA.size()-1).getDato1().toString();
            for (int i = 0; i < ladoA.size(); i++) {
                py.getCuarpeta().add(ladoA.get(i));
            }
            ladoB.add(new Nodo("GOTO", null, null, SintaxPYTHON.etInst, SintaxPYTHON.jerarquia));
            pilaCuarpeta.add(new ArrayList<>());
            pilaCuarpeta.get(pilaCuarpeta.size()-1).add(new Nodo("ETIQUETA", ultimoGoto, null, null, SintaxPYTHON.jerarquia));
            for (int i = 0; i < ladoB.size(); i++) {
                pilaCuarpeta.get(pilaCuarpeta.size()-1).add(ladoB.get(i));
            }
        }
    }

    /*-------------------------------------- IF ELSEIF ELSE -------------------------------------------------*/
    
    public void primerChequeoIf(ObjetosPYTHON py, ArrayList<Nodo> booleano){
        if(!SintaxPYTHON.inst){
            for (int i = 0; i < booleano.size(); i++) {
                py.getCuarpeta().add(booleano.get(i));
            }
        }
        SintaxPYTHON.inst = false;
        SintaxPYTHON.etInst = "";
    }
    
    public void segundoChequeoIf(ObjetosPYTHON py, ArrayList<ArrayList<Nodo>> pilaCuarpeta, ArrayList<ArrayList<Nodo>> pilaFalsas){
        ManejoCondiciones manejo = new ManejoCondiciones();
        if(!pilaCuarpeta.isEmpty()){
            manejo.eliminarEtiquetasPY(py, pilaCuarpeta.get(pilaCuarpeta.size()-1), pilaFalsas.get(pilaFalsas.size()-1));
            for (int i = 0; i < pilaFalsas.get(pilaFalsas.size()-1).size(); i++) {
                pilaCuarpeta.get(pilaCuarpeta.size()-1).add(pilaFalsas.get(pilaFalsas.size()-1).get(i));
            }
            for (int i = 0; i < pilaCuarpeta.get(pilaCuarpeta.size()-1).size(); i++) {
                py.getCuarpeta().add(pilaCuarpeta.get(pilaCuarpeta.size()-1).get(i));
            }
            pilaCuarpeta.remove(pilaCuarpeta.size()-1);
        } else {
            manejo.eliminarEtiquetasPY(py, null, pilaFalsas.get(pilaFalsas.size()-1));
            for (int i = 0; i < pilaFalsas.get(pilaFalsas.size()-1).size(); i++) {
                py.getCuarpeta().add(pilaFalsas.get(pilaFalsas.size()-1).get(i));
            }
        }
        pilaFalsas.remove(pilaFalsas.size()-1);
    }
    
}
