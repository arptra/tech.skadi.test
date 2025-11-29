package com.upuphone.xr.sapp.utils;

import com.upuphone.runasone.relay.api.IntentKey;
import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/utils/SystemPropertiesProxy;", "", "<init>", "()V", "", "key", "defaultValue", "a", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class SystemPropertiesProxy {

    /* renamed from: a  reason: collision with root package name */
    public static final SystemPropertiesProxy f7925a = new SystemPropertiesProxy();

    public final String a(String str, String str2) {
        Class<String> cls = String.class;
        Intrinsics.checkNotNullParameter(str, IntentKey.ACTIVITY.ACTION_KEY);
        Intrinsics.checkNotNullParameter(str2, "defaultValue");
        try {
            Class<?> cls2 = Class.forName("android.os.SystemProperties");
            Object invoke = cls2.getMethod("get", new Class[]{cls, cls}).invoke(cls2, new Object[]{str, str2});
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.String");
            return (String) invoke;
        } catch (Exception e) {
            ULog.f6446a.d("SystemPropertiesProxy", "getSystemProperty 获取系统属性出错: ", e);
            return str2;
        }
    }
}
