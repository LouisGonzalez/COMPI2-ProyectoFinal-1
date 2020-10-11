/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import objetos.Clase;
import objetos.Metodo;
import objetos.ObjetosJAVA;
import objetos.Parametro;
import objetos.Variable;
import verificaciones.VerifJAVA;

/**
 *
 * @author luisGonzalez
 */
public class OperacionesJAVA {

    private VerifJAVA verif = new VerifJAVA();

    //agrega una nueva clase
    public void agregarNuevaClase(ObjetosJAVA jv, String idClase) {
        if (verif.verificarIdClase(idClase, jv)) {
            System.out.println("ya existe una clase con el identificador: " + idClase);
        } else {
            jv.getMisClases().add(new Clase(idClase));
        }
    }

    //agrega un nuevo metodo
    public void agregarNuevoMetodo(String idMetodo, ObjetosJAVA jv, int iterador, String retorno) {
        if (verif.verificarIdMetodo(idMetodo, jv, iterador)) {
            System.out.println("ya existe un metodo con el identificador: " + idMetodo);
        } else {
            if (retorno.equals("void")) {
                jv.getMisClases().get(iterador).getMisMetodos().add(new Metodo(idMetodo, false, null));
            } else {
                jv.getMisClases().get(iterador).getMisMetodos().add(new Metodo(idMetodo, true, retorno));
            }
        }
    }
    
    public void agregarNuevoConstructor(ObjetosJAVA jv, String id){
        if(jv.getMisClases().get(jv.getMisClases().size()-1).getId().equals(id)){
            jv.getMisClases().get(jv.getMisClases().size()-1).getMisMetodos().add(new Metodo(id, false, null));
        } else {
            System.out.println("Nombre equivocado para creacion de constructor: "+id);
        }
    }

    //agrega el parametro al metodo
    public void agregarParametrosMetodo(String id, ObjetosJAVA jv, String tipo) {
        int itClase = jv.getMisClases().size() - 1;
        int itMetodo = jv.getMisClases().get(jv.getMisClases().size() - 1).getMisMetodos().size() - 1;
        if (verif.verifVarLocal(jv, id)) {
            System.out.println("Dentro dde los parametros ya existe una variable con el id: " + id);
        } else {
            jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisParametros().add(new Parametro(jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisParametros().size() - 1, tipo));
        }
    }

    //agrega la nueva variable dentro de los parametros al metodo en cuestion
    public void agregarVarMetodo(String id, ObjetosJAVA jv, String tipo, boolean param, int nivel) {
        int itClase = jv.getMisClases().size() - 1;
        int itMetodo = jv.getMisClases().get(jv.getMisClases().size() - 1).getMisMetodos().size() - 1;
        if (verif.verifVarLocal(jv, id)) {
            System.out.println("ya existe una variable con el id: " + id);
        } else {
            jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().add(new Variable(id, tipo, param, nivel));
            jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().get(jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().size()-1).getListAsignaciones().add(nivel);
            jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().get(jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().size()-1).setValor(true);
            jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisParametros().add(new Parametro(jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisParametros().size() - 1, tipo));
        }
    }

    //agrega una nueva variable a la clase 
    public void agregarVariable(ObjetosJAVA jv, int jerarquia, String id, String tipo, boolean valor) {
        int itClase = jv.getMisClases().size() - 1;
        if (jerarquia == 0) {
            if (verif.verifVarGlobal(jv, id)) {
                System.out.println("ya existe una variable global con el id: " + id);
            } else {
                jv.getMisClases().get(itClase).getGlobales().add(new Variable(id, tipo, valor, jerarquia));
                if(valor){
                    jv.getMisClases().get(itClase).getGlobales().get(jv.getMisClases().get(itClase).getGlobales().size()-1).getListAsignaciones().add(jerarquia);
                }
            }
        } else {
            int itMetodo = jv.getMisClases().get(itClase).getMisMetodos().size() - 1;
            if (verif.verifVarLocal(jv, id)) {
                System.out.println("ya existe una variable con el id: " + id);
            } else {
                jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().add(new Variable(id, tipo, valor, jerarquia));
                if(valor){
                    jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().get(jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().size()-1).getListAsignaciones().add(jerarquia);
                }
            }
        }
    }

    //devuelve el tipo de variable de un id si es que este existe
    public String devolverTipoVar(ObjetosJAVA jv, String idVar, int jerarquia, int itClase) {
        String tipo = "";
        boolean encontrado = false;
        if (jerarquia == 0) {
            for (int i = 0; i < jv.getMisClases().get(itClase).getGlobales().size(); i++) {
                if (jv.getMisClases().get(itClase).getGlobales().get(i).getId().equals(idVar)) {
                    tipo = jv.getMisClases().get(itClase).getGlobales().get(i).getTipo();
                    encontrado = true;
                    break;
                }
            }
        } else {
            int itMetodo = jv.getMisClases().get(itClase).getMisMetodos().size() - 1;
            for (int i = 0; i < jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().size(); i++) {
                if (jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().get(i).getId().equals(idVar)) {
                    tipo = jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().get(i).getTipo();
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                for (int j = 0; j < jv.getMisClases().get(itClase).getGlobales().size(); j++) {
                    if (jv.getMisClases().get(itClase).getGlobales().get(j).getId().equals(idVar)) {
                        tipo = jv.getMisClases().get(itClase).getGlobales().get(j).getTipo();
                        encontrado = true;
                        break;
                    }
                }
            }
        }
        if (!encontrado) {
            System.out.println("La variable " + idVar + " no existe dentro del archivo.");
        }
        return tipo;
    }

    //agrega valor a una variable previamente declarada
    public void agregarValorVar(ObjetosJAVA jv, int jerarquia, String id) {
        //si la sentencia se cumple significa que la variable ha sido definida
        int itClase = jv.getMisClases().size() - 1;
        if (jerarquia == 0) {
            for (int i = 0; i < jv.getMisClases().get(itClase).getGlobales().size(); i++) {
                if (jv.getMisClases().get(itClase).getGlobales().get(i).getId().equals(id)) {
                    jv.getMisClases().get(itClase).getGlobales().get(i).getListAsignaciones().add(jerarquia);
                    jv.getMisClases().get(itClase).getGlobales().get(i).setValor(true);
                    break;
                }
            }
        } else {
            int itMetodo = jv.getMisClases().get(itClase).getMisMetodos().size() - 1;
            for (int i = 0; i < jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().size(); i++) {
                if (jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().get(i).getId().equals(id)) {
                    jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().get(i).getListAsignaciones().add(jerarquia);
                    jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().get(i).setValor(true);
                }
            }
        }
    }

    //elimina las variables de un ambito
    public void eliminarAmbito(ObjetosJAVA jv, int jerarquia) {
        int itClase = jv.getMisClases().size() - 1;
        int itMetodo = jv.getMisClases().get(itClase).getMisMetodos().size() - 1;
        for (int i = 0; i < jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().size(); i++) {
            if (jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().get(i).getNivel() == jerarquia) {
                jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().remove(i);
                i--;
            }
        }
        for (int i = 0; i < jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().size(); i++) {
            for (int j = 0; j < jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().get(i).getListAsignaciones().size(); j++) {
                if(jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().get(i).getListAsignaciones().get(j) == jerarquia){
                    jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().get(i).getListAsignaciones().remove(j);
                    j--;
                }
            }
        }
        for (int i = 0; i < jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().size(); i++) {
            if(jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().get(i).getListAsignaciones().isEmpty()){
                jv.getMisClases().get(itClase).getMisMetodos().get(itMetodo).getMisVariables().get(i).setValor(false);
            }
        }
        
    }

    //envia un boolean dependiendo si hay returns dentro de un switch y sus case
    public Boolean retornarBoolCase(Boolean cuerpo, Boolean retorno, Boolean restoCasos) {
        Boolean aDevolver = null;
        if (restoCasos != null) {
            if (cuerpo != null) {
                if (cuerpo && retorno) {
                    aDevolver = null;
                } else if ((!cuerpo && retorno) || (cuerpo && !retorno)) {
                    if (!restoCasos) {
                        aDevolver = false;
                    } else {
                        aDevolver = true;
                    }
                } else if (!cuerpo && !retorno) {
                    if (!restoCasos) {
                        aDevolver = false;
                    } else {
                        aDevolver = true;
                    }
                }
            } else {
                if (retorno) {
                    if (!restoCasos) {
                        aDevolver = null;
                    } else {
                        aDevolver = true;
                    }
                } else {
                    aDevolver = restoCasos;
                }
            }
        }
        return aDevolver;
    }

    //comprueba al final de un metodo la validacion de los returns
    public void comprobarReturnMetodo(ObjetosJAVA jv, Boolean cuerpo, Boolean retorno) {
        if (cuerpo != null) {
            if (cuerpo && retorno) {
                System.out.println("ERROR, returns multiples");
            } else if ((!cuerpo && retorno) || (cuerpo && !retorno)) {
                int itMetodo = jv.getMisClases().get(jv.getMisClases().size() - 1).getMisMetodos().size() - 1;
                if (jv.getMisClases().get(jv.getMisClases().size() - 1).getMisMetodos().get(itMetodo).isTipo()) {
                    System.out.println("todo correcto en el manejo de returns");
                } else {
                    System.out.println("Error, metodo void no puede retornar un valor");
                }
            } else if (!cuerpo && !retorno) {
                System.out.println("ERROR, falta de parametro return en metodo");
            }
        } else {
            System.out.println("Error en return");
        }

    }

    //comprueba el manejo de returns ddentro de un if
    public Boolean retornoIf(Boolean cuerpo, Boolean retorno, Boolean resto) {
        Boolean aDevolver = null;
        if (resto != null) {
            if (cuerpo != null) {
                if ((!cuerpo && retorno) || (cuerpo && !retorno)) {
                    if (resto) {
                        aDevolver = true;
                    } else {
                        aDevolver = false;
                    }

                } else if (!cuerpo && !retorno) {
                    if (resto) {
                        aDevolver = null;
                    } else {
                        aDevolver = false;
                    }
                } else if (cuerpo && retorno) {
                    aDevolver = null;
                }
            }
        }
        return aDevolver;
    }

    public String buscarVariable(ObjetosJAVA jv, String id, int jerarquia) {
        String tipo = "";
        if (jerarquia == 0) {
            if (verif.verifVarGlobal(jv, id)) {
                tipo = jv.getMisClases().get(jv.getMisClases().size() - 1).getGlobales().get(VerifJAVA.iterador).getTipo();
            } else {
                System.out.println("La variable: " + id + " no existe dentro del archivo");
            }
        } else {
            if (verif.verifVarLocal(jv, id)) {
                int itMetodo = jv.getMisClases().get(jv.getMisClases().size() - 1).getMisMetodos().size() - 1;
                tipo = jv.getMisClases().get(jv.getMisClases().size() - 1).getMisMetodos().get(itMetodo).getMisVariables().get(VerifJAVA.iterador).getTipo();
            } else if (verif.verifVarGlobal(jv, id)) {
                tipo = jv.getMisClases().get(jv.getMisClases().size() - 1).getGlobales().get(VerifJAVA.iterador).getTipo();
            } else {
                System.out.println("La variable: " + id + " no existe dentro del archivo");
            }
        }
        return tipo;
    }

}
