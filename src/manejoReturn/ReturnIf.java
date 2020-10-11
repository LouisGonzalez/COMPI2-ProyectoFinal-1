/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoReturn;

/**
 *
 * @author luisGonzalez
 */
public class ReturnIf {
    
    private Boolean contReturn = null;
    private Boolean contElse = null;

    
    
    public Boolean getContReturn() {
        return contReturn;
    }

    public void setContReturn(Boolean contReturn) {
        this.contReturn = contReturn;
    }

    public Boolean getContElse() {
        return contElse;
    }

    public void setContElse(Boolean contElse) {
        this.contElse = contElse;
    }
    
    public int algo(){
        for (int i = 0; i < 10; i++) {
            if(3 > 1){
                return 4;
            } else {
                return 5;
            }
        }
        int a = 3;
        if(1  >4){
            if(1 > 3){
                return 4;
            } else {
                return 3;
            }
        } else {
            return 5;
        }
    }
    
    
}
