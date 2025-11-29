package io.ktor.util;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "concurrent", "Lio/ktor/util/Attributes;", "a", "(Z)Lio/ktor/util/Attributes;", "ktor-utils"}, k = 2, mv = {1, 8, 0})
public final class AttributesJvmKt {
    public static final Attributes a(boolean z) {
        return z ? new ConcurrentSafeAttributes() : new HashMapAttributes();
    }
}
