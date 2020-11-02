/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuartetos;

import Tablas.TablaSimbolos;
import java.util.ArrayList;

/**
 *
 * @author luisGonzalez
 */
public class CreacionEjecutable {

    public void definirTemporales(ArrayList<Nodo> ejecutable, int totalTemp) {
        for (int i = 0; i < totalTemp; i++) {
            ejecutable.add(new Nodo("TEMP", null, null, "t" + i, null));
        }
    }

    public void copiarCuarpetas(ArrayList<Nodo> ejecutable, ArrayList<Nodo> cuarpeta) {
        for (int i = 0; i < cuarpeta.size(); i++) {
            ejecutable.add(cuarpeta.get(i));
        }
    }

    public String crearEjecutable(ArrayList<Nodo> ejecutable, ArrayList<Nodo> cuarpeta, int totalTemp) {
        definirTemporales(ejecutable, totalTemp);
        copiarCuarpetas(ejecutable, cuarpeta);

        String codigo = "";
        codigo += "#include <stdio.h>\n";
        codigo += "#include <stdlib.h>\n";
        codigo += "float stack[100000000];\n";
        codigo += "float heap[10000000];\n";
        codigo += "int p;\n";
        codigo += "int h;\n";
        for (int i = 0; i < ejecutable.size(); i++) {
            if (ejecutable.get(i).getOperacion().equals("TEMP")) {
                codigo += "float " + ejecutable.get(i).getVar() + ";\n";
            } else if (ejecutable.get(i).getOperacion().equals("CREACION_METODO")) {
                codigo += "void " + ejecutable.get(i).getVar()+ "()" + " {\n";
            } else if (ejecutable.get(i).getOperacion().equals("FIN_METODO")) {
                codigo += "printf(\"\");\n";
                codigo += "}\n";
            } else if (ejecutable.get(i).getOperacion().equals("ETIQUETA")) {
                codigo += ejecutable.get(i).getDato1() + ":\n";
            } else if (ejecutable.get(i).getOperacion().equals("GOTO")) {
                codigo += "goto " + ejecutable.get(i).getVar() + ";\n";
            } else if (ejecutable.get(i).getOperacion().equals("CREACION_VAR")) {
              /*  if (!ejecutable.get(i).getDato1().equals("")) {
                    if (ejecutable.get(i).getDato1().equals("Integer")) {
                        codigo += "int " + ejecutable.get(i).getVar() + ";\n";
                    } else if (ejecutable.get(i).getDato1().equals("Char")) {
                        codigo += "char " + ejecutable.get(i).getVar() + ";\n";
                    } else if (ejecutable.get(i).getDato1().equals("Float")) {
                        codigo += "float " + ejecutable.get(i).getVar() + ";\n";
                    }
                }*/

            } else if (ejecutable.get(i).getOperacion().equals("asig")) {
                codigo += ejecutable.get(i).getVar() + " = " + ejecutable.get(i).getDato1() + ";\n";
            } else if (ejecutable.get(i).getOperacion().equals("PRINT")) {
                if(ejecutable.get(i).getDato1() != null){
                    codigo += "printf(\""+ejecutable.get(i).getDato1().toString()+"\","+ejecutable.get(i).getVar()+");\n";
                } else {
                    codigo += "printf(" + ejecutable.get(i).getVar() + ");\n";
                }
            } else if (ejecutable.get(i).getOperacion().equals("mult")) {
                codigo += ejecutable.get(i).getVar() + " = " + ejecutable.get(i).getDato1() + " * " + ejecutable.get(i).getDato2() + ";\n";
            } else if (ejecutable.get(i).getOperacion().equals("resta")) {
                codigo += ejecutable.get(i).getVar() + " = " + ejecutable.get(i).getDato1() + " - " + ejecutable.get(i).getDato2() + ";\n";
            } else if (ejecutable.get(i).getOperacion().equals("div")) {
                codigo += ejecutable.get(i).getVar() + " = " + ejecutable.get(i).getDato1() + " / " + ejecutable.get(i).getDato2() + ";\n";
            } else if (ejecutable.get(i).getOperacion().equals("suma")) {
                codigo += ejecutable.get(i).getVar() + " = " + ejecutable.get(i).getDato1() + " + " + ejecutable.get(i).getDato2() + ";\n";
            } else if (ejecutable.get(i).getOperacion().equals("modulo")) {
                codigo += ejecutable.get(i).getVar() + " = " + ejecutable.get(i).getDato1() + " % " + ejecutable.get(i).getDato2() + ";\n";
            } else if (ejecutable.get(i).getOperacion().equals("SCANF")) {
                codigo += "scanf(" + ejecutable.get(i).getDato1() + "," + ejecutable.get(i).getVar() + ");\n";
            } else if (ejecutable.get(i).getOperacion().equals("CALL")) {
                codigo += ejecutable.get(i).getDato1() + "\n";
            } else if (ejecutable.get(i).getOperacion().equals("PARAM")) {
                codigo += "param " + ejecutable.get(i).getVar() + "\n";
            } else if (ejecutable.get(i).getOperacion().equals("CLSCR")) {
                codigo += "clscr();\n";
            } else if (ejecutable.get(i).getOperacion().equals("GETCH")) {
                if (ejecutable.get(i).getVar() != null) {
                    codigo += ejecutable.get(i).getVar() + " = " + "getch();\n";
                } else {
                    codigo += "getch();\n";
                }
            } else {
                String[] posIf = ejecutable.get(i).getOperacion().split(" ");
                if (posIf[0].equals("IF")) {
                    codigo += "if(" + ejecutable.get(i).getDato1() + " " + posIf[1] + " " + ejecutable.get(i).getDato2() + ") { goto " + ejecutable.get(i).getVar() + "; }\n";
                }
            }
        }
        return codigo;
    }

}
