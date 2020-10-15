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
public class NodoFor {
    
    private String idInicio;
    private String idFin;
    private Boolean valor;

    public NodoFor(String idInicio, String idFin, Boolean valor) {
        this.idInicio = idInicio;
        this.idFin = idFin;
        this.valor = valor;
    }

    public String getIdInicio() {
        return idInicio;
    }

    public void setIdInicio(String idInicio) {
        this.idInicio = idInicio;
    }

    public String getIdFin() {
        return idFin;
    }

    public void setIdFin(String idFin) {
        this.idFin = idFin;
    }

    public Boolean getValor() {
        return valor;
    }

    public void setValor(Boolean valor) {
        this.valor = valor;
    }
    
    
    
}
