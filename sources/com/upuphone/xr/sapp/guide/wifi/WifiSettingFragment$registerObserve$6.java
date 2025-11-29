package com.upuphone.xr.sapp.guide.wifi;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.entity.GlassWifiValidInfo;
import com.upuphone.xr.sapp.guide.adapter.WifiListAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/xr/sapp/entity/GlassWifiValidInfo;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class WifiSettingFragment$registerObserve$6 extends Lambda implements Function1<GlassWifiValidInfo, Unit> {
    final /* synthetic */ WifiSettingFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WifiSettingFragment$registerObserve$6(WifiSettingFragment wifiSettingFragment) {
        super(1);
        this.this$0 = wifiSettingFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GlassWifiValidInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(GlassWifiValidInfo glassWifiValidInfo) {
        if (glassWifiValidInfo != null) {
            WifiSettingFragment wifiSettingFragment = this.this$0;
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("WifiSettingFragment", "receive network_valid: " + glassWifiValidInfo);
            WifiListAdapter S0 = wifiSettingFragment.k;
            if (S0 != null) {
                S0.J(glassWifiValidInfo.getSsid(), glassWifiValidInfo.getNetworkValid());
            }
        }
    }
}
