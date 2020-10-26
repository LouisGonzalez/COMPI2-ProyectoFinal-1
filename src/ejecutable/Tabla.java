/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejecutable;

/**
 *
 * @author luisGonzalez
 */
public class Tabla {
    
    private String id;
    private String tipo;
    private Integer posMemoria;
    private String ambito;
    private Integer size;
    private boolean esArreglo = false;
    private String rol;
    private String lenguaje;
    private String listParametros = "";
    private boolean chequeado = false;
    //sirve para cambiar el nombre del ambito de un parametro
    private boolean paramMarcado = false;

    public Tabla(String id, String tipo, Integer posMemoria, String ambito, Integer size, String rol, String lenguaje) {
        this.id = id;
        this.tipo = tipo;
        this.posMemoria = posMemoria;
        this.ambito = ambito;
        this.size = size;
        this.rol = rol;
        this.lenguaje = lenguaje;       
    }

    public boolean isParamMarcado() {
        return paramMarcado;
    }

    public void setParamMarcado(boolean paramMarcado) {
        this.paramMarcado = paramMarcado;
    }

    public boolean isChequeado() {
        return chequeado;
    }

    public void setChequeado(boolean chequeado) {
        this.chequeado = chequeado;
    }

    public String getListParametros() {
        return listParametros;
    }

    public void setListParametros(String listParametros) {
        this.listParametros = listParametros;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
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

    public Integer getPosMemoria() {
        return posMemoria;
    }

    public void setPosMemoria(Integer posMemoria) {
        this.posMemoria = posMemoria;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public boolean isEsArreglo() {
        return esArreglo;
    }

    public void setEsArreglo(boolean esArreglo) {
        this.esArreglo = esArreglo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
    
}
