package gramaticaPYTHON;
import java_cup.runtime.Symbol;

%%
%public 
%class AnalizadorLexico2
%cup
%cupdebug
%line
%column

/*Identificadores*/
GuionBajo = [_]
Numero = [0123456789]
Letra = [a-zA-Z]
Tab = \t | "     "
Enter = \n
Salto = \r
Espacio1 = [ \f]
Espacio = {Salto} | {Espacio1}

%{

    private Symbol symbol(int tipo){
        return new Symbol(tipo, yyline+1, yycolumn+1);
    }

    private Symbol symbol(int tipo, Object value){
        return new Symbol(tipo, yyline+1, yycolumn+1, value);
    }   

%}
%%
<YYINITIAL>{
    ","                                                     {return symbol(sym.coma, new String(yytext()));}
    "."                                                     {return symbol(sym.punto, new String(yytext()));}
    
    "+"                                                     {return symbol(sym.mas, new String(yytext()));}
    "-"                                                     {return symbol(sym.menos, new String(yytext()));}
    "*"                                                     {return symbol(sym.por, new String(yytext()));}
    "/"                                                     {return symbol(sym.div, new String(yytext()));}
    "%"                                                     {return symbol(sym.porcentaje, new String(yytext()));}
    
    "("                                                     {return symbol(sym.parentesis_a, new String(yytext()));}
    ")"                                                     {return symbol(sym.parentesis_b, new String(yytext()));}
    "{"                                                     {return symbol(sym.llave_a, new String(yytext()));}
    "}"                                                     {return symbol(sym.llave_b, new String(yytext()));}
    "["                                                     {return symbol(sym.agrupacion_a, new String(yytext()));}
    "]"                                                     {return symbol(sym.agrupacion_b, new String(yytext()));}

    ":"                                                     {return symbol(sym.dosPuntos, new String(yytext()));}
    "\""                                                    {return symbol(sym.comilla, new String(yytext()));}
    "'"                                                     {return symbol(sym.comillaSimple, new String(yytext()));}
    "!"                                                     {return symbol(sym.admiracion, new String(yytext()));}
    
    "//"                                                    {return symbol(sym.comentario_a, new String(yytext()));}
    "/*"                                                    {return symbol(sym.comentario_b, new String(yytext()));}
    "*/"                                                    {return symbol(sym.comentario_c, new String(yytext()));}

    "="                                                     {return symbol(sym.igual, new String(yytext()));}
    "<"                                                     {return symbol(sym.menor, new String(yytext()));}
    ">"                                                     {return symbol(sym.mayor, new String(yytext()));}
    "<="                                                    {return symbol(sym.menorIgual, new String(yytext()));}
    ">="                                                    {return symbol(sym.mayorIgual, new String(yytext()));}
    
    "and"                                                   {return symbol(sym.and, new String(yytext()));}
    "or"                                                    {return symbol(sym.or, new String(yytext()));}
    "not"                                                   {return symbol(sym.not, new String(yytext()));}

    "print"                                                 {return symbol(sym.mensaje, new String(yytext()));}
    "f"                                                     {return symbol(sym.f, new String(yytext()));}

    "else"                                                  {return symbol(sym.condElse, new String(yytext()));}
    "return"                                                {return symbol(sym.condReturn, new String(yytext()));}
    
    "for"                                                   {return symbol(sym.condFor, new String(yytext()));}
    "in"                                                    {return symbol(sym.condIn, new String(yytext()));}
    "range"                                                 {return symbol(sym.condRange, new String(yytext()));}

    "while"                                                 {return symbol(sym.condWhile, new String(yytext()));}
    
    "if"                                                    {return symbol(sym.condIf, new String(yytext()));}
    "elif"                                                  {return symbol(sym.condElif, new String(yytext()));}
    
    "intinput"                                              {return symbol(sym.intInput, new String(yytext()));}
    "charinput"                                             {return symbol(sym.charInput, new String(yytext()));}
    "floatinput"                                            {return symbol(sym.floatInput, new String(yytext()));}

    "def"                                                   {return symbol(sym.condDef, new String(yytext()));}

    "del"                                                   {return symbol(sym.condDel, new String(yytext()));}
    "pass"                                                  {return symbol(sym.condPass, new String(yytext()));}

    "end"                                                   {return symbol(sym.condEnd, new String(yytext()));}
    {Tab}                                                   {return symbol(sym.tab);} 
    {Enter}                                                 {return symbol(sym.enter);}
    {Numero}+                                               {return symbol(sym.numero, new Integer(yytext()));}
    ({Letra}|{GuionBajo})({Letra}|{Numero}|{GuionBajo})*     {return symbol(sym.id, new String(yytext()));}
    {Espacio}+                                              {}
}   
    [^]                                                     {return symbol(sym.resto, new String(yytext()));}