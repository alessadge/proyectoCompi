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
import java.util.ArrayList;

public class Node {
    public String nombre="";
    public String valor="";    
    public ArrayList<Node> hijos;
    public String lugar = "";
    public String verdadera = "";
    public String falsa = "";
    public String siguiente = "";
    public String comienzo = "";
    public String asig = "";
    
    public Node(String nombre) {
        this.nombre = nombre;
        this.valor = "<non-terminal>";
        hijos = new ArrayList();
    }
       
    public Node(String nombre, String valor) {
        this.nombre = nombre;
        this.valor = valor;
        hijos = new ArrayList();
    }

    public void addNode(Object root){
        if (root != null) {
            hijos.add((Node)root);
        }        
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public ArrayList<Node> getHijos() {
        return hijos;
    }

    public void setHijos(ArrayList<Node> hijos) {
        this.hijos = hijos;
    }        

    public void recorrido(Node root, int espacio){
        if (!root.hijos.isEmpty()) {
            for (int i = 0; i < espacio; i++) {
                System.out.print("\t");
            }
            System.out.println(root);

            recorrido(root.hijos.get(0), espacio+1);
            for (int i = 1; i < root.hijos.size(); i++) {
                recorrido(root.hijos.get(i), espacio+1);
            }
        } else {
            for (int i = 0; i < espacio; i++) {
                System.out.print("\t");
            }
            System.out.println(root);
        }
    }
    
    @Override
    public String toString() {
        if (valor.equals("<non-terminal>")) {
            return nombre;
        }else{
            return valor;
        }
    }
    
    
    
}

