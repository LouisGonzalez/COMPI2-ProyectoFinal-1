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
mensaje100 BYTE " valor de global1 :",0
mensaje105 BYTE t10,0
mensaje106 BYTE "\n",0
mensaje125 BYTE t24,0
mensaje126 BYTE "\n",0
mensaje137 BYTE " Escriba una opcion",0
mensaje138 BYTE "\n",0
mensaje147 BYTE " Hola mundo",0
mensaje148 BYTE "\n",0
mensaje154 BYTE " segunda opcion",0
mensaje155 BYTE "\n",0
mensaje168 BYTE " El resultado de la suma es :",0
mensaje171 BYTE t39,0
mensaje172 BYTE "\n",0
mensaje175 BYTE " opcion incorrecta",0
mensaje176 BYTE "\n",0
mensaje187 BYTE " El resultado de la resta es :",0
mensaje190 BYTE t47,0
mensaje191 BYTE "\n",0
mensaje209 BYTE " Opciones :",0
mensaje210 BYTE "\n",0
mensaje211 BYTE " 1 . Sumar :",0
mensaje212 BYTE "\n",0
mensaje213 BYTE " 2 . Restar :",0
mensaje214 BYTE "\n",0
mensaje215 BYTE " 3 . Alcanzar :",0
mensaje216 BYTE "\n",0
mensaje217 BYTE " Ingrese primer numero :",0
mensaje218 BYTE "\n",0
mensaje222 BYTE " Ingrese segundo numero :",0
mensaje223 BYTE "\n",0
mensaje235 BYTE " Ingrese numero menu :",0
mensaje236 BYTE "\n",0
.code
main proc
mov p,0
mov h,0
mov edx,offset mensaje209
call writestring
mov edx,offset mensaje210
call writestring
mov edx,offset mensaje211
call writestring
mov edx,offset mensaje212
call writestring
mov edx,offset mensaje213
call writestring
mov edx,offset mensaje214
call writestring
mov edx,offset mensaje215
call writestring
mov edx,offset mensaje216
call writestring
mov edx,offset mensaje217
call writestring
mov edx,offset mensaje218
call writestring
call readdec
mov t51,eax
mov eax,0
add eax,p
add eax,0
mov t52,eax
mov eax,0
mov stack[t52],t51
mov edx,offset mensaje222
call writestring
mov edx,offset mensaje223
call writestring
call readdec
mov t53,eax
mov eax,0
add eax,p
add eax,1
mov t54,eax
mov eax,0
mov stack[t54],t53
mov eax,0
add eax,p
add eax,4
mov p,eax
mov eax,0
call JV_operaciones_operaciones
mov eax,0
add eax,p
sub eax,4
mov p,eax
mov eax,0
mov eax,0
add eax,p
add eax,4
mov t55,eax
mov eax,0
mov eax,0
add eax,t55
add eax,0
mov t56,eax
mov eax,0
mov t57,stack[t56]
mov eax,0
add eax,p
add eax,3
mov t58,eax
mov eax,0
mov stack[t58],t57
mov edx,offset mensaje235
call writestring
mov edx,offset mensaje236
call writestring
call readdec
mov t59,eax
mov eax,0
add eax,p
add eax,2
mov t60,eax
mov eax,0
mov stack[t60],t59
mov eax,0
add eax,p
add eax,2
mov t61,eax
mov eax,0
mov t62,stack[t61]
.IF(t62 == 1)
jmp et_12
.ENDIF
jmp et_13
et_12:
mov eax,0
add eax,p
add eax,0
mov t63,eax
mov eax,0
mov t64,stack[t63]
mov eax,0
add eax,p
add eax,1
mov t65,eax
mov eax,0
mov t66,stack[t65]
mov eax,0
add eax,p
add eax,4
mov t67,eax
mov eax,0
mov eax,0
add eax,t67
add eax,2
mov t68,eax
mov eax,0
mov stack[t68],t64
mov eax,0
add eax,p
add eax,4
mov t69,eax
mov eax,0
mov eax,0
add eax,t69
add eax,3
mov t70,eax
mov eax,0
mov stack[t70],t66
mov eax,0
add eax,p
add eax,3
mov t71,eax
mov eax,0
mov t72,stack[t71]
mov eax,0
add eax,p
add eax,4
mov t73,eax
mov eax,0
mov eax,0
add eax,t73
add eax,0
mov t74,eax
mov eax,0
mov stack[t74],t72
mov eax,0
add eax,p
add eax,4
mov p,eax
mov eax,0
call JV_operaciones_suma_Integer_Integer
mov eax,0
add eax,p
sub eax,4
mov p,eax
mov eax,0
jmp etFinal_0
et_13:
.IF(t62 == 2)
jmp et_14
.ENDIF
jmp et_15
et_14:
mov eax,0
add eax,p
add eax,0
mov t75,eax
mov eax,0
mov t76,stack[t75]
mov eax,0
add eax,p
add eax,1
mov t77,eax
mov eax,0
mov t78,stack[t77]
mov eax,0
add eax,p
add eax,4
mov t79,eax
mov eax,0
mov eax,0
add eax,t79
add eax,2
mov t80,eax
mov eax,0
mov stack[t80],t76
mov eax,0
add eax,p
add eax,4
mov t81,eax
mov eax,0
mov eax,0
add eax,t81
add eax,3
mov t82,eax
mov eax,0
mov stack[t82],t78
mov eax,0
add eax,p
add eax,3
mov t83,eax
mov eax,0
mov t84,stack[t83]
mov eax,0
add eax,p
add eax,4
mov t85,eax
mov eax,0
mov eax,0
add eax,t85
add eax,0
mov t86,eax
mov eax,0
mov stack[t86],t84
mov eax,0
add eax,p
add eax,4
mov p,eax
mov eax,0
call JV_operaciones_resta_Integer_Integer
mov eax,0
add eax,p
sub eax,4
mov p,eax
mov eax,0
jmp etFinal_0
et_15:
.IF(t62 == 3)
jmp et_16
.ENDIF
jmp et_17
et_16:
mov eax,0
add eax,p
add eax,0
mov t87,eax
mov eax,0
mov t88,stack[t87]
mov eax,0
add eax,p
add eax,1
mov t89,eax
mov eax,0
mov t90,stack[t89]
mov eax,0
add eax,p
add eax,4
mov t91,eax
mov eax,0
mov eax,0
add eax,t91
add eax,2
mov t92,eax
mov eax,0
mov stack[t92],t88
mov eax,0
add eax,p
add eax,4
mov t93,eax
mov eax,0
mov eax,0
add eax,t93
add eax,3
mov t94,eax
mov eax,0
mov stack[t94],t90
mov eax,0
add eax,p
add eax,3
mov t95,eax
mov eax,0
mov t96,stack[t95]
mov eax,0
add eax,p
add eax,4
mov t97,eax
mov eax,0
mov eax,0
add eax,t97
add eax,0
mov t98,eax
mov eax,0
mov stack[t98],t96
mov eax,0
add eax,p
add eax,4
mov p,eax
mov eax,0
call JV_operaciones_vereficar_Integer_Integer
mov eax,0
add eax,p
sub eax,4
mov p,eax
mov eax,0
jmp etFinal_0
et_17:
etFinal_0:
EXIT
main ENDP
JV_operaciones_vereficar_Integer_Integer proc
mov edx,offset mensaje100
call writestring
mov eax,0
add eax,p
add eax,0
mov t7,eax
mov eax,0
mov t8,stack[t7]
mov eax,0
add eax,t8
add eax,0
mov t9,eax
mov eax,0
mov t10,heap[t9]
mov edx,offset mensaje105
call writestring
mov edx,offset mensaje106
call writestring
mov eax,0
add eax,h
add eax,1
mov t11,eax
mov eax,0
mov heap[t11],0
etFor_1:
mov eax,0
add eax,p
add eax,0
mov t12,eax
mov eax,0
mov t13,stack[t12]
mov eax,0
add eax,t13
add eax,1
mov t14,eax
mov eax,0
mov t15,heap[t14]
mov eax,0
add eax,p
add eax,0
mov t16,eax
mov eax,0
mov t17,stack[t16]
mov eax,0
add eax,t17
add eax,1
mov t18,eax
mov eax,0
mov t19,heap[t18]
.IF(t15 < 10)
jmp et_2
.ENDIF
jmp et_3
et_2:
mov eax,0
add eax,p
add eax,0
mov t21,eax
mov eax,0
mov t22,stack[t21]
mov eax,0
add eax,t22
add eax,1
mov t23,eax
mov eax,0
mov t24,heap[t23]
mov edx,offset mensaje125
call writestring
mov edx,offset mensaje126
call writestring
mov eax,0
add eax,t19
add eax,1
mov t20,eax
mov eax,0
mov eax,0
add eax,p
add eax,0
mov t25,eax
mov eax,0
mov t26,stack[t25]
mov eax,0
add eax,t26
add eax,1
mov t27,eax
mov eax,0
mov heap[t27],t20
jmp etFor_1
et_3:
etFin_1:
ret
JV_operaciones_vereficar_Integer_Integer endp
JV_operaciones_suma_Integer_Integer proc
mov edx,offset mensaje137
call writestring
mov edx,offset mensaje138
call writestring
call readdec
mov t28,eax
mov eax,0
add eax,p
add eax,4
mov t29,eax
mov eax,0
mov stack[t29],t28
mov eax,0
add eax,p
add eax,4
mov t30,eax
mov eax,0
mov t31,stack[t30]
.IF(t31 == 1)
jmp et_4
.ENDIF
jmp et_5
et_4:
mov edx,offset mensaje147
call writestring
mov edx,offset mensaje148
call writestring
jmp etFinal_0
et_5:
.IF(t31 == 2)
jmp et_6
.ENDIF
jmp et_7
et_6:
mov edx,offset mensaje154
call writestring
mov edx,offset mensaje155
call writestring
jmp etFinal_0
et_7:
.IF(t31 == 3)
jmp et_8
.ENDIF
jmp et_9
et_8:
mov eax,0
add eax,p
add eax,2
mov t32,eax
mov eax,0
mov t33,stack[t32]
mov eax,0
add eax,p
add eax,3
mov t34,eax
mov eax,0
mov t35,stack[t34]
mov eax,0
add eax,t33
add eax,t35
mov t36,eax
mov eax,0
mov eax,0
add eax,p
add eax,5
mov t37,eax
mov eax,0
mov stack[t37],t36
mov edx,offset mensaje168
call writestring
mov eax,0
add eax,p
add eax,5
mov t38,eax
mov eax,0
mov t39,stack[t38]
mov edx,offset mensaje171
call writestring
mov edx,offset mensaje172
call writestring
jmp etFinal_0
et_9:
mov edx,offset mensaje175
call writestring
mov edx,offset mensaje176
call writestring
etFinal_0:
ret
JV_operaciones_suma_Integer_Integer endp
JV_operaciones_resta_Integer_Integer proc
mov eax,0
add eax,p
add eax,2
mov t40,eax
mov eax,0
mov t41,stack[t40]
mov eax,0
add eax,p
add eax,3
mov t42,eax
mov eax,0
mov t43,stack[t42]
mov eax,0
add eax,t41
sub eax,t43
mov t44,eax
mov eax,0
mov eax,0
add eax,p
add eax,4
mov t45,eax
mov eax,0
mov stack[t45],t44
mov edx,offset mensaje187
call writestring
mov eax,0
add eax,p
add eax,4
mov t46,eax
mov eax,0
mov t47,stack[t46]
mov edx,offset mensaje190
call writestring
mov edx,offset mensaje191
call writestring
ret
JV_operaciones_resta_Integer_Integer endp
JV_operaciones_operaciones proc
mov eax,0
add eax,p
add eax,0
mov t48,eax
mov eax,0
mov stack[t48],h
mov eax,0
add eax,h
add eax,2
mov h,eax
mov eax,0
mov eax,0
add eax,p
add eax,0
mov t1,eax
mov eax,0
mov t2,stack[t1]
mov eax,0
add eax,t2
add eax,0
mov t3,eax
mov eax,0
mov heap[t3],12
mov eax,0
add eax,p
add eax,0
mov t4,eax
mov eax,0
mov t5,stack[t4]
mov eax,0
add eax,t5
add eax,1
mov t6,eax
mov eax,0
mov heap[t6],0
ret
JV_operaciones_operaciones endp
END main