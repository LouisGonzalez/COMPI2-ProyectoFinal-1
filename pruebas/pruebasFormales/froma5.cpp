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
void JV_clase_programa() {
printf( " Introduzca un n ú mero ( 0 a 99 ) :");
printf( "\n");
scanf("%f", &t1);
t2 = p + 2;
stack[(int) t2] = t1;
t3 = p + 2;
t4 = stack[(int) t3];
t5 = (int) t4 % (int)10;
t6 = p + 3;
stack[(int) t6] = t5;
t7 = p + 2;
t8 = stack[(int) t7];
t9 = t8 / 10;
t10 = p + 4;
stack[(int) t10] = t9;
printf( " el valor de decenas es :");
t11 = p + 4;
t12 = stack[(int) t11];
printf("%f", t12);
printf( "\n");
t13 = p + 4;
t14 = stack[(int) t13];
if((int)t14 == 0) { goto et_2; }
goto et_3;
et_2:
printf( "");
goto etFinal_0;
et_3:
if((int)t14 == 1) { goto et_4; }
goto et_5;
et_4:
printf( " diez");
goto etFinal_0;
et_5:
if((int)t14 == 2) { goto et_6; }
goto et_7;
et_6:
printf( " veinte");
goto etFinal_0;
et_7:
if((int)t14 == 3) { goto et_8; }
goto et_9;
et_8:
printf( " treinta");
goto etFinal_0;
et_9:
if((int)t14 == 4) { goto et_10; }
goto et_11;
et_10:
printf( " cuarenta");
goto etFinal_0;
et_11:
if((int)t14 == 5) { goto et_12; }
goto et_13;
et_12:
printf( " cincuenta");
goto etFinal_0;
et_13:
if((int)t14 == 6) { goto et_14; }
goto et_15;
et_14:
printf( " sesenta");
goto etFinal_0;
et_15:
if((int)t14 == 7) { goto et_16; }
goto et_17;
et_16:
printf( " setenta");
goto etFinal_0;
et_17:
if((int)t14 == 8) { goto et_18; }
goto et_19;
et_18:
printf( " ochenta");
goto etFinal_0;
et_19:
if((int)t14 == 9) { goto et_20; }
goto et_21;
et_20:
printf( " noventa");
goto etFinal_0;
et_21:
etFinal_0:
printf( " y");
t15 = p + 3;
t16 = stack[(int) t15];
if((int)t16 == 0) { goto et_22; }
goto et_23;
et_22:
printf( "");
printf( "\n");
goto etFinal_1;
et_23:
if((int)t16 == 1) { goto et_24; }
goto et_25;
et_24:
printf( " uno");
printf( "\n");
goto etFinal_1;
et_25:
if((int)t16 == 2) { goto et_26; }
goto et_27;
et_26:
printf( " dos");
printf( "\n");
goto etFinal_1;
et_27:
if((int)t16 == 3) { goto et_28; }
goto et_29;
et_28:
printf( " tres");
printf( "\n");
goto etFinal_1;
et_29:
if((int)t16 == 4) { goto et_30; }
goto et_31;
et_30:
printf( " cuatro");
printf( "\n");
goto etFinal_1;
et_31:
if((int)t16 == 5) { goto et_32; }
goto et_33;
et_32:
printf( " cinco");
printf( "\n");
goto etFinal_1;
et_33:
if((int)t16 == 6) { goto et_34; }
goto et_35;
et_34:
printf( " seis");
printf( "\n");
goto etFinal_1;
et_35:
if((int)t16 == 7) { goto et_36; }
goto et_37;
et_36:
printf( " siete");
printf( "\n");
goto etFinal_1;
et_37:
if((int)t16 == 8) { goto et_38; }
goto et_39;
et_38:
printf( " ocho");
printf( "\n");
goto etFinal_1;
et_39:
if((int)t16 == 9) { goto et_40; }
goto et_41;
et_40:
printf( " nueva");
printf( "\n");
goto etFinal_1;
et_41:
etFinal_1:
printf("");
}
void JV_clase_programa2() {
printf( " Introduzca un n ú mero :");
printf( "\n");
scanf("%f", &t17);
t18 = p + 2;
stack[(int) t18] = t17;
etWhile_1:
t19 = p + 2;
t20 = stack[(int) t19];
if(t20 != 0) { goto et_42; }
goto et_43;
et_42:
t21 = p + 2;
t22 = stack[(int) t21];
t23 = (int) t22 % (int)2;
if(t23 == 0) { goto et_44; }
goto et_45;
et_44:
printf( " Par");
printf( "\n");
goto etFin_1;
et_45:
printf( " Impar");
printf( "\n");
goto etFin_1;
etFin_1:
printf( " Introduzca un n ú mero :");
printf( "\n");
scanf("%f", &t24);
t25 = p + 2;
stack[(int) t25] = t24;
goto etWhile_1;
et_43:
etFin_2:
printf("");
}
void JV_clase_programa3() {
t26 = p + 3;
stack[(int) t26] = 0;
etWhile_2:
printf( " Introduzca un n ú mero :");
printf( "\n");
scanf("%f", &t27);
t28 = p + 2;
stack[(int) t28] = t27;
t29 = p + 3;
t30 = stack[(int) t29];
t31 = p + 2;
t32 = stack[(int) t31];
t33 = t30 + t32;
t34 = p + 3;
stack[(int) t34] = t33;
t35 = p + 2;
t36 = stack[(int) t35];
if(t36 != 0) { goto et_46; }
goto et_47;
et_46:
goto etWhile_2;
et_47:
etFin_3:
printf( " La suma de todos los n ú meros es :");
t37 = p + 3;
t38 = stack[(int) t37];
printf("%f", t38);
printf( "\n");
printf("");
}
void JV_clase_programa4() {
t39 = p + 2;
stack[(int) t39] = 1;
etFor_1:
t40 = p + 2;
t41 = stack[(int) t40];
t42 = p + 2;
t43 = stack[(int) t42];
if(t41 <= 10) { goto et_48; }
goto et_49;
et_48:
printf( " \ n \ nTabla del");
t45 = p + 2;
t46 = stack[(int) t45];
printf("%f", t46);
printf( "\n");
printf( " - - - - - - - - - - - - - - -");
printf( "\n");
t47 = p + 3;
stack[(int) t47] = 1;
etFor_2:
t48 = p + 3;
t49 = stack[(int) t48];
t50 = p + 3;
t51 = stack[(int) t50];
if(t49 <= 10) { goto et_50; }
goto et_51;
et_50:
t53 = p + 2;
t54 = stack[(int) t53];
t55 = p + 3;
t56 = stack[(int) t55];
t57 = t54 * t56;
t58 = p + 4;
stack[(int) t58] = t57;
t59 = p + 2;
t60 = stack[(int) t59];
printf("%f", t60);
printf( " x");
t61 = p + 3;
t62 = stack[(int) t61];
printf("%f", t62);
printf( " =");
t63 = p + 4;
t64 = stack[(int) t63];
printf("%f", t64);
printf( "\n");
t52 = t51 + 1;
t65 = p + 3;
stack[(int) t65] = t52;
goto etFor_2;
et_51:
etFin_4:
t44 = t43 + 1;
t66 = p + 2;
stack[(int) t66] = t44;
goto etFor_1;
et_49:
etFin_5:
printf("");
}
void JV_clase_programa5() {
t67 = p + 2;
stack[(int) t67] = 0;
etFor_3:
t68 = p + 2;
t69 = stack[(int) t68];
t70 = p + 2;
t71 = stack[(int) t70];
if(t69 <= 9) { goto et_52; }
goto et_53;
et_52:
t73 = p + 3;
stack[(int) t73] = 0;
etFor_4:
t74 = p + 3;
t75 = stack[(int) t74];
t76 = p + 3;
t77 = stack[(int) t76];
if(t75 <= 9) { goto et_54; }
goto et_55;
et_54:
t79 = p + 4;
stack[(int) t79] = 0;
etFor_5:
t80 = p + 4;
t81 = stack[(int) t80];
t82 = p + 4;
t83 = stack[(int) t82];
if(t81 <= 9) { goto et_56; }
goto et_57;
et_56:
t85 = p + 5;
stack[(int) t85] = 0;
etFor_6:
t86 = p + 5;
t87 = stack[(int) t86];
t88 = p + 5;
t89 = stack[(int) t88];
if(t87 <= 9) { goto et_58; }
goto et_59;
et_58:
t91 = p + 6;
stack[(int) t91] = 0;
etFor_7:
t92 = p + 6;
t93 = stack[(int) t92];
t94 = p + 6;
t95 = stack[(int) t94];
if(t93 <= 9) { goto et_60; }
goto et_61;
et_60:
t97 = p + 2;
t98 = stack[(int) t97];
if(t98 == 3) { goto et_62; }
goto et_63;
et_62:
printf( " E");
goto etFin_6;
et_63:
t99 = p + 2;
t100 = stack[(int) t99];
printf("%f", t100);
goto etFin_6;
etFin_6:
t101 = p + 3;
t102 = stack[(int) t101];
if(t102 == 3) { goto et_64; }
goto et_65;
et_64:
printf( " E");
goto etFin_7;
et_65:
t103 = p + 3;
t104 = stack[(int) t103];
printf("%f", t104);
goto etFin_7;
etFin_7:
t105 = p + 4;
t106 = stack[(int) t105];
if(t106 == 3) { goto et_66; }
goto et_67;
et_66:
printf( " E");
goto etFin_8;
et_67:
t107 = p + 4;
t108 = stack[(int) t107];
printf("%f", t108);
goto etFin_8;
etFin_8:
t109 = p + 5;
t110 = stack[(int) t109];
if(t110 == 3) { goto et_68; }
goto et_69;
et_68:
printf( " E");
goto etFin_9;
et_69:
t111 = p + 5;
t112 = stack[(int) t111];
printf("%f", t112);
goto etFin_9;
etFin_9:
t113 = p + 6;
t114 = stack[(int) t113];
if(t114 == 3) { goto et_70; }
goto et_71;
et_70:
printf( " E");
goto etFin_10;
et_71:
t115 = p + 6;
t116 = stack[(int) t115];
printf("%f", t116);
goto etFin_10;
etFin_10:
printf( "");
printf( "\n");
t96 = t95 + 1;
t117 = p + 6;
stack[(int) t117] = t96;
goto etFor_7;
et_61:
etFin_11:
t90 = t89 + 1;
t118 = p + 5;
stack[(int) t118] = t90;
goto etFor_6;
et_59:
etFin_12:
t84 = t83 + 1;
t119 = p + 4;
stack[(int) t119] = t84;
goto etFor_5;
et_57:
etFin_13:
t78 = t77 + 1;
t120 = p + 3;
stack[(int) t120] = t78;
goto etFor_4;
et_55:
etFin_14:
t72 = t71 + 1;
t121 = p + 2;
stack[(int) t121] = t72;
goto etFor_3;
et_53:
etFin_15:
printf("");
}
void JV_clase_clase() {
t122 = p + 0;
stack[(int) t122] = h;
h = h + 0;
printf("");
}
int main() {
p = 0;
h = 0;
p = p + 1;
JV_clase_clase();
p = p - 1;
t125 = p + 1;
t126 = t125 + 0;
t127 = stack[(int)t126];
t128 = p + 0;
stack[(int)t128] = t127;
t129 = p + 0;
t130 = stack[(int)t129];
t131 = p + 1;
t132 = t131 + 0;
stack[(int)t132] = t130;
p = p + 1;
JV_clase_programa5();
p = p - 1;
return 0;
}
