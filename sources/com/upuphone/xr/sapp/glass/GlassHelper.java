package com.upuphone.xr.sapp.glass;

import androidx.lifecycle.LifecycleOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.honey.account.view.web.WebJs;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.StarryNetDeviceManager;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.util.StarryNetDeviceExt;
import com.upuphone.xr.sapp.common.ResultListener;
import com.upuphone.xr.sapp.entity.BaseActionData;
import com.upuphone.xr.sapp.entity.BaseActionValue;
import com.upuphone.xr.sapp.entity.CheckGlassUpdateFileCmd;
import com.upuphone.xr.sapp.entity.ReceiveGlassUpdate;
import com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper;
import com.upuphone.xr.sapp.utils.JsonUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.TimeoutKt;

@Metadata(d1 = {"\u0000å\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u000b*\u0003hlo\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0014\u001a\u00020\u0013H@¢\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0014\u001a\u00020\u0013H@¢\u0006\u0004\b\u0019\u0010\u0017J\"\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u0013H@¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u0004¢\u0006\u0004\b\u001f\u0010 J\u001c\u0010\"\u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\u0014\u001a\u00020\u0013H@¢\u0006\u0004\b\"\u0010\u0017J$\u0010%\u001a\u0004\u0018\u00010!2\u0006\u0010$\u001a\u00020#2\b\b\u0002\u0010\u0014\u001a\u00020\u0013H@¢\u0006\u0004\b%\u0010&J\u001d\u0010(\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020'¢\u0006\u0004\b(\u0010)J\u001d\u0010*\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020'¢\u0006\u0004\b*\u0010)J%\u0010/\u001a\u00020\u001e2\u0016\u0010.\u001a\u0012\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u001e0+j\u0002`-¢\u0006\u0004\b/\u00100J\u0015\u00102\u001a\u00020\u001e2\u0006\u0010\u0007\u001a\u000201¢\u0006\u0004\b2\u00103J\u001d\u00106\u001a\u00020\u001e2\u0006\u00105\u001a\u0002042\u0006\u0010\u0007\u001a\u000201¢\u0006\u0004\b6\u00107J\u0015\u00108\u001a\u00020\u001e2\u0006\u0010\u0007\u001a\u000201¢\u0006\u0004\b8\u00103J$\u0010<\u001a\u0004\u0018\u00010;2\u0006\u0010:\u001a\u0002092\b\b\u0002\u0010\u0014\u001a\u00020\u0013H@¢\u0006\u0004\b<\u0010=J'\u0010>\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b>\u0010?J\r\u0010@\u001a\u00020\u001b¢\u0006\u0004\b@\u0010AJ%\u0010D\u001a\u00020\u001e2\u0016\u0010.\u001a\u0012\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020\u001e0+j\u0002`C¢\u0006\u0004\bD\u00100J\u001c\u0010E\u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\u0014\u001a\u00020\u0013H@¢\u0006\u0004\bE\u0010\u0017J\u0015\u0010H\u001a\u00020\u001b2\u0006\u0010G\u001a\u00020F¢\u0006\u0004\bH\u0010IJ\u0015\u0010J\u001a\u00020\u001b2\u0006\u0010G\u001a\u00020F¢\u0006\u0004\bJ\u0010IJ\u0015\u0010K\u001a\u00020\u001b2\u0006\u0010G\u001a\u00020F¢\u0006\u0004\bK\u0010IJ%\u0010N\u001a\u00020\u001e2\u0016\u0010.\u001a\u0012\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u001e0+j\u0002`M¢\u0006\u0004\bN\u00100J%\u0010Q\u001a\u00020\u001e2\u0016\u0010.\u001a\u0012\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020\u001e0+j\u0002`P¢\u0006\u0004\bQ\u00100R&\u0010U\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00060R8\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR*\u0010Y\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u001e0+j\u0002`-0V8\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u001a\u0010[\u001a\b\u0012\u0004\u0012\u0002010V8\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010XR&\u0010^\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0\\0R8\u0002X\u0004¢\u0006\u0006\n\u0004\b]\u0010TR*\u0010`\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020\u001e0+j\u0002`C0V8\u0002X\u0004¢\u0006\u0006\n\u0004\b_\u0010XR*\u0010b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u001e0+j\u0002`M0V8\u0002X\u0004¢\u0006\u0006\n\u0004\ba\u0010XR*\u0010d\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020\u001e0+j\u0002`P0V8\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u0010XR\u001a\u0010g\u001a\b\u0012\u0004\u0012\u00020e0V8\u0002X\u0004¢\u0006\u0006\n\u0004\bf\u0010XR\u0014\u0010k\u001a\u00020h8\u0002X\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u0014\u0010n\u001a\u00020l8\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u0010mR\u0014\u0010q\u001a\u00020o8\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u0010pR\u0013\u0010t\u001a\u0004\u0018\u00010F8F¢\u0006\u0006\u001a\u0004\br\u0010sR\u0013\u0010v\u001a\u0004\u0018\u00010F8F¢\u0006\u0006\u001a\u0004\bu\u0010sR\u0013\u0010x\u001a\u0004\u0018\u00010F8F¢\u0006\u0006\u001a\u0004\bw\u0010s¨\u0006y"}, d2 = {"Lcom/upuphone/xr/sapp/glass/GlassHelper;", "", "<init>", "()V", "", "msg", "Lcom/upuphone/xr/sapp/common/ResultListener;", "listener", "N", "(Ljava/lang/String;Lcom/upuphone/xr/sapp/common/ResultListener;)Ljava/lang/String;", "uid", "J", "(Ljava/lang/String;)Lcom/upuphone/xr/sapp/common/ResultListener;", "action", "subAction", "message", "Lcom/upuphone/xr/sapp/entity/BaseActionData;", "r", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/upuphone/xr/sapp/entity/BaseActionData;", "", "timeout", "Lcom/upuphone/xr/sapp/entity/StarGlassInfo;", "z", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/upuphone/xr/sapp/entity/RemoteGlassUpdateState;", "B", "identifier", "", "u", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "S", "(Ljava/lang/String;)V", "Lcom/upuphone/xr/sapp/entity/BasicGlassResponse;", "K", "Lcom/upuphone/xr/sapp/entity/ReceiveGlassUpdate;", "receiveGlassUpdate", "O", "(Lcom/upuphone/xr/sapp/entity/ReceiveGlassUpdate;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/upuphone/xr/sapp/glass/GlassMessageListener;", "n", "(Ljava/lang/String;Lcom/upuphone/xr/sapp/glass/GlassMessageListener;)V", "I", "Lkotlin/Function1;", "Lcom/upuphone/xr/sapp/entity/StarGlassUpdateResult;", "Lcom/upuphone/xr/sapp/glass/SyncStarGlassUpdateResultCallback;", "callback", "q", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/upuphone/xr/sapp/glass/DeviceConnectListener;", "l", "(Lcom/upuphone/xr/sapp/glass/DeviceConnectListener;)V", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "k", "(Landroidx/lifecycle/LifecycleOwner;Lcom/upuphone/xr/sapp/glass/DeviceConnectListener;)V", "H", "Lcom/upuphone/xr/sapp/entity/CheckGlassUpdateFileCmd;", "cmd", "Lcom/upuphone/xr/sapp/entity/CheckGlassUpdateFileResult;", "s", "(Lcom/upuphone/xr/sapp/entity/CheckGlassUpdateFileCmd;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "M", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "E", "()Z", "Lcom/upuphone/xr/sapp/entity/GlassBatteryInfo;", "Lcom/upuphone/xr/sapp/glass/GlassBatteryInfoCallback;", "m", "Q", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "device", "D", "(Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;)Z", "G", "F", "Lcom/upuphone/xr/sapp/entity/GlassUpdateDialogResult;", "Lcom/upuphone/xr/sapp/glass/GlassUpdateDialogResultCallback;", "o", "Lcom/upuphone/xr/sapp/entity/GlassUpdateProgress;", "Lcom/upuphone/xr/sapp/glass/GlassUpdateProgressCallback;", "p", "Ljava/util/concurrent/ConcurrentHashMap;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "resultListeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "c", "Ljava/util/concurrent/CopyOnWriteArraySet;", "syncGlassUpdateResultCallbacks", "d", "deviceConnectListeners", "", "e", "glassMessageListeners", "f", "glassBatteryInfoCallbacks", "g", "glassUpdateDialogResultCallbacks", "h", "glassUpdateProgressCallbacks", "Lcom/upuphone/xr/sapp/glass/DeviceBoundListener;", "i", "deviceBondStateListeners", "com/upuphone/xr/sapp/glass/GlassHelper$connectListener$1", "j", "Lcom/upuphone/xr/sapp/glass/GlassHelper$connectListener$1;", "connectListener", "com/upuphone/xr/sapp/glass/GlassHelper$bondStateListener$1", "Lcom/upuphone/xr/sapp/glass/GlassHelper$bondStateListener$1;", "bondStateListener", "com/upuphone/xr/sapp/glass/GlassHelper$messageReceiver$1", "Lcom/upuphone/xr/sapp/glass/GlassHelper$messageReceiver$1;", "messageReceiver", "x", "()Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "connectedDevice", "w", "bondedGlass", "y", "connectedGlass", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nGlassHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassHelper.kt\ncom/upuphone/xr/sapp/glass/GlassHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 4 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 5 JsonUtils.kt\ncom/upuphone/xr/sapp/utils/JsonUtils\n+ 6 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,649:1\n409#1:665\n410#1,12:675\n433#1,5:687\n1#2:650\n1#2:653\n72#3,2:651\n314#4,11:654\n314#4,9:666\n323#4,2:692\n29#5,5:694\n288#6,2:699\n*S KotlinDebug\n*F\n+ 1 GlassHelper.kt\ncom/upuphone/xr/sapp/glass/GlassHelper\n*L\n448#1:665\n448#1:675,12\n448#1:687,5\n323#1:653\n323#1:651,2\n409#1:654,11\n448#1:666,9\n448#1:692,2\n448#1:694,5\n486#1:699,2\n*E\n"})
public final class GlassHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final GlassHelper f7049a = new GlassHelper();
    public static final ConcurrentHashMap b = new ConcurrentHashMap();
    public static final CopyOnWriteArraySet c = new CopyOnWriteArraySet();
    public static final CopyOnWriteArraySet d = new CopyOnWriteArraySet();
    public static final ConcurrentHashMap e = new ConcurrentHashMap();
    public static final CopyOnWriteArraySet f = new CopyOnWriteArraySet();
    public static final CopyOnWriteArraySet g = new CopyOnWriteArraySet();
    public static final CopyOnWriteArraySet h = new CopyOnWriteArraySet();
    public static final CopyOnWriteArraySet i = new CopyOnWriteArraySet();
    public static final GlassHelper$connectListener$1 j;
    public static final GlassHelper$bondStateListener$1 k;
    public static final GlassHelper$messageReceiver$1 l;

    static {
        GlassHelper$connectListener$1 glassHelper$connectListener$1 = new GlassHelper$connectListener$1();
        j = glassHelper$connectListener$1;
        GlassHelper$bondStateListener$1 glassHelper$bondStateListener$1 = new GlassHelper$bondStateListener$1();
        k = glassHelper$bondStateListener$1;
        GlassHelper$messageReceiver$1 glassHelper$messageReceiver$1 = new GlassHelper$messageReceiver$1();
        l = glassHelper$messageReceiver$1;
        StarryMessageHelper.f7799a.j(glassHelper$messageReceiver$1);
        InterconnectManager.getInstance().getStarryNetDeviceManager().registerDeviceConnectionListener(glassHelper$connectListener$1);
        InterconnectManager.getInstance().getStarryNetDeviceManager().registerDeviceBondStateListener(glassHelper$bondStateListener$1);
    }

    public static /* synthetic */ Object A(GlassHelper glassHelper, long j2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = 15000;
        }
        return glassHelper.z(j2, continuation);
    }

    public static /* synthetic */ Object C(GlassHelper glassHelper, long j2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = 15000;
        }
        return glassHelper.B(j2, continuation);
    }

    public static /* synthetic */ Object L(GlassHelper glassHelper, long j2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = 15000;
        }
        return glassHelper.K(j2, continuation);
    }

    public static /* synthetic */ Object P(GlassHelper glassHelper, ReceiveGlassUpdate receiveGlassUpdate, long j2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = 15000;
        }
        return glassHelper.O(receiveGlassUpdate, j2, continuation);
    }

    public static /* synthetic */ Object R(GlassHelper glassHelper, long j2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = 15000;
        }
        return glassHelper.Q(j2, continuation);
    }

    public static /* synthetic */ Object t(GlassHelper glassHelper, CheckGlassUpdateFileCmd checkGlassUpdateFileCmd, long j2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = 15000;
        }
        return glassHelper.s(checkGlassUpdateFileCmd, j2, continuation);
    }

    public static /* synthetic */ Object v(GlassHelper glassHelper, String str, long j2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = 15000;
        }
        return glassHelper.u(str, j2, continuation);
    }

    public final Object B(long j2, Continuation continuation) {
        return TimeoutKt.c(j2, new GlassHelper$getRemoteGlassUpdateState$2((Continuation<? super GlassHelper$getRemoteGlassUpdateState$2>) null), continuation);
    }

    public final boolean D(StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        StarryNetDeviceManager starryNetDeviceManager = InterconnectManager.getInstance().getStarryNetDeviceManager();
        return Intrinsics.areEqual((Object) starryNetDeviceManager != null ? starryNetDeviceManager.getDeviceInfo(starryNetDevice.getDeviceId(), 5) : null, (Object) "1001");
    }

    public final boolean E() {
        return x() != null;
    }

    public final boolean F(StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        StarryNetDeviceManager starryNetDeviceManager = InterconnectManager.getInstance().getStarryNetDeviceManager();
        return Intrinsics.areEqual((Object) starryNetDeviceManager != null ? starryNetDeviceManager.getDeviceInfo(starryNetDevice.getDeviceId(), 5) : null, (Object) "1002");
    }

    public final boolean G(StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        StarryNetDeviceManager starryNetDeviceManager = InterconnectManager.getInstance().getStarryNetDeviceManager();
        String deviceInfo = starryNetDeviceManager != null ? starryNetDeviceManager.getDeviceInfo(starryNetDevice.getDeviceId(), 5) : null;
        return Intrinsics.areEqual((Object) deviceInfo, (Object) "1001") || Intrinsics.areEqual((Object) deviceInfo, (Object) "1002");
    }

    public final void H(DeviceConnectListener deviceConnectListener) {
        Intrinsics.checkNotNullParameter(deviceConnectListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        d.remove(deviceConnectListener);
    }

    public final void I(String str, GlassMessageListener glassMessageListener) {
        Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
        Intrinsics.checkNotNullParameter(glassMessageListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Set set = (Set) e.get(str);
        if (set != null) {
            set.remove(glassMessageListener);
        }
    }

    public final ResultListener J(String str) {
        if (str != null) {
            return (ResultListener) b.remove(str);
        }
        return null;
    }

    public final Object K(long j2, Continuation continuation) {
        return TimeoutKt.c(j2, new GlassHelper$sendInstallUpdateCmd$2((Continuation<? super GlassHelper$sendInstallUpdateCmd$2>) null), continuation);
    }

    public final void M(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
        Intrinsics.checkNotNullParameter(str2, "subAction");
        N(JsonUtils.f7893a.d(r(str, str2, str3)), (ResultListener) null);
    }

    public final String N(String str, ResultListener resultListener) {
        String str2 = null;
        if (InterconnectManager.getInstance().getStarryNetDeviceManager().getConnectedDevice() == null) {
            ULog.f6446a.a("GlassHelper", "sendMessageToGlass, connectedDevice is null");
            if (resultListener != null) {
                resultListener.onFail(-1, "connectedDevice is null");
            }
            return null;
        }
        if (resultListener != null) {
            str2 = UUID.randomUUID().toString();
            b.put(str2, resultListener);
        }
        StarryMessageHelper.f7799a.k(str, new GlassHelper$sendMessageToGlass$1(str, str2));
        return str2;
    }

    public final Object O(ReceiveGlassUpdate receiveGlassUpdate, long j2, Continuation continuation) {
        return TimeoutKt.c(j2, new GlassHelper$sendReceiveGlassUpdateCmd$2(receiveGlassUpdate, (Continuation<? super GlassHelper$sendReceiveGlassUpdateCmd$2>) null), continuation);
    }

    public final Object Q(long j2, Continuation continuation) {
        return TimeoutKt.c(j2, new GlassHelper$sendShowUpdateDialogCmd$2((Continuation<? super GlassHelper$sendShowUpdateDialogCmd$2>) null), continuation);
    }

    public final void S(String str) {
        Intrinsics.checkNotNullParameter(str, "identifier");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GlassHelper", "tryReleaseP2p, identifier: " + str);
        StarryNetDeviceManager starryNetDeviceManager = InterconnectManager.getInstance().getStarryNetDeviceManager();
        if (starryNetDeviceManager != null) {
            starryNetDeviceManager.tryReleaseP2p(str);
        }
    }

    public final void k(LifecycleOwner lifecycleOwner, DeviceConnectListener deviceConnectListener) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(deviceConnectListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        lifecycleOwner.getLifecycle().a(new GlassHelper$addDeviceConnectListener$1(deviceConnectListener));
        d.add(deviceConnectListener);
    }

    public final void l(DeviceConnectListener deviceConnectListener) {
        Intrinsics.checkNotNullParameter(deviceConnectListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        d.add(deviceConnectListener);
    }

    public final void m(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        f.add(function1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0012, code lost:
        r0 = new java.util.concurrent.CopyOnWriteArraySet();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n(java.lang.String r2, com.upuphone.xr.sapp.glass.GlassMessageListener r3) {
        /*
            r1 = this;
            java.lang.String r1 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            java.lang.String r1 = "listener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r1)
            java.util.concurrent.ConcurrentHashMap r1 = e
            java.lang.Object r0 = r1.get(r2)
            if (r0 != 0) goto L_0x001f
            java.util.concurrent.CopyOnWriteArraySet r0 = new java.util.concurrent.CopyOnWriteArraySet
            r0.<init>()
            java.lang.Object r1 = r1.putIfAbsent(r2, r0)
            if (r1 != 0) goto L_0x001e
            goto L_0x001f
        L_0x001e:
            r0 = r1
        L_0x001f:
            java.util.Set r0 = (java.util.Set) r0
            r0.add(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.glass.GlassHelper.n(java.lang.String, com.upuphone.xr.sapp.glass.GlassMessageListener):void");
    }

    public final void o(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        g.add(function1);
    }

    public final void p(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        h.add(function1);
    }

    public final void q(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        c.add(function1);
    }

    public final BaseActionData r(String str, String str2, String str3) {
        BaseActionValue baseActionValue = new BaseActionValue();
        baseActionValue.setAction(str2);
        if (str3 == null) {
            str3 = "";
        }
        baseActionValue.setValue(str3);
        BaseActionData baseActionData = new BaseActionData();
        baseActionData.setAction(str);
        baseActionData.setData(baseActionValue);
        return baseActionData;
    }

    public final Object s(CheckGlassUpdateFileCmd checkGlassUpdateFileCmd, long j2, Continuation continuation) {
        return TimeoutKt.c(j2, new GlassHelper$checkGlassUpdateFile$2(checkGlassUpdateFileCmd, (Continuation<? super GlassHelper$checkGlassUpdateFile$2>) null), continuation);
    }

    public final Object u(String str, long j2, Continuation continuation) {
        StarryNetDeviceManager starryNetDeviceManager = InterconnectManager.getInstance().getStarryNetDeviceManager();
        return starryNetDeviceManager == null ? Boxing.boxBoolean(false) : TimeoutKt.c(j2, new GlassHelper$enableP2pConnection$2(str, starryNetDeviceManager, (Continuation<? super GlassHelper$enableP2pConnection$2>) null), continuation);
    }

    public final StarryNetDevice w() {
        List<StarryNetDevice> bondedDevices = InterconnectManager.getInstance().getStarryNetDeviceManager().getBondedDevices();
        T t = null;
        if (bondedDevices == null) {
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

    public final StarryNetDevice x() {
        StarryNetDevice connectedDeviceWrapper = InterconnectManager.getInstance().getStarryNetDeviceManager().getConnectedDeviceWrapper();
        if (connectedDeviceWrapper == null || !StarryNetDeviceExt.isXrDevice(connectedDeviceWrapper)) {
            return null;
        }
        return connectedDeviceWrapper;
    }

    public final StarryNetDevice y() {
        StarryNetDevice connectedDeviceWrapper = InterconnectManager.getInstance().getStarryNetDeviceManager().getConnectedDeviceWrapper();
        if (connectedDeviceWrapper == null || !StarryNetDeviceExt.isXrDevice(connectedDeviceWrapper)) {
            return null;
        }
        return connectedDeviceWrapper;
    }

    public final Object z(long j2, Continuation continuation) {
        return TimeoutKt.c(j2, new GlassHelper$getGlassInfo$2((Continuation<? super GlassHelper$getGlassInfo$2>) null), continuation);
    }
}
