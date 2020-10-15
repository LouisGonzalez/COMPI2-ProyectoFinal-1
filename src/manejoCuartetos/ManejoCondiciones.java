/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoCuartetos;

import cuartetos.Nodo;
import java.util.ArrayList;
import objetos.ObjetosC;
import objetos.ObjetosJAVA;
import objetos.ObjetosPYTHON;
import objetos.ObjetosVB;

/**
 *
 * @author luisGonzalez
 */
public class ManejoCondiciones {

    /*IF*/
    public Integer verUltimoIf(ObjetosJAVA jv) {
        Integer jerarquia = null;
        for (int i = 0; i < jv.getCuarpeta().size(); i++) {
            if (jv.getCuarpeta().get(i).getOperacion().equals("IF")) {
                jerarquia = jv.getCuarpeta().get(i).getNivel();
            }
        }
        return jerarquia;
    }

    public String verUltimaEtiqueta(ObjetosJAVA jv) {
        String et = null;
        for (int i = 0; i < jv.getCuarpeta().size(); i++) {
            if (jv.getCuarpeta().get(i).getOperacion().equals("ETIQUETA")) {
                String[] arreglo = jv.getCuarpeta().get(i).getDato1().toString().split("_");
                if (arreglo[0].equals("et")) {
                    et = jv.getCuarpeta().get(i).getDato1().toString();
                }
            }
        }
        return et;
    }

    public Integer verUltimaEtiqueta2(ObjetosJAVA jv) {
        Integer et = null;
        for (int i = 0; i < jv.getCuarpeta().size(); i++) {
            if (jv.getCuarpeta().get(i).getOperacion().equals("ETIQUETA")) {
                String[] arreglo = jv.getCuarpeta().get(i).getDato1().toString().split("_");
                if (arreglo[0].equals("et")) {
                    et = jv.getCuarpeta().get(i).getNivel();
                }
            }
        }
        return et;
    }

    public Integer devolverCadenaNum(String var) {
        String[] cadena = var.split("_");
        Integer ultimo = Integer.parseInt(cadena[cadena.length - 1]);
        return ultimo;
    }

    public String sumarUnDigito(ObjetosJAVA jv) {
        String var = "";
        String[] arreglo = verUltimaEtiqueta(jv).split("_");
        int suma = Integer.parseInt(arreglo[arreglo.length - 1]) + 1;
        arreglo[arreglo.length - 1] = Integer.toString(suma);

        for (int i = 0; i < arreglo.length; i++) {
            if (i < arreglo.length - 1) {
                var += arreglo[i] + "_";
            } else {
                var += arreglo[i];
            }
        }
        return var;
    }

    public String definirEtiqueta(ObjetosJAVA jv, int jerarquia, String tipo) {
        String var = "";
        Integer comp = null;
        if (tipo.equals("etiqueta")) {
            comp = verUltimaEtiqueta2(jv);
        } else {
            comp = verUltimoIf(jv);
        }
        if (comp != null) {
            if (comp < jerarquia) {
                String nodo = "_" + 0;
                var = verUltimaEtiqueta(jv) + nodo;
            } else if (comp > jerarquia) {
                System.out.println("ENTRO AQUI  " + verUltimoIf(jv) + "  -  " + comp + " -  " + jerarquia);
                String[] arreglo = verUltimaEtiqueta(jv).split("_");
                String aux = "";
                for (int i = 0; i < arreglo.length - 1; i++) {
                    if (i < arreglo.length - 2) {
                        aux += arreglo[i] + "_";
                    } else {
                        aux += arreglo[i];
                    }
                }
                System.out.println(verUltimaEtiqueta(jv) + "        xx      " + aux);
                var = sumaDigito(aux);
            } else {
                var = sumarUnDigito(jv);
            }
        } else {
            if (verUltimaEtiqueta(jv) != null) {
                var = sumarUnDigito(jv);
            } else {
                var = "et_" + 0;
            }
        }
        return var;
    }

    public String sumaDigito(String var) {
        String varDevolver = "";
        String[] arreglo = var.split("_");
        int suma = Integer.parseInt(arreglo[arreglo.length - 1]) + 1;
        arreglo[arreglo.length - 1] = Integer.toString(suma);
        for (int i = 0; i < arreglo.length; i++) {
            if (i < arreglo.length - 1) {
                varDevolver += arreglo[i] + "_";
            } else {
                varDevolver += arreglo[i];
            }
        }
        return varDevolver;
    }

    public String obtenerUltimoGoTo(ArrayList<Nodo> jv, int jerarquia) {
        String et = "";
        for (int i = 0; i < jv.size(); i++) {
            if (jv.get(i).getOperacion().equals("GOTO")) {
                if (jv.get(i).getNivel() == jerarquia) {
                    String[] arreglo = jv.get(i).getVar().split("_");
                    if (arreglo[0].equals("et")) {
                        et = jv.get(i).getVar();
                    }
                }
            }
        }
        return et;
    }

    public String obtenerUltimoGoto2(ArrayList<Nodo> jv) {
        String et = "";
        for (int i = 0; i < jv.size(); i++) {
            if (jv.get(i).getOperacion().equals("GOTO")) {
                String[] arreglo = jv.get(i).getVar().split("_");
                if (arreglo[0].equals("et")) {
                    et = jv.get(i).getVar();
                }

            }
        }
        return et;
    }

    public String definirEtiqueta2(ObjetosJAVA jv) {
        String ultimoGoto = obtenerUltimoGoto2(jv.getCuarpeta());
        String et = "";
        //if (!ultimoGoto.equals("")) {
        int suma = jv.getContEt() + 1;
        jv.setContEt(suma);
        et = "et_" + suma;
        
        return et;
    }

    /*IF - ELSE */
    public ArrayList<ArrayList<String>> aas2 = new ArrayList<>();

    public void agregarPrimerosIf(ObjetosJAVA jv, String bool, int jerarquia, String tipoCond) {

        String et = definirEtiqueta(jv, jerarquia, "if");
        jv.getCuarpeta().add(new Nodo("IF", bool, null, et, jerarquia));
        if (tipoCond.equals("if")) {
            String et2 = sumaDigito(et);
            jv.getCuarpeta().add(new Nodo("GOTO", null, null, et2, jerarquia));
        } else {
            String etFin = "etFin_" + jv.getContEtFin();
            jv.setContEtFin(jv.getContEtFin() + 1);
            jv.getCuarpeta().add(new Nodo("GOTO", null, null, etFin, jerarquia));
        }
        jv.getCuarpeta().add(new Nodo("ETIQUETA", et, null, null, jerarquia));
    }

    public void agregarElse(ObjetosJAVA jv, int jerarquia) {
        String etActual = definirEtiqueta(jv, jerarquia, "etiqueta");
        jv.getCuarpeta().add(new Nodo("ETIQUETA", etActual, null, null, jerarquia));
    }

    public void agregarElseIf(ObjetosJAVA jv, String bool, int jerarquia) {
        String etActual = definirEtiqueta(jv, jerarquia, "etiqueta");
        jv.getCuarpeta().add(new Nodo("ETIQUETA", etActual, null, null, jerarquia));
        agregarPrimerosIf(jv, bool, jerarquia, "if");
    }

    public void irEtiquetaFin(ObjetosJAVA jv, int jerarquia) {
        String etFin = "etFin_" + jv.getContEtFin();
        jv.getCuarpeta().add(new Nodo("GOTO", null, null, etFin, jerarquia));
    }

    public void irEtiquetaFinVB(ObjetosVB vb, int jerarquia) {
        String etFin = "etFin_" + vb.getContEtFin();
        vb.getCuarpeta().add(new Nodo("GOTO", null, null, etFin, jerarquia));
    }

    public void irEtiquetaFinPY(ObjetosPYTHON py, int jerarquia) {
        String etFin = "etFin_" + py.getContEtFin();
        py.getCuarpeta().add(new Nodo("GOTO", null, null, etFin, jerarquia));
    }

    public void irEtiquetaFinPY2(ObjetosPYTHON py, int jerarquia, String et) {
        py.getCuarpeta().add(new Nodo("GOTO", null, null, et, jerarquia));
    }
    
    
    public void irEtiquetaFinC(ObjetosC c, int jerarquia) {
        String etFin = "etFin_" + c.getContEtFin();
        c.getCuarpeta().add(new Nodo("GOTO", null, null, etFin, jerarquia));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void agregarEtiquetaFin(ObjetosJAVA jv, int jerarquia) {
        String etFin = "etFin_" + jv.getContEtFin();
        jv.setContEtFin(jv.getContEtFin() + 1);
        jv.getCuarpeta().add(new Nodo("ETIQUETA", etFin, null, null, jerarquia));
    }

    public void agregarEtiquetaFinVB(ObjetosVB vb, int jerarquia) {
        String etFin = "etFin_" + vb.getContEtFin();
        vb.setContEtFin(vb.getContEtFin() + 1);
        vb.getCuarpeta().add(new Nodo("ETIQUETA", etFin, null, null, jerarquia));
    }
    
    public void agregarEtiquetaFinPY(ObjetosPYTHON py, int jerarquia){
        String etFin = "etFin_" + py.getContEtFin();
        py.setContEtFin(py.getContEtFin()+1);
        py.getCuarpeta().add(new Nodo("ETIQUETA", etFin, null, null, jerarquia));
    }
    
    public void agregarEtiquetaFinPY2(ObjetosPYTHON py, int jerarquia, String etFin){
        py.setContEtFin(py.getContEtFin()+1);
        py.getCuarpeta().add(new Nodo("ETIQUETA", etFin, null, null, jerarquia));
    }
    
    public void agregarEtiquetaFinC(ObjetosC c, int jerarquia){
        String etFin = "etFin_" + c.getContEtFin();
        c.setContEtFin(c.getContEtFin()+1);
        c.getCuarpeta().add(new Nodo("ETIQUETA", etFin, null, null, jerarquia));
    }    
    
    
    
    

    /*WHILE*/
    public void agregarWhile(ObjetosJAVA jv, String bool, int jerarquia) {
        String etWhile = "etWhile_" + jv.getContWhile();
        jv.setContWhile(jv.getContWhile() + 1);
        jv.getCuarpeta().add(new Nodo("ETIQUETA", etWhile, null, null, jerarquia));
        agregarPrimerosIf(jv, bool, jerarquia, "while");

    }

    public void retornoWhile(ObjetosJAVA jv, int jerarquia) {
        String etWhile = buscarUltimoWhile(jv, jerarquia);
        String etFinal = agregarEtiquetaFinWhile(jv, jerarquia);
        jv.getCuarpeta().add(new Nodo("GOTO", null, null, etWhile, jerarquia));
        jv.getCuarpeta().add(new Nodo("ETIQUETA", etFinal, null, null, jerarquia));
    }

    public String buscarUltimoWhile(ObjetosJAVA jv, int jerarquia) {
        String etWhile = "";
        for (int i = 0; i < jv.getCuarpeta().size(); i++) {
            if (jv.getCuarpeta().get(i).getOperacion().equals("ETIQUETA")) {
                String[] arreglo = jv.getCuarpeta().get(i).getDato1().toString().split("_");
                if (arreglo[0].equals("etWhile")) {
                    if (jv.getCuarpeta().get(i).getNivel() == jerarquia) {
                        etWhile = jv.getCuarpeta().get(i).getDato1().toString();
                        break;
                    }
                }
            }
        }
        return etWhile;
    }

    public String agregarEtiquetaFinWhile(ObjetosJAVA jv, int jerarquia) {
        String etWhile = "";
        for (int i = 0; i < jv.getCuarpeta().size(); i++) {
            if (jv.getCuarpeta().get(i).getOperacion().equals("GOTO")) {
                if (jv.getCuarpeta().get(i).getNivel() == jerarquia) {
                    etWhile = jv.getCuarpeta().get(i).getVar();
                }
            }
        }
        return etWhile;
    }

    /*FOR*/
    public void agregarFor(ObjetosJAVA jv, String id1, String valId1, String lado1, String lado2, String op, String idBoolean, int jerarquia) {
        jv.getCuarpeta().add(new Nodo("asig", valId1, null, id1, null));
        String etFor = "etFor_" + jv.getContFor();
        jv.setContFor(jv.getContFor() + 1);
        jv.getCuarpeta().add(new Nodo("ETIQUETA", etFor, null, null, jerarquia));
        jv.getCuarpeta().add(new Nodo("op", lado1, lado2, idBoolean, null));
        agregarPrimerosIf(jv, idBoolean, jerarquia, "for");
    }

    public void retornoFor(ObjetosJAVA jv, int jerarquia, String id, String varAsignar) {
        String etFor = buscarUltimoFor(jv, jerarquia);
        jv.getCuarpeta().add(new Nodo("asig", varAsignar, null, id, null));
        String etFin = agregarEtiquetaFinFor(jv, jerarquia);
        jv.getCuarpeta().add(new Nodo("GOTO", null, null, etFor, jerarquia));
        jv.getCuarpeta().add(new Nodo("ETIQUETA", etFin, null, null, jerarquia));
    }

    public String buscarUltimoFor(ObjetosJAVA jv, int jerarquia) {
        String etFor = "";
        for (int i = 0; i < jv.getCuarpeta().size(); i++) {
            if (jv.getCuarpeta().get(i).getOperacion().equals("ETIQUETA")) {
                String[] arreglo = jv.getCuarpeta().get(i).getDato1().toString().split("_");
                if (arreglo[0].equals("etFor")) {
                    if (jv.getCuarpeta().get(i).getNivel() == jerarquia) {
                        etFor = jv.getCuarpeta().get(i).getDato1().toString();
                        break;
                    }
                }
            }
        }
        return etFor;
    }

    public String agregarEtiquetaFinFor(ObjetosJAVA jv, int jerarquia) {
        String etFor = "";
        for (int i = 0; i < jv.getCuarpeta().size(); i++) {
            if (jv.getCuarpeta().get(i).getOperacion().equals("GOTO")) {
                if (jv.getCuarpeta().get(i).getNivel() == jerarquia) {
                    etFor = jv.getCuarpeta().get(i).getVar();
                }

            }
        }
        return etFor;
    }

    /*DO - WHILE*/
    public void agregarDoWhile(ObjetosJAVA jv, int jerarquia) {
        String etWhile = "etWhile_" + jv.getContWhile();
        jv.getCuarpeta().add(new Nodo("ETIQUETA", etWhile, null, null, jerarquia));
        jv.setContWhile(jv.getContWhile() + 1);
    }

    public void agregarCondicionDoWhile(ObjetosJAVA jv, int jerarquia, String bool) {
        String etWhile = buscarUltimoWhile(jv, jerarquia);
        jv.getCuarpeta().add(new Nodo("IF", bool, null, etWhile, jerarquia));
        String etFin = "etFin_" + jv.getContEtFin();
        jv.setContEtFin(jv.getContEtFin() + 1);
        jv.getCuarpeta().add(new Nodo("GOTO", null, null, etFin, jerarquia));
        jv.getCuarpeta().add(new Nodo("ETIQUETA", etFin, null, null, jerarquia));
    }

    /*SWITCH - CASE*/
    public void agregarSwitch(ObjetosJAVA jv, int jerarquia, String comparacion1, String comparacion2, String valorVar, String tipoOp) {
        String et = definirEtiqueta(jv, jerarquia, "if");
        jv.getCuarpeta().add(new Nodo(tipoOp, comparacion1, comparacion2, valorVar, null));
        jv.getCuarpeta().add(new Nodo("IF", valorVar, null, et, jerarquia));
        String et2 = sumaDigito(et);
        jv.getCuarpeta().add(new Nodo("GOTO", null, null, et2, jerarquia));
        jv.getCuarpeta().add(new Nodo("ETIQUETA", et, null, null, jerarquia));
    }

    public void agregarEtiquetaSwitch(ObjetosJAVA jv, int jerarquia) {
        String et = obtenerUltimoGoTo(jv.getCuarpeta(), jerarquia);
        jv.getCuarpeta().add(new Nodo("ETIQUETA", et, null, null, jerarquia));
    }

    /*-------------------------------------------------------------------------------------------------------*/
    //elimina las etiquetas que ya han sido sentenciadas antes
    public void eliminarEtiquetas(ObjetosJAVA jv, ArrayList<Nodo> aux, ArrayList<Nodo> etFalsas) {
        for (int i = 0; i < etFalsas.size(); i++) {
            String etiqueta = etFalsas.get(i).getDato1().toString();
            boolean encontrado = false;
            for (int j = 0; j < jv.getCuarpeta().size(); j++) {
                if (jv.getCuarpeta().get(j).getOperacion().equals("ETIQUETA")) {
                    if (jv.getCuarpeta().get(j).getDato1().equals(etiqueta)) {
                        encontrado = true;
                        break;
                    }
                }
            }
            if (!encontrado) {
                if (aux != null) {
                    for (int j = 0; j < aux.size(); j++) {
                        if (aux.get(j).getOperacion().equals("ETIQUETA")) {
                            if (aux.get(j).getDato1().equals(etiqueta)) {
                                encontrado = true;
                                break;
                            }
                        }
                    }
                }
            }
            if (encontrado) {
                etFalsas.remove(i);
                i--;
            }
        }
    }

    public void eliminarEtiquetasVB(ObjetosVB vb, ArrayList<Nodo> aux, ArrayList<Nodo> etFalsas) {
        for (int i = 0; i < etFalsas.size(); i++) {
            String etiqueta = etFalsas.get(i).getDato1().toString();
            boolean encontrado = false;
            for (int j = 0; j < vb.getCuarpeta().size(); j++) {
                if (vb.getCuarpeta().get(j).getOperacion().equals("ETIQUETA")) {
                    if (vb.getCuarpeta().get(j).getDato1().equals(etiqueta)) {
                        encontrado = true;
                        break;
                    }
                }
            }
            if (!encontrado) {
                if (aux != null) {
                    for (int j = 0; j < aux.size(); j++) {
                        if (aux.get(j).getOperacion().equals("ETIQUETA")) {
                            if (aux.get(j).getDato1().equals(etiqueta)) {
                                encontrado = true;
                                break;
                            }
                        }
                    }
                }
            }
            if (encontrado) {
                etFalsas.remove(i);
                i--;
            }
        }
    }

    public void eliminarEtiquetasPY(ObjetosPYTHON py, ArrayList<Nodo> aux, ArrayList<Nodo> etFalsas) {
        for (int i = 0; i < etFalsas.size(); i++) {
            String etiqueta = etFalsas.get(i).getDato1().toString();
            boolean encontrado = false;
            for (int j = 0; j < py.getCuarpeta().size(); j++) {
                if (py.getCuarpeta().get(j).getOperacion().equals("ETIQUETA")) {
                    if (py.getCuarpeta().get(j).getDato1().equals(etiqueta)) {
                        encontrado = true;
                        break;
                    }
                }
            }
            if (!encontrado) {
                if (aux != null) {
                    for (int j = 0; j < aux.size(); j++) {
                        if (aux.get(j).getOperacion().equals("ETIQUETA")) {
                            if (aux.get(j).getDato1().equals(etiqueta)) {
                                encontrado = true;
                                break;
                            }
                        }
                    }
                }
            }
                
            if (encontrado) {
                etFalsas.remove(i);
                i--;
            }
        }
    }
    
        public void eliminarEtiquetasC(ObjetosC vb, ArrayList<Nodo> aux, ArrayList<Nodo> etFalsas) {
        for (int i = 0; i < etFalsas.size(); i++) {
            String etiqueta = etFalsas.get(i).getDato1().toString();
            boolean encontrado = false;
            for (int j = 0; j < vb.getCuarpeta().size(); j++) {
                if (vb.getCuarpeta().get(j).getOperacion().equals("ETIQUETA")) {
                    if (vb.getCuarpeta().get(j).getDato1().equals(etiqueta)) {
                        encontrado = true;
                        break;
                    }
                }
            }
            if (!encontrado) {
                if (aux != null) {
                    for (int j = 0; j < aux.size(); j++) {
                        if (aux.get(j).getOperacion().equals("ETIQUETA")) {
                            if (aux.get(j).getDato1().equals(etiqueta)) {
                                encontrado = true;
                                break;
                            }
                        }
                    }
                }
            }
            if (encontrado) {
                etFalsas.remove(i);
                i--;
            }
        }
    }

}
