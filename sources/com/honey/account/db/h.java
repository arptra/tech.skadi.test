package com.honey.account.db;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.imagepicker.Messages;

public final /* synthetic */ class h implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Messages.ImagePickerApi f7229a;

    public /* synthetic */ h(Messages.ImagePickerApi imagePickerApi) {
        this.f7229a = imagePickerApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        Messages.ImagePickerApi.lambda$setUp$1(this.f7229a, obj, reply);
    }
}
