/* The following code was generated by JFlex 1.4.3 on 09-30-20 12:09 AM */

package codigo;
import java_cup.runtime.Symbol;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 09-30-20 12:09 AM from the specification file
 * <tt>../proyectoCompi/src/codigo/LexerCup.flex</tt>
 */
class LexerCup implements java_cup.runtime.Scanner {

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
  private static final char [] ZZ_CMAP = {
     0,  0,  0,  0,  0,  0,  0,  0,  0,  5,  5,  0,  0,  5,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
    35, 12, 28, 19,  0, 27, 16, 17, 20, 21,  8,  6, 15,  6,  2,  7, 
     4, 29, 29, 29, 29, 29, 29, 29, 29, 29, 13, 14, 10, 11,  9, 27, 
    18, 54, 52,  3,  3,  3, 47, 60,  3, 46,  3,  3, 49, 50,  3, 55, 
    59,  3,  3, 48,  3,  3,  3,  3,  3,  3,  3, 22,  0, 23, 26,  1, 
     0, 42, 58, 56, 34, 32, 31, 43, 39, 30,  3,  3, 36, 57, 33, 40, 
    45,  3, 41, 37, 38, 53,  3, 44,  3,  3, 51, 24,  0, 25,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0
  };

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\11\2\12\1\1\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26"+
    "\1\27\1\30\1\1\1\5\25\4\3\0\1\12\1\31"+
    "\1\0\1\32\1\33\1\34\7\4\1\35\12\4\1\36"+
    "\6\4\1\37\1\0\1\40\12\4\1\41\12\4\1\42"+
    "\1\43\1\44\1\0\1\45\1\4\1\46\1\47\6\4"+
    "\1\50\1\4\1\51\1\52\1\53\1\54\2\4\7\0"+
    "\3\4\1\55\1\56\1\57\2\4\1\60\1\61\1\62"+
    "\6\0\1\4\1\63\1\64\1\65\1\66\1\4\1\67"+
    "\5\0\1\70\1\71\1\72\1\73\1\0\1\74\1\75"+
    "\1\76\1\0\1\77\1\0\1\100";

  private static int [] zzUnpackAction() {
    int [] result = new int[178];
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
    "\0\0\0\75\0\75\0\75\0\172\0\267\0\364\0\75"+
    "\0\u0131\0\75\0\u016e\0\u01ab\0\u016e\0\75\0\75\0\75"+
    "\0\75\0\75\0\75\0\75\0\75\0\75\0\75\0\75"+
    "\0\75\0\75\0\75\0\u01e8\0\u0225\0\u0262\0\u029f\0\u02dc"+
    "\0\u0319\0\u0356\0\u0393\0\u03d0\0\u040d\0\u044a\0\u0487\0\u04c4"+
    "\0\u0501\0\u053e\0\u057b\0\u05b8\0\u05f5\0\u0632\0\u066f\0\u06ac"+
    "\0\u06e9\0\u0726\0\u0763\0\267\0\u07a0\0\75\0\75\0\u01e8"+
    "\0\75\0\172\0\172\0\u07dd\0\u081a\0\u0857\0\u0894\0\u08d1"+
    "\0\u090e\0\u094b\0\172\0\u0988\0\u09c5\0\u0a02\0\u0a3f\0\u0a7c"+
    "\0\u0ab9\0\u0af6\0\u0b33\0\u0b70\0\u0bad\0\172\0\u0bea\0\u0c27"+
    "\0\u0c64\0\u0ca1\0\u0cde\0\u0d1b\0\u0763\0\u0d58\0\172\0\u0d95"+
    "\0\u0dd2\0\u0e0f\0\u0e4c\0\u0e89\0\u0ec6\0\u0f03\0\u0f40\0\u0f7d"+
    "\0\u0fba\0\172\0\u0ff7\0\u1034\0\u1071\0\u10ae\0\u10eb\0\u1128"+
    "\0\u1165\0\u11a2\0\u11df\0\u121c\0\172\0\172\0\u07a0\0\u1259"+
    "\0\u1296\0\u12d3\0\172\0\172\0\u1310\0\u134d\0\u138a\0\u13c7"+
    "\0\u1404\0\u1441\0\172\0\u147e\0\172\0\172\0\172\0\172"+
    "\0\u14bb\0\u14f8\0\u1535\0\u1572\0\u15af\0\u15ec\0\u1629\0\u1666"+
    "\0\u16a3\0\u16e0\0\u171d\0\u175a\0\172\0\172\0\172\0\u1797"+
    "\0\u17d4\0\172\0\u1811\0\75\0\u184e\0\u188b\0\u18c8\0\u1905"+
    "\0\u1942\0\u197f\0\u19bc\0\172\0\172\0\172\0\172\0\u19f9"+
    "\0\75\0\u1a36\0\u1a73\0\u1ab0\0\u1aed\0\u1b2a\0\75\0\172"+
    "\0\172\0\u1b67\0\u1ba4\0\75\0\75\0\75\0\u1be1\0\75"+
    "\0\u1c1e\0\75";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[178];
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
    "\1\12\2\13\1\14\1\15\1\16\1\17\1\20\1\21"+
    "\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31"+
    "\1\32\2\33\1\34\1\35\1\36\1\37\1\40\1\5"+
    "\1\41\1\7\2\5\1\42\1\5\1\43\1\44\2\5"+
    "\1\45\1\5\1\46\1\47\1\50\1\51\1\52\1\5"+
    "\1\53\1\5\1\54\1\55\1\56\1\57\1\60\1\61"+
    "\1\62\76\0\1\5\1\0\2\5\30\0\6\5\1\0"+
    "\31\5\2\0\1\63\1\0\1\64\30\0\1\64\44\0"+
    "\1\7\35\0\1\7\63\0\1\65\55\0\1\66\72\0"+
    "\1\67\64\0\33\70\1\71\40\70\2\0\1\63\1\0"+
    "\1\35\30\0\1\35\40\0\1\5\1\0\2\5\30\0"+
    "\2\5\1\72\1\5\1\73\1\5\1\0\31\5\1\0"+
    "\1\5\1\0\2\5\30\0\6\5\1\0\4\5\1\74"+
    "\1\5\1\75\22\5\1\0\1\5\1\0\2\5\30\0"+
    "\4\5\1\76\1\5\1\0\1\77\30\5\1\0\1\5"+
    "\1\0\2\5\30\0\3\5\1\100\2\5\1\0\31\5"+
    "\1\0\1\5\1\0\2\5\30\0\6\5\1\0\3\5"+
    "\1\101\1\5\1\102\23\5\1\0\1\5\1\0\2\5"+
    "\30\0\2\5\1\103\3\5\1\0\31\5\1\0\1\5"+
    "\1\0\2\5\30\0\3\5\1\104\2\5\1\0\6\5"+
    "\1\105\22\5\1\0\1\5\1\0\2\5\30\0\6\5"+
    "\1\0\3\5\1\106\25\5\1\0\1\5\1\0\2\5"+
    "\30\0\4\5\1\107\1\5\1\0\31\5\1\0\1\5"+
    "\1\0\2\5\30\0\6\5\1\0\1\110\30\5\1\0"+
    "\1\5\1\0\2\5\30\0\6\5\1\0\2\5\1\111"+
    "\26\5\1\0\1\5\1\0\2\5\30\0\1\5\1\112"+
    "\4\5\1\0\31\5\1\0\1\5\1\0\2\5\30\0"+
    "\6\5\1\0\6\5\1\113\22\5\1\0\1\5\1\0"+
    "\2\5\30\0\6\5\1\0\4\5\1\114\24\5\1\0"+
    "\1\5\1\0\2\5\30\0\4\5\1\115\1\5\1\0"+
    "\31\5\1\0\1\5\1\0\2\5\30\0\6\5\1\0"+
    "\5\5\1\116\23\5\1\0\1\5\1\0\2\5\30\0"+
    "\6\5\1\0\6\5\1\117\22\5\1\0\1\5\1\0"+
    "\2\5\30\0\6\5\1\0\6\5\1\120\22\5\1\0"+
    "\1\5\1\0\2\5\30\0\3\5\1\121\2\5\1\0"+
    "\31\5\1\0\1\5\1\0\2\5\30\0\6\5\1\0"+
    "\5\5\1\122\13\5\1\123\7\5\1\0\1\5\1\0"+
    "\2\5\30\0\3\5\1\124\2\5\1\0\31\5\4\0"+
    "\1\125\30\0\1\125\40\0\31\65\1\126\1\65\1\0"+
    "\40\65\1\0\1\5\1\0\2\5\30\0\6\5\1\0"+
    "\5\5\1\127\23\5\1\0\1\5\1\0\2\5\30\0"+
    "\6\5\1\0\1\130\30\5\1\0\1\5\1\0\2\5"+
    "\30\0\5\5\1\131\1\0\31\5\1\0\1\5\1\0"+
    "\2\5\30\0\6\5\1\0\1\5\1\132\27\5\1\0"+
    "\1\5\1\0\2\5\30\0\2\5\1\133\3\5\1\0"+
    "\31\5\1\0\1\5\1\0\2\5\30\0\3\5\1\134"+
    "\2\5\1\0\31\5\1\0\1\5\1\0\2\5\30\0"+
    "\6\5\1\0\21\5\1\135\7\5\1\0\1\5\1\0"+
    "\2\5\30\0\6\5\1\0\2\5\1\136\6\5\1\137"+
    "\17\5\1\0\1\5\1\0\2\5\30\0\4\5\1\140"+
    "\1\5\1\0\31\5\1\0\1\5\1\0\2\5\30\0"+
    "\1\5\1\141\4\5\1\0\31\5\1\0\1\5\1\0"+
    "\2\5\30\0\6\5\1\0\2\5\1\142\26\5\1\0"+
    "\1\5\1\0\2\5\30\0\6\5\1\0\4\5\1\143"+
    "\24\5\1\0\1\5\1\0\2\5\30\0\6\5\1\0"+
    "\5\5\1\144\23\5\1\0\1\5\1\0\2\5\30\0"+
    "\6\5\1\0\1\5\1\145\27\5\1\0\1\5\1\0"+
    "\2\5\30\0\6\5\1\0\2\5\1\146\26\5\1\0"+
    "\1\5\1\0\2\5\30\0\6\5\1\0\4\5\1\147"+
    "\24\5\1\0\1\5\1\0\2\5\30\0\5\5\1\116"+
    "\1\0\31\5\1\0\1\5\1\0\2\5\30\0\6\5"+
    "\1\0\1\150\1\151\27\5\1\0\1\5\1\0\2\5"+
    "\30\0\1\5\1\152\4\5\1\0\31\5\1\0\1\5"+
    "\1\0\2\5\30\0\6\5\1\0\7\5\1\153\21\5"+
    "\1\0\1\5\1\0\2\5\30\0\1\5\1\154\4\5"+
    "\1\0\31\5\1\0\1\5\1\0\2\5\30\0\6\5"+
    "\1\0\2\5\1\155\26\5\1\0\1\5\1\0\2\5"+
    "\30\0\6\5\1\0\2\5\1\156\26\5\1\0\6\65"+
    "\1\157\22\65\1\126\1\65\1\0\40\65\1\0\1\5"+
    "\1\0\2\5\30\0\6\5\1\0\1\5\1\135\27\5"+
    "\1\0\1\5\1\0\2\5\30\0\6\5\1\160\31\5"+
    "\1\0\1\5\1\0\2\5\30\0\3\5\1\161\2\5"+
    "\1\0\31\5\1\0\1\5\1\0\2\5\30\0\6\5"+
    "\1\0\6\5\1\162\22\5\1\0\1\5\1\0\2\5"+
    "\30\0\4\5\1\163\1\5\1\0\31\5\1\0\1\5"+
    "\1\0\2\5\30\0\3\5\1\164\2\5\1\0\31\5"+
    "\1\0\1\5\1\0\2\5\30\0\6\5\1\0\21\5"+
    "\1\165\7\5\1\0\1\5\1\0\2\5\30\0\3\5"+
    "\1\166\2\5\1\0\31\5\1\0\1\5\1\0\2\5"+
    "\30\0\6\5\1\0\7\5\1\167\21\5\1\0\1\5"+
    "\1\0\2\5\30\0\6\5\1\0\1\170\30\5\1\0"+
    "\1\5\1\0\2\5\30\0\6\5\1\0\6\5\1\171"+
    "\22\5\1\0\1\5\1\0\2\5\30\0\1\5\1\172"+
    "\4\5\1\0\31\5\1\0\1\5\1\0\2\5\30\0"+
    "\6\5\1\0\2\5\1\173\26\5\1\0\1\5\1\0"+
    "\2\5\30\0\6\5\1\0\5\5\1\174\23\5\1\0"+
    "\1\5\1\0\2\5\30\0\6\5\1\0\1\175\30\5"+
    "\1\0\1\5\1\0\2\5\30\0\6\5\1\0\1\176"+
    "\30\5\1\0\1\5\1\0\2\5\30\0\3\5\1\177"+
    "\2\5\1\0\31\5\1\0\1\5\1\0\2\5\30\0"+
    "\4\5\1\200\1\5\1\0\31\5\1\0\1\5\1\0"+
    "\2\5\30\0\1\5\1\201\4\5\1\0\31\5\1\0"+
    "\1\5\1\0\2\5\30\0\4\5\1\202\1\5\1\0"+
    "\31\5\36\0\1\203\1\204\1\205\13\0\1\206\13\0"+
    "\1\207\1\210\4\0\1\5\1\0\2\5\30\0\6\5"+
    "\1\211\31\5\1\0\1\5\1\0\2\5\30\0\6\5"+
    "\1\0\21\5\1\212\7\5\1\0\1\5\1\0\2\5"+
    "\30\0\6\5\1\0\5\5\1\213\23\5\1\0\1\5"+
    "\1\0\2\5\30\0\6\5\1\0\6\5\1\214\22\5"+
    "\1\0\1\5\1\0\2\5\30\0\3\5\1\215\2\5"+
    "\1\0\31\5\1\0\1\5\1\0\2\5\30\0\3\5"+
    "\1\216\2\5\1\0\31\5\1\0\1\5\1\0\2\5"+
    "\30\0\6\5\1\0\2\5\1\217\26\5\1\0\1\5"+
    "\1\0\2\5\30\0\4\5\1\220\1\5\1\0\31\5"+
    "\1\0\1\5\1\0\2\5\30\0\1\5\1\221\4\5"+
    "\1\0\31\5\1\0\1\5\1\0\2\5\30\0\4\5"+
    "\1\222\1\5\1\0\31\5\1\0\1\5\1\0\2\5"+
    "\30\0\6\5\1\0\2\5\1\223\26\5\37\0\1\224"+
    "\105\0\1\225\70\0\1\226\77\0\1\227\77\0\1\230"+
    "\74\0\1\231\60\0\1\232\37\0\1\5\1\0\2\5"+
    "\30\0\6\5\1\0\1\233\30\5\1\0\1\5\1\0"+
    "\2\5\30\0\4\5\1\234\1\5\1\0\31\5\1\0"+
    "\1\5\1\0\2\5\30\0\6\5\1\0\2\5\1\235"+
    "\26\5\1\0\1\5\1\0\2\5\30\0\6\5\1\0"+
    "\7\5\1\236\21\5\1\0\1\5\1\0\2\5\30\0"+
    "\6\5\1\0\17\5\1\237\11\5\1\0\1\5\1\0"+
    "\2\5\30\0\6\5\1\0\1\240\30\5\51\0\1\241"+
    "\70\0\1\242\65\0\1\243\102\0\1\244\1\245\65\0"+
    "\1\246\75\0\1\247\36\0\1\5\1\0\2\5\30\0"+
    "\6\5\1\0\2\5\1\250\26\5\1\0\1\5\1\0"+
    "\2\5\30\0\4\5\1\251\1\5\1\0\31\5\40\0"+
    "\1\252\100\0\1\253\74\0\1\254\70\0\1\255\75\0"+
    "\1\256\76\0\1\257\71\0\1\260\72\0\1\261\75\0"+
    "\1\262\35\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[7259];
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
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\3\11\3\1\1\11\1\1\1\11\3\1\16\11"+
    "\27\1\3\0\2\11\1\0\1\11\34\1\1\0\31\1"+
    "\1\0\22\1\7\0\12\1\1\11\6\0\6\1\1\11"+
    "\5\0\1\11\3\1\1\0\3\11\1\0\1\11\1\0"+
    "\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[178];
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

  /* user code: */
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  LexerCup(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  LexerCup(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
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
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
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
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
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

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          zzR = false;
          break;
        case '\r':
          yyline++;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
          }
          break;
        default:
          zzR = false;
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


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
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
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 31: 
          { return new Symbol(sym.DECIMAL,yychar,yyline,yytext());
          }
        case 65: break;
        case 54: 
          { return new Symbol(sym.TypeMatriz,yychar,yyline,yytext());
          }
        case 66: break;
        case 37: 
          { return new Symbol(sym.Else,yychar,yyline,yytext());
          }
        case 67: break;
        case 34: 
          { return new Symbol(sym.put,yychar,yyline,yytext());
          }
        case 68: break;
        case 26: 
          { return new Symbol(sym.CADENA,yychar,yyline,yytext());
          }
        case 69: break;
        case 41: 
          { return new Symbol(sym.TypeBool,yychar,yyline,yytext());
          }
        case 70: break;
        case 9: 
          { return new Symbol(sym.OP_MULT,yychar,yyline,yytext());
          }
        case 71: break;
        case 12: 
          { return new Symbol(sym.PuntoComa,yychar,yyline,yytext());
          }
        case 72: break;
        case 63: 
          { return new Symbol(sym.EndWhile,yychar,yyline,yytext());
          }
        case 73: break;
        case 60: 
          { return new Symbol(sym.EndCall,yychar,yyline,yytext());
          }
        case 74: break;
        case 8: 
          { return new Symbol(sym.OP_DIV,yychar,yyline,yytext());
          }
        case 75: break;
        case 23: 
          { return new Symbol(sym.CurlyDer,yychar,yyline,yytext());
          }
        case 76: break;
        case 21: 
          { return new Symbol(sym.SquareBDer,yychar,yyline,yytext());
          }
        case 77: break;
        case 27: 
          { return new Symbol(sym.IF,yychar,yyline,yytext());
          }
        case 78: break;
        case 55: 
          { return new Symbol(sym.EndFor,yychar,yyline,yytext());
          }
        case 79: break;
        case 43: 
          { return new Symbol(sym.Case,yychar,yyline,yytext());
          }
        case 80: break;
        case 5: 
          { return new Symbol(sym.ENTERO,yychar,yyline,yytext());
          }
        case 81: break;
        case 32: 
          { return new Symbol(sym.For,yychar,yyline,yytext());
          }
        case 82: break;
        case 14: 
          { return new Symbol(sym.Ampersand,yychar,yyline,yytext());
          }
        case 83: break;
        case 22: 
          { return new Symbol(sym.CurlyIzq,yychar,yyline,yytext());
          }
        case 84: break;
        case 48: 
          { return new Symbol(sym.Begin,yychar,yyline,yytext());
          }
        case 85: break;
        case 59: 
          { return new Symbol(sym.EndElse,yychar,yyline,yytext());
          }
        case 86: break;
        case 36: 
          { return new Symbol(sym.COMENTARIO,yychar,yyline,yytext());
          }
        case 87: break;
        case 49: 
          { return new Symbol(sym.Imp,yychar,yyline,yytext());
          }
        case 88: break;
        case 20: 
          { return new Symbol(sym.SquareBIzq,yychar,yyline,yytext());
          }
        case 89: break;
        case 47: 
          { return new Symbol(sym.TypeFloat,yychar,yyline,yytext());
          }
        case 90: break;
        case 29: 
          { return new Symbol(sym.Of,yychar,yyline,yytext());
          }
        case 91: break;
        case 44: 
          { return new Symbol(sym.Main,yychar,yyline,yytext());
          }
        case 92: break;
        case 53: 
          { return new Symbol(sym.TypeString,yychar,yyline,yytext());
          }
        case 93: break;
        case 3: 
          { return new Symbol(sym.Punto,yychar,yyline,yytext());
          }
        case 94: break;
        case 25: 
          { return new Symbol(sym.OP_ASIG,yychar,yyline,yytext());
          }
        case 95: break;
        case 46: 
          { return new Symbol(sym.While,yychar,yyline,yytext());
          }
        case 96: break;
        case 38: 
          { return new Symbol(sym.Then,yychar,yyline,yytext());
          }
        case 97: break;
        case 57: 
          { return new Symbol(sym.Default,yychar,yyline,yytext());
          }
        case 98: break;
        case 40: 
          { return new Symbol(sym.TypeList,yychar,yyline,yytext());
          }
        case 99: break;
        case 13: 
          { return new Symbol(sym.Coma,yychar,yyline,yytext());
          }
        case 100: break;
        case 64: 
          { return new Symbol(sym.EndElseIf,yychar,yyline,yytext());
          }
        case 101: break;
        case 17: 
          { return new Symbol(sym.Numeral,yychar,yyline,yytext());
          }
        case 102: break;
        case 61: 
          { return new Symbol(sym.EndCase,yychar,yyline,yytext());
          }
        case 103: break;
        case 4: 
          { return new Symbol(sym.IDENTIFICADOR,yychar,yyline,yytext());
          }
        case 104: break;
        case 19: 
          { return new Symbol(sym.ParDer,yychar,yyline,yytext());
          }
        case 105: break;
        case 58: 
          { return new Symbol(sym.ImpLn,yychar,yyline,yytext());
          }
        case 106: break;
        case 24: 
          { return new Symbol(sym.special_characters,yychar,yyline,yytext());
          }
        case 107: break;
        case 62: 
          { return new Symbol(sym.EndMain,yychar,yyline,yytext());
          }
        case 108: break;
        case 33: 
          { return new Symbol(sym.TypeInt,yychar,yyline,yytext());
          }
        case 109: break;
        case 7: 
          { return new Symbol(sym.OP_SUMA,yychar,yyline,yytext());
          }
        case 110: break;
        case 39: 
          { return new Symbol(sym.TBool,yychar,yyline,yytext());
          }
        case 111: break;
        case 18: 
          { return new Symbol(sym.ParIzq,yychar,yyline,yytext());
          }
        case 112: break;
        case 50: 
          { return new Symbol(sym.EndIf,yychar,yyline,yytext());
          }
        case 113: break;
        case 11: 
          { return new Symbol(sym.DosPuntos,yychar,yyline,yytext());
          }
        case 114: break;
        case 16: 
          { return new Symbol(sym.Arroba,yychar,yyline,yytext());
          }
        case 115: break;
        case 2: 
          { return new Symbol(sym.GuionBajo,yychar,yyline,yytext());
          }
        case 116: break;
        case 51: 
          { return new Symbol(sym.RETURN,yychar,yyline,yytext());
          }
        case 117: break;
        case 1: 
          { return new Symbol(sym.ERROR, yychar, yyline, yytext());
          }
        case 118: break;
        case 42: 
          { return new Symbol(sym.Call,yychar,yyline,yytext());
          }
        case 119: break;
        case 10: 
          { return new Symbol(sym.OP_RELA,yychar,yyline,yytext());
          }
        case 120: break;
        case 30: 
          { return new Symbol(sym.OP_LOGIC,yychar,yyline,yytext());
          }
        case 121: break;
        case 52: 
          { return new Symbol(sym.Repeat,yychar,yyline,yytext());
          }
        case 122: break;
        case 6: 
          { /*Ignore*/
          }
        case 123: break;
        case 45: 
          { return new Symbol(sym.Range,yychar,yyline,yytext());
          }
        case 124: break;
        case 35: 
          { return new Symbol(sym.get,yychar,yyline,yytext());
          }
        case 125: break;
        case 56: 
          { return new Symbol(sym.ElseIf,yychar,yyline,yytext());
          }
        case 126: break;
        case 15: 
          { return new Symbol(sym.Apostrofe,yychar,yyline,yytext());
          }
        case 127: break;
        case 28: 
          { return new Symbol(sym.IN,yychar,yyline,yytext());
          }
        case 128: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(sym.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
