package com.upuphone.ar.tici.phone.utils;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0019\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Ljava/nio/charset/Charset;", "other", "", "a", "(Ljava/nio/charset/Charset;Ljava/nio/charset/Charset;)Z", "ar-tici_release"}, k = 2, mv = {1, 9, 0})
public final class CharsetExtKt {
    public static final boolean a(Charset charset, Charset charset2) {
        Intrinsics.checkNotNullParameter(charset, "<this>");
        Intrinsics.checkNotNullParameter(charset2, "other");
        if (Intrinsics.areEqual((Object) charset, (Object) charset2)) {
            return true;
        }
        String name = charset.name();
        String name2 = charset2.name();
        return Intrinsics.areEqual((Object) name, (Object) "windows-1252") ? Intrinsics.areEqual((Object) name2, (Object) "US-ASCII") : Intrinsics.areEqual((Object) name, (Object) "UTF-8") && Intrinsics.areEqual((Object) name2, (Object) "US-ASCII");
    }
}
