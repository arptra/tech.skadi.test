package com.upuphone.ai.ttsengine.base.utils;

import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0013\u0010\u0001\u001a\u00020\u0000*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0013\u0010\u0004\u001a\u00020\u0003*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "b", "(Ljava/lang/String;)Ljava/lang/String;", "", "a", "(Ljava/lang/String;)Z", "aar_intlRelease"}, k = 2, mv = {1, 9, 0})
public final class StringUtilsKt {
    public static final boolean a(String str) {
        return str != null && str.length() > 0 && StringsKt.startsWith$default(str, "<speak>", false, 2, (Object) null) && StringsKt.endsWith$default(str, "</speak>", false, 2, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000b, code lost:
        r2 = com.upuphone.ai.ttsengine.base.utils.StringUtils.c(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String b(java.lang.String r2) {
        /*
            java.lang.String r0 = ""
            if (r2 == 0) goto L_0x0013
            int r1 = r2.length()
            if (r1 != 0) goto L_0x000b
            goto L_0x0013
        L_0x000b:
            java.lang.String r2 = com.upuphone.ai.ttsengine.base.utils.StringUtils.c(r2)
            if (r2 != 0) goto L_0x0012
            goto L_0x0013
        L_0x0012:
            r0 = r2
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ai.ttsengine.base.utils.StringUtilsKt.b(java.lang.String):java.lang.String");
    }
}
