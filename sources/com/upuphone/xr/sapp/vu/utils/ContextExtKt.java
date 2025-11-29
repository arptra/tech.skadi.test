package com.upuphone.xr.sapp.vu.utils;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u001a-\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u00012\b\b\u0001\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroid/content/Context;", "", "formatRes", "clickableContentRes", "Landroid/view/View$OnClickListener;", "clickListener", "", "a", "(Landroid/content/Context;IILandroid/view/View$OnClickListener;)Ljava/lang/CharSequence;", "app_intlRelease"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nContextExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContextExt.kt\ncom/upuphone/xr/sapp/vu/utils/ContextExtKt\n+ 2 SpannableString.kt\nandroidx/core/text/SpannableStringKt\n*L\n1#1,44:1\n64#2,2:45\n*S KotlinDebug\n*F\n+ 1 ContextExt.kt\ncom/upuphone/xr/sapp/vu/utils/ContextExtKt\n*L\n42#1:45,2\n*E\n"})
public final class ContextExtKt {
    public static final CharSequence a(Context context, int i, int i2, View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(onClickListener, "clickListener");
        String string = context.getString(i2);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = context.getString(i, new Object[]{string});
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        int indexOf$default = StringsKt.indexOf$default((CharSequence) string2, string, 0, false, 6, (Object) null);
        if (indexOf$default < 0) {
            return string2;
        }
        SpannableString spannableString = new SpannableString(string2);
        ContextExtKt$getClickableString$clickSpan$1 contextExtKt$getClickableString$clickSpan$1 = new ContextExtKt$getClickableString$clickSpan$1(onClickListener, context);
        IntRange intRange = new IntRange(indexOf$default, string.length() + indexOf$default);
        spannableString.setSpan(contextExtKt$getClickableString$clickSpan$1, intRange.getStart().intValue(), intRange.getEndInclusive().intValue(), 17);
        return spannableString;
    }
}
