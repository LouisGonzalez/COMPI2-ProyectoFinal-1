/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
public class ObjetosJAVA {
    
    private ArrayList<Clase> misClases = new ArrayList<>();
    private Tipado tablaTipos = new Tipado();
    private ArrayList<Nodo> cuarpeta = new ArrayList<>();
    int a1 = 2;
    
    /*Contadores para la cuarpeta*/
    private int contVars = 0;
    private int contEt = 0;
    private int contEtFin = 0;
    private int contWhile = 0;
    private int contFor = 0;
    
    public ObjetosJAVA(){
        tablaTipos.getTipos().add(new DatosVar("Float", 3, null));
        tablaTipos.getTipos().add(new DatosVar("Integer", 2, "Float"));
        tablaTipos.getTipos().add(new DatosVar("Char", 1, "Integer"));
    }
    
    public int getContFor() {
        return contFor;
    }

    public void setContFor(int contFor) {
        this.contFor = contFor;
    }

    public int getA1() {
        return a1;
    }

    public void setA1(int a1) {
        this.a1 = a1;
    }

    public int getContWhile() {
        return contWhile;
    }

    public void setContWhile(int contWhile) {
        this.contWhile = contWhile;
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

    public int getContVars() {
        return contVars;
    }

    public void setContVars(int contVars) {
        this.contVars = contVars;
    }

    public ArrayList<Nodo> getCuarpeta() {
        return cuarpeta;
    }

    public void setCuarpeta(ArrayList<Nodo> cuarpeta) {
        this.cuarpeta = cuarpeta;
    }

    public ArrayList<Clase> getMisClases() {
        return misClases;
    }

    public void setMisClases(ArrayList<Clase> misClases) {
        this.misClases = misClases;
    }

    public Tipado getTablaTipos() {
        return tablaTipos;
    }

    public void setTablaTipos(Tipado tablaTipos) {
        this.tablaTipos = tablaTipos;
    }
    
    
}
