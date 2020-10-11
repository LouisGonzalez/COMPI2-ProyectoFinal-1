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
public class ClasesJava {
    
    private String id;
    private String idClase;
    private Integer nivel;

    public ClasesJava(String id, String idClase, Integer nivel) {
        this.id = id;
        this.idClase = idClase;
        this.nivel = nivel;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdClase() {
        return idClase;
    }

    public void setIdClase(String idClase) {
        this.idClase = idClase;
    }
    
    
    
}
