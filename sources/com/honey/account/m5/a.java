package com.honey.account.m5;

import com.upuphone.datatrack.sdk.XJDataTrack;
import java.util.Map;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XJDataTrack f4945a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Map c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ boolean g;

    public /* synthetic */ a(XJDataTrack xJDataTrack, String str, Map map, String str2, String str3, String str4, boolean z) {
        this.f4945a = xJDataTrack;
        this.b = str;
        this.c = map;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = z;
    }

    public final void run() {
        this.f4945a.j(this.b, this.c, this.d, this.e, this.f, this.g);
    }
}
