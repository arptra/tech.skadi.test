package com.honey.account.db;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.imagepicker.Messages;

public final /* synthetic */ class i implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.ImagePickerApi f7230a;

    public /* synthetic */ i(Messages.ImagePickerApi imagePickerApi) {
        this.f7230a = imagePickerApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        Messages.ImagePickerApi.lambda$setUp$2(this.f7230a, obj, reply);
    }
}
