package com.upuphone.ar.fastrecord.phone.starrynet.bean.glass;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/starrynet/bean/glass/RecordCacheTag;", "", "type", "", "tag", "", "id", "byteArray", "", "(IJJ[B)V", "getByteArray", "()[B", "setByteArray", "([B)V", "getId", "()J", "getTag", "getType", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RecordCacheTag {
    @NotNull
    private byte[] byteArray;
    private final long id;
    private final long tag;
    private final int type;

    public RecordCacheTag(int i, long j, long j2, @NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "byteArray");
        this.type = i;
        this.tag = j;
        this.id = j2;
        this.byteArray = bArr;
    }

    public static /* synthetic */ RecordCacheTag copy$default(RecordCacheTag recordCacheTag, int i, long j, long j2, byte[] bArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = recordCacheTag.type;
        }
        if ((i2 & 2) != 0) {
            j = recordCacheTag.tag;
        }
        long j3 = j;
        if ((i2 & 4) != 0) {
            j2 = recordCacheTag.id;
        }
        long j4 = j2;
        if ((i2 & 8) != 0) {
            bArr = recordCacheTag.byteArray;
        }
        return recordCacheTag.copy(i, j3, j4, bArr);
    }

    public final int component1() {
        return this.type;
    }

    public final long component2() {
        return this.tag;
    }

    public final long component3() {
        return this.id;
    }

    @NotNull
    public final byte[] component4() {
        return this.byteArray;
    }

    @NotNull
    public final RecordCacheTag copy(int i, long j, long j2, @NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "byteArray");
        return new RecordCacheTag(i, j, j2, bArr);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordCacheTag)) {
            return false;
        }
        RecordCacheTag recordCacheTag = (RecordCacheTag) obj;
        return this.type == recordCacheTag.type && this.tag == recordCacheTag.tag && this.id == recordCacheTag.id && Intrinsics.areEqual((Object) this.byteArray, (Object) recordCacheTag.byteArray);
    }

    @NotNull
    public final byte[] getByteArray() {
        return this.byteArray;
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
        return (((((Integer.hashCode(this.type) * 31) + Long.hashCode(this.tag)) * 31) + Long.hashCode(this.id)) * 31) + Arrays.hashCode(this.byteArray);
    }

    public final void setByteArray(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<set-?>");
        this.byteArray = bArr;
    }

    @NotNull
    public String toString() {
        int i = this.type;
        long j = this.tag;
        long j2 = this.id;
        String arrays = Arrays.toString(this.byteArray);
        return "RecordCacheTag(type=" + i + ", tag=" + j + ", id=" + j2 + ", byteArray=" + arrays + ")";
    }
}
