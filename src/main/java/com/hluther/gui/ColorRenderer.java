package com.hluther.gui;
import com.hluther.entityClasses.CColor;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Hashtable;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
/**
 *
 * @author helmuth
 */
public class ColorRenderer extends JLabel implements javax.swing.ListCellRenderer{
  
    private Hashtable<String, CColor> colors;
    
    public ColorRenderer(Hashtable<String, CColor> colors) {
        this.setOpaque(true);
        this.colors = colors;
    }
    
    @Override
    public Component getListCellRendererComponent(JList list, Object key, int index, boolean isSelected, boolean cellHasFocus) {
        CColor color = colors.get(key);;
        String name = key.toString();
        list.setSelectionBackground(null);
        list.setSelectionForeground(null);
        if(isSelected){
            setBorder(BorderFactory.createEtchedBorder());
        } 
        else {
            setBorder(null);
        }
        setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        setBackground(color.getColor());
        setText(name);
        setForeground(Color.black);
        return this;
    }
}