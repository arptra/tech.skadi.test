package com.upuphone.datatrack.base.model;

import androidx.annotation.Keep;
import com.upuphone.starrynet.payload.PayloadConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006 "}, d2 = {"Lcom/upuphone/datatrack/base/model/XJTrackData;", "", "id", "", "packageName", "", "name", "msg", "iotDeviceId", "iotDeviceRom", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()J", "getIotDeviceId", "()Ljava/lang/String;", "getIotDeviceRom", "getMsg", "getName", "getPackageName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "datatrack-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Keep
public final class XJTrackData {
    private final long id;
    @NotNull
    private final String iotDeviceId;
    @NotNull
    private final String iotDeviceRom;
    @NotNull
    private final String msg;
    @NotNull
    private final String name;
    @NotNull
    private final String packageName;

    public XJTrackData(long j, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        Intrinsics.checkNotNullParameter(str4, "iotDeviceId");
        Intrinsics.checkNotNullParameter(str5, "iotDeviceRom");
        this.id = j;
        this.packageName = str;
        this.name = str2;
        this.msg = str3;
        this.iotDeviceId = str4;
        this.iotDeviceRom = str5;
    }

    public static /* synthetic */ XJTrackData copy$default(XJTrackData xJTrackData, long j, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        XJTrackData xJTrackData2 = xJTrackData;
        return xJTrackData.copy((i & 1) != 0 ? xJTrackData2.id : j, (i & 2) != 0 ? xJTrackData2.packageName : str, (i & 4) != 0 ? xJTrackData2.name : str2, (i & 8) != 0 ? xJTrackData2.msg : str3, (i & 16) != 0 ? xJTrackData2.iotDeviceId : str4, (i & 32) != 0 ? xJTrackData2.iotDeviceRom : str5);
    }

    public final long component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.packageName;
    }

    @NotNull
    public final String component3() {
        return this.name;
    }

    @NotNull
    public final String component4() {
        return this.msg;
    }

    @NotNull
    public final String component5() {
        return this.iotDeviceId;
    }

    @NotNull
    public final String component6() {
        return this.iotDeviceRom;
    }

    @NotNull
    public final XJTrackData copy(long j, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        Intrinsics.checkNotNullParameter(str4, "iotDeviceId");
        Intrinsics.checkNotNullParameter(str5, "iotDeviceRom");
        return new XJTrackData(j, str, str2, str3, str4, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof XJTrackData)) {
            return false;
        }
        XJTrackData xJTrackData = (XJTrackData) obj;
        return this.id == xJTrackData.id && Intrinsics.areEqual((Object) this.packageName, (Object) xJTrackData.packageName) && Intrinsics.areEqual((Object) this.name, (Object) xJTrackData.name) && Intrinsics.areEqual((Object) this.msg, (Object) xJTrackData.msg) && Intrinsics.areEqual((Object) this.iotDeviceId, (Object) xJTrackData.iotDeviceId) && Intrinsics.areEqual((Object) this.iotDeviceRom, (Object) xJTrackData.iotDeviceRom);
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getIotDeviceId() {
        return this.iotDeviceId;
    }

    @NotNull
    public final String getIotDeviceRom() {
        return this.iotDeviceRom;
    }

    @NotNull
    public final String getMsg() {
        return this.msg;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        return (((((((((Long.hashCode(this.id) * 31) + this.packageName.hashCode()) * 31) + this.name.hashCode()) * 31) + this.msg.hashCode()) * 31) + this.iotDeviceId.hashCode()) * 31) + this.iotDeviceRom.hashCode();
    }

    @NotNull
    public String toString() {
        return "XJTrackData(id=" + this.id + ", packageName=" + this.packageName + ", name=" + this.name + ", msg=" + this.msg + ", iotDeviceId=" + this.iotDeviceId + ", iotDeviceRom=" + this.iotDeviceRom + ')';
    }
}
