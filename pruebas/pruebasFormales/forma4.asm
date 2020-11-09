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
mensaje17 BYTE " Introduzca una nota",0
mensaje18 BYTE "\n",0
mensaje47 BYTE " INSUFICIENTE",0
mensaje48 BYTE "\n",0
mensaje54 BYTE " SUFICIENTE",0
mensaje55 BYTE "\n",0
mensaje61 BYTE " BIEN",0
mensaje62 BYTE "\n",0
mensaje73 BYTE " NOTABLE",0
mensaje74 BYTE "\n",0
mensaje85 BYTE " SOBRESALIENTE",0
mensaje86 BYTE "\n",0
mensaje89 BYTE " ERROR",0
mensaje90 BYTE "\n",0
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
mov t8,eax
mov eax,0
mov eax,0
add eax,t8
add eax,0
mov t9,eax
mov eax,0
mov t10,stack[t9]
mov eax,0
add eax,p
add eax,0
mov t11,eax
mov eax,0
mov stack[t11],t10
mov eax,0
add eax,p
add eax,0
mov t12,eax
mov eax,0
mov t13,stack[t12]
mov eax,0
add eax,p
add eax,1
mov t14,eax
mov eax,0
mov eax,0
add eax,t14
add eax,0
mov t15,eax
mov eax,0
mov stack[t15],t13
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
mov edx,offset mensaje17
call writestring
mov edx,offset mensaje18
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
.IF(t4 == 0)
jmp et_2
.ENDIF
jmp et_3
et_2:
jmp etFinal_0
et_3:
.IF(t4 == 1)
jmp et_4
.ENDIF
jmp et_5
et_4:
jmp etFinal_0
et_5:
.IF(t4 == 2)
jmp et_6
.ENDIF
jmp et_7
et_6:
jmp etFinal_0
et_7:
.IF(t4 == 3)
jmp et_8
.ENDIF
jmp et_9
et_8:
jmp etFinal_0
et_9:
.IF(t4 == 4)
jmp et_10
.ENDIF
jmp et_11
et_10:
mov edx,offset mensaje47
call writestring
mov edx,offset mensaje48
call writestring
jmp etFinal_0
et_11:
.IF(t4 == 5)
jmp et_12
.ENDIF
jmp et_13
et_12:
mov edx,offset mensaje54
call writestring
mov edx,offset mensaje55
call writestring
jmp etFinal_0
et_13:
.IF(t4 == 6)
jmp et_14
.ENDIF
jmp et_15
et_14:
mov edx,offset mensaje61
call writestring
mov edx,offset mensaje62
call writestring
jmp etFinal_0
et_15:
.IF(t4 == 7)
jmp et_16
.ENDIF
jmp et_17
et_16:
jmp etFinal_0
et_17:
.IF(t4 == 8)
jmp et_18
.ENDIF
jmp et_19
et_18:
mov edx,offset mensaje73
call writestring
mov edx,offset mensaje74
call writestring
jmp etFinal_0
et_19:
.IF(t4 == 9)
jmp et_20
.ENDIF
jmp et_21
et_20:
jmp etFinal_0
et_21:
.IF(t4 == 10)
jmp et_22
.ENDIF
jmp et_23
et_22:
mov edx,offset mensaje85
call writestring
mov edx,offset mensaje86
call writestring
jmp etFinal_0
et_23:
mov edx,offset mensaje89
call writestring
mov edx,offset mensaje90
call writestring
etFinal_0:
ret
JV_clase_programa endp
JV_clase_clase proc
mov eax,0
add eax,p
add eax,0
mov t5,eax
mov eax,0
mov stack[t5],h
mov eax,0
add eax,h
add eax,0
mov h,eax
mov eax,0
ret
JV_clase_clase endp
END main