package com.hluther.AST;
/**
 *
 * @author helmuth
 */
public class Symbol {
    
    private final Type type;
    private final String id;
    private Object value;    
    
    public Symbol(String id, Type tipo) {
        this.type = tipo;
        this.id = id;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    /**
     * Enumeración que lista todos los tipos de variable reconocidos en el lenguaje.
     */
    public static enum Type{
        INT,
        STRING,
        BOOLEAN
    }
}

    
    
    
    
    
    
    
    
    
    
    

