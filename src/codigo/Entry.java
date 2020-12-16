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
public class Entry {
    String id,tipo , ambito;
    int offset;
    boolean activo;
    Entry(String i, String t, String a,int o,boolean bool){
        id = i;
        tipo = t;
        ambito = a;
        offset=o;
        activo=bool;
    }
}
