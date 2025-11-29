package com.honey.account.g7;

import com.upuphone.starrynet.strategy.channel.IMessageCallback;
import com.upuphone.starrynet.strategy.message.SppMsgSender;

public final /* synthetic */ class d implements IMessageCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SppMsgSender f4470a;
    public final /* synthetic */ int[] b;

    public /* synthetic */ d(SppMsgSender sppMsgSender, int[] iArr) {
        this.f4470a = sppMsgSender;
        this.b = iArr;
    }

    public final void onResult(int i) {
        this.f4470a.lambda$sendMessageByServer$1(this.b, i);
    }
}
