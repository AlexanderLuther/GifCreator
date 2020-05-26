package com.hluther.entityClasses;
/**
 *
 * @author helmuth
 */
public class Node {
    
    private Object dato;
    private Node izdo;
    private Node dcho;

    public Node(Object valor){
        dato = valor;
        izdo = dcho = null;
    }

    public Node(Node ramaIzdo, Object valor, Node ramaDcho){
        this.dato = valor;
        izdo = ramaIzdo;
        dcho = ramaDcho;
    }

    

}



