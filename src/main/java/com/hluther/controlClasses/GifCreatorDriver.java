package com.hluther.controlClasses;
import com.hluther.gui.CanvasPanel;
import com.hluther.gui.LineNumber;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;

/**
 *
 * @author helmuth
 */
public class GifCreatorDriver {
    
    private final FileNameExtensionFilter filterLNZ = new FileNameExtensionFilter("LNZ","lnz");
    private final FileNameExtensionFilter filterCLRS = new FileNameExtensionFilter("CLRS","clrs");
    private final FileNameExtensionFilter filterTMP = new FileNameExtensionFilter("TMP","tmp");
    private final FileNameExtensionFilter filterPNT = new FileNameExtensionFilter("PNT","pnt");
    private JTextArea textArea;
    private LineNumber lineNumber;
    private JScrollPane scrollPane;
    private JPanel panel;
    
    /*
    CONFIGURAR FILE CHOOSER ABRIR ARCHIVO
    Metodo encargado de establecer los filtros de busqueda del JfileChooser, el titulo
    y el texto del boton de aceptar del mismo.
    */
    public void configureFileChooserOpen(JFileChooser fileChooser){
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileFilter(filterCLRS);
        fileChooser.setFileFilter(filterPNT);
        fileChooser.setFileFilter(filterTMP);
        fileChooser.setFileFilter(filterLNZ);
        fileChooser.setApproveButtonText("Abrir");
        fileChooser.setDialogTitle("Abrir Archivo");  
    }
    
    /*
    CONFIGURAR FILE CHOOSER GUARDAR ARCHIVO
    Metodo encargado de establecer el filtro de busqueda en base al parametro type
    recibido, establecer el nombre sugerido del archivo a guardar, el titulo y el 
    texto del boton de guardar del fileChooser.
    */
    public void configureFileChooserSave(JFileChooser fileChooser, String fileName, int type){
        switch(type){
            case 0:
                fileChooser.setFileFilter(filterLNZ);
            break;
            case 1:
                fileChooser.setFileFilter(filterCLRS);
            break;
            case 2:
                fileChooser.setFileFilter(filterTMP);
            break;
            case 3:
                fileChooser.setFileFilter(filterPNT);
            break;
        } 
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setApproveButtonText("Guardar");
        fileChooser.setDialogTitle("Guardar Archivo");
        fileChooser.setSelectedFile(new File(fileName));
    }
    
    /*
    ABRIR UNA NUEVA PESTANA DE EDICION DE TEXTO.
    Metodo encargado de:
        1. a) crear una nueva instancia de JTextArea y establecer su contenido segun el parametro text.
           b) Crear una nueva instancia de la clase LineNumber y pasarle como parametro el JTextArea instanciado.
           c) Crear una nueva instancia de JScrollPane y enviarme como parametro el JTextArea, ademas establece
           el valor del atributo rowHeaderView al valor de lineNumber, esto permitira ver un indicador del 
              numero de lineas dentro del JTextArea.
           d) Por ultimo se crea una nueva instancia de JPanel a la cual se le  agrega el JScroolPane.
        2. Establecer un  evento en el JTextArea con el fin de imprimir en un
           JLabel la linea y la columna donde se encuentra el cursor.
    */
    public void addPanel(String name, String data, JTabbedPane editorTabbedPane, JLabel positionLabel, JPanel[] panels, JTextArea[] textAreas, int type){
        //----------------------------  1   ----------------------------//
        textArea = new JTextArea(data);
        lineNumber= new LineNumber(textArea);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setRowHeaderView(lineNumber);
        panel = new JPanel(new GridLayout());
        panel.add(scrollPane);
        editorTabbedPane.addTab(name, panel);
        panels[type] = panel;
        textAreas[type] = textArea;
        //----------------------------  2   ----------------------------//
        textArea.addCaretListener((CaretEvent e) -> {
            try {
                int actualPosition = textArea.getCaretPosition();
                int line= textArea.getLineOfOffset(actualPosition);
                int column = actualPosition - textArea.getLineStartOffset(line);
                line += 1;
                positionLabel.setText("Linea: " + line + "           Columna: " + column);
            }
            catch(BadLocationException ex){
                System.out.println("Error al capturar el evento");
            }
        }); 
    }
    
    /*
    CAPTURAR IMAGEN DE JPANEL.
    Metodo que recibe como parametros una instancia de la clase CanvasPanel, y las medidas
    de la intancia. Obtiene y devuelve un BufferedImage del CanvasPanel recibido.
    */
    public BufferedImage createBufferedImage(CanvasPanel canvasPanel, int width, int height, int size){
        canvasPanel.setPreferredSize(new Dimension(height*size, width*size));
        canvasPanel.setSize(canvasPanel.getPreferredSize());
        canvasPanel.doLayout();
        BufferedImage image = new BufferedImage(canvasPanel.getWidth(), canvasPanel.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        canvasPanel.print(g);
        g.dispose();
        return image;
    }
    
    /*
    CREAR IMAGEN GIF.
    Metodo encargado de generar una imagen gif. Recibe como parametros las BufferedImages 
    que se utilizaran para crear el gif. Los tiempos entre cada una de las transiciones 
    y el nombre que tendra la imagen gif resultante.
    */
    public void createGif(ArrayList<BufferedImage> images, ArrayList<Integer> times, String imageName) {
        try {
            BufferedImage firstImage = images.get(0);
            ImageOutputStream output = new FileImageOutputStream(new File(imageName));
            GifSequenceWriter writer =  new GifSequenceWriter(output, firstImage.getType(), times.get(0), true);
            writer.writeToSequence(firstImage, times.get(0));
            for(int i = 1; i <images.size(); i++) {
                BufferedImage nextImage = images.get(i);
                writer.writeToSequence(nextImage, times.get(i));
            }
            writer.close();
            output.close();
        } 
        catch (IOException ex) {
            System.out.println("Error creando la imagen gif.");
        }
    }
    
    
}
