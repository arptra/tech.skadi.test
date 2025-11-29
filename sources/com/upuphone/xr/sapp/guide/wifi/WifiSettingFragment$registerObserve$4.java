package com.upuphone.xr.sapp.guide.wifi;

import android.content.Context;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.entity.WifiListInfo;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/xr/sapp/entity/WifiListInfo;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class WifiSettingFragment$registerObserve$4 extends Lambda implements Function1<WifiListInfo, Unit> {
    final /* synthetic */ WifiSettingFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WifiSettingFragment$registerObserve$4(WifiSettingFragment wifiSettingFragment) {
        super(1);
        this.this$0 = wifiSettingFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WifiListInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable WifiListInfo wifiListInfo) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("WifiSettingFragment", "wifiList.observe::it " + wifiListInfo);
        if (wifiListInfo != null) {
            WifiSettingFragment wifiSettingFragment = this.this$0;
            if (wifiSettingFragment.r == 0 || wifiListInfo.getTime() <= wifiSettingFragment.r) {
                long time = wifiListInfo.getTime();
                long O0 = wifiSettingFragment.r;
                delegate.c("WifiSettingFragment", "wifiList.observe invalid state time is: " + time + " and mRequestWifiListTime is: " + O0);
            } else if (!wifiListInfo.getList().isEmpty() || wifiSettingFragment.s > 2) {
                wifiSettingFragment.c1(wifiListInfo.getList());
                boolean booleanValue = ((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), "wifi_auto_connect", Boolean.FALSE, (Context) null, 4, (Object) null)).booleanValue();
                if (wifiSettingFragment.t) {
                    wifiSettingFragment.t = false;
                    if (booleanValue) {
                        wifiSettingFragment.e1(true);
                    }
                }
            } else {
                wifiSettingFragment.v1();
                wifiSettingFragment.s = wifiSettingFragment.s + 1;
            }
        }
    }
}
