package com.hluther.entityClasses;
import java.awt.Color;
/**
 *
 * @author helmuth
 */
public class CColor {
    
    private Color color;
    private String id;

    public CColor(java.awt.Color color, String id) {
        this.color = color;
        this.id = id;
    }

    public java.awt.Color getColor() {
        return color;
    }

    public void setColor(java.awt.Color color) {
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
