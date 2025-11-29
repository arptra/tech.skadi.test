package com.upuphone.ar.fastrecord.phone.starrynet.bean.phone;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/starrynet/bean/phone/RecordPhoneAckGetCache;", "", "finish", "", "msgId", "", "sendSize", "(IJJ)V", "getFinish", "()I", "getMsgId", "()J", "getSendSize", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RecordPhoneAckGetCache {
    private final int finish;
    private final long msgId;
    private final long sendSize;

    public RecordPhoneAckGetCache(int i, long j, long j2) {
        this.finish = i;
        this.msgId = j;
        this.sendSize = j2;
    }

    public static /* synthetic */ RecordPhoneAckGetCache copy$default(RecordPhoneAckGetCache recordPhoneAckGetCache, int i, long j, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = recordPhoneAckGetCache.finish;
        }
        if ((i2 & 2) != 0) {
            j = recordPhoneAckGetCache.msgId;
        }
        long j3 = j;
        if ((i2 & 4) != 0) {
            j2 = recordPhoneAckGetCache.sendSize;
        }
        return recordPhoneAckGetCache.copy(i, j3, j2);
    }

    public final int component1() {
        return this.finish;
    }

    public final long component2() {
        return this.msgId;
    }

    public final long component3() {
        return this.sendSize;
    }

    @NotNull
    public final RecordPhoneAckGetCache copy(int i, long j, long j2) {
        return new RecordPhoneAckGetCache(i, j, j2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordPhoneAckGetCache)) {
            return false;
        }
        RecordPhoneAckGetCache recordPhoneAckGetCache = (RecordPhoneAckGetCache) obj;
        return this.finish == recordPhoneAckGetCache.finish && this.msgId == recordPhoneAckGetCache.msgId && this.sendSize == recordPhoneAckGetCache.sendSize;
    }

    public final int getFinish() {
        return this.finish;
    }

    public final long getMsgId() {
        return this.msgId;
    }

    public final long getSendSize() {
        return this.sendSize;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.finish) * 31) + Long.hashCode(this.msgId)) * 31) + Long.hashCode(this.sendSize);
    }

    @NotNull
    public String toString() {
        int i = this.finish;
        long j = this.msgId;
        long j2 = this.sendSize;
        return "RecordPhoneAckGetCache(finish=" + i + ", msgId=" + j + ", sendSize=" + j2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RecordPhoneAckGetCache(int i, long j, long j2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 1 : i, j, j2);
    }
}
