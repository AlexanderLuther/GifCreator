package com.hluther.entityClasses;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Hashtable;
/**
 *
 * @author helmuth
 */
public class Canvas {

    private String id;
    private String imageName;
    private int pixelsAmount;
    private int rows;
    private int columns;
    private Color backgroundColor;
    private boolean GIF;
    private Hashtable<String, CColor> colors;
    private Time time;

    public Canvas(String id, String imageName, int pixelsAmount, int rows, int columns, Color color, boolean GIF) {
        this.id = id;
        this.imageName = imageName;
        this.pixelsAmount = pixelsAmount;
        this.rows = rows;
        this.columns = columns;
        this.backgroundColor = color;
        this.GIF = GIF;
        colors = new Hashtable<>();
    }

    public Canvas(String imageName, int pixelsAmount, int rows, int columns, Color color, boolean GIF) {
        this.imageName = imageName;
        this.pixelsAmount = pixelsAmount;
        this.rows = rows;
        this.columns = columns;
        this.backgroundColor = color;
        this.GIF = GIF;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public int getPixelsAmount() {
        return pixelsAmount;
    }

    public void setPixelsAmount(int pixelsAmount) {
        this.pixelsAmount = pixelsAmount;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color BackgroundColor) {
        this.backgroundColor = BackgroundColor;
    }

    public boolean isGIF() {
        return GIF;
    }

    public void setGIF(boolean GIF) {
        this.GIF = GIF;
    }
    
    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Hashtable<String, CColor> getColors() {
        return colors;
    }

    public void setColors(Hashtable<String, CColor> colors) {
        this.colors = colors;
    }
    
}
