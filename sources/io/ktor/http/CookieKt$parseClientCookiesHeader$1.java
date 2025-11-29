package io.ktor.http;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "it", "Lkotlin/text/MatchResult;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class CookieKt$parseClientCookiesHeader$1 extends Lambda implements Function1<MatchResult, Pair<? extends String, ? extends String>> {
    public static final CookieKt$parseClientCookiesHeader$1 INSTANCE = new CookieKt$parseClientCookiesHeader$1();

    public CookieKt$parseClientCookiesHeader$1() {
        super(1);
    }

    @NotNull
    public final Pair<String, String> invoke(@NotNull MatchResult matchResult) {
        String str;
        String value;
        Intrinsics.checkNotNullParameter(matchResult, "it");
        MatchGroup matchGroup = matchResult.getGroups().get(2);
        String str2 = "";
        if (matchGroup == null || (str = matchGroup.getValue()) == null) {
            str = str2;
        }
        MatchGroup matchGroup2 = matchResult.getGroups().get(4);
        if (!(matchGroup2 == null || (value = matchGroup2.getValue()) == null)) {
            str2 = value;
        }
        return TuplesKt.to(str, str2);
    }
}
