/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

/**
 *
 * @author edujg
 */
public class Cuadruplo {
    String op, arg1, arg2, res;
    Cuadruplo(String op, String arg1, String arg2, String res){
        this.op = op;
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.res = res;
    }
    
    @Override
    public String toString(){
        return "Op: " + op + ", arg1: " + arg1 + ", arg2: " + arg2 + ", res: " + res;
    }
}
