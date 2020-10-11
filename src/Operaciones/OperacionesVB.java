/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import gramaticaVB.SintaxVB;
import java.util.ArrayList;
import objetos.Metodo;
import objetos.ObjetosVB;
import objetos.Variable;
import verificaciones.VerifVB;

/**
 *
 * @author luisGonzalez
 */
public class OperacionesVB {

    private VerifVB verificador = new VerifVB();

    //Busca el metodo en el que se esta actualmente
    public Integer buscarMetodo(ArrayList<Metodo> listMetodos, String nombre) {
        Integer iterador = null;
        for (int i = 0; i < listMetodos.size(); i++) {
            if (listMetodos.get(i).getIdMetodo().equals(nombre)) {
                iterador = i;
                break;
            }
        }
        return iterador;
    }

    public void crearMetodo(ObjetosVB vb, String id, boolean tipo) {
        boolean encontrado = false;
        for (int i = 0; i < vb.getMisMetodos().size(); i++) {
            if (vb.getMisMetodos().get(i).getIdMetodo().equals(id)) {
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            vb.getMisMetodos().add(new Metodo(id, tipo, null));
        } else {
            System.out.println("Ya existe un metodo con el id: " + id);
        }
    }

    //Agrega las variables dependiendo de si son globales o van en algun metodo
    public void agregarVariables(String nombre, String tipo, int jerarquia, ObjetosVB vb, String metodoActual) {
        if (!verificador.verificarIdVar(nombre, vb, jerarquia, metodoActual, this)) {
            Integer it = buscarMetodo(vb.getMisMetodos(), metodoActual);
            vb.getMisMetodos().get(it).getMisVariables().add(new Variable(nombre, tipo, null, jerarquia));
        } else {
            System.out.println("Ya existe una variable con nombre: " + nombre);
        }

    }

    //elimina cualquier variable que haya sido sentenciada dentro de un ciclo que esta a punto de cerrarse
    public void eliminarVariables(int jerarquia, ObjetosVB vb, int iterador) {
        if (jerarquia > 0) {
            for (int i = 0; i < vb.getMisMetodos().get(iterador).getMisVariables().size(); i++) {
                if (vb.getMisMetodos().get(iterador).getMisVariables().get(i).getNivel() == jerarquia) {
                    vb.getMisMetodos().get(iterador).getMisVariables().remove(i);
                    i--;
                }
            }
            for (int i = 0; i < vb.getMisMetodos().get(iterador).getMisVariables().size(); i++) {
                for (int j = 0; j < vb.getMisMetodos().get(iterador).getMisVariables().get(i).getListAsignaciones().size(); j++) {
                    if (vb.getMisMetodos().get(iterador).getMisVariables().get(i).getListAsignaciones().get(j) == jerarquia) {
                        vb.getMisMetodos().get(iterador).getMisVariables().get(i).getListAsignaciones().remove(j);
                        j--;
                    }
                }
            }
            for (int i = 0; i < vb.getMisMetodos().get(iterador).getMisVariables().size(); i++) {
                if (vb.getMisMetodos().get(iterador).getMisVariables().get(i).getListAsignaciones().isEmpty()) {
                    vb.getMisMetodos().get(iterador).getMisVariables().get(i).setValor(false);
                }
            }
        }
    }

    //agrega X valor a una variable durante una asignacion
    public void agregarValorVar(String id, ObjetosVB vb, int jerarquia) {
        if (!SintaxVB.isReturn) {
            if (verificador.verifVarLocal(vb, id)) {
                vb.getMisMetodos().get(vb.getMisMetodos().size() - 1).getMisVariables().get(VerifVB.iteradorVar).getListAsignaciones().add(jerarquia);
                vb.getMisMetodos().get(vb.getMisMetodos().size() - 1).getMisVariables().get(VerifVB.iteradorVar).setValor(true);
            } else {
                System.out.println("Variable: " + id + " inexistente dentro del metodo");
            }
        }

    }

    //maneja el uso de returns dentro de un if
    public Boolean retornoIf(Boolean a, Boolean b) {
        if (b != null && a != null) {
            if (a && b) {
                return true;
            } else if ((a && !b) || (!a && b)) {
                System.out.println("Error en if (posible confusion en mmanejo returns)");
                return null;
            } else {
                return false;
            }
        } else {
            return null;
        }
    }

    //maneja el uso de returns dentro de un for
    public Boolean retornoFor(Boolean a) {
        if (a != null) {
            return false;
        } else {
            return null;
        }
    }

    //maneja el uso de returns dentro de un case en un select/switch
    public Boolean retornoCaseSelect(Boolean a, Boolean b) {
        if (a != null && b != null) {
            if (a && b) {
                return true;
            } else if ((a && !b) || (!a && b)) {
                System.out.println("Error en select (posible confusion en manejo de returns");
                return null;
            } else {
                return false;
            }
        } else {
            return null;
        }
    }

    public void retornoMetodo(Boolean cuerpo, Boolean retorno, String idMetodo) {
        if (cuerpo != null) {
            if (cuerpo && retorno) {
                System.out.println("Error, multiples returns en metodo: " + idMetodo);
            } else if ((!cuerpo && retorno) || (cuerpo && !retorno)) {
                System.out.println("todoCorrecto");
            } else if (!cuerpo && !retorno) {
                System.out.println("Error, falta de return en metodo: " + idMetodo);
            }
        }
    }

    //busca una variable y devuelve su tipo
    public String buscarVariable(ObjetosVB vb, String id) {
        String tipo = "";
        if (verificador.verifVarLocal(vb, id)) {
            tipo = vb.getMisMetodos().get(vb.getMisMetodos().size() - 1).getMisVariables().get(VerifVB.iteradorVar).getTipo();
        } else {
            System.out.println("La variable: " + id + " no existe dentro del archivo");
        }
        return tipo;
    }

}
