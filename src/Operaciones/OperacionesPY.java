/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import gramaticaPYTHON.SintaxPYTHON;
import java.util.ArrayList;
import objetos.Metodo;
import objetos.ObjetosPYTHON;
import objetos.Parametro;
import objetos.Variable;
import verificaciones.VerifPY;

/**
 *
 * @author luisGonzalez
 */
public class OperacionesPY {

    public void verificarTabs(ObjetosPYTHON py, ArrayList<Integer> instrucciones, ArrayList<Integer> lineasGuias, int tabsLinea, boolean instruccion) {
        //Significa que somos la primer linea luego de una instruccion
        if (!SintaxPYTHON.primerLinea) {
            lineasGuias.add(tabsLinea);
            SintaxPYTHON.primerLinea = true;
        } else {
            if (tabsLinea > lineasGuias.get(lineasGuias.size() - 1)) {
                System.out.println("ERROR");
            } else if (tabsLinea < lineasGuias.get(lineasGuias.size() - 1)) {
                Integer iterador = null;
                for (int i = instrucciones.size() - 1; i >= 0; i--) {
                    eliminarVarAmbitos(py, SintaxPYTHON.jerarquia);
                    SintaxPYTHON.jerarquia--;
                    if (tabsLinea == instrucciones.get(i)) {
                        iterador = i;
                        break;
                    } else if (tabsLinea > instrucciones.get(i)) {
                        System.out.println("ERROR 2");
                        break;
                    }
                }
                if (iterador != null) {
                    for (int i = instrucciones.size() - 1; i >= iterador; i--) {
                        instrucciones.remove(i);
                    }
                }
                SintaxPYTHON.primerLinea = false;
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
    public void asignarVariables(ObjetosPYTHON py, String id, String tipo) {
        if (!tipo.equals("")) {
            VerifPY verif = new VerifPY();
            if (SintaxPYTHON.jerarquia == 0) {
                if (verif.verifVarGlobal(py, id)) {
                    py.getGlobales().get(VerifPY.iteradorVar).getListAsignaciones().add(SintaxPYTHON.jerarquia);
                    py.getGlobales().get(VerifPY.iteradorVar).setValor(true);
                } else {
                    //si no existe agrega la variable a las variables globales
                    py.getGlobales().add(new Variable(id, tipo, true, SintaxPYTHON.jerarquia));
                    py.getGlobales().get(py.getGlobales().size() - 1).getListAsignaciones().add(SintaxPYTHON.jerarquia);
                }
            } else {
                if (verif.verifVarLocal(py, id)) {
                    py.getMisMetodos().get(py.getMisMetodos().size() - 1).getMisVariables().get(VerifPY.iteradorVar).getListAsignaciones().add(SintaxPYTHON.jerarquia);
                    py.getMisMetodos().get(py.getMisMetodos().size() - 1).getMisVariables().get(VerifPY.iteradorVar).setValor(true);
                    py.getMisMetodos().get(py.getMisMetodos().size() - 1).getMisVariables().get(VerifPY.iteradorVar).setTipo(tipo);
                } else {
                    //si no existe agrega la variable a las variables del metodo    
                    py.getMisMetodos().get(py.getMisMetodos().size() - 1).getMisVariables().add(new Variable(id, tipo, true, SintaxPYTHON.jerarquia));
                    py.getMisMetodos().get(py.getMisMetodos().size() - 1).getMisVariables().get(py.getMisMetodos().get(py.getMisMetodos().size() - 1).getMisVariables().size() - 1).getListAsignaciones().add(SintaxPYTHON.jerarquia);
                }
            }
        } else {
            System.out.println("Error de asignacion en variable: " + id);
        }
    }

    //metodo para las asignaciones de tipo: a,b,c = 1,2,3
    public void asignacionesMultiples(ObjetosPYTHON py, ArrayList<String> identificadores, ArrayList<String> tipos, int jerarquia) {
        if (tipos != null) {
            VerifPY verif = new VerifPY();
            if (identificadores.size() == tipos.size()) {
                System.out.println(jerarquia + "      ===");
                for (int i = 0; i < identificadores.size(); i++) {
                    if (jerarquia == 0) {
                        if (verif.verifVarGlobal(py, identificadores.get(i))) {
                            py.getGlobales().get(VerifPY.iteradorVar).getListAsignaciones().add(jerarquia);
                            py.getGlobales().get(VerifPY.iteradorVar).setTipo(tipos.get(i));
                            py.getGlobales().get(VerifPY.iteradorVar).setValor(true);
                        } else {
                            py.getGlobales().add(new Variable(identificadores.get(i), tipos.get(i), true, jerarquia));
                            py.getGlobales().get(py.getGlobales().size() - 1).getListAsignaciones().add(jerarquia);
                            py.getGlobales().get(py.getGlobales().size() - 1).setValor(true);
                        }
                    } else {
                        int itMetodo = py.getMisMetodos().size() - 1;
                        if (verif.verifVarLocal(py, identificadores.get(i))) {
                            py.getMisMetodos().get(itMetodo).getMisVariables().get(VerifPY.iteradorVar).getListAsignaciones().add(jerarquia);
                            py.getMisMetodos().get(itMetodo).getMisVariables().get(VerifPY.iteradorVar).setTipo(tipos.get(i));
                            py.getMisMetodos().get(itMetodo).getMisVariables().get(VerifPY.iteradorVar).setValor(true);
                        } else {
                            py.getMisMetodos().get(itMetodo).getMisVariables().add(new Variable(identificadores.get(i), tipos.get(i), true, jerarquia));
                            py.getMisMetodos().get(itMetodo).getMisVariables().get(py.getMisMetodos().get(itMetodo).getMisVariables().size() - 1).getListAsignaciones().add(jerarquia);
                            py.getMisMetodos().get(itMetodo).getMisVariables().get(py.getMisMetodos().get(itMetodo).getMisVariables().size() - 1).setValor(true);
                        }
                    }
                }
            } else {
                System.out.println("Error, falta de valores en asignacion. " + identificadores.size() + " " + tipos.size());
            }
        } else {
            System.out.println("Error en las asignaciones");
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

    //agrega un nuevo metodo al archivo
    public void agregarMetodo(ObjetosPYTHON py, String id, ArrayList<String> parametros, int jerarquia) {
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
                System.out.println("Ya existe un metodo con el id: " + id);
            } else {
                py.getMisMetodos().add(new Metodo(id, false, null));
                for (int i = 0; i < parametros.size(); i++) {
                    py.getMisMetodos().get(py.getMisMetodos().size()-1).getMisParametros().add(new Parametro(py.getMisMetodos().get(py.getMisMetodos().size()-1).getMisParametros().size()-1, null));
                    py.getMisMetodos().get(py.getMisMetodos().size()-1).getMisVariables().add(new Variable(parametros.get(i), "Float", true, jerarquia));
                    py.getMisMetodos().get(py.getMisMetodos().size()-1).getMisVariables().get(py.getMisMetodos().get(py.getMisMetodos().size()-1).getMisVariables().size()-1).getListAsignaciones().add(jerarquia);
                }
            }
        } else {
            System.out.println("Nombres de parametros iguales en metodo: "+id);
        }
    }
    
    public void agregarRetornoMetodo(ObjetosPYTHON py, String tipo){
        if(!tipo.equals("")){
            py.getMisMetodos().get(py.getMisMetodos().size()-1).setTipo(false);
            py.getMisMetodos().get(py.getMisMetodos().size()-1).setRetorno(tipo);
        } else {
            py.getMisMetodos().get(py.getMisMetodos().size()-1).setTipo(false);
        }
    }
    
    //borra una variable gracias al comando "DEL"
    public void borrarVariable(ObjetosPYTHON py, String id, int jerarquia){
        VerifPY verif = new VerifPY();
        if(jerarquia == 0){
            if(verif.verifVarGlobal(py, id)){
                int aRemover = VerifPY.iteradorVar;
                py.getGlobales().remove(aRemover);
            }
        } else {
            if(verif.verifVarLocal(py, id)){
                int aRemover = VerifPY.iteradorVar;
                py.getMisMetodos().get(py.getMisMetodos().size()-1).getMisVariables().remove(aRemover);
            } else if(verif.verifVarLocal(py, id)){
                int aRemover = VerifPY.iteradorVar;
                py.getGlobales().remove(aRemover);
            } else {
                System.out.println("No existe la variable: "+id+" dentro del archivo como para usar el comando: del");
            }
        }
    }
    
    

}
