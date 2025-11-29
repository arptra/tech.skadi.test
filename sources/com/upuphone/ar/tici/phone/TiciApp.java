package com.upuphone.ar.tici.phone;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.upuphone.ar.tici.phone.db.TiciDao;
import com.upuphone.ar.tici.phone.db.TiciDatabase;
import com.upuphone.ar.tici.phone.db.entity.TiciEntity;
import com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import com.upuphone.ar.tici.phone.utils.TiciHostConfig;
import com.upuphone.runasone.uupcast.CaptureType;
import com.upuphone.xr.interconnect.listener.DeviceConnectionListener;
import com.upuphone.xr.sapp.context.IAccountInfo;
import com.upuphone.xr.sapp.context.SdkContext;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001bJ\r\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u000f¢\u0006\u0004\b \u0010\u0003J\r\u0010!\u001a\u00020\u000f¢\u0006\u0004\b!\u0010\u0003J\r\u0010#\u001a\u00020\"¢\u0006\u0004\b#\u0010$J\u0015\u0010'\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(R\u001b\u0010+\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010)\u001a\u0004\b*\u0010\u0006R\u001b\u0010/\u001a\u00020,8FX\u0002¢\u0006\f\n\u0004\b#\u0010)\u001a\u0004\b-\u0010.R\u001b\u00101\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010)\u001a\u0004\b0\u0010\u001fR\u0014\u00105\u001a\u0002028\u0016X\u0005¢\u0006\u0006\u001a\u0004\b3\u00104R\u0011\u00107\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b6\u0010$R\u0011\u00109\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b8\u0010$R\u0013\u0010=\u001a\u0004\u0018\u00010:8F¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0011\u0010?\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b>\u0010$¨\u0006@"}, d2 = {"Lcom/upuphone/ar/tici/phone/TiciApp;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "Lcom/upuphone/ar/tici/phone/starrynet/TiciStarryMsgManager;", "q", "()Lcom/upuphone/ar/tici/phone/starrynet/TiciStarryMsgManager;", "Landroid/content/Context;", "a", "()Landroid/content/Context;", "Lcom/upuphone/ar/tici/phone/db/TiciDao;", "w", "()Lcom/upuphone/ar/tici/phone/db/TiciDao;", "Lcom/upuphone/ar/tici/phone/utils/TiciHostConfig$HostProvider;", "hostProvider", "", "m", "(Lcom/upuphone/ar/tici/phone/utils/TiciHostConfig$HostProvider;)V", "context", "t", "(Landroid/content/Context;)V", "Landroid/app/Activity;", "r", "(Landroid/app/Activity;)V", "Lcom/upuphone/xr/interconnect/listener/DeviceConnectionListener;", "listener", "s", "(Lcom/upuphone/xr/interconnect/listener/DeviceConnectionListener;)V", "v", "Lcom/upuphone/ar/tici/phone/TiciAppViewModel;", "c", "()Lcom/upuphone/ar/tici/phone/TiciAppViewModel;", "e", "p", "", "d", "()Z", "", "resId", "x", "(I)V", "Lkotlin/Lazy;", "k", "starryNetManager", "Lcom/upuphone/ar/tici/phone/db/TiciDatabase;", "h", "()Lcom/upuphone/ar/tici/phone/db/TiciDatabase;", "database", "f", "appViewModel", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "j", "hasAccountAndBoundGlass", "l", "supportLargeFile", "", "g", "()Ljava/lang/String;", "currentUserId", "n", "isTiciStarting", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
public final class TiciApp implements CoroutineScope {
    public static final TiciApp b = new TiciApp();
    public static final Lazy c = LazyKt.lazy(TiciApp$starryNetManager$2.INSTANCE);
    public static final Lazy d = LazyKt.lazy(TiciApp$database$2.INSTANCE);
    public static final Lazy e = LazyKt.lazy(TiciApp$appViewModel$2.INSTANCE);

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f5877a = CoroutineScopeKt.b();

    public final Context a() {
        return SdkContext.f6675a.c().getContext();
    }

    public final TiciAppViewModel c() {
        return f();
    }

    public final boolean d() {
        return true;
    }

    public final void e() {
        f().I0((TiciEntity) null);
    }

    public final TiciAppViewModel f() {
        return (TiciAppViewModel) e.getValue();
    }

    public final String g() {
        IAccountInfo b2 = SdkContext.f6675a.b().b();
        if (b2 != null) {
            return b2.getId();
        }
        return null;
    }

    public CoroutineContext getCoroutineContext() {
        return this.f5877a.getCoroutineContext();
    }

    public final TiciDatabase h() {
        return (TiciDatabase) d.getValue();
    }

    public final boolean j() {
        return true;
    }

    public final TiciStarryMsgManager k() {
        return (TiciStarryMsgManager) c.getValue();
    }

    public final boolean l() {
        return c().V();
    }

    public final void m(TiciHostConfig.HostProvider hostProvider) {
        Intrinsics.checkNotNullParameter(hostProvider, "hostProvider");
        CommonExtKt.e("init->", "TiciApp");
        TiciHostConfig.f6003a.b(hostProvider);
        q();
    }

    public final boolean n() {
        return c().w0();
    }

    public final void p() {
        c().B0();
    }

    public final TiciStarryMsgManager q() {
        return k();
    }

    public final void r(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "context");
        activity.startActivity(new Intent(activity, TiciFileTipsActivity.class));
    }

    public final void s(DeviceConnectionListener deviceConnectionListener) {
        Intrinsics.checkNotNullParameter(deviceConnectionListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        CommonExtKt.e("startListenDeviceConnect-> " + deviceConnectionListener, "TiciApp");
        q().registerDeviceConnectListener(deviceConnectionListener);
    }

    public final void t(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        CommonExtKt.e("startMainActivity: ", "TiciApp");
        Intent intent = new Intent(context, TiciMainActivity.class);
        intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
        context.startActivity(intent);
    }

    public final void v(DeviceConnectionListener deviceConnectionListener) {
        Intrinsics.checkNotNullParameter(deviceConnectionListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        CommonExtKt.e("stopListenDeviceConnect-> " + deviceConnectionListener, "TiciApp");
        q().unregisterDeviceConnectListener(deviceConnectionListener);
    }

    public final TiciDao w() {
        return h().f();
    }

    public final void x(int i) {
        CommonExtKt.j(a(), i, 0, 2, (Object) null);
    }
}
