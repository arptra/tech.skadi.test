package com.upuphone.ar.tici.phone.starrynet.msg;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.upuphone.ar.tici.phone.starrynet.BaseJsonMsg;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\bHÖ\u0001J\b\u0010\u0018\u001a\u00020\u0003H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\"\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/upuphone/ar/tici/phone/starrynet/msg/OpenTiciMsgReplyV2;", "Lcom/upuphone/ar/tici/phone/starrynet/BaseJsonMsg;", "fileKey", "", "msgId", "paragraphIndexes", "", "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getFileKey", "()Ljava/lang/String;", "getMsgId", "getParagraphIndexes", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class OpenTiciMsgReplyV2 extends BaseJsonMsg {
    @SerializedName("fileKey")
    @NotNull
    private final String fileKey;
    @SerializedName("msgId")
    @NotNull
    private final String msgId;
    @SerializedName("paragraphIndexes")
    @NotNull
    private final List<Integer[]> paragraphIndexes;

    public OpenTiciMsgReplyV2(@NotNull String str, @NotNull String str2, @NotNull List<Integer[]> list) {
        Intrinsics.checkNotNullParameter(str, "fileKey");
        Intrinsics.checkNotNullParameter(str2, "msgId");
        Intrinsics.checkNotNullParameter(list, "paragraphIndexes");
        this.fileKey = str;
        this.msgId = str2;
        this.paragraphIndexes = list;
    }

    public static /* synthetic */ OpenTiciMsgReplyV2 copy$default(OpenTiciMsgReplyV2 openTiciMsgReplyV2, String str, String str2, List<Integer[]> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = openTiciMsgReplyV2.fileKey;
        }
        if ((i & 2) != 0) {
            str2 = openTiciMsgReplyV2.msgId;
        }
        if ((i & 4) != 0) {
            list = openTiciMsgReplyV2.paragraphIndexes;
        }
        return openTiciMsgReplyV2.copy(str, str2, list);
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
    public final List<Integer[]> component3() {
        return this.paragraphIndexes;
    }

    @NotNull
    public final OpenTiciMsgReplyV2 copy(@NotNull String str, @NotNull String str2, @NotNull List<Integer[]> list) {
        Intrinsics.checkNotNullParameter(str, "fileKey");
        Intrinsics.checkNotNullParameter(str2, "msgId");
        Intrinsics.checkNotNullParameter(list, "paragraphIndexes");
        return new OpenTiciMsgReplyV2(str, str2, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OpenTiciMsgReplyV2)) {
            return false;
        }
        OpenTiciMsgReplyV2 openTiciMsgReplyV2 = (OpenTiciMsgReplyV2) obj;
        return Intrinsics.areEqual((Object) this.fileKey, (Object) openTiciMsgReplyV2.fileKey) && Intrinsics.areEqual((Object) this.msgId, (Object) openTiciMsgReplyV2.msgId) && Intrinsics.areEqual((Object) this.paragraphIndexes, (Object) openTiciMsgReplyV2.paragraphIndexes);
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
    public final List<Integer[]> getParagraphIndexes() {
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
        String joinToString$default = CollectionsKt.joinToString$default(this.paragraphIndexes, (CharSequence) null, "[", "]", 0, (CharSequence) null, OpenTiciMsgReplyV2$toString$1.INSTANCE, 25, (Object) null);
        return StringsKt.trimMargin$default("OpenTiciMsgReplyV2(\n                |   fileKey='" + str + "',\n                |   msgId='" + str2 + "',\n                |   paragraphIndexSize=" + size + ",\n                |   paragraphIndexes=" + joinToString$default + ",\n                |) ", (String) null, 1, (Object) null);
    }
}
