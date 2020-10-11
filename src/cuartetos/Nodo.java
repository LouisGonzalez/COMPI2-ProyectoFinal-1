/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuartetos;

/**
 *
 * @author luisGonzalez
 */
public class Nodo {
    
    private String operacion;
    private Object dato1;
    private Object dato2;
    private String var;
    private Integer nivel;
    
    public Nodo(String operacion, Object dato1, Object dato2, String var, Integer nivel) {
        this.operacion = operacion;
        this.dato1 = dato1;
        this.dato2 = dato2;
        this.var = var;
        this.nivel = nivel;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public Object getDato1() {
        return dato1;
    }

    public void setDato1(Object dato1) {
        this.dato1 = dato1;
    }

    public Object getDato2() {
        return dato2;
    }

    public void setDato2(Object dato2) {
        this.dato2 = dato2;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }
    
    
    
}
