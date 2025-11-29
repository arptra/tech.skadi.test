package com.upuphone.xr.sapp.datatrack;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0012\b\u0017\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007¢\u0006\u0002\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/upuphone/xr/sapp/datatrack/DataTrackEvent;", "", "_event_name_", "", "ver", "rom_version", "devices_type", "", "phone_brand", "phone_rom_version", "phone_starrynet_version", "glass_starrynet_version", "data_reporting_source", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "get_event_name_", "()Ljava/lang/String;", "getData_reporting_source", "()I", "getDevices_type", "getGlass_starrynet_version", "getPhone_brand", "getPhone_rom_version", "getPhone_starrynet_version", "getRom_version", "getVer", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public class DataTrackEvent {
    @NotNull
    private final String _event_name_;
    private final int data_reporting_source;
    private final int devices_type;
    @NotNull
    private final String glass_starrynet_version;
    @NotNull
    private final String phone_brand;
    @NotNull
    private final String phone_rom_version;
    @NotNull
    private final String phone_starrynet_version;
    @NotNull
    private final String rom_version;
    @NotNull
    private final String ver;

    public DataTrackEvent(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, int i2) {
        Intrinsics.checkNotNullParameter(str, "_event_name_");
        Intrinsics.checkNotNullParameter(str2, "ver");
        Intrinsics.checkNotNullParameter(str3, "rom_version");
        Intrinsics.checkNotNullParameter(str4, "phone_brand");
        Intrinsics.checkNotNullParameter(str5, "phone_rom_version");
        Intrinsics.checkNotNullParameter(str6, "phone_starrynet_version");
        Intrinsics.checkNotNullParameter(str7, "glass_starrynet_version");
        this._event_name_ = str;
        this.ver = str2;
        this.rom_version = str3;
        this.devices_type = i;
        this.phone_brand = str4;
        this.phone_rom_version = str5;
        this.phone_starrynet_version = str6;
        this.glass_starrynet_version = str7;
        this.data_reporting_source = i2;
    }

    public final int getData_reporting_source() {
        return this.data_reporting_source;
    }

    public final int getDevices_type() {
        return this.devices_type;
    }

    @NotNull
    public final String getGlass_starrynet_version() {
        return this.glass_starrynet_version;
    }

    @NotNull
    public final String getPhone_brand() {
        return this.phone_brand;
    }

    @NotNull
    public final String getPhone_rom_version() {
        return this.phone_rom_version;
    }

    @NotNull
    public final String getPhone_starrynet_version() {
        return this.phone_starrynet_version;
    }

    @NotNull
    public final String getRom_version() {
        return this.rom_version;
    }

    @NotNull
    public final String getVer() {
        return this.ver;
    }

    @NotNull
    public final String get_event_name_() {
        return this._event_name_;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DataTrackEvent(java.lang.String r13, java.lang.String r14, java.lang.String r15, int r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, int r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r12 = this;
            r0 = r22
            r1 = r0 & 2
            if (r1 == 0) goto L_0x000a
            java.lang.String r1 = "1.0.0"
            r4 = r1
            goto L_0x000b
        L_0x000a:
            r4 = r14
        L_0x000b:
            r1 = r0 & 4
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x0020
            com.upuphone.xr.sapp.utils.ControlUtils r1 = com.upuphone.xr.sapp.utils.ControlUtils.f7858a
            com.upuphone.xr.sapp.entity.DeviceInfo r1 = r1.g()
            java.lang.String r1 = r1.getRomVersion()
            if (r1 != 0) goto L_0x001e
            r1 = r2
        L_0x001e:
            r5 = r1
            goto L_0x0021
        L_0x0020:
            r5 = r15
        L_0x0021:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0034
            java.lang.Boolean r1 = com.upuphone.xr.sapp.BuildConfig.b
            java.lang.String r3 = "THIRD_PLATFOM"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            boolean r1 = r1.booleanValue()
            r1 = r1 ^ 1
            r6 = r1
            goto L_0x0036
        L_0x0034:
            r6 = r16
        L_0x0036:
            r1 = r0 & 16
            java.lang.String r3 = "BRAND"
            if (r1 == 0) goto L_0x0043
            java.lang.String r1 = android.os.Build.BRAND
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            r7 = r1
            goto L_0x0045
        L_0x0043:
            r7 = r17
        L_0x0045:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0056
            com.upuphone.xr.sapp.utils.PhoneRomVersionUtil r1 = com.upuphone.xr.sapp.utils.PhoneRomVersionUtil.f7911a
            java.lang.String r8 = android.os.Build.BRAND
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r3)
            java.lang.String r1 = r1.b(r8)
            r8 = r1
            goto L_0x0058
        L_0x0056:
            r8 = r18
        L_0x0058:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x005e
            r10 = r2
            goto L_0x0060
        L_0x005e:
            r10 = r20
        L_0x0060:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0067
            r0 = 2
            r11 = r0
            goto L_0x0069
        L_0x0067:
            r11 = r21
        L_0x0069:
            r2 = r12
            r3 = r13
            r9 = r19
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.datatrack.DataTrackEvent.<init>(java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
