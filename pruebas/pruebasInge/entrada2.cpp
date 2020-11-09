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
float t99;
float t100;
float t101;
float t102;
float t103;
float t104;
float t105;
float t106;
void JV_operaciones_vereficar_Integer_Integer() {
printf( " valor de global1 :");
t4 = p + 0;
t5 = stack[(int) t4];
t6 = t5 + 0;
t7 = heap[(int) t6];
printf("%f", t7);
printf( "\n");
t8 = p + 2;
t9 = stack[(int) t8];
t10 = p + 3;
t11 = stack[(int) t10];
if(t9 < t11) { goto et_2; }
goto et_3;
et_2:
etWhile_1:
t12 = p + 3;
t13 = stack[(int) t12];
t14 = p + 2;
t15 = stack[(int) t14];
if(t13 > t15) { goto et_4; }
goto et_5;
et_4:
t16 = p + 2;
t17 = stack[(int) t16];
t18 = t17 + 1;
t19 = p + 2;
stack[(int) t19] = t18;
printf( " estoy alcanzando a");
t20 = p + 3;
t21 = stack[(int) t20];
printf("%f", t21);
printf( "");
t22 = p + 2;
t23 = stack[(int) t22];
printf("%f", t23);
printf( "\n");
goto etWhile_1;
et_5:
etFin_1:
printf( " ya lo alcanze");
printf( "\n");
goto etFin_2;
et_3:
etWhile_2:
t24 = p + 2;
t25 = stack[(int) t24];
t26 = p + 3;
t27 = stack[(int) t26];
if(t25 > t27) { goto et_6; }
goto et_7;
et_6:
t28 = p + 3;
t29 = stack[(int) t28];
t30 = t29 + 1;
t31 = p + 3;
stack[(int) t31] = t30;
printf( " estoy alcanzando a");
t32 = p + 2;
t33 = stack[(int) t32];
printf("%f", t33);
printf( "");
t34 = p + 3;
t35 = stack[(int) t34];
printf("%f", t35);
printf( "\n");
goto etWhile_2;
et_7:
etFin_2:
goto etFin_3;
etFin_3:
printf("");
}
void JV_operaciones_suma_Integer_Integer() {
printf( " Escriba una opcion");
printf( "\n");
scanf("%f", &t36);
t37 = p + 4;
stack[(int) t37] = t36;
t38 = p + 4;
t39 = stack[(int) t38];
if(t39 == 1) { goto et_8; }
goto et_9;
et_8:
printf( " Hola mundo");
printf( "\n");
goto etFinal_0;
et_9:
if(t39 == 2) { goto et_10; }
goto et_11;
et_10:
printf( " segunda opcion");
printf( "\n");
goto etFinal_0;
et_11:
if(t39 == 3) { goto et_12; }
goto et_13;
et_12:
t40 = p + 2;
t41 = stack[(int) t40];
t42 = p + 3;
t43 = stack[(int) t42];
t44 = t41 + t43;
t45 = p + 5;
stack[(int) t45] = t44;
printf( " El resultado de la suma es :");
t46 = p + 5;
t47 = stack[(int) t46];
printf("%f", t47);
printf( "\n");
goto etFinal_0;
et_13:
printf( " opcion incorrecta");
printf( "\n");
etFinal_0:
printf("");
}
void JV_operaciones_resta_Integer_Integer() {
t48 = p + 2;
t49 = stack[(int) t48];
t50 = p + 3;
t51 = stack[(int) t50];
t52 = t49 - t51;
t53 = p + 4;
stack[(int) t53] = t52;
printf( " El resultado de la resta es :");
t54 = p + 4;
t55 = stack[(int) t54];
printf("%f", t55);
printf( "\n");
printf("");
}
void JV_operaciones_operaciones() {
t56 = p + 0;
stack[(int) t56] = h;
h = h + 1;
t1 = p + 0;
t2 = stack[(int) t1];
t3 = t2 + 0;
heap[(int) t3] = 12;
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
scanf("%f", &t59);
t60 = p + 0;
stack[(int)t60] = t59;
printf( " Ingrese segundo numero :");
printf( "\n");
scanf("%f", &t61);
t62 = p + 1;
stack[(int)t62] = t61;
p = p + 4;
JV_operaciones_operaciones();
p = p - 4;
t63 = p + 4;
t64 = t63 + 0;
t65 = stack[(int)t64];
t66 = p + 3;
stack[(int)t66] = t65;
printf( " Ingrese numero menu :");
printf( "\n");
scanf("%f", &t67);
t68 = p + 2;
stack[(int)t68] = t67;
t69 = p + 2;
t70 = stack[(int)t69];
if(t70 == 1) { goto et_16; }
goto et_17;
et_16:
t71 = p + 0;
t72 = stack[(int)t71];
t73 = p + 1;
t74 = stack[(int)t73];
t75 = p + 4;
t76 = t75 + 2;
stack[(int)t76] = t72;
t77 = p + 4;
t78 = t77 + 3;
stack[(int)t78] = t74;
t79 = p + 3;
t80 = stack[(int)t79];
t81 = p + 4;
t82 = t81 + 0;
stack[(int)t82] = t80;
p = p + 4;
JV_operaciones_suma_Integer_Integer();
p = p - 4;
goto etFinal_0;
et_17:
if(t70 == 2) { goto et_18; }
goto et_19;
et_18:
t83 = p + 0;
t84 = stack[(int)t83];
t85 = p + 1;
t86 = stack[(int)t85];
t87 = p + 4;
t88 = t87 + 2;
stack[(int)t88] = t84;
t89 = p + 4;
t90 = t89 + 3;
stack[(int)t90] = t86;
t91 = p + 3;
t92 = stack[(int)t91];
t93 = p + 4;
t94 = t93 + 0;
stack[(int)t94] = t92;
p = p + 4;
JV_operaciones_resta_Integer_Integer();
p = p - 4;
goto etFinal_0;
et_19:
if(t70 == 3) { goto et_20; }
goto et_21;
et_20:
t95 = p + 0;
t96 = stack[(int)t95];
t97 = p + 1;
t98 = stack[(int)t97];
t99 = p + 4;
t100 = t99 + 2;
stack[(int)t100] = t96;
t101 = p + 4;
t102 = t101 + 3;
stack[(int)t102] = t98;
t103 = p + 3;
t104 = stack[(int)t103];
t105 = p + 4;
t106 = t105 + 0;
stack[(int)t106] = t104;
p = p + 4;
JV_operaciones_vereficar_Integer_Integer();
p = p - 4;
goto etFinal_0;
et_21:
etFinal_0:
return 0;
}
