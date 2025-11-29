package com.honey.account.gb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.urllauncher.Messages;

public final /* synthetic */ class b implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.UrlLauncherApi f7322a;

    public /* synthetic */ b(Messages.UrlLauncherApi urlLauncherApi) {
        this.f7322a = urlLauncherApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        Messages.UrlLauncherApi.lambda$setup$1(this.f7322a, obj, reply);
    }
}
