package com.hluther.controlClasses;
import com.hluther.entityClasses.Canvas;
import com.hluther.entityClasses.Time;
import java.util.ArrayList;

/**
 *
 * @author helmuth
 */
public class TimeFileDriver {
    
    private ArrayList<Canvas> canvases;
    
    public TimeFileDriver(ArrayList<Canvas> canvases) {
        this.canvases = canvases;
    }
    
    /*
    AGREGAR TIEMPOS A UN LIENZO
    Metodo encargado de obtener el lienzo identificado con el id que se recibe como
    parametro, despues de obtenerlo asigna al atributo time el valor recibido como 
    parametro.
    */
    public void addTime(String canvasId, Time time){
        //Obtener el lienzo.
        Canvas canvas = null;
        for(Canvas currentCanvas : canvases){
            if(currentCanvas.getId().equals(canvasId)){
                canvas = currentCanvas;
                break;
            }
        }
        canvas.setTime(time); 
    }
    
    public ArrayList<Canvas> getCanvases() {
        return canvases;
    }
    
}
