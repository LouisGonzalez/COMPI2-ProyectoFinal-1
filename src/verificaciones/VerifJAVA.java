/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificaciones;

import interfaz.PanelPrincipal;
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
    public boolean verificarTipadoVar(ObjetosJAVA jv, String id, int jerarquia, int itClase, String tipoBase, int fila, int columna) {
        boolean todoCorrecto = false;
        if (jerarquia == 0) {
            if (verifVarGlobal(jv, id)) {
                if (jv.getMisClases().get(jv.getMisClases().size() - 1).getGlobales().get(iterador).getTipo().equals(tipoBase)) {
                    if (jv.getMisClases().get(jv.getMisClases().size() - 1).getGlobales().get(iterador).getValor()) {
                        todoCorrecto = true;
                    } else {
                        PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: La variable " + id + " no tiene un valor asignado.\n";
                    }
                } else {
                    if (verificarPadreVar(jv, jv.getMisClases().get(jv.getMisClases().size() - 1).getGlobales().get(iterador).getTipo(), tipoBase)) {
                        if (jv.getMisClases().get(jv.getMisClases().size() - 1).getGlobales().get(iterador).getValor()) {
                            todoCorrecto = true;
                        } else {
                            PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: La variable " + id + " no tiene un valor asignado.\n";
                        }
                    } else {
                        PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: La variable " + id + " no es compatible con el tipo de operacion.\n";
                    }
                }
            } else {
                PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: No existe ninguna variable: " + id + " dentro del archivo JAVA.\n";
            }
        } else {
            int itMetodo = jv.getMisClases().get(itClase).getMisMetodos().size() - 1;
            if (verifVarLocal(jv, id)) {
                if (jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().get(iterador).getTipo().equals(tipoBase)) {
                    if (jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().get(iterador).getValor()) {
                        todoCorrecto = true;
                    } else {
                        PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: La variable " + id + " no tiene un valor asignado.\n";
                    }
                } else {
                    if (verificarPadreVar(jv, jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().get(iterador).getTipo(), tipoBase)) {
                        if (jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().get(iterador).getValor()) {
                            todoCorrecto = true;
                        } else {
                            PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: La variable " + id + " no tiene un valor asignado.\n";
                        }
                    } else {
                        PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: La variable " + id + " no es compatible con el tipo de operacion.\n";
                    }
                }
            } else if (verifVarGlobal(jv, id)) {
                if (jv.getMisClases().get(jv.getMisClases().size() - 1).getGlobales().get(iterador).getTipo().equals(tipoBase)) {
                    if (jv.getMisClases().get(jv.getMisClases().size() - 1).getGlobales().get(iterador).getValor()) {
                        todoCorrecto = true;
                    } else {
                        PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: La variable " + id + " no tiene un valor asignado.\n";
                    }
                } else {
                    if (verificarPadreVar(jv, jv.getMisClases().get(jv.getMisClases().size() - 1).getGlobales().get(iterador).getTipo(), tipoBase)) {
                        if (jv.getMisClases().get(jv.getMisClases().size() - 1).getGlobales().get(iterador).getValor()) {
                            todoCorrecto = true;
                        } else {
                            PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: La variable " + id + " no tiene un valor asignado.\n";
                        }
                    } else {
                        PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: La variable " + id + " no es compatible con el tipo de operacion.\n";
                    }
                }
            } else {
                PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: No existe ninguna vsssssariable: " + id + " dentro del archivo JAVA.\n";
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

    public boolean verificarNumero(String tipoNum, ObjetosJAVA jv, String tipoBase, String valor, int fila, int columna) {
        boolean todoCorrecto = false;
        if (tipoBase.equals(tipoNum)) {
            todoCorrecto = true;
        } else {
            if (verificarPadreVar(jv, tipoNum, tipoBase)) {
                todoCorrecto = true;
            } else {
                PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: El valor " + valor + " no es compatible con el tipo de operacion.\n";

            }
        }
        return todoCorrecto;
    }

    //revisa que el id que se ingrese en un input cumpla con las condiciones
    public void verifInput(ObjetosJAVA jv, String id, String tipoBase, int fila, int columna) {
        boolean todoCorrecto = false;
        int itClase = jv.getMisClases().size() - 1;
        int itMetodo = jv.getMisClases().get(itClase).getMisMetodos().size() - 1;
        if (verifVarLocal(jv, id)) {
            if (jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().get(iterador).getTipo().equals(tipoBase)) {
                todoCorrecto = true;
            } else {
                PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: La variable " + id + " no es de tipo: " + tipoBase + "\n";

            }
        } else {
            if (verifVarGlobal(jv, id)) {
                if (jv.getMisClases().get(jv.getMisClases().size() - 1).getGlobales().get(iterador).getTipo().equals(tipoBase)) {
                    todoCorrecto = true;
                } else {
                    PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: La variable " + id + " no es de tipo: " + tipoBase + "\n";
                }
            } else {
                PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: La variable " + id + " no existe dentro del archivo JAVA\n";

            }
        }
    }

    //verifica que el id condicion de un switch cumpla con las condiciones
    public void verifVarSwitch(ObjetosJAVA jv, String id, int fila, int columna) {
        int itClase = jv.getMisClases().size() - 1;
        int itMetodo = jv.getMisClases().get(itClase).getMisMetodos().size() - 1;
        if (verifVarLocal(jv, id)) {
            if (jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().get(iterador).getTipo().equals("Float")) {
                PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: La variable " + id + " es de tipo Float por lo que no es posible usarla dentro de un switch\n";

            }
        } else {
            if (verifVarGlobal(jv, id)) {
                if (jv.getMisClases().get(jv.getMisClases().size() - 1).getGlobales().get(iterador).getTipo().equals("Float")) {
                    PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: La variable " + id + " es de tipo Float por lo que no es posible usarla dentro de un switch\n";
                }
            } else {
                PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: No existe una variable " + id + " dentro del archivo JAVA\n";

            }
        }

    }

    //agrega la variable del iterador dentro de un for
    public void agregarVarFor(ObjetosJAVA jv, String id, String dec, int jerarquia, int fila, int columna) {
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
                        PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: La variable " + id + " no es compatible como iterador de un for\n";
                    }
                }
            } else {
                if (verifVarGlobal(jv, id)) {
                    if (jv.getMisClases().get(jv.getMisClases().size() - 1).getGlobales().get(iterador).getTipo().equals("Integer")) {

                    } else {
                        if (verificarPadreVar(jv, jv.getMisClases().get(jv.getMisClases().size() - 1).getGlobales().get(iterador).getTipo(), "Integer")) {

                        } else {
                            PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: La variable " + id + " no es compatible como iterador de un for\n";
                        }
                    }
                } else {
                    PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: No existe una variable " + id + " dentro del archivo JAVA\n";
                }
            }
        } else {
            //acaba de ser declarada por lo que hay que comprobar que no haya una sentenciada antes
            if (verifVarLocal(jv, id)) {
                PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: Ya existe una variable id" + id + " dentro del archivo JAVA\n";

            } else {
                if (verifVarGlobal(jv, id)) {
                    PanelPrincipal.errores += "Fila: " + fila + " Columna: " + columna + " Tipo de error: SEMANTICO - Causa: Ya existe una variable id" + id + " dentro del archivo JAVA\n";
                } else {
                    //agregar variable al metodo
                    jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().add(new Variable(id, dec, true, jerarquia));
                }
            }

        }
    }

    //verifica que todas las sentencias esten de forma correcta
    public void comprobarFor(ObjetosJAVA jv, String id, String dec, int jerarquia) {
        /**
         * if (g) { } else { System.out.println("Problemas en el for..."); }
         */
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
