package gramaticaJAVA;
import java_cup.runtime.Symbol;

%%
%public
%class AnalizadorLexico
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
    ","                                                             {return symbol(sym.coma, new String(yytext()));}
    "."                                                             {return symbol(sym.punto, new String(yytext()));}
    
    "int"                                                           {return symbol(sym.tipoInt, new String(yytext()));}
    "char"                                                          {return symbol(sym.tipoChar, new String(yytext()));}
    "float"                                                         {return symbol(sym.tipoFloat, new String(yytext()));}
    "void"                                                          {return symbol(sym.tipoVoid, new String(yytext()));}
    
    "if"                                                            {return symbol(sym.condIf, new String(yytext()));}
    "else"                                                          {return symbol(sym.condElse, new String(yytext()));}
    "for"                                                           {return symbol(sym.condFor, new String(yytext()));}
    "while"                                                         {return symbol(sym.condWhile, new String(yytext()));}
    "do"                                                            {return symbol(sym.condDo, new String(yytext()));}
    "switch"                                                        {return symbol(sym.condSwitch, new String(yytext()));}
    "case"                                                          {return symbol(sym.noCase, new String(yytext()));}
    "break"                                                         {return symbol(sym.quiebre, new String(yytext()));}
    "default"                                                       {return symbol(sym.def, new String(yytext()));}
    "return"                                                        {return symbol(sym.retorno, new String(yytext()));}
    "System.out.print"                                              {return symbol(sym.mensaje, new String(yytext()));}
    "System.out.println"                                            {return symbol(sym.mensaje2, new String(yytext()));}

    "this"                                                          {return symbol(sym.condThis, new String(yytext()));}

    "public"                                                        {return symbol(sym.tipoPublic, new String(yytext()));}
    "class"                                                         {return symbol(sym.clase, new String(yytext()));}

    "true"                                                          {return symbol(sym.condTrue, new String(yytext()));}
    "false"                                                         {return symbol(sym.condFalse, new String(yytext()));}


    "intinput"                                                      {return symbol(sym.intInput, new String(yytext()));}
    "charinput"                                                     {return symbol(sym.charInput, new String(yytext()));}
    "floatinput"                                                    {return symbol(sym.floatInput, new String(yytext()));}

    "{"                                                             {return symbol(sym.llave_a, new String(yytext()));}
    "}"                                                             {return symbol(sym.llave_b, new String(yytext()));}
    "["                                                             {return symbol(sym.agrupacion_a, new String(yytext()));}
    "]"                                                             {return symbol(sym.agrupacion_b, new String(yytext()));}
    "("                                                             {return symbol(sym.parentesis_a, new String(yytext()));}
    ")"                                                             {return symbol(sym.parentesis_b, new String(yytext()));}
    ";"                                                             {return symbol(sym.puntoComa, new String(yytext()));}
    ":"                                                             {return symbol(sym.dosPuntos, new String(yytext()));}
    "!"                                                             {return symbol(sym.admiracion, new String(yytext()));}
    
    "="                                                             {return symbol(sym.igual, new String(yytext()));}
    "+"                                                             {return symbol(sym.mas, new String(yytext()));}
    "-"                                                             {return symbol(sym.menos, new String(yytext()));}
    "*"                                                             {return symbol(sym.por, new String(yytext()));}
    "/"                                                             {return symbol(sym.div, new String(yytext()));}
    "%"                                                             {return symbol(sym.porcentaje, new String(yytext()));}

    "//"                                                            {return symbol(sym.comentario_a, new String(yytext()));}
    "/*"                                                            {return symbol(sym.comentario_b, new String(yytext()));}
    "*/"                                                            {return symbol(sym.comentario_c, new String(yytext()));}

    "<"                                                             {return symbol(sym.menor, new String(yytext()));}
    ">"                                                             {return symbol(sym.mayor, new String(yytext()));}
    
    "&&"                                                            {return symbol(sym.and, new String(yytext()));}
    "||"                                                            {return symbol(sym.or, new String(yytext()));}

    "&"                                                             {return symbol(sym.ampersand, new String(yytext()));}
    "|"                                                             {return symbol(sym.pleca, new String(yytext()));}
    
    "\""                                                            {return symbol(sym.comilla, new String(yytext()));}
    "'"                                                             {return symbol(sym.comillaSimple, new String(yytext()));}
    
    "_"                                                             {return symbol(sym.guionBajo, new String(yytext()));}
    {Enter}                                                         {return symbol(sym.enter);}    
    {Numero}+                                                       {return symbol(sym.numero, new Integer(yytext()));}
    ({Letra}|{GuionBajo})({Letra}|{Numero}|{GuionBajo})*            {return symbol(sym.id, new String(yytext()));}
    {Espacio}+                                                      {}    
}
    [^]                                                             {return symbol(sym.resto, new String(yytext()));}    