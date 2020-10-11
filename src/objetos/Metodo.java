/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.util.ArrayList;

/**
 *
 * @author luisGonzalez
 */
public class Metodo {

    private String idMetodo;
    private ArrayList<Variable> misVariables = new ArrayList<>();
    //tipo se refiere a si devuelve o no un valor
    private boolean tipo;
    //retorno ->  int, char, float
    private String retorno;
    private ArrayList<Parametro> misParametros = new ArrayList<>();

    public Metodo(String idMetodo, boolean tipo, String retorno) {
        this.idMetodo = idMetodo;
        this.tipo = tipo;
        this.retorno = retorno;
    }

    public ArrayList<Parametro> getMisParametros() {
        return misParametros;
    }

    public void setMisParametros(ArrayList<Parametro> misParametros) {
        this.misParametros = misParametros;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }
   
    public String getRetorno() {
        return retorno;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }

    public String getIdMetodo() {
        return idMetodo;
    }

    public void setIdMetodo(String idMetodo) {
        this.idMetodo = idMetodo;
    }

    public ArrayList<Variable> getMisVariables() {
        return misVariables;
    }

    public void setMisVariables(ArrayList<Variable> misVariables) {
        this.misVariables = misVariables;
    }

}
