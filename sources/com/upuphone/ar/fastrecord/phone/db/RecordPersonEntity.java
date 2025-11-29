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
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010\fJ\u0011\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0000H\u0002J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\nHÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003JQ\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010+\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020!HÖ\u0001J\t\u0010.\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0012\"\u0004\b\u001b\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0012\"\u0004\b\u001f\u0010\u0014¨\u0006/"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/db/RecordPersonEntity;", "", "personTagId", "", "recordId", "personName", "", "personType", "createTime", "isNewEditBean", "", "accountId", "(JJLjava/lang/String;Ljava/lang/String;JZLjava/lang/String;)V", "getAccountId", "()Ljava/lang/String;", "setAccountId", "(Ljava/lang/String;)V", "getCreateTime", "()J", "setCreateTime", "(J)V", "()Z", "setNewEditBean", "(Z)V", "getPersonName", "setPersonName", "getPersonTagId", "setPersonTagId", "getPersonType", "setPersonType", "getRecordId", "setRecordId", "compareTo", "", "other", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "hashCode", "toString", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Entity
public final class RecordPersonEntity implements Comparable<RecordPersonEntity> {
    @NotNull
    private String accountId;
    private long createTime;
    @Ignore
    private boolean isNewEditBean;
    @Nullable
    private String personName;
    @PrimaryKey
    private long personTagId;
    @NotNull
    private String personType;
    private long recordId;

    public RecordPersonEntity() {
        this(0, 0, (String) null, (String) null, 0, false, (String) null, 127, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RecordPersonEntity copy$default(RecordPersonEntity recordPersonEntity, long j, long j2, String str, String str2, long j3, boolean z, String str3, int i, Object obj) {
        RecordPersonEntity recordPersonEntity2 = recordPersonEntity;
        return recordPersonEntity.copy((i & 1) != 0 ? recordPersonEntity2.personTagId : j, (i & 2) != 0 ? recordPersonEntity2.recordId : j2, (i & 4) != 0 ? recordPersonEntity2.personName : str, (i & 8) != 0 ? recordPersonEntity2.personType : str2, (i & 16) != 0 ? recordPersonEntity2.createTime : j3, (i & 32) != 0 ? recordPersonEntity2.isNewEditBean : z, (i & 64) != 0 ? recordPersonEntity2.accountId : str3);
    }

    public final long component1() {
        return this.personTagId;
    }

    public final long component2() {
        return this.recordId;
    }

    @Nullable
    public final String component3() {
        return this.personName;
    }

    @NotNull
    public final String component4() {
        return this.personType;
    }

    public final long component5() {
        return this.createTime;
    }

    public final boolean component6() {
        return this.isNewEditBean;
    }

    @NotNull
    public final String component7() {
        return this.accountId;
    }

    @NotNull
    public final RecordPersonEntity copy(long j, long j2, @Nullable String str, @NotNull String str2, long j3, boolean z, @NotNull String str3) {
        String str4 = str2;
        Intrinsics.checkNotNullParameter(str4, "personType");
        String str5 = str3;
        Intrinsics.checkNotNullParameter(str5, "accountId");
        return new RecordPersonEntity(j, j2, str, str4, j3, z, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordPersonEntity)) {
            return false;
        }
        RecordPersonEntity recordPersonEntity = (RecordPersonEntity) obj;
        return this.personTagId == recordPersonEntity.personTagId && this.recordId == recordPersonEntity.recordId && Intrinsics.areEqual((Object) this.personName, (Object) recordPersonEntity.personName) && Intrinsics.areEqual((Object) this.personType, (Object) recordPersonEntity.personType) && this.createTime == recordPersonEntity.createTime && this.isNewEditBean == recordPersonEntity.isNewEditBean && Intrinsics.areEqual((Object) this.accountId, (Object) recordPersonEntity.accountId);
    }

    @NotNull
    public final String getAccountId() {
        return this.accountId;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    @Nullable
    public final String getPersonName() {
        return this.personName;
    }

    public final long getPersonTagId() {
        return this.personTagId;
    }

    @NotNull
    public final String getPersonType() {
        return this.personType;
    }

    public final long getRecordId() {
        return this.recordId;
    }

    public int hashCode() {
        int hashCode = ((Long.hashCode(this.personTagId) * 31) + Long.hashCode(this.recordId)) * 31;
        String str = this.personName;
        return ((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.personType.hashCode()) * 31) + Long.hashCode(this.createTime)) * 31) + Boolean.hashCode(this.isNewEditBean)) * 31) + this.accountId.hashCode();
    }

    public final boolean isNewEditBean() {
        return this.isNewEditBean;
    }

    public final void setAccountId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.accountId = str;
    }

    public final void setCreateTime(long j) {
        this.createTime = j;
    }

    public final void setNewEditBean(boolean z) {
        this.isNewEditBean = z;
    }

    public final void setPersonName(@Nullable String str) {
        this.personName = str;
    }

    public final void setPersonTagId(long j) {
        this.personTagId = j;
    }

    public final void setPersonType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.personType = str;
    }

    public final void setRecordId(long j) {
        this.recordId = j;
    }

    @NotNull
    public String toString() {
        long j = this.personTagId;
        long j2 = this.recordId;
        String str = this.personName;
        String str2 = this.personType;
        long j3 = this.createTime;
        boolean z = this.isNewEditBean;
        String str3 = this.accountId;
        return "RecordPersonEntity(personTagId=" + j + ", recordId=" + j2 + ", personName=" + str + ", personType=" + str2 + ", createTime=" + j3 + ", isNewEditBean=" + z + ", accountId=" + str3 + ")";
    }

    public RecordPersonEntity(long j, long j2, @Nullable String str, @NotNull String str2, long j3, boolean z, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str2, "personType");
        Intrinsics.checkNotNullParameter(str3, "accountId");
        this.personTagId = j;
        this.recordId = j2;
        this.personName = str;
        this.personType = str2;
        this.createTime = j3;
        this.isNewEditBean = z;
        this.accountId = str3;
    }

    public int compareTo(@NotNull RecordPersonEntity recordPersonEntity) {
        Intrinsics.checkNotNullParameter(recordPersonEntity, "other");
        return (int) (recordPersonEntity.createTime - this.createTime);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RecordPersonEntity(long j, long j2, String str, String str2, long j3, boolean z, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : j, (i & 2) != 0 ? 0 : j2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? "" : str2, (i & 16) != 0 ? 0 : j3, (i & 32) != 0 ? false : z, (i & 64) != 0 ? RecordDataSaveUtil.INSTANCE.getAccountId() : str3);
    }
}
