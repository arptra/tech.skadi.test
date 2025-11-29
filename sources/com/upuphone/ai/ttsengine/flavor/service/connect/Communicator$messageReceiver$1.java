package com.upuphone.ai.ttsengine.flavor.service.connect;

import android.os.Handler;
import android.os.Message;
import com.upuphone.ai.ttsengine.base.utils.AILOG;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.listener.MessageReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/upuphone/ai/ttsengine/flavor/service/connect/Communicator$messageReceiver$1", "Lcom/upuphone/xr/interconnect/listener/MessageReceiver;", "onMessageReceive", "", "msg", "Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;", "aar_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Communicator$messageReceiver$1 extends MessageReceiver {
    final /* synthetic */ Communicator this$0;

    public Communicator$messageReceiver$1(Communicator communicator) {
        this.this$0 = communicator;
    }

    public void onMessageReceive(@NotNull StarryNetMessage starryNetMessage) {
        Handler d;
        Message obtainMessage;
        Intrinsics.checkNotNullParameter(starryNetMessage, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        AILOG c = this.this$0.f5565a;
        String id = starryNetMessage.getId();
        String senderPkg = starryNetMessage.getSenderPkg();
        String receiverPkg = starryNetMessage.getReceiverPkg();
        String message = starryNetMessage.getMessage();
        String receiveUniteCode = starryNetMessage.getReceiveUniteCode();
        int version = starryNetMessage.getVersion();
        int length = starryNetMessage.getData() == null ? 0 : starryNetMessage.getData().length;
        c.m("Communicator: " + this + ", receive message id: " + id + ", send pkg: " + senderPkg + ", receive pkg: " + receiverPkg + ", message: " + message + ", receive unicode: " + receiveUniteCode + ", version: " + version + ", data size: " + length, new Object[0]);
        if (starryNetMessage.getData() != null && (d = this.this$0.g) != null && (obtainMessage = d.obtainMessage(0, starryNetMessage.getData())) != null) {
            obtainMessage.sendToTarget();
        }
    }
}
