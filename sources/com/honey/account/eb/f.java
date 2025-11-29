package com.honey.account.eb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.pathprovider.Messages;

public final /* synthetic */ class f implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.PathProviderApi f7288a;

    public /* synthetic */ f(Messages.PathProviderApi pathProviderApi) {
        this.f7288a = pathProviderApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        Messages.PathProviderApi.lambda$setup$5(this.f7288a, obj, reply);
    }
}
