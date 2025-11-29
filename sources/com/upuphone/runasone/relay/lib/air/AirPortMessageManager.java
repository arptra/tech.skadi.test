package com.upuphone.runasone.relay.lib.air;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.google.gson.Gson;
import com.honey.account.g6.c;
import com.upuphone.runasone.ArrayData;
import com.upuphone.runasone.api.ApiConstant;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.host.core.api.AbilityMessage;
import com.upuphone.runasone.host.core.api.IAbilitySlot;
import com.upuphone.runasone.host.core.api.myconst.TlvCodeConst;
import com.upuphone.runasone.host.core.api.util.TlvBox;
import com.upuphone.runasone.relay.StarryParam;
import com.upuphone.runasone.relay.StarryTag;
import com.upuphone.runasone.relay.api.RelayCallback;
import com.upuphone.runasone.relay.api.SendRelayMessageCallBack;
import com.upuphone.runasone.relay.error.RelayErrorCode;
import com.upuphone.runasone.relay.lib.BuildConfig;
import com.upuphone.runasone.relay.lib.RelayPort;
import com.upuphone.runasone.relay.lib.air.AirPortDeviceManager;
import com.upuphone.runasone.relay.lib.device.AbilityBean;
import com.upuphone.runasone.relay.lib.manager.AppConfigManager;
import com.upuphone.runasone.relay.lib.myconst.OpenConst;
import com.upuphone.runasone.relay.lib.utils.LogUtil;
import com.upuphone.runasone.relay.lib.utils.UtilUse;
import com.upuphone.starrynet.payload.PayloadConstant;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0004\u0018\u0000 42\u00020\u0001:\u0003345B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004J\u001a\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011J*\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\"\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J \u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J2\u0010!\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010$\u001a\u0004\u0018\u00010%J\u001e\u0010&\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020#J\u0016\u0010)\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010'\u001a\u00020#J\u0016\u0010*\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010(\u001a\u00020#J\u000e\u0010+\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014J4\u0010,\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0010\u001a\u0004\u0018\u00010\u001e2\u0006\u0010-\u001a\u00020#2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\"\u0010.\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0018\u0010/\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\"\u00100\u001a\u00020\f2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001c022\u0006\u0010-\u001a\u00020#R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u00066"}, d2 = {"Lcom/upuphone/runasone/relay/lib/air/AirPortMessageManager;", "", "()V", "context", "Landroid/content/Context;", "timeOut", "Lcom/upuphone/runasone/relay/lib/air/AirPortMessageManager$TimeOutHandler;", "getTimeOut", "()Lcom/upuphone/runasone/relay/lib/air/AirPortMessageManager$TimeOutHandler;", "timeOut$delegate", "Lkotlin/Lazy;", "initCtx", "", "input", "device", "Lcom/upuphone/runasone/device/StarryDevice;", "message", "Lcom/upuphone/runasone/host/core/api/AbilityMessage;", "onReceiveMessage", "starryTag", "Lcom/upuphone/runasone/relay/StarryTag;", "tlvBox", "Lcom/upuphone/runasone/host/core/api/util/TlvBox;", "param", "Lcom/upuphone/runasone/relay/StarryParam;", "openActOrService", "openActivityWithParams", "host", "", "msg", "", "openApplication", "ctx", "sendMessage", "qos", "", "callback", "Lcom/upuphone/runasone/relay/api/SendRelayMessageCallBack;", "sendMessageFailed", "msgId", "errorCode", "sendMessageSuccess", "sendRemoteFailed", "sendRemoteSuccess", "startRemote", "type", "startService", "stopRemote", "updateAbility", "keyMap", "", "AirCallBackData", "Companion", "TimeOutHandler", "relay-lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AirPortMessageManager {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Lazy<AirPortMessageManager> SIntance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, AirPortMessageManager$Companion$SIntance$2.INSTANCE);
    /* access modifiers changed from: private */
    public static final String TAG = AirPortMessageManager.class.getSimpleName();
    @Nullable
    private Context context;
    @NotNull
    private final Lazy timeOut$delegate = LazyKt.lazy(AirPortMessageManager$timeOut$2.INSTANCE);

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/upuphone/runasone/relay/lib/air/AirPortMessageManager$AirCallBackData;", "", "starryTag", "Lcom/upuphone/runasone/relay/StarryTag;", "uniqueKey", "", "(Lcom/upuphone/runasone/relay/StarryTag;Ljava/lang/Integer;)V", "isUsing", "", "()Z", "setUsing", "(Z)V", "getStarryTag", "()Lcom/upuphone/runasone/relay/StarryTag;", "setStarryTag", "(Lcom/upuphone/runasone/relay/StarryTag;)V", "getUniqueKey", "()Ljava/lang/Integer;", "setUniqueKey", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "relay-lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AirCallBackData {
        private boolean isUsing;
        @Nullable
        private StarryTag starryTag;
        @Nullable
        private Integer uniqueKey;

        public AirCallBackData(@Nullable StarryTag starryTag2, @Nullable Integer num) {
            this.starryTag = starryTag2;
            this.uniqueKey = num;
        }

        @Nullable
        public final StarryTag getStarryTag() {
            return this.starryTag;
        }

        @Nullable
        public final Integer getUniqueKey() {
            return this.uniqueKey;
        }

        public final boolean isUsing() {
            return this.isUsing;
        }

        public final void setStarryTag(@Nullable StarryTag starryTag2) {
            this.starryTag = starryTag2;
        }

        public final void setUniqueKey(@Nullable Integer num) {
            this.uniqueKey = num;
        }

        public final void setUsing(boolean z) {
            this.isUsing = z;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/upuphone/runasone/relay/lib/air/AirPortMessageManager$Companion;", "", "()V", "SIntance", "Lcom/upuphone/runasone/relay/lib/air/AirPortMessageManager;", "getSIntance", "()Lcom/upuphone/runasone/relay/lib/air/AirPortMessageManager;", "SIntance$delegate", "Lkotlin/Lazy;", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "relay-lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AirPortMessageManager getSIntance() {
            return (AirPortMessageManager) AirPortMessageManager.SIntance$delegate.getValue();
        }

        public final String getTAG() {
            return AirPortMessageManager.TAG;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J#\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0005H\u0002J/\u0010\u001e\u001a\u00020\u001c2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!¢\u0006\u0002\u0010\"J\u0016\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020!2\u0006\u0010\u0019\u001a\u00020\u0007J \u0010%\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\u0007J'\u0010)\u001a\u00020\u001c2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00072\u0006\u0010*\u001a\u00020!¢\u0006\u0002\u0010+R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\nj\b\u0012\u0004\u0012\u00020\u0007`\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0001X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015XD¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/upuphone/runasone/relay/lib/air/AirPortMessageManager$TimeOutHandler;", "", "()V", "list", "Ljava/util/LinkedList;", "Lcom/upuphone/runasone/relay/lib/air/AirPortMessageManager$AirCallBackData;", "maxPool", "", "messageTimeOut", "msgSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "obj", "remoteTimeOut", "sendFailedCallback", "sendSuccessCallback", "thread", "Landroid/os/HandlerThread;", "threadHandler", "Landroid/os/Handler;", "timeOut", "", "obtain", "starryTag", "Lcom/upuphone/runasone/relay/StarryTag;", "uniqueKey", "(Lcom/upuphone/runasone/relay/StarryTag;Ljava/lang/Integer;)Lcom/upuphone/runasone/relay/lib/air/AirPortMessageManager$AirCallBackData;", "recycleData", "", "data", "sendFailedCallBack", "errorCode", "needCallBack", "", "(Lcom/upuphone/runasone/relay/StarryTag;Ljava/lang/Integer;IZ)V", "sendRemoveMessage", "send", "sendRemoveRemote", "devAuc", "", "listenerId", "sendSuccessCallBack", "needCallback", "(Lcom/upuphone/runasone/relay/StarryTag;Ljava/lang/Integer;Z)V", "relay-lib_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class TimeOutHandler {
        @NotNull
        private final LinkedList<AirCallBackData> list = new LinkedList<>();
        private final int maxPool = 25;
        private final int messageTimeOut;
        @NotNull
        private HashSet<Integer> msgSet;
        @NotNull
        private Object obj = new Object();
        private final int remoteTimeOut;
        private final int sendFailedCallback;
        private final int sendSuccessCallback;
        @NotNull
        private final HandlerThread thread;
        @NotNull
        private final Handler threadHandler;
        private final long timeOut;

        public TimeOutHandler() {
            HandlerThread handlerThread = new HandlerThread("sendCallbackMsg");
            this.thread = handlerThread;
            this.msgSet = new HashSet<>();
            this.messageTimeOut = 1;
            this.remoteTimeOut = 2;
            this.sendSuccessCallback = 4;
            this.sendFailedCallback = 5;
            this.timeOut = 10000;
            handlerThread.start();
            this.threadHandler = new Handler(handlerThread.getLooper(), new c(this));
        }

        /* access modifiers changed from: private */
        /* renamed from: _init_$lambda-0  reason: not valid java name */
        public static final boolean m1678_init_$lambda0(TimeOutHandler timeOutHandler, Message message) {
            Object obj2;
            StarryParam starryParam;
            Intrinsics.checkNotNullParameter(timeOutHandler, "this$0");
            Intrinsics.checkNotNullParameter(message, "it");
            int i = message.what;
            if (i == timeOutHandler.remoteTimeOut) {
                if (message.obj != null) {
                    if (message.arg1 == 0) {
                        starryParam = new StarryParam();
                        starryParam.setListenerId(message.arg1);
                    } else {
                        starryParam = null;
                    }
                    AirPortDeviceManager sIntance = AirPortDeviceManager.Companion.getSIntance();
                    Object obj3 = message.obj;
                    if (obj3 != null) {
                        sIntance.callRemoteListener((String) obj3, RelayErrorCode.START_REMOTE_TIMEOUT, false, starryParam);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                }
            } else if (i == timeOutHandler.messageTimeOut) {
                Object obj4 = message.obj;
                if (obj4 != null) {
                    HashSet<Integer> hashSet = timeOutHandler.msgSet;
                    if (obj4 != null) {
                        hashSet.remove((Integer) obj4);
                        AirPortDeviceManager sIntance2 = AirPortDeviceManager.Companion.getSIntance();
                        Object obj5 = message.obj;
                        if (obj5 != null) {
                            sIntance2.callSendMessageListener(((Integer) obj5).intValue(), RelayErrorCode.SEND_MESSAGE_TIMEOUT, false);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                }
            } else if (i == timeOutHandler.sendSuccessCallback) {
                Object obj6 = message.obj;
                if (obj6 != null) {
                    if (obj6 != null) {
                        AirCallBackData airCallBackData = (AirCallBackData) obj6;
                        AirPortMessageManager sIntance3 = AirPortMessageManager.Companion.getSIntance();
                        StarryTag starryTag = airCallBackData.getStarryTag();
                        Intrinsics.checkNotNull(starryTag);
                        Integer uniqueKey = airCallBackData.getUniqueKey();
                        Intrinsics.checkNotNull(uniqueKey);
                        sIntance3.sendMessageSuccess(starryTag, uniqueKey.intValue());
                        timeOutHandler.recycleData(airCallBackData);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.upuphone.runasone.relay.lib.air.AirPortMessageManager.AirCallBackData");
                    }
                }
            } else if (i == timeOutHandler.sendFailedCallback && (obj2 = message.obj) != null) {
                if (obj2 != null) {
                    AirCallBackData airCallBackData2 = (AirCallBackData) obj2;
                    AirPortMessageManager sIntance4 = AirPortMessageManager.Companion.getSIntance();
                    StarryTag starryTag2 = airCallBackData2.getStarryTag();
                    Intrinsics.checkNotNull(starryTag2);
                    Integer uniqueKey2 = airCallBackData2.getUniqueKey();
                    Intrinsics.checkNotNull(uniqueKey2);
                    sIntance4.sendMessageFailed(starryTag2, uniqueKey2.intValue(), message.arg1);
                    timeOutHandler.recycleData(airCallBackData2);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.upuphone.runasone.relay.lib.air.AirPortMessageManager.AirCallBackData");
                }
            }
            return false;
        }

        private final AirCallBackData obtain(StarryTag starryTag, Integer num) {
            AirCallBackData poll;
            synchronized (this.obj) {
                poll = this.list.poll();
                Unit unit = Unit.INSTANCE;
            }
            if (poll != null) {
                AirCallBackData airCallBackData = poll;
                if (!airCallBackData.isUsing()) {
                    airCallBackData.setStarryTag(starryTag);
                    airCallBackData.setUniqueKey(num);
                    airCallBackData.setUsing(true);
                    return airCallBackData;
                }
            }
            AirCallBackData airCallBackData2 = new AirCallBackData(starryTag, num);
            airCallBackData2.setUsing(true);
            return airCallBackData2;
        }

        private final void recycleData(AirCallBackData airCallBackData) {
            airCallBackData.setUniqueKey((Integer) null);
            airCallBackData.setStarryTag((StarryTag) null);
            airCallBackData.setUsing(false);
            synchronized (this.obj) {
                try {
                    if (this.list.size() < this.maxPool) {
                        this.list.addLast(airCallBackData);
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void sendFailedCallBack(@Nullable StarryTag starryTag, @Nullable Integer num, int i, boolean z) {
            if (z) {
                Message obtain = Message.obtain(this.threadHandler, this.sendFailedCallback);
                obtain.obj = obtain(starryTag, num);
                obtain.arg1 = i;
                this.threadHandler.sendMessage(obtain);
            }
        }

        public final void sendRemoveMessage(boolean z, int i) {
            if (z) {
                this.msgSet.add(Integer.valueOf(i));
                String tag = AirPortMessageManager.Companion.getTAG();
                LogUtil.dPrimary(tag, "----sendHandler  uniqueKey= " + i);
                this.threadHandler.sendMessageDelayed(Message.obtain(this.threadHandler, this.messageTimeOut, Integer.valueOf(i)), this.timeOut);
                return;
            }
            String tag2 = AirPortMessageManager.Companion.getTAG();
            LogUtil.dPrimary(tag2, "----removeHandler  uniqueKey= " + i);
            if (this.msgSet.contains(Integer.valueOf(i))) {
                this.msgSet.remove(Integer.valueOf(i));
                this.threadHandler.removeMessages(this.messageTimeOut, Integer.valueOf(i));
            }
        }

        public final void sendRemoveRemote(boolean z, @Nullable String str, int i) {
            if (z) {
                Message obtain = Message.obtain(this.threadHandler, this.remoteTimeOut, str);
                obtain.arg1 = i;
                this.threadHandler.sendMessageDelayed(obtain, this.timeOut);
                return;
            }
            this.threadHandler.removeMessages(this.remoteTimeOut);
        }

        public final void sendSuccessCallBack(@Nullable StarryTag starryTag, @Nullable Integer num, boolean z) {
            if (z) {
                Message obtain = Message.obtain(this.threadHandler, this.sendSuccessCallback);
                obtain.obj = obtain(starryTag, num);
                this.threadHandler.sendMessage(obtain);
            }
        }
    }

    private final void onReceiveMessage(StarryDevice starryDevice, StarryTag starryTag, TlvBox tlvBox, StarryParam starryParam) {
        Integer integer = tlvBox.getInteger(Byte.valueOf(TlvCodeConst.msgId));
        Boolean bool = tlvBox.getBoolean(Byte.valueOf(TlvCodeConst.needCallback));
        byte[] bytes = tlvBox.getBytes(Byte.valueOf(TlvCodeConst.msgBody));
        String sendAppUniteCode = starryTag.getSendAppUniteCode();
        String str = TAG;
        LogUtil.dPrimary(str, "------run-R-msg    deviceId=" + starryDevice.getId() + "  msgId=" + integer + "   needCallback=" + bool + "  appUniteCode=" + sendAppUniteCode + "   msgSize=" + bytes.length);
        AirPortDeviceManager sIntance = AirPortDeviceManager.Companion.getSIntance();
        Intrinsics.checkNotNullExpressionValue(sendAppUniteCode, "appUniteCode");
        RelayCallback relayCallback = sIntance.getRelayCallback(sendAppUniteCode);
        if (!BuildConfig.IS_THIRD.booleanValue()) {
            if (!AppConfigManager.getInstance().hasAppUniteCode(sendAppUniteCode)) {
                LogUtil.dPrimary(str, "------APP_NOT_INSTALL203007   needCallback=" + bool);
                TimeOutHandler timeOut = getTimeOut();
                Intrinsics.checkNotNullExpressionValue(bool, "needCallback");
                timeOut.sendFailedCallBack(starryTag, integer, RelayErrorCode.APP_NOT_INSTALL, bool.booleanValue());
                return;
            } else if (!RelayPort.getInstance().isBinderExit(sendAppUniteCode)) {
                LogUtil.dPrimary(str, "------BINDER_ERROR203010   needCallback=" + bool);
                TimeOutHandler timeOut2 = getTimeOut();
                Intrinsics.checkNotNullExpressionValue(bool, "needCallback");
                timeOut2.sendFailedCallBack(starryTag, integer, RelayErrorCode.BINDER_ERROR, bool.booleanValue());
                return;
            }
        }
        if (relayCallback == null) {
            LogUtil.dPrimary(str, "------UN_INIT203001   needCallback=" + bool);
            TimeOutHandler timeOut3 = getTimeOut();
            Intrinsics.checkNotNullExpressionValue(bool, "needCallback");
            timeOut3.sendFailedCallBack(starryTag, integer, RelayErrorCode.UN_INIT, bool.booleanValue());
            return;
        }
        relayCallback.onReceiveMessage(starryTag, new ArrayData(bytes), starryParam);
        TimeOutHandler timeOut4 = getTimeOut();
        Intrinsics.checkNotNullExpressionValue(bool, "needCallback");
        timeOut4.sendSuccessCallBack(starryTag, integer, bool.booleanValue());
    }

    private final void openActOrService(StarryTag starryTag, TlvBox tlvBox) {
        String string = tlvBox.getString(Byte.valueOf(TlvCodeConst.host));
        byte[] bytes = tlvBox.getBytes(Byte.valueOf(TlvCodeConst.msgBody));
        String str = TAG;
        LogUtil.dPrimary(str, "openActOrService   deviceId=" + starryTag.getDeviceId() + "  host=" + string);
        Byte b = tlvBox.getByte(Byte.valueOf(TlvCodeConst.openType));
        if (b == null || b.byteValue() != TlvCodeConst.openTypeService) {
            Intrinsics.checkNotNullExpressionValue(string, ApiConstant.VALUE_HOST);
            openActivityWithParams(starryTag, string, bytes);
            return;
        }
        Intrinsics.checkNotNullExpressionValue(string, ApiConstant.VALUE_HOST);
        startService(starryTag, string, bytes);
    }

    private final void openActivityWithParams(StarryTag starryTag, String str, byte[] bArr) {
        if (AppConfigManager.getInstance().getPackageName(starryTag.getSendAppUniteCode()) == null) {
            sendRemoteFailed(starryTag, RelayErrorCode.APP_NOT_INSTALL);
            return;
        }
        String str2 = TAG;
        LogUtil.dPrimary(str2, "------openActivity:" + str + "   Send=" + starryTag.getSendAppUniteCode());
        try {
            UtilUse.openActivityWithParams(this.context, str, OpenConst.ACTIVITY_ACTION, bArr);
            if (RelayPort.getInstance().isBinderExit(starryTag.getSendAppUniteCode())) {
                sendRemoteSuccess(starryTag);
            }
        } catch (Exception e) {
            e.printStackTrace();
            sendRemoteFailed(starryTag, RelayErrorCode.NOT_FOUND_ACTIVITY);
        }
    }

    private final void openApplication(Context context2, StarryTag starryTag, byte[] bArr) {
        String str = TAG;
        LogUtil.dPrimary(str, "------openApplication:   Send=" + starryTag.getSendAppUniteCode());
        if (RelayPort.getInstance().isBinderExit(starryTag.getSendAppUniteCode())) {
            sendRemoteSuccess(starryTag);
            return;
        }
        String packageName = AppConfigManager.getInstance().getPackageName(starryTag.getSendAppUniteCode());
        if (packageName == null) {
            sendRemoteFailed(starryTag, RelayErrorCode.APP_NOT_INSTALL);
            return;
        }
        try {
            UtilUse.openApplication(context2, packageName, bArr);
            sendRemoteSuccess(starryTag);
        } catch (Exception e) {
            sendRemoteFailed(starryTag, RelayErrorCode.NOT_FOUND_ACTIVITY);
            e.printStackTrace();
        }
    }

    private final void startService(StarryTag starryTag, String str, byte[] bArr) {
        String packageName = AppConfigManager.getInstance().getPackageName(starryTag.getReceiveAppUniteCode());
        if (packageName == null) {
            sendRemoteFailed(starryTag, RelayErrorCode.APP_NOT_INSTALL);
            return;
        }
        String str2 = TAG;
        LogUtil.dPrimary(str2, "------openService:" + str + "   Send=" + starryTag.getSendAppUniteCode());
        try {
            UtilUse.startService(this.context, packageName, str, OpenConst.ACTION_OPEN, bArr);
            if (RelayPort.getInstance().isBinderExit(starryTag.getReceiveAppUniteCode())) {
                sendRemoteSuccess(starryTag);
            }
        } catch (Exception unused) {
            sendRemoteFailed(starryTag, RelayErrorCode.NOT_FOUND_SERVICE);
        }
    }

    @NotNull
    public final TimeOutHandler getTimeOut() {
        return (TimeOutHandler) this.timeOut$delegate.getValue();
    }

    public final void initCtx(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final void input(@NotNull StarryDevice starryDevice, @NotNull AbilityMessage<?> abilityMessage) {
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        Intrinsics.checkNotNullParameter(abilityMessage, "message");
        TlvBox tlvBox = new TlvBox(abilityMessage.getBypass());
        Byte b = tlvBox.getByte(Byte.valueOf(TlvCodeConst.msgType));
        if (b != null) {
            Byte b2 = tlvBox.getByte(Byte.valueOf(TlvCodeConst.appUniteCode));
            if (b2 == null) {
                b2 = (byte) -1;
            }
            AirPortDeviceManager.Companion companion = AirPortDeviceManager.Companion;
            AirPortDeviceManager sIntance = companion.getSIntance();
            String id = starryDevice.getId();
            Intrinsics.checkNotNullExpressionValue(id, "device.id");
            String mappingString = sIntance.getMappingString(id, b2.byteValue());
            if (mappingString == null) {
                mappingString = "null";
            }
            StarryTag starryTag = new StarryTag(starryDevice.getId(), mappingString, "");
            String devAuc = UtilUse.getDevAuc(starryTag);
            Integer integer = tlvBox.getInteger(Byte.valueOf(TlvCodeConst.listenerId));
            Integer integer2 = tlvBox.getInteger(Byte.valueOf(TlvCodeConst.msgId));
            StarryParam starryParam = new StarryParam();
            starryParam.setListenerId(0);
            if (integer != null) {
                Intrinsics.checkNotNullExpressionValue(integer, "listenId");
                starryParam.setListenerId(integer.intValue());
            }
            byte byteValue = b.byteValue();
            if (byteValue == TlvCodeConst.open) {
                Context context2 = this.context;
                Intrinsics.checkNotNull(context2);
                byte[] bytes = tlvBox.getBytes(Byte.valueOf(TlvCodeConst.msgBody));
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(TlvCodeConst.msgBody)");
                openApplication(context2, starryTag, bytes);
            } else if (byteValue == TlvCodeConst.close) {
                companion.getSIntance().callRemoteListener(devAuc, 0, true, starryParam);
            } else if (byteValue == TlvCodeConst.sendMsg) {
                onReceiveMessage(starryDevice, starryTag, tlvBox, starryParam);
            } else if (byteValue == TlvCodeConst.sendMsgSuccess) {
                AirPortDeviceManager sIntance2 = companion.getSIntance();
                Intrinsics.checkNotNullExpressionValue(integer2, "msgId");
                sIntance2.callSendMessageListener(integer2.intValue(), -1, true);
            } else if (byteValue == TlvCodeConst.sendMsgFail) {
                Integer integer3 = tlvBox.getInteger(Byte.valueOf(TlvCodeConst.errorCode));
                AirPortDeviceManager sIntance3 = companion.getSIntance();
                Intrinsics.checkNotNullExpressionValue(integer2, "msgId");
                int intValue = integer2.intValue();
                Intrinsics.checkNotNullExpressionValue(integer3, "errorCode");
                sIntance3.callSendMessageListener(intValue, integer3.intValue(), true);
            } else if (byteValue == TlvCodeConst.openSuccess) {
                String str = TAG;
                LogUtil.dPrimary(str, "------REMOTE_SUCCESS" + devAuc);
                companion.getSIntance().callRemoteListener(devAuc, -1, true, starryParam);
            } else if (byteValue == TlvCodeConst.openFail) {
                Integer integer4 = tlvBox.getInteger(Byte.valueOf(TlvCodeConst.errorCode));
                String str2 = TAG;
                LogUtil.dPrimary(str2, "------REMOTE_FAILED:" + integer4 + "  devAuc= " + devAuc);
                AirPortDeviceManager sIntance4 = companion.getSIntance();
                Intrinsics.checkNotNullExpressionValue(integer4, "errorCode");
                sIntance4.callRemoteListener(devAuc, integer4.intValue(), true, starryParam);
            } else if (byteValue == TlvCodeConst.openPage) {
                openActOrService(starryTag, tlvBox);
            }
        }
    }

    public final void sendMessage(@NotNull StarryTag starryTag, @NotNull byte[] bArr, int i, @Nullable StarryParam starryParam, @Nullable SendRelayMessageCallBack sendRelayMessageCallBack) {
        Intrinsics.checkNotNullParameter(starryTag, "starryTag");
        Intrinsics.checkNotNullParameter(bArr, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        int uniqueKeyAir = UtilUse.getUniqueKeyAir();
        String sendAppUniteCode = starryTag.getSendAppUniteCode();
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("------sendMessage  DeviceId=");
        sb.append(starryTag.getDeviceId());
        sb.append("   msgId=");
        sb.append(uniqueKeyAir);
        sb.append("  param=");
        sb.append(starryParam != null ? Integer.valueOf(starryParam.getListenerId()) : null);
        sb.append(" SendAppUniteCode=");
        sb.append(sendAppUniteCode);
        LogUtil.dPrimary(str, sb.toString());
        AirPortDeviceManager.Companion companion = AirPortDeviceManager.Companion;
        AirPortDeviceManager sIntance = companion.getSIntance();
        String deviceId = starryTag.getDeviceId();
        Intrinsics.checkNotNullExpressionValue(deviceId, "starryTag.deviceId");
        String sendAppUniteCode2 = starryTag.getSendAppUniteCode();
        Intrinsics.checkNotNullExpressionValue(sendAppUniteCode2, "starryTag.sendAppUniteCode");
        Integer mappingCode = sIntance.getMappingCode(deviceId, sendAppUniteCode2);
        TlvBox create = TlvBox.create();
        create.put(Byte.valueOf(TlvCodeConst.msgType), TlvCodeConst.sendMsg);
        create.put(Byte.valueOf(TlvCodeConst.msgId), uniqueKeyAir);
        create.put(Byte.valueOf(TlvCodeConst.needCallback), sendRelayMessageCallBack != null);
        create.put(Byte.valueOf(TlvCodeConst.msgBody), bArr);
        if (starryParam != null) {
            create.put(Byte.valueOf(TlvCodeConst.listenerId), starryParam.getListenerId());
        }
        if (mappingCode != null) {
            create.put(Byte.valueOf(TlvCodeConst.appUniteCode), (byte) mappingCode.intValue());
        }
        AbilityMessage.Qos qos = i != 1 ? i != 2 ? i != 3 ? AbilityMessage.Qos.AM_QOS_0 : AbilityMessage.Qos.AM_QOS_3 : AbilityMessage.Qos.AM_QOS_2 : AbilityMessage.Qos.AM_QOS_1;
        AirPortDeviceManager sIntance2 = companion.getSIntance();
        String deviceId2 = starryTag.getDeviceId();
        Intrinsics.checkNotNullExpressionValue(deviceId2, "starryTag.deviceId");
        AbilityBean device = sIntance2.getDevice(deviceId2);
        if (device != null) {
            IAbilitySlot.SlotObserver observer = device.getObserver();
            if (observer != null) {
                observer.output(device.getDevice(), new AbilityMessage(create.serialize(), AbilityMessage.MessageType.AIR, qos));
            }
            if (sendRelayMessageCallBack != null) {
                companion.getSIntance().addSendMessageListener(uniqueKeyAir, sendRelayMessageCallBack);
            }
            if (sendRelayMessageCallBack != null) {
                getTimeOut().sendRemoveMessage(true, uniqueKeyAir);
            }
        }
    }

    public final void sendMessageFailed(@NotNull StarryTag starryTag, int i, int i2) {
        IAbilitySlot.SlotObserver observer;
        Intrinsics.checkNotNullParameter(starryTag, "starryTag");
        String str = TAG;
        LogUtil.dPrimary(str, "------sendMessage  DeviceId=" + starryTag.getDeviceId() + "  msgId=" + i + "    SendAppUniteCode=" + starryTag.getSendAppUniteCode() + "  errorCode=" + i2);
        TlvBox create = TlvBox.create();
        create.put(Byte.valueOf(TlvCodeConst.msgType), TlvCodeConst.sendMsgFail);
        create.put(Byte.valueOf(TlvCodeConst.msgId), i);
        create.put(Byte.valueOf(TlvCodeConst.errorCode), i2);
        AirPortDeviceManager sIntance = AirPortDeviceManager.Companion.getSIntance();
        String deviceId = starryTag.getDeviceId();
        Intrinsics.checkNotNullExpressionValue(deviceId, "starryTag.deviceId");
        AbilityBean device = sIntance.getDevice(deviceId);
        if (device != null && (observer = device.getObserver()) != null) {
            observer.output(device.getDevice(), new AbilityMessage(create.serialize(), AbilityMessage.MessageType.AIR));
        }
    }

    public final void sendMessageSuccess(@NotNull StarryTag starryTag, int i) {
        IAbilitySlot.SlotObserver observer;
        Intrinsics.checkNotNullParameter(starryTag, "starryTag");
        String str = TAG;
        LogUtil.dPrimary(str, "------sendMessage  DeviceId=" + starryTag.getDeviceId() + "   msgId=" + i + "  SendAppUniteCode=" + starryTag.getSendAppUniteCode());
        TlvBox create = TlvBox.create();
        create.put(Byte.valueOf(TlvCodeConst.msgType), TlvCodeConst.sendMsgSuccess);
        create.put(Byte.valueOf(TlvCodeConst.msgId), i);
        AirPortDeviceManager sIntance = AirPortDeviceManager.Companion.getSIntance();
        String deviceId = starryTag.getDeviceId();
        Intrinsics.checkNotNullExpressionValue(deviceId, "starryTag.deviceId");
        AbilityBean device = sIntance.getDevice(deviceId);
        if (device != null && (observer = device.getObserver()) != null) {
            observer.output(device.getDevice(), new AbilityMessage(create.serialize(), AbilityMessage.MessageType.AIR));
        }
    }

    public final void sendRemoteFailed(@NotNull StarryTag starryTag, int i) {
        IAbilitySlot.SlotObserver observer;
        Intrinsics.checkNotNullParameter(starryTag, "starryTag");
        String str = TAG;
        LogUtil.dPrimary(str, "------sendRemoteFailed  DeviceId=" + starryTag.getDeviceId() + "  SendAppUniteCode=" + starryTag.getSendAppUniteCode() + "  errorCode=" + i);
        AirPortDeviceManager.Companion companion = AirPortDeviceManager.Companion;
        AirPortDeviceManager sIntance = companion.getSIntance();
        String deviceId = starryTag.getDeviceId();
        Intrinsics.checkNotNullExpressionValue(deviceId, "starryTag.deviceId");
        String sendAppUniteCode = starryTag.getSendAppUniteCode();
        Intrinsics.checkNotNullExpressionValue(sendAppUniteCode, "starryTag.sendAppUniteCode");
        Integer mappingCode = sIntance.getMappingCode(deviceId, sendAppUniteCode);
        TlvBox create = TlvBox.create();
        create.put(Byte.valueOf(TlvCodeConst.msgType), TlvCodeConst.openFail);
        create.put(Byte.valueOf(TlvCodeConst.errorCode), i);
        if (mappingCode != null) {
            create.put(Byte.valueOf(TlvCodeConst.appUniteCode), (byte) mappingCode.intValue());
        }
        AirPortDeviceManager sIntance2 = companion.getSIntance();
        String deviceId2 = starryTag.getDeviceId();
        Intrinsics.checkNotNullExpressionValue(deviceId2, "starryTag.deviceId");
        AbilityBean device = sIntance2.getDevice(deviceId2);
        if (device != null && (observer = device.getObserver()) != null) {
            observer.output(device.getDevice(), new AbilityMessage(create.serialize(), AbilityMessage.MessageType.AIR));
        }
    }

    public final void sendRemoteSuccess(@NotNull StarryTag starryTag) {
        IAbilitySlot.SlotObserver observer;
        Intrinsics.checkNotNullParameter(starryTag, "starryTag");
        String str = TAG;
        LogUtil.dPrimary(str, "------sendRemoteSuccess  DeviceId=" + starryTag.getDeviceId() + "  SendAppUniteCode=" + starryTag.getSendAppUniteCode() + ' ');
        AirPortDeviceManager.Companion companion = AirPortDeviceManager.Companion;
        AirPortDeviceManager sIntance = companion.getSIntance();
        String deviceId = starryTag.getDeviceId();
        Intrinsics.checkNotNullExpressionValue(deviceId, "starryTag.deviceId");
        String sendAppUniteCode = starryTag.getSendAppUniteCode();
        Intrinsics.checkNotNullExpressionValue(sendAppUniteCode, "starryTag.sendAppUniteCode");
        Integer mappingCode = sIntance.getMappingCode(deviceId, sendAppUniteCode);
        TlvBox create = TlvBox.create();
        create.put(Byte.valueOf(TlvCodeConst.msgType), TlvCodeConst.openSuccess);
        if (mappingCode != null) {
            create.put(Byte.valueOf(TlvCodeConst.appUniteCode), (byte) mappingCode.intValue());
        }
        AirPortDeviceManager sIntance2 = companion.getSIntance();
        String deviceId2 = starryTag.getDeviceId();
        Intrinsics.checkNotNullExpressionValue(deviceId2, "starryTag.deviceId");
        AbilityBean device = sIntance2.getDevice(deviceId2);
        if (device != null && (observer = device.getObserver()) != null) {
            observer.output(device.getDevice(), new AbilityMessage(create.serialize(), AbilityMessage.MessageType.AIR));
        }
    }

    public final void startRemote(@NotNull StarryTag starryTag, @Nullable String str, @Nullable byte[] bArr, int i, @Nullable StarryParam starryParam) {
        Intrinsics.checkNotNullParameter(starryTag, "starryTag");
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("------sendRemoteSuccess  DeviceId=");
        sb.append(starryTag.getDeviceId());
        sb.append("    host=");
        sb.append(str);
        sb.append("   type=");
        sb.append(i);
        sb.append("  param=");
        sb.append(starryParam != null ? Integer.valueOf(starryParam.getListenerId()) : null);
        sb.append("SendAppUniteCode=");
        sb.append(starryTag.getSendAppUniteCode());
        sb.append(' ');
        LogUtil.dPrimary(str2, sb.toString());
        AirPortDeviceManager.Companion companion = AirPortDeviceManager.Companion;
        AirPortDeviceManager sIntance = companion.getSIntance();
        String deviceId = starryTag.getDeviceId();
        Intrinsics.checkNotNullExpressionValue(deviceId, "starryTag.deviceId");
        String sendAppUniteCode = starryTag.getSendAppUniteCode();
        Intrinsics.checkNotNullExpressionValue(sendAppUniteCode, "starryTag.sendAppUniteCode");
        Integer mappingCode = sIntance.getMappingCode(deviceId, sendAppUniteCode);
        TlvBox create = TlvBox.create();
        if (str != null) {
            create.put(Byte.valueOf(TlvCodeConst.msgType), TlvCodeConst.openPage);
        } else {
            create.put(Byte.valueOf(TlvCodeConst.msgType), TlvCodeConst.open);
        }
        create.put(Byte.valueOf(TlvCodeConst.openType), (byte) i);
        if (mappingCode != null) {
            create.put(Byte.valueOf(TlvCodeConst.appUniteCode), (byte) mappingCode.intValue());
        }
        if (bArr != null) {
            create.put(Byte.valueOf(TlvCodeConst.msgBody), bArr);
        }
        if (str != null) {
            create.put(Byte.valueOf(TlvCodeConst.host), str);
        }
        if (starryParam != null) {
            create.put(Byte.valueOf(TlvCodeConst.listenerId), starryParam.getListenerId());
        }
        AirPortDeviceManager sIntance2 = companion.getSIntance();
        String deviceId2 = starryTag.getDeviceId();
        Intrinsics.checkNotNullExpressionValue(deviceId2, "starryTag.deviceId");
        AbilityBean device = sIntance2.getDevice(deviceId2);
        if (device != null) {
            IAbilitySlot.SlotObserver observer = device.getObserver();
            if (observer != null) {
                observer.output(device.getDevice(), new AbilityMessage(create.serialize(), AbilityMessage.MessageType.AIR));
            }
            getTimeOut().sendRemoveRemote(true, UtilUse.getDevAuc(starryTag), starryParam != null ? starryParam.getListenerId() : 0);
        }
    }

    public final void stopRemote(@NotNull StarryTag starryTag, @Nullable StarryParam starryParam) {
        IAbilitySlot.SlotObserver observer;
        Intrinsics.checkNotNullParameter(starryTag, "starryTag");
        String str = TAG;
        LogUtil.dPrimary(str, "------sendRemoteSuccess  DeviceId=" + starryTag.getDeviceId() + "  SendAppUniteCode=" + starryTag.getSendAppUniteCode() + ' ');
        AirPortDeviceManager.Companion companion = AirPortDeviceManager.Companion;
        AirPortDeviceManager sIntance = companion.getSIntance();
        String deviceId = starryTag.getDeviceId();
        Intrinsics.checkNotNullExpressionValue(deviceId, "starryTag.deviceId");
        String sendAppUniteCode = starryTag.getSendAppUniteCode();
        Intrinsics.checkNotNullExpressionValue(sendAppUniteCode, "starryTag.sendAppUniteCode");
        Integer mappingCode = sIntance.getMappingCode(deviceId, sendAppUniteCode);
        TlvBox create = TlvBox.create();
        create.put(Byte.valueOf(TlvCodeConst.msgType), TlvCodeConst.close);
        if (mappingCode != null) {
            create.put(Byte.valueOf(TlvCodeConst.appUniteCode), (byte) mappingCode.intValue());
        }
        if (starryParam != null) {
            create.put(Byte.valueOf(TlvCodeConst.listenerId), starryParam.getListenerId());
        }
        AirPortDeviceManager sIntance2 = companion.getSIntance();
        String deviceId2 = starryTag.getDeviceId();
        Intrinsics.checkNotNullExpressionValue(deviceId2, "starryTag.deviceId");
        AbilityBean device = sIntance2.getDevice(deviceId2);
        if (device != null && (observer = device.getObserver()) != null) {
            observer.output(device.getDevice(), new AbilityMessage(create.serialize(), AbilityMessage.MessageType.AIR));
        }
    }

    public final void updateAbility(@NotNull Map<Integer, String> map, int i) {
        IAbilitySlot.SlotObserver observer;
        Intrinsics.checkNotNullParameter(map, "keyMap");
        for (StarryDevice next : AirPortDeviceManager.Companion.getSIntance().getBroadcastDeviceList(map.values())) {
            AirPortDeviceManager.Companion companion = AirPortDeviceManager.Companion;
            AirPortDeviceManager sIntance = companion.getSIntance();
            String id = next.getId();
            Intrinsics.checkNotNullExpressionValue(id, "dev.id");
            AbilityBean device = sIntance.getDevice(id);
            if ((device != null ? device.getObserver() : null) != null) {
                TlvBox create = TlvBox.create();
                String json = new Gson().toJson((Object) new AirBean().setAirMapping(map));
                if (i == 1) {
                    create.put(Byte.valueOf(TlvCodeConst.msgType), TlvCodeConst.installApp);
                } else {
                    create.put(Byte.valueOf(TlvCodeConst.msgType), TlvCodeConst.unInstallApp);
                }
                create.put(Byte.valueOf(TlvCodeConst.msgBody), json);
                AirPortDeviceManager sIntance2 = companion.getSIntance();
                String id2 = next.getId();
                Intrinsics.checkNotNullExpressionValue(id2, "dev.id");
                AbilityBean device2 = sIntance2.getDevice(id2);
                if (!(device2 == null || (observer = device2.getObserver()) == null)) {
                    observer.output(next, new AbilityMessage(create.serialize(), AbilityMessage.MessageType.AIR));
                }
            }
        }
    }
}
