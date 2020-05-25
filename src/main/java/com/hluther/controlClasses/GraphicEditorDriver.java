package com.hluther.controlClasses;

import com.hluther.gui.ColorComboBox;
import com.hluther.gui.GraphicEditor;
import com.hluther.entityClasses.Canvas;
import com.hluther.entityClasses.ImageDTO;
import com.hluther.gui.CanvasPanel;
import com.hluther.gui.CellPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
/**
 *
 * @author helmuth
 */
public class GraphicEditorDriver {
    
    private ColorComboBox colors;
    private JScrollPane scrollPane;
    private JPanel panel;
    
    
    public void addCanvas(Canvas canvas, JTabbedPane canvasesTabbedPane, GraphicEditor editor, ArrayList<JPanel> panels){
        this.addGraphicEditor(canvas, editor); 
        panel = new JPanel();
        canvasesTabbedPane.addTab(canvas.getId(), panel);
        panels.add(panel);
    }
    
   
    public void addGraphicEditor(Canvas canvas, GraphicEditor graphicEditor){
        for(ImageDTO image : canvas.getTime().getImages()){
            image.getCanvasPanel().setGraphicEditor(graphicEditor);
        }
    }

    /*
    Metodo encargado de:
        1. Remover todos los items de los JComboBox recibidos como parametros.
        2. Agregar a los JComboBox todos los id de imagenes dentro del lienzo 
           recibido como parametro.
        3. Establecer los valores selecionados dentro de los JComboBox.
    */
    public void setComboBoxItems(JComboBox imageId, JComboBox startId, JComboBox endId, Canvas canvas){
        //------------------------  1   ------------------------//
        imageId.removeAllItems();
        startId.removeAllItems();
        endId.removeAllItems();
        //------------------------  2   ------------------------//
        for(ImageDTO currentImage : canvas.getTime().getImages()){
            imageId.addItem(currentImage.getId());
            startId.addItem(currentImage.getId());
            endId.addItem(currentImage.getId());
        }
        //------------------------  3   ------------------------//
        imageId.setSelectedIndex(0);
        startId.setSelectedItem(canvas.getTime().getStartId());
        endId.setSelectedItem(canvas.getTime().getEndId());
    }
    
    /*
    Metodo encargado de:
        1. Crear una nueva instancia de la clase ColorComboBox y le pasa
           como paramtro los colores contenidos dentro del lienzo.
        2. Remueve todos los items dentro del JPanel colorPanel, agregar al 
           board colorPanel el ColorComboBox creado, repinta y revalida el board. 
        3. Agrega un evento dentro del ColorComboBox para que el board selectedColor
           board establezca su color de fondo al valor del color seleccionado dentro
           del JColorComboBox.
    */
    public ColorComboBox addColorComboBox(JPanel colorPanel, JPanel selectedColorPanel,  Canvas canvas){
        //------------------------  1   ------------------------//
        colors = new ColorComboBox(canvas.getColors());
        //------------------------  2   ------------------------//
        colorPanel.removeAll();
        colorPanel.add(colors);
        colorPanel.repaint();
        colorPanel.revalidate();
        //------------------------  3   ------------------------//
        colors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    selectedColorPanel.setBackground(colors.getSelectedColor());
           }
        });     
        return colors;
    }
    
    /*
    Metodo encargado de:    
        1. Obtener el liezo actual y establecer los bordes.
        2. Remover todos los componentes dentro del JTabbed pane donde se insertara 
           el lienzo.
        3. Crear un JScrollPane y agregarselo al lienzo.
        4. Agregar el JScrollPane al JTabbedPane indicado por el parametro tabberdPaneIndex.
        5. Repintar y revalidar el JTabbedPane
    */
    public void setCurrentCanvasPanel(int tabbedPaneIndex, Canvas canvas, ArrayList<JPanel> panels, int imageIdIndex){        
        CanvasPanel canvasPanel = canvas.getTime().getImages().get(imageIdIndex).getCanvasPanel();
        canvasPanel.setBorder(false);
        panels.get(tabbedPaneIndex).removeAll();        
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(canvasPanel);        
        panels.get(tabbedPaneIndex).setLayout(new BorderLayout());
        panels.get(tabbedPaneIndex).add(scrollPane, BorderLayout.CENTER);
        panels.get(tabbedPaneIndex).repaint();
        panels.get(tabbedPaneIndex).revalidate();
    }
    
}
