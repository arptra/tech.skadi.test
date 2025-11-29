package com.honey.account.hb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class a0 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.PermissionRequestHostApi f7339a;

    public /* synthetic */ a0(GeneratedAndroidWebView.PermissionRequestHostApi permissionRequestHostApi) {
        this.f7339a = permissionRequestHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidWebView.PermissionRequestHostApi.lambda$setup$1(this.f7339a, obj, reply);
    }
}
