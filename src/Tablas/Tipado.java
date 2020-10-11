/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

import java.util.ArrayList;

/**
 *
 * @author luisGonzalez
 */
public class Tipado {
    
   /* private DatosVar tipoFloat = new DatosVar("Double", 3, null);
    private DatosVar tipoInt = new DatosVar("Integer", 2, "Double");
    private DatosVar tipoChar = new DatosVar("Char", 1, "Integer");*/
    
    private ArrayList<DatosVar> tipos = new ArrayList<>();

    public ArrayList<DatosVar> getTipos() {
        return tipos;
    }

    public void setTipos(ArrayList<DatosVar> tipos) {
        this.tipos = tipos;
    }
    
    

    
    
    
    
}
