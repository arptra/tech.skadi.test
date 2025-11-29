package com.upuphone.ar.translation.iflytek.entity;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/upuphone/ar/translation/iflytek/entity/Src;", "", "type", "", "content", "", "(ILjava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getType", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Src {
    @SerializedName("content")
    @NotNull
    private final String content;
    @SerializedName("type")
    private final int type;

    public Src() {
        this(0, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Src copy$default(Src src, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = src.type;
        }
        if ((i2 & 2) != 0) {
            str = src.content;
        }
        return src.copy(i, str);
    }

    public final int component1() {
        return this.type;
    }

    @NotNull
    public final String component2() {
        return this.content;
    }

    @NotNull
    public final Src copy(int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "content");
        return new Src(i, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Src)) {
            return false;
        }
        Src src = (Src) obj;
        return this.type == src.type && Intrinsics.areEqual((Object) this.content, (Object) src.content);
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (Integer.hashCode(this.type) * 31) + this.content.hashCode();
    }

    @NotNull
    public String toString() {
        int i = this.type;
        String str = this.content;
        return "Src(type=" + i + ", content=" + str + ")";
    }

    public Src(int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "content");
        this.type = i;
        this.content = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Src(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 1 : i, (i2 & 2) != 0 ? "" : str);
    }
}
