package com.upuphone.ar.tici.phone.starrynet.msg;

import androidx.annotation.Keep;
import com.upuphone.ar.tici.phone.starrynet.BaseJsonMsg;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0006HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006#"}, d2 = {"Lcom/upuphone/ar/tici/phone/starrynet/msg/SendTiciContentPageMsg;", "Lcom/upuphone/ar/tici/phone/starrynet/BaseJsonMsg;", "msgId", "", "fileKey", "sourceByteSize", "", "totalPart", "paragraphIndex", "currentPage", "sourceTextOffset", "(Ljava/lang/String;Ljava/lang/String;IIIII)V", "getCurrentPage", "()I", "getFileKey", "()Ljava/lang/String;", "getMsgId", "getParagraphIndex", "getSourceByteSize", "getSourceTextOffset", "getTotalPart", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "toString", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class SendTiciContentPageMsg extends BaseJsonMsg {
    private final int currentPage;
    @NotNull
    private final String fileKey;
    @NotNull
    private final String msgId;
    private final int paragraphIndex;
    private final int sourceByteSize;
    private final int sourceTextOffset;
    private final int totalPart;

    public SendTiciContentPageMsg(@NotNull String str, @NotNull String str2, int i, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(str, "msgId");
        Intrinsics.checkNotNullParameter(str2, "fileKey");
        this.msgId = str;
        this.fileKey = str2;
        this.sourceByteSize = i;
        this.totalPart = i2;
        this.paragraphIndex = i3;
        this.currentPage = i4;
        this.sourceTextOffset = i5;
    }

    public static /* synthetic */ SendTiciContentPageMsg copy$default(SendTiciContentPageMsg sendTiciContentPageMsg, String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = sendTiciContentPageMsg.msgId;
        }
        if ((i6 & 2) != 0) {
            str2 = sendTiciContentPageMsg.fileKey;
        }
        String str3 = str2;
        if ((i6 & 4) != 0) {
            i = sendTiciContentPageMsg.sourceByteSize;
        }
        int i7 = i;
        if ((i6 & 8) != 0) {
            i2 = sendTiciContentPageMsg.totalPart;
        }
        int i8 = i2;
        if ((i6 & 16) != 0) {
            i3 = sendTiciContentPageMsg.paragraphIndex;
        }
        int i9 = i3;
        if ((i6 & 32) != 0) {
            i4 = sendTiciContentPageMsg.currentPage;
        }
        int i10 = i4;
        if ((i6 & 64) != 0) {
            i5 = sendTiciContentPageMsg.sourceTextOffset;
        }
        return sendTiciContentPageMsg.copy(str, str3, i7, i8, i9, i10, i5);
    }

    @NotNull
    public final String component1() {
        return this.msgId;
    }

    @NotNull
    public final String component2() {
        return this.fileKey;
    }

    public final int component3() {
        return this.sourceByteSize;
    }

    public final int component4() {
        return this.totalPart;
    }

    public final int component5() {
        return this.paragraphIndex;
    }

    public final int component6() {
        return this.currentPage;
    }

    public final int component7() {
        return this.sourceTextOffset;
    }

    @NotNull
    public final SendTiciContentPageMsg copy(@NotNull String str, @NotNull String str2, int i, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(str, "msgId");
        Intrinsics.checkNotNullParameter(str2, "fileKey");
        return new SendTiciContentPageMsg(str, str2, i, i2, i3, i4, i5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SendTiciContentPageMsg)) {
            return false;
        }
        SendTiciContentPageMsg sendTiciContentPageMsg = (SendTiciContentPageMsg) obj;
        return Intrinsics.areEqual((Object) this.msgId, (Object) sendTiciContentPageMsg.msgId) && Intrinsics.areEqual((Object) this.fileKey, (Object) sendTiciContentPageMsg.fileKey) && this.sourceByteSize == sendTiciContentPageMsg.sourceByteSize && this.totalPart == sendTiciContentPageMsg.totalPart && this.paragraphIndex == sendTiciContentPageMsg.paragraphIndex && this.currentPage == sendTiciContentPageMsg.currentPage && this.sourceTextOffset == sendTiciContentPageMsg.sourceTextOffset;
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

    public final int getParagraphIndex() {
        return this.paragraphIndex;
    }

    public final int getSourceByteSize() {
        return this.sourceByteSize;
    }

    public final int getSourceTextOffset() {
        return this.sourceTextOffset;
    }

    public final int getTotalPart() {
        return this.totalPart;
    }

    public int hashCode() {
        return (((((((((((this.msgId.hashCode() * 31) + this.fileKey.hashCode()) * 31) + Integer.hashCode(this.sourceByteSize)) * 31) + Integer.hashCode(this.totalPart)) * 31) + Integer.hashCode(this.paragraphIndex)) * 31) + Integer.hashCode(this.currentPage)) * 31) + Integer.hashCode(this.sourceTextOffset);
    }

    @NotNull
    public String toString() {
        String str = this.msgId;
        String str2 = this.fileKey;
        int i = this.sourceByteSize;
        int i2 = this.totalPart;
        int i3 = this.paragraphIndex;
        int i4 = this.currentPage;
        int i5 = this.sourceTextOffset;
        return "SendTiciContentPageMsg(msgId=" + str + ", fileKey=" + str2 + ", sourceByteSize=" + i + ", totalPart=" + i2 + ", paragraphIndex=" + i3 + ", currentPage=" + i4 + ", sourceTextOffset=" + i5 + ")";
    }
}
