package com.xjsd.xr.sapp.asr.dao;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003JM\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\b\u0010!\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006\""}, d2 = {"Lcom/xjsd/xr/sapp/asr/dao/AsrRequestData;", "", "audioType", "", "sampleRate", "", "channel", "sampleBytes", "hotWords", "", "enablePunctuation", "", "(Ljava/lang/String;IIILjava/util/List;Z)V", "getAudioType", "()Ljava/lang/String;", "getChannel", "()I", "getEnablePunctuation", "()Z", "getHotWords", "()Ljava/util/List;", "getSampleBytes", "getSampleRate", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AsrRequestData {
    @NotNull
    private final String audioType;
    private final int channel;
    private final boolean enablePunctuation;
    @Nullable
    private final List<String> hotWords;
    private final int sampleBytes;
    private final int sampleRate;

    public AsrRequestData(@NotNull String str, int i, int i2, int i3, @Nullable List<String> list, boolean z) {
        Intrinsics.checkNotNullParameter(str, "audioType");
        this.audioType = str;
        this.sampleRate = i;
        this.channel = i2;
        this.sampleBytes = i3;
        this.hotWords = list;
        this.enablePunctuation = z;
    }

    public static /* synthetic */ AsrRequestData copy$default(AsrRequestData asrRequestData, String str, int i, int i2, int i3, List<String> list, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = asrRequestData.audioType;
        }
        if ((i4 & 2) != 0) {
            i = asrRequestData.sampleRate;
        }
        int i5 = i;
        if ((i4 & 4) != 0) {
            i2 = asrRequestData.channel;
        }
        int i6 = i2;
        if ((i4 & 8) != 0) {
            i3 = asrRequestData.sampleBytes;
        }
        int i7 = i3;
        if ((i4 & 16) != 0) {
            list = asrRequestData.hotWords;
        }
        List<String> list2 = list;
        if ((i4 & 32) != 0) {
            z = asrRequestData.enablePunctuation;
        }
        return asrRequestData.copy(str, i5, i6, i7, list2, z);
    }

    @NotNull
    public final String component1() {
        return this.audioType;
    }

    public final int component2() {
        return this.sampleRate;
    }

    public final int component3() {
        return this.channel;
    }

    public final int component4() {
        return this.sampleBytes;
    }

    @Nullable
    public final List<String> component5() {
        return this.hotWords;
    }

    public final boolean component6() {
        return this.enablePunctuation;
    }

    @NotNull
    public final AsrRequestData copy(@NotNull String str, int i, int i2, int i3, @Nullable List<String> list, boolean z) {
        Intrinsics.checkNotNullParameter(str, "audioType");
        return new AsrRequestData(str, i, i2, i3, list, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AsrRequestData)) {
            return false;
        }
        AsrRequestData asrRequestData = (AsrRequestData) obj;
        return Intrinsics.areEqual((Object) this.audioType, (Object) asrRequestData.audioType) && this.sampleRate == asrRequestData.sampleRate && this.channel == asrRequestData.channel && this.sampleBytes == asrRequestData.sampleBytes && Intrinsics.areEqual((Object) this.hotWords, (Object) asrRequestData.hotWords) && this.enablePunctuation == asrRequestData.enablePunctuation;
    }

    @NotNull
    public final String getAudioType() {
        return this.audioType;
    }

    public final int getChannel() {
        return this.channel;
    }

    public final boolean getEnablePunctuation() {
        return this.enablePunctuation;
    }

    @Nullable
    public final List<String> getHotWords() {
        return this.hotWords;
    }

    public final int getSampleBytes() {
        return this.sampleBytes;
    }

    public final int getSampleRate() {
        return this.sampleRate;
    }

    public int hashCode() {
        int hashCode = ((((((this.audioType.hashCode() * 31) + Integer.hashCode(this.sampleRate)) * 31) + Integer.hashCode(this.channel)) * 31) + Integer.hashCode(this.sampleBytes)) * 31;
        List<String> list = this.hotWords;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        boolean z = this.enablePunctuation;
        if (z) {
            z = true;
        }
        return hashCode2 + (z ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "AsrRequestData(audioType='" + this.audioType + "', channel=" + this.channel + ", sampleBytes=" + this.sampleBytes + ", sampleRate=" + this.sampleRate + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AsrRequestData(String str, int i, int i2, int i3, List list, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i4 & 2) != 0 ? 16000 : i, (i4 & 4) != 0 ? 1 : i2, (i4 & 8) != 0 ? 2 : i3, (i4 & 16) != 0 ? null : list, (i4 & 32) != 0 ? true : z);
    }
}
