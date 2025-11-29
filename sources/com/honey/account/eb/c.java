package com.honey.account.eb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.pathprovider.Messages;

public final /* synthetic */ class c implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.PathProviderApi f7285a;

    public /* synthetic */ c(Messages.PathProviderApi pathProviderApi) {
        this.f7285a = pathProviderApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        Messages.PathProviderApi.lambda$setup$2(this.f7285a, obj, reply);
    }
}
