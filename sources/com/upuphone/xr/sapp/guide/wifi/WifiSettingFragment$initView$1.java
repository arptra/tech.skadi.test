package com.upuphone.xr.sapp.guide.wifi;

import android.graphics.Rect;
import android.view.ViewTreeObserver;
import com.upuphone.xr.sapp.databinding.FragmentWifiSettingBinding;
import com.upuphone.xr.sapp.utils.GenericWindowManger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/upuphone/xr/sapp/guide/wifi/WifiSettingFragment$initView$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WifiSettingFragment$initView$1 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WifiSettingFragment f7096a;

    public WifiSettingFragment$initView$1(WifiSettingFragment wifiSettingFragment) {
        this.f7096a = wifiSettingFragment;
    }

    public void onGlobalLayout() {
        FragmentWifiSettingBinding L0 = this.f7096a.j;
        FragmentWifiSettingBinding fragmentWifiSettingBinding = null;
        if (L0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            L0 = null;
        }
        L0.getRoot().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        Rect rect = new Rect();
        FragmentWifiSettingBinding L02 = this.f7096a.j;
        if (L02 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            L02 = null;
        }
        L02.getRoot().getWindowVisibleDisplayFrame(rect);
        int i = rect.bottom - rect.top;
        FragmentWifiSettingBinding L03 = this.f7096a.j;
        if (L03 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentWifiSettingBinding = L03;
        }
        GenericWindowManger.c.a().m(fragmentWifiSettingBinding.getRoot().getHeight() - i);
    }
}
