package com.hluther.controlClasses;

import com.hluther.gui.ColorComboBox;
import com.hluther.entityClasses.Canvas;
import com.hluther.gui.LineNumber;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.text.BadLocationException;

/**
 *
 * @author helmuth
 */
public class GraphicEditorDriver {
    
    private ColorComboBox colors;
    
    private JScrollPane scrollPane;
    private JPanel panel;
    
    
    public void addCanvas(String name, JTabbedPane canvasesTabbedPane){
        //----------------------------  1   ----------------------------//
        //textArea = new JTextArea(data);
        //scrollPane = new JScrollPane(textArea);
        //scrollPane.setRowHeaderView(lineNumber);
        panel = new JPanel(new GridLayout());
        //panel.add(scrollPane);
        canvasesTabbedPane.addTab(name, panel); 
    }
    
    public void addColorComboBoxEvent(ColorComboBox colors, JPanel panel){
        colors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    panel.setBackground(colors.getSelectedColor());
                    panel.repaint();
                    panel.revalidate();
           }
        });
    }
    
    
    
    
    
}
