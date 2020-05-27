package com.hluther.controlClasses;

import com.hluther.AST.Instruction;
import com.hluther.AST.SymbolTable;
import java.util.LinkedList;

/**
 *
 * @author helmuth
 */
public class PaintFileDriver {
    
    /**
     * Recibe una lista de instrucciones y la ejecuta
     * @param ast lista de instrucciones
     */
    public void executeAST(LinkedList<Instruction> abstractSintaxTree){
        if(abstractSintaxTree == null){
            System.out.println("No es posible ejecutar las instrucciones porque\r\n"
                    + "el árbol no fue cargado de forma adecuada por la existencia\r\n"
                    + "de errores léxicos o sintácticos.");
            return;
        }
        //Se crea una tabla de símbolos global para ejecutar las instrucciones.
        SymbolTable  symbolTable = new SymbolTable();
        //Se ejecuta cada instruccion en el ast, es decir, cada instruccion de 
        //la lista principal de instrucciones.
        
        int counter = 0; 
        for(int i = abstractSintaxTree.size() -1; i >= 0; i--){
            counter++;
            System.out.println(counter);
            //Si existe un error léxico o sintáctico en cierta instrucción esta
            //será inválida y se cargará como null, por lo tanto no deberá ejecutarse
            //es por esto que se hace esta validación.
            if(abstractSintaxTree.get(i)!=null)
                abstractSintaxTree.get(i).execute(symbolTable);
        }
        
        
        for(int i = 0; i < symbolTable.size(); i++){
            System.out.println(symbolTable.get(i).getId() + " =  " + symbolTable.get(i).getValue());
        }
        
    }
    
}
