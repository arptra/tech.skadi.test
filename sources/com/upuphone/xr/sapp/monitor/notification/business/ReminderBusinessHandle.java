package com.upuphone.xr.sapp.monitor.notification.business;

import android.app.Notification;
import android.service.notification.StatusBarNotification;
import com.meizu.common.util.LunarCalendar;
import com.upuphone.sdk.NotificationSDK;
import com.upuphone.sdk.Regular;
import com.upuphone.sdk.ResultType;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.monitor.notification.AppConfigHelper;
import com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager;
import com.upuphone.xr.sapp.monitor.notification.algorithm.AiHandleDataCall;
import com.upuphone.xr.sapp.monitor.notification.constants.PackageConfig;
import com.upuphone.xr.sapp.monitor.notification.mode.AiSdkResult;
import com.upuphone.xr.sapp.monitor.notification.model.AppNotifyConfigModel;
import com.upuphone.xr.sapp.monitor.notification.model.ArNotificationModel;
import com.upuphone.xr.sapp.monitor.notification.rule.GoogleMessagingRule;
import com.upuphone.xr.sapp.monitor.notification.rule.LineRule;
import com.upuphone.xr.sapp.monitor.notification.rule.LockScreenRule;
import com.upuphone.xr.sapp.monitor.notification.rule.MmsRule;
import com.upuphone.xr.sapp.monitor.notification.rule.MmsServiceRule;
import com.upuphone.xr.sapp.monitor.notification.rule.Rule;
import com.upuphone.xr.sapp.monitor.notification.rule.SamsungCalendarRule;
import com.upuphone.xr.sapp.monitor.notification.rule.SamsungMessagingRule;
import com.upuphone.xr.sapp.monitor.notification.rule.ScheduleRule;
import com.upuphone.xr.sapp.monitor.notification.rule.WechatRule;
import com.upuphone.xr.sapp.monitor.notification.rule.WhatsAppRule;
import com.upuphone.xr.sapp.monitor.notification.utils.NotificationHelper;
import com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper;
import com.upuphone.xr.sapp.monitor.starry.StarryNotificationBase;
import com.upuphone.xr.sapp.utils.AppInfoHelper;
import com.upuphone.xr.sapp.utils.PackageHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 32\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J0\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013H@¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ;\u0010\"\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\"\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u001fj\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013` H\u0002¢\u0006\u0004\b\"\u0010#J\u0019\u0010$\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b$\u0010\u0012J\u0019\u0010%\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b%\u0010\u0012R\u001b\u0010+\u001a\u00020&8BX\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R2\u0010-\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u001fj\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013` 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010,R2\u00102\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170/0.j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170/`08\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u00101¨\u00065"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/business/ReminderBusinessHandle;", "Lcom/upuphone/xr/sapp/monitor/notification/business/BusinessHandle;", "<init>", "()V", "Landroid/service/notification/StatusBarNotification;", "sbn", "", "c", "(Landroid/service/notification/StatusBarNotification;)Z", "", "reason", "", "d", "(Landroid/service/notification/StatusBarNotification;I)V", "Lcom/upuphone/xr/sapp/monitor/notification/business/BusinessType;", "a", "()Lcom/upuphone/xr/sapp/monitor/notification/business/BusinessType;", "k", "(Landroid/service/notification/StatusBarNotification;)V", "", "title", "content", "packageName", "Lcom/upuphone/xr/sapp/monitor/notification/mode/AiSdkResult;", "o", "(Landroid/service/notification/StatusBarNotification;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "result", "m", "(Lcom/upuphone/xr/sapp/monitor/notification/mode/AiSdkResult;)V", "q", "(Landroid/service/notification/StatusBarNotification;Lcom/upuphone/xr/sapp/monitor/notification/mode/AiSdkResult;)V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "hashMap", "j", "(Landroid/service/notification/StatusBarNotification;Ljava/util/HashMap;)Z", "l", "p", "Lcom/upuphone/xr/sapp/monitor/notification/algorithm/AiHandleDataCall;", "b", "Lkotlin/Lazy;", "n", "()Lcom/upuphone/xr/sapp/monitor/notification/algorithm/AiHandleDataCall;", "aiHandleCall", "Ljava/util/HashMap;", "cache", "Ljava/util/ArrayList;", "Lcom/upuphone/xr/sapp/monitor/notification/rule/Rule;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "rule", "e", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nReminderBusinessHandle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReminderBusinessHandle.kt\ncom/upuphone/xr/sapp/monitor/notification/business/ReminderBusinessHandle\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,379:1\n314#2,11:380\n766#3:391\n857#3,2:392\n1855#3,2:394\n*S KotlinDebug\n*F\n+ 1 ReminderBusinessHandle.kt\ncom/upuphone/xr/sapp/monitor/notification/business/ReminderBusinessHandle\n*L\n180#1:380,11\n212#1:391\n212#1:392,2\n214#1:394,2\n*E\n"})
public final class ReminderBusinessHandle extends BusinessHandle {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);
    public final Lazy b = LazyKt.lazy(ReminderBusinessHandle$aiHandleCall$2.INSTANCE);
    public HashMap c = new HashMap();
    public ArrayList d = CollectionsKt.arrayListOf(new WechatRule(), new MmsRule(), new LockScreenRule(), new WhatsAppRule(), new LineRule(), new MmsServiceRule(), new SamsungCalendarRule(), new GoogleMessagingRule(), new SamsungMessagingRule(), new ScheduleRule());

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/business/ReminderBusinessHandle$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public BusinessType a() {
        return BusinessType.REMINDER;
    }

    public boolean c(StatusBarNotification statusBarNotification) {
        Intrinsics.checkNotNullParameter(statusBarNotification, "sbn");
        k(statusBarNotification);
        return false;
    }

    public void d(StatusBarNotification statusBarNotification, int i) {
        Intrinsics.checkNotNullParameter(statusBarNotification, "sbn");
        l(statusBarNotification);
        p(statusBarNotification);
    }

    public final boolean j(StatusBarNotification statusBarNotification, HashMap hashMap) {
        Unit unit;
        String e2 = NotificationHelper.f7775a.e(statusBarNotification);
        String str = (String) hashMap.get("title");
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        String str3 = (String) hashMap.get("content");
        if (str3 != null) {
            str2 = str3;
        }
        try {
            Result.Companion companion = Result.Companion;
            String str4 = (String) this.c.get(e2);
            if (str4 != null) {
                Intrinsics.checkNotNull(str4);
                List split$default = StringsKt.split$default((CharSequence) str4, new String[]{"-|-"}, false, 0, 6, (Object) null);
                String str5 = (String) split$default.get(1);
                String str6 = (String) split$default.get(2);
                String str7 = (String) split$default.get(3);
                if (Intrinsics.areEqual((Object) (String) split$default.get(0), (Object) String.valueOf(statusBarNotification.getId()))) {
                    if (Intrinsics.areEqual((Object) str7, (Object) str + str2)) {
                        ULog.f6446a.g("ReminderBusinessHandle", "checkSendCache:id&&title&&content");
                        return true;
                    }
                }
                if (statusBarNotification.getPostTime() - Long.parseLong(str5) < 1000) {
                    if (Intrinsics.areEqual((Object) str7, (Object) str + str2)) {
                        ULog.f6446a.g("ReminderBusinessHandle", "checkSendCache:time&&title&&content");
                        return true;
                    }
                }
                String groupKey = statusBarNotification.getGroupKey();
                Intrinsics.checkNotNullExpressionValue(groupKey, "getGroupKey(...)");
                if (groupKey.length() > 0 && Intrinsics.areEqual((Object) statusBarNotification.getGroupKey(), (Object) str6)) {
                    if (Intrinsics.areEqual((Object) str7, (Object) str + str2)) {
                        ULog.f6446a.g("ReminderBusinessHandle", "checkSendCache:groupKey&&title&&content");
                        return true;
                    }
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            Result.m20constructorimpl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m20constructorimpl(ResultKt.createFailure(th));
        }
        return false;
    }

    public final void k(StatusBarNotification statusBarNotification) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        T t = "";
        objectRef.element = t;
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = t;
        NotificationHelper notificationHelper = NotificationHelper.f7775a;
        HashMap a2 = notificationHelper.a(statusBarNotification);
        if (a2 != null) {
            T t2 = (String) a2.get("title");
            if (t2 == null) {
                t2 = t;
            } else {
                Intrinsics.checkNotNull(t2);
            }
            objectRef.element = t2;
            T t3 = (String) a2.get("content");
            if (t3 != null) {
                Intrinsics.checkNotNull(t3);
                t = t3;
            }
            objectRef2.element = t;
        }
        String e2 = notificationHelper.e(statusBarNotification);
        String c2 = new PackageHelper().c(SdkContext.f6675a.c().getContext(), e2);
        ULog.Delegate delegate = ULog.f6446a;
        String h = notificationHelper.h((String) objectRef.element);
        String h2 = notificationHelper.h((String) objectRef2.element);
        delegate.a("ReminderBusinessHandle", "Data before processing---package:" + e2 + " | title:" + h + " | content:" + h2);
        if (((CharSequence) objectRef.element).length() == 0 && ((CharSequence) objectRef2.element).length() == 0) {
            delegate.a("ReminderBusinessHandle", "invalid notices return");
        } else if (Intrinsics.areEqual((Object) statusBarNotification.getNotification().category, (Object) PayloadConstant.PARAMS_KEY_INT_OTA_PROGRESS)) {
            delegate.a("ReminderBusinessHandle", "current notification is category_progress");
        } else if (statusBarNotification.getNotification().extras != null && statusBarNotification.getNotification().extras.containsKey("android.progressMax") && statusBarNotification.getNotification().extras.getInt("android.progressMax", 0) != 0) {
            delegate.a("ReminderBusinessHandle", "current notification is progress");
        } else if (Intrinsics.areEqual((Object) statusBarNotification.getNotification().category, (Object) "service")) {
            delegate.a("ReminderBusinessHandle", "current notification is category_service");
        } else if (Intrinsics.areEqual((Object) statusBarNotification.getNotification().category, (Object) "transport")) {
            delegate.a("ReminderBusinessHandle", "current notification is category_transport");
        } else if (StringsKt.contains$default((CharSequence) objectRef2.element, (CharSequence) "•  ", false, 2, (Object) null) && StringsKt.startsWith$default(StringsKt.trim((CharSequence) (String) objectRef2.element).toString(), c2, false, 2, (Object) null)) {
            delegate.c("ReminderBusinessHandle", "current notify is group update");
        } else if (StringsKt.contains$default((CharSequence) objectRef2.element, (CharSequence) "•  •  •", false, 2, (Object) null)) {
            delegate.c("ReminderBusinessHandle", "current notify is group update");
        } else {
            Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new ReminderBusinessHandle$dealNotification$2(this, statusBarNotification, objectRef, objectRef2, e2, (Continuation<? super ReminderBusinessHandle$dealNotification$2>) null), 3, (Object) null);
        }
    }

    public final void l(StatusBarNotification statusBarNotification) {
        if (statusBarNotification != null) {
            ULog.Delegate delegate = ULog.f6446a;
            String packageName = statusBarNotification.getPackageName();
            int id = statusBarNotification.getId();
            delegate.a("ReminderBusinessHandle", "ss dealNotificationRemovepackage:" + packageName + " id:" + id);
            String e2 = NotificationHelper.f7775a.e(statusBarNotification);
            int id2 = statusBarNotification.getId();
            StarryMessageHelper.t(StarryMessageHelper.f7799a, (byte[]) null, new StarryNotificationBase("DISMISS_NOTIFICATION", MapsKt.hashMapOf(TuplesKt.to("ids", ArraysKt.toList((T[]) new String[]{"phone-" + e2 + LunarCalendar.DATE_SEPARATOR + id2})), TuplesKt.to("type", 0))), (SendMessageListener) null, 5, (Object) null);
        }
    }

    public final void m(AiSdkResult aiSdkResult) {
        String a2;
        StatusBarNotification sbn = aiSdkResult.getSbn();
        if (!SuperNotificationManager.f7749a.C()) {
            ULog.f6446a.c("ReminderBusinessHandle", "current notify switch not open");
            return;
        }
        String e2 = NotificationHelper.f7775a.e(aiSdkResult.getSbn());
        AppNotifyConfigModel c2 = AppConfigHelper.d.a().c(e2);
        if (c2.getDisableState()) {
            ULog.Delegate delegate = ULog.f6446a;
            String packageName = sbn.getPackageName();
            delegate.c("ReminderBusinessHandle", "current notification【package:" + packageName + "】 is disabled by the user");
            return;
        }
        ArrayList arrayList = this.d;
        ArrayList<Rule> arrayList2 = new ArrayList<>();
        for (Object next : arrayList) {
            Rule rule = (Rule) next;
            if (Intrinsics.areEqual((Object) rule.a(), (Object) e2) || (a2 = rule.a()) == null || a2.length() == 0) {
                arrayList2.add(next);
            }
        }
        for (Rule rule2 : arrayList2) {
            if (!rule2.c(aiSdkResult)) {
                ULog.Delegate delegate2 = ULog.f6446a;
                String name = rule2.getClass().getName();
                delegate2.c("ReminderBusinessHandle", "current rule rule no match:" + name);
                return;
            }
        }
        if (c2.getShowAllNotify()) {
            ULog.f6446a.c("ReminderBusinessHandle", "current user setting all notice");
            q(sbn, aiSdkResult);
        } else if (aiSdkResult.getType() != ResultType.NoMatch) {
            ULog.f6446a.c("ReminderBusinessHandle", "current notify is ai matched");
            q(sbn, aiSdkResult);
        } else if (Regular.a(e2)) {
            ULog.f6446a.c("ReminderBusinessHandle", "current notify is ai support list && Result_Type_NoMatch");
        } else if (c2.getShowAllNotify() || sbn.getNotification().priority >= 1) {
            q(sbn, aiSdkResult);
        } else {
            ULog.Delegate delegate3 = ULog.f6446a;
            int i = sbn.getNotification().priority;
            delegate3.c("ReminderBusinessHandle", "current notify priority:" + i + " | is too low");
        }
    }

    public final AiHandleDataCall n() {
        return (AiHandleDataCall) this.b.getValue();
    }

    public final Object o(StatusBarNotification statusBarNotification, String str, String str2, String str3, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.x();
        NotificationSDK a2 = NotificationSDK.a(SdkContext.f6675a.c().getContext());
        Long boxLong = Boxing.boxLong(statusBarNotification.getPostTime());
        int id = statusBarNotification.getId();
        long postTime = statusBarNotification.getPostTime();
        a2.b(boxLong, str3, "phone-" + str3 + LunarCalendar.DATE_SEPARATOR + id + LunarCalendar.DATE_SEPARATOR + postTime, str, str2, Boxing.boxBoolean(true), new ReminderBusinessHandle$handleData$2$1(statusBarNotification, cancellableContinuationImpl));
        Object u = cancellableContinuationImpl.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u;
    }

    public final void p(StatusBarNotification statusBarNotification) {
        if (statusBarNotification != null) {
            String e2 = NotificationHelper.f7775a.e(statusBarNotification);
            if (this.c.containsKey(e2)) {
                String str = (String) this.c.get(e2);
                if (str == null) {
                    str = "";
                }
                Intrinsics.checkNotNull(str);
                int id = statusBarNotification.getId();
                if (StringsKt.startsWith$default(str, id + LunarCalendar.DATE_SEPARATOR, false, 2, (Object) null)) {
                    this.c.remove(e2);
                }
            }
        }
    }

    public final void q(StatusBarNotification statusBarNotification, AiSdkResult aiSdkResult) {
        byte[] bArr;
        StatusBarNotification statusBarNotification2 = statusBarNotification;
        AiSdkResult aiSdkResult2 = aiSdkResult;
        NotificationHelper notificationHelper = NotificationHelper.f7775a;
        HashMap a2 = notificationHelper.a(statusBarNotification2);
        if (a2 != null) {
            String e2 = notificationHelper.e(statusBarNotification2);
            StarryMessageHelper starryMessageHelper = StarryMessageHelper.f7799a;
            if (starryMessageHelper.h()) {
                bArr = null;
            } else if (PackageConfig.f7770a.c(e2)) {
                Notification notification = statusBarNotification.getNotification();
                Intrinsics.checkNotNullExpressionValue(notification, "getNotification(...)");
                bArr = notificationHelper.f(notification);
            } else {
                bArr = AppInfoHelper.f7840a.a(SdkContext.f6675a.c().getContext(), e2);
            }
            byte[] bArr2 = bArr;
            String str = (String) a2.get("title");
            String str2 = str == null ? "" : str;
            Intrinsics.checkNotNull(str2);
            String str3 = (String) a2.get("content");
            String str4 = str3 == null ? "" : str3;
            Intrinsics.checkNotNull(str4);
            String str5 = "phone-" + e2 + LunarCalendar.DATE_SEPARATOR + statusBarNotification.getId() + LunarCalendar.DATE_SEPARATOR + statusBarNotification.getPostTime();
            if (!j(statusBarNotification2, a2)) {
                ULog.f6446a.g("ReminderBusinessHandle", "sendArNotification id:" + str5 + " title:" + notificationHelper.h(str2) + " content:" + notificationHelper.h(str4));
                StarryMessageHelper.t(starryMessageHelper, bArr2, new StarryNotificationBase("SHOW_NOTIFICATION", ArraysKt.toList((T[]) new ArNotificationModel[]{new ArNotificationModel(str5, str2, str4, statusBarNotification.getPostTime(), (String) null, e2, AppInfoHelper.f7840a.b(e2), aiSdkResult2 != null ? aiSdkResult.getCanReply() : false, (String) null, n().b(aiSdkResult2), 272, (DefaultConstructorMarker) null)})), (SendMessageListener) null, 4, (Object) null);
                this.c.put(e2, statusBarNotification.getId() + "-|-" + statusBarNotification.getPostTime() + "-|-" + statusBarNotification.getGroupKey() + "-|-" + str2 + str4);
                SuperNotificationManager.f7749a.f();
            }
        }
    }
}
