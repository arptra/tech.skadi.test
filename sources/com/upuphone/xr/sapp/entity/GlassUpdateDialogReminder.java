package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003JR\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\t\u0010\u000fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\r¨\u0006$"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassUpdateDialogReminder;", "", "needReminder", "", "version", "", "lastTime", "", "digest", "isAir", "filePath", "(ZLjava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getDigest", "()Ljava/lang/String;", "getFilePath", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLastTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getNeedReminder", "()Z", "getVersion", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ZLjava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/upuphone/xr/sapp/entity/GlassUpdateDialogReminder;", "equals", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class GlassUpdateDialogReminder {
    @Nullable
    private final String digest;
    @Nullable
    private final String filePath;
    @Nullable
    private final Boolean isAir;
    @Nullable
    private final Long lastTime;
    private final boolean needReminder;
    @NotNull
    private final String version;

    public GlassUpdateDialogReminder(boolean z, @NotNull String str, @Nullable Long l, @Nullable String str2, @Nullable Boolean bool, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "version");
        this.needReminder = z;
        this.version = str;
        this.lastTime = l;
        this.digest = str2;
        this.isAir = bool;
        this.filePath = str3;
    }

    public static /* synthetic */ GlassUpdateDialogReminder copy$default(GlassUpdateDialogReminder glassUpdateDialogReminder, boolean z, String str, Long l, String str2, Boolean bool, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = glassUpdateDialogReminder.needReminder;
        }
        if ((i & 2) != 0) {
            str = glassUpdateDialogReminder.version;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            l = glassUpdateDialogReminder.lastTime;
        }
        Long l2 = l;
        if ((i & 8) != 0) {
            str2 = glassUpdateDialogReminder.digest;
        }
        String str5 = str2;
        if ((i & 16) != 0) {
            bool = glassUpdateDialogReminder.isAir;
        }
        Boolean bool2 = bool;
        if ((i & 32) != 0) {
            str3 = glassUpdateDialogReminder.filePath;
        }
        return glassUpdateDialogReminder.copy(z, str4, l2, str5, bool2, str3);
    }

    public final boolean component1() {
        return this.needReminder;
    }

    @NotNull
    public final String component2() {
        return this.version;
    }

    @Nullable
    public final Long component3() {
        return this.lastTime;
    }

    @Nullable
    public final String component4() {
        return this.digest;
    }

    @Nullable
    public final Boolean component5() {
        return this.isAir;
    }

    @Nullable
    public final String component6() {
        return this.filePath;
    }

    @NotNull
    public final GlassUpdateDialogReminder copy(boolean z, @NotNull String str, @Nullable Long l, @Nullable String str2, @Nullable Boolean bool, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "version");
        return new GlassUpdateDialogReminder(z, str, l, str2, bool, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GlassUpdateDialogReminder)) {
            return false;
        }
        GlassUpdateDialogReminder glassUpdateDialogReminder = (GlassUpdateDialogReminder) obj;
        return this.needReminder == glassUpdateDialogReminder.needReminder && Intrinsics.areEqual((Object) this.version, (Object) glassUpdateDialogReminder.version) && Intrinsics.areEqual((Object) this.lastTime, (Object) glassUpdateDialogReminder.lastTime) && Intrinsics.areEqual((Object) this.digest, (Object) glassUpdateDialogReminder.digest) && Intrinsics.areEqual((Object) this.isAir, (Object) glassUpdateDialogReminder.isAir) && Intrinsics.areEqual((Object) this.filePath, (Object) glassUpdateDialogReminder.filePath);
    }

    @Nullable
    public final String getDigest() {
        return this.digest;
    }

    @Nullable
    public final String getFilePath() {
        return this.filePath;
    }

    @Nullable
    public final Long getLastTime() {
        return this.lastTime;
    }

    public final boolean getNeedReminder() {
        return this.needReminder;
    }

    @NotNull
    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        int hashCode = ((Boolean.hashCode(this.needReminder) * 31) + this.version.hashCode()) * 31;
        Long l = this.lastTime;
        int i = 0;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.digest;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.isAir;
        int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.filePath;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode4 + i;
    }

    @Nullable
    public final Boolean isAir() {
        return this.isAir;
    }

    @NotNull
    public String toString() {
        boolean z = this.needReminder;
        String str = this.version;
        Long l = this.lastTime;
        String str2 = this.digest;
        Boolean bool = this.isAir;
        String str3 = this.filePath;
        return "GlassUpdateDialogReminder(needReminder=" + z + ", version=" + str + ", lastTime=" + l + ", digest=" + str2 + ", isAir=" + bool + ", filePath=" + str3 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlassUpdateDialogReminder(boolean z, String str, Long l, String str2, Boolean bool, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, str, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : str3);
    }
}
