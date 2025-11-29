package com.honey.account.g7;

import com.upuphone.starrynet.strategy.channel.IMessageCallback;
import com.upuphone.starrynet.strategy.message.SppMsgSender;

public final /* synthetic */ class e implements IMessageCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SppMsgSender f4471a;
    public final /* synthetic */ int[] b;

    public /* synthetic */ e(SppMsgSender sppMsgSender, int[] iArr) {
        this.f4471a = sppMsgSender;
        this.b = iArr;
    }

    public final void onResult(int i) {
        this.f4471a.lambda$sendMessageByClient$0(this.b, i);
    }
}
