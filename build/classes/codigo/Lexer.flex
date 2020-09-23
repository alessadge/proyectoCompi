package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
Point="."
LETTER=[a-zA-Z]
Caracteres="+"|"-"|"/"|"*"|">"|"<"|">="|"<="|"!="|"!"|"="|":"|";"|"."|","|"-"|"_"|"&"|"'"|"@"|"#"|"("|")"|"["|"]"|"{"|"}"|"^"|"%"|"?"
INTEGER=[1-9]{D}*|0
DECIMAL={D}+{Point}{D}+
espacio=[ ,\t,\r]+
NUMBER=[0-9]
Comentario=("/^")({LETTER}|{NUMBER}|{espacio}|{Caracteres})*("^/")
STRING=\"({LETTER}|{NUMBER}|{espacio}|{Caracteres})*\"
%{
    public String lexeme;
%}
%%


/* Espacios en blanco */
{espacio} {/*Ignore*/}

/* Comentarios */
({Comentario}) {/*Ignore*/}

/* Salto de linea */
( "\n" ) {return Linea;}

("if") {
        lexeme=yytext(); return If;
    }
("end if") {
        lexeme=yytext(); return EndIf;
    }
("else") {
        lexeme=yytext(); return Else;
    }
("end else") {
        lexeme=yytext(); return EndElse;
    }
("else if") {
        lexeme=yytext(); return ElseIf;
    }
("end else if") {
        lexeme=yytext(); return EndElseIf;
    }
("then") {
        lexeme=yytext(); return Then;
    }
	
    //Parte for
("for") {
        lexeme=yytext(); return For;
    }
("in") {
        lexeme=yytext(); return In;
    }
("range") {
        lexeme=yytext(); return Range;
    }
("end for") {
        lexeme=yytext(); return EndFor;
    }
	
    //Parte while
("while") {
        lexeme=yytext(); return While;
    }
("repeat") {
        lexeme=yytext(); return Repeat;
    }
("end while") {
        lexeme=yytext(); return EndWhile;
    }

	
    //Tipos de variables
("Int") {
        lexeme=yytext(); return TypeInt;
    }
("Float") {
        lexeme=yytext(); return TypeFloat;
    }
("String") {
        lexeme=yytext(); return TypeString;
    }
("List") {
        lexeme=yytext(); return TypeList;
    }
("Matriz") {
        lexeme=yytext(); return TypeMatriz;
    }
("Bool") {
        lexeme=yytext(); return TypeBool;
    }
/*Operadores Booleanos*/
(true | false)      {lexeme = yytext(); return OP_BOOL;}
    
    //operadores
("+|-") {      
        lexeme=yytext(); return OP_SUMA;
    }
("*") {
        lexeme=yytext(); return OP_MULT;
    }
("/") {
        lexeme=yytext(); return OP_DIV;
    } 
("And"|"Or") {
        lexeme=yytext(); return OP_LOGIC;
    }
(">"|"<"|">="|"<="|"!="|"!"|"=") {
        lexeme=yytext(); return OP_RELA;
    } 
("=>") {
        lexeme=yytext(); return OP_ASIG;
    }
    //Parte del switch 
("case") {     
        lexeme=yytext(); return Case;
    }
("of") {
        lexeme=yytext(); return Of;
    }
("default") {
        lexeme=yytext(); return Default;
    }
("end case") {
        lexeme=yytext(); return EndCase;
    }
    
    //Parte del Main
("main") {      
        lexeme=yytext(); return Main;
    }
("begin") {
        lexeme=yytext(); return Begin;
    }
("Println") {
        lexeme=yytext(); return ImpLn;
    }
("Print") {
        lexeme=yytext(); return Imp;
    }
("call") {
        lexeme=yytext(); return Call;
    }
("end call") {
        lexeme=yytext(); return EndCall;
    }
("end main") {
        lexeme=yytext(); return EndMain;
    }
    //Lectura y escritura
("Put") { 
        lexeme=yytext(); return Put;
    }
("Get") {
        lexeme=yytext(); return Get;
    }
("Do") { 
        lexeme=yytext(); return Do;
    }
    
    //Caracteres
(":") {      
        lexeme=yytext(); return DosPuntos;    
    }
(";") {
        lexeme=yytext(); return PuntoComa;
    }
(".") {
        lexeme=yytext(); return Punto;
    }
(",") {
        lexeme=yytext(); return Coma;
    }
("_") {
        lexeme=yytext(); return GuionBajo;
    }
("&") {
        lexeme=yytext(); return Ampersand;
    }
("'") {
        lexeme=yytext(); return Apostrofe;
    }
/* Comillas */
( "\"" ) {lexeme=yytext(); return Comillas;}

("@") {
        lexeme=yytext(); return Arroba;
    }
("#") {
        lexeme=yytext(); return Numeral;
    }
("(") {
        lexeme=yytext(); return ParIzq;
    }
(")") {
        lexeme=yytext(); return ParDer;
    }
("[") {
        lexeme=yytext(); return SquareBIzq;
    }
("]") {
        lexeme=yytext(); return SquareBDer;
    }
("{") {
        lexeme=yytext(); return CurlyIzq;
    }
("}") {
        lexeme=yytext(); return CurlyDer;
    }
("^"|"%"|"?") {
        lexeme=yytext(); return special_characters;
    }
/* Operadores Atribucion */
( "+=" | "-="  | "*=" | "/=" | "%=" ) {lexeme = yytext(); return Op_atribucion;}

/* Operadores Incremento y decremento */
( "++" | "--" ) {lexeme = yytext(); return Op_incremento;}
     
    //variables
/* Tipo de dato String */
({STRING}) {
        lexeme=yytext(); return CADENA;
    }
({INTEGER}) {
        lexeme=yytext(); return ENTERO;
    }
({DECIMAL}) {
        lexeme=yytext(); return DECIMAL;
    }

/* Identificador */
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}

/* Numero */
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}


/* Error de analisis */
 . {return ERROR;}
