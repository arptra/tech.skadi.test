package com.honey.account.o4;

import android.widget.PopupWindow;
import com.upuphone.ar.navi.lite.view.AvoidLimitPopView;

public final /* synthetic */ class e implements PopupWindow.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AvoidLimitPopView f4972a;

    public /* synthetic */ e(AvoidLimitPopView avoidLimitPopView) {
        this.f4972a = avoidLimitPopView;
    }

    public final void onDismiss() {
        this.f4972a.q();
    }
}
