/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembler;

/**
 *
 * @author luisGonzalez
 */
public class Objetos {

    private String tipo;
    private String id;
    private Object dato;

    public Objetos(String tipo, String id, Object dato) {
        this.tipo = tipo;
        this.id = id;
        this.dato = dato;
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

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }
    
    
    
}

