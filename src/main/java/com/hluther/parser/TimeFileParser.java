
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package com.hluther.parser;

import java_cup.runtime.*;
import com.hluther.gui.GifCreatorFrame;
import com.hluther.lexer.TimeFileLexer;
import com.hluther.entityClasses.ImageDTO;
import com.hluther.entityClasses.Time;
import com.hluther.controlClasses.TimeFileDriver;
import java.util.LinkedList;
import java.util.Hashtable;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class TimeFileParser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return TimeSym.class;
}

  /** Default constructor. */
  @Deprecated
  public TimeFileParser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public TimeFileParser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public TimeFileParser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\023\000\002\002\004\000\002\002\011\000\002\003" +
    "\011\000\002\003\007\000\002\013\007\000\002\013\007" +
    "\000\002\013\007\000\002\013\007\000\002\013\007\000" +
    "\002\013\007\000\002\004\005\000\002\005\005\000\002" +
    "\012\007\000\002\011\007\000\002\011\005\000\002\010" +
    "\005\000\002\010\005\000\002\007\005\000\002\006\005" +
    "" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\105\000\004\004\004\001\002\000\004\013\007\001" +
    "\002\000\004\002\006\001\002\000\004\002\001\001\002" +
    "\000\004\010\010\001\002\000\004\004\011\001\002\000" +
    "\004\012\013\001\002\000\004\005\106\001\002\000\004" +
    "\010\014\001\002\000\004\004\015\001\002\000\010\014" +
    "\021\015\023\017\024\001\002\000\004\011\077\001\002" +
    "\000\004\011\070\001\002\000\004\011\061\001\002\000" +
    "\004\010\057\001\002\000\004\005\054\001\002\000\004" +
    "\010\052\001\002\000\004\010\025\001\002\000\004\006" +
    "\026\001\002\000\004\004\030\001\002\000\004\007\051" +
    "\001\002\000\006\020\031\021\032\001\002\000\004\010" +
    "\047\001\002\000\004\010\045\001\002\000\004\005\042" +
    "\001\002\000\004\011\040\001\002\000\004\011\036\001" +
    "\002\000\004\021\032\001\002\000\004\005\ufff1\001\002" +
    "\000\004\020\031\001\002\000\004\005\ufff2\001\002\000" +
    "\006\007\ufff3\011\043\001\002\000\004\004\030\001\002" +
    "\000\004\007\ufff4\001\002\000\004\022\046\001\002\000" +
    "\006\005\ufff0\011\ufff0\001\002\000\004\016\050\001\002" +
    "\000\006\005\uffef\011\uffef\001\002\000\006\005\ufff5\011" +
    "\ufff5\001\002\000\004\016\053\001\002\000\006\005\ufff6" +
    "\011\ufff6\001\002\000\006\005\ufffe\011\055\001\002\000" +
    "\004\012\013\001\002\000\004\005\uffff\001\002\000\004" +
    "\016\060\001\002\000\006\005\ufff7\011\ufff7\001\002\000" +
    "\006\014\021\017\024\001\002\000\004\011\066\001\002" +
    "\000\004\011\064\001\002\000\004\014\021\001\002\000" +
    "\004\005\ufffa\001\002\000\004\017\024\001\002\000\004" +
    "\005\ufffb\001\002\000\006\014\021\015\023\001\002\000" +
    "\004\011\075\001\002\000\004\011\073\001\002\000\004" +
    "\014\021\001\002\000\004\005\ufff8\001\002\000\004\015" +
    "\023\001\002\000\004\005\ufff9\001\002\000\006\015\023" +
    "\017\024\001\002\000\004\011\104\001\002\000\004\011" +
    "\102\001\002\000\004\017\024\001\002\000\004\005\ufffd" +
    "\001\002\000\004\015\023\001\002\000\004\005\ufffc\001" +
    "\002\000\004\005\107\001\002\000\004\002\000\001\002" +
    "" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\105\000\004\002\004\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\003\011\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\012\004\015\005\017" +
    "\012\016\013\021\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\011\026\001\001\000\002\001\001\000\010\006\034" +
    "\007\033\010\032\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\004\007\036\001\001\000\002\001\001\000\004\006" +
    "\040\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\011\043\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\003\055\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\006\004\061\012\062\001" +
    "\001\000\002\001\001\000\002\001\001\000\004\004\064" +
    "\001\001\000\002\001\001\000\004\012\066\001\001\000" +
    "\002\001\001\000\006\004\070\005\071\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\004\073\001\001\000" +
    "\002\001\001\000\004\005\075\001\001\000\002\001\001" +
    "\000\006\005\100\012\077\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\012\102\001\001\000\002\001\001" +
    "\000\004\005\104\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$TimeFileParser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$TimeFileParser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$TimeFileParser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




    private GifCreatorFrame gifCreatorFrame;
    private TimeFileDriver timeFileDriver;
    private LinkedList<ImageDTO> imagesArray;
    private Hashtable symbolTable;
    
    public TimeFileParser(TimeFileLexer lexer, GifCreatorFrame gifCreatorFrame, TimeFileDriver timeFileDriver, Hashtable symbolTable) { 
        super(lexer);
        this.gifCreatorFrame = gifCreatorFrame;
        this.timeFileDriver = timeFileDriver;
        this.symbolTable = symbolTable;
    }

    public void syntax_error(Symbol s){
        //konquestFrame.printGameSaveSintaxError(s);
    }

    public void unrecovered_syntax_error(Symbol s){
        //konquestFrame.printGameSaveSintaxError(s);
    } 

    public void semanticError(String lexeme, int line, int column, int errorType){
        String msg = "";    
        switch(errorType){
            case 0:
                msg = "Error Semantico -> No existe ningun lienzo con el identificador ["+lexeme+"]. Se descartan todos los tiempos. Linea: "+line+" Columna: "+column; 
            break;
            case 1:
                msg = "Error Semantico -> Ya existe una imagen con el identificador ["+lexeme+"]. Se descarto la imagen. Linea: "+line+" Columna: "+column; 
            break;
        }
        gifCreatorFrame.printError(msg, 2);
    }



/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$TimeFileParser$actions {
  private final TimeFileParser parser;

  /** Constructor */
  CUP$TimeFileParser$actions(TimeFileParser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$TimeFileParser$do_action_part00000000(
    int                        CUP$TimeFileParser$act_num,
    java_cup.runtime.lr_parser CUP$TimeFileParser$parser,
    java.util.Stack            CUP$TimeFileParser$stack,
    int                        CUP$TimeFileParser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$TimeFileParser$result;

      /* select the action based on the action number */
      switch (CUP$TimeFileParser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= times EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-1)).value;
		RESULT = start_val;
              CUP$TimeFileParser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-1)), ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$TimeFileParser$parser.done_parsing();
          return CUP$TimeFileParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // times ::= CURLYBRACKETO TIME COLON CURLYBRACKETO canvas CURLYBRACKETC CURLYBRACKETC 
            {
              Object RESULT =null;

              CUP$TimeFileParser$result = parser.getSymbolFactory().newSymbol("times",0, ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-6)), ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()), RESULT);
            }
          return CUP$TimeFileParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // canvas ::= CANVASID COLON CURLYBRACKETO timeAttributes CURLYBRACKETC COMMA canvas 
            {
              Object RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-6)).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-6)).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-6)).value;
		int timeleft = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-3)).left;
		int timeright = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-3)).right;
		Time time = (Time)((java_cup.runtime.Symbol) CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-3)).value;
		  if(symbolTable.get(name) != null){
                    time.setCanvasId(name);
                    timeFileDriver.addTime(name, time);
                }
                else{
                    semanticError(name, nameleft, nameright, 0);
                } 
            
              CUP$TimeFileParser$result = parser.getSymbolFactory().newSymbol("canvas",1, ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-6)), ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()), RESULT);
            }
          return CUP$TimeFileParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // canvas ::= CANVASID COLON CURLYBRACKETO timeAttributes CURLYBRACKETC 
            {
              Object RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-4)).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-4)).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-4)).value;
		int timeleft = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-1)).left;
		int timeright = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-1)).right;
		Time time = (Time)((java_cup.runtime.Symbol) CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-1)).value;
		  if(symbolTable.get(name) != null){
                    time.setCanvasId(name);
                    timeFileDriver.addTime(name, time);
                }
                else{
                    semanticError(name, nameleft, nameright, 0);
                }
            
              CUP$TimeFileParser$result = parser.getSymbolFactory().newSymbol("canvas",1, ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-4)), ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()), RESULT);
            }
          return CUP$TimeFileParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // timeAttributes ::= startId COMMA end COMMA images 
            {
              Time RESULT =null;
		int initialNameleft = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-4)).left;
		int initialNameright = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-4)).right;
		String initialName = (String)((java_cup.runtime.Symbol) CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-4)).value;
		int endNameleft = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-2)).left;
		int endNameright = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-2)).right;
		String endName = (String)((java_cup.runtime.Symbol) CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-2)).value;
		int allImagesleft = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()).left;
		int allImagesright = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()).right;
		LinkedList<ImageDTO> allImages = (LinkedList<ImageDTO>)((java_cup.runtime.Symbol) CUP$TimeFileParser$stack.peek()).value;
		 RESULT = new Time(initialName, endName, allImages); 
              CUP$TimeFileParser$result = parser.getSymbolFactory().newSymbol("timeAttributes",9, ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-4)), ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()), RESULT);
            }
          return CUP$TimeFileParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // timeAttributes ::= startId COMMA images COMMA end 
            {
              Time RESULT =null;
		int initialNameleft = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-4)).left;
		int initialNameright = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-4)).right;
		String initialName = (String)((java_cup.runtime.Symbol) CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-4)).value;
		int allImagesleft = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-2)).left;
		int allImagesright = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-2)).right;
		LinkedList<ImageDTO> allImages = (LinkedList<ImageDTO>)((java_cup.runtime.Symbol) CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-2)).value;
		int endNameleft = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()).left;
		int endNameright = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()).right;
		String endName = (String)((java_cup.runtime.Symbol) CUP$TimeFileParser$stack.peek()).value;
		 RESULT = new Time(initialName, endName, allImages); 
              CUP$TimeFileParser$result = parser.getSymbolFactory().newSymbol("timeAttributes",9, ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-4)), ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()), RESULT);
            }
          return CUP$TimeFileParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // timeAttributes ::= end COMMA startId COMMA images 
            {
              Time RESULT =null;
		int endNameleft = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-4)).left;
		int endNameright = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-4)).right;
		String endName = (String)((java_cup.runtime.Symbol) CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-4)).value;
		int initialNameleft = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-2)).left;
		int initialNameright = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-2)).right;
		String initialName = (String)((java_cup.runtime.Symbol) CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-2)).value;
		int allImagesleft = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()).left;
		int allImagesright = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()).right;
		LinkedList<ImageDTO> allImages = (LinkedList<ImageDTO>)((java_cup.runtime.Symbol) CUP$TimeFileParser$stack.peek()).value;
		 RESULT = new Time(initialName, endName, allImages); 
              CUP$TimeFileParser$result = parser.getSymbolFactory().newSymbol("timeAttributes",9, ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-4)), ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()), RESULT);
            }
          return CUP$TimeFileParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // timeAttributes ::= end COMMA images COMMA startId 
            {
              Time RESULT =null;
		int endNameleft = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-4)).left;
		int endNameright = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-4)).right;
		String endName = (String)((java_cup.runtime.Symbol) CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-4)).value;
		int allImagesleft = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-2)).left;
		int allImagesright = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-2)).right;
		LinkedList<ImageDTO> allImages = (LinkedList<ImageDTO>)((java_cup.runtime.Symbol) CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-2)).value;
		int initialNameleft = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()).left;
		int initialNameright = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()).right;
		String initialName = (String)((java_cup.runtime.Symbol) CUP$TimeFileParser$stack.peek()).value;
		 RESULT = new Time(initialName, endName, allImages); 
              CUP$TimeFileParser$result = parser.getSymbolFactory().newSymbol("timeAttributes",9, ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-4)), ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()), RESULT);
            }
          return CUP$TimeFileParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // timeAttributes ::= images COMMA startId COMMA end 
            {
              Time RESULT =null;
		int allImagesleft = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-4)).left;
		int allImagesright = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-4)).right;
		LinkedList<ImageDTO> allImages = (LinkedList<ImageDTO>)((java_cup.runtime.Symbol) CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-4)).value;
		int initialNameleft = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-2)).left;
		int initialNameright = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-2)).right;
		String initialName = (String)((java_cup.runtime.Symbol) CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-2)).value;
		int endNameleft = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()).left;
		int endNameright = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()).right;
		String endName = (String)((java_cup.runtime.Symbol) CUP$TimeFileParser$stack.peek()).value;
		 RESULT = new Time(initialName, endName, allImages); 
              CUP$TimeFileParser$result = parser.getSymbolFactory().newSymbol("timeAttributes",9, ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-4)), ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()), RESULT);
            }
          return CUP$TimeFileParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // timeAttributes ::= images COMMA end COMMA startId 
            {
              Time RESULT =null;
		int allImagesleft = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-4)).left;
		int allImagesright = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-4)).right;
		LinkedList<ImageDTO> allImages = (LinkedList<ImageDTO>)((java_cup.runtime.Symbol) CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-4)).value;
		int endNameleft = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-2)).left;
		int endNameright = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-2)).right;
		String endName = (String)((java_cup.runtime.Symbol) CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-2)).value;
		int initialNameleft = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()).left;
		int initialNameright = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()).right;
		String initialName = (String)((java_cup.runtime.Symbol) CUP$TimeFileParser$stack.peek()).value;
		 RESULT = new Time(initialName, endName, allImages); 
              CUP$TimeFileParser$result = parser.getSymbolFactory().newSymbol("timeAttributes",9, ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-4)), ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()), RESULT);
            }
          return CUP$TimeFileParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // startId ::= STARTID COLON LITERAL 
            {
              String RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$TimeFileParser$stack.peek()).value;
		 RESULT = name.replaceAll("\"", ""); 
              CUP$TimeFileParser$result = parser.getSymbolFactory().newSymbol("startId",2, ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-2)), ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()), RESULT);
            }
          return CUP$TimeFileParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // end ::= END COLON LITERAL 
            {
              String RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$TimeFileParser$stack.peek()).value;
		 RESULT = name.replaceAll("\"", ""); 
              CUP$TimeFileParser$result = parser.getSymbolFactory().newSymbol("end",3, ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-2)), ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()), RESULT);
            }
          return CUP$TimeFileParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // images ::= IMAGES COLON SQUAREBRACKETO imagesAttributes SQUAREBRACKETC 
            {
              LinkedList<ImageDTO> RESULT =null;
		int allImagesleft = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-1)).left;
		int allImagesright = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-1)).right;
		LinkedList<ImageDTO> allImages = (LinkedList<ImageDTO>)((java_cup.runtime.Symbol) CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-1)).value;
		 RESULT = allImages; 
              CUP$TimeFileParser$result = parser.getSymbolFactory().newSymbol("images",8, ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-4)), ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()), RESULT);
            }
          return CUP$TimeFileParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // imagesAttributes ::= CURLYBRACKETO attribute CURLYBRACKETC COMMA imagesAttributes 
            {
              LinkedList<ImageDTO> RESULT =null;
		int imageleft = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-3)).left;
		int imageright = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-3)).right;
		ImageDTO image = (ImageDTO)((java_cup.runtime.Symbol) CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-3)).value;
		int allImagesleft = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()).left;
		int allImagesright = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()).right;
		LinkedList<ImageDTO> allImages = (LinkedList<ImageDTO>)((java_cup.runtime.Symbol) CUP$TimeFileParser$stack.peek()).value;
		 boolean add = true;
                        for(ImageDTO currentImage : allImages){
                            if(currentImage.getId().equals(image.getId())){
                                add = false;
                            }
                        }
                        if(add){
                            allImages.addFirst(image);
                        }
                        else{
                            semanticError(image.getId(), imageleft, imageright, 1);
                        }
                        RESULT = allImages; 
                     
              CUP$TimeFileParser$result = parser.getSymbolFactory().newSymbol("imagesAttributes",7, ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-4)), ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()), RESULT);
            }
          return CUP$TimeFileParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // imagesAttributes ::= CURLYBRACKETO attribute CURLYBRACKETC 
            {
              LinkedList<ImageDTO> RESULT =null;
		int imageleft = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-1)).left;
		int imageright = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-1)).right;
		ImageDTO image = (ImageDTO)((java_cup.runtime.Symbol) CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-1)).value;
		 imagesArray = new LinkedList<>();
                        imagesArray.addFirst(image); 
                        RESULT = imagesArray;
                     
              CUP$TimeFileParser$result = parser.getSymbolFactory().newSymbol("imagesAttributes",7, ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-2)), ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()), RESULT);
            }
          return CUP$TimeFileParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // attribute ::= duration COMMA id 
            {
              ImageDTO RESULT =null;
		int amountleft = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-2)).left;
		int amountright = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-2)).right;
		Integer amount = (Integer)((java_cup.runtime.Symbol) CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-2)).value;
		int nameleft = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$TimeFileParser$stack.peek()).value;
		 RESULT = new ImageDTO(name, amount); 
              CUP$TimeFileParser$result = parser.getSymbolFactory().newSymbol("attribute",6, ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-2)), ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()), RESULT);
            }
          return CUP$TimeFileParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // attribute ::= id COMMA duration 
            {
              ImageDTO RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-2)).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-2)).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-2)).value;
		int amountleft = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()).left;
		int amountright = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()).right;
		Integer amount = (Integer)((java_cup.runtime.Symbol) CUP$TimeFileParser$stack.peek()).value;
		 RESULT = new ImageDTO(name, amount); 
              CUP$TimeFileParser$result = parser.getSymbolFactory().newSymbol("attribute",6, ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-2)), ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()), RESULT);
            }
          return CUP$TimeFileParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // duration ::= DURATION COLON INTEGER 
            {
              Integer RESULT =null;
		int amountleft = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()).left;
		int amountright = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()).right;
		Integer amount = (Integer)((java_cup.runtime.Symbol) CUP$TimeFileParser$stack.peek()).value;
		 RESULT = amount; 
              CUP$TimeFileParser$result = parser.getSymbolFactory().newSymbol("duration",5, ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-2)), ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()), RESULT);
            }
          return CUP$TimeFileParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // id ::= ID COLON LITERAL 
            {
              String RESULT =null;
		int nameleft = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()).left;
		int nameright = ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()).right;
		String name = (String)((java_cup.runtime.Symbol) CUP$TimeFileParser$stack.peek()).value;
		 RESULT = name.replaceAll("\"", ""); 
              CUP$TimeFileParser$result = parser.getSymbolFactory().newSymbol("id",4, ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.elementAt(CUP$TimeFileParser$top-2)), ((java_cup.runtime.Symbol)CUP$TimeFileParser$stack.peek()), RESULT);
            }
          return CUP$TimeFileParser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$TimeFileParser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$TimeFileParser$do_action(
    int                        CUP$TimeFileParser$act_num,
    java_cup.runtime.lr_parser CUP$TimeFileParser$parser,
    java.util.Stack            CUP$TimeFileParser$stack,
    int                        CUP$TimeFileParser$top)
    throws java.lang.Exception
    {
              return CUP$TimeFileParser$do_action_part00000000(
                               CUP$TimeFileParser$act_num,
                               CUP$TimeFileParser$parser,
                               CUP$TimeFileParser$stack,
                               CUP$TimeFileParser$top);
    }
}

}
