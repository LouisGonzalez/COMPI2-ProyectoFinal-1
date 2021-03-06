/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoCuartetos;

import Tablas.TablaSimbolos;
import cuartetos.Nodo;
import gramaticaPYTHON.SintaxPYTHON;
import java.util.ArrayList;
import manejoExe.ExePython;
import objetos.ObjetosPYTHON;
import objetosApoyo.NodoBoolean;
import verificaciones.VerifPY;

/**
 *
 * @author luisGonzalez
 */
public class ManejoPython {
    
    public String definirTemporal(TablaSimbolos tabla) {
        String t = "t" + tabla.getObPython().getContVars();
        tabla.getObPython().setContVars(tabla.getObPython().getContVars() + 1);
        return t;
    }
    
    public String definirEtiqueta2(ObjetosPYTHON jv) {
        int suma = jv.getContEt() + 1;
        jv.setContEt(suma);
        String et = "et_" + suma;
        return et;
    }
    
    public String ultimoGotoFinal(ObjetosPYTHON py, int jerarquia) {
        String nodo = null;
        for (int i = 0; i < py.getCuarpeta().size(); i++) {
            if (py.getCuarpeta().get(i).getOperacion().equals("GOTO")) {
                if (py.getCuarpeta().get(i).getNivel() == jerarquia) {
                    String[] arreglo = py.getCuarpeta().get(i).getVar().split("_");
                    if (arreglo[0].equals("etFin")) {
                        nodo = py.getCuarpeta().get(i).getVar();
                    }
                }
            }
        }
        return nodo;
    }
    
    public Integer ultimaEtiquetaFinal(ObjetosPYTHON py, int jerarquia) {
        Integer nodo = null;
        for (int i = 0; i < py.getCuarpeta().size(); i++) {
            if (py.getCuarpeta().get(i).getOperacion().equals("ETIQUETA")) {
                if (py.getCuarpeta().get(i).getNivel() == jerarquia) {
                    String[] arreglo = py.getCuarpeta().get(i).getDato1().toString().split("_");
                    if (arreglo[0].equals("etFin")) {
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
    
    /*------------------------------------------- LLAMADO A METODOS ---------------------------------------------*/

    public String devolverEtiquetaMetodo(TablaSimbolos tabla, String idMetodo, ArrayList<NodoBoolean> etiquetas, int linea){
        invocarMetodo(tabla, idMetodo, etiquetas, linea);
        String posReturn = buscarPosicionMemoria(tabla, "return", idMetodo);
        int posMemoria = determinarSizeAmbito(tabla, idMetodo);
        if(!posReturn.equals("")){
            String t = definirTemporal(tabla);
            tabla.getObPython().getCuarpeta().add(new Nodo("suma", "p", posMemoria, t, null));
            String t2 = definirTemporal(tabla);
            tabla.getObPython().getCuarpeta().add(new Nodo("suma", t, posReturn, t2, null));
            String t3 = definirTemporal(tabla);
            tabla.getObPython().getCuarpeta().add(new Nodo("asig", "stack[(int) "+t2+"]", null, t3, null));
            return t3;
        } else {
            return "";
        }
    }
    
    public void invocarMetodo(TablaSimbolos tabla, String idMetodo, ArrayList<NodoBoolean> etiquetas, int linea){
        pasoParametros(tabla, idMetodo, etiquetas);
        int posVar = determinarSizeAmbito(tabla, idMetodo);
        tabla.getObPython().getCuarpeta().add(new Nodo("suma", "p", posVar, "p", null));
        tabla.getObPython().getCuarpeta().add(new Nodo("CALL", "PY_"+idMetodo+"();", null, null, null));
        tabla.getObPython().getCuarpeta().add(new Nodo("resta", "p", posVar, "p", null));
    }
    
    public void pasoParametros(TablaSimbolos tabla, String ambito, ArrayList<NodoBoolean> etiquetas){
        int cont = 0;
        int posVar = determinarSizeAmbito(tabla, ambito);
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if(tabla.getTablaExe().get(i).getRol().equals("parametro") && tabla.getTablaExe().get(i).getAmbito().equals(ambito) && tabla.getTablaExe().get(i).getLenguaje().equals("PY")){
                if(!tabla.getTablaExe().get(i).isChequeado()){
                    String t = definirTemporal(tabla);
                    tabla.getObPython().getCuarpeta().add(new Nodo("suma", "p", posVar, t, null));
                    String t2 = definirTemporal(tabla);
                    tabla.getObPython().getCuarpeta().add(new Nodo("suma", t, tabla.getTablaExe().get(i).getPosMemoria(), t2, null));
                    tabla.getObPython().getCuarpeta().add(new Nodo("asig", etiquetas.get(cont).getId(), null, "stack[(int) "+t2+"]", null));
                    tabla.getTablaExe().get(i).setChequeado(true);
                    cont++;
                }
            }
        }
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            tabla.getTablaExe().get(i).setChequeado(false);
        }
    }
    
    public int determinarSizeAmbito(TablaSimbolos tabla, String ambito){
        int size = 0;
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if(tabla.getTablaExe().get(i).getId().equals(ambito) && tabla.getTablaExe().get(i).getLenguaje().equals("PY")){
                size = tabla.getTablaExe().get(i).getSize();
                break;
            }
        }
        return size;
    }
    
    
    
    /*------------------------------------------- METODOS -------------------------------------------------*/
    public void crearMetodo(ObjetosPYTHON py, String idMetodo, ArrayList<String> parametros, String retorno) {
        String nombre = "PY_" + idMetodo;
        py.getCuarpeta().add(new Nodo("CREACION_METODO", retorno, null, nombre, null));
    }
    
    public void finMetodo(ObjetosPYTHON py) {
        py.getCuarpeta().add(new Nodo("FIN_METODO", null, null, null, null));
    }

    /*--------------------------------------- MANEJO DE VARIABLES ----------------------------------------------*/
    public void agregarVariable(TablaSimbolos tabla, String idMetodo, String idVar, NodoBoolean valoresVar, int fila, int columna) {
        String t = definirTemporal(tabla);
        String valMemoria = buscarPosicionMemoria(tabla, idVar, idMetodo);
        tabla.getObPython().getCuarpeta().add(new Nodo("suma", "p", valMemoria, t, null));
        tabla.getObPython().getCuarpeta().add(new Nodo("asig", valoresVar.getId(), null, "stack[(int) " + t + "]", null));
        
    }
    
    public void asignacionesMultiples(ObjetosPYTHON py, ArrayList<String> identificadores, ArrayList<NodoBoolean> valores, int fila, int columna) {
        if (valores != null) {
            if (identificadores.size() == valores.size()) {
                for (int i = 0; i < identificadores.size(); i++) {
                    
                    py.getCuarpeta().add(new Nodo("asig", valores.get(i).getId(), null, identificadores.get(i), null));
                }
            }
        }
    }

    /*---------------------------------------- MANEJO DE PILA -------------------------------------------------*/
    
    public NodoBoolean devEtiquetaId(TablaSimbolos tabla, String idVar, String idMetodo, String tipo, boolean negativo){
        String t = definirTemporal(tabla);
        String valMemoria = buscarPosicionMemoria(tabla, idVar, idMetodo);
        tabla.getObPython().getCuarpeta().add(new Nodo("suma", "p", valMemoria, t, null));
        String t2 = definirTemporal(tabla);
        tabla.getObPython().getCuarpeta().add(new Nodo("asig", "stack[(int) "+t+"]", null, t2, null));
        if(negativo){
            t2 = "-"+t2;
        }
        return new NodoBoolean(tipo, t2);
    }
    
    public String buscarPosicionMemoria(TablaSimbolos tabla, String idVar, String idMetodo) {
        String valor = "";
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if (tabla.getTablaExe().get(i).getId().equals(idVar)) {
                if (tabla.getTablaExe().get(i).getAmbito().equals(idMetodo) && tabla.getTablaExe().get(i).getLenguaje().equals("PY")) {
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
                } catch (NumberFormatException ex) {
                    return true;
                }
            }
        }
    }

    /*---------------------------------------- MANEJO BOOLEANOS -------------------------------------------------*/
    public NodoBoolean concatenarOperacion(ObjetosPYTHON py, NodoBoolean ladoA, NodoBoolean ladoB, String tipoOp, int fila, int columna) {
        VerifPY verif = new VerifPY();
        String var = "t" + py.getContVars();
        py.setContVars(py.getContVars() + 1);
        py.getCuarpeta().add(new Nodo(tipoOp, ladoA.getId(), ladoB.getId(), var, null));
        if (!ladoA.getTipo().equals("") && !ladoB.getTipo().equals("")) {
            String tip = "";
            if(!ladoA.getTipo().equals("Metodo") && !ladoB.getTipo().equals("Metodo")){
                tip = verif.verificarTipoOperacion(py, ladoA.getTipo(), ladoB.getTipo(), fila, columna);
            } else {
                if(!ladoA.getTipo().equals("Metodo")){
                    tip = ladoA.getTipo();
                } else if(!ladoB.getTipo().equals("Metodo")){
                    tip = ladoB.getTipo();
                } else {
                    tip = "Float";
                }
            }
            return new NodoBoolean(tip, var);
        } else {
            return new NodoBoolean("", var);
        }
    }
    
    public ArrayList<Nodo> agregarBooleans(ObjetosPYTHON py, ArrayList<ArrayList<Nodo>> pilaFalsas, NodoBoolean ladoA, NodoBoolean ladoB, String op, int fila, int columna) {
        VerifPY verif = new VerifPY();
        ArrayList<Nodo> list = new ArrayList<>();
        if (ladoA != null && ladoB != null) {
            if (!ladoA.getTipo().equals("") && !ladoB.getTipo().equals("")) {
                if(!ladoA.getTipo().equals("Metodo") && !ladoB.getTipo().equals("Metodo")){
                    verif.verificarTipoOperacion(py, ladoA.getTipo(), ladoB.getTipo(), fila, columna);
                }
            }
            
            String et = definirEtiqueta2(py);
            list.add(new Nodo("IF " + op, ladoA.getId(), ladoB.getId(), et, SintaxPYTHON.jerarquia));
            int sum = py.getContEt() + 1;
            py.setContEt(sum);
            String et2 = "et_" + sum;
            SintaxPYTHON.aux2 = et2;
            list.add(new Nodo("GOTO", null, null, et2, SintaxPYTHON.jerarquia));
            pilaFalsas.get(pilaFalsas.size() - 1).add(new Nodo("ETIQUETA", et2, null, null, SintaxPYTHON.jerarquia));
            list.add(new Nodo("ETIQUETA", et, null, null, SintaxPYTHON.jerarquia));
        }
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

    /*---------------------------------------------- AND --------------------------------------------------------*/
    public ArrayList<Nodo> manejoAnd(ArrayList<Nodo> ladoA, ArrayList<Nodo> ladoB) {
        for (int i = 0; i < ladoB.size(); i++) {
            ladoA.add(ladoB.get(i));
        }
        return ladoA;
    }

    /*---------------------------------------------- OR --------------------------------------------------------*/
    public void manejoOr(ObjetosPYTHON py, ArrayList<Boolean> usoPila, ArrayList<ArrayList<Nodo>> pilaCuarpeta, ArrayList<Nodo> ladoA, ArrayList<Nodo> ladoB) {
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
            SintaxPYTHON.etInst = ladoA.get(ladoA.size() - 1).getDato1().toString();
            for (int i = 0; i < ladoA.size(); i++) {
                py.getCuarpeta().add(ladoA.get(i));
            }
            ladoB.add(new Nodo("GOTO", null, null, SintaxPYTHON.etInst, SintaxPYTHON.jerarquia));
            pilaCuarpeta.add(new ArrayList<>());
            usoPila.set(usoPila.size() - 1, true);
            pilaCuarpeta.get(pilaCuarpeta.size() - 1).add(new Nodo("ETIQUETA", ultimoGoto, null, null, SintaxPYTHON.jerarquia));
            for (int i = 0; i < ladoB.size(); i++) {
                pilaCuarpeta.get(pilaCuarpeta.size() - 1).add(ladoB.get(i));
            }
        }
    }

    /*-------------------------------------- IF ELSEIF ELSE -------------------------------------------------*/
    public void primerChequeoIf(ObjetosPYTHON py, ArrayList<Nodo> booleano) {
        if (!SintaxPYTHON.inst) {
            for (int i = 0; i < booleano.size(); i++) {
                py.getCuarpeta().add(booleano.get(i));
            }
        }
        SintaxPYTHON.inst = false;
        SintaxPYTHON.etInst = "";
    }
    
    public void segundoChequeoIf(ObjetosPYTHON py, ArrayList<Boolean> usoPila, ArrayList<ArrayList<Nodo>> pilaCuarpeta, ArrayList<ArrayList<Nodo>> pilaFalsas) {
        ManejoCondiciones manejo = new ManejoCondiciones();
        if (!pilaCuarpeta.isEmpty()) {
            if (usoPila.get(usoPila.size() - 1)) {
                manejo.eliminarEtiquetasPY(py, pilaCuarpeta.get(pilaCuarpeta.size() - 1), pilaFalsas.get(pilaFalsas.size() - 1));
                for (int i = 0; i < pilaFalsas.get(pilaFalsas.size() - 1).size(); i++) {
                    pilaCuarpeta.get(pilaCuarpeta.size() - 1).add(pilaFalsas.get(pilaFalsas.size() - 1).get(i));
                }
                for (int i = 0; i < pilaCuarpeta.get(pilaCuarpeta.size() - 1).size(); i++) {
                    py.getCuarpeta().add(pilaCuarpeta.get(pilaCuarpeta.size() - 1).get(i));
                }
                pilaCuarpeta.remove(pilaCuarpeta.size() - 1);
            } else {
                manejo.eliminarEtiquetasPY(py, null, pilaFalsas.get(pilaFalsas.size() - 1));
                for (int i = 0; i < pilaFalsas.get(pilaFalsas.size() - 1).size(); i++) {
                    py.getCuarpeta().add(pilaFalsas.get(pilaFalsas.size() - 1).get(i));
                }
            }
            usoPila.remove(usoPila.size() - 1);
        } else {
            manejo.eliminarEtiquetasPY(py, null, pilaFalsas.get(pilaFalsas.size() - 1));
            for (int i = 0; i < pilaFalsas.get(pilaFalsas.size() - 1).size(); i++) {
                py.getCuarpeta().add(pilaFalsas.get(pilaFalsas.size() - 1).get(i));
            }
        }
        pilaFalsas.remove(pilaFalsas.size() - 1);
    }

    /*------------------------------------------ WHILE ----------------------------------------------------*/
    
    public void agregarPreludioWhile(ObjetosPYTHON py){
        String etWhile = "etWhile_" + py.getContWhile();
        py.setContWhile(py.getContWhile() + 1);
        py.getCuarpeta().add(new Nodo("ETIQUETA", etWhile, null, null, SintaxPYTHON.jerarquia));
    }
    
    public void agregarWhile(ObjetosPYTHON py, ArrayList<Nodo> booleano) {
        primerChequeoIf(py, booleano);
    }
    
    public void retornoWhile(ObjetosPYTHON py, ArrayList<Boolean> usoPila, ArrayList<ArrayList<Nodo>> pilaCuarpeta, ArrayList<ArrayList<Nodo>> pilaFalsas) {
        ManejoCondiciones manejo = new ManejoCondiciones();
        String etWhile = buscarUltimoWhile(py, SintaxPYTHON.jerarquia);
        py.getCuarpeta().add(new Nodo("GOTO", null, null, etWhile, SintaxPYTHON.jerarquia));
        segundoChequeoIf(py, usoPila, pilaCuarpeta, pilaFalsas);
        manejo.agregarEtiquetaFinPY(py, SintaxPYTHON.jerarquia);
    }
    
    public String buscarUltimoWhile(ObjetosPYTHON jv, int jerarquia) {
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

    /*-------------------------------------------- FOR ----------------------------------------------------*/
 
    public void agregarFor(TablaSimbolos tabla, ArrayList<ArrayList<Nodo>> pilaFalsas, String id, String start, String stop, String idMetodo) {
        String t1 = definirTemporal(tabla);
        String posMemoria1 = buscarPosicionMemoria(tabla, id, idMetodo);
        tabla.getObPython().getCuarpeta().add(new Nodo("suma", "p", posMemoria1, t1, null));
        tabla.getObPython().getCuarpeta().add(new Nodo("asig", start, null, "stack[(int) "+t1+"]", null));
        

        String etFor = "etFor_" + tabla.getObPython().getContFor();
        tabla.getObPython().setContFor(tabla.getObPython().getContFor() + 1);
        tabla.getObPython().getCuarpeta().add(new Nodo("ETIQUETA", etFor, null, null, SintaxPYTHON.jerarquia));
        String et = definirEtiqueta2(tabla.getObPython());
        
        String t = definirTemporal(tabla);
        String posMemoria = buscarPosicionMemoria(tabla, id, idMetodo);
        tabla.getObPython().getCuarpeta().add(new Nodo("suma", "p", posMemoria, t, null));
        String t2 = definirTemporal(tabla);
        tabla.getObPython().getCuarpeta().add(new Nodo("asig", "stack[(int) "+t+"]", null, t2, null));

        tabla.getObPython().getCuarpeta().add(new Nodo("IF " + "<=", t2, stop, et, SintaxPYTHON.jerarquia));
        int sum = tabla.getObPython().getContEt() + 1;
        String et2 = "et_" + sum;
        tabla.getObPython().getCuarpeta().add(new Nodo("GOTO", null, null, et2, SintaxPYTHON.jerarquia));
        pilaFalsas.get(pilaFalsas.size() - 1).add(new Nodo("ETIQUETA", et2, null, null, SintaxPYTHON.jerarquia));
        tabla.getObPython().getCuarpeta().add(new Nodo("ETIQUETA", et, null, null, SintaxPYTHON.jerarquia));
        
    }
    
    public void retornoFor(ObjetosPYTHON py, ArrayList<Boolean> usoPila, ArrayList<ArrayList<Nodo>> pilaCuarpeta, ArrayList<ArrayList<Nodo>> pilaFalsas, ArrayList<ArrayList<Nodo>> pilaFor) {
        ManejoCondiciones manejo = new ManejoCondiciones();
        String etFor = buscarUltimoFor(py, SintaxPYTHON.jerarquia);
        for (int i = 0; i < pilaFor.get(pilaFor.size() - 1).size(); i++) {
            py.getCuarpeta().add(pilaFor.get(pilaFor.size() - 1).get(i));
        }
        pilaFor.remove(pilaFor.size() - 1);
        py.getCuarpeta().add(new Nodo("GOTO", null, null, etFor, SintaxPYTHON.jerarquia));
        segundoChequeoIf(py, usoPila, pilaCuarpeta, pilaFalsas);
        manejo.agregarEtiquetaFinPY(py, SintaxPYTHON.jerarquia);
    }
    
    public void agregarAuxPilaFor(TablaSimbolos tabla, ArrayList<ArrayList<Nodo>> pilaFor, String id, String varAsignar, boolean esNumero, String idMetodo) {
        if(!esNumero){
            String t = definirTemporal(tabla);
            String posMemoria = buscarPosicionMemoria(tabla, id, idMetodo);
            pilaFor.get(pilaFor.size()-1).add(new Nodo("suma", "p", posMemoria, t, null));
            String t2 = definirTemporal(tabla);
            String posMemoria2 = buscarPosicionMemoria(tabla, varAsignar, idMetodo);
            pilaFor.get(pilaFor.size()-1).add(new Nodo("suma", "p", posMemoria2, t2, null));
            String temp1 = definirTemporal(tabla);
            pilaFor.get(pilaFor.size()-1).add(new Nodo("suma", "stack[(int) "+t2+"]", "stack[(int) "+t+"]", temp1, null));
            pilaFor.get(pilaFor.size()-1).add(new Nodo("asig", temp1, null, "stack[(int) "+t2+"]", null));
        } else {
            String t = definirTemporal(tabla);
            pilaFor.get(pilaFor.size()-1).add(new Nodo("asig", id, null, t, null));
            String t2 = definirTemporal(tabla);
            String posMemoria2 = buscarPosicionMemoria(tabla, varAsignar, idMetodo);
            pilaFor.get(pilaFor.size()-1).add(new Nodo("suma", "p", posMemoria2, t2, null));
            String t3 = definirTemporal(tabla);
            pilaFor.get(pilaFor.size()-1).add(new Nodo("suma", t, "stack[(int) "+t2+"]", t3, null));
            pilaFor.get(pilaFor.size()-1).add(new Nodo("asig", t3, null, "stack[(int) "+t2+"]", null));
        }
    }
    
    public String buscarUltimoFor(ObjetosPYTHON vb, int jerarquia) {
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

    /*------------------------------------------ INPUTS ---------------------------------------------------*/
    public void crearScanf(TablaSimbolos tabla, String id, String tipo, String idMetodo) {
        String t = definirTemporal(tabla);
        if (tipo.equals("Integer")) {
            tabla.getObPython().getCuarpeta().add(new Nodo("SCANF", "\"%f\"", null, t, null));
        } else if (tipo.equals("Float")) {
            tabla.getObPython().getCuarpeta().add(new Nodo("SCANF", "\"%f\"", null, t, null));
        } else if (tipo.equals("Char")) {
            tabla.getObPython().getCuarpeta().add(new Nodo("SCANF", "\"%f\"", null, t, null));
        }
        String posMemoria = buscarPosicionMemoria(tabla, id, idMetodo);
        String t2 = definirTemporal(tabla);
        tabla.getObPython().getCuarpeta().add(new Nodo("suma", "p", posMemoria, t2, null));
        tabla.getObPython().getCuarpeta().add(new Nodo("asig", t, null, "stack[(int) "+t2+"]", null));
        
    }

    /*----------------------------------------- MENSAJES ---------------------------------------------------*/
    
    public void mostrarMensaje(ObjetosPYTHON py, String id, String mascara) {
        py.getCuarpeta().add(new Nodo("PRINT", mascara, null, id, null));
    }

    public String retornarEtiquetaId(TablaSimbolos tabla, String id, String idMetodo){
        String t = definirTemporal(tabla);
        String posMemoria = buscarPosicionMemoria(tabla, id, idMetodo);
        tabla.getObPython().getCuarpeta().add(new Nodo("suma", "p", posMemoria, t, null));
        String t2 = definirTemporal(tabla);
        tabla.getObPython().getCuarpeta().add(new Nodo("asig", "stack[(int) "+t+"]", null, t2, null));
        return t2;
    }
    
    public void mostrarQuiebre(TablaSimbolos tabla){
        tabla.getObPython().getCuarpeta().add(new Nodo("PRINT", null, null, "\"\\n\"",null));
    }
    
    /*------------------------------------------ RETURN ------------------------------------------------------*/
    public void agregarReturn(TablaSimbolos tabla, String id, String idMetodo) {
        String t = definirTemporal(tabla);
        String valMemoria = buscarPosicionMemoria(tabla, "return", idMetodo);
        tabla.getObPython().getCuarpeta().add(new Nodo("suma", "p", valMemoria, t, null));
        tabla.getObPython().getCuarpeta().add(new Nodo("asig", id, null, "stack[(int) " + t + "]", null));
        
    }
    
}
