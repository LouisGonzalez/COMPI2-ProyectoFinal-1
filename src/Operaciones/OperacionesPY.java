/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import cuartetos.Nodo;
import gramaticaJAVA.sym;
import gramaticaPYTHON.SintaxPYTHON;
import interfaz.PanelPrincipal;
import java.util.ArrayList;
import manejoCuartetos.ManejoCondiciones;
import manejoCuartetos.ManejoPython;
import objetos.Metodo;
import objetos.ObjetosPYTHON;
import objetos.Parametro;
import objetos.Variable;
import objetosApoyo.NodoBoolean;
import verificaciones.VerifPY;

/**
 *
 * @author luisGonzalez
 */
public class OperacionesPY {

    public void verificarTabs(int columna, ObjetosPYTHON py, ArrayList<ArrayList<Nodo>> pilaFor, ArrayList<Boolean> usoPila, ArrayList<ArrayList<Nodo>> pilaCuarpeta, ArrayList<ArrayList<Nodo>> pilaFalsas, ArrayList<Integer> instrucciones, ArrayList<Integer> lineasGuias, int tabsLinea, boolean instruccion, ArrayList<String> tipoInstruccion) {
        ManejoCondiciones manejo = new ManejoCondiciones();
        ManejoPython manejoPY = new ManejoPython();
        //Significa que somos la primer linea luego de una instruccion
        if (!SintaxPYTHON.primerLinea) {
            lineasGuias.add(tabsLinea);
            SintaxPYTHON.primerLinea = true;
        } else {
            if (tabsLinea > lineasGuias.get(lineasGuias.size() - 1)) {
                System.out.println("ERROR");
            } else if (tabsLinea < lineasGuias.get(lineasGuias.size() - 1)) {
                lineasGuias.remove(lineasGuias.size() - 1);
                Integer iterador = null;
                for (int i = instrucciones.size() - 1; i >= 0; i--) {
                    /*AQUI DEBE IR LA SEGUNDA PARTE DE LAS CONDICIONALES: IF - FOR - WHILE */
                    if (!tipoInstruccion.isEmpty()) {
                        if (tipoInstruccion.get(tipoInstruccion.size() - 1).equals("IF")) {
                            if (manejoPY.ultimaEtiquetaFinal(py, SintaxPYTHON.jerarquia) != null) {
                                int nodo = manejoPY.ultimaEtiquetaFinal(py, SintaxPYTHON.jerarquia);
                                //   py.getCuarpeta().remove(nodo);
                                //   py.setContEtFin(py.getContEtFin() - 1);
                            }
                            manejo.irEtiquetaFinPY(py, SintaxPYTHON.jerarquia);
                            manejoPY.segundoChequeoIf(py, usoPila, pilaCuarpeta, pilaFalsas);
                            manejo.agregarEtiquetaFinPY(py, SintaxPYTHON.jerarquia);
                        } else if (tipoInstruccion.get(tipoInstruccion.size() - 1).equals("ELSEIF")) {
                            if (manejoPY.ultimaEtiquetaFinal(py, SintaxPYTHON.jerarquia) != null) {
                                int nodo = manejoPY.ultimaEtiquetaFinal(py, SintaxPYTHON.jerarquia);
                                py.getCuarpeta().remove(nodo);
                                py.setContEtFin(py.getContEtFin() - 1);
                            }
                            String et = manejoPY.ultimoGotoFinal(py, SintaxPYTHON.jerarquia);
                            manejo.irEtiquetaFinPY2(py, SintaxPYTHON.jerarquia, et);
                            manejoPY.segundoChequeoIf(py, usoPila, pilaCuarpeta, pilaFalsas);
                            manejo.agregarEtiquetaFinPY2(py, SintaxPYTHON.jerarquia, et);
                        } else if (tipoInstruccion.get(tipoInstruccion.size() - 1).equals("ELSE")) {
                            if (manejoPY.ultimaEtiquetaFinal(py, SintaxPYTHON.jerarquia) != null) {
                                int nodo = manejoPY.ultimaEtiquetaFinal(py, SintaxPYTHON.jerarquia);
                                py.getCuarpeta().remove(nodo);
                                py.setContEtFin(py.getContEtFin() - 1);
                            }
                            String et = manejoPY.ultimoGotoFinal(py, SintaxPYTHON.jerarquia);
                            manejo.irEtiquetaFinPY2(py, SintaxPYTHON.jerarquia, et);
                            manejo.agregarEtiquetaFinPY2(py, SintaxPYTHON.jerarquia, et);
                        } else if (tipoInstruccion.get(tipoInstruccion.size() - 1).equals("WHILE")) {
                            manejoPY.retornoWhile(py, usoPila, pilaCuarpeta, pilaFalsas);
                        } else if (tipoInstruccion.get(tipoInstruccion.size() - 1).equals("FOR")) {
                            System.out.println("ENTRO AQUI DEBIDO AL FOR MIS PANAS");
                            manejoPY.retornoFor(py, usoPila, pilaCuarpeta, pilaFalsas, pilaFor);
                        }
                        System.out.println(tipoInstruccion.get(tipoInstruccion.size() - 1) + "      " + tipoInstruccion.size());
                        tipoInstruccion.remove(tipoInstruccion.size() - 1);
                    }

                    eliminarVarAmbitos(py, SintaxPYTHON.jerarquia);
                    SintaxPYTHON.jerarquia--;
                    if (tabsLinea == instrucciones.get(i)) {
                        iterador = i;
                        break;
                    } else if (tabsLinea > instrucciones.get(i)) {
                        PanelPrincipal.errores += "Columna: "+columna+" Tipo de error: SEMANTICO - Causa: Error en manejo de identado.\n";
                        break;
                    }
                }
                if (iterador != null) {
                    for (int i = instrucciones.size() - 1; i >= iterador; i--) {
                      instrucciones.remove(i);
                    }
                }

            }
        }
        if (instruccion) {
            instrucciones.add(tabsLinea);
            SintaxPYTHON.jerarquia++;
            SintaxPYTHON.primerLinea = false;
        }
    }

    //elimina todas las variables de un ambito
    public void eliminarVarAmbitos(ObjetosPYTHON py, int jerarquia) {
        if (jerarquia > 1) {
            int itMetodo = py.getMisMetodos().size() - 1;
            for (int i = 0; i < py.getMisMetodos().get(itMetodo).getMisVariables().size(); i++) {
                if (py.getMisMetodos().get(itMetodo).getMisVariables().get(i).getNivel() == jerarquia) {
                    py.getMisMetodos().get(itMetodo).getMisVariables().remove(i);
                    i--;
                }
            }
            for (int i = 0; i < py.getMisMetodos().get(itMetodo).getMisVariables().size(); i++) {
                for (int j = 0; j < py.getMisMetodos().get(itMetodo).getMisVariables().get(i).getListAsignaciones().size(); j++) {
                    if (py.getMisMetodos().get(itMetodo).getMisVariables().get(i).getListAsignaciones().get(j) == jerarquia) {
                        py.getMisMetodos().get(itMetodo).getMisVariables().get(i).getListAsignaciones().remove(j);
                        j--;
                    }
                }
            }
            for (int i = 0; i < py.getMisMetodos().get(itMetodo).getMisVariables().size(); i++) {
                if (py.getMisMetodos().get(itMetodo).getMisVariables().get(i).getListAsignaciones().isEmpty()) {
                    py.getMisMetodos().get(itMetodo).getMisVariables().get(i).setValor(false);
                }
            }
        }
    }

    //verifica si una variable ya existe dentro del archivo
    public boolean asignarVariables(ObjetosPYTHON py, String id, String tipo, int fila, int columna) {
        boolean existe = false;
        if (!tipo.equals("")) {
            VerifPY verif = new VerifPY();
            if (verif.verifVarLocal(py, id)) {
                existe = true;
                py.getMisMetodos().get(py.getMisMetodos().size() - 1).getMisVariables().get(VerifPY.iteradorVar).getListAsignaciones().add(SintaxPYTHON.jerarquia);
                py.getMisMetodos().get(py.getMisMetodos().size() - 1).getMisVariables().get(VerifPY.iteradorVar).setValor(true);
                py.getMisMetodos().get(py.getMisMetodos().size() - 1).getMisVariables().get(VerifPY.iteradorVar).setTipo(tipo);
            } else {
                //si no existe agrega la variable a las variables del metodo    
                py.getMisMetodos().get(py.getMisMetodos().size() - 1).getMisVariables().add(new Variable(id, tipo, true, SintaxPYTHON.jerarquia));
                py.getMisMetodos().get(py.getMisMetodos().size() - 1).getMisVariables().get(py.getMisMetodos().get(py.getMisMetodos().size() - 1).getMisVariables().size() - 1).getListAsignaciones().add(SintaxPYTHON.jerarquia);
            }
            //}
        } else {
            PanelPrincipal.errores += "Fila: "+fila+" Columna: "+columna+" Tipo de error: SEMANTICO - Causa: Error de asignacion en posible variable: "+id+"\n";
       }
        return existe;
    }

    //metodo para las asignaciones de tipo: a,b,c = 1,2,3
    public void asignacionesMultiples(ObjetosPYTHON py, ArrayList<String> identificadores, ArrayList<NodoBoolean> tipos, int jerarquia, int fila, int columna) {
        if (tipos != null) {
            VerifPY verif = new VerifPY();
            if (identificadores.size() == tipos.size()) {
                System.out.println(jerarquia + "      ===");
                for (int i = 0; i < identificadores.size(); i++) {
                    if (jerarquia == 0) {
                        if (verif.verifVarGlobal(py, identificadores.get(i))) {
                            py.getGlobales().get(VerifPY.iteradorVar).getListAsignaciones().add(jerarquia);
                            py.getGlobales().get(VerifPY.iteradorVar).setTipo(tipos.get(i).getTipo());
                            py.getGlobales().get(VerifPY.iteradorVar).setValor(true);
                        } else {
                            py.getGlobales().add(new Variable(identificadores.get(i), tipos.get(i).getTipo(), true, jerarquia));
                            py.getGlobales().get(py.getGlobales().size() - 1).getListAsignaciones().add(jerarquia);
                            py.getGlobales().get(py.getGlobales().size() - 1).setValor(true);
                        }
                    } else {
                        int itMetodo = py.getMisMetodos().size() - 1;
                        if (verif.verifVarLocal(py, identificadores.get(i))) {
                            py.getMisMetodos().get(itMetodo).getMisVariables().get(VerifPY.iteradorVar).getListAsignaciones().add(jerarquia);
                            py.getMisMetodos().get(itMetodo).getMisVariables().get(VerifPY.iteradorVar).setTipo(tipos.get(i).getTipo());
                            py.getMisMetodos().get(itMetodo).getMisVariables().get(VerifPY.iteradorVar).setValor(true);
                        } else {
                            py.getMisMetodos().get(itMetodo).getMisVariables().add(new Variable(identificadores.get(i), tipos.get(i).getTipo(), true, jerarquia));
                            py.getMisMetodos().get(itMetodo).getMisVariables().get(py.getMisMetodos().get(itMetodo).getMisVariables().size() - 1).getListAsignaciones().add(jerarquia);
                            py.getMisMetodos().get(itMetodo).getMisVariables().get(py.getMisMetodos().get(itMetodo).getMisVariables().size() - 1).setValor(true);
                        }
                    }
                }
            } else {
                PanelPrincipal.errores += "Fila: "+fila+" Columna: "+columna+" Tipo de error: SEMANTICO - Causa: Falta de valores en asignacion -> "+identificadores.size()+" "+tipos.size()+".\n";
            }
        } else {
        //    System.out.println("Error en las asignaciones");
        }
    }

    //busca una variable dentro del archivo y retorna su tipo
    public String buscarVariable(ObjetosPYTHON py, String id, int jerarquia) {
        String tipo = "";
        VerifPY verif = new VerifPY();
        if (jerarquia == 0) {
            if (verif.verifVarGlobal(py, id)) {
                tipo = py.getGlobales().get(VerifPY.iteradorVar).getTipo();
            }
        } else {
            int itMetodo = py.getMisMetodos().size() - 1;
            if (verif.verifVarLocal(py, id)) {
                tipo = py.getMisMetodos().get(itMetodo).getMisVariables().get(VerifPY.iteradorVar).getTipo();
            } else if (verif.verifVarGlobal(py, id)) {
                tipo = py.getGlobales().get(VerifPY.iteradorVar).getTipo();
            }
        }
        return tipo;
    }

    public void valorVariableInput(ObjetosPYTHON py, String id, int jerarquia, String tipoVar) {
        VerifPY verif = new VerifPY();
        int itMetodo = py.getMisMetodos().size() - 1;
        if (verif.verifVarLocal(py, id)) {
            py.getMisMetodos().get(itMetodo).getMisVariables().get(VerifPY.iteradorVar).getListAsignaciones().add(jerarquia);
            py.getMisMetodos().get(itMetodo).getMisVariables().get(VerifPY.iteradorVar).setTipo(tipoVar);
        } else {
            py.getMisMetodos().get(itMetodo).getMisVariables().add(new Variable(id, tipoVar, true, jerarquia));
            py.getMisMetodos().get(itMetodo).getMisVariables().get(py.getMisMetodos().get(itMetodo).getMisVariables().size()-1).getListAsignaciones().add(jerarquia);
        
        }
    }

    //agrega un nuevo metodo al archivo
    public void agregarMetodo(ObjetosPYTHON py, String id, ArrayList<String> parametros, int jerarquia, int fila, int columna) {
        VerifPY verif = new VerifPY();
        boolean coincidencia = false;
        for (int i = 0; i < parametros.size(); i++) {
            for (int j = 0; j < parametros.size(); j++) {
                if (i != j) {
                    if (parametros.get(i).equals(parametros.get(j))) {
                        coincidencia = true;
                        break;
                    }
                }
            }
        }
        if (!coincidencia) {
            if (verif.verifMetodo(py, id)) {
                PanelPrincipal.errores += "Fila: "+fila+" Columna: "+columna+" Tipo de error: SEMANTICO - Causa: Ya existe un metodo dentro de PYTHON con el id: "+id+".\n";
            } else {
                py.getMisMetodos().add(new Metodo(id, false, null));
                for (int i = 0; i < parametros.size(); i++) {
                    py.getMisMetodos().get(py.getMisMetodos().size() - 1).getMisParametros().add(new Parametro(py.getMisMetodos().get(py.getMisMetodos().size() - 1).getMisParametros().size() - 1, null));
                    py.getMisMetodos().get(py.getMisMetodos().size() - 1).getMisVariables().add(new Variable(parametros.get(i), "Float", true, jerarquia));
                    py.getMisMetodos().get(py.getMisMetodos().size() - 1).getMisVariables().get(py.getMisMetodos().get(py.getMisMetodos().size() - 1).getMisVariables().size() - 1).getListAsignaciones().add(jerarquia);
                }
            }
        } else {
            PanelPrincipal.errores += "Fila: "+fila+" Columna: "+columna+" Tipo de error: SEMANTICO - Causa: Id's en parametros de metodo "+id+" con multiple coincidencia.\n";
        }
    }

    public void agregarRetornoMetodo(ObjetosPYTHON py, String tipo) {
        if (!tipo.equals("")) {
            py.getMisMetodos().get(py.getMisMetodos().size() - 1).setTipo(true);
            py.getMisMetodos().get(py.getMisMetodos().size() - 1).setRetorno(tipo);
        } else {
            py.getMisMetodos().get(py.getMisMetodos().size() - 1).setTipo(false);
        }
    }

    //borra una variable gracias al comando "DEL"
    public void borrarVariable(ObjetosPYTHON py, String id, int jerarquia, int fila, int columna) {
        VerifPY verif = new VerifPY();
        if (jerarquia == 0) {
            if (verif.verifVarGlobal(py, id)) {
                int aRemover = VerifPY.iteradorVar;
                py.getGlobales().remove(aRemover);
            }
        } else {
            if (verif.verifVarLocal(py, id)) {
                int aRemover = VerifPY.iteradorVar;
                py.getMisMetodos().get(py.getMisMetodos().size() - 1).getMisVariables().remove(aRemover);
            } else if (verif.verifVarLocal(py, id)) {
                int aRemover = VerifPY.iteradorVar;
                py.getGlobales().remove(aRemover);
            } else {
                PanelPrincipal.errores += "Fila: "+fila+" Columna: "+columna+" Tipo de error: SEMANTICO - Causa: No existe la variable "+id+" comos para usar el comando del.\n"; 
            }
        }
    }

}
