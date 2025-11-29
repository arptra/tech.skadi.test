package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidPermissionApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class h1 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidPermissionApi.PermissionApi f7551a;

    public /* synthetic */ h1(AndroidPermissionApi.PermissionApi permissionApi) {
        this.f7551a = permissionApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidPermissionApi.PermissionApi.k(this.f7551a, obj, reply);
    }
}
