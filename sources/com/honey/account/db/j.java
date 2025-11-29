package com.honey.account.db;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.imagepicker.Messages;

public final /* synthetic */ class j implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.ImagePickerApi f7231a;

    public /* synthetic */ j(Messages.ImagePickerApi imagePickerApi) {
        this.f7231a = imagePickerApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        Messages.ImagePickerApi.lambda$setUp$3(this.f7231a, obj, reply);
    }
}
