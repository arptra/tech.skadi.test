package io.ktor.http;

import com.meizu.common.datetimepicker.date.MonthView;
import io.ktor.util.date.GMTDate;
import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\r\u001a\u00020\f\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/ktor/http/CookieDateParser;", "", "<init>", "()V", "", "source", "Lio/ktor/util/date/GMTDate;", "c", "(Ljava/lang/String;)Lio/ktor/util/date/GMTDate;", "T", "name", "field", "", "a", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "", "requirement", "Lkotlin/Function0;", "msg", "b", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;)V", "ktor-http"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nCookieUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CookieUtils.kt\nio/ktor/http/CookieDateParser\n+ 2 CookieUtils.kt\nio/ktor/http/StringLexer\n*L\n1#1,349:1\n56#2,3:350\n*S KotlinDebug\n*F\n+ 1 CookieUtils.kt\nio/ktor/http/CookieDateParser\n*L\n294#1:350,3\n*E\n"})
public final class CookieDateParser {
    public final void a(String str, String str2, Object obj) {
        if (obj == null) {
            throw new InvalidCookieDateException(str, "Could not find " + str2);
        }
    }

    public final void b(String str, boolean z, Function0 function0) {
        if (!z) {
            throw new InvalidCookieDateException(str, (String) function0.invoke());
        }
    }

    public final GMTDate c(String str) {
        Intrinsics.checkNotNullParameter(str, "source");
        StringLexer stringLexer = new StringLexer(str);
        CookieDateBuilder cookieDateBuilder = new CookieDateBuilder();
        stringLexer.b(CookieDateParser$parse$1.INSTANCE);
        while (stringLexer.c()) {
            if (stringLexer.f(CookieDateParser$parse$2.INSTANCE)) {
                int d = stringLexer.d();
                stringLexer.b(CookieDateParser$parse$token$1$1.INSTANCE);
                String substring = stringLexer.e().substring(d, stringLexer.d());
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                CookieUtilsKt.a(cookieDateBuilder, substring);
                stringLexer.b(CookieDateParser$parse$3.INSTANCE);
            }
        }
        Integer g = cookieDateBuilder.g();
        IntRange intRange = new IntRange(70, 99);
        boolean z = false;
        if (g == null || !intRange.contains(g.intValue())) {
            IntRange intRange2 = new IntRange(0, 69);
            if (g != null && intRange2.contains(g.intValue())) {
                Integer g2 = cookieDateBuilder.g();
                Intrinsics.checkNotNull(g2);
                cookieDateBuilder.m(Integer.valueOf(g2.intValue() + 2000));
            }
        } else {
            Integer g3 = cookieDateBuilder.g();
            Intrinsics.checkNotNull(g3);
            cookieDateBuilder.m(Integer.valueOf(g3.intValue() + 1900));
        }
        a(str, "day-of-month", cookieDateBuilder.b());
        a(str, MonthView.VIEW_PARAMS_MONTH, cookieDateBuilder.e());
        a(str, MonthView.VIEW_PARAMS_YEAR, cookieDateBuilder.g());
        a(str, RtspHeaders.Values.TIME, cookieDateBuilder.c());
        a(str, RtspHeaders.Values.TIME, cookieDateBuilder.d());
        a(str, RtspHeaders.Values.TIME, cookieDateBuilder.f());
        IntRange intRange3 = new IntRange(1, 31);
        Integer b = cookieDateBuilder.b();
        b(str, b != null && intRange3.contains(b.intValue()), CookieDateParser$parse$4.INSTANCE);
        Integer g4 = cookieDateBuilder.g();
        Intrinsics.checkNotNull(g4);
        b(str, g4.intValue() >= 1601, CookieDateParser$parse$5.INSTANCE);
        Integer c = cookieDateBuilder.c();
        Intrinsics.checkNotNull(c);
        b(str, c.intValue() <= 23, CookieDateParser$parse$6.INSTANCE);
        Integer d2 = cookieDateBuilder.d();
        Intrinsics.checkNotNull(d2);
        b(str, d2.intValue() <= 59, CookieDateParser$parse$7.INSTANCE);
        Integer f = cookieDateBuilder.f();
        Intrinsics.checkNotNull(f);
        if (f.intValue() <= 59) {
            z = true;
        }
        b(str, z, CookieDateParser$parse$8.INSTANCE);
        return cookieDateBuilder.a();
    }
}
