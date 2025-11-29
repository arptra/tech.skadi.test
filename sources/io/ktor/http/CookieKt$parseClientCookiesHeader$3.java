package io.ktor.http;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "cookie", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class CookieKt$parseClientCookiesHeader$3 extends Lambda implements Function1<Pair<? extends String, ? extends String>, Pair<? extends String, ? extends String>> {
    public static final CookieKt$parseClientCookiesHeader$3 INSTANCE = new CookieKt$parseClientCookiesHeader$3();

    public CookieKt$parseClientCookiesHeader$3() {
        super(1);
    }

    @NotNull
    public final Pair<String, String> invoke(@NotNull Pair<String, String> pair) {
        Intrinsics.checkNotNullParameter(pair, "cookie");
        return (!StringsKt.startsWith$default(pair.getSecond(), "\"", false, 2, (Object) null) || !StringsKt.endsWith$default(pair.getSecond(), "\"", false, 2, (Object) null)) ? pair : Pair.copy$default(pair, (Object) null, StringsKt.removeSurrounding(pair.getSecond(), (CharSequence) "\""), 1, (Object) null);
    }
}
