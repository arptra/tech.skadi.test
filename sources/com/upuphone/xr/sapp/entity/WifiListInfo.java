package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import com.upuphone.xr.sapp.guide.model.WifiInfoModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/upuphone/xr/sapp/entity/WifiListInfo;", "", "list", "", "Lcom/upuphone/xr/sapp/guide/model/WifiInfoModel;", "time", "", "(Ljava/util/List;J)V", "getList", "()Ljava/util/List;", "getTime", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class WifiListInfo {
    @NotNull
    private final List<WifiInfoModel> list;
    private final long time;

    public WifiListInfo(@NotNull List<WifiInfoModel> list2, long j) {
        Intrinsics.checkNotNullParameter(list2, "list");
        this.list = list2;
        this.time = j;
    }

    public static /* synthetic */ WifiListInfo copy$default(WifiListInfo wifiListInfo, List<WifiInfoModel> list2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            list2 = wifiListInfo.list;
        }
        if ((i & 2) != 0) {
            j = wifiListInfo.time;
        }
        return wifiListInfo.copy(list2, j);
    }

    @NotNull
    public final List<WifiInfoModel> component1() {
        return this.list;
    }

    public final long component2() {
        return this.time;
    }

    @NotNull
    public final WifiListInfo copy(@NotNull List<WifiInfoModel> list2, long j) {
        Intrinsics.checkNotNullParameter(list2, "list");
        return new WifiListInfo(list2, j);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WifiListInfo)) {
            return false;
        }
        WifiListInfo wifiListInfo = (WifiListInfo) obj;
        return Intrinsics.areEqual((Object) this.list, (Object) wifiListInfo.list) && this.time == wifiListInfo.time;
    }

    @NotNull
    public final List<WifiInfoModel> getList() {
        return this.list;
    }

    public final long getTime() {
        return this.time;
    }

    public int hashCode() {
        return (this.list.hashCode() * 31) + Long.hashCode(this.time);
    }

    @NotNull
    public String toString() {
        List<WifiInfoModel> list2 = this.list;
        long j = this.time;
        return "WifiListInfo(list=" + list2 + ", time=" + j + ")";
    }
}
