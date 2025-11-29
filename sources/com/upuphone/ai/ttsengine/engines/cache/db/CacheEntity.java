package com.upuphone.ai.ttsengine.engines.cache.db;

import androidx.annotation.Keep;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/upuphone/ai/ttsengine/engines/cache/db/CacheEntity;", "", "word", "", "path", "updateTime", "", "count", "", "(Ljava/lang/String;Ljava/lang/String;JI)V", "getCount", "()I", "setCount", "(I)V", "getPath", "()Ljava/lang/String;", "getUpdateTime", "()J", "setUpdateTime", "(J)V", "getWord", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "aar_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
@Entity
public final class CacheEntity {
    private int count;
    @NotNull
    private final String path;
    private long updateTime;
    @NotNull
    @PrimaryKey
    private final String word;

    public CacheEntity(@NotNull String str, @NotNull String str2, long j, int i) {
        Intrinsics.checkNotNullParameter(str, "word");
        Intrinsics.checkNotNullParameter(str2, "path");
        this.word = str;
        this.path = str2;
        this.updateTime = j;
        this.count = i;
    }

    public static /* synthetic */ CacheEntity copy$default(CacheEntity cacheEntity, String str, String str2, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cacheEntity.word;
        }
        if ((i2 & 2) != 0) {
            str2 = cacheEntity.path;
        }
        String str3 = str2;
        if ((i2 & 4) != 0) {
            j = cacheEntity.updateTime;
        }
        long j2 = j;
        if ((i2 & 8) != 0) {
            i = cacheEntity.count;
        }
        return cacheEntity.copy(str, str3, j2, i);
    }

    @NotNull
    public final String component1() {
        return this.word;
    }

    @NotNull
    public final String component2() {
        return this.path;
    }

    public final long component3() {
        return this.updateTime;
    }

    public final int component4() {
        return this.count;
    }

    @NotNull
    public final CacheEntity copy(@NotNull String str, @NotNull String str2, long j, int i) {
        Intrinsics.checkNotNullParameter(str, "word");
        Intrinsics.checkNotNullParameter(str2, "path");
        return new CacheEntity(str, str2, j, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CacheEntity)) {
            return false;
        }
        CacheEntity cacheEntity = (CacheEntity) obj;
        return Intrinsics.areEqual((Object) this.word, (Object) cacheEntity.word) && Intrinsics.areEqual((Object) this.path, (Object) cacheEntity.path) && this.updateTime == cacheEntity.updateTime && this.count == cacheEntity.count;
    }

    public final int getCount() {
        return this.count;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    @NotNull
    public final String getWord() {
        return this.word;
    }

    public int hashCode() {
        return (((((this.word.hashCode() * 31) + this.path.hashCode()) * 31) + Long.hashCode(this.updateTime)) * 31) + Integer.hashCode(this.count);
    }

    public final void setCount(int i) {
        this.count = i;
    }

    public final void setUpdateTime(long j) {
        this.updateTime = j;
    }

    @NotNull
    public String toString() {
        String str = this.word;
        String str2 = this.path;
        long j = this.updateTime;
        int i = this.count;
        return "CacheEntity(word=" + str + ", path=" + str2 + ", updateTime=" + j + ", count=" + i + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CacheEntity(String str, String str2, long j, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j, (i2 & 8) != 0 ? 1 : i);
    }
}
