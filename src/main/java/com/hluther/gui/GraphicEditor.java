package com.hluther.gui;
import com.hluther.controlClasses.GraphicEditorDriver;
import com.hluther.controlClasses.TextWriterDriver;
import com.hluther.entityClasses.Canvas;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
/**
 *
 * @author helmuth
 */
public class GraphicEditor extends javax.swing.JDialog {
    
    private GraphicEditorDriver graphicEditorDriver = new GraphicEditorDriver();
    private TextWriterDriver textWriter = new TextWriterDriver();
    private ArrayList<Canvas> canvases;
    private JTextArea timeTextArea;
    private ColorComboBox colors;
    private Canvas canvas;
    private ArrayList<JPanel> panels = new ArrayList<>();
    private boolean makeActions = false;

    public GraphicEditor(GifCreatorFrame parent, boolean modal, ArrayList<Canvas> canvases) {
        super(parent, modal);
        initComponents();
        this.timeTextArea = parent.getTimeTextArea();
        this.canvases = canvases;
        this.setLocationRelativeTo(null);
        this.addCanvas();
        makeActions = true;
        graphicEditorDriver.setCurrentCanvasPanel(0, canvas, panels, 0);
    }
    
    /*
    AGREGAR LOS LIENZOS A LA INTERFAZ.
    Metodo encargado de agregar todos los lienzos en el arrayList
    canvases a el JTabbedPane de lienzos.
    */
    private void addCanvas(){
        for(Canvas canvas : canvases){
            graphicEditorDriver.addCanvas(canvas, canvasesTabbedPane, this, panels);
        }
    }

    /*
    PINTAR UN CUADRO
    Metodo encargado de pintar un cuadro con el color seleccionado en el selector
    de colores. Si se encuentra activado el borrador se pinta el cuadro del mismo
    color que el del lienzo. 
    */
    public void paintSquare(CellPanel cell){
        if(erraserActivate.isSelected()){
            cell.setBackground(canvas.getBackgroundColor());
        }
        else{
            cell.setBackground(selectedColorPanel.getBackground());
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        colorsPanel = new javax.swing.JPanel();
        Jpanel45 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        JPanel8856 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        JpANEL = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        colorPanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        selectedColorPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        erraserActivate = new javax.swing.JCheckBox();
        jPanel8 = new javax.swing.JPanel();
        timePanel = new javax.swing.JPanel();
        startEndPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        setStartEnd = new javax.swing.JButton();
        startComboBox = new javax.swing.JComboBox<>();
        endComboBox = new javax.swing.JComboBox<>();
        imagenDurationPanel = new javax.swing.JPanel();
        durationPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        durationTextArea = new javax.swing.JTextField();
        modifyDuration = new javax.swing.JButton();
        imagePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        imageIdComboBox = new javax.swing.JComboBox<>();
        canvasesPanel = new javax.swing.JPanel();
        canvasesTabbedPane = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editor Grafico");
        setMinimumSize(new java.awt.Dimension(700, 500));
        setModal(true);
        setPreferredSize(new java.awt.Dimension(700, 500));

        jPanel1.setBackground(new java.awt.Color(54, 63, 69));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jPanel2.setBackground(new java.awt.Color(204, 204, 0));
        jPanel2.setMaximumSize(new java.awt.Dimension(750, 32767));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 391));
        jPanel2.setLayout(new java.awt.BorderLayout());

        colorsPanel.setBackground(new java.awt.Color(204, 0, 204));
        colorsPanel.setPreferredSize(new java.awt.Dimension(300, 150));
        colorsPanel.setLayout(new java.awt.BorderLayout());

        Jpanel45.setBackground(new java.awt.Color(54, 63, 69));
        Jpanel45.setPreferredSize(new java.awt.Dimension(300, 20));
        Jpanel45.setLayout(new java.awt.BorderLayout());
        colorsPanel.add(Jpanel45, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(54, 63, 69));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new java.awt.BorderLayout());

        JPanel8856.setBackground(new java.awt.Color(54, 63, 69));
        JPanel8856.setPreferredSize(new java.awt.Dimension(300, 50));
        JPanel8856.setLayout(new java.awt.BorderLayout());

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("   Colores:");
        jLabel5.setPreferredSize(new java.awt.Dimension(57, 20));
        JPanel8856.add(jLabel5, java.awt.BorderLayout.PAGE_START);

        JpANEL.setBackground(new java.awt.Color(54, 63, 69));
        JpANEL.setPreferredSize(new java.awt.Dimension(300, 30));
        JpANEL.setLayout(new javax.swing.BoxLayout(JpANEL, javax.swing.BoxLayout.LINE_AXIS));

        jPanel4.setBackground(new java.awt.Color(54, 63, 69));
        jPanel4.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        JpANEL.add(jPanel4);

        colorPanel.setBackground(new java.awt.Color(54, 63, 69));
        colorPanel.setPreferredSize(new java.awt.Dimension(240, 30));
        colorPanel.setLayout(new java.awt.BorderLayout());
        JpANEL.add(colorPanel);

        jPanel6.setBackground(new java.awt.Color(54, 63, 69));
        jPanel6.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        JpANEL.add(jPanel6);

        JPanel8856.add(JpANEL, java.awt.BorderLayout.CENTER);

        jPanel3.add(JPanel8856, java.awt.BorderLayout.PAGE_START);

        jPanel5.setBackground(new java.awt.Color(54, 63, 69));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel9.setBackground(new java.awt.Color(54, 63, 69));
        jPanel9.setPreferredSize(new java.awt.Dimension(0, 100));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel10.setBackground(new java.awt.Color(54, 63, 69));
        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel10.setPreferredSize(new java.awt.Dimension(20, 10));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 292, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel10, java.awt.BorderLayout.PAGE_START);

        jPanel11.setBackground(new java.awt.Color(54, 63, 69));
        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel11.setMaximumSize(new java.awt.Dimension(30, 23));
        jPanel11.setMinimumSize(new java.awt.Dimension(30, 23));
        jPanel11.setPreferredSize(new java.awt.Dimension(30, 40));
        jPanel11.setLayout(new javax.swing.BoxLayout(jPanel11, javax.swing.BoxLayout.LINE_AXIS));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("  Color Seleccionado:");
        jPanel11.add(jLabel6);

        jLabel7.setText("      ");
        jPanel11.add(jLabel7);

        selectedColorPanel.setBackground(new java.awt.Color(54, 63, 69));
        selectedColorPanel.setMaximumSize(new java.awt.Dimension(40, 32767));
        selectedColorPanel.setMinimumSize(new java.awt.Dimension(40, 0));
        selectedColorPanel.setPreferredSize(new java.awt.Dimension(40, 30));

        javax.swing.GroupLayout selectedColorPanelLayout = new javax.swing.GroupLayout(selectedColorPanel);
        selectedColorPanel.setLayout(selectedColorPanelLayout);
        selectedColorPanelLayout.setHorizontalGroup(
            selectedColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        selectedColorPanelLayout.setVerticalGroup(
            selectedColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel11.add(selectedColorPanel);

        jLabel8.setText("                                     ");
        jPanel11.add(jLabel8);

        jPanel9.add(jPanel11, java.awt.BorderLayout.CENTER);

        jPanel12.setBackground(new java.awt.Color(54, 63, 69));
        jPanel12.setMaximumSize(new java.awt.Dimension(32767, 50));
        jPanel12.setMinimumSize(new java.awt.Dimension(0, 50));
        jPanel12.setPreferredSize(new java.awt.Dimension(300, 50));

        erraserActivate.setForeground(new java.awt.Color(255, 255, 255));
        erraserActivate.setText("Borrador Activado");
        erraserActivate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        erraserActivate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        erraserActivate.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(erraserActivate)
                .addContainerGap(151, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(erraserActivate)
                .addGap(0, 25, Short.MAX_VALUE))
        );

        jPanel9.add(jPanel12, java.awt.BorderLayout.PAGE_END);

        jPanel5.add(jPanel9, java.awt.BorderLayout.PAGE_START);

        jPanel8.setBackground(new java.awt.Color(54, 63, 69));
        jPanel8.setPreferredSize(new java.awt.Dimension(296, 140));
        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.LINE_AXIS));
        jPanel5.add(jPanel8, java.awt.BorderLayout.PAGE_END);

        jPanel3.add(jPanel5, java.awt.BorderLayout.CENTER);

        colorsPanel.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel2.add(colorsPanel, java.awt.BorderLayout.CENTER);

        timePanel.setBackground(new java.awt.Color(54, 63, 69));
        timePanel.setPreferredSize(new java.awt.Dimension(300, 200));
        timePanel.setLayout(new javax.swing.BoxLayout(timePanel, javax.swing.BoxLayout.LINE_AXIS));

        startEndPanel.setBackground(new java.awt.Color(54, 63, 69));
        startEndPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Inicio");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Fin");

        setStartEnd.setText("Modificar");
        setStartEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setStartEndActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout startEndPanelLayout = new javax.swing.GroupLayout(startEndPanel);
        startEndPanel.setLayout(startEndPanelLayout);
        startEndPanelLayout.setHorizontalGroup(
            startEndPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(startEndPanelLayout.createSequentialGroup()
                .addGroup(startEndPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(startEndPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(startEndPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(startComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(setStartEnd, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)))
                    .addGroup(startEndPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(endComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        startEndPanelLayout.setVerticalGroup(
            startEndPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(startEndPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(endComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(setStartEnd)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        timePanel.add(startEndPanel);

        imagenDurationPanel.setBackground(new java.awt.Color(54, 63, 69));
        imagenDurationPanel.setLayout(new java.awt.BorderLayout());

        durationPanel.setBackground(new java.awt.Color(54, 63, 69));
        durationPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        durationPanel.setOpaque(false);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Duracion");

        durationTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                durationTextAreaKeyTyped(evt);
            }
        });

        modifyDuration.setText("Modificar");
        modifyDuration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyDurationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout durationPanelLayout = new javax.swing.GroupLayout(durationPanel);
        durationPanel.setLayout(durationPanelLayout);
        durationPanelLayout.setHorizontalGroup(
            durationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(durationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(durationTextArea)
                .addContainerGap())
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, durationPanelLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(modifyDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        durationPanelLayout.setVerticalGroup(
            durationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(durationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(durationTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modifyDuration)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        imagenDurationPanel.add(durationPanel, java.awt.BorderLayout.CENTER);

        imagePanel.setBackground(new java.awt.Color(54, 63, 69));
        imagePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        imagePanel.setOpaque(false);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Imagen");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        imageIdComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                imageIdComboBoxItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(imagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageIdComboBox, 0, 149, Short.MAX_VALUE)
                .addContainerGap())
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagePanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imageIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        imagenDurationPanel.add(imagePanel, java.awt.BorderLayout.PAGE_START);

        timePanel.add(imagenDurationPanel);

        jPanel2.add(timePanel, java.awt.BorderLayout.PAGE_START);
        timePanel.getAccessibleContext().setAccessibleName("");

        jPanel1.add(jPanel2);

        canvasesPanel.setBackground(new java.awt.Color(54, 63, 69));
        canvasesPanel.setLayout(new java.awt.BorderLayout());

        canvasesTabbedPane.setBackground(new java.awt.Color(54, 63, 69));
        canvasesTabbedPane.setOpaque(true);
        canvasesTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                canvasesTabbedPaneStateChanged(evt);
            }
        });
        canvasesPanel.add(canvasesTabbedPane, java.awt.BorderLayout.CENTER);

        jPanel1.add(canvasesPanel);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
    LLENAR LOS JCOMBO BOX.
    Metodo encargado de:
        1. Obtener el lienzo que se encuentra seleccionado actualmente.
        2. Llamar al metodo setComboBoxItems para llenar los JComboBox.
        3. Llamar al metodo addColorComboBox para agregar un selector de colores.
        4. Establecer el color de fondo del JPanel selectedColor panel y establecer
           el estado selected del JCheckBox en false.
    */
    private void canvasesTabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_canvasesTabbedPaneStateChanged
        canvas = canvases.get(canvasesTabbedPane.getSelectedIndex());
        graphicEditorDriver.setComboBoxItems(imageIdComboBox, startComboBox, endComboBox, canvas);
        colors = graphicEditorDriver.addColorComboBox(colorPanel, selectedColorPanel, canvas);
        selectedColorPanel.setBackground(colors.getSelectedColor());
        erraserActivate.setSelected(false);
    }//GEN-LAST:event_canvasesTabbedPaneStateChanged

    /*
    OBTENER E IMPRIMIR LA DURACION DE LA IMAGEN SELECCIONADA.
    Metodo encargado de:
        1. Obtener y llenar el JTextField con el valor del atributo duracion 
           contenido dentro de la imagen seleccionada en el JComboBox de imagenes.
        2. Establecer la imagen correspondiente en el liezo actual.
    */
    private void imageIdComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_imageIdComboBoxItemStateChanged
        if(imageIdComboBox.getSelectedIndex() >= 0){
            durationTextArea.setText(String.valueOf(canvas.getTime().getImages().get(imageIdComboBox.getSelectedIndex()).getDuration()));
            if(makeActions){
                graphicEditorDriver.setCurrentCanvasPanel(canvasesTabbedPane.getSelectedIndex(), canvas, panels, imageIdComboBox.getSelectedIndex());
            } 
        }
    }//GEN-LAST:event_imageIdComboBoxItemStateChanged

    /*
    PERMITIR SOLAMENTE NUMEROS.
    Metodo encargado de restringir el area de texto solamente a recepcion numeros.
    */
    private void durationTextAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_durationTextAreaKeyTyped
        char caracter = evt.getKeyChar();
        if(((caracter < '0') || (caracter > '9')) && (caracter != '\b')){
            evt.consume();
        }
    }//GEN-LAST:event_durationTextAreaKeyTyped

    /*
    MODIFICAR EL VALOR DEL ATRIBUTO DURATION.
    Metodo encargado de modificar el valor del atributo duration de la imagen seleccionada
    en el JComboBox de imagenes del lienzo actual.
    */
    private void modifyDurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyDurationActionPerformed
        if(!durationTextArea.getText().isEmpty() && !durationTextArea.getText().isBlank()){
            canvas.getTime().getImages().get(imageIdComboBox.getSelectedIndex()).setDuration(Integer.parseInt(durationTextArea.getText()));
            timeTextArea.setText(textWriter.writeTimeFileText(canvases));
        }
    }//GEN-LAST:event_modifyDurationActionPerformed

    /*
    MODIFICAR EL VALOR DE ID INICIAL Y FINAL DEL LIENZO
    Metodo encargado de modificar el valor del atributo startId del lienzo actual al valor 
    seleccionado en el JComboBox startIdComboBox.
    Modifica el valor del atributo enId del lienzo actual al valor  seleccionado en el
    JComboBox endIdComboBox.
    */
    private void setStartEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setStartEndActionPerformed
        canvas.getTime().setStartId(startComboBox.getSelectedItem().toString());
        canvas.getTime().setEndId(endComboBox.getSelectedItem().toString());
        timeTextArea.setText(textWriter.writeTimeFileText(canvases));
    }//GEN-LAST:event_setStartEndActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GraphicEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraphicEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraphicEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraphicEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GraphicEditor dialog = new GraphicEditor(new GifCreatorFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanel8856;
    private javax.swing.JPanel JpANEL;
    private javax.swing.JPanel Jpanel45;
    private javax.swing.JPanel canvasesPanel;
    private javax.swing.JTabbedPane canvasesTabbedPane;
    private javax.swing.JPanel colorPanel;
    private javax.swing.JPanel colorsPanel;
    private javax.swing.JPanel durationPanel;
    private javax.swing.JTextField durationTextArea;
    private javax.swing.JComboBox<String> endComboBox;
    private javax.swing.JCheckBox erraserActivate;
    private javax.swing.JComboBox<String> imageIdComboBox;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JPanel imagenDurationPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton modifyDuration;
    private javax.swing.JPanel selectedColorPanel;
    private javax.swing.JButton setStartEnd;
    private javax.swing.JComboBox<String> startComboBox;
    private javax.swing.JPanel startEndPanel;
    private javax.swing.JPanel timePanel;
    // End of variables declaration//GEN-END:variables
}
