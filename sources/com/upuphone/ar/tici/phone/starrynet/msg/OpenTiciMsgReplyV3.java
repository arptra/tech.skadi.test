package com.upuphone.ar.tici.phone.starrynet.msg;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.upuphone.ar.tici.phone.starrynet.BaseJsonMsg;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003JA\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\b\u0010\u001e\u001a\u00020\u0003H\u0016R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\t\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/upuphone/ar/tici/phone/starrynet/msg/OpenTiciMsgReplyV3;", "Lcom/upuphone/ar/tici/phone/starrynet/BaseJsonMsg;", "fileKey", "", "msgId", "paragraphIndexes", "", "", "currentPage", "highlightIndex", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;II)V", "getCurrentPage", "()I", "getFileKey", "()Ljava/lang/String;", "getHighlightIndex", "getMsgId", "getParagraphIndexes", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class OpenTiciMsgReplyV3 extends BaseJsonMsg {
    @SerializedName("currentPage")
    private final int currentPage;
    @SerializedName("fileKey")
    @NotNull
    private final String fileKey;
    @SerializedName("highlight_index")
    private final int highlightIndex;
    @SerializedName("msgId")
    @NotNull
    private final String msgId;
    @SerializedName("paragraphIndexes")
    @NotNull
    private final List<Integer> paragraphIndexes;

    public OpenTiciMsgReplyV3(@NotNull String str, @NotNull String str2, @NotNull List<Integer> list, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "fileKey");
        Intrinsics.checkNotNullParameter(str2, "msgId");
        Intrinsics.checkNotNullParameter(list, "paragraphIndexes");
        this.fileKey = str;
        this.msgId = str2;
        this.paragraphIndexes = list;
        this.currentPage = i;
        this.highlightIndex = i2;
    }

    public static /* synthetic */ OpenTiciMsgReplyV3 copy$default(OpenTiciMsgReplyV3 openTiciMsgReplyV3, String str, String str2, List<Integer> list, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = openTiciMsgReplyV3.fileKey;
        }
        if ((i3 & 2) != 0) {
            str2 = openTiciMsgReplyV3.msgId;
        }
        String str3 = str2;
        if ((i3 & 4) != 0) {
            list = openTiciMsgReplyV3.paragraphIndexes;
        }
        List<Integer> list2 = list;
        if ((i3 & 8) != 0) {
            i = openTiciMsgReplyV3.currentPage;
        }
        int i4 = i;
        if ((i3 & 16) != 0) {
            i2 = openTiciMsgReplyV3.highlightIndex;
        }
        return openTiciMsgReplyV3.copy(str, str3, list2, i4, i2);
    }

    @NotNull
    public final String component1() {
        return this.fileKey;
    }

    @NotNull
    public final String component2() {
        return this.msgId;
    }

    @NotNull
    public final List<Integer> component3() {
        return this.paragraphIndexes;
    }

    public final int component4() {
        return this.currentPage;
    }

    public final int component5() {
        return this.highlightIndex;
    }

    @NotNull
    public final OpenTiciMsgReplyV3 copy(@NotNull String str, @NotNull String str2, @NotNull List<Integer> list, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "fileKey");
        Intrinsics.checkNotNullParameter(str2, "msgId");
        Intrinsics.checkNotNullParameter(list, "paragraphIndexes");
        return new OpenTiciMsgReplyV3(str, str2, list, i, i2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OpenTiciMsgReplyV3)) {
            return false;
        }
        OpenTiciMsgReplyV3 openTiciMsgReplyV3 = (OpenTiciMsgReplyV3) obj;
        return Intrinsics.areEqual((Object) this.fileKey, (Object) openTiciMsgReplyV3.fileKey) && Intrinsics.areEqual((Object) this.msgId, (Object) openTiciMsgReplyV3.msgId) && Intrinsics.areEqual((Object) this.paragraphIndexes, (Object) openTiciMsgReplyV3.paragraphIndexes) && this.currentPage == openTiciMsgReplyV3.currentPage && this.highlightIndex == openTiciMsgReplyV3.highlightIndex;
    }

    public final int getCurrentPage() {
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
    public final String getMsgId() {
        return this.msgId;
    }

    @NotNull
    public final List<Integer> getParagraphIndexes() {
        return this.paragraphIndexes;
    }

    public int hashCode() {
        return (((((((this.fileKey.hashCode() * 31) + this.msgId.hashCode()) * 31) + this.paragraphIndexes.hashCode()) * 31) + Integer.hashCode(this.currentPage)) * 31) + Integer.hashCode(this.highlightIndex);
    }

    @NotNull
    public String toString() {
        String str = this.fileKey;
        String str2 = this.msgId;
        int i = this.currentPage;
        int i2 = this.highlightIndex;
        int size = this.paragraphIndexes.size();
        List<Integer> list = this.paragraphIndexes;
        return StringsKt.trimMargin$default("OpenTiciMsgReplyV3(\n                |   fileKey='" + str + "',\n                |   msgId='" + str2 + "',\n                |   currentPage=" + i + ",\n                |   highlightIndex=" + i2 + ",\n                |   paragraphIndexSize=" + size + ",\n                |   paragraphIndexes=" + list + ",\n                |) ", (String) null, 1, (Object) null);
    }
}
