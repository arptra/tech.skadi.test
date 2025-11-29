package com.honey.account.db;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.imagepicker.Messages;

public final /* synthetic */ class g implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.ImagePickerApi f7228a;

    public /* synthetic */ g(Messages.ImagePickerApi imagePickerApi) {
        this.f7228a = imagePickerApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        Messages.ImagePickerApi.lambda$setUp$0(this.f7228a, obj, reply);
    }
}
