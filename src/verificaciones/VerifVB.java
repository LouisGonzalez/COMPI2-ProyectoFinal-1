/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificaciones;

import Operaciones.OperacionesVB;
import Tablas.TablaSimbolos;
import Tablas.Tipado;
import gramaticaVB.SintaxVB;
import interfaz.PanelPrincipal;
import java.util.ArrayList;
import java.util.Objects;
import manejoCuartetos.ManejoVb;
import objetos.ObjetosVB;
import objetos.Variable;

/**
 *
 * @author luisGonzalez
 */
public class VerifVB {

    public static Integer iteradorVar = null;

    public boolean verifVarLocal(ObjetosVB vb, String id) {
        boolean existe = false;
        for (int i = 0; i < vb.getMisMetodos().get(vb.getMisMetodos().size() - 1).getMisVariables().size(); i++) {
            if (vb.getMisMetodos().get(vb.getMisMetodos().size() - 1).getMisVariables().get(i).getId().equals(id)) {
                existe = true;
                iteradorVar = i;
                break;
            }
        }
        return existe;
    }

    //verifica si existe un id dentro de la tabla, si no existe agregar la nueva variable   
    public boolean verificarIdVar(String id, ObjetosVB vb, int jerarquia, String metodo, OperacionesVB operacion) {
        boolean existe = false;
        Integer it = operacion.buscarMetodo(vb.getMisMetodos(), metodo);
        if(!vb.getMisMetodos().isEmpty()){
            for (int i = 0; i < vb.getMisMetodos().get(it).getMisVariables().size(); i++) {
                if (vb.getMisMetodos().get(it).getMisVariables().get(i).getId().equals(id)) {
                    existe = true;
                    break;
                }
            }
        }
        return existe;
    }

    //Simplemente verifica si existe un id dentro del metodo actual y tiene agregado un valor
    public boolean verifVarOp(ObjetosVB vb, int iterador, String id, String tipoBase, Tipado tipado, int fila, int columna) {
        boolean varExiste = false;
        if (verifVarLocal(vb, id)) {
            if (vb.getMisMetodos().get(vb.getMisMetodos().size() - 1).getMisVariables().get(iteradorVar).getValor()) {
                if (vb.getMisMetodos().get(vb.getMisMetodos().size() - 1).getMisVariables().get(iteradorVar).getTipo().equals(tipoBase)) {
                    varExiste = true;
                } else {
                    if (verificarPadre(vb, vb.getMisMetodos().get(vb.getMisMetodos().size() - 1).getMisVariables().get(iteradorVar).getTipo(), tipoBase, tipado)) {
                        varExiste = true;
                    } else {
                        PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: La variable: " + id + " no es compatible con el tipo de operacion\n";
                    }
                }
            } else {
                PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: La variable: " + id + " no tiene un valor asignado\n";
            }
        } else {
            PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: La variable: " + id + " no existe dentro del metodo\n";
        }

        return varExiste;
    }

    //verifica que al usar un tipo de input la variable que se lea exista y sea del mismo valor que se quiere asignar
    public boolean verificarVarInput(ObjetosVB vb, int iterador, String id, String tipoBase, Tipado tipado, int jerarquia) {
        boolean todoCorrecto = false;
        for (int i = 0; i < vb.getMisMetodos().get(iterador).getMisVariables().size(); i++) {
            if (vb.getMisMetodos().get(iterador).getMisVariables().get(i).getId().equals(id)) {
                if (vb.getMisMetodos().get(iterador).getMisVariables().get(i).getTipo().equals(tipoBase)) {
                    vb.getMisMetodos().get(iterador).getMisVariables().get(i).getListAsignaciones().add(jerarquia);
                    vb.getMisMetodos().get(iterador).getMisVariables().get(i).setValor(true);
                    todoCorrecto = true;
                    break;
                } else {
                    if (verificarPadre(vb, vb.getMisMetodos().get(iterador).getMisVariables().get(i).getTipo(), tipoBase, tipado)) {
                        vb.getMisMetodos().get(iterador).getMisVariables().get(i).getListAsignaciones().add(jerarquia);
                        vb.getMisMetodos().get(iterador).getMisVariables().get(i).setValor(true);
                        todoCorrecto = true;
                        break;
                    }
                }
            }
        }
        return todoCorrecto;
    }

    public boolean verificarNumero(String tipoNum, ObjetosVB vb, Tipado tipado, String tipoBase, int fila, int columna, String valor) {
        boolean todoCorrecto = false;
        if (tipoBase.equals(tipoNum)) {
            todoCorrecto = true;
        } else {
            if (verificarPadre(vb, tipoNum, tipoBase, tipado)) {
                todoCorrecto = true;
            } else {
                PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: El valor " + valor + " no es compatible con el tipo de operacion.\n";
            }
        }
        return todoCorrecto;
    }

    //verifica si una variable tiene asignado un valor y no es nulo
    public boolean verificarValorVar(Variable var) {
        if (var.getValor()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verificarPadre(ObjetosVB vb, String tipoVar, String tipoBase, Tipado tipado) {
        boolean aceptado = false;
        for (int i = 0; i < tipado.getTipos().size(); i++) {
            if (tipoVar.equals(tipado.getTipos().get(i).getId())) {
                if (tipado.getTipos().get(i).getPadre() != null) {
                    if (tipoBase.equals(tipado.getTipos().get(i).getPadre())) {
                        aceptado = true;
                        break;
                    } else {
                        aceptado = verificarPadre(vb, tipado.getTipos().get(i).getPadre(), tipoBase, tipado);
                    }
                }
            }
        }

        return aceptado;
    }

    //verifica que en una condicion ambos lados sean iguales
    public boolean verificarCondicion(Variable var1, Variable var2, Tipado tipado, ObjetosVB vb) {
        boolean todoCorrecto = false;
        if (var1.getTipo().equals(var2.getTipo())) {
            todoCorrecto = true;
        } else {
            if (var1.getNivel() > var2.getNivel()) {
                if (verificarPadre(vb, var2.getId(), var1.getId(), tipado)) {
                    todoCorrecto = true;
                }
            } else {
                if (verificarPadre(vb, var1.getId(), var2.getId(), tipado)) {
                    todoCorrecto = true;
                }
            }
        }
        return todoCorrecto;
    }

    //verifica si ya existe un metodo con un id especifico
    public boolean verificarMetodo(String id, ObjetosVB vb, int fila, int columna) {
        boolean agregar = true;
        for (int i = 0; i < vb.getMisMetodos().size(); i++) {
            if (id.equals(vb.getMisMetodos().get(i).getIdMetodo())) {
                System.out.println("Ya existe un metodo con este nombre en especifico");
                PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: Ya existe un metodo con el id" + id + " dentro del archivo.\n";
                agregar = false;
                break;
            }
        }
        return agregar;
    }

    /*PARAMETROS*/
    //verifica si existe ya un id dentro de los parametros de un metodo
    public boolean verificarIdParam(ArrayList<Variable> listVar, String id) {
        boolean existe = false;
        for (int i = 0; i < listVar.size(); i++) {
            if (id.equals(listVar.get(i).getId())) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    //verifica el tipo de valor de una variable a la que se le asignara un valor, y luego lo devuelve
    public String verificarVarAsignar(String id, TablaSimbolos tabla, int iterador, int fila, int columna, String idMetodo) {
        String tipo = "";
        if (verifVarLocal(tabla.getObVb(), id)) {
            tipo = tabla.getObVb().getMisMetodos().get(tabla.getObVb().getMisMetodos().size() - 1).getMisVariables().get(iteradorVar).getTipo();
        } else {
            tipo = verificarReturn(tabla, id, fila, columna, idMetodo);
            if (tipo.equals("")) {
                PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: No existe una variable con el id " + id + " dentro del metodo.\n";
    
            }
        }
        return tipo;
    }

    //verifica si una asignacion es del mismo nombre que el metodo, lo que significa que es un return
    public String verificarReturn(TablaSimbolos tabla, String id, int fila, int columna, String idMetodo) {
        String tipo = "";
        if (id.equals(tabla.getObVb().getMisMetodos().get(tabla.getObVb().getMisMetodos().size() - 1).getIdMetodo())) {
            if (tabla.getObVb().getMisMetodos().get(tabla.getObVb().getMisMetodos().size() - 1).isTipo()) {
                SintaxVB.isReturn = true;
                tipo = tabla.getObVb().getMisMetodos().get(tabla.getObVb().getMisMetodos().size() - 1).getRetorno();
                
            } else {
                PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: El metodo: " + tabla.getObVb().getMisMetodos().get(tabla.getObVb().getMisMetodos().size() - 1).getIdMetodo() + " es de tipo Sub por lo que no puede retornar elementos.\n";
            }
        }
        return tipo;
    }

    //verifica a la variable iterable de un FOR
    public void verificarVarFor(String id, String tipoVar, ObjetosVB vb, int iterador, Tipado tipado, int nivel, Boolean step, int fila, int columna, int jerarquia) {

        if (step || step == null) {
            //si tipoVar es vacio hace alusion que esa variable ya existe dentro del metodo
            if (tipoVar.equals("")) {
                if (!verificarVarInput(vb, iterador, id, "Integer", tipado, jerarquia)) {
                    PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: No existe una variable con el id " + id + " dentro del metodo.\n";
                    
                }
            } else {
                if (tipoVar.equals("Integer")) {
                    vb.getMisMetodos().get(iterador).getMisVariables().add(new Variable(id, tipoVar, true, nivel));
                } else {
                    System.out.println("No es posible usar una variable de tipo " + tipoVar + " en un for");
                    PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: No es posible usar una variable de tipo " + tipoVar + " en un for\n";
                }
            }
        } else {
            if (!step) {
                System.out.println("STEP no es de tipo integer");
                    PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: Paso STEP no es de tipo Integer por lo que no puede usarse dentro de un for\n";

            }
        }
    }

    //verifica si una variable dentro de un mensaje existe y si es asi ver si tiene un valor
    public void verifVarMensaje(ObjetosVB vb, String id, int fila, int columna) {
        if (verifVarLocal(vb, id)) {
            if (!vb.getMisMetodos().get(vb.getMisMetodos().size() - 1).getMisVariables().get(iteradorVar).getValor()) {
                PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: La variable " + id + " no tiene asignado ningun valor.\n";
            }
        } else {
            PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: No existe ninguna variable " + id + " dentro del metodo.\n";
       }
    }

    //verifica el tipo que representara a una operacion condicional
    public String verificarTipoOperacion(ObjetosVB vb, String dato1, String dato2) {
        String tipo = "";
        Integer nivelDato1 = null, nivelDato2 = null;
        for (int i = 0; i < vb.getTablaTipos().getTipos().size(); i++) {
            if (vb.getTablaTipos().getTipos().get(i).getId().equals(dato1)) {
                nivelDato1 = vb.getTablaTipos().getTipos().get(i).getNivel();
                break;
            }
        }
        for (int i = 0; i < vb.getTablaTipos().getTipos().size(); i++) {
            if (vb.getTablaTipos().getTipos().get(i).getId().equals(dato2)) {
                nivelDato2 = vb.getTablaTipos().getTipos().get(i).getNivel();
                break;
            }
        }
        if (Objects.equals(nivelDato1, nivelDato2)) {
            tipo = dato1;
        } else if (nivelDato1 > nivelDato2) {
            if (verificarPadre(vb, dato2, dato1, vb.getTablaTipos())) {
                tipo = dato1;
            }
        } else {
            if (verificarPadre(vb, dato1, dato2, vb.getTablaTipos())) {
                tipo = dato2;
            }
        }
        return tipo;
    }

    public void verifVarSelect(ObjetosVB vb, String id, int fila, int columna) {
        if (verifVarLocal(vb, id)) {
            System.out.println(vb.getMisMetodos().get(vb.getMisMetodos().size() - 1).getMisVariables().get(iteradorVar).getId());
            if (vb.getMisMetodos().get(vb.getMisMetodos().size() - 1).getMisVariables().get(iteradorVar).getValor()) {
                if (vb.getMisMetodos().get(vb.getMisMetodos().size() - 1).getMisVariables().get(iteradorVar).getTipo().equals("Float")) {
                    PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: Variable: " + id + " imposible de utilizar en select debido a su tipo de dato: " + vb.getMisMetodos().get(vb.getMisMetodos().size() - 1).getMisVariables().get(iteradorVar).getTipo()+"\n";
                }
            } else {
                PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: Variable: " + id + " sin valor para uso en select.\n";
            }
        } else {
            PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: Variable: " + id + " no existe dentro del archivo VB.\n";

        }
    }
    
    public boolean verificarMetodo(TablaSimbolos tabla, String idMetodo, int fila, int columna){
        boolean existe = false;
        for (int i = 0; i < tabla.getObVb().getMisMetodos().size(); i++) {
            if(tabla.getObVb().getMisMetodos().get(i).getIdMetodo().equals(idMetodo)){
                existe = true;
                iteradorVar = i;
                break;
            }
        }
        if(!existe){
            PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: No existe ningun metodo con el id: " + idMetodo + " dentro del archivo VB\n";
        }
        return existe;
    }

}
