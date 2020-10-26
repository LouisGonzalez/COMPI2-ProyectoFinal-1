package gramaticaVB;
import java_cup.runtime.*;

%%
%public 
%class AnalizadorLexico3
%cup
%cupdebug
%line
%column
%ignorecase



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
    ","                                                         {return symbol(sym.coma, new String(yytext()));}
    "."                                                         {return symbol(sym.punto, new String(yytext()));}
    "Public"                                                    {return symbol(sym.tipoPublic, new String(yytext()));}
    "End"                                                       {return symbol(sym.fin, new String(yytext()));}
    "Dim"                                                       {return symbol(sym.tipoDim, new String(yytext()));}
    "return"                                                    {return symbol(sym.condReturn, new String(yytext()));}

    "Integer"                                                   {return symbol(sym.tipoInt, new String(yytext()));}
    "Decimal"                                                   {return symbol(sym.tipoFloat, new String(yytext()));}
    "Chart"                                                     {return symbol(sym.tipoChar, new String(yytext()));}

    
    "Sub"                                                       {return symbol(sym.tipoSub, new String(yytext()));}
    "Function"                                                  {return symbol(sym.tipoFuncion, new String(yytext()));}
    
    "ByVal"                                                     {return symbol(sym.byVal, new String(yytext()));}

    "If"                                                        {return symbol(sym.condIf, new String(yytext()));}
    "Then"                                                      {return symbol(sym.condThen, new String(yytext()));}
    "Else"                                                      {return symbol(sym.condElse, new String(yytext()));}
    "elseif"                                                    {return symbol(sym.condElseIf, new String(yytext()));}
     
    "As"                                                        {return symbol(sym.condAs, new String(yytext()));}        

    "Do"                                                        {return symbol(sym.condDo, new String(yytext()));}
    "While"                                                     {return symbol(sym.condWhile, new String(yytext()));}
    "until"                                                     {return symbol(sym.condUntil, new String(yytext()));}
    "Loop"                                                      {return symbol(sym.condLoop, new String(yytext()));}

    "For"                                                       {return symbol(sym.condFor, new String(yytext()));}
    "to"                                                        {return symbol(sym.condTo, new String(yytext()));}
    "Step"                                                      {return symbol(sym.condStep, new String(yytext()));}
    "Next"                                                      {return symbol(sym.condNext, new String(yytext()));}                                              

    "And"                                                       {return symbol(sym.condAnd, new String(yytext()));}
    "Or"                                                        {return symbol(sym.condOr, new String(yytext()));}    
    "Not"                                                       {return symbol(sym.condNot, new String(yytext()));}
    "typeof"                                                    {return symbol(sym.condTP, new String(yytext()));}
    
    "intinput"                                                  {return symbol(sym.intInput, new String(yytext()));}
    "charinput"                                                 {return symbol(sym.charInput, new String(yytext()));}
    "floatinput"                                                {return symbol(sym.floatInput, new String(yytext()));}

    "select"                                                    {return symbol(sym.condSelect, new String(yytext()));}
    "case"                                                      {return symbol(sym.condCase, new String(yytext()));}

    "Console.writeLine"                                         {return symbol(sym.mensaje, new String(yytext()));}
    "Console.write"                                             {return symbol(sym.mensaje2, new String(yytext()));}

    
    "'"                                                         {return symbol(sym.comillaSimple, new String(yytext()));}
    "\""                                                        {return symbol(sym.comilla, new String(yytext()));}

    "+"                                                         {return symbol(sym.mas, new String(yytext()));}
    "-"                                                         {return symbol(sym.menos, new String(yytext()));}
    "*"                                                         {return symbol(sym.por, new String(yytext()));}
    "/"                                                         {return symbol(sym.div, new String(yytext()));}
    "%"                                                         {return symbol(sym.modulo, new String(yytext()));}
    "^"                                                         {return symbol(sym.potencia, new String(yytext()));}
    "\\"                                                        {return symbol(sym.contraDiagonal, new String(yytext()));}
            
    "//"                                                        {return symbol(sym.comentario_a, new String(yytext()));} 
    "/*"                                                        {return symbol(sym.comentario_b, new String(yytext()));}
    "*/"                                                        {return symbol(sym.comentario_c, new String(yytext()));}
                                                 
    "="                                                         {return symbol(sym.igual, new String(yytext()));}    
    "<"                                                         {return symbol(sym.menor, new String(yytext()));}
    ">"                                                         {return symbol(sym.mayor, new String(yytext()));}
    "<="                                                        {return symbol(sym.menorIgual, new String(yytext()));}
    ">="                                                        {return symbol(sym.mayorIgual, new String(yytext()));}
    "=<"                                                        {return symbol(sym.menorIgual2, new String(yytext()));}
    "=>"                                                        {return symbol(sym.mayorIgual2, new String(yytext()));}
    "Like"                                                      {return symbol(sym.condLike, new String(yytext()));}
    "Is"                                                        {return symbol(sym.condIs, new String(yytext()));}
    "IsNot"                                                     {return symbol(sym.condIsNot, new String(yytext()));}
    
    "("                                                         {return symbol(sym.parentesis_a, new String(yytext()));}
    ")"                                                         {return symbol(sym.parentesis_b, new String(yytext()));}
    "["                                                         {return symbol(sym.agrupacion_a, new String(yytext()));}
    "]"                                                         {return symbol(sym.agrupacion_b, new String(yytext()));}

    ":"                                                         {return symbol(sym.dosPuntos, new String(yytext()));}
    "&"                                                         {return symbol(sym.ampersand, new String(yytext()));}

    {Enter}                                                     {return symbol(sym.enter);}         
    {Numero}+                                                   {return symbol(sym.numero, new Integer(yytext()));}
    ({Letra}|{GuionBajo})({Letra}|{Numero}|{GuionBajo})*        {return symbol(sym.id, new String(yytext()));}
    {Espacio}+                                                  {}
    
} 
    [^]                                                         {return symbol(sym.resto, new String(yytext()));}