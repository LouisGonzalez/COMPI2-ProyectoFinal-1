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
mensaje31 BYTE " Introduzca una nota :",0
mensaje32 BYTE "\n",0
mensaje46 BYTE " INSUFICIENTE",0
mensaje47 BYTE "\n",0
mensaje56 BYTE " SUFICIENTE",0
mensaje57 BYTE "\n",0
mensaje65 BYTE " BIEN",0
mensaje66 BYTE "\n",0
mensaje76 BYTE " NOTABLE",0
mensaje77 BYTE "\n",0
mensaje92 BYTE " SOBRESALIENTE",0
mensaje93 BYTE "\n",0
mensaje101 BYTE " VALOR INVALIDO",0
mensaje102 BYTE "\n",0
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
mov t22,eax
mov eax,0
mov eax,0
add eax,t22
add eax,0
mov t23,eax
mov eax,0
mov t24,stack[t23]
mov eax,0
add eax,p
add eax,0
mov t25,eax
mov eax,0
mov stack[t25],t24
mov eax,0
add eax,p
add eax,0
mov t26,eax
mov eax,0
mov t27,stack[t26]
mov eax,0
add eax,p
add eax,1
mov t28,eax
mov eax,0
mov eax,0
add eax,t28
add eax,0
mov t29,eax
mov eax,0
mov stack[t29],t27
mov eax,0
add eax,p
add eax,1
mov p,eax
mov eax,0
call JV_clase_programa
mov eax,0
add eax,p
sub eax,1
mov p,eax
mov eax,0
EXIT
main ENDP
JV_clase_programa proc
mov edx,offset mensaje31
call writestring
mov edx,offset mensaje32
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
mov eax,0
add eax,p
add eax,2
mov t5,eax
mov eax,0
mov t6,stack[t5]
.IF(t4 >= 0)
jmp et_2
.ENDIF
jmp et_3
et_2:
.IF(t6 < 5)
jmp et_4
.ENDIF
jmp et_5
et_4:
mov edx,offset mensaje46
call writestring
mov edx,offset mensaje47
call writestring
jmp etFin_1
et_3:
et_5:
mov eax,0
add eax,p
add eax,2
mov t7,eax
mov eax,0
mov t8,stack[t7]
.IF(t8 == 5)
jmp et_6
.ENDIF
jmp et_7
et_6:
mov edx,offset mensaje56
call writestring
mov edx,offset mensaje57
call writestring
jmp etFin_1
et_7:
mov eax,0
add eax,p
add eax,2
mov t9,eax
mov eax,0
mov t10,stack[t9]
.IF(t10 == 6)
jmp et_8
.ENDIF
jmp et_9
et_8:
mov edx,offset mensaje65
call writestring
mov edx,offset mensaje66
call writestring
jmp etFin_1
et_9:
mov eax,0
add eax,p
add eax,2
mov t11,eax
mov eax,0
mov t12,stack[t11]
mov eax,0
add eax,p
add eax,2
mov t13,eax
mov eax,0
mov t14,stack[t13]
.IF(t12 == 7)
jmp et_10
.ENDIF
jmp et_11
et_10:
mov edx,offset mensaje76
call writestring
mov edx,offset mensaje77
call writestring
jmp etFin_1
et_11:
.IF(t14 == 8)
jmp et_12
.ENDIF
jmp et_13
et_12:
jmp et_10
et_13:
mov eax,0
add eax,p
add eax,2
mov t15,eax
mov eax,0
mov t16,stack[t15]
mov eax,0
add eax,p
add eax,2
mov t17,eax
mov eax,0
mov t18,stack[t17]
.IF(t16 == 9)
jmp et_14
.ENDIF
jmp et_15
et_14:
mov edx,offset mensaje92
call writestring
mov edx,offset mensaje93
call writestring
jmp etFin_1
et_15:
.IF(t18 == 10)
jmp et_16
.ENDIF
jmp et_17
et_16:
jmp et_14
et_17:
mov edx,offset mensaje101
call writestring
mov edx,offset mensaje102
call writestring
jmp etFin_1
etFin_1:
jmp etFin_2
etFin_2:
jmp etFin_3
etFin_3:
jmp etFin_4
etFin_4:
jmp etFin_5
etFin_5:
ret
JV_clase_programa endp
JV_clase_clase proc
mov eax,0
add eax,p
add eax,0
mov t19,eax
mov eax,0
mov stack[t19],h
mov eax,0
add eax,h
add eax,0
mov h,eax
mov eax,0
ret
JV_clase_clase endp
END main