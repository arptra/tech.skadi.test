package com.upuphone.ar.fastrecord.phone.db;

import androidx.annotation.Keep;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import com.upuphone.ar.fastrecord.phone.utils.RecordDataSaveUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0000H\u0002J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003JG\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001J\u0013\u0010'\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\u001eHÖ\u0001J\t\u0010*\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u0015¨\u0006+"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/db/RecordContentTagEntity;", "", "contentTagId", "", "recordId", "contentName", "", "createTime", "isNewEditBean", "", "accountId", "(JJLjava/lang/String;JZLjava/lang/String;)V", "getAccountId", "()Ljava/lang/String;", "setAccountId", "(Ljava/lang/String;)V", "getContentName", "setContentName", "getContentTagId", "()J", "setContentTagId", "(J)V", "getCreateTime", "setCreateTime", "()Z", "setNewEditBean", "(Z)V", "getRecordId", "setRecordId", "compareTo", "", "other", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "hashCode", "toString", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Entity
public final class RecordContentTagEntity implements Comparable<RecordContentTagEntity> {
    @NotNull
    private String accountId;
    @Nullable
    private String contentName;
    @PrimaryKey
    private long contentTagId;
    private long createTime;
    @Ignore
    private boolean isNewEditBean;
    private long recordId;

    public RecordContentTagEntity() {
        this(0, 0, (String) null, 0, false, (String) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RecordContentTagEntity copy$default(RecordContentTagEntity recordContentTagEntity, long j, long j2, String str, long j3, boolean z, String str2, int i, Object obj) {
        RecordContentTagEntity recordContentTagEntity2 = recordContentTagEntity;
        return recordContentTagEntity.copy((i & 1) != 0 ? recordContentTagEntity2.contentTagId : j, (i & 2) != 0 ? recordContentTagEntity2.recordId : j2, (i & 4) != 0 ? recordContentTagEntity2.contentName : str, (i & 8) != 0 ? recordContentTagEntity2.createTime : j3, (i & 16) != 0 ? recordContentTagEntity2.isNewEditBean : z, (i & 32) != 0 ? recordContentTagEntity2.accountId : str2);
    }

    public final long component1() {
        return this.contentTagId;
    }

    public final long component2() {
        return this.recordId;
    }

    @Nullable
    public final String component3() {
        return this.contentName;
    }

    public final long component4() {
        return this.createTime;
    }

    public final boolean component5() {
        return this.isNewEditBean;
    }

    @NotNull
    public final String component6() {
        return this.accountId;
    }

    @NotNull
    public final RecordContentTagEntity copy(long j, long j2, @Nullable String str, long j3, boolean z, @NotNull String str2) {
        String str3 = str2;
        Intrinsics.checkNotNullParameter(str3, "accountId");
        return new RecordContentTagEntity(j, j2, str, j3, z, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordContentTagEntity)) {
            return false;
        }
        RecordContentTagEntity recordContentTagEntity = (RecordContentTagEntity) obj;
        return this.contentTagId == recordContentTagEntity.contentTagId && this.recordId == recordContentTagEntity.recordId && Intrinsics.areEqual((Object) this.contentName, (Object) recordContentTagEntity.contentName) && this.createTime == recordContentTagEntity.createTime && this.isNewEditBean == recordContentTagEntity.isNewEditBean && Intrinsics.areEqual((Object) this.accountId, (Object) recordContentTagEntity.accountId);
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

    public final long getRecordId() {
        return this.recordId;
    }

    public int hashCode() {
        int hashCode = ((Long.hashCode(this.contentTagId) * 31) + Long.hashCode(this.recordId)) * 31;
        String str = this.contentName;
        return ((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.createTime)) * 31) + Boolean.hashCode(this.isNewEditBean)) * 31) + this.accountId.hashCode();
    }

    public final boolean isNewEditBean() {
        return this.isNewEditBean;
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

    public final void setNewEditBean(boolean z) {
        this.isNewEditBean = z;
    }

    public final void setRecordId(long j) {
        this.recordId = j;
    }

    @NotNull
    public String toString() {
        long j = this.contentTagId;
        long j2 = this.recordId;
        String str = this.contentName;
        long j3 = this.createTime;
        boolean z = this.isNewEditBean;
        String str2 = this.accountId;
        return "RecordContentTagEntity(contentTagId=" + j + ", recordId=" + j2 + ", contentName=" + str + ", createTime=" + j3 + ", isNewEditBean=" + z + ", accountId=" + str2 + ")";
    }

    public RecordContentTagEntity(long j, long j2, @Nullable String str, long j3, boolean z, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str2, "accountId");
        this.contentTagId = j;
        this.recordId = j2;
        this.contentName = str;
        this.createTime = j3;
        this.isNewEditBean = z;
        this.accountId = str2;
    }

    public int compareTo(@NotNull RecordContentTagEntity recordContentTagEntity) {
        Intrinsics.checkNotNullParameter(recordContentTagEntity, "other");
        return (int) (recordContentTagEntity.createTime - this.createTime);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RecordContentTagEntity(long j, long j2, String str, long j3, boolean z, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : j, (i & 2) != 0 ? 0 : j2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? 0 : j3, (i & 16) != 0 ? false : z, (i & 32) != 0 ? RecordDataSaveUtil.INSTANCE.getAccountId() : str2);
    }
}
