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
mensaje112 BYTE t23,0
mensaje113 BYTE "\n",0
mensaje141 BYTE " Hola mudno",0
mensaje144 BYTE t39,0
mensaje145 BYTE "\n",0
mensaje166 BYTE " HOla mundo",0
mensaje167 BYTE "\n",0
mensaje189 BYTE " hola mundo",0
mensaje190 BYTE "\n",0
mensaje191 BYTE " hola mundo",0
mensaje192 BYTE "\n",0
mensaje193 BYTE " hola mundo",0
mensaje194 BYTE "\n",0
mensaje195 BYTE " hola mundo",0
mensaje196 BYTE "\n",0
mensaje197 BYTE " hola mundo",0
mensaje198 BYTE "\n",0
mensaje199 BYTE " hola mundo",0
mensaje200 BYTE "\n",0
.code
main proc
mov p,0
mov h,0
mov eax,0
add eax,p
add eax,0
mov t59,eax
mov eax,0
mov stack[t59],0
mov edx,offset mensaje189
call writestringmov edx,offset mensaje190
call writestringmov edx,offset mensaje191
call writestringmov edx,offset mensaje192
call writestringmov edx,offset mensaje193
call writestringmov edx,offset mensaje194
call writestringmov edx,offset mensaje195
call writestringmov edx,offset mensaje196
call writestringmov edx,offset mensaje197
call writestringmov edx,offset mensaje198
call writestringmov edx,offset mensaje199
call writestringmov edx,offset mensaje200
call writestringcall readdec
mov t60,eax
mov eax,0
add eax,p
add eax,0
mov t61,eax
mov eax,0
mov stack[t61],t60
EXIT
main ENDP
VB_Factorial_Integer proc
mov eax,0
add eax,p
add eax,1
mov t1,eax
mov eax,0
mov t2,stack[t1]
mov eax,0
add eax,p
add eax,3
mov t3,eax
mov eax,0
mov stack[t3],t2
mov eax,0
add eax,p
add eax,3
mov t4,eax
mov eax,0
mov t5,stack[t4]
.IF(1 > 1)
jmp et_1
.ENDIF
jmp et_2
et_1:
.IF(t5 > 1)
jmp et_3
.ENDIF
jmp et_4
et_3:
mov eax,0
add eax,p
add eax,3
mov t6,eax
mov eax,0
mov t7,stack[t6]
mov eax,0
add eax,p
add eax,6
mov t8,eax
mov eax,0
mov eax,0
add eax,t8
add eax,1
mov t9,eax
mov eax,0
mov stack[t9],123
mov eax,0
add eax,p
add eax,6
mov p,eax
mov eax,0
call VB_Factorial_Integer
mov eax,0
add eax,p
sub eax,6
mov p,eax
mov eax,0
mov eax,0
add eax,p
add eax,6
mov t10,eax
mov eax,0
mov eax,0
add eax,t10
add eax,0
mov t11,eax
mov eax,0
mov t12,stack[t11]
mov eax,0
add eax,t7
add eax,t12
mov t13,eax
mov eax,0
mov eax,0
add eax,p
add eax,5
mov t14,eax
mov eax,0
mov stack[t14],t13
jmp etFin_0
et_4:
.IF(4 > 1)
jmp et_5
.ENDIF
jmp et_6
et_5:
jmp et_3
et_2:
et_6:
etFin_0:
mov eax,0
add eax,p
add eax,0
mov t15,eax
mov eax,0
mov stack[t15],2
ret
VB_Factorial_Integer endp
VB_xxx proc
mov eax,0
add eax,p
add eax,2
mov t17,eax
mov eax,0
mov stack[t17],0
etFor_0:
mov eax,0
add eax,p
add eax,2
mov t20,eax
mov eax,0
mov t21,stack[t20]
.IF(t21 <= 10)
jmp et_7
.ENDIF
jmp et_8
et_7:
mov eax,0
add eax,p
add eax,2
mov t22,eax
mov eax,0
mov t23,stack[t22]
mov edx,offset mensaje112
call writestringmov edx,offset mensaje113
call writestringmov eax,0
add eax,p
add eax,2
mov t24,eax
mov eax,0
mov t25,stack[t24]
mov eax,0
add eax,p
add eax,2
mov t18,eax
mov eax,0
mov eax,0
add eax,stack[(int) t18]
add eax,1
mov t19,eax
mov eax,0
mov stack[t18],t19
jmp etFor_0
et_8:
etFin_1:
ret
VB_xxx endp
JV_algo_factorial proc
mov eax,0
add eax,1
add eax,1
mov t27,eax
mov eax,0
mov eax,0
add eax,p
add eax,0
mov t28,eax
mov eax,0
mov t29,stack[t28]
mov eax,0
add eax,p
add eax,1
mov t30,eax
mov eax,0
mov eax,0
add eax,t30
add eax,0
mov t31,eax
mov eax,0
mov stack[t31],t29
mov eax,0
add eax,p
add eax,1
mov p,eax
mov eax,0
call JV_algo_factorial
mov eax,0
add eax,p
sub eax,1
mov p,eax
mov eax,0
mov eax,0
add eax,p
add eax,1
mov t32,eax
mov eax,0
mov eax,0
add eax,t32
add eax,1
mov t33,eax
mov eax,0
mov t34,stack[t33]
mov eax,0
add eax,t27
add eax,t34
mov t35,eax
mov eax,0
mov eax,0
add eax,p
add eax,2
mov t36,eax
mov eax,0
mov stack[t36],t35
mov eax,0
add eax,p
add eax,2
mov t37,eax
mov eax,0
mov stack[t37],12
mov edx,offset mensaje141
call writestringmov eax,0
add eax,p
add eax,2
mov t38,eax
mov eax,0
mov t39,stack[t38]
mov edx,offset mensaje144
call writestringmov edx,offset mensaje145
call writestringmov eax,0
add eax,p
add eax,1
mov t40,eax
mov eax,0
mov stack[t40],34
ret
JV_algo_factorial endp
JV_algo_algo proc
mov eax,0
add eax,p
add eax,0
mov t41,eax
mov eax,0
mov stack[t41],h
mov eax,0
add eax,h
add eax,2
mov h,eax
mov eax,0
ret
JV_algo_algo endp
JV_algo_algo_Integer proc
mov eax,0
add eax,p
add eax,0
mov t42,eax
mov eax,0
mov stack[t42],h
mov eax,0
add eax,h
add eax,2
mov h,eax
mov eax,0
mov eax,0
add eax,p
add eax,1
mov t43,eax
mov eax,0
mov t44,stack[t43]
mov eax,0
add eax,p
add eax,0
mov t45,eax
mov eax,0
mov t46,stack[t45]
mov eax,0
add eax,t46
add eax,0
mov t47,eax
mov eax,0
mov heap[t47],t44
ret
JV_algo_algo_Integer endp
PY_edadmeses proc
mov edx,offset mensaje166
call writestringmov edx,offset mensaje167
call writestringmov eax,0
add eax,p
add eax,4
mov t49,eax
mov eax,0
mov eax,0
add eax,t49
add eax,1
mov t50,eax
mov eax,0
mov stack[t50],4
mov eax,0
add eax,p
add eax,4
mov t51,eax
mov eax,0
mov eax,0
add eax,t51
add eax,2
mov t52,eax
mov eax,0
mov stack[t52],5
mov eax,0
add eax,p
add eax,4
mov p,eax
mov eax,0
call PY_edadmeses
mov eax,0
add eax,p
sub eax,4
mov p,eax
mov eax,0
mov eax,0
add eax,p
add eax,4
mov t53,eax
mov eax,0
mov eax,0
add eax,t53
add eax,0
mov t54,eax
mov eax,0
mov t55,stack[t54]
mov eax,0
add eax,12
add eax,t55
mov t56,eax
mov eax,0
mov eax,0
add eax,p
add eax,3
mov t57,eax
mov eax,0
mov stack[t57],t56
ret
PY_edadmeses endp
END main