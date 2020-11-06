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
t101 DWORD 0
t102 DWORD 0
mensaje104 BYTE " valor de global1 :",0
mensaje109 BYTE t7,0
mensaje110 BYTE "\n",0
mensaje131 BYTE " estoy alcanzando a",0
mensaje134 BYTE t21,0
mensaje135 BYTE "",0
mensaje138 BYTE t23,0
mensaje139 BYTE "\n",0
mensaje143 BYTE " ya lo alcanze",0
mensaje144 BYTE "\n",0
mensaje160 BYTE " estoy alcanzando a",0
mensaje163 BYTE t33,0
mensaje164 BYTE "",0
mensaje167 BYTE t35,0
mensaje168 BYTE "\n",0
mensaje183 BYTE " El resultado de la suma :",0
mensaje186 BYTE t43,0
mensaje187 BYTE "\n",0
mensaje197 BYTE " El resultado de la resta es :",0
mensaje200 BYTE t51,0
mensaje201 BYTE "\n",0
mensaje215 BYTE " Opciones :",0
mensaje216 BYTE "\n",0
mensaje217 BYTE " 1 . Sumar :",0
mensaje218 BYTE "\n",0
mensaje219 BYTE " 2 . Restar :",0
mensaje220 BYTE "\n",0
mensaje221 BYTE " 3 . Alcanzar :",0
mensaje222 BYTE "\n",0
mensaje223 BYTE " Ingrese primer numero :",0
mensaje224 BYTE "\n",0
mensaje228 BYTE " Ingrese segundo numero :",0
mensaje229 BYTE "\n",0
mensaje241 BYTE " Ingrese numero menu :",0
mensaje242 BYTE "\n",0
.code
main proc
mov p,0
mov h,0
mov edx,offset mensaje215
call writestringmov edx,offset mensaje216
call writestringmov edx,offset mensaje217
call writestringmov edx,offset mensaje218
call writestringmov edx,offset mensaje219
call writestringmov edx,offset mensaje220
call writestringmov edx,offset mensaje221
call writestringmov edx,offset mensaje222
call writestringmov edx,offset mensaje223
call writestringmov edx,offset mensaje224
call writestringcall readdec
mov t55,eax
mov eax,0
add eax,p
add eax,0
mov t56,eax
mov eax,0
mov stack[t56],t55
mov edx,offset mensaje228
call writestringmov edx,offset mensaje229
call writestringcall readdec
mov t57,eax
mov eax,0
add eax,p
add eax,1
mov t58,eax
mov eax,0
mov stack[t58],t57
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
mov t59,eax
mov eax,0
mov eax,0
add eax,t59
add eax,0
mov t60,eax
mov eax,0
mov t61,stack[t60]
mov eax,0
add eax,p
add eax,3
mov t62,eax
mov eax,0
mov stack[t62],t61
mov edx,offset mensaje241
call writestringmov edx,offset mensaje242
call writestringcall readdec
mov t63,eax
mov eax,0
add eax,p
add eax,2
mov t64,eax
mov eax,0
mov stack[t64],t63
mov eax,0
add eax,p
add eax,2
mov t65,eax
mov eax,0
mov t66,stack[t65]
.IF(t66 == 1)
jmp et_10
.ENDIF
jmp et_11
et_10:
mov eax,0
add eax,p
add eax,0
mov t67,eax
mov eax,0
mov t68,stack[t67]
mov eax,0
add eax,p
add eax,1
mov t69,eax
mov eax,0
mov t70,stack[t69]
mov eax,0
add eax,p
add eax,4
mov t71,eax
mov eax,0
mov eax,0
add eax,t71
add eax,2
mov t72,eax
mov eax,0
mov stack[t72],t68
mov eax,0
add eax,p
add eax,4
mov t73,eax
mov eax,0
mov eax,0
add eax,t73
add eax,3
mov t74,eax
mov eax,0
mov stack[t74],t70
mov eax,0
add eax,p
add eax,3
mov t75,eax
mov eax,0
mov t76,stack[t75]
mov eax,0
add eax,p
add eax,4
mov t77,eax
mov eax,0
mov eax,0
add eax,t77
add eax,0
mov t78,eax
mov eax,0
mov stack[t78],t76
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
et_11:
.IF(t66 == 2)
jmp et_12
.ENDIF
jmp et_13
et_12:
mov eax,0
add eax,p
add eax,0
mov t79,eax
mov eax,0
mov t80,stack[t79]
mov eax,0
add eax,p
add eax,1
mov t81,eax
mov eax,0
mov t82,stack[t81]
mov eax,0
add eax,p
add eax,4
mov t83,eax
mov eax,0
mov eax,0
add eax,t83
add eax,2
mov t84,eax
mov eax,0
mov stack[t84],t80
mov eax,0
add eax,p
add eax,4
mov t85,eax
mov eax,0
mov eax,0
add eax,t85
add eax,3
mov t86,eax
mov eax,0
mov stack[t86],t82
mov eax,0
add eax,p
add eax,3
mov t87,eax
mov eax,0
mov t88,stack[t87]
mov eax,0
add eax,p
add eax,4
mov t89,eax
mov eax,0
mov eax,0
add eax,t89
add eax,0
mov t90,eax
mov eax,0
mov stack[t90],t88
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
et_13:
.IF(t66 == 3)
jmp et_14
.ENDIF
jmp et_15
et_14:
mov eax,0
add eax,p
add eax,0
mov t91,eax
mov eax,0
mov t92,stack[t91]
mov eax,0
add eax,p
add eax,1
mov t93,eax
mov eax,0
mov t94,stack[t93]
mov eax,0
add eax,p
add eax,4
mov t95,eax
mov eax,0
mov eax,0
add eax,t95
add eax,2
mov t96,eax
mov eax,0
mov stack[t96],t92
mov eax,0
add eax,p
add eax,4
mov t97,eax
mov eax,0
mov eax,0
add eax,t97
add eax,3
mov t98,eax
mov eax,0
mov stack[t98],t94
mov eax,0
add eax,p
add eax,3
mov t99,eax
mov eax,0
mov t100,stack[t99]
mov eax,0
add eax,p
add eax,4
mov t101,eax
mov eax,0
mov eax,0
add eax,t101
add eax,0
mov t102,eax
mov eax,0
mov stack[t102],t100
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
et_15:
etFinal_0:
EXIT
main ENDP
JV_operaciones_vereficar_Integer_Integer proc
mov edx,offset mensaje104
call writestringmov eax,0
add eax,p
add eax,0
mov t4,eax
mov eax,0
mov t5,stack[t4]
mov eax,0
add eax,t5
add eax,0
mov t6,eax
mov eax,0
mov t7,heap[t6]
mov edx,offset mensaje109
call writestringmov edx,offset mensaje110
call writestringmov eax,0
add eax,p
add eax,2
mov t8,eax
mov eax,0
mov t9,stack[t8]
mov eax,0
add eax,p
add eax,3
mov t10,eax
mov eax,0
mov t11,stack[t10]
.IF(t9 < t11)
jmp et_2
.ENDIF
jmp et_3
et_2:
etWhile_1:
mov eax,0
add eax,p
add eax,3
mov t12,eax
mov eax,0
mov t13,stack[t12]
mov eax,0
add eax,p
add eax,2
mov t14,eax
mov eax,0
mov t15,stack[t14]
.IF(t13 > t15)
jmp et_4
.ENDIF
jmp et_5
et_4:
mov eax,0
add eax,p
add eax,2
mov t16,eax
mov eax,0
mov t17,stack[t16]
mov eax,0
add eax,t17
add eax,1
mov t18,eax
mov eax,0
mov eax,0
add eax,p
add eax,2
mov t19,eax
mov eax,0
mov stack[t19],t18
mov edx,offset mensaje131
call writestringmov eax,0
add eax,p
add eax,3
mov t20,eax
mov eax,0
mov t21,stack[t20]
mov edx,offset mensaje134
call writestringmov edx,offset mensaje135
call writestringmov eax,0
add eax,p
add eax,2
mov t22,eax
mov eax,0
mov t23,stack[t22]
mov edx,offset mensaje138
call writestringmov edx,offset mensaje139
call writestringjmp etWhile_1
et_5:
etFin_1:
mov edx,offset mensaje143
call writestringmov edx,offset mensaje144
call writestringjmp etFin_2
et_3:
etWhile_2:
mov eax,0
add eax,p
add eax,2
mov t24,eax
mov eax,0
mov t25,stack[t24]
mov eax,0
add eax,p
add eax,3
mov t26,eax
mov eax,0
mov t27,stack[t26]
.IF(t25 > t27)
jmp et_6
.ENDIF
jmp et_7
et_6:
mov eax,0
add eax,p
add eax,3
mov t28,eax
mov eax,0
mov t29,stack[t28]
mov eax,0
add eax,t29
add eax,1
mov t30,eax
mov eax,0
mov eax,0
add eax,p
add eax,3
mov t31,eax
mov eax,0
mov stack[t31],t30
mov edx,offset mensaje160
call writestringmov eax,0
add eax,p
add eax,2
mov t32,eax
mov eax,0
mov t33,stack[t32]
mov edx,offset mensaje163
call writestringmov edx,offset mensaje164
call writestringmov eax,0
add eax,p
add eax,3
mov t34,eax
mov eax,0
mov t35,stack[t34]
mov edx,offset mensaje167
call writestringmov edx,offset mensaje168
call writestringjmp etWhile_2
et_7:
etFin_2:
jmp etFin_3
etFin_3:
ret
JV_operaciones_vereficar_Integer_Integer endp
JV_operaciones_suma_Integer_Integer proc
mov eax,0
add eax,p
add eax,2
mov t36,eax
mov eax,0
mov t37,stack[t36]
mov eax,0
add eax,p
add eax,3
mov t38,eax
mov eax,0
mov t39,stack[t38]
mov eax,0
add eax,t37
add eax,t39
mov t40,eax
mov eax,0
mov eax,0
add eax,p
add eax,4
mov t41,eax
mov eax,0
mov stack[t41],t40
mov edx,offset mensaje183
call writestringmov eax,0
add eax,p
add eax,4
mov t42,eax
mov eax,0
mov t43,stack[t42]
mov edx,offset mensaje186
call writestringmov edx,offset mensaje187
call writestringret
JV_operaciones_suma_Integer_Integer endp
JV_operaciones_resta_Integer_Integer proc
mov eax,0
add eax,p
add eax,2
mov t44,eax
mov eax,0
mov t45,stack[t44]
mov eax,0
add eax,p
add eax,3
mov t46,eax
mov eax,0
mov t47,stack[t46]
mov eax,0
add eax,t45
sub eax,t47
mov t48,eax
mov eax,0
mov eax,0
add eax,p
add eax,4
mov t49,eax
mov eax,0
mov stack[t49],t48
mov edx,offset mensaje197
call writestringmov eax,0
add eax,p
add eax,4
mov t50,eax
mov eax,0
mov t51,stack[t50]
mov edx,offset mensaje200
call writestringmov edx,offset mensaje201
call writestringret
JV_operaciones_resta_Integer_Integer endp
JV_operaciones_operaciones proc
mov eax,0
add eax,p
add eax,0
mov t52,eax
mov eax,0
mov stack[t52],h
mov eax,0
add eax,h
add eax,1
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
ret
JV_operaciones_operaciones endp
END main