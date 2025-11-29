package com.upuphone.xr.interconnect.business.messenger;

import android.os.Binder;
import com.honey.account.v7.a;
import com.upuphone.starrynetsdk.ability.relay.BypassAbility;
import com.upuphone.xr.interconnect.Constants;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.common.IMessageReceiver;
import com.upuphone.xr.interconnect.common.IMessageSendListener;
import com.upuphone.xr.interconnect.common.IMessageTransport;
import com.upuphone.xr.interconnect.common.IRingMessageReceiver;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.entity.StarryNetRingMsgConfig;
import com.upuphone.xr.interconnect.util.ObjectUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J.\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0014\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0016"}, d2 = {"com/upuphone/xr/interconnect/business/messenger/IpcMessageDispatcher$transporter$1", "Lcom/upuphone/xr/interconnect/common/IMessageTransport$Stub;", "registerMessageReceiver", "", "receiver", "Lcom/upuphone/xr/interconnect/common/IMessageReceiver;", "registerRingMessageReceiver", "Lcom/upuphone/xr/interconnect/common/IRingMessageReceiver;", "sendMessage", "", "msg", "Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;", "listener", "Lcom/upuphone/xr/interconnect/common/IMessageSendListener;", "sendRingMessage", "cofig", "Lcom/upuphone/xr/interconnect/entity/StarryNetRingMsgConfig;", "deviceId", "data", "", "unregisterMessageReceiver", "unregisterRingMessageReceiver", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class IpcMessageDispatcher$transporter$1 extends IMessageTransport.Stub {
    final /* synthetic */ IpcMessageDispatcher this$0;

    public IpcMessageDispatcher$transporter$1(IpcMessageDispatcher ipcMessageDispatcher) {
        this.this$0 = ipcMessageDispatcher;
    }

    /* access modifiers changed from: private */
    public static final void registerRingMessageReceiver$lambda$0(String str, String str2, String str3, byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        if (StringsKt.equals(Constants.SERVICE_DATA, str2, true)) {
            Intrinsics.areEqual((Object) Constants.NOTIY_Characteristic, (Object) str3);
        }
    }

    public void registerMessageReceiver(@Nullable IMessageReceiver iMessageReceiver) {
        if (iMessageReceiver != null) {
            int callingPid = Binder.getCallingPid();
            String objectId = ObjectUtil.getObjectId(iMessageReceiver);
            String objectId2 = ObjectUtil.getObjectId(iMessageReceiver.asBinder());
            IpcMessageDispatcher ipcMessageDispatcher = this.this$0;
            ipcMessageDispatcher.serialize("registration", new IpcMessageDispatcher$transporter$1$registerMessageReceiver$1(ipcMessageDispatcher, callingPid, objectId, objectId2, iMessageReceiver));
        }
    }

    public void registerRingMessageReceiver(@Nullable IRingMessageReceiver iRingMessageReceiver) {
        new BypassAbility().registerBypassListener(Constants.SERVICE_DATA, Constants.DATA_Characteristic, new a());
    }

    @NotNull
    public String sendMessage(@Nullable StarryNetMessage starryNetMessage, @Nullable IMessageSendListener iMessageSendListener) {
        return String.valueOf(InterconnectManager.getInstance().getStarryNetMessenger().sendMessageRequireId(starryNetMessage, iMessageSendListener));
    }

    @NotNull
    public String sendRingMessage(@NotNull StarryNetRingMsgConfig starryNetRingMsgConfig, @Nullable String str, @Nullable byte[] bArr, @Nullable IMessageSendListener iMessageSendListener) {
        Intrinsics.checkNotNullParameter(starryNetRingMsgConfig, "cofig");
        return String.valueOf(InterconnectManager.getInstance().getStarryNetMessenger().sendRingMessage(starryNetRingMsgConfig, str, bArr, iMessageSendListener));
    }

    public void unregisterMessageReceiver(@Nullable IMessageReceiver iMessageReceiver) {
        if (iMessageReceiver != null) {
            int callingPid = Binder.getCallingPid();
            String objectId = ObjectUtil.getObjectId(iMessageReceiver);
            String objectId2 = ObjectUtil.getObjectId(iMessageReceiver.asBinder());
            IpcMessageDispatcher ipcMessageDispatcher = this.this$0;
            ipcMessageDispatcher.serialize("unregistering", new IpcMessageDispatcher$transporter$1$unregisterMessageReceiver$1(ipcMessageDispatcher, callingPid, objectId, objectId2, iMessageReceiver));
        }
    }

    public void unregisterRingMessageReceiver(@Nullable IRingMessageReceiver iRingMessageReceiver) {
        new BypassAbility().unregisterBypassListener(Constants.SERVICE_DATA, Constants.DATA_Characteristic);
    }
}
