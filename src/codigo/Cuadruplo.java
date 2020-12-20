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
    String op, op1, op2, res;
    Cuadruplo(String op, String op1, String op2, String res){
        this.op = op;
        this.op1 = op1;
        this.op2 = op2;
        this.res = res;
    }
    
    @Override
    public String toString(){
        return "Operador: " + op + ", ARG1: " + op1 + ", AGR2: " + op2 + ", RES: " + res;
    }
}
