/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoCuartetos;

import Tablas.TablaSimbolos;
import cuartetos.Nodo;
import gramaticaJAVA.SintaxJAVA;
import interfaz.PanelPrincipal;
import java.util.ArrayList;
import manejoExe.ExeJava;
import objetos.ObjetosJAVA;
import objetosApoyo.NodoBoolean;
import objetosApoyo.NodoHeap;
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

    public String definirTemporal(TablaSimbolos tabla) {
        String t = "t" + tabla.getObJava().getContVars();
        tabla.getObJava().setContVars(tabla.getObJava().getContVars() + 1);
        return t;
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

    /*------------------------------------- MANEJO DE PILA Y HEAP ----------------------------------------------*/
    public NodoHeap buscarPosicionMemoria(TablaSimbolos tabla, String idVar, String idMetodo, String idClase) {
        if (idMetodo.equals("")) {
            NodoHeap aDevolver = null;
            for (int i = 0; i < tabla.getTablaExe().size(); i++) {
                if (tabla.getTablaExe().get(i).getId().equals(idVar)) {
                    if (tabla.getTablaExe().get(i).getLenguaje().equals("JV") && tabla.getTablaExe().get(i).getAmbito().equals(idClase)) {
                        aDevolver = new NodoHeap(tabla.getTablaExe().get(i).getPosMemoria().toString(), false);
                        break;
                    }
                }
            }
            return aDevolver;
        } else {
            NodoHeap aDevolver = null;
            String ambito = idClase + "_" + idMetodo;
            boolean existe = false;
            for (int i = 0; i < tabla.getTablaExe().size(); i++) {
                if (tabla.getTablaExe().get(i).getId().equals(idVar)) {
                    if (tabla.getTablaExe().get(i).getAmbito().equals(ambito)) {
                        aDevolver = new NodoHeap(tabla.getTablaExe().get(i).getPosMemoria().toString(), true);
                        existe = true;
                        break;
                    }
                }
            }
            if (!existe) {
                for (int i = 0; i < tabla.getTablaExe().size(); i++) {
                    if (tabla.getTablaExe().get(i).getId().equals(idVar)) {
                        if (tabla.getTablaExe().get(i).getLenguaje().equals("JV") && tabla.getTablaExe().get(i).getAmbito().equals(idClase)) {
                            aDevolver = new NodoHeap(tabla.getTablaExe().get(i).getPosMemoria().toString(), false);
                            break;
                        }
                    }
                }
            }
            return aDevolver;
        }
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
                } catch (NumberFormatException ee) {
                    return true;
                }
            }
        }
    }

    /*----------------------------------------- LLAMADO A METODOS ------------------------------------------------*/
    public String devolverEtiquetaMetodo(TablaSimbolos tabla, String idMetodo, String idClase, ArrayList<NodoBoolean> etiquetas, int linea) {
        invocarMetodo(tabla, idMetodo, idClase, etiquetas, linea);
        String idTotal = encontrarIdMetodo(tabla, idMetodo, idClase);

        //CAMBIAR EL METODO BUSCARPOSICIONMEMORIA PARA QUE EL [PARAMETRO SEA UN NOMBRE UNICO
        NodoHeap posReturn = buscarPosicionMemoria(tabla, "return", idMetodo, idClase);
        int posMemoria = determinarSizeAmbito(tabla, idTotal);
        if (posReturn != null) {
            String t = definirTemporal(tabla);
            tabla.getObJava().getCuarpeta().add(new Nodo("suma", "p", posMemoria, t, null));
            String t2 = definirTemporal(tabla);
            tabla.getObJava().getCuarpeta().add(new Nodo("suma", t, posReturn.getPosMemoria(), t2, null));
            String t3 = definirTemporal(tabla);
            tabla.getObJava().getCuarpeta().add(new Nodo("asig", "stack[(int) " + t2 + "]", null, t3, null));
            System.out.println("A DONDE SI ENTRO ES AQUIC " + t3);
            return t3;
        } else {
            return "";
        }
    }

    public void invocarMetodo(TablaSimbolos tabla, String idMetodo, String idClase, ArrayList<NodoBoolean> etiquetas, int linea) {
        VerifJAVA verif = new VerifJAVA();
        ExeJava exe = new ExeJava();
        ManejoC manejoc = new ManejoC();
        String parametros = "";
        for (int i = 0; i < etiquetas.size(); i++) {
            if (i == 0) {
                parametros = etiquetas.get(i).getTipo();
            } else {
                parametros += "_" + etiquetas.get(i).getTipo();
            }
        }
        String[] arregloParam = parametros.split("_");
        String varTotal = manejoc.encontrarIdMetodo(tabla, idMetodo, idClase, "JV");
        if (verificarParametrosCorrectos(tabla, varTotal, arregloParam, verif, linea)) {
            //paso de parametros
            pasoParametros(tabla, varTotal, etiquetas, exe);
            //preparando this
            preparandoThis(tabla, varTotal);
            //invocando metodo
            int posVar = determinarSizeAmbito(tabla, varTotal);
            tabla.getObJava().getCuarpeta().add(new Nodo("suma", "p", posVar, "p", null));
            tabla.getObJava().getCuarpeta().add(new Nodo("CALL", "JV_" + varTotal + "();", null, null, null));
            tabla.getObJava().getCuarpeta().add(new Nodo("resta", "p", posVar, "p", null));
        }
    }

    public void pasoParametros(TablaSimbolos tabla, String ambito, ArrayList<NodoBoolean> etiquetas, ExeJava exe) {
        int cont = 0;
        int posVar = determinarSizeAmbito(tabla, ambito);
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if (tabla.getTablaExe().get(i).getRol().equals("parametro") && tabla.getTablaExe().get(i).getAmbito().equals(ambito) && tabla.getTablaExe().get(i).getLenguaje().equals("JV")) {
                if (!tabla.getTablaExe().get(i).isChequeado()) {
                    String t1 = definirTemporal(tabla);
                    tabla.getObJava().getCuarpeta().add(new Nodo("suma", "p", posVar, t1, null));
                    String t2 = definirTemporal(tabla);
                    tabla.getObJava().getCuarpeta().add(new Nodo("suma", t1, tabla.getTablaExe().get(i).getPosMemoria(), t2, null));
                    tabla.getObJava().getCuarpeta().add(new Nodo("asig", etiquetas.get(cont).getId(), null, "stack[(int) " + t2 + "]", null));
                    tabla.getTablaExe().get(i).setChequeado(true);
                    cont++;
                }
            }
        }
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            tabla.getTablaExe().get(i).setChequeado(false);
        }
    }

    public void preparandoThis(TablaSimbolos tabla, String ambito) {
        int posVar = determinarSizeAmbito(tabla, ambito);
        String t = definirTemporal(tabla);
        tabla.getObJava().getCuarpeta().add(new Nodo("suma", "p", 0, t, null));
        String t2 = definirTemporal(tabla);
        tabla.getObJava().getCuarpeta().add(new Nodo("asig", "stack[(int) " + t + "]", null, t2, null));
        String t3 = definirTemporal(tabla);
        tabla.getObJava().getCuarpeta().add(new Nodo("suma", "p", posVar, t3, posVar));
        String t4 = definirTemporal(tabla);
        tabla.getObJava().getCuarpeta().add(new Nodo("suma", t3, 0, t4, null));
        tabla.getObJava().getCuarpeta().add(new Nodo("asig", t2, null, "stack[(int) " + t4 + "]", null));
    }

    public boolean verificarParametrosCorrectos(TablaSimbolos tabla, String id, String[] arregloParam, VerifJAVA verif, int linea) {
        boolean todoCorrecto = true;
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if (tabla.getTablaExe().get(i).getRol().equals("metodo") && tabla.getTablaExe().get(i).getId().equals(id) && tabla.getTablaExe().get(i).getLenguaje().equals("JV")) {
                if (!tabla.getTablaExe().get(i).getListParametros().equals("")) {
                    String[] arregloParam2 = tabla.getTablaExe().get(i).getListParametros().split("_");
                    if (arregloParam2.length == arregloParam.length) {
                        for (int j = 0; j < arregloParam.length; j++) {
                            if (!arregloParam[j].equals(arregloParam2[j])) {
                                if (!verif.verificarPadreVar(tabla.getObJava(), arregloParam[j], arregloParam2[j])) {
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

    public String encontrarIdMetodo(TablaSimbolos tabla, String idMetodo, String idClase) {
        String id = idClase + "_" + idMetodo;
        String aDevolver = "";
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if (tabla.getTablaExe().get(i).getRol().equals("metodo") && tabla.getTablaExe().get(i).getLenguaje().equals("JV")) {
                String[] arreglo = tabla.getTablaExe().get(i).getId().split("_");
                String id2 = arreglo[0] + "_" + arreglo[1];
                if (id.equals(id2)) {
                    aDevolver = tabla.getTablaExe().get(i).getId();
                    break;
                }
            }
        }
        return aDevolver;
    }

    public int determinarSizeAmbito(TablaSimbolos tabla, String ambito) {
        int size = 0;
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if (tabla.getTablaExe().get(i).getId().equals(ambito) && tabla.getTablaExe().get(i).getLenguaje().equals("JV")) {
                size = tabla.getTablaExe().get(i).getSize();
                break;
            }
        }
        return size;
    }

    /*---------------------------------------- ASIGNACION VARIABLES------------------------------------------*/
    public void agregarValVariable(TablaSimbolos tabla, String idVar, String et, String idMetodo, String idClase, int jerarquia) {
        NodoHeap posible = buscarPosicionMemoria(tabla, idVar, idMetodo, idClase);
        if (posible != null) {
            if (posible.getEnMetodo()) {
                String t = definirTemporal(tabla);
                tabla.getObJava().getCuarpeta().add(new Nodo("suma", "p", posible.getPosMemoria(), t, null));
                tabla.getObJava().getCuarpeta().add(new Nodo("asig", et, null, "stack[(int) " + t + "]", null));
            } else {
                if (jerarquia == 0) {
                    String t = definirTemporal(tabla);
                    tabla.getObJava().getAuxiliar().add(new Nodo("suma", "p", "0", t, null));
                    String t2 = definirTemporal(tabla);
                    tabla.getObJava().getAuxiliar().add(new Nodo("asig", "stack[(int) " + t + "]", null, t2, null));
                    String t3 = definirTemporal(tabla);
                    tabla.getObJava().getAuxiliar().add(new Nodo("suma", t2, posible.getPosMemoria(), t3, null));
                    tabla.getObJava().getAuxiliar().add(new Nodo("asig", et, null, "heap[(int) " + t3 + "]", null));
                } else {
                    String t = definirTemporal(tabla);
                    tabla.getObJava().getCuarpeta().add(new Nodo("suma", "p", "0", t, null));
                    String t2 = definirTemporal(tabla);
                    tabla.getObJava().getCuarpeta().add(new Nodo("asig", "stack[(int) " + t + "]", null, t2, null));
                    String t3 = definirTemporal(tabla);
                    tabla.getObJava().getCuarpeta().add(new Nodo("suma", t2, posible.getPosMemoria(), t3, null));
                    tabla.getObJava().getCuarpeta().add(new Nodo("asig", et, null, "heap[(int) " + t3 + "]", null));

                }
            }
        }
    }

    //se usa en el caso this
    public void agregarValVariable2(TablaSimbolos tabla, String idVar, String et, String idMetodo, String idClase) {
        NodoHeap posible = buscarPosicionMemoria(tabla, idVar, "", idClase);
        if (posible != null) {
            if (!posible.getEnMetodo()) {
                String t = definirTemporal(tabla);
                tabla.getObJava().getCuarpeta().add(new Nodo("suma", "p", "0", t, null));
                String t2 = definirTemporal(tabla);
                tabla.getObJava().getCuarpeta().add(new Nodo("asig", "stack[(int) " + t + "]", null, t2, null));
                String t3 = definirTemporal(tabla);
                tabla.getObJava().getCuarpeta().add(new Nodo("suma", t2, posible.getPosMemoria(), t3, null));
                tabla.getObJava().getCuarpeta().add(new Nodo("asig", et, null, "heap[(int) " + t3 + "]", null));
            }
        }
    }

    public String agregarOperacion(TablaSimbolos tabla, String ladoA, String ladoB, String tipo) {
        String t = definirTemporal(tabla);
        tabla.getObJava().getCuarpeta().add(new Nodo(tipo, ladoA, ladoB, t, null));
        return t;
    }

    public String etiquetaId(TablaSimbolos tabla, String idVar, String idMetodo, String idClase) {
        String aDevolver = "";
        NodoHeap posible = buscarPosicionMemoria(tabla, idVar, idMetodo, idClase);
        if (posible != null) {
            if (posible.getEnMetodo()) {
                String t = definirTemporal(tabla);
                tabla.getObJava().getCuarpeta().add(new Nodo("suma", "p", posible.getPosMemoria(), t, null));
                aDevolver = definirTemporal(tabla);
                tabla.getObJava().getCuarpeta().add(new Nodo("asig", "stack[(int) " + t + "]", null, aDevolver, null));
            } else {
                String t = definirTemporal(tabla);
                tabla.getObJava().getCuarpeta().add(new Nodo("suma", "p", 0, t, null));
                String t2 = definirTemporal(tabla);
                tabla.getObJava().getCuarpeta().add(new Nodo("asig", "stack[(int) " + t + "]", null, t2, null));
                String t3 = definirTemporal(tabla);
                tabla.getObJava().getCuarpeta().add(new Nodo("suma", t2, posible.getPosMemoria(), t3, null));
                aDevolver = definirTemporal(tabla);
                tabla.getObJava().getCuarpeta().add(new Nodo("asig", "heap[(int) " + t3 + "]", null, aDevolver, null));
            }
        }
        return aDevolver;
    }

    public String agregarOperacionFor(TablaSimbolos tabla, ArrayList<ArrayList<Nodo>> pilaFor, String ladoA, String ladoB, String tipo) {
        String t = definirTemporal(tabla);
        pilaFor.get(pilaFor.size() - 1).add(new Nodo(tipo, ladoA, ladoB, t, null));
        return t;
    }

    /*---------------------------------------- METODOS -----------------------------------------------------*/
    public void crearMetodo(ObjetosJAVA jv, String idMetodo, String parametros, String tipo) {
        String idClase = jv.getMisClases().get(jv.getMisClases().size() - 1).getId();
        String nombre;
        if (parametros.equals("")) {
            nombre = "JV_" + idClase + "_" + idMetodo;
        } else {
            nombre = "JV_" + idClase + "_" + idMetodo + "_" + parametros;
        }
        jv.getCuarpeta().add(new Nodo("CREACION_METODO", tipo, null, nombre, null));
    }

    public void finMetodo(ObjetosJAVA jv) {
        jv.getCuarpeta().add(new Nodo("FIN_METODO", null, null, null, null));
    }

    /*-------------------------------------------- CONSTRUCTOR ----------------------------------------------------*/
    public void constructorPorDefecto(TablaSimbolos tabla, String idClase) {
        ExeJava exe = new ExeJava();
        String idConstructor = idClase + "_" + idClase;
        boolean existe = false;
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if (tabla.getTablaExe().get(i).getId().equals(idConstructor) && tabla.getTablaExe().get(i).getRol().equals("constructor") && tabla.getTablaExe().get(i).getLenguaje().equals("JV")) {
                existe = true;
                break;
            }
        }
        if (!existe) {
            exe.agregarConstructor(tabla, idClase);
            crearMetodo(tabla.getObJava(), idClase, "", "void");
            inicializarThis(tabla, idClase, idClase);
            finMetodo(tabla.getObJava());
        }
    }

    public void inicializarThis(TablaSimbolos tabla, String idMetodo, String idClase) {
        String t = definirTemporal(tabla);
        NodoHeap posMemoria = buscarPosicionMemoria(tabla, "this", idMetodo, idClase);
        tabla.getObJava().getCuarpeta().add(new Nodo("suma", "p", posMemoria.getPosMemoria(), t, null));
        tabla.getObJava().getCuarpeta().add(new Nodo("asig", "h", null, "stack[(int) " + t + "]", null));
        tabla.getObJava().getCuarpeta().add(new Nodo("suma", "h", "VALOR_CLASE_" + idClase, "h", null));
        for (int i = 0; i < tabla.getObJava().getAuxiliar().size(); i++) {
            tabla.getObJava().getCuarpeta().add(tabla.getObJava().getAuxiliar().get(i));
        }
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

    /*------------------------------------ MANEJO BOOLEANOS ---------------------------------------------------*/
    public NodoBoolean concatenarOperacion(TablaSimbolos tabla, NodoBoolean ladoA, NodoBoolean ladoB, String tipoOp) {
        VerifJAVA verif = new VerifJAVA();
        String t = definirTemporal(tabla);
        if (!ladoA.getTipo().equals("") && !ladoB.getTipo().equals("")) {
            String tip = verif.verificarTipoOperacion(tabla.getObJava(), ladoA.getTipo(), ladoB.getTipo());
            tabla.getObJava().getCuarpeta().add(new Nodo(tipoOp, ladoA.getId(), ladoB.getId(), t, null));
            return new NodoBoolean(tip, t);
        } else {
            tabla.getObJava().getCuarpeta().add(new Nodo(tipoOp, ladoA.getId(), ladoB.getId(), t, null));
            return new NodoBoolean("", t);
        }
    }

    public NodoBoolean devEtiquetaId(TablaSimbolos tabla, String idVar, String tipo, String idMetodo, String idClase, boolean negativo) {
        NodoHeap posible = buscarPosicionMemoria(tabla, idVar, idMetodo, idClase);
        if (posible != null) {
            if (posible.getEnMetodo()) {
                String t = definirTemporal(tabla);
                tabla.getObJava().getCuarpeta().add(new Nodo("suma", "p", posible.getPosMemoria(), t, null));
                String t2 = definirTemporal(tabla);
                tabla.getObJava().getCuarpeta().add(new Nodo("asig", "stack[(int) " + t + "]", null, t2, null));
                if (negativo) {
                    t2 = "-" + t2;
                }
                return new NodoBoolean(tipo, t2);
            } else {
                String t = definirTemporal(tabla);
                tabla.getObJava().getCuarpeta().add(new Nodo("suma", "p", "0", t, null));
                String t2 = definirTemporal(tabla);
                tabla.getObJava().getCuarpeta().add(new Nodo("asig", "stack[(int) " + t + "]", null, t2, null));
                String t3 = definirTemporal(tabla);
                tabla.getObJava().getCuarpeta().add(new Nodo("suma", t2, posible.getPosMemoria(), t3, null));
                String t4 = definirTemporal(tabla);
                tabla.getObJava().getCuarpeta().add(new Nodo("asig", "heap[(int) " + t3 + "]", null, t4, null));
                if (negativo) {
                    t4 = "-" + t4;
                }
                return new NodoBoolean(tipo, t4);
            }
        } else {
            return new NodoBoolean("", "");
        }
    }

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

    /*---------------------------------------IF - ELSEIF - ELSE-----------------------------------------*/
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
    public void agregarPreludioWhile(ObjetosJAVA jv, int jerarquia) {
        String etWhile = "etWhile_" + jv.getContWhile();
        jv.setContWhile(jv.getContWhile() + 1);
        jv.getCuarpeta().add(new Nodo("ETIQUETA", etWhile, null, null, jerarquia));

    }

    public void agregarWhile(ObjetosJAVA jv, ArrayList<Nodo> booleano, int jerarquia) {
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
        jv.getCuarpeta().add(new Nodo("GOTO", null, null, etWhile, jerarquia));
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

    public String devolverVarSwitch(TablaSimbolos tabla, String idVar, String idMetodo, String idClase) {
        String aDevolver = "";
        NodoHeap posible = buscarPosicionMemoria(tabla, idVar, idMetodo, idClase);
        if (posible != null) {
            if (posible.getEnMetodo()) {
                String t = definirTemporal(tabla);
                tabla.getObJava().getCuarpeta().add(new Nodo("suma", "p", posible.getPosMemoria(), t, null));
                aDevolver = definirTemporal(tabla);
                tabla.getObJava().getCuarpeta().add(new Nodo("asig", "stack[(int) " + t + "]", null, aDevolver, null));
            } else {
                String t = definirTemporal(tabla);
                tabla.getObJava().getCuarpeta().add(new Nodo("suma", "p", "0", t, null));
                String t2 = definirTemporal(tabla);
                tabla.getObJava().getCuarpeta().add(new Nodo("asig", "stack[(int) " + t + "]", null, t2, null));
                String t3 = definirTemporal(tabla);
                tabla.getObJava().getCuarpeta().add(new Nodo("suma", t2, posible.getPosMemoria(), t3, null));
                aDevolver = definirTemporal(tabla);
                tabla.getObJava().getCuarpeta().add(new Nodo("asig", "heap[(int) " + t3 + "]", null, aDevolver, null));
            }
        }
        return aDevolver;
    }

    public void agregarFinCase(ObjetosJAVA jv, ArrayList<String> arrayFinales, int jerarquia) {
        jv.getCuarpeta().add(new Nodo("GOTO", null, null, arrayFinales.get(arrayFinales.size() - 1), jerarquia));
        String et = obtenerUltimoGoTo(jv.getCuarpeta(), jerarquia);
        jv.getCuarpeta().add(new Nodo("ETIQUETA", et, null, null, jerarquia));

    }

    /*-------------------------------------------- FOR ----------------------------------------------------------*/
    public void agregarPreludioFor(TablaSimbolos tabla, String id1, String valId1, int jerarquia, String idMetodo, String idClase) {
        NodoHeap posible = buscarPosicionMemoria(tabla, id1, idMetodo, idClase);
        if (posible != null) {
            if (posible.getEnMetodo()) {
                String t = definirTemporal(tabla);
                tabla.getObJava().getCuarpeta().add(new Nodo("suma", "p", posible.getPosMemoria(), t, null));
                tabla.getObJava().getCuarpeta().add(new Nodo("asig", valId1, null, "stack[(int) " + t + "]", null));
            } else {

                //ARREGLAR ESTO
                String t = definirTemporal(tabla);
                tabla.getObJava().getCuarpeta().add(new Nodo("suma", "h", posible.getPosMemoria(), t, null));
                tabla.getObJava().getCuarpeta().add(new Nodo("asig", valId1, null, "heap[(int) " + t + "]", null));
            }
        }
        String etFor = "etFor_" + tabla.getObJava().getContFor();
        tabla.getObJava().setContFor(tabla.getObJava().getContFor() + 1);
        tabla.getObJava().getCuarpeta().add(new Nodo("ETIQUETA", etFor, null, null, jerarquia));
    }

    public void agregarFor(TablaSimbolos tabla, String id1, String valId1, ArrayList<Nodo> booolean, int jerarquia, String idMetodo, String idClase) {
        primerChequeoIf(tabla.getObJava(), booolean);
    }

    public void retornoFor(TablaSimbolos tabla, ArrayList<Boolean> usoPila, ArrayList<ArrayList<Nodo>> pilaFor, String id, ArrayList<ArrayList<Nodo>> pilaCuarpeta, ArrayList<ArrayList<Nodo>> pilaFalsas, String varAsignar, int jerarquia, String idMetodo, String idClase) {
        ManejoCondiciones manejo = new ManejoCondiciones();
        String etFor = buscarUltimoFor(tabla.getObJava(), jerarquia);
        for (int i = 0; i < pilaFor.get(pilaFor.size() - 1).size(); i++) {
            tabla.getObJava().getCuarpeta().add(pilaFor.get(pilaFor.size() - 1).get(i));
        }
        pilaFor.remove(pilaFor.size() - 1);
        NodoHeap posible = buscarPosicionMemoria(tabla, id, idMetodo, idClase);
        if (posible != null) {
            if (posible.getEnMetodo()) {
                String t = definirTemporal(tabla);
                tabla.getObJava().getCuarpeta().add(new Nodo("suma", "p", posible.getPosMemoria(), t, null));
                tabla.getObJava().getCuarpeta().add(new Nodo("asig", varAsignar, null, "stack[(int) " + t + "]", null));
            } else {
                String t = definirTemporal(tabla);
                tabla.getObJava().getCuarpeta().add(new Nodo("suma", "p", "0", t, null));
                String t2 = definirTemporal(tabla);
                tabla.getObJava().getCuarpeta().add(new Nodo("asig", "stack[(int) " + t + "]", null, t2, null));
                String t3 = definirTemporal(tabla);
                tabla.getObJava().getCuarpeta().add(new Nodo("suma", t2, posible.getPosMemoria(), t3, null));
                tabla.getObJava().getCuarpeta().add(new Nodo("asig", varAsignar, null, "heap[(int) " + t3 + "]", null));
            }
        }
        tabla.getObJava().getCuarpeta().add(new Nodo("GOTO", null, null, etFor, jerarquia));
        segundoChequeoIf(tabla.getObJava(), usoPila, pilaCuarpeta, pilaFalsas, jerarquia);
        manejo.agregarEtiquetaFin(tabla.getObJava(), jerarquia);

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
    public void crearScanf(TablaSimbolos tabla, String id, String tipo, String idMetodo, String idClase) {
        String temp = "";
        if (tipo.equals("Integer")) {
            temp = definirTemporal(tabla);
            tabla.getObJava().getCuarpeta().add(new Nodo("SCANF", "\"%f\"", null, temp, null));
        } else if (tipo.equals("Float")) {
            temp = definirTemporal(tabla);
            tabla.getObJava().getCuarpeta().add(new Nodo("SCANF", "\"%f\"", null, temp, null));
        } else if (tipo.equals("Char")) {
            temp = definirTemporal(tabla);
            tabla.getObJava().getCuarpeta().add(new Nodo("SCANF", "\"%f\"", null, temp, null));
        }
        NodoHeap posible = buscarPosicionMemoria(tabla, id, idMetodo, idClase);
        if (posible != null) {
            if (posible.getEnMetodo()) {
                String t = definirTemporal(tabla);
                tabla.getObJava().getCuarpeta().add(new Nodo("suma", "p", posible.getPosMemoria(), t, null));
                tabla.getObJava().getCuarpeta().add(new Nodo("asig", temp, null, "stack[(int) " + t + "]", null));
            } else {
                String t = definirTemporal(tabla);
                tabla.getObJava().getCuarpeta().add(new Nodo("suma", "p", 0, t, null));
                String t2 = definirTemporal(tabla);
                tabla.getObJava().getCuarpeta().add(new Nodo("asig", "stack[(int) " + t + "]", null, t2, null));
                String t3 = definirTemporal(tabla);
                tabla.getObJava().getCuarpeta().add(new Nodo("suma", t2, posible.getPosMemoria(), t3, null));
                tabla.getObJava().getCuarpeta().add(new Nodo("asig", temp, null, "heap[(int) " + t3 + "]", null));
            }
        }

    }

    /*------------------------------------------- RETURNS ----------------------------------------------------*/
    public void crearReturn(TablaSimbolos tabla, String id, String idMetodo, String idClase) {
        NodoHeap posible = buscarPosicionMemoria(tabla, "return", idMetodo, idClase);
        if (posible != null) {
            if (posible.getEnMetodo()) {
                String t2 = definirTemporal(tabla);
                tabla.getObJava().getCuarpeta().add(new Nodo("suma", "p", posible.getPosMemoria(), t2, null));
                tabla.getObJava().getCuarpeta().add(new Nodo("asig", id, null, "stack[(int) " + t2 + "]", null));
            }
        }
    }

    /*------------------------------------------- MENSAJES ---------------------------------------------------*/
    public void mostrarMensaje(ObjetosJAVA jv, String id, String mascara) {
        jv.getCuarpeta().add(new Nodo("PRINT", mascara, null, id, null));
    }

    public void mostrarQuiebre(TablaSimbolos tabla) {
        tabla.getObJava().getCuarpeta().add(new Nodo("PRINT", null, null, "\"\\n\"", null));
    }

}
