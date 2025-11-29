package io.ktor.http;

import io.netty.util.internal.StringUtil;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.apache.commons.io.IOUtils;

@Metadata(d1 = {"\u0000.\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\f\n\u0002\b\u0004\u001a\u0011\u0010\u0001\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0000H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\u0006\u001a\u00020\u0003*\u00020\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u0011\u0010\u0007\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\u0002\u001a\u001f\u0010\f\u001a\u00020\u000b*\u00020\u00002\n\u0010\n\u001a\u00060\bj\u0002`\tH\u0002¢\u0006\u0004\b\f\u0010\r\"\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"", "b", "(Ljava/lang/String;)Ljava/lang/String;", "", "d", "(Ljava/lang/String;)Z", "c", "e", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "out", "", "f", "(Ljava/lang/String;Ljava/lang/StringBuilder;)V", "", "", "a", "Ljava/util/Set;", "HeaderFieldValueSeparators", "ktor-http"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nHeaderValueWithParameters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HeaderValueWithParameters.kt\nio/ktor/http/HeaderValueWithParametersKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,152:1\n1#2:153\n*E\n"})
public final class HeaderValueWithParametersKt {

    /* renamed from: a  reason: collision with root package name */
    public static final Set f8961a = SetsKt.setOf('(', ')', Character.valueOf(Typography.less), Character.valueOf(Typography.greater), '@', Character.valueOf(StringUtil.COMMA), ';', ':', Character.valueOf(IOUtils.DIR_SEPARATOR_WINDOWS), '\"', '/', '[', ']', '?', '=', '{', '}', ' ', 9, 10, 13);

    public static final String b(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return d(str) ? e(str) : str;
    }

    public static final boolean c(String str) {
        if (str.length() < 2 || StringsKt.first(str) != '\"' || StringsKt.last(str) != '\"') {
            return false;
        }
        int i = 1;
        do {
            int indexOf$default = StringsKt.indexOf$default((CharSequence) str, '\"', i, false, 4, (Object) null);
            if (indexOf$default == StringsKt.getLastIndex(str)) {
                break;
            }
            int i2 = 0;
            for (int i3 = indexOf$default - 1; str.charAt(i3) == '\\'; i3--) {
                i2++;
            }
            if (i2 % 2 == 0) {
                return false;
            }
            i = indexOf$default + 1;
        } while (i < str.length());
        return true;
    }

    public static final boolean d(String str) {
        if (str.length() == 0) {
            return true;
        }
        if (c(str)) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (f8961a.contains(Character.valueOf(str.charAt(i)))) {
                return true;
            }
        }
        return false;
    }

    public static final String e(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        StringBuilder sb = new StringBuilder();
        f(str, sb);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static final void f(String str, StringBuilder sb) {
        sb.append("\"");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\\') {
                sb.append("\\\\");
            } else if (charAt == 10) {
                sb.append("\\n");
            } else if (charAt == 13) {
                sb.append("\\r");
            } else if (charAt == 9) {
                sb.append("\\t");
            } else if (charAt == '\"') {
                sb.append("\\\"");
            } else {
                sb.append(charAt);
            }
        }
        sb.append("\"");
    }
}
