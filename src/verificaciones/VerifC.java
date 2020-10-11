/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificaciones;

import ObjetosC.VerifObjetos;
import Operaciones.OperacionesC;
import Tablas.TablaSimbolos;
import gramaticaC.SintaxC;
import java.util.Objects;
import objetos.Clase;
import objetos.Metodo;
import objetos.ObjetosC;
import objetos.ObjetosJAVA;

/**
 *
 * @author luisGonzalez
 */
public class VerifC {

    private String claseJava = "";

    //verifica si una variable existe dentro del archivo C
    public boolean verificarExistenciaVar(ObjetosC c, int jerarquia, String id) {
        VerifObjetos verif = new VerifObjetos();
        if (jerarquia == 0) {
            return verificarVarGlobal(c, id, jerarquia);
        } else {
            boolean existe = false;
            if (!verif.verifIdVar(c, jerarquia, id)) {
                if (!verif.verifVector(c, jerarquia, id)) {
                    if (verif.verifClase(c, jerarquia, id)) {
                        existe = true;
                        System.out.println("Ya existe un objeto clase con el id: " + id);
                    }
                } else {
                    existe = true;
                    System.out.println("Ya existe un arreglo con el id: " + id);
                }
            } else {
                existe = true;
                System.out.println("Ya existe una variable con el id: " + id);
            }
            VerifObjetos.iterador = null;
            return existe;
        }
    }

    public boolean verifExistenciaArreglo(ObjetosC c, int jerarquia, String id) {
        boolean existe = false;
        VerifObjetos verif = new VerifObjetos();
        if (jerarquia == 0) {
            if (verif.verifVectorGlobal(c, jerarquia, id)) {
                existe = true;
            }
        } else {
            if (!verif.verifVector(c, jerarquia, id)) {
                if (verif.verifVectorGlobal(c, jerarquia, id)) {
                    existe = true;
                }
            } else {
                existe = true;
            }
        }
        return existe;
    }

    //verifica si dentro de cualquier tipo de variable global ya existe una con un nombre especifico
    public boolean verificarVarGlobal(ObjetosC c, String id, int jerarquia) {
        boolean existe = false;
        VerifObjetos verif = new VerifObjetos();
        if (!verif.verifIdConstGlobal(c, jerarquia, id)) {
            if (!verif.verifIdVarGlobal(c, jerarquia, id)) {
                if (!verif.verifVectorGlobal(c, jerarquia, id)) {
                    if (verif.verifClaseGlobal(c, jerarquia, id)) {
                        existe = true;
                        System.out.println("Ya existe un objeto clase con el id: " + id);
                    }
                } else {
                    existe = true;
                    System.out.println("Ya existe un arreglo con el id: " + id);
                }
            } else {
                existe = true;
                System.out.println("Ya existe una variable con el id: " + id);
            }
        } else {
            existe = true;
            System.out.println("Ya existe una constantee con el id: " + id);
        }
        return existe;
    }

    //verifica si una clase esta activada dentro del programa principal
    public boolean verificarClaseJava(ObjetosJAVA jv, String clase) {
        boolean activo = false;
        for (int i = 0; i < jv.getMisClases().size(); i++) {
            if (jv.getMisClases().get(i).getId().equals(clase)) {
                activo = jv.getMisClases().get(i).isActivado();
                break;
            }
        }
        return activo;
    }

    //verifica si un lenguaje o clase(en caso dde java) esta activa, esto mediante los include
    public boolean verificarLenguajeActivo(TablaSimbolos tabla, String lenguaje, String objetoClase, int jerarquia) {
        boolean activado = false;
        if (lenguaje.equals("PY")) {
            if (tabla.getObPython().isActivado()) {
                activado = true;
            } else {
                System.out.println("Lenguaje PYTHON no activado dentro del archivo principal.");
            }
        } else if (lenguaje.equals("VB")) {
            if (tabla.getObVb().isActivado()) {
                activado = true;
            } else {
                System.out.println("Lenguaje Visual Basic no activado dentro del archivo principal");
            }
        } else if (lenguaje.equals("JAVA")) {
            String idClase = "";
            if (jerarquia == 0) {
                for (int i = 0; i < tabla.getObC().getListClases().size(); i++) {
                    if (tabla.getObC().getListClases().get(i).getNivel() == jerarquia) {
                        if (tabla.getObC().getListClases().get(i).getId().equals(objetoClase)) {
                            idClase = tabla.getObC().getListClases().get(i).getIdClase();
                            break;
                        }
                    }
                }
            } else {
                for (int i = 0; i < tabla.getObC().getListClases().size(); i++) {
                    if (tabla.getObC().getListClases().get(i).getNivel() == jerarquia) {
                        if (tabla.getObC().getListClases().get(i).getId().equals(objetoClase)) {
                            idClase = tabla.getObC().getListClases().get(i).getIdClase();
                            break;
                        }
                    }
                }
                if (idClase.equals("")) {
                    for (int i = 0; i < tabla.getObC().getListClases().size(); i++) {
                        if (tabla.getObC().getListClases().get(i).getNivel() > 0) {
                            if (tabla.getObC().getListClases().get(i).getId().equals(objetoClase)) {
                                idClase = tabla.getObC().getListClases().get(i).getIdClase();
                                break;
                            }
                        }
                    }
                }
            }
            if (!idClase.equals("")) {
                activado = verificarClaseJava(tabla.getObJava(), idClase);
                if (!activado) {
                    System.out.println("Clase: " + idClase + " de lenguaje JAVA no activada dentro del archivo principal");
                } else {
                    claseJava = idClase;
                }
            } else {
                System.out.println("no existe ningun objeto clase con id: " + objetoClase);
            }
        }
        return activado;
    }

    //verifica si el tipo de dato corresponde al valor que se busca
    public boolean verificarNumero(ObjetosC c, String tipoVar, String tipoActual, String valor) {
        boolean todoCorrecto = false;
        if (tipoActual != null) {
            if (tipoActual.equals(tipoVar)) {
                todoCorrecto = true;
            } else {
                if (verificarPadre(c, tipoVar, tipoActual)) {
                    todoCorrecto = true;
                } else {
                    System.out.println("El valor: " + valor + " no es compatible con la operacion.");
                }
            }
        }
        return todoCorrecto;
    }

    //verificacion de padres para una variable especifica
    public boolean verificarPadre(ObjetosC c, String tipoVar, String tipoActual) {
        boolean aceptado = false;
        for (int i = 0; i < c.getTablaTipos().getTipos().size(); i++) {
            if (tipoVar.equals(c.getTablaTipos().getTipos().get(i).getId())) {
                if (c.getTablaTipos().getTipos().get(i).getPadre() != null) {
                    if (c.getTablaTipos().getTipos().get(i).getPadre().equals(tipoActual)) {
                        aceptado = true;
                        break;
                    } else {
                        aceptado = verificarPadre(c, c.getTablaTipos().getTipos().get(i).getPadre(), tipoActual);
                    }
                }
            }
        }
        return aceptado;
    }

    //verifica si el metodo existe, si existe ver si es del mismo tipo que se necesita
    public boolean verificarMetodoOp(TablaSimbolos tabla, String tipoActual, String lenguaje, String objetoClase, int jerarquia, String idMetodo) {
        boolean metodoAceptado = false;
        if (verificarLenguajeActivo(tabla, lenguaje, objetoClase, jerarquia)) {
            if (lenguaje.equals("PY")) {
                /*FALTA*/
            } else if (lenguaje.equals("VB")) {
                for (int i = 0; i < tabla.getObVb().getMisMetodos().size(); i++) {
                    if (tabla.getObVb().getMisMetodos().get(i).getIdMetodo().equals(idMetodo)) {
                        metodoAceptado = verificarTipoMetodo(tabla.getObC(), tabla.getObVb().getMisMetodos().get(i), tipoActual);
                        if (metodoAceptado) {
                            SintaxC.itMetodo = i;
                        }
                        break;
                    }
                }
                if (!metodoAceptado) {
                    SintaxC.itMetodo = null;
                }
            } else if (lenguaje.equals("JAVA")) {
                Clase aUsar = devolverClaseJava(claseJava, tabla.getObJava());
                for (int i = 0; i < aUsar.getMisMetodos().size(); i++) {
                    if (aUsar.getMisMetodos().get(i).getIdMetodo().equals(idMetodo)) {
                        metodoAceptado = verificarTipoMetodo(tabla.getObC(), aUsar.getMisMetodos().get(i), tipoActual);
                        if (metodoAceptado) {
                            SintaxC.itMetodo = i;
                        }
                        break;
                    }
                }
                if (!metodoAceptado) {
                    SintaxC.itMetodo = null;
                }
            }
        }
        return metodoAceptado;
    }

    //verifica unicamente si el metodo existe
    public boolean verificarMetodo(TablaSimbolos tabla, String lenguaje, String objetoClase, int jerarquia, String idMetodo) {
        boolean existe = false;
        if (verificarLenguajeActivo(tabla, lenguaje, objetoClase, jerarquia)) {
            if (lenguaje.equals("PY")) {
                /*PENDIENT4E*/
            } else if (lenguaje.equals("VB")) {
                for (int i = 0; i < tabla.getObVb().getMisMetodos().size(); i++) {
                    if (tabla.getObVb().getMisMetodos().get(i).getIdMetodo().equals(idMetodo)) {
                        existe = true;
                        SintaxC.itMetodo = i;
                        break;
                    }
                }
                if (!existe) {
                    SintaxC.itMetodo = null;
                    System.out.println("No existe ningun metodo en VB con el id: " + idMetodo);
                }
            } else if (lenguaje.equals("JAVA")) {
                Clase aUsar = devolverClaseJava(claseJava, tabla.getObJava());
                for (int i = 0; i < aUsar.getMisMetodos().size(); i++) {
                    if (aUsar.getMisMetodos().get(i).getIdMetodo().equals(idMetodo)) {
                        existe = true;
                        SintaxC.itMetodo = i;
                        break;
                    }
                }
                if (!existe) {
                    SintaxC.itMetodo = null;
                    System.out.println("No existe ningun metodo en la clase: " + aUsar.getId() + " con el id: " + idMetodo);
                }
            }
        }
        return existe;
    }

    //verifica que al invocar un metodo contenga cada uno de los parametros establecido
    public String verifParametrosMetodo(TablaSimbolos tabla, int iterador, String lenguaje, Clase clase) {
        String lenUsar = "";
        if (SintaxC.itMetodo != null) {
            if (lenguaje.equals("PY")) {
                /*PENDIENTE*/
            } else if (lenguaje.equals("JAVA")) {
                if (clase.getMisMetodos().get(SintaxC.itMetodo).getMisParametros().size() > iterador) {
                    lenUsar = clase.getMisMetodos().get(SintaxC.itMetodo).getMisParametros().get(iterador).getTipo();
                }
            } else if (lenguaje.equals("VB")) {
                if (tabla.getObVb().getMisMetodos().get(SintaxC.itMetodo).getMisParametros().size() > iterador) {
                    lenUsar = tabla.getObVb().getMisMetodos().get(SintaxC.itMetodo).getMisParametros().get(iterador).getTipo();
                }
            }
        }
        return lenUsar;
    }

    public boolean verUltimoParametro(TablaSimbolos tabla, int iterador, String lenguaje, Clase clase) {
        boolean correcto = false;
        if (SintaxC.itMetodo != null) {
            if (lenguaje.equals("PY")) {
                /*PENDIENTE*/
            } else if (lenguaje.equals("JAVA")) {
                correcto = (clase.getMisMetodos().get(SintaxC.itMetodo).getMisParametros().size() == iterador);
                if (!correcto) {
                    System.out.println("Num de parametros invalido  para metodo: " + clase.getMisMetodos().get(SintaxC.itMetodo).getIdMetodo());
                }
            } else if (lenguaje.equals("VB")) {
                System.out.println(SintaxC.itMetodo);
                correcto = (tabla.getObVb().getMisMetodos().get(SintaxC.itMetodo).getMisParametros().size() == iterador);
                if (!correcto) {
                    System.out.println("--------------------------------------------------------");
                    System.out.println(tabla.getObVb().getMisMetodos().get(SintaxC.itMetodo).getMisParametros().size());
                    System.out.println(iterador);
                    System.out.println("Num de parametros invalido  para metodo: " + tabla.getObVb().getMisMetodos().get(SintaxC.itMetodo).getIdMetodo());
                }
            }
        }
        return correcto;
    }

    public boolean verificarTipoMetodo(ObjetosC c, Metodo metodo, String tipoActual) {
        boolean todoCorrecto = false;
        if (metodo.isTipo()) {
            if (metodo.getRetorno().equals(tipoActual)) {
                todoCorrecto = true;
            } else {
                if (verificarPadre(c, metodo.getRetorno(), tipoActual)) {
                    todoCorrecto = true;
                } else {
                    System.out.println("El metodo: " + metodo.getIdMetodo() + " no es compatible con la operacion");
                }
            }
        } else {
            System.out.println("El metodo: " + metodo.getIdMetodo() + " no devuelve un valor, por lo que no puede usarse para asignaciones.");
        }
        return todoCorrecto;
    }

    public Clase devolverClaseJava(String id, ObjetosJAVA jv) {
        Clase aDevolver = null;
        for (int i = 0; i < jv.getMisClases().size(); i++) {
            if (jv.getMisClases().get(i).getId().equals(id)) {
                aDevolver = jv.getMisClases().get(i);
            }
        }
        return aDevolver;
    }

    //int x = 2 + y; -> verifica que y exista y sea del mismo tipo que x
    public boolean verificarIdOperacion(ObjetosC c, String id, int jerarquia, String tipoActual) {
        VerifObjetos verif = new VerifObjetos();
        boolean correcto = false;
        boolean existe = false;
        if (tipoActual != null) {
            if (jerarquia == 0) {
                if (verif.verifIdConstGlobal(c, jerarquia, id)) {
                    correcto = verif.verifTipadoConstante(c, id, tipoActual, c.getListConstantes().get(VerifObjetos.iterador), this);
                } else if (verif.verifIdVarGlobal(c, jerarquia, id)) {
                    correcto = verif.verifTipadoVar(c, id, tipoActual, c.getListVariables().get(VerifObjetos.iterador), this);
                } else {
                    System.out.println("no existe ninguna variable con id: " + id + " dentro del archivo");
                }
            } else {
                /*COMPROBACIONES PARA VER SI LA VARIABLE EXISTE DENTRO DEL MAINN Y SI NO BUSCAR ENTRRE LAS VARIABLES GLOBALES*/
                if (verif.verifIdConst(c, jerarquia, id)) {
                    correcto = verif.verifTipadoConstante(c, id, tipoActual, c.getListConstantes().get(VerifObjetos.iterador), this);
                    existe = true;
                }
                if (!correcto) {
                    if (verif.verifIdConstGlobal(c, jerarquia, id)) {
                        correcto = verif.verifTipadoConstante(c, id, tipoActual, c.getListConstantes().get(VerifObjetos.iterador), this);
                        existe = true;
                    }
                }
                if (!correcto) {
                    if (verif.verifIdVar(c, jerarquia, id)) {
                        correcto = verif.verifTipadoVar(c, id, tipoActual, c.getListVariables().get(VerifObjetos.iterador), this);
                        existe = true;
                    }
                    if (!correcto) {
                        if (verif.verifIdVarGlobal(c, jerarquia, id)) {
                            correcto = verif.verifTipadoVar(c, id, tipoActual, c.getListVariables().get(VerifObjetos.iterador), this);
                            existe = true;
                        }
                        if (!correcto) {
                            if (verif.verifVector(c, jerarquia, id)) {
                                correcto = verif.verifTipadoArreglo(c, id, tipoActual, c.getListArreglos().get(VerifObjetos.iterador), this);
                                existe = true;
                            }
                            if (!correcto) {
                                if (verif.verifVectorGlobal(c, jerarquia, id)) {
                                    correcto = verif.verifTipadoArreglo(c, id, tipoActual, c.getListArreglos().get(VerifObjetos.iterador), this);
                                    existe = true;
                                }
                                if (!existe) {
                                    System.out.println("No existe ninguna variable con el id: " + id + " dentro del archivo");
                                }

                            }
                        }
                    }
                }
            }
        }
        return correcto;
    }

    //int x = 3 + v[1][2] -> verifica que V exista, que sea del mismo tipo que x 
    public boolean verifVectorOperacion(ObjetosC c, String id, int dimension, int jerarquia, String tipoActual) {
        boolean correcto = false;
        VerifObjetos verif = new VerifObjetos();
        if (jerarquia == 0) {
            if (verif.verifVectorGlobal(c, jerarquia, id)) {
                if (verif.verifTipadoArreglo(c, id, tipoActual, c.getListArreglos().get(VerifObjetos.iterador), this)) {
                    correcto = (c.getListArreglos().get(VerifObjetos.iterador).getDimension() == dimension);
                    if (!correcto) {
                        System.out.println("Arreglo con dimensiones incorrectas. Total dimensiones: " + c.getListArreglos().get(VerifObjetos.iterador).getDimension());
                    }
                }
            } else {
                System.out.println("Vector: " + id + " no encontrado en el grupo de variables globales.");
            }
        } else {
            if (verif.verifVector(c, jerarquia, id)) {
                if (verif.verifTipadoArreglo(c, id, tipoActual, c.getListArreglos().get(VerifObjetos.iterador), this)) {
                    correcto = (c.getListArreglos().get(VerifObjetos.iterador).getDimension() == dimension);
                    if (!correcto) {
                        System.out.println("Arreglo con dimensiones incorrectas. Total dimensiones: " + c.getListArreglos().get(VerifObjetos.iterador).getDimension());
                    }
                }
            } else if (verif.verifVectorGlobal(c, jerarquia, id)) {
                if (verif.verifTipadoArreglo(c, id, tipoActual, c.getListArreglos().get(VerifObjetos.iterador), this)) {
                    correcto = (c.getListArreglos().get(VerifObjetos.iterador).getDimension() == dimension);
                    if (!correcto) {
                        System.out.println("Arreglo con dimensiones incorrectas. Total dimensiones: " + c.getListArreglos().get(VerifObjetos.iterador).getDimension());
                    }
                }
            } else {
                System.out.println("Vector: " + id + " no encontrado en el archivo pricipal");
            }
        }
        return correcto;
    }

    public String devolverTipoVar(ObjetosC c, int jerarquia, String id) {
        String tipo = "";
        VerifObjetos verif = new VerifObjetos();
        if (jerarquia == 0) {
            if (verif.verifIdConstGlobal(c, jerarquia, id)) {
                tipo = "";
                System.out.println("No es posible cambiar el valor de una constante. Id: " + id);
            } else if (verif.verifIdVarGlobal(c, jerarquia, id)) {
                tipo = c.getListVariables().get(VerifObjetos.iterador).getTipo();
            }
        } else {
            if (!verif.verifIdConst(c, jerarquia, id)) {
                if (!verif.verifIdVar(c, jerarquia, id)) {
                    if (verif.verifIdConstGlobal(c, jerarquia, id)) {
                        tipo = "";
                        System.out.println("No es posible cambiar el valor de una constante. Id: " + id);
                    } else if (verif.verifIdVarGlobal(c, jerarquia, id)) {
                        tipo = c.getListVariables().get(VerifObjetos.iterador).getTipo();
                    }
                } else {
                    tipo = c.getListVariables().get(VerifObjetos.iterador).getTipo();
                }
            } else {
                tipo = "";
                System.out.println("No es posible cambiar el valor de una constante. Id: " + id);

            }
        }
        if (tipo.equals("")) {
            System.out.println("La variable: " + id + " no existe dentro del archivo");
        }
        return tipo;
    }

    public boolean verifVarFor(ObjetosC c, String id, String tipo, String tipoActual, int jerarquia) {
        //hace alusion a que la variable ya existe por lo que hay que buscarla.
        boolean todoCorrecto = false;
        VerifObjetos verif = new VerifObjetos();
        OperacionesC op = new OperacionesC();
        if (tipo.equals("")) {
            if (verif.verifIdVar(c, jerarquia, id)) {
                if (c.getListVariables().get(VerifObjetos.iterador).getTipo().equals(tipoActual)) {
                    todoCorrecto = true;
                } else if (verificarPadre(c, c.getListVariables().get(VerifObjetos.iterador).getTipo(), tipoActual)) {
                    todoCorrecto = true;
                } else {
                    System.out.println("variable: " + id + " no permitida para ciclo for");
                }
            } else if (verif.verifIdVarGlobal(c, jerarquia, tipoActual)) {
                if (c.getListVariables().get(VerifObjetos.iterador).getTipo().equals(tipoActual)) {
                    todoCorrecto = true;
                } else if (verificarPadre(c, c.getListVariables().get(VerifObjetos.iterador).getTipo(), tipoActual)) {
                    todoCorrecto = true;
                } else {
                    System.out.println("variable: " + id + " no permitida para ciclo for");
                }
            }
            if (todoCorrecto) {
                c.getListVariables().get(VerifObjetos.iterador).getListAsignaciones().add(jerarquia);
                c.getListVariables().get(VerifObjetos.iterador).setValor(true);

            }
        } else {
            op.agregarNuevaVar(c, id, "Integer", "Variable", jerarquia, true, id, null);
        }

        return todoCorrecto;
    }

    //verifica que todas en el for esten de forma correcta
    public void verificarFor(ObjetosC c, int jerarquia, boolean cond1, String boolean2, String var1, String var2, String tipoActual, boolean cond3, String tipoVar1, String id1) {
        boolean condVar1 = verificarIdOperacion(c, var1, jerarquia, tipoActual);
        boolean condVar2 = verificarIdOperacion(c, var2, jerarquia, tipoActual);
        boolean cond2 = !boolean2.equals("");
        if (cond1 && condVar1 && condVar2 && cond3 && cond2) {
            System.out.println("todo correcto en el for");
        } else {
            System.out.println("ERROR for");
        }
    }
    
    //verifica el tipo que representara a una operacion condicional
    public String verifOpCondicional(ObjetosC c, String dato1, String dato2){
        String tipo = "";
        Integer nivelDato1 = null, nivelDato2 = null;
        for (int i = 0; i < c.getTablaTipos().getTipos().size(); i++) {
            if(c.getTablaTipos().getTipos().get(i).getId().equals(dato1)){
                nivelDato1 = c.getTablaTipos().getTipos().get(i).getNivel();
                break;        
            }
        }
        for (int i = 0; i < c.getTablaTipos().getTipos().size(); i++) {
            if(c.getTablaTipos().getTipos().get(i).getId().equals(dato2)){
                nivelDato2 = c.getTablaTipos().getTipos().get(i).getNivel();
                break;
            }
        }
        if(Objects.equals(nivelDato1, nivelDato2)){
            tipo = dato1;
        } else if(nivelDato1 > nivelDato2){
            if(verificarPadre(c, dato2, dato1)){
                tipo = dato1;
            }
        } else {
            if(verificarPadre(c, dato1, dato2)){
                tipo = dato2;
            }
        }
        return tipo;
    }
    
}
