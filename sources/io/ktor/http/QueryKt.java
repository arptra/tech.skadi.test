package io.ktor.http;

import com.google.android.gms.actions.SearchIntents;
import io.ktor.http.Parameters;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\r\n\u0002\b\u0005\u001a3\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t\u001a3\u0010\f\u001a\u00020\u000b*\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\r\u001a;\u0010\u0011\u001a\u00020\u000b*\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a'\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a'\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u0018¨\u0006\u001a"}, d2 = {"", "query", "", "startIndex", "limit", "", "decode", "Lio/ktor/http/Parameters;", "c", "(Ljava/lang/String;IIZ)Lio/ktor/http/Parameters;", "Lio/ktor/http/ParametersBuilder;", "", "b", "(Lio/ktor/http/ParametersBuilder;Ljava/lang/String;IIZ)V", "nameIndex", "equalIndex", "endIndex", "a", "(Lio/ktor/http/ParametersBuilder;Ljava/lang/String;IIIZ)V", "start", "end", "", "text", "e", "(IILjava/lang/CharSequence;)I", "f", "ktor-http"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nQuery.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Query.kt\nio/ktor/http/QueryKt\n+ 2 Parameters.kt\nio/ktor/http/Parameters$Companion\n*L\n1#1,95:1\n24#2:96\n*S KotlinDebug\n*F\n+ 1 Query.kt\nio/ktor/http/QueryKt\n*L\n14#1:96\n*E\n"})
public final class QueryKt {
    public static final void a(ParametersBuilder parametersBuilder, String str, int i, int i2, int i3, boolean z) {
        String str2;
        String str3;
        String str4;
        if (i2 == -1) {
            int f = f(i, i3, str);
            int e = e(f, i3, str);
            if (e > f) {
                if (z) {
                    str4 = CodecsKt.k(str, f, e, false, (Charset) null, 12, (Object) null);
                } else {
                    str4 = str.substring(f, e);
                    Intrinsics.checkNotNullExpressionValue(str4, "this as java.lang.String…ing(startIndex, endIndex)");
                }
                parametersBuilder.c(str4, CollectionsKt.emptyList());
                return;
            }
            return;
        }
        int f2 = f(i, i2, str);
        int e2 = e(f2, i2, str);
        if (e2 > f2) {
            if (z) {
                str2 = CodecsKt.k(str, f2, e2, false, (Charset) null, 12, (Object) null);
            } else {
                str2 = str.substring(f2, e2);
                Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            int f3 = f(i2 + 1, i3, str);
            int e3 = e(f3, i3, str);
            if (z) {
                str3 = CodecsKt.k(str, f3, e3, true, (Charset) null, 8, (Object) null);
            } else {
                str3 = str.substring(f3, e3);
                Intrinsics.checkNotNullExpressionValue(str3, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            parametersBuilder.e(str2, str3);
        }
    }

    public static final void b(ParametersBuilder parametersBuilder, String str, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5 = i2;
        int lastIndex = StringsKt.getLastIndex(str);
        int i6 = 0;
        int i7 = i;
        if (i7 <= lastIndex) {
            int i8 = 0;
            int i9 = -1;
            int i10 = i7;
            int i11 = i10;
            while (i8 != i5) {
                char charAt = str.charAt(i10);
                if (charAt == '&') {
                    a(parametersBuilder, str, i11, i9, i10, z);
                    i8++;
                    i9 = -1;
                    i11 = i10 + 1;
                } else if (charAt == '=' && i9 == -1) {
                    i9 = i10;
                }
                if (i10 != lastIndex) {
                    i10++;
                } else {
                    i4 = i11;
                    i3 = i9;
                    i6 = i8;
                }
            }
            return;
        }
        String str2 = str;
        i3 = -1;
        i4 = i7;
        if (i6 != i5) {
            a(parametersBuilder, str, i4, i3, str.length(), z);
        }
    }

    public static final Parameters c(String str, int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(str, SearchIntents.EXTRA_QUERY);
        if (i > StringsKt.getLastIndex(str)) {
            return Parameters.b.a();
        }
        Parameters.Companion companion = Parameters.b;
        ParametersBuilder b = ParametersKt.b(0, 1, (Object) null);
        b(b, str, i, i2, z);
        return b.build();
    }

    public static /* synthetic */ Parameters d(String str, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 1000;
        }
        if ((i3 & 8) != 0) {
            z = true;
        }
        return c(str, i, i2, z);
    }

    public static final int e(int i, int i2, CharSequence charSequence) {
        while (i2 > i && CharsKt.isWhitespace(charSequence.charAt(i2 - 1))) {
            i2--;
        }
        return i2;
    }

    public static final int f(int i, int i2, CharSequence charSequence) {
        while (i < i2 && CharsKt.isWhitespace(charSequence.charAt(i))) {
            i++;
        }
        return i;
    }
}
