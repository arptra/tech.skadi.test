package com.honey.account.eb;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.pathprovider.Messages;

public final /* synthetic */ class a implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.PathProviderApi f7283a;

    public /* synthetic */ a(Messages.PathProviderApi pathProviderApi) {
        this.f7283a = pathProviderApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        Messages.PathProviderApi.lambda$setup$0(this.f7283a, obj, reply);
    }
}
