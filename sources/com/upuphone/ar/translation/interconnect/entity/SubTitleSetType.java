package com.upuphone.ar.translation.interconnect.entity;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/upuphone/ar/translation/interconnect/entity/SubTitleSetType;", "", "subtitleSetType", "", "(I)V", "getSubtitleSetType", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SubTitleSetType {
    @SerializedName("subtitleSetType")
    private final int subtitleSetType;

    public SubTitleSetType(int i) {
        this.subtitleSetType = i;
    }

    public static /* synthetic */ SubTitleSetType copy$default(SubTitleSetType subTitleSetType, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = subTitleSetType.subtitleSetType;
        }
        return subTitleSetType.copy(i);
    }

    public final int component1() {
        return this.subtitleSetType;
    }

    @NotNull
    public final SubTitleSetType copy(int i) {
        return new SubTitleSetType(i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SubTitleSetType) && this.subtitleSetType == ((SubTitleSetType) obj).subtitleSetType;
    }

    public final int getSubtitleSetType() {
        return this.subtitleSetType;
    }

    public int hashCode() {
        return Integer.hashCode(this.subtitleSetType);
    }

    @NotNull
    public String toString() {
        int i = this.subtitleSetType;
        return "SubTitleSetType(subtitleSetType=" + i + ")";
    }
}
