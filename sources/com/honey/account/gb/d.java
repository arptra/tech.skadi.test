package com.honey.account.gb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.urllauncher.Messages;

public final /* synthetic */ class d implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.UrlLauncherApi f7324a;

    public /* synthetic */ d(Messages.UrlLauncherApi urlLauncherApi) {
        this.f7324a = urlLauncherApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        Messages.UrlLauncherApi.lambda$setup$3(this.f7324a, obj, reply);
    }
}
