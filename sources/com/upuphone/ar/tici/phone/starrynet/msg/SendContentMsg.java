package com.upuphone.ar.tici.phone.starrynet.msg;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.upuphone.ar.tici.phone.starrynet.BaseJsonMsg;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/upuphone/ar/tici/phone/starrynet/msg/SendContentMsg;", "Lcom/upuphone/ar/tici/phone/starrynet/BaseJsonMsg;", "msgId", "", "fileKey", "sourceText", "part", "", "currentPage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getCurrentPage", "()I", "getFileKey", "()Ljava/lang/String;", "getMsgId", "getPart", "getSourceText", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class SendContentMsg extends BaseJsonMsg {
    @SerializedName("currentPage")
    private final int currentPage;
    @SerializedName("fileKey")
    @NotNull
    private final String fileKey;
    @SerializedName("msgId")
    @NotNull
    private final String msgId;
    @SerializedName("part")
    private final int part;
    @SerializedName("sourceText")
    @NotNull
    private final String sourceText;

    public SendContentMsg(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "msgId");
        Intrinsics.checkNotNullParameter(str2, "fileKey");
        Intrinsics.checkNotNullParameter(str3, "sourceText");
        this.msgId = str;
        this.fileKey = str2;
        this.sourceText = str3;
        this.part = i;
        this.currentPage = i2;
    }

    public static /* synthetic */ SendContentMsg copy$default(SendContentMsg sendContentMsg, String str, String str2, String str3, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = sendContentMsg.msgId;
        }
        if ((i3 & 2) != 0) {
            str2 = sendContentMsg.fileKey;
        }
        String str4 = str2;
        if ((i3 & 4) != 0) {
            str3 = sendContentMsg.sourceText;
        }
        String str5 = str3;
        if ((i3 & 8) != 0) {
            i = sendContentMsg.part;
        }
        int i4 = i;
        if ((i3 & 16) != 0) {
            i2 = sendContentMsg.currentPage;
        }
        return sendContentMsg.copy(str, str4, str5, i4, i2);
    }

    @NotNull
    public final String component1() {
        return this.msgId;
    }

    @NotNull
    public final String component2() {
        return this.fileKey;
    }

    @NotNull
    public final String component3() {
        return this.sourceText;
    }

    public final int component4() {
        return this.part;
    }

    public final int component5() {
        return this.currentPage;
    }

    @NotNull
    public final SendContentMsg copy(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "msgId");
        Intrinsics.checkNotNullParameter(str2, "fileKey");
        Intrinsics.checkNotNullParameter(str3, "sourceText");
        return new SendContentMsg(str, str2, str3, i, i2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SendContentMsg)) {
            return false;
        }
        SendContentMsg sendContentMsg = (SendContentMsg) obj;
        return Intrinsics.areEqual((Object) this.msgId, (Object) sendContentMsg.msgId) && Intrinsics.areEqual((Object) this.fileKey, (Object) sendContentMsg.fileKey) && Intrinsics.areEqual((Object) this.sourceText, (Object) sendContentMsg.sourceText) && this.part == sendContentMsg.part && this.currentPage == sendContentMsg.currentPage;
    }

    public final int getCurrentPage() {
        return this.currentPage;
    }

    @NotNull
    public final String getFileKey() {
        return this.fileKey;
    }

    @NotNull
    public final String getMsgId() {
        return this.msgId;
    }

    public final int getPart() {
        return this.part;
    }

    @NotNull
    public final String getSourceText() {
        return this.sourceText;
    }

    public int hashCode() {
        return (((((((this.msgId.hashCode() * 31) + this.fileKey.hashCode()) * 31) + this.sourceText.hashCode()) * 31) + Integer.hashCode(this.part)) * 31) + Integer.hashCode(this.currentPage);
    }

    @NotNull
    public String toString() {
        String str = this.msgId;
        String str2 = this.fileKey;
        String str3 = this.sourceText;
        int i = this.part;
        int i2 = this.currentPage;
        return "SendContentMsg(msgId=" + str + ", fileKey=" + str2 + ", sourceText=" + str3 + ", part=" + i + ", currentPage=" + i2 + ")";
    }
}
