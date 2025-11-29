package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidViewGlassControlApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class f2 implements BasicMessageChannel.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidViewGlassControlApi.VoidResult f7544a;
    public final /* synthetic */ String b;

    public /* synthetic */ f2(AndroidViewGlassControlApi.VoidResult voidResult, String str) {
        this.f7544a = voidResult;
        this.b = str;
    }

    public final void reply(Object obj) {
        AndroidViewGlassControlApi.FlutterViewGlassControlApi.c(this.f7544a, this.b, obj);
    }
}
