package com.upuphone.ar.fastrecord.phone.starrynet.bean.phone;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/starrynet/bean/phone/RecordPhoneRecId;", "", "id", "", "(J)V", "getId", "()J", "setId", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RecordPhoneRecId {
    private long id;

    public RecordPhoneRecId(long j) {
        this.id = j;
    }

    public static /* synthetic */ RecordPhoneRecId copy$default(RecordPhoneRecId recordPhoneRecId, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = recordPhoneRecId.id;
        }
        return recordPhoneRecId.copy(j);
    }

    public final long component1() {
        return this.id;
    }

    @NotNull
    public final RecordPhoneRecId copy(long j) {
        return new RecordPhoneRecId(j);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RecordPhoneRecId) && this.id == ((RecordPhoneRecId) obj).id;
    }

    public final long getId() {
        return this.id;
    }

    public int hashCode() {
        return Long.hashCode(this.id);
    }

    public final void setId(long j) {
        this.id = j;
    }

    @NotNull
    public String toString() {
        long j = this.id;
        return "RecordPhoneRecId(id=" + j + ")";
    }
}
