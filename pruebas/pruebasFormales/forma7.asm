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
mensaje73 BYTE " Ingrese primer numero :",0
mensaje74 BYTE "\n",0
mensaje78 BYTE " Ingrese segundo numero :",0
mensaje79 BYTE "\n",0
mensaje151 BYTE t45,0
mensaje152 BYTE "",0
mensaje153 BYTE "\n",0
mensaje154 BYTE "",0
mensaje155 BYTE "\n",0
mensaje187 BYTE " hola mundo",0
mensaje190 BYTE t63,0
mensaje191 BYTE "\n",0
mensaje199 BYTE " fin metodo",0
mensaje200 BYTE "\n",0
mensaje214 BYTE " El valor de a es :",0
mensaje217 BYTE t71,0
mensaje218 BYTE "\n",0
.code
main proc
mov p,0
mov h,0
mov eax,0
add eax,p
add eax,2
mov p,eax
mov eax,0
call VB_pruebaForVb
mov eax,0
add eax,p
sub eax,2
mov p,eax
mov eax,0
mov eax,0
add eax,p
add eax,2
mov t65,eax
mov eax,0
mov eax,0
add eax,t65
add eax,0
mov t66,eax
mov eax,0
mov t67,stack[t66]
mov eax,0
add eax,12
add eax,t67
mov t68,eax
mov eax,0
mov eax,0
add eax,p
add eax,0
mov t69,eax
mov eax,0
mov stack[t69],t68
mov edx,offset mensaje214
call writestring
mov eax,0
add eax,p
add eax,0
mov t70,eax
mov eax,0
mov t71,stack[t70]
mov edx,offset mensaje217
call writestring
mov edx,offset mensaje218
call writestring
EXIT
main ENDP
VB_pruebaForVb proc
mov edx,offset mensaje73
call writestring
mov edx,offset mensaje74
call writestring
call readdec
mov t1,eax
mov eax,0
add eax,p
add eax,1
mov t2,eax
mov eax,0
mov stack[t2],t1
mov edx,offset mensaje78
call writestring
mov edx,offset mensaje79
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
JV_clase_mostrar_Integer_Integer proc
mov eax,0
add eax,p
add eax,4
mov t16,eax
mov eax,0
mov stack[t16],0
mov eax,0
add eax,p
add eax,5
mov t17,eax
mov eax,0
mov stack[t17],0
mov eax,0
add eax,p
add eax,2
mov t18,eax
mov eax,0
mov t19,stack[t18]
mov eax,0
add eax,p
add eax,3
mov t20,eax
mov eax,0
mov t21,stack[t20]
.IF(t19 > t21)
jmp et_4
.ENDIF
jmp et_5
et_4:
mov eax,0
add eax,p
add eax,2
mov t22,eax
mov eax,0
mov t23,stack[t22]
mov eax,0
add eax,p
add eax,4
mov t24,eax
mov eax,0
mov stack[t24],t23
mov eax,0
add eax,p
add eax,3
mov t25,eax
mov eax,0
mov t26,stack[t25]
mov eax,0
add eax,p
add eax,5
mov t27,eax
mov eax,0
mov stack[t27],t26
jmp etFin_2
et_5:
mov eax,0
add eax,p
add eax,3
mov t28,eax
mov eax,0
mov t29,stack[t28]
mov eax,0
add eax,p
add eax,4
mov t30,eax
mov eax,0
mov stack[t30],t29
mov eax,0
add eax,p
add eax,2
mov t31,eax
mov eax,0
mov t32,stack[t31]
mov eax,0
add eax,p
add eax,5
mov t33,eax
mov eax,0
mov stack[t33],t32
jmp etFin_2
etFin_2:
mov eax,0
add eax,p
add eax,5
mov t34,eax
mov eax,0
mov t35,stack[t34]
mov eax,0
add eax,p
add eax,6
mov t36,eax
mov eax,0
mov stack[t36],t35
etFor_1:
mov eax,0
add eax,p
add eax,6
mov t37,eax
mov eax,0
mov t38,stack[t37]
mov eax,0
add eax,p
add eax,4
mov t39,eax
mov eax,0
mov t40,stack[t39]
mov eax,0
add eax,p
add eax,6
mov t41,eax
mov eax,0
mov t42,stack[t41]
.IF(t38 <= t40)
jmp et_6
.ENDIF
jmp et_7
et_6:
mov eax,0
add eax,p
add eax,6
mov t44,eax
mov eax,0
mov t45,stack[t44]
mov edx,offset mensaje151
call writestring
mov edx,offset mensaje152
call writestring
mov edx,offset mensaje153
call writestring
mov edx,offset mensaje154
call writestring
mov edx,offset mensaje155
call writestring
mov eax,0
add eax,t42
add eax,1
mov t43,eax
mov eax,0
mov eax,0
add eax,p
add eax,6
mov t46,eax
mov eax,0
mov stack[t46],t43
jmp etFor_1
et_7:
etFin_3:
ret
JV_clase_mostrar_Integer_Integer endp
JV_clase_clase proc
mov eax,0
add eax,p
add eax,0
mov t47,eax
mov eax,0
mov stack[t47],h
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
mov t49,eax
mov eax,0
mov stack[t49],5
mov eax,0
add eax,p
add eax,2
mov t50,eax
mov eax,0
mov stack[t50],20
mov eax,0
add eax,p
add eax,3
mov t51,eax
mov eax,0
mov stack[t51],2
mov eax,0
add eax,p
add eax,1
mov t52,eax
mov eax,0
mov t53,stack[t52]
mov eax,0
add eax,p
add eax,2
mov t54,eax
mov eax,0
mov t55,stack[t54]
mov eax,0
add eax,p
add eax,4
mov t59,eax
mov eax,0
mov stack[t59],t53
etFor_3:
mov eax,0
add eax,p
add eax,4
mov t60,eax
mov eax,0
mov t61,stack[t60]
.IF(t61 <= t55)
jmp et_9
.ENDIF
jmp et_10
et_9:
mov edx,offset mensaje187
call writestring
mov eax,0
add eax,p
add eax,4
mov t62,eax
mov eax,0
mov t63,stack[t62]
mov edx,offset mensaje190
call writestring
mov edx,offset mensaje191
call writestring
mov eax,0
add eax,p
add eax,3
mov t56,eax
mov eax,0
mov eax,0
add eax,p
add eax,4
mov t57,eax
mov eax,0
mov eax,0
add eax,stack[(int) t57]
add eax,stack[(int) t56]
mov t58,eax
mov eax,0
mov stack[t57],t58
jmp etFor_3
et_10:
etFin_5:
mov edx,offset mensaje199
call writestring
mov edx,offset mensaje200
call writestring
ret
PY_pruebaFor endp
END main