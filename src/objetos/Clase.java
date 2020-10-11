/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.util.ArrayList;

/**
 *
 * @author luisitopapurey
 */
public class Clase {
    
    /*SOLO PARA JAVA*/
    private String id;
    private ArrayList<Metodo> misMetodos = new ArrayList<>();
    private ArrayList<Variable> globales = new ArrayList<>();
    private boolean activado = false;

    public Clase(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Metodo> getMisMetodos() {
        return misMetodos;
    }

    public void setMisMetodos(ArrayList<Metodo> misMetodos) {
        this.misMetodos = misMetodos;
    }

    public ArrayList<Variable> getGlobales() {
        return globales;
    }

    public void setGlobales(ArrayList<Variable> globales) {
        this.globales = globales;
    }

    public boolean isActivado() {
        return activado;
    }

    public void setActivado(boolean activado) {
        this.activado = activado;
    }
    
}
