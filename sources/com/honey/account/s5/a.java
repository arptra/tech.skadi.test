package com.honey.account.s5;

import com.upuphone.runasone.channel.bean.auth.AuthParameter;
import com.upuphone.runasone.channel.linker.EnumLinker;
import com.upuphone.runasone.channel.linker.ILinker;
import com.upuphone.runasone.channel.linker.websocket.client.WsClient;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WsClient f5126a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ int e;
    public final /* synthetic */ ILinker.LinkerStreamObserver f;
    public final /* synthetic */ EnumLinker g;
    public final /* synthetic */ AuthParameter h;

    public /* synthetic */ a(WsClient wsClient, String str, String str2, String str3, int i, ILinker.LinkerStreamObserver linkerStreamObserver, EnumLinker enumLinker, AuthParameter authParameter) {
        this.f5126a = wsClient;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = i;
        this.f = linkerStreamObserver;
        this.g = enumLinker;
        this.h = authParameter;
    }

    public final void run() {
        this.f5126a.lambda$new$0(this.b, this.c, this.d, this.e, this.f, this.g, this.h);
    }
}
