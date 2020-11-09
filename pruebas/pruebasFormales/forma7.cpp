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
float t62;
float t63;
float t64;
float t65;
float t66;
float t67;
float t68;
float t69;
float t70;
float t71;
void VB_pruebaForVb() {
printf( " Ingrese primer numero :");
printf( "\n");
scanf("%f", &t1);
t2 = p + 1;
stack[(int) t2] = t1;
printf( " Ingrese segundo numero :");
printf( "\n");
scanf("%f", &t3);
t4 = p + 2;
stack[(int) t4] = t3;
t5 = p + 1;
t6 = stack[(int) t5];
t7 = p + 2;
t8 = stack[(int) t7];
if(t6 > t8) { goto et_1; }
goto et_2;
et_1:
t9 = p + 1;
t10 = stack[(int) t9];
t11 = p + 0;
stack[(int) t11] = t10;
goto etFin_0;
et_2:
t12 = p + 2;
t13 = stack[(int) t12];
t14 = p + 0;
stack[(int) t14] = t13;
goto etFin_0;
etFin_0:
printf("");
}
void JV_clase_mostrar_Integer_Integer() {
t16 = p + 4;
stack[(int) t16] = 0;
t17 = p + 5;
stack[(int) t17] = 0;
t18 = p + 2;
t19 = stack[(int) t18];
t20 = p + 3;
t21 = stack[(int) t20];
if(t19 > t21) { goto et_4; }
goto et_5;
et_4:
t22 = p + 2;
t23 = stack[(int) t22];
t24 = p + 4;
stack[(int) t24] = t23;
t25 = p + 3;
t26 = stack[(int) t25];
t27 = p + 5;
stack[(int) t27] = t26;
goto etFin_2;
et_5:
t28 = p + 3;
t29 = stack[(int) t28];
t30 = p + 4;
stack[(int) t30] = t29;
t31 = p + 2;
t32 = stack[(int) t31];
t33 = p + 5;
stack[(int) t33] = t32;
goto etFin_2;
etFin_2:
t34 = p + 5;
t35 = stack[(int) t34];
t36 = p + 6;
stack[(int) t36] = t35;
etFor_1:
t37 = p + 6;
t38 = stack[(int) t37];
t39 = p + 4;
t40 = stack[(int) t39];
t41 = p + 6;
t42 = stack[(int) t41];
if(t38 <= t40) { goto et_6; }
goto et_7;
et_6:
t44 = p + 6;
t45 = stack[(int) t44];
printf("%f", t45);
printf( "");
printf( "\n");
printf( "");
printf( "\n");
t43 = t42 + 1;
t46 = p + 6;
stack[(int) t46] = t43;
goto etFor_1;
et_7:
etFin_3:
printf("");
}
void JV_clase_clase() {
t47 = p + 0;
stack[(int) t47] = h;
h = h + 0;
printf("");
}
void PY_pruebaFor() {
t49 = p + 1;
stack[(int) t49] = 5;
t50 = p + 2;
stack[(int) t50] = 20;
t51 = p + 3;
stack[(int) t51] = 2;
t52 = p + 1;
t53 = stack[(int) t52];
t54 = p + 2;
t55 = stack[(int) t54];
t59 = p + 4;
stack[(int) t59] = t53;
etFor_3:
t60 = p + 4;
t61 = stack[(int) t60];
if(t61 <= t55) { goto et_9; }
goto et_10;
et_9:
printf( " hola mundo");
t62 = p + 4;
t63 = stack[(int) t62];
printf("%f", t63);
printf( "\n");
t56 = p + 3;
t57 = p + 4;
t58 = stack[(int) t57] + stack[(int) t56];
stack[(int) t57] = t58;
goto etFor_3;
et_10:
etFin_5:
printf( " fin metodo");
printf( "\n");
printf("");
}
int main() {
p = 0;
h = 0;
p = p + 2;
VB_pruebaForVb();
p = p - 2;
t65 = p + 2;
t66 = t65 + 0;
t67 = stack[(int)t66];
t68 = 12 + t67;
t69 = p + 0;
stack[(int)t69] = t68;
printf( " El valor de a es :");
t70 = p + 0;
t71 = stack[(int)t70];
printf("%f", t71);
printf( "\n");
return 0;
}
