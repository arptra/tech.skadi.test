package com.honey.account.gb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.urllauncher.Messages;

public final /* synthetic */ class a implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.UrlLauncherApi f7321a;

    public /* synthetic */ a(Messages.UrlLauncherApi urlLauncherApi) {
        this.f7321a = urlLauncherApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        Messages.UrlLauncherApi.lambda$setup$0(this.f7321a, obj, reply);
    }
}
