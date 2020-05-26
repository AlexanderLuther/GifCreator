package com.hluther.controlClasses;

import com.hluther.entityClasses.Data;
import com.hluther.entityClasses.TemporalData;
import com.hluther.gui.GifCreatorFrame;
import java.util.ArrayList;
import java.util.Hashtable;
/**
 *
 * @author helmuth
 */
public class PaintFileDriver {
    
    private Data data;
    
    public void createData(Hashtable<String, Data> symbolTable, ArrayList<TemporalData> temporalData, GifCreatorFrame gifCreatorFrame){
    
        System.out.println("Variables a asignar");
        for(int i = 0; i < temporalData.size(); i++){
            System.out.println("Nombre de la variable: " + temporalData.get(i).getId());
            System.out.println("Nombre de la variable que dara el valor: " + temporalData.get(i).getIdValue());
            System.out.println("Tipo de variable: " + temporalData.get(i).getType());
        }
        
        System.out.println("Variables ya guardadas");
        for(Data currentData : symbolTable.values()){
            
            switch(currentData.getType()){
                case 0:
                    System.out.println("Id: " + currentData.getId());
                    if(currentData.isEmpty()){
                        System.out.println("No inicializada");
                    }
                    else{
                        System.out.println("Valor: " + currentData.getIntegerValue());
                    }
                break;
                case 1:
                    System.out.println("Id: " + currentData.getId());
                    if(currentData.isEmpty()){
                        System.out.println("No inicializada");
                    }
                    else{
                        System.out.println("Valor: " + currentData.getStringValue());
                    }
                break;
                case 2:
                    System.out.println("Id: " + currentData.getId());
                    if(currentData.isEmpty()){
                        System.out.println("No inicializada");
                    }
                    else{
                        System.out.println("Valor: " + currentData.isBooleanValue());
                    }
                break;
            }
        
        }
        
        
        
        
        for(TemporalData tempData : temporalData){
            if(symbolTable.get(tempData.getIdValue()) != null){
                data = symbolTable.get(tempData.getIdValue());
                switch(tempData.getType()){
                    case 0:
                        if(data.getType() == 0){
                            if(data.isEmpty()){
                                gifCreatorFrame.printError("Error Semantico -> La variable ["+data.getId()+"] no fue inicializada. Linea: "+tempData.getIdRow()+" Columna: "+tempData.getIdColumn(), 3);
                            }
                            else{
                                symbolTable.put(tempData.getId(), new Data(tempData.getId(), data.getIntegerValue(), 0, false));
                            }
                        }
                        else{
                            gifCreatorFrame.printError("Error Semantico -> La variable ["+data.getId()+"] no es de tipo int. Linea: "+tempData.getIdRow()+" Columna: "+tempData.getIdColumn(), 3);
                        }
                    break;
                    case 1:
                        if(data.getType() == 1){
                            if(data.isEmpty()){
                                gifCreatorFrame.printError("Error Semantico -> La variable ["+data.getId()+"] no fue inicializada. Linea: "+tempData.getIdRow()+" Columna: "+tempData.getIdColumn(), 3);
                            }
                            else{
                                symbolTable.put(tempData.getId(), new Data(tempData.getId(), data.getStringValue(), 1, false));
                            }
                        }
                        else{
                            gifCreatorFrame.printError("Error Semantico -> La variable ["+data.getId()+"] no es de tipo String. Linea: "+tempData.getIdRow()+" Columna: "+tempData.getIdColumn(), 3);
                        }
                    break;
                    case 2:
                        if(data.getType() == 2){
                            if(data.isEmpty()){
                                gifCreatorFrame.printError("Error Semantico -> La variable ["+data.getId()+"] no fue inicializada. Linea: "+tempData.getIdRow()+" Columna: "+tempData.getIdColumn(), 3);
                            }
                            else{
                                symbolTable.put(tempData.getId(), new Data(tempData.getId(), data.isBooleanValue(), 2, false));
                            }
                        }
                        else{
                            gifCreatorFrame.printError("Error Semantico -> La variable ["+data.getId()+"] no es de tipo boolean. Linea: "+tempData.getIdRow()+" Columna: "+tempData.getIdColumn(), 3);
                        } 
                    break;
                }  
            }  
            else{
                gifCreatorFrame.printError("Error Semantico -> No existe ninguna variable con el nombre ["+tempData.getIdValue()+"]. Imposible asignar un valor.  Linea: "+tempData.getIdRow()+" Columna: "+tempData.getIdColumn(), 3);
            }
        }
        
        
        
        
        
        
        
        
        System.out.println("Variables asignadas");
         for(Data currentData : symbolTable.values()){
            
            switch(currentData.getType()){
                case 0:
                    System.out.println("Id: " + currentData.getId());
                    if(currentData.isEmpty()){
                        System.out.println("No inicializada");
                    }
                    else{
                        System.out.println("Valor: " + currentData.getIntegerValue());
                    }
                break;
                case 1:
                    System.out.println("Id: " + currentData.getId());
                    if(currentData.isEmpty()){
                        System.out.println("No inicializada");
                    }
                    else{
                        System.out.println("Valor: " + currentData.getStringValue());
                    }
                break;
                case 2:
                    System.out.println("Id: " + currentData.getId());
                    if(currentData.isEmpty()){
                        System.out.println("No inicializada");
                    }
                    else{
                        System.out.println("Valor: " + currentData.isBooleanValue());
                    }
                break;
            }
        
        }
        
        
        
        
    }
    
    
    
    
    
}
