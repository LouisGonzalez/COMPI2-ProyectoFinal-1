/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosC;

import objetos.Arreglo;
import objetos.ObjetosC;
import objetos.Variable;
import verificaciones.VerifC;

/**
 *
 * @author luisGonzalez
 */
public class VerifObjetos {

    public static Integer iterador = null;

    //verifica si existe un id dentro de las constantes globales
    public boolean verifIdConstGlobal(ObjetosC c, int jerarquia, String id) {
        boolean existe = false;
        for (int i = 0; i < c.getListConstantes().size(); i++) {
            if (jerarquia == 0) {
                if (c.getListConstantes().get(i).getId().equals(id)) {
                    existe = true;
                    iterador = i;
                    break;
                }
            }
        }
        return existe;
    }

    //verifica si existe un id dentro de las constantes del main
    public boolean verifIdConst(ObjetosC c, int jerarquia, String id) {
        boolean existe = false;
        for (int i = 0; i < c.getListConstantes().size(); i++) {
            if (jerarquia > 0) {
                if (c.getListConstantes().get(i).getId().equals(id)) {
                    existe = true;
                    iterador = i;
                    break;
                }
            }
        }
        return existe;
    }

    //verifica si existe un id dentro dde las variables globales
    public boolean verifIdVarGlobal(ObjetosC c, int jerarquia, String id) {
        boolean existe = false;
        for (int i = 0; i < c.getListVariables().size(); i++) {
            if (jerarquia == 0) {
                if (c.getListVariables().get(i).getId().equals(id)) {
                    existe = true;
                    iterador = i;
                    break;
                } 
            }
            
        }
        return existe;
    }

    //verifica si existe un id dentro de las variables del main
    public boolean verifIdVar(ObjetosC c, int jerarquia, String id) {
        boolean existe = false;
        for (int i = 0; i < c.getListVariables().size(); i++) {
            if (jerarquia > 0) {
                if (c.getListVariables().get(i).getId().equals(id)) {
                    existe = true;
                    iterador = i;
                    break;
                }
            }
        }
        return existe;
    }

    //verifica si existe un arreglo dentro de los arreglos globales
    public boolean verifVectorGlobal(ObjetosC c, int jerarquia, String id) {
        boolean existe = false;
        for (int i = 0; i < c.getListArreglos().size(); i++) {
            if (jerarquia == 0) {
                if (c.getListArreglos().get(i).getId().equals(id)) {
                    existe = true;
                    iterador = i;
                    break;
                }
            }
        }
        return existe;
    }

    //verifica si existe un arreglo dentro de las variables del main
    public boolean verifVector(ObjetosC c, int jerarquia, String id) {
        boolean existe = false;
        for (int i = 0; i < c.getListArreglos().size(); i++) {
            if (jerarquia > 0) {
                if (c.getListArreglos().get(i).getId().equals(id)) {
                    existe = true;
                    iterador = i;
                    break;
                }
            }
        }
        return existe;
    }

    //verifica si existe una clase dentro de las clases globales
    public boolean verifClaseGlobal(ObjetosC c, int jerarquia, String id) {
        boolean existe = false;
        for (int i = 0; i < c.getListClases().size(); i++) {
            if (jerarquia == 0) {
                if (c.getListClases().get(i).getId().equals(id)) {
                    existe = true;
                    iterador = i;
                    break;
                }
            }
        }
        return existe;
    }

    //verifica si existe un clase dentro de las variables del main
    public boolean verifClase(ObjetosC c, int jerarquia, String id) {
        boolean existe = false;
        for (int i = 0; i < c.getListClases().size(); i++) {
            if (jerarquia > 0) {
                if (c.getListClases().get(i).getId().equals(id)) {
                    existe = true;
                    iterador = i;
                    break;
                }
            }
        }
        return existe;
    }

    //verifica si una variable de tipo constante cumple con cierto tipado
    public boolean verifTipadoConstante(ObjetosC c, String id, String tipoActual, Constantes constante, VerifC verif) {
        boolean correcto = false;
        if (constante.getTipo().equals(tipoActual)) {
            correcto = true;
        } else {
            if (verif.verificarPadre(c, constante.getTipo(), tipoActual)) {
                correcto = true;
            } else {
                System.out.println("La constante: " + id + " no es compatible con la operacion");
            }
        }
        return correcto;
    }

    //verifica si una variable normal cumple con cierto tipado y contiene un valor 
    public boolean verifTipadoVar(ObjetosC c, String id, String tipoActual, Variable var, VerifC verif) {
        boolean correcto = false;
        if (var.getTipo().equals(tipoActual)) {
            if (var.getValor()) {
                correcto = true;
            }
        } else {
            if (verif.verificarPadre(c, var.getTipo(), tipoActual)) {
                if (var.getValor()) {
                    correcto = true;
                } else {
                    System.out.println("La variable: " + id + " no tiene asignado un valor.");
                }
            } else {
                System.out.println("La variable: " + id + " no es compatible con la operacion");
            }
        }
        return correcto;
    }

    //verifica si una variable de tipo arreglo cumple con cierto tipado
    public boolean verifTipadoArreglo(ObjetosC c, String id, String tipoActual, Arreglo arreglo, VerifC verif) {
        boolean correcto = false;
        if (arreglo.getTipo().equals(tipoActual)) {
            correcto = true;
        } else {
            if (verif.verificarPadre(c, arreglo.getTipo(), tipoActual)) {
                correcto = true;
            } else {
                System.out.println("El arreglo: " + id + " no es compatible con la operacion");
            }
        }
        return correcto;
    }
}
