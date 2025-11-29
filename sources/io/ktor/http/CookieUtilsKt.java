package io.ktor.http;

import com.upuphone.runasone.api.ApiConstant;
import io.ktor.util.date.Month;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0013\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u0013\u0010\u0007\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0007\u0010\u0003\u001a\u001b\u0010\f\u001a\u00020\u000b*\u00020\b2\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"", "", "b", "(C)Z", "d", "f", "e", "c", "Lio/ktor/http/CookieDateBuilder;", "", "token", "", "a", "(Lio/ktor/http/CookieDateBuilder;Ljava/lang/String;)V", "ktor-http"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nCookieUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CookieUtils.kt\nio/ktor/http/CookieUtilsKt\n+ 2 CookieUtils.kt\nio/ktor/http/StringLexer\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,349:1\n106#1,2:352\n106#1,2:355\n106#1,2:359\n106#1,2:362\n106#1,2:366\n106#1,2:371\n106#1,2:377\n115#1,3:380\n118#1:385\n106#1,2:386\n119#1,2:388\n122#1:391\n106#1,2:392\n124#1,2:394\n106#1,2:396\n126#1,4:398\n106#1,2:402\n131#1,2:404\n106#1,2:406\n133#1,9:408\n168#1,3:417\n171#1:422\n106#1,2:423\n172#1,2:425\n175#1,6:428\n149#1,12:434\n188#1,3:446\n191#1:451\n106#1,2:453\n192#1,2:455\n195#1,6:458\n56#2,2:350\n58#2:354\n56#2,2:357\n58#2:361\n56#2,2:364\n58#2:368\n56#2,2:369\n58#2:373\n56#2,2:374\n58#2:379\n56#2,2:383\n58#2:390\n56#2,2:420\n58#2:427\n56#2,2:449\n58#2:457\n1#3:376\n1#3:452\n*S KotlinDebug\n*F\n+ 1 CookieUtils.kt\nio/ktor/http/CookieUtilsKt\n*L\n118#1:352,2\n122#1:355,2\n125#1:359,2\n129#1:362,2\n132#1:366,2\n171#1:371,2\n191#1:377,2\n209#1:380,3\n209#1:385\n209#1:386,2\n209#1:388,2\n209#1:391\n209#1:392,2\n209#1:394,2\n209#1:396,2\n209#1:398,4\n209#1:402,2\n209#1:404,2\n209#1:406,2\n209#1:408,9\n220#1:417,3\n220#1:422\n220#1:423,2\n220#1:425,2\n220#1:428,6\n229#1:434,12\n238#1:446,3\n238#1:451\n238#1:453,2\n238#1:455,2\n238#1:458,6\n117#1:350,2\n117#1:354\n124#1:357,2\n124#1:361\n131#1:364,2\n131#1:368\n170#1:369,2\n170#1:373\n190#1:374,2\n190#1:379\n209#1:383,2\n209#1:390\n220#1:420,2\n220#1:427\n238#1:449,2\n238#1:457\n238#1:452\n*E\n"})
public final class CookieUtilsKt {
    public static final void a(CookieDateBuilder cookieDateBuilder, String str) {
        Intrinsics.checkNotNullParameter(cookieDateBuilder, "<this>");
        Intrinsics.checkNotNullParameter(str, ApiConstant.KEY_TOKEN);
        if (cookieDateBuilder.c() == null || cookieDateBuilder.d() == null || cookieDateBuilder.f() == null) {
            StringLexer stringLexer = new StringLexer(str);
            int d = stringLexer.d();
            if (stringLexer.a(CookieUtilsKt$tryParseTime$hour$1$1.INSTANCE)) {
                stringLexer.a(CookieUtilsKt$tryParseTime$hour$1$3.INSTANCE);
                String substring = stringLexer.e().substring(d, stringLexer.d());
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                int parseInt = Integer.parseInt(substring);
                if (stringLexer.a(CookieUtilsKt$tryParseTime$1.INSTANCE)) {
                    int d2 = stringLexer.d();
                    if (stringLexer.a(CookieUtilsKt$tryParseTime$minute$1$1.INSTANCE)) {
                        stringLexer.a(CookieUtilsKt$tryParseTime$minute$1$3.INSTANCE);
                        String substring2 = stringLexer.e().substring(d2, stringLexer.d());
                        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                        int parseInt2 = Integer.parseInt(substring2);
                        if (stringLexer.a(CookieUtilsKt$tryParseTime$3.INSTANCE)) {
                            int d3 = stringLexer.d();
                            if (stringLexer.a(CookieUtilsKt$tryParseTime$second$1$1.INSTANCE)) {
                                stringLexer.a(CookieUtilsKt$tryParseTime$second$1$3.INSTANCE);
                                String substring3 = stringLexer.e().substring(d3, stringLexer.d());
                                Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                                int parseInt3 = Integer.parseInt(substring3);
                                if (stringLexer.a(CookieUtilsKt$tryParseTime$5.INSTANCE)) {
                                    stringLexer.b(CookieUtilsKt$tryParseTime$6.INSTANCE);
                                }
                                cookieDateBuilder.i(Integer.valueOf(parseInt));
                                cookieDateBuilder.j(Integer.valueOf(parseInt2));
                                cookieDateBuilder.l(Integer.valueOf(parseInt3));
                                return;
                            }
                        }
                    }
                }
            }
        }
        if (cookieDateBuilder.b() == null) {
            StringLexer stringLexer2 = new StringLexer(str);
            int d4 = stringLexer2.d();
            if (stringLexer2.a(CookieUtilsKt$tryParseDayOfMonth$day$1$1.INSTANCE)) {
                stringLexer2.a(CookieUtilsKt$tryParseDayOfMonth$day$1$3.INSTANCE);
                String substring4 = stringLexer2.e().substring(d4, stringLexer2.d());
                Intrinsics.checkNotNullExpressionValue(substring4, "this as java.lang.String…ing(startIndex, endIndex)");
                int parseInt4 = Integer.parseInt(substring4);
                if (stringLexer2.a(CookieUtilsKt$tryParseDayOfMonth$1.INSTANCE)) {
                    stringLexer2.b(CookieUtilsKt$tryParseDayOfMonth$2.INSTANCE);
                }
                cookieDateBuilder.h(Integer.valueOf(parseInt4));
                return;
            }
        }
        if (cookieDateBuilder.e() == null && str.length() >= 3) {
            for (Month month : Month.values()) {
                if (StringsKt.startsWith(str, month.getValue(), true)) {
                    cookieDateBuilder.k(month);
                    return;
                }
            }
        }
        if (cookieDateBuilder.g() == null) {
            StringLexer stringLexer3 = new StringLexer(str);
            int d5 = stringLexer3.d();
            int i = 0;
            while (i < 2) {
                if (stringLexer3.a(CookieUtilsKt$tryParseYear$year$1$1$1.INSTANCE)) {
                    i++;
                } else {
                    return;
                }
            }
            for (int i2 = 0; i2 < 2; i2++) {
                stringLexer3.a(CookieUtilsKt$tryParseYear$year$1$2$1.INSTANCE);
            }
            String substring5 = stringLexer3.e().substring(d5, stringLexer3.d());
            Intrinsics.checkNotNullExpressionValue(substring5, "this as java.lang.String…ing(startIndex, endIndex)");
            int parseInt5 = Integer.parseInt(substring5);
            if (stringLexer3.a(CookieUtilsKt$tryParseYear$1.INSTANCE)) {
                stringLexer3.b(CookieUtilsKt$tryParseYear$2.INSTANCE);
            }
            cookieDateBuilder.m(Integer.valueOf(parseInt5));
        }
    }

    public static final boolean b(char c) {
        return c == 9 || (' ' <= c && c < '0') || ((';' <= c && c < 'A') || (('[' <= c && c < 'a') || ('{' <= c && c < 127)));
    }

    public static final boolean c(char c) {
        return '0' <= c && c < ':';
    }

    public static final boolean d(char c) {
        return (c >= 0 && c < 9) || (10 <= c && c < ' ') || (('0' <= c && c < ':') || c == ':' || (('a' <= c && c < '{') || (('A' <= c && c < '[') || (127 <= c && c < 256))));
    }

    public static final boolean e(char c) {
        return (c >= 0 && c < '0') || ('J' <= c && c < 256);
    }

    public static final boolean f(char c) {
        return c >= 0 && c < 256;
    }
}
