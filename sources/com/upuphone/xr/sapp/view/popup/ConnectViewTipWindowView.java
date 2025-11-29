package com.upuphone.xr.sapp.view.popup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.honey.account.y8.b;
import com.honey.account.y8.c;
import com.upuphone.starrynet.common.utils.tracker.Ring2TrackerConstant;
import com.upuphone.xr.sapp.databinding.LayoutConnectViewWindowBinding;
import com.upuphone.xr.sapp.view.GenericWindowView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/view/popup/ConnectViewTipWindowView;", "Lcom/upuphone/xr/sapp/view/popup/GenericWindowViewContainer;", "windowType", "", "context", "Landroid/content/Context;", "callback", "Lcom/upuphone/xr/sapp/view/GenericWindowView$IClickCallback;", "(ILandroid/content/Context;Lcom/upuphone/xr/sapp/view/GenericWindowView$IClickCallback;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ConnectViewTipWindowView extends GenericWindowViewContainer {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectViewTipWindowView(int i, Context context, GenericWindowView.IClickCallback iClickCallback) {
        super(context, i, iClickCallback);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutConnectViewWindowBinding c = LayoutConnectViewWindowBinding.c(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        c.b.setOnClickListener(new b(c, iClickCallback, i));
        c.g.setOnClickListener(new c(iClickCallback, i));
    }

    public static final void e(LayoutConnectViewWindowBinding layoutConnectViewWindowBinding, GenericWindowView.IClickCallback iClickCallback, int i, View view) {
        Intrinsics.checkNotNullParameter(layoutConnectViewWindowBinding, "$binding");
        int i2 = layoutConnectViewWindowBinding.d.isChecked() ? 2 : 1;
        if (iClickCallback != null) {
            iClickCallback.a(i, Ring2TrackerConstant.MSG_BT_OFF);
        }
        if (iClickCallback != null) {
            iClickCallback.b(i, Integer.valueOf(i2));
        }
    }

    public static final void f(GenericWindowView.IClickCallback iClickCallback, int i, View view) {
        if (iClickCallback != null) {
            iClickCallback.a(i, Ring2TrackerConstant.MSG_RING_EVENT_HANDLER);
        }
    }
}
