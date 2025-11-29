package com.upuphone.xr.sapp.vu.utils;

import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.entity.DeviceInfo;
import com.upuphone.xr.sapp.utils.PhoneTypeUtils;
import com.upuphone.xr.sapp.vu.vm.VuGlassesDeviceInfoModel;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/upuphone/xr/sapp/vu/utils/VuWebViewUtils;", "", "<init>", "()V", "", "a", "()Ljava/lang/String;", "c", "b", "d", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class VuWebViewUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final VuWebViewUtils f8107a = new VuWebViewUtils();

    public final String a() {
        String b = b();
        String d = d();
        return d + "/#/device/adaptation?" + b;
    }

    public final String b() {
        PhoneTypeUtils phoneTypeUtils = PhoneTypeUtils.f7912a;
        String b = phoneTypeUtils.b();
        String a2 = phoneTypeUtils.a();
        DeviceInfo d = VuGlassesDeviceInfoModel.f8112a.d();
        String romVersion = d.getRomVersion();
        if (romVersion == null) {
            romVersion = "1.0.0.0";
        }
        String model = d.getModel();
        String country = Locale.getDefault().getCountry();
        return "iotDeviceType=View&xrType=View&xrModel=" + model + "&deviceType=phone&brand=" + b + "&model=" + a2 + "&os=" + "Android" + "&appVer=" + "2.40.51" + "&iotDeviceRom=" + romVersion + "&country=" + country;
    }

    public final String c() {
        String b = b();
        String d = d();
        return d + "/#/issue?" + b;
    }

    public final String d() {
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        return bool.booleanValue() ? "https://mixture-global.myvu.cn" : "https://mixture.myvu.cn";
    }
}
