package com.hluther.lexer;
import com.hluther.gui.GifCreatorFrame;
import com.hluther.parser.CanvasSym;
import java_cup.runtime.*;
%%//

/* 
----------------------------------- Opciones y declaraciones de JFlex -----------------------------------
*/
%class CanvasFileLexer
%cup
%cupdebug
%line 
%column
%public

Letter = [a-zA-Z]
Number = [0-9]
HexNumber = [0-9a-fA-F]
LineTerminator = \r|\n|\r\n
WhiteSpace = {LineTerminator} | [ \t\f]

/* 
----------------------------------- Codigo Java -----------------------------------
*/
%{
    private GifCreatorFrame gifCreatorFrame;
    private String errorLexeme; 
    private int line;
    private int column;

    public CanvasFileLexer(java.io.Reader in, GifCreatorFrame gifCreatorFrame) {
        this.gifCreatorFrame = gifCreatorFrame;    
        this.zzReader = in;
        this.errorLexeme = "";
        line = -1;
        column = -1;
    }
        
    private Symbol symbol(int type, String value) {
        return new Symbol(type, yyline+1, yycolumn, value);
    }

    private Symbol symbol(int type, int value) {
        return new Symbol(type, yyline+1, yycolumn, value);
    }

    private void printToken(String token){
        System.out.println(token);
    }

    private void createErrorLexeme(String lexeme, int line, int column){
        if(this.line == -1 && this.column == -1){
            this.line = line;
            this.column = column;
        }
        errorLexeme = errorLexeme + lexeme;
    }

    private void printError(){
        if(line != -1 && column != -1){
            gifCreatorFrame.printError("Error Lexico -> Lexema ["+errorLexeme+"] no reconocido. Linea: "+line+" Columna: "+column, 0);
            errorLexeme = "";
            line = -1;
            column = -1;
        }
    }

%}

%%//

/* 
----------------------------------- Reglas Lexicas -----------------------------------
*/
<YYINITIAL>{
    "{"                                                                         { printToken("CURLYBRACKETO"); printError(); return symbol(CanvasSym.CURLYBRACKETO, new String("{")); }
    "}"                                                                         { printToken("CURLYBRACKETC"); printError(); return symbol(CanvasSym.CURLYBRACKETC, new String("}")); }
    ":"                                                                         { printToken("COLON"); printError(); return symbol(CanvasSym.COLON, new String(":")); }
    ","                                                                         { printToken("COMMA"); printError(); return symbol(CanvasSym.COMMA, new String(",")); }
    "Red"                                                                       { printToken("RED"); printError(); return symbol(CanvasSym.RED, new String("Red")); }
    "Blue"                                                                      { printToken("BLUE"); printError(); return symbol(CanvasSym.BLUE, new String("Blue")); }
    "Green"                                                                     { printToken("GREEN"); printError(); return symbol(CanvasSym.GREEN, new String("Green")); }
    "HEX"                                                                       { printToken("HEX"); printError(); return symbol(CanvasSym.HEX, new String("HEX")); }
    "LIENZOS"                                                                   { printToken("CANVAS"); printError(); return symbol(CanvasSym.CANVAS, new String("LIENZOS")); }
    "Fondo"                                                                     { printToken("BACKGROUND"); printError(); return symbol(CanvasSym.BACKGROUND, new String("Fondo")); }
    "tamaño"                                                                    { printToken("SIZE"); printError(); return symbol(CanvasSym.SIZE, new String("tamaño")); }
    "cuadro"                                                                    { printToken("SQUARE"); printError(); return symbol(CanvasSym.SQUARE, new String("cuadro")); }
    "dimension_x"                                                               { printToken("DIMENSIONX"); printError(); return symbol(CanvasSym.DIMENSIONX, new String("dimension_x")); }
    "dimension_y"                                                               { printToken("DIMENSIONY"); printError(); return symbol(CanvasSym.DIMENSIONY, new String("dimension_y")); }
    "nombre"                                                                    { printToken("NAME"); printError(); return symbol(CanvasSym.NAME, new String("nombre")); }
    "tipo"                                                                      { printToken("TYPE"); printError(); return symbol(CanvasSym.TYPE, new String("tipo")); }
    ("\"") ("gif") ("\"")                                                       { printToken("GIF"); printError(); return symbol(CanvasSym.GIF, new String("\"gif\"")); }
    ("\"") ("png") ("\"")                                                       { printToken("PNG"); printError(); return symbol(CanvasSym.PNG, new String("\"png\"")); }
    ({Letter} | "_") ({Letter} | {Number} | "_")*                               { printToken("ID"); printError(); return symbol(CanvasSym.ID, yytext()); }
    {Number}+                                                                   { printToken("INTEGER"); printError(); return symbol(CanvasSym.INTEGER, Integer.parseInt(yytext())); }
    ("#"){HexNumber}{HexNumber}{HexNumber}{HexNumber}{HexNumber}{HexNumber}     { printToken("HEXCODE"); printError(); return symbol(CanvasSym.HEXCODE, yytext()); }
    ("\"") [^*]~ ("\"")                                                         { printToken("LITERAL"); printError(); return symbol(CanvasSym.LITERAL, yytext()); }
    {WhiteSpace}                        { printError(); }//Ignore
     .                                  { createErrorLexeme(new String(yytext()), (yyline+1), yycolumn); }  
}