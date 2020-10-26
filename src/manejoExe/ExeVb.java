/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoExe;

import Tablas.TablaSimbolos;
import ejecutable.Tabla;
import java.util.ArrayList;
import objetos.Variable;

/**
 *
 * @author luisGonzalez
 */
public class ExeVb {

    /*------------------------------AGREGAR A LA TABLA DE SIMBOLOS--------------------------------------------*/
    //agrega el metodo a la tabla 
    public void agregarMetodo(TablaSimbolos tabla, String idMetodo, String tipo) {
        boolean existe = false;
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if(tabla.getTablaExe().get(i).getId().equals(idMetodo) && tabla.getTablaExe().get(i).getRol().equals("metodo") && tabla.getTablaExe().get(i).getLenguaje().equals("VB")){
                existe = true;
                break;
            }
        }
        if(!existe){
            tabla.getTablaExe().add(new Tabla(idMetodo, tipo, -1, "global", null, "metodo", "VB"));
        }
    }

    public void agregarTipoMetodo(TablaSimbolos tabla, String tipo, ArrayList<Variable> listParam) {
        Integer iterador = null;
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if (tabla.getTablaExe().get(i).getRol().equals("metodo")) {
                iterador = i;
            }
        }
        tabla.getTablaExe().get(iterador).setTipo(tipo);
        String parametros = agregarParametrosMetodo(tabla, listParam);
        if(!parametros.equals("")){
            tabla.getTablaExe().get(iterador).setId(tabla.getTablaExe().get(iterador).getId()+"_"+agregarParametrosMetodo(tabla, listParam));
        }
    }
    
    public void actualizarParametrosMetodo(TablaSimbolos tabla, String idMetodo){
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if(tabla.getTablaExe().get(i).getRol().equals("parametro") && tabla.getTablaExe().get(i).getLenguaje().equals("VB")){
                if(!tabla.getTablaExe().get(i).isParamMarcado()){
                    tabla.getTablaExe().get(i).setAmbito(idMetodo);
                    tabla.getTablaExe().get(i).setParamMarcado(true);
                }
            }
        }
    }
    
    public String agregarParametrosMetodo(TablaSimbolos tabla, ArrayList<Variable> listParam){
        String parametros = "";
        if(!listParam.isEmpty()){
            for (int i = 0; i < listParam.size(); i++) {
                if(i == 0){
                    parametros = listParam.get(i).getTipo();
                } else {
                    parametros += "_"+listParam.get(i).getTipo();
                }
            }
        } 
        return parametros;
    }

    //agrega la variable a la tabla de simbolos
    public void agregarVariable(TablaSimbolos tabla, String id, String idMetodo, String tipo) {
        if (id.equals(idMetodo)) {
            agregarReturn(tabla, idMetodo);
        } else {
            boolean existe = false;
            for (int i = 0; i < tabla.getTablaExe().size(); i++) {
                if (tabla.getTablaExe().get(i).getId().equals(id) && tabla.getTablaExe().get(i).getAmbito().equals(idMetodo) && tabla.getTablaExe().get(i).getLenguaje().equals("VB")) {
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                tabla.getTablaExe().add(new Tabla(id, tipo, tabla.getTablaExe().get(tabla.getTablaExe().size() - 1).getPosMemoria() + 1, idMetodo, 1, "variable", "VB"));
                sumarVariableMetodo(tabla, idMetodo);
            }
        }
    }
    
    public void agregarParametro(TablaSimbolos tabla, String id, String idMetodo, String tipo) {
        if (id.equals(idMetodo)) {
            agregarReturn(tabla, idMetodo);
        } else {
            boolean existe = false;
            for (int i = 0; i < tabla.getTablaExe().size(); i++) {
                if (tabla.getTablaExe().get(i).getId().equals(id) && tabla.getTablaExe().get(i).getAmbito().equals(idMetodo) && tabla.getTablaExe().get(i).getLenguaje().equals("VB")) {
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                tabla.getTablaExe().add(new Tabla(id, tipo, tabla.getTablaExe().get(tabla.getTablaExe().size() - 1).getPosMemoria() + 1, idMetodo, 1, "parametro", "VB"));
                sumarVariableMetodo(tabla, idMetodo);
            }
        }
    }

    public void agregarReturn(TablaSimbolos tabla, String idMetodo) {
        boolean existe = false;
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if (tabla.getTablaExe().get(i).getId().equals("return") && tabla.getTablaExe().get(i).getAmbito().equals(idMetodo) && tabla.getTablaExe().get(i).getLenguaje().equals("VB")) {
                existe = true;
                break;
            }
        }
        if (!existe) {
            String tipo = "";
            for (int i = 0; i < tabla.getObVb().getMisMetodos().size(); i++) {
                if (tabla.getObVb().getMisMetodos().get(i).getIdMetodo().equals(idMetodo)) {
                    tipo = tabla.getObVb().getMisMetodos().get(i).getRetorno();
                    break;
                }
            }
            tabla.getTablaExe().add(new Tabla("return", tipo, tabla.getTablaExe().get(tabla.getTablaExe().size() - 1).getPosMemoria() + 1, idMetodo, 1, "return", "VB"));
            sumarVariableMetodo(tabla, idMetodo);
        }
    }

    public void sumarVariableMetodo(TablaSimbolos tabla, String idMetodo) {
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if (tabla.getTablaExe().get(i).getId().equals(idMetodo)) {
                if (tabla.getTablaExe().get(i).getRol().equals("metodo") && tabla.getTablaExe().get(i).getLenguaje().equals("VB")) {
                    if (tabla.getTablaExe().get(i).getSize() != null) {
                        tabla.getTablaExe().get(i).setSize(tabla.getTablaExe().get(i).getSize() + 1);
                    } else {
                        tabla.getTablaExe().get(i).setSize(1);
                    }
                }
            }
        }
    }

    //agrega el atributo tipo a las variables pendientes
    public void agregarTipo(TablaSimbolos tabla, ArrayList<String> pendientes, String idMetodo, String tipo) {
        for (int i = 0; i < pendientes.size(); i++) {
            for (int j = 0; j < tabla.getTablaExe().size(); j++) {
                if (tabla.getTablaExe().get(i).getId().equals(pendientes.get(i)) && tabla.getTablaExe().get(i).getAmbito().equals(idMetodo)) {
                    tabla.getTablaExe().get(i).setTipo(tipo);
                    break;
                }
            }
        }
    }

}
