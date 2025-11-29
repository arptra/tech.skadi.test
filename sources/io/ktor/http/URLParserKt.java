package io.ktor.http;

import io.ktor.util.CharsetKt;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\u001a\u0019\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0004\u001a3\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a+\u0010\r\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a+\u0010\u000f\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a+\u0010\u0011\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u000e\u001a+\u0010\u0012\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u000e\u001a'\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a/\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a#\u0010\u0019\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u0014\" \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a8\u0000X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lio/ktor/http/URLBuilder;", "", "urlString", "j", "(Lio/ktor/http/URLBuilder;Ljava/lang/String;)Lio/ktor/http/URLBuilder;", "k", "", "startIndex", "endIndex", "slashCount", "", "f", "(Lio/ktor/http/URLBuilder;Ljava/lang/String;III)V", "h", "(Lio/ktor/http/URLBuilder;Ljava/lang/String;II)V", "i", "(Lio/ktor/http/URLBuilder;Ljava/lang/String;II)I", "g", "b", "c", "(Ljava/lang/String;II)I", "", "char", "a", "(Ljava/lang/String;IIC)I", "e", "", "Ljava/util/List;", "d", "()Ljava/util/List;", "ROOT_PATH", "ktor-http"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nURLParser.kt\nKotlin\n*S Kotlin\n*F\n+ 1 URLParser.kt\nio/ktor/http/URLParserKt\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,263:1\n151#2,6:264\n163#2,6:270\n1#3:276\n*S KotlinDebug\n*F\n+ 1 URLParser.kt\nio/ktor/http/URLParserKt\n*L\n34#1:264,6\n35#1:270,6\n*E\n"})
public final class URLParserKt {

    /* renamed from: a  reason: collision with root package name */
    public static final List f8978a = CollectionsKt.listOf("");

    public static final int a(String str, int i, int i2, char c) {
        int i3 = 0;
        while (true) {
            int i4 = i + i3;
            if (i4 >= i2 || str.charAt(i4) != c) {
                return i3;
            }
            i3++;
        }
        return i3;
    }

    public static final void b(URLBuilder uRLBuilder, String str, int i, int i2) {
        Integer valueOf = Integer.valueOf(e(str, i, i2));
        if (valueOf.intValue() <= 0) {
            valueOf = null;
        }
        int intValue = valueOf != null ? valueOf.intValue() : i2;
        String substring = str.substring(i, intValue);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        uRLBuilder.w(substring);
        int i3 = intValue + 1;
        if (i3 < i2) {
            String substring2 = str.substring(i3, i2);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            uRLBuilder.x(Integer.parseInt(substring2));
            return;
        }
        uRLBuilder.x(0);
    }

    public static final int c(String str, int i, int i2) {
        int i3;
        int i4;
        char charAt = str.charAt(i);
        if (('a' > charAt || charAt >= '{') && ('A' > charAt || charAt >= '[')) {
            i4 = i;
            i3 = i4;
        } else {
            i4 = i;
            i3 = -1;
        }
        while (i4 < i2) {
            char charAt2 = str.charAt(i4);
            if (charAt2 != ':') {
                if (charAt2 == '/' || charAt2 == '?' || charAt2 == '#') {
                    break;
                }
                if (i3 == -1 && (('a' > charAt2 || charAt2 >= '{') && (('A' > charAt2 || charAt2 >= '[') && !(('0' <= charAt2 && charAt2 < ':') || charAt2 == '.' || charAt2 == '+' || charAt2 == '-')))) {
                    i3 = i4;
                }
                i4++;
            } else if (i3 == -1) {
                return i4 - i;
            } else {
                throw new IllegalArgumentException("Illegal character in scheme at position " + i3);
            }
        }
        return -1;
    }

    public static final List d() {
        return f8978a;
    }

    public static final int e(String str, int i, int i2) {
        boolean z = false;
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt == '[') {
                z = true;
            } else if (charAt == ']') {
                z = false;
            } else if (charAt == ':' && !z) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final void f(URLBuilder uRLBuilder, String str, int i, int i2, int i3) {
        if (i3 == 2) {
            int indexOf$default = StringsKt.indexOf$default((CharSequence) str, '/', i, false, 4, (Object) null);
            if (indexOf$default == -1 || indexOf$default == i2) {
                String substring = str.substring(i, i2);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                uRLBuilder.w(substring);
                return;
            }
            String substring2 = str.substring(i, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            uRLBuilder.w(substring2);
            String substring3 = str.substring(indexOf$default, i2);
            Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
            URLBuilderKt.k(uRLBuilder, substring3);
        } else if (i3 == 3) {
            uRLBuilder.w("");
            StringBuilder sb = new StringBuilder();
            sb.append('/');
            String substring4 = str.substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(substring4, "this as java.lang.String…ing(startIndex, endIndex)");
            sb.append(substring4);
            URLBuilderKt.k(uRLBuilder, sb.toString());
        } else {
            throw new IllegalArgumentException("Invalid file url: " + str);
        }
    }

    public static final void g(URLBuilder uRLBuilder, String str, int i, int i2) {
        if (i < i2 && str.charAt(i) == '#') {
            String substring = str.substring(i + 1, i2);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            uRLBuilder.r(substring);
        }
    }

    public static final void h(URLBuilder uRLBuilder, String str, int i, int i2) {
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, "@", i, false, 4, (Object) null);
        if (indexOf$default != -1) {
            String substring = str.substring(i, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            uRLBuilder.A(CodecsKt.i(substring, 0, 0, (Charset) null, 7, (Object) null));
            String substring2 = str.substring(indexOf$default + 1, i2);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            uRLBuilder.w(substring2);
            return;
        }
        throw new IllegalArgumentException("Invalid mailto url: " + str + ", it should contain '@'.");
    }

    public static final int i(URLBuilder uRLBuilder, String str, int i, int i2) {
        int i3 = i + 1;
        if (i3 == i2) {
            uRLBuilder.z(true);
            return i2;
        }
        Integer valueOf = Integer.valueOf(StringsKt.indexOf$default((CharSequence) str, '#', i3, false, 4, (Object) null));
        if (valueOf.intValue() <= 0) {
            valueOf = null;
        }
        if (valueOf != null) {
            i2 = valueOf.intValue();
        }
        String substring = str.substring(i3, i2);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        QueryKt.d(substring, 0, 0, false, 6, (Object) null).c(new URLParserKt$parseQuery$1(uRLBuilder));
        return i2;
    }

    public static final URLBuilder j(URLBuilder uRLBuilder, String str) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(str, "urlString");
        if (StringsKt.isBlank(str)) {
            return uRLBuilder;
        }
        try {
            return k(uRLBuilder, str);
        } catch (Throwable th) {
            throw new URLParserException(str, th);
        }
    }

    public static final URLBuilder k(URLBuilder uRLBuilder, String str) {
        int i;
        int i2;
        URLBuilder uRLBuilder2 = uRLBuilder;
        String str2 = str;
        Intrinsics.checkNotNullParameter(uRLBuilder2, "<this>");
        Intrinsics.checkNotNullParameter(str2, "urlString");
        int length = str.length();
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                i3 = -1;
                break;
            } else if (!CharsKt.isWhitespace(str2.charAt(i3))) {
                break;
            } else {
                i3++;
            }
        }
        int length2 = str.length() - 1;
        if (length2 >= 0) {
            while (true) {
                int i4 = length2 - 1;
                if (!CharsKt.isWhitespace(str2.charAt(length2))) {
                    i = length2;
                    break;
                } else if (i4 < 0) {
                    break;
                } else {
                    length2 = i4;
                }
            }
        }
        i = -1;
        int i5 = i + 1;
        int c = c(str2, i3, i5);
        if (c > 0) {
            String substring = str2.substring(i3, i3 + c);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            uRLBuilder2.y(URLProtocol.c.a(substring));
            i3 += c + 1;
        }
        int a2 = a(str2, i3, i5, '/');
        int i6 = i3 + a2;
        if (Intrinsics.areEqual((Object) uRLBuilder.o().f(), (Object) "file")) {
            f(uRLBuilder2, str2, i6, i5, a2);
            return uRLBuilder2;
        } else if (!Intrinsics.areEqual((Object) uRLBuilder.o().f(), (Object) "mailto")) {
            Integer num = null;
            if (a2 >= 2) {
                int i7 = i6;
                while (true) {
                    i2 = i7;
                    Integer valueOf = Integer.valueOf(StringsKt.indexOfAny$default((CharSequence) str, CharsetKt.b("@/\\?#"), i7, false, 4, (Object) null));
                    if (valueOf.intValue() <= 0) {
                        valueOf = null;
                    }
                    i6 = valueOf != null ? valueOf.intValue() : i5;
                    if (i6 >= i5 || str2.charAt(i6) != '@') {
                        b(uRLBuilder2, str2, i2, i6);
                    } else {
                        int e = e(str2, i2, i6);
                        if (e != -1) {
                            String substring2 = str2.substring(i2, e);
                            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                            uRLBuilder2.v(substring2);
                            String substring3 = str2.substring(e + 1, i6);
                            Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                            uRLBuilder2.t(substring3);
                        } else {
                            String substring4 = str2.substring(i2, i6);
                            Intrinsics.checkNotNullExpressionValue(substring4, "this as java.lang.String…ing(startIndex, endIndex)");
                            uRLBuilder2.v(substring4);
                        }
                        i7 = i6 + 1;
                    }
                }
                b(uRLBuilder2, str2, i2, i6);
            }
            int i8 = i6;
            if (i8 >= i5) {
                uRLBuilder2.u(str2.charAt(i) == '/' ? f8978a : CollectionsKt.emptyList());
                return uRLBuilder2;
            }
            uRLBuilder2.u(a2 == 0 ? CollectionsKt.dropLast(uRLBuilder.g(), 1) : CollectionsKt.emptyList());
            Integer valueOf2 = Integer.valueOf(StringsKt.indexOfAny$default((CharSequence) str, CharsetKt.b("?#"), i8, false, 4, (Object) null));
            if (valueOf2.intValue() > 0) {
                num = valueOf2;
            }
            int intValue = num != null ? num.intValue() : i5;
            if (intValue > i8) {
                String substring5 = str2.substring(i8, intValue);
                Intrinsics.checkNotNullExpressionValue(substring5, "this as java.lang.String…ing(startIndex, endIndex)");
                uRLBuilder2.u(CollectionsKt.plus((uRLBuilder.g().size() == 1 && ((CharSequence) CollectionsKt.first(uRLBuilder.g())).length() == 0) ? CollectionsKt.emptyList() : uRLBuilder.g(), CollectionsKt.plus(a2 == 1 ? f8978a : CollectionsKt.emptyList(), Intrinsics.areEqual((Object) substring5, (Object) "/") ? f8978a : StringsKt.split$default((CharSequence) substring5, new char[]{'/'}, false, 0, 6, (Object) null))));
                i8 = intValue;
            }
            if (i8 < i5 && str2.charAt(i8) == '?') {
                i8 = i(uRLBuilder2, str2, i8, i5);
            }
            g(uRLBuilder2, str2, i8, i5);
            return uRLBuilder2;
        } else if (a2 == 0) {
            h(uRLBuilder2, str2, i6, i5);
            return uRLBuilder2;
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }
}
