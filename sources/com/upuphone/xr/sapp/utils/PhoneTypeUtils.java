package com.upuphone.xr.sapp.utils;

import android.os.Build;
import com.ucar.vehiclesdk.MDevice;
import com.upuphone.starrynet.common.StarryNetConstant;
import com.upuphone.xr.sapp.BuildConfig;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\r\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u0006J\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u0006J\r\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u0006J\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\u0006J\r\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u0006J\r\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u0006J\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0006J\r\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/upuphone/xr/sapp/utils/PhoneTypeUtils;", "", "<init>", "()V", "", "h", "()Z", "e", "f", "c", "j", "l", "i", "k", "", "b", "()Ljava/lang/String;", "a", "d", "g", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nPhoneTypeUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PhoneTypeUtils.kt\ncom/upuphone/xr/sapp/utils/PhoneTypeUtils\n+ 2 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n1#1,135:1\n107#2:136\n79#2,22:137\n*S KotlinDebug\n*F\n+ 1 PhoneTypeUtils.kt\ncom/upuphone/xr/sapp/utils/PhoneTypeUtils\n*L\n104#1:136\n104#1:137,22\n*E\n"})
public final class PhoneTypeUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final PhoneTypeUtils f7912a = new PhoneTypeUtils();

    public final String a() {
        String replace;
        String str = Build.MODEL;
        if (str == null) {
            return "";
        }
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
            if (!z) {
                if (!z2) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!z2) {
                break;
            } else {
                length--;
            }
        }
        String obj = str.subSequence(i, length + 1).toString();
        return (obj == null || (replace = new Regex("\\s*").replace((CharSequence) obj, "")) == null) ? "" : replace;
    }

    public final String b() {
        String str = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(str, "MANUFACTURER");
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return StringsKt.trim((CharSequence) lowerCase).toString();
    }

    public final boolean c() {
        String str = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(str, "MANUFACTURER");
        return StringsKt.equals("HUAWEI", str, true);
    }

    public final boolean d() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return StringsKt.equals("Harmony", cls.getMethod("getOsBrand", (Class[]) null).invoke(cls, (Object[]) null).toString(), true);
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean e() {
        String str = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(str, "MANUFACTURER");
        return StringsKt.equals(MDevice.MANUFACTURERS_XIAOMI, str, true);
    }

    public final boolean f() {
        if (e()) {
            Boolean bool = BuildConfig.f6575a;
            Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
            if (bool.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final boolean g() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return StringsKt.contains$default((CharSequence) cls.getMethod("getOsBrand", (Class[]) null).invoke(cls, (Object[]) null).toString(), (CharSequence) "magicui", false, 2, (Object) null);
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean h() {
        return Intrinsics.areEqual((Object) Build.MODEL, (Object) "MEIZU 20 Inf");
    }

    public final boolean i() {
        String str = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(str, "MANUFACTURER");
        return StringsKt.equals(MDevice.MANUFACTURERS_MEIZU, StringsKt.trim((CharSequence) str).toString(), true);
    }

    public final boolean j() {
        String str = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(str, "MANUFACTURER");
        return StringsKt.equals(StarryNetConstant.DEVICE_NAME_OPPO, str, true);
    }

    public final boolean k() {
        String str = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(str, "MANUFACTURER");
        return StringsKt.equals("samsung", StringsKt.trim((CharSequence) str).toString(), true);
    }

    public final boolean l() {
        String str = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(str, "MANUFACTURER");
        return StringsKt.equals(MDevice.MANUFACTURERS_VIVO, str, true);
    }
}
