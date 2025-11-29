package com.upuphone.ar.fastrecord.phone.utils;

import com.upuphone.ar.fastrecord.phone.ext.RecordStringExtKt;
import com.upuphone.runasone.constant.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\b\u0010\u001a\u001a\u00020\u0003H\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/utils/RecordWebSocketConfig;", "", "url", "", "srcLang", "dstLang", "deviceId", "iotDeviceId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "getDstLang", "getIotDeviceId", "getSrcLang", "getUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RecordWebSocketConfig {
    @NotNull
    private final String deviceId;
    @NotNull
    private final String dstLang;
    @NotNull
    private final String iotDeviceId;
    @NotNull
    private final String srcLang;
    @NotNull
    private final String url;

    public RecordWebSocketConfig(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "srcLang");
        Intrinsics.checkNotNullParameter(str3, "dstLang");
        Intrinsics.checkNotNullParameter(str4, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str5, "iotDeviceId");
        this.url = str;
        this.srcLang = str2;
        this.dstLang = str3;
        this.deviceId = str4;
        this.iotDeviceId = str5;
    }

    public static /* synthetic */ RecordWebSocketConfig copy$default(RecordWebSocketConfig recordWebSocketConfig, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = recordWebSocketConfig.url;
        }
        if ((i & 2) != 0) {
            str2 = recordWebSocketConfig.srcLang;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = recordWebSocketConfig.dstLang;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = recordWebSocketConfig.deviceId;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = recordWebSocketConfig.iotDeviceId;
        }
        return recordWebSocketConfig.copy(str, str6, str7, str8, str5);
    }

    @NotNull
    public final String component1() {
        return this.url;
    }

    @NotNull
    public final String component2() {
        return this.srcLang;
    }

    @NotNull
    public final String component3() {
        return this.dstLang;
    }

    @NotNull
    public final String component4() {
        return this.deviceId;
    }

    @NotNull
    public final String component5() {
        return this.iotDeviceId;
    }

    @NotNull
    public final RecordWebSocketConfig copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "srcLang");
        Intrinsics.checkNotNullParameter(str3, "dstLang");
        Intrinsics.checkNotNullParameter(str4, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str5, "iotDeviceId");
        return new RecordWebSocketConfig(str, str2, str3, str4, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordWebSocketConfig)) {
            return false;
        }
        RecordWebSocketConfig recordWebSocketConfig = (RecordWebSocketConfig) obj;
        return Intrinsics.areEqual((Object) this.url, (Object) recordWebSocketConfig.url) && Intrinsics.areEqual((Object) this.srcLang, (Object) recordWebSocketConfig.srcLang) && Intrinsics.areEqual((Object) this.dstLang, (Object) recordWebSocketConfig.dstLang) && Intrinsics.areEqual((Object) this.deviceId, (Object) recordWebSocketConfig.deviceId) && Intrinsics.areEqual((Object) this.iotDeviceId, (Object) recordWebSocketConfig.iotDeviceId);
    }

    @NotNull
    public final String getDeviceId() {
        return this.deviceId;
    }

    @NotNull
    public final String getDstLang() {
        return this.dstLang;
    }

    @NotNull
    public final String getIotDeviceId() {
        return this.iotDeviceId;
    }

    @NotNull
    public final String getSrcLang() {
        return this.srcLang;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((((((this.url.hashCode() * 31) + this.srcLang.hashCode()) * 31) + this.dstLang.hashCode()) * 31) + this.deviceId.hashCode()) * 31) + this.iotDeviceId.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.url;
        String str2 = this.srcLang;
        String str3 = this.dstLang;
        String shortHandMixedLogData = RecordStringExtKt.shortHandMixedLogData(this.deviceId);
        String shortHandMixedLogData2 = RecordStringExtKt.shortHandMixedLogData(this.iotDeviceId);
        return "IntlTransConfig(url='" + str + "', srcLang='" + str2 + "', dstLang='" + str3 + "', deviceId='" + shortHandMixedLogData + "', iotDeviceId='" + shortHandMixedLogData2 + "')";
    }
}
