package com.hluther.lexer;
import com.hluther.gui.GifCreatorFrame;
import com.hluther.parser.TimeSym;
import java_cup.runtime.*;
%%//

/* 
----------------------------------- Opciones y declaraciones de JFlex -----------------------------------
*/
%class TimeFileLexer
%cup
%cupdebug
%line 
%column
%public

Letter = [a-zA-Z]
Number = [0-9]
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

    public TimeFileLexer(java.io.Reader in, GifCreatorFrame gifCreatorFrame) {
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
            gifCreatorFrame.printError("Error Lexico -> Lexema ["+errorLexeme+"] no reconocido. Linea: "+line+" Columna: "+column, 2);
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
    "{"                                                                         { printToken("CURLYBRACKETO"); printError(); return symbol(TimeSym.CURLYBRACKETO, new String("{")); }
    "}"                                                                         { printToken("CURLYBRACKETC"); printError(); return symbol(TimeSym.CURLYBRACKETC, new String("}")); }
    "["                                                                         { printToken("SQUAREBRACKETO"); printError(); return symbol(TimeSym.SQUAREBRACKETO, new String("[")); }
    "]"                                                                         { printToken("SQUAREBRACKETC"); printError(); return symbol(TimeSym.SQUAREBRACKETC, new String("]")); }
    ":"                                                                         { printToken("COLON"); printError(); return symbol(TimeSym.COLON, new String(":")); }
    ","                                                                         { printToken("COMMA"); printError(); return symbol(TimeSym.COMMA, new String(",")); }
    "TIEMPOS"                                                                   { printToken("TIME"); printError(); return symbol(TimeSym.TIME, new String("TIEMPOS")); }
    "inicio"                                                                    { printToken("STARTID"); printError(); return symbol(TimeSym.STARTID, new String("inicio")); }
    "fin"                                                                       { printToken("END"); printError(); return symbol(TimeSym.END, new String("fin")); }
    "imagenes"                                                                  { printToken("IMAGES"); printError(); return symbol(TimeSym.IMAGES, new String("imagenes")); }
    "id"                                                                        { printToken("ID"); printError(); return symbol(TimeSym.ID, new String("id")); }
    "duracion"                                                                  { printToken("DURATION"); printError(); return symbol(TimeSym.DURATION, new String("duracion")); }
    ({Letter} | "_") ({Letter} | {Number} | "_")*                               { printToken("CANVASID"); printError(); return symbol(TimeSym.CANVASID, yytext()); }
    {Number}+                                                                   { printToken("INTEGER"); printError(); return symbol(TimeSym.INTEGER, Integer.parseInt(yytext())); }
    ("\"") ( ({Letter} | "_") ({Letter} | {Number} | "_")* ) ("\"")             { printToken("LITERAL"); printError(); return symbol(TimeSym.LITERAL, yytext()); }
    {WhiteSpace}                        {printError();}//Ignore
     .                                  {createErrorLexeme(new String(yytext()), (yyline+1), yycolumn);}  
}
