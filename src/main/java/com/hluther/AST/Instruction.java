package com.hluther.AST;

import com.hluther.entityClasses.Canvas;
/**
 *
 * @author helmuth
 */
public interface Instruction {
    
    public Object execute(SymbolTable symbolTable, Canvas currentCanvas);
    
}
