package com.xjmz.myvu.flutter.pigeon.impl;

import com.meizu.flyme.openidsdk.OpenIdHelper;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.utils.SystemPropertiesProxy;
import com.xjmz.myvu.flutter.pigeon.AndroidSystemPropertyApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/xjmz/myvu/flutter/pigeon/impl/SystemPropertyApiHandler;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidSystemPropertyApi$SystemPropertyApi;", "<init>", "()V", "", "property", "defaultValue", "h", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "a", "()Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class SystemPropertyApiHandler implements AndroidSystemPropertyApi.SystemPropertyApi {
    public String a() {
        String oaid = OpenIdHelper.getOAID(MainApplication.k.d());
        Intrinsics.checkNotNullExpressionValue(oaid, "getOAID(...)");
        return oaid;
    }

    public String h(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "property");
        Intrinsics.checkNotNullParameter(str2, "defaultValue");
        return SystemPropertiesProxy.f7925a.a(str, str2);
    }
}
