package com.upuphone.xr.sapp.unicron;

import android.net.Uri;
import com.honey.account.v8.a;
import com.tencent.mmkv.MMKV;
import com.upuphone.star.fota.phone.GlassUpdateInfo;
import com.upuphone.starrynetsdk.StarryNet;
import com.upuphone.starrynetsdk.ability.share.ShareAbility;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.sapp.common.Constants;
import com.upuphone.xr.sapp.entity.BasicGlassResponse;
import com.upuphone.xr.sapp.entity.CheckUpdateFileReq;
import com.upuphone.xr.sapp.entity.CheckUpdateFileResp;
import com.upuphone.xr.sapp.entity.RequestUpdateFileReq;
import com.upuphone.xr.sapp.entity.UnicronInfo;
import com.upuphone.xr.sapp.glass.FilterShareListener;
import com.upuphone.xr.sapp.glass.GlassHelper;
import com.upuphone.xr.sapp.utils.AppUtils;
import com.upuphone.xr.sapp.utils.JsonUtils;
import java.io.File;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\tJ\u001a\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000bH@¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0004J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ+\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00070\u001cH\u0002¢\u0006\u0004\b\u001f\u0010 R\u001b\u0010%\u001a\u00020!8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\"\u001a\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b+\u0010,R(\u00104\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u00010.8B@BX\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u00065"}, d2 = {"Lcom/upuphone/xr/sapp/unicron/AirUnicronUpdater;", "Lcom/upuphone/xr/sapp/unicron/IUnicronUpdater;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "", "msg", "", "q", "(Ljava/lang/String;)V", "r", "Lcom/upuphone/xr/sapp/entity/CheckUpdateFileReq;", "req", "Lcom/upuphone/xr/sapp/entity/CheckUpdateFileResp;", "c", "(Lcom/upuphone/xr/sapp/entity/CheckUpdateFileReq;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/io/File;", "file", "Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "glassUpdateInfo", "Lcom/upuphone/xr/sapp/entity/UnicronInfo;", "unicronInfo", "a", "(Ljava/io/File;Lcom/upuphone/star/fota/phone/GlassUpdateInfo;Lcom/upuphone/xr/sapp/entity/UnicronInfo;)V", "m", "Lcom/upuphone/xr/sapp/entity/RequestUpdateFileReq;", "s", "(Lcom/upuphone/xr/sapp/entity/RequestUpdateFileReq;)V", "Lkotlin/Function1;", "Lcom/upuphone/xr/sapp/entity/BasicGlassResponse;", "callback", "v", "(Ljava/io/File;Lkotlin/jvm/functions/Function1;)V", "Lcom/upuphone/starrynetsdk/ability/share/ShareAbility;", "Lkotlin/Lazy;", "p", "()Lcom/upuphone/starrynetsdk/ability/share/ShareAbility;", "shareAbility", "Lcom/upuphone/xr/sapp/glass/FilterShareListener;", "d", "Lcom/upuphone/xr/sapp/glass/FilterShareListener;", "filterShareListener", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lcom/upuphone/xr/sapp/unicron/UnicronUpdateConfig;", "value", "n", "()Lcom/upuphone/xr/sapp/unicron/UnicronUpdateConfig;", "t", "(Lcom/upuphone/xr/sapp/unicron/UnicronUpdateConfig;)V", "savedUpdateConfig", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nAirUnicronUpdater.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AirUnicronUpdater.kt\ncom/upuphone/xr/sapp/unicron/AirUnicronUpdater\n+ 2 JsonUtils.kt\ncom/upuphone/xr/sapp/utils/JsonUtils\n*L\n1#1,159:1\n29#2,5:160\n*S KotlinDebug\n*F\n+ 1 AirUnicronUpdater.kt\ncom/upuphone/xr/sapp/unicron/AirUnicronUpdater\n*L\n78#1:160,5\n*E\n"})
public final class AirUnicronUpdater implements IUnicronUpdater, CoroutineScope {
    public static final AirUnicronUpdater b = new AirUnicronUpdater();
    public static final Lazy c = LazyKt.lazy(AirUnicronUpdater$shareAbility$2.INSTANCE);
    public static final FilterShareListener d = new FilterShareListener();

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f7829a = CoroutineScopeKt.b();

    static {
        StarryNet.getInstance().registerInstallListener(new a());
        UnicronHelper.f7834a.d(AnonymousClass2.INSTANCE);
    }

    public static final void e() {
        AirUnicronUpdater airUnicronUpdater = b;
        int registerSendListener = airUnicronUpdater.p().registerSendListener(d);
        airUnicronUpdater.q("registerSendListener code: " + registerSendListener);
    }

    private final ShareAbility p() {
        return (ShareAbility) c.getValue();
    }

    /* access modifiers changed from: private */
    public final void q(String str) {
        UnicronUpdateHelper unicronUpdateHelper = UnicronUpdateHelper.b;
        unicronUpdateHelper.L("AirUnicronUpdater|" + str);
    }

    /* access modifiers changed from: private */
    public final void r(String str) {
        UnicronUpdateHelper unicronUpdateHelper = UnicronUpdateHelper.b;
        unicronUpdateHelper.M("AirUnicronUpdater|" + str);
    }

    public void a(File file, GlassUpdateInfo glassUpdateInfo, UnicronInfo unicronInfo) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(glassUpdateInfo, "glassUpdateInfo");
        Intrinsics.checkNotNullParameter(unicronInfo, "unicronInfo");
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        t(new UnicronUpdateConfig(absolutePath, glassUpdateInfo));
    }

    public Object c(CheckUpdateFileReq checkUpdateFileReq, Continuation continuation) {
        return CheckUpdateFileResp.Companion.exist(false);
    }

    public CoroutineContext getCoroutineContext() {
        return this.f7829a.getCoroutineContext();
    }

    public void m() {
        t((UnicronUpdateConfig) null);
    }

    public final UnicronUpdateConfig n() {
        Object obj;
        JsonUtils jsonUtils = JsonUtils.f7893a;
        String j = MMKV.n().j("unicron._unicron_update_config");
        Type type = new AirUnicronUpdater$special$$inlined$fromJson$1().getType();
        if (Intrinsics.areEqual((Object) type, (Object) Unit.INSTANCE.getClass()) || Intrinsics.areEqual((Object) type, (Object) Void.class)) {
            Intrinsics.checkNotNull(type);
            obj = jsonUtils.a("{}", type);
        } else {
            Intrinsics.checkNotNull(type);
            obj = jsonUtils.a(j, type);
        }
        return (UnicronUpdateConfig) obj;
    }

    public final void s(RequestUpdateFileReq requestUpdateFileReq) {
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new AirUnicronUpdater$prepareTransferFile$1(requestUpdateFileReq, (Continuation<? super AirUnicronUpdater$prepareTransferFile$1>) null), 3, (Object) null);
    }

    public final void t(UnicronUpdateConfig unicronUpdateConfig) {
        MMKV.n().u("unicron._unicron_update_config", JsonUtils.f7893a.d(unicronUpdateConfig));
    }

    public final void v(File file, Function1 function1) {
        StarryNetDevice y = GlassHelper.f7049a.y();
        if (y == null) {
            r("transferFile, glass not connected");
            function1.invoke(BasicGlassResponse.Companion.fail("glass not connected"));
            return;
        }
        Uri d2 = AppUtils.f7842a.d(file, Constants.f6657a.b());
        AirUnicronUpdater$transferFile$shareListener$1 airUnicronUpdater$transferFile$shareListener$1 = new AirUnicronUpdater$transferFile$shareListener$1();
        String bleSend = p().bleSend(y.getDeviceId(), d2, (String) null);
        q("transferFile, ShareAbility#send uri: " + d2 + ", taskId=" + bleSend);
        if (bleSend == null) {
            function1.invoke(BasicGlassResponse.Companion.fail("send file fail"));
            return;
        }
        d.a(airUnicronUpdater$transferFile$shareListener$1, bleSend);
        function1.invoke(BasicGlassResponse.Companion.success());
    }
}
