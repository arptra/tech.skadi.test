package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001c"}, d2 = {"Lcom/upuphone/xr/sapp/entity/StandbyWidgetInfo;", "", "widgetName", "", "isChecked", "", "viewType", "", "(Ljava/lang/String;ZI)V", "()Z", "setChecked", "(Z)V", "getViewType", "()I", "setViewType", "(I)V", "getWidgetName", "()Ljava/lang/String;", "setWidgetName", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class StandbyWidgetInfo {
    private boolean isChecked;
    private int viewType;
    @NotNull
    private String widgetName;

    public StandbyWidgetInfo() {
        this((String) null, false, 0, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ StandbyWidgetInfo copy$default(StandbyWidgetInfo standbyWidgetInfo, String str, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = standbyWidgetInfo.widgetName;
        }
        if ((i2 & 2) != 0) {
            z = standbyWidgetInfo.isChecked;
        }
        if ((i2 & 4) != 0) {
            i = standbyWidgetInfo.viewType;
        }
        return standbyWidgetInfo.copy(str, z, i);
    }

    @NotNull
    public final String component1() {
        return this.widgetName;
    }

    public final boolean component2() {
        return this.isChecked;
    }

    public final int component3() {
        return this.viewType;
    }

    @NotNull
    public final StandbyWidgetInfo copy(@NotNull String str, boolean z, int i) {
        Intrinsics.checkNotNullParameter(str, "widgetName");
        return new StandbyWidgetInfo(str, z, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StandbyWidgetInfo)) {
            return false;
        }
        StandbyWidgetInfo standbyWidgetInfo = (StandbyWidgetInfo) obj;
        return Intrinsics.areEqual((Object) this.widgetName, (Object) standbyWidgetInfo.widgetName) && this.isChecked == standbyWidgetInfo.isChecked && this.viewType == standbyWidgetInfo.viewType;
    }

    public final int getViewType() {
        return this.viewType;
    }

    @NotNull
    public final String getWidgetName() {
        return this.widgetName;
    }

    public int hashCode() {
        return (((this.widgetName.hashCode() * 31) + Boolean.hashCode(this.isChecked)) * 31) + Integer.hashCode(this.viewType);
    }

    public final boolean isChecked() {
        return this.isChecked;
    }

    public final void setChecked(boolean z) {
        this.isChecked = z;
    }

    public final void setViewType(int i) {
        this.viewType = i;
    }

    public final void setWidgetName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.widgetName = str;
    }

    @NotNull
    public String toString() {
        String str = this.widgetName;
        boolean z = this.isChecked;
        int i = this.viewType;
        return "StandbyWidgetInfo(widgetName=" + str + ", isChecked=" + z + ", viewType=" + i + ")";
    }

    public StandbyWidgetInfo(@NotNull String str, boolean z, int i) {
        Intrinsics.checkNotNullParameter(str, "widgetName");
        this.widgetName = str;
        this.isChecked = z;
        this.viewType = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StandbyWidgetInfo(String str, boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? 0 : i);
    }
}
