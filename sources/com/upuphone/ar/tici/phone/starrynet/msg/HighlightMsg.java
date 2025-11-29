package com.upuphone.ar.tici.phone.starrynet.msg;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.upuphone.ar.tici.phone.starrynet.BaseJsonMsg;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/upuphone/ar/tici/phone/starrynet/msg/HighlightMsg;", "Lcom/upuphone/ar/tici/phone/starrynet/BaseJsonMsg;", "index", "", "fileKey", "", "(ILjava/lang/String;)V", "getFileKey", "()Ljava/lang/String;", "getIndex", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class HighlightMsg extends BaseJsonMsg {
    @SerializedName("fileKey")
    @Nullable
    private final String fileKey;
    @SerializedName("index")
    private final int index;

    public HighlightMsg(int i, @Nullable String str) {
        this.index = i;
        this.fileKey = str;
    }

    public static /* synthetic */ HighlightMsg copy$default(HighlightMsg highlightMsg, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = highlightMsg.index;
        }
        if ((i2 & 2) != 0) {
            str = highlightMsg.fileKey;
        }
        return highlightMsg.copy(i, str);
    }

    public final int component1() {
        return this.index;
    }

    @Nullable
    public final String component2() {
        return this.fileKey;
    }

    @NotNull
    public final HighlightMsg copy(int i, @Nullable String str) {
        return new HighlightMsg(i, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HighlightMsg)) {
            return false;
        }
        HighlightMsg highlightMsg = (HighlightMsg) obj;
        return this.index == highlightMsg.index && Intrinsics.areEqual((Object) this.fileKey, (Object) highlightMsg.fileKey);
    }

    @Nullable
    public final String getFileKey() {
        return this.fileKey;
    }

    public final int getIndex() {
        return this.index;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.index) * 31;
        String str = this.fileKey;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        int i = this.index;
        String str = this.fileKey;
        return "HighlightMsg(index=" + i + ", fileKey=" + str + ")";
    }
}
