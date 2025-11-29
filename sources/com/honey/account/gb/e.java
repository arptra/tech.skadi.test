package com.honey.account.gb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.urllauncher.Messages;

public final /* synthetic */ class e implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.UrlLauncherApi f7325a;

    public /* synthetic */ e(Messages.UrlLauncherApi urlLauncherApi) {
        this.f7325a = urlLauncherApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        Messages.UrlLauncherApi.lambda$setup$4(this.f7325a, obj, reply);
    }
}
