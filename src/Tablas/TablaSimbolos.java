/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

import cuartetos.Nodo;
import ejecutable.Tabla;
import java.util.ArrayList;
import objetos.*;
/**
 *
 * @author luisGonzalez
 */
public class TablaSimbolos {
    
    
    private ObjetosC obC = new ObjetosC();  
    private ObjetosJAVA obJava = new ObjetosJAVA();
    private ObjetosPYTHON obPython = new ObjetosPYTHON();
    private ObjetosVB obVb = new ObjetosVB();
    private ArrayList<Tabla> tablaExe = new ArrayList<>();

    public ArrayList<Tabla> getTablaExe() {
        return tablaExe;
    }

    public void setTablaExe(ArrayList<Tabla> tablaExe) {
        this.tablaExe = tablaExe;
    }
    
    public ObjetosC getObC() {
        return obC;
    }

    public void setObC(ObjetosC obC) {
        this.obC = obC;
    }

    public ObjetosJAVA getObJava() {
        return obJava;
    }

    public void setObJava(ObjetosJAVA obJava) {
        this.obJava = obJava;
    }

    public ObjetosPYTHON getObPython() {
        return obPython;
    }

    public void setObPython(ObjetosPYTHON obPython) {
        this.obPython = obPython;
    }

    public ObjetosVB getObVb() {
        return obVb;
    }

    public void setObVb(ObjetosVB obVb) {
        this.obVb = obVb;
    }
    
    
    
}
