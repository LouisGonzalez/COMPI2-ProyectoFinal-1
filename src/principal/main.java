/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import interfaz.Principal;

/**
 *
 * @author luisGonzalez
 */
public class main {

    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.setVisible(true);
        esNumero("asd");
    }
       
      public static boolean esNumero(String numero){
        try{
            Integer.parseInt(numero);
            System.out.println("es numero");
            return true;
        } catch(NumberFormatException e){
            System.out.println("no lo es ");
            return false;
            
        }
    }
}
