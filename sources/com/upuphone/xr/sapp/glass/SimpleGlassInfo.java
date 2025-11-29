package com.upuphone.xr.sapp.glass;

import androidx.annotation.Keep;
import com.upuphone.xr.sapp.context.IGlassInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/upuphone/xr/sapp/glass/SimpleGlassInfo;", "Lcom/upuphone/xr/sapp/context/IGlassInfo;", "model", "", "romVersion", "(Ljava/lang/String;Ljava/lang/String;)V", "getModel", "()Ljava/lang/String;", "getRomVersion", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class SimpleGlassInfo implements IGlassInfo {
    @NotNull
    private final String model;
    @NotNull
    private final String romVersion;

    public SimpleGlassInfo(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "model");
        Intrinsics.checkNotNullParameter(str2, "romVersion");
        this.model = str;
        this.romVersion = str2;
    }

    public static /* synthetic */ SimpleGlassInfo copy$default(SimpleGlassInfo simpleGlassInfo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = simpleGlassInfo.model;
        }
        if ((i & 2) != 0) {
            str2 = simpleGlassInfo.romVersion;
        }
        return simpleGlassInfo.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.model;
    }

    @NotNull
    public final String component2() {
        return this.romVersion;
    }

    @NotNull
    public final SimpleGlassInfo copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "model");
        Intrinsics.checkNotNullParameter(str2, "romVersion");
        return new SimpleGlassInfo(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SimpleGlassInfo)) {
            return false;
        }
        SimpleGlassInfo simpleGlassInfo = (SimpleGlassInfo) obj;
        return Intrinsics.areEqual((Object) this.model, (Object) simpleGlassInfo.model) && Intrinsics.areEqual((Object) this.romVersion, (Object) simpleGlassInfo.romVersion);
    }

    @NotNull
    public String getModel() {
        return this.model;
    }

    @NotNull
    public String getRomVersion() {
        return this.romVersion;
    }

    public int hashCode() {
        return (this.model.hashCode() * 31) + this.romVersion.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.model;
        String str2 = this.romVersion;
        return "SimpleGlassInfo(model=" + str + ", romVersion=" + str2 + ")";
    }
}
