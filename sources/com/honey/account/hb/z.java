package com.honey.account.hb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class z implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.PermissionRequestHostApi f7443a;

    public /* synthetic */ z(GeneratedAndroidWebView.PermissionRequestHostApi permissionRequestHostApi) {
        this.f7443a = permissionRequestHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidWebView.PermissionRequestHostApi.lambda$setup$0(this.f7443a, obj, reply);
    }
}
