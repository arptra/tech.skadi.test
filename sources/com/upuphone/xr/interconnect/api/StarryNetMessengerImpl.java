package com.upuphone.xr.interconnect.api;

import com.upuphone.runasone.constant.Constants;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.upuphone.xr.interconnect.business.connect.PeerDeviceStatusManager;
import com.upuphone.xr.interconnect.business.messenger.MessageTxProcessor;
import com.upuphone.xr.interconnect.common.IMessageSendListener;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.entity.StarryNetRingMsgConfig;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016JD\u0010\r\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010\u0019\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J0\u0010\u001a\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/upuphone/xr/interconnect/api/StarryNetMessengerImpl;", "Lcom/upuphone/xr/interconnect/api/StarryNetMessenger;", "peerDeviceStatusManager", "Lcom/upuphone/xr/interconnect/business/connect/PeerDeviceStatusManager;", "(Lcom/upuphone/xr/interconnect/business/connect/PeerDeviceStatusManager;)V", "messageTxProcessor", "Lcom/upuphone/xr/interconnect/business/messenger/MessageTxProcessor;", "canSendMessage", "", "deviceId", "", "getDeviceMsgVersion", "", "sendMessage", "", "msg", "Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;", "listener", "Lcom/upuphone/xr/interconnect/common/IMessageSendListener;", "receiverDeviceId", "sender", "receiver", "text", "data", "", "sendMessageRequireId", "sendRingMessage", "ringMsgConfig", "Lcom/upuphone/xr/interconnect/entity/StarryNetRingMsgConfig;", "Companion", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class StarryNetMessengerImpl implements StarryNetMessenger {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String TAG = "StarryNetMessengerImpl";
    @NotNull
    private final MessageTxProcessor messageTxProcessor;
    @NotNull
    private final PeerDeviceStatusManager peerDeviceStatusManager;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/interconnect/api/StarryNetMessengerImpl$Companion;", "", "()V", "TAG", "", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public StarryNetMessengerImpl(@NotNull PeerDeviceStatusManager peerDeviceStatusManager2) {
        Intrinsics.checkNotNullParameter(peerDeviceStatusManager2, "peerDeviceStatusManager");
        this.peerDeviceStatusManager = peerDeviceStatusManager2;
        this.messageTxProcessor = new MessageTxProcessor(peerDeviceStatusManager2);
    }

    public boolean canSendMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        return this.peerDeviceStatusManager.isDeviceNegotiated(str);
    }

    public int getDeviceMsgVersion(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Integer version = this.peerDeviceStatusManager.getVersion(str);
        ILog.e(TAG, "getDeviceVersion version = " + version);
        if (version == null) {
            version = Integer.valueOf(PeerDeviceStatusManager.Companion.getSelfVersion());
        }
        return version.intValue();
    }

    public void sendMessage(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable byte[] bArr, @Nullable IMessageSendListener iMessageSendListener) {
        if (str2 != null && str3 != null) {
            if (str == null) {
                MessageTxProcessor.localSend$default(this.messageTxProcessor, str2, str3, str4, bArr, iMessageSendListener, (Integer) null, 32, (Object) null);
            } else {
                MessageTxProcessor.send$default(this.messageTxProcessor, str, str2, str3, str4, bArr, iMessageSendListener, (Integer) null, 64, (Object) null);
            }
        }
    }

    public int sendMessageRequireId(@Nullable StarryNetMessage starryNetMessage, @Nullable IMessageSendListener iMessageSendListener) {
        StarryNetMessage starryNetMessage2 = starryNetMessage;
        IMessageSendListener iMessageSendListener2 = iMessageSendListener;
        ILog.i(TAG, "sendMessageRequireId Send message with result: " + starryNetMessage2 + ", " + iMessageSendListener2 + ".");
        if (starryNetMessage2 == null) {
            return -1;
        }
        boolean z = false;
        ILog.d(TAG, "发送消息id--" + starryNetMessage.getId() + "，from--" + starryNetMessage.getSenderPkg() + "，to--" + starryNetMessage.getReceiverPkg() + "，message--" + starryNetMessage.getMessage() + "，跨设备流转--" + (starryNetMessage.getTarget() == 0) + "，是否重要--" + (iMessageSendListener2 != null));
        if (starryNetMessage.getTarget() == 0) {
            z = true;
        }
        ILog.i(TAG, z + ", " + starryNetMessage.getSenderPkg() + " -> " + starryNetMessage.getReceiverPkg() + ": " + starryNetMessage.getMessage() + ".");
        int idSource = this.messageTxProcessor.getIdSource();
        StringBuilder sb = new StringBuilder();
        sb.append("sendMessageRequireId messageId = ");
        sb.append(idSource);
        ILog.i(TAG, sb.toString());
        if (starryNetMessage.getTarget() == 1) {
            MessageTxProcessor messageTxProcessor2 = this.messageTxProcessor;
            String senderPkg = starryNetMessage.getSenderPkg();
            Intrinsics.checkNotNullExpressionValue(senderPkg, "getSenderPkg(...)");
            String receiverPkg = starryNetMessage.getReceiverPkg();
            Intrinsics.checkNotNullExpressionValue(receiverPkg, "getReceiverPkg(...)");
            messageTxProcessor2.localSend(senderPkg, receiverPkg, starryNetMessage.getMessage(), starryNetMessage.getData(), iMessageSendListener, Integer.valueOf(idSource));
        } else {
            MessageTxProcessor messageTxProcessor3 = this.messageTxProcessor;
            String senderPkg2 = starryNetMessage.getSenderPkg();
            Intrinsics.checkNotNullExpressionValue(senderPkg2, "getSenderPkg(...)");
            String receiverPkg2 = starryNetMessage.getReceiverPkg();
            Intrinsics.checkNotNullExpressionValue(receiverPkg2, "getReceiverPkg(...)");
            messageTxProcessor3.send(senderPkg2, receiverPkg2, starryNetMessage.getMessage(), starryNetMessage.getData(), iMessageSendListener, Integer.valueOf(idSource));
        }
        return idSource;
    }

    public int sendRingMessage(@Nullable StarryNetRingMsgConfig starryNetRingMsgConfig, @Nullable String str, @Nullable byte[] bArr, @Nullable IMessageSendListener iMessageSendListener) {
        int idSource = this.messageTxProcessor.getIdSource();
        boolean z = false;
        boolean z2 = starryNetRingMsgConfig == null;
        boolean z3 = bArr == null;
        if (iMessageSendListener != null) {
            z = true;
        }
        ILog.d(TAG, "发送消指环消息 deviceId-- " + str + " ,ringMsgConfig is null = " + z2 + " ,data is null = " + z3 + ",messageId = " + idSource + ",是否有listener-- " + z);
        if (str == null || bArr == null || starryNetRingMsgConfig == null) {
            return -1;
        }
        return this.messageTxProcessor.sendRingMsg(starryNetRingMsgConfig, str, bArr, iMessageSendListener, idSource);
    }

    public void sendMessage(@NotNull StarryNetMessage starryNetMessage, @Nullable IMessageSendListener iMessageSendListener) {
        Intrinsics.checkNotNullParameter(starryNetMessage, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        String id = starryNetMessage.getId();
        String senderPkg = starryNetMessage.getSenderPkg();
        String receiverPkg = starryNetMessage.getReceiverPkg();
        String message = starryNetMessage.getMessage();
        boolean z = false;
        boolean z2 = starryNetMessage.getTarget() == 0;
        if (iMessageSendListener != null) {
            z = true;
        }
        ILog.d(TAG, "发送消息id--" + id + "，from--" + senderPkg + "，to--" + receiverPkg + "，message--" + message + "，跨设备流转--" + z2 + "，是否重要--" + z);
        if (starryNetMessage.getTarget() == 1) {
            MessageTxProcessor messageTxProcessor2 = this.messageTxProcessor;
            String senderPkg2 = starryNetMessage.getSenderPkg();
            Intrinsics.checkNotNullExpressionValue(senderPkg2, "getSenderPkg(...)");
            String receiverPkg2 = starryNetMessage.getReceiverPkg();
            Intrinsics.checkNotNullExpressionValue(receiverPkg2, "getReceiverPkg(...)");
            MessageTxProcessor.localSend$default(messageTxProcessor2, senderPkg2, receiverPkg2, starryNetMessage.getMessage(), starryNetMessage.getData(), iMessageSendListener, (Integer) null, 32, (Object) null);
            return;
        }
        MessageTxProcessor messageTxProcessor3 = this.messageTxProcessor;
        String senderPkg3 = starryNetMessage.getSenderPkg();
        Intrinsics.checkNotNullExpressionValue(senderPkg3, "getSenderPkg(...)");
        String receiverPkg3 = starryNetMessage.getReceiverPkg();
        Intrinsics.checkNotNullExpressionValue(receiverPkg3, "getReceiverPkg(...)");
        MessageTxProcessor.send$default(messageTxProcessor3, senderPkg3, receiverPkg3, starryNetMessage.getMessage(), starryNetMessage.getData(), iMessageSendListener, (Integer) null, 32, (Object) null);
    }
}
