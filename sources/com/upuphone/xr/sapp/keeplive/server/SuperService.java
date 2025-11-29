package com.upuphone.xr.sapp.keeplive.server;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.app.ServiceCompat;
import androidx.lifecycle.LifecycleService;
import com.meizu.common.widget.CircleProgressBar;
import com.ucar.vehiclesdk.MDevice;
import com.upuphone.ar.music.phone.helper.MusicPhoneUniversalHelper;
import com.upuphone.ar.navi.lite.manger.NaviManager;
import com.upuphone.ar.transcribe.TranscribeApp;
import com.upuphone.ar.translation.TranslationApp;
import com.upuphone.ar.translation.statemachine.annotation.MSG;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.listener.DeviceConnectionListener;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.DynamicAdapterUtils;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import com.upuphone.xr.sapp.utils.ModelIdExtKt;
import com.upuphone.xr.sapp.utils.PhoneTypeUtils;
import com.xjmz.myvu.MYVUActivity;
import com.xjmz.myvu.ext.ContextExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 M2\u00020\u0001:\u0002NOB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\"\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010!\u001a\u00020\nH\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0004H\u0002¢\u0006\u0004\b$\u0010\u0003J\u0019\u0010'\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0004H\u0002¢\u0006\u0004\b)\u0010\u0003J\u001f\u0010-\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*H\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0004H\u0016¢\u0006\u0004\b/\u0010\u0003J\u000f\u00100\u001a\u00020\u0004H\u0016¢\u0006\u0004\b0\u0010\u0003R\u001c\u00104\u001a\b\u0018\u000101R\u00020\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010;\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010CR\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010L\u001a\u00020*8\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010C¨\u0006P"}, d2 = {"Lcom/upuphone/xr/sapp/keeplive/server/SuperService;", "Landroidx/lifecycle/LifecycleService;", "<init>", "()V", "", "D", "F", "v", "x", "u", "", "channelId", "w", "(Ljava/lang/String;)V", "t", "Landroid/app/Notification;", "B", "(Ljava/lang/String;)Landroid/app/Notification;", "Landroid/widget/RemoteViews;", "C", "()Landroid/widget/RemoteViews;", "Landroid/content/Intent;", "A", "()Landroid/content/Intent;", "intent", "", "code", "Landroid/app/PendingIntent;", "y", "(Landroid/content/Intent;I)Landroid/app/PendingIntent;", "event", "z", "(Ljava/lang/String;I)Landroid/app/PendingIntent;", "channelName", "s", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "E", "Lcom/upuphone/xr/interconnect/listener/DeviceConnectionListener;", "listener", "G", "(Lcom/upuphone/xr/interconnect/listener/DeviceConnectionListener;)V", "r", "", "isOnline", "needNotify", "q", "(ZZ)V", "onCreate", "onDestroy", "Lcom/upuphone/xr/sapp/keeplive/server/SuperService$EventBroadCast;", "b", "Lcom/upuphone/xr/sapp/keeplive/server/SuperService$EventBroadCast;", "mEventBroadCast", "Landroid/app/NotificationManager;", "c", "Landroid/app/NotificationManager;", "mNotificationManager", "d", "Landroid/app/Notification;", "mNotification", "e", "Landroid/widget/RemoteViews;", "mRemoteViews", "f", "Lcom/upuphone/xr/interconnect/listener/DeviceConnectionListener;", "mConnectionListener", "g", "Z", "glassConnectState", "h", "deleteNotificationState", "Landroid/os/Handler;", "i", "Landroid/os/Handler;", "mHandler", "j", "isAirPro", "k", "Companion", "EventBroadCast", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class SuperService extends LifecycleService {
    public static final Companion k = new Companion((DefaultConstructorMarker) null);
    public EventBroadCast b;
    public NotificationManager c;
    public Notification d;
    public RemoteViews e;
    public DeviceConnectionListener f;
    public boolean g;
    public boolean h;
    public Handler i;
    public final boolean j = InterconnectManager.getInstance().getStarryNetDeviceManager().isAirPro();

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/upuphone/xr/sapp/keeplive/server/SuperService$Companion;", "", "()V", "PENDING_EVENT_CANCEL_CLOSE", "", "PENDING_EVENT_CLEAR_NOTIFICATION", "PENDING_EVENT_CLOSE", "PENDING_EVENT_NAVI_NOTIFICATION", "PENDING_INTENT_INTO_CLOSE_BY_PERMISSION", "PENDING_INTENT_INTO_CLOSE_BY_USER", "PENDING_INTENT_INTO_ENABLE", "PENDING_INTENT_INTO_TOUCHPAD", "PENDING_INTENT_RES_CLEAR_NOTIFICATION", "", "PENDING_INTENT_RES_CLEAR_NOTIFICATION_CANCEL", "PENDING_INTENT_RES_CLEAR_NOTIFICATION_CONFIRM", "PENDING_INTENT_RES_INTO_MAIN_CODE", "PENDING_INTENT_RES_INTO_TOUCHPAD_CODE", "SUPER_SERVICE_CHANNEL_ID", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/keeplive/server/SuperService$EventBroadCast;", "Landroid/content/BroadcastReceiver;", "(Lcom/upuphone/xr/sapp/keeplive/server/SuperService;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class EventBroadCast extends BroadcastReceiver {
        public EventBroadCast() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                SuperService superService = SuperService.this;
                String action = intent.getAction();
                if (action != null) {
                    switch (action.hashCode()) {
                        case -1369020733:
                            if (action.equals("navi_background_notification")) {
                                if (intent.getBooleanExtra("enable", true)) {
                                    String packageName = superService.getPackageName();
                                    Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
                                    superService.w(packageName);
                                    return;
                                }
                                superService.t();
                                return;
                            }
                            return;
                        case -515955026:
                            if (action.equals("action_discovery_device")) {
                                ULog.f6446a.a("SuperService", "EventBroadCast::ACTION_DISCOVERY_DEVICE");
                                boolean booleanExtra = intent.getBooleanExtra("device_online", false);
                                superService.g = booleanExtra;
                                superService.q(booleanExtra, true);
                                return;
                            }
                            return;
                        case -92370990:
                            if (action.equals("close_notification")) {
                                ULog.f6446a.a("SuperService", "EventBroadCast::PENDING_EVENT_CLOSE");
                                superService.r();
                                return;
                            }
                            return;
                        case 1369547165:
                            if (action.equals("clear_notification")) {
                                boolean booleanExtra2 = intent.getBooleanExtra("close_by_user", false);
                                boolean booleanExtra3 = intent.getBooleanExtra("close_by_permission", false);
                                ULog.Delegate delegate = ULog.f6446a;
                                boolean j = superService.g;
                                delegate.a("SuperService", "EventBroadCast::PENDING_EVENT_CLEAR_NOTIFICATION glassConnectState is: " + j + " byUser is: " + booleanExtra2 + " byPermission is: " + booleanExtra3);
                                if (booleanExtra3) {
                                    superService.u();
                                }
                                if (booleanExtra2) {
                                    MainApplication.k.k(true);
                                }
                                if (superService.g) {
                                    PhoneTypeUtils phoneTypeUtils = PhoneTypeUtils.f7912a;
                                    if (!Intrinsics.areEqual((Object) phoneTypeUtils.b(), (Object) "huawei") && !Intrinsics.areEqual((Object) phoneTypeUtils.b(), (Object) "honor") && !booleanExtra3) {
                                        superService.h = true;
                                        RemoteViews n = superService.e;
                                        if (n != null) {
                                            n.setViewVisibility(R.id.delete, 8);
                                        }
                                        RemoteViews n2 = superService.e;
                                        if (n2 != null) {
                                            n2.setViewVisibility(R.id.notification_touchpad, 8);
                                        }
                                        RemoteViews n3 = superService.e;
                                        if (n3 != null) {
                                            n3.setViewVisibility(R.id.notification_split, 8);
                                        }
                                        RemoteViews n4 = superService.e;
                                        if (n4 != null) {
                                            n4.setViewVisibility(R.id.notification_split2, 0);
                                        }
                                        RemoteViews n5 = superService.e;
                                        if (n5 != null) {
                                            n5.setViewVisibility(R.id.control_main, 0);
                                        }
                                        RemoteViews n6 = superService.e;
                                        if (n6 != null) {
                                            n6.setTextViewText(R.id.notification_content, superService.getString(R.string.close_service_content));
                                        }
                                        RemoteViews n7 = superService.e;
                                        if (n7 != null) {
                                            n7.setTextViewText(R.id.notification_cancel, superService.getString(R.string.cancel));
                                        }
                                        RemoteViews n8 = superService.e;
                                        if (n8 != null) {
                                            n8.setTextViewText(R.id.notification_close, superService.getString(R.string.word_close));
                                        }
                                        NotificationManager m = superService.c;
                                        if (m != null) {
                                            m.notify(MSG.MSG_PREPARING_SUCCESS, superService.d);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                superService.r();
                                return;
                            }
                            return;
                        case 2141456823:
                            if (action.equals("cancel_close_notification")) {
                                ULog.f6446a.a("SuperService", "EventBroadCast::PENDING_EVENT_CANCEL_CLOSE");
                                MainApplication.k.k(false);
                                superService.h = false;
                                RemoteViews n9 = superService.e;
                                if (n9 != null) {
                                    n9.setViewVisibility(R.id.control_main, 8);
                                }
                                RemoteViews n10 = superService.e;
                                if (n10 != null) {
                                    n10.setViewVisibility(R.id.notification_split2, 8);
                                }
                                RemoteViews n11 = superService.e;
                                if (n11 != null) {
                                    n11.setViewVisibility(R.id.notification_split, 0);
                                }
                                superService.q(superService.g, true);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    }

    private final void E() {
        this.f = new SuperService$registerDeviceConnectCallback$1(this);
        InterconnectManager.getInstance().getStarryNetDeviceManager().registerDeviceConnectionListener(this.f);
    }

    private final void G(DeviceConnectionListener deviceConnectionListener) {
        InterconnectManager.getInstance().getStarryNetDeviceManager().unregisterDeviceConnectionListener(deviceConnectionListener);
    }

    /* access modifiers changed from: private */
    public final void r() {
        ULog.f6446a.a("SuperService", "====================close==================");
        NaviManager.getInstance(this).stopLocation();
        NaviManager.getInstance(this).disableBackgroundLocation(true);
        this.h = false;
        Boolean bool = BuildConfig.b;
        Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
        if (bool.booleanValue()) {
            stopSelf();
        }
    }

    public final Intent A() {
        return new Intent(this, MYVUActivity.class);
    }

    public final Notification B(String str) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, str);
        builder.P(1).H(R.drawable.notification_logo_mini).C(-1).n(GlobalExtKt.f().getText(R.string.ar_navi_ongoing)).l(y(A(), 100));
        Notification c2 = builder.c();
        Intrinsics.checkNotNullExpressionValue(c2, "build(...)");
        return c2;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.widget.RemoteViews C() {
        /*
            r5 = this;
            com.upuphone.xr.sapp.utils.PhoneTypeUtils r0 = com.upuphone.xr.sapp.utils.PhoneTypeUtils.f7912a
            java.lang.String r0 = r0.b()
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getSmallRemoteViews::phone type is: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "SuperService"
            r1.a(r3, r2)
            int r2 = r0.hashCode()
            switch(r2) {
                case -1206476313: goto L_0x006a;
                case -759499589: goto L_0x003e;
                case 99462250: goto L_0x0032;
                case 1864941562: goto L_0x0026;
                default: goto L_0x0025;
            }
        L_0x0025:
            goto L_0x0072
        L_0x0026:
            java.lang.String r1 = "samsung"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x002f
            goto L_0x0072
        L_0x002f:
            int r0 = com.upuphone.xr.sapp.R.layout.notification_content_sanxing
            goto L_0x0077
        L_0x0032:
            java.lang.String r1 = "honor"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x003b
            goto L_0x0072
        L_0x003b:
            int r0 = com.upuphone.xr.sapp.R.layout.notification_content_honor
            goto L_0x0077
        L_0x003e:
            java.lang.String r2 = "xiaomi"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0048
            goto L_0x0072
        L_0x0048:
            java.lang.Boolean r0 = com.upuphone.xr.sapp.BuildConfig.f6575a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "getSmallRemoteViews  XIAOMI BuildConfig.COUNTRY_INTL = "
            r2.append(r4)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            r1.g(r3, r2)
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0067
            int r0 = com.upuphone.xr.sapp.R.layout.notification_content_xiaomi
            goto L_0x0077
        L_0x0067:
            int r0 = com.upuphone.xr.sapp.R.layout.notification_content_xiaomi_for_intl
            goto L_0x0077
        L_0x006a:
            java.lang.String r1 = "huawei"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0075
        L_0x0072:
            int r0 = com.upuphone.xr.sapp.R.layout.notification_content
            goto L_0x0077
        L_0x0075:
            int r0 = com.upuphone.xr.sapp.R.layout.notification_content_hw
        L_0x0077:
            android.widget.RemoteViews r1 = new android.widget.RemoteViews
            java.lang.String r2 = r5.getPackageName()
            r1.<init>(r2, r0)
            int r0 = com.upuphone.xr.sapp.R.id.notification_main
            android.content.Intent r2 = r5.A()
            r3 = 100
            android.app.PendingIntent r2 = r5.y(r2, r3)
            r1.setOnClickPendingIntent(r0, r2)
            int r0 = com.upuphone.xr.sapp.R.id.notification_touchpad
            android.content.Intent r2 = r5.A()
            java.lang.String r3 = "open_touchpad"
            r4 = 1
            r2.putExtra(r3, r4)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r3 = 101(0x65, float:1.42E-43)
            android.app.PendingIntent r2 = r5.y(r2, r3)
            r1.setOnClickPendingIntent(r0, r2)
            int r0 = com.upuphone.xr.sapp.R.id.delete
            java.lang.String r2 = "clear_notification"
            r3 = 102(0x66, float:1.43E-43)
            android.app.PendingIntent r2 = r5.z(r2, r3)
            r1.setOnClickPendingIntent(r0, r2)
            int r0 = com.upuphone.xr.sapp.R.id.notification_cancel
            java.lang.String r2 = "cancel_close_notification"
            r3 = 103(0x67, float:1.44E-43)
            android.app.PendingIntent r2 = r5.z(r2, r3)
            r1.setOnClickPendingIntent(r0, r2)
            int r0 = com.upuphone.xr.sapp.R.id.notification_close
            java.lang.String r2 = "close_notification"
            r3 = 104(0x68, float:1.46E-43)
            android.app.PendingIntent r2 = r5.z(r2, r3)
            r1.setOnClickPendingIntent(r0, r2)
            r5.e = r1
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.keeplive.server.SuperService.C():android.widget.RemoteViews");
    }

    public final void D() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("clear_notification");
        intentFilter.addAction("action_discovery_device");
        intentFilter.addAction("cancel_close_notification");
        intentFilter.addAction("close_notification");
        intentFilter.addAction("navi_background_notification");
        EventBroadCast eventBroadCast = new EventBroadCast();
        this.b = eventBroadCast;
        Intrinsics.checkNotNull(eventBroadCast);
        ContextExtKt.a(this, eventBroadCast, intentFilter);
        this.i = new Handler(Looper.getMainLooper());
    }

    public final void F() {
        EventBroadCast eventBroadCast = this.b;
        if (eventBroadCast != null) {
            try {
                unregisterReceiver(eventBroadCast);
            } catch (Exception unused) {
            }
        }
    }

    public void onCreate() {
        super.onCreate();
        ULog.f6446a.a("SuperService", "service onCreate");
        D();
        E();
        v();
        MusicPhoneUniversalHelper.f5631a.b(this);
    }

    public void onDestroy() {
        super.onDestroy();
        ULog.f6446a.a("SuperService", "do onDestroy");
        F();
        G(this.f);
        stopForeground(2);
    }

    public final void q(boolean z, boolean z2) {
        NotificationManager notificationManager;
        if (!BuildConfig.b.booleanValue()) {
            ULog.f6446a.g("SuperService", "not notify on flyme link devices");
            return;
        }
        boolean z3 = this.h;
        if (z3) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("SuperService", "changeConnectState::deleteNotificationState is: " + z3);
            return;
        }
        if (z) {
            RemoteViews remoteViews = this.e;
            if (remoteViews != null) {
                remoteViews.setViewVisibility(R.id.notification_touchpad, 0);
            }
            RemoteViews remoteViews2 = this.e;
            if (remoteViews2 != null) {
                remoteViews2.setViewVisibility(R.id.notification_split, 0);
            }
            RemoteViews remoteViews3 = this.e;
            if (remoteViews3 != null) {
                remoteViews3.setViewVisibility(R.id.notification_split2, 8);
            }
            DynamicAdapterUtils dynamicAdapterUtils = DynamicAdapterUtils.f7879a;
            if (ModelIdExtKt.b(dynamicAdapterUtils.a())) {
                RemoteViews remoteViews4 = this.e;
                if (remoteViews4 != null) {
                    int i2 = R.id.notification_content;
                    String string = getString(R.string.air_glass_display_name);
                    String string2 = getString(R.string.air_glass_connect);
                    remoteViews4.setTextViewText(i2, string + string2);
                }
            } else if (ModelIdExtKt.d(dynamicAdapterUtils.a())) {
                RemoteViews remoteViews5 = this.e;
                if (remoteViews5 != null) {
                    int i3 = R.id.notification_content;
                    String string3 = getString(R.string.air_pro_glass_display_name);
                    String string4 = getString(R.string.air_glass_connect);
                    remoteViews5.setTextViewText(i3, string3 + string4);
                }
            } else {
                RemoteViews remoteViews6 = this.e;
                if (remoteViews6 != null) {
                    int i4 = R.id.notification_content;
                    String string5 = getString(R.string.star_glass_display_name);
                    String string6 = getString(R.string.air_glass_connect);
                    remoteViews6.setTextViewText(i4, string5 + string6);
                }
            }
        } else {
            RemoteViews remoteViews7 = this.e;
            if (remoteViews7 != null) {
                remoteViews7.setViewVisibility(R.id.notification_touchpad, 8);
            }
            RemoteViews remoteViews8 = this.e;
            if (remoteViews8 != null) {
                remoteViews8.setViewVisibility(R.id.notification_split, 8);
            }
            RemoteViews remoteViews9 = this.e;
            if (remoteViews9 != null) {
                remoteViews9.setViewVisibility(R.id.notification_split2, 8);
            }
            DynamicAdapterUtils dynamicAdapterUtils2 = DynamicAdapterUtils.f7879a;
            if (ModelIdExtKt.b(dynamicAdapterUtils2.a())) {
                RemoteViews remoteViews10 = this.e;
                if (remoteViews10 != null) {
                    int i5 = R.id.notification_content;
                    String string7 = getString(R.string.air_glass_display_name);
                    String string8 = getString(R.string.air_glass_break);
                    remoteViews10.setTextViewText(i5, string7 + string8);
                }
            } else if (ModelIdExtKt.d(dynamicAdapterUtils2.a())) {
                RemoteViews remoteViews11 = this.e;
                if (remoteViews11 != null) {
                    int i6 = R.id.notification_content;
                    String string9 = getString(R.string.air_pro_glass_display_name);
                    String string10 = getString(R.string.air_glass_break);
                    remoteViews11.setTextViewText(i6, string9 + string10);
                }
            } else {
                RemoteViews remoteViews12 = this.e;
                if (remoteViews12 != null) {
                    int i7 = R.id.notification_content;
                    String string11 = getString(R.string.star_glass_display_name);
                    String string12 = getString(R.string.air_glass_break);
                    remoteViews12.setTextViewText(i7, string11 + string12);
                }
            }
        }
        RemoteViews remoteViews13 = this.e;
        if (remoteViews13 != null) {
            remoteViews13.setViewVisibility(R.id.delete, 0);
        }
        if (z2 && (notificationManager = this.c) != null) {
            notificationManager.notify(MSG.MSG_PREPARING_SUCCESS, this.d);
        }
    }

    public final String s(String str, String str2) {
        NotificationChannel notificationChannel = new NotificationChannel(str, str2, 2);
        notificationChannel.setLockscreenVisibility(1);
        Object systemService = getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        this.c = notificationManager;
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
        }
        return str;
    }

    public final void t() {
        ULog.f6446a.g("SuperService", "disableBackgroundLocation");
        NaviManager.getInstance(this).disableBackgroundLocation(true);
        NaviManager.getInstance(this).enableBackgroundLocation(MSG.MSG_PREPARING_SUCCESS, (Notification) null);
    }

    public final void u() {
        Boolean bool = BuildConfig.b;
        Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
        if (bool.booleanValue()) {
            ULog.f6446a.g("SuperService", "disable disableBackgroundTranslation");
            TranslationApp.setKeepLiveNotification(MSG.MSG_PREPARING_SUCCESS, (Notification) null);
            TranscribeApp.setKeepLiveNotification(MSG.MSG_PREPARING_SUCCESS, (Notification) null);
        }
    }

    public final void v() {
        String packageName = getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        String s = s(packageName, "SuperApp");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, s);
        builder.P(1).H(R.drawable.notification_logo_mini).p(C()).C(-1);
        ULog.Delegate delegate = ULog.f6446a;
        PhoneTypeUtils phoneTypeUtils = PhoneTypeUtils.f7912a;
        boolean f2 = phoneTypeUtils.f();
        delegate.g("SuperService", "doStartForeGround isMIUIIntl = " + f2);
        if (Intrinsics.areEqual((Object) phoneTypeUtils.b(), (Object) MDevice.MANUFACTURERS_OPPO) || Intrinsics.areEqual((Object) phoneTypeUtils.b(), (Object) MDevice.MANUFACTURERS_VIVO) || phoneTypeUtils.f()) {
            builder.J(new NotificationCompat.DecoratedCustomViewStyle());
        } else if (Intrinsics.areEqual((Object) phoneTypeUtils.b(), (Object) "huawei") || Intrinsics.areEqual((Object) phoneTypeUtils.b(), (Object) "honor") || Intrinsics.areEqual((Object) phoneTypeUtils.b(), (Object) "samsung")) {
            builder.H(R.drawable.notification_logo_mini);
        } else {
            builder.o(C());
        }
        if (Intrinsics.areEqual((Object) phoneTypeUtils.b(), (Object) "honor")) {
            builder.H(R.drawable.notification_logo);
        }
        Notification c2 = builder.c();
        Intrinsics.checkNotNullExpressionValue(c2, "build(...)");
        this.d = c2;
        Boolean bool = BuildConfig.b;
        Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
        if (bool.booleanValue()) {
            q(this.g, false);
            boolean z = this.g;
            delegate.a("SuperService", "connectState is: " + z);
            ServiceCompat.a(this, MSG.MSG_PREPARING_SUCCESS, c2, 16);
        }
        if (((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), "navi_notification_resident", Boolean.TRUE, (Context) null, 4, (Object) null)).booleanValue()) {
            w(s);
            x();
        }
    }

    public final void w(String str) {
        ULog.f6446a.g("SuperService", "enable enableBackgroundLocation");
        Boolean bool = BuildConfig.b;
        Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
        NaviManager.getInstance(this).enableBackgroundLocation(MSG.MSG_PREPARING_SUCCESS, bool.booleanValue() ? this.d : B(str));
    }

    public final void x() {
        Boolean bool = BuildConfig.b;
        Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
        if (bool.booleanValue()) {
            ULog.f6446a.g("SuperService", "enable enableBackgroundTranslation");
            TranslationApp.setKeepLiveNotification(MSG.MSG_PREPARING_SUCCESS, this.d);
            TranscribeApp.setKeepLiveNotification(MSG.MSG_PREPARING_SUCCESS, this.d);
        }
    }

    public final PendingIntent y(Intent intent, int i2) {
        PendingIntent activity = PendingIntent.getActivity(GlobalExtKt.f(), i2, intent, CircleProgressBar.RIM_COLOR_DEF);
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
        return activity;
    }

    public final PendingIntent z(String str, int i2) {
        Intent intent = new Intent(str);
        intent.putExtra("close_by_user", true);
        Unit unit = Unit.INSTANCE;
        PendingIntent broadcast = PendingIntent.getBroadcast(this, i2, intent, CircleProgressBar.RIM_COLOR_DEF);
        Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(...)");
        return broadcast;
    }
}
