package com.honey.account.gb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.urllauncher.Messages;

public final /* synthetic */ class c implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.UrlLauncherApi f7323a;

    public /* synthetic */ c(Messages.UrlLauncherApi urlLauncherApi) {
        this.f7323a = urlLauncherApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        Messages.UrlLauncherApi.lambda$setup$2(this.f7323a, obj, reply);
    }
}
