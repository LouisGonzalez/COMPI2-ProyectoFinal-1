/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosApoyo;

/**
 *
 * @author luisitopapurey
 */
public class NodoBoolean {
    
    private String tipo;
    private String id;

    public NodoBoolean(String tipo, String id) {
        this.tipo = tipo;
        this.id = id;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    
}
