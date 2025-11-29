package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidAppApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class t implements BasicMessageChannel.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidAppApi.VoidResult f7585a;
    public final /* synthetic */ String b;

    public /* synthetic */ t(AndroidAppApi.VoidResult voidResult, String str) {
        this.f7585a = voidResult;
        this.b = str;
    }

    public final void reply(Object obj) {
        AndroidAppApi.FlutterGlassSettingApi.e(this.f7585a, this.b, obj);
    }
}
