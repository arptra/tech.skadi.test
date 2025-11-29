package com.xjmz.myvu.ext;

import com.xjmz.myvu.flutter.pigeon.AndroidConnectApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$DeviceInfo;", "", "a", "(Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$DeviceInfo;)Ljava/lang/String;", "app_intlRelease"}, k = 2, mv = {1, 9, 0})
public final class DeviceInfoExtKt {
    public static final String a(AndroidConnectApi.DeviceInfo deviceInfo) {
        Intrinsics.checkNotNullParameter(deviceInfo, "<this>");
        String c = deviceInfo.c();
        String d = deviceInfo.d();
        String b = deviceInfo.b();
        return "DeviceInfo{deviceName='" + c + "', modelId='" + d + "', deviceId='" + b + "'}";
    }
}
