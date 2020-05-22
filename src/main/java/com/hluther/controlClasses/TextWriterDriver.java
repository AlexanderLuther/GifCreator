package com.hluther.controlClasses;

import com.hluther.entityClasses.Canvas;
import java.util.ArrayList;
/**
 *
 * @author helmuth
 */
public class TextWriterDriver {
    
    /*
    ESCRIBIR TEXTO DE ARCHIVO DE TIEMPOS.
    */
    public String writeTimeFileText(ArrayList<Canvas> canvases){
        String text = "{\n\tTIEMPOS:{\n";
        for(int k = 0; k < canvases.size(); k++){
            text = text + "\t\t"+canvases.get(k).getId()+":{\n";
            text = text + "\t\t\tinicio: \""+canvases.get(k).getTime().getStartId()+"\",\n";
            text = text + "\t\t\tfin: \""+canvases.get(k).getTime().getEndId()+"\",\n";
            text = text + "\t\t\timagenes:[\n";
            //Crear el texto del arreglo de imagenes.
            for(int i = 0; i < canvases.get(k).getTime().getImages().size(); i++){
                text = text + "\t\t\t\t{\n";
                text = text + "\t\t\t\t\tid: \""+canvases.get(k).getTime().getImages().get(i).getId()+"\",\n";
                text = text + "\t\t\t\t\tduracion: "+canvases.get(k).getTime().getImages().get(i).getDuration()+"\n";
                if(i + 1 == canvases.get(k).getTime().getImages().size()){ 
                    text = text + "\t\t\t\t}\n";    
                }
                else{
                    text = text + "\t\t\t\t},\n";    
                }
            }
            text = text + "\t\t\t]\n";
            if(k + 1 == canvases.size()){
                text = text + "\t\t}\n";
            }
            else{
                text = text + "\t\t},\n";
            }
        }
        text = text + "\t}\n}";
        return text;
    }
}
