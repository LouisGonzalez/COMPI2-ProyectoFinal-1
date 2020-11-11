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
t103 DWORD 0
t104 DWORD 0
t105 DWORD 0
t106 DWORD 0
t107 DWORD 0
t108 DWORD 0
t109 DWORD 0
t110 DWORD 0
t111 DWORD 0
t112 DWORD 0
t113 DWORD 0
t114 DWORD 0
t115 DWORD 0
t116 DWORD 0
t117 DWORD 0
t118 DWORD 0
t119 DWORD 0
t120 DWORD 0
t121 DWORD 0
t122 DWORD 0
t123 DWORD 0
t124 DWORD 0
t125 DWORD 0
t126 DWORD 0
t127 DWORD 0
t128 DWORD 0
t129 DWORD 0
t130 DWORD 0
t131 DWORD 0
t132 DWORD 0
t133 DWORD 0
t134 DWORD 0
t135 DWORD 0
t136 DWORD 0
t137 DWORD 0
t138 DWORD 0
t139 DWORD 0
t140 DWORD 0
mensaje142 BYTE " Ingrese primer numero :",0
mensaje143 BYTE "\n",0
mensaje147 BYTE " Ingrese segundo numero :",0
mensaje148 BYTE "\n",0
mensaje186 BYTE " Ingrese primer numero :",0
mensaje187 BYTE "\n",0
mensaje191 BYTE " Ingrese segundo numero :",0
mensaje192 BYTE "\n",0
mensaje214 BYTE " la suma es :",0
mensaje217 BYTE t43,0
mensaje218 BYTE "\n",0
mensaje268 BYTE t74,0
mensaje269 BYTE "",0
mensaje270 BYTE "\n",0
mensaje271 BYTE "",0
mensaje272 BYTE "\n",0
mensaje294 BYTE " Ingrese primer numero :",0
mensaje295 BYTE "\n",0
mensaje299 BYTE " Ingrese segundo numero :",0
mensaje300 BYTE "\n",0
mensaje327 BYTE " El resultado de la suma es :",0
mensaje330 BYTE t106,0
mensaje331 BYTE "\n",0
mensaje357 BYTE " hola mundo",0
mensaje360 BYTE t123,0
mensaje361 BYTE "\n",0
mensaje369 BYTE " fin metodo",0
mensaje370 BYTE "\n",0
mensaje388 BYTE " fin metodo",0
mensaje389 BYTE "\n",0
mensaje408 BYTE " el valor es :",0
mensaje411 BYTE t140,0
mensaje412 BYTE "\n",0
.code
main proc
mov p,0
mov h,0
mov eax,0
add eax,p
add eax,3
mov t131,eax
mov eax,0
mov eax,0
add eax,t131
add eax,1
mov t132,eax
mov eax,0
mov stack[t132],156
mov eax,0
add eax,p
add eax,3
mov t133,eax
mov eax,0
mov eax,0
add eax,t133
add eax,2
mov t134,eax
mov eax,0
mov stack[t134],43
mov eax,0
add eax,p
add eax,3
mov p,eax
mov eax,0
call PY_otraPrueba
mov eax,0
add eax,p
sub eax,3
mov p,eax
mov eax,0
mov eax,0
add eax,p
add eax,3
mov t135,eax
mov eax,0
mov eax,0
add eax,t135
add eax,0
mov t136,eax
mov eax,0
mov t137,stack[t136]
mov eax,0
add eax,p
add eax,2
mov t138,eax
mov eax,0
mov stack[t138],t137
mov edx,offset mensaje408
call writestring
mov eax,0
add eax,p
add eax,2
mov t139,eax
mov eax,0
mov t140,stack[t139]
mov edx,offset mensaje411
call writestring
mov edx,offset mensaje412
call writestring
EXIT
main ENDP
VB_pruebaForVb proc
mov edx,offset mensaje142
call writestring
mov edx,offset mensaje143
call writestring
call readdec
mov t1,eax
mov eax,0
add eax,p
add eax,1
mov t2,eax
mov eax,0
mov stack[t2],t1
mov edx,offset mensaje147
call writestring
mov edx,offset mensaje148
call writestring
call readdec
mov t3,eax
mov eax,0
add eax,p
add eax,2
mov t4,eax
mov eax,0
mov stack[t4],t3
mov eax,0
add eax,p
add eax,1
mov t5,eax
mov eax,0
mov t6,stack[t5]
mov eax,0
add eax,p
add eax,2
mov t7,eax
mov eax,0
mov t8,stack[t7]
.IF(t6 > t8)
jmp et_1
.ENDIF
jmp et_2
et_1:
mov eax,0
add eax,p
add eax,1
mov t9,eax
mov eax,0
mov t10,stack[t9]
mov eax,0
add eax,p
add eax,0
mov t11,eax
mov eax,0
mov stack[t11],t10
jmp etFin_0
et_2:
mov eax,0
add eax,p
add eax,2
mov t12,eax
mov eax,0
mov t13,stack[t12]
mov eax,0
add eax,p
add eax,0
mov t14,eax
mov eax,0
mov stack[t14],t13
jmp etFin_0
etFin_0:
ret
VB_pruebaForVb endp
VB_suma_Integer_Integer proc
mov eax,0
add eax,p
add eax,1
mov t16,eax
mov eax,0
mov t17,stack[t16]
mov eax,0
add eax,p
add eax,2
mov t18,eax
mov eax,0
mov t19,stack[t18]
mov eax,0
add eax,t17
add eax,t19
mov t20,eax
mov eax,0
mov eax,0
add eax,p
add eax,3
mov t21,eax
mov eax,0
mov stack[t21],t20
mov eax,0
add eax,p
add eax,3
mov t22,eax
mov eax,0
mov t23,stack[t22]
mov eax,0
add eax,p
add eax,0
mov t24,eax
mov eax,0
mov stack[t24],t23
ret
VB_suma_Integer_Integer endp
VB_llamarSuma proc
mov edx,offset mensaje186
call writestring
mov edx,offset mensaje187
call writestring
call readdec
mov t26,eax
mov eax,0
add eax,p
add eax,2
mov t27,eax
mov eax,0
mov stack[t27],t26
mov edx,offset mensaje191
call writestring
mov edx,offset mensaje192
call writestring
call readdec
mov t28,eax
mov eax,0
add eax,p
add eax,3
mov t29,eax
mov eax,0
mov stack[t29],t28
mov eax,0
add eax,p
add eax,2
mov t30,eax
mov eax,0
mov t31,stack[t30]
mov eax,0
add eax,p
add eax,3
mov t32,eax
mov eax,0
mov t33,stack[t32]
mov eax,0
add eax,p
add eax,4
mov t34,eax
mov eax,0
mov eax,0
add eax,t34
add eax,1
mov t35,eax
mov eax,0
mov stack[t35],t31
mov eax,0
add eax,p
add eax,4
mov t36,eax
mov eax,0
mov eax,0
add eax,t36
add eax,2
mov t37,eax
mov eax,0
mov stack[t37],t33
mov eax,0
add eax,p
add eax,4
mov p,eax
mov eax,0
call VB_suma_Integer_Integer
mov eax,0
add eax,p
sub eax,4
mov p,eax
mov eax,0
mov eax,0
add eax,p
add eax,4
mov t38,eax
mov eax,0
mov eax,0
add eax,t38
add eax,0
mov t39,eax
mov eax,0
mov t40,stack[t39]
mov eax,0
add eax,p
add eax,1
mov t41,eax
mov eax,0
mov stack[t41],t40
mov edx,offset mensaje214
call writestring
mov eax,0
add eax,p
add eax,1
mov t42,eax
mov eax,0
mov t43,stack[t42]
mov edx,offset mensaje217
call writestring
mov edx,offset mensaje218
call writestring
ret
VB_llamarSuma endp
JV_clase_mostrar_Integer_Integer proc
mov eax,0
add eax,p
add eax,4
mov t45,eax
mov eax,0
mov stack[t45],0
mov eax,0
add eax,p
add eax,5
mov t46,eax
mov eax,0
mov stack[t46],0
mov eax,0
add eax,p
add eax,2
mov t47,eax
mov eax,0
mov t48,stack[t47]
mov eax,0
add eax,p
add eax,3
mov t49,eax
mov eax,0
mov t50,stack[t49]
.IF(t48 > t50)
jmp et_4
.ENDIF
jmp et_5
et_4:
mov eax,0
add eax,p
add eax,2
mov t51,eax
mov eax,0
mov t52,stack[t51]
mov eax,0
add eax,p
add eax,4
mov t53,eax
mov eax,0
mov stack[t53],t52
mov eax,0
add eax,p
add eax,3
mov t54,eax
mov eax,0
mov t55,stack[t54]
mov eax,0
add eax,p
add eax,5
mov t56,eax
mov eax,0
mov stack[t56],t55
jmp etFin_2
et_5:
mov eax,0
add eax,p
add eax,3
mov t57,eax
mov eax,0
mov t58,stack[t57]
mov eax,0
add eax,p
add eax,4
mov t59,eax
mov eax,0
mov stack[t59],t58
mov eax,0
add eax,p
add eax,2
mov t60,eax
mov eax,0
mov t61,stack[t60]
mov eax,0
add eax,p
add eax,5
mov t62,eax
mov eax,0
mov stack[t62],t61
jmp etFin_2
etFin_2:
mov eax,0
add eax,p
add eax,5
mov t63,eax
mov eax,0
mov t64,stack[t63]
mov eax,0
add eax,p
add eax,6
mov t65,eax
mov eax,0
mov stack[t65],t64
etFor_1:
mov eax,0
add eax,p
add eax,6
mov t66,eax
mov eax,0
mov t67,stack[t66]
mov eax,0
add eax,p
add eax,4
mov t68,eax
mov eax,0
mov t69,stack[t68]
mov eax,0
add eax,p
add eax,6
mov t70,eax
mov eax,0
mov t71,stack[t70]
.IF(t67 <= t69)
jmp et_6
.ENDIF
jmp et_7
et_6:
mov eax,0
add eax,p
add eax,6
mov t73,eax
mov eax,0
mov t74,stack[t73]
mov edx,offset mensaje268
call writestring
mov edx,offset mensaje269
call writestring
mov edx,offset mensaje270
call writestring
mov edx,offset mensaje271
call writestring
mov edx,offset mensaje272
call writestring
mov eax,0
add eax,t71
add eax,1
mov t72,eax
mov eax,0
mov eax,0
add eax,p
add eax,6
mov t75,eax
mov eax,0
mov stack[t75],t72
jmp etFor_1
et_7:
etFin_3:
ret
JV_clase_mostrar_Integer_Integer endp
JV_clase_suma_Integer_Integer proc
mov eax,0
add eax,p
add eax,2
mov t76,eax
mov eax,0
mov t77,stack[t76]
mov eax,0
add eax,p
add eax,3
mov t78,eax
mov eax,0
mov t79,stack[t78]
mov eax,0
add eax,t77
add eax,t79
mov t80,eax
mov eax,0
mov eax,0
add eax,p
add eax,4
mov t81,eax
mov eax,0
mov stack[t81],t80
mov eax,0
add eax,p
add eax,4
mov t82,eax
mov eax,0
mov t83,stack[t82]
mov eax,0
add eax,p
add eax,1
mov t84,eax
mov eax,0
mov stack[t84],t83
ret
JV_clase_suma_Integer_Integer endp
JV_clase_llamarSuma proc
mov edx,offset mensaje294
call writestring
mov edx,offset mensaje295
call writestring
call readdec
mov t85,eax
mov eax,0
add eax,p
add eax,2
mov t86,eax
mov eax,0
mov stack[t86],t85
mov edx,offset mensaje299
call writestring
mov edx,offset mensaje300
call writestring
call readdec
mov t87,eax
mov eax,0
add eax,p
add eax,3
mov t88,eax
mov eax,0
mov stack[t88],t87
mov eax,0
add eax,p
add eax,2
mov t89,eax
mov eax,0
mov t90,stack[t89]
mov eax,0
add eax,p
add eax,3
mov t91,eax
mov eax,0
mov t92,stack[t91]
mov eax,0
add eax,p
add eax,3
mov t93,eax
mov eax,0
mov eax,0
add eax,t93
add eax,2
mov t94,eax
mov eax,0
mov stack[t94],t90
mov eax,0
add eax,p
add eax,3
mov t95,eax
mov eax,0
mov eax,0
add eax,t95
add eax,3
mov t96,eax
mov eax,0
mov stack[t96],t92
mov eax,0
add eax,p
add eax,0
mov t97,eax
mov eax,0
mov t98,stack[t97]
mov eax,0
add eax,p
add eax,3
mov t99,eax
mov eax,0
mov eax,0
add eax,t99
add eax,0
mov t100,eax
mov eax,0
mov stack[t100],t98
mov eax,0
add eax,p
add eax,3
mov p,eax
mov eax,0
call JV_clase_suma_Integer_Integer
mov eax,0
add eax,p
sub eax,3
mov p,eax
mov eax,0
mov eax,0
add eax,p
add eax,3
mov t101,eax
mov eax,0
mov eax,0
add eax,t101
add eax,1
mov t102,eax
mov eax,0
mov t103,stack[t102]
mov eax,0
add eax,p
add eax,4
mov t104,eax
mov eax,0
mov stack[t104],t103
mov edx,offset mensaje327
call writestring
mov eax,0
add eax,p
add eax,4
mov t105,eax
mov eax,0
mov t106,stack[t105]
mov edx,offset mensaje330
call writestring
mov edx,offset mensaje331
call writestring
ret
JV_clase_llamarSuma endp
JV_clase_clase proc
mov eax,0
add eax,p
add eax,0
mov t107,eax
mov eax,0
mov stack[t107],h
mov eax,0
add eax,h
add eax,0
mov h,eax
mov eax,0
ret
JV_clase_clase endp
PY_pruebaFor proc
mov eax,0
add eax,p
add eax,1
mov t109,eax
mov eax,0
mov stack[t109],5
mov eax,0
add eax,p
add eax,2
mov t110,eax
mov eax,0
mov stack[t110],20
mov eax,0
add eax,p
add eax,3
mov t111,eax
mov eax,0
mov stack[t111],2
mov eax,0
add eax,p
add eax,1
mov t112,eax
mov eax,0
mov t113,stack[t112]
mov eax,0
add eax,p
add eax,2
mov t114,eax
mov eax,0
mov t115,stack[t114]
mov eax,0
add eax,p
add eax,4
mov t119,eax
mov eax,0
mov stack[t119],t113
etFor_3:
mov eax,0
add eax,p
add eax,4
mov t120,eax
mov eax,0
mov t121,stack[t120]
.IF(t121 <= t115)
jmp et_9
.ENDIF
jmp et_10
et_9:
mov edx,offset mensaje357
call writestring
mov eax,0
add eax,p
add eax,4
mov t122,eax
mov eax,0
mov t123,stack[t122]
mov edx,offset mensaje360
call writestring
mov edx,offset mensaje361
call writestring
mov eax,0
add eax,p
add eax,3
mov t116,eax
mov eax,0
mov eax,0
add eax,p
add eax,4
mov t117,eax
mov eax,0
mov eax,0
add eax,stack[(int) t117]
add eax,stack[(int) t116]
mov t118,eax
mov eax,0
mov stack[t117],t118
jmp etFor_3
et_10:
etFin_5:
mov edx,offset mensaje369
call writestring
mov edx,offset mensaje370
call writestring
ret
PY_pruebaFor endp
PY_otraPrueba proc
mov eax,0
add eax,p
add eax,1
mov t124,eax
mov eax,0
mov t125,stack[t124]
mov eax,0
add eax,p
add eax,2
mov t126,eax
mov eax,0
mov t127,stack[t126]
.IF(t125 > t127)
jmp et_10
.ENDIF
jmp et_11
et_10:
mov eax,0
add eax,p
add eax,0
mov t128,eax
mov eax,0
mov stack[t128],23
jmp etFin_6
et_11:
mov eax,0
add eax,p
add eax,0
mov t129,eax
mov eax,0
mov stack[t129],12
jmp etFin_6
etFin_6:
mov edx,offset mensaje388
call writestring
mov edx,offset mensaje389
call writestring
ret
PY_otraPrueba endp
END main