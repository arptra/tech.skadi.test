package com.upuphone.ar.fastrecord.phone.bean;

import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/bean/CacheAmplitudeInfo;", "", "recordId", "", "detailAmpData", "Ljava/util/LinkedList;", "Lcom/upuphone/ar/fastrecord/phone/bean/AmplitudeBean;", "(JLjava/util/LinkedList;)V", "getDetailAmpData", "()Ljava/util/LinkedList;", "setDetailAmpData", "(Ljava/util/LinkedList;)V", "getRecordId", "()J", "setRecordId", "(J)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CacheAmplitudeInfo {
    @NotNull
    private LinkedList<AmplitudeBean> detailAmpData;
    private long recordId;

    public CacheAmplitudeInfo(long j, @NotNull LinkedList<AmplitudeBean> linkedList) {
        Intrinsics.checkNotNullParameter(linkedList, "detailAmpData");
        this.recordId = j;
        this.detailAmpData = linkedList;
    }

    public static /* synthetic */ CacheAmplitudeInfo copy$default(CacheAmplitudeInfo cacheAmplitudeInfo, long j, LinkedList<AmplitudeBean> linkedList, int i, Object obj) {
        if ((i & 1) != 0) {
            j = cacheAmplitudeInfo.recordId;
        }
        if ((i & 2) != 0) {
            linkedList = cacheAmplitudeInfo.detailAmpData;
        }
        return cacheAmplitudeInfo.copy(j, linkedList);
    }

    public final long component1() {
        return this.recordId;
    }

    @NotNull
    public final LinkedList<AmplitudeBean> component2() {
        return this.detailAmpData;
    }

    @NotNull
    public final CacheAmplitudeInfo copy(long j, @NotNull LinkedList<AmplitudeBean> linkedList) {
        Intrinsics.checkNotNullParameter(linkedList, "detailAmpData");
        return new CacheAmplitudeInfo(j, linkedList);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CacheAmplitudeInfo)) {
            return false;
        }
        CacheAmplitudeInfo cacheAmplitudeInfo = (CacheAmplitudeInfo) obj;
        return this.recordId == cacheAmplitudeInfo.recordId && Intrinsics.areEqual((Object) this.detailAmpData, (Object) cacheAmplitudeInfo.detailAmpData);
    }

    @NotNull
    public final LinkedList<AmplitudeBean> getDetailAmpData() {
        return this.detailAmpData;
    }

    public final long getRecordId() {
        return this.recordId;
    }

    public int hashCode() {
        return (Long.hashCode(this.recordId) * 31) + this.detailAmpData.hashCode();
    }

    public final void setDetailAmpData(@NotNull LinkedList<AmplitudeBean> linkedList) {
        Intrinsics.checkNotNullParameter(linkedList, "<set-?>");
        this.detailAmpData = linkedList;
    }

    public final void setRecordId(long j) {
        this.recordId = j;
    }

    @NotNull
    public String toString() {
        long j = this.recordId;
        LinkedList<AmplitudeBean> linkedList = this.detailAmpData;
        return "CacheAmplitudeInfo(recordId=" + j + ", detailAmpData=" + linkedList + ")";
    }
}
