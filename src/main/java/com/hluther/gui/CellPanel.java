package com.hluther.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
/**
 *
 * @author helmuth
 */
public class CellPanel extends JPanel implements MouseListener{
    
    private GraphicEditor graphicEditor;
    private Color color;
    private int size;

    public CellPanel(int size, Color color, GraphicEditor graphicEditor) {
        this.color = color;
        this.size = size;
        this.graphicEditor = graphicEditor;
        this.setBackground(color);
        this.addMouseListener(this);
    }

    public void setGraphicEditor(GraphicEditor graphicEditor) {
        this.graphicEditor = graphicEditor;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(size, size);
    }    
    
    @Override
    public void mouseClicked(MouseEvent e){
        graphicEditor.paintSquare(this);
    }
    
    @Override
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
