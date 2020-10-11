/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

/**
 *
 * @author luisitopapurey
 */
public class DatosVar {
 
    private String id;
    private int nivel;
    private String padre;

    public DatosVar(String id, int nivel, String padre) {
        this.id = id;
        this.nivel = nivel;
        this.padre = padre;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getPadre() {
        return padre;
    }

    public void setPadre(String padre) {
        this.padre = padre;
    }

  
    
    
}
