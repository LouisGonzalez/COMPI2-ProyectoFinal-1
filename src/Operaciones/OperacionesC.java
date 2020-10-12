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
import java.util.ArrayList;
import objetos.Arreglo;
import objetos.Metodo;
import objetos.ObjetosC;
import objetos.ObjetosJAVA;
import objetos.Variable;
import verificaciones.VerifC;

/**
 *
 * @author luisGonzalez
 */
public class OperacionesC {

 
    //activa un lenguaje para poder usar sus clases y/o metodos en el lenguaje principal
    public void activarLenguaje(String lenguaje, TablaSimbolos tabla, String clase) {
        if (lenguaje.equals("JAVA")) {
            if (clase.equals("*")) {
                for (int i = 0; i < tabla.getObJava().getMisClases().size(); i++) {
                    tabla.getObJava().getMisClases().get(i).setActivado(true);
                }
            } else {
                activarClase(tabla.getObJava(), clase);
            }
        } else if (lenguaje.equals("VB")) {
            tabla.getObVb().setActivado(true);
        } else if (lenguaje.equals("PY")) {
            tabla.getObPython().setActivado(true);
        }
    }

    //activa una clase JAVA para poder usarla en el lenguaje principal
    public void activarClase(ObjetosJAVA jv, String clase) {
        boolean encontrado = false;
        for (int i = 0; i < jv.getMisClases().size(); i++) {
            if (jv.getMisClases().get(i).getId().equals(clase)) {
                jv.getMisClases().get(i).setActivado(true);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No existe ninguna clase con el id: " + clase + " dentro del archivo");
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
    public void agregarNuevaVar(ObjetosC c, String id, String tipoDato, String tipoVar, int nivel, boolean valor, String idClase, Integer dimension) {
        VerifC verif = new VerifC();
        boolean existe = false;
        if (nivel > 0) {
            existe = verif.verificarExistenciaVar(c, nivel, id);
            if (existe) {
                System.out.println("Ya existe una variable con el id: " + id);
            } else {
                if (tipoVar.equals("Clase")) {
                    c.getListClases().add(new ClasesJava(id, idClase, nivel));
                } else if (tipoVar.equals("Arreglo")) {
                    c.getListArreglos().add(new Arreglo(id, tipoDato, nivel, dimension));
                } else if (tipoVar.equals("Constante")) {
                    c.getListConstantes().add(new Constantes(id, tipoDato, nivel));
                } else {
                    c.getListVariables().add(new Variable(id, tipoDato, valor, nivel));
                }
            }
        } else {
            existe = verif.verificarVarGlobal(c, id, nivel);
            if (existe) {
                System.out.println("Ya existe una variable con el id: " + id);
            } else {
                if (tipoVar.equals("Clase")) {
                    c.getListClases().add(new ClasesJava(id, idClase, nivel));
                } else if (tipoVar.equals("Arreglo")) {
                    c.getListArreglos().add(new Arreglo(id, tipoDato, nivel, dimension));
                } else if (tipoVar.equals("Constante")) {
                    c.getListConstantes().add(new Constantes(id, tipoDato, nivel));
                } else {
                    c.getListVariables().add(new Variable(id, tipoDato, valor, nivel));
                }
            }
        }
    }

    //devuelve el tipo de dato de un arreglo
    public String devolverTipoArreglo(ObjetosC c, String id, int dim, int jerarquia) {
        String tipo = "";
        VerifObjetos verif2 = new VerifObjetos();
        if (verif2.verifVector(c, jerarquia, id)) {
            if (c.getListArreglos().get(VerifObjetos.iterador).getDimension() == dim) {
                tipo = c.getListArreglos().get(VerifObjetos.iterador).getTipo();
            } else {
                System.out.println("Error en la dimension del arreglo: " + dim);
            }
        } else if (verif2.verifVectorGlobal(c, jerarquia, id)) {
            if (c.getListArreglos().get(VerifObjetos.iterador).getDimension() == dim) {
                tipo = c.getListArreglos().get(VerifObjetos.iterador).getTipo();
            } else {
                System.out.println("Error en la dimension del arreglo: " + dim);
            }
        } else {
            System.out.println("Arreglo con id: " + id + " inexistente dentro del archivo.");
        }
        return tipo;
    }

    //devuelve el tipo de dato de una variable
    public String devolverTipoVar(ObjetosC c, String id, int jerarquia) {
        String tipo = "";
        VerifObjetos verif2 = new VerifObjetos();
        if (verif2.verifIdVar(c, jerarquia, id)) {
            tipo = c.getListVariables().get(VerifObjetos.iterador).getTipo();
        } else if (verif2.verifIdVarGlobal(c, jerarquia, id)) {
            tipo = c.getListVariables().get(VerifObjetos.iterador).getTipo();
        } else {
            System.out.println("Variable: " + id + " inexistente dentro del archivo.");
        }
        return tipo;
    }

    //mediante parametros ddescritos se busca un constructor 
    public void crearClase(TablaSimbolos tabla, ArrayList<String> posibles, String idClase, String id, int jerarquia) {
        Integer itClase = null;
        boolean encontrado = false;
        for (int i = 0; i < tabla.getObJava().getMisClases().size(); i++) {
            if (tabla.getObJava().getMisClases().get(i).getId().equals(idClase)) {
                itClase = i;
                break;
            }
        }
        if (itClase != null) {
            for (int i = 0; i < tabla.getObJava().getMisClases().get(itClase).getMisMetodos().size(); i++) {
                if (tabla.getObJava().getMisClases().get(itClase).getMisMetodos().get(i).getIdMetodo().equals(idClase)) {
                    if (compararParametros(tabla.getObC(), tabla.getObJava().getMisClases().get(itClase).getMisMetodos().get(i), posibles)) {
                        encontrado = true;
                        break;
                    }
                }
            }
            if (!encontrado) {
                System.out.println("No existe constructor dentro de la clase: " + idClase + " que cumpla con los parametros que se necesitan");
            } else {
                agregarClase(tabla.getObC(), id, idClase, jerarquia);
            }
        } else {
            System.out.println("No existe ninguna clase en JAVA con el id: " + idClase);
        }
    }

    public void agregarClase(ObjetosC c, String id, String idClase, int jerarquia) {
        VerifObjetos verif = new VerifObjetos();
        if (jerarquia == 0) {
            if (verif.verifClaseGlobal(c, jerarquia, id)) {
                System.out.println("Ya existe un variable de tipo clase con id: " + id);
            } else if (verif.verifIdConstGlobal(c, jerarquia, id)) {
                System.out.println("Ya existe un variable de tipo constante con id: " + id);
            } else if (verif.verifIdVarGlobal(c, jerarquia, id)) {
                System.out.println("Ya existe un variable con id: " + id);
            } else if (verif.verifVectorGlobal(c, jerarquia, id)) {
                System.out.println("Ya existe un arreglo con id: " + id);
            } else {
                c.getListClases().add(new ClasesJava(id, idClase, jerarquia));
            }
        } else {
            if (verif.verifClase(c, jerarquia, id)) {
                System.out.println("Ya existe un variable de tipo clase dentro del main con id: " + id);
            } else if (verif.verifIdConst(c, jerarquia, id)) {
                System.out.println("Ya existe un variable de tipo constante dentro del main con id: " + id);
            } else if (verif.verifIdVar(c, jerarquia, id)) {
                System.out.println("Ya existe un variable dentro del main con id: " + id);
            } else if (verif.verifVector(c, jerarquia, id)) {
                System.out.println("Ya existe un arreglo dentro del main con id: " + id);
            } else {
                c.getListClases().add(new ClasesJava(id, idClase, jerarquia));
            }
        }
    }

    public boolean compararParametros(ObjetosC c, Metodo constructor, ArrayList<String> posibles) {
        boolean todoCorrecto = true;
        VerifC verif = new VerifC();
        if (constructor.getMisParametros().size() == posibles.size()) {
            for (int i = 0; i < constructor.getMisParametros().size(); i++) {
                if (!constructor.getMisParametros().get(i).getTipo().equals(posibles.get(i))) {
                    if (!verif.verificarPadre(c, posibles.get(i), constructor.getMisParametros().get(i).getTipo())) {
                        todoCorrecto = false;
                        break;
                    }
                }
            }
        }
        return todoCorrecto;
    }

}
