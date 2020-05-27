package com.hluther.AST;

import java.util.LinkedList;
/**
 *
 * @author helmuth
 */
public class PaintInstructions implements Instruction{
    
    private LinkedList<Instruction> vars;
    private LinkedList<Instruction> instructions;

    public PaintInstructions(LinkedList<Instruction> vars, LinkedList<Instruction> instructions) {
        this.vars = vars;
        this.instructions = instructions;
    }
    
   
    @Override
    public Object execute(SymbolTable symbolTable) {
        //Guardado de todas las variables declaradas.
        System.out.println("Guardando Variables.");
        int counter = 0; 
        for(int i = vars.size() -1; i >= 0; i--){
            counter++;
            System.out.println(counter);
            if(vars.get(i)!=null)
                vars.get(i).execute(symbolTable);
        }
        
        //Ejecucion de acciones en cada bloque de instrucciones.
        System.out.println("Ejecucion de acciones.");
        counter = 0; 
        for(int i = instructions.size() -1; i >= 0; i--){
            counter++;
            System.out.println(counter);
            if(instructions.get(i)!=null)
                instructions.get(i).execute(symbolTable);
        }
        
        return null;
    }
     
}
