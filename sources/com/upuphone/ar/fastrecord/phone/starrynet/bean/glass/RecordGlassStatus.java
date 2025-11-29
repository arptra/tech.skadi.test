package com.upuphone.ar.fastrecord.phone.starrynet.bean.glass;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/starrynet/bean/glass/RecordGlassStatus;", "", "type", "", "state", "id", "", "(IIJ)V", "getId", "()J", "setId", "(J)V", "getState", "()I", "setState", "(I)V", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RecordGlassStatus {
    private long id;
    private int state;
    private final int type;

    public RecordGlassStatus(int i, int i2, long j) {
        this.type = i;
        this.state = i2;
        this.id = j;
    }

    public static /* synthetic */ RecordGlassStatus copy$default(RecordGlassStatus recordGlassStatus, int i, int i2, long j, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = recordGlassStatus.type;
        }
        if ((i3 & 2) != 0) {
            i2 = recordGlassStatus.state;
        }
        if ((i3 & 4) != 0) {
            j = recordGlassStatus.id;
        }
        return recordGlassStatus.copy(i, i2, j);
    }

    public final int component1() {
        return this.type;
    }

    public final int component2() {
        return this.state;
    }

    public final long component3() {
        return this.id;
    }

    @NotNull
    public final RecordGlassStatus copy(int i, int i2, long j) {
        return new RecordGlassStatus(i, i2, j);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordGlassStatus)) {
            return false;
        }
        RecordGlassStatus recordGlassStatus = (RecordGlassStatus) obj;
        return this.type == recordGlassStatus.type && this.state == recordGlassStatus.state && this.id == recordGlassStatus.id;
    }

    public final long getId() {
        return this.id;
    }

    public final int getState() {
        return this.state;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.type) * 31) + Integer.hashCode(this.state)) * 31) + Long.hashCode(this.id);
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final void setState(int i) {
        this.state = i;
    }

    @NotNull
    public String toString() {
        int i = this.type;
        int i2 = this.state;
        long j = this.id;
        return "RecordGlassStatus(type=" + i + ", state=" + i2 + ", id=" + j + ")";
    }
}
