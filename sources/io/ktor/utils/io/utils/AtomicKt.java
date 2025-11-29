package io.ktor.utils.io.utils;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u001f\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "name", "", "default", "a", "(Ljava/lang/String;I)I", "ktor-io"}, k = 2, mv = {1, 8, 0})
public final class AtomicKt {
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        r2 = kotlin.text.StringsKt.toIntOrNull(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int a(java.lang.String r2, int r3) {
        /*
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ SecurityException -> 0x001b }
            r0.<init>()     // Catch:{ SecurityException -> 0x001b }
            java.lang.String r1 = "io.ktor.utils.io."
            r0.append(r1)     // Catch:{ SecurityException -> 0x001b }
            r0.append(r2)     // Catch:{ SecurityException -> 0x001b }
            java.lang.String r2 = r0.toString()     // Catch:{ SecurityException -> 0x001b }
            java.lang.String r2 = java.lang.System.getProperty(r2)     // Catch:{ SecurityException -> 0x001b }
            goto L_0x001c
        L_0x001b:
            r2 = 0
        L_0x001c:
            if (r2 == 0) goto L_0x0028
            java.lang.Integer r2 = kotlin.text.StringsKt.toIntOrNull(r2)
            if (r2 == 0) goto L_0x0028
            int r3 = r2.intValue()
        L_0x0028:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.utils.AtomicKt.a(java.lang.String, int):int");
    }
}
