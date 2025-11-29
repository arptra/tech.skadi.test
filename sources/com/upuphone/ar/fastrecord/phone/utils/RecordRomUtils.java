package com.upuphone.ar.fastrecord.phone.utils;

import android.os.Build;
import com.honey.account.constant.AccountConstantKt;
import com.ucar.vehiclesdk.MDevice;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import java.util.Locale;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001*B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0002J\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0005H\u0002J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001c\u001a\u00020\u001aJ\u0006\u0010\u001d\u001a\u00020\u001aJ+\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0002\u0010\"J\u0006\u0010#\u001a\u00020\u001aJ\u0006\u0010$\u001a\u00020\u001aJ\u0006\u0010%\u001a\u00020\u001aJ\u0014\u0010&\u001a\u00020'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0)R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0012\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/utils/RecordRomUtils;", "", "()V", "ROM_GOOGLE", "", "", "[Ljava/lang/String;", "ROM_HUAWEI", "ROM_LENOVO", "ROM_LG", "ROM_MEIZU", "ROM_NUBIA", "ROM_ONEPLUS", "ROM_OPPO", "ROM_SAMSUNG", "ROM_VIVO", "ROM_XIAOMI", "ROM_ZTE", "TAG", "UNKNOWN", "getBrand", "getManufacturer", "getRomInfo", "Lcom/upuphone/ar/fastrecord/phone/utils/RecordRomUtils$RomInfo;", "getRomVersion", "isHuawei", "", "isMeizu", "isOneplus", "isOppo", "isRightRom", "brand", "manufacturer", "romNames", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "isSamsung", "isVivo", "isXiaomi", "needShowToastForCopy", "", "callback", "Lkotlin/Function0;", "RomInfo", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RecordRomUtils {
    @NotNull
    public static final RecordRomUtils INSTANCE = new RecordRomUtils();
    @NotNull
    private static final String[] ROM_GOOGLE = {"google"};
    @NotNull
    private static final String[] ROM_HUAWEI = {"huawei"};
    @NotNull
    private static final String[] ROM_LENOVO = {"lenovo"};
    @NotNull
    private static final String[] ROM_LG = {"lg", "lge"};
    @NotNull
    private static final String[] ROM_MEIZU = {MDevice.MANUFACTURERS_MEIZU};
    @NotNull
    private static final String[] ROM_NUBIA = {"nubia"};
    @NotNull
    private static final String[] ROM_ONEPLUS = {"oneplus"};
    @NotNull
    private static final String[] ROM_OPPO = {MDevice.MANUFACTURERS_OPPO};
    @NotNull
    private static final String[] ROM_SAMSUNG = {"samsung"};
    @NotNull
    private static final String[] ROM_VIVO = {MDevice.MANUFACTURERS_VIVO};
    @NotNull
    private static final String[] ROM_XIAOMI = {MDevice.MANUFACTURERS_XIAOMI};
    @NotNull
    private static final String[] ROM_ZTE = {"zte"};
    @NotNull
    private static final String TAG = "RomKtUtils";
    @NotNull
    private static final String UNKNOWN = "unknown";

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/utils/RecordRomUtils$RomInfo;", "", "name", "", "version", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getVersion", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RomInfo {
        @NotNull
        private final String name;
        @NotNull
        private final String version;

        public RomInfo() {
            this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ RomInfo copy$default(RomInfo romInfo, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = romInfo.name;
            }
            if ((i & 2) != 0) {
                str2 = romInfo.version;
            }
            return romInfo.copy(str, str2);
        }

        @NotNull
        public final String component1() {
            return this.name;
        }

        @NotNull
        public final String component2() {
            return this.version;
        }

        @NotNull
        public final RomInfo copy(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "version");
            return new RomInfo(str, str2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RomInfo)) {
                return false;
            }
            RomInfo romInfo = (RomInfo) obj;
            return Intrinsics.areEqual((Object) this.name, (Object) romInfo.name) && Intrinsics.areEqual((Object) this.version, (Object) romInfo.version);
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final String getVersion() {
            return this.version;
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.version.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.name;
            String str2 = this.version;
            return "RomInfo(name='" + str + "', version='" + str2 + "')";
        }

        public RomInfo(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "version");
            this.name = str;
            this.version = str2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ RomInfo(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
        }
    }

    private RecordRomUtils() {
    }

    private final String getBrand() {
        try {
            String str = Build.BRAND;
            if (str == null) {
                return "unknown";
            }
            if (StringsKt.isBlank(str)) {
                return "unknown";
            }
            Intrinsics.checkNotNull(str);
            return str;
        } catch (Exception e) {
            String stackTraceToString = ExceptionsKt.stackTraceToString(e);
            LogExt.logI("getBrand error=" + stackTraceToString, TAG);
            return "unknown";
        }
    }

    private final String getManufacturer() {
        try {
            String str = Build.MANUFACTURER;
            if (str == null) {
                return "unknown";
            }
            if (StringsKt.isBlank(str)) {
                return "unknown";
            }
            Intrinsics.checkNotNull(str);
            return str;
        } catch (Exception e) {
            String stackTraceToString = ExceptionsKt.stackTraceToString(e);
            LogExt.logI("getManufacturer error=" + stackTraceToString, TAG);
            return "unknown";
        }
    }

    private final String getRomVersion() {
        try {
            String str = Build.DISPLAY;
            if (str == null) {
                return "unknown";
            }
            if (StringsKt.isBlank(str)) {
                return "unknown";
            }
            Intrinsics.checkNotNull(str);
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return lowerCase;
        } catch (Exception e) {
            String stackTraceToString = ExceptionsKt.stackTraceToString(e);
            LogExt.logI("getRomVersion error=" + stackTraceToString, TAG);
            return "unknown";
        }
    }

    private final boolean isRightRom(String str, String str2, String[] strArr) {
        for (String str3 : strArr) {
            if (StringsKt.contains((CharSequence) str, (CharSequence) str3, true) || StringsKt.contains((CharSequence) str2, (CharSequence) str3, true)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final RomInfo getRomInfo() {
        String str;
        String brand = getBrand();
        String manufacturer = getManufacturer();
        String[] strArr = ROM_HUAWEI;
        if (isRightRom(brand, manufacturer, strArr)) {
            str = strArr[0];
        } else {
            String[] strArr2 = ROM_VIVO;
            if (isRightRom(brand, manufacturer, strArr2)) {
                str = strArr2[0];
            } else {
                String[] strArr3 = ROM_XIAOMI;
                if (isRightRom(brand, manufacturer, strArr3)) {
                    str = strArr3[0];
                } else {
                    String[] strArr4 = ROM_OPPO;
                    if (isRightRom(brand, manufacturer, strArr4)) {
                        str = strArr4[0];
                    } else {
                        String[] strArr5 = ROM_ONEPLUS;
                        if (isRightRom(brand, manufacturer, strArr5)) {
                            str = strArr5[0];
                        } else {
                            String[] strArr6 = ROM_ZTE;
                            if (isRightRom(brand, manufacturer, strArr6)) {
                                str = strArr6[0];
                            } else {
                                String[] strArr7 = ROM_NUBIA;
                                if (isRightRom(brand, manufacturer, strArr7)) {
                                    str = strArr7[0];
                                } else {
                                    String[] strArr8 = ROM_LG;
                                    if (isRightRom(brand, manufacturer, strArr8)) {
                                        str = strArr8[0];
                                    } else {
                                        String[] strArr9 = ROM_GOOGLE;
                                        if (isRightRom(brand, manufacturer, strArr9)) {
                                            str = strArr9[0];
                                        } else {
                                            String[] strArr10 = ROM_SAMSUNG;
                                            if (isRightRom(brand, manufacturer, strArr10)) {
                                                str = strArr10[0];
                                            } else {
                                                String[] strArr11 = ROM_MEIZU;
                                                if (isRightRom(brand, manufacturer, strArr11)) {
                                                    str = strArr11[0];
                                                } else {
                                                    String[] strArr12 = ROM_LENOVO;
                                                    if (isRightRom(brand, manufacturer, strArr12)) {
                                                        str = strArr12[0];
                                                    } else {
                                                        str = brand + AccountConstantKt.DEFAULT_SEGMENT + manufacturer;
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
        LogExt.logE("romName = " + str + ",getRomVersion = " + getRomVersion(), TAG);
        return new RomInfo(str, getRomVersion());
    }

    public final boolean isHuawei() {
        return Intrinsics.areEqual((Object) ROM_HUAWEI[0], (Object) getRomInfo().getName());
    }

    public final boolean isMeizu() {
        return Intrinsics.areEqual((Object) ROM_MEIZU[0], (Object) getRomInfo().getName());
    }

    public final boolean isOneplus() {
        return Intrinsics.areEqual((Object) ROM_ONEPLUS[0], (Object) getRomInfo().getName());
    }

    public final boolean isOppo() {
        return Intrinsics.areEqual((Object) ROM_OPPO[0], (Object) getRomInfo().getName());
    }

    public final boolean isSamsung() {
        return Intrinsics.areEqual((Object) ROM_SAMSUNG[0], (Object) getRomInfo().getName());
    }

    public final boolean isVivo() {
        return Intrinsics.areEqual((Object) ROM_VIVO[0], (Object) getRomInfo().getName());
    }

    public final boolean isXiaomi() {
        return Intrinsics.areEqual((Object) ROM_XIAOMI[0], (Object) getRomInfo().getName());
    }

    public final void needShowToastForCopy(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "callback");
        if (isXiaomi() || isMeizu()) {
            LogExt.logE("needShowToastForCopy isXiaomi or isMeizu", TAG);
            function0.invoke();
            return;
        }
        int i = Build.VERSION.SDK_INT;
        LogExt.logE("needShowToastForCopy Build.VERSION.SDK_INT = " + i, TAG);
        if (i <= 32) {
            function0.invoke();
        }
    }
}
