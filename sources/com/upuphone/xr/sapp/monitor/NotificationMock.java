package com.upuphone.xr.sapp.monitor;

import android.content.Context;
import com.upuphone.sdk.NotificationSDK;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.monitor.notification.algorithm.AiHandleDataCall;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/NotificationMock;", "", "<init>", "()V", "", "postTime", "", "packageName", "", "id", "title", "content", "", "a", "(JLjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "Lcom/upuphone/xr/sapp/monitor/notification/algorithm/AiHandleDataCall;", "b", "Lcom/upuphone/xr/sapp/monitor/notification/algorithm/AiHandleDataCall;", "handleDataCall", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class NotificationMock {

    /* renamed from: a  reason: collision with root package name */
    public static final NotificationMock f7736a = new NotificationMock();
    public static final AiHandleDataCall b;

    static {
        Context applicationContext = MainApplication.k.f().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        b = new AiHandleDataCall(applicationContext);
    }

    public final void a(long j, String str, int i, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "content");
        NotificationSDK.a(MainApplication.k.f().getApplicationContext()).b(Long.valueOf(j), str, String.valueOf(i), str2, str3, Boolean.TRUE, b);
    }
}
