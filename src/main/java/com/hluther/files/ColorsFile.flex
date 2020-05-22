package com.hluther.lexer;
import com.hluther.gui.GifCreatorFrame;
import com.hluther.parser.ColorsSym;
import java_cup.runtime.*;
%%//

/* 
----------------------------------- Opciones y declaraciones de JFlex -----------------------------------
*/
%class ColorsFileLexer
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

    public ColorsFileLexer(java.io.Reader in, GifCreatorFrame gifCreatorFrame) {
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
            gifCreatorFrame.printError("Error Lexico -> Lexema ["+errorLexeme+"] no reconocido. Linea: "+line+" Columna: "+column, 1);
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
    "{"                                                                         { printToken("CURLYBRACKETO"); printError(); return symbol(ColorsSym.CURLYBRACKETO, new String("{")); }
    "}"                                                                         { printToken("CURLYBRACKETC"); printError(); return symbol(ColorsSym.CURLYBRACKETC, new String("}")); }
    ":"                                                                         { printToken("COLON"); printError(); return symbol(ColorsSym.COLON, new String(":")); }
    ","                                                                         { printToken("COMMA"); printError(); return symbol(ColorsSym.COMMA, new String(",")); }
    "Red"                                                                       { printToken("RED"); printError(); return symbol(ColorsSym.RED, new String("Red")); }
    "Blue"                                                                      { printToken("BLUE"); printError(); return symbol(ColorsSym.BLUE, new String("Blue")); }
    "Green"                                                                     { printToken("GREEN"); printError(); return symbol(ColorsSym.GREEN, new String("Green")); }
    "HEX"                                                                       { printToken("HEX"); printError(); return symbol(ColorsSym.HEX, new String("HEX")); }
    "COLORES"                                                                   { printToken("COLORS"); printError(); return symbol(ColorsSym.COLORS, new String("COLORES")); }
    ({Letter} | "_") ({Letter} | {Number} | "_")*                               { printToken("ID"); printError(); return symbol(ColorsSym.ID, yytext()); }
    {Number}+                                                                   { printToken("INTEGER"); printError(); return symbol(ColorsSym.INTEGER, Integer.parseInt(yytext())); }
    ("#"){HexNumber}{HexNumber}{HexNumber}{HexNumber}{HexNumber}{HexNumber}     { printToken("HEXCODE"); printError(); return symbol(ColorsSym.HEXCODE, yytext()); }
    {WhiteSpace}                        {printError();}//Ignore
     .                                  {createErrorLexeme(new String(yytext()), (yyline+1), yycolumn);}  
}