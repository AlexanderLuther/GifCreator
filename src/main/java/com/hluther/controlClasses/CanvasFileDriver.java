package com.hluther.controlClasses;
import com.hluther.entityClasses.Canvas;
import java.util.ArrayList;
/**
 *
 * @author helmuth
 */
public class CanvasFileDriver {

    private ArrayList<Canvas> canvases;
    
    public CanvasFileDriver() {
        canvases = new ArrayList<>();
    }
    
    /*
    AGREGAR LIENZOS AL ARRAYLIST.
    Metodo encargado de agrega el lienzo que recibe como parametro al arrayList canvases.
    */
    public void addCanvas(Canvas canvas){
        canvases.add(canvas);        
    }

    public ArrayList<Canvas> getCanvases() {
        return canvases;
    }
    
}
