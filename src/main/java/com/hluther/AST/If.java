package com.hluther.AST;

import java.util.LinkedList;

/**
 * Clase que ejecuta las acciones de una instrucción si...entonces y que implementa
 * la interfaz de instrucción
 * @author Alexander Luther
 */
public class If implements Instruction{

    private final Operation condition;
    private final LinkedList<Instruction> instructionsList;
    private LinkedList<Instruction> elseInstructionsList;
    
    /**
     * Primer constructor de la clase, este se utiliza cuando la instrucción no 
     * tiene clausula ELSE.
     * @param condition Condición del si..entonces
     * @param instructionsList Lista de instrucciones que deberían ejecutarse si la condición se cumple
     */
    public If(Operation condition, LinkedList<Instruction> instructionsList) {
        this.condition = condition;
        this.instructionsList = instructionsList;
    }
    /**
     * Segundo constructor de la clase, este se utiliza cuando la instrucción tiene
     * clausula ELSE.
     * @param condition Condición del si..entonces
     * @param instructionsList Lista de instrucciones que deberían ejecutarse si la condición se cumple
     * @param elseInstructionsList Lista de instrucciones que deberían ejecutarse si la condición no se cumple
     */
    public If(Operation condition, LinkedList<Instruction> instructionsList, LinkedList<Instruction> elseInstructionsList) {
        this.condition = condition;
        this.instructionsList = instructionsList;
        this.elseInstructionsList = elseInstructionsList;
    }
    
    /**
     * Método que ejecuta la instrucción si..entonces, es una sobreescritura del 
     * método ejecutar que se debe programar por la implementación de la interfaz
     * instrucción
     * @param symbolTable tabla de símbolos del ámbito padre de la sentencia.
     * @return Estra instrucción retorna nulo porque no produce ningún valor en 
     * su ejecución
     */
    @Override
    public Object execute(SymbolTable symbolTable) {
        if((Boolean)condition.execute(symbolTable)){
            System.out.println("Dentro del if");
            if(instructionsList != null){
                SymbolTable localTable = new SymbolTable();
                localTable.addAll(symbolTable);
                for(Instruction in: instructionsList){
                    in.execute(localTable);
                }
            }
        }else{
            System.out.println("Dentro del else.");
            if(elseInstructionsList!=null){
                SymbolTable localTable=new SymbolTable();
                localTable.addAll(symbolTable);
                for(Instruction in: elseInstructionsList){
                    in.execute(localTable);
                }            
            }
        }
        return null;
    }
}
