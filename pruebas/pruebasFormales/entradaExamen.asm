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
t141 DWORD 0
t142 DWORD 0
t143 DWORD 0
t144 DWORD 0
t145 DWORD 0
t146 DWORD 0
t147 DWORD 0
t148 DWORD 0
t149 DWORD 0
t150 DWORD 0
t151 DWORD 0
t152 DWORD 0
t153 DWORD 0
t154 DWORD 0
t155 DWORD 0
t156 DWORD 0
t157 DWORD 0
t158 DWORD 0
t159 DWORD 0
t160 DWORD 0
t161 DWORD 0
t162 DWORD 0
t163 DWORD 0
t164 DWORD 0
t165 DWORD 0
mensaje189 BYTE " Ingrese primer numero :",0
mensaje190 BYTE "\n",0
mensaje198 BYTE " Ingrese segundo numero :",0
mensaje199 BYTE "\n",0
mensaje209 BYTE " Ingrese operacion",0
mensaje210 BYTE "\n",0
mensaje327 BYTE " operacion incorrecta !",0
mensaje328 BYTE "\n",0
mensaje390 BYTE " el total es",0
mensaje391 BYTE "\n",0
mensaje406 BYTE t131,0
mensaje407 BYTE "\n",0
mensaje438 BYTE " el total es",0
mensaje439 BYTE "\n",0
mensaje454 BYTE t156,0
mensaje455 BYTE "\n",0
mensaje456 BYTE " el total es",0
mensaje457 BYTE "\n",0
mensaje472 BYTE t165,0
mensaje473 BYTE "\n",0
.code
main proc
mov p,0
mov h,0
mov eax,0
add eax,p
add eax,1
mov p,eax
mov eax,0
call JV_Calculadora_Calculadora
mov eax,0
add eax,p
sub eax,1
mov p,eax
mov eax,0
mov eax,0
add eax,p
add eax,1
mov t95,eax
mov eax,0
mov eax,0
add eax,t95
add eax,0
mov t96,eax
mov eax,0
mov t97,stack[t96]
mov eax,0
add eax,p
add eax,0
mov t98,eax
mov eax,0
mov stack[t98],t97
mov eax,0
add eax,p
add eax,2
mov p,eax
mov eax,0
call JV_Calculadora_Calculadora
mov eax,0
add eax,p
sub eax,2
mov p,eax
mov eax,0
mov eax,0
add eax,p
add eax,2
mov t99,eax
mov eax,0
mov eax,0
add eax,t99
add eax,0
mov t100,eax
mov eax,0
mov t101,stack[t100]
mov eax,0
add eax,p
add eax,1
mov t102,eax
mov eax,0
mov stack[t102],t101
mov eax,0
add eax,p
add eax,3
mov p,eax
mov eax,0
call JV_Calculadora_Calculadora
mov eax,0
add eax,p
sub eax,3
mov p,eax
mov eax,0
mov eax,0
add eax,p
add eax,3
mov t103,eax
mov eax,0
mov eax,0
add eax,t103
add eax,0
mov t104,eax
mov eax,0
mov t105,stack[t104]
mov eax,0
add eax,p
add eax,2
mov t106,eax
mov eax,0
mov stack[t106],t105
mov eax,0
add eax,p
add eax,3
mov t107,eax
mov eax,0
mov eax,0
add eax,t107
add eax,2
mov t108,eax
mov eax,0
mov stack[t108],1
mov eax,0
add eax,p
add eax,0
mov t109,eax
mov eax,0
mov t110,stack[t109]
mov eax,0
add eax,p
add eax,3
mov t111,eax
mov eax,0
mov eax,0
add eax,t111
add eax,0
mov t112,eax
mov eax,0
mov stack[t112],t110
mov eax,0
add eax,p
add eax,3
mov p,eax
mov eax,0
call JV_Calculadora_pedirOperador_Integer
mov eax,0
add eax,p
sub eax,3
mov p,eax
mov eax,0
mov eax,0
add eax,p
add eax,3
mov t113,eax
mov eax,0
mov eax,0
add eax,t113
add eax,2
mov t114,eax
mov eax,0
mov stack[t114],2
mov eax,0
add eax,p
add eax,0
mov t115,eax
mov eax,0
mov t116,stack[t115]
mov eax,0
add eax,p
add eax,3
mov t117,eax
mov eax,0
mov eax,0
add eax,t117
add eax,0
mov t118,eax
mov eax,0
mov stack[t118],t116
mov eax,0
add eax,p
add eax,3
mov p,eax
mov eax,0
call JV_Calculadora_pedirOperador_Integer
mov eax,0
add eax,p
sub eax,3
mov p,eax
mov eax,0
mov eax,0
add eax,p
add eax,0
mov t119,eax
mov eax,0
mov t120,stack[t119]
mov eax,0
add eax,p
add eax,3
mov t121,eax
mov eax,0
mov eax,0
add eax,t121
add eax,0
mov t122,eax
mov eax,0
mov stack[t122],t120
mov eax,0
add eax,p
add eax,3
mov p,eax
mov eax,0
call JV_Calculadora_pedirOperacion
mov eax,0
add eax,p
sub eax,3
mov p,eax
mov eax,0
mov edx,offset mensaje390
call writestring
mov edx,offset mensaje391
call writestring
mov eax,0
add eax,p
add eax,3
mov t123,eax
mov eax,0
mov eax,0
add eax,t123
add eax,2
mov t124,eax
mov eax,0
mov stack[t124],0
mov eax,0
add eax,p
add eax,0
mov t125,eax
mov eax,0
mov t126,stack[t125]
mov eax,0
add eax,p
add eax,3
mov t127,eax
mov eax,0
mov eax,0
add eax,t127
add eax,0
mov t128,eax
mov eax,0
mov stack[t128],t126
mov eax,0
add eax,p
add eax,3
mov p,eax
mov eax,0
call JV_Calculadora_operar_Integer
mov eax,0
add eax,p
sub eax,3
mov p,eax
mov eax,0
mov eax,0
add eax,p
add eax,3
mov t129,eax
mov eax,0
mov eax,0
add eax,t129
add eax,1
mov t130,eax
mov eax,0
mov t131,stack[t130]
mov edx,offset mensaje406
call writestring
mov edx,offset mensaje407
call writestring
mov eax,0
add eax,p
add eax,3
mov t132,eax
mov eax,0
mov eax,0
add eax,t132
add eax,2
mov t133,eax
mov eax,0
mov stack[t133],1
mov eax,0
add eax,p
add eax,1
mov t134,eax
mov eax,0
mov t135,stack[t134]
mov eax,0
add eax,p
add eax,3
mov t136,eax
mov eax,0
mov eax,0
add eax,t136
add eax,0
mov t137,eax
mov eax,0
mov stack[t137],t135
mov eax,0
add eax,p
add eax,3
mov p,eax
mov eax,0
call JV_Calculadora_pedirOperador_Integer
mov eax,0
add eax,p
sub eax,3
mov p,eax
mov eax,0
mov eax,0
add eax,p
add eax,3
mov t138,eax
mov eax,0
mov eax,0
add eax,t138
add eax,2
mov t139,eax
mov eax,0
mov stack[t139],2
mov eax,0
add eax,p
add eax,1
mov t140,eax
mov eax,0
mov t141,stack[t140]
mov eax,0
add eax,p
add eax,3
mov t142,eax
mov eax,0
mov eax,0
add eax,t142
add eax,0
mov t143,eax
mov eax,0
mov stack[t143],t141
mov eax,0
add eax,p
add eax,3
mov p,eax
mov eax,0
call JV_Calculadora_pedirOperador_Integer
mov eax,0
add eax,p
sub eax,3
mov p,eax
mov eax,0
mov eax,0
add eax,p
add eax,1
mov t144,eax
mov eax,0
mov t145,stack[t144]
mov eax,0
add eax,p
add eax,3
mov t146,eax
mov eax,0
mov eax,0
add eax,t146
add eax,0
mov t147,eax
mov eax,0
mov stack[t147],t145
mov eax,0
add eax,p
add eax,3
mov p,eax
mov eax,0
call JV_Calculadora_pedirOperacion
mov eax,0
add eax,p
sub eax,3
mov p,eax
mov eax,0
mov edx,offset mensaje438
call writestring
mov edx,offset mensaje439
call writestring
mov eax,0
add eax,p
add eax,3
mov t148,eax
mov eax,0
mov eax,0
add eax,t148
add eax,2
mov t149,eax
mov eax,0
mov stack[t149],0
mov eax,0
add eax,p
add eax,1
mov t150,eax
mov eax,0
mov t151,stack[t150]
mov eax,0
add eax,p
add eax,3
mov t152,eax
mov eax,0
mov eax,0
add eax,t152
add eax,0
mov t153,eax
mov eax,0
mov stack[t153],t151
mov eax,0
add eax,p
add eax,3
mov p,eax
mov eax,0
call JV_Calculadora_operar_Integer
mov eax,0
add eax,p
sub eax,3
mov p,eax
mov eax,0
mov eax,0
add eax,p
add eax,3
mov t154,eax
mov eax,0
mov eax,0
add eax,t154
add eax,1
mov t155,eax
mov eax,0
mov t156,stack[t155]
mov edx,offset mensaje454
call writestring
mov edx,offset mensaje455
call writestring
mov edx,offset mensaje456
call writestring
mov edx,offset mensaje457
call writestring
mov eax,0
add eax,p
add eax,3
mov t157,eax
mov eax,0
mov eax,0
add eax,t157
add eax,2
mov t158,eax
mov eax,0
mov stack[t158],0
mov eax,0
add eax,p
add eax,2
mov t159,eax
mov eax,0
mov t160,stack[t159]
mov eax,0
add eax,p
add eax,3
mov t161,eax
mov eax,0
mov eax,0
add eax,t161
add eax,0
mov t162,eax
mov eax,0
mov stack[t162],t160
mov eax,0
add eax,p
add eax,3
mov p,eax
mov eax,0
call JV_Calculadora_operar_Integer
mov eax,0
add eax,p
sub eax,3
mov p,eax
mov eax,0
mov eax,0
add eax,p
add eax,3
mov t163,eax
mov eax,0
mov eax,0
add eax,t163
add eax,1
mov t164,eax
mov eax,0
mov t165,stack[t164]
mov edx,offset mensaje472
call writestring
mov edx,offset mensaje473
call writestring
EXIT
main ENDP
JV_Calculadora_Calculadora proc
mov eax,0
add eax,p
add eax,0
mov t1,eax
mov eax,0
mov stack[t1],h
mov eax,0
add eax,h
add eax,3
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
mov heap[t4],1
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
mov heap[t7],1
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
mov heap[t10],3
ret
JV_Calculadora_Calculadora endp
JV_Calculadora_pedirOperador_Integer proc
mov eax,0
add eax,p
add eax,2
mov t11,eax
mov eax,0
mov t12,stack[t11]
.IF(t12 == 1)
jmp et_2
.ENDIF
jmp et_3
et_2:
mov edx,offset mensaje189
call writestring
mov edx,offset mensaje190
call writestring
call readdec
mov t13,eax
mov eax,0
add eax,p
add eax,0
mov t14,eax
mov eax,0
mov t15,stack[t14]
mov eax,0
add eax,t15
add eax,0
mov t16,eax
mov eax,0
mov heap[t16],t13
jmp etFin_1
et_3:
mov edx,offset mensaje198
call writestring
mov edx,offset mensaje199
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
add eax,1
mov t20,eax
mov eax,0
mov heap[t20],t17
jmp etFin_1
etFin_1:
ret
JV_Calculadora_pedirOperador_Integer endp
JV_Calculadora_pedirOperacion proc
mov edx,offset mensaje209
call writestring
mov edx,offset mensaje210
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
add eax,2
mov t24,eax
mov eax,0
mov heap[t24],t21
ret
JV_Calculadora_pedirOperacion endp
JV_Calculadora_sumar proc
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
add eax,2
mov t34,eax
mov eax,0
mov stack[t34],t33
mov eax,0
add eax,p
add eax,2
mov t35,eax
mov eax,0
mov t36,stack[t35]
mov eax,0
add eax,p
add eax,1
mov t37,eax
mov eax,0
mov stack[t37],t36
ret
JV_Calculadora_sumar endp
JV_Calculadora_restar proc
mov eax,0
add eax,p
add eax,0
mov t38,eax
mov eax,0
mov t39,stack[t38]
mov eax,0
add eax,t39
add eax,0
mov t40,eax
mov eax,0
mov t41,heap[t40]
mov eax,0
add eax,p
add eax,0
mov t42,eax
mov eax,0
mov t43,stack[t42]
mov eax,0
add eax,t43
add eax,1
mov t44,eax
mov eax,0
mov t45,heap[t44]
mov eax,0
add eax,t41
sub eax,t45
mov t46,eax
mov eax,0
mov eax,0
add eax,p
add eax,2
mov t47,eax
mov eax,0
mov stack[t47],t46
mov eax,0
add eax,p
add eax,2
mov t48,eax
mov eax,0
mov t49,stack[t48]
mov eax,0
add eax,p
add eax,1
mov t50,eax
mov eax,0
mov stack[t50],t49
ret
JV_Calculadora_restar endp
JV_Calculadora_potencia proc
mov eax,0
add eax,p
add eax,0
mov t51,eax
mov eax,0
mov t52,stack[t51]
mov eax,0
add eax,t52
add eax,0
mov t53,eax
mov eax,0
mov t54,heap[t53]
mov eax,0
add eax,p
add eax,0
mov t55,eax
mov eax,0
mov t56,stack[t55]
mov eax,0
add eax,t56
add eax,1
mov t57,eax
mov eax,0
mov t58,heap[t57]
mov eax,t54
mov ebx,t58
mul ebx
mov t59,eax
mov ebx,0
mov eax,0
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
mov eax,0
add eax,p
add eax,1
mov t63,eax
mov eax,0
mov stack[t63],t62
ret
JV_Calculadora_potencia endp
JV_Calculadora_operar_Integer proc
mov eax,0
add eax,p
add eax,0
mov t64,eax
mov eax,0
mov t65,stack[t64]
mov eax,0
add eax,t65
add eax,2
mov t66,eax
mov eax,0
mov t67,heap[t66]
.IF(t67 == 1)
jmp et_4
.ENDIF
jmp et_5
et_4:
mov eax,0
add eax,p
add eax,0
mov t68,eax
mov eax,0
mov t69,stack[t68]
mov eax,0
add eax,p
add eax,1
mov t70,eax
mov eax,0
mov eax,0
add eax,t70
add eax,0
mov t71,eax
mov eax,0
mov stack[t71],t69
mov eax,0
add eax,p
add eax,1
mov p,eax
mov eax,0
call JV_Calculadora_sumar
mov eax,0
add eax,p
sub eax,1
mov p,eax
mov eax,0
mov eax,0
add eax,p
add eax,1
mov t72,eax
mov eax,0
mov eax,0
add eax,t72
add eax,1
mov t73,eax
mov eax,0
mov t74,stack[t73]
mov eax,0
add eax,p
add eax,1
mov t75,eax
mov eax,0
mov stack[t75],t74
jmp etFinal_0
et_5:
.IF(t67 == 2)
jmp et_6
.ENDIF
jmp et_7
et_6:
mov eax,0
add eax,p
add eax,0
mov t76,eax
mov eax,0
mov t77,stack[t76]
mov eax,0
add eax,p
add eax,1
mov t78,eax
mov eax,0
mov eax,0
add eax,t78
add eax,0
mov t79,eax
mov eax,0
mov stack[t79],t77
mov eax,0
add eax,p
add eax,1
mov p,eax
mov eax,0
call JV_Calculadora_restar
mov eax,0
add eax,p
sub eax,1
mov p,eax
mov eax,0
mov eax,0
add eax,p
add eax,1
mov t80,eax
mov eax,0
mov eax,0
add eax,t80
add eax,1
mov t81,eax
mov eax,0
mov t82,stack[t81]
mov eax,0
add eax,p
add eax,1
mov t83,eax
mov eax,0
mov stack[t83],t82
jmp etFinal_0
et_7:
.IF(t67 == 3)
jmp et_8
.ENDIF
jmp et_9
et_8:
mov eax,0
add eax,p
add eax,0
mov t84,eax
mov eax,0
mov t85,stack[t84]
mov eax,0
add eax,p
add eax,1
mov t86,eax
mov eax,0
mov eax,0
add eax,t86
add eax,0
mov t87,eax
mov eax,0
mov stack[t87],t85
mov eax,0
add eax,p
add eax,1
mov p,eax
mov eax,0
call JV_Calculadora_potencia
mov eax,0
add eax,p
sub eax,1
mov p,eax
mov eax,0
mov eax,0
add eax,p
add eax,1
mov t88,eax
mov eax,0
mov eax,0
add eax,t88
add eax,1
mov t89,eax
mov eax,0
mov t90,stack[t89]
mov eax,0
add eax,p
add eax,1
mov t91,eax
mov eax,0
mov stack[t91],t90
jmp etFinal_0
et_9:
mov edx,offset mensaje327
call writestring
mov edx,offset mensaje328
call writestring
mov eax,0
add eax,p
add eax,1
mov t92,eax
mov eax,0
mov stack[t92],-1
etFinal_0:
ret
JV_Calculadora_operar_Integer endp
END main