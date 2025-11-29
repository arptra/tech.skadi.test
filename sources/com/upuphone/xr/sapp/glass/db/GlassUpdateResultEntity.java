package com.upuphone.xr.sapp.glass.db;

import androidx.annotation.Keep;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/upuphone/xr/sapp/glass/db/GlassUpdateResultEntity;", "", "id", "", "content", "", "time", "(JLjava/lang/String;J)V", "getContent", "()Ljava/lang/String;", "getId", "()J", "getTime", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Entity
public final class GlassUpdateResultEntity {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final String content;
    @PrimaryKey
    private final long id;
    private final long time;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/glass/db/GlassUpdateResultEntity$Companion;", "", "<init>", "()V", "", "content", "Lcom/upuphone/xr/sapp/glass/db/GlassUpdateResultEntity;", "a", "(Ljava/lang/String;)Lcom/upuphone/xr/sapp/glass/db/GlassUpdateResultEntity;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GlassUpdateResultEntity a(String str) {
            Intrinsics.checkNotNullParameter(str, "content");
            return new GlassUpdateResultEntity(0, str, System.currentTimeMillis());
        }

        public Companion() {
        }
    }

    public GlassUpdateResultEntity(long j, @NotNull String str, long j2) {
        Intrinsics.checkNotNullParameter(str, "content");
        this.id = j;
        this.content = str;
        this.time = j2;
    }

    public static /* synthetic */ GlassUpdateResultEntity copy$default(GlassUpdateResultEntity glassUpdateResultEntity, long j, String str, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = glassUpdateResultEntity.id;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            str = glassUpdateResultEntity.content;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            j2 = glassUpdateResultEntity.time;
        }
        return glassUpdateResultEntity.copy(j3, str2, j2);
    }

    public final long component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.content;
    }

    public final long component3() {
        return this.time;
    }

    @NotNull
    public final GlassUpdateResultEntity copy(long j, @NotNull String str, long j2) {
        Intrinsics.checkNotNullParameter(str, "content");
        return new GlassUpdateResultEntity(j, str, j2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GlassUpdateResultEntity)) {
            return false;
        }
        GlassUpdateResultEntity glassUpdateResultEntity = (GlassUpdateResultEntity) obj;
        return this.id == glassUpdateResultEntity.id && Intrinsics.areEqual((Object) this.content, (Object) glassUpdateResultEntity.content) && this.time == glassUpdateResultEntity.time;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    public final long getId() {
        return this.id;
    }

    public final long getTime() {
        return this.time;
    }

    public int hashCode() {
        return (((Long.hashCode(this.id) * 31) + this.content.hashCode()) * 31) + Long.hashCode(this.time);
    }

    @NotNull
    public String toString() {
        long j = this.id;
        String str = this.content;
        long j2 = this.time;
        return "GlassUpdateResultEntity(id=" + j + ", content=" + str + ", time=" + j2 + ")";
    }
}
