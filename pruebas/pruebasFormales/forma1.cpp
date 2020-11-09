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
float t72;
float t73;
float t74;
float t75;
float t76;
float t77;
float t78;
float t79;
float t80;
float t81;
float t82;
float t83;
float t84;
float t85;
float t86;
float t87;
float t88;
float t89;
float t90;
float t91;
float t92;
float t93;
float t94;
float t95;
float t96;
float t97;
float t98;
void JV_operaciones_vereficar_Integer_Integer() {
printf( " valor de global1 :");
t7 = p + 0;
t8 = stack[(int) t7];
t9 = t8 + 0;
t10 = heap[(int) t9];
printf("%f", t10);
printf( "\n");
t11 = h + 1;
heap[(int) t11] = 0;
etFor_1:
t12 = p + 0;
t13 = stack[(int) t12];
t14 = t13 + 1;
t15 = heap[(int) t14];
t16 = p + 0;
t17 = stack[(int) t16];
t18 = t17 + 1;
t19 = heap[(int) t18];
if(t15 < 10) { goto et_2; }
goto et_3;
et_2:
t21 = p + 0;
t22 = stack[(int) t21];
t23 = t22 + 1;
t24 = heap[(int) t23];
printf("%f", t24);
printf( "\n");
t20 = t19 + 1;
t25 = p + 0;
t26 = stack[(int) t25];
t27 = t26 + 1;
heap[(int) t27] = t20;
goto etFor_1;
et_3:
etFin_1:
printf("");
}
void JV_operaciones_suma_Integer_Integer() {
printf( " Escriba una opcion");
printf( "\n");
scanf("%f", &t28);
t29 = p + 4;
stack[(int) t29] = t28;
t30 = p + 4;
t31 = stack[(int) t30];
if(t31 == 1) { goto et_4; }
goto et_5;
et_4:
printf( " Hola mundo");
printf( "\n");
goto etFinal_0;
et_5:
if(t31 == 2) { goto et_6; }
goto et_7;
et_6:
printf( " segunda opcion");
printf( "\n");
goto etFinal_0;
et_7:
if(t31 == 3) { goto et_8; }
goto et_9;
et_8:
t32 = p + 2;
t33 = stack[(int) t32];
t34 = p + 3;
t35 = stack[(int) t34];
t36 = t33 + t35;
t37 = p + 5;
stack[(int) t37] = t36;
printf( " El resultado de la suma es :");
t38 = p + 5;
t39 = stack[(int) t38];
printf("%f", t39);
printf( "\n");
goto etFinal_0;
et_9:
printf( " opcion incorrecta");
printf( "\n");
etFinal_0:
printf("");
}
void JV_operaciones_resta_Integer_Integer() {
t40 = p + 2;
t41 = stack[(int) t40];
t42 = p + 3;
t43 = stack[(int) t42];
t44 = t41 - t43;
t45 = p + 4;
stack[(int) t45] = t44;
printf( " El resultado de la resta es :");
t46 = p + 4;
t47 = stack[(int) t46];
printf("%f", t47);
printf( "\n");
printf("");
}
void JV_operaciones_operaciones() {
t48 = p + 0;
stack[(int) t48] = h;
h = h + 2;
t1 = p + 0;
t2 = stack[(int) t1];
t3 = t2 + 0;
heap[(int) t3] = 12;
t4 = p + 0;
t5 = stack[(int) t4];
t6 = t5 + 1;
heap[(int) t6] = 0;
printf("");
}
int main() {
p = 0;
h = 0;
printf( " Opciones :");
printf( "\n");
printf( " 1 . Sumar :");
printf( "\n");
printf( " 2 . Restar :");
printf( "\n");
printf( " 3 . Alcanzar :");
printf( "\n");
printf( " Ingrese primer numero :");
printf( "\n");
scanf("%f", &t51);
t52 = p + 0;
stack[(int)t52] = t51;
printf( " Ingrese segundo numero :");
printf( "\n");
scanf("%f", &t53);
t54 = p + 1;
stack[(int)t54] = t53;
p = p + 4;
JV_operaciones_operaciones();
p = p - 4;
t55 = p + 4;
t56 = t55 + 0;
t57 = stack[(int)t56];
t58 = p + 3;
stack[(int)t58] = t57;
printf( " Ingrese numero menu :");
printf( "\n");
scanf("%f", &t59);
t60 = p + 2;
stack[(int)t60] = t59;
t61 = p + 2;
t62 = stack[(int)t61];
if(t62 == 1) { goto et_12; }
goto et_13;
et_12:
t63 = p + 0;
t64 = stack[(int)t63];
t65 = p + 1;
t66 = stack[(int)t65];
t67 = p + 4;
t68 = t67 + 2;
stack[(int)t68] = t64;
t69 = p + 4;
t70 = t69 + 3;
stack[(int)t70] = t66;
t71 = p + 3;
t72 = stack[(int)t71];
t73 = p + 4;
t74 = t73 + 0;
stack[(int)t74] = t72;
p = p + 4;
JV_operaciones_suma_Integer_Integer();
p = p - 4;
goto etFinal_0;
et_13:
if(t62 == 2) { goto et_14; }
goto et_15;
et_14:
t75 = p + 0;
t76 = stack[(int)t75];
t77 = p + 1;
t78 = stack[(int)t77];
t79 = p + 4;
t80 = t79 + 2;
stack[(int)t80] = t76;
t81 = p + 4;
t82 = t81 + 3;
stack[(int)t82] = t78;
t83 = p + 3;
t84 = stack[(int)t83];
t85 = p + 4;
t86 = t85 + 0;
stack[(int)t86] = t84;
p = p + 4;
JV_operaciones_resta_Integer_Integer();
p = p - 4;
goto etFinal_0;
et_15:
if(t62 == 3) { goto et_16; }
goto et_17;
et_16:
t87 = p + 0;
t88 = stack[(int)t87];
t89 = p + 1;
t90 = stack[(int)t89];
t91 = p + 4;
t92 = t91 + 2;
stack[(int)t92] = t88;
t93 = p + 4;
t94 = t93 + 3;
stack[(int)t94] = t90;
t95 = p + 3;
t96 = stack[(int)t95];
t97 = p + 4;
t98 = t97 + 0;
stack[(int)t98] = t96;
p = p + 4;
JV_operaciones_vereficar_Integer_Integer();
p = p - 4;
goto etFinal_0;
et_17:
etFinal_0:
return 0;
}
