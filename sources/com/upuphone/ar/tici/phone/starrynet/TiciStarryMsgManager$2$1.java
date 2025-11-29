package com.upuphone.ar.tici.phone.starrynet;

import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.listener.MessageReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/upuphone/ar/tici/phone/starrynet/TiciStarryMsgManager$2$1", "Lcom/upuphone/xr/interconnect/listener/MessageReceiver;", "onMessageReceive", "", "starryNetMessage", "Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TiciStarryMsgManager$2$1 extends MessageReceiver {
    final /* synthetic */ TiciStarryMsgManager this$0;

    public TiciStarryMsgManager$2$1(TiciStarryMsgManager ticiStarryMsgManager) {
        this.this$0 = ticiStarryMsgManager;
    }

    public void onMessageReceive(@NotNull StarryNetMessage starryNetMessage) {
        Intrinsics.checkNotNullParameter(starryNetMessage, "starryNetMessage");
        this.this$0.handleStarryMsg(starryNetMessage);
    }
}
