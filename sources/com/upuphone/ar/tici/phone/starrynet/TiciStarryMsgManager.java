package com.upuphone.ar.tici.phone.starrynet;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.android.dingtalk.openauth.utils.DDAuthConstant;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.r4.a;
import com.honey.account.r4.b;
import com.honey.account.view.web.WebJs;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel;
import com.upuphone.ar.tici.phone.data.OpenTiciConfig;
import com.upuphone.ar.tici.phone.data.OpenTiciConfigKt;
import com.upuphone.ar.tici.phone.data.OpenTiciFrom;
import com.upuphone.ar.tici.phone.data.OpenTiciResult;
import com.upuphone.ar.tici.phone.db.entity.TiciContentPart;
import com.upuphone.ar.tici.phone.db.entity.TiciEntity;
import com.upuphone.ar.tici.phone.db.entity.TiciEntityKt;
import com.upuphone.ar.tici.phone.starrynet.msg.AutoTiciRunningMsg;
import com.upuphone.ar.tici.phone.starrynet.msg.CancelTiciMsg;
import com.upuphone.ar.tici.phone.starrynet.msg.ChangeTiciModeMsg;
import com.upuphone.ar.tici.phone.starrynet.msg.CheckTiciStateMsg;
import com.upuphone.ar.tici.phone.starrynet.msg.HighlightMsg;
import com.upuphone.ar.tici.phone.starrynet.msg.HighlightMsgV3;
import com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsg;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import com.upuphone.ar.tici.phone.utils.ConstantsKt;
import com.upuphone.ar.tici.phone.utils.SpUtilKt;
import com.upuphone.ar.tici.phone.utils.StringExtKt;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.upuphone.xr.interconnect.Constants;
import com.upuphone.xr.interconnect.SuperAppServiceManager;
import com.upuphone.xr.interconnect.api.OperatorManager;
import com.upuphone.xr.interconnect.api.StarryNetDeviceOperator;
import com.upuphone.xr.interconnect.api.StarryNetMessageOperator;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.listener.DeviceConnectionListener;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.interconnect.util.StarryNetDeviceExt;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.utils.ModelIdExtKt;
import com.xjmz.arabic.NativeLib;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000×\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e*\u0001\u0018\u0018\u0000 \u00012\u00020\u00012\u00020\u0002:\u0002\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u00102\u001a\u000203J\b\u00104\u001a\u000203H\u0002J\u0006\u00105\u001a\u000203J!\u00106\u001a\u0002032\u0017\u00107\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020308¢\u0006\u0002\b9H\u0002J\u0010\u0010:\u001a\u0002032\u0006\u0010;\u001a\u00020\tH\u0002J\u0010\u0010:\u001a\u0002032\u0006\u0010<\u001a\u00020=H\u0002J\u0017\u0010>\u001a\u0004\u0018\u0001012\u0006\u0010?\u001a\u00020\u000bH\u0000¢\u0006\u0002\b@J\b\u0010A\u001a\u0004\u0018\u00010BJ\n\u0010C\u001a\u0004\u0018\u00010BH\u0007J\b\u0010D\u001a\u0004\u0018\u00010BJ\r\u0010E\u001a\u000203H\u0000¢\u0006\u0002\bFJ\u0015\u0010G\u001a\u0002032\u0006\u0010?\u001a\u00020\u000bH\u0000¢\u0006\u0002\bHJ\u0010\u0010I\u001a\u0002032\u0006\u0010J\u001a\u00020KH\u0002J\u000e\u0010L\u001a\u00020 2\u0006\u0010M\u001a\u00020BJ\u000e\u0010N\u001a\u00020 2\u0006\u0010M\u001a\u00020BJ\u0012\u0010O\u001a\u0002032\b\u0010M\u001a\u0004\u0018\u00010BH\u0016J\u0012\u0010P\u001a\u0002032\b\u0010M\u001a\u0004\u0018\u00010BH\u0016J\u000e\u0010Q\u001a\u0002032\u0006\u0010R\u001a\u00020\u0001J\u000e\u0010S\u001a\u0002032\u0006\u0010T\u001a\u00020 J\u0010\u0010U\u001a\u0002032\u0006\u0010?\u001a\u00020\u000bH\u0002J\u000e\u0010V\u001a\u0002032\u0006\u0010W\u001a\u00020XJ\u0006\u0010Y\u001a\u000203J\u000e\u0010Z\u001a\u0002032\u0006\u0010[\u001a\u00020\\J\u0018\u0010Z\u001a\u0002032\u0006\u0010]\u001a\u00020=2\b\u0010^\u001a\u0004\u0018\u00010\u000bJN\u0010_\u001a\u0002032\u0006\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020=2\u0006\u0010e\u001a\u00020=2\u0006\u0010f\u001a\u00020 2\u0006\u0010g\u001a\u00020=2\u0006\u0010h\u001a\u00020=2\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020\u0006J \u0010l\u001a\u0002032\u0006\u0010[\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u000b2\u0006\u0010m\u001a\u00020\u0006H\u0002J-\u0010n\u001a\u0002032\u0006\u0010[\u001a\u00020\u000b2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010R\u001a\u0004\u0018\u00010oH\u0000¢\u0006\u0002\bpJ\u0010\u0010q\u001a\u0002032\u0006\u0010r\u001a\u00020sH\u0002J\u0010\u0010t\u001a\u0002032\u0006\u0010f\u001a\u00020 H\u0003J1\u0010u\u001a\u0002032\u0006\u0010`\u001a\u00020a2\u0006\u0010v\u001a\u00020c2\u0006\u0010d\u001a\u00020=2\n\b\u0002\u0010e\u001a\u0004\u0018\u00010=H\u0007¢\u0006\u0002\u0010wJ(\u0010x\u001a\u0002032\u0006\u0010^\u001a\u00020\u000b2\u0006\u0010y\u001a\u00020\u000b2\u0006\u0010z\u001a\u00020=2\u0006\u0010d\u001a\u00020=H\u0002J\u0010\u0010{\u001a\u0002032\b\b\u0002\u0010m\u001a\u00020\u0006J\u000e\u0010|\u001a\u0002032\u0006\u0010R\u001a\u00020\u0001J\u0010\u0010}\u001a\u0002032\u0006\u0010k\u001a\u00020\u0006H\u0002J\u000e\u0010~\u001a\u000203H@¢\u0006\u0002\u0010R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u0011X\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\t0&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010+\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0010\u0010.\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Lcom/upuphone/ar/tici/phone/starrynet/TiciStarryMsgManager;", "Lcom/upuphone/xr/interconnect/listener/DeviceConnectionListener;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "_impatientTiciData", "Landroidx/lifecycle/MutableLiveData;", "", "_openTiciResultFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/upuphone/ar/tici/phone/data/OpenTiciResult;", "connectedDeviceType", "", "getConnectedDeviceType", "()Ljava/lang/String;", "connectionListeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "delaySendTiciContentJob", "Lkotlinx/coroutines/Job;", "delaySendTiciPageJob", "deviceBoundListener", "com/upuphone/ar/tici/phone/starrynet/TiciStarryMsgManager$deviceBoundListener$1", "Lcom/upuphone/ar/tici/phone/starrynet/TiciStarryMsgManager$deviceBoundListener$1;", "impatientTiciData", "Landroidx/lifecycle/LiveData;", "getImpatientTiciData", "()Landroidx/lifecycle/LiveData;", "impatientTiciJob", "isConnected", "", "isWaitingTici", "()Z", "msgHandler", "Lcom/upuphone/ar/tici/phone/starrynet/ReceiveMsgHandler;", "openTiciResultFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getOpenTiciResultFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "operatorManager", "Lcom/upuphone/xr/interconnect/api/OperatorManager;", "receiveMsgHandler", "getReceiveMsgHandler", "()Lcom/upuphone/ar/tici/phone/starrynet/ReceiveMsgHandler;", "sendTiciContentJob", "waitingOpenAppJob", "waitingTiciConfig", "Lcom/upuphone/ar/tici/phone/data/OpenTiciConfig;", "cancelOpenTiciMsg", "", "cancelPendingJob", "destroy", "dispatchDeviceConnect", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "dispatchOpenTiciResult", "result", "code", "", "findOpenTiciConfig", "msgId", "findOpenTiciConfig$ar_tici_release", "getBondedXrDevice", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "getConnectDevice", "getConnectXrDevice", "handleGlassesTiciQuit", "handleGlassesTiciQuit$ar_tici_release", "handleOpenResult", "handleOpenResult$ar_tici_release", "handleStarryMsg", "starryNetMessage", "Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;", "isAirGlass", "device", "isStarOrConceptGlass", "onDeviceConnected", "onDeviceDisconnected", "registerDeviceConnectListener", "listener", "sendAutoTiciState", "running", "sendCancelTiciMsg", "sendChangeTiciMode", "ticiModeMsg", "Lcom/upuphone/ar/tici/phone/starrynet/msg/ChangeTiciModeMsg;", "sendCheckTiciStateMsg", "sendHighlightMsg", "msg", "Lcom/upuphone/ar/tici/phone/starrynet/msg/HighlightMsgV3;", "index", "fileKey", "sendOpenAppMsg", "ticiEntity", "Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;", "ticiContentPart", "Lcom/upuphone/ar/tici/phone/db/entity/TiciContentPart;", "currentPage", "currentIndex", "supportLargeFile", "prevTotalParagraphSize", "nextTotalParagraphSize", "from", "Lcom/upuphone/ar/tici/phone/data/OpenTiciFrom;", "sendContentDelay", "sendOpenAppMsgAndWait", "waitTime", "sendStarryMessage", "Lcom/upuphone/xr/interconnect/listener/SendMessageListener;", "sendStarryMessage$ar_tici_release", "sendTiciActionMsg", "data", "Lorg/json/JSONObject;", "sendTiciContentInfo", "sendTiciContentPage", "contentPart", "(Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;Lcom/upuphone/ar/tici/phone/db/entity/TiciContentPart;ILjava/lang/Integer;)V", "sendTiciContentPart", "sourceText", "totalPart", "startImpatientTiciCount", "unregisterDeviceConnectListener", "waitForGlassTiciStarted", "waitUntilConnected", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTiciStarryMsgManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciStarryMsgManager.kt\ncom/upuphone/ar/tici/phone/starrynet/TiciStarryMsgManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 BaseJsonMsg.kt\ncom/upuphone/ar/tici/phone/starrynet/BaseJsonMsg$Companion\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,728:1\n288#2,2:729\n1855#2,2:733\n15#3:731\n1#4:732\n314#5,11:735\n*S KotlinDebug\n*F\n+ 1 TiciStarryMsgManager.kt\ncom/upuphone/ar/tici/phone/starrynet/TiciStarryMsgManager\n*L\n193#1:729,2\n570#1:733,2\n214#1:731\n675#1:735,11\n*E\n"})
public final class TiciStarryMsgManager extends DeviceConnectionListener implements CoroutineScope {
    private static final int CONTENT_LIMIT = 10240;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long IMPATIENT_WAIT_TIME = 5000;
    public static final long MAX_TIME_OUT = 180000;
    public static final long MIN_TIME_OUT = 30000;
    public static final long SINGLE_PART_TIME = 8500;
    @NotNull
    private static final String TAG = "TiciStarryMsgManager";
    private final /* synthetic */ CoroutineScope $$delegate_0 = CoroutineScopeKt.b();
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<Long> _impatientTiciData;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableSharedFlow<OpenTiciResult> _openTiciResultFlow;
    @NotNull
    private final CopyOnWriteArraySet<DeviceConnectionListener> connectionListeners;
    @Nullable
    private Job delaySendTiciContentJob;
    @Nullable
    private Job delaySendTiciPageJob;
    @NotNull
    private final TiciStarryMsgManager$deviceBoundListener$1 deviceBoundListener;
    @NotNull
    private final LiveData<Long> impatientTiciData;
    @Nullable
    private Job impatientTiciJob;
    private boolean isConnected;
    @NotNull
    private final ReceiveMsgHandler msgHandler = new ReceiveMsgHandler();
    @NotNull
    private final SharedFlow<OpenTiciResult> openTiciResultFlow;
    @Nullable
    private OperatorManager operatorManager;
    @Nullable
    private Job sendTiciContentJob;
    @Nullable
    private Job waitingOpenAppJob;
    /* access modifiers changed from: private */
    @Nullable
    public volatile OpenTiciConfig waitingTiciConfig;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/upuphone/ar/tici/phone/starrynet/TiciStarryMsgManager$Companion;", "", "()V", "CONTENT_LIMIT", "", "IMPATIENT_WAIT_TIME", "", "MAX_TIME_OUT", "MIN_TIME_OUT", "SINGLE_PART_TIME", "TAG", "", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public TiciStarryMsgManager() {
        MutableSharedFlow<OpenTiciResult> b = SharedFlowKt.b(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._openTiciResultFlow = b;
        this.openTiciResultFlow = FlowKt.b(b);
        MutableLiveData<Long> mutableLiveData = new MutableLiveData<>();
        this._impatientTiciData = mutableLiveData;
        this.impatientTiciData = mutableLiveData;
        this.connectionListeners = new CopyOnWriteArraySet<>();
        this.deviceBoundListener = new TiciStarryMsgManager$deviceBoundListener$1();
        CommonExtKt.e("TiciStarryMsgManager#init", TAG);
        SuperAppServiceManager.getInstance().init("com.upuphone.ar.tici", new a(this));
        SuperAppServiceManager.getInstance().init("com.upuphone.star.launcher", new b(this));
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(TiciStarryMsgManager ticiStarryMsgManager, OperatorManager operatorManager2) {
        Intrinsics.checkNotNullParameter(ticiStarryMsgManager, "this$0");
        Intrinsics.checkNotNullParameter(operatorManager2, "operatorManager");
        ticiStarryMsgManager.operatorManager = operatorManager2;
        CommonExtKt.e("SuperAppServiceManager#init-sender, operatorManager: " + operatorManager2, TAG);
        operatorManager2.getDeviceOperator().registerDeviceConnectionListener(ticiStarryMsgManager);
        operatorManager2.getDeviceOperator().registerDeviceBondStateListener(ticiStarryMsgManager.deviceBoundListener);
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$1(TiciStarryMsgManager ticiStarryMsgManager, OperatorManager operatorManager2) {
        Intrinsics.checkNotNullParameter(ticiStarryMsgManager, "this$0");
        Intrinsics.checkNotNullParameter(operatorManager2, "operatorManager");
        CommonExtKt.e("SuperAppServiceManager#init-receiver, operatorManager: " + operatorManager2, TAG);
        operatorManager2.getMessageOperator().registerMessageReceiver(new TiciStarryMsgManager$2$1(ticiStarryMsgManager));
    }

    /* access modifiers changed from: private */
    public final void cancelPendingJob() {
        Job job = this.waitingOpenAppJob;
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        Job job2 = this.sendTiciContentJob;
        if (job2 != null) {
            Job.DefaultImpls.a(job2, (CancellationException) null, 1, (Object) null);
        }
        Job job3 = this.delaySendTiciContentJob;
        if (job3 != null) {
            Job.DefaultImpls.a(job3, (CancellationException) null, 1, (Object) null);
        }
        Job job4 = this.impatientTiciJob;
        if (job4 != null) {
            Job.DefaultImpls.a(job4, (CancellationException) null, 1, (Object) null);
        }
    }

    private final void dispatchDeviceConnect(Function1<? super DeviceConnectionListener, Unit> function1) {
        for (DeviceConnectionListener deviceConnectionListener : this.connectionListeners) {
            Intrinsics.checkNotNull(deviceConnectionListener);
            function1.invoke(deviceConnectionListener);
        }
    }

    /* access modifiers changed from: private */
    public final void dispatchOpenTiciResult(OpenTiciResult openTiciResult) {
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new TiciStarryMsgManager$dispatchOpenTiciResult$1(this, openTiciResult, (Continuation<? super TiciStarryMsgManager$dispatchOpenTiciResult$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void handleStarryMsg(StarryNetMessage starryNetMessage) {
        try {
            JsonElement parseString = JsonParser.parseString(starryNetMessage.getMessage());
            JsonObject jsonObject = parseString instanceof JsonObject ? (JsonObject) parseString : null;
            if (jsonObject == null) {
                String message = starryNetMessage.getMessage();
                CommonExtKt.d("handleStarryMsg, wrong message: " + message, TAG, (Throwable) null, 2, (Object) null);
            } else if (jsonObject.has(WebJs.ACTION) && Intrinsics.areEqual((Object) jsonObject.get(WebJs.ACTION).getAsString(), (Object) "tici")) {
                String jsonElement = jsonObject.get("data").toString();
                Intrinsics.checkNotNullExpressionValue(jsonElement, "toString(...)");
                this.msgHandler.k(this, (BaseActionMsg) BaseJsonMsg.Companion.a().fromJson(jsonElement, BaseActionMsg.class));
            }
        } catch (Throwable th) {
            String message2 = starryNetMessage.getMessage();
            CommonExtKt.d("handleStarryMsg, error: " + th + ", message: " + message2, TAG, (Throwable) null, 2, (Object) null);
        }
    }

    private final void sendCancelTiciMsg(String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(WebJs.ACTION, BaseActionMsg.MSG_APP_CANCEL_TICI);
        jSONObject.put(AccountConstantKt.RESPONSE_VALUE, new CancelTiciMsg(str).toJsonString());
        sendTiciActionMsg(jSONObject);
    }

    private final void sendOpenAppMsgAndWait(String str, String str2, long j) {
        CommonExtKt.e("sendOpenAppMsgAndWait-> msgId: " + str2 + ", waitTime: " + j + ", send", TAG);
        Job job = this.waitingOpenAppJob;
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        this.waitingOpenAppJob = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new TiciStarryMsgManager$sendOpenAppMsgAndWait$1(j, this, (Continuation<? super TiciStarryMsgManager$sendOpenAppMsgAndWait$1>) null), 3, (Object) null);
        sendStarryMessage$ar_tici_release(str, str2, new TiciStarryMsgManager$sendOpenAppMsgAndWait$2(this));
    }

    public static /* synthetic */ void sendStarryMessage$ar_tici_release$default(TiciStarryMsgManager ticiStarryMsgManager, String str, String str2, SendMessageListener sendMessageListener, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            sendMessageListener = null;
        }
        ticiStarryMsgManager.sendStarryMessage$ar_tici_release(str, str2, sendMessageListener);
    }

    private final void sendTiciActionMsg(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(WebJs.ACTION, "tici");
        jSONObject2.put("data", jSONObject);
        String jSONObject3 = jSONObject2.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "toString(...)");
        sendStarryMessage$ar_tici_release$default(this, jSONObject3, (String) null, (SendMessageListener) null, 6, (Object) null);
    }

    @Deprecated(message = "已废弃，未使用")
    private final void sendTiciContentInfo(boolean z) {
        OpenTiciConfig openTiciConfig = this.waitingTiciConfig;
        if (openTiciConfig == null) {
            CommonExtKt.d("sendTiciContentInfo, waitingTiciConfig is null", TAG, (Throwable) null, 2, (Object) null);
        } else if (z) {
            sendTiciContentPage(openTiciConfig.f(), openTiciConfig.e(), openTiciConfig.b(), Integer.valueOf(openTiciConfig.a()));
        } else {
            sendTiciContentPart(OpenTiciConfigKt.a(openTiciConfig), OpenTiciConfigKt.d(openTiciConfig), openTiciConfig.d().getTotalPart(), openTiciConfig.b());
        }
    }

    public static /* synthetic */ void sendTiciContentPage$default(TiciStarryMsgManager ticiStarryMsgManager, TiciEntity ticiEntity, TiciContentPart ticiContentPart, int i, Integer num, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            num = null;
        }
        ticiStarryMsgManager.sendTiciContentPage(ticiEntity, ticiContentPart, i, num);
    }

    /* access modifiers changed from: private */
    public final void sendTiciContentPart(String str, String str2, int i, int i2) {
        Job job = this.sendTiciContentJob;
        if (job == null || !job.isActive()) {
            this.sendTiciContentJob = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new TiciStarryMsgManager$sendTiciContentPart$1(i, str2, str, i2, (Continuation<? super TiciStarryMsgManager$sendTiciContentPart$1>) null), 3, (Object) null);
        } else {
            CommonExtKt.e("sendTiciContentPart, sendTiciContentJob.isActive=true, return", TAG);
        }
    }

    public static /* synthetic */ void startImpatientTiciCount$default(TiciStarryMsgManager ticiStarryMsgManager, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 5000;
        }
        ticiStarryMsgManager.startImpatientTiciCount(j);
    }

    private final void waitForGlassTiciStarted(long j) {
        Job job = this.delaySendTiciContentJob;
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        this.delaySendTiciContentJob = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new TiciStarryMsgManager$waitForGlassTiciStarted$1(j, this, (Continuation<? super TiciStarryMsgManager$waitForGlassTiciStarted$1>) null), 3, (Object) null);
    }

    public final void cancelOpenTiciMsg() {
        OpenTiciConfig openTiciConfig = this.waitingTiciConfig;
        OpenTiciMsg d = openTiciConfig != null ? openTiciConfig.d() : null;
        CommonExtKt.e("cancelOpenTiciMsg, waitingTiciConfig: " + d, TAG);
        OpenTiciConfig openTiciConfig2 = this.waitingTiciConfig;
        if (openTiciConfig2 != null) {
            sendCancelTiciMsg(OpenTiciConfigKt.c(openTiciConfig2));
        }
        cancelPendingJob();
        dispatchOpenTiciResult(ConstantsKt.e());
    }

    public final void destroy() {
        StarryNetDeviceOperator deviceOperator;
        CommonExtKt.e("destroy-> ", TAG);
        OperatorManager operatorManager2 = this.operatorManager;
        if (operatorManager2 != null && (deviceOperator = operatorManager2.getDeviceOperator()) != null) {
            deviceOperator.unregisterDeviceConnectionListener(this);
        }
    }

    @Nullable
    public final OpenTiciConfig findOpenTiciConfig$ar_tici_release(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "msgId");
        OpenTiciConfig openTiciConfig = this.waitingTiciConfig;
        if (openTiciConfig == null || !Intrinsics.areEqual((Object) OpenTiciConfigKt.c(openTiciConfig), (Object) str)) {
            return null;
        }
        return openTiciConfig;
    }

    @Nullable
    public final StarryNetDevice getBondedXrDevice() {
        List<StarryNetDevice> bondedDevices;
        OperatorManager operatorManager2 = this.operatorManager;
        T t = null;
        StarryNetDeviceOperator deviceOperator = operatorManager2 != null ? operatorManager2.getDeviceOperator() : null;
        if (deviceOperator == null) {
            CommonExtKt.d("getBondedXrDevice, deviceOperator is null", TAG, (Throwable) null, 2, (Object) null);
        }
        if (deviceOperator == null || (bondedDevices = deviceOperator.getBondedDevices()) == null) {
            return null;
        }
        Iterator<T> it = bondedDevices.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            StarryNetDevice starryNetDevice = (StarryNetDevice) next;
            Intrinsics.checkNotNull(starryNetDevice);
            if (StarryNetDeviceExt.isXrDevice(starryNetDevice)) {
                t = next;
                break;
            }
        }
        return (StarryNetDevice) t;
    }

    @Deprecated(message = "废弃", replaceWith = @ReplaceWith(expression = "getConnectXrDevice()", imports = {}))
    @Nullable
    public final StarryNetDevice getConnectDevice() {
        return getConnectXrDevice();
    }

    @Nullable
    public final StarryNetDevice getConnectXrDevice() {
        StarryNetDevice connectedDevice;
        OperatorManager operatorManager2 = this.operatorManager;
        StarryNetDeviceOperator deviceOperator = operatorManager2 != null ? operatorManager2.getDeviceOperator() : null;
        if (deviceOperator == null) {
            CommonExtKt.d("getConnectXrDevice, deviceOperator is null", TAG, (Throwable) null, 2, (Object) null);
        }
        if (deviceOperator == null || (connectedDevice = deviceOperator.getConnectedDevice()) == null || !StarryNetDeviceExt.isXrDevice(connectedDevice)) {
            return null;
        }
        return connectedDevice;
    }

    @NotNull
    public final String getConnectedDeviceType() {
        StarryNetDevice connectXrDevice = getConnectXrDevice();
        return (connectXrDevice == null || !isAirGlass(connectXrDevice)) ? Constants.GLASS_DEVICE_STAR : "star air";
    }

    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    @NotNull
    public final LiveData<Long> getImpatientTiciData() {
        return this.impatientTiciData;
    }

    @NotNull
    public final SharedFlow<OpenTiciResult> getOpenTiciResultFlow() {
        return this.openTiciResultFlow;
    }

    @NotNull
    public final ReceiveMsgHandler getReceiveMsgHandler() {
        return this.msgHandler;
    }

    public final void handleGlassesTiciQuit$ar_tici_release() {
        CommonExtKt.e("handleGlassesTiciQuit", TAG);
        cancelPendingJob();
        dispatchOpenTiciResult(ConstantsKt.b());
    }

    public final void handleOpenResult$ar_tici_release(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "msgId");
        OpenTiciConfig openTiciConfig = this.waitingTiciConfig;
        boolean areEqual = openTiciConfig != null ? Intrinsics.areEqual((Object) OpenTiciConfigKt.c(openTiciConfig), (Object) str) : false;
        CommonExtKt.e("handleOpenResult, msgId: " + str + ", exist: " + areEqual, TAG);
        if (areEqual) {
            cancelPendingJob();
            dispatchOpenTiciResult(ConstantsKt.g());
        }
    }

    public final boolean isAirGlass(@NotNull StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        String modelId = starryNetDevice.getModelId();
        Intrinsics.checkNotNullExpressionValue(modelId, "getModelId(...)");
        return ModelIdExtKt.a(modelId);
    }

    public final boolean isStarOrConceptGlass(@NotNull StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        String modelId = starryNetDevice.getModelId();
        return Intrinsics.areEqual((Object) modelId, (Object) "1001") || Intrinsics.areEqual((Object) modelId, (Object) "1002");
    }

    public final boolean isWaitingTici() {
        return this.waitingTiciConfig != null;
    }

    public void onDeviceConnected(@Nullable StarryNetDevice starryNetDevice) {
        CommonExtKt.e("onDeviceConnected-> device: " + starryNetDevice, TAG);
        if (starryNetDevice != null && true == StarryNetDeviceExt.isXrDevice(starryNetDevice)) {
            this.isConnected = true;
            dispatchDeviceConnect(new TiciStarryMsgManager$onDeviceConnected$1(starryNetDevice));
            sendCheckTiciStateMsg();
        }
    }

    public void onDeviceDisconnected(@Nullable StarryNetDevice starryNetDevice) {
        CommonExtKt.e("onDeviceDisconnected-> device: " + starryNetDevice, TAG);
        if (starryNetDevice != null && true == StarryNetDeviceExt.isXrDevice(starryNetDevice)) {
            this.isConnected = false;
            dispatchDeviceConnect(new TiciStarryMsgManager$onDeviceDisconnected$1(starryNetDevice));
            cancelPendingJob();
            dispatchOpenTiciResult(ConstantsKt.c());
        }
    }

    public final void registerDeviceConnectListener(@NotNull DeviceConnectionListener deviceConnectionListener) {
        Intrinsics.checkNotNullParameter(deviceConnectionListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.connectionListeners.add(deviceConnectionListener);
    }

    public final void sendAutoTiciState(boolean z) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(WebJs.ACTION, BaseActionMsg.MSG_AUTO_TICI_RUNNING);
        jSONObject.put(AccountConstantKt.RESPONSE_VALUE, new AutoTiciRunningMsg(z, false).toJsonString());
        sendTiciActionMsg(jSONObject);
    }

    public final void sendChangeTiciMode(@NotNull ChangeTiciModeMsg changeTiciModeMsg) {
        Intrinsics.checkNotNullParameter(changeTiciModeMsg, "ticiModeMsg");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(WebJs.ACTION, BaseActionMsg.MSG_CHANGE_TICI_MODE);
        jSONObject.put(AccountConstantKt.RESPONSE_VALUE, changeTiciModeMsg.toJsonString());
        sendTiciActionMsg(jSONObject);
    }

    public final void sendCheckTiciStateMsg() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(WebJs.ACTION, BaseActionMsg.MSG_CHECK_TICI_STATE);
        jSONObject.put(AccountConstantKt.RESPONSE_VALUE, new CheckTiciStateMsg().toJsonString());
        sendTiciActionMsg(jSONObject);
    }

    public final void sendHighlightMsg(int i, @Nullable String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(WebJs.ACTION, BaseActionMsg.MSG_HIGHLIGHT_INDEX);
        jSONObject.put(AccountConstantKt.RESPONSE_VALUE, new HighlightMsg(i, str).toJsonString());
        sendTiciActionMsg(jSONObject);
    }

    public final void sendOpenAppMsg(@NotNull TiciEntity ticiEntity, @NotNull TiciContentPart ticiContentPart, int i, int i2, boolean z, int i3, int i4, @NotNull OpenTiciFrom openTiciFrom, long j) {
        Intrinsics.checkNotNullParameter(ticiEntity, "ticiEntity");
        Intrinsics.checkNotNullParameter(ticiContentPart, "ticiContentPart");
        Intrinsics.checkNotNullParameter(openTiciFrom, "from");
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        int j2 = SpUtilKt.j();
        long k = SpUtilKt.k();
        boolean b = SpUtilKt.b();
        int h = SpUtilKt.h();
        int i5 = z ? 3 : 2;
        String a2 = TiciEntityKt.a(ticiEntity);
        int totalPage = ticiEntity.getTotalPage();
        int totalTextLength = ticiEntity.getTotalTextLength();
        int contentOffsetStart = ticiContentPart.getContentOffsetStart();
        Boolean valueOf = Boolean.valueOf(b);
        Integer valueOf2 = Integer.valueOf(h);
        Integer valueOf3 = Integer.valueOf(totalPage);
        Integer valueOf4 = Integer.valueOf(totalTextLength);
        OpenTiciMsg openTiciMsg = r9;
        OpenTiciMsg openTiciMsg2 = new OpenTiciMsg(a2, uuid, i2, j2, k, valueOf, valueOf2, i5, valueOf3, valueOf4, i, contentOffsetStart, i3, i4);
        String contentText = ticiContentPart.getContentText();
        if (SdkContext.f6675a.c().e()) {
            byte[] bytes = ticiContentPart.getContentText().getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            byte[] transform = NativeLib.transform(bytes);
            Intrinsics.checkNotNullExpressionValue(transform, "transform(...)");
            Charset defaultCharset = Charset.defaultCharset();
            Intrinsics.checkNotNullExpressionValue(defaultCharset, "defaultCharset(...)");
            contentText = new String(transform, defaultCharset);
        }
        int a3 = StringExtKt.a(contentText);
        int ceil = (int) ((float) Math.ceil((double) (((float) contentText.length()) / 10240.0f)));
        openTiciMsg.setTotalPart(ceil);
        openTiciMsg.setSourceByteSize(a3);
        OpenTiciMsg openTiciMsg3 = openTiciMsg;
        this.waitingTiciConfig = new OpenTiciConfig(openTiciMsg, ticiEntity, ticiContentPart, i, i2, openTiciFrom);
        long min = Math.min(MAX_TIME_OUT, Math.max(30000, ((long) ceil) * SINGLE_PART_TIME));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(WebJs.ACTION, DDAuthConstant.AUTH_LOGIN_TYPE_APP);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("launchMode", FastRecordMainViewModel.RECORD_TYPE_SCENE);
        jSONObject2.put(WebJs.ACTION, "open_app");
        jSONObject2.put(AccountConstantKt.REQUEST_HEADER_PKG, "com.upuphone.ar.tici");
        jSONObject2.put("app_name", "com.upuphone.ar.tici");
        jSONObject2.put("ext", openTiciMsg3.toJsonString());
        Unit unit = Unit.INSTANCE;
        jSONObject.put("data", jSONObject2);
        String jSONObject3 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "toString(...)");
        sendOpenAppMsgAndWait(jSONObject3, openTiciMsg3.getMsgId(), min);
        waitForGlassTiciStarted(j);
        startImpatientTiciCount$default(this, 0, 1, (Object) null);
    }

    public final void sendStarryMessage$ar_tici_release(@NotNull String str, @Nullable String str2, @Nullable SendMessageListener sendMessageListener) {
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        StarryNetMessage starryNetMessage = new StarryNetMessage();
        if (str2 == null) {
            str2 = UUID.randomUUID().toString();
        }
        starryNetMessage.setId(str2);
        starryNetMessage.setMessage(str);
        starryNetMessage.setReceiverPkg("com.upuphone.star.launcher");
        CommonExtKt.e("sendStarryMessage-> " + str, TAG);
        if (sendMessageListener == null) {
            sendMessageListener = new TiciStarryMsgManager$sendStarryMessage$messageListener$1();
        }
        OperatorManager operatorManager2 = this.operatorManager;
        StarryNetMessageOperator messageOperator = operatorManager2 != null ? operatorManager2.getMessageOperator() : null;
        if (messageOperator == null) {
            CommonExtKt.d("sendStarryMessage, messageOperator is null", TAG, (Throwable) null, 2, (Object) null);
        }
        Job unused = BuildersKt__Builders_commonKt.d(this, Dispatchers.b(), (CoroutineStart) null, new TiciStarryMsgManager$sendStarryMessage$1(messageOperator, starryNetMessage, sendMessageListener, (Continuation<? super TiciStarryMsgManager$sendStarryMessage$1>) null), 2, (Object) null);
    }

    @Deprecated(message = "已废弃，未使用")
    public final void sendTiciContentPage(@NotNull TiciEntity ticiEntity, @NotNull TiciContentPart ticiContentPart, int i, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(ticiEntity, "ticiEntity");
        Intrinsics.checkNotNullParameter(ticiContentPart, "contentPart");
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new TiciStarryMsgManager$sendTiciContentPage$1(ticiContentPart, ticiEntity, num, i, this, (Continuation<? super TiciStarryMsgManager$sendTiciContentPage$1>) null), 3, (Object) null);
    }

    public final void startImpatientTiciCount(long j) {
        CommonExtKt.e("startImpatientTiciCount, waitTime: " + j, TAG);
        Job job = this.impatientTiciJob;
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        this.impatientTiciJob = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new TiciStarryMsgManager$startImpatientTiciCount$1(this, j, (Continuation<? super TiciStarryMsgManager$startImpatientTiciCount$1>) null), 3, (Object) null);
    }

    public final void unregisterDeviceConnectListener(@NotNull DeviceConnectionListener deviceConnectionListener) {
        Intrinsics.checkNotNullParameter(deviceConnectionListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.connectionListeners.remove(deviceConnectionListener);
    }

    @Nullable
    public final Object waitUntilConnected(@NotNull Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.x();
        TiciStarryMsgManager$waitUntilConnected$2$connectListener$1 ticiStarryMsgManager$waitUntilConnected$2$connectListener$1 = new TiciStarryMsgManager$waitUntilConnected$2$connectListener$1(cancellableContinuationImpl);
        cancellableContinuationImpl.E(new TiciStarryMsgManager$waitUntilConnected$2$1(this, ticiStarryMsgManager$waitUntilConnected$2$connectListener$1));
        registerDeviceConnectListener(ticiStarryMsgManager$waitUntilConnected$2$connectListener$1);
        Object u = cancellableContinuationImpl.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? u : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void dispatchOpenTiciResult(int i) {
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new TiciStarryMsgManager$dispatchOpenTiciResult$2(this, i, (Continuation<? super TiciStarryMsgManager$dispatchOpenTiciResult$2>) null), 3, (Object) null);
    }

    public final void sendHighlightMsg(@NotNull HighlightMsgV3 highlightMsgV3) {
        Intrinsics.checkNotNullParameter(highlightMsgV3, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(WebJs.ACTION, BaseActionMsg.MSG_HIGHLIGHT_INDEX_V3);
        jSONObject.put(AccountConstantKt.RESPONSE_VALUE, highlightMsgV3.toJsonString());
        sendTiciActionMsg(jSONObject);
    }
}
