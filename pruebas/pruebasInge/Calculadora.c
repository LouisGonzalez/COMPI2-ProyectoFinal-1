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
float t141;
float t142;
float t143;
float t144;
float t145;
float t146;
float t147;
float t148;
float t149;
float t150;
float t151;
float t152;
float t153;
float t154;
float t155;
float t156;
float t157;
float t158;
float t159;
float t160;
float t161;
float t162;
float t163;
float t164;
float t165;
float t166;
float t167;
float t168;
float t169;
float t170;
float t171;
float t172;
float t173;
float t174;
float t175;
float t176;
float t177;
float t178;
float t179;
float t180;
float t181;
float t182;
float t183;
float t184;
float t185;
float t186;
float t187;
float t188;
float t189;
float t190;
float t191;
float t192;
float t193;
float t194;
float t195;
float t196;
float t197;
float t198;
float t199;
float t200;
float t201;
float t202;
float t203;
float t204;
float t205;
float t206;
float t207;
float t208;
float t209;
float t210;
float t211;
float t212;
float t213;
float t214;
float t215;
float t216;
float t217;
float t218;
float t219;
float t220;
float t221;
float t222;
float t223;
float t224;
float t225;
float t226;
float t227;
float t228;
float t229;
float t230;
float t231;
float t232;
float t233;
float t234;
float t235;
float t236;
float t237;
float t238;
void VB_SUMAR_Integer_Integer() {
t1 = p + 3;
stack[(int) t1] = 0;
t2 = p + 1;
t3 = stack[(int) t2];
t4 = p + 2;
t5 = stack[(int) t4];
t6 = t3 + t5;
t7 = p + 3;
stack[(int) t7] = t6;
t8 = p + 3;
t9 = stack[(int) t8];
t10 = p + 0;
stack[(int) t10] = t9;
printf("");
}
void VB_RESTAR_Integer_Integer() {
t12 = p + 3;
stack[(int) t12] = 0;
t13 = p + 1;
t14 = stack[(int) t13];
t15 = p + 2;
t16 = stack[(int) t15];
t17 = t14 - t16;
t18 = p + 3;
stack[(int) t18] = t17;
t19 = p + 3;
t20 = stack[(int) t19];
t21 = p + 0;
stack[(int) t21] = t20;
printf("");
}
void VB_MULTIPLICAR_Integer_Integer() {
t23 = p + 3;
stack[(int) t23] = 0;
t24 = p + 1;
t25 = stack[(int) t24];
t26 = p + 2;
t27 = stack[(int) t26];
t28 = t25 * t27;
t29 = p + 3;
stack[(int) t29] = t28;
t30 = p + 3;
t31 = stack[(int) t30];
t32 = p + 0;
stack[(int) t32] = t31;
printf("");
}
void PY_DIVIDIR() {
t35 = p + 1;
t36 = stack[(int) t35];
t37 = p + 2;
t38 = stack[(int) t37];
t39 = t36 / t38;
t40 = p + 0;
stack[(int) t40] = t39;
printf("");
}
void PY_MODULO() {
t41 = p + 1;
t42 = stack[(int) t41];
t43 = p + 2;
t44 = stack[(int) t43];
t45 = (int) t42 % (int)t44;
t46 = p + 3;
stack[(int) t46] = t45;
t47 = p + 3;
t48 = stack[(int) t47];
t49 = p + 0;
stack[(int) t49] = t48;
printf("");
}
int main() {
p = 0;
h = 0;
t51 = p + 0;
stack[(int)t51] = 2;
t52 = p + 1;
stack[(int)t52] = 2;
t54 = p + 6;
stack[(int)t54] = 0;
t55 = p + 7;
stack[(int)t55] = 1;
t56 = p + 8;
stack[(int)t56] = 3;
t57 = p + 9;
stack[(int)t57] = 4;
t58 = p + 17;
stack[(int)t58] = 0;
t59 = 1 + 2;
t60 = p + 13;
stack[(int)t60] = t59;
t61 = p + 14;
stack[(int)t61] = 0;
t62 = p + 15;
stack[(int)t62] = 86;
t63 = p + 16;
stack[(int)t63] = 100;
printf( " Bienvenido");
printf( "\n");
printf( " Archivo de prueba . . .");
printf( "\n");
printf( " Ingrese el primer valor entero");
printf( "\n");
printf( "null");
printf( "\n");
printf( "\n");
scanf("%f", &t64);
t65 = p + 10;
stack[(int)t65] = t64;
printf( " Ingrese el segudo valor entero");
printf( "\n");
printf( "null");
printf( "\n");
printf( "\n");
scanf("%f", &t66);
t67 = p + 11;
stack[(int)t67] = t66;
t68 = p + 10;
t69 = stack[(int)t68];
t70 = p + 11;
t71 = stack[(int)t70];
t72 = p + 18;
t73 = t72 + 1;
stack[(int)t73] = t69;
t74 = p + 18;
t75 = t74 + 2;
stack[(int)t75] = t71;
p = p + 18;
PY_MODULO();
p = p - 18;
t76 = p + 18;
t77 = t76 + 0;
t78 = stack[(int)t77];
t79 = p + 16;
stack[(int)t79] = t78;
t80 = p + 10;
t81 = stack[(int)t80];
t82 = p + 11;
t83 = stack[(int)t82];
t84 = p + 18;
t85 = t84 + 1;
stack[(int)t85] = t81;
t86 = p + 18;
t87 = t86 + 2;
stack[(int)t87] = t83;
p = p + 18;
VB_SUMAR_Integer_Integer();
p = p - 18;
t88 = p + 18;
t89 = t88 + 0;
t90 = stack[(int)t89];
t91 = p + 13;
stack[(int)t91] = t90;
t92 = p + 10;
t93 = stack[(int)t92];
t94 = p + 11;
t95 = stack[(int)t94];
t96 = p + 18;
t97 = t96 + 1;
stack[(int)t97] = t93;
t98 = p + 18;
t99 = t98 + 2;
stack[(int)t99] = t95;
p = p + 18;
VB_RESTAR_Integer_Integer();
p = p - 18;
t100 = p + 18;
t101 = t100 + 0;
t102 = stack[(int)t101];
t103 = p + 14;
stack[(int)t103] = t102;
t104 = p + 10;
t105 = stack[(int)t104];
t106 = p + 11;
t107 = stack[(int)t106];
t108 = p + 18;
t109 = t108 + 1;
stack[(int)t109] = t105;
t110 = p + 18;
t111 = t110 + 2;
stack[(int)t111] = t107;
p = p + 18;
VB_MULTIPLICAR_Integer_Integer();
p = p - 18;
t112 = p + 18;
t113 = t112 + 0;
t114 = stack[(int)t113];
t115 = p + 15;
stack[(int)t115] = t114;
t116 = p + 10;
t117 = stack[(int)t116];
t118 = p + 11;
t119 = stack[(int)t118];
t120 = p + 18;
t121 = t120 + 1;
stack[(int)t121] = t117;
t122 = p + 18;
t123 = t122 + 2;
stack[(int)t123] = t119;
p = p + 18;
PY_DIVIDIR();
p = p - 18;
t124 = p + 18;
t125 = t124 + 0;
t126 = stack[(int)t125];
t127 = p + 12;
stack[(int)t127] = t126;
printf( " Integer + Integer es igual a Integer");
t128 = p + 10;
t129 = stack[(int)t128];
printf("%f", t129);
t130 = p + 11;
t131 = stack[(int)t130];
printf("%f", t131);
t132 = p + 13;
t133 = stack[(int)t132];
printf("%f", t133);
printf( "\n");
printf( " Integer - Integer es igual a Integer");
t134 = p + 10;
t135 = stack[(int)t134];
printf("%f", t135);
t136 = p + 11;
t137 = stack[(int)t136];
printf("%f", t137);
t138 = p + 14;
t139 = stack[(int)t138];
printf("%f", t139);
printf( "\n");
printf( " Integer * Integer es igual a Integer");
t140 = p + 10;
t141 = stack[(int)t140];
printf("%f", t141);
t142 = p + 11;
t143 = stack[(int)t142];
printf("%f", t143);
t144 = p + 15;
t145 = stack[(int)t144];
printf("%f", t145);
printf( "\n");
printf( " Integer / Integer es igual a Integer");
t146 = p + 10;
t147 = stack[(int)t146];
printf("%f", t147);
t148 = p + 11;
t149 = stack[(int)t148];
printf("%f", t149);
t150 = p + 16;
t151 = stack[(int)t150];
printf("%f", t151);
printf( "\n");
printf( " Integer mod Integer es igual a Integer");
t152 = p + 10;
t153 = stack[(int)t152];
printf("%f", t153);
t154 = p + 11;
t155 = stack[(int)t154];
printf("%f", t155);
t156 = p + 12;
t157 = stack[(int)t156];
printf("%f", t157);
printf( "\n");
t158 = 0 * 2;
t159 = 0 + 1;
t160 = t158 + t159;
t161 = 2 + t160;
t162 = p + t161;
t163 = p + 13;
t164 = stack[(int)t163];
stack[(int) t162] = t164;
t165 = 0 * 2;
t166 = 1 + 1;
t167 = t165 + t166;
t168 = 2 + t167;
t169 = p + t168;
t170 = p + 14;
t171 = stack[(int)t170];
stack[(int) t169] = t171;
t172 = 1 * 2;
t173 = 0 + 1;
t174 = t172 + t173;
t175 = 2 + t174;
t176 = p + t175;
t177 = p + 15;
t178 = stack[(int)t177];
stack[(int) t176] = t178;
t179 = 1 * 2;
t180 = 1 + 1;
t181 = t179 + t180;
t182 = 2 + t181;
t183 = p + t182;
t184 = p + 16;
t185 = stack[(int)t184];
t186 = 0 * 2;
t187 = 0 + 1;
t188 = t186 + t187;
t189 = t188 + 2;
t190 = p + t189;
t191 = stack[(int)t190];
t192 = p + 6;
stack[(int)t192] = t191;
t193 = 0 * 2;
t194 = 1 + 1;
t195 = t193 + t194;
t196 = t195 + 2;
t197 = p + t196;
t198 = stack[(int)t197];
t199 = p + 7;
stack[(int)t199] = t198;
t200 = 1 * 2;
t201 = 0 + 1;
t202 = t200 + t201;
t203 = t202 + 2;
t204 = p + t203;
t205 = stack[(int)t204];
t206 = p + 8;
stack[(int)t206] = t205;
t207 = 1 * 2;
t208 = 1 + 1;
t209 = t207 + t208;
t210 = t209 + 2;
t211 = p + t210;
t212 = stack[(int)t211];
t213 = p + 9;
stack[(int)t213] = t212;
t214 = p + 17;
stack[(int)t214] = 0;
etFor_3:
t215 = p + 17;
t216 = stack[(int)t215];
if(t216 < 2) { goto et_4; }
goto et_5;
et_4:
t217 = p + 17;
t218 = stack[(int)t217];
if(t218 == 0) { goto et_6; }
goto et_7;
et_6:
printf( " Arreglo [ Integer ] [ 0 ] su contenido es Integer");
t219 = p + 17;
t220 = stack[(int)t219];
printf("%f", t220);
t221 = p + 6;
t222 = stack[(int)t221];
printf("%f", t222);
printf( "\n");
printf( " Arreglo [ Integer ] [ 1 ] su contenido es Integer");
t223 = p + 17;
t224 = stack[(int)t223];
printf("%f", t224);
t225 = p + 7;
t226 = stack[(int)t225];
printf("%f", t226);
printf( "\n");
goto etFin_3;
et_7:
printf( " Arrseglo [ Integer ] [ 0 ] su contenido es Integer");
t227 = p + 17;
t228 = stack[(int)t227];
printf("%f", t228);
t229 = p + 8;
t230 = stack[(int)t229];
printf("%f", t230);
printf( "\n");
printf( " Arrseglo [ Integer ] [ 1 ] su contenido es Integer");
t231 = p + 17;
t232 = stack[(int)t231];
printf("%f", t232);
t233 = p + 9;
t234 = stack[(int)t233];
printf("%f", t234);
printf( "\n");
goto etFin_3;
etFin_3:
t235 = p + 17;
t236 = stack[(int)t235];
t237 = t236 + 1;
t238 = p + 17;
stack[(int)t238] = t237;
goto etFor_3;
et_5:
etFin_4:
return 0;
}