package com.upuphone.xr.sapp.monitor.notification.business;

import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import com.meizu.common.util.LunarCalendar;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.listener.DeviceConnectionListener;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.interconnect.util.StarryNetDeviceExt;
import com.upuphone.xr.sapp.monitor.notification.NotificationListenerHelper;
import com.upuphone.xr.sapp.monitor.notification.NotificationListenerState;
import com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager;
import com.upuphone.xr.sapp.monitor.notification.model.FlymeSmartFlightModel;
import com.upuphone.xr.sapp.monitor.notification.utils.NotificationHelper;
import com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper;
import com.upuphone.xr.sapp.monitor.starry.StarryNotificationBase;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\bJ\u000f\u0010\u0016\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\u0003J\u0017\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR0\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001d0\u001cj\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001d`\u001e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/business/FlightBusinessHandle;", "Lcom/upuphone/xr/sapp/monitor/notification/business/BusinessHandle;", "<init>", "()V", "Landroid/service/notification/StatusBarNotification;", "sbn", "", "c", "(Landroid/service/notification/StatusBarNotification;)Z", "", "reason", "", "d", "(Landroid/service/notification/StatusBarNotification;I)V", "Lcom/upuphone/xr/sapp/monitor/notification/business/BusinessType;", "a", "()Lcom/upuphone/xr/sapp/monitor/notification/business/BusinessType;", "Landroid/service/notification/NotificationListenerService;", "mServices", "e", "(Landroid/service/notification/NotificationListenerService;)V", "i", "h", "k", "", "id", "j", "(Ljava/lang/String;)V", "Ljava/util/HashMap;", "Lcom/upuphone/xr/sapp/monitor/notification/model/FlymeSmartFlightModel;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "flightMap", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nFlightBusinessHandle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlightBusinessHandle.kt\ncom/upuphone/xr/sapp/monitor/notification/business/FlightBusinessHandle\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,230:1\n13309#2,2:231\n*S KotlinDebug\n*F\n+ 1 FlightBusinessHandle.kt\ncom/upuphone/xr/sapp/monitor/notification/business/FlightBusinessHandle\n*L\n183#1:231,2\n*E\n"})
public final class FlightBusinessHandle extends BusinessHandle {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);
    public final HashMap b = new HashMap();

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.xr.sapp.monitor.notification.business.FlightBusinessHandle$2", f = "FlightBusinessHandle.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.xr.sapp.monitor.notification.business.FlightBusinessHandle$2  reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ FlightBusinessHandle this$0;

        {
            this.this$0 = r1;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableStateFlow p = SuperNotificationManager.f7749a.p();
                final FlightBusinessHandle flightBusinessHandle = this.this$0;
                AnonymousClass1 r1 = new Function2<Boolean, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {
                    /* synthetic */ boolean Z$0;
                    int label;

                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        AnonymousClass1 r0 = 

                        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/business/FlightBusinessHandle$Companion;", "", "()V", "LIVE_EVENT", "", "LIVE_TYPE", "TAG", "TARGET_PACKAGE", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
                        public static final class Companion {
                            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                                this();
                            }

                            public Companion() {
                            }
                        }

                        public FlightBusinessHandle() {
                            StarryMessageHelper.f7799a.i(new DeviceConnectionListener(this) {
                                final /* synthetic */ FlightBusinessHandle this$0;

                                {
                                    this.this$0 = r1;
                                }

                                public void onDeviceConnected(@Nullable StarryNetDevice starryNetDevice) {
                                    if (starryNetDevice != null) {
                                        StarryNetDeviceExt.isXrDevice(starryNetDevice);
                                    }
                                    FlightBusinessHandle flightBusinessHandle = this.this$0;
                                    ULog.f6446a.a("FlightBusinessHandle", "onDeviceConnected");
                                    flightBusinessHandle.h();
                                }

                                public void onDeviceDisconnected(@Nullable StarryNetDevice starryNetDevice) {
                                }
                            });
                            Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.c()), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(this, (Continuation<? super AnonymousClass2>) null), 3, (Object) null);
                        }

                        public BusinessType a() {
                            return BusinessType.FLYME_FLIGHT;
                        }

                        public boolean c(StatusBarNotification statusBarNotification) {
                            Intrinsics.checkNotNullParameter(statusBarNotification, "sbn");
                            if (!SuperNotificationManager.f7749a.D()) {
                                ULog.f6446a.a("FlightBusinessHandle", "parseNotification is not Support Flight");
                                return false;
                            }
                            boolean i = i(statusBarNotification);
                            if (i) {
                                k();
                            }
                            return i;
                        }

                        public void d(StatusBarNotification statusBarNotification, int i) {
                            Intrinsics.checkNotNullParameter(statusBarNotification, "sbn");
                            if (SuperNotificationManager.f7749a.D()) {
                                String e = NotificationHelper.f7775a.e(statusBarNotification);
                                Bundle bundle = statusBarNotification.getNotification().extras;
                                if (Intrinsics.areEqual((Object) e, (Object) "com.meizu.suggestion") && bundle != null) {
                                    String string = bundle.getString("notification.live.contentOverlay", "");
                                    ULog.f6446a.a("FlightBusinessHandle", "航班通知移除:" + string);
                                    if (this.b.containsKey(string)) {
                                        this.b.remove(string);
                                        j("phone-" + e + LunarCalendar.DATE_SEPARATOR + string);
                                    }
                                }
                            }
                        }

                        public void e(NotificationListenerService notificationListenerService) {
                            super.e(notificationListenerService);
                            ULog.f6446a.a("FlightBusinessHandle", "onServicesAttch");
                            h();
                        }

                        public final void h() {
                            if (!SuperNotificationManager.f7749a.D()) {
                                ULog.f6446a.a("FlightBusinessHandle", "loadActiveCache is not Support Flight ");
                                return;
                            }
                            NotificationListenerHelper notificationListenerHelper = NotificationListenerHelper.f7746a;
                            if (notificationListenerHelper.d() != NotificationListenerState.CONNECTED) {
                                ULog.f6446a.a("FlightBusinessHandle", "notification listener error state:" + notificationListenerHelper.d().name());
                                return;
                            }
                            try {
                                NotificationListenerService b2 = b();
                                if (b2 != null) {
                                    StatusBarNotification[] activeNotifications = b2.getActiveNotifications();
                                    ULog.f6446a.a("FlightBusinessHandle", "loadActiveCache size: " + activeNotifications.length);
                                    Intrinsics.checkNotNull(activeNotifications);
                                    boolean z = false;
                                    for (StatusBarNotification statusBarNotification : activeNotifications) {
                                        NotificationHelper notificationHelper = NotificationHelper.f7775a;
                                        Intrinsics.checkNotNull(statusBarNotification);
                                        if (Intrinsics.areEqual((Object) notificationHelper.e(statusBarNotification), (Object) "com.meizu.suggestion")) {
                                            ULog.f6446a.a("FlightBusinessHandle", "loadActiveCache 开始解析通知栏中已有数据");
                                            if (i(statusBarNotification)) {
                                                z = true;
                                            }
                                        }
                                    }
                                    if (z) {
                                        k();
                                    }
                                }
                            } catch (Exception e) {
                                ULog.f6446a.a("FlightBusinessHandle", "loadActiveCache error:" + e.getMessage());
                            }
                        }

                        public final boolean i(StatusBarNotification statusBarNotification) {
                            String str;
                            FlymeSmartFlightModel flymeSmartFlightModel;
                            boolean s = SuperNotificationManager.f7749a.s("MSG_TYPE_FLIGHT");
                            ULog.Delegate delegate = ULog.f6446a;
                            delegate.a("FlightBusinessHandle", "parseNotification reminderIsOpen:" + s);
                            if (!s) {
                                return false;
                            }
                            String e = NotificationHelper.f7775a.e(statusBarNotification);
                            Bundle bundle = statusBarNotification.getNotification().extras;
                            if (!Intrinsics.areEqual((Object) e, (Object) "com.meizu.suggestion") || bundle == null) {
                                return false;
                            }
                            int i = bundle.getInt("notification.live.type", -1);
                            String string = bundle.getString("notification.live.event", "");
                            if (i != 0 && !Intrinsics.areEqual((Object) string, (Object) "FLIGHT")) {
                                return false;
                            }
                            String string2 = bundle.getString("notification.live.contentOverlay", "");
                            String str2 = "phone-" + e + LunarCalendar.DATE_SEPARATOR + string2;
                            delegate.a("FlightBusinessHandle", "匹配到航班号:" + string2 + " 数据,开始解析~");
                            if (this.b.containsKey(string2)) {
                                delegate.a("FlightBusinessHandle", "已有数据,更新~");
                                flymeSmartFlightModel = (FlymeSmartFlightModel) this.b.get(string2);
                                str = "";
                            } else {
                                str = "";
                                flymeSmartFlightModel = new FlymeSmartFlightModel(str2, statusBarNotification.getPostTime(), (String) null, e, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, 2036, (DefaultConstructorMarker) null);
                            }
                            if (flymeSmartFlightModel != null) {
                                String str3 = str;
                                String string3 = bundle.getString("notification.live.titleOverlay", str3);
                                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                                flymeSmartFlightModel.setFlightStateDesc(string3);
                                Intrinsics.checkNotNull(string2);
                                flymeSmartFlightModel.setFlightNumber(string2);
                                String string4 = bundle.getString("notification.live.feature.firstTitleText", str3);
                                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                                flymeSmartFlightModel.setFlightDepartureTime(string4);
                                String string5 = bundle.getString("notification.live.feature.firstContentText", str3);
                                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                                flymeSmartFlightModel.setFlightDepartureAerodrome(string5);
                                String string6 = bundle.getString("notification.live.feature.lastTitleText", str3);
                                Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                                flymeSmartFlightModel.setFlightArrivalTime(string6);
                                String string7 = bundle.getString("notification.live.feature.lastContentText", str3);
                                Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                                flymeSmartFlightModel.setFlightArrivalAerodrome(string7);
                                flymeSmartFlightModel.setLastUpdateTime(System.currentTimeMillis());
                            }
                            HashMap hashMap = this.b;
                            Intrinsics.checkNotNull(string2);
                            Intrinsics.checkNotNull(flymeSmartFlightModel);
                            hashMap.put(string2, flymeSmartFlightModel);
                            return true;
                        }

                        public final void j(String str) {
                            ULog.Delegate delegate = ULog.f6446a;
                            delegate.a("FlightBusinessHandle", "移除航班数据id:" + str);
                            StarryMessageHelper.t(StarryMessageHelper.f7799a, (byte[]) null, new StarryNotificationBase("DISMISS_REMINDER", MapsKt.hashMapOf(TuplesKt.to("packages", ArraysKt.toList((T[]) new String[]{"com.meizu.suggestion"})))), (SendMessageListener) null, 5, (Object) null);
                        }

                        public final void k() {
                            ULog.Delegate delegate = ULog.f6446a;
                            int size = this.b.values().size();
                            delegate.a("FlightBusinessHandle", "同步航班数据size:" + size);
                            StarryMessageHelper.t(StarryMessageHelper.f7799a, (byte[]) null, new StarryNotificationBase("SYNC_SMART_REMINDER_FLYME_FLIGHT", this.b.values()), (SendMessageListener) null, 5, (Object) null);
                        }
                    }
