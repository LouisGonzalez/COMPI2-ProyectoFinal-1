/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import gramaticaVB.SintaxVB;
import interfaz.PanelPrincipal;
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

    public void modificarTipos(ObjetosVB vb, ArrayList<String> variables, String tipo){
        for (int i = 0; i < variables.size(); i++) {
            for (int j = 0; j < vb.getMisMetodos().get(vb.getMisMetodos().size()-1).getMisVariables().size(); j++) {
                if(variables.get(i).equals(vb.getMisMetodos().get(vb.getMisMetodos().size()-1).getMisVariables().get(j).getId())){
                    vb.getMisMetodos().get(vb.getMisMetodos().size()-1).getMisVariables().get(j).setTipo(tipo);
                    break;
                }
            }
        }
        variables = new ArrayList<>();
    }
    
    
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

    public void crearMetodo(ObjetosVB vb, String id, boolean tipo, int fila, int columna) {
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
           PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: Ya existe un metodo con el id:" + id + " dentro del archivo VB\n";

        }
    }

    //Agrega las variables dependiendo de si son globales o van en algun metodo
    public void agregarVariables(String nombre, String tipo, int jerarquia, ObjetosVB vb, String metodoActual, int fila, int columna) {
        if (!verificador.verificarIdVar(nombre, vb, jerarquia, metodoActual, this)) {
            Integer it = buscarMetodo(vb.getMisMetodos(), metodoActual);
            vb.getMisMetodos().get(it).getMisVariables().add(new Variable(nombre, tipo, false, jerarquia));
        } else {
             PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: Ya existe una variable con el id:" + nombre + ".\n";
   
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
    public void agregarValorVar(String id, ObjetosVB vb, int jerarquia, int fila, int columna) {
        if (!SintaxVB.isReturn) {
            if (verificador.verifVarLocal(vb, id)) {
                vb.getMisMetodos().get(vb.getMisMetodos().size() - 1).getMisVariables().get(VerifVB.iteradorVar).getListAsignaciones().add(jerarquia);
                vb.getMisMetodos().get(vb.getMisMetodos().size() - 1).getMisVariables().get(VerifVB.iteradorVar).setValor(true);
            } else {
                PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: No existe una variable con el id:" + id + " dentro del metodo.\n";
            }
        }

    }

    //maneja el uso de returns dentro de un if
    public Boolean retornoIf(Boolean a, Boolean b, int fila, int columna) {
        if (b != null && a != null) {
            if (a && b) {
                return true;
            } else if ((a && !b) || (!a && b)) {
                System.out.println("Error en if (posible confusion en mmanejo returns)");
                PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: Error en if (posible confusion en mmanejo returns)\n";
                
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
    public Boolean retornoCaseSelect(Boolean a, Boolean b, int fila, int columna) {
        if (a != null && b != null) {
            if (a && b) {
                return true;
            } else if ((a && !b) || (!a && b)) {

                PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: Error en switch (posible confusion en manejo returns)\n";
                return null;
            } else {
                return false;
            }
        } else {
            return null;
        }
    }

    public void retornoMetodo(Boolean cuerpo, Boolean retorno, String idMetodo, int fila, int columna) {
        if (cuerpo != null) {
            if (cuerpo && retorno) {
                PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: Error, multiples returns en metodo:" + idMetodo+"\n";
            } else if ((!cuerpo && retorno) || (cuerpo && !retorno)) {
            } else if (!cuerpo && !retorno) {
                System.out.println("Error, falta de return en metodo: " + idMetodo);
                PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: Error, falta de return en metodo: " + idMetodo+"\n";
            }
        }
    }

    //busca una variable y devuelve su tipo
    public String buscarVariable(ObjetosVB vb, String id, int fila, int columna) {
        String tipo = "";
        if (verificador.verifVarLocal(vb, id)) {
            tipo = vb.getMisMetodos().get(vb.getMisMetodos().size() - 1).getMisVariables().get(VerifVB.iteradorVar).getTipo();
        } else {
            System.out.println("La variable: " + id + " no existe dentro del archivo");
            PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: La variable: " + id + " no existe dentro del archivo VB\n";
        }
        return tipo;
    }
   

}
