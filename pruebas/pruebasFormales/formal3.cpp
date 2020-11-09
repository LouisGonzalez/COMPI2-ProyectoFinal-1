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
float t16;
float t17;
float t18;
float t19;
float t20;
float t21;
float t22;
float t23;
float t24;
float t25;
float t26;
float t27;
float t28;
float t29;
void JV_clase_programa() {
printf( " Introduzca una nota :");
printf( "\n");
scanf("%f", &t1);
t2 = p + 2;
stack[(int) t2] = t1;
t3 = p + 2;
t4 = stack[(int) t3];
t5 = p + 2;
t6 = stack[(int) t5];
if(t4 >= 0) { goto et_2; }
goto et_3;
et_2:
if(t6 < 5) { goto et_4; }
goto et_5;
et_4:
printf( " INSUFICIENTE");
printf( "\n");
goto etFin_1;
et_3:
et_5:
t7 = p + 2;
t8 = stack[(int) t7];
if(t8 == 5) { goto et_6; }
goto et_7;
et_6:
printf( " SUFICIENTE");
printf( "\n");
goto etFin_1;
et_7:
t9 = p + 2;
t10 = stack[(int) t9];
if(t10 == 6) { goto et_8; }
goto et_9;
et_8:
printf( " BIEN");
printf( "\n");
goto etFin_1;
et_9:
t11 = p + 2;
t12 = stack[(int) t11];
t13 = p + 2;
t14 = stack[(int) t13];
if(t12 == 7) { goto et_10; }
goto et_11;
et_10:
printf( " NOTABLE");
printf( "\n");
goto etFin_1;
et_11:
if(t14 == 8) { goto et_12; }
goto et_13;
et_12:
goto et_10;
et_13:
t15 = p + 2;
t16 = stack[(int) t15];
t17 = p + 2;
t18 = stack[(int) t17];
if(t16 == 9) { goto et_14; }
goto et_15;
et_14:
printf( " SOBRESALIENTE");
printf( "\n");
goto etFin_1;
et_15:
if(t18 == 10) { goto et_16; }
goto et_17;
et_16:
goto et_14;
et_17:
printf( " VALOR INVALIDO");
printf( "\n");
goto etFin_1;
etFin_1:
goto etFin_2;
etFin_2:
goto etFin_3;
etFin_3:
goto etFin_4;
etFin_4:
goto etFin_5;
etFin_5:
printf("");
}
void JV_clase_clase() {
t19 = p + 0;
stack[(int) t19] = h;
h = h + 0;
printf("");
}
int main() {
p = 0;
h = 0;
p = p + 1;
JV_clase_clase();
p = p - 1;
t22 = p + 1;
t23 = t22 + 0;
t24 = stack[(int)t23];
t25 = p + 0;
stack[(int)t25] = t24;
t26 = p + 0;
t27 = stack[(int)t26];
t28 = p + 1;
t29 = t28 + 0;
stack[(int)t29] = t27;
p = p + 1;
JV_clase_programa();
p = p - 1;
return 0;
}
