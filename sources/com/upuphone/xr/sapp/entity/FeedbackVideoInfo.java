package com.upuphone.xr.sapp.entity;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/upuphone/xr/sapp/entity/FeedbackVideoInfo;", "", "videoType", "", "videoUrl", "", "videoSrc", "(ILjava/lang/String;Ljava/lang/String;)V", "getVideoSrc", "()Ljava/lang/String;", "setVideoSrc", "(Ljava/lang/String;)V", "getVideoType", "()I", "setVideoType", "(I)V", "getVideoUrl", "setVideoUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class FeedbackVideoInfo {
    @Nullable
    private String videoSrc;
    private int videoType;
    @Nullable
    private String videoUrl;

    public FeedbackVideoInfo(int i, @Nullable String str, @Nullable String str2) {
        this.videoType = i;
        this.videoUrl = str;
        this.videoSrc = str2;
    }

    public static /* synthetic */ FeedbackVideoInfo copy$default(FeedbackVideoInfo feedbackVideoInfo, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = feedbackVideoInfo.videoType;
        }
        if ((i2 & 2) != 0) {
            str = feedbackVideoInfo.videoUrl;
        }
        if ((i2 & 4) != 0) {
            str2 = feedbackVideoInfo.videoSrc;
        }
        return feedbackVideoInfo.copy(i, str, str2);
    }

    public final int component1() {
        return this.videoType;
    }

    @Nullable
    public final String component2() {
        return this.videoUrl;
    }

    @Nullable
    public final String component3() {
        return this.videoSrc;
    }

    @NotNull
    public final FeedbackVideoInfo copy(int i, @Nullable String str, @Nullable String str2) {
        return new FeedbackVideoInfo(i, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedbackVideoInfo)) {
            return false;
        }
        FeedbackVideoInfo feedbackVideoInfo = (FeedbackVideoInfo) obj;
        return this.videoType == feedbackVideoInfo.videoType && Intrinsics.areEqual((Object) this.videoUrl, (Object) feedbackVideoInfo.videoUrl) && Intrinsics.areEqual((Object) this.videoSrc, (Object) feedbackVideoInfo.videoSrc);
    }

    @Nullable
    public final String getVideoSrc() {
        return this.videoSrc;
    }

    public final int getVideoType() {
        return this.videoType;
    }

    @Nullable
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.videoType) * 31;
        String str = this.videoUrl;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.videoSrc;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public final void setVideoSrc(@Nullable String str) {
        this.videoSrc = str;
    }

    public final void setVideoType(int i) {
        this.videoType = i;
    }

    public final void setVideoUrl(@Nullable String str) {
        this.videoUrl = str;
    }

    @NotNull
    public String toString() {
        int i = this.videoType;
        String str = this.videoUrl;
        String str2 = this.videoSrc;
        return "FeedbackVideoInfo(videoType=" + i + ", videoUrl=" + str + ", videoSrc=" + str2 + ")";
    }
}
