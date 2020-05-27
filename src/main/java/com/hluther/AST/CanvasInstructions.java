package com.hluther.AST;

import com.hluther.entityClasses.Canvas;
import java.util.ArrayList;
import java.util.LinkedList;
/**
 *
 * @author helmuth
 */
public class CanvasInstructions implements Instruction{
    
    private final String id;
    private LinkedList<Instruction> instructions;
    private ArrayList<Canvas> canvases;
    /**
     * 
     * @param id id del lienzo.
     * @param instructions instrucciones a realizar sobre el lienzo.
     */
    public CanvasInstructions(String id, LinkedList instructions, ArrayList<Canvas> canvases) {
        this.id = id;
        this.instructions = instructions;
        this.canvases = canvases;
    }

    /**
     * Metodo que busca el lienzo con el id igual al id de la clase.
     * Si encuentra un lienzo realiza las acciones del bloque, caso
     * contrario lanza un mensaje de error.
     * @param symbolTable Tabla de simbolos.
     * @param currentCanvas Lienzo actual.
     * @return 
     */
    @Override
    public Object execute(SymbolTable symbolTable, Canvas currentCanvas) { 
        Canvas canvas = null;
        for(Canvas c : canvases){
            if(c.getId().equals(id)){
                canvas = c;
                break;
            }        
        }
        
        if(canvas != null){
            int counter = 0; 
            for(int i = instructions.size() -1; i >= 0; i--){
                counter++;
                System.out.println("Acciones dentro del bloque de instrucciones del lienzo:" + id + " No.: " + counter);
                if(instructions.get(i)!=null)
                    instructions.get(i).execute(symbolTable, canvas);
             }
        }
        else{
            //Lanzar error
            System.out.println("El lienzo "+id+" no existe.");
        }
        return null;    
    }
    
}
