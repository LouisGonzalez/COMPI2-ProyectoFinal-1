/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificaciones;

import Operaciones.OperacionesPY;
import Tablas.TablaSimbolos;
import interfaz.PanelPrincipal;
import java.util.Objects;
import objetos.ObjetosPYTHON;
import objetos.Variable;

/**
 *
 * @author luisGonzalez
 */
public class VerifPY {

    public static Integer iteradorVar = null;

    //verifica si una variable existe dentro de las variables globales del archivo
    public boolean verifVarGlobal(ObjetosPYTHON py, String id) {
        boolean existe = false;
        for (int i = 0; i < py.getGlobales().size(); i++) {
            if (py.getGlobales().get(i).getId().equals(id)) {
                existe = true;
                iteradorVar = i;
                break;
            }
        }
        return existe;
    }

    //verifica si una variable existe dentro del ambito de un metodo
    public boolean verifVarLocal(ObjetosPYTHON py, String id) {
        boolean existe = false;
        for (int i = 0; i < py.getMisMetodos().get(py.getMisMetodos().size() - 1).getMisVariables().size(); i++) {
            if (py.getMisMetodos().get(py.getMisMetodos().size() - 1).getMisVariables().get(i).getId().equals(id)) {
                existe = true;
                iteradorVar = i;
                break;
            }
        }
        return existe;
    }

    //verifica el tipo de dato que representara a una operacion
    public String verificarTipoOperacion(ObjetosPYTHON py, String dato1, String dato2, int fila, int columna) {
        String tipo = "";
        Integer nivelDato1 = null, nivelDato2 = null;
        for (int i = 0; i < py.getTablaTipos().getTipos().size(); i++) {
            if (py.getTablaTipos().getTipos().get(i).getId().equals(dato1)) {
                nivelDato1 = py.getTablaTipos().getTipos().get(i).getNivel();
                break;
            }
        }
        for (int i = 0; i < py.getTablaTipos().getTipos().size(); i++) {
            if (py.getTablaTipos().getTipos().get(i).getId().equals(dato2)) {
                nivelDato2 = py.getTablaTipos().getTipos().get(i).getNivel();
                break;
            }
        }
        if (Objects.equals(nivelDato1, nivelDato2)) {
            tipo = dato1;
        } else if (nivelDato1 > nivelDato2) {
            if (verificarPadre(py, dato2, dato1)) {
                tipo = dato1;
            }
        } else {
            if (verificarPadre(py, dato1, dato2)) {
                tipo = dato2;
            }
        }
        if(tipo.equals("")){
            PanelPrincipal.errores += "Fila: "+fila+" Columna: "+columna+" Tipo de error: SEMANTICO - Causa: Error al momento de comparar el tipo de 2 variables incompatibles.\n";
        }
        return tipo;
    }

    //verificacion para el manejo de padres con respecto a los tipados
    public boolean verificarPadre(ObjetosPYTHON py, String tipo, String tipoBase) {
        boolean aceptado = true;
        for (int i = 0; i < py.getTablaTipos().getTipos().size(); i++) {
            if (py.getTablaTipos().getTipos().get(i).getId().equals(tipo)) {
                if (py.getTablaTipos().getTipos().get(i).getPadre() != null) {
                    if (py.getTablaTipos().getTipos().get(i).getPadre().equals(tipoBase)) {
                        aceptado = true;
                        break;
                    } else {
                        aceptado = verificarPadre(py, py.getTablaTipos().getTipos().get(i).getPadre(), tipoBase);
                    }
                }
            }
        }
        return aceptado;
    }

    //verifica si un metodo ya existe dentro del archivo 
    public boolean verifMetodo(ObjetosPYTHON py, String id) {
        boolean existe = false;
        for (int i = 0; i < py.getMisMetodos().size(); i++) {
            if (py.getMisMetodos().get(i).getIdMetodo().equals(id)) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    //verifica que un id corresponda al tipo que se pide en el input
    public void verifVarInput(ObjetosPYTHON py, String tipoVar, String tipoInput, String id, int fila, int columna) {
        if (!tipoVar.equals(tipoInput)) {
            String padre = null;
            for (int i = 0; i < py.getTablaTipos().getTipos().size(); i++) {
                if (py.getTablaTipos().getTipos().get(i).getId().equals(tipoVar)) {
                    padre = py.getTablaTipos().getTipos().get(i).getPadre();
                }
            }
            if (padre != null) {
                if (!verificarPadre(py, padre, tipoVar)) {
                    System.out.println("Variable: " + id + " incompatible para el input de tipo: " + tipoInput);
                    PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: Variable " + id + " incompatible para un input de tipo " + tipoInput + ".\n";
                }
            } else {
                System.out.println("Variable: " + id + " incompatible para el input de tipo: " + tipoInput);
                PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: Variable " + id + " incompatible para un input de tipo " + tipoInput + ".\n";
            }
        }
    }

    public void comprobacionFor(ObjetosPYTHON py, String id, String operacion, boolean range, String tipo, OperacionesPY op, int jerarquia, int fila, int columna, int fila2, int columna2) {
        String tipoId = op.buscarVariable(py, id, jerarquia);
        if (tipo.equals("tipo2")) {
            if (tipoId.equals("")) {
                py.getMisMetodos().get(py.getMisMetodos().size() - 1).getMisVariables().add(new Variable(id, "Integer", true, jerarquia));
                py.getMisMetodos().get(py.getMisMetodos().size() - 1).getMisVariables().get(py.getMisMetodos().get(py.getMisMetodos().size() - 1).getMisVariables().size() - 1).getListAsignaciones().add(jerarquia);
            } else if (tipoId.equals("Integer")) {
                if (!range) {
                    System.out.println("Error en orden: range()");
                    PanelPrincipal.errores += "Fila: " + fila2 + " Columna: " + columna2 + " Tipo de error: SEMANTICO - Causa: Rangos en range definidos de forma incorrecta.\n";
                }
            } else {
                System.out.println("Variable: " + id + " con tipo incorrecto para usar");
                PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: Variable " + id + " incompatible dentro del ciclo for.\n";

            }
        }
    }

    //verifica que la variable dentro de un mensaje exista y tenga un valor ddentro
    public Boolean verifVarMensaje(ObjetosPYTHON py, String id, int jerarquia, int fila, int columna) {
        boolean todoCorrecto = false;
        if (jerarquia == 0) {
            if (verifVarGlobal(py, id)) {
                if (py.getGlobales().get(iteradorVar).getValor()) {
                    todoCorrecto = true;
                } else {
                    PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: La variable " + id + " no tiene un valor asignado.\n";

                }
            } else {
                PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: La variable " + id + " no existe dentro del archivo PYTHON.\n";
            }
        } else {
            if (verifVarLocal(py, id)) {
                if (py.getMisMetodos().get(py.getMisMetodos().size() - 1).getMisVariables().get(iteradorVar).getValor()) {
                    todoCorrecto = true;
                } else {
                    PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: La variable " + id + " no tiene un valor asignado.\n";
                }
            } else if (verifVarGlobal(py, id)) {
                if (py.getGlobales().get(iteradorVar).getValor()) {
                    todoCorrecto = true;
                } else {
                    PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: La variable " + id + " no tiene un valor asignado.\n";
                }
            } else {
                PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: La variable " + id + " no existe dentro del archivo PYTHON.\n";
            }
        }
        return todoCorrecto;
    }

    //verifica que en un mensaje todo este en ordden
    public void verifMensaje(Boolean a, Boolean b, String tipo, int fila, int columna) {
        if (tipo.equals("tipo1")) {
            if (a && b) {
            } else {
                System.out.println("ERROR en definicion de instruccion print. py");
                PanelPrincipal.errores += "Fila: "+fila+" Columna: "+columna+" Tipo de error: SEMANTICO - Causa: Error en definicion print().\n";
        
            }
        } else if (tipo.equals("tipo2")) {
            if (!b) {
                PanelPrincipal.errores += "Fila: "+fila+" Columna: "+columna+" Tipo de error: SEMANTICO - Causa: Error en definicion print().\n";
            }
        }
    }
    
    public boolean verificarMetodo(TablaSimbolos tabla, String idMetodo, int fila, int columna){
        boolean existe = false;
        for (int i = 0; i < tabla.getObPython().getMisMetodos().size(); i++) {
            if(tabla.getObPython().getMisMetodos().get(i).getIdMetodo().equals(idMetodo)){
                existe = true;
                iteradorVar = i;
                break;
            }
        }
        if(!existe){
            PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: No existe ningun metodo con el id: " + idMetodo + " dentro del archivo PYTHON\n";
        }
        return existe;
    }
}
