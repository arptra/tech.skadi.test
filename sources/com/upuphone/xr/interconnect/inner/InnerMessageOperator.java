package com.upuphone.xr.interconnect.inner;

import com.upuphone.runasone.constant.Constants;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.StarryNetMessageOperator;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.entity.StarryNetRingMessage;
import com.upuphone.xr.interconnect.entity.StarryNetRingMsgConfig;
import com.upuphone.xr.interconnect.listener.MessageReceiver;
import com.upuphone.xr.interconnect.listener.RingMessageReceiver;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.interconnect.main.dispatcher.MessageDispatcher;
import com.upuphone.xr.interconnect.main.dispatcher.RingMessageDispatcher;
import com.upuphone.xr.interconnect.util.AlienCallExtKt;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\b\u0000\u0018\u0000 %2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001%B\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH@¢\u0006\u0002\u0010\u0010J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0011H@¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\tH\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bH\u0016J\u001a\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J,\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\tH\u0016J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bH\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/upuphone/xr/interconnect/inner/InnerMessageOperator;", "Lcom/upuphone/xr/interconnect/api/StarryNetMessageOperator;", "Lcom/upuphone/xr/interconnect/main/dispatcher/MessageDispatcher;", "Lcom/upuphone/xr/interconnect/main/dispatcher/RingMessageDispatcher;", "pkgName", "", "(Ljava/lang/String;)V", "mMessageReceiverList", "", "Lcom/upuphone/xr/interconnect/listener/MessageReceiver;", "mRingMessageReceiverList", "Lcom/upuphone/xr/interconnect/listener/RingMessageReceiver;", "dispatch", "", "message", "Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;", "(Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/upuphone/xr/interconnect/entity/StarryNetRingMessage;", "(Lcom/upuphone/xr/interconnect/entity/StarryNetRingMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doDispatch", "", "registerMessageReceiver", "receiver", "registerRingMessageReceiver", "sendMessage", "msg", "listener", "Lcom/upuphone/xr/interconnect/listener/SendMessageListener;", "sendMessage2", "sendRingMessage", "config", "Lcom/upuphone/xr/interconnect/entity/StarryNetRingMsgConfig;", "deviceId", "data", "", "unregisterMessageReceiver", "unregisterRingMessageReceiver", "Companion", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class InnerMessageOperator implements StarryNetMessageOperator, MessageDispatcher, RingMessageDispatcher {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "InnerMessageOperator";
    @NotNull
    private final List<MessageReceiver> mMessageReceiverList = new CopyOnWriteArrayList();
    @NotNull
    private final List<RingMessageReceiver> mRingMessageReceiverList = new CopyOnWriteArrayList();
    @Nullable
    private final String pkgName;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/interconnect/inner/InnerMessageOperator$Companion;", "", "()V", "TAG", "", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public InnerMessageOperator(@Nullable String str) {
        this.pkgName = str;
        InterconnectManager.getInstance().getMainDispatcher().addMessageDispatcher(this);
    }

    private final void doDispatch(StarryNetMessage starryNetMessage) {
        for (MessageReceiver threadSafeAlienCall : this.mMessageReceiverList) {
            AlienCallExtKt.threadSafeAlienCall(threadSafeAlienCall, TAG, new InnerMessageOperator$doDispatch$1(starryNetMessage));
        }
    }

    @Nullable
    public Object dispatch(@NotNull StarryNetMessage starryNetMessage, @NotNull Continuation<? super Boolean> continuation) {
        if (Intrinsics.areEqual((Object) starryNetMessage.getSenderPkg(), (Object) "System")) {
            doDispatch(starryNetMessage);
            return Boxing.boxBoolean(true);
        }
        if (!Intrinsics.areEqual((Object) this.pkgName, (Object) starryNetMessage.getReceiverPkg())) {
            return Boxing.boxBoolean(false);
        }
        if (this.mMessageReceiverList.isEmpty()) {
            return Boxing.boxBoolean(false);
        }
        String id = starryNetMessage.getId();
        String str = this.pkgName;
        int size = this.mMessageReceiverList.size();
        ILog.i(TAG, "分发消息id--" + id + "给内部模块--" + str + "，该模块已注册消息接收器个数--" + size);
        doDispatch(starryNetMessage);
        return Boxing.boxBoolean(true);
    }

    public void registerMessageReceiver(@NotNull MessageReceiver messageReceiver) {
        Intrinsics.checkNotNullParameter(messageReceiver, "receiver");
        String str = this.pkgName;
        ILog.i(TAG, "添加内部消息监听器，pkgName--" + str);
        this.mMessageReceiverList.add(messageReceiver);
    }

    public void registerRingMessageReceiver(@NotNull RingMessageReceiver ringMessageReceiver) {
        Intrinsics.checkNotNullParameter(ringMessageReceiver, "receiver");
        this.mRingMessageReceiverList.add(ringMessageReceiver);
    }

    public void sendMessage(@NotNull StarryNetMessage starryNetMessage, @Nullable SendMessageListener sendMessageListener) {
        Intrinsics.checkNotNullParameter(starryNetMessage, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        sendMessage2(starryNetMessage, sendMessageListener);
    }

    @NotNull
    public String sendMessage2(@NotNull StarryNetMessage starryNetMessage, @Nullable SendMessageListener sendMessageListener) {
        Intrinsics.checkNotNullParameter(starryNetMessage, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        starryNetMessage.setSenderPkg(this.pkgName);
        return String.valueOf(InterconnectManager.getInstance().getStarryNetMessenger().sendMessageRequireId(starryNetMessage, sendMessageListener));
    }

    @NotNull
    public String sendRingMessage(@NotNull StarryNetRingMsgConfig starryNetRingMsgConfig, @NotNull String str, @Nullable byte[] bArr, @Nullable SendMessageListener sendMessageListener) {
        Intrinsics.checkNotNullParameter(starryNetRingMsgConfig, "config");
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        return String.valueOf(InterconnectManager.getInstance().getStarryNetMessenger().sendRingMessage(starryNetRingMsgConfig, str, bArr, sendMessageListener));
    }

    public void unregisterMessageReceiver(@NotNull MessageReceiver messageReceiver) {
        Intrinsics.checkNotNullParameter(messageReceiver, "receiver");
        String str = this.pkgName;
        ILog.i(TAG, "移除内部消息监听器，pkgName--" + str);
        this.mMessageReceiverList.remove(messageReceiver);
    }

    public void unregisterRingMessageReceiver(@NotNull RingMessageReceiver ringMessageReceiver) {
        Intrinsics.checkNotNullParameter(ringMessageReceiver, "receiver");
        this.mRingMessageReceiverList.remove(ringMessageReceiver);
    }

    @Nullable
    public Object dispatch(@NotNull StarryNetRingMessage starryNetRingMessage, @NotNull Continuation<? super Boolean> continuation) {
        for (RingMessageReceiver threadSafeAlienCall : this.mRingMessageReceiverList) {
            AlienCallExtKt.threadSafeAlienCall(threadSafeAlienCall, TAG, new InnerMessageOperator$dispatch$3(starryNetRingMessage));
        }
        return Boxing.boxBoolean(true);
    }
}
