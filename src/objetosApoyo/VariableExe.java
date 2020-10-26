/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosApoyo;

/**
 *
 * @author luisGonzalez
 */
public class VariableExe {
    
    private String id;
    private String tipo;
    private String idMetodo;
    private String lenguaje;

    public VariableExe(String id, String tipo, String idMetodo, String lenguaje) {
        this.id = id;
        this.tipo = tipo;
        this.idMetodo = idMetodo;
        this.lenguaje = lenguaje;
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

    public String getIdMetodo() {
        return idMetodo;
    }

    public void setIdMetodo(String idMetodo) {
        this.idMetodo = idMetodo;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }
    
    
}
