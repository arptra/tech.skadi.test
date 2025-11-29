package com.upuphone.xr.sapp.monitor.notification;

import android.content.Context;
import com.upuphone.runasone.relay.api.IntentKey;
import com.upuphone.runasone.share.lib.TransferHandler;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.common.MzAccountManager;
import com.upuphone.xr.sapp.context.GlassInfoExtKt;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.datatrack.ReminderDataTrackEvent;
import com.upuphone.xr.sapp.monitor.contact.ContactChangeMonitor;
import com.upuphone.xr.sapp.monitor.notification.business.BusinessManager;
import com.upuphone.xr.sapp.monitor.notification.business.BusinessType;
import com.upuphone.xr.sapp.monitor.notification.constants.NotificationConfig;
import com.upuphone.xr.sapp.monitor.notification.constants.ReminderType;
import com.upuphone.xr.sapp.monitor.notification.missedcall.MissedCallMonitor;
import com.upuphone.xr.sapp.monitor.notification.utils.NotificationHelper;
import com.upuphone.xr.sapp.monitor.sport.SportMonitor;
import com.upuphone.xr.sapp.monitor.starry.NotificationCmdHandler;
import com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper;
import com.upuphone.xr.sapp.monitor.starry.StarryNotificationBase;
import com.upuphone.xr.sapp.monitor.weather.WeatherMonitor;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.JsonUtils;
import com.upuphone.xr.sapp.utils.VersionMatchHelper;
import com.xjsd.ai.assistant.protocol.CmdCode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\r\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u0003J\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u0003J\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0010J\r\u0010\u0012\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0010J\u0015\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0010J\u0015\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u000e¢\u0006\u0004\b!\u0010\u0010J\u0015\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000e¢\u0006\u0004\b#\u0010\u0015J\r\u0010$\u001a\u00020\u000e¢\u0006\u0004\b$\u0010\u0010J\u0015\u0010%\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000e¢\u0006\u0004\b%\u0010\u0015J\r\u0010&\u001a\u00020\u000e¢\u0006\u0004\b&\u0010\u0010J\u0015\u0010'\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000e¢\u0006\u0004\b'\u0010\u0015J\r\u0010)\u001a\u00020(¢\u0006\u0004\b)\u0010*J\u0015\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020(¢\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020\u000e¢\u0006\u0004\b.\u0010\u0010J\u0015\u0010/\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000e¢\u0006\u0004\b/\u0010\u0015J\u0013\u00101\u001a\b\u0012\u0004\u0012\u00020\u000e00¢\u0006\u0004\b1\u00102J\u0013\u00103\u001a\b\u0012\u0004\u0012\u00020\u000e00¢\u0006\u0004\b3\u00102J\r\u00104\u001a\u00020\u000e¢\u0006\u0004\b4\u0010\u0010J\u0015\u00105\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000e¢\u0006\u0004\b5\u0010\u0015J\u001d\u00107\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00172\u0006\u00106\u001a\u00020\u000e¢\u0006\u0004\b7\u00108J\r\u00109\u001a\u00020(¢\u0006\u0004\b9\u0010*J\u0015\u0010:\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020(¢\u0006\u0004\b:\u0010-J\r\u0010;\u001a\u00020\u0004¢\u0006\u0004\b;\u0010\u0003J\r\u0010<\u001a\u00020\u0004¢\u0006\u0004\b<\u0010\u0003R\u0017\u0010B\u001a\u00020=8\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010F\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010#R\u0016\u0010G\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u0010DR\u0016\u0010H\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010DR\u0016\u0010I\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010DR\u0016\u0010K\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010DR\u001c\u0010O\u001a\b\u0012\u0004\u0012\u00020\u000e0L8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u001c\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u000e0L8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u0010NR(\u0010V\u001a\b\u0012\u0004\u0012\u00020\u000e0L8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b&\u0010N\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0016\u0010W\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010DR\u0016\u0010X\u001a\u00020(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010%R\u0016\u0010Y\u001a\u00020(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010%R\u0016\u0010Z\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010DR\u001a\u0010^\u001a\b\u0012\u0004\u0012\u00020\\0[8\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010]R\"\u0010a\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000e0_8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u0010`R\u001b\u0010e\u001a\u00020b8BX\u0002¢\u0006\f\n\u0004\b3\u0010c\u001a\u0004\bJ\u0010dR\u001b\u0010h\u001a\u00020f8BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010c\u001a\u0004\bP\u0010gR\u0018\u0010j\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010iR\u001b\u0010m\u001a\u00020k8BX\u0002¢\u0006\f\n\u0004\b@\u0010c\u001a\u0004\bM\u0010l¨\u0006n"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/SuperNotificationManager;", "", "<init>", "()V", "", "x", "A", "z", "y", "G", "Lcom/upuphone/xr/sapp/monitor/notification/business/BusinessManager;", "g", "()Lcom/upuphone/xr/sapp/monitor/notification/business/BusinessManager;", "F", "", "B", "()Z", "E", "D", "openState", "d", "(Z)V", "C", "", "key", "s", "(Ljava/lang/String;)Z", "", "o", "()J", "time", "L", "(J)V", "m", "state", "J", "l", "I", "k", "H", "", "n", "()I", "type", "K", "(I)V", "w", "O", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "v", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "r", "q", "M", "selected", "e", "(Ljava/lang/String;Z)V", "t", "N", "P", "f", "Lkotlinx/coroutines/CoroutineScope;", "b", "Lkotlinx/coroutines/CoroutineScope;", "u", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "c", "Z", "mNotificationEnable", "notificationDismissTime", "notificationBroadcast", "notificationBrightenScreen", "callNotificationState", "h", "missedCallNotificationState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "i", "Lkotlinx/coroutines/flow/MutableStateFlow;", "usingPhoneNotificationState", "j", "reminderScenesControlState", "p", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "setReminderFlightState", "(Lkotlinx/coroutines/flow/MutableStateFlow;)V", "reminderFlightState", "isUsingCheckShow", "scheduleDisplayTime", "notificationBroadcastPauseType", "isInit", "", "Lcom/upuphone/xr/sapp/monitor/notification/mode/IReminderSwitchCall;", "Ljava/util/List;", "reminderTypeCall", "", "Ljava/util/Map;", "openReminderType", "Lcom/upuphone/xr/sapp/monitor/contact/ContactChangeMonitor;", "Lkotlin/Lazy;", "()Lcom/upuphone/xr/sapp/monitor/contact/ContactChangeMonitor;", "mContactChange", "Lcom/upuphone/xr/sapp/monitor/weather/WeatherMonitor;", "()Lcom/upuphone/xr/sapp/monitor/weather/WeatherMonitor;", "mWeatherMonitor", "Lcom/upuphone/xr/sapp/monitor/notification/business/BusinessManager;", "businessManager", "Lcom/upuphone/xr/sapp/monitor/starry/NotificationCmdHandler;", "()Lcom/upuphone/xr/sapp/monitor/starry/NotificationCmdHandler;", "mNotificationCmdHandler", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nSuperNotificationManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SuperNotificationManager.kt\ncom/upuphone/xr/sapp/monitor/notification/SuperNotificationManager\n+ 2 JsonUtils.kt\ncom/upuphone/xr/sapp/utils/JsonUtils\n*L\n1#1,725:1\n71#2,2:726\n*S KotlinDebug\n*F\n+ 1 SuperNotificationManager.kt\ncom/upuphone/xr/sapp/monitor/notification/SuperNotificationManager\n*L\n621#1:726,2\n*E\n"})
public final class SuperNotificationManager {

    /* renamed from: a  reason: collision with root package name */
    public static final SuperNotificationManager f7749a = new SuperNotificationManager();
    public static final CoroutineScope b = CoroutineScopeKt.a(Dispatchers.b());
    public static boolean c = true;
    public static long d = 10000;
    public static boolean e = true;
    public static boolean f;
    public static boolean g = true;
    public static boolean h = true;
    public static MutableStateFlow i;
    public static MutableStateFlow j = StateFlowKt.a(Boolean.TRUE);
    public static MutableStateFlow k;
    public static boolean l;
    public static int m = TransferHandler.TIMEOUT;
    public static int n = 2;
    public static boolean o;
    public static final List p = new ArrayList();
    public static Map q = new LinkedHashMap();
    public static final Lazy r = LazyKt.lazy(SuperNotificationManager$mContactChange$2.INSTANCE);
    public static final Lazy s = LazyKt.lazy(SuperNotificationManager$mWeatherMonitor$2.INSTANCE);
    public static BusinessManager t;
    public static final Lazy u = LazyKt.lazy(SuperNotificationManager$mNotificationCmdHandler$2.INSTANCE);

    static {
        Boolean bool = Boolean.FALSE;
        i = StateFlowKt.a(bool);
        k = StateFlowKt.a(bool);
    }

    public final void A() {
        String str = (String) DataStoreUtils.j(DataStoreUtils.e.a(), "ai_notification_enable_type_key", "", true, (Context) null, 8, (Object) null);
        try {
            Map map = q;
            Object fromJson = JsonUtils.f7893a.c().fromJson(str, new SuperNotificationManager$initWiseNotifyStateMap$$inlined$fromJsonForMap$1().getType());
            Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
            map.putAll((Map) fromJson);
        } catch (Exception unused) {
            Map map2 = q;
            Boolean bool = Boolean.TRUE;
            map2.put(ReminderType.MSG_TYPE_REMINDER, bool);
            q.put(ReminderType.MSG_TYPE_TAXI, bool);
            q.put("MSG_TYPE_FLIGHT", bool);
        }
    }

    public final boolean B() {
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        return bool.booleanValue();
    }

    public final boolean C() {
        return c;
    }

    public final boolean D() {
        Boolean bool = BuildConfig.b;
        Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
        if (bool.booleanValue()) {
            return false;
        }
        return VersionMatchHelper.g(VersionMatchHelper.f7930a, false, false, false, GlassInfoExtKt.c(GlassInfoExtKt.d("Flyme AR 1.0.9.0.20240424_Air_FR")), (String) null, GlassInfoExtKt.c(GlassInfoExtKt.d("1.1.0.274")), (String) null, 86, (Object) null);
    }

    public final boolean E() {
        return VersionMatchHelper.e(VersionMatchHelper.f7930a, false, false, false, GlassInfoExtKt.c(GlassInfoExtKt.d("Flyme AR 1.0.9.0.20240424_Air_FR")), (String) null, (String) null, (String) null, CmdCode.CODE_DELAY_LISTENING, (Object) null);
    }

    public final void F() {
        j().e();
    }

    public final void G() {
        DataStoreUtils.Companion companion = DataStoreUtils.e;
        DataStoreUtils a2 = companion.a();
        Boolean bool = Boolean.TRUE;
        c = ((Boolean) DataStoreUtils.j(a2, "notification_enable_key", bool, true, (Context) null, 8, (Object) null)).booleanValue();
        d = ((Number) DataStoreUtils.j(companion.a(), "notification_dismiss_time_key", 10000L, true, (Context) null, 8, (Object) null)).longValue();
        e = ((Boolean) DataStoreUtils.j(companion.a(), "notification_broadcast_key", bool, true, (Context) null, 8, (Object) null)).booleanValue();
        DataStoreUtils a3 = companion.a();
        Boolean bool2 = Boolean.FALSE;
        f = ((Boolean) DataStoreUtils.j(a3, "notification_brighten_screen_key", bool2, true, (Context) null, 8, (Object) null)).booleanValue();
        Boolean bool3 = bool;
        g = ((Boolean) DataStoreUtils.j(companion.a(), "call_notification_state_key", bool3, true, (Context) null, 8, (Object) null)).booleanValue();
        i.setValue(DataStoreUtils.j(companion.a(), "using_phone_notification_state_key", bool2, true, (Context) null, 8, (Object) null));
        j.setValue(DataStoreUtils.j(companion.a(), "reminder_scenes_control_state_key", bool3, true, (Context) null, 8, (Object) null));
        h = ((Boolean) DataStoreUtils.j(companion.a(), "missed_call_notification_state_key", bool3, true, (Context) null, 8, (Object) null)).booleanValue();
        m = ((Number) DataStoreUtils.j(companion.a(), "schedule_display_time_key", Integer.valueOf(TransferHandler.TIMEOUT), true, (Context) null, 8, (Object) null)).intValue();
        n = ((Number) DataStoreUtils.j(companion.a(), "notification_broadcast_pause_type_key", 2, true, (Context) null, 8, (Object) null)).intValue();
    }

    public final void H(boolean z) {
        if (z != h) {
            h = z;
            DataStoreUtils.e.a().p("missed_call_notification_state_key", Boolean.valueOf(h), true);
            SdkContext.f6675a.d().reportEvent(ReminderDataTrackEvent.APP_STATUS_CALL_REMINDER, MapsKt.hashMapOf(TuplesKt.to("status", z ? "1" : "0")));
        }
    }

    public final void I(boolean z) {
        ULog.Delegate delegate = ULog.f6446a;
        boolean z2 = f;
        delegate.a("SuperNotificationManager", "saveNotificationBrightenScreen current:" + z2 + " change:" + z);
        if (z != f) {
            f = z;
            DataStoreUtils.e.a().p("notification_brighten_screen_key", Boolean.valueOf(f), true);
            P();
            SdkContext.f6675a.d().reportEvent(ReminderDataTrackEvent.APP_CLICK_REMIND_LIGHT, MapsKt.hashMapOf(TuplesKt.to("status", z ? "1" : "0")));
        }
    }

    public final void J(boolean z) {
        ULog.Delegate delegate = ULog.f6446a;
        boolean z2 = e;
        delegate.a("SuperNotificationManager", "saveNotificationBroadcast current:" + z2 + " change:" + z);
        if (z != e) {
            e = z;
            DataStoreUtils.e.a().p("notification_broadcast_key", Boolean.valueOf(e), true);
            P();
            SdkContext.f6675a.d().reportEvent(ReminderDataTrackEvent.APP_CLICK_REMIND_READ, MapsKt.hashMapOf(TuplesKt.to("status", z ? "1" : "0")));
        }
    }

    public final void K(int i2) {
        if (i2 != n) {
            n = i2;
            DataStoreUtils.e.a().p("notification_broadcast_pause_type_key", Integer.valueOf(n), true);
            StarryMessageHelper.t(StarryMessageHelper.f7799a, (byte[]) null, new StarryNotificationBase("SYNC_CONFIG_BROADCAST_PAUSE_TYPE", MapsKt.hashMapOf(TuplesKt.to("notificationBroadcastPauseType", Integer.valueOf(n)))), (SendMessageListener) null, 5, (Object) null);
            SdkContext.f6675a.d().reportEvent(ReminderDataTrackEvent.APP_GLASSES_SETTING, MapsKt.hashMapOf(TuplesKt.to("broadcast_pause", String.valueOf(n))));
        }
    }

    public final void L(long j2) {
        if (j2 != d) {
            d = j2;
            DataStoreUtils.e.a().p("notification_dismiss_time_key", Long.valueOf(d), true);
            P();
        }
    }

    public final void M(boolean z) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("SuperNotificationManager", "saveReminderScenesControlState state:" + z);
        Job unused = BuildersKt__Builders_commonKt.d(b, (CoroutineContext) null, (CoroutineStart) null, new SuperNotificationManager$saveReminderScenesControlState$1(z, (Continuation<? super SuperNotificationManager$saveReminderScenesControlState$1>) null), 3, (Object) null);
    }

    public final void N(int i2) {
        if (i2 != t()) {
            m = i2;
            DataStoreUtils.e.a().p("schedule_display_time_key", Integer.valueOf(m), true);
            P();
        }
    }

    public final void O(boolean z) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("SuperNotificationManager", "saveUsingPhoneNotificationState state:" + z);
        Job unused = BuildersKt__Builders_commonKt.d(b, (CoroutineContext) null, (CoroutineStart) null, new SuperNotificationManager$saveUsingPhoneNotificationState$1(z, (Continuation<? super SuperNotificationManager$saveUsingPhoneNotificationState$1>) null), 3, (Object) null);
    }

    public final void P() {
        StarryMessageHelper.t(StarryMessageHelper.f7799a, (byte[]) null, new StarryNotificationBase("SYNC_SMART_REMINDER_CONFIG", new NotificationConfig(c, ((Boolean) j.getValue()).booleanValue(), q, Long.valueOf(d), e, f, g, t(), n)), (SendMessageListener) null, 5, (Object) null);
    }

    public final void d(boolean z) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("SuperNotificationManager", "changeNotificationState---" + z);
        if (!z) {
            StarryMessageHelper.t(StarryMessageHelper.f7799a, (byte[]) null, new StarryNotificationBase("DISMISS_NOTIFICATION", MapsKt.hashMapOf(TuplesKt.to("ids", ArraysKt.toList((T[]) new String[]{"phone"})), TuplesKt.to("type", 0))), (SendMessageListener) null, 5, (Object) null);
        }
        DataStoreUtils.e.a().p("notification_enable_key", Boolean.valueOf(z), true);
        SdkContext.f6675a.d().reportEvent(ReminderDataTrackEvent.APP_CLICK_REMIND_NOTICE, MapsKt.hashMapOf(TuplesKt.to("status", z ? "1" : "0")));
        c = z;
        P();
    }

    public final void e(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "type");
        q.put(str, Boolean.valueOf(z));
        DataStoreUtils.e.a().p("ai_notification_enable_type_key", JsonUtils.f7893a.d(q), true);
        P();
    }

    public final void f() {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("SuperNotificationManager", "checkUsingPhonePromptGlass ");
        boolean booleanValue = ((Boolean) DataStoreUtils.j(DataStoreUtils.e.a(), "using_phone_prompt_glass_id", Boolean.FALSE, true, (Context) null, 8, (Object) null)).booleanValue();
        boolean z = l;
        if (z || booleanValue) {
            delegate.a("SuperNotificationManager", "PromptGlass checkShow:" + z + " first:" + booleanValue + " return");
        } else if (w()) {
            boolean w = w();
            delegate.a("SuperNotificationManager", "PromptGlass state:" + w + " return");
        } else {
            NotificationHelper notificationHelper = NotificationHelper.f7775a;
            if (notificationHelper.g()) {
                boolean g2 = notificationHelper.g();
                delegate.a("SuperNotificationManager", "PromptGlass locked:" + g2 + " return");
                return;
            }
            l = true;
            Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new SuperNotificationManager$checkUsingPhonePromptGlass$1((Continuation<? super SuperNotificationManager$checkUsingPhonePromptGlass$1>) null), 3, (Object) null);
        }
    }

    public final BusinessManager g() {
        return t;
    }

    public final ContactChangeMonitor h() {
        return (ContactChangeMonitor) r.getValue();
    }

    public final NotificationCmdHandler i() {
        return (NotificationCmdHandler) u.getValue();
    }

    public final WeatherMonitor j() {
        return (WeatherMonitor) s.getValue();
    }

    public final boolean k() {
        return h;
    }

    public final boolean l() {
        ULog.Delegate delegate = ULog.f6446a;
        boolean z = f;
        delegate.a("SuperNotificationManager", "getNotificationBrightenScreen current:" + z);
        return f;
    }

    public final boolean m() {
        ULog.Delegate delegate = ULog.f6446a;
        boolean z = e;
        delegate.a("SuperNotificationManager", "getNotificationBroadcast current:" + z);
        return e;
    }

    public final int n() {
        return n;
    }

    public final long o() {
        return d;
    }

    public final MutableStateFlow p() {
        return k;
    }

    public final boolean q() {
        return ((Boolean) j.getValue()).booleanValue();
    }

    public final MutableSharedFlow r() {
        return j;
    }

    public final boolean s(String str) {
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Boolean bool = (Boolean) q.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final int t() {
        if (m == 30) {
            m = TransferHandler.TIMEOUT;
        }
        return m;
    }

    public final CoroutineScope u() {
        return b;
    }

    public final MutableSharedFlow v() {
        return i;
    }

    public final boolean w() {
        return ((Boolean) i.getValue()).booleanValue();
    }

    public final void x() {
        G();
        A();
    }

    public final void y() {
        ULog.Delegate delegate = ULog.f6446a;
        boolean z = o;
        delegate.a("SuperNotificationManager", "init SuperNotificationManager isInit:" + z);
        if (!o) {
            delegate.a("SuperNotificationManager", "init SuperNotificationManager");
            x();
            MzAccountManager.c.b().d().observeForever(new SuperNotificationManager$sam$androidx_lifecycle_Observer$0(SuperNotificationManager$initManager$1.INSTANCE));
            z();
            i().initCmdHandler();
            t = new BusinessManager();
            o = true;
        }
        BusinessManager businessManager = t;
        if (businessManager != null) {
            businessManager.a(BusinessType.ASSISTANT);
        }
        BusinessManager businessManager2 = t;
        if (businessManager2 != null) {
            businessManager2.a(BusinessType.MISSED_CALL);
        }
        BusinessManager businessManager3 = t;
        if (businessManager3 != null) {
            businessManager3.a(BusinessType.FLYME_FLIGHT);
        }
        BusinessManager businessManager4 = t;
        if (businessManager4 != null) {
            businessManager4.a(BusinessType.REMINDER);
        }
        j().d();
        h().g();
        MissedCallMonitor.f7773a.h();
        SportMonitor.f7796a.c();
        NotificationListenerHelper.f7746a.a();
    }

    public final void z() {
        StarryMessageHelper.f7799a.i(new SuperNotificationManager$initStarryChange$1());
    }
}
