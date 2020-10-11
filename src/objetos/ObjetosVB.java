/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this     private boolean libPython;
    private boolean libJava;
    private boolean libVb;
template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import Tablas.DatosVar;
import Tablas.Tipado;
import cuartetos.Nodo;
import java.util.ArrayList;

/**
 *
 * @author luisGonzalez
 */
public class ObjetosVB {
    
    private ArrayList<Metodo> misMetodos = new ArrayList<>();
    private boolean activado = false;
    private Tipado tablaTipos = new Tipado();
    private ArrayList<Nodo> cuarpeta = new ArrayList<>();
    
    /*Contadores para la cuarpeta*/
    private int contVars = 0;
    private int contEt = 0;
    private int contEtFin = 0;
    private int contEtWhile = 0;
    private int contFor = 0;
    
    public ObjetosVB(){
        tablaTipos.getTipos().add(new DatosVar("Float", 3, null));
        tablaTipos.getTipos().add(new DatosVar("Integer", 2, "Float"));
        tablaTipos.getTipos().add(new DatosVar("Char", 1, null));
    }

    public ArrayList<Nodo> getCuarpeta() {
        return cuarpeta;
    }

    public void setCuarpeta(ArrayList<Nodo> cuarpeta) {
        this.cuarpeta = cuarpeta;
    }

    public int getContVars() {
        return contVars;
    }

    public void setContVars(int contVars) {
        this.contVars = contVars;
    }

    public int getContEt() {
        return contEt;
    }

    public void setContEt(int contEt) {
        this.contEt = contEt;
    }

    public int getContEtFin() {
        return contEtFin;
    }

    public void setContEtFin(int contEtFin) {
        this.contEtFin = contEtFin;
    }

    public int getContEtWhile() {
        return contEtWhile;
    }

    public void setContEtWhile(int contEtWhile) {
        this.contEtWhile = contEtWhile;
    }

    public int getContFor() {
        return contFor;
    }

    public void setContFor(int contFor) {
        this.contFor = contFor;
    }

    public Tipado getTablaTipos() {
        return tablaTipos;
    }

    public void setTablaTipos(Tipado tablaTipos) {
        this.tablaTipos = tablaTipos;
    }
    
    public ArrayList<Metodo> getMisMetodos() {
        return misMetodos;
    }

    public void setMisMetodos(ArrayList<Metodo> misMetodos) {
        this.misMetodos = misMetodos;
    }

    public boolean isActivado() {
        return activado;
    }

    public void setActivado(boolean activado) {
        this.activado = activado;
    }
    
    
    
}
