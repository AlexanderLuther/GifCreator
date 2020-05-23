package com.hluther.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
/**
 *
 * @author helmuth
 */
public class CanvasPanel extends JPanel {
        
    public CanvasPanel(int rows, int columns, int size, Color color, GraphicEditor graphicEditor) { 
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                gbc.gridx = col;
                gbc.gridy = row;
                CellPanel cellPane = new CellPanel(size, color, graphicEditor);    
                Border border = new EtchedBorder();
                cellPane.setBorder(border);
                add(cellPane, gbc);
            }
        }
    }
}
    
   
