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

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\b\u0010\u0018\u001a\u00020\u0003H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/upuphone/ar/tici/phone/starrynet/msg/OpenTiciMsgReply;", "Lcom/upuphone/ar/tici/phone/starrynet/BaseJsonMsg;", "fileKey", "", "msgId", "paragraphIndexes", "", "Lcom/upuphone/ar/tici/phone/starrynet/msg/ParagraphItem;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getFileKey", "()Ljava/lang/String;", "getMsgId", "getParagraphIndexes", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class OpenTiciMsgReply extends BaseJsonMsg {
    @SerializedName("fileKey")
    @NotNull
    private final String fileKey;
    @SerializedName("msgId")
    @NotNull
    private final String msgId;
    @SerializedName("paragraphIndexes")
    @NotNull
    private final List<ParagraphItem> paragraphIndexes;

    public OpenTiciMsgReply(@NotNull String str, @NotNull String str2, @NotNull List<ParagraphItem> list) {
        Intrinsics.checkNotNullParameter(str, "fileKey");
        Intrinsics.checkNotNullParameter(str2, "msgId");
        Intrinsics.checkNotNullParameter(list, "paragraphIndexes");
        this.fileKey = str;
        this.msgId = str2;
        this.paragraphIndexes = list;
    }

    public static /* synthetic */ OpenTiciMsgReply copy$default(OpenTiciMsgReply openTiciMsgReply, String str, String str2, List<ParagraphItem> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = openTiciMsgReply.fileKey;
        }
        if ((i & 2) != 0) {
            str2 = openTiciMsgReply.msgId;
        }
        if ((i & 4) != 0) {
            list = openTiciMsgReply.paragraphIndexes;
        }
        return openTiciMsgReply.copy(str, str2, list);
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
    public final List<ParagraphItem> component3() {
        return this.paragraphIndexes;
    }

    @NotNull
    public final OpenTiciMsgReply copy(@NotNull String str, @NotNull String str2, @NotNull List<ParagraphItem> list) {
        Intrinsics.checkNotNullParameter(str, "fileKey");
        Intrinsics.checkNotNullParameter(str2, "msgId");
        Intrinsics.checkNotNullParameter(list, "paragraphIndexes");
        return new OpenTiciMsgReply(str, str2, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OpenTiciMsgReply)) {
            return false;
        }
        OpenTiciMsgReply openTiciMsgReply = (OpenTiciMsgReply) obj;
        return Intrinsics.areEqual((Object) this.fileKey, (Object) openTiciMsgReply.fileKey) && Intrinsics.areEqual((Object) this.msgId, (Object) openTiciMsgReply.msgId) && Intrinsics.areEqual((Object) this.paragraphIndexes, (Object) openTiciMsgReply.paragraphIndexes);
    }

    @NotNull
    public final String getFileKey() {
        return this.fileKey;
    }

    @NotNull
    public final String getMsgId() {
        return this.msgId;
    }

    @NotNull
    public final List<ParagraphItem> getParagraphIndexes() {
        return this.paragraphIndexes;
    }

    public int hashCode() {
        return (((this.fileKey.hashCode() * 31) + this.msgId.hashCode()) * 31) + this.paragraphIndexes.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.fileKey;
        String str2 = this.msgId;
        int size = this.paragraphIndexes.size();
        List<ParagraphItem> list = this.paragraphIndexes;
        return StringsKt.trimMargin$default("OpenTiciMsgReply(\n                |   fileKey='" + str + "',\n                |   msgId='" + str2 + "',\n                |   paragraphIndexSize=" + size + ",\n                |   paragraphIndexes=" + list + ",\n                |) ", (String) null, 1, (Object) null);
    }
}
