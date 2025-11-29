package com.upuphone.xr.interconnect.business.messenger;

import com.meizu.common.widget.MzContactsContract;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.starrynetsdk.ability.relay.IMultiBypassAbility;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.business.connect.PeerDeviceStatusManager;
import com.upuphone.xr.interconnect.business.connect.PeerInfo;
import com.upuphone.xr.interconnect.business.messenger.compat.Version0MessageAdapter;
import com.upuphone.xr.interconnect.business.messenger.compat.Version1MessageAdapter;
import com.upuphone.xr.interconnect.common.IMessageSendListener;
import com.upuphone.xr.interconnect.entity.StarryNetRingMsgConfig;
import com.upuphone.xr.interconnect.main.StarryNetAbilityManager;
import com.upuphone.xr.interconnect.petastep.PetaStepSerializer;
import com.upuphone.xr.interconnect.util.log.ILog;
import com.upuphone.xr.interconnect.util.log.PayloadLoggingKt;
import com.upuphone.xr.interconnect.util.log.PrettyPrintExtKt;
import com.upuphone.xr.interconnect.util.statemachine.ChannelExtKt;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JG\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\"JH\u0010#\u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0002JO\u0010#\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010'JG\u0010#\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\"J2\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010,\u001a\u00020\bJ%\u0010-\u001a\u00020\u001f*\u00020!2\u0017\u0010.\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u001f0/¢\u0006\u0002\b0H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u00020\b8FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0002\u0010\r\u001a\u0002\u0012\u0004\u0012\u00020\b\u0012w\u0012u\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0015\u0012\u0013\u0018\u00010\u0017¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00170\u000f0\u000ej\u0001\u0012\u0004\u0012\u00020\b\u0012w\u0012u\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0015\u0012\u0013\u0018\u00010\u0017¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00170\u000f`\u0019X\u0004¢\u0006\u0002\n\u0000R\u0002\u0010\u001a\u001a\u0002\u0012\u0004\u0012\u00020\b\u0012w\u0012u\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0015\u0012\u0013\u0018\u00010\u0017¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00170\u000f0\u000ej\u0001\u0012\u0004\u0012\u00020\b\u0012w\u0012u\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0015\u0012\u0013\u0018\u00010\u0017¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00170\u000f`\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/upuphone/xr/interconnect/business/messenger/MessageTxProcessor;", "Lcom/upuphone/xr/interconnect/petastep/PetaStepSerializer;", "peerDeviceStatusManager", "Lcom/upuphone/xr/interconnect/business/connect/PeerDeviceStatusManager;", "(Lcom/upuphone/xr/interconnect/business/connect/PeerDeviceStatusManager;)V", "callbackScope", "Lkotlinx/coroutines/CoroutineScope;", "idSource", "", "getIdSource", "()I", "setIdSource", "(I)V", "messageAdapterMap", "Ljava/util/HashMap;", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "identifier", "", "sender", "receiver", "text", "", "data", "Lkotlin/collections/HashMap;", "messageConsumerMapFroPro", "relayChannel", "Lkotlinx/coroutines/channels/Channel;", "Lcom/upuphone/xr/interconnect/business/messenger/RelayTask;", "localSend", "", "listener", "Lcom/upuphone/xr/interconnect/common/IMessageSendListener;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BLcom/upuphone/xr/interconnect/common/IMessageSendListener;Ljava/lang/Integer;)V", "send", "peerInfo", "Lcom/upuphone/xr/interconnect/business/connect/PeerInfo;", "receiverDeviceId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BLcom/upuphone/xr/interconnect/common/IMessageSendListener;Ljava/lang/Integer;)V", "sendRingMsg", "ringMsgConfig", "Lcom/upuphone/xr/interconnect/entity/StarryNetRingMsgConfig;", "deviceId", "msgId", "safeCall", "action", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MessageTxProcessor extends PetaStepSerializer {
    @NotNull
    private final CoroutineScope callbackScope = CoroutineScopeKt.a(Dispatchers.a().plus(SupervisorKt.b((Job) null, 1, (Object) null)));
    private int idSource;
    @NotNull
    private final HashMap<Integer, Function5<Integer, String, String, String, byte[], byte[]>> messageAdapterMap;
    @NotNull
    private final HashMap<Integer, Function5<Integer, String, String, String, byte[], byte[]>> messageConsumerMapFroPro;
    /* access modifiers changed from: private */
    @NotNull
    public final PeerDeviceStatusManager peerDeviceStatusManager;
    /* access modifiers changed from: private */
    @NotNull
    public final Channel<RelayTask> relayChannel = ChannelKt.b(Integer.MAX_VALUE, (BufferOverflow) null, (Function1) null, 6, (Object) null);

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.xr.interconnect.business.messenger.MessageTxProcessor$2", f = "MessageTxProcessor.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.xr.interconnect.business.messenger.MessageTxProcessor$2  reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MessageTxProcessor this$0;

        {
            this.this$0 = r1;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0034 A[Catch:{ RuntimeException -> 0x0018, all -> 0x0015 }, RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x006a A[Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0072 A[Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }] */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x00a0 A[Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x00b9 A[Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }] */
        @org.jetbrains.annotations.Nullable
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.String r0 = ":"
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r13.label
                r3 = 1
                java.lang.String r4 = "PetaStepSerializer"
                java.lang.String r5 = "."
                if (r2 == 0) goto L_0x0023
                if (r2 != r3) goto L_0x001b
                kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ RuntimeException -> 0x0018, all -> 0x0015 }
                goto L_0x0035
            L_0x0015:
                r14 = move-exception
                goto L_0x011c
            L_0x0018:
                r14 = move-exception
                goto L_0x0139
            L_0x001b:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r14)
                throw r13
            L_0x0023:
                kotlin.ResultKt.throwOnFailure(r14)
            L_0x0026:
                com.upuphone.xr.interconnect.business.messenger.MessageTxProcessor r14 = r13.this$0     // Catch:{ RuntimeException -> 0x0018, all -> 0x0015 }
                kotlinx.coroutines.channels.Channel r14 = r14.relayChannel     // Catch:{ RuntimeException -> 0x0018, all -> 0x0015 }
                r13.label = r3     // Catch:{ RuntimeException -> 0x0018, all -> 0x0015 }
                java.lang.Object r14 = r14.K(r13)     // Catch:{ RuntimeException -> 0x0018, all -> 0x0015 }
                if (r14 != r1) goto L_0x0035
                return r1
            L_0x0035:
                com.upuphone.xr.interconnect.business.messenger.RelayTask r14 = (com.upuphone.xr.interconnect.business.messenger.RelayTask) r14     // Catch:{ RuntimeException -> 0x0018, all -> 0x0015 }
                int r2 = r14.component1()     // Catch:{ RuntimeException -> 0x0018, all -> 0x0015 }
                java.lang.String r6 = r14.component2()     // Catch:{ RuntimeException -> 0x0018, all -> 0x0015 }
                byte[] r7 = r14.component3()     // Catch:{ RuntimeException -> 0x0018, all -> 0x0015 }
                com.upuphone.xr.interconnect.common.IMessageSendListener r14 = r14.component4()     // Catch:{ RuntimeException -> 0x0018, all -> 0x0015 }
                com.upuphone.starrynetsdk.ability.relay.RelayBean r8 = new com.upuphone.starrynetsdk.ability.relay.RelayBean     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                r8.<init>()     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                r8.setTargetDeviceId(r6)     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                com.upuphone.xr.interconnect.InterconnectManager r6 = com.upuphone.xr.interconnect.InterconnectManager.getInstance()     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                java.lang.String r6 = r6.getPeerPackageName()     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                r8.setTargetUniteCode(r6)     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                r8.setData(r7)     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                com.upuphone.xr.interconnect.business.messenger.MessageTxProcessor r6 = r13.this$0     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                java.lang.String r6 = r6.getTag()     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                java.lang.String r7 = com.upuphone.xr.interconnect.util.log.PayloadLoggingKt.samplePrint((byte[]) r7)     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                r9 = 0
                if (r14 == 0) goto L_0x0072
                java.lang.String r10 = com.upuphone.xr.interconnect.util.log.PrettyPrintExtKt.stringify(r14)     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                goto L_0x0073
            L_0x006f:
                r6 = move-exception
                goto L_0x00f3
            L_0x0072:
                r10 = r9
            L_0x0073:
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                r11.<init>()     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                java.lang.String r12 = "Relaying #"
                r11.append(r12)     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                r11.append(r2)     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                r11.append(r0)     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                r11.append(r7)     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                r11.append(r0)     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                r11.append(r10)     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                r11.append(r5)     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                java.lang.String r7 = r11.toString()     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                com.upuphone.xr.interconnect.util.log.ILog.d(r6, r7)     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                com.upuphone.xr.interconnect.main.StarryNetAbilityManager r6 = com.upuphone.xr.interconnect.main.StarryNetAbilityManager.getInstance()     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                com.upuphone.starrynetsdk.ability.relay.RelayAbility r6 = r6.getRelayAbility()     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                if (r6 != 0) goto L_0x00b9
                com.upuphone.xr.interconnect.business.messenger.MessageTxProcessor r6 = r13.this$0     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                java.lang.String r6 = r6.getTag()     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                java.lang.String r7 = "Cannot send message because relay ability is not available."
                com.upuphone.xr.interconnect.util.log.ILog.w(r6, r7)     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                if (r14 == 0) goto L_0x0026
                com.upuphone.xr.interconnect.business.messenger.MessageTxProcessor r6 = r13.this$0     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                com.upuphone.xr.interconnect.business.messenger.MessageTxProcessor$2$1 r7 = new com.upuphone.xr.interconnect.business.messenger.MessageTxProcessor$2$1     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                r7.<init>(r2)     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                r6.safeCall(r14, r7)     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                goto L_0x0026
            L_0x00b9:
                if (r14 == 0) goto L_0x00c2
                com.upuphone.xr.interconnect.business.messenger.MessageTxProcessor r7 = r13.this$0     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                com.upuphone.xr.interconnect.business.messenger.MessageTxProcessor$2$result$1$1 r9 = new com.upuphone.xr.interconnect.business.messenger.MessageTxProcessor$2$result$1$1     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                r9.<init>(r7, r2, r14)     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
            L_0x00c2:
                int r6 = r6.relay(r8, r9)     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                if (r6 == 0) goto L_0x0026
                com.upuphone.xr.interconnect.business.messenger.MessageTxProcessor r7 = r13.this$0     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                java.lang.String r7 = r7.getTag()     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                r8.<init>()     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                java.lang.String r9 = "Relay failed with code "
                r8.append(r9)     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                r8.append(r6)     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                r8.append(r5)     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                java.lang.String r6 = r8.toString()     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                com.upuphone.xr.interconnect.util.log.ILog.w(r7, r6)     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                if (r14 == 0) goto L_0x0026
                com.upuphone.xr.interconnect.business.messenger.MessageTxProcessor r6 = r13.this$0     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                com.upuphone.xr.interconnect.business.messenger.MessageTxProcessor$2$2 r7 = new com.upuphone.xr.interconnect.business.messenger.MessageTxProcessor$2$2     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                r7.<init>(r2)     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                r6.safeCall(r14, r7)     // Catch:{ RuntimeException -> 0x006f, all -> 0x0015 }
                goto L_0x0026
            L_0x00f3:
                java.lang.String r6 = r6.getLocalizedMessage()     // Catch:{ RuntimeException -> 0x0018, all -> 0x0015 }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x0018, all -> 0x0015 }
                r7.<init>()     // Catch:{ RuntimeException -> 0x0018, all -> 0x0015 }
                java.lang.String r8 = "Relay failed with exception: "
                r7.append(r8)     // Catch:{ RuntimeException -> 0x0018, all -> 0x0015 }
                r7.append(r6)     // Catch:{ RuntimeException -> 0x0018, all -> 0x0015 }
                r7.append(r5)     // Catch:{ RuntimeException -> 0x0018, all -> 0x0015 }
                java.lang.String r6 = r7.toString()     // Catch:{ RuntimeException -> 0x0018, all -> 0x0015 }
                com.upuphone.xr.interconnect.util.log.ILog.e(r4, r6)     // Catch:{ RuntimeException -> 0x0018, all -> 0x0015 }
                if (r14 == 0) goto L_0x0026
                com.upuphone.xr.interconnect.business.messenger.MessageTxProcessor r6 = r13.this$0     // Catch:{ RuntimeException -> 0x0018, all -> 0x0015 }
                com.upuphone.xr.interconnect.business.messenger.MessageTxProcessor$2$3 r7 = new com.upuphone.xr.interconnect.business.messenger.MessageTxProcessor$2$3     // Catch:{ RuntimeException -> 0x0018, all -> 0x0015 }
                r7.<init>(r2)     // Catch:{ RuntimeException -> 0x0018, all -> 0x0015 }
                r6.safeCall(r14, r7)     // Catch:{ RuntimeException -> 0x0018, all -> 0x0015 }
                goto L_0x0026
            L_0x011c:
                java.lang.String r14 = r14.getLocalizedMessage()
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r6 = "Receiving failed with unrecoverable error: "
                r2.append(r6)
                r2.append(r14)
                r2.append(r5)
                java.lang.String r14 = r2.toString()
                com.upuphone.xr.interconnect.util.log.ILog.e(r4, r14)
                goto L_0x0026
            L_0x0139:
                java.lang.String r14 = r14.getLocalizedMessage()
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r6 = "Receiving failed: "
                r2.append(r6)
                r2.append(r14)
                r2.append(r5)
                java.lang.String r14 = r2.toString()
                com.upuphone.xr.interconnect.util.log.ILog.e(r4, r14)
                goto L_0x0026
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.interconnect.business.messenger.MessageTxProcessor.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageTxProcessor(@NotNull PeerDeviceStatusManager peerDeviceStatusManager2) {
        super(AnonymousClass1.INSTANCE, (String) null, 2, (DefaultConstructorMarker) null);
        PeerDeviceStatusManager peerDeviceStatusManager3 = peerDeviceStatusManager2;
        Intrinsics.checkNotNullParameter(peerDeviceStatusManager3, "peerDeviceStatusManager");
        this.peerDeviceStatusManager = peerDeviceStatusManager3;
        Job unused = BuildersKt__Builders_commonKt.d(PetaStepSerializer.Companion.getScope(), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(this, (Continuation<? super AnonymousClass2>) null), 3, (Object) null);
        this.idSource = 1;
        this.messageAdapterMap = MapsKt.hashMapOf(TuplesKt.to(0, new Version0MessageAdapter()), TuplesKt.to(1, new Version1MessageAdapter()), TuplesKt.to(2, new Version1MessageAdapter()), TuplesKt.to(3, new Version1MessageAdapter()), TuplesKt.to(4, new Version1MessageAdapter()), TuplesKt.to(5, new Version1MessageAdapter()), TuplesKt.to(6, new Version1MessageAdapter()), TuplesKt.to(7, new Version1MessageAdapter()), TuplesKt.to(8, new Version1MessageAdapter()));
        this.messageConsumerMapFroPro = MapsKt.hashMapOf(TuplesKt.to(0, new Version0MessageAdapter()), TuplesKt.to(1, new Version1MessageAdapter()), TuplesKt.to(2, new Version1MessageAdapter()), TuplesKt.to(3, new Version1MessageAdapter()), TuplesKt.to(4, new Version1MessageAdapter()), TuplesKt.to(5, new Version1MessageAdapter()), TuplesKt.to(6, new Version1MessageAdapter()), TuplesKt.to(7, new Version1MessageAdapter()), TuplesKt.to(100, new Version1MessageAdapter()));
    }

    public static /* synthetic */ void localSend$default(MessageTxProcessor messageTxProcessor, String str, String str2, String str3, byte[] bArr, IMessageSendListener iMessageSendListener, Integer num, int i, Object obj) {
        messageTxProcessor.localSend(str, str2, str3, bArr, (i & 16) != 0 ? null : iMessageSendListener, (i & 32) != 0 ? null : num);
    }

    /* access modifiers changed from: private */
    public final void safeCall(IMessageSendListener iMessageSendListener, Function1<? super IMessageSendListener, Unit> function1) {
        Job unused = BuildersKt__Builders_commonKt.d(this.callbackScope, (CoroutineContext) null, (CoroutineStart) null, new MessageTxProcessor$safeCall$1(function1, iMessageSendListener, this, (Continuation<? super MessageTxProcessor$safeCall$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void send(int i, PeerInfo peerInfo, String str, String str2, String str3, byte[] bArr, IMessageSendListener iMessageSendListener) {
        int i2 = i;
        IMessageSendListener iMessageSendListener2 = iMessageSendListener;
        String tag = getTag();
        String str4 = null;
        String stringify = iMessageSendListener2 != null ? PrettyPrintExtKt.stringify(iMessageSendListener) : null;
        ILog.d(tag, "Sending message#" + i + " from " + str + " to " + str2 + "@" + peerInfo + " with " + stringify + ".");
        String tag2 = getTag();
        String limitSizePrint = str3 != null ? PayloadLoggingKt.limitSizePrint(str3) : null;
        if (bArr != null) {
            str4 = PayloadLoggingKt.samplePrint(bArr);
        }
        ILog.v(tag2, "Content: " + limitSizePrint + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_VCARD + str4);
        boolean isAirPro = InterconnectManager.getInstance().getStarryNetDeviceInfoManager().isAirPro();
        String tag3 = getTag();
        ILog.w(tag3, "Sending message isPro = " + isAirPro);
        String component1 = peerInfo.component1();
        int component2 = peerInfo.component2();
        Function5 function5 = isAirPro ? this.messageConsumerMapFroPro.get(Integer.valueOf(component2)) : this.messageAdapterMap.get(Integer.valueOf(component2));
        if (function5 == null) {
            String tag4 = getTag();
            ILog.w(tag4, "Cannot send message to " + component1 + " because version " + component2 + " is not supported.");
            if (iMessageSendListener2 != null) {
                safeCall(iMessageSendListener2, new MessageTxProcessor$send$1(i));
                return;
            }
            return;
        }
        ChannelExtKt.sendOrErr(this.relayChannel, new RelayTask(i, component1, (byte[]) function5.invoke(Integer.valueOf(i), str, str2, str3, bArr), iMessageSendListener2));
    }

    public static /* synthetic */ void send$default(MessageTxProcessor messageTxProcessor, int i, PeerInfo peerInfo, String str, String str2, String str3, byte[] bArr, IMessageSendListener iMessageSendListener, int i2, Object obj) {
        messageTxProcessor.send(i, peerInfo, str, str2, str3, bArr, (i2 & 64) != 0 ? null : iMessageSendListener);
    }

    public static /* synthetic */ int sendRingMsg$default(MessageTxProcessor messageTxProcessor, StarryNetRingMsgConfig starryNetRingMsgConfig, String str, byte[] bArr, IMessageSendListener iMessageSendListener, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            iMessageSendListener = null;
        }
        return messageTxProcessor.sendRingMsg(starryNetRingMsgConfig, str, bArr, iMessageSendListener, i);
    }

    public final int getIdSource() {
        int i = this.idSource;
        this.idSource = i == Integer.MAX_VALUE ? 1 : i + 1;
        return i;
    }

    public final void localSend(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable byte[] bArr, @Nullable IMessageSendListener iMessageSendListener, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, "sender");
        Intrinsics.checkNotNullParameter(str2, "receiver");
        serialize("local tx", new MessageTxProcessor$localSend$1(num, this, str, str2, iMessageSendListener, str3, bArr));
    }

    public final int sendRingMsg(@NotNull StarryNetRingMsgConfig starryNetRingMsgConfig, @NotNull String str, @NotNull byte[] bArr, @Nullable IMessageSendListener iMessageSendListener, int i) {
        Intrinsics.checkNotNullParameter(starryNetRingMsgConfig, "ringMsgConfig");
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(bArr, "data");
        IMultiBypassAbility multiBypassAbility = StarryNetAbilityManager.getInstance().getMultiBypassAbility();
        String serviceData = starryNetRingMsgConfig.getServiceData();
        Intrinsics.checkNotNullExpressionValue(serviceData, "getServiceData(...)");
        String characteristic = starryNetRingMsgConfig.getCharacteristic();
        Intrinsics.checkNotNullExpressionValue(characteristic, "getCharacteristic(...)");
        String version = starryNetRingMsgConfig.getVersion();
        Intrinsics.checkNotNullExpressionValue(version, "getVersion(...)");
        return multiBypassAbility.sendMessage(str, serviceData, characteristic, bArr, Integer.parseInt(version), new MessageTxProcessor$sendRingMsg$1(iMessageSendListener, i));
    }

    public final void setIdSource(int i) {
        this.idSource = i;
    }

    public static /* synthetic */ void send$default(MessageTxProcessor messageTxProcessor, String str, String str2, String str3, byte[] bArr, IMessageSendListener iMessageSendListener, Integer num, int i, Object obj) {
        messageTxProcessor.send(str, str2, str3, bArr, (i & 16) != 0 ? null : iMessageSendListener, (i & 32) != 0 ? null : num);
    }

    public static /* synthetic */ void send$default(MessageTxProcessor messageTxProcessor, String str, String str2, String str3, String str4, byte[] bArr, IMessageSendListener iMessageSendListener, Integer num, int i, Object obj) {
        messageTxProcessor.send(str, str2, str3, str4, bArr, (i & 32) != 0 ? null : iMessageSendListener, (i & 64) != 0 ? null : num);
    }

    public final void send(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable byte[] bArr, @Nullable IMessageSendListener iMessageSendListener, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, "sender");
        Intrinsics.checkNotNullParameter(str2, "receiver");
        serialize("peer tx", new MessageTxProcessor$send$2(num, this, str, str2, str3, bArr, iMessageSendListener));
    }

    public final void send(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable byte[] bArr, @Nullable IMessageSendListener iMessageSendListener, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, "receiverDeviceId");
        Intrinsics.checkNotNullParameter(str2, "sender");
        Intrinsics.checkNotNullParameter(str3, "receiver");
        MessageTxProcessor$send$3 messageTxProcessor$send$3 = new MessageTxProcessor$send$3(num, this, str, str2, str3, str4, bArr, iMessageSendListener);
        serialize("tx", messageTxProcessor$send$3);
    }
}
