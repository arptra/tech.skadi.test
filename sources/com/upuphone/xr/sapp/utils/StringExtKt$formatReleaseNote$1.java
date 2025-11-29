package com.upuphone.xr.sapp.utils;

import android.text.Html;
import android.text.Spanned;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class StringExtKt$formatReleaseNote$1 extends Lambda implements Function1<String, CharSequence> {
    public static final StringExtKt$formatReleaseNote$1 INSTANCE = new StringExtKt$formatReleaseNote$1();

    public StringExtKt$formatReleaseNote$1() {
        super(1);
    }

    @NotNull
    public final CharSequence invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        Spanned fromHtml = Html.fromHtml(str, 63);
        Intrinsics.checkNotNullExpressionValue(fromHtml, "fromHtml(...)");
        return fromHtml;
    }
}
