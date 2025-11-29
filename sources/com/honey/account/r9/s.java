package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidAppApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class s implements BasicMessageChannel.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAppApi.VoidResult f7582a;
    public final /* synthetic */ String b;

    public /* synthetic */ s(AndroidAppApi.VoidResult voidResult, String str) {
        this.f7582a = voidResult;
        this.b = str;
    }

    public final void reply(Object obj) {
        AndroidAppApi.FlutterGlassSettingApi.d(this.f7582a, this.b, obj);
    }
}
