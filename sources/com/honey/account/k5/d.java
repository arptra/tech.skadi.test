package com.honey.account.k5;

import com.upuphone.ar.translation.statemachine.handler.XunFeiChannelHandler$mAsrResultCallback$1;
import com.upuphone.oggopus.OggOpus;

public final /* synthetic */ class d implements OggOpus.OnDataListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f4909a;

    public /* synthetic */ d(long j) {
        this.f4909a = j;
    }

    public final void onData(byte[] bArr, long j) {
        XunFeiChannelHandler$mAsrResultCallback$1.f(this.f4909a, bArr, j);
    }
}
