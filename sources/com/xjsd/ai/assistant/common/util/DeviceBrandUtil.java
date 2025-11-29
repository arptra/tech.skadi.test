package com.xjsd.ai.assistant.common.util;

import android.os.Build;
import com.ucar.vehiclesdk.MDevice;
import com.xjsd.ai.assistant.log.ILog;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/xjsd/ai/assistant/common/util/DeviceBrandUtil;", "", "<init>", "()V", "", "c", "()Z", "g", "e", "f", "d", "b", "", "manufacturer", "a", "(Ljava/lang/String;)Z", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class DeviceBrandUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final DeviceBrandUtil f8444a = new DeviceBrandUtil();

    public static final boolean b() {
        return f8444a.a("honor");
    }

    public static final boolean c() {
        return f8444a.a("huawei");
    }

    public static final boolean d() {
        return f8444a.a(MDevice.MANUFACTURERS_MEIZU);
    }

    public static final boolean e() {
        return f8444a.a(MDevice.MANUFACTURERS_OPPO);
    }

    public static final boolean f() {
        return f8444a.a(MDevice.MANUFACTURERS_VIVO);
    }

    public static final boolean g() {
        return f8444a.a(MDevice.MANUFACTURERS_XIAOMI);
    }

    public final boolean a(String str) {
        String str2 = Build.MANUFACTURER;
        ILog.a("DeviceBrandUtil", "checkManufacturer: 手机品牌->" + str2);
        return StringsKt.equals(str, str2, true);
    }
}
