#include <stdio.h>
#include <stdlib.h>
float stack[100000000];
float heap[10000000];
int p;
int h;
float t0;
float t1;
float t2;
float t3;
float t4;
float t5;
float t6;
float t7;
float t8;
float t9;
float t10;
float t11;
float t12;
float t13;
float t14;
float t15;
void JV_clase_programa() {
printf( " Introduzca una nota");
printf( "\n");
scanf("%f", &t1);
t2 = p + 2;
stack[(int) t2] = t1;
t3 = p + 2;
t4 = stack[(int) t3];
if(t4 == 0) { goto et_2; }
goto et_3;
et_2:
goto etFinal_0;
et_3:
if(t4 == 1) { goto et_4; }
goto et_5;
et_4:
goto etFinal_0;
et_5:
if(t4 == 2) { goto et_6; }
goto et_7;
et_6:
goto etFinal_0;
et_7:
if(t4 == 3) { goto et_8; }
goto et_9;
et_8:
goto etFinal_0;
et_9:
if(t4 == 4) { goto et_10; }
goto et_11;
et_10:
printf( " INSUFICIENTE");
printf( "\n");
goto etFinal_0;
et_11:
if(t4 == 5) { goto et_12; }
goto et_13;
et_12:
printf( " SUFICIENTE");
printf( "\n");
goto etFinal_0;
et_13:
if(t4 == 6) { goto et_14; }
goto et_15;
et_14:
printf( " BIEN");
printf( "\n");
goto etFinal_0;
et_15:
if(t4 == 7) { goto et_16; }
goto et_17;
et_16:
goto etFinal_0;
et_17:
if(t4 == 8) { goto et_18; }
goto et_19;
et_18:
printf( " NOTABLE");
printf( "\n");
goto etFinal_0;
et_19:
if(t4 == 9) { goto et_20; }
goto et_21;
et_20:
goto etFinal_0;
et_21:
if(t4 == 10) { goto et_22; }
goto et_23;
et_22:
printf( " SOBRESALIENTE");
printf( "\n");
goto etFinal_0;
et_23:
printf( " ERROR");
printf( "\n");
etFinal_0:
printf("");
}
void JV_clase_clase() {
t5 = p + 0;
stack[(int) t5] = h;
h = h + 0;
printf("");
}
int main() {
p = 0;
h = 0;
p = p + 1;
JV_clase_clase();
p = p - 1;
t8 = p + 1;
t9 = t8 + 0;
t10 = stack[(int)t9];
t11 = p + 0;
stack[(int)t11] = t10;
t12 = p + 0;
t13 = stack[(int)t12];
t14 = p + 1;
t15 = t14 + 0;
stack[(int)t15] = t13;
p = p + 1;
JV_clase_programa();
p = p - 1;
return 0;
}
