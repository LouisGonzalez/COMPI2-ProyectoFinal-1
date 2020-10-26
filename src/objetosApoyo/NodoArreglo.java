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
public class NodoArreglo {

    private int size;
    private String etiqueta;

    public NodoArreglo(int size, String etiqueta) {
        this.size = size;
        this.etiqueta = etiqueta;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }
    
    
    
}
