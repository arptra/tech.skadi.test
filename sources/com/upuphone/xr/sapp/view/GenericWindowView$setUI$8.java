package com.upuphone.xr.sapp.view;

import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/upuphone/xr/sapp/view/GenericWindowView$setUI$8", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GenericWindowView$setUI$8 implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GenericWindowView f7970a;

    public GenericWindowView$setUI$8(GenericWindowView genericWindowView) {
        this.f7970a = genericWindowView;
    }

    public boolean onPreDraw() {
        this.f7970a.d.i.getViewTreeObserver().removeOnPreDrawListener(this);
        ULog.f6446a.a("GenericWindowView", "binding.content, onPreDraw");
        GenericWindowView genericWindowView = this.f7970a;
        TextView textView = genericWindowView.d.i;
        Intrinsics.checkNotNullExpressionValue(textView, "content");
        genericWindowView.W(textView, "binding.content");
        return true;
    }
}
