package com.xjmz.myvu.flutter.pigeon.impl;

import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.utils.DataTrackUtil;
import com.xjmz.myvu.flutter.pigeon.AndroidDataTrackApi;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJI\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/xjmz/myvu/flutter/pigeon/impl/DataTrackApiHandler;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidDataTrackApi$DataTrackApi;", "<init>", "()V", "", "eventName", "", "attributes", "", "reportEvent", "(Ljava/lang/String;Ljava/util/Map;)V", "iotDeviceId", "iotDeviceModel", "iotDeviceRom", "g", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class DataTrackApiHandler implements AndroidDataTrackApi.DataTrackApi {
    public void g(String str, Map map, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, "attributes");
        if (SdkContext.f6675a.c().e()) {
            DataTrackUtil.f7875a.q(str, map, str2, str3, str4);
        } else {
            DataTrackUtil.m(DataTrackUtil.f7875a, str, map, str2, str3, str4, false, 32, (Object) null);
        }
    }

    public void reportEvent(String str, Map map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, "attributes");
        SdkContext.f6675a.d().reportEvent(str, map);
    }
}
