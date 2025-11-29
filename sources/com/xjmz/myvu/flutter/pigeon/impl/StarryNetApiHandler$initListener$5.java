package com.xjmz.myvu.flutter.pigeon.impl;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.main.StarryNetAbilityManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/xjmz/myvu/flutter/pigeon/impl/StarryNetApiHandler$initListener$5", "Lcom/upuphone/xr/interconnect/InterconnectManager$OnStarrySdkStateChangeListener;", "onStateChanged", "", "isEnable", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class StarryNetApiHandler$initListener$5 implements InterconnectManager.OnStarrySdkStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StarryNetApiHandler f8358a;

    public StarryNetApiHandler$initListener$5(StarryNetApiHandler starryNetApiHandler) {
        this.f8358a = starryNetApiHandler;
    }

    public void onStateChanged(boolean z) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("StarryNetApiHandler", "onStateChanged: " + z);
        StarryNetAbilityManager instance = StarryNetAbilityManager.getInstance();
        String H = this.f8358a.b;
        String G = this.f8358a.d;
        StarryNetApiHandler starryNetApiHandler = this.f8358a;
        instance.registerMultiBypassAbility(H, G, starryNetApiHandler, starryNetApiHandler.a0());
    }
}
