package com.upuphone.ar.tici.phone.starrynet.msg;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.upuphone.ar.tici.phone.starrynet.BaseJsonMsg;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/upuphone/ar/tici/phone/starrynet/msg/SendContentPageRequest;", "Lcom/upuphone/ar/tici/phone/starrynet/BaseJsonMsg;", "fileKey", "", "targetPage", "", "(Ljava/lang/String;I)V", "getFileKey", "()Ljava/lang/String;", "getTargetPage", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class SendContentPageRequest extends BaseJsonMsg {
    @SerializedName("fileKey")
    @NotNull
    private final String fileKey;
    @SerializedName("targetPage")
    private final int targetPage;

    public SendContentPageRequest(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "fileKey");
        this.fileKey = str;
        this.targetPage = i;
    }

    public static /* synthetic */ SendContentPageRequest copy$default(SendContentPageRequest sendContentPageRequest, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = sendContentPageRequest.fileKey;
        }
        if ((i2 & 2) != 0) {
            i = sendContentPageRequest.targetPage;
        }
        return sendContentPageRequest.copy(str, i);
    }

    @NotNull
    public final String component1() {
        return this.fileKey;
    }

    public final int component2() {
        return this.targetPage;
    }

    @NotNull
    public final SendContentPageRequest copy(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "fileKey");
        return new SendContentPageRequest(str, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SendContentPageRequest)) {
            return false;
        }
        SendContentPageRequest sendContentPageRequest = (SendContentPageRequest) obj;
        return Intrinsics.areEqual((Object) this.fileKey, (Object) sendContentPageRequest.fileKey) && this.targetPage == sendContentPageRequest.targetPage;
    }

    @NotNull
    public final String getFileKey() {
        return this.fileKey;
    }

    public final int getTargetPage() {
        return this.targetPage;
    }

    public int hashCode() {
        return (this.fileKey.hashCode() * 31) + Integer.hashCode(this.targetPage);
    }

    @NotNull
    public String toString() {
        String str = this.fileKey;
        int i = this.targetPage;
        return "SendContentPageRequest(fileKey=" + str + ", targetPage=" + i + ")";
    }
}
