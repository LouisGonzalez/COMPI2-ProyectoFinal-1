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
mensaje179 BYTE " Arreglo antes de ordenarse",0
mensaje180 BYTE "\n",0
mensaje188 BYTE " Arreglo depues de ordenarse",0
mensaje189 BYTE "\n",0
mensaje192 BYTE " default",0
mensaje193 BYTE "\n",0
mensaje196 BYTE " default2",0
mensaje197 BYTE "\n",0
mensaje200 BYTE " arreglo [",0
mensaje203 BYTE t15,0
mensaje204 BYTE " ] =",0
mensaje207 BYTE t17,0
mensaje208 BYTE "\n",0
mensaje438 BYTE " fin",0
mensaje439 BYTE "\n",0
mensaje440 BYTE "null",0
mensaje441 BYTE "\n",0
mensaje442 BYTE "\n",0
.code
main proc
mov p,0
mov h,0
mov eax,0
add eax,p
add eax,0
mov t19,eax
mov eax,0
mov stack[t19],10
mov eax,0
add eax,p
add eax,11
mov t20,eax
mov eax,0
mov stack[t20],0
mov eax,0
add eax,p
add eax,12
mov t21,eax
mov eax,0
mov stack[t21],0
mov t22,0
mov eax,0
add eax,1
add eax,t22
mov t23,eax
mov eax,0
mov eax,0
add eax,p
add eax,t23
mov t24,eax
mov eax,0
mov stack[t24],7
mov t25,1
mov eax,0
add eax,1
add eax,t25
mov t26,eax
mov eax,0
mov eax,0
add eax,p
add eax,t26
mov t27,eax
mov eax,0
mov stack[t27],14
mov t28,2
mov eax,0
add eax,1
add eax,t28
mov t29,eax
mov eax,0
mov eax,0
add eax,p
add eax,t29
mov t30,eax
mov eax,0
mov stack[t30],18
mov t31,3
mov eax,0
add eax,1
add eax,t31
mov t32,eax
mov eax,0
mov eax,0
add eax,p
add eax,t32
mov t33,eax
mov eax,0
mov stack[t33],19
mov t34,4
mov eax,0
add eax,1
add eax,t34
mov t35,eax
mov eax,0
mov eax,0
add eax,p
add eax,t35
mov t36,eax
mov eax,0
mov stack[t36],21
mov t37,5
mov eax,0
add eax,1
add eax,t37
mov t38,eax
mov eax,0
mov eax,0
add eax,p
add eax,t38
mov t39,eax
mov eax,0
mov stack[t39],2
mov t40,6
mov eax,0
add eax,1
add eax,t40
mov t41,eax
mov eax,0
mov eax,0
add eax,p
add eax,t41
mov t42,eax
mov eax,0
mov stack[t42],9
mov t43,7
mov eax,0
add eax,1
add eax,t43
mov t44,eax
mov eax,0
mov eax,0
add eax,p
add eax,t44
mov t45,eax
mov eax,0
mov stack[t45],24
mov t46,8
mov eax,0
add eax,1
add eax,t46
mov t47,eax
mov eax,0
mov eax,0
add eax,p
add eax,t47
mov t48,eax
mov eax,0
mov stack[t48],29
mov t49,9
mov eax,0
add eax,1
add eax,t49
mov t50,eax
mov eax,0
mov eax,0
add eax,p
add eax,t50
mov t51,eax
mov eax,0
mov stack[t51],47
mov eax,0
add eax,p
add eax,14
mov t52,eax
mov eax,0
mov eax,0
add eax,t52
add eax,1
mov t53,eax
mov eax,0
mov stack[t53],1
mov eax,0
add eax,p
add eax,14
mov p,eax
mov eax,0
call PY_Mensaje
mov eax,0
add eax,p
sub eax,14
mov p,eax
mov eax,0
mov eax,0
add eax,p
add eax,11
mov t54,eax
mov eax,0
mov stack[t54],0
etFor_3:
mov eax,0
add eax,p
add eax,11
mov t55,eax
mov eax,0
mov t56,stack[t55]
mov eax,0
add eax,p
add eax,0
mov t57,eax
mov eax,0
mov t58,stack[t57]
.IF(t56 < t58)
jmp et_8
.ENDIF
jmp et_9
et_8:
mov eax,0
add eax,p
add eax,11
mov t59,eax
mov eax,0
mov t60,stack[t59]
mov eax,0
add eax,p
add eax,11
mov t61,eax
mov eax,0
mov t62,stack[t61]
mov t63,t62
mov eax,0
add eax,t63
add eax,1
mov t64,eax
mov eax,0
mov eax,0
add eax,p
add eax,t64
mov t65,eax
mov eax,0
mov t66,stack[t65]
mov eax,0
add eax,p
add eax,14
mov t67,eax
mov eax,0
mov eax,0
add eax,t67
add eax,1
mov t68,eax
mov eax,0
mov stack[t68],t60
mov eax,0
add eax,p
add eax,14
mov t69,eax
mov eax,0
mov eax,0
add eax,t69
add eax,2
mov t70,eax
mov eax,0
mov stack[t70],t66
mov eax,0
add eax,p
add eax,14
mov p,eax
mov eax,0
call PY_Mostrar
mov eax,0
add eax,p
sub eax,14
mov p,eax
mov eax,0
mov eax,0
add eax,p
add eax,11
mov t71,eax
mov eax,0
mov t72,stack[t71]
mov eax,0
add eax,t72
add eax,1
mov t73,eax
mov eax,0
mov eax,0
add eax,p
add eax,11
mov t74,eax
mov eax,0
mov stack[t74],t73
jmp etFor_3
et_9:
etFin_4:
mov eax,0
add eax,p
add eax,11
mov t75,eax
mov eax,0
mov stack[t75],0
etWhile_3:
mov eax,0
add eax,p
add eax,11
mov t76,eax
mov eax,0
mov t77,stack[t76]
.IF(t77 < 9)
jmp et_10
.ENDIF
jmp et_11
et_10:
etWhile_4:
mov eax,0
add eax,p
add eax,12
mov t78,eax
mov eax,0
mov t79,stack[t78]
.IF(t79 < 9)
jmp et_12
.ENDIF
jmp et_13
et_12:
mov eax,0
add eax,p
add eax,12
mov t80,eax
mov eax,0
mov t81,stack[t80]
mov t82,t81
mov eax,0
add eax,t82
add eax,1
mov t83,eax
mov eax,0
mov eax,0
add eax,p
add eax,t83
mov t84,eax
mov eax,0
mov t85,stack[t84]
mov eax,0
add eax,p
add eax,12
mov t86,eax
mov eax,0
mov t87,stack[t86]
mov eax,0
add eax,t87
add eax,1
mov t88,eax
mov eax,0
mov t89,t88
mov eax,0
add eax,t89
add eax,1
mov t90,eax
mov eax,0
mov eax,0
add eax,p
add eax,t90
mov t91,eax
mov eax,0
mov t92,stack[t91]
.IF(t85 < t92)
jmp et_14
.ENDIF
jmp et_15
et_14:
mov eax,0
add eax,p
add eax,12
mov t93,eax
mov eax,0
mov t94,stack[t93]
mov t95,t94
mov eax,0
add eax,t95
add eax,1
mov t96,eax
mov eax,0
mov eax,0
add eax,p
add eax,t96
mov t97,eax
mov eax,0
mov t98,stack[t97]
mov eax,0
add eax,p
add eax,13
mov t99,eax
mov eax,0
mov stack[t99],t98
mov eax,0
add eax,p
add eax,12
mov t100,eax
mov eax,0
mov t101,stack[t100]
mov t102,t101
mov eax,0
add eax,1
add eax,t102
mov t103,eax
mov eax,0
mov eax,0
add eax,p
add eax,t103
mov t104,eax
mov eax,0
mov eax,0
add eax,p
add eax,12
mov t105,eax
mov eax,0
mov t106,stack[t105]
mov eax,0
add eax,t106
add eax,1
mov t107,eax
mov eax,0
mov t108,t107
mov eax,0
add eax,t108
add eax,1
mov t109,eax
mov eax,0
mov eax,0
add eax,p
add eax,t109
mov t110,eax
mov eax,0
mov t111,stack[t110]
mov stack[t104],t111
mov eax,0
add eax,p
add eax,12
mov t112,eax
mov eax,0
mov t113,stack[t112]
mov eax,0
add eax,t113
add eax,1
mov t114,eax
mov eax,0
mov t115,t114
mov eax,0
add eax,1
add eax,t115
mov t116,eax
mov eax,0
mov eax,0
add eax,p
add eax,t116
mov t117,eax
mov eax,0
mov eax,0
add eax,p
add eax,13
mov t118,eax
mov eax,0
mov t119,stack[t118]
mov stack[t117],t119
jmp etFin_5
et_15:
etFin_5:
mov eax,0
add eax,p
add eax,12
mov t120,eax
mov eax,0
mov t121,stack[t120]
mov eax,0
add eax,p
add eax,14
mov t122,eax
mov eax,0
mov eax,0
add eax,t122
add eax,1
mov t123,eax
mov eax,0
mov stack[t123],t121
mov eax,0
add eax,p
add eax,14
mov p,eax
mov eax,0
call VB_Incremento_Integer
mov eax,0
add eax,p
sub eax,14
mov p,eax
mov eax,0
mov eax,0
add eax,p
add eax,14
mov t124,eax
mov eax,0
mov eax,0
add eax,t124
add eax,0
mov t125,eax
mov eax,0
mov t126,stack[t125]
mov eax,0
add eax,p
add eax,12
mov t127,eax
mov eax,0
mov stack[t127],t126
jmp etWhile_4
et_13:
etFin_6:
mov eax,0
add eax,p
add eax,12
mov t128,eax
mov eax,0
mov stack[t128],0
mov eax,0
add eax,p
add eax,11
mov t129,eax
mov eax,0
mov t130,stack[t129]
mov eax,0
add eax,p
add eax,14
mov t131,eax
mov eax,0
mov eax,0
add eax,t131
add eax,1
mov t132,eax
mov eax,0
mov stack[t132],t130
mov eax,0
add eax,p
add eax,14
mov p,eax
mov eax,0
call VB_Incremento_Integer
mov eax,0
add eax,p
sub eax,14
mov p,eax
mov eax,0
mov eax,0
add eax,p
add eax,14
mov t133,eax
mov eax,0
mov eax,0
add eax,t133
add eax,0
mov t134,eax
mov eax,0
mov t135,stack[t134]
mov eax,0
add eax,p
add eax,11
mov t136,eax
mov eax,0
mov stack[t136],t135
jmp etWhile_3
et_11:
etFin_7:
mov eax,0
add eax,p
add eax,14
mov t137,eax
mov eax,0
mov eax,0
add eax,t137
add eax,1
mov t138,eax
mov eax,0
mov stack[t138],2
mov eax,0
add eax,p
add eax,14
mov p,eax
mov eax,0
call PY_Mensaje
mov eax,0
add eax,p
sub eax,14
mov p,eax
mov eax,0
mov eax,0
add eax,p
add eax,11
mov t139,eax
mov eax,0
mov stack[t139],0
etFor_4:
mov eax,0
add eax,p
add eax,11
mov t140,eax
mov eax,0
mov t141,stack[t140]
mov eax,0
add eax,p
add eax,0
mov t142,eax
mov eax,0
mov t143,stack[t142]
.IF(t141 < t143)
jmp et_16
.ENDIF
jmp et_17
et_16:
mov eax,0
add eax,p
add eax,11
mov t144,eax
mov eax,0
mov t145,stack[t144]
mov eax,0
add eax,p
add eax,11
mov t146,eax
mov eax,0
mov t147,stack[t146]
mov t148,t147
mov eax,0
add eax,t148
add eax,1
mov t149,eax
mov eax,0
mov eax,0
add eax,p
add eax,t149
mov t150,eax
mov eax,0
mov t151,stack[t150]
mov eax,0
add eax,p
add eax,14
mov t152,eax
mov eax,0
mov eax,0
add eax,t152
add eax,1
mov t153,eax
mov eax,0
mov stack[t153],t145
mov eax,0
add eax,p
add eax,14
mov t154,eax
mov eax,0
mov eax,0
add eax,t154
add eax,2
mov t155,eax
mov eax,0
mov stack[t155],t151
mov eax,0
add eax,p
add eax,14
mov p,eax
mov eax,0
call PY_Mostrar
mov eax,0
add eax,p
sub eax,14
mov p,eax
mov eax,0
mov eax,0
add eax,p
add eax,11
mov t156,eax
mov eax,0
mov t157,stack[t156]
mov eax,0
add eax,t157
add eax,1
mov t158,eax
mov eax,0
mov eax,0
add eax,p
add eax,11
mov t159,eax
mov eax,0
mov stack[t159],t158
jmp etFor_4
et_17:
etFin_8:
mov edx,offset mensaje438
call writestring
mov edx,offset mensaje439
call writestring
mov edx,offset mensaje440
call writestring
mov edx,offset mensaje441
call writestring
mov edx,offset mensaje442
call writestring
call readdec
mov t160,eax
mov eax,0
add eax,p
add eax,14
mov t161,eax
mov eax,0
mov stack[t161],t160
EXIT
main ENDP
VB_Incremento_Integer proc
mov eax,0
add eax,p
add eax,1
mov t1,eax
mov eax,0
mov t2,stack[t1]
mov eax,0
add eax,t2
add eax,1
mov t3,eax
mov eax,0
mov eax,0
add eax,p
add eax,1
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
add eax,0
mov t7,eax
mov eax,0
mov stack[t7],t6
ret
VB_Incremento_Integer endp
PY_Mensaje proc
mov eax,0
add eax,p
add eax,1
mov t10,eax
mov eax,0
mov t11,stack[t10]
.IF(t11 == 1)
jmp et_3
.ENDIF
jmp et_4
et_3:
mov edx,offset mensaje179
call writestring
mov edx,offset mensaje180
call writestring
jmp etFin_2
et_4:
mov eax,0
add eax,p
add eax,1
mov t12,eax
mov eax,0
mov t13,stack[t12]
.IF(t13 == 2)
jmp et_5
.ENDIF
jmp et_6
et_5:
mov edx,offset mensaje188
call writestring
mov edx,offset mensaje189
call writestring
jmp etFin_2
et_6:
mov edx,offset mensaje192
call writestring
mov edx,offset mensaje193
call writestring
jmp etFin_2
etFin_2:
mov edx,offset mensaje196
call writestring
mov edx,offset mensaje197
call writestring
ret
PY_Mensaje endp
PY_Mostrar proc
mov edx,offset mensaje200
call writestring
mov eax,0
add eax,p
add eax,1
mov t14,eax
mov eax,0
mov t15,stack[t14]
mov edx,offset mensaje203
call writestring
mov edx,offset mensaje204
call writestring
mov eax,0
add eax,p
add eax,2
mov t16,eax
mov eax,0
mov t17,stack[t16]
mov edx,offset mensaje207
call writestring
mov edx,offset mensaje208
call writestring
ret
PY_Mostrar endp
END main