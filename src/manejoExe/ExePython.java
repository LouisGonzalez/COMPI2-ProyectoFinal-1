/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoExe;

import Tablas.TablaSimbolos;
import ejecutable.Tabla;
import java.util.ArrayList;
import objetosApoyo.NodoBoolean;

/**
 *
 * @author luisGonzalez
 */
public class ExePython {

    public void agregarMetodo(TablaSimbolos tabla, String idMetodo) {
        boolean existe = false;
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if (tabla.getTablaExe().get(i).getId().equals(idMetodo) && tabla.getTablaExe().get(i).getRol().equals("metodo") && tabla.getTablaExe().get(i).getLenguaje().equals("PY")) {
                existe = true;
                break;
            }
        }
        if (!existe) {
            tabla.getTablaExe().add(new Tabla(idMetodo, "void", -1, "global", null, "metodo", "PY"));
        }
    }

    public void agregarParametro(TablaSimbolos tabla, String id, String idMetodo){
        boolean existe = false;
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if (tabla.getTablaExe().get(i).getId().equals(id) && tabla.getTablaExe().get(i).getAmbito().equals(idMetodo) && tabla.getTablaExe().get(i).getLenguaje().equals("PY")) {
                existe = true;
                break;
            }
        }
        if (!existe) {
            tabla.getTablaExe().add(new Tabla(id, null, tabla.getTablaExe().get(tabla.getTablaExe().size()-1).getPosMemoria()+1, idMetodo, 1, "parametro", "PY"));
            sumarVariableMetodo(tabla, idMetodo);
        }
    }
    
    public void agregarVariable(TablaSimbolos tabla, String id, String idMetodo, String tipo) {
        boolean existe = false;
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if (tabla.getTablaExe().get(i).getId().equals(id) && tabla.getTablaExe().get(i).getAmbito().equals(idMetodo) && tabla.getTablaExe().get(i).getLenguaje().equals("PY")) {
                existe = true;
                break;
            }
        }
        if (!existe) {
            tabla.getTablaExe().add(new Tabla(id, null, tabla.getTablaExe().get(tabla.getTablaExe().size()-1).getPosMemoria()+1, idMetodo, 1, "variable", "PY"));
            sumarVariableMetodo(tabla, idMetodo);
        }
    }
    
    public void agregacionesMultiples(TablaSimbolos tabla, ArrayList<String> ids, ArrayList<NodoBoolean> valores, String idMetodo){
        if(ids.size() == valores.size()){
            for (int i = 0; i < ids.size(); i++) {
                boolean existe = false;
                for (int j = 0; j < tabla.getTablaExe().size(); j++) {
                    if(ids.get(i).equals(tabla.getTablaExe().get(i).getId())){
                        if(tabla.getTablaExe().get(i).getAmbito().equals(idMetodo) && tabla.getTablaExe().get(i).getLenguaje().equals("PY")){
                            existe = true;
                            break;
                        }
                    }
                }
                if(!existe){
                    tabla.getTablaExe().add(new Tabla(ids.get(i), valores.get(i).getTipo(), tabla.getTablaExe().get(tabla.getTablaExe().size()-1).getPosMemoria()+1, idMetodo, i, "variable", "PY"));
                    sumarVariableMetodo(tabla, idMetodo);
                }
            }
        }
    }
    
    public void cambiarTipoVar(TablaSimbolos tabla, String idVar, String idMetodo, String tipo){
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if(tabla.getTablaExe().get(i).getId().equals(idVar)){
                if(tabla.getTablaExe().get(i).getAmbito().equals(idMetodo) && tabla.getTablaExe().get(i).getLenguaje().equals("PY")){
                    tabla.getTablaExe().get(i).setTipo(tipo);
                    break;
                }
            }
        }
    }
    
    public void agregarReturn(TablaSimbolos tabla, String idMetodo, String tipo){
        boolean existe = false;
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if(tabla.getTablaExe().get(i).getId().equals("return") && tabla.getTablaExe().get(i).getAmbito().equals(idMetodo) && tabla.getTablaExe().get(i).getLenguaje().equals("PY")){
                existe = true;
                break;
            }
        }
        if(!existe){
            agregarTipoMetodo(tabla, idMetodo, tipo);
            tabla.getTablaExe().add(new Tabla("return", tipo, tabla.getTablaExe().get(tabla.getTablaExe().size()-1).getPosMemoria()+1, idMetodo, 1, "return", "PY"));
            sumarVariableMetodo(tabla, idMetodo);
        }
    }

    //esto cuando se encuentre un return
    public void agregarTipoMetodo(TablaSimbolos tabla, String idMetodo, String tipo) {
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if(tabla.getTablaExe().get(i).getId().equals(idMetodo) && tabla.getTablaExe().get(i).getRol().equals("metodo") && tabla.getTablaExe().get(i).getLenguaje().equals("PY")){
                tabla.getTablaExe().get(i).setTipo(tipo);
                break;
            }
        }
        
    }

    public void sumarVariableMetodo(TablaSimbolos tabla, String idMetodo) {
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if (tabla.getTablaExe().get(i).getId().equals(idMetodo)) {
                if (tabla.getTablaExe().get(i).getRol().equals("metodo") && tabla.getTablaExe().get(i).getLenguaje().equals("PY")) {
                    if (tabla.getTablaExe().get(i).getSize() != null) {
                        tabla.getTablaExe().get(i).setSize(tabla.getTablaExe().get(i).getSize() + 1);
                    } else {
                        tabla.getTablaExe().get(i).setSize(1);
                    }
                }
            }
        }

    }

}
