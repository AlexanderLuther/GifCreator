package com.hluther.controlClasses;
import com.hluther.gui.GifCreatorFrame;
import com.hluther.lexer.CanvasFileLexer;
import com.hluther.lexer.ColorsFileLexer;
import com.hluther.lexer.PaintFileLexer;
import com.hluther.lexer.TimeFileLexer;
import com.hluther.parser.CanvasFileParser;
import com.hluther.parser.ColorsFileParser;
import com.hluther.parser.PaintFileParser;
import com.hluther.parser.TimeFileParser;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Hashtable;
import com.hluther.entityClasses.Canvas;

/**
 *
 * @author helmuth
 */
public class AnalysisDriver {
    
    public void doCanvasFileAnalysis(String text, GifCreatorFrame gifCreatorFrame, CanvasFileDriver canvasFileDriver, Hashtable symbolTable){
        try { 
            new CanvasFileParser(new CanvasFileLexer(new StringReader(text), gifCreatorFrame), gifCreatorFrame, canvasFileDriver, symbolTable).parse();
        } 
        catch (Exception ex) {}
    }
    
    public void doColorsFileAnalysis(String text, GifCreatorFrame gifCreatorFrame, ColorsFileDriver colorsFileDriver, Hashtable symbolTable){
        try { 
            new ColorsFileParser(new ColorsFileLexer(new StringReader(text), gifCreatorFrame), gifCreatorFrame, colorsFileDriver, symbolTable).parse();
        } 
        catch (Exception ex) {}
    }
    
     public void doTimeFileAnalysis(String text, GifCreatorFrame gifCreatorFrame, TimeFileDriver timeFileDriver, Hashtable symbolTable){
        try { 
            new TimeFileParser(new TimeFileLexer(new StringReader(text), gifCreatorFrame), gifCreatorFrame, timeFileDriver, symbolTable).parse();
        } 
        catch (Exception ex) {}
    }
     
    public void doPaintFileAnalysis(String text, GifCreatorFrame gifCreatorFrame, PaintFileDriver paintFileDriver, ArrayList<Canvas> canvases){
        try { 
            new PaintFileParser(new PaintFileLexer(new StringReader(text), gifCreatorFrame), gifCreatorFrame, paintFileDriver, canvases).parse();
        } 
        catch (Exception ex) {}
    } 
     
}
