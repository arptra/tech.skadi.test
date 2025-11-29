package com.upuphone.ar.fastrecord.phone.starrynet;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.honey.account.t3.a;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.listener.RecordOnInterConnectMsgListener;
import com.upuphone.ar.fastrecord.phone.starrynet.bean.RecordInterConnectMessage;
import com.upuphone.ar.fastrecord.phone.utils.RecordDataSaveUtil;
import com.upuphone.ar.shorthand.phone.utils.RecordGsonUtils;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.xr.interconnect.SuperAppServiceManager;
import com.upuphone.xr.interconnect.api.InfoOperator;
import com.upuphone.xr.interconnect.api.NaviAbilityOperator;
import com.upuphone.xr.interconnect.api.OperatorManager;
import com.upuphone.xr.interconnect.api.SappAbilityOperator;
import com.upuphone.xr.interconnect.api.StarryNetDeviceOperator;
import com.upuphone.xr.interconnect.api.StarryNetMessageOperator;
import com.upuphone.xr.interconnect.api.info.InfoEndpoint;
import com.upuphone.xr.interconnect.api.info.PeerInfoOperator;
import com.upuphone.xr.interconnect.common.IAIModelResult;
import com.upuphone.xr.interconnect.entity.NaviLocationInfo;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.listener.DeviceConnectionListener;
import com.upuphone.xr.interconnect.listener.MessageReceiver;
import com.upuphone.xr.interconnect.listener.NaviLocationCallback;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.interconnect.util.StarryNetDeviceExt;
import com.upuphone.xr.sapp.context.SdkContext;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 I2\u00020\u0001:\u0002IJB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010%\u001a\u00020&J\n\u0010'\u001a\u0004\u0018\u00010(H\u0002J\b\u0010)\u001a\u0004\u0018\u00010\u0006J\b\u0010*\u001a\u0004\u0018\u00010\u001dJ\"\u0010+\u001a\u00020&2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u0015J\u0016\u00100\u001a\u00020&2\u0006\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u0015J\u0006\u00101\u001a\u00020\u0012J\u0006\u00102\u001a\u00020\u0012J\u000e\u00103\u001a\u00020&2\u0006\u00104\u001a\u00020\bJ\u000e\u00105\u001a\u00020&2\u0006\u00104\u001a\u00020\bJ\u000e\u00106\u001a\u00020&2\u0006\u00107\u001a\u000208J\u0006\u00109\u001a\u00020&J\u000e\u0010:\u001a\u00020&2\u0006\u0010;\u001a\u00020<J\u0016\u0010:\u001a\u00020&2\u0006\u0010;\u001a\u00020<2\u0006\u00104\u001a\u00020\u001fJ$\u0010:\u001a\u00020&2\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u001fJ\u0006\u0010?\u001a\u00020&J\b\u0010@\u001a\u00020&H\u0002J\b\u0010A\u001a\u00020&H\u0002J-\u0010B\u001a\u00020&2#\u0010C\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b(G\u0012\u0004\u0012\u00020&\u0018\u00010DH\u0002J\u000e\u0010H\u001a\u00020&2\u0006\u00107\u001a\u00020\u001bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00150\"j\b\u0012\u0004\u0012\u00020\u0015`#X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/starrynet/RecordConnectManager;", "", "()V", "checkLocationJob", "Lkotlinx/coroutines/Job;", "location", "Lcom/upuphone/xr/interconnect/entity/NaviLocationInfo;", "mConnectMsgReceiver", "Lcom/upuphone/ar/fastrecord/phone/listener/RecordOnInterConnectMsgListener;", "mDeviceConnectionListener", "Lcom/upuphone/xr/interconnect/listener/DeviceConnectionListener;", "mDeviceOperator", "Lcom/upuphone/xr/interconnect/api/StarryNetDeviceOperator;", "mGlassVersion", "", "mInfoOperator", "Lcom/upuphone/xr/interconnect/api/InfoOperator;", "mIsDeviceConnected", "", "mIsInit", "mModuleIdentifier", "", "mMsgOperator", "Lcom/upuphone/xr/interconnect/api/StarryNetMessageOperator;", "mMsgReceiver", "Lcom/upuphone/xr/interconnect/listener/MessageReceiver;", "mNaviLocationCallback", "Lcom/upuphone/xr/interconnect/listener/NaviLocationCallback;", "mOperatorManager", "Lcom/upuphone/xr/interconnect/api/OperatorManager;", "mSendMsgListener", "Lcom/upuphone/xr/interconnect/listener/SendMessageListener;", "mTargetPkg", "permissionList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "remoteAppDieListener", "cacheAudioAmplitudeWhenPause", "", "getBondedXrDevice", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "getLocation", "getOperatorManager", "init", "context", "Landroid/content/Context;", "moduleIdentifier", "targetPkg", "initForCallback", "isDeviceConnected", "isInit", "registerInterConnectMsgListener", "listener", "registerRemoteAppDieListener", "requestAIState", "callback", "Lcom/upuphone/xr/interconnect/common/IAIModelResult;", "requestPermission", "sendMessage", "message", "Lcom/upuphone/ar/fastrecord/phone/starrynet/bean/RecordInterConnectMessage;", "bytes", "", "setStopVoiceState", "startCheckLocationJob", "startLocation", "startLocationCallBack", "hasGetLocationCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "locationInfo", "stopLocation", "Companion", "SingleHolder", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRecordConnectManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecordConnectManager.kt\ncom/upuphone/ar/fastrecord/phone/starrynet/RecordConnectManager\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,517:1\n37#2,2:518\n1855#3,2:520\n*S KotlinDebug\n*F\n+ 1 RecordConnectManager.kt\ncom/upuphone/ar/fastrecord/phone/starrynet/RecordConnectManager\n*L\n249#1:518,2\n469#1:520,2\n*E\n"})
public final class RecordConnectManager {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long DELAY_GET_LOCATION = 5000;
    @NotNull
    private static final String TAG = "FastRecordInterConnectHelper";
    /* access modifiers changed from: private */
    @Nullable
    public Job checkLocationJob;
    /* access modifiers changed from: private */
    @Nullable
    public NaviLocationInfo location;
    /* access modifiers changed from: private */
    @Nullable
    public RecordOnInterConnectMsgListener mConnectMsgReceiver;
    @NotNull
    private final DeviceConnectionListener mDeviceConnectionListener;
    @Nullable
    private StarryNetDeviceOperator mDeviceOperator;
    /* access modifiers changed from: private */
    public int mGlassVersion;
    @Nullable
    private InfoOperator mInfoOperator;
    /* access modifiers changed from: private */
    public boolean mIsDeviceConnected;
    private boolean mIsInit;
    @Nullable
    private String mModuleIdentifier;
    @Nullable
    private StarryNetMessageOperator mMsgOperator;
    @NotNull
    private final MessageReceiver mMsgReceiver;
    /* access modifiers changed from: private */
    @Nullable
    public NaviLocationCallback mNaviLocationCallback;
    @Nullable
    private OperatorManager mOperatorManager;
    @NotNull
    private final SendMessageListener mSendMsgListener;
    @Nullable
    private String mTargetPkg;
    @NotNull
    private final ArrayList<String> permissionList;
    @Nullable
    private RecordOnInterConnectMsgListener remoteAppDieListener;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/starrynet/RecordConnectManager$Companion;", "", "()V", "DELAY_GET_LOCATION", "", "TAG", "", "getInstance", "Lcom/upuphone/ar/fastrecord/phone/starrynet/RecordConnectManager;", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final RecordConnectManager getInstance() {
            return SingleHolder.INSTANCE.getHolder();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/starrynet/RecordConnectManager$SingleHolder;", "", "()V", "holder", "Lcom/upuphone/ar/fastrecord/phone/starrynet/RecordConnectManager;", "getHolder", "()Lcom/upuphone/ar/fastrecord/phone/starrynet/RecordConnectManager;", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SingleHolder {
        @NotNull
        public static final SingleHolder INSTANCE = new SingleHolder();
        @NotNull
        private static final RecordConnectManager holder = new RecordConnectManager((DefaultConstructorMarker) null);

        private SingleHolder() {
        }

        @NotNull
        public final RecordConnectManager getHolder() {
            return holder;
        }
    }

    public /* synthetic */ RecordConnectManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final StarryNetDevice getBondedXrDevice() {
        StarryNetDeviceOperator starryNetDeviceOperator = this.mDeviceOperator;
        List<StarryNetDevice> bondedDevices = starryNetDeviceOperator != null ? starryNetDeviceOperator.getBondedDevices() : null;
        if (bondedDevices != null && !bondedDevices.isEmpty()) {
            for (StarryNetDevice starryNetDevice : bondedDevices) {
                Intrinsics.checkNotNull(starryNetDevice);
                if (StarryNetDeviceExt.isXrDevice(starryNetDevice)) {
                    return starryNetDevice;
                }
            }
        }
        return null;
    }

    @JvmStatic
    @NotNull
    public static final RecordConnectManager getInstance() {
        return Companion.getInstance();
    }

    public static /* synthetic */ void init$default(RecordConnectManager recordConnectManager, Context context, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            context = null;
        }
        recordConnectManager.init(context, str, str2);
    }

    /* access modifiers changed from: private */
    public static final void initForCallback$lambda$2(RecordConnectManager recordConnectManager, OperatorManager operatorManager) {
        PeerInfoOperator peer;
        InfoEndpoint<Integer> version;
        StarryNetDevice connectedDevice;
        Intrinsics.checkNotNullParameter(recordConnectManager, "this$0");
        Intrinsics.checkNotNullParameter(operatorManager, "operatorManager");
        recordConnectManager.mOperatorManager = operatorManager;
        LogExt.logE("SuperAppServiceManager#init-sender, operatorManager: " + operatorManager, TAG);
        OperatorManager operatorManager2 = recordConnectManager.mOperatorManager;
        InfoOperator infoOperator = null;
        recordConnectManager.mMsgOperator = operatorManager2 != null ? operatorManager2.getMessageOperator() : null;
        OperatorManager operatorManager3 = recordConnectManager.mOperatorManager;
        recordConnectManager.mDeviceOperator = operatorManager3 != null ? operatorManager3.getDeviceOperator() : null;
        OperatorManager operatorManager4 = recordConnectManager.mOperatorManager;
        if (operatorManager4 != null) {
            infoOperator = operatorManager4.getInfoOperator();
        }
        recordConnectManager.mInfoOperator = infoOperator;
        OperatorManager operatorManager5 = recordConnectManager.mOperatorManager;
        StarryNetMessageOperator starryNetMessageOperator = recordConnectManager.mMsgOperator;
        StarryNetDeviceOperator starryNetDeviceOperator = recordConnectManager.mDeviceOperator;
        LogExt.logI("init:: mOperatorManager=" + operatorManager5 + ", mMsgOperator=" + starryNetMessageOperator + ", mDeviceOperator=" + starryNetDeviceOperator + ", mInfoOperator=" + infoOperator, TAG);
        StarryNetDeviceOperator starryNetDeviceOperator2 = recordConnectManager.mDeviceOperator;
        if (!(starryNetDeviceOperator2 == null || (connectedDevice = starryNetDeviceOperator2.getConnectedDevice()) == null || !StarryNetDeviceExt.isXrDevice(connectedDevice))) {
            LogExt.logI("init 眼镜和手机设备连接成功=" + connectedDevice, TAG);
            recordConnectManager.mIsDeviceConnected = true;
        }
        InfoOperator infoOperator2 = recordConnectManager.mInfoOperator;
        if (!(infoOperator2 == null || (peer = infoOperator2.getPeer()) == null || (version = peer.getVersion()) == null)) {
            version.subscribe(new RecordConnectManager$initForCallback$1$2(recordConnectManager));
        }
        StarryNetMessageOperator starryNetMessageOperator2 = recordConnectManager.mMsgOperator;
        if (starryNetMessageOperator2 != null) {
            starryNetMessageOperator2.registerMessageReceiver(recordConnectManager.mMsgReceiver);
        }
        StarryNetDeviceOperator starryNetDeviceOperator3 = recordConnectManager.mDeviceOperator;
        if (starryNetDeviceOperator3 != null) {
            starryNetDeviceOperator3.registerDeviceConnectionListener(recordConnectManager.mDeviceConnectionListener);
        }
        recordConnectManager.mIsInit = true;
        recordConnectManager.startCheckLocationJob();
    }

    public static /* synthetic */ void sendMessage$default(RecordConnectManager recordConnectManager, RecordInterConnectMessage recordInterConnectMessage, byte[] bArr, SendMessageListener sendMessageListener, int i, Object obj) {
        if ((i & 4) != 0) {
            sendMessageListener = null;
        }
        recordConnectManager.sendMessage(recordInterConnectMessage, bArr, sendMessageListener);
    }

    private final void startCheckLocationJob() {
        NaviLocationInfo naviLocationInfo = this.location;
        Double d = null;
        if (naviLocationInfo == null) {
            Job job = this.checkLocationJob;
            if (job != null) {
                Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
            }
            LogExt.logW("null == checkLocation start delay check", TAG);
            this.checkLocationJob = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new RecordConnectManager$startCheckLocationJob$1(this, (Continuation<? super RecordConnectManager$startCheckLocationJob$1>) null), 3, (Object) null);
            return;
        }
        String address = naviLocationInfo != null ? naviLocationInfo.getAddress() : null;
        NaviLocationInfo naviLocationInfo2 = this.location;
        String city = naviLocationInfo2 != null ? naviLocationInfo2.getCity() : null;
        NaviLocationInfo naviLocationInfo3 = this.location;
        String cityCode = naviLocationInfo3 != null ? naviLocationInfo3.getCityCode() : null;
        NaviLocationInfo naviLocationInfo4 = this.location;
        String district = naviLocationInfo4 != null ? naviLocationInfo4.getDistrict() : null;
        NaviLocationInfo naviLocationInfo5 = this.location;
        String district2 = naviLocationInfo5 != null ? naviLocationInfo5.getDistrict() : null;
        NaviLocationInfo naviLocationInfo6 = this.location;
        String poiName = naviLocationInfo6 != null ? naviLocationInfo6.getPoiName() : null;
        NaviLocationInfo naviLocationInfo7 = this.location;
        String street = naviLocationInfo7 != null ? naviLocationInfo7.getStreet() : null;
        NaviLocationInfo naviLocationInfo8 = this.location;
        String province = naviLocationInfo8 != null ? naviLocationInfo8.getProvince() : null;
        NaviLocationInfo naviLocationInfo9 = this.location;
        Double valueOf = naviLocationInfo9 != null ? Double.valueOf(naviLocationInfo9.getLatitude()) : null;
        NaviLocationInfo naviLocationInfo10 = this.location;
        if (naviLocationInfo10 != null) {
            d = Double.valueOf(naviLocationInfo10.getLongitude());
        }
        LogExt.logI("定位获取成功--address:" + address + ",city = " + city + ",cityCode = " + cityCode + ",district = " + district + ",district = " + district2 + ",poiName = " + poiName + ",street = " + street + ",province = " + province + "latitude:" + valueOf + " ,longitude:" + d, TAG);
    }

    /* access modifiers changed from: private */
    public final void startLocation() {
        if (this.location == null) {
            LogExt.logW("null == location startLocation", TAG);
            startLocationCallBack(new RecordConnectManager$startLocation$1(this));
        }
    }

    private final void startLocationCallBack(Function1<? super NaviLocationInfo, Unit> function1) {
        OperatorManager operatorManager;
        NaviAbilityOperator naviAbilityOperator;
        if (this.mNaviLocationCallback == null) {
            this.mNaviLocationCallback = new RecordConnectManager$startLocationCallBack$1(this, function1);
        }
        OperatorManager operatorManager2 = this.mOperatorManager;
        boolean z = (operatorManager2 != null ? operatorManager2.getNaviAbilityOperator() : null) != null;
        LogExt.logW("mOperatorManager?.naviAbilityOperator? != null is " + z, TAG);
        boolean a2 = SdkContext.f6675a.f().a((String[]) this.permissionList.toArray(new String[0]));
        LogExt.logE("startLocationCallBack permissionState = " + a2, TAG);
        if (a2 && (operatorManager = this.mOperatorManager) != null && (naviAbilityOperator = operatorManager.getNaviAbilityOperator()) != null) {
            naviAbilityOperator.startLocation(this.mNaviLocationCallback);
        }
    }

    public final void cacheAudioAmplitudeWhenPause() {
        FastRecordManager.Companion companion = FastRecordManager.Companion;
        int recordIngState = companion.getInstance().appViewModel().getRecordIngState();
        long recordIngId = companion.getInstance().appViewModel().getRecordIngId();
        LogExt.logW("cacheAudioAmplitudeWhenPause cur state = " + recordIngState + ",recordId = " + recordIngId, TAG);
        StringBuilder sb = new StringBuilder();
        sb.append("is  state = ");
        sb.append(recordIngState);
        sb.append(" cache amplitude");
        LogExt.logW(sb.toString(), TAG);
        RecordDataSaveUtil recordDataSaveUtil = RecordDataSaveUtil.INSTANCE;
        recordDataSaveUtil.saveAmpData(recordIngId);
        recordDataSaveUtil.setNeedToDetailAfterConnect(recordIngId);
    }

    @Nullable
    public final NaviLocationInfo getLocation() {
        return this.location;
    }

    @Nullable
    public final OperatorManager getOperatorManager() {
        return this.mOperatorManager;
    }

    public final void init(@Nullable Context context, @NotNull String str, @NotNull String str2) {
        PeerInfoOperator peer;
        InfoEndpoint<Integer> version;
        StarryNetDevice connectedDevice;
        Intrinsics.checkNotNullParameter(str, "moduleIdentifier");
        Intrinsics.checkNotNullParameter(str2, "targetPkg");
        this.mModuleIdentifier = str;
        this.mTargetPkg = str2;
        OperatorManager init = context == null ? SuperAppServiceManager.getInstance().init(str) : SuperAppServiceManager.getInstance().init(context, new RecordConnectManager$init$1(), 1);
        this.mOperatorManager = init;
        InfoOperator infoOperator = null;
        this.mMsgOperator = init != null ? init.getMessageOperator() : null;
        OperatorManager operatorManager = this.mOperatorManager;
        this.mDeviceOperator = operatorManager != null ? operatorManager.getDeviceOperator() : null;
        OperatorManager operatorManager2 = this.mOperatorManager;
        if (operatorManager2 != null) {
            infoOperator = operatorManager2.getInfoOperator();
        }
        this.mInfoOperator = infoOperator;
        OperatorManager operatorManager3 = this.mOperatorManager;
        StarryNetMessageOperator starryNetMessageOperator = this.mMsgOperator;
        StarryNetDeviceOperator starryNetDeviceOperator = this.mDeviceOperator;
        LogExt.logI("init:: mOperatorManager=" + operatorManager3 + ", mMsgOperator=" + starryNetMessageOperator + ", mDeviceOperator=" + starryNetDeviceOperator + ", mInfoOperator=" + infoOperator, TAG);
        StarryNetDeviceOperator starryNetDeviceOperator2 = this.mDeviceOperator;
        if (!(starryNetDeviceOperator2 == null || (connectedDevice = starryNetDeviceOperator2.getConnectedDevice()) == null || !StarryNetDeviceExt.isXrDevice(connectedDevice))) {
            LogExt.logI("init 眼镜和手机设备连接成功=" + connectedDevice, TAG);
            this.mIsDeviceConnected = true;
        }
        InfoOperator infoOperator2 = this.mInfoOperator;
        if (!(infoOperator2 == null || (peer = infoOperator2.getPeer()) == null || (version = peer.getVersion()) == null)) {
            version.subscribe(new RecordConnectManager$init$3(this));
        }
        StarryNetMessageOperator starryNetMessageOperator2 = this.mMsgOperator;
        if (starryNetMessageOperator2 != null) {
            starryNetMessageOperator2.registerMessageReceiver(this.mMsgReceiver);
        }
        StarryNetDeviceOperator starryNetDeviceOperator3 = this.mDeviceOperator;
        if (starryNetDeviceOperator3 != null) {
            starryNetDeviceOperator3.registerDeviceConnectionListener(this.mDeviceConnectionListener);
        }
        this.mIsInit = true;
        startCheckLocationJob();
    }

    public final void initForCallback(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "moduleIdentifier");
        Intrinsics.checkNotNullParameter(str2, "targetPkg");
        this.mModuleIdentifier = str;
        this.mTargetPkg = str2;
        SuperAppServiceManager.getInstance().init(str, new a(this));
    }

    public final boolean isDeviceConnected() {
        return this.mIsDeviceConnected;
    }

    public final boolean isInit() {
        if (this.mIsInit) {
            return true;
        }
        LogExt.logI("必须初始化互联通道，请先调用init()进行初始化！", TAG);
        return false;
    }

    public final void registerInterConnectMsgListener(@NotNull RecordOnInterConnectMsgListener recordOnInterConnectMsgListener) {
        Intrinsics.checkNotNullParameter(recordOnInterConnectMsgListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.mConnectMsgReceiver = recordOnInterConnectMsgListener;
    }

    public final void registerRemoteAppDieListener(@NotNull RecordOnInterConnectMsgListener recordOnInterConnectMsgListener) {
        Intrinsics.checkNotNullParameter(recordOnInterConnectMsgListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.remoteAppDieListener = recordOnInterConnectMsgListener;
    }

    public final void requestAIState(@NotNull IAIModelResult iAIModelResult) {
        Intrinsics.checkNotNullParameter(iAIModelResult, "callback");
        OperatorManager operatorManager = this.mOperatorManager;
        Unit unit = null;
        if (operatorManager != null) {
            SappAbilityOperator sappAbilityOperator = operatorManager.getSappAbilityOperator();
            if (sappAbilityOperator != null) {
                sappAbilityOperator.requestAIState(iAIModelResult);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                LogExt.logE("requestAIState AbilityOperator is null.", TAG);
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            LogExt.logE("requestAIState Enter! mOperatorManager is null.", TAG);
        }
    }

    public final void requestPermission() {
        OperatorManager operatorManager = this.mOperatorManager;
        Unit unit = null;
        if (operatorManager != null) {
            SappAbilityOperator sappAbilityOperator = operatorManager.getSappAbilityOperator();
            if (sappAbilityOperator != null) {
                sappAbilityOperator.requestPermission(CollectionsKt.listOf("permission_ai_model"), new RecordConnectManager$requestPermission$1$1());
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                LogExt.logE("requestPermission AbilityOperator is null.", TAG);
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            LogExt.logE("requestPermission permission operatorManager is null!", TAG);
        }
    }

    public final void sendMessage(@NotNull RecordInterConnectMessage recordInterConnectMessage) {
        Intrinsics.checkNotNullParameter(recordInterConnectMessage, "message");
        boolean z = this.mIsDeviceConnected;
        LogExt.logW("sendMessage mIsDeviceConnected = " + z, TAG);
        if (this.mIsDeviceConnected) {
            sendMessage$default(this, recordInterConnectMessage, (byte[]) null, (SendMessageListener) null, 4, (Object) null);
            return;
        }
        UToast.Companion companion = UToast.f6444a;
        FastRecordManager.Companion companion2 = FastRecordManager.Companion;
        Context appContext = companion2.getInstance().appContext();
        String string = companion2.getInstance().appContext().getString(R.string.fast_record_starrynet_can_not_use);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.d(appContext, string);
    }

    public final void setStopVoiceState() {
        FastRecordManager.Companion companion = FastRecordManager.Companion;
        long recordIngId = companion.getInstance().appViewModel().getRecordIngId();
        RecordDataSaveUtil.INSTANCE.checkRecordTimeAndSetFinishState(recordIngId, 2, new RecordConnectManager$setStopVoiceState$1(recordIngId, companion.getInstance().appViewModel().getRecordIngType()));
    }

    public final void stopLocation(@NotNull NaviLocationCallback naviLocationCallback) {
        NaviAbilityOperator naviAbilityOperator;
        Intrinsics.checkNotNullParameter(naviLocationCallback, "callback");
        OperatorManager operatorManager = this.mOperatorManager;
        if (operatorManager != null && (naviAbilityOperator = operatorManager.getNaviAbilityOperator()) != null) {
            naviAbilityOperator.stopLocation(naviLocationCallback);
        }
    }

    private RecordConnectManager() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
        arrayList.add("android.permission.ACCESS_FINE_LOCATION");
        this.permissionList = arrayList;
        this.mMsgReceiver = new RecordConnectManager$mMsgReceiver$1(this);
        this.mSendMsgListener = new RecordConnectManager$mSendMsgListener$1();
        this.mDeviceConnectionListener = new RecordConnectManager$mDeviceConnectionListener$1(this);
    }

    public final void sendMessage(@NotNull RecordInterConnectMessage recordInterConnectMessage, @NotNull SendMessageListener sendMessageListener) {
        Intrinsics.checkNotNullParameter(recordInterConnectMessage, "message");
        Intrinsics.checkNotNullParameter(sendMessageListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        sendMessage(recordInterConnectMessage, (byte[]) null, sendMessageListener);
    }

    public final void sendMessage(@NotNull RecordInterConnectMessage recordInterConnectMessage, @Nullable byte[] bArr, @Nullable SendMessageListener sendMessageListener) {
        Intrinsics.checkNotNullParameter(recordInterConnectMessage, "message");
        boolean z = false;
        if (!isInit()) {
            if (sendMessageListener == null) {
                z = true;
            }
            LogExt.logW("sendMessage is not init msg = " + recordInterConnectMessage + ",listener is null = " + z, TAG);
            return;
        }
        LogExt.logW("sendMessage msg = " + recordInterConnectMessage + ",listener is null = " + (sendMessageListener == null), TAG);
        StarryNetMessage starryNetMessage = new StarryNetMessage();
        starryNetMessage.setSenderPkg(this.mModuleIdentifier);
        starryNetMessage.setReceiverPkg(this.mTargetPkg);
        starryNetMessage.setMessage(RecordGsonUtils.b(recordInterConnectMessage));
        if (bArr != null) {
            if (bArr.length == 0) {
                z = true;
            }
            if (!z) {
                starryNetMessage.setData(bArr);
            }
        }
        StarryNetMessageOperator starryNetMessageOperator = this.mMsgOperator;
        if (starryNetMessageOperator != null) {
            starryNetMessageOperator.sendMessage2(starryNetMessage, sendMessageListener);
        }
    }
}
