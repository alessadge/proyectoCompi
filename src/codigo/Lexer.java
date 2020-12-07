/* The following code was generated by JFlex 1.4.3 on 12-06-20 11:35 PM */

package codigo;
import java.util.LinkedList;
import static codigo.Tokens.*;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 12-06-20 11:35 PM from the specification file
 * <tt>../proyectoCompi/src/codigo/Lexer.flex</tt>
 */
class Lexer {

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
    "\11\0\1\16\1\36\2\0\1\16\22\0\1\44\1\12\1\35\1\22"+
    "\1\0\1\32\1\17\1\20\1\23\1\24\1\10\1\5\1\16\1\6"+
    "\1\3\1\7\1\2\11\34\1\14\1\15\1\12\1\13\1\11\1\33"+
    "\1\21\1\67\1\65\1\4\1\76\1\4\1\60\1\75\1\4\1\57"+
    "\2\4\1\62\1\63\1\4\1\70\1\74\2\4\1\61\7\4\1\25"+
    "\1\0\1\26\1\31\1\1\1\0\1\53\1\73\1\71\1\43\1\41"+
    "\1\40\1\54\1\50\1\37\2\4\1\45\1\72\1\42\1\51\1\56"+
    "\1\4\1\52\1\46\1\47\1\66\1\4\1\55\2\4\1\64\1\27"+
    "\1\0\1\30\uff82\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\2\6\1\7"+
    "\1\10\2\11\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\1\21\1\22\1\23\1\24\1\25\1\26\2\27"+
    "\1\3\1\30\1\31\26\5\1\32\1\0\1\33\1\34"+
    "\1\0\1\11\1\35\2\0\1\36\1\37\1\40\7\5"+
    "\1\41\12\5\1\42\6\5\1\43\1\44\2\0\1\45"+
    "\11\5\1\46\12\5\1\47\1\50\1\14\1\32\1\0"+
    "\1\51\1\5\1\52\1\53\5\5\1\54\1\5\1\55"+
    "\1\56\1\57\1\60\2\5\7\0\2\5\1\61\1\62"+
    "\1\63\2\5\1\64\1\65\1\66\6\0\1\5\1\67"+
    "\1\70\1\71\1\5\1\72\5\0\1\73\1\74\1\75"+
    "\1\76\1\0\1\77\1\100\1\101\1\0\1\102\1\0"+
    "\1\103";

  private static int [] zzUnpackAction() {
    int [] result = new int[182];
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
    "\0\0\0\77\0\176\0\275\0\77\0\176\0\374\0\u013b"+
    "\0\u017a\0\u01b9\0\u01f8\0\u0237\0\77\0\77\0\u0276\0\77"+
    "\0\77\0\77\0\77\0\u02b5\0\77\0\77\0\77\0\77"+
    "\0\77\0\77\0\u01b9\0\u02f4\0\u0333\0\77\0\u0372\0\u03b1"+
    "\0\u03f0\0\u042f\0\u046e\0\u04ad\0\u04ec\0\u052b\0\u056a\0\u05a9"+
    "\0\u05e8\0\u0627\0\u0666\0\u06a5\0\u06e4\0\u0723\0\u0762\0\u07a1"+
    "\0\u07e0\0\u081f\0\u085e\0\u089d\0\275\0\u08dc\0\77\0\77"+
    "\0\u091b\0\77\0\77\0\u095a\0\u0333\0\77\0\176\0\176"+
    "\0\u0999\0\u09d8\0\u0a17\0\u0a56\0\u0a95\0\u0ad4\0\u0b13\0\176"+
    "\0\u0b52\0\u0b91\0\u0bd0\0\u0c0f\0\u0c4e\0\u0c8d\0\u0ccc\0\u0d0b"+
    "\0\u0d4a\0\u0d89\0\176\0\u0dc8\0\u0e07\0\u0e46\0\u0e85\0\u0ec4"+
    "\0\u0f03\0\176\0\u08dc\0\u0f42\0\u0f81\0\176\0\u0fc0\0\u0fff"+
    "\0\u103e\0\u107d\0\u10bc\0\u10fb\0\u113a\0\u1179\0\u11b8\0\176"+
    "\0\u11f7\0\u1236\0\u1275\0\u12b4\0\u12f3\0\u1332\0\u1371\0\u13b0"+
    "\0\u13ef\0\u142e\0\176\0\176\0\u091b\0\77\0\u146d\0\u14ac"+
    "\0\u14eb\0\176\0\176\0\u152a\0\u1569\0\u15a8\0\u15e7\0\u1626"+
    "\0\176\0\u1665\0\176\0\176\0\176\0\176\0\u16a4\0\u16e3"+
    "\0\u1722\0\u1761\0\u17a0\0\u17df\0\u181e\0\u185d\0\u189c\0\u18db"+
    "\0\u191a\0\176\0\176\0\176\0\u1959\0\u1998\0\176\0\u19d7"+
    "\0\77\0\u1a16\0\u1a55\0\u1a94\0\u1ad3\0\u1b12\0\u1b51\0\u1b90"+
    "\0\176\0\176\0\176\0\u1bcf\0\77\0\u1c0e\0\u1c4d\0\u1c8c"+
    "\0\u1ccb\0\u1d0a\0\77\0\176\0\176\0\u1d49\0\u1d88\0\77"+
    "\0\77\0\77\0\u1dc7\0\77\0\u1e06\0\77";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[182];
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
    "\1\32\1\33\1\32\1\34\1\35\1\36\1\37\1\40"+
    "\1\41\1\6\1\42\1\17\2\6\1\43\1\6\1\44"+
    "\1\45\2\6\1\46\1\6\1\47\1\50\1\51\1\52"+
    "\1\53\1\6\1\54\1\6\1\55\1\56\1\57\1\60"+
    "\1\61\1\62\1\63\1\64\100\0\2\6\1\0\1\6"+
    "\27\0\1\6\2\0\5\6\1\0\32\6\2\0\1\65"+
    "\1\66\30\0\1\65\47\0\1\67\5\0\1\70\71\0"+
    "\1\67\4\0\1\70\76\0\1\70\15\0\1\71\60\0"+
    "\1\70\76\0\1\72\74\0\1\73\103\0\1\17\25\0"+
    "\1\17\40\0\1\74\72\0\1\34\1\66\30\0\1\34"+
    "\43\0\34\75\1\76\1\0\40\75\1\0\2\6\1\0"+
    "\1\6\27\0\1\6\2\0\1\6\1\77\1\6\1\100"+
    "\1\6\1\0\32\6\1\0\2\6\1\0\1\6\27\0"+
    "\1\6\2\0\5\6\1\0\4\6\1\101\1\6\1\102"+
    "\23\6\1\0\2\6\1\0\1\6\27\0\1\6\2\0"+
    "\3\6\1\103\1\6\1\0\1\104\31\6\1\0\2\6"+
    "\1\0\1\6\27\0\1\6\2\0\2\6\1\105\2\6"+
    "\1\0\32\6\1\0\2\6\1\0\1\6\27\0\1\6"+
    "\2\0\5\6\1\0\3\6\1\106\1\6\1\107\24\6"+
    "\1\0\2\6\1\0\1\6\27\0\1\6\2\0\1\6"+
    "\1\110\3\6\1\0\32\6\1\0\2\6\1\0\1\6"+
    "\27\0\1\6\2\0\2\6\1\111\2\6\1\0\6\6"+
    "\1\112\23\6\1\0\2\6\1\0\1\6\27\0\1\6"+
    "\2\0\5\6\1\0\3\6\1\113\26\6\1\0\2\6"+
    "\1\0\1\6\27\0\1\6\2\0\3\6\1\114\1\6"+
    "\1\0\32\6\1\0\2\6\1\0\1\6\27\0\1\6"+
    "\2\0\5\6\1\0\1\115\31\6\1\0\2\6\1\0"+
    "\1\6\27\0\1\6\2\0\5\6\1\0\2\6\1\116"+
    "\27\6\1\0\2\6\1\0\1\6\27\0\1\6\2\0"+
    "\1\117\4\6\1\0\32\6\1\0\2\6\1\0\1\6"+
    "\27\0\1\6\2\0\5\6\1\0\6\6\1\120\23\6"+
    "\1\0\2\6\1\0\1\6\27\0\1\6\2\0\5\6"+
    "\1\0\4\6\1\121\25\6\1\0\2\6\1\0\1\6"+
    "\27\0\1\6\2\0\3\6\1\122\1\6\1\0\32\6"+
    "\1\0\2\6\1\0\1\6\27\0\1\6\2\0\5\6"+
    "\1\0\5\6\1\123\24\6\1\0\2\6\1\0\1\6"+
    "\27\0\1\6\2\0\5\6\1\0\6\6\1\124\23\6"+
    "\1\0\2\6\1\0\1\6\27\0\1\6\2\0\5\6"+
    "\1\0\6\6\1\125\23\6\1\0\2\6\1\0\1\6"+
    "\27\0\1\6\2\0\2\6\1\126\2\6\1\0\32\6"+
    "\1\0\2\6\1\0\1\6\27\0\1\6\2\0\5\6"+
    "\1\0\5\6\1\127\13\6\1\130\10\6\1\0\2\6"+
    "\1\0\1\6\27\0\1\6\2\0\2\6\1\131\2\6"+
    "\1\0\32\6\1\0\2\6\1\0\1\6\27\0\1\6"+
    "\2\0\5\6\1\0\4\6\1\132\25\6\2\0\1\133"+
    "\31\0\1\133\43\0\30\71\1\134\3\71\2\0\40\71"+
    "\2\0\1\135\31\0\1\135\43\0\2\6\1\0\1\6"+
    "\27\0\1\6\2\0\5\6\1\0\5\6\1\136\24\6"+
    "\1\0\2\6\1\0\1\6\27\0\1\6\2\0\5\6"+
    "\1\0\1\137\31\6\1\0\2\6\1\0\1\6\27\0"+
    "\1\6\2\0\4\6\1\140\1\0\32\6\1\0\2\6"+
    "\1\0\1\6\27\0\1\6\2\0\5\6\1\0\1\6"+
    "\1\141\30\6\1\0\2\6\1\0\1\6\27\0\1\6"+
    "\2\0\1\6\1\142\3\6\1\0\32\6\1\0\2\6"+
    "\1\0\1\6\27\0\1\6\2\0\2\6\1\143\2\6"+
    "\1\0\32\6\1\0\2\6\1\0\1\6\27\0\1\6"+
    "\2\0\5\6\1\0\21\6\1\144\10\6\1\0\2\6"+
    "\1\0\1\6\27\0\1\6\2\0\5\6\1\0\11\6"+
    "\1\145\20\6\1\0\2\6\1\0\1\6\27\0\1\6"+
    "\2\0\3\6\1\146\1\6\1\0\32\6\1\0\2\6"+
    "\1\0\1\6\27\0\1\6\2\0\1\147\4\6\1\0"+
    "\32\6\1\0\2\6\1\0\1\6\27\0\1\6\2\0"+
    "\5\6\1\0\2\6\1\150\27\6\1\0\2\6\1\0"+
    "\1\6\27\0\1\6\2\0\5\6\1\0\4\6\1\151"+
    "\25\6\1\0\2\6\1\0\1\6\27\0\1\6\2\0"+
    "\5\6\1\0\5\6\1\152\24\6\1\0\2\6\1\0"+
    "\1\6\27\0\1\6\2\0\5\6\1\0\1\6\1\153"+
    "\30\6\1\0\2\6\1\0\1\6\27\0\1\6\2\0"+
    "\5\6\1\0\2\6\1\154\27\6\1\0\2\6\1\0"+
    "\1\6\27\0\1\6\2\0\5\6\1\0\4\6\1\155"+
    "\25\6\1\0\2\6\1\0\1\6\27\0\1\6\2\0"+
    "\4\6\1\123\1\0\32\6\1\0\2\6\1\0\1\6"+
    "\27\0\1\6\2\0\5\6\1\0\1\156\1\157\30\6"+
    "\1\0\2\6\1\0\1\6\27\0\1\6\2\0\1\160"+
    "\4\6\1\0\32\6\1\0\2\6\1\0\1\6\27\0"+
    "\1\6\2\0\5\6\1\0\7\6\1\161\22\6\1\0"+
    "\2\6\1\0\1\6\27\0\1\6\2\0\1\162\4\6"+
    "\1\0\32\6\1\0\2\6\1\0\1\6\27\0\1\6"+
    "\2\0\5\6\1\0\2\6\1\163\27\6\1\0\2\6"+
    "\1\0\1\6\27\0\1\6\2\0\5\6\1\0\2\6"+
    "\1\164\27\6\1\0\6\71\1\165\21\71\1\134\3\71"+
    "\2\0\40\71\2\0\1\135\21\0\1\166\7\0\1\135"+
    "\43\0\2\6\1\0\1\6\27\0\1\6\2\0\5\6"+
    "\1\0\1\6\1\144\30\6\1\0\2\6\1\0\1\6"+
    "\27\0\1\6\2\0\5\6\1\167\32\6\1\0\2\6"+
    "\1\0\1\6\27\0\1\6\2\0\2\6\1\170\2\6"+
    "\1\0\32\6\1\0\2\6\1\0\1\6\27\0\1\6"+
    "\2\0\5\6\1\0\6\6\1\171\23\6\1\0\2\6"+
    "\1\0\1\6\27\0\1\6\2\0\3\6\1\172\1\6"+
    "\1\0\32\6\1\0\2\6\1\0\1\6\27\0\1\6"+
    "\2\0\2\6\1\173\2\6\1\0\32\6\1\0\2\6"+
    "\1\0\1\6\27\0\1\6\2\0\2\6\1\174\2\6"+
    "\1\0\32\6\1\0\2\6\1\0\1\6\27\0\1\6"+
    "\2\0\5\6\1\0\7\6\1\175\22\6\1\0\2\6"+
    "\1\0\1\6\27\0\1\6\2\0\5\6\1\0\1\176"+
    "\31\6\1\0\2\6\1\0\1\6\27\0\1\6\2\0"+
    "\5\6\1\0\6\6\1\177\23\6\1\0\2\6\1\0"+
    "\1\6\27\0\1\6\2\0\1\200\4\6\1\0\32\6"+
    "\1\0\2\6\1\0\1\6\27\0\1\6\2\0\5\6"+
    "\1\0\2\6\1\201\27\6\1\0\2\6\1\0\1\6"+
    "\27\0\1\6\2\0\5\6\1\0\5\6\1\202\24\6"+
    "\1\0\2\6\1\0\1\6\27\0\1\6\2\0\5\6"+
    "\1\0\1\203\31\6\1\0\2\6\1\0\1\6\27\0"+
    "\1\6\2\0\5\6\1\0\1\204\31\6\1\0\2\6"+
    "\1\0\1\6\27\0\1\6\2\0\2\6\1\205\2\6"+
    "\1\0\32\6\1\0\2\6\1\0\1\6\27\0\1\6"+
    "\2\0\3\6\1\206\1\6\1\0\32\6\1\0\2\6"+
    "\1\0\1\6\27\0\1\6\2\0\1\207\4\6\1\0"+
    "\32\6\1\0\2\6\1\0\1\6\27\0\1\6\2\0"+
    "\3\6\1\210\1\6\1\0\32\6\37\0\1\211\1\212"+
    "\1\213\13\0\1\214\13\0\1\215\1\216\5\0\2\6"+
    "\1\0\1\6\27\0\1\6\2\0\5\6\1\217\32\6"+
    "\1\0\2\6\1\0\1\6\27\0\1\6\2\0\5\6"+
    "\1\0\21\6\1\220\10\6\1\0\2\6\1\0\1\6"+
    "\27\0\1\6\2\0\5\6\1\0\6\6\1\221\23\6"+
    "\1\0\2\6\1\0\1\6\27\0\1\6\2\0\2\6"+
    "\1\222\2\6\1\0\32\6\1\0\2\6\1\0\1\6"+
    "\27\0\1\6\2\0\2\6\1\223\2\6\1\0\32\6"+
    "\1\0\2\6\1\0\1\6\27\0\1\6\2\0\5\6"+
    "\1\0\2\6\1\224\27\6\1\0\2\6\1\0\1\6"+
    "\27\0\1\6\2\0\3\6\1\225\1\6\1\0\32\6"+
    "\1\0\2\6\1\0\1\6\27\0\1\6\2\0\1\226"+
    "\4\6\1\0\32\6\1\0\2\6\1\0\1\6\27\0"+
    "\1\6\2\0\3\6\1\227\1\6\1\0\32\6\1\0"+
    "\2\6\1\0\1\6\27\0\1\6\2\0\5\6\1\0"+
    "\2\6\1\230\27\6\40\0\1\231\107\0\1\232\72\0"+
    "\1\233\101\0\1\234\101\0\1\235\76\0\1\236\62\0"+
    "\1\237\40\0\2\6\1\0\1\6\27\0\1\6\2\0"+
    "\5\6\1\0\1\240\31\6\1\0\2\6\1\0\1\6"+
    "\27\0\1\6\2\0\5\6\1\0\2\6\1\241\27\6"+
    "\1\0\2\6\1\0\1\6\27\0\1\6\2\0\5\6"+
    "\1\0\7\6\1\242\22\6\1\0\2\6\1\0\1\6"+
    "\27\0\1\6\2\0\5\6\1\0\17\6\1\243\12\6"+
    "\1\0\2\6\1\0\1\6\27\0\1\6\2\0\5\6"+
    "\1\0\1\244\31\6\52\0\1\245\72\0\1\246\67\0"+
    "\1\247\104\0\1\250\1\251\67\0\1\252\77\0\1\253"+
    "\37\0\2\6\1\0\1\6\27\0\1\6\2\0\5\6"+
    "\1\0\2\6\1\254\27\6\1\0\2\6\1\0\1\6"+
    "\27\0\1\6\2\0\3\6\1\255\1\6\1\0\32\6"+
    "\41\0\1\256\102\0\1\257\76\0\1\260\72\0\1\261"+
    "\77\0\1\262\100\0\1\263\73\0\1\264\74\0\1\265"+
    "\77\0\1\266\36\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[7749];
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
    "\1\0\1\11\2\1\1\11\7\1\2\11\1\1\4\11"+
    "\1\1\6\11\3\1\1\11\27\1\1\0\2\11\1\0"+
    "\2\11\2\0\1\11\35\1\2\0\30\1\1\11\1\0"+
    "\21\1\7\0\11\1\1\11\6\0\5\1\1\11\5\0"+
    "\1\11\3\1\1\0\3\11\1\0\1\11\1\0\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[182];
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
    public String lexeme;
    /* Lista con errores lexicos */
    public static LinkedList<String> ErroresLexicos=new LinkedList<String>();


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
      yyline = 1; 
    yychar = 1; 
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Lexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 166) {
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
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Tokens yylex() throws java.io.IOException {
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
        case 5: 
          { lexeme=yytext(); return Identificador;
          }
        case 68: break;
        case 42: 
          { lexeme=yytext(); return Then;
          }
        case 69: break;
        case 51: 
          { lexeme=yytext(); return TypeFloat;
          }
        case 70: break;
        case 66: 
          { lexeme=yytext(); return EndWhile;
          }
        case 71: break;
        case 3: 
          { lexeme=yytext(); return ENTERO;
          }
        case 72: break;
        case 41: 
          { lexeme=yytext(); return Else;
          }
        case 73: break;
        case 2: 
          { lexeme=yytext(); return GuionBajo;
          }
        case 74: break;
        case 40: 
          { lexeme=yytext(); return Get;
          }
        case 75: break;
        case 10: 
          { lexeme=yytext(); return DosPuntos;
          }
        case 76: break;
        case 47: 
          { lexeme=yytext(); return Case;
          }
        case 77: break;
        case 23: 
          { lexeme=yytext(); return special_characters;
          }
        case 78: break;
        case 19: 
          { lexeme=yytext(); return SquareBIzq;
          }
        case 79: break;
        case 67: 
          { lexeme=yytext(); return EndElseIf;
          }
        case 80: break;
        case 25: 
          { return Linea;
          }
        case 81: break;
        case 37: 
          { lexeme=yytext(); return For;
          }
        case 82: break;
        case 65: 
          { lexeme=yytext(); return EndMain;
          }
        case 83: break;
        case 20: 
          { lexeme=yytext(); return SquareBDer;
          }
        case 84: break;
        case 33: 
          { lexeme=yytext(); return Of;
          }
        case 85: break;
        case 63: 
          { lexeme=yytext(); return EndCall;
          }
        case 86: break;
        case 8: 
          { lexeme=yytext(); return OP_MULT;
          }
        case 87: break;
        case 32: 
          { lexeme=yytext(); return In;
          }
        case 88: break;
        case 53: 
          { lexeme=yytext(); return Imp;
          }
        case 89: break;
        case 29: 
          { lexeme=yytext(); return OP_ASIG;
          }
        case 90: break;
        case 34: 
          { lexeme=yytext(); return OP_LOGIC;
          }
        case 91: break;
        case 21: 
          { lexeme=yytext(); return CurlyIzq;
          }
        case 92: break;
        case 28: 
          { lexeme = yytext(); return Op_atribucion;
          }
        case 93: break;
        case 27: 
          { lexeme = yytext(); return Op_incremento;
          }
        case 94: break;
        case 26: 
          { lexeme=yytext(); return Numero;
          }
        case 95: break;
        case 22: 
          { lexeme=yytext(); return CurlyDer;
          }
        case 96: break;
        case 57: 
          { lexeme=yytext(); return TypeMatriz;
          }
        case 97: break;
        case 7: 
          { lexeme=yytext(); return OP_DIV;
          }
        case 98: break;
        case 24: 
          { lexeme=yytext(); return Comillas;
          }
        case 99: break;
        case 52: 
          { lexeme=yytext(); return Begin;
          }
        case 100: break;
        case 9: 
          { lexeme=yytext(); return OP_RELA;
          }
        case 101: break;
        case 44: 
          { lexeme=yytext(); return TypeList;
          }
        case 102: break;
        case 35: 
          { lexeme=yytext(); return Do;
          }
        case 103: break;
        case 43: 
          { lexeme = yytext(); return OP_BOOL;
          }
        case 104: break;
        case 60: 
          { lexeme=yytext(); return Default;
          }
        case 105: break;
        case 4: 
          { lexeme=yytext(); return Punto;
          }
        case 106: break;
        case 16: 
          { lexeme=yytext(); return Numeral;
          }
        case 107: break;
        case 11: 
          { lexeme=yytext(); return PuntoComa;
          }
        case 108: break;
        case 48: 
          { lexeme=yytext(); return Main;
          }
        case 109: break;
        case 36: 
          { lexeme=yytext(); return DECIMAL;
          }
        case 110: break;
        case 17: 
          { lexeme=yytext(); return ParIzq;
          }
        case 111: break;
        case 55: 
          { lexeme=yytext(); return Repeat;
          }
        case 112: break;
        case 54: 
          { lexeme=yytext(); return EndIf;
          }
        case 113: break;
        case 46: 
          { lexeme=yytext(); return Call;
          }
        case 114: break;
        case 38: 
          { lexeme=yytext(); return TypeInt;
          }
        case 115: break;
        case 14: 
          { lexeme=yytext(); return Apostrofe;
          }
        case 116: break;
        case 18: 
          { lexeme=yytext(); return ParDer;
          }
        case 117: break;
        case 62: 
          { lexeme=yytext(); return EndElse;
          }
        case 118: break;
        case 6: 
          { lexeme=yytext(); return OP_SUMA;
          }
        case 119: break;
        case 64: 
          { lexeme=yytext(); return EndCase;
          }
        case 120: break;
        case 56: 
          { lexeme=yytext(); return TypeString;
          }
        case 121: break;
        case 13: 
          { lexeme=yytext(); return Ampersand;
          }
        case 122: break;
        case 59: 
          { lexeme=yytext(); return ElseIf;
          }
        case 123: break;
        case 30: 
          { lexeme=yytext(); return CADENA;
          }
        case 124: break;
        case 45: 
          { lexeme=yytext(); return TypeBool;
          }
        case 125: break;
        case 1: 
          { System.err.println("Este es un error lexico: "+yytext()+", en la linea: "+yyline+", en la columna: "+yychar);
    ErroresLexicos.add("Este es un error lexico: "+yytext()+", en la linea: "+yyline+", en la columna: "+yychar + " con el caracter:\n " +yytext() + "\n");
          }
        case 126: break;
        case 58: 
          { lexeme=yytext(); return EndFor;
          }
        case 127: break;
        case 49: 
          { lexeme=yytext(); return Range;
          }
        case 128: break;
        case 50: 
          { lexeme=yytext(); return While;
          }
        case 129: break;
        case 12: 
          { /*Ignore*/
          }
        case 130: break;
        case 31: 
          { lexeme=yytext(); return If;
          }
        case 131: break;
        case 61: 
          { lexeme=yytext(); return ImpLn;
          }
        case 132: break;
        case 15: 
          { lexeme=yytext(); return Arroba;
          }
        case 133: break;
        case 39: 
          { lexeme=yytext(); return Put;
          }
        case 134: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return null;
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
