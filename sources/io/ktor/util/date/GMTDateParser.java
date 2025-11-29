package io.ktor.util.date;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.lang3.time.TimeZones;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000f\u001a\u00020\u000e*\u00020\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011¨\u0006\u0013"}, d2 = {"Lio/ktor/util/date/GMTDateParser;", "", "", "pattern", "<init>", "(Ljava/lang/String;)V", "dateString", "Lio/ktor/util/date/GMTDate;", "b", "(Ljava/lang/String;)Lio/ktor/util/date/GMTDate;", "Lio/ktor/util/date/GMTDateBuilder;", "", "type", "chunk", "", "a", "(Lio/ktor/util/date/GMTDateBuilder;CLjava/lang/String;)V", "Ljava/lang/String;", "Companion", "ktor-utils"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nGMTDateParser.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GMTDateParser.kt\nio/ktor/util/date/GMTDateParser\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,128:1\n1#2:129\n1064#3,2:130\n*S KotlinDebug\n*F\n+ 1 GMTDateParser.kt\nio/ktor/util/date/GMTDateParser\n*L\n89#1:130,2\n*E\n"})
public final class GMTDateParser {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f9051a;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lio/ktor/util/date/GMTDateParser$Companion;", "", "()V", "ANY", "", "DAY_OF_MONTH", "HOURS", "MINUTES", "MONTH", "SECONDS", "YEAR", "ZONE", "ktor-utils"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public GMTDateParser(String str) {
        Intrinsics.checkNotNullParameter(str, "pattern");
        this.f9051a = str;
        if (str.length() <= 0) {
            throw new IllegalStateException("Date parser pattern shouldn't be empty.".toString());
        }
    }

    public final void a(GMTDateBuilder gMTDateBuilder, char c, String str) {
        if (c == 's') {
            gMTDateBuilder.g(Integer.valueOf(Integer.parseInt(str)));
        } else if (c == 'm') {
            gMTDateBuilder.e(Integer.valueOf(Integer.parseInt(str)));
        } else if (c == 'h') {
            gMTDateBuilder.d(Integer.valueOf(Integer.parseInt(str)));
        } else if (c == 'd') {
            gMTDateBuilder.c(Integer.valueOf(Integer.parseInt(str)));
        } else if (c == 'M') {
            gMTDateBuilder.f(Month.Companion.b(str));
        } else if (c == 'Y') {
            gMTDateBuilder.h(Integer.valueOf(Integer.parseInt(str)));
        } else if (c == 'z') {
            if (!Intrinsics.areEqual((Object) str, (Object) TimeZones.GMT_ID)) {
                throw new IllegalStateException("Check failed.".toString());
            }
        } else if (c != '*') {
            int i = 0;
            while (i < str.length()) {
                if (str.charAt(i) == c) {
                    i++;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }
    }

    public final GMTDate b(String str) {
        Intrinsics.checkNotNullParameter(str, "dateString");
        GMTDateBuilder gMTDateBuilder = new GMTDateBuilder();
        char charAt = this.f9051a.charAt(0);
        int i = 0;
        int i2 = 1;
        int i3 = 0;
        while (i2 < this.f9051a.length()) {
            try {
                if (this.f9051a.charAt(i2) == charAt) {
                    i2++;
                } else {
                    int i4 = (i3 + i2) - i;
                    String substring = str.substring(i3, i4);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    a(gMTDateBuilder, charAt, substring);
                    try {
                        charAt = this.f9051a.charAt(i2);
                        int i5 = i4;
                        i = i2;
                        i2++;
                        i3 = i5;
                    } catch (Throwable unused) {
                        i3 = i4;
                        throw new InvalidDateStringException(str, i3, this.f9051a);
                    }
                }
            } catch (Throwable unused2) {
                throw new InvalidDateStringException(str, i3, this.f9051a);
            }
        }
        if (i3 < str.length()) {
            String substring2 = str.substring(i3);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
            a(gMTDateBuilder, charAt, substring2);
        }
        return gMTDateBuilder.a();
    }
}
