package com.upuphone.xr.sapp.monitor.notification.algorithm;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.monitor.notification.model.ArNotificationModel;
import com.upuphone.xr.sapp.monitor.notification.model.DiscernResultModel;
import com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper;
import com.upuphone.xr.sapp.monitor.starry.StarryNotificationBase;
import com.upuphone.xr.sapp.utils.AppInfoHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007JC\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0004¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/algorithm/BaseParse;", "T", "", "<init>", "()V", "", "a", "()Ljava/lang/String;", "id", "title", "content", "", "crateTime", "packageName", "", "mByteArray", "", "b", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;[B)V", "", "data", "d", "(Ljava/util/List;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public abstract class BaseParse<T> {
    public static /* synthetic */ void c(BaseParse baseParse, String str, String str2, String str3, long j, String str4, byte[] bArr, int i, Object obj) {
        if (obj == null) {
            baseParse.b(str, str2, str3, j, str4, (i & 32) != 0 ? null : bArr);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendNotification");
    }

    public abstract String a();

    public final void b(String str, String str2, String str3, long j, String str4, byte[] bArr) {
        String str5 = str4;
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "content");
        Intrinsics.checkNotNullParameter(str5, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        StarryMessageHelper.t(StarryMessageHelper.f7799a, (bArr != null || str4.length() == 0) ? bArr : AppInfoHelper.f7840a.a(MainApplication.k.f(), str5), new StarryNotificationBase("SHOW_NOTIFICATION", ArraysKt.toList((T[]) new ArNotificationModel[]{new ArNotificationModel(str, str2, str3, j, (String) null, str4, AppInfoHelper.f7840a.b(str5), false, (String) null, (DiscernResultModel) null, 912, (DefaultConstructorMarker) null)})), (SendMessageListener) null, 4, (Object) null);
    }

    public final void d(List list) {
        Intrinsics.checkNotNullParameter(list, "data");
        ULog.f6446a.a("BaseParse", "sendSyncParseMessage");
        StarryMessageHelper.t(StarryMessageHelper.f7799a, (byte[]) null, new StarryNotificationBase(a(), CollectionsKt.toList(list)), (SendMessageListener) null, 5, (Object) null);
    }
}
