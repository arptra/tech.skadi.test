package com.upuphone.ar.tici.phone.utils;

import android.net.Uri;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class UrlExtKt$appendParam$subStr$1 extends Lambda implements Function1<Map.Entry<? extends String, ? extends String>, CharSequence> {
    public static final UrlExtKt$appendParam$subStr$1 INSTANCE = new UrlExtKt$appendParam$subStr$1();

    public UrlExtKt$appendParam$subStr$1() {
        super(1);
    }

    @NotNull
    public final CharSequence invoke(@NotNull Map.Entry<String, String> entry) {
        Intrinsics.checkNotNullParameter(entry, "it");
        String encode = Uri.encode(entry.getKey());
        String encode2 = Uri.encode(entry.getValue());
        return encode + "=" + encode2;
    }
}
