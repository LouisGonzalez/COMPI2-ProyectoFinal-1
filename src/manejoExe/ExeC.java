/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoExe;

import Tablas.TablaSimbolos;
import ejecutable.Tabla;

/**
 *
 * @author luisGonzalez
 */
public class ExeC {
    
    
    //aplica para variables, arreglos y clases
    public void agregarVariable(TablaSimbolos tabla, String id, int size, boolean esArreglo, String tipo){
        boolean existe = false;
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if(tabla.getTablaExe().get(i).getId().equals(id)){
                if(tabla.getTablaExe().get(i).getAmbito().equals("global") && tabla.getTablaExe().get(i).getLenguaje().equals("C")){
                    existe = true;
                    break;
                }
            }
        }
        if(!existe){
            int posMemoria = determinarPosVar(tabla);
            tabla.getTablaExe().add(new Tabla(id, tipo, posMemoria, "global", size, "variable", "C"));
            tabla.getTablaExe().get(tabla.getTablaExe().size()-1).setEsArreglo(esArreglo);
        }
    }
    

   
   public int determinarPosVar(TablaSimbolos tabla){
        int size = 0;
        for (int i = 0; i < tabla.getTablaExe().size(); i++) {
            if(tabla.getTablaExe().get(i).getAmbito().equals("global") && (!tabla.getTablaExe().get(i).getRol().equals("metodo") && !tabla.getTablaExe().get(i).getRol().equals("clase"))){
                size = size + tabla.getTablaExe().get(i).getSize();
            }
        }
        return size;
    }
    
    
    
}
