package com.hluther.AST;

import com.hluther.entityClasses.Canvas;
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
    public Object execute(SymbolTable symbolTable, Canvas currentCanvas) {
        if((Boolean)condition.execute(symbolTable, currentCanvas)){
            System.out.println("Dentro del if");
            System.out.println(currentCanvas.getId());
            if(instructionsList != null){
                SymbolTable localTable = new SymbolTable();
                localTable.addAll(symbolTable);
                for(int i = instructionsList.size() -1; i >= 0; i--){
                    instructionsList.get(i).execute(localTable, currentCanvas);
                }
                
            }
        }else{
            System.out.println("Dentro del else.");
            if(elseInstructionsList!=null){
                SymbolTable localTable=new SymbolTable();
                localTable.addAll(symbolTable);
                for(int i = elseInstructionsList.size() -1; i >= 0; i--){
                    elseInstructionsList.get(i).execute(localTable, currentCanvas);
                }       
            }
        }
        return null;
    }
}
