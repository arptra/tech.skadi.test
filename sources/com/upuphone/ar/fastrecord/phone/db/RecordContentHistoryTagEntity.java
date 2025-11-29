package com.upuphone.ar.fastrecord.phone.db;

import androidx.annotation.Keep;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.upuphone.ar.fastrecord.phone.utils.RecordDataSaveUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\u0011\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0000H\u0002J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J3\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0016HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012¨\u0006\""}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/db/RecordContentHistoryTagEntity;", "", "contentTagId", "", "contentName", "", "createTime", "accountId", "(JLjava/lang/String;JLjava/lang/String;)V", "getAccountId", "()Ljava/lang/String;", "setAccountId", "(Ljava/lang/String;)V", "getContentName", "setContentName", "getContentTagId", "()J", "setContentTagId", "(J)V", "getCreateTime", "setCreateTime", "compareTo", "", "other", "component1", "component2", "component3", "component4", "copy", "equals", "", "", "hashCode", "toString", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Entity
public final class RecordContentHistoryTagEntity implements Comparable<RecordContentHistoryTagEntity> {
    @NotNull
    private String accountId;
    @Nullable
    private String contentName;
    @PrimaryKey
    private long contentTagId;
    private long createTime;

    public RecordContentHistoryTagEntity() {
        this(0, (String) null, 0, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RecordContentHistoryTagEntity copy$default(RecordContentHistoryTagEntity recordContentHistoryTagEntity, long j, String str, long j2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = recordContentHistoryTagEntity.contentTagId;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            str = recordContentHistoryTagEntity.contentName;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            j2 = recordContentHistoryTagEntity.createTime;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            str2 = recordContentHistoryTagEntity.accountId;
        }
        return recordContentHistoryTagEntity.copy(j3, str3, j4, str2);
    }

    public final long component1() {
        return this.contentTagId;
    }

    @Nullable
    public final String component2() {
        return this.contentName;
    }

    public final long component3() {
        return this.createTime;
    }

    @NotNull
    public final String component4() {
        return this.accountId;
    }

    @NotNull
    public final RecordContentHistoryTagEntity copy(long j, @Nullable String str, long j2, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str2, "accountId");
        return new RecordContentHistoryTagEntity(j, str, j2, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordContentHistoryTagEntity)) {
            return false;
        }
        RecordContentHistoryTagEntity recordContentHistoryTagEntity = (RecordContentHistoryTagEntity) obj;
        return this.contentTagId == recordContentHistoryTagEntity.contentTagId && Intrinsics.areEqual((Object) this.contentName, (Object) recordContentHistoryTagEntity.contentName) && this.createTime == recordContentHistoryTagEntity.createTime && Intrinsics.areEqual((Object) this.accountId, (Object) recordContentHistoryTagEntity.accountId);
    }

    @NotNull
    public final String getAccountId() {
        return this.accountId;
    }

    @Nullable
    public final String getContentName() {
        return this.contentName;
    }

    public final long getContentTagId() {
        return this.contentTagId;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public int hashCode() {
        int hashCode = Long.hashCode(this.contentTagId) * 31;
        String str = this.contentName;
        return ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.createTime)) * 31) + this.accountId.hashCode();
    }

    public final void setAccountId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.accountId = str;
    }

    public final void setContentName(@Nullable String str) {
        this.contentName = str;
    }

    public final void setContentTagId(long j) {
        this.contentTagId = j;
    }

    public final void setCreateTime(long j) {
        this.createTime = j;
    }

    @NotNull
    public String toString() {
        long j = this.contentTagId;
        String str = this.contentName;
        long j2 = this.createTime;
        String str2 = this.accountId;
        return "RecordContentHistoryTagEntity(contentTagId=" + j + ", contentName=" + str + ", createTime=" + j2 + ", accountId=" + str2 + ")";
    }

    public RecordContentHistoryTagEntity(long j, @Nullable String str, long j2, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str2, "accountId");
        this.contentTagId = j;
        this.contentName = str;
        this.createTime = j2;
        this.accountId = str2;
    }

    public int compareTo(@NotNull RecordContentHistoryTagEntity recordContentHistoryTagEntity) {
        Intrinsics.checkNotNullParameter(recordContentHistoryTagEntity, "other");
        return (int) (recordContentHistoryTagEntity.createTime - this.createTime);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RecordContentHistoryTagEntity(long j, String str, long j2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? 0 : j2, (i & 8) != 0 ? RecordDataSaveUtil.INSTANCE.getAccountId() : str2);
    }
}
