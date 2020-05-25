package com.hluther.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
/**
 *
 * @author helmuth
 */
public class CanvasPanel extends JPanel {
    
    private GraphicEditor graphicEditor;
    private CellPanel[][] cells;
    private int rows;
    private int columns;
    private int size;
    
    public CanvasPanel(int rows, int columns, int size, Color color, GraphicEditor graphicEditor) { 
        this.rows = rows;
        this.columns = columns;
        this.size = size;
        cells = new CellPanel[rows][columns];
        this.setLayout(new GridBagLayout());
        this.setSize(new Dimension(rows * size, columns * size));
        GridBagConstraints gbc = new GridBagConstraints();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                gbc.gridx = col;
                gbc.gridy = row;
                CellPanel cellPane = new CellPanel(size, color, graphicEditor); 
                cellPane.setSize(new Dimension(size, size));
                cells[row][col] = cellPane;
                Border border = new EtchedBorder();
                cellPane.setBorder(border);
                this.add(cellPane, gbc);
            }
        }
    }

    public GraphicEditor getGraphicEditor() {
        return graphicEditor;
    }

    public void setGraphicEditor(GraphicEditor graphicEditor) {
        this.graphicEditor = graphicEditor;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                cells[i][j].setGraphicEditor(graphicEditor);
            }
        }
    }

    public CellPanel getCells(int row, int column) {
        return cells[row][column];
    }
    
     public void setBorder(boolean noBoder){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(noBoder){
                    cells[i][j].setBorder(new LineBorder(Color.BLACK, 0, false));
                }
                else{
                    cells[i][j].setBorder(new EtchedBorder());
                }
            }
        }
    } 
}
    
   
