/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosC;

/**
 *
 * @author luisGonzalez
 */
public class Constantes {
    
    private String id;
    private String tipo;
    private Integer nivel;

    public Constantes(String id, String tipo, Integer nivel) {
        this.id = id;
        this.tipo = tipo;
        this.nivel = nivel;
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

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
    
    
}
