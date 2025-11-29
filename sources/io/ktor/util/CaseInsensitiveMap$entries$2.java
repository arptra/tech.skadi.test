package io.ktor.util;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010'\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004*\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00030\u0001H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lio/ktor/util/CaseInsensitiveString;", "Value", "", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class CaseInsensitiveMap$entries$2 extends Lambda implements Function1<Map.Entry<String, Value>, Map.Entry<CaseInsensitiveString, Value>> {
    public static final CaseInsensitiveMap$entries$2 INSTANCE = new CaseInsensitiveMap$entries$2();

    public CaseInsensitiveMap$entries$2() {
        super(1);
    }

    @NotNull
    public final Map.Entry<CaseInsensitiveString, Value> invoke(@NotNull Map.Entry<String, Value> entry) {
        Intrinsics.checkNotNullParameter(entry, "$this$$receiver");
        return new Entry(TextKt.a(entry.getKey()), entry.getValue());
    }
}
