package com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\fHÆ\u0003JY\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010)\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\fHÖ\u0001R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0016\"\u0004\b\u0019\u0010\u0018R\u001a\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001a\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015¨\u0006."}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/bean/AsrDuringProgress;", "", "totalTime", "", "curAsrTime", "recordId", "isFinish", "", "isFail", "isWaitAsr", "isStartAsr", "content", "", "(JJJZZZZLjava/lang/String;)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getCurAsrTime", "()J", "setCurAsrTime", "(J)V", "()Z", "setFail", "(Z)V", "setFinish", "setStartAsr", "setWaitAsr", "getRecordId", "setRecordId", "getTotalTime", "setTotalTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AsrDuringProgress {
    @NotNull
    private String content;
    private long curAsrTime;
    private boolean isFail;
    private boolean isFinish;
    private boolean isStartAsr;
    private boolean isWaitAsr;
    private long recordId;
    private long totalTime;

    public AsrDuringProgress(long j, long j2, long j3, boolean z, boolean z2, boolean z3, boolean z4, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "content");
        this.totalTime = j;
        this.curAsrTime = j2;
        this.recordId = j3;
        this.isFinish = z;
        this.isFail = z2;
        this.isWaitAsr = z3;
        this.isStartAsr = z4;
        this.content = str;
    }

    public static /* synthetic */ AsrDuringProgress copy$default(AsrDuringProgress asrDuringProgress, long j, long j2, long j3, boolean z, boolean z2, boolean z3, boolean z4, String str, int i, Object obj) {
        AsrDuringProgress asrDuringProgress2 = asrDuringProgress;
        int i2 = i;
        return asrDuringProgress.copy((i2 & 1) != 0 ? asrDuringProgress2.totalTime : j, (i2 & 2) != 0 ? asrDuringProgress2.curAsrTime : j2, (i2 & 4) != 0 ? asrDuringProgress2.recordId : j3, (i2 & 8) != 0 ? asrDuringProgress2.isFinish : z, (i2 & 16) != 0 ? asrDuringProgress2.isFail : z2, (i2 & 32) != 0 ? asrDuringProgress2.isWaitAsr : z3, (i2 & 64) != 0 ? asrDuringProgress2.isStartAsr : z4, (i2 & 128) != 0 ? asrDuringProgress2.content : str);
    }

    public final long component1() {
        return this.totalTime;
    }

    public final long component2() {
        return this.curAsrTime;
    }

    public final long component3() {
        return this.recordId;
    }

    public final boolean component4() {
        return this.isFinish;
    }

    public final boolean component5() {
        return this.isFail;
    }

    public final boolean component6() {
        return this.isWaitAsr;
    }

    public final boolean component7() {
        return this.isStartAsr;
    }

    @NotNull
    public final String component8() {
        return this.content;
    }

    @NotNull
    public final AsrDuringProgress copy(long j, long j2, long j3, boolean z, boolean z2, boolean z3, boolean z4, @NotNull String str) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "content");
        return new AsrDuringProgress(j, j2, j3, z, z2, z3, z4, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AsrDuringProgress)) {
            return false;
        }
        AsrDuringProgress asrDuringProgress = (AsrDuringProgress) obj;
        return this.totalTime == asrDuringProgress.totalTime && this.curAsrTime == asrDuringProgress.curAsrTime && this.recordId == asrDuringProgress.recordId && this.isFinish == asrDuringProgress.isFinish && this.isFail == asrDuringProgress.isFail && this.isWaitAsr == asrDuringProgress.isWaitAsr && this.isStartAsr == asrDuringProgress.isStartAsr && Intrinsics.areEqual((Object) this.content, (Object) asrDuringProgress.content);
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    public final long getCurAsrTime() {
        return this.curAsrTime;
    }

    public final long getRecordId() {
        return this.recordId;
    }

    public final long getTotalTime() {
        return this.totalTime;
    }

    public int hashCode() {
        return (((((((((((((Long.hashCode(this.totalTime) * 31) + Long.hashCode(this.curAsrTime)) * 31) + Long.hashCode(this.recordId)) * 31) + Boolean.hashCode(this.isFinish)) * 31) + Boolean.hashCode(this.isFail)) * 31) + Boolean.hashCode(this.isWaitAsr)) * 31) + Boolean.hashCode(this.isStartAsr)) * 31) + this.content.hashCode();
    }

    public final boolean isFail() {
        return this.isFail;
    }

    public final boolean isFinish() {
        return this.isFinish;
    }

    public final boolean isStartAsr() {
        return this.isStartAsr;
    }

    public final boolean isWaitAsr() {
        return this.isWaitAsr;
    }

    public final void setContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    public final void setCurAsrTime(long j) {
        this.curAsrTime = j;
    }

    public final void setFail(boolean z) {
        this.isFail = z;
    }

    public final void setFinish(boolean z) {
        this.isFinish = z;
    }

    public final void setRecordId(long j) {
        this.recordId = j;
    }

    public final void setStartAsr(boolean z) {
        this.isStartAsr = z;
    }

    public final void setTotalTime(long j) {
        this.totalTime = j;
    }

    public final void setWaitAsr(boolean z) {
        this.isWaitAsr = z;
    }

    @NotNull
    public String toString() {
        long j = this.totalTime;
        long j2 = this.curAsrTime;
        long j3 = this.recordId;
        boolean z = this.isFinish;
        boolean z2 = this.isFail;
        boolean z3 = this.isWaitAsr;
        boolean z4 = this.isStartAsr;
        String str = this.content;
        return "AsrDuringProgress(totalTime=" + j + ", curAsrTime=" + j2 + ", recordId=" + j3 + ", isFinish=" + z + ", isFail=" + z2 + ", isWaitAsr=" + z3 + ", isStartAsr=" + z4 + ", content=" + str + ")";
    }
}
