package com.upuphone.ar.tici.phone.starrynet.msg;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.upuphone.ar.tici.phone.starrynet.BaseJsonMsg;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b7\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0002\u0010\u0014J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010!J\t\u00103\u001a\u00020\u0006HÆ\u0003J\t\u00104\u001a\u00020\u0006HÆ\u0003J\t\u00105\u001a\u00020\u0006HÆ\u0003J\t\u00106\u001a\u00020\u0006HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0006HÆ\u0003J\t\u00109\u001a\u00020\u0006HÆ\u0003J\t\u0010:\u001a\u00020\tHÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010<\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010!J\t\u0010=\u001a\u00020\u0006HÆ\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010!J¢\u0001\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010@J\u0013\u0010A\u001a\u00020\u000b2\b\u0010B\u001a\u0004\u0018\u00010CHÖ\u0003J\t\u0010D\u001a\u00020\u0006HÖ\u0001J\b\u0010E\u001a\u00020\u0003H\u0016R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0010\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u0013\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010\u0012\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u001e\u0010#\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010&R\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b+\u0010!R\u001e\u0010,\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0019\"\u0004\b.\u0010&R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b/\u0010!R\u0016\u0010\r\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0019¨\u0006F"}, d2 = {"Lcom/upuphone/ar/tici/phone/starrynet/msg/OpenTiciMsg;", "Lcom/upuphone/ar/tici/phone/starrynet/BaseJsonMsg;", "fileKey", "", "msgId", "paragraphIndex", "", "ticiMode", "ticiSpeed", "", "blockNotification", "", "screenLocation", "version", "totalPage", "totalTextLength", "currentPage", "sourceTextOffset", "prevTotalParagraphSize", "nextTotalParagraphSize", "(Ljava/lang/String;Ljava/lang/String;IIJLjava/lang/Boolean;Ljava/lang/Integer;ILjava/lang/Integer;Ljava/lang/Integer;IIII)V", "getBlockNotification", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCurrentPage", "()I", "getFileKey", "()Ljava/lang/String;", "getMsgId", "getNextTotalParagraphSize", "getParagraphIndex", "getPrevTotalParagraphSize", "getScreenLocation", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "sourceByteSize", "getSourceByteSize", "setSourceByteSize", "(I)V", "getSourceTextOffset", "getTiciMode", "getTiciSpeed", "()J", "getTotalPage", "totalPart", "getTotalPart", "setTotalPart", "getTotalTextLength", "getVersion", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;IIJLjava/lang/Boolean;Ljava/lang/Integer;ILjava/lang/Integer;Ljava/lang/Integer;IIII)Lcom/upuphone/ar/tici/phone/starrynet/msg/OpenTiciMsg;", "equals", "other", "", "hashCode", "toString", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class OpenTiciMsg extends BaseJsonMsg {
    @SerializedName("blockNotification")
    @Nullable
    private final Boolean blockNotification;
    private final int currentPage;
    @SerializedName("fileKey")
    @NotNull
    private final String fileKey;
    @SerializedName("msgId")
    @NotNull
    private final String msgId;
    private final int nextTotalParagraphSize;
    @SerializedName("paragraphIndex")
    private final int paragraphIndex;
    private final int prevTotalParagraphSize;
    @SerializedName("screenLocation")
    @Nullable
    private final Integer screenLocation;
    @SerializedName("sourceByteSize")
    private int sourceByteSize;
    private final int sourceTextOffset;
    @SerializedName("ticiMode")
    private final int ticiMode;
    @SerializedName("ticiSpeed")
    private final long ticiSpeed;
    @SerializedName("totalPage")
    @Nullable
    private final Integer totalPage;
    @SerializedName("totalPart")
    private int totalPart;
    @SerializedName("totalTextLength")
    @Nullable
    private final Integer totalTextLength;
    @SerializedName("version")
    private final int version;

    public OpenTiciMsg(@NotNull String str, @NotNull String str2, int i, int i2, long j, @Nullable Boolean bool, @Nullable Integer num, int i3, @Nullable Integer num2, @Nullable Integer num3, int i4, int i5, int i6, int i7) {
        Intrinsics.checkNotNullParameter(str, "fileKey");
        Intrinsics.checkNotNullParameter(str2, "msgId");
        this.fileKey = str;
        this.msgId = str2;
        this.paragraphIndex = i;
        this.ticiMode = i2;
        this.ticiSpeed = j;
        this.blockNotification = bool;
        this.screenLocation = num;
        this.version = i3;
        this.totalPage = num2;
        this.totalTextLength = num3;
        this.currentPage = i4;
        this.sourceTextOffset = i5;
        this.prevTotalParagraphSize = i6;
        this.nextTotalParagraphSize = i7;
    }

    public static /* synthetic */ OpenTiciMsg copy$default(OpenTiciMsg openTiciMsg, String str, String str2, int i, int i2, long j, Boolean bool, Integer num, int i3, Integer num2, Integer num3, int i4, int i5, int i6, int i7, int i8, Object obj) {
        OpenTiciMsg openTiciMsg2 = openTiciMsg;
        int i9 = i8;
        return openTiciMsg.copy((i9 & 1) != 0 ? openTiciMsg2.fileKey : str, (i9 & 2) != 0 ? openTiciMsg2.msgId : str2, (i9 & 4) != 0 ? openTiciMsg2.paragraphIndex : i, (i9 & 8) != 0 ? openTiciMsg2.ticiMode : i2, (i9 & 16) != 0 ? openTiciMsg2.ticiSpeed : j, (i9 & 32) != 0 ? openTiciMsg2.blockNotification : bool, (i9 & 64) != 0 ? openTiciMsg2.screenLocation : num, (i9 & 128) != 0 ? openTiciMsg2.version : i3, (i9 & 256) != 0 ? openTiciMsg2.totalPage : num2, (i9 & 512) != 0 ? openTiciMsg2.totalTextLength : num3, (i9 & 1024) != 0 ? openTiciMsg2.currentPage : i4, (i9 & 2048) != 0 ? openTiciMsg2.sourceTextOffset : i5, (i9 & 4096) != 0 ? openTiciMsg2.prevTotalParagraphSize : i6, (i9 & 8192) != 0 ? openTiciMsg2.nextTotalParagraphSize : i7);
    }

    @NotNull
    public final String component1() {
        return this.fileKey;
    }

    @Nullable
    public final Integer component10() {
        return this.totalTextLength;
    }

    public final int component11() {
        return this.currentPage;
    }

    public final int component12() {
        return this.sourceTextOffset;
    }

    public final int component13() {
        return this.prevTotalParagraphSize;
    }

    public final int component14() {
        return this.nextTotalParagraphSize;
    }

    @NotNull
    public final String component2() {
        return this.msgId;
    }

    public final int component3() {
        return this.paragraphIndex;
    }

    public final int component4() {
        return this.ticiMode;
    }

    public final long component5() {
        return this.ticiSpeed;
    }

    @Nullable
    public final Boolean component6() {
        return this.blockNotification;
    }

    @Nullable
    public final Integer component7() {
        return this.screenLocation;
    }

    public final int component8() {
        return this.version;
    }

    @Nullable
    public final Integer component9() {
        return this.totalPage;
    }

    @NotNull
    public final OpenTiciMsg copy(@NotNull String str, @NotNull String str2, int i, int i2, long j, @Nullable Boolean bool, @Nullable Integer num, int i3, @Nullable Integer num2, @Nullable Integer num3, int i4, int i5, int i6, int i7) {
        String str3 = str;
        Intrinsics.checkNotNullParameter(str3, "fileKey");
        String str4 = str2;
        Intrinsics.checkNotNullParameter(str4, "msgId");
        return new OpenTiciMsg(str3, str4, i, i2, j, bool, num, i3, num2, num3, i4, i5, i6, i7);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OpenTiciMsg)) {
            return false;
        }
        OpenTiciMsg openTiciMsg = (OpenTiciMsg) obj;
        return Intrinsics.areEqual((Object) this.fileKey, (Object) openTiciMsg.fileKey) && Intrinsics.areEqual((Object) this.msgId, (Object) openTiciMsg.msgId) && this.paragraphIndex == openTiciMsg.paragraphIndex && this.ticiMode == openTiciMsg.ticiMode && this.ticiSpeed == openTiciMsg.ticiSpeed && Intrinsics.areEqual((Object) this.blockNotification, (Object) openTiciMsg.blockNotification) && Intrinsics.areEqual((Object) this.screenLocation, (Object) openTiciMsg.screenLocation) && this.version == openTiciMsg.version && Intrinsics.areEqual((Object) this.totalPage, (Object) openTiciMsg.totalPage) && Intrinsics.areEqual((Object) this.totalTextLength, (Object) openTiciMsg.totalTextLength) && this.currentPage == openTiciMsg.currentPage && this.sourceTextOffset == openTiciMsg.sourceTextOffset && this.prevTotalParagraphSize == openTiciMsg.prevTotalParagraphSize && this.nextTotalParagraphSize == openTiciMsg.nextTotalParagraphSize;
    }

    @Nullable
    public final Boolean getBlockNotification() {
        return this.blockNotification;
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

    public final int getNextTotalParagraphSize() {
        return this.nextTotalParagraphSize;
    }

    public final int getParagraphIndex() {
        return this.paragraphIndex;
    }

    public final int getPrevTotalParagraphSize() {
        return this.prevTotalParagraphSize;
    }

    @Nullable
    public final Integer getScreenLocation() {
        return this.screenLocation;
    }

    public final int getSourceByteSize() {
        return this.sourceByteSize;
    }

    public final int getSourceTextOffset() {
        return this.sourceTextOffset;
    }

    public final int getTiciMode() {
        return this.ticiMode;
    }

    public final long getTiciSpeed() {
        return this.ticiSpeed;
    }

    @Nullable
    public final Integer getTotalPage() {
        return this.totalPage;
    }

    public final int getTotalPart() {
        return this.totalPart;
    }

    @Nullable
    public final Integer getTotalTextLength() {
        return this.totalTextLength;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        int hashCode = ((((((((this.fileKey.hashCode() * 31) + this.msgId.hashCode()) * 31) + Integer.hashCode(this.paragraphIndex)) * 31) + Integer.hashCode(this.ticiMode)) * 31) + Long.hashCode(this.ticiSpeed)) * 31;
        Boolean bool = this.blockNotification;
        int i = 0;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num = this.screenLocation;
        int hashCode3 = (((hashCode2 + (num == null ? 0 : num.hashCode())) * 31) + Integer.hashCode(this.version)) * 31;
        Integer num2 = this.totalPage;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.totalTextLength;
        if (num3 != null) {
            i = num3.hashCode();
        }
        return ((((((((hashCode4 + i) * 31) + Integer.hashCode(this.currentPage)) * 31) + Integer.hashCode(this.sourceTextOffset)) * 31) + Integer.hashCode(this.prevTotalParagraphSize)) * 31) + Integer.hashCode(this.nextTotalParagraphSize);
    }

    public final void setSourceByteSize(int i) {
        this.sourceByteSize = i;
    }

    public final void setTotalPart(int i) {
        this.totalPart = i;
    }

    @NotNull
    public String toString() {
        return toJsonString();
    }
}
