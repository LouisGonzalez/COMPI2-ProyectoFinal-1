/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import ObjetosC.ClasesJava;
import ObjetosC.Constantes;
import ObjetosC.VerifObjetos;
import Tablas.TablaSimbolos;
import interfaz.PanelPrincipal;
import java.util.ArrayList;
import objetos.Arreglo;
import objetos.Metodo;
import objetos.ObjetosC;
import objetos.ObjetosJAVA;
import objetos.Variable;
import objetosApoyo.NodoBoolean;
import verificaciones.VerifC;

/**
 *
 * @author luisGonzalez
 */
public class OperacionesC {

    //activa un lenguaje para poder usar sus clases y/o metodos en el lenguaje principal
    public void activarLenguaje(String lenguaje, TablaSimbolos tabla, String clase, int fila, int columna) {
        if (lenguaje.equals("JAVA")) {
            if (clase.equals("*")) {
                for (int i = 0; i < tabla.getObJava().getMisClases().size(); i++) {
                    tabla.getObJava().getMisClases().get(i).setActivado(true);
                }
            } else {
                activarClase(tabla.getObJava(), clase, fila, columna);
            }
        } else if (lenguaje.equals("VB")) {
            tabla.getObVb().setActivado(true);
        } else if (lenguaje.equals("PY")) {
            tabla.getObPython().setActivado(true);
        }
    }

    //activa una clase JAVA para poder usarla en el lenguaje principal
    public void activarClase(ObjetosJAVA jv, String clase, int fila, int columna) {
        boolean encontrado = false;
        for (int i = 0; i < jv.getMisClases().size(); i++) {
            if (jv.getMisClases().get(i).getId().equals(clase)) {
                jv.getMisClases().get(i).setActivado(true);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: No existe ninguna clase con el id: " + clase + " dentro del archivo\n";

        }
    }

    //elimina todas las variables dentro de un ambito
    public void eliminarVarAmbitos(ObjetosC c, int jerarquia) {
        if (jerarquia > 1) {
            for (int i = 0; i < c.getListArreglos().size(); i++) {
                if (c.getListArreglos().get(i).getNivel() == jerarquia) {
                    c.getListArreglos().remove(i);
                    i--;
                }
            }
            for (int i = 0; i < c.getListVariables().size(); i++) {
                if (c.getListVariables().get(i).getNivel() == jerarquia) {
                    c.getListVariables().remove(i);
                    i--;
                }
            }
            for (int i = 0; i < c.getListClases().size(); i++) {
                if (c.getListClases().get(i).getNivel() == jerarquia) {
                    c.getListClases().remove(i);
                    i--;
                }
            }
        }
        eliminarAsignacionesVariables(c, jerarquia);
    }

    //eliminar asignaciones que las variables hayan tenido en ciertos ambitos
    public void eliminarAsignacionesVariables(ObjetosC c, int jerarquia) {
        for (int i = 0; i < c.getListVariables().size(); i++) {
            for (int j = 0; j < c.getListVariables().get(i).getListAsignaciones().size(); j++) {
                if (c.getListVariables().get(i).getListAsignaciones().get(j) == jerarquia) {
                    c.getListVariables().get(i).getListAsignaciones().remove(j);
                    j--;
                }
            }
            if (c.getListVariables().get(i).getListAsignaciones().isEmpty()) {
                c.getListVariables().get(i).setValor(false);
            }
        }
    }

    //agrega una nueva variable a la tabla de C
    public void agregarNuevaVar(ObjetosC c, String id, String tipoDato, String tipoVar, int nivel, boolean valor, String idClase, Integer dimension, int fila, int columna, ArrayList<String> dimensiones, String valConstante) {
        VerifC verif = new VerifC();
        boolean existe = false;
        if (nivel > 0) {
            existe = verif.verificarExistenciaVar(c, nivel, id, fila, columna);
            if (existe) {
                PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: Ya existe una variable con el id: " + id + " dentro del archivo C\n";

            } else {
                if (tipoVar.equals("Clase")) {
                    c.getListClases().add(new ClasesJava(id, idClase, nivel));
                } else if (tipoVar.equals("Arreglo")) {
                    c.getListArreglos().add(new Arreglo(id, tipoDato, nivel, dimension));
                } else if (tipoVar.equals("Constante")) {
                    c.getListConstantes().add(new Constantes(id, tipoDato, nivel, valConstante));
                } else {
                    c.getListVariables().add(new Variable(id, tipoDato, valor, nivel));
                    if(valor){
                        c.getListVariables().get(c.getListVariables().size()-1).getListAsignaciones().add(1);
                    }
                }
            }
        } else {
            existe = verif.verificarVarGlobal(c, id, nivel, fila, columna);
            if (existe) {
                PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: Ya existe una variable con el id: " + id + " dentro del archivo C\n";
            } else {
                if (tipoVar.equals("Clase")) {
                    c.getListClases().add(new ClasesJava(id, idClase, nivel));
                } else if (tipoVar.equals("Arreglo")) {
                    c.getListArreglos().add(new Arreglo(id, tipoDato, nivel, dimension));
                    for (int i = 0; i < dimensiones.size(); i++) {
                        c.getListArreglos().get(c.getListArreglos().size()-1).getDimensiones().add(dimensiones.get(i));
                    }
                    dimensiones.clear();
                } else if (tipoVar.equals("Constante")) {
                    c.getListConstantes().add(new Constantes(id, tipoDato, nivel, valConstante));
                } else {
                    c.getListVariables().add(new Variable(id, tipoDato, valor, nivel));
                    if(valor){
                        c.getListVariables().get(c.getListVariables().size()-1).getListAsignaciones().add(1);
                    }
                }
            }
        }
    }

    
    //devuelve el tipo de dato de un arreglo
    public String devolverTipoArreglo(ObjetosC c, String id, int dim, int jerarquia, int fila, int columna) {
        String tipo = "";
        VerifObjetos verif2 = new VerifObjetos();
        if (verif2.verifVector(c, jerarquia, id)) {
            if (c.getListArreglos().get(VerifObjetos.iterador).getDimension() == dim) {
                tipo = c.getListArreglos().get(VerifObjetos.iterador).getTipo();
            } else {
                PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: Error en la dimension del arreglo: " + dim + "\n";

            }
        } else if (verif2.verifVectorGlobal(c, jerarquia, id)) {
            if (c.getListArreglos().get(VerifObjetos.iterador).getDimension() == dim) {
                tipo = c.getListArreglos().get(VerifObjetos.iterador).getTipo();
            } else {
                PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: Error en la dimension del arreglo: " + dim + "\n";
            }
        } else {
            PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: Arreglo con id: " + id + " inexistente dentro del archivo.\n";
        }
        return tipo;
    }

    //devuelve el tipo de dato de una variable
    public String devolverTipoVar(ObjetosC c, int jerarquia, String id, int fila, int columna) {
        String tipo = "";
        VerifObjetos verif = new VerifObjetos();
        if (jerarquia == 0) {
            if (verif.verifIdConstGlobal(c, jerarquia, id)) {
                tipo = c.getListConstantes().get(VerifObjetos.iterador).getTipo();
            } else if (verif.verifIdVarGlobal(c, jerarquia, id)) {
                tipo = c.getListVariables().get(VerifObjetos.iterador).getTipo();
            }
        } else {
            if (!verif.verifIdConst(c, jerarquia, id)) {
                if (!verif.verifIdVar(c, jerarquia, id)) {
                    if (verif.verifIdConstGlobal(c, jerarquia, id)) {
                        tipo = c.getListConstantes().get(VerifObjetos.iterador).getTipo();
                    } else if (verif.verifIdVarGlobal(c, jerarquia, id)) {
                        tipo = c.getListVariables().get(VerifObjetos.iterador).getTipo();
                    }
                } else {
                    tipo = c.getListVariables().get(VerifObjetos.iterador).getTipo();
                }
            } else {
                tipo = c.getListConstantes().get(VerifObjetos.iterador).getTipo();
            }
        }
        if (tipo.equals("")) {
            PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: La variable: " + id + " no existe dentro del archivo\n";
        }
        return tipo;
    }

    //mediante parametros ddescritos se busca un constructor 
    public void crearClase(TablaSimbolos tabla, ArrayList<NodoBoolean> posibles, String idClase, String id, int jerarquia, int fila, int columna) {
        Integer itClase = null;
        boolean encontrado = false;
        for (int i = 0; i < tabla.getObJava().getMisClases().size(); i++) {
            if (tabla.getObJava().getMisClases().get(i).getId().equals(idClase)) {
                itClase = i;
                break;
            }
        }
        if (itClase != null) {
            /*for (int i = 0; i < tabla.getObJava().getMisClases().get(itClase).getMisMetodos().size(); i++) {
                if (tabla.getObJava().getMisClases().get(itClase).getMisMetodos().get(i).getIdMetodo().equals(idClase)) {
                    if (compararParametros(tabla.getObC(), tabla.getObJava().getMisClases().get(itClase).getMisMetodos().get(i), posibles)) {
                        encontrado = true;
                        break;
                    }
                }
            }*/
            encontrado = true;
            if (!encontrado) {
                if(!posibles.isEmpty()){
                    PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: No existe constructor dentro de la clase: " + idClase + " que cumpla con los parametros que se necesitan\n";
                }
            } else {
                agregarClase(tabla.getObC(), id, idClase, jerarquia, fila, columna);
            }
        } else {
            PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: No existe ninguna clase en JAVA con el id: " + idClase + "\n";

        }
        
       
        
    }

   
    public void agregarClase(ObjetosC c, String id, String idClase, int jerarquia, int fila, int columna) {
        VerifObjetos verif = new VerifObjetos();
        if (jerarquia == 0) {
            if (verif.verifClaseGlobal(c, jerarquia, id)) {
                PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: Ya existe un variable de tipo clase con id: " + id + "\n";
         /*   } else if (verif.verifIdConstGlobal(c, jerarquia, id)) {
                PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: Ya existe un variable de tipo constante con id: " + id + "\n";
            */} else if (verif.verifIdVarGlobal(c, jerarquia, id)) {
                PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: Ya existe un variable de tipo constante con id: " + id + "\n";
            } else if (verif.verifVectorGlobal(c, jerarquia, id)) {
                PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: Ya existe un arreglo con id: " + id + "\n";
            } else {
                c.getListClases().add(new ClasesJava(id, idClase, jerarquia));
            }
        } else {
            if (verif.verifClase(c, jerarquia, id)) {
                PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: Ya existe un variable de tipo clase dentro del main con id: " + id+ "\n";
            } else if (verif.verifIdConst(c, jerarquia, id)) {
                PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: Ya existe un variable de tipo constante dentro del main con id: " + id + "\n";
            } else if (verif.verifIdVar(c, jerarquia, id)) {
                PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: Ya existe un variable dentro del main con id: " + id+ "\n";
            } else if (verif.verifVector(c, jerarquia, id)) {
                PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: Ya existe un arreglo dentro del main con id: " + id + "\n";
            } else {
                c.getListClases().add(new ClasesJava(id, idClase, jerarquia));
            }
        }
    }

    public boolean compararParametros(ObjetosC c, Metodo constructor, ArrayList<NodoBoolean> posibles) {
        boolean todoCorrecto = true;
        VerifC verif = new VerifC();
        if (constructor.getMisParametros().size() == posibles.size()) {
            for (int i = 0; i < constructor.getMisParametros().size(); i++) {
                if (!constructor.getMisParametros().get(i).getTipo().equals(posibles.get(i).getTipo())) {
                    if (!verif.verificarPadre(c, posibles.get(i).getTipo(), constructor.getMisParametros().get(i).getTipo())) {
                        todoCorrecto = false;
                        break;
                    }
                }
            }
        }
        return todoCorrecto;
    }

}