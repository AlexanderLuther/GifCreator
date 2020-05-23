package com.hluther.controlClasses;

import com.hluther.gui.ColorComboBox;
import com.hluther.gui.GraphicEditor;
import com.hluther.entityClasses.Canvas;
import com.hluther.entityClasses.ImageDTO;
import com.hluther.gui.CanvasPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
/**
 *
 * @author helmuth
 */
public class GraphicEditorDriver {
    
    private ColorComboBox colors;
    private JScrollPane scrollPane;
    private JPanel panel;
    
    
    public void addCanvas(Canvas canvas, JTabbedPane canvasesTabbedPane, GraphicEditor editor, ArrayList<JPanel> panels){
        this.addCanvasPanel(canvas, editor); 
        panel = new JPanel();
        canvasesTabbedPane.addTab(canvas.getId(), panel);
        panels.add(panel);
    }
    
   
    public void addCanvasPanel(Canvas canvas, GraphicEditor graphicEditor){
        for(ImageDTO image : canvas.getTime().getImages()){
            image.setCanvasPanel(new CanvasPanel(canvas.getColumns(), canvas.getRows(), canvas.getPixelsAmount(), canvas.getBackgroundColor(), graphicEditor));    
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
           panel colorPanel el ColorComboBox creado, repinta y revalida el panel. 
        3. Agrega un evento dentro del ColorComboBox para que el panel selectedColor
           panel establezca su color de fondo al valor del color seleccionado dentro
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
        1. Obtener el lienzo que se encuentra seleccionado.
        2. Crear una nueva instancia de JScrollPane y agregarle la imagen del lienzo.
        3. Establecer el layout del panel actual e insertar el JScrollPane.
        4. Repintar y revalidar el panel.
    */
    public void setCurrentCanvasPanel(int tabbedPaneIndex, Canvas canvas, ArrayList<JPanel> panels, int imageIdIndex){
        CanvasPanel canvasPanel = canvas.getTime().getImages().get(imageIdIndex).getCanvasPanel();
        panels.get(tabbedPaneIndex).removeAll();        
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(canvasPanel);        
        panels.get(tabbedPaneIndex).setLayout(new BorderLayout());
        panels.get(tabbedPaneIndex).add(scrollPane, BorderLayout.CENTER);
        panels.get(tabbedPaneIndex).repaint();
        panels.get(tabbedPaneIndex).revalidate();
    }
    
}
