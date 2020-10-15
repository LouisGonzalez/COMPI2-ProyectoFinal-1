/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoCuartetos;

import cuartetos.Nodo;
import gramaticaJAVA.SintaxJAVA;
import java.util.ArrayList;
import objetos.ObjetosJAVA;
import objetosApoyo.NodoBoolean;
import verificaciones.VerifJAVA;

/**
 *
 * @author luisGonzalez
 */
public class ManejoJava {

    public String definirEtiqueta2(ObjetosJAVA jv) {
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
                    if (jv.get(i).getVar() != null) {
                        String[] arreglo = jv.get(i).getVar().split("_");
                        if (arreglo[0].equals("et")) {
                            et = jv.get(i).getVar();
                        }
                    }
                }
            }
        }
        return et;
    }

    /*---------------------------------------- METODOS -----------------------------------------------------*/
    public void crearMetodo(ObjetosJAVA jv, String idMetodo, String parametros, String tipo) {
        String idClase = jv.getMisClases().get(jv.getMisClases().size() - 1).getId();
        String nombre;
        if (parametros.equals("")) {
            nombre = "JV_"+idClase + "_" + idMetodo;
        } else {
            nombre = "JV_"+idClase + "_" + idMetodo + "_" + parametros;
        }
        jv.getCuarpeta().add(new Nodo("CREACION_METODO", tipo, null, nombre, null));
    }

    public void finMetodo(ObjetosJAVA jv) {
        jv.getCuarpeta().add(new Nodo("FIN_METODO", null, null, null, null));
    }

    /*---------------------------------------- NOT ----------------------------------------------------------*/
    public ArrayList<Nodo> cambiarGotos(ArrayList<Nodo> booleano) {
        String goto1 = booleano.get(0).getVar();
        String goto2 = booleano.get(1).getVar();
        booleano.get(0).setVar(goto2);
        booleano.get(1).setVar(goto1);
        return booleano;
    }

    /*----------------------------------------AND-----------------------------------------------*/
    public ArrayList<Nodo> manejoAnd(ArrayList<Nodo> ladoA, ArrayList<Nodo> ladoB) {
        for (int i = 0; i < ladoB.size(); i++) {
            ladoA.add(ladoB.get(i));
        }
        return ladoA;
    }

    /*-----------------------------------------OR-------------------------------------------------*/
    public void manejoOr(ObjetosJAVA jv, ArrayList<Boolean> usoPila, ArrayList<ArrayList<Nodo>> pilaCuarpeta, ArrayList<Nodo> ladoA, ArrayList<Nodo> ladoB, int jerarquia) {
        if (SintaxJAVA.inst) {
            if (ladoA == null) {
                pilaCuarpeta.get(pilaCuarpeta.size() - 1).add(new Nodo("ETIQUETA", SintaxJAVA.aux3, null, null, jerarquia));
                SintaxJAVA.aux3 = "";
            }
            ladoB.add(new Nodo("GOTO", null, null, SintaxJAVA.etInst, jerarquia));
            for (int i = 0; i < ladoB.size(); i++) {
                pilaCuarpeta.get(pilaCuarpeta.size() - 1).add(ladoB.get(i));
            }
        } else {
            String ultimoGoto = obtenerUltimoGoTo(ladoA, jerarquia);
            SintaxJAVA.inst = true;
            SintaxJAVA.etInst = ladoA.get(ladoA.size() - 1).getDato1().toString();
            for (int i = 0; i < ladoA.size(); i++) {
                jv.getCuarpeta().add(ladoA.get(i));
            }
            ladoB.add(new Nodo("GOTO", null, null, SintaxJAVA.etInst, jerarquia));
            pilaCuarpeta.add(new ArrayList<>());
            usoPila.set(usoPila.size() - 1, true);
            pilaCuarpeta.get(pilaCuarpeta.size() - 1).add(new Nodo("ETIQUETA", ultimoGoto, null, null, jerarquia));
            for (int i = 0; i < ladoB.size(); i++) {
                pilaCuarpeta.get(pilaCuarpeta.size() - 1).add(ladoB.get(i));

            }
        }
    }

    /*---------------------------------------IF - ELSEIF - ELSE-----------------------------------------*/
    //METODO PARA RETORNAR ARRAYLIST EN PRODUCCION BOOLEAN OP BOOLEAN
    public ArrayList<Nodo> agregarBooleans(ObjetosJAVA jv, ArrayList<ArrayList<Nodo>> pilaFalsas, NodoBoolean lado1, NodoBoolean lado2, String op, int jerarquia) {
        VerifJAVA verif = new VerifJAVA();
        if (!lado1.getTipo().equals("") && !lado2.getTipo().equals("")) {
            verif.verificarTipoOperacion(jv, lado1.getTipo(), lado2.getTipo());
        }
        ArrayList<Nodo> list = new ArrayList<>();
        String et = definirEtiqueta2(jv);
        list.add(new Nodo("IF " + op, lado1.getId(), lado2.getId(), et, jerarquia));
        int sum = jv.getContEt() + 1;
        jv.setContEt(sum);
        String et2 = "et_" + sum;
        SintaxJAVA.aux2 = et2;
        list.add(new Nodo("GOTO", null, null, et2, jerarquia));
        pilaFalsas.get(pilaFalsas.size() - 1).add(new Nodo("ETIQUETA", et2, null, null, jerarquia));
        list.add(new Nodo("ETIQUETA", et, null, null, jerarquia));
        return list;

    }

    public void primerChequeoIf(ObjetosJAVA jv, ArrayList<Nodo> booleano) {
        if (!SintaxJAVA.inst) {
            for (int i = 0; i < booleano.size(); i++) {
                jv.getCuarpeta().add(booleano.get(i));
            }
        }
        SintaxJAVA.inst = false;
        SintaxJAVA.etInst = "";
    }

    public void segundoChequeoIf(ObjetosJAVA jv, ArrayList<Boolean> usoPila, ArrayList<ArrayList<Nodo>> pilaCuarpeta, ArrayList<ArrayList<Nodo>> pilaFalsas, int jerarquia) {
        ManejoCondiciones manejo = new ManejoCondiciones();
        if (!pilaCuarpeta.isEmpty()) {
            if (usoPila.get(usoPila.size() - 1)) {
                manejo.eliminarEtiquetas(jv, pilaCuarpeta.get(pilaCuarpeta.size() - 1), pilaFalsas.get(pilaFalsas.size() - 1));
                for (int i = 0; i < pilaFalsas.get(pilaFalsas.size() - 1).size(); i++) {
                    pilaCuarpeta.get(pilaCuarpeta.size() - 1).add(pilaFalsas.get(pilaFalsas.size() - 1).get(i));
                }

                for (int i = 0; i < pilaCuarpeta.get(pilaCuarpeta.size() - 1).size(); i++) {
                    jv.getCuarpeta().add(pilaCuarpeta.get(pilaCuarpeta.size() - 1).get(i));
                }
                pilaCuarpeta.remove(pilaCuarpeta.size() - 1);
            } else {
                manejo.eliminarEtiquetas(jv, null, pilaFalsas.get(pilaFalsas.size() - 1));
                for (int i = 0; i < pilaFalsas.get(pilaFalsas.size() - 1).size(); i++) {
                    jv.getCuarpeta().add(pilaFalsas.get(pilaFalsas.size() - 1).get(i));
                }
            }
            usoPila.remove(usoPila.size() - 1);
        } else {
            manejo.eliminarEtiquetas(jv, null, pilaFalsas.get(pilaFalsas.size() - 1));
            for (int i = 0; i < pilaFalsas.get(pilaFalsas.size() - 1).size(); i++) {
                jv.getCuarpeta().add(pilaFalsas.get(pilaFalsas.size() - 1).get(i));
            }
        }
        pilaFalsas.remove(pilaFalsas.size() - 1);
    }

    /*-------------------------------------------WHILE-------------------------------------------------------*/
    public void agregarWhile(ObjetosJAVA jv, ArrayList<Nodo> booleano, int jerarquia) {
        String etWhile = "etWhile_" + jv.getContWhile();
        jv.setContWhile(jv.getContWhile() + 1);
        jv.getCuarpeta().add(new Nodo("ETIQUETA", etWhile, null, null, jerarquia));
        primerChequeoIf(jv, booleano);
    }

    public void retornoWhile(ObjetosJAVA jv, ArrayList<Boolean> usoPila, ArrayList<ArrayList<Nodo>> pilaCuarpeta, ArrayList<ArrayList<Nodo>> pilaFalsas, int jerarquia) {
        ManejoCondiciones manejo = new ManejoCondiciones();
        String etWhile = buscarUltimoWhile(jv, jerarquia);
        jv.getCuarpeta().add(new Nodo("GOTO", null, null, etWhile, jerarquia));
        segundoChequeoIf(jv, usoPila, pilaCuarpeta, pilaFalsas, jerarquia);
        manejo.agregarEtiquetaFin(jv, jerarquia);
    }

    public String buscarUltimoWhile(ObjetosJAVA jv, int jerarquia) {
        String etWhile = "";
        for (int i = 0; i < jv.getCuarpeta().size(); i++) {
            if (jv.getCuarpeta().get(i).getOperacion().equals("ETIQUETA")) {
                String[] arreglo = jv.getCuarpeta().get(i).getDato1().toString().split("_");
                if (arreglo[0].equals("etWhile")) {
                    if (jv.getCuarpeta().get(i).getNivel() == jerarquia) {
                        etWhile = jv.getCuarpeta().get(i).getDato1().toString();
                    }
                }
            }
        }
        return etWhile;
    }

    public String agregarEtiquetaFinWhile(ObjetosJAVA jv, int jerarquia) {
        String etWhile = "";
        for (int i = 0; i < jv.getCuarpeta().size(); i++) {
            if (jv.getCuarpeta().get(i).getOperacion().equals("GOTO")) {
                if (jv.getCuarpeta().get(i).getNivel() == jerarquia) {
                    etWhile = jv.getCuarpeta().get(i).getVar();
                }
            }
        }
        return etWhile;
    }

    /*----------------------------------------------DO - WHILE-----------------------------------------------------*/
    public void agregarDoWhile(ObjetosJAVA jv, int jerarquia) {
        String etWhile = "etWhile_" + jv.getContWhile();
        jv.getCuarpeta().add(new Nodo("ETIQUETA", etWhile, null, null, jerarquia));
        jv.setContWhile(jv.getContWhile() + 1);
    }

    public void agregarCondicionWhile(ObjetosJAVA jv, ArrayList<Boolean> usoPila, ArrayList<Nodo> booleano, ArrayList<ArrayList<Nodo>> pilaCuarpeta, ArrayList<ArrayList<Nodo>> pilaFalsas, int jerarquia) {
        ManejoCondiciones manejo = new ManejoCondiciones();
        String etWhile = buscarUltimoWhile(jv, jerarquia);
        primerChequeoIf(jv, booleano);
        jv.getCuarpeta().add(new Nodo("GOTO", etWhile, null, null, jerarquia));
        segundoChequeoIf(jv, usoPila, pilaCuarpeta, pilaFalsas, jerarquia);
        manejo.agregarEtiquetaFin(jv, jerarquia);
    }

    /*--------------------------------------- SWITCH - CASE -------------------------------------------------*/
    public void agregarCaseSwitch(ObjetosJAVA jv, int jerarquia, String comparacion1, String comparacion2, String tipoOp) {
        String et = definirEtiqueta2(jv);
        jv.getCuarpeta().add(new Nodo("IF " + tipoOp, comparacion1, comparacion2, et, jerarquia));
        String et2 = definirEtiqueta2(jv);
        jv.getCuarpeta().add(new Nodo("GOTO", null, null, et2, jerarquia));
        jv.getCuarpeta().add(new Nodo("ETIQUETA", et, null, null, jerarquia));
    }

    public void agregarFinCase(ObjetosJAVA jv, ArrayList<String> arrayFinales, int jerarquia) {
        jv.getCuarpeta().add(new Nodo("GOTO", null, null, arrayFinales.get(arrayFinales.size() - 1), jerarquia));
        String et = obtenerUltimoGoTo(jv.getCuarpeta(), jerarquia);
        jv.getCuarpeta().add(new Nodo("ETIQUETA", et, null, null, jerarquia));

    }

    /*-------------------------------------------- FOR ----------------------------------------------------------*/
    public void agregarFor(ObjetosJAVA jv, String id1, String valId1, ArrayList<Nodo> booolean, int jerarquia) {
        jv.getCuarpeta().add(new Nodo("asig", valId1, null, id1, null));
        String etFor = "etFor_" + jv.getContFor();
        jv.setContFor(jv.getContFor() + 1);
        jv.getCuarpeta().add(new Nodo("ETIQUETA", etFor, null, null, jerarquia));
        primerChequeoIf(jv, booolean);
    }

    public void retornoFor(ObjetosJAVA jv, ArrayList<Boolean> usoPila, ArrayList<ArrayList<Nodo>> pilaFor, String id, ArrayList<ArrayList<Nodo>> pilaCuarpeta, ArrayList<ArrayList<Nodo>> pilaFalsas, String varAsignar, int jerarquia) {
        ManejoCondiciones manejo = new ManejoCondiciones();
        String etFor = buscarUltimoFor(jv, jerarquia);
        for (int i = 0; i < pilaFor.get(pilaFor.size() - 1).size(); i++) {
            jv.getCuarpeta().add(pilaFor.get(pilaFor.size() - 1).get(i));
        }
        pilaFor.remove(pilaFor.size() - 1);
        jv.getCuarpeta().add(new Nodo("asig", varAsignar, null, id, null));
        jv.getCuarpeta().add(new Nodo("GOTO", null, null, etFor, jerarquia));
        segundoChequeoIf(jv, usoPila, pilaCuarpeta, pilaFalsas, jerarquia);
        manejo.agregarEtiquetaFin(jv, jerarquia);

    }

    public String buscarUltimoFor(ObjetosJAVA jv, int jerarquia) {
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

    /*------------------------------------------ INPUTS ----------------------------------------------------*/
    public void crearScanf(ObjetosJAVA jv, String id, String tipo) {
        if (tipo.equals("Integer")) {
            jv.getCuarpeta().add(new Nodo("SCANF", "%d", null, id, null));
        } else if (tipo.equals("Float")) {
            jv.getCuarpeta().add(new Nodo("SCANF", "%f", null, id, null));
        } else if (tipo.equals("Char")) {
            jv.getCuarpeta().add(new Nodo("SCANF", "%c", null, id, null));
        }
    }

    /*------------------------------------------- RETURNS ----------------------------------------------------*/
    public void crearReturn(ObjetosJAVA jv, String id) {
        String et = "t" + jv.getContVars();
        jv.setContVars(jv.getContVars() + 1);
        jv.getCuarpeta().add(new Nodo("asig", id, null, et, null));
    }

    /*------------------------------------------- MENSAJES ---------------------------------------------------*/
    public String concatenarMensaje(ObjetosJAVA jv, String ladoA, String ladoB) {
        String et = "t" + jv.getContVars();
        jv.setContVars(jv.getContVars() + 1);
        jv.getCuarpeta().add(new Nodo("asig", ladoA, ladoB, et, null));
        return et;
    }

    public void mostrarMensaje(ObjetosJAVA jv, String id) {
        jv.getCuarpeta().add(new Nodo("PRINT", null, null, id, null));
    }

}
