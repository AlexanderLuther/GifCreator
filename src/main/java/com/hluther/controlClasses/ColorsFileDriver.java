package com.hluther.controlClasses;
import com.hluther.entityClasses.CColor;
import java.util.ArrayList;
import  com.hluther.entityClasses.Canvas;
import java.util.Hashtable;
/**
 *
 * @author helmuth
 */
public class ColorsFileDriver {
    
    private ArrayList<Canvas> canvases;
    private ArrayList<CColor> canvasColors;

    public ColorsFileDriver(ArrayList<Canvas> canvases) {
        this.canvases = canvases;
    }
    
    /*
    AGREGAR COLORES A UN LIENZO
    Metodo encargado de agregar colores a un lienzo. Obtiene el lienzo cuyo id se
    recibe como parametro y le asigna a su atributo colors el parametro colors recibido.
    */
    public void addColors(String canvasId, Hashtable<String, CColor> colors){
        //Obtener el lienzo.
        Canvas canvas = null;
        for(Canvas currentCanvas : canvases){
            if(currentCanvas.getId().equals(canvasId)){
                canvas = currentCanvas;
                break;
            }
        }
        canvas.setColors(colors);
    }

    public ArrayList<Canvas> getCanvases() {
        return canvases;
    }

}
