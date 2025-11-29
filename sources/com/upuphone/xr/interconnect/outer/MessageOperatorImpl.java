package com.upuphone.xr.interconnect.outer;

import com.upuphone.runasone.constant.Constants;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.upuphone.xr.interconnect.api.StarryNetMessageOperator;
import com.upuphone.xr.interconnect.common.IMessageTransport;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.entity.StarryNetRingMsgConfig;
import com.upuphone.xr.interconnect.listener.ListenerAggregator;
import com.upuphone.xr.interconnect.listener.MessageReceiver;
import com.upuphone.xr.interconnect.listener.RingMessageReceiver;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u001d\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\rH\u0016J\u001a\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0017J\u001a\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J,\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\rH\u0016R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/upuphone/xr/interconnect/outer/MessageOperatorImpl;", "Lcom/upuphone/xr/interconnect/api/StarryNetMessageOperator;", "Lcom/upuphone/xr/interconnect/outer/BaseOperatorImpl;", "Lcom/upuphone/xr/interconnect/common/IMessageTransport;", "transporterGetter", "Lkotlin/Function0;", "identifier", "", "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;)V", "coreMessageReceiver", "Lcom/upuphone/xr/interconnect/listener/ListenerAggregator;", "Lcom/upuphone/xr/interconnect/listener/MessageReceiver;", "coreRingMessageReceiver", "Lcom/upuphone/xr/interconnect/listener/RingMessageReceiver;", "onServiceConnected", "", "onServiceDied", "registerMessageReceiver", "receiver", "registerRingMessageReceiver", "sendMessage", "msg", "Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;", "listener", "Lcom/upuphone/xr/interconnect/listener/SendMessageListener;", "sendMessage2", "sendRingMessage", "config", "Lcom/upuphone/xr/interconnect/entity/StarryNetRingMsgConfig;", "deviceId", "data", "", "unregisterMessageReceiver", "unregisterRingMessageReceiver", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MessageOperatorImpl extends BaseOperatorImpl<IMessageTransport> implements StarryNetMessageOperator {
    @NotNull
    private final ListenerAggregator<MessageReceiver, IMessageTransport> coreMessageReceiver = new MessageOperatorImpl$coreMessageReceiver$1(getTag(), new MessageOperatorImpl$coreMessageReceiver$2(this), new MessageOperatorImpl$coreMessageReceiver$3(this), MessageOperatorImpl$coreMessageReceiver$4.INSTANCE, MessageOperatorImpl$coreMessageReceiver$5.INSTANCE);
    @NotNull
    private final ListenerAggregator<RingMessageReceiver, IMessageTransport> coreRingMessageReceiver = new MessageOperatorImpl$coreRingMessageReceiver$1(getTag(), new MessageOperatorImpl$coreRingMessageReceiver$2(this), new MessageOperatorImpl$coreRingMessageReceiver$3(this), MessageOperatorImpl$coreRingMessageReceiver$4.INSTANCE, MessageOperatorImpl$coreRingMessageReceiver$5.INSTANCE);
    @NotNull
    private final String identifier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageOperatorImpl(@NotNull Function0<? extends IMessageTransport> function0, @NotNull String str) {
        super(function0);
        Intrinsics.checkNotNullParameter(function0, "transporterGetter");
        Intrinsics.checkNotNullParameter(str, "identifier");
        this.identifier = str;
    }

    public void onServiceConnected() {
        super.onServiceConnected();
        this.coreMessageReceiver.onServiceUp();
    }

    public void onServiceDied() {
        super.onServiceDied();
        this.coreMessageReceiver.onServiceDown();
    }

    public void registerMessageReceiver(@NotNull MessageReceiver messageReceiver) {
        Intrinsics.checkNotNullParameter(messageReceiver, "receiver");
        this.coreMessageReceiver.addListener(messageReceiver);
    }

    public void registerRingMessageReceiver(@NotNull RingMessageReceiver ringMessageReceiver) {
        Intrinsics.checkNotNullParameter(ringMessageReceiver, "receiver");
        this.coreRingMessageReceiver.addListener(ringMessageReceiver);
    }

    @Deprecated(message = "Deprecated in Java", replaceWith = @ReplaceWith(expression = "sendMessage2(msg, listener)", imports = {}))
    public void sendMessage(@NotNull StarryNetMessage starryNetMessage, @Nullable SendMessageListener sendMessageListener) {
        Intrinsics.checkNotNullParameter(starryNetMessage, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        sendMessage2(starryNetMessage, sendMessageListener);
    }

    @NotNull
    public String sendMessage2(@NotNull StarryNetMessage starryNetMessage, @Nullable SendMessageListener sendMessageListener) {
        Intrinsics.checkNotNullParameter(starryNetMessage, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        starryNetMessage.setSenderPkg(this.identifier);
        IMessageTransport iMessageTransport = (IMessageTransport) getRemoteProxy();
        String sendMessage = iMessageTransport != null ? iMessageTransport.sendMessage(starryNetMessage, sendMessageListener) : null;
        return sendMessage == null ? "-1" : sendMessage;
    }

    @NotNull
    public String sendRingMessage(@NotNull StarryNetRingMsgConfig starryNetRingMsgConfig, @NotNull String str, @Nullable byte[] bArr, @Nullable SendMessageListener sendMessageListener) {
        Intrinsics.checkNotNullParameter(starryNetRingMsgConfig, "config");
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        IMessageTransport iMessageTransport = (IMessageTransport) getRemoteProxy();
        String sendRingMessage = iMessageTransport != null ? iMessageTransport.sendRingMessage(starryNetRingMsgConfig, str, bArr, sendMessageListener) : null;
        return sendRingMessage == null ? "-1" : sendRingMessage;
    }

    public void unregisterMessageReceiver(@NotNull MessageReceiver messageReceiver) {
        Intrinsics.checkNotNullParameter(messageReceiver, "receiver");
        this.coreMessageReceiver.removeListener(messageReceiver);
    }

    public void unregisterRingMessageReceiver(@NotNull RingMessageReceiver ringMessageReceiver) {
        Intrinsics.checkNotNullParameter(ringMessageReceiver, "receiver");
        this.coreRingMessageReceiver.removeListener(ringMessageReceiver);
    }
}
