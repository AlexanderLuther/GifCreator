package com.hluther.AST;

import java.util.Objects;

/**
 * Clase que ejecuta las acciones de una operación, ya sea aritmética o realacional
 y que implementa la interfaz de instrucción, ya que estas operaciones pueden 
 ejecutarse y al ejecutarse retornan un value.
 * @author Alexander Luther
 */
public class Operation implements Instruction{

    /**
     * Enumeración del tipo de operación que puede ser ejecutada por esta clase.
    */
    public static enum OperationType{
        BOOLEAN,
        LITERAL,
        INTEGER,
        ID, 
        SUM,
        SUBTRACTION,
        MULTIPLICATION,
        DIVISION,
        COMPARATION,
        LESS_EQUAL_THAN,
        GREATER_EQUAL_THAN,
        LESS_THAN,
        GREATER_THAN,
        AND,
        OR
    }
    
    private final OperationType tipo;
    private Operation leftOperator;
    private Operation rightOperator;
    private Object value;
    
    /**
     * Constructor de la clase para operaciones binarias (con dos operadores), estas
     * operaciones son: SUM, SUBTRACTION, MULTIPLICATION, DIVISION,
     * GREATER_EQUAL_THAN, LESS_EQUAL_THAN
     * @param operadorIzq Operador izquierdo de la operación
     * @param operadorDer Opeardor derecho de la operación
     * @param type Tipo de la operación
     */
    public Operation(Operation leftOperator, Operation rightOperator, OperationType type) {
        this.tipo = type;
        this.leftOperator = leftOperator;
        this.rightOperator = rightOperator;
    }
    
    /**
     * Constructor para operaciones unarias (un operador), estas operaciones son: BETWEEN
     * @param operadorIzq Único operador de la operación
     * @param type Tipo de operación
     */
    public Operation(Operation leftOperator, OperationType type) {
        this.tipo = type;
        this.leftOperator = leftOperator;
    }
    
    /**
     * Constructor para operaciones unarias (un operador), cuyo operador es
     *  específicamente una cadena, estas operaciones son:
     * ID, LITERAL.
     * @param value Cadena que representa la operación value realizar
     * @param type Tipo de operación
     */
    public Operation(String value, OperationType type) {
        this.value=value;
        this.tipo = type;
    }
    /**
     * Constructor para operaciones unarias (un operador), cuyo operador es
     *  específicamente un INTEGER.
     * @param value Valor de tipo int que representa la operación value realizar.
     */
    public Operation(int value) {
        this.value = value;
        this.tipo = OperationType.INTEGER;
    }
    
    public Operation(boolean value) {
        this.value = value;
        this.tipo  = OperationType.BOOLEAN;
    }
    
        
    /**
     * Método que ejecuta la instrucción operación, es una sobreescritura del
     * método ejecutar que se debe programar por la implementación de la interfaz
     * instrucción
     * @param symbolTable tabla de símbolos del ámbito padre de la sentencia.
     * @return Esta instrucción retorna el value producido por la operación que se ejecutó.
     */    
    @Override
    public Object execute(SymbolTable symbolTable) {
        if(null == tipo){
            return null;
        }
        else switch (tipo) {
            case BOOLEAN:
                return Boolean.parseBoolean(value.toString());    
            case LITERAL:
                return value.toString().replace("\"", "");  
            case INTEGER:
                return Integer.parseInt(value.toString());
            case ID:
                return symbolTable.getValue(value.toString());        
            case SUM:
                return (Integer)leftOperator.execute(symbolTable) + (Integer)rightOperator.execute(symbolTable);
            case SUBTRACTION:
                return (Integer)leftOperator.execute(symbolTable) - (Integer)rightOperator.execute(symbolTable);
            case MULTIPLICATION:
                return (Integer)leftOperator.execute(symbolTable) * (Integer)rightOperator.execute(symbolTable);
            case DIVISION:
                return (Integer)leftOperator.execute(symbolTable) / (Integer)rightOperator.execute(symbolTable);
            case COMPARATION:
                return Objects.equals((Integer)leftOperator.execute(symbolTable), (Integer)rightOperator.execute(symbolTable));   
            case LESS_EQUAL_THAN:
                return (Integer)leftOperator.execute(symbolTable) <= (Integer)rightOperator.execute(symbolTable);    
            case GREATER_EQUAL_THAN:
                return (Integer)leftOperator.execute(symbolTable) >= (Integer)rightOperator.execute(symbolTable);
            case LESS_THAN:
                return (Integer)leftOperator.execute(symbolTable) < (Integer)rightOperator.execute(symbolTable);    
            case GREATER_THAN:
                return (Integer)leftOperator.execute(symbolTable) > (Integer)rightOperator.execute(symbolTable);
            case AND:
                return (Boolean)leftOperator.execute(symbolTable) && (Boolean)rightOperator.execute(symbolTable);
            case OR:
                return (Boolean)leftOperator.execute(symbolTable) || (Boolean)rightOperator.execute(symbolTable);    
            default:
            return null;
        }
    }    
}






