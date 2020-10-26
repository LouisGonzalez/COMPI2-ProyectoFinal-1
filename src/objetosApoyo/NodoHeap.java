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
public class NodoHeap {
    
    private String posMemoria;
    private Boolean enMetodo;

    public NodoHeap(String posMemoria, Boolean enMetodo) {
        this.posMemoria = posMemoria;
        this.enMetodo = enMetodo;
    }

    public String getPosMemoria() {
        return posMemoria;
    }

    public void setPosMemoria(String posMemoria) {
        this.posMemoria = posMemoria;
    }

    public Boolean getEnMetodo() {
        return enMetodo;
    }

    public void setEnMetodo(Boolean enMetodo) {
        this.enMetodo = enMetodo;
    }
    
    
    
}
