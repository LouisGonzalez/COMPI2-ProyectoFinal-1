/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoExe;

import Tablas.TablaSimbolos;
import ejecutable.Tabla;
import java.util.ArrayList;

/**
 *
 * @author luisGonzalez
 */
public class ExeJava {

    public void agregarClase(TablaSimbolos tabla, String idClase) {
        boolean existe = false;
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if (tabla.getTablaExe().get(i).getId().equals(idClase) && tabla.getTablaExe().get(i).getRol().equals("clase")) {
                existe = true;
                break;
            }
        }
        if (!existe) {
            tabla.getTablaExe().add(new Tabla(idClase, null, -1, "global", null, "clase", "JV"));
            constructorPorDefecto(tabla, idClase);
        }
    }
    
    public void constructorPorDefecto(TablaSimbolos tabla, String idClase){
        tabla.getTablaExe().add(new Tabla(idClase+"_"+idClase, null, -1, idClase, 1, "constructor", "JV"));
        this.agregarReturn(tabla, idClase, idClase);
    }

    public void agregarConstructor(TablaSimbolos tabla, String idClase) {
        String id = idClase +"_"+idClase;
        tabla.getTablaExe().add(new Tabla(id, null, -1, idClase, null, "constructor", "JV"));
    }

    public void agregarMetodo(TablaSimbolos tabla, String idMetodo, String tipo, String idClase) {
        boolean existe = false;
        String id = idClase + "_" + idMetodo;
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if (tabla.getTablaExe().get(i).getId().equals(id) && tabla.getTablaExe().get(i).getLenguaje().equals("JV") && tabla.getTablaExe().get(i).getRol().equals("metodo")) {
                existe = true;
                break;
            }
        }
        if (!existe) {
            tabla.getTablaExe().add(new Tabla(id, tipo, -1, idClase, null, "metodo", "JV"));
        }
    }
    
    public void agregarParametros(TablaSimbolos tabla, String idMetodo, String idClase, String listParam){
        String id = idClase + "_"+idMetodo;
        Integer iterador = null;
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if(tabla.getTablaExe().get(i).getId().equals(id) && tabla.getTablaExe().get(i).getLenguaje().equals("JV") && (tabla.getTablaExe().get(i).getRol().equals("metodo") || tabla.getTablaExe().get(i).getRol().equals("constructor"))){
                iterador = i;
//                tabla.getTablaExe().get(i).setListParametros(listParam);
            }
        }
        tabla.getTablaExe().get(iterador).setListParametros(listParam);
        if(!listParam.equals("")){
           tabla.getTablaExe().get(iterador).setId(tabla.getTablaExe().get(iterador).getId()+"_"+listParam);
        } 
    }
    
    
    
    public void actualizarParametrosMetodo(TablaSimbolos tabla, String idClase, String ambito){
        String id = idClase + "_" + ambito;
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if(tabla.getTablaExe().get(i).getRol().equals("parametro") && tabla.getTablaExe().get(i).getLenguaje().equals("JV")){
                if(!tabla.getTablaExe().get(i).isParamMarcado()){
                    tabla.getTablaExe().get(i).setAmbito(id);
                    tabla.getTablaExe().get(i).setParamMarcado(true);
                }
            }
        }
    }
    

    public void agregarVariable(TablaSimbolos tabla, String idVar, String idMetodo, String idClase, String tipo) {
        //Hace alusion a que es una variable global dentro de la clase
        if (idMetodo.equals("")) {
            boolean existe = false;
            for (int i = 0; i < tabla.getTablaExe().size(); i++) {
                if (tabla.getTablaExe().get(i).getId().equals(idVar)) {
                    if (tabla.getTablaExe().get(i).getLenguaje().equals("JV") && tabla.getTablaExe().get(i).getAmbito().equals(idClase) && (tabla.getTablaExe().get(i).getRol().equals("variable") || tabla.getTablaExe().get(i).getRol().equals("parametro"))) {
                        existe = true;
                        break;
                    }
                }
            }
            if (!existe) {
                tabla.getTablaExe().add(new Tabla(idVar, tipo, tabla.getTablaExe().get(tabla.getTablaExe().size() - 1).getPosMemoria() + 1, idClase, 1, "variable", "JV"));
                sumarMemoriaClase(tabla, idClase);
            }
        } else {
            boolean existe = false;
            String ambito = idClase + "_" + idMetodo;
            for (int i = 0; i < tabla.getTablaExe().size(); i++) {
                if (tabla.getTablaExe().get(i).getId().equals(idVar)) {
                    if (tabla.getTablaExe().get(i).getAmbito().equals(ambito) && tabla.getTablaExe().get(i).getLenguaje().equals("JV") && (tabla.getTablaExe().get(i).getRol().equals("variable") || tabla.getTablaExe().get(i).getRol().equals("parametro"))) {
                        existe = true;
                        break;
                    }
                }
            }
            if (!existe) {
                tabla.getTablaExe().add(new Tabla(idVar, tipo, tabla.getTablaExe().get(tabla.getTablaExe().size() - 1).getPosMemoria() + 1, ambito, 1, "variable", "JV"));
                sumarMemoriaMetodo(tabla, idClase, idMetodo);
            }
        }
    }

    public void agregarParametro(TablaSimbolos tabla, String idVar, String idClase, String idMetodo, String tipo) {
        String ambito = idClase + "_" + idMetodo;
        boolean existe = false;
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if (tabla.getTablaExe().get(i).getId().equals(idVar)) {
                if (tabla.getTablaExe().get(i).getAmbito().equals(ambito) && tabla.getTablaExe().get(i).getLenguaje().equals("JV") && (tabla.getTablaExe().get(i).getRol().equals("variable") || tabla.getTablaExe().get(i).getRol().equals("parametro"))) {
                    existe = true;
                    break;
                }
            }
        }
        if (!existe) {
            tabla.getTablaExe().add(new Tabla(idVar, tipo, tabla.getTablaExe().get(tabla.getTablaExe().size() - 1).getPosMemoria() + 1, ambito, 1, "parametro", "JV"));
            sumarMemoriaMetodo(tabla, idClase, idMetodo);
        }
    }

    public void agregarReturn(TablaSimbolos tabla, String idMetodo, String idClase) {
        String id = idClase + "_" + idMetodo;
        boolean existe = false;
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if (tabla.getTablaExe().get(i).getRol().equals("return") && tabla.getTablaExe().get(i).getAmbito().equals(id)) {
                existe = true;
                break;
            }
        }
        if (!existe) {
            String tipo = "";
            for (int i = 0; i < tabla.getObJava().getMisClases().size(); i++) {
                if (tabla.getObJava().getMisClases().get(i).getId().equals(idClase)) {
                    for (int j = 0; j < tabla.getObJava().getMisClases().get(i).getMisMetodos().size(); j++) {
                        if (tabla.getObJava().getMisClases().get(i).getMisMetodos().get(j).getIdMetodo().equals(idMetodo)) {
                            tipo = tabla.getObJava().getMisClases().get(i).getMisMetodos().get(j).getRetorno();
                            break;
                        }
                    }
                }
            }
            tabla.getTablaExe().add(new Tabla("return", tipo, tabla.getTablaExe().get(tabla.getTablaExe().size() - 1).getPosMemoria() + 1, id, 1, "return", "JV"));
            sumarMemoriaMetodo(tabla, idClase, idMetodo);
        }
    }

    public void sumarMemoriaClase(TablaSimbolos tabla, String idClase) {
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if (tabla.getTablaExe().get(i).getId().equals(idClase) && tabla.getTablaExe().get(i).getRol().equals("clase")) {
                if (tabla.getTablaExe().get(i).getSize() != null) {
                    tabla.getTablaExe().get(i).setSize(tabla.getTablaExe().get(i).getSize() + 1);
                } else {
                    tabla.getTablaExe().get(i).setSize(0);
                }
                break;
            }
        }
    }

    public void sumarMemoriaMetodo(TablaSimbolos tabla, String idClase, String idMetodo) {
        String id = idClase + "_" + idMetodo;
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if (tabla.getTablaExe().get(i).getId().equals(id) && tabla.getTablaExe().get(i).getAmbito().equals(idClase) && (tabla.getTablaExe().get(i).getRol().equals("metodo") ||tabla.getTablaExe().get(i).getRol().equals("constructor"))) {
                if (tabla.getTablaExe().get(i).getSize() != null) {
                    tabla.getTablaExe().get(i).setSize(tabla.getTablaExe().get(i).getSize() + 1);
                } else {
                    tabla.getTablaExe().get(i).setSize(0);
                }
                break;
            }
        }
    }

}
