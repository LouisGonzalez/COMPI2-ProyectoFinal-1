package gramaticaC;
import java_cup.runtime.Symbol;

%%
%public
%class AnalizadorLexico4
%cup
%cupdebug
%line
%column

/*Identificadores*/
GuionBajo = [_]
Numero = [0123456789]
Letra = [a-zA-Z]
Enter = \n
Salto = \r
Espacio1 = [ \t\f]
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
    ";"                                                     {return symbol(sym.puntoComa, new String(yytext()));}
    ":"                                                     {return symbol(sym.dosPuntos, new String(yytext()));}

    "{"                                                     {return symbol(sym.llave_a, new String(yytext()));}
    "}"                                                     {return symbol(sym.llave_b, new String(yytext()));}
    "("                                                     {return symbol(sym.parentesis_a, new String(yytext()));}
    ")"                                                     {return symbol(sym.parentesis_b, new String(yytext()));}
    "["                                                     {return symbol(sym.agrupacion_a, new String(yytext()));}
    "]"                                                     {return symbol(sym.agrupacion_b, new String(yytext()));}
    
    "break"                                                 {return symbol(sym.condBreak, new String(yytext()));}
    
    "include"                                               {return symbol(sym.condInclude, new String(yytext()));}
    "VB"                                                    {return symbol(sym.visual, new String(yytext()));}
    "PY"                                                    {return symbol(sym.python, new String(yytext()));}
    "JAVA"                                                  {return symbol(sym.java, new String(yytext()));}
    "PROGRAMA"                                              {return symbol(sym.principal, new String(yytext()));}
    
    "\""                                                    {return symbol(sym.comilla, new String(yytext()));}
    "'"                                                     {return symbol(sym.comillaSimple, new String(yytext()));}
    
    "+"                                                     {return symbol(sym.mas, new String(yytext()));}
    "-"                                                     {return symbol(sym.menos, new String(yytext()));}
    "*"                                                     {return symbol(sym.por, new String(yytext()));}
    "/"                                                     {return symbol(sym.div, new String(yytext()));}
    "%"                                                     {return symbol(sym.modulo, new String(yytext()));}
    "#"                                                     {return symbol(sym.numeral, new String(yytext()));}
    
    "void"                                                  {return symbol(sym.tipoVoid, new String(yytext()));}    
    "int"                                                   {return symbol(sym.tipoInteger, new String(yytext()));}
    "float"                                                 {return symbol(sym.tipoFloat, new String(yytext()));}
    "char"                                                  {return symbol(sym.tipoChar, new String(yytext()));}
    "const"                                                 {return symbol(sym.tipoConst, new String(yytext()));}

    "true"                                                  {return symbol(sym.verdadero, new String(yytext()));}
    "false"                                                 {return symbol(sym.falso, new String(yytext()));}

    "main"                                                  {return symbol(sym.main, new String(yytext()));}
        
    "//"                                                    {return symbol(sym.comentario_a);}
    "/*"                                                    {return symbol(sym.comentario_b);}
    "*/"                                                    {return symbol(sym.comentario_c);}

    ">"                                                     {return symbol(sym.mayor, new String(yytext()));}
    "<"                                                     {return symbol(sym.menor, new String(yytext()));}
    "="                                                     {return symbol(sym.igual, new String(yytext()));}
    "!"                                                     {return symbol(sym.admiracion, new String(yytext()));}
        
    "&"                                                     {return symbol(sym.ampersand, new String(yytext()));}
    "|"                                                     {return symbol(sym.pleca, new String(yytext()));}

    "if"                                                    {return symbol(sym.condIf, new String(yytext()));}
    "else"                                                  {return symbol(sym.condElse, new String(yytext()));}
    
    "switch"                                                {return symbol(sym.condSwitch, new String(yytext()));}
    "case"                                                  {return symbol(sym.condCase, new String(yytext()));}
    "default"                                               {return symbol(sym.condDef, new String(yytext()));}
    
    "for"                                                   {return symbol(sym.condFor, new String(yytext()));}

    "while"                                                 {return symbol(sym.condWhile, new String(yytext()));}
    "do"                                                    {return symbol(sym.condDo, new String(yytext()));}

    "printf"                                                {return symbol(sym.printf, new String(yytext()));}
    "scanf"                                                 {return symbol(sym.scanf, new String(yytext()));}

    "%d"                                                     {return symbol(sym.scanfInt, new String(yytext()));}
    "%c"                                                     {return symbol(sym.scanfChar, new String(yytext()));}
    "%f"                                                     {return symbol(sym.scanfFloat, new String(yytext()));}

    "&&"                                                    {return symbol(sym.and, new String(yytext()));}
    "||"                                                    {return symbol(sym.or, new String(yytext()));}

    "clrscr"                                                 {return symbol(sym.clscr, new String(yytext()));}
    "getch"                                                 {return symbol(sym.getch, new String(yytext()));}
    {Numero}+                                               {return symbol(sym.numero, new Integer(yytext()));}
    ({Letra}|{GuionBajo})({Letra}|{Numero}|{GuionBajo})*    {return symbol(sym.id, new String(yytext()));}
    {Enter}                                                 {return symbol(sym.enter);}
    {Espacio}+                                              {}    
}
    [^]                                                     {return symbol(sym.resto, new String(yytext()));}