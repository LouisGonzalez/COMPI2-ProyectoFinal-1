/* The following code was generated by JFlex 1.6.1 */

package gramaticaC;
import java_cup.runtime.Symbol;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>LexerC.flex</tt>
 */
public class AnalizadorLexico4 implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\4\1\3\1\0\1\4\1\4\22\0\1\4\1\66\1\44"+
    "\1\53\1\0\1\52\1\67\1\45\1\13\1\14\1\50\1\46\1\5"+
    "\1\47\1\6\1\51\12\2\1\10\1\7\1\64\1\65\1\63\2\0"+
    "\1\37\1\33\4\1\1\42\2\1\1\36\2\1\1\43\1\1\1\41"+
    "\1\34\1\1\1\40\3\1\1\32\2\1\1\35\1\1\1\15\1\0"+
    "\1\16\1\0\1\1\1\0\1\22\1\17\1\26\1\31\1\21\1\57"+
    "\1\73\1\60\1\24\1\1\1\23\1\27\1\62\1\25\1\55\1\72"+
    "\1\1\1\20\1\61\1\56\1\30\1\54\1\71\3\1\1\11\1\70"+
    "\1\12\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uff92\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\10\2\1\20\1\21\1\22\1\23\1\24\1\25\1\26"+
    "\1\27\5\2\1\30\1\31\1\32\1\33\1\34\1\35"+
    "\6\2\1\36\5\2\1\37\1\40\1\41\2\2\1\42"+
    "\1\43\1\44\1\45\1\46\1\47\10\2\1\50\1\51"+
    "\6\2\1\52\13\2\1\53\7\2\1\54\1\2\1\55"+
    "\2\2\1\56\2\2\1\57\1\60\1\61\4\2\1\62"+
    "\3\2\1\63\2\2\1\64\2\2\1\65\1\66\1\67"+
    "\1\2\1\70\1\2\1\71\1\2\1\72\2\2\1\73"+
    "\1\74\1\75\1\76\1\2\1\77";

  private static int [] zzUnpackAction() {
    int [] result = new int[144];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\74\0\170\0\264\0\74\0\360\0\74\0\74"+
    "\0\74\0\74\0\74\0\74\0\74\0\74\0\74\0\74"+
    "\0\u012c\0\u0168\0\u01a4\0\u01e0\0\u021c\0\u0258\0\u0294\0\u02d0"+
    "\0\74\0\74\0\74\0\74\0\u030c\0\u0348\0\u0384\0\74"+
    "\0\u03c0\0\u03fc\0\u0438\0\u0474\0\u04b0\0\74\0\74\0\74"+
    "\0\74\0\u04ec\0\u0528\0\u0564\0\u05a0\0\u05dc\0\u0618\0\u0654"+
    "\0\u0690\0\170\0\u06cc\0\u0708\0\u0744\0\u0780\0\u07bc\0\170"+
    "\0\170\0\170\0\u07f8\0\u0834\0\74\0\74\0\74\0\74"+
    "\0\74\0\74\0\u0870\0\u08ac\0\u08e8\0\u0924\0\u0960\0\u099c"+
    "\0\u09d8\0\u0a14\0\74\0\74\0\u0a50\0\u0a8c\0\u0ac8\0\u0b04"+
    "\0\u0b40\0\u0b7c\0\170\0\u0bb8\0\u0bf4\0\u0c30\0\u0c6c\0\u0ca8"+
    "\0\u0ce4\0\u0d20\0\u0d5c\0\u0d98\0\u0dd4\0\u0e10\0\170\0\u0e4c"+
    "\0\u0e88\0\u0ec4\0\u0f00\0\u0f3c\0\u0f78\0\u0fb4\0\170\0\u0ff0"+
    "\0\170\0\u102c\0\u1068\0\170\0\u10a4\0\u10e0\0\170\0\170"+
    "\0\170\0\u111c\0\u1158\0\u1194\0\u11d0\0\170\0\u120c\0\u1248"+
    "\0\u1284\0\170\0\u12c0\0\u12fc\0\170\0\u1338\0\u1374\0\170"+
    "\0\170\0\170\0\u13b0\0\170\0\u13ec\0\170\0\u1428\0\170"+
    "\0\u1464\0\u14a0\0\170\0\170\0\170\0\170\0\u14dc\0\170";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[144];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11"+
    "\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21"+
    "\1\3\1\22\2\3\1\23\1\3\1\24\2\3\1\25"+
    "\1\26\1\3\1\27\1\3\1\30\5\3\1\31\1\32"+
    "\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\3"+
    "\1\42\1\43\1\3\1\44\1\45\1\46\1\47\1\50"+
    "\1\51\1\52\1\53\1\54\1\55\1\56\75\0\2\3"+
    "\14\0\25\3\10\0\7\3\6\0\3\3\2\0\1\4"+
    "\75\0\1\6\70\0\2\3\14\0\1\3\1\57\23\3"+
    "\10\0\7\3\6\0\3\3\1\0\2\3\14\0\10\3"+
    "\1\60\14\3\10\0\7\3\6\0\3\3\1\0\2\3"+
    "\14\0\6\3\1\61\16\3\10\0\3\3\1\62\3\3"+
    "\6\0\3\3\1\0\2\3\14\0\3\3\1\63\4\3"+
    "\1\64\14\3\10\0\1\3\1\65\2\3\1\66\2\3"+
    "\6\0\3\3\1\0\2\3\14\0\2\3\1\67\22\3"+
    "\10\0\1\3\1\70\5\3\6\0\3\3\1\0\2\3"+
    "\14\0\14\3\1\71\10\3\10\0\7\3\6\0\3\3"+
    "\1\0\2\3\14\0\16\3\1\72\2\3\1\73\3\3"+
    "\10\0\7\3\6\0\3\3\1\0\2\3\14\0\20\3"+
    "\1\74\4\3\10\0\7\3\6\0\3\3\51\0\1\75"+
    "\72\0\1\76\1\77\50\0\1\100\2\0\1\101\25\0"+
    "\1\102\15\0\2\3\14\0\25\3\10\0\1\3\1\103"+
    "\5\3\6\0\3\3\1\0\2\3\14\0\1\3\1\104"+
    "\23\3\10\0\7\3\6\0\3\3\1\0\2\3\14\0"+
    "\3\3\1\105\4\3\1\106\14\3\10\0\1\3\1\107"+
    "\5\3\6\0\3\3\1\0\2\3\14\0\7\3\1\110"+
    "\15\3\10\0\7\3\6\0\1\111\2\3\1\0\2\3"+
    "\14\0\3\3\1\112\21\3\10\0\7\3\6\0\3\3"+
    "\67\0\1\113\74\0\1\114\4\0\2\3\14\0\25\3"+
    "\10\0\4\3\1\115\2\3\6\0\3\3\1\0\2\3"+
    "\14\0\1\3\1\116\23\3\10\0\7\3\6\0\3\3"+
    "\1\0\2\3\14\0\2\3\1\117\22\3\10\0\7\3"+
    "\6\0\3\3\1\0\2\3\14\0\2\3\1\120\22\3"+
    "\10\0\7\3\6\0\3\3\1\0\2\3\14\0\25\3"+
    "\10\0\5\3\1\121\1\3\6\0\3\3\1\0\2\3"+
    "\14\0\7\3\1\122\15\3\10\0\2\3\1\123\4\3"+
    "\6\0\3\3\1\0\2\3\14\0\25\3\10\0\5\3"+
    "\1\124\1\3\6\0\3\3\1\0\2\3\14\0\1\3"+
    "\1\125\23\3\10\0\7\3\6\0\3\3\1\0\2\3"+
    "\14\0\6\3\1\126\16\3\10\0\7\3\6\0\3\3"+
    "\1\0\2\3\14\0\3\3\1\127\21\3\10\0\7\3"+
    "\6\0\3\3\1\0\2\3\14\0\25\3\10\0\3\3"+
    "\1\130\3\3\6\0\3\3\1\0\2\3\14\0\22\3"+
    "\1\131\2\3\10\0\7\3\6\0\3\3\1\0\2\3"+
    "\14\0\13\3\1\132\11\3\10\0\7\3\6\0\3\3"+
    "\1\0\2\3\14\0\5\3\1\133\17\3\10\0\7\3"+
    "\6\0\3\3\1\0\2\3\14\0\11\3\1\134\13\3"+
    "\10\0\7\3\6\0\3\3\1\0\2\3\14\0\10\3"+
    "\1\135\14\3\10\0\7\3\6\0\3\3\1\0\2\3"+
    "\14\0\25\3\10\0\1\3\1\136\5\3\6\0\3\3"+
    "\1\0\2\3\14\0\1\3\1\137\23\3\10\0\7\3"+
    "\6\0\3\3\1\0\2\3\14\0\3\3\1\140\21\3"+
    "\10\0\7\3\6\0\3\3\1\0\2\3\14\0\5\3"+
    "\1\141\17\3\10\0\7\3\6\0\3\3\1\0\2\3"+
    "\14\0\5\3\1\142\17\3\10\0\7\3\6\0\3\3"+
    "\1\0\2\3\14\0\5\3\1\143\17\3\10\0\7\3"+
    "\6\0\3\3\1\0\2\3\14\0\5\3\1\144\17\3"+
    "\10\0\7\3\6\0\3\3\1\0\2\3\14\0\25\3"+
    "\10\0\2\3\1\145\4\3\6\0\3\3\1\0\2\3"+
    "\14\0\3\3\1\146\21\3\10\0\7\3\6\0\3\3"+
    "\1\0\2\3\14\0\2\3\1\147\22\3\10\0\7\3"+
    "\6\0\3\3\1\0\2\3\14\0\10\3\1\150\14\3"+
    "\10\0\7\3\6\0\3\3\1\0\2\3\14\0\2\3"+
    "\1\151\22\3\10\0\7\3\6\0\3\3\1\0\2\3"+
    "\14\0\25\3\10\0\5\3\1\152\1\3\6\0\3\3"+
    "\1\0\2\3\14\0\25\3\10\0\5\3\1\153\1\3"+
    "\6\0\3\3\1\0\2\3\14\0\1\3\1\154\23\3"+
    "\10\0\7\3\6\0\3\3\1\0\2\3\14\0\3\3"+
    "\1\155\21\3\10\0\7\3\6\0\3\3\1\0\2\3"+
    "\14\0\23\3\1\156\1\3\10\0\7\3\6\0\3\3"+
    "\1\0\2\3\14\0\20\3\1\157\4\3\10\0\7\3"+
    "\6\0\3\3\1\0\2\3\14\0\12\3\1\160\12\3"+
    "\10\0\7\3\6\0\3\3\1\0\2\3\14\0\2\3"+
    "\1\161\22\3\10\0\7\3\6\0\3\3\1\0\2\3"+
    "\14\0\25\3\10\0\5\3\1\162\1\3\6\0\3\3"+
    "\1\0\2\3\14\0\3\3\1\163\21\3\10\0\7\3"+
    "\6\0\3\3\1\0\2\3\14\0\6\3\1\164\16\3"+
    "\10\0\7\3\6\0\3\3\1\0\2\3\14\0\25\3"+
    "\10\0\2\3\1\165\4\3\6\0\3\3\1\0\2\3"+
    "\14\0\6\3\1\166\16\3\10\0\7\3\6\0\3\3"+
    "\1\0\2\3\14\0\10\3\1\167\14\3\10\0\7\3"+
    "\6\0\3\3\1\0\2\3\14\0\6\3\1\170\16\3"+
    "\10\0\7\3\6\0\3\3\1\0\2\3\14\0\7\3"+
    "\1\171\15\3\10\0\7\3\6\0\3\3\1\0\2\3"+
    "\14\0\4\3\1\172\20\3\10\0\7\3\6\0\3\3"+
    "\1\0\2\3\14\0\11\3\1\173\13\3\10\0\7\3"+
    "\6\0\3\3\1\0\2\3\14\0\7\3\1\174\15\3"+
    "\10\0\7\3\6\0\3\3\1\0\2\3\14\0\25\3"+
    "\10\0\2\3\1\175\4\3\6\0\3\3\1\0\2\3"+
    "\14\0\11\3\1\176\13\3\10\0\7\3\6\0\3\3"+
    "\1\0\2\3\14\0\21\3\1\177\3\3\10\0\7\3"+
    "\6\0\3\3\1\0\2\3\14\0\2\3\1\200\22\3"+
    "\10\0\7\3\6\0\3\3\1\0\2\3\14\0\25\3"+
    "\10\0\2\3\1\201\4\3\6\0\3\3\1\0\2\3"+
    "\14\0\25\3\10\0\3\3\1\202\3\3\6\0\3\3"+
    "\1\0\2\3\14\0\7\3\1\203\15\3\10\0\7\3"+
    "\6\0\3\3\1\0\2\3\14\0\2\3\1\204\22\3"+
    "\10\0\7\3\6\0\3\3\1\0\2\3\14\0\25\3"+
    "\10\0\2\3\1\205\4\3\6\0\3\3\1\0\2\3"+
    "\14\0\25\3\10\0\4\3\1\206\2\3\6\0\3\3"+
    "\1\0\2\3\14\0\12\3\1\207\12\3\10\0\7\3"+
    "\6\0\3\3\1\0\2\3\14\0\1\3\1\210\23\3"+
    "\10\0\7\3\6\0\3\3\1\0\2\3\14\0\10\3"+
    "\1\211\14\3\10\0\7\3\6\0\3\3\1\0\2\3"+
    "\14\0\20\3\1\212\4\3\10\0\7\3\6\0\3\3"+
    "\1\0\2\3\14\0\25\3\10\0\4\3\1\213\2\3"+
    "\6\0\3\3\1\0\2\3\14\0\25\3\10\0\3\3"+
    "\1\214\3\3\6\0\3\3\1\0\2\3\14\0\2\3"+
    "\1\215\22\3\10\0\7\3\6\0\3\3\1\0\2\3"+
    "\14\0\25\3\10\0\2\3\1\216\4\3\6\0\3\3"+
    "\1\0\2\3\14\0\24\3\1\217\10\0\7\3\6\0"+
    "\3\3\1\0\2\3\14\0\20\3\1\220\4\3\10\0"+
    "\7\3\6\0\3\3";

  private static int [] zzUnpackTrans() {
    int [] result = new int[5400];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\2\1\1\11\1\1\12\11\10\1\4\11"+
    "\3\1\1\11\5\1\4\11\23\1\6\11\10\1\2\11"+
    "\104\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[144];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
    private Symbol symbol(int tipo){
        return new Symbol(tipo, yyline+1, yycolumn+1);
    }

    private Symbol symbol(int tipo, Object value){
        return new Symbol(tipo, yyline+1, yycolumn+1, value);
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public AnalizadorLexico4(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 196) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          { return new java_cup.runtime.Symbol(sym.EOF); }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return symbol(sym.resto, new String(yytext()));
            }
          case 64: break;
          case 2: 
            { return symbol(sym.id, new String(yytext()));
            }
          case 65: break;
          case 3: 
            { return symbol(sym.numero, new Integer(yytext()));
            }
          case 66: break;
          case 4: 
            { return symbol(sym.enter);
            }
          case 67: break;
          case 5: 
            { 
            }
          case 68: break;
          case 6: 
            { return symbol(sym.coma, new String(yytext()));
            }
          case 69: break;
          case 7: 
            { return symbol(sym.punto, new String(yytext()));
            }
          case 70: break;
          case 8: 
            { return symbol(sym.puntoComa, new String(yytext()));
            }
          case 71: break;
          case 9: 
            { return symbol(sym.dosPuntos, new String(yytext()));
            }
          case 72: break;
          case 10: 
            { return symbol(sym.llave_a, new String(yytext()));
            }
          case 73: break;
          case 11: 
            { return symbol(sym.llave_b, new String(yytext()));
            }
          case 74: break;
          case 12: 
            { return symbol(sym.parentesis_a, new String(yytext()));
            }
          case 75: break;
          case 13: 
            { return symbol(sym.parentesis_b, new String(yytext()));
            }
          case 76: break;
          case 14: 
            { return symbol(sym.agrupacion_a, new String(yytext()));
            }
          case 77: break;
          case 15: 
            { return symbol(sym.agrupacion_b, new String(yytext()));
            }
          case 78: break;
          case 16: 
            { return symbol(sym.comilla, new String(yytext()));
            }
          case 79: break;
          case 17: 
            { return symbol(sym.comillaSimple, new String(yytext()));
            }
          case 80: break;
          case 18: 
            { return symbol(sym.mas, new String(yytext()));
            }
          case 81: break;
          case 19: 
            { return symbol(sym.menos, new String(yytext()));
            }
          case 82: break;
          case 20: 
            { return symbol(sym.por, new String(yytext()));
            }
          case 83: break;
          case 21: 
            { return symbol(sym.div, new String(yytext()));
            }
          case 84: break;
          case 22: 
            { return symbol(sym.modulo, new String(yytext()));
            }
          case 85: break;
          case 23: 
            { return symbol(sym.numeral, new String(yytext()));
            }
          case 86: break;
          case 24: 
            { return symbol(sym.mayor, new String(yytext()));
            }
          case 87: break;
          case 25: 
            { return symbol(sym.menor, new String(yytext()));
            }
          case 88: break;
          case 26: 
            { return symbol(sym.igual, new String(yytext()));
            }
          case 89: break;
          case 27: 
            { return symbol(sym.admiracion, new String(yytext()));
            }
          case 90: break;
          case 28: 
            { return symbol(sym.ampersand, new String(yytext()));
            }
          case 91: break;
          case 29: 
            { return symbol(sym.pleca, new String(yytext()));
            }
          case 92: break;
          case 30: 
            { return symbol(sym.condIf, new String(yytext()));
            }
          case 93: break;
          case 31: 
            { return symbol(sym.condDo, new String(yytext()));
            }
          case 94: break;
          case 32: 
            { return symbol(sym.visual, new String(yytext()));
            }
          case 95: break;
          case 33: 
            { return symbol(sym.python, new String(yytext()));
            }
          case 96: break;
          case 34: 
            { return symbol(sym.comentario_c);
            }
          case 97: break;
          case 35: 
            { return symbol(sym.comentario_b);
            }
          case 98: break;
          case 36: 
            { return symbol(sym.comentario_a);
            }
          case 99: break;
          case 37: 
            { return symbol(sym.scanfChar, new String(yytext()));
            }
          case 100: break;
          case 38: 
            { return symbol(sym.scanfInt, new String(yytext()));
            }
          case 101: break;
          case 39: 
            { return symbol(sym.scanfFloat, new String(yytext()));
            }
          case 102: break;
          case 40: 
            { return symbol(sym.and, new String(yytext()));
            }
          case 103: break;
          case 41: 
            { return symbol(sym.or, new String(yytext()));
            }
          case 104: break;
          case 42: 
            { return symbol(sym.tipoInteger, new String(yytext()));
            }
          case 105: break;
          case 43: 
            { return symbol(sym.condFor, new String(yytext()));
            }
          case 106: break;
          case 44: 
            { return symbol(sym.condElse, new String(yytext()));
            }
          case 107: break;
          case 45: 
            { return symbol(sym.condCase, new String(yytext()));
            }
          case 108: break;
          case 46: 
            { return symbol(sym.tipoChar, new String(yytext()));
            }
          case 109: break;
          case 47: 
            { return symbol(sym.java, new String(yytext()));
            }
          case 110: break;
          case 48: 
            { return symbol(sym.tipoVoid, new String(yytext()));
            }
          case 111: break;
          case 49: 
            { return symbol(sym.verdadero, new String(yytext()));
            }
          case 112: break;
          case 50: 
            { return symbol(sym.main, new String(yytext()));
            }
          case 113: break;
          case 51: 
            { return symbol(sym.condBreak, new String(yytext()));
            }
          case 114: break;
          case 52: 
            { return symbol(sym.tipoConst, new String(yytext()));
            }
          case 115: break;
          case 53: 
            { return symbol(sym.falso, new String(yytext()));
            }
          case 116: break;
          case 54: 
            { return symbol(sym.tipoFloat, new String(yytext()));
            }
          case 117: break;
          case 55: 
            { return symbol(sym.scanf, new String(yytext()));
            }
          case 118: break;
          case 56: 
            { return symbol(sym.condWhile, new String(yytext()));
            }
          case 119: break;
          case 57: 
            { return symbol(sym.getch, new String(yytext()));
            }
          case 120: break;
          case 58: 
            { return symbol(sym.clscr, new String(yytext()));
            }
          case 121: break;
          case 59: 
            { return symbol(sym.condSwitch, new String(yytext()));
            }
          case 122: break;
          case 60: 
            { return symbol(sym.printf, new String(yytext()));
            }
          case 123: break;
          case 61: 
            { return symbol(sym.condInclude, new String(yytext()));
            }
          case 124: break;
          case 62: 
            { return symbol(sym.condDef, new String(yytext()));
            }
          case 125: break;
          case 63: 
            { return symbol(sym.principal, new String(yytext()));
            }
          case 126: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }

  /**
   * Converts an int token code into the name of the
   * token by reflection on the cup symbol class/interface sym
   *
   * This code was contributed by Karl Meissner <meissnersd@yahoo.com>
   */
  private String getTokenName(int token) {
    try {
      java.lang.reflect.Field [] classFields = sym.class.getFields();
      for (int i = 0; i < classFields.length; i++) {
        if (classFields[i].getInt(null) == token) {
          return classFields[i].getName();
        }
      }
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }

    return "UNKNOWN TOKEN";
  }

  /**
   * Same as next_token but also prints the token to standard out
   * for debugging.
   *
   * This code was contributed by Karl Meissner <meissnersd@yahoo.com>
   */
  public java_cup.runtime.Symbol debug_next_token() throws java.io.IOException {
    java_cup.runtime.Symbol s = next_token();
    System.out.println( "line:" + (yyline+1) + " col:" + (yycolumn+1) + " --"+ yytext() + "--" + getTokenName(s.sym) + "--");
    return s;
  }

  /**
   * Runs the scanner on input files.
   *
   * This main method is the debugging routine for the scanner.
   * It prints debugging information about each returned token to
   * System.out until the end of file is reached, or an error occured.
   *
   * @param argv   the command line, contains the filenames to run
   *               the scanner on.
   */
  public static void main(String argv[]) {
    if (argv.length == 0) {
      System.out.println("Usage : java AnalizadorLexico4 [ --encoding <name> ] <inputfile(s)>");
    }
    else {
      int firstFilePos = 0;
      String encodingName = "UTF-8";
      if (argv[0].equals("--encoding")) {
        firstFilePos = 2;
        encodingName = argv[1];
        try {
          java.nio.charset.Charset.forName(encodingName); // Side-effect: is encodingName valid? 
        } catch (Exception e) {
          System.out.println("Invalid encoding '" + encodingName + "'");
          return;
        }
      }
      for (int i = firstFilePos; i < argv.length; i++) {
        AnalizadorLexico4 scanner = null;
        try {
          java.io.FileInputStream stream = new java.io.FileInputStream(argv[i]);
          java.io.Reader reader = new java.io.InputStreamReader(stream, encodingName);
          scanner = new AnalizadorLexico4(reader);
          while ( !scanner.zzAtEOF ) scanner.debug_next_token();
        }
        catch (java.io.FileNotFoundException e) {
          System.out.println("File not found : \""+argv[i]+"\"");
        }
        catch (java.io.IOException e) {
          System.out.println("IO error scanning file \""+argv[i]+"\"");
          System.out.println(e);
        }
        catch (Exception e) {
          System.out.println("Unexpected exception:");
          e.printStackTrace();
        }
      }
    }
  }


}
