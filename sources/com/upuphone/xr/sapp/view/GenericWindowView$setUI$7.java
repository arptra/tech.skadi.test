package com.upuphone.xr.sapp.view;

import android.view.ViewTreeObserver;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/upuphone/xr/sapp/view/GenericWindowView$setUI$7", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GenericWindowView$setUI$7 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GenericWindowView f7969a;

    public GenericWindowView$setUI$7(GenericWindowView genericWindowView) {
        this.f7969a = genericWindowView;
    }

    public void onGlobalLayout() {
        this.f7969a.d.u0.p();
        this.f7969a.d.u0.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
}
