package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/upuphone/xr/sapp/entity/NaviSupportEntity;", "", "ukey", "", "uval", "(Ljava/lang/String;Ljava/lang/String;)V", "getUkey", "()Ljava/lang/String;", "getUval", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class NaviSupportEntity {
    @NotNull
    private final String ukey;
    @NotNull
    private final String uval;

    public NaviSupportEntity(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "ukey");
        Intrinsics.checkNotNullParameter(str2, "uval");
        this.ukey = str;
        this.uval = str2;
    }

    public static /* synthetic */ NaviSupportEntity copy$default(NaviSupportEntity naviSupportEntity, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = naviSupportEntity.ukey;
        }
        if ((i & 2) != 0) {
            str2 = naviSupportEntity.uval;
        }
        return naviSupportEntity.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.ukey;
    }

    @NotNull
    public final String component2() {
        return this.uval;
    }

    @NotNull
    public final NaviSupportEntity copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "ukey");
        Intrinsics.checkNotNullParameter(str2, "uval");
        return new NaviSupportEntity(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NaviSupportEntity)) {
            return false;
        }
        NaviSupportEntity naviSupportEntity = (NaviSupportEntity) obj;
        return Intrinsics.areEqual((Object) this.ukey, (Object) naviSupportEntity.ukey) && Intrinsics.areEqual((Object) this.uval, (Object) naviSupportEntity.uval);
    }

    @NotNull
    public final String getUkey() {
        return this.ukey;
    }

    @NotNull
    public final String getUval() {
        return this.uval;
    }

    public int hashCode() {
        return (this.ukey.hashCode() * 31) + this.uval.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.ukey;
        String str2 = this.uval;
        return "NaviSupportEntity(ukey=" + str + ", uval=" + str2 + ")";
    }
}
