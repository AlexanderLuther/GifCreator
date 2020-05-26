package com.hluther.lexer;
import com.hluther.gui.GifCreatorFrame;
import com.hluther.parser.PaintSym;
import java_cup.runtime.*;
%%//

/* 
----------------------------------- Opciones y declaraciones de JFlex -----------------------------------
*/
%class PaintFileLexer
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

    public PaintFileLexer(java.io.Reader in, GifCreatorFrame gifCreatorFrame) {
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

    private Symbol symbol(int type, boolean value) {
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
            gifCreatorFrame.printError("Error Lexico -> Lexema ["+errorLexeme+"] no reconocido. Linea: "+line+" Columna: "+column, 3);
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
    "="                                                                         { printToken("EQUALS"); printError(); return symbol(PaintSym.EQUALS, new String("=")); }
    ";"                                                                         { printToken("SEMICOLON"); printError(); return symbol(PaintSym.SEMICOLON, new String(";")); }
    ","                                                                         { printToken("COMMA"); printError(); return symbol(PaintSym.COMMA, new String(",")); }
    "+"                                                                         { printToken("PLUS"); printError(); return symbol(PaintSym.PLUS, new String("+")); }
    "-"                                                                         { printToken("MINUS"); printError(); return symbol(PaintSym.MINUS, new String("-")); }
    "*"                                                                         { printToken("MULTIPLICATION"); printError(); return symbol(PaintSym.MULTIPLICATION, new String("*")); }
    "/"                                                                         { printToken("DIVISION"); printError(); return symbol(PaintSym.DIVISION, new String("/")); }
    "["                                                                         { printToken("SQUAREBRACKETO"); printError(); return symbol(PaintSym.SQUAREBRACKETO, new String("[")); }
    "]"                                                                         { printToken("SQUAREBRACKETC"); printError(); return symbol(PaintSym.SQUAREBRACKETC, new String("]")); }
    "("                                                                         { printToken("PARENTHESISO"); printError(); return symbol(PaintSym.PARENTHESISO, new String("(")); }
    ")"                                                                         { printToken("PARENTHESISC"); printError(); return symbol(PaintSym.PARENTHESISC, new String("(")); }
    "."                                                                         { printToken("FULLSTOP"); printError(); return symbol(PaintSym.FULLSTOP, new String(".")); }
    "{"                                                                         { printToken("CURLYBRACKETO"); printError(); return symbol(PaintSym.CURLYBRACKETO, new String("{")); }
    "}"                                                                         { printToken("CURLYBRACKETC"); printError(); return symbol(PaintSym.CURLYBRACKETC, new String("}")); }
    "=="                                                                        { printToken("COMPARATION"); printError(); return symbol(PaintSym.COMPARATION, new String("==")); }
    "<="                                                                        { printToken("LESSEQUALSTHAN"); printError(); return symbol(PaintSym.LESSEQUALSTHAN, new String("<=")); }
    ">="                                                                        { printToken("MOREEQUALSTHAN"); printError(); return symbol(PaintSym.MOREEQUALSTHAN, new String(">=")); }
    "<"                                                                         { printToken("LESSTHAN"); printError(); return symbol(PaintSym.LESSTHAN, new String("<")); }
    ">"                                                                         { printToken("MORETHAN"); printError(); return symbol(PaintSym.MORETHAN, new String(">")); }
    "<>"                                                                        { printToken("BETWEEN"); printError(); return symbol(PaintSym.BETWEEN, new String("<>")); }
    "AND"                                                                       { printToken("AND"); printError(); return symbol(PaintSym.AND, new String("AND")); }
    "OR"                                                                        { printToken("OR"); printError(); return symbol(PaintSym.OR, new String("OR")); }
    "if"                                                                        { printToken("IF"); printError(); return symbol(PaintSym.IF, new String("if")); }
    "else"                                                                      { printToken("ELSE"); printError(); return symbol(PaintSym.ELSE, new String("else")); }
    "while"                                                                     { printToken("WHILE"); printError(); return symbol(PaintSym.WHILE, new String("while")); }
    "PINTAR"                                                                    { printToken("PAINT"); printError(); return symbol(PaintSym.PAINT, new String("PINTAR")); }
    "VARS"                                                                      { printToken("VARS"); printError(); return symbol(PaintSym.VARS, new String("VARS")); }
    "INSTRUCCIONES"                                                             { printToken("INSTRUCTIONS"); printError(); return symbol(PaintSym.INSTRUCTIONS, new String("INSTRUCCIONES")); }
    "int"                                                                       { printToken("INT"); printError(); return symbol(PaintSym.INT, new String("int")); }
    "String"                                                                    { printToken("STRING"); printError(); return symbol(PaintSym.STRING, new String("String")); }
    "boolean"                                                                   { printToken("BOOLEAN"); printError(); return symbol(PaintSym.BOOLEAN, new String("boolean")); }
    "true"                                                                      { printToken("TRUE"); printError(); return symbol(PaintSym.TRUE, true); }
    "false"                                                                     { printToken("FALSE"); printError(); return symbol(PaintSym.FALSE, false); }
    ({Letter} | "_") ({Letter} | {Number} | "_")*                               { printToken("ID"); printError(); return symbol(PaintSym.ID, yytext()); }
    {Number}+                                                                   { printToken("INTEGER"); printError(); return symbol(PaintSym.INTEGER, Integer.parseInt(yytext())); }
    ("\"") ( ({Letter} | "_") ({Letter} | {Number} | "_")* ) ("\"")             { printToken("IDLITERAL"); printError(); return symbol(PaintSym.IDLITERAL, yytext()); }
    ("\"") [^*]~ ("\"")                                                         { printToken("STRINGLITERAL"); printError(); return symbol(PaintSym.STRINGLITERAL, yytext()); }
    "//"[^\n]*                                                                  { printToken("LINECOMMENT"); printError(); }
    ("/*" [^*/]* "*/") | ("/*" [^/]~ "*/")                                      { printToken("MULTIPLELINECOMMENT"); printError(); }
    {WhiteSpace}                        {printError();}//Ignore
     .                                  {createErrorLexeme(new String(yytext()), (yyline+1), yycolumn);}  
}

