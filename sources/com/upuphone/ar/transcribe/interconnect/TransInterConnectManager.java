package com.upuphone.ar.transcribe.interconnect;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.interconnect.entity.InterConnectDevice;
import com.upuphone.ar.transcribe.interconnect.entity.InterConnectDeviceExtKt;
import com.upuphone.ar.transcribe.interconnect.entity.InterConnectMessage;
import com.upuphone.ar.transcribe.interconnect.entity.OpenScene;
import com.upuphone.ar.transcribe.interconnect.listener.OnDeviceConnectedListener;
import com.upuphone.ar.transcribe.interconnect.listener.OnInterConnectMsgListener;
import com.upuphone.ar.transcribe.utils.JsonUtils;
import com.upuphone.xr.interconnect.SuperAppServiceManager;
import com.upuphone.xr.interconnect.api.InfoOperator;
import com.upuphone.xr.interconnect.api.NaviAbilityOperator;
import com.upuphone.xr.interconnect.api.OperatorManager;
import com.upuphone.xr.interconnect.api.SappAbilityOperator;
import com.upuphone.xr.interconnect.api.StarryNetDeviceInfoOperator;
import com.upuphone.xr.interconnect.api.StarryNetDeviceOperator;
import com.upuphone.xr.interconnect.api.StarryNetMessageOperator;
import com.upuphone.xr.interconnect.api.info.InfoEndpoint;
import com.upuphone.xr.interconnect.api.info.PeerInfoOperator;
import com.upuphone.xr.interconnect.entity.NaviLocationInfo;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.listener.DeviceConnectionListener;
import com.upuphone.xr.interconnect.listener.MessageReceiver;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.interconnect.util.StarryNetDeviceExt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\u0010!\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0002\u0001\u0018\u0000 '2\u00020\u0001:\u0004\u0001\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J)\u0010\f\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u0003J\u001f\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u0004¢\u0006\u0004\b#\u0010\u0003J\u0015\u0010$\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b$\u0010\"J\r\u0010%\u001a\u00020\u0004¢\u0006\u0004\b%\u0010\u0003J\u0015\u0010'\u001a\u00020\u00042\u0006\u0010 \u001a\u00020&¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u0019¢\u0006\u0004\b)\u0010\u001bJ\u000f\u0010+\u001a\u0004\u0018\u00010*¢\u0006\u0004\b+\u0010,J\r\u0010-\u001a\u00020\t¢\u0006\u0004\b-\u0010.J\r\u0010/\u001a\u00020\u0019¢\u0006\u0004\b/\u0010\u001bJ\r\u00100\u001a\u00020\u0019¢\u0006\u0004\b0\u0010\u001bJ\r\u00101\u001a\u00020\u0019¢\u0006\u0004\b1\u0010\u001bJ\r\u00102\u001a\u00020\u0019¢\u0006\u0004\b2\u0010\u001bJ\r\u00103\u001a\u00020\u0019¢\u0006\u0004\b3\u0010\u001bJ\r\u00105\u001a\u000204¢\u0006\u0004\b5\u00106J\u000f\u00108\u001a\u0004\u0018\u000107¢\u0006\u0004\b8\u00109J0\u0010?\u001a\u00020\u00042!\u0010>\u001a\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020\u00040:¢\u0006\u0004\b?\u0010@J\r\u0010A\u001a\u00020\u0004¢\u0006\u0004\bA\u0010\u0003R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010Y\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010\\\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010^\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b]\u0010[R\u0016\u0010a\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b_\u0010`R&\u0010f\u001a\u0014\u0012\u0004\u0012\u000204\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0c0b8\u0002X\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010h\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010gR\u0018\u0010j\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010iR\u0018\u0010k\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010gR\u0016\u0010l\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u0010`R\u0016\u0010m\u001a\u0002048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u0010%R\u0018\u0010o\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010nR\u0016\u0010p\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u0010`R\u0016\u0010s\u001a\u00020q8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u0010rR\u0016\u0010v\u001a\u00020t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u0010uR\u0018\u0010y\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010xR\u0014\u0010|\u001a\u00020z8\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010{R\u0014\u0010\u001a\u00020}8\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u0010~R\u0017\u0010\u0001\u001a\u00030\u00018\u0002X\u0004¢\u0006\u0007\n\u0005\b0\u0010\u0001R\u0017\u0010\u0001\u001a\u00030\u00018\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0017\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/upuphone/ar/transcribe/interconnect/TransInterConnectManager;", "", "<init>", "()V", "", "E", "F", "Landroid/content/Context;", "context", "", "moduleIdentifier", "targetPkg", "p", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "G", "Lcom/upuphone/ar/transcribe/interconnect/entity/InterConnectMessage;", "message", "", "bytes", "D", "(Lcom/upuphone/ar/transcribe/interconnect/entity/InterConnectMessage;[B)V", "Lcom/upuphone/ar/transcribe/interconnect/entity/OpenScene;", "openScene", "x", "(Lcom/upuphone/ar/transcribe/interconnect/entity/OpenScene;[B)V", "", "t", "()Z", "Lcom/upuphone/ar/transcribe/interconnect/entity/InterConnectDevice;", "k", "()Lcom/upuphone/ar/transcribe/interconnect/entity/InterConnectDevice;", "Lcom/upuphone/ar/transcribe/interconnect/listener/OnInterConnectMsgListener;", "listener", "z", "(Lcom/upuphone/ar/transcribe/interconnect/listener/OnInterConnectMsgListener;)V", "H", "A", "I", "Lcom/upuphone/ar/transcribe/interconnect/listener/OnDeviceConnectedListener;", "y", "(Lcom/upuphone/ar/transcribe/interconnect/listener/OnDeviceConnectedListener;)V", "u", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "l", "()Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "m", "()Ljava/lang/String;", "q", "w", "s", "v", "r", "", "n", "()I", "Lcom/upuphone/xr/interconnect/entity/NaviLocationInfo;", "o", "()Lcom/upuphone/xr/interconnect/entity/NaviLocationInfo;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isAgree", "callBack", "B", "(Lkotlin/jvm/functions/Function1;)V", "C", "Lcom/upuphone/xr/interconnect/api/OperatorManager;", "a", "Lcom/upuphone/xr/interconnect/api/OperatorManager;", "mOperatorManager", "Lcom/upuphone/xr/interconnect/api/StarryNetMessageOperator;", "b", "Lcom/upuphone/xr/interconnect/api/StarryNetMessageOperator;", "mMsgOperator", "Lcom/upuphone/xr/interconnect/api/StarryNetDeviceOperator;", "c", "Lcom/upuphone/xr/interconnect/api/StarryNetDeviceOperator;", "mDeviceOperator", "Lcom/upuphone/xr/interconnect/api/InfoOperator;", "d", "Lcom/upuphone/xr/interconnect/api/InfoOperator;", "mInfoOperator", "Lcom/upuphone/xr/interconnect/api/NaviAbilityOperator;", "e", "Lcom/upuphone/xr/interconnect/api/NaviAbilityOperator;", "mNavOperator", "Lcom/upuphone/xr/interconnect/api/StarryNetDeviceInfoOperator;", "f", "Lcom/upuphone/xr/interconnect/api/StarryNetDeviceInfoOperator;", "mDeviceInfoOperator", "g", "Ljava/lang/String;", "mModuleIdentifier", "h", "mTargetPkg", "i", "Z", "mIsInit", "", "", "j", "Ljava/util/Map;", "mInterConnectMap", "Lcom/upuphone/ar/transcribe/interconnect/listener/OnInterConnectMsgListener;", "remoteAppDieListener", "Lcom/upuphone/ar/transcribe/interconnect/listener/OnDeviceConnectedListener;", "mOnDeviceConnectedListener", "mConnectMsgReceiver", "mIsDeviceConnected", "mGlassVersion", "Lcom/upuphone/xr/interconnect/entity/NaviLocationInfo;", "mNaviLocationInfo", "mIsNeedLocation", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "mIoJob", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "mIoCoroutineScope", "Lcom/upuphone/xr/interconnect/api/SappAbilityOperator;", "Lcom/upuphone/xr/interconnect/api/SappAbilityOperator;", "mSappAbilityOperator", "Lcom/upuphone/xr/interconnect/listener/MessageReceiver;", "Lcom/upuphone/xr/interconnect/listener/MessageReceiver;", "mMsgReceiver", "Lcom/upuphone/xr/interconnect/listener/SendMessageListener;", "Lcom/upuphone/xr/interconnect/listener/SendMessageListener;", "mSendMsgListener", "Lcom/upuphone/xr/interconnect/listener/DeviceConnectionListener;", "Lcom/upuphone/xr/interconnect/listener/DeviceConnectionListener;", "mDeviceConnectionListener", "com/upuphone/ar/transcribe/interconnect/TransInterConnectManager$mNaviLocationCallback$1", "Lcom/upuphone/ar/transcribe/interconnect/TransInterConnectManager$mNaviLocationCallback$1;", "mNaviLocationCallback", "Companion", "SingleHolder", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTransInterConnectManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TransInterConnectManager.kt\ncom/upuphone/ar/transcribe/interconnect/TransInterConnectManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,611:1\n1855#2,2:612\n*S KotlinDebug\n*F\n+ 1 TransInterConnectManager.kt\ncom/upuphone/ar/transcribe/interconnect/TransInterConnectManager\n*L\n419#1:612,2\n*E\n"})
public final class TransInterConnectManager {
    public static final Companion y = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public OperatorManager f6067a;
    public StarryNetMessageOperator b;
    public StarryNetDeviceOperator c;
    public InfoOperator d;
    public NaviAbilityOperator e;
    public StarryNetDeviceInfoOperator f;
    public String g;
    public String h;
    public boolean i;
    public final Map j;
    public OnInterConnectMsgListener k;
    public OnDeviceConnectedListener l;
    public OnInterConnectMsgListener m;
    public boolean n;
    public int o;
    public NaviLocationInfo p;
    public boolean q;
    public Job r;
    public CoroutineScope s;
    public SappAbilityOperator t;
    public final MessageReceiver u;
    public final SendMessageListener v;
    public final DeviceConnectionListener w;
    public final TransInterConnectManager$mNaviLocationCallback$1 x;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\f\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00078\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/upuphone/ar/transcribe/interconnect/TransInterConnectManager$Companion;", "", "<init>", "()V", "Lcom/upuphone/ar/transcribe/interconnect/TransInterConnectManager;", "a", "()Lcom/upuphone/ar/transcribe/interconnect/TransInterConnectManager;", "", "PKG_MESSAGE_RECEIVER_LAUNCHER", "Ljava/lang/String;", "PKG_MESSAGE_SENDER_SYSTEM", "", "STARRY_DEVICE_RING", "B", "TAG", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TransInterConnectManager a() {
            return SingleHolder.f6068a.a();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/upuphone/ar/transcribe/interconnect/TransInterConnectManager$SingleHolder;", "", "<init>", "()V", "Lcom/upuphone/ar/transcribe/interconnect/TransInterConnectManager;", "b", "Lcom/upuphone/ar/transcribe/interconnect/TransInterConnectManager;", "a", "()Lcom/upuphone/ar/transcribe/interconnect/TransInterConnectManager;", "holder", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class SingleHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final SingleHolder f6068a = new SingleHolder();
        public static final TransInterConnectManager b = new TransInterConnectManager((DefaultConstructorMarker) null);

        public final TransInterConnectManager a() {
            return b;
        }
    }

    public /* synthetic */ TransInterConnectManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void A(OnInterConnectMsgListener onInterConnectMsgListener) {
        Intrinsics.checkNotNullParameter(onInterConnectMsgListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.k = onInterConnectMsgListener;
    }

    public final void B(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "callBack");
        SappAbilityOperator sappAbilityOperator = this.t;
        LogExt.d("mSappAbilityOperator: " + sappAbilityOperator, "TranscribeConnectManager");
        SappAbilityOperator sappAbilityOperator2 = this.t;
        if (sappAbilityOperator2 != null) {
            sappAbilityOperator2.requestAIState(new TransInterConnectManager$requestAIState$1(function1));
        }
    }

    public final void C() {
        SappAbilityOperator sappAbilityOperator = this.t;
        if (sappAbilityOperator != null) {
            sappAbilityOperator.requestPermission(CollectionsKt.arrayListOf("permission_ai_model"), new TransInterConnectManager$requestAiModelPermission$1());
        }
    }

    public final void D(InterConnectMessage interConnectMessage, byte[] bArr) {
        Intrinsics.checkNotNullParameter(interConnectMessage, "message");
        if (u()) {
            StarryNetMessage starryNetMessage = new StarryNetMessage();
            starryNetMessage.setSenderPkg(this.g);
            starryNetMessage.setReceiverPkg(this.h);
            starryNetMessage.setMessage(JsonUtils.b(interConnectMessage));
            if (bArr != null) {
                if (!(bArr.length == 0)) {
                    int length = bArr.length;
                    LogExt.d("send message byte size: " + length, "TranscribeConnectManager");
                    starryNetMessage.setData(bArr);
                }
            }
            StarryNetMessageOperator starryNetMessageOperator = this.b;
            if (starryNetMessageOperator != null) {
                starryNetMessageOperator.sendMessage(starryNetMessage, (SendMessageListener) null);
            }
        }
    }

    public final void E() {
        LogExt.g("startLocation", "TranscribeConnectManager");
        this.q = true;
        if (this.r.isCancelled()) {
            this.r = SupervisorKt.b((Job) null, 1, (Object) null);
            this.s = CoroutineScopeKt.a(Dispatchers.b().plus(this.r));
        }
        Job unused = BuildersKt__Builders_commonKt.d(this.s, (CoroutineContext) null, (CoroutineStart) null, new TransInterConnectManager$startLocation$1(this, (Continuation<? super TransInterConnectManager$startLocation$1>) null), 3, (Object) null);
    }

    public final void F() {
        LogExt.g("stopLocation", "TranscribeConnectManager");
        this.q = false;
        Job.DefaultImpls.a(this.r, (CancellationException) null, 1, (Object) null);
        NaviAbilityOperator naviAbilityOperator = this.e;
        if (naviAbilityOperator != null) {
            naviAbilityOperator.stopLocation(this.x);
        }
    }

    public final void G() {
        if (u()) {
            LogExt.g("InterConnectManager is release....", "TranscribeConnectManager");
            StarryNetMessageOperator starryNetMessageOperator = this.b;
            if (starryNetMessageOperator != null) {
                starryNetMessageOperator.unregisterMessageReceiver(this.u);
            }
            StarryNetDeviceOperator starryNetDeviceOperator = this.c;
            if (starryNetDeviceOperator != null) {
                starryNetDeviceOperator.unregisterDeviceConnectionListener(this.w);
            }
            this.n = false;
            this.i = false;
            this.o = 0;
            F();
            this.q = false;
            this.p = null;
            Job.DefaultImpls.a(this.r, (CancellationException) null, 1, (Object) null);
            CoroutineScopeKt.e(this.s, (CancellationException) null, 1, (Object) null);
        }
    }

    public final void H() {
        this.m = null;
    }

    public final void I() {
        this.k = null;
    }

    public final InterConnectDevice k() {
        StarryNetDevice l2 = l();
        if (l2 != null) {
            return InterConnectDeviceExtKt.append(l2);
        }
        return null;
    }

    public final StarryNetDevice l() {
        StarryNetDeviceOperator starryNetDeviceOperator = this.c;
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

    public final String m() {
        StarryNetDevice connectedDevice;
        StarryNetDeviceOperator starryNetDeviceOperator = this.c;
        if (starryNetDeviceOperator == null || (connectedDevice = starryNetDeviceOperator.getConnectedDevice()) == null) {
            StarryNetDevice l2 = l();
            if (l2 == null) {
                return "";
            }
            String modelId = l2.getModelId();
            Intrinsics.checkNotNullExpressionValue(modelId, "getModelId(...)");
            return modelId;
        }
        String modelId2 = connectedDevice.getModelId();
        Intrinsics.checkNotNullExpressionValue(modelId2, "getModelId(...)");
        return modelId2;
    }

    public final int n() {
        return this.o;
    }

    public final NaviLocationInfo o() {
        return this.p;
    }

    public final void p(Context context, String str, String str2) {
        PeerInfoOperator peer;
        InfoEndpoint<Integer> version;
        StarryNetDevice connectedDevice;
        Intrinsics.checkNotNullParameter(str, "moduleIdentifier");
        Intrinsics.checkNotNullParameter(str2, "targetPkg");
        this.g = str;
        this.h = str2;
        OperatorManager init = context == null ? SuperAppServiceManager.getInstance().init(str) : SuperAppServiceManager.getInstance().init(context, new TransInterConnectManager$init$1(), 1);
        this.f6067a = init;
        SappAbilityOperator sappAbilityOperator = null;
        this.b = init != null ? init.getMessageOperator() : null;
        OperatorManager operatorManager = this.f6067a;
        this.c = operatorManager != null ? operatorManager.getDeviceOperator() : null;
        OperatorManager operatorManager2 = this.f6067a;
        this.d = operatorManager2 != null ? operatorManager2.getInfoOperator() : null;
        OperatorManager operatorManager3 = this.f6067a;
        this.f = operatorManager3 != null ? operatorManager3.getDeviceInfoOperator() : null;
        OperatorManager operatorManager4 = this.f6067a;
        this.e = operatorManager4 != null ? operatorManager4.getNaviAbilityOperator() : null;
        OperatorManager operatorManager5 = this.f6067a;
        if (operatorManager5 != null) {
            sappAbilityOperator = operatorManager5.getSappAbilityOperator();
        }
        this.t = sappAbilityOperator;
        OperatorManager operatorManager6 = this.f6067a;
        StarryNetMessageOperator starryNetMessageOperator = this.b;
        StarryNetDeviceOperator starryNetDeviceOperator = this.c;
        InfoOperator infoOperator = this.d;
        LogExt.g("init:: mOperatorManager=" + operatorManager6 + ", mMsgOperator=" + starryNetMessageOperator + ", mDeviceOperator=" + starryNetDeviceOperator + ", mInfoOperator=" + infoOperator, "TranscribeConnectManager");
        StarryNetDeviceOperator starryNetDeviceOperator2 = this.c;
        if (!(starryNetDeviceOperator2 == null || (connectedDevice = starryNetDeviceOperator2.getConnectedDevice()) == null || !StarryNetDeviceExt.isXrDevice(connectedDevice))) {
            LogExt.g("init 眼镜和手机设备连接成功=" + connectedDevice, "TranscribeConnectManager");
            this.n = true;
            OnDeviceConnectedListener onDeviceConnectedListener = this.l;
            if (onDeviceConnectedListener != null) {
                onDeviceConnectedListener.a(InterConnectDeviceExtKt.append(connectedDevice));
            }
        }
        InfoOperator infoOperator2 = this.d;
        if (!(infoOperator2 == null || (peer = infoOperator2.getPeer()) == null || (version = peer.getVersion()) == null)) {
            version.subscribe(new TransInterConnectManager$init$3(this));
        }
        StarryNetMessageOperator starryNetMessageOperator2 = this.b;
        if (starryNetMessageOperator2 != null) {
            starryNetMessageOperator2.registerMessageReceiver(this.u);
        }
        StarryNetDeviceOperator starryNetDeviceOperator3 = this.c;
        if (starryNetDeviceOperator3 != null) {
            starryNetDeviceOperator3.registerDeviceConnectionListener(this.w);
        }
        E();
        this.i = true;
    }

    public final boolean q() {
        return Intrinsics.areEqual((Object) m(), (Object) "1003");
    }

    public final boolean r() {
        StarryNetDeviceInfoOperator starryNetDeviceInfoOperator = this.f;
        if (starryNetDeviceInfoOperator != null) {
            return starryNetDeviceInfoOperator.isAirPro();
        }
        return false;
    }

    public final boolean s() {
        String m2 = m();
        LogExt.d("isConcept: Connected device modelId=" + m2, "TranscribeConnectManager");
        return Intrinsics.areEqual((Object) m2, (Object) "1001");
    }

    public final boolean t() {
        return this.n;
    }

    public final boolean u() {
        if (this.i) {
            return true;
        }
        LogExt.e("必须初始化互联通道，请先调用init()进行初始化！", "TranscribeConnectManager");
        return false;
    }

    public final boolean v() {
        StarryNetDevice selfDevice;
        StarryNetDeviceOperator starryNetDeviceOperator = this.c;
        if (starryNetDeviceOperator == null || (selfDevice = starryNetDeviceOperator.getSelfDevice()) == null) {
            return false;
        }
        byte terminalType = selfDevice.getTerminalType();
        LogExt.g("isSelfPhoneThird terminalType=" + terminalType, "TranscribeConnectManager");
        return InterConnectDeviceExtKt.isThirdPhone(selfDevice);
    }

    public final boolean w() {
        String m2 = m();
        LogExt.d("isStar: Connected device modelId=" + m2, "TranscribeConnectManager");
        return Intrinsics.areEqual((Object) m2, (Object) "1002");
    }

    public final void x(OpenScene openScene, byte[] bArr) {
        Intrinsics.checkNotNullParameter(openScene, "openScene");
        try {
            StarryNetMessage starryNetMessage = new StarryNetMessage();
            starryNetMessage.setSenderPkg(this.g);
            starryNetMessage.setReceiverPkg("com.upuphone.star.launcher");
            starryNetMessage.setMessage(JsonUtils.b(openScene));
            if (bArr != null) {
                if (!(bArr.length == 0)) {
                    starryNetMessage.setData(bArr);
                }
            }
            String message = starryNetMessage.getMessage();
            LogExt.d("open scene data: " + message, "TranscribeConnectManager");
            StarryNetMessageOperator starryNetMessageOperator = this.b;
            if (starryNetMessageOperator != null) {
                starryNetMessageOperator.sendMessage(starryNetMessage, this.v);
            }
        } catch (Exception e2) {
            String stackTraceToString = ExceptionsKt.stackTraceToString(e2);
            LogExt.d("通过互联开启眼镜翻译官异常：" + stackTraceToString, "TranscribeConnectManager");
        }
    }

    public final void y(OnDeviceConnectedListener onDeviceConnectedListener) {
        Intrinsics.checkNotNullParameter(onDeviceConnectedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.l = onDeviceConnectedListener;
    }

    public final void z(OnInterConnectMsgListener onInterConnectMsgListener) {
        Intrinsics.checkNotNullParameter(onInterConnectMsgListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.m = onInterConnectMsgListener;
    }

    public TransInterConnectManager() {
        this.j = new LinkedHashMap();
        this.r = SupervisorKt.b((Job) null, 1, (Object) null);
        this.s = CoroutineScopeKt.a(Dispatchers.b());
        this.u = new TransInterConnectManager$mMsgReceiver$1(this);
        this.v = new TransInterConnectManager$mSendMsgListener$1();
        this.w = new TransInterConnectManager$mDeviceConnectionListener$1(this);
        this.x = new TransInterConnectManager$mNaviLocationCallback$1(this);
    }
}
