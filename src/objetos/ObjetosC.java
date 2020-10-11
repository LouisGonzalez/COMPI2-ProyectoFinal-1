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

    public ObjetosC() {
        tablaTipos.getTipos().add(new DatosVar("Float", 3, null));
        tablaTipos.getTipos().add(new DatosVar("Integer", 2, "Float"));
        tablaTipos.getTipos().add(new DatosVar("Char", 1, "Integer"));
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
