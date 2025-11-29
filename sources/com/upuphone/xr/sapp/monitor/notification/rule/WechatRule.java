package com.upuphone.xr.sapp.monitor.notification.rule;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import com.upuphone.xr.interconnect.util.log.ILog;
import com.upuphone.xr.sapp.context.GlassInfoExtKt;
import com.upuphone.xr.sapp.context.IGlassInfo;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager;
import com.upuphone.xr.sapp.monitor.notification.constants.PackageConfig;
import com.upuphone.xr.sapp.monitor.notification.mode.AiSdkResult;
import com.upuphone.xr.sapp.monitor.notification.utils.NotificationHelper;
import com.upuphone.xr.sapp.utils.OSHelper;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.dfu.DfuBaseService;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\bR\u001a\u0010\u0013\u001a\u00020\t8\u0006XD¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u000bR\u001a\u0010\u0019\u001a\u00020\u00148\u0006XD¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001b\u001a\u00020\u00148\u0006XD¢\u0006\f\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u001a\u0010\u001d\u001a\u00020\t8\u0006XD¢\u0006\f\n\u0004\b\u000f\u0010\u0011\u001a\u0004\b\u001c\u0010\u000bR\u001a\u0010\u001f\u001a\u00020\t8\u0006XD¢\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u001e\u0010\u000b¨\u0006\""}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/rule/WechatRule;", "Lcom/upuphone/xr/sapp/monitor/notification/rule/Rule;", "Lcom/upuphone/xr/sapp/monitor/notification/mode/AiSdkResult;", "<init>", "()V", "data", "", "f", "(Lcom/upuphone/xr/sapp/monitor/notification/mode/AiSdkResult;)Z", "", "a", "()Ljava/lang/String;", "", "d", "(Lcom/upuphone/xr/sapp/monitor/notification/mode/AiSdkResult;)V", "e", "b", "Ljava/lang/String;", "getFriendApplyClass", "friendApplyClass", "", "c", "I", "getLoginExpiresId", "()I", "loginExpiresId", "getMessageFailedId", "messageFailedId", "getServiceNotices", "serviceNotices", "getMultiTalk", "multiTalk", "g", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class WechatRule extends Rule<AiSdkResult> {
    public static final Companion g = new Companion((DefaultConstructorMarker) null);
    public final String b = "com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI";
    public final int c = DfuBaseService.ERROR_FILE_NOT_FOUND;
    public final int d = 1;
    public final String e = "notifymessage";
    public final String f = "com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/rule/WechatRule$Companion;", "", "()V", "AUTO_GROUP_KEY", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public String a() {
        return "com.tencent.mm";
    }

    public final void d(AiSdkResult aiSdkResult) {
        aiSdkResult.setCanReply(true);
        StatusBarNotification sbn = aiSdkResult.getSbn();
        OSHelper oSHelper = OSHelper.f7904a;
        if (!oSHelper.g() || !oSHelper.f() || SuperNotificationManager.f7749a.B()) {
            String b2 = b();
            boolean g2 = oSHelper.g();
            boolean f2 = oSHelper.f();
            ILog.e(b2, "isFlyMeOS:" + g2 + " isChineseLanguage:" + f2);
            aiSdkResult.setCanReply(false);
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            if (sbn.getNotification().contentIntent == null) {
                aiSdkResult.setCanReply(false);
                return;
            }
            NotificationHelper notificationHelper = NotificationHelper.f7775a;
            PendingIntent pendingIntent = sbn.getNotification().contentIntent;
            Intrinsics.checkNotNullExpressionValue(pendingIntent, "contentIntent");
            Intent d2 = notificationHelper.d(pendingIntent);
            Unit unit = null;
            if (d2 != null) {
                ComponentName component = d2.getComponent();
                if (Intrinsics.areEqual((Object) component != null ? component.getClassName() : null, (Object) this.b)) {
                    ILog.e(b(), "current notify is friend Apply");
                    aiSdkResult.setCanReply(false);
                }
                ComponentName component2 = d2.getComponent();
                if (Intrinsics.areEqual((Object) component2 != null ? component2.getClassName() : null, (Object) this.f)) {
                    ILog.e(b(), "current notify is multi Talk");
                    aiSdkResult.setCanReply(false);
                }
                if (sbn.getId() == this.c) {
                    ILog.e(b(), "current notify is login message");
                    aiSdkResult.setCanReply(false);
                }
                if (sbn.getId() == this.d) {
                    ILog.e(b(), "current notify is  message Failed");
                    aiSdkResult.setCanReply(false);
                }
                Bundle extras = d2.getExtras();
                if (extras != null) {
                    if (extras.containsKey("Main_User") && Intrinsics.areEqual(extras.get("Main_User"), (Object) this.e)) {
                        ILog.e(b(), "current notify is  service notices");
                        aiSdkResult.setCanReply(false);
                    }
                    unit = Unit.INSTANCE;
                }
            }
            Result.m20constructorimpl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m20constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final boolean e(AiSdkResult aiSdkResult) {
        IGlassInfo a2 = SdkContext.f6675a.e().a();
        if (a2 != null && GlassInfoExtKt.h(a2)) {
            return false;
        }
        if (a2 != null && GlassInfoExtKt.f(a2) && GlassInfoExtKt.j(GlassInfoExtKt.c(GlassInfoExtKt.d(a2.getRomVersion())), GlassInfoExtKt.c(GlassInfoExtKt.d("Flyme AR 1.0.6.3.20240424_Air_FR"))) >= 0) {
            return false;
        }
        StatusBarNotification sbn = aiSdkResult.getSbn();
        try {
            Result.Companion companion = Result.Companion;
            if (sbn.getNotification().contentIntent != null) {
                NotificationHelper notificationHelper = NotificationHelper.f7775a;
                PendingIntent pendingIntent = sbn.getNotification().contentIntent;
                Intrinsics.checkNotNullExpressionValue(pendingIntent, "contentIntent");
                Intent d2 = notificationHelper.d(pendingIntent);
                if (d2 != null) {
                    ComponentName component = d2.getComponent();
                    if (Intrinsics.areEqual((Object) component != null ? component.getClassName() : null, (Object) this.f)) {
                        ILog.e(b(), "current notify is multi talk true");
                        return true;
                    }
                }
            }
            Result.m20constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m20constructorimpl(ResultKt.createFailure(th));
        }
        return false;
    }

    /* renamed from: f */
    public boolean c(AiSdkResult aiSdkResult) {
        Intrinsics.checkNotNullParameter(aiSdkResult, "data");
        StatusBarNotification sbn = aiSdkResult.getSbn();
        if (Intrinsics.areEqual((Object) sbn.getTag(), (Object) "ranker_group")) {
            ILog.e(b(), "[ranker_group] current notify is group update");
            return false;
        }
        if (SuperNotificationManager.f7749a.B() || OSHelper.f7904a.f()) {
            PackageConfig packageConfig = PackageConfig.f7770a;
            String packageName = sbn.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
            if (packageConfig.c(packageName) && sbn.getId() == 40) {
                ILog.e(b(), "current notify is wechat call");
                return false;
            }
        }
        PackageConfig packageConfig2 = PackageConfig.f7770a;
        String packageName2 = sbn.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName2, "getPackageName(...)");
        if (!packageConfig2.c(packageName2) || sbn.getId() != 43) {
            if (OSHelper.f7904a.g()) {
                String packageName3 = sbn.getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName3, "getPackageName(...)");
                if (!packageConfig2.c(packageName3) || sbn.getId() != 40) {
                    String packageName4 = sbn.getPackageName();
                    Intrinsics.checkNotNullExpressionValue(packageName4, "getPackageName(...)");
                    if (packageConfig2.c(packageName4) && sbn.getId() == 41) {
                        ILog.e(b(), "current notify is wechat call");
                        return e(aiSdkResult);
                    }
                } else {
                    ILog.e(b(), "current notify is wechat call");
                    return false;
                }
            }
            d(aiSdkResult);
            return true;
        }
        ILog.e(b(), "current notify is wechat group call hint");
        return false;
    }
}
