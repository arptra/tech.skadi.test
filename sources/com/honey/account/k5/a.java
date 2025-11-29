package com.honey.account.k5;

import com.upuphone.ar.translation.statemachine.handler.XunFeiChannelHandler$mAsrResultCallback$1;
import com.upuphone.oggopus.OggOpus;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class a implements OggOpus.OnDataListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f4908a;
    public final /* synthetic */ XunFeiChannelHandler$mAsrResultCallback$1 b;
    public final /* synthetic */ byte[] c;

    public /* synthetic */ a(Ref.IntRef intRef, XunFeiChannelHandler$mAsrResultCallback$1 xunFeiChannelHandler$mAsrResultCallback$1, byte[] bArr) {
        this.f4908a = intRef;
        this.b = xunFeiChannelHandler$mAsrResultCallback$1;
        this.c = bArr;
    }

    public final void onData(byte[] bArr, long j) {
        XunFeiChannelHandler$mAsrResultCallback$1.g(this.f4908a, this.b, this.c, bArr, j);
    }
}
