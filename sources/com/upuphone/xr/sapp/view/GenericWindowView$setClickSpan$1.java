package com.upuphone.xr.sapp.view;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.upuphone.xr.sapp.view.GenericWindowView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/upuphone/xr/sapp/view/GenericWindowView$setClickSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GenericWindowView$setClickSpan$1 extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GenericWindowView f7966a;

    public GenericWindowView$setClickSpan$1(GenericWindowView genericWindowView) {
        this.f7966a = genericWindowView;
    }

    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "widget");
        String str = this.f7966a.getWindowType() == 132 ? "TYPE_ONE" : null;
        GenericWindowView.IClickCallback callback = this.f7966a.getCallback();
        if (callback != null) {
            callback.b(this.f7966a.getWindowType(), str);
        }
    }

    public void updateDrawState(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "ds");
        textPaint.setUnderlineText(false);
    }
}
