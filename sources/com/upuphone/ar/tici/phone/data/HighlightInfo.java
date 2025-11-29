package com.upuphone.ar.tici.phone.data;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/upuphone/ar/tici/phone/data/HighlightInfo;", "", "text", "", "start", "", "end", "(Ljava/lang/String;II)V", "getEnd", "()I", "getStart", "getText", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class HighlightInfo {
    private final int end;
    private final int start;
    @NotNull
    private final String text;

    public HighlightInfo(@NotNull String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.text = str;
        this.start = i;
        this.end = i2;
    }

    public static /* synthetic */ HighlightInfo copy$default(HighlightInfo highlightInfo, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = highlightInfo.text;
        }
        if ((i3 & 2) != 0) {
            i = highlightInfo.start;
        }
        if ((i3 & 4) != 0) {
            i2 = highlightInfo.end;
        }
        return highlightInfo.copy(str, i, i2);
    }

    @NotNull
    public final String component1() {
        return this.text;
    }

    public final int component2() {
        return this.start;
    }

    public final int component3() {
        return this.end;
    }

    @NotNull
    public final HighlightInfo copy(@NotNull String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "text");
        return new HighlightInfo(str, i, i2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HighlightInfo)) {
            return false;
        }
        HighlightInfo highlightInfo = (HighlightInfo) obj;
        return Intrinsics.areEqual((Object) this.text, (Object) highlightInfo.text) && this.start == highlightInfo.start && this.end == highlightInfo.end;
    }

    public final int getEnd() {
        return this.end;
    }

    public final int getStart() {
        return this.start;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        return (((this.text.hashCode() * 31) + Integer.hashCode(this.start)) * 31) + Integer.hashCode(this.end);
    }

    @NotNull
    public String toString() {
        String str = this.text;
        int i = this.start;
        int i2 = this.end;
        return "HighlightInfo(text=" + str + ", start=" + i + ", end=" + i2 + ")";
    }
}
