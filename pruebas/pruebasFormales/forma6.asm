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
mensaje148 BYTE " A [",0
mensaje151 BYTE t13,0
mensaje152 BYTE " ] [",0
mensaje155 BYTE t15,0
mensaje156 BYTE " ] :",0
mensaje157 BYTE "\n",0
mensaje167 BYTE "\n",0
mensaje186 BYTE " Matriz B :",0
mensaje187 BYTE "\n",0
mensaje204 BYTE " B [",0
mensaje207 BYTE t41,0
mensaje208 BYTE " ] [",0
mensaje211 BYTE t43,0
mensaje212 BYTE " ] :",0
mensaje213 BYTE "\n",0
mensaje223 BYTE "\n",0
mensaje305 BYTE " Matriz Suma :",0
mensaje306 BYTE "\n",0
mensaje332 BYTE stack[(int) t120],0
mensaje333 BYTE "",0
mensaje334 BYTE "\n",0
mensaje343 BYTE "",0
mensaje344 BYTE "\n",0
.code
main proc
mov p,0
mov h,0
mov eax,0
add eax,p
add eax,27
mov t6,eax
mov eax,0
mov stack[t6],0
etFor_3:
mov eax,0
add eax,p
add eax,27
mov t7,eax
mov eax,0
mov t8,stack[t7]
.IF(t8 < 3)
jmp et_4
.ENDIF
jmp et_5
et_4:
mov eax,0
add eax,p
add eax,28
mov t9,eax
mov eax,0
mov stack[t9],0
etFor_4:
mov eax,0
add eax,p
add eax,28
mov t10,eax
mov eax,0
mov t11,stack[t10]
.IF(t11 < 3)
jmp et_6
.ENDIF
jmp et_7
et_6:
mov edx,offset mensaje148
call writestring
mov eax,0
add eax,p
add eax,27
mov t12,eax
mov eax,0
mov t13,stack[t12]
mov edx,offset mensaje151
call writestring
mov edx,offset mensaje152
call writestring
mov eax,0
add eax,p
add eax,28
mov t14,eax
mov eax,0
mov t15,stack[t14]
mov edx,offset mensaje155
call writestring
mov edx,offset mensaje156
call writestring
mov edx,offset mensaje157
call writestring
mov eax,0
add eax,p
add eax,27
mov t16,eax
mov eax,0
mov t17,stack[t16]
mov eax,t17
mov ebx,3
mul ebx
mov t18,eax
mov ebx,0
mov eax,0
mov eax,0
add eax,p
add eax,28
mov t19,eax
mov eax,0
mov t20,stack[t19]
mov eax,0
add eax,t20
add eax,1
mov t21,eax
mov eax,0
mov eax,0
add eax,t18
add eax,t21
mov t22,eax
mov eax,0
mov eax,0
add eax,0
add eax,t22
mov t23,eax
mov eax,0
mov eax,0
add eax,p
add eax,t23
mov t24,eax
mov eax,0
mov edx,offset mensaje167
call writestring
call readdec
mov t25,eax
mov stack[t24],t25
mov eax,0
add eax,p
add eax,28
mov t26,eax
mov eax,0
mov t27,stack[t26]
mov eax,0
add eax,t27
add eax,1
mov t28,eax
mov eax,0
mov eax,0
add eax,p
add eax,28
mov t29,eax
mov eax,0
mov stack[t29],t28
jmp etFor_4
et_7:
etFin_3:
mov eax,0
add eax,p
add eax,27
mov t30,eax
mov eax,0
mov t31,stack[t30]
mov eax,0
add eax,t31
add eax,1
mov t32,eax
mov eax,0
mov eax,0
add eax,p
add eax,27
mov t33,eax
mov eax,0
mov stack[t33],t32
jmp etFor_3
et_5:
etFin_4:
mov edx,offset mensaje186
call writestring
mov edx,offset mensaje187
call writestring
mov eax,0
add eax,p
add eax,27
mov t34,eax
mov eax,0
mov stack[t34],0
etFor_5:
mov eax,0
add eax,p
add eax,27
mov t35,eax
mov eax,0
mov t36,stack[t35]
.IF(t36 < 3)
jmp et_8
.ENDIF
jmp et_9
et_8:
mov eax,0
add eax,p
add eax,28
mov t37,eax
mov eax,0
mov stack[t37],0
etFor_6:
mov eax,0
add eax,p
add eax,28
mov t38,eax
mov eax,0
mov t39,stack[t38]
.IF(t39 < 3)
jmp et_10
.ENDIF
jmp et_11
et_10:
mov edx,offset mensaje204
call writestring
mov eax,0
add eax,p
add eax,27
mov t40,eax
mov eax,0
mov t41,stack[t40]
mov edx,offset mensaje207
call writestring
mov edx,offset mensaje208
call writestring
mov eax,0
add eax,p
add eax,28
mov t42,eax
mov eax,0
mov t43,stack[t42]
mov edx,offset mensaje211
call writestring
mov edx,offset mensaje212
call writestring
mov edx,offset mensaje213
call writestring
mov eax,0
add eax,p
add eax,27
mov t44,eax
mov eax,0
mov t45,stack[t44]
mov eax,t45
mov ebx,3
mul ebx
mov t46,eax
mov ebx,0
mov eax,0
mov eax,0
add eax,p
add eax,28
mov t47,eax
mov eax,0
mov t48,stack[t47]
mov eax,0
add eax,t48
add eax,1
mov t49,eax
mov eax,0
mov eax,0
add eax,t46
add eax,t49
mov t50,eax
mov eax,0
mov eax,0
add eax,9
add eax,t50
mov t51,eax
mov eax,0
mov eax,0
add eax,p
add eax,t51
mov t52,eax
mov eax,0
mov edx,offset mensaje223
call writestring
call readdec
mov t53,eax
mov stack[t52],t53
mov eax,0
add eax,p
add eax,28
mov t54,eax
mov eax,0
mov t55,stack[t54]
mov eax,0
add eax,t55
add eax,1
mov t56,eax
mov eax,0
mov eax,0
add eax,p
add eax,28
mov t57,eax
mov eax,0
mov stack[t57],t56
jmp etFor_6
et_11:
etFin_5:
mov eax,0
add eax,p
add eax,27
mov t58,eax
mov eax,0
mov t59,stack[t58]
mov eax,0
add eax,t59
add eax,1
mov t60,eax
mov eax,0
mov eax,0
add eax,p
add eax,27
mov t61,eax
mov eax,0
mov stack[t61],t60
jmp etFor_5
et_9:
etFin_6:
mov eax,0
add eax,p
add eax,27
mov t62,eax
mov eax,0
mov stack[t62],0
etFor_7:
mov eax,0
add eax,p
add eax,27
mov t63,eax
mov eax,0
mov t64,stack[t63]
.IF(t64 < 3)
jmp et_12
.ENDIF
jmp et_13
et_12:
mov eax,0
add eax,p
add eax,28
mov t65,eax
mov eax,0
mov stack[t65],0
etFor_8:
mov eax,0
add eax,p
add eax,28
mov t66,eax
mov eax,0
mov t67,stack[t66]
.IF(t67 < 3)
jmp et_14
.ENDIF
jmp et_15
et_14:
mov eax,0
add eax,p
add eax,27
mov t68,eax
mov eax,0
mov t69,stack[t68]
mov eax,t69
mov ebx,3
mul ebx
mov t70,eax
mov ebx,0
mov eax,0
mov eax,0
add eax,p
add eax,28
mov t71,eax
mov eax,0
mov t72,stack[t71]
mov eax,0
add eax,t72
add eax,1
mov t73,eax
mov eax,0
mov eax,0
add eax,t70
add eax,t73
mov t74,eax
mov eax,0
mov eax,0
add eax,18
add eax,t74
mov t75,eax
mov eax,0
mov eax,0
add eax,p
add eax,t75
mov t76,eax
mov eax,0
mov eax,0
add eax,p
add eax,27
mov t77,eax
mov eax,0
mov t78,stack[t77]
mov eax,t78
mov ebx,3
mul ebx
mov t79,eax
mov ebx,0
mov eax,0
mov eax,0
add eax,p
add eax,28
mov t80,eax
mov eax,0
mov t81,stack[t80]
mov eax,0
add eax,t81
add eax,1
mov t82,eax
mov eax,0
mov eax,0
add eax,t79
add eax,t82
mov t83,eax
mov eax,0
mov eax,0
add eax,t83
add eax,0
mov t84,eax
mov eax,0
mov eax,0
add eax,p
add eax,t84
mov t85,eax
mov eax,0
mov t86,stack[t85]
mov eax,0
add eax,p
add eax,27
mov t87,eax
mov eax,0
mov t88,stack[t87]
mov eax,t88
mov ebx,3
mul ebx
mov t89,eax
mov ebx,0
mov eax,0
mov eax,0
add eax,p
add eax,28
mov t90,eax
mov eax,0
mov t91,stack[t90]
mov eax,0
add eax,t91
add eax,1
mov t92,eax
mov eax,0
mov eax,0
add eax,t89
add eax,t92
mov t93,eax
mov eax,0
mov eax,0
add eax,t93
add eax,9
mov t94,eax
mov eax,0
mov eax,0
add eax,p
add eax,t94
mov t95,eax
mov eax,0
mov t96,stack[t95]
mov eax,0
add eax,t86
add eax,t96
mov t97,eax
mov eax,0
mov stack[t76],t97
mov eax,0
add eax,p
add eax,28
mov t98,eax
mov eax,0
mov t99,stack[t98]
mov eax,0
add eax,t99
add eax,1
mov t100,eax
mov eax,0
mov eax,0
add eax,p
add eax,28
mov t101,eax
mov eax,0
mov stack[t101],t100
jmp etFor_8
et_15:
etFin_7:
mov eax,0
add eax,p
add eax,27
mov t102,eax
mov eax,0
mov t103,stack[t102]
mov eax,0
add eax,t103
add eax,1
mov t104,eax
mov eax,0
mov eax,0
add eax,p
add eax,27
mov t105,eax
mov eax,0
mov stack[t105],t104
jmp etFor_7
et_13:
etFin_8:
mov edx,offset mensaje305
call writestring
mov edx,offset mensaje306
call writestring
mov eax,0
add eax,p
add eax,27
mov t106,eax
mov eax,0
mov stack[t106],0
etFor_9:
mov eax,0
add eax,p
add eax,27
mov t107,eax
mov eax,0
mov t108,stack[t107]
.IF(t108 < 3)
jmp et_16
.ENDIF
jmp et_17
et_16:
mov eax,0
add eax,p
add eax,28
mov t109,eax
mov eax,0
mov stack[t109],0
etFor_10:
mov eax,0
add eax,p
add eax,28
mov t110,eax
mov eax,0
mov t111,stack[t110]
.IF(t111 < 3)
jmp et_18
.ENDIF
jmp et_19
et_18:
mov eax,0
add eax,p
add eax,27
mov t112,eax
mov eax,0
mov t113,stack[t112]
mov eax,t113
mov ebx,3
mul ebx
mov t114,eax
mov ebx,0
mov eax,0
mov eax,0
add eax,p
add eax,28
mov t115,eax
mov eax,0
mov t116,stack[t115]
mov eax,0
add eax,t116
add eax,1
mov t117,eax
mov eax,0
mov eax,0
add eax,t114
add eax,t117
mov t118,eax
mov eax,0
mov eax,0
add eax,18
add eax,t118
mov t119,eax
mov eax,0
mov eax,0
add eax,p
add eax,t119
mov t120,eax
mov eax,0
mov edx,offset mensaje332
call writestring
mov edx,offset mensaje333
call writestring
mov edx,offset mensaje334
call writestring
mov eax,0
add eax,p
add eax,28
mov t121,eax
mov eax,0
mov t122,stack[t121]
mov eax,0
add eax,t122
add eax,1
mov t123,eax
mov eax,0
mov eax,0
add eax,p
add eax,28
mov t124,eax
mov eax,0
mov stack[t124],t123
jmp etFor_10
et_19:
etFin_9:
mov edx,offset mensaje343
call writestring
mov edx,offset mensaje344
call writestring
mov eax,0
add eax,p
add eax,27
mov t125,eax
mov eax,0
mov t126,stack[t125]
mov eax,0
add eax,t126
add eax,1
mov t127,eax
mov eax,0
mov eax,0
add eax,p
add eax,27
mov t128,eax
mov eax,0
mov stack[t128],t127
jmp etFor_9
et_17:
etFin_10:
EXIT
main ENDP
END main