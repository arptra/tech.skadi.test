package com.upuphone.ar.tici.phone.starrynet.msg;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.upuphone.ar.tici.phone.starrynet.BaseJsonMsg;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011JZ\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0007HÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0015R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0015R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0018\u0010\u0011¨\u0006'"}, d2 = {"Lcom/upuphone/ar/tici/phone/starrynet/msg/CheckTiciStateReply;", "Lcom/upuphone/ar/tici/phone/starrynet/BaseJsonMsg;", "isRunning", "", "fileKey", "", "paragraphIndex", "", "isAutoTiciPlaying", "autoTiciProgress", "", "version", "currentPage", "(ZLjava/lang/String;IZFLjava/lang/Integer;Ljava/lang/Integer;)V", "getAutoTiciProgress", "()F", "getCurrentPage", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFileKey", "()Ljava/lang/String;", "()Z", "getParagraphIndex", "()I", "getVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(ZLjava/lang/String;IZFLjava/lang/Integer;Ljava/lang/Integer;)Lcom/upuphone/ar/tici/phone/starrynet/msg/CheckTiciStateReply;", "equals", "other", "", "hashCode", "toString", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class CheckTiciStateReply extends BaseJsonMsg {
    @SerializedName("autoTiciProgress")
    private final float autoTiciProgress;
    @Nullable
    private final Integer currentPage;
    @SerializedName("fileKey")
    @Nullable
    private final String fileKey;
    @SerializedName("isAutoTiciPlaying")
    private final boolean isAutoTiciPlaying;
    @SerializedName("isRunning")
    private final boolean isRunning;
    @SerializedName("paragraphIndex")
    private final int paragraphIndex;
    @Nullable
    private final Integer version;

    public CheckTiciStateReply(boolean z, @Nullable String str, int i, boolean z2, float f, @Nullable Integer num, @Nullable Integer num2) {
        this.isRunning = z;
        this.fileKey = str;
        this.paragraphIndex = i;
        this.isAutoTiciPlaying = z2;
        this.autoTiciProgress = f;
        this.version = num;
        this.currentPage = num2;
    }

    public static /* synthetic */ CheckTiciStateReply copy$default(CheckTiciStateReply checkTiciStateReply, boolean z, String str, int i, boolean z2, float f, Integer num, Integer num2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = checkTiciStateReply.isRunning;
        }
        if ((i2 & 2) != 0) {
            str = checkTiciStateReply.fileKey;
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            i = checkTiciStateReply.paragraphIndex;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            z2 = checkTiciStateReply.isAutoTiciPlaying;
        }
        boolean z3 = z2;
        if ((i2 & 16) != 0) {
            f = checkTiciStateReply.autoTiciProgress;
        }
        float f2 = f;
        if ((i2 & 32) != 0) {
            num = checkTiciStateReply.version;
        }
        Integer num3 = num;
        if ((i2 & 64) != 0) {
            num2 = checkTiciStateReply.currentPage;
        }
        return checkTiciStateReply.copy(z, str2, i3, z3, f2, num3, num2);
    }

    public final boolean component1() {
        return this.isRunning;
    }

    @Nullable
    public final String component2() {
        return this.fileKey;
    }

    public final int component3() {
        return this.paragraphIndex;
    }

    public final boolean component4() {
        return this.isAutoTiciPlaying;
    }

    public final float component5() {
        return this.autoTiciProgress;
    }

    @Nullable
    public final Integer component6() {
        return this.version;
    }

    @Nullable
    public final Integer component7() {
        return this.currentPage;
    }

    @NotNull
    public final CheckTiciStateReply copy(boolean z, @Nullable String str, int i, boolean z2, float f, @Nullable Integer num, @Nullable Integer num2) {
        return new CheckTiciStateReply(z, str, i, z2, f, num, num2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CheckTiciStateReply)) {
            return false;
        }
        CheckTiciStateReply checkTiciStateReply = (CheckTiciStateReply) obj;
        return this.isRunning == checkTiciStateReply.isRunning && Intrinsics.areEqual((Object) this.fileKey, (Object) checkTiciStateReply.fileKey) && this.paragraphIndex == checkTiciStateReply.paragraphIndex && this.isAutoTiciPlaying == checkTiciStateReply.isAutoTiciPlaying && Float.compare(this.autoTiciProgress, checkTiciStateReply.autoTiciProgress) == 0 && Intrinsics.areEqual((Object) this.version, (Object) checkTiciStateReply.version) && Intrinsics.areEqual((Object) this.currentPage, (Object) checkTiciStateReply.currentPage);
    }

    public final float getAutoTiciProgress() {
        return this.autoTiciProgress;
    }

    @Nullable
    public final Integer getCurrentPage() {
        return this.currentPage;
    }

    @Nullable
    public final String getFileKey() {
        return this.fileKey;
    }

    public final int getParagraphIndex() {
        return this.paragraphIndex;
    }

    @Nullable
    public final Integer getVersion() {
        return this.version;
    }

    public int hashCode() {
        int hashCode = Boolean.hashCode(this.isRunning) * 31;
        String str = this.fileKey;
        int i = 0;
        int hashCode2 = (((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.paragraphIndex)) * 31) + Boolean.hashCode(this.isAutoTiciPlaying)) * 31) + Float.hashCode(this.autoTiciProgress)) * 31;
        Integer num = this.version;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.currentPage;
        if (num2 != null) {
            i = num2.hashCode();
        }
        return hashCode3 + i;
    }

    public final boolean isAutoTiciPlaying() {
        return this.isAutoTiciPlaying;
    }

    public final boolean isRunning() {
        return this.isRunning;
    }

    @NotNull
    public String toString() {
        boolean z = this.isRunning;
        String str = this.fileKey;
        int i = this.paragraphIndex;
        boolean z2 = this.isAutoTiciPlaying;
        float f = this.autoTiciProgress;
        Integer num = this.version;
        Integer num2 = this.currentPage;
        return "CheckTiciStateReply(isRunning=" + z + ", fileKey=" + str + ", paragraphIndex=" + i + ", isAutoTiciPlaying=" + z2 + ", autoTiciProgress=" + f + ", version=" + num + ", currentPage=" + num2 + ")";
    }
}
