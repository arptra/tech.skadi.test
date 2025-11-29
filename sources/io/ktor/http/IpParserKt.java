package io.ktor.http;

import com.honey.account.constant.AccountConstantKt;
import com.upuphone.runasone.api.ApiConstant;
import io.ktor.http.parsing.Grammar;
import io.ktor.http.parsing.Parser;
import io.ktor.http.parsing.ParserDslKt;
import io.ktor.http.parsing.PrimitivesKt;
import io.ktor.http.parsing.regex.RegexParserGeneratorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\"\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006\"\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0006\"\u0014\u0010\r\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"", "host", "", "a", "(Ljava/lang/String;)Z", "Lio/ktor/http/parsing/Grammar;", "Lio/ktor/http/parsing/Grammar;", "IPv4address", "b", "IPv6address", "Lio/ktor/http/parsing/Parser;", "c", "Lio/ktor/http/parsing/Parser;", "IP_PARSER", "ktor-http"}, k = 2, mv = {1, 8, 0})
public final class IpParserKt {

    /* renamed from: a  reason: collision with root package name */
    public static final Grammar f8970a;
    public static final Grammar b;
    public static final Parser c;

    static {
        Grammar e = ParserDslKt.e(ParserDslKt.f(ParserDslKt.e(ParserDslKt.f(ParserDslKt.e(ParserDslKt.f(PrimitivesKt.b(), "."), PrimitivesKt.b()), "."), PrimitivesKt.b()), "."), PrimitivesKt.b());
        f8970a = e;
        Grammar f = ParserDslKt.f(ParserDslKt.g("[", ParserDslKt.a(ParserDslKt.d(PrimitivesKt.c(), AccountConstantKt.CODE_SEPARTOR))), "]");
        b = f;
        c = RegexParserGeneratorKt.b(ParserDslKt.c(e, f));
    }

    public static final boolean a(String str) {
        Intrinsics.checkNotNullParameter(str, ApiConstant.VALUE_HOST);
        return c.a(str);
    }
}
