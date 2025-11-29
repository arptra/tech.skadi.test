package com.honey.account.y6;

import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pManager;
import com.upuphone.starrynet.core.p2p.WiFiP2pGCManager;

public final /* synthetic */ class e implements WifiP2pManager.GroupInfoListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WiFiP2pGCManager f5333a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ byte[] d;
    public final /* synthetic */ int e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ int h;

    public /* synthetic */ e(WiFiP2pGCManager wiFiP2pGCManager, String str, String str2, byte[] bArr, int i, String str3, String str4, int i2) {
        this.f5333a = wiFiP2pGCManager;
        this.b = str;
        this.c = str2;
        this.d = bArr;
        this.e = i;
        this.f = str3;
        this.g = str4;
        this.h = i2;
    }

    public final void onGroupInfoAvailable(WifiP2pGroup wifiP2pGroup) {
        this.f5333a.lambda$connect$2(this.b, this.c, this.d, this.e, this.f, this.g, this.h, wifiP2pGroup);
    }
}
