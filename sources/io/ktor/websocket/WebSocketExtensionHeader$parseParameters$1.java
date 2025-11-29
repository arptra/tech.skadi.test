package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "it", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class WebSocketExtensionHeader$parseParameters$1 extends Lambda implements Function1<String, Pair<? extends String, ? extends String>> {
    public static final WebSocketExtensionHeader$parseParameters$1 INSTANCE = new WebSocketExtensionHeader$parseParameters$1();

    public WebSocketExtensionHeader$parseParameters$1() {
        super(1);
    }

    @NotNull
    public final Pair<String, String> invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, '=', 0, false, 6, (Object) null);
        String str2 = "";
        if (indexOf$default < 0) {
            return TuplesKt.to(str, str2);
        }
        String substring = StringsKt.substring(str, RangesKt.until(0, indexOf$default));
        int i = indexOf$default + 1;
        if (i < str.length()) {
            str2 = str.substring(i);
            Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String).substring(startIndex)");
        }
        return TuplesKt.to(substring, str2);
    }
}
