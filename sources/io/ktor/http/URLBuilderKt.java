package io.ktor.http;

import com.honey.account.constant.AccountConstantKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u001a)\u0010\u0005\u001a\u00028\u0000\"\f\b\u0000\u0010\u0002*\u00060\u0000j\u0002`\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\u000b\u001a\u00020\n*\u00060\u0000j\u0002`\u00012\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a'\u0010\u000e\u001a\u00020\n*\u00060\u0000j\u0002`\u00012\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\f\u001a\u0011\u0010\u000f\u001a\u00020\u0003*\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0019\u0010\u0012\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a\\\u0010\u001b\u001a\u00020\n*\u00020\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\u0018¢\u0006\u0002\b\u0019¢\u0006\u0004\b\u001b\u0010\u001c\"\u0018\u0010\u001f\u001a\u00020\u0007*\u00020\u00038@X\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\"\u0015\u0010!\u001a\u00020\u0007*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b \u0010\u001e\"(\u0010\r\u001a\u00020\u0007*\u00020\u00032\u0006\u0010\"\u001a\u00020\u00078F@FX\u000e¢\u0006\f\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010%¨\u0006&"}, d2 = {"Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "A", "Lio/ktor/http/URLBuilder;", "out", "d", "(Lio/ktor/http/URLBuilder;Ljava/lang/Appendable;)Ljava/lang/Appendable;", "", "encodedUser", "host", "", "c", "(Ljava/lang/Appendable;Ljava/lang/String;Ljava/lang/String;)V", "encodedPath", "b", "e", "(Lio/ktor/http/URLBuilder;)Lio/ktor/http/URLBuilder;", "", "i", "(Ljava/util/List;)Ljava/lang/String;", "scheme", "", "port", "path", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "block", "j", "(Lio/ktor/http/URLBuilder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "h", "(Lio/ktor/http/URLBuilder;)Ljava/lang/String;", "encodedUserAndPassword", "f", "authority", "value", "g", "k", "(Lio/ktor/http/URLBuilder;Ljava/lang/String;)V", "ktor-http"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nURLBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 URLBuilder.kt\nio/ktor/http/URLBuilderKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,308:1\n1360#2:309\n1446#2,5:310\n1549#2:315\n1620#2,3:316\n11335#3:319\n11670#3,3:320\n*S KotlinDebug\n*F\n+ 1 URLBuilder.kt\nio/ktor/http/URLBuilderKt\n*L\n188#1:309\n188#1:310,5\n189#1:315\n189#1:316,3\n211#1:319\n211#1:320,3\n*E\n"})
public final class URLBuilderKt {
    public static final void b(Appendable appendable, String str, String str2) {
        appendable.append("://");
        appendable.append(str);
        if (!StringsKt.startsWith$default((CharSequence) str2, '/', false, 2, (Object) null)) {
            appendable.append('/');
        }
        appendable.append(str2);
    }

    public static final void c(Appendable appendable, String str, String str2) {
        appendable.append(AccountConstantKt.CODE_SEPARTOR);
        appendable.append(str);
        appendable.append(str2);
    }

    public static final Appendable d(URLBuilder uRLBuilder, Appendable appendable) {
        appendable.append(uRLBuilder.o().f());
        String f = uRLBuilder.o().f();
        if (Intrinsics.areEqual((Object) f, (Object) "file")) {
            b(appendable, uRLBuilder.j(), g(uRLBuilder));
            return appendable;
        } else if (Intrinsics.areEqual((Object) f, (Object) "mailto")) {
            c(appendable, h(uRLBuilder), uRLBuilder.j());
            return appendable;
        } else {
            appendable.append("://");
            appendable.append(f(uRLBuilder));
            URLUtilsKt.e(appendable, g(uRLBuilder), uRLBuilder.e(), uRLBuilder.p());
            if (uRLBuilder.d().length() > 0) {
                appendable.append('#');
                appendable.append(uRLBuilder.d());
            }
            return appendable;
        }
    }

    public static final URLBuilder e(URLBuilder uRLBuilder) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        return URLUtilsKt.h(new URLBuilder((URLProtocol) null, (String) null, 0, (String) null, (String) null, (List) null, (Parameters) null, (String) null, false, 511, (DefaultConstructorMarker) null), uRLBuilder);
    }

    public static final String f(URLBuilder uRLBuilder) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append(h(uRLBuilder));
        sb.append(uRLBuilder.j());
        if (!(uRLBuilder.n() == 0 || uRLBuilder.n() == uRLBuilder.o().e())) {
            sb.append(AccountConstantKt.CODE_SEPARTOR);
            sb.append(String.valueOf(uRLBuilder.n()));
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static final String g(URLBuilder uRLBuilder) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        return i(uRLBuilder.g());
    }

    public static final String h(URLBuilder uRLBuilder) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        StringBuilder sb = new StringBuilder();
        URLUtilsKt.f(sb, uRLBuilder.h(), uRLBuilder.f());
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static final String i(List list) {
        return list.isEmpty() ? "" : list.size() == 1 ? ((CharSequence) CollectionsKt.first(list)).length() == 0 ? "/" : (String) CollectionsKt.first(list) : CollectionsKt.joinToString$default(list, "/", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public static final void j(URLBuilder uRLBuilder, String str, String str2, Integer num, String str3, Function1 function1) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (str != null) {
            uRLBuilder.y(URLProtocol.c.a(str));
        }
        if (str2 != null) {
            uRLBuilder.w(str2);
        }
        if (num != null) {
            uRLBuilder.x(num.intValue());
        }
        if (str3 != null) {
            k(uRLBuilder, str3);
        }
        function1.invoke(uRLBuilder);
    }

    public static final void k(URLBuilder uRLBuilder, String str) {
        List list;
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
        if (StringsKt.isBlank(str)) {
            list = CollectionsKt.emptyList();
        } else if (Intrinsics.areEqual((Object) str, (Object) "/")) {
            list = URLParserKt.d();
        } else {
            list = CollectionsKt.toMutableList(StringsKt.split$default((CharSequence) str, new char[]{'/'}, false, 0, 6, (Object) null));
        }
        uRLBuilder.u(list);
    }
}
