/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import Tablas.TablaSimbolos;
import java.util.ArrayList;

/**
 *
 * @author luisGonzalez
 */
public class ManejoTexto {

    public void manejarTexto(TablaSimbolos tabla, String texto) {
        ArrayList<String> textoLineas = new ArrayList<>();
        String[] txt = texto.split("\n");
        for (int i = 0; i < txt.length; i++) {
            textoLineas.add(txt[i]);
        }
        Integer iterador = null;
        for (int i = 1; i < textoLineas.size(); i++) {
            if (textoLineas.get(i).equals("%%JAVA")) {
                iterador = i;
                break;
            }
        }
        PanelPrincipal.lineasVb = iterador;
        for (int i = 1; i < iterador; i++) {
            PanelPrincipal.codigoVb += textoLineas.get(i)+"\n";
        }
        for (int i = 0; i < iterador; i++) {
            textoLineas.remove(i);
            i--;
            iterador = iterador - 1;
        }
        iterador = null;
        //---------------------------------------------------
        for (int i = 1; i < textoLineas.size(); i++) {
            if (textoLineas.get(i).equals("%%PY")) {
                iterador = i;
                break;
            }
        }
        PanelPrincipal.lineasJava = iterador;
        for (int i = 1; i < iterador; i++) {
            PanelPrincipal.codigoJava += textoLineas.get(i)+"\n";
        }
        for (int i = 0; i < iterador; i++) {
            textoLineas.remove(i);
            i--;
            iterador = iterador - 1;
        }
        iterador = null;
        //-------------------------------------------------------------
        for (int i = 1; i < textoLineas.size(); i++) {
            if (textoLineas.get(i).equals("%%PROGRAMA")) {
                iterador = i;
                break;
            }
        }
        PanelPrincipal.lineasPython = iterador;
        for (int i = 1; i < iterador; i++) {
            PanelPrincipal.codigoPython += textoLineas.get(i)+"\n";
        }
        for (int i = 0; i < iterador; i++) {
            textoLineas.remove(i);
            i--;
            iterador = iterador - 1;
        }
        iterador = null;
        //------------------------------------------------------------
        PanelPrincipal.lineasC = textoLineas.size();
        for (int i = 1; i < textoLineas.size(); i++) {
            PanelPrincipal.codigoC += textoLineas.get(i)+"\n";
        }
  /*      System.out.println(PanelPrincipal.lineasVb);
        System.out.println(PanelPrincipal.lineasJava);
        System.out.println(PanelPrincipal.lineasPython);
        System.out.println(PanelPrincipal.lineasC);
        int total = PanelPrincipal.lineasC+PanelPrincipal.lineasJava+PanelPrincipal.lineasPython+PanelPrincipal.lineasVb;
        System.out.println(total+"      -------------------------------------------------TOTAL--------------");
    */    
    }
    
    public void sumarVariablesPython(TablaSimbolos tabla){
        tabla.getObPython().setContEt(tabla.getObJava().getContEt()+1);
        tabla.getObPython().setContEtFin(tabla.getObJava().getContEtFin()+1);
        tabla.getObPython().setContFor(tabla.getObJava().getContFor()+1);
        tabla.getObPython().setContVars(tabla.getObJava().getContVars()+1);
        tabla.getObPython().setContWhile(tabla.getObJava().getContWhile()+1);
    }
    
    public void sumarVariablesJava(TablaSimbolos tabla){
        tabla.getObJava().setContEt(tabla.getObVb().getContEt()+1);
        tabla.getObJava().setContEtFin(tabla.getObVb().getContEtFin()+1);
        tabla.getObJava().setContFor(tabla.getObVb().getContFor()+1);
        tabla.getObJava().setContWhile(tabla.getObVb().getContEtWhile()+1);
        tabla.getObJava().setContVars(tabla.getObVb().getContVars()+1);
        
    }
    
    public void sumarVariablesC(TablaSimbolos tabla){
        tabla.getObC().setContEt(tabla.getObPython().getContEt()+1);
        tabla.getObC().setContEtFin(tabla.getObPython().getContEtFin()+1);
        tabla.getObC().setContFor(tabla.getObPython().getContFor()+1);
        tabla.getObC().setContVars(tabla.getObPython().getContVars()+1);
        tabla.getObC().setContWhile(tabla.getObPython().getContWhile()+1);
    }
    

}
