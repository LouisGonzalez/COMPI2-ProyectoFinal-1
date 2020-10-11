/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.util.ArrayList;

/**
 *
 * @author luisGonzalez
 */
public class Variable {
    
    private String id;
    private String tipo;
    private Integer nivel;
    private Boolean valor;
    private ArrayList<Integer> listAsignaciones = new ArrayList<>();

    public Variable(String id, String tipo, Boolean valor, Integer nivel) {
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
        this.nivel = nivel;
    }

    public ArrayList<Integer> getListAsignaciones() {
        return listAsignaciones;
    }

    public void setListAsignaciones(ArrayList<Integer> listAsignaciones) {
        this.listAsignaciones = listAsignaciones;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getValor() {
        return valor;
    }

    public void setValor(Boolean valor) {
        this.valor = valor;
    }

   
    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
}
