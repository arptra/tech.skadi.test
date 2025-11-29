package com.upuphone.xr.sapp.guide.wifi;

import com.upuphone.xr.sapp.guide.adapter.WifiListAdapter;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.vm.internal.SuperMessageManger;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/upuphone/xr/sapp/guide/wifi/WifiSettingFragment$mSwitchCallback$1", "Lcom/upuphone/xr/sapp/guide/adapter/WifiListAdapter$ISwitchCallback;", "", "state", "", "a", "(Z)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class WifiSettingFragment$mSwitchCallback$1 implements WifiListAdapter.ISwitchCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WifiSettingFragment f7097a;

    public WifiSettingFragment$mSwitchCallback$1(WifiSettingFragment wifiSettingFragment) {
        this.f7097a = wifiSettingFragment;
    }

    public void a(boolean z) {
        if (!z) {
            WifiListAdapter S0 = this.f7097a.k;
            if (S0 != null) {
                S0.I(true, 6, 0, true);
            }
            SuperMessageManger.m.a().B0(true);
        } else if (this.f7097a.i1().R()) {
            StaticMethodUtilsKt.I(this.f7097a, CollectionsKt.arrayListOf(138), false, false, 6, (Object) null);
        } else {
            WifiListAdapter S02 = this.f7097a.k;
            if (S02 != null) {
                S02.I(false, 6, 0, true);
            }
            SuperMessageManger.m.a().B0(false);
        }
    }
}
