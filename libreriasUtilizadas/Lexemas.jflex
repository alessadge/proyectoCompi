package Analizar;
import java_cup.runtime.Symbol;
import java.util.ArrayList;
%%
%unicode
%class Lexer1
%line
%column
%int
%ignorecase
%state comentarios
%cup 
%full
%char
%public 

//Palabras Reservadas
    //Parte de if
	If=if
	EndIf="end if"
	Else=else
	EndElse="end else"
	ElseIf="else if"
	EndElseIf="end else if"
	Then=then

	 //Parte for
	For="for"
        In="in"
        Range="range"
        EndFor="end for"
	
    //Parte while
	While="while"
	Repeat="repeat"
	EndWhile="end while"
    
    //Tipos de variables
    TypeInt ="Int"
    TypeFloat="Float"
    TypeString="String"
    TypeList="List"
    TypeMatriz="Matriz"
    TypeBoolean="Bool"
    typeBool=true|false
    
    //Parte switch
    Case="case"
    Of="of"
    Default="default"
    EndCase="end case"
    
    //Metodo Main y demas
    Main="main"
    Begin="begin"
    ImpLn="Println"
    Imp="Print"
    Call="call"
    EndCall="end call"
    EndMain="end main"    
    //Funicones lectura y escritura
    put ="Put"
    get ="Get"

//Operadores
    OP_SUMA ="+"|"-"
    OP_DIV ="/"
    OP_MULT ="*"
    OP_RELA =">"|"<"|">="|"<="|"!="|"!"|"=" 
    OP_LOGIC ="And" | "Or"
    OP_ASIG="=>"  

//Caracteres
    DosPuntos=":"
    PuntoComa=";"
    Punto="."
    Coma=","
    Guion="-"
    GuionBajo="_"
    Ampersand="&"
    Apostrofe="'"
    Arroba="@"
    Numeral="#"
    ParIzq="("
    ParDer=")"
    SquareBIzq="["
    SquareBDer="]"
    CurlyIzq="{"
    CurlyDer="}"
    special_characters="^"|"%"|"?"|

//variable
    LETTER=[a-zA-Z]
    NUMBER=[0-9]
    ID={LETTER}({NUMBER}|{Guion}|{GuionBajo}|{LETTER})*
    STRING =\"({LETTER}|{NUMBER})*\"
    INTEGER =[1-9]{NUMBER}*|0 
    DECIMAL={NUMBER}+{Punto}{NUMBER}+
//Comentaros
    ComentarioEntrada="/^"
    ComentarioSalida="^/"

//
	Espacio=[ \n\r\t]+

%%
<YYINITIAL> {	
	//Parte if
	{If} {System.out.println("<IF >:"+yytext());
        return symbol(sym.If,yyline,yycolumn,yytext());
    }
	{EndIf} {System.out.println("<EndIf >:"+yytext());
        return symbol(sym.EndIf,yyline,yycolumn,yytext());
    }
	{Else} {System.out.println("<Else >:"+yytext());
        return symbol(sym.Else,yyline,yycolumn,yytext());
    }
	{EndElse} {System.out.println("<EndElse >:"+yytext());
        return symbol(sym.EndElse,yyline,yycolumn,yytext());
    }
	{ElseIf} {System.out.println("<ElseIf >:"+yytext());
        return symbol(sym.ElseIf,yyline,yycolumn,yytext());
    }
	{EndElseIf} {System.out.println("<EndElseIf >:"+yytext());
        return symbol(sym.EndElseIf,yyline,yycolumn,yytext());
    }
	{Then} {System.out.println("<Then >:"+yytext());
        return symbol(sym.Then,yyline,yycolumn,yytext());
    }
	
    //Parte for
	{For} {System.out.println("<For >:"+yytext());
        return symbol(sym.For,yyline,yycolumn,yytext());
    }
	{In} {System.out.println("<In >:"+yytext());
        return symbol(sym.In,yyline,yycolumn,yytext());
    }
	{Range} {System.out.println("<Range >:"+yytext());
        return symbol(sym.Range,yyline,yycolumn,yytext());
    }
	{EndFor} {System.out.println("<EndFor >:"+yytext());
        return symbol(sym.EndFor,yyline,yycolumn,yytext());
    }
	
    //Parte while
	{While} {System.out.println("<While >:"+yytext());
        return symbol(sym.While,yyline,yycolumn,yytext());
    }
	{Repeat} {System.out.println("<Repeat >:"+yytext());
        return symbol(sym.Repeat,yyline,yycolumn,yytext());
    }
	{EndWhile} {System.out.println("<end while >:"+yytext());
        return symbol(sym.EndWhile,yyline,yycolumn,yytext());
    }
	
    //Tipos de variables
    {TypeInt} {System.out.println("<TypeInt >:"+yytext());
        return symbol(sym.TypeInt,yyline,yycolumn,yytext());
    }
    {TypeFloat} {System.out.println("<TypeFloat >:"+yytext());
        return symbol(sym.TypeFloat,yyline,yycolumn,yytext());
    }
    {TypeString} {System.out.println("<TypeString >:"+yytext());
        return symbol(sym.TypeString,yyline,yycolumn,yytext());
    }
    {TypeList} {System.out.println("<TypeList >:"+yytext());
        return symbol(sym.TypeList,yyline,yycolumn,yytext());
    }
    {TypeMatriz} {System.out.println("<TypeMatriz >:"+yytext());
        return symbol(sym.TypeMatriz,yyline,yycolumn,yytext());
    }
    {TypeBoolean} {System.out.println("<TypeBool >:"+yytext());
        return symbol(sym.TypeBool,yyline,yycolumn,yytext());
    }
    {typeBool} {System.out.println("<TypeBool >:"+yytext());
        return symbol(sym.typeBool,yyline,yycolumn,yytext());
    }
    
    //operadores
    {OP_SUMA} {System.out.println("<OP_SUMA >:"+yytext());
        return symbol(sym.OP_SUMA,yyline,yycolumn,yytext());
    }
    {OP_MULT} {System.out.println("<OP_MULT >:"+yytext());
        return symbol(sym.OP_MULT,yyline,yycolumn,yytext());
    }
    {OP_DIV} {System.out.println("<OP_DIV >:"+yytext());
        return symbol(sym.OP_DIV,yyline,yycolumn,yytext());
    } 
    {OP_LOGIC} {System.out.println("<OP_LOGIC >:"+yytext());
        return symbol(sym.OP_LOGIC,yyline,yycolumn,yytext());
    }
    {OP_RELA} {System.out.println("<OP_RELA >:"+yytext());
        return symbol(sym.OP_RELA,yyline,yycolumn,yytext());
    } 
    {OP_ASIG} {System.out.println("<OP_ASIG >:"+yytext());
        return symbol(sym.OP_ASIG,yyline,yycolumn,yytext());
    }
    
    //Parte del switch 
    {Case} {System.out.println("<Case >:"+yytext());
        return symbol(sym.Case,yyline,yycolumn,yytext());
    }
    {Of} {System.out.println("<Of >:"+yytext());
        return symbol(sym.Of,yyline,yycolumn,yytext());
    }
    {Default} {System.out.println("<Default >:"+yytext());
        return symbol(sym.Default,yyline,yycolumn,yytext());
    }
    {EndCase} {System.out.println("<EndCase >:"+yytext());
        return symbol(sym.EndCase,yyline,yycolumn,yytext());
    }
    
    //Parte del Main
    {Main} {System.out.println("<Main >:"+yytext());
        return symbol(sym.Main,yyline,yycolumn,yytext());
    }
    {Begin} {System.out.println("<Begin >:"+yytext());
        return symbol(sym.Begin,yyline,yycolumn,yytext());
    }
    {ImpLn} {System.out.println("<ImpLn >:"+yytext());
        return symbol(sym.ImpLn,yyline,yycolumn,yytext());
    }
    {Imp} {System.out.println("<Imp >:"+yytext());
        return symbol(sym.Imp,yyline,yycolumn,yytext());
    }
    {Call} {System.out.println("<Call >:"+yytext());
        return symbol(sym.Call,yyline,yycolumn,yytext());
    }
    {EndCall} {System.out.println("<EndCall >:"+yytext());
        return symbol(sym.EndCall,yyline,yycolumn,yytext());
    }
    {EndMain} {System.out.println("<EndMain >:"+yytext());
        return symbol(sym.EndMain,yyline,yycolumn,yytext());
    }
    
    //Lectura y escritura
    {put} {System.out.println("<Put >:"+yytext());
        return symbol(sym.put,yyline,yycolumn,yytext());
    }
    {get} {System.out.println("<Get >:"+yytext());
        return symbol(sym.get,yyline,yycolumn,yytext());
    }
    
    //Caracteres
    {DosPuntos} {System.out.println("<DosPuntos >:"+yytext());
        return symbol(sym.DosPuntos,yyline,yycolumn,yytext());
    }
    {PuntoComa} {System.out.println("<PuntoComa >:"+yytext());
        return symbol(sym.PuntoComa,yyline,yycolumn,yytext());
    }
    {Punto} {System.out.println("<Punto >:"+yytext());
        return symbol(sym.Punto,yyline,yycolumn,yytext());
    }
    {Coma} {System.out.println("<Coma >:"+yytext());
        return symbol(sym.Coma,yyline,yycolumn,yytext());
    }
    {Guion} {System.out.println("<Guion >:"+yytext());
        return symbol(sym.Guion,yyline,yycolumn,yytext());
    }
    {GuionBajo} {System.out.println("<GuionBajo >:"+yytext());
        return symbol(sym.GuionBajo,yyline,yycolumn,yytext());
    }
    {Ampersand} {System.out.println("<Ampersand >:"+yytext());
        return symbol(sym.Ampersand,yyline,yycolumn,yytext());
    }
    {Apostrofe} {System.out.println("<Apostrofe >:"+yytext());
        return symbol(sym.Apostrofe,yyline,yycolumn,yytext());
    }
    {Arroba} {System.out.println("<Arroba >:"+yytext());
        return symbol(sym.Arroba,yyline,yycolumn,yytext());
    }
    {Numeral} {System.out.println("<Numeral >:"+yytext());
        return symbol(sym.Numeral,yyline,yycolumn,yytext());
    }
    {ParIzq} {System.out.println("<ParIzq >:"+yytext());
        return symbol(sym.ParIzq,yyline,yycolumn,yytext());
    }
    {ParDer} {System.out.println("<ParDer >:"+yytext());
        return symbol(sym.ParDer,yyline,yycolumn,yytext());
    }
    {SquareBIzq} {System.out.println("<SquareBIzq >:"+yytext());
        return symbol(sym.SquareBIzq,yyline,yycolumn,yytext());
    }
    {SquareBDer} {System.out.println("<SquareBDer >:"+yytext());
        return symbol(sym.SquareBDer,yyline,yycolumn,yytext());
    }
    {CurlyIzq} {System.out.println("<CurlyIzq >:"+yytext());
        return symbol(sym.CurlyIzq,yyline,yycolumn,yytext());
    }
    {CurlyDer} {System.out.println("<CurlyDer >:"+yytext());
        return symbol(sym.CurlyDer,yyline,yycolumn,yytext());
    }
    {special_characters} {System.out.println("<special_characters >:"+yytext());
        return symbol(sym.special_characters,yyline,yycolumn,yytext());
    }
     
    //variables
    {ID} {System.out.println("<ID >:"+yytext());
        return symbol(sym.IDENTIFICADOR,yyline,yycolumn,yytext());
    }
    {STRING} {System.out.println("<String >:"+yytext());
        return symbol(sym.CADENA,yyline,yycolumn,yytext());
    }
    {INTEGER} {System.out.println("<Integer >:"+yytext());
        return symbol(sym.ENTERO,yyline,yycolumn,yytext());
    }
    {DECIMAL} {System.out.println("<Decimal >:"+yytext());
        return symbol(sym.DECIMAL,yyline,yycolumn,yytext());
    }

    //Comentarios
    {ComentarioEntrada} {yybegin(comentarios);}
	
    //
    {Espacio} {}
	. {System.out.println("error"+yyline+" "+yycolumn +" "+yytext());} 
}
<comentarios>{
    {ComentarioSalida}  {yybegin(YYINITIAL);}
    .   {}
}