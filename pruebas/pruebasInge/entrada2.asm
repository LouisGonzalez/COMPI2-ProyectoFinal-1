title *falta titulo*
include irvine32.inc
.data
stack DW 100000 DUP(0)
heap DW 100000 DUP(0)
t0 DWORD 0
t1 DWORD 0
t2 DWORD 0
t3 DWORD 0
t4 DWORD 0
t5 DWORD 0
t6 DWORD 0
t7 DWORD 0
t8 DWORD 0
t9 DWORD 0
t10 DWORD 0
t11 DWORD 0
t12 DWORD 0
t13 DWORD 0
t14 DWORD 0
t15 DWORD 0
t16 DWORD 0
t17 DWORD 0
t18 DWORD 0
t19 DWORD 0
t20 DWORD 0
t21 DWORD 0
t22 DWORD 0
t23 DWORD 0
t24 DWORD 0
t25 DWORD 0
t26 DWORD 0
t27 DWORD 0
t28 DWORD 0
t29 DWORD 0
t30 DWORD 0
t31 DWORD 0
t32 DWORD 0
t33 DWORD 0
t34 DWORD 0
t35 DWORD 0
t36 DWORD 0
t37 DWORD 0
t38 DWORD 0
t39 DWORD 0
t40 DWORD 0
t41 DWORD 0
t42 DWORD 0
t43 DWORD 0
t44 DWORD 0
t45 DWORD 0
t46 DWORD 0
t47 DWORD 0
t48 DWORD 0
t49 DWORD 0
t50 DWORD 0
t51 DWORD 0
t52 DWORD 0
t53 DWORD 0
t54 DWORD 0
t55 DWORD 0
t56 DWORD 0
t57 DWORD 0
t58 DWORD 0
t59 DWORD 0
t60 DWORD 0
t61 DWORD 0
t62 DWORD 0
t63 DWORD 0
t64 DWORD 0
t65 DWORD 0
t66 DWORD 0
t67 DWORD 0
t68 DWORD 0
t69 DWORD 0
t70 DWORD 0
t71 DWORD 0
t72 DWORD 0
t73 DWORD 0
t74 DWORD 0
t75 DWORD 0
t76 DWORD 0
t77 DWORD 0
t78 DWORD 0
t79 DWORD 0
t80 DWORD 0
t81 DWORD 0
t82 DWORD 0
t83 DWORD 0
t84 DWORD 0
t85 DWORD 0
t86 DWORD 0
t87 DWORD 0
t88 DWORD 0
t89 DWORD 0
t90 DWORD 0
t91 DWORD 0
t92 DWORD 0
t93 DWORD 0
t94 DWORD 0
t95 DWORD 0
t96 DWORD 0
t97 DWORD 0
t98 DWORD 0
t99 DWORD 0
t100 DWORD 0
mensaje127 BYTE " \ n Ingrese el primer numero :",0
mensaje128 BYTE "\n",0
mensaje129 BYTE " aaa",0
mensaje130 BYTE "\n",0
mensaje136 BYTE " \ n Ingrese el segundo numero :",0
mensaje137 BYTE "\n",0
mensaje138 BYTE " bbb",0
mensaje139 BYTE "\n",0
mensaje160 BYTE " \ n Ingrese el numero hasta donde quiera contar",0
mensaje161 BYTE "\n",0
mensaje162 BYTE " cccc",0
mensaje163 BYTE "\n",0
mensaje170 BYTE "",0
mensaje171 BYTE "\n",0
mensaje185 BYTE t52,0
mensaje186 BYTE "\n",0
mensaje216 BYTE " \ n Ingrese x para elevarlo al cuadrado :",0
mensaje217 BYTE "\n",0
mensaje218 BYTE " dddd",0
mensaje219 BYTE "\n",0
mensaje225 BYTE " \ n Antes de Elevarse es :",0
mensaje226 BYTE "\n",0
mensaje227 BYTE " \ n x despus de Elevarse es :",0
mensaje228 BYTE "\n",0
mensaje231 BYTE " Desea Repetir el Proceso [ s ] i o [ n ] o",0
mensaje232 BYTE "\n",0
mensaje233 BYTE " eee",0
mensaje234 BYTE "\n",0
.code
main proc
mov p,0
mov h,0
mov eax,0
add eax,p
add eax,0
mov t81,eax
mov eax,0
mov stack[t81],'s'
mov eax,0
add eax,p
add eax,2
mov p,eax
mov eax,0
call JV_OperacionAlgebraica_OperacionAlgebraica
mov eax,0
add eax,p
sub eax,2
mov p,eax
mov eax,0
mov eax,0
add eax,p
add eax,2
mov t82,eax
mov eax,0
mov eax,0
add eax,t82
add eax,0
mov t83,eax
mov eax,0
mov t84,stack[t83]
mov eax,0
add eax,p
add eax,1
mov t85,eax
mov eax,0
mov stack[t85],t84
mov eax,0
add eax,p
add eax,1
mov t86,eax
mov eax,0
mov t87,stack[t86]
mov eax,0
add eax,p
add eax,2
mov t88,eax
mov eax,0
mov eax,0
add eax,t88
add eax,0
mov t89,eax
mov eax,0
mov stack[t89],t87
mov eax,0
add eax,p
add eax,2
mov p,eax
mov eax,0
call JV_OperacionAlgebraica_Suma
mov eax,0
add eax,p
sub eax,2
mov p,eax
mov eax,0
mov eax,0
add eax,p
add eax,1
mov t91,eax
mov eax,0
mov t92,stack[t91]
mov eax,0
add eax,p
add eax,2
mov t93,eax
mov eax,0
mov eax,0
add eax,t93
add eax,0
mov t94,eax
mov eax,0
mov stack[t94],t92
mov eax,0
add eax,p
add eax,2
mov p,eax
mov eax,0
call JV_OperacionAlgebraica_Contador
mov eax,0
add eax,p
sub eax,2
mov p,eax
mov eax,0
mov eax,0
add eax,p
add eax,1
mov t96,eax
mov eax,0
mov t97,stack[t96]
mov eax,0
add eax,p
add eax,2
mov t98,eax
mov eax,0
mov eax,0
add eax,t98
add eax,0
mov t99,eax
mov eax,0
mov stack[t99],t97
mov eax,0
add eax,p
add eax,2
mov p,eax
mov eax,0
call JV_OperacionAlgebraica_ElevarCuadrado
mov eax,0
add eax,p
sub eax,2
mov p,eax
mov eax,0
EXIT
main ENDP
JV_OperacionAlgebraica_OperacionAlgebraica proc
mov eax,0
add eax,p
add eax,0
mov t1,eax
mov eax,0
mov stack[t1],h
mov eax,0
add eax,h
add eax,6
mov h,eax
mov eax,0
mov eax,0
add eax,p
add eax,0
mov t2,eax
mov eax,0
mov t3,stack[t2]
mov eax,0
add eax,t3
add eax,0
mov t4,eax
mov eax,0
mov heap[t4],0.0
mov eax,0
add eax,p
add eax,0
mov t5,eax
mov eax,0
mov t6,stack[t5]
mov eax,0
add eax,t6
add eax,1
mov t7,eax
mov eax,0
mov heap[t7],0.0
mov eax,0
add eax,p
add eax,0
mov t8,eax
mov eax,0
mov t9,stack[t8]
mov eax,0
add eax,t9
add eax,2
mov t10,eax
mov eax,0
mov heap[t10],0.0
mov eax,0
add eax,p
add eax,0
mov t11,eax
mov eax,0
mov t12,stack[t11]
mov eax,0
add eax,t12
add eax,4
mov t13,eax
mov eax,0
mov heap[t13],4
mov eax,0
add eax,p
add eax,0
mov t14,eax
mov eax,0
mov t15,stack[t14]
mov eax,0
add eax,t15
add eax,5
mov t16,eax
mov eax,0
mov heap[t16],0
ret
JV_OperacionAlgebraica_OperacionAlgebraica endp
JV_OperacionAlgebraica_Suma proc
mov edx,offset mensaje127
call writestring
mov edx,offset mensaje128
call writestring
mov edx,offset mensaje129
call writestring
mov edx,offset mensaje130
call writestring
call readdec
mov t17,eax
mov eax,0
add eax,p
add eax,0
mov t18,eax
mov eax,0
mov t19,stack[t18]
mov eax,0
add eax,t19
add eax,0
mov t20,eax
mov eax,0
mov heap[t20],t17
mov edx,offset mensaje136
call writestring
mov edx,offset mensaje137
call writestring
mov edx,offset mensaje138
call writestring
mov edx,offset mensaje139
call writestring
call readdec
mov t21,eax
mov eax,0
add eax,p
add eax,0
mov t22,eax
mov eax,0
mov t23,stack[t22]
mov eax,0
add eax,t23
add eax,1
mov t24,eax
mov eax,0
mov heap[t24],t21
mov eax,0
add eax,p
add eax,0
mov t25,eax
mov eax,0
mov t26,stack[t25]
mov eax,0
add eax,t26
add eax,0
mov t27,eax
mov eax,0
mov t28,heap[t27]
mov eax,0
add eax,p
add eax,0
mov t29,eax
mov eax,0
mov t30,stack[t29]
mov eax,0
add eax,t30
add eax,1
mov t31,eax
mov eax,0
mov t32,heap[t31]
mov eax,0
add eax,t28
add eax,t32
mov t33,eax
mov eax,0
mov eax,0
add eax,p
add eax,0
mov t34,eax
mov eax,0
mov t35,stack[t34]
mov eax,0
add eax,t35
add eax,2
mov t36,eax
mov eax,0
mov heap[t36],t33
ret
JV_OperacionAlgebraica_Suma endp
JV_OperacionAlgebraica_Contador proc
mov edx,offset mensaje160
call writestring
mov edx,offset mensaje161
call writestring
mov edx,offset mensaje162
call writestring
mov edx,offset mensaje163
call writestring
call readdec
mov t37,eax
mov eax,0
add eax,p
add eax,0
mov t38,eax
mov eax,0
mov t39,stack[t38]
mov eax,0
add eax,t39
add eax,3
mov t40,eax
mov eax,0
mov heap[t40],t37
etWhile_1:
mov edx,offset mensaje170
call writestring
mov edx,offset mensaje171
call writestring
mov eax,0
add eax,p
add eax,0
mov t41,eax
mov eax,0
mov t42,stack[t41]
mov eax,0
add eax,t42
add eax,4
mov t43,eax
mov eax,0
mov t44,heap[t43]
mov eax,0
add eax,t44
add eax,1
mov t45,eax
mov eax,0
mov eax,0
add eax,p
add eax,0
mov t46,eax
mov eax,0
mov t47,stack[t46]
mov eax,0
add eax,t47
add eax,4
mov t48,eax
mov eax,0
mov heap[t48],t45
mov eax,0
add eax,p
add eax,0
mov t49,eax
mov eax,0
mov t50,stack[t49]
mov eax,0
add eax,t50
add eax,4
mov t51,eax
mov eax,0
mov t52,heap[t51]
mov edx,offset mensaje185
call writestring
mov edx,offset mensaje186
call writestring
mov eax,0
add eax,p
add eax,0
mov t53,eax
mov eax,0
mov t54,stack[t53]
mov eax,0
add eax,t54
add eax,4
mov t55,eax
mov eax,0
mov t56,heap[t55]
mov eax,0
add eax,p
add eax,0
mov t57,eax
mov eax,0
mov t58,stack[t57]
mov eax,0
add eax,t58
add eax,3
mov t59,eax
mov eax,0
mov t60,heap[t59]
.IF(t56 <= t60)
jmp et_2
.ENDIF
jmp et_3
et_2:
jmp etWhile_1
et_3:
etFin_1:
ret
JV_OperacionAlgebraica_Contador endp
JV_OperacionAlgebraica_Cuadrado_Integer proc
mov eax,0
add eax,p
add eax,2
mov t61,eax
mov eax,0
mov t62,stack[t61]
mov eax,0
add eax,p
add eax,2
mov t63,eax
mov eax,0
mov t64,stack[t63]
mov eax,t62
mov ebx,t64
mul ebx
mov t65,eax
mov ebx,0
mov eax,0
mov eax,0
add eax,p
add eax,2
mov t66,eax
mov eax,0
mov stack[t66],t65
mov eax,0
add eax,p
add eax,2
mov t67,eax
mov eax,0
mov t68,stack[t67]
mov eax,0
add eax,p
add eax,1
mov t69,eax
mov eax,0
mov stack[t69],t68
ret
JV_OperacionAlgebraica_Cuadrado_Integer endp
JV_OperacionAlgebraica_ElevarCuadrado proc
mov edx,offset mensaje216
call writestring
mov edx,offset mensaje217
call writestring
mov edx,offset mensaje218
call writestring
mov edx,offset mensaje219
call writestring
call readdec
mov t70,eax
mov eax,0
add eax,p
add eax,0
mov t71,eax
mov eax,0
mov t72,stack[t71]
mov eax,0
add eax,t72
add eax,5
mov t73,eax
mov eax,0
mov heap[t73],t70
mov edx,offset mensaje225
call writestring
mov edx,offset mensaje226
call writestring
mov edx,offset mensaje227
call writestring
mov edx,offset mensaje228
call writestring
ret
JV_OperacionAlgebraica_ElevarCuadrado endp
PY_Continuar proc
mov edx,offset mensaje231
call writestring
mov edx,offset mensaje232
call writestring
mov edx,offset mensaje233
call writestring
mov edx,offset mensaje234
call writestring
call readdec
mov t75,eax
mov eax,0
add eax,p
add eax,1
mov t76,eax
mov eax,0
mov stack[t76],t75
mov eax,0
add eax,p
add eax,1
mov t77,eax
mov eax,0
mov t78,stack[t77]
mov eax,0
add eax,p
add eax,0
mov t79,eax
mov eax,0
mov stack[t79],t78
ret
PY_Continuar endp
END main