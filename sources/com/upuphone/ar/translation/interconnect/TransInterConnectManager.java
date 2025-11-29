package com.upuphone.ar.translation.interconnect;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.interconnect.entity.InterConnectDevice;
import com.upuphone.ar.translation.interconnect.entity.InterConnectDeviceExtKt;
import com.upuphone.ar.translation.interconnect.entity.InterConnectMessage;
import com.upuphone.ar.translation.interconnect.entity.OpenScene;
import com.upuphone.ar.translation.interconnect.listener.OnDeviceConnectedListener;
import com.upuphone.ar.translation.interconnect.listener.OnInterConnectMsgListener;
import com.upuphone.ar.translation.utils.JsonUtils;
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
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
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

@Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0002\u0001\u0018\u0000 22\u00020\u0001:\u0004\u0001\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J)\u0010\f\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u0003J\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\u0004¢\u0006\u0004\b%\u0010\u0003J\u0015\u0010&\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b&\u0010$J\r\u0010'\u001a\u00020\u0004¢\u0006\u0004\b'\u0010\u0003J\u0015\u0010)\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020(¢\u0006\u0004\b)\u0010*J\r\u0010+\u001a\u00020\u001b¢\u0006\u0004\b+\u0010\u001dJ\u000f\u0010-\u001a\u0004\u0018\u00010,¢\u0006\u0004\b-\u0010.J\r\u0010/\u001a\u00020\t¢\u0006\u0004\b/\u00100J\r\u00101\u001a\u00020\u001b¢\u0006\u0004\b1\u0010\u001dJ\r\u00102\u001a\u00020\u001b¢\u0006\u0004\b2\u0010\u001dJ\r\u00103\u001a\u00020\u001b¢\u0006\u0004\b3\u0010\u001dJ\r\u00104\u001a\u00020\u001b¢\u0006\u0004\b4\u0010\u001dJ\r\u00105\u001a\u00020\u001b¢\u0006\u0004\b5\u0010\u001dJ\r\u00107\u001a\u000206¢\u0006\u0004\b7\u00108J\u000f\u0010:\u001a\u0004\u0018\u000109¢\u0006\u0004\b:\u0010;J0\u0010A\u001a\u00020\u00042!\u0010@\u001a\u001d\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020\u00040<¢\u0006\u0004\bA\u0010BJ0\u0010C\u001a\u00020\u00042!\u0010@\u001a\u001d\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020\u00040<¢\u0006\u0004\bC\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010W\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010[\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010_\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010b\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010d\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bc\u0010aR\u0016\u0010g\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010j\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010l\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010kR\u0018\u0010m\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010iR\u0016\u0010n\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u0010fR\u0016\u0010o\u001a\u0002068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u0010\u0006R\u0018\u0010q\u001a\u0004\u0018\u0001098\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010pR\u0016\u0010s\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\br\u0010fR\u0016\u0010v\u001a\u00020t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010uR\u0016\u0010y\u001a\u00020w8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u0010xR\u001b\u0010|\u001a\u00020w8BX\u0002¢\u0006\f\n\u0004\b4\u0010z\u001a\u0004\br\u0010{R\u0014\u0010\u001a\u00020}8\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u0010~R\u0017\u0010\u0001\u001a\u00030\u00018\u0002X\u0004¢\u0006\u0007\n\u0005\b\u001c\u0010\u0001R\u0017\u0010\u0001\u001a\u00030\u00018\u0002X\u0004¢\u0006\u0007\n\u0005\b+\u0010\u0001R\u0017\u0010\u0001\u001a\u00030\u00018\u0002X\u0004¢\u0006\u0007\n\u0005\b5\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/upuphone/ar/translation/interconnect/TransInterConnectManager;", "", "<init>", "()V", "", "H", "I", "Landroid/content/Context;", "context", "", "moduleIdentifier", "targetPkg", "r", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "J", "Lcom/upuphone/ar/translation/interconnect/entity/InterConnectMessage;", "message", "F", "(Lcom/upuphone/ar/translation/interconnect/entity/InterConnectMessage;)V", "", "bytes", "G", "(Lcom/upuphone/ar/translation/interconnect/entity/InterConnectMessage;[B)V", "Lcom/upuphone/ar/translation/interconnect/entity/OpenScene;", "openScene", "z", "(Lcom/upuphone/ar/translation/interconnect/entity/OpenScene;[B)V", "", "v", "()Z", "Lcom/upuphone/ar/translation/interconnect/entity/InterConnectDevice;", "l", "()Lcom/upuphone/ar/translation/interconnect/entity/InterConnectDevice;", "Lcom/upuphone/ar/translation/interconnect/listener/OnInterConnectMsgListener;", "listener", "B", "(Lcom/upuphone/ar/translation/interconnect/listener/OnInterConnectMsgListener;)V", "K", "C", "L", "Lcom/upuphone/ar/translation/interconnect/listener/OnDeviceConnectedListener;", "A", "(Lcom/upuphone/ar/translation/interconnect/listener/OnDeviceConnectedListener;)V", "w", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "m", "()Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "n", "()Ljava/lang/String;", "s", "y", "u", "t", "x", "", "o", "()I", "Lcom/upuphone/xr/interconnect/entity/NaviLocationInfo;", "p", "()Lcom/upuphone/xr/interconnect/entity/NaviLocationInfo;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isAgree", "callBack", "D", "(Lkotlin/jvm/functions/Function1;)V", "E", "Lcom/upuphone/xr/interconnect/api/OperatorManager;", "a", "Lcom/upuphone/xr/interconnect/api/OperatorManager;", "mOperatorManager", "Lcom/upuphone/xr/interconnect/api/StarryNetMessageOperator;", "b", "Lcom/upuphone/xr/interconnect/api/StarryNetMessageOperator;", "mMsgOperator", "Lcom/upuphone/xr/interconnect/api/StarryNetDeviceOperator;", "c", "Lcom/upuphone/xr/interconnect/api/StarryNetDeviceOperator;", "mDeviceOperator", "Lcom/upuphone/xr/interconnect/api/InfoOperator;", "d", "Lcom/upuphone/xr/interconnect/api/InfoOperator;", "mInfoOperator", "Lcom/upuphone/xr/interconnect/api/StarryNetDeviceInfoOperator;", "e", "Lcom/upuphone/xr/interconnect/api/StarryNetDeviceInfoOperator;", "mDeviceInfoOperator", "Lcom/upuphone/xr/interconnect/api/NaviAbilityOperator;", "f", "Lcom/upuphone/xr/interconnect/api/NaviAbilityOperator;", "mNaviAbilityOperator", "Lcom/upuphone/xr/interconnect/api/SappAbilityOperator;", "g", "Lcom/upuphone/xr/interconnect/api/SappAbilityOperator;", "mSappAbilityOperator", "h", "Ljava/lang/String;", "mModuleIdentifier", "i", "mTargetPkg", "j", "Z", "mIsInit", "k", "Lcom/upuphone/ar/translation/interconnect/listener/OnInterConnectMsgListener;", "remoteAppDieListener", "Lcom/upuphone/ar/translation/interconnect/listener/OnDeviceConnectedListener;", "mOnDeviceConnectedListener", "mConnectMsgReceiver", "mIsDeviceConnected", "mGlassVersion", "Lcom/upuphone/xr/interconnect/entity/NaviLocationInfo;", "mNaviLocationInfo", "q", "mIsNeedLocation", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "mIoJob", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "mIoCoroutineScope", "Lkotlin/Lazy;", "()Lkotlinx/coroutines/CoroutineScope;", "mMainCoroutineScope", "Lcom/upuphone/xr/interconnect/listener/MessageReceiver;", "Lcom/upuphone/xr/interconnect/listener/MessageReceiver;", "mMsgReceiver", "Lcom/upuphone/xr/interconnect/listener/SendMessageListener;", "Lcom/upuphone/xr/interconnect/listener/SendMessageListener;", "mSendMsgListener", "Lcom/upuphone/xr/interconnect/listener/DeviceConnectionListener;", "Lcom/upuphone/xr/interconnect/listener/DeviceConnectionListener;", "mDeviceConnectionListener", "com/upuphone/ar/translation/interconnect/TransInterConnectManager$mNaviLocationCallback$1", "Lcom/upuphone/ar/translation/interconnect/TransInterConnectManager$mNaviLocationCallback$1;", "mNaviLocationCallback", "Companion", "SingleHolder", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTransInterConnectManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TransInterConnectManager.kt\ncom/upuphone/ar/translation/interconnect/TransInterConnectManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,633:1\n1855#2,2:634\n*S KotlinDebug\n*F\n+ 1 TransInterConnectManager.kt\ncom/upuphone/ar/translation/interconnect/TransInterConnectManager\n*L\n428#1:634,2\n*E\n"})
public final class TransInterConnectManager {
    public static final Companion y = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public OperatorManager f6213a;
    public StarryNetMessageOperator b;
    public StarryNetDeviceOperator c;
    public InfoOperator d;
    public StarryNetDeviceInfoOperator e;
    public NaviAbilityOperator f;
    public SappAbilityOperator g;
    public String h;
    public String i;
    public boolean j;
    public OnInterConnectMsgListener k;
    public OnDeviceConnectedListener l;
    public OnInterConnectMsgListener m;
    public boolean n;
    public int o;
    public NaviLocationInfo p;
    public boolean q;
    public Job r;
    public CoroutineScope s;
    public final Lazy t;
    public final MessageReceiver u;
    public final SendMessageListener v;
    public final DeviceConnectionListener w;
    public final TransInterConnectManager$mNaviLocationCallback$1 x;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/upuphone/ar/translation/interconnect/TransInterConnectManager$Companion;", "", "<init>", "()V", "Lcom/upuphone/ar/translation/interconnect/TransInterConnectManager;", "a", "()Lcom/upuphone/ar/translation/interconnect/TransInterConnectManager;", "", "PKG_MESSAGE_RECEIVER_LAUNCHER", "Ljava/lang/String;", "PKG_MESSAGE_SENDER_SYSTEM", "TAG", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TransInterConnectManager a() {
            return SingleHolder.f6214a.a();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/upuphone/ar/translation/interconnect/TransInterConnectManager$SingleHolder;", "", "<init>", "()V", "Lcom/upuphone/ar/translation/interconnect/TransInterConnectManager;", "b", "Lcom/upuphone/ar/translation/interconnect/TransInterConnectManager;", "a", "()Lcom/upuphone/ar/translation/interconnect/TransInterConnectManager;", "holder", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class SingleHolder {

        /* renamed from: a  reason: collision with root package name */
        public static final SingleHolder f6214a = new SingleHolder();
        public static final TransInterConnectManager b = new TransInterConnectManager((DefaultConstructorMarker) null);

        public final TransInterConnectManager a() {
            return b;
        }
    }

    public /* synthetic */ TransInterConnectManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void A(OnDeviceConnectedListener onDeviceConnectedListener) {
        Intrinsics.checkNotNullParameter(onDeviceConnectedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.l = onDeviceConnectedListener;
    }

    public final void B(OnInterConnectMsgListener onInterConnectMsgListener) {
        Intrinsics.checkNotNullParameter(onInterConnectMsgListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.m = onInterConnectMsgListener;
    }

    public final void C(OnInterConnectMsgListener onInterConnectMsgListener) {
        Intrinsics.checkNotNullParameter(onInterConnectMsgListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.k = onInterConnectMsgListener;
    }

    public final void D(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "callBack");
        SappAbilityOperator sappAbilityOperator = this.g;
        if (sappAbilityOperator != null) {
            sappAbilityOperator.requestAIState(new TransInterConnectManager$requestAIState$1(this, function1));
        }
    }

    public final void E(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "callBack");
        SappAbilityOperator sappAbilityOperator = this.g;
        if (sappAbilityOperator != null) {
            sappAbilityOperator.requestPermission(CollectionsKt.arrayListOf("permission_ai_model"), new TransInterConnectManager$requestAiModelPermission$1(this, function1));
        }
    }

    public final void F(InterConnectMessage interConnectMessage) {
        Intrinsics.checkNotNullParameter(interConnectMessage, "message");
        G(interConnectMessage, (byte[]) null);
    }

    public final void G(InterConnectMessage interConnectMessage, byte[] bArr) {
        Intrinsics.checkNotNullParameter(interConnectMessage, "message");
        if (w()) {
            StarryNetMessage starryNetMessage = new StarryNetMessage();
            starryNetMessage.setSenderPkg(this.h);
            starryNetMessage.setReceiverPkg(this.i);
            starryNetMessage.setMessage(JsonUtils.d(interConnectMessage));
            if (bArr != null) {
                if (!(bArr.length == 0)) {
                    starryNetMessage.setData(bArr);
                }
            }
            StarryNetMessageOperator starryNetMessageOperator = this.b;
            if (starryNetMessageOperator != null) {
                starryNetMessageOperator.sendMessage2(starryNetMessage, (SendMessageListener) null);
            }
        }
    }

    public final void H() {
        LogExt.j("startLocation", "TransInterConnectManager");
        this.q = true;
        if (this.r.isCancelled()) {
            this.r = SupervisorKt.b((Job) null, 1, (Object) null);
            this.s = CoroutineScopeKt.a(Dispatchers.b().plus(this.r));
        }
        Job unused = BuildersKt__Builders_commonKt.d(this.s, (CoroutineContext) null, (CoroutineStart) null, new TransInterConnectManager$startLocation$1(this, (Continuation<? super TransInterConnectManager$startLocation$1>) null), 3, (Object) null);
    }

    public final void I() {
        LogExt.j("stopLocation", "TransInterConnectManager");
        this.q = false;
        Job.DefaultImpls.a(this.r, (CancellationException) null, 1, (Object) null);
        NaviAbilityOperator naviAbilityOperator = this.f;
        if (naviAbilityOperator != null) {
            naviAbilityOperator.stopLocation(this.x);
        }
    }

    public final void J() {
        if (w()) {
            LogExt.j("InterConnectManager is release....", "TransInterConnectManager");
            StarryNetMessageOperator starryNetMessageOperator = this.b;
            if (starryNetMessageOperator != null) {
                starryNetMessageOperator.unregisterMessageReceiver(this.u);
            }
            StarryNetDeviceOperator starryNetDeviceOperator = this.c;
            if (starryNetDeviceOperator != null) {
                starryNetDeviceOperator.unregisterDeviceConnectionListener(this.w);
            }
            this.n = false;
            this.j = false;
            this.o = 0;
            I();
            this.q = false;
            this.p = null;
            Job.DefaultImpls.a(this.r, (CancellationException) null, 1, (Object) null);
            CoroutineScopeKt.e(this.s, (CancellationException) null, 1, (Object) null);
        }
    }

    public final void K() {
        this.m = null;
    }

    public final void L() {
        this.k = null;
    }

    public final InterConnectDevice l() {
        StarryNetDevice m2 = m();
        if (m2 != null) {
            return InterConnectDeviceExtKt.append(m2);
        }
        return null;
    }

    public final StarryNetDevice m() {
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

    public final String n() {
        StarryNetDevice connectedDevice;
        StarryNetDeviceOperator starryNetDeviceOperator = this.c;
        if (starryNetDeviceOperator == null || (connectedDevice = starryNetDeviceOperator.getConnectedDevice()) == null) {
            StarryNetDevice m2 = m();
            if (m2 == null) {
                return "";
            }
            String modelId = m2.getModelId();
            Intrinsics.checkNotNullExpressionValue(modelId, "getModelId(...)");
            return modelId;
        }
        String modelId2 = connectedDevice.getModelId();
        Intrinsics.checkNotNullExpressionValue(modelId2, "getModelId(...)");
        return modelId2;
    }

    public final int o() {
        return this.o;
    }

    public final NaviLocationInfo p() {
        return this.p;
    }

    public final CoroutineScope q() {
        return (CoroutineScope) this.t.getValue();
    }

    public final void r(Context context, String str, String str2) {
        PeerInfoOperator peer;
        InfoEndpoint<Integer> version;
        StarryNetDevice connectedDevice;
        Intrinsics.checkNotNullParameter(str, "moduleIdentifier");
        Intrinsics.checkNotNullParameter(str2, "targetPkg");
        this.h = str;
        this.i = str2;
        OperatorManager init = context == null ? SuperAppServiceManager.getInstance().init(str) : SuperAppServiceManager.getInstance().init(context, new TransInterConnectManager$init$1(), 1);
        this.f6213a = init;
        SappAbilityOperator sappAbilityOperator = null;
        this.b = init != null ? init.getMessageOperator() : null;
        OperatorManager operatorManager = this.f6213a;
        this.c = operatorManager != null ? operatorManager.getDeviceOperator() : null;
        OperatorManager operatorManager2 = this.f6213a;
        this.d = operatorManager2 != null ? operatorManager2.getInfoOperator() : null;
        OperatorManager operatorManager3 = this.f6213a;
        this.e = operatorManager3 != null ? operatorManager3.getDeviceInfoOperator() : null;
        OperatorManager operatorManager4 = this.f6213a;
        this.f = operatorManager4 != null ? operatorManager4.getNaviAbilityOperator() : null;
        OperatorManager operatorManager5 = this.f6213a;
        if (operatorManager5 != null) {
            sappAbilityOperator = operatorManager5.getSappAbilityOperator();
        }
        this.g = sappAbilityOperator;
        OperatorManager operatorManager6 = this.f6213a;
        StarryNetMessageOperator starryNetMessageOperator = this.b;
        StarryNetDeviceOperator starryNetDeviceOperator = this.c;
        InfoOperator infoOperator = this.d;
        StarryNetDeviceInfoOperator starryNetDeviceInfoOperator = this.e;
        NaviAbilityOperator naviAbilityOperator = this.f;
        LogExt.j("init互联[OperatorManager=" + operatorManager6 + ", MsgOperator=" + starryNetMessageOperator + ", DeviceOperator=" + starryNetDeviceOperator + ", InfoOperator=" + infoOperator + ", DeviceInfoOperator=" + starryNetDeviceInfoOperator + ", mNaviAbilityOperator=" + naviAbilityOperator + "]", "TransInterConnectManager");
        StarryNetDeviceOperator starryNetDeviceOperator2 = this.c;
        if (!(starryNetDeviceOperator2 == null || (connectedDevice = starryNetDeviceOperator2.getConnectedDevice()) == null || !StarryNetDeviceExt.isXrDevice(connectedDevice))) {
            LogExt.j("init 眼镜和手机设备连接成功=" + connectedDevice, "TransInterConnectManager");
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
        H();
        this.j = true;
    }

    public final boolean s() {
        StarryNetDeviceInfoOperator starryNetDeviceInfoOperator = this.e;
        if (starryNetDeviceInfoOperator != null) {
            return starryNetDeviceInfoOperator.isAir();
        }
        return false;
    }

    public final boolean t() {
        StarryNetDeviceInfoOperator starryNetDeviceInfoOperator = this.e;
        if (starryNetDeviceInfoOperator != null) {
            return starryNetDeviceInfoOperator.isAirPro();
        }
        return false;
    }

    public final boolean u() {
        String n2 = n();
        LogExt.g("isConcept: Connected device modelId=" + n2, "TransInterConnectManager");
        return Intrinsics.areEqual((Object) n2, (Object) "1001");
    }

    public final boolean v() {
        return this.n;
    }

    public final boolean w() {
        if (this.j) {
            return true;
        }
        LogExt.h("必须初始化互联通道，请先调用init()进行初始化！", "TransInterConnectManager");
        return false;
    }

    public final boolean x() {
        StarryNetDevice selfDevice;
        StarryNetDeviceOperator starryNetDeviceOperator = this.c;
        if (starryNetDeviceOperator == null || (selfDevice = starryNetDeviceOperator.getSelfDevice()) == null) {
            return false;
        }
        byte terminalType = selfDevice.getTerminalType();
        LogExt.j("isSelfPhoneThird terminalType=" + terminalType, "TransInterConnectManager");
        return InterConnectDeviceExtKt.isThirdPhone(selfDevice);
    }

    public final boolean y() {
        String n2 = n();
        LogExt.g("isStar: Connected device modelId=" + n2, "TransInterConnectManager");
        return Intrinsics.areEqual((Object) n2, (Object) "1002");
    }

    public final void z(OpenScene openScene, byte[] bArr) {
        Intrinsics.checkNotNullParameter(openScene, "openScene");
        try {
            StarryNetMessage starryNetMessage = new StarryNetMessage();
            starryNetMessage.setSenderPkg(this.h);
            starryNetMessage.setReceiverPkg("com.upuphone.star.launcher");
            starryNetMessage.setMessage(JsonUtils.d(openScene));
            if (bArr != null) {
                if (!(bArr.length == 0)) {
                    starryNetMessage.setData(bArr);
                }
            }
            StarryNetMessageOperator starryNetMessageOperator = this.b;
            if (starryNetMessageOperator != null) {
                starryNetMessageOperator.sendMessage2(starryNetMessage, this.v);
            }
        } catch (Exception e2) {
            String stackTraceToString = ExceptionsKt.stackTraceToString(e2);
            LogExt.g("通过互联开启眼镜翻译官异常：" + stackTraceToString, "TransInterConnectManager");
        }
    }

    public TransInterConnectManager() {
        this.r = SupervisorKt.b((Job) null, 1, (Object) null);
        this.s = CoroutineScopeKt.a(Dispatchers.b().plus(this.r));
        this.t = LazyKt.lazy(TransInterConnectManager$mMainCoroutineScope$2.INSTANCE);
        this.u = new TransInterConnectManager$mMsgReceiver$1(this);
        this.v = new TransInterConnectManager$mSendMsgListener$1();
        this.w = new TransInterConnectManager$mDeviceConnectionListener$1(this);
        this.x = new TransInterConnectManager$mNaviLocationCallback$1(this);
    }
}
