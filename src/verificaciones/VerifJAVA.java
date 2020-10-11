/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificaciones;

import java.util.Objects;
import objetos.ObjetosJAVA;
import objetos.Variable;

/**
 *
 * @author luisGonzalez
 */
public class VerifJAVA {

    public static Integer iterador = null;

    public String a;

    public boolean verifVarGlobal(ObjetosJAVA jv, String id) {
        boolean existe = false;
        int itClase = jv.getMisClases().size() - 1;
        for (int i = 0; i < jv.getMisClases().get(itClase).getGlobales().size(); i++) {
            if (jv.getMisClases().get(itClase).getGlobales().get(i).getId().equals(id)) {
                existe = true;
                iterador = i;
                break;
            }
        }
        return existe;
    }

    public boolean verifVarLocal(ObjetosJAVA jv, String id) {
        boolean existe = false;
        int itClase = jv.getMisClases().size() - 1;
        int itMetodo = jv.getMisClases().get(itClase).getMisMetodos().size() - 1;
        for (int i = 0; i < jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().size(); i++) {
            if (jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().get(i).getId().equals(id)) {
                existe = true;
                iterador = i;
                break;
            }
        }
        return existe;
    }

    //VERIFICA SI YA EXISTE UN METODO CON UN ID ESPECIFICO
    public boolean verificarIdClase(String id, ObjetosJAVA jv) {
        boolean existe = false;
        for (int i = 0; i < jv.getMisClases().size(); i++) {
            if (jv.getMisClases().get(i).getId().equals(id)) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    //VERIFICA SI YA EXISTE UN METODO CON UN ID ESPECIFICO
    public boolean verificarIdMetodo(String id, ObjetosJAVA jv, int iterador) {
        boolean existe = false;
        for (int i = 0; i < jv.getMisClases().get(iterador).getMisMetodos().size(); i++) {
            if (jv.getMisClases().get(iterador).getMisMetodos().get(i).getIdMetodo().equals(id)) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    //float suma = 23.3 + a; --------->  verifica si a existe y si no hay problemas de tipado 
    public boolean verificarTipadoVar(ObjetosJAVA jv, String id, int jerarquia, int itClase, String tipoBase) {
        boolean todoCorrecto = false;
        if (jerarquia == 0) {
            if (verifVarGlobal(jv, id)) {
                if (jv.getMisClases().get(jv.getMisClases().size() - 1).getGlobales().get(iterador).getTipo().equals(tipoBase)) {
                    if (jv.getMisClases().get(jv.getMisClases().size() - 1).getGlobales().get(iterador).getValor()) {
                        todoCorrecto = true;
                    } else {
                        System.out.println("La variable: " + id + " es nula");
                    }
                } else {
                    if (verificarPadreVar(jv, jv.getMisClases().get(jv.getMisClases().size() - 1).getGlobales().get(iterador).getTipo(), tipoBase)) {
                        if (jv.getMisClases().get(jv.getMisClases().size() - 1).getGlobales().get(iterador).getValor()) {
                            todoCorrecto = true;
                        } else {
                            System.out.println("La variable: " + id + " es nula");
                        }
                    } else {
                        System.out.println("variable " + id + " con tipo incorrecto para entrar a la operacion");
                    }
                }
            } else {
                System.out.println("no existe una variable: " + id + " en el archivo.");
            }
        } else {
            int itMetodo = jv.getMisClases().get(itClase).getMisMetodos().size() - 1;
            if (verifVarLocal(jv, id)) {
                if (jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().get(iterador).getTipo().equals(tipoBase)) {
                    if (jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().get(iterador).getValor()) {
                        todoCorrecto = true;
                    } else {
                        System.out.println("La variable: " + id + " es nula");
                    }
                } else {
                    if (verificarPadreVar(jv, jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().get(iterador).getTipo(), tipoBase)) {
                        if (jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().get(iterador).getValor()) {
                            todoCorrecto = true;
                        } else {
                            System.out.println("La variable: " + id + " es nula");
                        }
                    } else {
                        System.out.println("variable " + id + " con tipo incorrecto para entrar a la operacion");
                    }
                }
            } else if (verifVarLocal(jv, id)) {
                if (jv.getMisClases().get(jv.getMisClases().size() - 1).getGlobales().get(iterador).getTipo().equals(tipoBase)) {
                    if (jv.getMisClases().get(jv.getMisClases().size() - 1).getGlobales().get(iterador).getValor()) {
                        todoCorrecto = true;
                    } else {
                        System.out.println("La variable: " + id + " es nula");
                    }
                } else {
                    if (verificarPadreVar(jv, jv.getMisClases().get(jv.getMisClases().size() - 1).getGlobales().get(iterador).getTipo(), tipoBase)) {
                        if (jv.getMisClases().get(jv.getMisClases().size() - 1).getGlobales().get(iterador).getValor()) {
                            todoCorrecto = true;
                        } else {
                            System.out.println("La variable: " + id + " es nula");
                        }
                    } else {
                        System.out.println("variable " + id + " con tipo incorrecto para entrar a la operacion");
                    }
                }
            } else {
                System.out.println("no existe una variable: " + id + " en el archivo.");
            }
        }
        return todoCorrecto;
    }

    //verificacion de padres entre variables
    public boolean verificarPadreVar(ObjetosJAVA jv, String tipoVar, String tipoBase) {
        boolean aceptado = false;
        for (int i = 0; i < jv.getTablaTipos().getTipos().size(); i++) {
            if (tipoVar.equals(jv.getTablaTipos().getTipos().get(i).getId())) {
                if (jv.getTablaTipos().getTipos().get(i).getPadre() != null) {
                    if (tipoBase.equals(jv.getTablaTipos().getTipos().get(i).getPadre())) {
                        aceptado = true;
                        break;
                    } else {
                        aceptado = verificarPadreVar(jv, jv.getTablaTipos().getTipos().get(i).getPadre(), tipoBase);
                    }
                }
            }
        }
        return aceptado;
    }

    public boolean verificarNumero(String tipoNum, ObjetosJAVA jv, String tipoBase, String valor) {
        boolean todoCorrecto = false;
        if (tipoBase.equals(tipoNum)) {
            todoCorrecto = true;
        } else {
            if (verificarPadreVar(jv, tipoNum, tipoBase)) {
                todoCorrecto = true;
            } else {
                System.out.println("El valor: " + valor + " no es compatible con la operacion");
            }
        }
        return todoCorrecto;
    }

    //revisa que el id que se ingrese en un input cumpla con las condiciones
    public void verifInput(ObjetosJAVA jv, String id, String tipoBase) {
        boolean todoCorrecto = false;
        int itClase = jv.getMisClases().size() - 1;
        int itMetodo = jv.getMisClases().get(itClase).getMisMetodos().size() - 1;
        if (verifVarLocal(jv, id)) {
            if (jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().get(iterador).getTipo().equals(tipoBase)) {
                todoCorrecto = true;
            } else {
                System.out.println("la variable: " + id + " no es de tipo " + tipoBase);
            }
        } else {
            if (verifVarGlobal(jv, id)) {
                if (jv.getMisClases().get(jv.getMisClases().size() - 1).getGlobales().get(iterador).getTipo().equals(tipoBase)) {
                    todoCorrecto = true;
                } else {
                    System.out.println("la variable: " + id + " no es de tipo " + tipoBase);
                }
            } else {
                System.out.println("la variable: " + id + " no existe dentro del archivo de entrada");
            }
        }
    }

    //verifica que el id condicion de un switch cumpla con las condiciones
    public void verifVarSwitch(ObjetosJAVA jv, String id) {
        int itClase = jv.getMisClases().size() - 1;
        int itMetodo = jv.getMisClases().get(itClase).getMisMetodos().size() - 1;
        if (verifVarLocal(jv, id)) {
            if (jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().get(iterador).getTipo().equals("Float")) {
                System.out.println("la variable: " + id + " es de tipo Float por lo que no es posible usarse en el switch");
            }
        } else {
            if (verifVarGlobal(jv, id)) {
                if (jv.getMisClases().get(jv.getMisClases().size() - 1).getGlobales().get(iterador).getTipo().equals("Float")) {
                    System.out.println("La variable: " + id + " es de tipo Float por lo que no es posible usarse en el switch");
                }
            } else {
                System.out.println("la variable: " + id + " no existe dentro del archivo de entrada");
            }
        }

    }
    int xx = 0;

    //agrega la variable del iterador dentro de un for
    public void agregarVarFor(ObjetosJAVA jv, String id, String dec, int jerarquia) {
        int itClase = jv.getMisClases().size() - 1;
        int itMetodo = jv.getMisClases().get(itClase).getMisMetodos().size() - 1;
        if (dec.equals("")) {
            //hace alusion a que ya existe por lo que hay que hacer la comprobacion
            if (verifVarLocal(jv, id)) {
                if (jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().get(iterador).getTipo().equals("Integer")) {

                } else {
                    //verificacion padre
                    if (verificarPadreVar(jv, jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().get(iterador).getTipo(), "Integer")) {

                    } else {
                        System.out.println("El tipo de la variable: " + id + " no es compatible como para ser introducido en un for");
                    }
                }
            } else {
                if (verifVarGlobal(jv, id)) {
                    if (jv.getMisClases().get(jv.getMisClases().size() - 1).getGlobales().get(iterador).getTipo().equals("Integer")) {

                    } else {
                        if (verificarPadreVar(jv, jv.getMisClases().get(jv.getMisClases().size() - 1).getGlobales().get(iterador).getTipo(), "Integer")) {

                        } else {
                            System.out.println("El tipo de la variable " + id + " no es compatible como para ser introducido en un for");
                        }
                    }
                } else {
                    System.out.println("la variable: " + id + " no existe dentro del archivo de entrada");
                }
            }
        } else {
            //acaba de ser declarada por lo que hay que comprobar que no haya una sentenciada antes
            if (verifVarLocal(jv, id)) {
                System.out.println("Ya existe una variable: " + id + " declarada previamente");
            } else {
                if (verifVarGlobal(jv, id)) {
                    System.out.println("Ya existe una variable: " + id + " declarada previamente");
                } else {
                    //agregar variable al metodo
                    jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().add(new Variable(id, dec, true, jerarquia));
                }
            }

        }
    }

    //verifica que todas las sentencias esten de forma correcta
    public void comprobarFor(ObjetosJAVA jv, String id, String dec, int jerarquia) {
       /** if (g) {
        } else {
            System.out.println("Problemas en el for...");
        }*/
    }

    public String verificarTipoOperacion(ObjetosJAVA jv, String dato1, String dato2) {
        String tipo = "";
        Integer nivelDato1 = null, nivelDato2 = null;
        for (int i = 0; i < jv.getTablaTipos().getTipos().size(); i++) {
            if (jv.getTablaTipos().getTipos().get(i).getId().equals(dato1)) {
                nivelDato1 = jv.getTablaTipos().getTipos().get(i).getNivel();
                break;
            }
        }
        for (int i = 0; i < jv.getTablaTipos().getTipos().size(); i++) {
            if (jv.getTablaTipos().getTipos().get(i).getId().equals(dato2)) {
                nivelDato2 = jv.getTablaTipos().getTipos().get(i).getNivel();
                break;
            }
        }
        if (Objects.equals(nivelDato1, nivelDato2)) {
            tipo = dato1;
        } else if (nivelDato1 > nivelDato2) {
            if (verificarPadreVar(jv, dato2, dato1)) {
                tipo = dato1;
            }
        } else {
            if (verificarPadreVar(jv, dato1, dato2)) {
                tipo = dato2;
            }
        }
        return tipo;
    }

}
