package com.hluther.AST;
/**
 *
 * @author helmuth
 */
public class DeclarationAssignment implements Instruction{
    
    private final String id;
    private final Symbol.Type type;
    private Operation value;
    
    /**
     * Constructor de la clase
     * @param id Identificador de la variable que será declarada.
     * @param type Tipo de la clase que será declarada.
     * @param value Valor que se la a asignar.
     */
    public DeclarationAssignment(String id, Operation value, Symbol.Type type) {
        this.id = id;
        this.value = value;
        this.type = type;  
    }

    @Override
    public Object execute(SymbolTable symbolTable) {
        symbolTable.add(new Symbol(id, type));
        symbolTable.setValue(id, value.execute(symbolTable));
        return null;
    }     
}
