package codigo;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
    GBajo="_"
    Point="."
    LETTER=[a-zA-Z]
    NUMBER=[0-9]
    Espacio=[ \n\r\t]+
    Caracteres="+"|"-"|"/"|"*"|">"|"<"|">="|"<="|"!="|"!"|"="|":"|";"|"."|","|"-"|"_"|"&"|"'"|"@"|"#"|"("|")"|"["|"]"|"{"|"}"|"^"|"%"|"?"
    ID={LETTER}({NUMBER}|{GBajo}|{LETTER})*
    STRING=\"({LETTER}|{NUMBER}|{Espacio}|{Caracteres})*\"
    Comentario=("/^")({LETTER}|{NUMBER}|{Espacio}|{Caracteres})*("^/")
    NUMERO=[1-9]{NUMBER}*|0 
    NUMEROD={NUMBER}+{Point}{NUMBER}+
    INTEGER=[1-9]{NUMBER}*|0 
    DECIMAL={NUMBER}+{Point}{NUMBER}+

%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%

{Espacio} {/*Ignore*/}
({Comentario}) {
        return new Symbol(sym.COMENTARIO,yychar,yyline,yytext());
    }

("if") {
        return new Symbol(sym.IF,yychar,yyline,yytext());
    }
("end if") {
        return new Symbol(sym.EndIf,yychar,yyline,yytext());
    }
("else") {
        return new Symbol(sym.Else,yychar,yyline,yytext());
    }
("end else") {
        return new Symbol(sym.EndElse,yychar,yyline,yytext());
    }
("else if") {
        return new Symbol(sym.ElseIf,yychar,yyline,yytext());
    }
("end else if") {
        return new Symbol(sym.EndElseIf,yychar,yyline,yytext());
    }
("then") {
        return new Symbol(sym.Then,yychar,yyline,yytext());
    }
	
    //Parte for
("for") {
        return new Symbol(sym.For,yychar,yyline,yytext());
    }
("in") {
        return new Symbol(sym.IN,yychar,yyline,yytext());
    }
("range") {
        return new Symbol(sym.Range,yychar,yyline,yytext());
    }
("end for") {
        return new Symbol(sym.EndFor,yychar,yyline,yytext());
    }
	
    //Parte while
("while") {
        return new Symbol(sym.While,yychar,yyline,yytext());
    }
("repeat") {
        return new Symbol(sym.Repeat,yychar,yyline,yytext());
    }
("end while") {
        return new Symbol(sym.EndWhile,yychar,yyline,yytext());
    }

	
    //Tipos de variables
("Int") {
        return new Symbol(sym.TypeInt,yychar,yyline,yytext());
    }
("Float") {
        return new Symbol(sym.TypeFloat,yychar,yyline,yytext());
    }
("String") {
        return new Symbol(sym.TypeString,yychar,yyline,yytext());
    }
("List") {
        return new Symbol(sym.TypeList,yychar,yyline,yytext());
    }
("Matriz") {
        return new Symbol(sym.TypeMatriz,yychar,yyline,yytext());
    }
("Bool") {
        return new Symbol(sym.TypeBool,yychar,yyline,yytext());
    }
("true"|"false") {
        return new Symbol(sym.TBool,yychar,yyline,yytext());
    }
    
    //operadores
("+"|"-") {      
         return new Symbol(sym.OP_SUMA,yychar,yyline,yytext());
    }
("*") {
        return new Symbol(sym.OP_MULT,yychar,yyline,yytext());
    }
("/") {
        return new Symbol(sym.OP_DIV,yychar,yyline,yytext());
    } 
("And"|"Or") {
        return new Symbol(sym.OP_LOGIC,yychar,yyline,yytext());
    }
(">"|"<"|">="|"<=") {
        return new Symbol(sym.OP_RELA,yychar,yyline,yytext());
    }
("!="|"=") {
        return new Symbol(sym.OP_RELA2,yychar,yyline,yytext());
    } 
("=>") {
        return new Symbol(sym.OP_ASIG,yychar,yyline,yytext());
    }
    //Parte del switch 
("case") {     
        return new Symbol(sym.Case,yychar,yyline,yytext());
    }
("of") {
        return new Symbol(sym.Of,yychar,yyline,yytext());
    }
("default") {
        return new Symbol(sym.Default,yychar,yyline,yytext());
    }
("end case") {
        return new Symbol(sym.EndCase,yychar,yyline,yytext());
    }    
    //Parte del Main
("main") {      
        return new Symbol(sym.Main,yychar,yyline,yytext());
    }
("begin") {
        return new Symbol(sym.Begin,yychar,yyline,yytext());
    }
("Println") {
        return new Symbol(sym.ImpLn,yychar,yyline,yytext());
    }
("Print") {
        return new Symbol(sym.Imp,yychar,yyline,yytext());
    }
("call") {
        return new Symbol(sym.Call,yychar,yyline,yytext());
    }
("return") {
        return new Symbol(sym.RETURN,yychar,yyline,yytext());
    }
("end call") {
        return new Symbol(sym.EndCall,yychar,yyline,yytext());
    }
("end main") {
        return new Symbol(sym.EndMain,yychar,yyline,yytext());
    }
    //Lectura y escritura
("Put") { 
       return new Symbol(sym.put,yychar,yyline,yytext());
    }
("Get") {
        return new Symbol(sym.get,yychar,yyline,yytext());
    }
    
    //Caracteres
(":") {      
          return new Symbol(sym.DosPuntos,yychar,yyline,yytext());
    }
(";") {
        return new Symbol(sym.PuntoComa,yychar,yyline,yytext());
    }
(".") {
        return new Symbol(sym.Punto,yychar,yyline,yytext());
    }
(",") {
        return new Symbol(sym.Coma,yychar,yyline,yytext());
    }
("_") {
        return new Symbol(sym.GuionBajo,yychar,yyline,yytext());
    }
("&") {
        return new Symbol(sym.Ampersand,yychar,yyline,yytext());
    }
("'") {
        return new Symbol(sym.Apostrofe,yychar,yyline,yytext());
    }
("@") {
        return new Symbol(sym.Arroba,yychar,yyline,yytext());
    }
("#") {
        return new Symbol(sym.Numeral,yychar,yyline,yytext());
    }
("(") {
        return new Symbol(sym.ParIzq,yychar,yyline,yytext());
    }
(")") {
        return new Symbol(sym.ParDer,yychar,yyline,yytext());
    }
("[") {
        return new Symbol(sym.SquareBIzq,yychar,yyline,yytext());
    }
("]") {
        return new Symbol(sym.SquareBDer,yychar,yyline,yytext());
    }
("{") {
        return new Symbol(sym.CurlyIzq,yychar,yyline,yytext());
    }
("}") {
        return new Symbol(sym.CurlyDer,yychar,yyline,yytext());
    }
("^"|"%"|"?") {
        return new Symbol(sym.special_characters,yychar,yyline,yytext());
    }
     
    //variables
({ID}) {     
       return new Symbol(sym.IDENTIFICADOR,yychar,yyline,yytext());
    }
({STRING}) {
        return new Symbol(sym.CADENA,yychar,yyline,yytext());
    }
({INTEGER}) {
        return new Symbol(sym.ENTERO,yychar,yyline,yytext());
    }
({DECIMAL}) {
        return new Symbol(sym.DECIMAL,yychar,yyline,yytext());
    }

 . {return new Symbol(sym.ERROR, yychar, yyline, yytext());}
