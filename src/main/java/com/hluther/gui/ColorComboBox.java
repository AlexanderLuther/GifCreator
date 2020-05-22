package com.hluther.gui;
import com.hluther.entityClasses.CColor;
import java.awt.Color;
import java.awt.Font;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.*;
/**
 *
 * @author helmuth
 */
public class ColorComboBox extends JComboBox {
    
    private Hashtable<String, CColor> colors;

    public ColorComboBox(Hashtable<String, CColor> colors) {
        super();
        this.colors = colors;
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Enumeration colorNames = this.colors.keys();
        while(colorNames.hasMoreElements()){
            String temp = colorNames.nextElement().toString();
            model.addElement(temp);
        }
        setModel(model);
        setRenderer(new ColorRenderer(colors));
        this.setOpaque(true);
        this.setSelectedIndex(0);
    }
    
    @Override
    public void setSelectedItem(Object anObject) {
        super.setSelectedItem(anObject);
        setBackground(colors.get(anObject).getColor());
        setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
    }
    
    public Color getSelectedColor(){
        return colors.get(this.getSelectedItem().toString()).getColor();
    } 
}    

