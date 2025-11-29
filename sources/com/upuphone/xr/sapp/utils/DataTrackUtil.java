package com.upuphone.xr.sapp.utils;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import com.google.gson.Gson;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.datatrack.base.utils.XJDeviceUtil;
import com.upuphone.datatrack.sdk.XJDataTrack;
import com.upuphone.datatrack.sdk.XJDataTrackConfig;
import com.upuphone.datatrack.sdk.XJTriggerScan;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.common.MzAccountManager;
import com.upuphone.xr.sapp.context.DataTrackContext;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.datatrack.AppDataTrackEvent;
import com.upuphone.xr.sapp.datatrack.BluetoothEventReporter;
import com.upuphone.xr.sapp.datatrack.DataTrackRuleHelper;
import com.upuphone.xr.sapp.entity.DeviceInfo;
import com.upuphone.xr.sapp.entity.GlassActiveData;
import com.upuphone.xr.sapp.entity.UnicronBatteryInfo;
import com.upuphone.xr.sapp.monitor.net.TokenInterceptor;
import com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper;
import com.xjmz.myvu.ext.ConnectExtKt;
import com.xjsd.ai.assistant.encrypt.DigestUtils;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\r\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014¢\u0006\u0004\b\u0019\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u0011J%\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u000eJM\u0010$\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\t2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u001f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b$\u0010%J3\u0010(\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\t2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u001f2\b\b\u0002\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)JQ\u0010*\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\t2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u001f2\b\u0010!\u001a\u0004\u0018\u00010\t2\b\u0010\"\u001a\u0004\u0018\u00010\t2\b\u0010#\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010'\u001a\u00020&¢\u0006\u0004\b*\u0010+J)\u0010,\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\t2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001f¢\u0006\u0004\b,\u0010-J?\u0010.\u001a\u00020\u00062\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u001f2\b\u0010!\u001a\u0004\u0018\u00010\t2\b\u0010\"\u001a\u0004\u0018\u00010\t2\b\u0010#\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b.\u0010/J\u0015\u00100\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t¢\u0006\u0004\b0\u00101J\u0015\u00104\u001a\u00020\u00062\u0006\u00103\u001a\u000202¢\u0006\u0004\b4\u00105J\u0015\u00108\u001a\u00020\u00062\u0006\u00107\u001a\u000206¢\u0006\u0004\b8\u00109J\r\u0010:\u001a\u00020\u0006¢\u0006\u0004\b:\u0010\u0003J\r\u0010;\u001a\u00020\u0006¢\u0006\u0004\b;\u0010\u0003J\u0017\u0010>\u001a\u00020\u00062\u0006\u0010=\u001a\u00020<H\u0002¢\u0006\u0004\b>\u0010?JT\u0010@\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\t2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u001f2\b\u0010!\u001a\u0004\u0018\u00010\t2\b\u0010\"\u001a\u0004\u0018\u00010\t2\b\u0010#\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010'\u001a\u00020&H@¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\tH\u0002¢\u0006\u0004\bB\u0010CR\u0016\u0010E\u001a\u00020&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010DR\u0014\u0010H\u001a\u00020F8\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010GR\u001b\u0010K\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\bB\u0010I\u001a\u0004\bJ\u0010CR\u0016\u0010L\u001a\u00020&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010D¨\u0006M"}, d2 = {"Lcom/upuphone/xr/sapp/utils/DataTrackUtil;", "", "<init>", "()V", "Landroid/app/Application;", "application", "", "g", "(Landroid/app/Application;)V", "", "glassSn", "model", "glassRom", "b", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "msg", "s", "(Ljava/lang/String;)V", "Lcom/upuphone/xr/sapp/entity/DeviceInfo;", "deviceInfo", "", "duration", "timestamp", "v", "(Lcom/upuphone/xr/sapp/entity/DeviceInfo;JJ)V", "t", "u", "sn", "romVersion", "x", "eventName", "", "attributes", "iotDeviceId", "iotDeviceModel", "iotDeviceRom", "q", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "isSync", "l", "(Ljava/lang/String;Ljava/util/Map;Z)V", "k", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "i", "(Ljava/lang/String;Ljava/util/Map;)V", "o", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "f", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/content/Context;", "context", "h", "(Landroid/content/Context;)V", "", "throwable", "j", "(Ljava/lang/Throwable;)V", "c", "w", "Lcom/upuphone/xr/sapp/entity/GlassActiveData;", "activeData", "y", "(Lcom/upuphone/xr/sapp/entity/GlassActiveData;)V", "p", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "()Ljava/lang/String;", "Z", "enableMYVUDataTrack", "Lcom/google/gson/Gson;", "Lcom/google/gson/Gson;", "mGson", "Lkotlin/Lazy;", "e", "OVERSEA_GLASS_ACTIVE", "reportPairState", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nDataTrackUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataTrackUtil.kt\ncom/upuphone/xr/sapp/utils/DataTrackUtil\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,641:1\n1#2:642\n*E\n"})
public final class DataTrackUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final DataTrackUtil f7875a = new DataTrackUtil();
    public static boolean b = true;
    public static final Gson c = new Gson();
    public static final Lazy d = LazyKt.lazy(DataTrackUtil$OVERSEA_GLASS_ACTIVE$2.INSTANCE);
    public static boolean e;

    public static /* synthetic */ void m(DataTrackUtil dataTrackUtil, String str, Map map, String str2, String str3, String str4, boolean z, int i, Object obj) {
        if ((i & 32) != 0) {
            z = false;
        }
        dataTrackUtil.k(str, map, str2, str3, str4, z);
    }

    public static /* synthetic */ void n(DataTrackUtil dataTrackUtil, String str, Map map, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        dataTrackUtil.l(str, map, z);
    }

    public static /* synthetic */ void r(DataTrackUtil dataTrackUtil, String str, Map map, String str2, String str3, String str4, int i, Object obj) {
        dataTrackUtil.q(str, map, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4);
    }

    public final void b(String str, String str2, String str3) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("DataTrackUtil", "collectBaseData, glassSn: " + str + ", model: " + str2 + ", glassRom: " + str3);
        if (!(str == null || str.length() == 0)) {
            XJDeviceUtil.y(f(str));
        }
        if (!(str3 == null || str3.length() == 0)) {
            XJDeviceUtil.A(str3);
        }
        if (str2 != null) {
            DataTrackRuleHelper.b.k(str2);
            XJDeviceUtil.z(str2);
            if (Intrinsics.areEqual((Object) str2, (Object) "XGA020C")) {
                XJDeviceUtil.B(4);
            } else if (Intrinsics.areEqual((Object) str2, (Object) "XGA010C")) {
                XJDeviceUtil.B(3);
            } else {
                XJDeviceUtil.B(2);
            }
        }
    }

    public final void c() {
        String a2 = DynamicAdapterUtils.f7879a.a();
        PhoneTypeUtils phoneTypeUtils = PhoneTypeUtils.f7912a;
        Pair pair = TuplesKt.to("system_type", phoneTypeUtils.b());
        Pair pair2 = TuplesKt.to("Mobile Brand_type", phoneTypeUtils.a());
        Pair pair3 = TuplesKt.to(RtspHeaders.Values.TIME, String.valueOf(System.currentTimeMillis()));
        String str = "XGA010C";
        if (!Intrinsics.areEqual((Object) a2, (Object) str)) {
            str = "XGZ020C";
        }
        i("app_topic_APP_Bluetoothconnectivity", MapsKt.hashMapOf(pair, pair2, pair3, TuplesKt.to("glasses_type", str)));
    }

    public final String d() {
        DynamicAdapterUtils dynamicAdapterUtils = DynamicAdapterUtils.f7879a;
        return ModelIdExtKt.b(dynamicAdapterUtils.a()) ? "XGA010C" : ModelIdExtKt.d(dynamicAdapterUtils.a()) ? "XGA020C" : "XGZ020C";
    }

    public final String e() {
        return (String) d.getValue();
    }

    public final String f(String str) {
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_STR_SN);
        String l = DigestUtils.l("RhdNS`Z?" + str);
        Intrinsics.checkNotNullExpressionValue(l, "sha256Hex(...)");
        return l;
    }

    public final void g(Application application) {
        Intrinsics.checkNotNullParameter(application, VuiModelType.APPLICATION);
        ULog.Delegate delegate = ULog.f6446a;
        String d2 = XJDeviceUtil.d(application);
        delegate.g("DataTrackUtil", "DataTrackUtil.init, deviceId: " + d2);
        XJDataTrackConfig.c(Intrinsics.areEqual((Object) BuildConfig.f6575a, (Object) Boolean.TRUE) ^ true);
        try {
            XJDataTrack.i(6, application, "phone-navi", false);
            DeviceInfo o = ControlUtils.f7858a.o();
            if (o != null) {
                f7875a.b(o.getSerialNo(), o.getModel(), o.getRomVersion());
            }
        } catch (Exception e2) {
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.c("DataTrackUtil", "DataTrackUtil.init, error: " + e2);
        }
        BluetoothEventReporter bluetoothEventReporter = BluetoothEventReporter.f6912a;
        DataTrackRuleHelper dataTrackRuleHelper = DataTrackRuleHelper.b;
    }

    public final void h(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ULog.f6446a.g("DataTrackUtil", "manualUploadDatas");
        if (MainApplication.k.a()) {
            XJTriggerScan.g(context);
        }
    }

    public final void i(String str, Map map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, "attributes");
        if (b) {
            try {
                if (((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), "sp_user_agreement_state", Boolean.FALSE, (Context) null, 4, (Object) null)).booleanValue()) {
                    n(this, str, map, false, 4, (Object) null);
                }
            } catch (Exception e2) {
                ULog.Delegate delegate = ULog.f6446a;
                String message = e2.getMessage();
                delegate.c("DataTrackUtil", "myvuDataReport::e is: " + message);
            }
        }
    }

    public final void j(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "throwable");
        try {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.c("DataTrackUtil", "onAppCrash, throwable: " + th);
            l("app_topic_crash", MapsKt.hashMapOf(TuplesKt.to("crash_status", CollectionsKt.joinToString$default(TextStreamsKt.readLines(new StringReader(ExceptionsKt.stackTraceToString(th))), MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null))), true);
        } catch (Exception unused) {
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.c("DataTrackUtil", "onAppCrash, error: " + th);
        }
    }

    public final void k(String str, Map map, String str2, String str3, String str4, boolean z) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, "attributes");
        if (z) {
            Object unused = BuildersKt__BuildersKt.b((CoroutineContext) null, new DataTrackUtil$reportEvent$1(str, map, str2, str3, str4, z, (Continuation<? super DataTrackUtil$reportEvent$1>) null), 1, (Object) null);
        } else {
            Job unused2 = BuildersKt__Builders_commonKt.d(GlobalScope.f3732a, (CoroutineContext) null, (CoroutineStart) null, new DataTrackUtil$reportEvent$2(str, map, str2, str3, str4, z, (Continuation<? super DataTrackUtil$reportEvent$2>) null), 3, (Object) null);
        }
    }

    public final void l(String str, Map map, boolean z) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, "attributes");
        if (SdkContext.f6675a.c().e()) {
            r(this, str, map, (String) null, (String) null, (String) null, 28, (Object) null);
        } else {
            k(str, map, (String) null, (String) null, (String) null, z);
        }
    }

    public final void o(Map map, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(map, "attributes");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("DataTrackUtil", "reportEventByTrack, attributes: " + map);
        delegate.g("DataTrackUtil", "reportEventByTrack, iotDeviceId: " + str + ", iotDeviceModel: " + str2 + ", iotDeviceRom: " + str3);
        try {
            String e2 = MzAccountManager.c.b().e();
            if (e2 != null) {
                if (e2.length() != 0) {
                    XJDataTrack.h().p(e2);
                    XJDataTrack.h().o(new HashMap(map), str, str2, str3);
                    delegate.g("DataTrackUtil", "reportEventByTrack, end");
                }
            }
            delegate.c("DataTrackUtil", "reportEventByTrack, userId is empty");
            XJDataTrack.h().o(new HashMap(map), str, str2, str3);
            delegate.g("DataTrackUtil", "reportEventByTrack, end");
        } catch (Exception e3) {
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.c("DataTrackUtil", "reportEventByTrack, error: " + e3);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: java.util.Map} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00e1 A[Catch:{ Exception -> 0x00e6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e8 A[Catch:{ Exception -> 0x00e6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00eb A[Catch:{ Exception -> 0x00e6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object p(java.lang.String r8, java.util.Map r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, boolean r13, kotlin.coroutines.Continuation r14) {
        /*
            r7 = this;
            boolean r0 = r14 instanceof com.upuphone.xr.sapp.utils.DataTrackUtil$reportEventSuspend$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.upuphone.xr.sapp.utils.DataTrackUtil$reportEventSuspend$1 r0 = (com.upuphone.xr.sapp.utils.DataTrackUtil$reportEventSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.utils.DataTrackUtil$reportEventSuspend$1 r0 = new com.upuphone.xr.sapp.utils.DataTrackUtil$reportEventSuspend$1
            r0.<init>(r7, r14)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r14 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 1
            java.lang.String r3 = "DataTrackUtil"
            if (r1 == 0) goto L_0x004d
            if (r1 != r2) goto L_0x0045
            boolean r13 = r0.Z$0
            java.lang.Object r8 = r0.L$4
            r12 = r8
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r8 = r0.L$3
            r11 = r8
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r8 = r0.L$2
            r10 = r8
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r8 = r0.L$1
            r9 = r8
            java.util.Map r9 = (java.util.Map) r9
            java.lang.Object r8 = r0.L$0
            java.lang.String r8 = (java.lang.String) r8
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x00b1
        L_0x0045:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r7)
            com.upuphone.star.core.log.ULog$Delegate r7 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "reportEvent, event: "
            r1.append(r4)
            r1.append(r8)
            java.lang.String r5 = ", attributes: "
            r1.append(r5)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            r7.g(r3, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            r1.append(r8)
            java.lang.String r4 = ", iotDeviceId: "
            r1.append(r4)
            r1.append(r10)
            java.lang.String r4 = ", iotDeviceModel: "
            r1.append(r4)
            r1.append(r11)
            java.lang.String r4 = ", iotDeviceRom: "
            r1.append(r4)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            r7.g(r3, r1)
            if (r13 != 0) goto L_0x00d2
            com.upuphone.xr.sapp.datatrack.DataTrackRuleHelper r7 = com.upuphone.xr.sapp.datatrack.DataTrackRuleHelper.b
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r10
            r0.L$3 = r11
            r0.L$4 = r12
            r0.Z$0 = r13
            r0.label = r2
            java.lang.Object r7 = r7.p(r8, r0)
            if (r7 != r14) goto L_0x00b1
            return r14
        L_0x00b1:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x00d2
            com.upuphone.star.core.log.ULog$Delegate r7 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "reportEvent, block event: "
            r9.append(r10)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            r7.c(r3, r8)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x00d2:
            r7 = r9
            r14 = r12
            r9 = r8
            r12 = r10
            r6 = r13
            r13 = r11
            r11 = r6
            com.upuphone.xr.sapp.common.MzAccountManager$Companion r8 = com.upuphone.xr.sapp.common.MzAccountManager.c     // Catch:{ Exception -> 0x00e6 }
            com.upuphone.xr.sapp.entity.AccountInfo r8 = r8.a()     // Catch:{ Exception -> 0x00e6 }
            if (r8 == 0) goto L_0x00e8
            java.lang.String r8 = r8.getMzUid()     // Catch:{ Exception -> 0x00e6 }
            goto L_0x00e9
        L_0x00e6:
            r7 = move-exception
            goto L_0x0115
        L_0x00e8:
            r8 = 0
        L_0x00e9:
            if (r8 == 0) goto L_0x00fa
            int r10 = r8.length()     // Catch:{ Exception -> 0x00e6 }
            if (r10 != 0) goto L_0x00f2
            goto L_0x00fa
        L_0x00f2:
            com.upuphone.datatrack.sdk.XJDataTrack r10 = com.upuphone.datatrack.sdk.XJDataTrack.h()     // Catch:{ Exception -> 0x00e6 }
            r10.p(r8)     // Catch:{ Exception -> 0x00e6 }
            goto L_0x0101
        L_0x00fa:
            com.upuphone.star.core.log.ULog$Delegate r8 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r10 = "reportEvent, userId is empty"
            r8.c(r3, r10)     // Catch:{ Exception -> 0x00e6 }
        L_0x0101:
            java.util.HashMap r10 = new java.util.HashMap     // Catch:{ Exception -> 0x00e6 }
            r10.<init>(r7)     // Catch:{ Exception -> 0x00e6 }
            com.upuphone.datatrack.sdk.XJDataTrack r8 = com.upuphone.datatrack.sdk.XJDataTrack.h()     // Catch:{ Exception -> 0x00e6 }
            r8.n(r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x00e6 }
            com.upuphone.star.core.log.ULog$Delegate r7 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ Exception -> 0x00e6 }
            java.lang.String r8 = "reportEvent, end"
            r7.g(r3, r8)     // Catch:{ Exception -> 0x00e6 }
            goto L_0x012b
        L_0x0115:
            com.upuphone.star.core.log.ULog$Delegate r8 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "reportEvent, error: "
            r9.append(r10)
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            r8.c(r3, r7)
        L_0x012b:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.utils.DataTrackUtil.p(java.lang.String, java.util.Map, java.lang.String, java.lang.String, java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void q(String str, Map map, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, "attributes");
    }

    public final void s(String str) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        try {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.g("DataTrackUtil", "reportGlassActive, msg: " + str2);
            GlassActiveData glassActiveData = (GlassActiveData) c.fromJson(str2, GlassActiveData.class);
            Intrinsics.checkNotNull(glassActiveData);
            y(glassActiveData);
            String b2 = StringExtKt.b(glassActiveData.getRomVersion(), new DataTrackUtil$reportGlassActive$romVersion$1(glassActiveData));
            String f = f(glassActiveData.getSn());
            Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("duration", Long.valueOf(glassActiveData.getDuration())), TuplesKt.to("ip", ""), TuplesKt.to("model", glassActiveData.getModel()), TuplesKt.to("option", ""), TuplesKt.to("rom_version", b2), TuplesKt.to(PayloadConstant.PARAMS_KEY_STR_SN, f), TuplesKt.to("timestamp", Long.valueOf(glassActiveData.getTimestamp())));
            String romVersion = glassActiveData.getRomVersion();
            m(this, "xr_activation_event", mutableMapOf, f, glassActiveData.getModel(), romVersion, false, 32, (Object) null);
        } catch (Exception e2) {
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.c("DataTrackUtil", "reportGlassActive init failed, " + e2);
        }
    }

    public final void t(DeviceInfo deviceInfo, long j, long j2) {
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("DataTrackUtil", "reportGlassActiveIntl");
        try {
            MediaType parse = MediaType.Companion.parse(HttpHeaders.Values.APPLICATION_JSON);
            String f = deviceInfo.getSerialNo() == null ? "" : f(deviceInfo.getSerialNo());
            Settings.Secure.getString(GlobalExtKt.f().getContentResolver(), "android_id");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("iotDeviceId", f);
            jSONObject.put("duration", j);
            jSONObject.put("iotModel", deviceInfo.getModel());
            jSONObject.put("iotRomVersion", deviceInfo.getRomVersion());
            jSONObject.put("brand", Build.BRAND);
            jSONObject.put("manufacturer", Build.MANUFACTURER);
            jSONObject.put("deviceModel", Build.MODEL);
            String str = Build.VERSION.RELEASE;
            jSONObject.put("os", "android" + str);
            jSONObject.put("appPkgName", GlobalExtKt.f().getPackageName());
            jSONObject.put("appVer", "2.40.51");
            jSONObject.put("debug", 0);
            jSONObject.put("timestamp", j2);
            RequestBody.Companion companion = RequestBody.Companion;
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
            RequestBody create = companion.create(parse, jSONObject2);
            Request build = new Request.Builder().url(e()).post(create).build();
            OkHttpClient build2 = new OkHttpClient.Builder().addInterceptor(new TokenInterceptor()).build();
            delegate.g("DataTrackUtil", "reportGlassActiveIntl formBody =" + create + " request is: " + build + " and requestParameter is: " + jSONObject);
            build2.newCall(build).enqueue(new DataTrackUtil$reportGlassActiveIntl$1());
        } catch (Exception e2) {
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.c("DataTrackUtil", "reportGlassActiveIntl init failed, " + e2);
        }
    }

    public final void u(String str) {
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("DataTrackUtil", "reportGlassActiveIntl::mas is: " + str);
        GlassActiveData glassActiveData = (GlassActiveData) c.fromJson(str, GlassActiveData.class);
        String b2 = StringExtKt.b(glassActiveData.getRomVersion(), new DataTrackUtil$reportGlassActiveIntl$romVersion$1(glassActiveData));
        try {
            MediaType parse = MediaType.Companion.parse(HttpHeaders.Values.APPLICATION_JSON);
            Settings.Secure.getString(GlobalExtKt.f().getContentResolver(), "android_id");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("iotDeviceId", f(glassActiveData.getSn()));
            jSONObject.put("duration", glassActiveData.getDuration());
            jSONObject.put("iotModel", d());
            jSONObject.put("iotRomVersion", b2);
            jSONObject.put("brand", Build.BRAND);
            jSONObject.put("manufacturer", Build.MANUFACTURER);
            jSONObject.put("deviceModel", Build.MODEL);
            String str2 = Build.VERSION.RELEASE;
            jSONObject.put("os", "android" + str2);
            jSONObject.put("appPkgName", GlobalExtKt.f().getPackageName());
            jSONObject.put("appVer", "2.40.51");
            jSONObject.put("debug", 0);
            jSONObject.put("timestamp", glassActiveData.getTimestamp());
            RequestBody.Companion companion = RequestBody.Companion;
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
            RequestBody create = companion.create(parse, jSONObject2);
            Request build = new Request.Builder().url(e()).post(create).build();
            OkHttpClient build2 = new OkHttpClient.Builder().addInterceptor(new TokenInterceptor()).build();
            delegate.g("DataTrackUtil", "reportGlassActiveIntl formBody =" + create + " request is: " + build + " and requestParameter is: " + jSONObject);
            build2.newCall(build).enqueue(new DataTrackUtil$reportGlassActiveIntl$2());
        } catch (Exception e2) {
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.c("DataTrackUtil", "reportGlassActiveIntl init failed, " + e2);
        }
    }

    public final void v(DeviceInfo deviceInfo, long j, long j2) {
        DeviceInfo deviceInfo2 = deviceInfo;
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        ULog.Delegate delegate = ULog.f6446a;
        String serialNo = deviceInfo.getSerialNo();
        delegate.g("DataTrackUtil", "reportGlassesActive::sn is: " + serialNo);
        String serialNo2 = deviceInfo.getSerialNo();
        String str = "";
        if (serialNo2 == null) {
            serialNo2 = str;
        }
        String f = f(serialNo2);
        Pair pair = TuplesKt.to("duration", String.valueOf(j));
        Pair pair2 = TuplesKt.to("ip", str);
        Pair pair3 = TuplesKt.to("model", deviceInfo.getModel());
        Pair pair4 = TuplesKt.to("option", str);
        String romVersion = deviceInfo.getRomVersion();
        if (romVersion != null) {
            str = romVersion;
        }
        m(this, "xr_activation_event", MapsKt.hashMapOf(pair, pair2, pair3, pair4, TuplesKt.to("rom_version", str), TuplesKt.to(PayloadConstant.PARAMS_KEY_STR_SN, f), TuplesKt.to("timestamp", String.valueOf(j2))), f, deviceInfo.getModel(), deviceInfo.getRomVersion(), false, 32, (Object) null);
    }

    public final void w() {
        String modelId;
        String modelId2;
        ULog.f6446a.c("DataTrackUtil", "reportPairDevices, reportPairState: " + e);
        if (!e) {
            boolean g = StarryMessageHelper.f7799a.g();
            StarryNetDevice a2 = ConnectExtKt.a();
            Boolean bool = null;
            String str = "2";
            if (!(a2 == null || (modelId2 = a2.getModelId()) == null)) {
                boolean d2 = ModelIdExtKt.d(modelId2);
                Boolean valueOf = Boolean.valueOf(d2);
                if (!d2) {
                    valueOf = null;
                }
                if (valueOf != null) {
                    SdkContext.f6675a.d().reportEvent(AppDataTrackEvent.PAIR_DEVICES, MapsKt.hashMapOf(TuplesKt.to(PayloadConstant.KEY_DEVICE_TYPE, "5"), TuplesKt.to("connect", g ? "1" : str)));
                }
            }
            StarryNetDevice a3 = ConnectExtKt.a();
            if (!(a3 == null || (modelId = a3.getModelId()) == null)) {
                boolean b2 = ModelIdExtKt.b(modelId);
                Boolean valueOf2 = Boolean.valueOf(b2);
                if (b2) {
                    bool = valueOf2;
                }
                if (bool != null) {
                    SdkContext.f6675a.d().reportEvent(AppDataTrackEvent.PAIR_DEVICES, MapsKt.hashMapOf(TuplesKt.to(PayloadConstant.KEY_DEVICE_TYPE, "1"), TuplesKt.to("connect", g ? "1" : str)));
                }
            }
            UnicronBatteryInfo m = ControlUtils.f7858a.m();
            if (m.getBound()) {
                DataTrackContext d3 = SdkContext.f6675a.d();
                Pair pair = TuplesKt.to(PayloadConstant.KEY_DEVICE_TYPE, "3");
                if (m.isConnect()) {
                    str = "1";
                }
                d3.reportEvent(AppDataTrackEvent.PAIR_DEVICES, MapsKt.hashMapOf(pair, TuplesKt.to("connect", str)));
            }
            e = true;
        }
    }

    public final void x(String str, String str2, String str3) {
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        Intrinsics.checkNotNullParameter(str4, "model");
        Intrinsics.checkNotNullParameter(str5, PayloadConstant.PARAMS_KEY_STR_SN);
        Intrinsics.checkNotNullParameter(str6, "romVersion");
        String f = f(str5);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("DataTrackUtil", "reportRing2Active, model: " + str4 + ", sn: " + str5 + ", romVersion: " + str6 + ", signSn: " + f);
        try {
            m(this, "xr_activation_event", MapsKt.mutableMapOf(TuplesKt.to("duration", 300000), TuplesKt.to("ip", ""), TuplesKt.to("model", str4), TuplesKt.to("option", ""), TuplesKt.to("rom_version", str6), TuplesKt.to(PayloadConstant.PARAMS_KEY_STR_SN, f), TuplesKt.to("timestamp", Long.valueOf(System.currentTimeMillis()))), f, str, str3, false, 32, (Object) null);
        } catch (Exception e2) {
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.c("DataTrackUtil", "reportRing2Active, error: " + e2);
        }
    }

    public final void y(GlassActiveData glassActiveData) {
        XJDeviceUtil.y(f(glassActiveData.getSn()));
        XJDeviceUtil.z(glassActiveData.getModel());
        String model = glassActiveData.getModel();
        if (Intrinsics.areEqual((Object) model, (Object) "XGA020C")) {
            XJDeviceUtil.B(4);
        } else if (Intrinsics.areEqual((Object) model, (Object) "XGA010C")) {
            XJDeviceUtil.B(3);
        } else {
            XJDeviceUtil.B(2);
        }
    }
}
