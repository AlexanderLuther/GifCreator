package com.hluther.gui;
import com.hluther.controlClasses.AnalysisDriver;
import com.hluther.controlClasses.CanvasFileDriver;
import com.hluther.controlClasses.ColorsFileDriver;
import com.hluther.controlClasses.FilesDriver;
import com.hluther.entityClasses.Canvas;
import javax.swing.JFileChooser;
import com.hluther.controlClasses.GifCreatorDriver;
import com.hluther.controlClasses.TimeFileDriver;
import com.hluther.entityClasses.ImageDTO;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
/**
 *
 * @author helmuth
 */
public class GifCreatorFrame extends javax.swing.JFrame {
    /*
    tabbedPanes[0] = archivo.lnz
    tabbedPanes[1] = archivo.clrs
    tabbedPanes[2] = archivo.tmp
    tabbedPanes[3] = archivo.pnt
    */
    private GifCreatorDriver gifCreatorDriver = new GifCreatorDriver();
    private FilesDriver filesDriver = new FilesDriver();
    private JFileChooser fileChooser;
    private JPanel[] panels = new JPanel[4];
    private JTextArea[] textAreas = new JTextArea[4];
    private String[] titles = new String[4];
    
    private AnalysisDriver analysisDriver = new AnalysisDriver();
    private Hashtable symbolTable;
    private CanvasFileDriver canvasFileDriver;
    private ColorsFileDriver colorsFileDriver;
    private TimeFileDriver timeFileDriver;
    
    private boolean canvasError = false; 
    private boolean colorsError = false;
    private boolean timeError = false;
    private boolean paintError = false;
    
    private GraphicEditor graphicEditor;
    
    private ArrayList<Canvas> canvases = new ArrayList<>();
   
    public GifCreatorFrame() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        messagesAreaPanel.setVisible(false);
        showMessagesAreaMenu.setSelected(false);
        graphicEditorMenu.setEnabled(false);
        generateGifMenu.setEnabled(false);  
    }

    public JTextArea getTimeTextArea(){
        return textAreas[2];
    }
    
    /*
    ABRIR UN NUEVO PANEL EN EL JTABBEDPANE
    Metodo encargado de:
        1. Validar que el indice del array donde se desea insertar sea null.
            a) Si es null no existe ningun panel del tipo recibido como parametro y se
              llama al metodo addPanel para insertar una nuevo.
            b) Si no es null, ya existe un panel instanciado del tipo deseado por lo cual
               no se puede insertar otro del mismo tipo entonces se lanza un mensaje y se 
               obtiene la seleccion del usuario:
                Caso 0: El usuario selecciona guardar el contenido del panel actual y
                        abrir uno nuevo.    
                Caso 1: El usuario selecciona descartar el contenido del panel actual y 
                        abrir uno nuevo.
                Caso 2: El usuario cancela la apetura del nuevo panel.
    */
    private void openPanel(int type, String name, String data){
        if(panels[type] == null){
            gifCreatorDriver.addPanel(name, data, editorTabbedPane, positionLabel, panels, textAreas, type);
            titles[type] = name;
        }
        else{
            String fileType = "";
            switch(type){
                case 0: fileType = "Lienzos"; break;
                case 1: fileType = "Colores"; break;
                case 2: fileType = "Tiempo"; break;
                case 3: fileType = "Pintura"; break;
            }
            int selectedOption = JOptionPane.showConfirmDialog(rootPane, "Desea guardar el archivo de configuracion de " + fileType + "?", "Guardar Archivo", 1, 2);
            switch(selectedOption){
                //Guardar
                case 0:
                    if(this.saveFile(name, type) != 1){
                        this.removePanel(type);
                        this.openPanel(type, name, data);
                    }
                break;
                //No guardar
                case 1:
                    this.removePanel(type);
                    this.openPanel(type, name, data);
                break;
                //Cancelar apertura
                case 2:
                break;
            }
        }
    }
    
    /*
    REABRIR PANELES GUARDADOS
    */
    private void reOpenPanel(int type, String name, String data){
            this.removePanel(type);
            gifCreatorDriver.addPanel(name, data, editorTabbedPane, positionLabel, panels, textAreas, type);
            titles[type] = name;
    }
    
    /*
    REMOVER PANEL.
    Metodo encargado de remover del JTabbedPane el panel contenido en el indice del 
    arreglo que se recibe como parametro. Establece a null el indice del arreglo y 
    llama al metodo openPanel.
    */
    private void removePanel(int type){
        editorTabbedPane.remove(panels[type]);
        panels[type] = null;
        textAreas[type] = null;
        titles[type] = null;
    }
    
    /*
    GUARDAR ARCHIVO
    Metodo encargado de abrir un JFileChooser, llama al metodo createFile enviando
    como parametros la direccion seleccionada por el usuario y el texto contenido 
    dentro del arreglo de areas de texto en el indice indicado por el parametro type
    */
    private int saveFile(String fileName, int type){
        fileChooser = new JFileChooser();
        this.gifCreatorDriver.configureFileChooserSave(fileChooser, fileName, type);
        int selection = fileChooser.showSaveDialog(this);      
        if(selection == JFileChooser.APPROVE_OPTION){
            filesDriver.createFile(fileChooser.getSelectedFile().toString(), textAreas[type].getText());
            titles[type] = fileChooser.getSelectedFile().getName();
        }
        return selection;
    }
      
    /*
    IMPRESION DE ERRORES LEXICOS, SINTACTICOS Y SEMANTICOS.
    */
    public void printError(String errorMessage, int fileType){
        messagesAreaPanel.setVisible(true);
        showMessagesAreaMenu.setSelected(true);
        switch(fileType){
            case 0:
                if(!canvasError){
                    messagesTextArea.setText(messagesTextArea.getText() + "\nERRORES EN ARCHIVO DE LIENZOS: "+titles[0]+"\n");
                    canvasError = true;
                }    
            break;     
            case 1:
                if(!colorsError){
                    messagesTextArea.setText(messagesTextArea.getText() + "\nERRORES EN ARCHIVO DE COLORES: "+titles[1]+"\n");
                    colorsError = true;
                } 
            break;
            case 2:
                if(!timeError){
                    messagesTextArea.setText(messagesTextArea.getText() + "\nERRORES EN ARCHIVO DE TIEMPOS: "+titles[2]+"\n");
                    timeError = true;
                }   
            break;
            case 3:
                if(!paintError){
                    messagesTextArea.setText(messagesTextArea.getText() + "\nERRORES EN ARCHIVO DE PINTURA: "+titles[3]+"\n");
                    paintError = true;
                } 
            break;
        }
        messagesTextArea.setText(messagesTextArea.getText() + errorMessage + "\n");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        principalPanel = new javax.swing.JPanel();
        editorAreaPanel = new javax.swing.JPanel();
        editorTabbedPane = new javax.swing.JTabbedPane();
        messagesAreaPanel = new javax.swing.JPanel();
        messagesAreaFrame = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        messagesTextArea = new javax.swing.JTextArea();
        footerPanel = new javax.swing.JPanel();
        positionLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        newMenu = new javax.swing.JMenu();
        newCanvasMenu = new javax.swing.JMenuItem();
        newColorMenu = new javax.swing.JMenuItem();
        newTimeMenu = new javax.swing.JMenuItem();
        newPaintMenu = new javax.swing.JMenuItem();
        openMenu = new javax.swing.JMenuItem();
        saveMenu = new javax.swing.JMenuItem();
        exitMenu = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        analysisMenu = new javax.swing.JMenuItem();
        generateMenu = new javax.swing.JMenu();
        graphicEditorMenu = new javax.swing.JMenuItem();
        generateGifMenu = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        showMessagesAreaMenu = new javax.swing.JCheckBoxMenuItem();
        jMenu4 = new javax.swing.JMenu();
        userManualMenu = new javax.swing.JMenuItem();
        technicalManualMenu = new javax.swing.JMenuItem();
        aboutMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gif Creator");
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new java.awt.CardLayout());

        backgroundPanel.setBackground(new java.awt.Color(54, 63, 69));
        backgroundPanel.setLayout(new java.awt.BorderLayout());

        principalPanel.setBackground(new java.awt.Color(54, 63, 69));
        principalPanel.setMaximumSize(new java.awt.Dimension(32767, 100));
        principalPanel.setMinimumSize(new java.awt.Dimension(100, 100));
        principalPanel.setPreferredSize(new java.awt.Dimension(150, 400));
        principalPanel.setLayout(new java.awt.BorderLayout());

        editorAreaPanel.setBackground(new java.awt.Color(54, 63, 69));
        editorAreaPanel.setForeground(new java.awt.Color(157, 157, 157));
        editorAreaPanel.setMaximumSize(new java.awt.Dimension(32767, 200));
        editorAreaPanel.setMinimumSize(new java.awt.Dimension(800, 150));
        editorAreaPanel.setLayout(new javax.swing.BoxLayout(editorAreaPanel, javax.swing.BoxLayout.LINE_AXIS));

        editorTabbedPane.setBackground(new java.awt.Color(25, 150, 135));
        editorTabbedPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        editorAreaPanel.add(editorTabbedPane);

        principalPanel.add(editorAreaPanel, java.awt.BorderLayout.CENTER);

        messagesAreaPanel.setMaximumSize(new java.awt.Dimension(32767, 175));
        messagesAreaPanel.setMinimumSize(new java.awt.Dimension(800, 175));
        messagesAreaPanel.setOpaque(false);
        messagesAreaPanel.setPreferredSize(new java.awt.Dimension(400, 175));
        messagesAreaPanel.setLayout(new javax.swing.BoxLayout(messagesAreaPanel, javax.swing.BoxLayout.LINE_AXIS));

        messagesAreaFrame.setBackground(new java.awt.Color(54, 63, 69));
        messagesAreaFrame.setVisible(true);
        messagesAreaFrame.getContentPane().setLayout(new javax.swing.BoxLayout(messagesAreaFrame.getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        messagesTextArea.setEditable(false);
        messagesTextArea.setColumns(20);
        messagesTextArea.setRows(5);
        messagesTextArea.setText("\n");
        jScrollPane1.setViewportView(messagesTextArea);

        messagesAreaFrame.getContentPane().add(jScrollPane1);

        messagesAreaPanel.add(messagesAreaFrame);

        principalPanel.add(messagesAreaPanel, java.awt.BorderLayout.PAGE_END);

        backgroundPanel.add(principalPanel, java.awt.BorderLayout.CENTER);

        footerPanel.setMaximumSize(new java.awt.Dimension(32767, 25));
        footerPanel.setMinimumSize(new java.awt.Dimension(0, 30));
        footerPanel.setPreferredSize(new java.awt.Dimension(400, 25));
        footerPanel.setLayout(new java.awt.BorderLayout());

        positionLabel.setBackground(new java.awt.Color(48, 50, 52));
        positionLabel.setForeground(new java.awt.Color(255, 255, 255));
        positionLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        positionLabel.setOpaque(true);
        footerPanel.add(positionLabel, java.awt.BorderLayout.CENTER);

        jLabel1.setBackground(new java.awt.Color(48, 50, 52));
        jLabel1.setMaximumSize(new java.awt.Dimension(10, 0));
        jLabel1.setMinimumSize(new java.awt.Dimension(10, 0));
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(10, 0));
        footerPanel.add(jLabel1, java.awt.BorderLayout.LINE_END);

        backgroundPanel.add(footerPanel, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(backgroundPanel, "card2");

        menu.setBackground(new java.awt.Color(48, 50, 53));
        menu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        menu.setForeground(new java.awt.Color(0, 0, 0));
        menu.setAutoscrolls(true);

        jMenu1.setBackground(new java.awt.Color(48, 50, 53));
        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/formato-de-documento-portable.png"))); // NOI18N
        jMenu1.setText("Archivo ");
        jMenu1.setFont(new java.awt.Font("Noto Sans Mono", 1, 14)); // NOI18N
        jMenu1.setOpaque(true);

        newMenu.setBackground(new java.awt.Color(0, 153, 51));
        newMenu.setForeground(new java.awt.Color(255, 255, 255));
        newMenu.setText("Nuevo");
        newMenu.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        newMenu.setOpaque(true);

        newCanvasMenu.setBackground(new java.awt.Color(48, 50, 53));
        newCanvasMenu.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        newCanvasMenu.setForeground(new java.awt.Color(255, 255, 255));
        newCanvasMenu.setText("Lienzos");
        newCanvasMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newCanvasMenuActionPerformed(evt);
            }
        });
        newMenu.add(newCanvasMenu);

        newColorMenu.setBackground(new java.awt.Color(48, 50, 53));
        newColorMenu.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        newColorMenu.setForeground(new java.awt.Color(255, 255, 255));
        newColorMenu.setText("Colores");
        newColorMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newColorMenuActionPerformed(evt);
            }
        });
        newMenu.add(newColorMenu);

        newTimeMenu.setBackground(new java.awt.Color(48, 50, 53));
        newTimeMenu.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        newTimeMenu.setForeground(new java.awt.Color(255, 255, 255));
        newTimeMenu.setText("Tiempo");
        newTimeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newTimeMenuActionPerformed(evt);
            }
        });
        newMenu.add(newTimeMenu);

        newPaintMenu.setBackground(new java.awt.Color(48, 50, 53));
        newPaintMenu.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        newPaintMenu.setForeground(new java.awt.Color(255, 255, 255));
        newPaintMenu.setText("Pintar");
        newPaintMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPaintMenuActionPerformed(evt);
            }
        });
        newMenu.add(newPaintMenu);

        jMenu1.add(newMenu);

        openMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openMenu.setBackground(new java.awt.Color(48, 50, 53));
        openMenu.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        openMenu.setForeground(new java.awt.Color(255, 255, 255));
        openMenu.setText("Abrir");
        openMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuActionPerformed(evt);
            }
        });
        jMenu1.add(openMenu);

        saveMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveMenu.setBackground(new java.awt.Color(48, 50, 53));
        saveMenu.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        saveMenu.setForeground(new java.awt.Color(255, 255, 255));
        saveMenu.setText("Guardar");
        saveMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuActionPerformed(evt);
            }
        });
        jMenu1.add(saveMenu);

        exitMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        exitMenu.setBackground(new java.awt.Color(48, 50, 53));
        exitMenu.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        exitMenu.setForeground(new java.awt.Color(255, 255, 255));
        exitMenu.setText("Salir");
        exitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuActionPerformed(evt);
            }
        });
        jMenu1.add(exitMenu);

        menu.add(jMenu1);

        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buscar (1).png"))); // NOI18N
        jMenu2.setText("Analisis ");
        jMenu2.setFont(new java.awt.Font("Noto Sans Mono", 1, 14)); // NOI18N

        analysisMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        analysisMenu.setBackground(new java.awt.Color(48, 50, 53));
        analysisMenu.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        analysisMenu.setForeground(new java.awt.Color(255, 255, 255));
        analysisMenu.setText("Analizar Archivos");
        analysisMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analysisMenuActionPerformed(evt);
            }
        });
        jMenu2.add(analysisMenu);

        menu.add(jMenu2);

        generateMenu.setForeground(new java.awt.Color(255, 255, 255));
        generateMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gif.png"))); // NOI18N
        generateMenu.setText("Generar ");
        generateMenu.setFont(new java.awt.Font("Noto Sans Mono", 1, 14)); // NOI18N

        graphicEditorMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        graphicEditorMenu.setBackground(new java.awt.Color(48, 50, 53));
        graphicEditorMenu.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        graphicEditorMenu.setForeground(new java.awt.Color(255, 255, 255));
        graphicEditorMenu.setText("Editor Grafico");
        graphicEditorMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphicEditorMenuActionPerformed(evt);
            }
        });
        generateMenu.add(graphicEditorMenu);

        generateGifMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        generateGifMenu.setBackground(new java.awt.Color(48, 50, 53));
        generateGifMenu.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        generateGifMenu.setForeground(new java.awt.Color(255, 255, 255));
        generateGifMenu.setText("Generar Gif");
        generateGifMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateGifMenuActionPerformed(evt);
            }
        });
        generateMenu.add(generateGifMenu);

        menu.add(generateMenu);

        jMenu3.setBackground(new java.awt.Color(48, 50, 53));
        jMenu3.setForeground(new java.awt.Color(255, 255, 255));
        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ojo.png"))); // NOI18N
        jMenu3.setText("Ver ");
        jMenu3.setFont(new java.awt.Font("Noto Sans Mono", 1, 14)); // NOI18N

        showMessagesAreaMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        showMessagesAreaMenu.setBackground(new java.awt.Color(48, 50, 53));
        showMessagesAreaMenu.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        showMessagesAreaMenu.setForeground(new java.awt.Color(255, 255, 255));
        showMessagesAreaMenu.setSelected(true);
        showMessagesAreaMenu.setText("Mostrar Area de Mensajes");
        showMessagesAreaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showMessagesAreaMenuActionPerformed(evt);
            }
        });
        jMenu3.add(showMessagesAreaMenu);

        menu.add(jMenu3);

        jMenu4.setForeground(new java.awt.Color(255, 255, 255));
        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/acerca-de.png"))); // NOI18N
        jMenu4.setText("Ayuda");
        jMenu4.setFont(new java.awt.Font("Noto Sans Mono", 1, 14)); // NOI18N

        userManualMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        userManualMenu.setBackground(new java.awt.Color(48, 50, 53));
        userManualMenu.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        userManualMenu.setForeground(new java.awt.Color(255, 255, 255));
        userManualMenu.setText("Manual de Usuario");
        userManualMenu.setOpaque(true);
        userManualMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userManualMenuActionPerformed(evt);
            }
        });
        jMenu4.add(userManualMenu);

        technicalManualMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        technicalManualMenu.setBackground(new java.awt.Color(48, 50, 53));
        technicalManualMenu.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        technicalManualMenu.setForeground(new java.awt.Color(255, 255, 255));
        technicalManualMenu.setText("Manual Tecnico");
        technicalManualMenu.setOpaque(true);
        technicalManualMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                technicalManualMenuActionPerformed(evt);
            }
        });
        jMenu4.add(technicalManualMenu);

        aboutMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        aboutMenu.setBackground(new java.awt.Color(48, 50, 53));
        aboutMenu.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        aboutMenu.setForeground(new java.awt.Color(255, 255, 255));
        aboutMenu.setText("Acerca De");
        aboutMenu.setOpaque(true);
        aboutMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuActionPerformed(evt);
            }
        });
        jMenu4.add(aboutMenu);

        menu.add(jMenu4);

        setJMenuBar(menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //CERRAR APLICACION.
    private void exitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuActionPerformed

    //ACERCA DE.
    private void aboutMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuActionPerformed
        JOptionPane.showMessageDialog(rootPane, "<html><center><p style=\"color:rgb(54,63,69);\"><b>Desarollado por: <br> Helmuth Alexander Luther Montejo <br> 201730457<b> </p></center></html>", "Acerca De", 1);
    }//GEN-LAST:event_aboutMenuActionPerformed

    //MOSTRAR Y OCULTAR AREA DE MENSAJES.
    private void showMessagesAreaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showMessagesAreaMenuActionPerformed
        if(showMessagesAreaMenu.isSelected()){
            messagesAreaPanel.setVisible(true);
            showMessagesAreaMenu.setSelected(true);
        }
        else{
            messagesAreaPanel.setVisible(false);
            showMessagesAreaMenu.setSelected(false); 
        }
    }//GEN-LAST:event_showMessagesAreaMenuActionPerformed

    /*
    ABRIR ARCHIVO
    Metodo encargado de abrir un JFileChooser y obtener los datos contenidos dentro del
    archivo cuyo path es proporcionado segun la seleccion del usuario en el fileChooser.
    Se establece el tipo de panel a abrir segun la extension del archivo y se llama al
    metodo openPanel para mostrar en un nuevo panel la informacion del archivo seleccionado.
    */
    private void openMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuActionPerformed
        fileChooser = new JFileChooser();
        this.gifCreatorDriver.configureFileChooserOpen(fileChooser);
        int selection = fileChooser.showOpenDialog(this);      
        if(selection == JFileChooser.APPROVE_OPTION){
            String fileName = fileChooser.getSelectedFile().getName(); 
            String data = this.filesDriver.readFile(fileChooser.getSelectedFile().toString());
            int type;
            if(fileName.endsWith(".lnz")){
                type = 0;
            }
            else if(fileName.endsWith(".clrs")){
                type = 1;
            }
            else if(fileName.endsWith(".tmp")){
                type = 2;
            }
            else{
                type = 3;
            }
            this.openPanel(type, fileName, data);
        }
    }//GEN-LAST:event_openMenuActionPerformed

    //NUEVO ARCHIVO .lnz
    private void newCanvasMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newCanvasMenuActionPerformed
        this.openPanel(0, "Untitle.lnz", "");
    }//GEN-LAST:event_newCanvasMenuActionPerformed

    //NUEVO ARCHIVO .clrs
    private void newColorMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newColorMenuActionPerformed
        this.openPanel(1, "Untitle.clrs", "");
    }//GEN-LAST:event_newColorMenuActionPerformed

    //NUEVO ARCHIVO .tmp
    private void newTimeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newTimeMenuActionPerformed
        this.openPanel(2, "Untitle.tmp", "");
    }//GEN-LAST:event_newTimeMenuActionPerformed

    //NUEVO ARCHIVO .pnt
    private void newPaintMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPaintMenuActionPerformed
        this.openPanel(3, "Untitle.pnt", "");
    }//GEN-LAST:event_newPaintMenuActionPerformed

    //GUARDAR TODOS LOS ARCHIVOS.
    private void saveMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuActionPerformed
        for(int i = 0; i < 4; i++){
            if(panels[i] != null){
                if(this.saveFile(titles[i], i) == 0){
                    this.reOpenPanel(i, titles[i], textAreas[i].getText());
                }
            }
        }
    }//GEN-LAST:event_saveMenuActionPerformed

    //MOSTRAR MANUAL DE USUARIO
    private void userManualMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userManualMenuActionPerformed
        filesDriver.openPDF("userManual.pdf");
    }//GEN-LAST:event_userManualMenuActionPerformed

    //MOSTRAR MANUAL TECNICO
    private void technicalManualMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_technicalManualMenuActionPerformed
        filesDriver.openPDF("technicalManual.pdf");
    }//GEN-LAST:event_technicalManualMenuActionPerformed

    //REALIZAR ANALISIS SINTACTICO Y LEXICO
    private void analysisMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analysisMenuActionPerformed
        if(panels[0] == null || panels[1] == null || panels[2] == null || panels[3] == null){
            JOptionPane.showMessageDialog(rootPane, "<html><font color=red>Para poder realizar el analisis se necesita abrir los cuatro tipos de archivos.</font></html>", "Error", 0);
        }
        else{
            //Inicializar variables
            graphicEditor = null;
            canvasError = false;
            colorsError = false;
            timeError = false;
            paintError = false;
            messagesTextArea.setText("");
            symbolTable = new Hashtable();
            //Realizar analisis
            canvasFileDriver = new CanvasFileDriver();
            analysisDriver.doCanvasFileAnalysis(textAreas[0].getText(), this, canvasFileDriver, symbolTable);            
            colorsFileDriver = new ColorsFileDriver(canvasFileDriver.getCanvases());
            analysisDriver.doColorsFileAnalysis(textAreas[1].getText(), this, colorsFileDriver, symbolTable);
            timeFileDriver = new TimeFileDriver(colorsFileDriver.getCanvases());
            analysisDriver.doTimeFileAnalysis(textAreas[2].getText(), this, timeFileDriver, symbolTable);
            
            //Obtener lienzos
            canvases = timeFileDriver.getCanvases();
            
            //Activar el editor grafico
            if(!canvasError && !colorsError && !timeError && !paintError){
                messagesAreaPanel.setVisible(false);
                graphicEditorMenu.setEnabled(true);
                generateGifMenu.setEnabled(true);
                JOptionPane.showMessageDialog(rootPane, "<html><center><p style=\"color:rgb(54,63,69);\">Analisis Exitoso.</p></center></html>", "Proceso de analisis.", 1);
            }
            else{
                graphicEditorMenu.setEnabled(false);
                generateGifMenu.setEnabled(false);
            }
        }
    }//GEN-LAST:event_analysisMenuActionPerformed

    //ABRIR EL EDITOR GRAFICO DE LIENZOS.
    private void graphicEditorMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphicEditorMenuActionPerformed
        if(graphicEditor == null){
            graphicEditor = new GraphicEditor(this, true, timeFileDriver.getCanvases());
        }
        else{
            graphicEditor.setBorder();
        }
        graphicEditor.setVisible(true);
    }//GEN-LAST:event_graphicEditorMenuActionPerformed

    /*
    GENERAR IMAGENES GIF Y PNG.
    Metodo encargado de generar las imagenes en base a los datos establecidos por cada 
    lienzo de imagen de inicio e imagen de fin.
    */
    private void generateGifMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateGifMenuActionPerformed
        Thread hilo = new Thread(){
        @Override 
        public  void run(){
            try {
                CanvasPanel canvasPanel;
                for(Canvas canvas : canvases){

                    //Crear arrayList para almacenar las imagenes y los tiempos.
                    ArrayList<BufferedImage> bufferedImages = new ArrayList<>();
                    ArrayList<Integer> times = new ArrayList<>();

                    //Obtener los indices que limitan la creacion de la imagen
                    int startIndex = canvas.getTime().getIdIndex(canvas.getTime().getStartId());
                    int endIndex = canvas.getTime().getIdIndex( canvas.getTime().getEndId());

                    for(int i = startIndex; i <= endIndex; i++){
                        //Obtener la imagen actual.
                        ImageDTO currentImage = canvas.getTime().getImages().get(i);

                        //Obtener CanvasPanel y sus medidas.
                        canvasPanel = currentImage.getCanvasPanel();
                        int columns = canvas.getColumns();
                        int rows = canvas.getRows();
                        int size = canvas.getPixelsAmount();

                        //Eliminar bordes.
                        canvasPanel.setBorder(true);

                        //Agregar tiempo y agregar imagen.
                        times.add(currentImage.getDuration());
                        bufferedImages.add(gifCreatorDriver.createBufferedImage(canvasPanel, rows, columns, size));        
                    } 

                    //Crear extension del archivo.
                    String extension = ".png";
                    if(canvas.isGIF()){
                        extension = ".gif";
                    }

                    //Crear la imagen.
                    if(!bufferedImages.isEmpty()){
                        gifCreatorDriver.createGif(bufferedImages, times, canvas.getImageName() + extension);
                    }
                }
                JOptionPane.showMessageDialog(rootPane, "Imagenes generadas exitosamente.", "Exito", 1);
            }    
            catch (Exception e) {
                System.out.println(e.toString());
            }
        }};
        hilo.start();    
    }//GEN-LAST:event_generateGifMenuActionPerformed
 
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
            java.util.logging.Logger.getLogger(GifCreatorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GifCreatorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GifCreatorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GifCreatorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GifCreatorFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenu;
    private javax.swing.JMenuItem analysisMenu;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JPanel editorAreaPanel;
    private javax.swing.JTabbedPane editorTabbedPane;
    private javax.swing.JMenuItem exitMenu;
    private javax.swing.JPanel footerPanel;
    private javax.swing.JMenuItem generateGifMenu;
    private javax.swing.JMenu generateMenu;
    private javax.swing.JMenuItem graphicEditorMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menu;
    private javax.swing.JInternalFrame messagesAreaFrame;
    private javax.swing.JPanel messagesAreaPanel;
    private javax.swing.JTextArea messagesTextArea;
    private javax.swing.JMenuItem newCanvasMenu;
    private javax.swing.JMenuItem newColorMenu;
    private javax.swing.JMenu newMenu;
    private javax.swing.JMenuItem newPaintMenu;
    private javax.swing.JMenuItem newTimeMenu;
    private javax.swing.JMenuItem openMenu;
    private javax.swing.JLabel positionLabel;
    private javax.swing.JPanel principalPanel;
    private javax.swing.JMenuItem saveMenu;
    private javax.swing.JCheckBoxMenuItem showMessagesAreaMenu;
    private javax.swing.JMenuItem technicalManualMenu;
    private javax.swing.JMenuItem userManualMenu;
    // End of variables declaration//GEN-END:variables
}
