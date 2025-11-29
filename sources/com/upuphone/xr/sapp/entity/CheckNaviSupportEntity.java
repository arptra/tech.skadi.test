package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/upuphone/xr/sapp/entity/CheckNaviSupportEntity;", "", "status", "", "code", "", "data", "Lcom/upuphone/xr/sapp/entity/NaviSupportEntity;", "tstamp", "(Ljava/lang/String;ILcom/upuphone/xr/sapp/entity/NaviSupportEntity;Ljava/lang/String;)V", "getCode", "()I", "getData", "()Lcom/upuphone/xr/sapp/entity/NaviSupportEntity;", "getStatus", "()Ljava/lang/String;", "getTstamp", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class CheckNaviSupportEntity {
    private final int code;
    @NotNull
    private final NaviSupportEntity data;
    @NotNull
    private final String status;
    @NotNull
    private final String tstamp;

    public CheckNaviSupportEntity(@NotNull String str, int i, @NotNull NaviSupportEntity naviSupportEntity, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "status");
        Intrinsics.checkNotNullParameter(naviSupportEntity, "data");
        Intrinsics.checkNotNullParameter(str2, "tstamp");
        this.status = str;
        this.code = i;
        this.data = naviSupportEntity;
        this.tstamp = str2;
    }

    public static /* synthetic */ CheckNaviSupportEntity copy$default(CheckNaviSupportEntity checkNaviSupportEntity, String str, int i, NaviSupportEntity naviSupportEntity, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = checkNaviSupportEntity.status;
        }
        if ((i2 & 2) != 0) {
            i = checkNaviSupportEntity.code;
        }
        if ((i2 & 4) != 0) {
            naviSupportEntity = checkNaviSupportEntity.data;
        }
        if ((i2 & 8) != 0) {
            str2 = checkNaviSupportEntity.tstamp;
        }
        return checkNaviSupportEntity.copy(str, i, naviSupportEntity, str2);
    }

    @NotNull
    public final String component1() {
        return this.status;
    }

    public final int component2() {
        return this.code;
    }

    @NotNull
    public final NaviSupportEntity component3() {
        return this.data;
    }

    @NotNull
    public final String component4() {
        return this.tstamp;
    }

    @NotNull
    public final CheckNaviSupportEntity copy(@NotNull String str, int i, @NotNull NaviSupportEntity naviSupportEntity, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "status");
        Intrinsics.checkNotNullParameter(naviSupportEntity, "data");
        Intrinsics.checkNotNullParameter(str2, "tstamp");
        return new CheckNaviSupportEntity(str, i, naviSupportEntity, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CheckNaviSupportEntity)) {
            return false;
        }
        CheckNaviSupportEntity checkNaviSupportEntity = (CheckNaviSupportEntity) obj;
        return Intrinsics.areEqual((Object) this.status, (Object) checkNaviSupportEntity.status) && this.code == checkNaviSupportEntity.code && Intrinsics.areEqual((Object) this.data, (Object) checkNaviSupportEntity.data) && Intrinsics.areEqual((Object) this.tstamp, (Object) checkNaviSupportEntity.tstamp);
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final NaviSupportEntity getData() {
        return this.data;
    }

    @NotNull
    public final String getStatus() {
        return this.status;
    }

    @NotNull
    public final String getTstamp() {
        return this.tstamp;
    }

    public int hashCode() {
        return (((((this.status.hashCode() * 31) + Integer.hashCode(this.code)) * 31) + this.data.hashCode()) * 31) + this.tstamp.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.status;
        int i = this.code;
        NaviSupportEntity naviSupportEntity = this.data;
        String str2 = this.tstamp;
        return "CheckNaviSupportEntity(status=" + str + ", code=" + i + ", data=" + naviSupportEntity + ", tstamp=" + str2 + ")";
    }
}
