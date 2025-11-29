package com.upuphone.xr.sapp.monitor.notification.business;

import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.SpannableString;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.monitor.notification.constants.PackageConfig;
import com.upuphone.xr.sapp.monitor.notification.model.WechatMissedCallModel;
import com.upuphone.xr.sapp.monitor.notification.utils.NotificationHelper;
import com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper;
import com.upuphone.xr.sapp.utils.PhoneTypeUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\bJ\u0019\u0010\u0012\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\bJ\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/business/MissedCallBusinessHandle;", "Lcom/upuphone/xr/sapp/monitor/notification/business/BusinessHandle;", "<init>", "()V", "Landroid/service/notification/StatusBarNotification;", "sbn", "", "c", "(Landroid/service/notification/StatusBarNotification;)Z", "", "reason", "", "d", "(Landroid/service/notification/StatusBarNotification;I)V", "Lcom/upuphone/xr/sapp/monitor/notification/business/BusinessType;", "a", "()Lcom/upuphone/xr/sapp/monitor/notification/business/BusinessType;", "h", "g", "Lcom/upuphone/xr/sapp/monitor/notification/model/WechatMissedCallModel;", "i", "(Landroid/service/notification/StatusBarNotification;)Lcom/upuphone/xr/sapp/monitor/notification/model/WechatMissedCallModel;", "b", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class MissedCallBusinessHandle extends BusinessHandle {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/business/MissedCallBusinessHandle$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public BusinessType a() {
        return BusinessType.MISSED_CALL;
    }

    public boolean c(StatusBarNotification statusBarNotification) {
        Intrinsics.checkNotNullParameter(statusBarNotification, "sbn");
        if (!h(statusBarNotification)) {
            return false;
        }
        ULog.f6446a.a("MissedCallBusinessHandle", "interceptWechatMissedCall success, not show notification any more");
        return true;
    }

    public void d(StatusBarNotification statusBarNotification, int i) {
        Intrinsics.checkNotNullParameter(statusBarNotification, "sbn");
        g(statusBarNotification);
    }

    public final boolean g(StatusBarNotification statusBarNotification) {
        WechatMissedCallModel i;
        if (!PhoneTypeUtils.f7912a.i() || statusBarNotification == null || (i = i(statusBarNotification)) == null) {
            return false;
        }
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new MissedCallBusinessHandle$clearWechatMissedCall$1(i, (Continuation<? super MissedCallBusinessHandle$clearWechatMissedCall$1>) null), 3, (Object) null);
        return true;
    }

    public final boolean h(StatusBarNotification statusBarNotification) {
        WechatMissedCallModel i;
        if (!PhoneTypeUtils.f7912a.i() || statusBarNotification == null || StarryMessageHelper.f7799a.g() || (i = i(statusBarNotification)) == null) {
            return false;
        }
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new MissedCallBusinessHandle$interceptWechatMissedCall$1(i, (Continuation<? super MissedCallBusinessHandle$interceptWechatMissedCall$1>) null), 3, (Object) null);
        return true;
    }

    public final WechatMissedCallModel i(StatusBarNotification statusBarNotification) {
        Bundle bundle;
        CharSequence charSequence;
        CharSequence charSequence2;
        String str;
        String str2;
        NotificationHelper notificationHelper = NotificationHelper.f7775a;
        if (!PackageConfig.f7770a.c(notificationHelper.e(statusBarNotification)) || (bundle = statusBarNotification.getNotification().extras) == null || (charSequence = bundle.getCharSequence("android.title")) == null || (charSequence2 = bundle.getCharSequence("android.text")) == null) {
            return null;
        }
        if (charSequence2 instanceof SpannableString) {
            SpannableString spannableString = (SpannableString) charSequence2;
            str = spannableString.subSequence(0, spannableString.length()).toString();
        } else {
            str = charSequence2.toString();
        }
        if (charSequence instanceof SpannableString) {
            SpannableString spannableString2 = (SpannableString) charSequence;
            str2 = spannableString2.subSequence(0, spannableString2.length()).toString();
        } else {
            str2 = charSequence.toString();
        }
        ULog.Delegate delegate = ULog.f6446a;
        String h = notificationHelper.h(str2);
        String h2 = notificationHelper.h(str);
        long postTime = statusBarNotification.getPostTime();
        delegate.a("MissedCallBusinessHandle", "parseWechatMissedCallMsg: title: " + h + ", content: " + h2 + ", id: " + postTime);
        MainApplication.Companion companion = MainApplication.k;
        String string = companion.f().getString(R.string.wechat_missed_call_notification_content);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = companion.f().getString(R.string.wechat_missed_video_call_notification_content);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = companion.f().getString(R.string.wechat_missed_call_notification_content_new);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) string, false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) string2, false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) string3, false, 2, (Object) null)) {
            return new WechatMissedCallModel(str2, statusBarNotification.getPostTime());
        }
        return null;
    }
}
