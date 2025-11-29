package com.upuphone.ar.tici.phone.starrynet.msg;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.upuphone.ar.tici.phone.starrynet.BaseJsonMsg;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000bJ>\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/upuphone/ar/tici/phone/starrynet/msg/SyncParagraphInfo;", "Lcom/upuphone/ar/tici/phone/starrynet/BaseJsonMsg;", "fileKey", "", "paragraphIndexes", "", "", "highlightIndex", "currentPage", "(Ljava/lang/String;Ljava/util/List;ILjava/lang/Integer;)V", "getCurrentPage", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFileKey", "()Ljava/lang/String;", "getHighlightIndex", "()I", "getParagraphIndexes", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/util/List;ILjava/lang/Integer;)Lcom/upuphone/ar/tici/phone/starrynet/msg/SyncParagraphInfo;", "equals", "", "other", "", "hashCode", "toString", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class SyncParagraphInfo extends BaseJsonMsg {
    @SerializedName("currentPage")
    @Nullable
    private final Integer currentPage;
    @SerializedName("fileKey")
    @NotNull
    private final String fileKey;
    @SerializedName("highlight_index")
    private final int highlightIndex;
    @SerializedName("paragraphIndexes")
    @NotNull
    private final List<Integer> paragraphIndexes;

    public SyncParagraphInfo(@NotNull String str, @NotNull List<Integer> list, int i, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, "fileKey");
        Intrinsics.checkNotNullParameter(list, "paragraphIndexes");
        this.fileKey = str;
        this.paragraphIndexes = list;
        this.highlightIndex = i;
        this.currentPage = num;
    }

    public static /* synthetic */ SyncParagraphInfo copy$default(SyncParagraphInfo syncParagraphInfo, String str, List<Integer> list, int i, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = syncParagraphInfo.fileKey;
        }
        if ((i2 & 2) != 0) {
            list = syncParagraphInfo.paragraphIndexes;
        }
        if ((i2 & 4) != 0) {
            i = syncParagraphInfo.highlightIndex;
        }
        if ((i2 & 8) != 0) {
            num = syncParagraphInfo.currentPage;
        }
        return syncParagraphInfo.copy(str, list, i, num);
    }

    @NotNull
    public final String component1() {
        return this.fileKey;
    }

    @NotNull
    public final List<Integer> component2() {
        return this.paragraphIndexes;
    }

    public final int component3() {
        return this.highlightIndex;
    }

    @Nullable
    public final Integer component4() {
        return this.currentPage;
    }

    @NotNull
    public final SyncParagraphInfo copy(@NotNull String str, @NotNull List<Integer> list, int i, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, "fileKey");
        Intrinsics.checkNotNullParameter(list, "paragraphIndexes");
        return new SyncParagraphInfo(str, list, i, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SyncParagraphInfo)) {
            return false;
        }
        SyncParagraphInfo syncParagraphInfo = (SyncParagraphInfo) obj;
        return Intrinsics.areEqual((Object) this.fileKey, (Object) syncParagraphInfo.fileKey) && Intrinsics.areEqual((Object) this.paragraphIndexes, (Object) syncParagraphInfo.paragraphIndexes) && this.highlightIndex == syncParagraphInfo.highlightIndex && Intrinsics.areEqual((Object) this.currentPage, (Object) syncParagraphInfo.currentPage);
    }

    @Nullable
    public final Integer getCurrentPage() {
        return this.currentPage;
    }

    @NotNull
    public final String getFileKey() {
        return this.fileKey;
    }

    public final int getHighlightIndex() {
        return this.highlightIndex;
    }

    @NotNull
    public final List<Integer> getParagraphIndexes() {
        return this.paragraphIndexes;
    }

    public int hashCode() {
        int hashCode = ((((this.fileKey.hashCode() * 31) + this.paragraphIndexes.hashCode()) * 31) + Integer.hashCode(this.highlightIndex)) * 31;
        Integer num = this.currentPage;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    @NotNull
    public String toString() {
        String str = this.fileKey;
        List<Integer> list = this.paragraphIndexes;
        int i = this.highlightIndex;
        Integer num = this.currentPage;
        return "SyncParagraphInfo(fileKey=" + str + ", paragraphIndexes=" + list + ", highlightIndex=" + i + ", currentPage=" + num + ")";
    }
}
