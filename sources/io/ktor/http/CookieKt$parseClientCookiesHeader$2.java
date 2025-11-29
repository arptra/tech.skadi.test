package io.ktor.http;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "", "invoke", "(Lkotlin/Pair;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class CookieKt$parseClientCookiesHeader$2 extends Lambda implements Function1<Pair<? extends String, ? extends String>, Boolean> {
    final /* synthetic */ boolean $skipEscaped;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CookieKt$parseClientCookiesHeader$2(boolean z) {
        super(1);
        this.$skipEscaped = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0018, code lost:
        if (kotlin.text.StringsKt.startsWith$default(r4.getFirst(), "$", false, 2, (java.lang.Object) null) == false) goto L_0x001a;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Boolean invoke(@org.jetbrains.annotations.NotNull kotlin.Pair<java.lang.String, java.lang.String> r4) {
        /*
            r3 = this;
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            boolean r3 = r3.$skipEscaped
            if (r3 == 0) goto L_0x001a
            java.lang.Object r3 = r4.getFirst()
            java.lang.String r3 = (java.lang.String) r3
            r4 = 2
            r0 = 0
            java.lang.String r1 = "$"
            r2 = 0
            boolean r3 = kotlin.text.StringsKt.startsWith$default(r3, r1, r2, r4, r0)
            if (r3 != 0) goto L_0x001b
        L_0x001a:
            r2 = 1
        L_0x001b:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r2)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.CookieKt$parseClientCookiesHeader$2.invoke(kotlin.Pair):java.lang.Boolean");
    }
}
