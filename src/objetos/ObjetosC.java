/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import ObjetosC.ClasesJava;
import ObjetosC.Constantes;
import Tablas.DatosVar;
import Tablas.Tipado;
import cuartetos.Nodo;
import java.util.ArrayList;

/**
 *
 * @author luisGonzalez
 */
public class ObjetosC {

    private ArrayList<Constantes> listConstantes = new ArrayList<>();
    private ArrayList<Variable> listVariables = new ArrayList<>();
    private ArrayList<Arreglo> listArreglos = new ArrayList<>();
    private ArrayList<ClasesJava> listClases = new ArrayList<>();
    private Tipado tablaTipos = new Tipado();
    private ArrayList<Nodo> cuarpeta = new ArrayList<>();

    /*Contadores para la cuarpeta*/
    private int contVars = 0;
    private int contEt = 0;
    private int contEtFin = 0;
    private int contWhile = 0;
    private int contFor = 0;
    
    public ObjetosC() {
        tablaTipos.getTipos().add(new DatosVar("Float", 3, null));
        tablaTipos.getTipos().add(new DatosVar("Integer", 2, "Float"));
        tablaTipos.getTipos().add(new DatosVar("Char", 1, "Integer"));
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

    public int getContWhile() {
        return contWhile;
    }

    public void setContWhile(int contWhile) {
        this.contWhile = contWhile;
    }

    public int getContFor() {
        return contFor;
    }

    public void setContFor(int contFor) {
        this.contFor = contFor;
    }

    public ArrayList<ClasesJava> getListClases() {
        return listClases;
    }

    public void setListClases(ArrayList<ClasesJava> listClases) {
        this.listClases = listClases;
    }

    public ArrayList<Arreglo> getListArreglos() {
        return listArreglos;
    }

    public void setListArreglos(ArrayList<Arreglo> listArreglos) {
        this.listArreglos = listArreglos;
    }

    public ArrayList<Variable> getListVariables() {
        return listVariables;
    }

    public void setListVariables(ArrayList<Variable> listVariables) {
        this.listVariables = listVariables;
    }

    public ArrayList<Constantes> getListConstantes() {
        return listConstantes;
    }

    public void setListConstantes(ArrayList<Constantes> listConstantes) {
        this.listConstantes = listConstantes;
    }

    public Tipado getTablaTipos() {
        return tablaTipos;
    }

    public void setTablaTipos(Tipado tablaTipos) {
        this.tablaTipos = tablaTipos;
    }

}
