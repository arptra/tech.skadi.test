package com.upuphone.ar.translation.iflytek.entity;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/upuphone/ar/translation/iflytek/entity/Dst;", "", "type", "", "content", "", "finalSrc", "(ILjava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getFinalSrc", "getType", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Dst {
    @SerializedName("content")
    @NotNull
    private final String content;
    @SerializedName("finalSrc")
    @NotNull
    private final String finalSrc;
    @SerializedName("type")
    private final int type;

    public Dst() {
        this(0, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Dst copy$default(Dst dst, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = dst.type;
        }
        if ((i2 & 2) != 0) {
            str = dst.content;
        }
        if ((i2 & 4) != 0) {
            str2 = dst.finalSrc;
        }
        return dst.copy(i, str, str2);
    }

    public final int component1() {
        return this.type;
    }

    @NotNull
    public final String component2() {
        return this.content;
    }

    @NotNull
    public final String component3() {
        return this.finalSrc;
    }

    @NotNull
    public final Dst copy(int i, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(str2, "finalSrc");
        return new Dst(i, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Dst)) {
            return false;
        }
        Dst dst = (Dst) obj;
        return this.type == dst.type && Intrinsics.areEqual((Object) this.content, (Object) dst.content) && Intrinsics.areEqual((Object) this.finalSrc, (Object) dst.finalSrc);
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final String getFinalSrc() {
        return this.finalSrc;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.type) * 31) + this.content.hashCode()) * 31) + this.finalSrc.hashCode();
    }

    @NotNull
    public String toString() {
        int i = this.type;
        String str = this.content;
        String str2 = this.finalSrc;
        return "Dst(type=" + i + ", content=" + str + ", finalSrc=" + str2 + ")";
    }

    public Dst(int i, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(str2, "finalSrc");
        this.type = i;
        this.content = str;
        this.finalSrc = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Dst(int i, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 1 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2);
    }
}
