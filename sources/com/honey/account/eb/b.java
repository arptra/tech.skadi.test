package com.honey.account.eb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.pathprovider.Messages;

public final /* synthetic */ class b implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.PathProviderApi f7284a;

    public /* synthetic */ b(Messages.PathProviderApi pathProviderApi) {
        this.f7284a = pathProviderApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        Messages.PathProviderApi.lambda$setup$1(this.f7284a, obj, reply);
    }
}
