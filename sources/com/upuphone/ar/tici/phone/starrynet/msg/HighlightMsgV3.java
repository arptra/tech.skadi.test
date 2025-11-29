package com.upuphone.ar.tici.phone.starrynet.msg;

import androidx.annotation.Keep;
import com.upuphone.ar.tici.phone.starrynet.BaseJsonMsg;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/upuphone/ar/tici/phone/starrynet/msg/HighlightMsgV3;", "Lcom/upuphone/ar/tici/phone/starrynet/BaseJsonMsg;", "fileKey", "", "index", "", "currentPage", "(Ljava/lang/String;II)V", "getCurrentPage", "()I", "getFileKey", "()Ljava/lang/String;", "getIndex", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class HighlightMsgV3 extends BaseJsonMsg {
    private final int currentPage;
    @NotNull
    private final String fileKey;
    private final int index;

    public HighlightMsgV3(@NotNull String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "fileKey");
        this.fileKey = str;
        this.index = i;
        this.currentPage = i2;
    }

    public static /* synthetic */ HighlightMsgV3 copy$default(HighlightMsgV3 highlightMsgV3, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = highlightMsgV3.fileKey;
        }
        if ((i3 & 2) != 0) {
            i = highlightMsgV3.index;
        }
        if ((i3 & 4) != 0) {
            i2 = highlightMsgV3.currentPage;
        }
        return highlightMsgV3.copy(str, i, i2);
    }

    @NotNull
    public final String component1() {
        return this.fileKey;
    }

    public final int component2() {
        return this.index;
    }

    public final int component3() {
        return this.currentPage;
    }

    @NotNull
    public final HighlightMsgV3 copy(@NotNull String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "fileKey");
        return new HighlightMsgV3(str, i, i2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HighlightMsgV3)) {
            return false;
        }
        HighlightMsgV3 highlightMsgV3 = (HighlightMsgV3) obj;
        return Intrinsics.areEqual((Object) this.fileKey, (Object) highlightMsgV3.fileKey) && this.index == highlightMsgV3.index && this.currentPage == highlightMsgV3.currentPage;
    }

    public final int getCurrentPage() {
        return this.currentPage;
    }

    @NotNull
    public final String getFileKey() {
        return this.fileKey;
    }

    public final int getIndex() {
        return this.index;
    }

    public int hashCode() {
        return (((this.fileKey.hashCode() * 31) + Integer.hashCode(this.index)) * 31) + Integer.hashCode(this.currentPage);
    }

    @NotNull
    public String toString() {
        String str = this.fileKey;
        int i = this.index;
        int i2 = this.currentPage;
        return "HighlightMsgV3(fileKey=" + str + ", index=" + i + ", currentPage=" + i2 + ")";
    }
}
