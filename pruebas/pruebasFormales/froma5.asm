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
mensaje134 BYTE " Introduzca un n ú mero ( 0 a 99 ) :",0
mensaje135 BYTE "\n",0
mensaje149 BYTE " el valor de decenas es :",0
mensaje152 BYTE t12,0
mensaje153 BYTE "\n",0
mensaje159 BYTE "",0
mensaje165 BYTE " diez",0
mensaje171 BYTE " veinte",0
mensaje177 BYTE " treinta",0
mensaje183 BYTE " cuarenta",0
mensaje189 BYTE " cincuenta",0
mensaje195 BYTE " sesenta",0
mensaje201 BYTE " setenta",0
mensaje207 BYTE " ochenta",0
mensaje213 BYTE " noventa",0
mensaje217 BYTE " y",0
mensaje223 BYTE "",0
mensaje224 BYTE "\n",0
mensaje230 BYTE " uno",0
mensaje231 BYTE "\n",0
mensaje237 BYTE " dos",0
mensaje238 BYTE "\n",0
mensaje244 BYTE " tres",0
mensaje245 BYTE "\n",0
mensaje251 BYTE " cuatro",0
mensaje252 BYTE "\n",0
mensaje258 BYTE " cinco",0
mensaje259 BYTE "\n",0
mensaje265 BYTE " seis",0
mensaje266 BYTE "\n",0
mensaje272 BYTE " siete",0
mensaje273 BYTE "\n",0
mensaje279 BYTE " ocho",0
mensaje280 BYTE "\n",0
mensaje286 BYTE " nueva",0
mensaje287 BYTE "\n",0
mensaje293 BYTE " Introduzca un n ú mero :",0
mensaje294 BYTE "\n",0
mensaje310 BYTE " Par",0
mensaje311 BYTE "\n",0
mensaje314 BYTE " Impar",0
mensaje315 BYTE "\n",0
mensaje318 BYTE " Introduzca un n ú mero :",0
mensaje319 BYTE "\n",0
mensaje331 BYTE " Introduzca un n ú mero :",0
mensaje332 BYTE "\n",0
mensaje351 BYTE " La suma de todos los n ú meros es :",0
mensaje354 BYTE t38,0
mensaje355 BYTE "\n",0
mensaje368 BYTE " \ n \ nTabla del",0
mensaje371 BYTE t46,0
mensaje372 BYTE "\n",0
mensaje373 BYTE " - - - - - - - - - - - - - - -",0
mensaje374 BYTE "\n",0
mensaje394 BYTE t60,0
mensaje395 BYTE " x",0
mensaje398 BYTE t62,0
mensaje399 BYTE " =",0
mensaje402 BYTE t64,0
mensaje403 BYTE "\n",0
mensaje473 BYTE " E",0
mensaje478 BYTE t100,0
mensaje486 BYTE " E",0
mensaje491 BYTE t104,0
mensaje499 BYTE " E",0
mensaje504 BYTE t108,0
mensaje512 BYTE " E",0
mensaje517 BYTE t112,0
mensaje525 BYTE " E",0
mensaje530 BYTE t116,0
mensaje533 BYTE "",0
mensaje534 BYTE "\n",0
.code
main proc
mov p,0
mov h,0
mov eax,0
add eax,p
add eax,1
mov p,eax
mov eax,0
call JV_clase_clase
mov eax,0
add eax,p
sub eax,1
mov p,eax
mov eax,0
mov eax,0
add eax,p
add eax,1
mov t125,eax
mov eax,0
mov eax,0
add eax,t125
add eax,0
mov t126,eax
mov eax,0
mov t127,stack[t126]
mov eax,0
add eax,p
add eax,0
mov t128,eax
mov eax,0
mov stack[t128],t127
mov eax,0
add eax,p
add eax,0
mov t129,eax
mov eax,0
mov t130,stack[t129]
mov eax,0
add eax,p
add eax,1
mov t131,eax
mov eax,0
mov eax,0
add eax,t131
add eax,0
mov t132,eax
mov eax,0
mov stack[t132],t130
mov eax,0
add eax,p
add eax,1
mov p,eax
mov eax,0
call JV_clase_programa5
mov eax,0
add eax,p
sub eax,1
mov p,eax
mov eax,0
EXIT
main ENDP
JV_clase_programa proc
mov edx,offset mensaje134
call writestring
mov edx,offset mensaje135
call writestring
call readdec
mov t1,eax
mov eax,0
add eax,p
add eax,2
mov t2,eax
mov eax,0
mov stack[t2],t1
mov eax,0
add eax,p
add eax,2
mov t3,eax
mov eax,0
mov t4,stack[t3]
mov edx,0
mov eax,t4
mov ebx,10
div ebx
mov t5,edx
mov edx,0
mov eax,0
mov ebx,0
mov eax,0
add eax,p
add eax,3
mov t6,eax
mov eax,0
mov stack[t6],t5
mov eax,0
add eax,p
add eax,2
mov t7,eax
mov eax,0
mov t8,stack[t7]
mov edx,0
mov eax,t8
mov ebx,10
div ebx
mov t9,eax
mov edx,0
mov eax,0
mov ebx,0
mov eax,0
add eax,p
add eax,4
mov t10,eax
mov eax,0
mov stack[t10],t9
mov edx,offset mensaje149
call writestring
mov eax,0
add eax,p
add eax,4
mov t11,eax
mov eax,0
mov t12,stack[t11]
mov edx,offset mensaje152
call writestring
mov edx,offset mensaje153
call writestring
mov eax,0
add eax,p
add eax,4
mov t13,eax
mov eax,0
mov t14,stack[t13]
.IF((int)t14 == 0)
jmp et_2
.ENDIF
jmp et_3
et_2:
mov edx,offset mensaje159
call writestring
jmp etFinal_0
et_3:
.IF((int)t14 == 1)
jmp et_4
.ENDIF
jmp et_5
et_4:
mov edx,offset mensaje165
call writestring
jmp etFinal_0
et_5:
.IF((int)t14 == 2)
jmp et_6
.ENDIF
jmp et_7
et_6:
mov edx,offset mensaje171
call writestring
jmp etFinal_0
et_7:
.IF((int)t14 == 3)
jmp et_8
.ENDIF
jmp et_9
et_8:
mov edx,offset mensaje177
call writestring
jmp etFinal_0
et_9:
.IF((int)t14 == 4)
jmp et_10
.ENDIF
jmp et_11
et_10:
mov edx,offset mensaje183
call writestring
jmp etFinal_0
et_11:
.IF((int)t14 == 5)
jmp et_12
.ENDIF
jmp et_13
et_12:
mov edx,offset mensaje189
call writestring
jmp etFinal_0
et_13:
.IF((int)t14 == 6)
jmp et_14
.ENDIF
jmp et_15
et_14:
mov edx,offset mensaje195
call writestring
jmp etFinal_0
et_15:
.IF((int)t14 == 7)
jmp et_16
.ENDIF
jmp et_17
et_16:
mov edx,offset mensaje201
call writestring
jmp etFinal_0
et_17:
.IF((int)t14 == 8)
jmp et_18
.ENDIF
jmp et_19
et_18:
mov edx,offset mensaje207
call writestring
jmp etFinal_0
et_19:
.IF((int)t14 == 9)
jmp et_20
.ENDIF
jmp et_21
et_20:
mov edx,offset mensaje213
call writestring
jmp etFinal_0
et_21:
etFinal_0:
mov edx,offset mensaje217
call writestring
mov eax,0
add eax,p
add eax,3
mov t15,eax
mov eax,0
mov t16,stack[t15]
.IF((int)t16 == 0)
jmp et_22
.ENDIF
jmp et_23
et_22:
mov edx,offset mensaje223
call writestring
mov edx,offset mensaje224
call writestring
jmp etFinal_1
et_23:
.IF((int)t16 == 1)
jmp et_24
.ENDIF
jmp et_25
et_24:
mov edx,offset mensaje230
call writestring
mov edx,offset mensaje231
call writestring
jmp etFinal_1
et_25:
.IF((int)t16 == 2)
jmp et_26
.ENDIF
jmp et_27
et_26:
mov edx,offset mensaje237
call writestring
mov edx,offset mensaje238
call writestring
jmp etFinal_1
et_27:
.IF((int)t16 == 3)
jmp et_28
.ENDIF
jmp et_29
et_28:
mov edx,offset mensaje244
call writestring
mov edx,offset mensaje245
call writestring
jmp etFinal_1
et_29:
.IF((int)t16 == 4)
jmp et_30
.ENDIF
jmp et_31
et_30:
mov edx,offset mensaje251
call writestring
mov edx,offset mensaje252
call writestring
jmp etFinal_1
et_31:
.IF((int)t16 == 5)
jmp et_32
.ENDIF
jmp et_33
et_32:
mov edx,offset mensaje258
call writestring
mov edx,offset mensaje259
call writestring
jmp etFinal_1
et_33:
.IF((int)t16 == 6)
jmp et_34
.ENDIF
jmp et_35
et_34:
mov edx,offset mensaje265
call writestring
mov edx,offset mensaje266
call writestring
jmp etFinal_1
et_35:
.IF((int)t16 == 7)
jmp et_36
.ENDIF
jmp et_37
et_36:
mov edx,offset mensaje272
call writestring
mov edx,offset mensaje273
call writestring
jmp etFinal_1
et_37:
.IF((int)t16 == 8)
jmp et_38
.ENDIF
jmp et_39
et_38:
mov edx,offset mensaje279
call writestring
mov edx,offset mensaje280
call writestring
jmp etFinal_1
et_39:
.IF((int)t16 == 9)
jmp et_40
.ENDIF
jmp et_41
et_40:
mov edx,offset mensaje286
call writestring
mov edx,offset mensaje287
call writestring
jmp etFinal_1
et_41:
etFinal_1:
ret
JV_clase_programa endp
JV_clase_programa2 proc
mov edx,offset mensaje293
call writestring
mov edx,offset mensaje294
call writestring
call readdec
mov t17,eax
mov eax,0
add eax,p
add eax,2
mov t18,eax
mov eax,0
mov stack[t18],t17
etWhile_1:
mov eax,0
add eax,p
add eax,2
mov t19,eax
mov eax,0
mov t20,stack[t19]
.IF(t20 != 0)
jmp et_42
.ENDIF
jmp et_43
et_42:
mov eax,0
add eax,p
add eax,2
mov t21,eax
mov eax,0
mov t22,stack[t21]
mov edx,0
mov eax,t22
mov ebx,2
div ebx
mov t23,edx
mov edx,0
mov eax,0
mov ebx,0
.IF(t23 == 0)
jmp et_44
.ENDIF
jmp et_45
et_44:
mov edx,offset mensaje310
call writestring
mov edx,offset mensaje311
call writestring
jmp etFin_1
et_45:
mov edx,offset mensaje314
call writestring
mov edx,offset mensaje315
call writestring
jmp etFin_1
etFin_1:
mov edx,offset mensaje318
call writestring
mov edx,offset mensaje319
call writestring
call readdec
mov t24,eax
mov eax,0
add eax,p
add eax,2
mov t25,eax
mov eax,0
mov stack[t25],t24
jmp etWhile_1
et_43:
etFin_2:
ret
JV_clase_programa2 endp
JV_clase_programa3 proc
mov eax,0
add eax,p
add eax,3
mov t26,eax
mov eax,0
mov stack[t26],0
etWhile_2:
mov edx,offset mensaje331
call writestring
mov edx,offset mensaje332
call writestring
call readdec
mov t27,eax
mov eax,0
add eax,p
add eax,2
mov t28,eax
mov eax,0
mov stack[t28],t27
mov eax,0
add eax,p
add eax,3
mov t29,eax
mov eax,0
mov t30,stack[t29]
mov eax,0
add eax,p
add eax,2
mov t31,eax
mov eax,0
mov t32,stack[t31]
mov eax,0
add eax,t30
add eax,t32
mov t33,eax
mov eax,0
mov eax,0
add eax,p
add eax,3
mov t34,eax
mov eax,0
mov stack[t34],t33
mov eax,0
add eax,p
add eax,2
mov t35,eax
mov eax,0
mov t36,stack[t35]
.IF(t36 != 0)
jmp et_46
.ENDIF
jmp et_47
et_46:
jmp etWhile_2
et_47:
etFin_3:
mov edx,offset mensaje351
call writestring
mov eax,0
add eax,p
add eax,3
mov t37,eax
mov eax,0
mov t38,stack[t37]
mov edx,offset mensaje354
call writestring
mov edx,offset mensaje355
call writestring
ret
JV_clase_programa3 endp
JV_clase_programa4 proc
mov eax,0
add eax,p
add eax,2
mov t39,eax
mov eax,0
mov stack[t39],1
etFor_1:
mov eax,0
add eax,p
add eax,2
mov t40,eax
mov eax,0
mov t41,stack[t40]
mov eax,0
add eax,p
add eax,2
mov t42,eax
mov eax,0
mov t43,stack[t42]
.IF(t41 <= 10)
jmp et_48
.ENDIF
jmp et_49
et_48:
mov edx,offset mensaje368
call writestring
mov eax,0
add eax,p
add eax,2
mov t45,eax
mov eax,0
mov t46,stack[t45]
mov edx,offset mensaje371
call writestring
mov edx,offset mensaje372
call writestring
mov edx,offset mensaje373
call writestring
mov edx,offset mensaje374
call writestring
mov eax,0
add eax,p
add eax,3
mov t47,eax
mov eax,0
mov stack[t47],1
etFor_2:
mov eax,0
add eax,p
add eax,3
mov t48,eax
mov eax,0
mov t49,stack[t48]
mov eax,0
add eax,p
add eax,3
mov t50,eax
mov eax,0
mov t51,stack[t50]
.IF(t49 <= 10)
jmp et_50
.ENDIF
jmp et_51
et_50:
mov eax,0
add eax,p
add eax,2
mov t53,eax
mov eax,0
mov t54,stack[t53]
mov eax,0
add eax,p
add eax,3
mov t55,eax
mov eax,0
mov t56,stack[t55]
mov eax,t54
mov ebx,t56
mul ebx
mov t57,eax
mov ebx,0
mov eax,0
mov eax,0
add eax,p
add eax,4
mov t58,eax
mov eax,0
mov stack[t58],t57
mov eax,0
add eax,p
add eax,2
mov t59,eax
mov eax,0
mov t60,stack[t59]
mov edx,offset mensaje394
call writestring
mov edx,offset mensaje395
call writestring
mov eax,0
add eax,p
add eax,3
mov t61,eax
mov eax,0
mov t62,stack[t61]
mov edx,offset mensaje398
call writestring
mov edx,offset mensaje399
call writestring
mov eax,0
add eax,p
add eax,4
mov t63,eax
mov eax,0
mov t64,stack[t63]
mov edx,offset mensaje402
call writestring
mov edx,offset mensaje403
call writestring
mov eax,0
add eax,t51
add eax,1
mov t52,eax
mov eax,0
mov eax,0
add eax,p
add eax,3
mov t65,eax
mov eax,0
mov stack[t65],t52
jmp etFor_2
et_51:
etFin_4:
mov eax,0
add eax,t43
add eax,1
mov t44,eax
mov eax,0
mov eax,0
add eax,p
add eax,2
mov t66,eax
mov eax,0
mov stack[t66],t44
jmp etFor_1
et_49:
etFin_5:
ret
JV_clase_programa4 endp
JV_clase_programa5 proc
mov eax,0
add eax,p
add eax,2
mov t67,eax
mov eax,0
mov stack[t67],0
etFor_3:
mov eax,0
add eax,p
add eax,2
mov t68,eax
mov eax,0
mov t69,stack[t68]
mov eax,0
add eax,p
add eax,2
mov t70,eax
mov eax,0
mov t71,stack[t70]
.IF(t69 <= 9)
jmp et_52
.ENDIF
jmp et_53
et_52:
mov eax,0
add eax,p
add eax,3
mov t73,eax
mov eax,0
mov stack[t73],0
etFor_4:
mov eax,0
add eax,p
add eax,3
mov t74,eax
mov eax,0
mov t75,stack[t74]
mov eax,0
add eax,p
add eax,3
mov t76,eax
mov eax,0
mov t77,stack[t76]
.IF(t75 <= 9)
jmp et_54
.ENDIF
jmp et_55
et_54:
mov eax,0
add eax,p
add eax,4
mov t79,eax
mov eax,0
mov stack[t79],0
etFor_5:
mov eax,0
add eax,p
add eax,4
mov t80,eax
mov eax,0
mov t81,stack[t80]
mov eax,0
add eax,p
add eax,4
mov t82,eax
mov eax,0
mov t83,stack[t82]
.IF(t81 <= 9)
jmp et_56
.ENDIF
jmp et_57
et_56:
mov eax,0
add eax,p
add eax,5
mov t85,eax
mov eax,0
mov stack[t85],0
etFor_6:
mov eax,0
add eax,p
add eax,5
mov t86,eax
mov eax,0
mov t87,stack[t86]
mov eax,0
add eax,p
add eax,5
mov t88,eax
mov eax,0
mov t89,stack[t88]
.IF(t87 <= 9)
jmp et_58
.ENDIF
jmp et_59
et_58:
mov eax,0
add eax,p
add eax,6
mov t91,eax
mov eax,0
mov stack[t91],0
etFor_7:
mov eax,0
add eax,p
add eax,6
mov t92,eax
mov eax,0
mov t93,stack[t92]
mov eax,0
add eax,p
add eax,6
mov t94,eax
mov eax,0
mov t95,stack[t94]
.IF(t93 <= 9)
jmp et_60
.ENDIF
jmp et_61
et_60:
mov eax,0
add eax,p
add eax,2
mov t97,eax
mov eax,0
mov t98,stack[t97]
.IF(t98 == 3)
jmp et_62
.ENDIF
jmp et_63
et_62:
mov edx,offset mensaje473
call writestring
jmp etFin_6
et_63:
mov eax,0
add eax,p
add eax,2
mov t99,eax
mov eax,0
mov t100,stack[t99]
mov edx,offset mensaje478
call writestring
jmp etFin_6
etFin_6:
mov eax,0
add eax,p
add eax,3
mov t101,eax
mov eax,0
mov t102,stack[t101]
.IF(t102 == 3)
jmp et_64
.ENDIF
jmp et_65
et_64:
mov edx,offset mensaje486
call writestring
jmp etFin_7
et_65:
mov eax,0
add eax,p
add eax,3
mov t103,eax
mov eax,0
mov t104,stack[t103]
mov edx,offset mensaje491
call writestring
jmp etFin_7
etFin_7:
mov eax,0
add eax,p
add eax,4
mov t105,eax
mov eax,0
mov t106,stack[t105]
.IF(t106 == 3)
jmp et_66
.ENDIF
jmp et_67
et_66:
mov edx,offset mensaje499
call writestring
jmp etFin_8
et_67:
mov eax,0
add eax,p
add eax,4
mov t107,eax
mov eax,0
mov t108,stack[t107]
mov edx,offset mensaje504
call writestring
jmp etFin_8
etFin_8:
mov eax,0
add eax,p
add eax,5
mov t109,eax
mov eax,0
mov t110,stack[t109]
.IF(t110 == 3)
jmp et_68
.ENDIF
jmp et_69
et_68:
mov edx,offset mensaje512
call writestring
jmp etFin_9
et_69:
mov eax,0
add eax,p
add eax,5
mov t111,eax
mov eax,0
mov t112,stack[t111]
mov edx,offset mensaje517
call writestring
jmp etFin_9
etFin_9:
mov eax,0
add eax,p
add eax,6
mov t113,eax
mov eax,0
mov t114,stack[t113]
.IF(t114 == 3)
jmp et_70
.ENDIF
jmp et_71
et_70:
mov edx,offset mensaje525
call writestring
jmp etFin_10
et_71:
mov eax,0
add eax,p
add eax,6
mov t115,eax
mov eax,0
mov t116,stack[t115]
mov edx,offset mensaje530
call writestring
jmp etFin_10
etFin_10:
mov edx,offset mensaje533
call writestring
mov edx,offset mensaje534
call writestring
mov eax,0
add eax,t95
add eax,1
mov t96,eax
mov eax,0
mov eax,0
add eax,p
add eax,6
mov t117,eax
mov eax,0
mov stack[t117],t96
jmp etFor_7
et_61:
etFin_11:
mov eax,0
add eax,t89
add eax,1
mov t90,eax
mov eax,0
mov eax,0
add eax,p
add eax,5
mov t118,eax
mov eax,0
mov stack[t118],t90
jmp etFor_6
et_59:
etFin_12:
mov eax,0
add eax,t83
add eax,1
mov t84,eax
mov eax,0
mov eax,0
add eax,p
add eax,4
mov t119,eax
mov eax,0
mov stack[t119],t84
jmp etFor_5
et_57:
etFin_13:
mov eax,0
add eax,t77
add eax,1
mov t78,eax
mov eax,0
mov eax,0
add eax,p
add eax,3
mov t120,eax
mov eax,0
mov stack[t120],t78
jmp etFor_4
et_55:
etFin_14:
mov eax,0
add eax,t71
add eax,1
mov t72,eax
mov eax,0
mov eax,0
add eax,p
add eax,2
mov t121,eax
mov eax,0
mov stack[t121],t72
jmp etFor_3
et_53:
etFin_15:
ret
JV_clase_programa5 endp
JV_clase_clase proc
mov eax,0
add eax,p
add eax,0
mov t122,eax
mov eax,0
mov stack[t122],h
mov eax,0
add eax,h
add eax,0
mov h,eax
mov eax,0
ret
JV_clase_clase endp
END main