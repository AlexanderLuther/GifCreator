package com.hluther.controlClasses;
import com.hluther.entityClasses.Canvas;
import com.hluther.entityClasses.ImageDTO;
import com.hluther.entityClasses.Time;
import com.hluther.gui.CanvasPanel;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author helmuth
 */
public class TimeFileDriver {
    
    private ArrayList<Canvas> canvases;
    private CanvasPanel canvasPanel;
    
    public TimeFileDriver(ArrayList<Canvas> canvases) {
        this.canvases = canvases;
    }
    
    /*
    AGREGAR TIEMPOS A UN LIENZO
    Metodo encargado de:
        1. Obtener el lienzo identificado con el id que se recibe como
            parametro.
        2. A cada instancia de la clase ImageDTO dentro del parametro time 
           recibido se le asigna un nuevo valor al atributo canvasPane.
        3. A el lienzo obtenido le asigna al atributo time el valor recibido como 
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
