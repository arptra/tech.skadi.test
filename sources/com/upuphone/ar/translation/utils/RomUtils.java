package com.upuphone.ar.translation.utils;

import android.os.Build;
import com.honey.account.constant.AccountConstantKt;
import com.ucar.vehiclesdk.MDevice;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.starrynet.common.StarryNetConstant;
import java.util.Locale;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u001c\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001+B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\r\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u0006J\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u0006J\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0018R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0018R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0018R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0018R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\r0\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0018R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0018R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0018R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\r0\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010\u0018R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\r0\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010\u0018R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\r0\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010\u0018R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\r0\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010\u0018¨\u0006,"}, d2 = {"Lcom/upuphone/ar/translation/utils/RomUtils;", "", "<init>", "()V", "", "f", "()Z", "i", "g", "e", "Lcom/upuphone/ar/translation/utils/RomUtils$RomInfo;", "c", "()Lcom/upuphone/ar/translation/utils/RomUtils$RomInfo;", "", "brand", "manufacturer", "", "romNames", "h", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "b", "()Ljava/lang/String;", "a", "d", "[Ljava/lang/String;", "ROM_HUAWEI", "ROM_VIVO", "ROM_XIAOMI", "ROM_OPPO", "ROM_ONEPLUS", "ROM_ZTE", "ROM_NUBIA", "ROM_LG", "j", "ROM_GOOGLE", "k", "ROM_SAMSUNG", "l", "ROM_MEIZU", "m", "ROM_LENOVO", "n", "ROM_HONOR", "RomInfo", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class RomUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final RomUtils f6371a = new RomUtils();
    public static final String[] b = {"huawei"};
    public static final String[] c = {MDevice.MANUFACTURERS_VIVO};
    public static final String[] d = {MDevice.MANUFACTURERS_XIAOMI};
    public static final String[] e = {MDevice.MANUFACTURERS_OPPO};
    public static final String[] f = {"oneplus"};
    public static final String[] g = {"zte"};
    public static final String[] h = {"nubia"};
    public static final String[] i = {"lg", "lge"};
    public static final String[] j = {"google"};
    public static final String[] k = {"samsung"};
    public static final String[] l = {MDevice.MANUFACTURERS_MEIZU};
    public static final String[] m = {"lenovo"};
    public static final String[] n = {"honor"};

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u0013\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/upuphone/ar/translation/utils/RomUtils$RomInfo;", "", "", "name", "version", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "b", "getVersion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class RomInfo {

        /* renamed from: a  reason: collision with root package name */
        public final String f6372a;
        public final String b;

        public RomInfo(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "version");
            this.f6372a = str;
            this.b = str2;
        }

        public final String a() {
            return this.f6372a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RomInfo)) {
                return false;
            }
            RomInfo romInfo = (RomInfo) obj;
            return Intrinsics.areEqual((Object) this.f6372a, (Object) romInfo.f6372a) && Intrinsics.areEqual((Object) this.b, (Object) romInfo.b);
        }

        public int hashCode() {
            return (this.f6372a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            String str = this.f6372a;
            String str2 = this.b;
            return "RomInfo(name='" + str + "', version='" + str2 + "')";
        }
    }

    public final String a() {
        try {
            String str = Build.BRAND;
            if (str == null) {
                return StarryNetConstant.DEVICE_NAME_UNKNOWN;
            }
            if (StringsKt.isBlank(str)) {
                return StarryNetConstant.DEVICE_NAME_UNKNOWN;
            }
            Intrinsics.checkNotNull(str);
            return str;
        } catch (Exception e2) {
            String stackTraceToString = ExceptionsKt.stackTraceToString(e2);
            LogExt.j("getBrand error=" + stackTraceToString, "RomKtUtils");
            return StarryNetConstant.DEVICE_NAME_UNKNOWN;
        }
    }

    public final String b() {
        try {
            String str = Build.MANUFACTURER;
            if (str == null) {
                return StarryNetConstant.DEVICE_NAME_UNKNOWN;
            }
            if (StringsKt.isBlank(str)) {
                return StarryNetConstant.DEVICE_NAME_UNKNOWN;
            }
            Intrinsics.checkNotNull(str);
            return str;
        } catch (Exception e2) {
            String stackTraceToString = ExceptionsKt.stackTraceToString(e2);
            LogExt.j("getManufacturer error=" + stackTraceToString, "RomKtUtils");
            return StarryNetConstant.DEVICE_NAME_UNKNOWN;
        }
    }

    public final RomInfo c() {
        String str;
        String a2 = a();
        String b2 = b();
        String[] strArr = b;
        if (h(a2, b2, strArr)) {
            str = strArr[0];
        } else {
            String[] strArr2 = c;
            if (h(a2, b2, strArr2)) {
                str = strArr2[0];
            } else {
                String[] strArr3 = d;
                if (h(a2, b2, strArr3)) {
                    str = strArr3[0];
                } else {
                    String[] strArr4 = e;
                    if (h(a2, b2, strArr4)) {
                        str = strArr4[0];
                    } else {
                        String[] strArr5 = f;
                        if (h(a2, b2, strArr5)) {
                            str = strArr5[0];
                        } else {
                            String[] strArr6 = g;
                            if (h(a2, b2, strArr6)) {
                                str = strArr6[0];
                            } else {
                                String[] strArr7 = h;
                                if (h(a2, b2, strArr7)) {
                                    str = strArr7[0];
                                } else {
                                    String[] strArr8 = i;
                                    if (h(a2, b2, strArr8)) {
                                        str = strArr8[0];
                                    } else {
                                        String[] strArr9 = j;
                                        if (h(a2, b2, strArr9)) {
                                            str = strArr9[0];
                                        } else {
                                            String[] strArr10 = k;
                                            if (h(a2, b2, strArr10)) {
                                                str = strArr10[0];
                                            } else {
                                                String[] strArr11 = l;
                                                if (h(a2, b2, strArr11)) {
                                                    str = strArr11[0];
                                                } else {
                                                    String[] strArr12 = m;
                                                    if (h(a2, b2, strArr12)) {
                                                        str = strArr12[0];
                                                    } else {
                                                        String[] strArr13 = n;
                                                        if (h(a2, b2, strArr13)) {
                                                            str = strArr13[0];
                                                        } else {
                                                            str = a2 + AccountConstantKt.DEFAULT_SEGMENT + b2;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return new RomInfo(str, d());
    }

    public final String d() {
        try {
            String str = Build.DISPLAY;
            if (str == null) {
                return StarryNetConstant.DEVICE_NAME_UNKNOWN;
            }
            if (StringsKt.isBlank(str)) {
                return StarryNetConstant.DEVICE_NAME_UNKNOWN;
            }
            Intrinsics.checkNotNull(str);
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return lowerCase;
        } catch (Exception e2) {
            String stackTraceToString = ExceptionsKt.stackTraceToString(e2);
            LogExt.j("getRomVersion error=" + stackTraceToString, "RomKtUtils");
            return StarryNetConstant.DEVICE_NAME_UNKNOWN;
        }
    }

    public final boolean e() {
        return Intrinsics.areEqual((Object) n[0], (Object) c().a());
    }

    public final boolean f() {
        return Intrinsics.areEqual((Object) b[0], (Object) c().a());
    }

    public final boolean g() {
        return Intrinsics.areEqual((Object) l[0], (Object) c().a());
    }

    public final boolean h(String str, String str2, String[] strArr) {
        for (String str3 : strArr) {
            if (StringsKt.contains((CharSequence) str, (CharSequence) str3, true) || StringsKt.contains((CharSequence) str2, (CharSequence) str3, true)) {
                return true;
            }
        }
        return false;
    }

    public final boolean i() {
        return Intrinsics.areEqual((Object) d[0], (Object) c().a());
    }
}
