package com.hluther.AST;
/**
 *
 * @author helmuth
 */
public interface Instruction {
    
    public Object execute(SymbolTable symbolTable);
    
}
