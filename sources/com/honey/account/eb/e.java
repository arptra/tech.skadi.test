package com.honey.account.eb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.pathprovider.Messages;

public final /* synthetic */ class e implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.PathProviderApi f7287a;

    public /* synthetic */ e(Messages.PathProviderApi pathProviderApi) {
        this.f7287a = pathProviderApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        Messages.PathProviderApi.lambda$setup$4(this.f7287a, obj, reply);
    }
}
