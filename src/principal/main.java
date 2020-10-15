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
    
    public static void main(String[] args){
        System.out.println("HOLA MUNDO");
        Principal principal = new Principal();
        principal.setVisible(true);
      
        String dat = "1_2";
        String[] dats = dat.split("_");
        for (int i = 0; i < dats.length; i++) {
            System.out.println(dats[i]);
        }
           System.out.println(-2.6);
  
    }
    
}
