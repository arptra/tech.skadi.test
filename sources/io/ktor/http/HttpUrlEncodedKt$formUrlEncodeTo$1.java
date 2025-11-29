package io.ktor.http;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class HttpUrlEncodedKt$formUrlEncodeTo$1 extends Lambda implements Function1<Pair<? extends String, ? extends String>, CharSequence> {
    public static final HttpUrlEncodedKt$formUrlEncodeTo$1 INSTANCE = new HttpUrlEncodedKt$formUrlEncodeTo$1();

    public HttpUrlEncodedKt$formUrlEncodeTo$1() {
        super(1);
    }

    @NotNull
    public final CharSequence invoke(@NotNull Pair<String, String> pair) {
        Intrinsics.checkNotNullParameter(pair, "it");
        String l = CodecsKt.l(pair.getFirst(), true);
        if (pair.getSecond() == null) {
            return l;
        }
        String n = CodecsKt.n(String.valueOf(pair.getSecond()));
        return l + '=' + n;
    }
}
