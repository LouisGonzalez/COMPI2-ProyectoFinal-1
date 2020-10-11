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
        for (int i = 1; i < textoLineas.size(); i++) {
            PanelPrincipal.codigoC += textoLineas.get(i)+"\n";
        }
      
    }

}
