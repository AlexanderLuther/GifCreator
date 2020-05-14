package com.hluther.controlClasses;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author helmuth
 */
public class FilesDriver {
    
    private BufferedReader bufferReader;
    private FileOutputStream fileOutputStream;
    private File file;
    private String data;
    private String text;

    /*
    LEER ARCHIVO
    Metodo que recibe como parametro un path, el cual utiliza para la apertura de 
    un archivo y su posterior lectura. Devuelve un String con todos los datos 
    contenidos dentro del archivo.
    */
    public String readFile(String path){
        text = "";
	try {
            bufferReader = new BufferedReader(new FileReader(path));
            while ((data = bufferReader.readLine()) != null){    
                text = text + data + "\n";
            } 
	}
        catch (EOFException ex) {
            System.out.println("ERROR: Lectura finalizada");
	}
        catch (IOException ex) {
            System.out.println("ERROR: No se puede leer archivo");
	}
        finally{
            try {
		bufferReader.close();
            } 
            catch (IOException ex) {
		System.out.println("ERROR: No se pudo cerrar el archivo");
            }
	}
        return text;
    }
    
    /*
    CREAR ARCHIVO
    Metodo encargado de crear un archivo en la ruta que recibe como parametro.
    Establece el contenido del archivo segun el parametro data.
    */
    public void createFile(String path, String data){
        try {
            fileOutputStream = null;
            fileOutputStream = new FileOutputStream(path);
            fileOutputStream.write(data.getBytes());
        } 
        catch (FileNotFoundException ex) {
            System.out.println("Error al crear el archivo");
        } catch (IOException ex) {
            System.out.println("Error al crear el archivo");
        }
    }
    
    //ABRIR DOCUMENTO PDF
    public void openPDF(String name){
        try {
            InputStream pdf = getClass().getClassLoader().getResourceAsStream(name);
            file = new File(name);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            while (pdf.available() > 0) {
                fileOutputStream.write(pdf.read());
            }
            fileOutputStream.close();
            Desktop.getDesktop().open(file);
        }   
        catch (IOException e) {
            System.out.println("Error : " + e);
        } 
    }
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
    Metodo encargado de crear la carpeta principal que almacenara todos los proyectos.
    */
    public void createRootFolder(){
        File rootFolder = new File("/home/helmuth/Documentos/ProyectosCSV");
        if(!rootFolder.exists()){
            rootFolder.mkdir();
        }
    }
    
    /*
    Metodo encargado de crear carpetas dentro la ruta que se especifica como parametro.
    */
    public void createFolder(String path){
        File folder = new File("/home/helmuth/Documentos/ProyectosCSV/" + path);
        folder.mkdir();    
    }
    
    
    
    /*
    Metodo encarado de borrar un archivo
    */
    public void deleteFile(String path){
        File file = new File (path);
        file.delete();
    }
    
    /*
    Metodo encargado de borrar una carpeta y tods los archivos que contenga.
    */
    public void deleteFolder(String path){
        File file = new File ("/home/helmuth/Documentos/ProyectosCSV/"+path);
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                File fileR = new File (f.getPath());
                fileR.delete();
            }
        }
        file.delete();
    }
    
    
}
