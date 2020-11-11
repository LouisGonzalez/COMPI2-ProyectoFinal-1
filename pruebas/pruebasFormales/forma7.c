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
float t107;
float t108;
float t109;
float t110;
float t111;
float t112;
float t113;
float t114;
float t115;
float t116;
float t117;
float t118;
float t119;
float t120;
float t121;
float t122;
float t123;
float t124;
float t125;
float t126;
float t127;
float t128;
float t129;
float t130;
float t131;
float t132;
float t133;
float t134;
float t135;
float t136;
float t137;
float t138;
float t139;
float t140;
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
void VB_suma_Integer_Integer() {
t16 = p + 1;
t17 = stack[(int) t16];
t18 = p + 2;
t19 = stack[(int) t18];
t20 = t17 + t19;
t21 = p + 3;
stack[(int) t21] = t20;
t22 = p + 3;
t23 = stack[(int) t22];
t24 = p + 0;
stack[(int) t24] = t23;
printf("");
}
void VB_llamarSuma() {
printf( " Ingrese primer numero :");
printf( "\n");
scanf("%f", &t26);
t27 = p + 2;
stack[(int) t27] = t26;
printf( " Ingrese segundo numero :");
printf( "\n");
scanf("%f", &t28);
t29 = p + 3;
stack[(int) t29] = t28;
t30 = p + 2;
t31 = stack[(int) t30];
t32 = p + 3;
t33 = stack[(int) t32];
t34 = p + 4;
t35 = t34 + 1;
stack[(int) t35] = t31;
t36 = p + 4;
t37 = t36 + 2;
stack[(int) t37] = t33;
p = p + 4;
VB_suma_Integer_Integer();
p = p - 4;
t38 = p + 4;
t39 = t38 + 0;
t40 = stack[(int) t39];
t41 = p + 1;
stack[(int) t41] = t40;
printf( " la suma es :");
t42 = p + 1;
t43 = stack[(int) t42];
printf("%f", t43);
printf( "\n");
printf("");
}
void JV_clase_mostrar_Integer_Integer() {
t45 = p + 4;
stack[(int) t45] = 0;
t46 = p + 5;
stack[(int) t46] = 0;
t47 = p + 2;
t48 = stack[(int) t47];
t49 = p + 3;
t50 = stack[(int) t49];
if(t48 > t50) { goto et_4; }
goto et_5;
et_4:
t51 = p + 2;
t52 = stack[(int) t51];
t53 = p + 4;
stack[(int) t53] = t52;
t54 = p + 3;
t55 = stack[(int) t54];
t56 = p + 5;
stack[(int) t56] = t55;
goto etFin_2;
et_5:
t57 = p + 3;
t58 = stack[(int) t57];
t59 = p + 4;
stack[(int) t59] = t58;
t60 = p + 2;
t61 = stack[(int) t60];
t62 = p + 5;
stack[(int) t62] = t61;
goto etFin_2;
etFin_2:
t63 = p + 5;
t64 = stack[(int) t63];
t65 = p + 6;
stack[(int) t65] = t64;
etFor_1:
t66 = p + 6;
t67 = stack[(int) t66];
t68 = p + 4;
t69 = stack[(int) t68];
t70 = p + 6;
t71 = stack[(int) t70];
if(t67 <= t69) { goto et_6; }
goto et_7;
et_6:
t73 = p + 6;
t74 = stack[(int) t73];
printf("%f", t74);
printf( "");
printf( "\n");
printf( "");
printf( "\n");
t72 = t71 + 1;
t75 = p + 6;
stack[(int) t75] = t72;
goto etFor_1;
et_7:
etFin_3:
printf("");
}
void JV_clase_suma_Integer_Integer() {
t76 = p + 2;
t77 = stack[(int) t76];
t78 = p + 3;
t79 = stack[(int) t78];
t80 = t77 + t79;
t81 = p + 4;
stack[(int) t81] = t80;
t82 = p + 4;
t83 = stack[(int) t82];
t84 = p + 1;
stack[(int) t84] = t83;
printf("");
}
void JV_clase_llamarSuma() {
printf( " Ingrese primer numero :");
printf( "\n");
scanf("%f", &t85);
t86 = p + 2;
stack[(int) t86] = t85;
printf( " Ingrese segundo numero :");
printf( "\n");
scanf("%f", &t87);
t88 = p + 3;
stack[(int) t88] = t87;
t89 = p + 2;
t90 = stack[(int) t89];
t91 = p + 3;
t92 = stack[(int) t91];
t93 = p + 3;
t94 = t93 + 2;
stack[(int) t94] = t90;
t95 = p + 3;
t96 = t95 + 3;
stack[(int) t96] = t92;
t97 = p + 0;
t98 = stack[(int) t97];
t99 = p + 3;
t100 = t99 + 0;
stack[(int) t100] = t98;
p = p + 3;
JV_clase_suma_Integer_Integer();
p = p - 3;
t101 = p + 3;
t102 = t101 + 1;
t103 = stack[(int) t102];
t104 = p + 4;
stack[(int) t104] = t103;
printf( " El resultado de la suma es :");
t105 = p + 4;
t106 = stack[(int) t105];
printf("%f", t106);
printf( "\n");
printf("");
}
void JV_clase_clase() {
t107 = p + 0;
stack[(int) t107] = h;
h = h + 0;
printf("");
}
void PY_pruebaFor() {
t109 = p + 1;
stack[(int) t109] = 5;
t110 = p + 2;
stack[(int) t110] = 20;
t111 = p + 3;
stack[(int) t111] = 2;
t112 = p + 1;
t113 = stack[(int) t112];
t114 = p + 2;
t115 = stack[(int) t114];
t119 = p + 4;
stack[(int) t119] = t113;
etFor_3:
t120 = p + 4;
t121 = stack[(int) t120];
if(t121 <= t115) { goto et_9; }
goto et_10;
et_9:
printf( " hola mundo");
t122 = p + 4;
t123 = stack[(int) t122];
printf("%f", t123);
printf( "\n");
t116 = p + 3;
t117 = p + 4;
t118 = stack[(int) t117] + stack[(int) t116];
stack[(int) t117] = t118;
goto etFor_3;
et_10:
etFin_5:
printf( " fin metodo");
printf( "\n");
printf("");
}
void PY_otraPrueba() {
t124 = p + 1;
t125 = stack[(int) t124];
t126 = p + 2;
t127 = stack[(int) t126];
if(t125 > t127) { goto et_10; }
goto et_11;
et_10:
t128 = p + 0;
stack[(int) t128] = 23;
goto etFin_6;
et_11:
t129 = p + 0;
stack[(int) t129] = 12;
goto etFin_6;
etFin_6:
printf( " fin metodo");
printf( "\n");
printf("");
}
int main() {
p = 0;
h = 0;
t131 = p + 3;
t132 = t131 + 1;
stack[(int)t132] = 12;
t133 = p + 3;
t134 = t133 + 2;
stack[(int)t134] = 43;
p = p + 3;
PY_otraPrueba();
p = p - 3;
t135 = p + 3;
t136 = t135 + 0;
t137 = stack[(int)t136];
t138 = p + 2;
stack[(int)t138] = t137;
printf( " el valor es :");
t139 = p + 2;
t140 = stack[(int)t139];
printf("%f", t140);
printf( "\n");
return 0;
}
