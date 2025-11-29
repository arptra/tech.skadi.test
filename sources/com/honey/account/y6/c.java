package com.honey.account.y6;

import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pManager;
import com.upuphone.starrynet.core.p2p.WiFiP2pGCManager;

public final /* synthetic */ class c implements WifiP2pManager.GroupInfoListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WiFiP2pGCManager f5331a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ byte[] d;
    public final /* synthetic */ int e;
    public final /* synthetic */ int f;
    public final /* synthetic */ String g;

    public /* synthetic */ c(WiFiP2pGCManager wiFiP2pGCManager, String str, String str2, byte[] bArr, int i, int i2, String str3) {
        this.f5331a = wiFiP2pGCManager;
        this.b = str;
        this.c = str2;
        this.d = bArr;
        this.e = i;
        this.f = i2;
        this.g = str3;
    }

    public final void onGroupInfoAvailable(WifiP2pGroup wifiP2pGroup) {
        this.f5331a.lambda$connect$1(this.b, this.c, this.d, this.e, this.f, this.g, wifiP2pGroup);
    }
}
