package com.upuphone.xr.sapp.monitor.notification.business;

import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import com.upuphone.star.core.log.ULog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/business/BusinessManager;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/monitor/notification/business/BusinessType;", "type", "", "a", "(Lcom/upuphone/xr/sapp/monitor/notification/business/BusinessType;)V", "Landroid/service/notification/StatusBarNotification;", "sbn", "c", "(Landroid/service/notification/StatusBarNotification;)V", "", "reason", "d", "(Landroid/service/notification/StatusBarNotification;I)V", "Landroid/service/notification/NotificationListenerService;", "service", "b", "(Landroid/service/notification/NotificationListenerService;)V", "", "Lcom/upuphone/xr/sapp/monitor/notification/business/BusinessHandle;", "Ljava/util/List;", "businessHandlers", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nBusinessManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BusinessManager.kt\ncom/upuphone/xr/sapp/monitor/notification/business/BusinessManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,75:1\n288#2,2:76\n1855#2,2:78\n1855#2,2:80\n1855#2,2:82\n*S KotlinDebug\n*F\n+ 1 BusinessManager.kt\ncom/upuphone/xr/sapp/monitor/notification/business/BusinessManager\n*L\n24#1:76,2\n45#1:78,2\n61#1:80,2\n70#1:82,2\n*E\n"})
public final class BusinessManager {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final List f7756a = new ArrayList();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/business/BusinessManager$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                com.upuphone.xr.sapp.monitor.notification.business.BusinessType[] r0 = com.upuphone.xr.sapp.monitor.notification.business.BusinessType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.upuphone.xr.sapp.monitor.notification.business.BusinessType r1 = com.upuphone.xr.sapp.monitor.notification.business.BusinessType.FLYME_FLIGHT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.upuphone.xr.sapp.monitor.notification.business.BusinessType r1 = com.upuphone.xr.sapp.monitor.notification.business.BusinessType.ASSISTANT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.upuphone.xr.sapp.monitor.notification.business.BusinessType r1 = com.upuphone.xr.sapp.monitor.notification.business.BusinessType.MISSED_CALL     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.upuphone.xr.sapp.monitor.notification.business.BusinessType r1 = com.upuphone.xr.sapp.monitor.notification.business.BusinessType.REMINDER     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.monitor.notification.business.BusinessManager.WhenMappings.<clinit>():void");
        }
    }

    public final void a(BusinessType businessType) {
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(businessType, "type");
        ULog.Delegate delegate = ULog.f6446a;
        String name = businessType.name();
        delegate.a("BusinessManager", "addBusinessHandel " + name);
        Iterator it = this.f7756a.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((BusinessHandle) obj).a() == businessType) {
                break;
            }
        }
        if (((BusinessHandle) obj) == null) {
            int i = WhenMappings.$EnumSwitchMapping$0[businessType.ordinal()];
            if (i == 1) {
                obj2 = new FlightBusinessHandle();
            } else if (i == 2) {
                obj2 = new AiBusinessHandle();
            } else if (i == 3) {
                obj2 = new MissedCallBusinessHandle();
            } else if (i == 4) {
                obj2 = new ReminderBusinessHandle();
            } else {
                throw new NoWhenBranchMatchedException();
            }
            this.f7756a.add(obj2);
            return;
        }
        ULog.f6446a.a("BusinessManager", "Business is added");
    }

    public final void b(NotificationListenerService notificationListenerService) {
        for (BusinessHandle e : this.f7756a) {
            e.e(notificationListenerService);
        }
    }

    public final void c(StatusBarNotification statusBarNotification) {
        Intrinsics.checkNotNullParameter(statusBarNotification, "sbn");
        ULog.Delegate delegate = ULog.f6446a;
        String packageName = statusBarNotification.getPackageName();
        int id = statusBarNotification.getId();
        delegate.a("BusinessManager", "business dispatchPosted packageName:" + packageName + " id:" + id);
        for (BusinessHandle businessHandle : this.f7756a) {
            if (businessHandle.c(statusBarNotification)) {
                ULog.Delegate delegate2 = ULog.f6446a;
                String name = businessHandle.a().name();
                delegate2.a("BusinessManager", "business consume " + name);
                return;
            }
        }
    }

    public final void d(StatusBarNotification statusBarNotification, int i) {
        Intrinsics.checkNotNullParameter(statusBarNotification, "sbn");
        ULog.Delegate delegate = ULog.f6446a;
        String packageName = statusBarNotification.getPackageName();
        int id = statusBarNotification.getId();
        delegate.a("BusinessManager", "Business dispatchRemoved packageName:" + packageName + " id:" + id);
        for (BusinessHandle d : this.f7756a) {
            d.d(statusBarNotification, i);
        }
    }
}
