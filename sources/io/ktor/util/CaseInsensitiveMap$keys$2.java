package io.ktor.util;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lio/ktor/util/CaseInsensitiveString;", "Value", "", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class CaseInsensitiveMap$keys$2 extends Lambda implements Function1<String, CaseInsensitiveString> {
    public static final CaseInsensitiveMap$keys$2 INSTANCE = new CaseInsensitiveMap$keys$2();

    public CaseInsensitiveMap$keys$2() {
        super(1);
    }

    @NotNull
    public final CaseInsensitiveString invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$$receiver");
        return TextKt.a(str);
    }
}
