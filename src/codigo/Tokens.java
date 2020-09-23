/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

/**
 *
 * @author Charly Ponce
 */
public enum Tokens {
        If,
        EndIf,
        Else,
        EndElse,
        ElseIf,
        EndElseIf,
        Then,
	
    //Parte for
        For,
        In,
        Range,
        EndFor,
	
    //Parte while
        While,
        Repeat,
        EndWhile,
	
    //Tipos de variables
        TypeInt,
        TypeFloat,
        TypeString,
        TypeList,
        TypeMatriz,
        TypeBool,
        T_dato,
    
    //operadores
        OP_SUMA,
        OP_MULT,
        OP_DIV,
        OP_LOGIC,
        OP_RELA,
        OP_ASIG,
        Op_incremento,
        Op_atribucion,
        OP_BOOL,
    
    //Parte del switch 
        Case,
        Of,
        Default,
        EndCase,
    
    //Parte del Main
        Main,
        Begin,
        ImpLn,
        Imp,
        Call,
        EndCall,
        EndMain,
    
    //Lectura y escritura
        Put,
        Get,
        Do,
    
    //Caracteres
        DosPuntos,
        PuntoComa,
        Punto,
        Coma,
        GuionBajo,
        Ampersand,
        Apostrofe,
        Comillas,
        Arroba,
        Numeral,
        ParIzq,
        ParDer,
        SquareBIzq,
        SquareBDer,
        CurlyIzq,
        CurlyDer,
        special_characters,
     
    //variables
        Identificador,
        ENTERO,
        CADENA,
        Numero,
        DECIMAL,
        ERROR,
        Linea,

        
}
