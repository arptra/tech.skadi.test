package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J#\u0010\n\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/upuphone/xr/sapp/entity/StandbyWidgetOrderSubInfo;", "", "widgets", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getWidgets", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class StandbyWidgetOrderSubInfo {
    @NotNull
    private final ArrayList<String> widgets;

    public StandbyWidgetOrderSubInfo() {
        this((ArrayList) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ StandbyWidgetOrderSubInfo copy$default(StandbyWidgetOrderSubInfo standbyWidgetOrderSubInfo, ArrayList<String> arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = standbyWidgetOrderSubInfo.widgets;
        }
        return standbyWidgetOrderSubInfo.copy(arrayList);
    }

    @NotNull
    public final ArrayList<String> component1() {
        return this.widgets;
    }

    @NotNull
    public final StandbyWidgetOrderSubInfo copy(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "widgets");
        return new StandbyWidgetOrderSubInfo(arrayList);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StandbyWidgetOrderSubInfo) && Intrinsics.areEqual((Object) this.widgets, (Object) ((StandbyWidgetOrderSubInfo) obj).widgets);
    }

    @NotNull
    public final ArrayList<String> getWidgets() {
        return this.widgets;
    }

    public int hashCode() {
        return this.widgets.hashCode();
    }

    @NotNull
    public String toString() {
        ArrayList<String> arrayList = this.widgets;
        return "StandbyWidgetOrderSubInfo(widgets=" + arrayList + ")";
    }

    public StandbyWidgetOrderSubInfo(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "widgets");
        this.widgets = arrayList;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StandbyWidgetOrderSubInfo(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : arrayList);
    }
}
