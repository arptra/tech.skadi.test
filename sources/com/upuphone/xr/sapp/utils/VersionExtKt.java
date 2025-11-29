package com.upuphone.xr.sapp.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u001d\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "version", "version2", "", "a", "(Ljava/lang/String;Ljava/lang/String;)I", "lib_common_release"}, k = 2, mv = {1, 9, 0})
public final class VersionExtKt {
    public static final int a(String str, String str2) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(str, "version");
        Intrinsics.checkNotNullParameter(str2, "version2");
        if (Intrinsics.areEqual((Object) str, (Object) str2)) {
            return 0;
        }
        int i3 = 0;
        int i4 = 0;
        do {
            if (i3 >= str.length() && i4 >= str2.length()) {
                return 0;
            }
            i = 0;
            while (i3 < str.length() && str.charAt(i3) != '.') {
                int i5 = i * 10;
                Integer digitToIntOrNull = CharsKt.digitToIntOrNull(str.charAt(i3));
                i = i5 + (digitToIntOrNull != null ? digitToIntOrNull.intValue() : 0);
                i3++;
            }
            i3++;
            i2 = 0;
            while (i4 < str2.length() && str2.charAt(i4) != '.') {
                int i6 = i2 * 10;
                Integer digitToIntOrNull2 = CharsKt.digitToIntOrNull(str2.charAt(i4));
                i2 = i6 + (digitToIntOrNull2 != null ? digitToIntOrNull2.intValue() : 0);
                i4++;
            }
            i4++;
        } while (i == i2);
        return Intrinsics.compare(i, i2);
    }
}
