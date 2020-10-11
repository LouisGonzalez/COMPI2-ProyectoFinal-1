/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author luisGonzalez
 */
public class Arreglo {
    
    private String id;  
    private String tipo;
    private Integer nivel;
    private Integer dimension;

    public Arreglo(String id, String tipo, Integer nivel, Integer dimension) {
        this.id = id;
        this.tipo = tipo;
        this.nivel = nivel;
        this.dimension = dimension;
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

    public Integer getDimension() {
        return dimension;
    }

    public void setDimension(Integer dimension) {
        this.dimension = dimension;
    }
    
    
    
}
