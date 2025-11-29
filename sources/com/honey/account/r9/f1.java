package com.honey.account.r9;

import com.xjmz.myvu.flutter.pigeon.AndroidPermissionApi;
import io.flutter.plugin.common.BasicMessageChannel;

public final /* synthetic */ class f1 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AndroidPermissionApi.PermissionApi f7543a;

    public /* synthetic */ f1(AndroidPermissionApi.PermissionApi permissionApi) {
        this.f7543a = permissionApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        AndroidPermissionApi.PermissionApi.m(this.f7543a, obj, reply);
    }
}
