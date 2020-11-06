#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
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
float t30;
float t31;
float t32;
float t33;
float t34;
float t35;
float t36;
float t37;
float t38;
float t39;
float t40;
float t41;
float t42;
float t43;
float t44;
float t45;
float t46;
float t47;
float t48;
float t49;
float t50;
float t51;
float t52;
float t53;
float t54;
float t55;
float t56;
float t57;
float t58;
float t59;
float t60;
float t61;
void VB_Factorial_Integer() {
t1 = p + 1;
t2 = stack[(int) t1];
t3 = p + 3;
stack[(int) t3] = t2;
t4 = p + 3;
t5 = stack[(int) t4];
if(1 > 1) { goto et_1; }
goto et_2;
et_1:
if(t5 > 1) { goto et_3; }
goto et_4;
et_3:
t6 = p + 3;
t7 = stack[(int) t6];
t8 = p + 6;
t9 = t8 + 1;
stack[(int) t9] = 123;
p = p + 6;
VB_Factorial_Integer();
p = p - 6;
t10 = p + 6;
t11 = t10 + 0;
t12 = stack[(int) t11];
t13 = t7 + t12;
t14 = p + 5;
stack[(int) t14] = t13;
goto etFin_0;
et_4:
if(4 > 1) { goto et_5; }
goto et_6;
et_5:
goto et_3;
et_2:
et_6:
etFin_0:
t15 = p + 0;
stack[(int) t15] = 2;
printf("");
}
void VB_xxx() {
t17 = p + 2;
stack[(int) t17] = 0;
etFor_0:
t20 = p + 2;
t21 = stack[(int) t20];
if(t21 <= 10) { goto et_7; }
goto et_8;
et_7:
t22 = p + 2;
t23 = stack[(int) t22];
printf("%f", t23);
printf( "\n");
t24 = p + 2;
t25 = stack[(int) t24];
t18 = p + 2;
t19 = stack[(int) t18] + 1;
stack[(int) t18] = t19;
goto etFor_0;
et_8:
etFin_1:
printf("");
}
void JV_algo_factorial() {
t27 = 1 + 1;
t28 = p + 0;
t29 = stack[(int) t28];
t30 = p + 1;
t31 = t30 + 0;
stack[(int) t31] = t29;
p = p + 1;
JV_algo_factorial();
p = p - 1;
t32 = p + 1;
t33 = t32 + 1;
t34 = stack[(int) t33];
t35 = t27 + t34;
t36 = p + 2;
stack[(int) t36] = t35;
t37 = p + 2;
stack[(int) t37] = 12;
printf( " Hola mudno");
t38 = p + 2;
t39 = stack[(int) t38];
printf("%f", t39);
printf( "\n");
t40 = p + 1;
stack[(int) t40] = 34;
printf("");
}
void JV_algo_algo() {
t41 = p + 0;
stack[(int) t41] = h;
h = h + 2;
printf("");
}
void JV_algo_algo_Integer() {
t42 = p + 0;
stack[(int) t42] = h;
h = h + 2;
t43 = p + 1;
t44 = stack[(int) t43];
t45 = p + 0;
t46 = stack[(int) t45];
t47 = t46 + 0;
heap[(int) t47] = t44;
printf("");
}
void PY_edadmeses() {
printf( " HOla mundo");
printf( "\n");
t49 = p + 4;
t50 = t49 + 1;
stack[(int) t50] = 4;
t51 = p + 4;
t52 = t51 + 2;
stack[(int) t52] = 5;
p = p + 4;
PY_edadmeses();
p = p - 4;
t53 = p + 4;
t54 = t53 + 0;
t55 = stack[(int) t54];
t56 = 12 + t55;
t57 = p + 3;
stack[(int) t57] = t56;
printf("");
}
int main() {
p = 0;
h = 0;
t59 = p + 0;
stack[(int)t59] = 0;
printf( " hola mundo");
printf( "\n");
printf( " hola mundo");
printf( "\n");
printf( " hola mundo");
printf( "\n");
printf( " hola mundo");
printf( "\n");
printf( " hola mundo");
printf( "\n");
printf( " hola mundo");
printf( "\n");
scanf("%f", &t60);
t61 = p + 0;
stack[(int)t61] = t60;
return 0;
}
