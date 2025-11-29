package com.upuphone.ar.fastrecord.phone.starrynet.bean.glass;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/starrynet/bean/glass/RecordGlassAudioInfo;", "", "tag", "", "id", "type", "", "(JJI)V", "getId", "()J", "getTag", "getType", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RecordGlassAudioInfo {
    private final long id;
    private final long tag;
    private final int type;

    public RecordGlassAudioInfo(long j, long j2, int i) {
        this.tag = j;
        this.id = j2;
        this.type = i;
    }

    public static /* synthetic */ RecordGlassAudioInfo copy$default(RecordGlassAudioInfo recordGlassAudioInfo, long j, long j2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = recordGlassAudioInfo.tag;
        }
        long j3 = j;
        if ((i2 & 2) != 0) {
            j2 = recordGlassAudioInfo.id;
        }
        long j4 = j2;
        if ((i2 & 4) != 0) {
            i = recordGlassAudioInfo.type;
        }
        return recordGlassAudioInfo.copy(j3, j4, i);
    }

    public final long component1() {
        return this.tag;
    }

    public final long component2() {
        return this.id;
    }

    public final int component3() {
        return this.type;
    }

    @NotNull
    public final RecordGlassAudioInfo copy(long j, long j2, int i) {
        return new RecordGlassAudioInfo(j, j2, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordGlassAudioInfo)) {
            return false;
        }
        RecordGlassAudioInfo recordGlassAudioInfo = (RecordGlassAudioInfo) obj;
        return this.tag == recordGlassAudioInfo.tag && this.id == recordGlassAudioInfo.id && this.type == recordGlassAudioInfo.type;
    }

    public final long getId() {
        return this.id;
    }

    public final long getTag() {
        return this.tag;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((Long.hashCode(this.tag) * 31) + Long.hashCode(this.id)) * 31) + Integer.hashCode(this.type);
    }

    @NotNull
    public String toString() {
        long j = this.tag;
        long j2 = this.id;
        int i = this.type;
        return "RecordGlassAudioInfo(tag=" + j + ", id=" + j2 + ", type=" + i + ")";
    }
}
