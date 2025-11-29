package com.upuphone.xr.sapp.view;

import android.graphics.Rect;
import android.view.ViewTreeObserver;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.view.popup.GenericWindowViewContainer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/upuphone/xr/sapp/view/SuperGenericWindowView$showPermission$1$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SuperGenericWindowView$showPermission$1$1 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuperGenericWindowView f7991a;
    public final /* synthetic */ GenericWindowViewContainer b;

    public SuperGenericWindowView$showPermission$1$1(SuperGenericWindowView superGenericWindowView, GenericWindowViewContainer genericWindowViewContainer) {
        this.f7991a = superGenericWindowView;
        this.b = genericWindowViewContainer;
    }

    public void onGlobalLayout() {
        this.f7991a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        StaticMethodUtilsKt.M(this.b);
        Rect d = this.f7991a.g;
        if (d != null) {
            SuperGenericWindowView superGenericWindowView = this.f7991a;
            GenericWindowViewContainer genericWindowViewContainer = this.b;
            d.top = 0;
            d.left = 0;
            d.bottom = superGenericWindowView.i - genericWindowViewContainer.getHeight();
            d.right = superGenericWindowView.j;
        }
    }
}
