package com.upuphone.xr.sapp.fragment;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/upuphone/xr/sapp/fragment/WiseNotifyFragment$spannableTxt$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "p0", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WiseNotifyFragment$spannableTxt$1 extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f7024a;
    public final /* synthetic */ Function0 b;

    public WiseNotifyFragment$spannableTxt$1(String str, Function0 function0) {
        this.f7024a = str;
        this.b = function0;
    }

    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "p0");
        this.b.invoke();
    }

    public void updateDrawState(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "ds");
        textPaint.setColor(Color.parseColor(this.f7024a));
    }
}
