package com.upuphone.xr.sapp.glass;

import android.content.Context;
import android.net.Uri;
import com.upuphone.star.fota.phone.GlassUpdateInfo;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.air.AirHelper;
import com.upuphone.xr.sapp.common.Constants;
import com.upuphone.xr.sapp.entity.GlassUpdateState;
import com.upuphone.xr.sapp.utils.AppUtils;
import com.upuphone.xr.sapp.utils.ModelIdExtKt;
import java.io.File;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u00012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H@¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H@¢\u0006\u0004\b\u0016\u0010\u0014J\"\u0010\u0019\u001a\u00020\u00152\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0018\u001a\u00020\u0017H@¢\u0006\u0004\b\u0019\u0010\u001aJ*\u0010\u001e\u001a\u00020\u001d2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bH@¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b#\u0010$J\u001a\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010\u0011\u001a\u00020\u0010H@¢\u0006\u0004\b&\u0010\u0014J\u001c\u0010'\u001a\u0004\u0018\u00010\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H@¢\u0006\u0004\b'\u0010\u0014J5\u0010,\u001a\u00020\u00042\u0006\u0010(\u001a\u00020 2\u0006\u0010*\u001a\u00020)2\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005¢\u0006\u0004\b,\u0010-J5\u0010.\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)2\u0006\u0010(\u001a\u00020 2\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005¢\u0006\u0004\b.\u0010/J\r\u00100\u001a\u00020\u0015¢\u0006\u0004\b0\u00101J\u0015\u00104\u001a\u00020\b2\u0006\u00103\u001a\u000202¢\u0006\u0004\b4\u00105J\r\u00106\u001a\u00020\u0015¢\u0006\u0004\b6\u00101J\u0017\u00108\u001a\u0002072\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b8\u00109R\u001b\u0010?\u001a\u00020:8BX\u0002¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001b\u0010D\u001a\u00020@8BX\u0002¢\u0006\f\n\u0004\bA\u0010<\u001a\u0004\bB\u0010CR\u0014\u0010H\u001a\u00020E8\u0016X\u0005¢\u0006\u0006\u001a\u0004\bF\u0010G¨\u0006I"}, d2 = {"Lcom/upuphone/xr/sapp/glass/GlassUpdateAdapter;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Function1;", "Lcom/upuphone/xr/sapp/entity/GlassUpdateState;", "", "Lcom/upuphone/xr/sapp/glass/GlassUpdateStateCallback;", "<init>", "()V", "", "msg", "t", "(Ljava/lang/String;)V", "v", "glassUpdateState", "s", "(Lcom/upuphone/xr/sapp/entity/GlassUpdateState;)V", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "device", "Lcom/upuphone/xr/sapp/entity/BasicGlassInfo;", "l", "(Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "g", "", "requiredStorage", "e", "(Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "version", "digest", "", "f", "(Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/io/File;", "file", "Landroid/net/Uri;", "j", "(Ljava/io/File;)Landroid/net/Uri;", "Lcom/upuphone/xr/sapp/entity/BasicGlassResponse;", "w", "h", "downloadFile", "Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "glassUpdateInfo", "stateCallback", "y", "(Ljava/io/File;Lcom/upuphone/star/fota/phone/GlassUpdateInfo;Lkotlin/jvm/functions/Function1;)V", "x", "(Lcom/upuphone/star/fota/phone/GlassUpdateInfo;Ljava/io/File;Lkotlin/jvm/functions/Function1;)V", "p", "()I", "Landroid/content/Context;", "context", "n", "(Landroid/content/Context;)Ljava/lang/String;", "m", "Lcom/upuphone/xr/sapp/glass/IGlassUpdater;", "q", "(Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;)Lcom/upuphone/xr/sapp/glass/IGlassUpdater;", "Lcom/upuphone/xr/sapp/glass/AirGlassUpdater;", "c", "Lkotlin/Lazy;", "k", "()Lcom/upuphone/xr/sapp/glass/AirGlassUpdater;", "airGlassUpdater", "Lcom/upuphone/xr/sapp/glass/StarGlassUpdater;", "d", "r", "()Lcom/upuphone/xr/sapp/glass/StarGlassUpdater;", "starGlassUpdater", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class GlassUpdateAdapter implements CoroutineScope, Function1<GlassUpdateState, Unit> {
    public static final GlassUpdateAdapter b = new GlassUpdateAdapter();
    public static final Lazy c = LazyKt.lazy(GlassUpdateAdapter$airGlassUpdater$2.INSTANCE);
    public static final Lazy d = LazyKt.lazy(GlassUpdateAdapter$starGlassUpdater$2.INSTANCE);

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f7061a = CoroutineScopeKt.b();

    /* access modifiers changed from: private */
    public final void t(String str) {
        GlassUpdateHelper glassUpdateHelper = GlassUpdateHelper.b;
        glassUpdateHelper.d1("GlassUpdateAdapter|" + str);
    }

    /* access modifiers changed from: private */
    public final void v(String str) {
        GlassUpdateHelper glassUpdateHelper = GlassUpdateHelper.b;
        glassUpdateHelper.e1("GlassUpdateAdapter|" + str);
    }

    public final Object e(StarryNetDevice starryNetDevice, long j, Continuation continuation) {
        if (starryNetDevice != null) {
            return q(starryNetDevice).f(j, continuation);
        }
        v("checkGlassInfo, device is null");
        return Boxing.boxInt(101);
    }

    public final Object f(StarryNetDevice starryNetDevice, String str, String str2, Continuation continuation) {
        if (starryNetDevice != null) {
            return q(starryNetDevice).h(str, str2, continuation);
        }
        v("checkGlassInfo, device is null");
        return Boxing.boxBoolean(false);
    }

    public final Object g(StarryNetDevice starryNetDevice, Continuation continuation) {
        if (starryNetDevice != null) {
            return q(starryNetDevice).e(continuation);
        }
        v("checkRemoteGlassUpdateState, device is null");
        return Boxing.boxInt(101);
    }

    public CoroutineContext getCoroutineContext() {
        return this.f7061a.getCoroutineContext();
    }

    public final Object h(StarryNetDevice starryNetDevice, Continuation continuation) {
        if (starryNetDevice != null) {
            return q(starryNetDevice).d(continuation);
        }
        v("fetchGlassUpdateState, device is null");
        return null;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        s((GlassUpdateState) obj);
        return Unit.INSTANCE;
    }

    public final Uri j(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return AppUtils.f7842a.d(file, Constants.f6657a.b());
    }

    public final AirGlassUpdater k() {
        return (AirGlassUpdater) c.getValue();
    }

    public final Object l(StarryNetDevice starryNetDevice, Continuation continuation) {
        return q(starryNetDevice).j(continuation);
    }

    public final int m() {
        StarryNetDevice w = GlassHelper.f7049a.w();
        String modelId = w != null ? w.getModelId() : null;
        return (modelId == null || !ModelIdExtKt.d(modelId)) ? 50 : 30;
    }

    public final String n(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Boolean bool = BuildConfig.b;
        Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
        if (bool.booleanValue()) {
            String string = context.getString(R.string.glass_system_update_notice_installing_third, new Object[]{String.valueOf(p())});
            Intrinsics.checkNotNull(string);
            return string;
        }
        String string2 = context.getString(R.string.glass_system_update_notice_installing, new Object[]{String.valueOf(p())});
        Intrinsics.checkNotNull(string2);
        return string2;
    }

    public final int p() {
        StarryNetDevice w = GlassHelper.f7049a.w();
        String modelId = w != null ? w.getModelId() : null;
        if (modelId == null) {
            return 10;
        }
        return (!ModelIdExtKt.d(modelId) && !ModelIdExtKt.b(modelId)) ? 10 : 5;
    }

    public final IGlassUpdater q(StarryNetDevice starryNetDevice) {
        return AirHelper.b.I(starryNetDevice) ? k() : r();
    }

    public final StarGlassUpdater r() {
        return (StarGlassUpdater) d.getValue();
    }

    public void s(GlassUpdateState glassUpdateState) {
        Intrinsics.checkNotNullParameter(glassUpdateState, "glassUpdateState");
        GlassUpdateHelper.b.v1(glassUpdateState);
    }

    public final Object w(StarryNetDevice starryNetDevice, Continuation continuation) {
        return q(starryNetDevice).c(continuation);
    }

    public final void x(GlassUpdateInfo glassUpdateInfo, File file, Function1 function1) {
        Intrinsics.checkNotNullParameter(glassUpdateInfo, "glassUpdateInfo");
        Intrinsics.checkNotNullParameter(file, "downloadFile");
        Intrinsics.checkNotNullParameter(function1, "stateCallback");
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new GlassUpdateAdapter$sendShowUpdateDialogCmd$1(function1, glassUpdateInfo, file, (Continuation<? super GlassUpdateAdapter$sendShowUpdateDialogCmd$1>) null), 3, (Object) null);
    }

    public final void y(File file, GlassUpdateInfo glassUpdateInfo, Function1 function1) {
        Intrinsics.checkNotNullParameter(file, "downloadFile");
        Intrinsics.checkNotNullParameter(glassUpdateInfo, "glassUpdateInfo");
        Intrinsics.checkNotNullParameter(function1, "stateCallback");
        StarryNetDevice x = GlassHelper.f7049a.x();
        if (x == null) {
            v("transferFileAndInstall, connectedDevice is null");
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
            function1.invoke(new GlassUpdateState.TransferFail(uuid, glassUpdateInfo, 101, (String) null, 8, (DefaultConstructorMarker) null));
            return;
        }
        q(x).g(file, glassUpdateInfo);
    }
}
