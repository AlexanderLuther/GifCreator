package com.hluther.AST;

import java.util.LinkedList;
/**
 *
 * @author helmuth
 */
public class CanvasInstructions implements Instruction{
    
    private final String id;
    private LinkedList<Instruction> instructions;
    /**
     * 
     * @param id id del lienzo.
     * @param instructions instrucciones a realizar sobre el lienzo.
     */
    public CanvasInstructions(String id, LinkedList instructions) {
        this.id = id;
        this.instructions = instructions;
    }

   
    @Override
    public Object execute(SymbolTable symbolTable) { 
        int counter = 0; 
        for(int i = instructions.size() -1; i >= 0; i--){
            counter++;
            System.out.println("Acciones dentro del bloque de instrucciones del lienzo:" + id + " No.: " + counter);
            if(instructions.get(i)!=null)
                instructions.get(i).execute(symbolTable);
        }
        return null;    
    }
    
}
