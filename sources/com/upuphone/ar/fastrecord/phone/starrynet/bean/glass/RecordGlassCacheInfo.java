package com.upuphone.ar.fastrecord.phone.starrynet.bean.glass;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\u001d\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bHÆ\u0003JO\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0007HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR.\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014¨\u0006&"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/starrynet/bean/glass/RecordGlassCacheInfo;", "", "sendSize", "", "msgId", "totalSize", "finish", "", "list", "Ljava/util/ArrayList;", "Lcom/upuphone/ar/fastrecord/phone/starrynet/bean/glass/RecordCacheTag;", "Lkotlin/collections/ArrayList;", "(JJJILjava/util/ArrayList;)V", "getFinish", "()I", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "getMsgId", "()J", "setMsgId", "(J)V", "getSendSize", "setSendSize", "getTotalSize", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RecordGlassCacheInfo {
    private final int finish;
    @Nullable
    private ArrayList<RecordCacheTag> list;
    private long msgId;
    private long sendSize;
    private final long totalSize;

    public RecordGlassCacheInfo(long j, long j2, long j3, int i, @Nullable ArrayList<RecordCacheTag> arrayList) {
        this.sendSize = j;
        this.msgId = j2;
        this.totalSize = j3;
        this.finish = i;
        this.list = arrayList;
    }

    public static /* synthetic */ RecordGlassCacheInfo copy$default(RecordGlassCacheInfo recordGlassCacheInfo, long j, long j2, long j3, int i, ArrayList arrayList, int i2, Object obj) {
        RecordGlassCacheInfo recordGlassCacheInfo2 = recordGlassCacheInfo;
        return recordGlassCacheInfo.copy((i2 & 1) != 0 ? recordGlassCacheInfo2.sendSize : j, (i2 & 2) != 0 ? recordGlassCacheInfo2.msgId : j2, (i2 & 4) != 0 ? recordGlassCacheInfo2.totalSize : j3, (i2 & 8) != 0 ? recordGlassCacheInfo2.finish : i, (i2 & 16) != 0 ? recordGlassCacheInfo2.list : arrayList);
    }

    public final long component1() {
        return this.sendSize;
    }

    public final long component2() {
        return this.msgId;
    }

    public final long component3() {
        return this.totalSize;
    }

    public final int component4() {
        return this.finish;
    }

    @Nullable
    public final ArrayList<RecordCacheTag> component5() {
        return this.list;
    }

    @NotNull
    public final RecordGlassCacheInfo copy(long j, long j2, long j3, int i, @Nullable ArrayList<RecordCacheTag> arrayList) {
        return new RecordGlassCacheInfo(j, j2, j3, i, arrayList);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordGlassCacheInfo)) {
            return false;
        }
        RecordGlassCacheInfo recordGlassCacheInfo = (RecordGlassCacheInfo) obj;
        return this.sendSize == recordGlassCacheInfo.sendSize && this.msgId == recordGlassCacheInfo.msgId && this.totalSize == recordGlassCacheInfo.totalSize && this.finish == recordGlassCacheInfo.finish && Intrinsics.areEqual((Object) this.list, (Object) recordGlassCacheInfo.list);
    }

    public final int getFinish() {
        return this.finish;
    }

    @Nullable
    public final ArrayList<RecordCacheTag> getList() {
        return this.list;
    }

    public final long getMsgId() {
        return this.msgId;
    }

    public final long getSendSize() {
        return this.sendSize;
    }

    public final long getTotalSize() {
        return this.totalSize;
    }

    public int hashCode() {
        int hashCode = ((((((Long.hashCode(this.sendSize) * 31) + Long.hashCode(this.msgId)) * 31) + Long.hashCode(this.totalSize)) * 31) + Integer.hashCode(this.finish)) * 31;
        ArrayList<RecordCacheTag> arrayList = this.list;
        return hashCode + (arrayList == null ? 0 : arrayList.hashCode());
    }

    public final void setList(@Nullable ArrayList<RecordCacheTag> arrayList) {
        this.list = arrayList;
    }

    public final void setMsgId(long j) {
        this.msgId = j;
    }

    public final void setSendSize(long j) {
        this.sendSize = j;
    }

    @NotNull
    public String toString() {
        long j = this.sendSize;
        long j2 = this.msgId;
        long j3 = this.totalSize;
        int i = this.finish;
        ArrayList<RecordCacheTag> arrayList = this.list;
        return "RecordGlassCacheInfo(sendSize=" + j + ", msgId=" + j2 + ", totalSize=" + j3 + ", finish=" + i + ", list=" + arrayList + ")";
    }
}
