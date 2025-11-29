package com.upuphone.xr.sapp.glass;

import androidx.lifecycle.LifecycleOwner;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.star.core.log.ULog;
import com.upuphone.star.httplib.HttpUtils;
import com.upuphone.star.httplib.SignUtils;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.config.NetConfig;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.contract.ProtocolCategory;
import com.upuphone.xr.sapp.entity.BasicGlassInfo;
import com.upuphone.xr.sapp.entity.DeviceCompatInfo;
import com.upuphone.xr.sapp.utils.NetworkUtils;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001'\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ$\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0006\u0010\u000b\u001a\u00020\nH@¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u001e\u0010#\u001a\f\u0012\b\u0012\u00060\u001fj\u0002` 0\u001e8\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R$\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\b\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010\u0016R\u0014\u00100\u001a\u00020-8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00061"}, d2 = {"Lcom/upuphone/xr/sapp/glass/GlassCompatHelper;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "", "l", "", "delay", "g", "(J)V", "Lcom/upuphone/xr/sapp/entity/BasicGlassInfo;", "glassInfo", "Lcom/upuphone/star/httplib/HttpResult;", "Lcom/upuphone/xr/sapp/entity/BasicResponse;", "Lcom/upuphone/xr/sapp/entity/DeviceCompatInfo;", "j", "(Lcom/upuphone/xr/sapp/entity/BasicGlassInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "compatInfo", "k", "(Lcom/upuphone/xr/sapp/entity/BasicGlassInfo;Lcom/upuphone/xr/sapp/entity/DeviceCompatInfo;)V", "", "c", "Z", "isAppInitialized", "Lkotlinx/coroutines/Job;", "d", "Lkotlinx/coroutines/Job;", "getCompatInfoJob", "e", "handleCompatInfoJob", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "f", "Ljava/util/concurrent/CopyOnWriteArraySet;", "networkAvailableActions", "Lkotlin/Pair;", "Lkotlin/Pair;", "glassCompatPair", "com/upuphone/xr/sapp/glass/GlassCompatHelper$networkCallback$1", "h", "Lcom/upuphone/xr/sapp/glass/GlassCompatHelper$networkCallback$1;", "networkCallback", "i", "needShowCompatDialog", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nGlassCompatHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassCompatHelper.kt\ncom/upuphone/xr/sapp/glass/GlassCompatHelper\n+ 2 HttpUtils.kt\ncom/upuphone/star/httplib/HttpUtils\n*L\n1#1,275:1\n253#2:276\n*S KotlinDebug\n*F\n+ 1 GlassCompatHelper.kt\ncom/upuphone/xr/sapp/glass/GlassCompatHelper\n*L\n187#1:276\n*E\n"})
public final class GlassCompatHelper implements CoroutineScope {
    public static final GlassCompatHelper b = new GlassCompatHelper();
    public static boolean c;
    public static Job d;
    public static Job e;
    public static final CopyOnWriteArraySet f = new CopyOnWriteArraySet();
    public static Pair g;
    public static final GlassCompatHelper$networkCallback$1 h;
    public static boolean i = true;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f7042a = CoroutineScopeKt.b();

    static {
        GlassCompatHelper$networkCallback$1 glassCompatHelper$networkCallback$1 = new GlassCompatHelper$networkCallback$1();
        h = glassCompatHelper$networkCallback$1;
        GlassHelper.f7049a.l(new DeviceConnectListener() {
            public void onDeviceConnected(StarryNetDevice starryNetDevice) {
                Intrinsics.checkNotNullParameter(starryNetDevice, "device");
                ULog.Delegate delegate = ULog.f6446a;
                delegate.a("GlassCompatHelper", "onDeviceConnected: " + starryNetDevice);
                GlassCompatHelper.i = true;
                GlassCompatHelper.h(GlassCompatHelper.b, 0, 1, (Object) null);
            }

            public void onDeviceDisconnected(StarryNetDevice starryNetDevice) {
                Intrinsics.checkNotNullParameter(starryNetDevice, "device");
                ULog.Delegate delegate = ULog.f6446a;
                delegate.a("GlassCompatHelper", "onDeviceDisconnected: " + starryNetDevice);
            }
        });
        NetworkUtils.f7898a.o((LifecycleOwner) null, glassCompatHelper$networkCallback$1);
        CompatibilityManager compatibilityManager = CompatibilityManager.INSTANCE;
        GlassUpdateHelper.b.P0().observeForever(new GlassCompatHelper$sam$androidx_lifecycle_Observer$0(AnonymousClass2.INSTANCE));
    }

    public static /* synthetic */ void h(GlassCompatHelper glassCompatHelper, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = AssistantConstants.TIMEOUT_VAD_MUTE;
        }
        glassCompatHelper.g(j);
    }

    public final void g(long j) {
        if (!c) {
            ULog.f6446a.a("GlassCompatHelper", "checkCompatibility, isAppInitialized=false");
            return;
        }
        Job job = d;
        if (job == null || !job.isActive()) {
            d = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new GlassCompatHelper$checkCompatibility$1(j, (Continuation<? super GlassCompatHelper$checkCompatibility$1>) null), 3, (Object) null);
            return;
        }
        ULog.f6446a.a("GlassCompatHelper", "checkCompatibility, getCompatInfoJob.isActive=true");
    }

    public CoroutineContext getCoroutineContext() {
        return this.f7042a.getCoroutineContext();
    }

    public final Object j(BasicGlassInfo basicGlassInfo, Continuation continuation) {
        ULog.Delegate delegate = ULog.f6446a;
        Boolean bool = BuildConfig.b;
        delegate.a("GlassCompatHelper", "getCompatInfo, THIRD_PLATFOM: " + bool + ", INTL: " + BuildConfig.f6575a);
        Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
        Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("timestamp", String.valueOf(System.currentTimeMillis())), TuplesKt.to("appChannel", bool.booleanValue() ? "android" : ProtocolCategory.FLYME), TuplesKt.to("appVersion", "2.40.51"), TuplesKt.to("appRegion", SdkContext.f6675a.c().e() ? "abroad" : "native"), TuplesKt.to("deviceType", basicGlassInfo.getModel()));
        String subModel = basicGlassInfo.getSubModel();
        if (!(subModel == null || subModel.length() == 0)) {
            String subModel2 = basicGlassInfo.getSubModel();
            Intrinsics.checkNotNull(subModel2);
            mutableMapOf.put("deviceModel", subModel2);
        }
        mutableMapOf.put(AccountConstantKt.REQUEST_HEADER_SIGN, SignUtils.signWithHMacSha256$default(SignUtils.INSTANCE, mutableMapOf, (SecretKey) null, 2, (Object) null));
        HttpUtils httpUtils = HttpUtils.f6479a;
        String str = NetConfig.f6666a.v("sArOta") + "/client/v1/version-compatible/query";
        Type type = new GlassCompatHelper$getCompatInfo$$inlined$post$1().getType();
        Intrinsics.checkNotNullExpressionValue(type, "object : TypeToken<T>() {}.type");
        return httpUtils.o(str, mutableMapOf, type, continuation);
    }

    public final void k(BasicGlassInfo basicGlassInfo, DeviceCompatInfo deviceCompatInfo) {
        if (!c) {
            ULog.f6446a.a("GlassCompatHelper", "handleCompatInfo, isAppInitialized=false");
        } else if (!i) {
            ULog.f6446a.a("GlassCompatHelper", "handleCompatInfo, needShowCompatDialog=false");
        } else {
            GlassUpdateHelper glassUpdateHelper = GlassUpdateHelper.b;
            if (!glassUpdateHelper.B0()) {
                ULog.f6446a.a("GlassCompatHelper", "handleCompatInfo, glassRomReady=false");
            } else if (glassUpdateHelper.b1()) {
                ULog.f6446a.a("GlassCompatHelper", "handleCompatInfo, isUpdating=true");
            } else {
                Job job = e;
                if (job == null || !job.isActive()) {
                    e = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new GlassCompatHelper$handleCompatInfo$1(deviceCompatInfo, basicGlassInfo, (Continuation<? super GlassCompatHelper$handleCompatInfo$1>) null), 3, (Object) null);
                    return;
                }
                ULog.f6446a.a("GlassCompatHelper", "handleCompatInfo, handleCompatInfoJob?.isActive=true");
            }
        }
    }

    public final void l() {
        ULog.f6446a.a("GlassCompatHelper", "onAppInitialized");
        c = true;
        h(this, 0, 1, (Object) null);
    }
}
