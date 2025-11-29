package com.honey.account.b3;

import com.share.connect.security.UCarAuthService;
import com.ucar.protocol.UCarMessage;
import com.ucar.protocol.channel.UCarChannel;

public final /* synthetic */ class a implements UCarChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UCarAuthService f9706a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ String d;
    public final /* synthetic */ boolean e;

    public /* synthetic */ a(UCarAuthService uCarAuthService, int i, int i2, String str, boolean z) {
        this.f9706a = uCarAuthService;
        this.b = i;
        this.c = i2;
        this.d = str;
        this.e = z;
    }

    public final void a(UCarMessage uCarMessage) {
        this.f9706a.d(this.b, this.c, this.d, this.e, uCarMessage);
    }
}
