package com.upuphone.ar.fastrecord.phone.starrynet.bean.phone;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/starrynet/bean/phone/RecordPhoneRequestRetryDownload;", "", "id", "", "hasGetDataSize", "", "(IJ)V", "getHasGetDataSize", "()J", "getId", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RecordPhoneRequestRetryDownload {
    private final long hasGetDataSize;
    private final int id;

    public RecordPhoneRequestRetryDownload(int i, long j) {
        this.id = i;
        this.hasGetDataSize = j;
    }

    public static /* synthetic */ RecordPhoneRequestRetryDownload copy$default(RecordPhoneRequestRetryDownload recordPhoneRequestRetryDownload, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = recordPhoneRequestRetryDownload.id;
        }
        if ((i2 & 2) != 0) {
            j = recordPhoneRequestRetryDownload.hasGetDataSize;
        }
        return recordPhoneRequestRetryDownload.copy(i, j);
    }

    public final int component1() {
        return this.id;
    }

    public final long component2() {
        return this.hasGetDataSize;
    }

    @NotNull
    public final RecordPhoneRequestRetryDownload copy(int i, long j) {
        return new RecordPhoneRequestRetryDownload(i, j);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordPhoneRequestRetryDownload)) {
            return false;
        }
        RecordPhoneRequestRetryDownload recordPhoneRequestRetryDownload = (RecordPhoneRequestRetryDownload) obj;
        return this.id == recordPhoneRequestRetryDownload.id && this.hasGetDataSize == recordPhoneRequestRetryDownload.hasGetDataSize;
    }

    public final long getHasGetDataSize() {
        return this.hasGetDataSize;
    }

    public final int getId() {
        return this.id;
    }

    public int hashCode() {
        return (Integer.hashCode(this.id) * 31) + Long.hashCode(this.hasGetDataSize);
    }

    @NotNull
    public String toString() {
        int i = this.id;
        long j = this.hasGetDataSize;
        return "RecordPhoneRequestRetryDownload(id=" + i + ", hasGetDataSize=" + j + ")";
    }
}
