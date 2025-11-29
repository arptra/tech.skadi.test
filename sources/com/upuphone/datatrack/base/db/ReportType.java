package com.upuphone.datatrack.base.db;

import androidx.annotation.Keep;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/upuphone/datatrack/base/db/ReportType;", "", "id", "", "name", "", "type", "", "(JLjava/lang/String;I)V", "getId", "()J", "getName", "()Ljava/lang/String;", "getType", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "datatrack-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Entity
public final class ReportType {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @PrimaryKey
    private final long id;
    @NotNull
    private final String name;
    private final int type;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/upuphone/datatrack/base/db/ReportType$Companion;", "", "<init>", "()V", "", "name", "", "type", "Lcom/upuphone/datatrack/base/db/ReportType;", "a", "(Ljava/lang/String;I)Lcom/upuphone/datatrack/base/db/ReportType;", "datatrack-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ReportType a(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "name");
            return new ReportType(0, str, i);
        }

        public Companion() {
        }
    }

    public ReportType(long j, @NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.id = j;
        this.name = str;
        this.type = i;
    }

    public static /* synthetic */ ReportType copy$default(ReportType reportType, long j, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = reportType.id;
        }
        if ((i2 & 2) != 0) {
            str = reportType.name;
        }
        if ((i2 & 4) != 0) {
            i = reportType.type;
        }
        return reportType.copy(j, str, i);
    }

    @JvmStatic
    @NotNull
    public static final ReportType newInstance(@NotNull String str, int i) {
        return Companion.a(str, i);
    }

    public final long component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.type;
    }

    @NotNull
    public final ReportType copy(long j, @NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "name");
        return new ReportType(j, str, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReportType)) {
            return false;
        }
        ReportType reportType = (ReportType) obj;
        return this.id == reportType.id && Intrinsics.areEqual((Object) this.name, (Object) reportType.name) && this.type == reportType.type;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((Long.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.type);
    }

    @NotNull
    public String toString() {
        return "ReportType(id=" + this.id + ", name=" + this.name + ", type=" + this.type + ')';
    }
}
