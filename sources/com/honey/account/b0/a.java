package com.honey.account.b0;

import androidx.profileinstaller.DeviceProfileWriter;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceProfileWriter f3006a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ a(DeviceProfileWriter deviceProfileWriter, int i, Object obj) {
        this.f3006a = deviceProfileWriter;
        this.b = i;
        this.c = obj;
    }

    public final void run() {
        this.f3006a.g(this.b, this.c);
    }
}
