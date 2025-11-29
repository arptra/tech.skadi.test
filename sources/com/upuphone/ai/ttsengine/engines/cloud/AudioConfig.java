package com.upuphone.ai.ttsengine.engines.cloud;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003Jc\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0005HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016¨\u0006*"}, d2 = {"Lcom/upuphone/ai/ttsengine/engines/cloud/AudioConfig;", "", "voice_type", "", "rate", "", "encoding", "compression_rate", "speed_ratio", "", "volume_ratio", "pitch_ratio", "emotion", "language", "(Ljava/lang/String;ILjava/lang/String;IFFFLjava/lang/String;Ljava/lang/String;)V", "getCompression_rate", "()I", "getEmotion", "()Ljava/lang/String;", "getEncoding", "getLanguage", "getPitch_ratio", "()F", "getRate", "getSpeed_ratio", "getVoice_type", "getVolume_ratio", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "aar_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class AudioConfig {
    private final int compression_rate;
    @NotNull
    private final String emotion;
    @NotNull
    private final String encoding;
    @NotNull
    private final String language;
    private final float pitch_ratio;
    private final int rate;
    private final float speed_ratio;
    @NotNull
    private final String voice_type;
    private final float volume_ratio;

    public AudioConfig() {
        this((String) null, 0, (String) null, 0, 0.0f, 0.0f, 0.0f, (String) null, (String) null, 511, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AudioConfig copy$default(AudioConfig audioConfig, String str, int i, String str2, int i2, float f, float f2, float f3, String str3, String str4, int i3, Object obj) {
        AudioConfig audioConfig2 = audioConfig;
        int i4 = i3;
        return audioConfig.copy((i4 & 1) != 0 ? audioConfig2.voice_type : str, (i4 & 2) != 0 ? audioConfig2.rate : i, (i4 & 4) != 0 ? audioConfig2.encoding : str2, (i4 & 8) != 0 ? audioConfig2.compression_rate : i2, (i4 & 16) != 0 ? audioConfig2.speed_ratio : f, (i4 & 32) != 0 ? audioConfig2.volume_ratio : f2, (i4 & 64) != 0 ? audioConfig2.pitch_ratio : f3, (i4 & 128) != 0 ? audioConfig2.emotion : str3, (i4 & 256) != 0 ? audioConfig2.language : str4);
    }

    @NotNull
    public final String component1() {
        return this.voice_type;
    }

    public final int component2() {
        return this.rate;
    }

    @NotNull
    public final String component3() {
        return this.encoding;
    }

    public final int component4() {
        return this.compression_rate;
    }

    public final float component5() {
        return this.speed_ratio;
    }

    public final float component6() {
        return this.volume_ratio;
    }

    public final float component7() {
        return this.pitch_ratio;
    }

    @NotNull
    public final String component8() {
        return this.emotion;
    }

    @NotNull
    public final String component9() {
        return this.language;
    }

    @NotNull
    public final AudioConfig copy(@NotNull String str, int i, @NotNull String str2, int i2, float f, float f2, float f3, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "voice_type");
        Intrinsics.checkNotNullParameter(str2, "encoding");
        String str5 = str3;
        Intrinsics.checkNotNullParameter(str5, "emotion");
        String str6 = str4;
        Intrinsics.checkNotNullParameter(str6, "language");
        return new AudioConfig(str, i, str2, i2, f, f2, f3, str5, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioConfig)) {
            return false;
        }
        AudioConfig audioConfig = (AudioConfig) obj;
        return Intrinsics.areEqual((Object) this.voice_type, (Object) audioConfig.voice_type) && this.rate == audioConfig.rate && Intrinsics.areEqual((Object) this.encoding, (Object) audioConfig.encoding) && this.compression_rate == audioConfig.compression_rate && Float.compare(this.speed_ratio, audioConfig.speed_ratio) == 0 && Float.compare(this.volume_ratio, audioConfig.volume_ratio) == 0 && Float.compare(this.pitch_ratio, audioConfig.pitch_ratio) == 0 && Intrinsics.areEqual((Object) this.emotion, (Object) audioConfig.emotion) && Intrinsics.areEqual((Object) this.language, (Object) audioConfig.language);
    }

    public final int getCompression_rate() {
        return this.compression_rate;
    }

    @NotNull
    public final String getEmotion() {
        return this.emotion;
    }

    @NotNull
    public final String getEncoding() {
        return this.encoding;
    }

    @NotNull
    public final String getLanguage() {
        return this.language;
    }

    public final float getPitch_ratio() {
        return this.pitch_ratio;
    }

    public final int getRate() {
        return this.rate;
    }

    public final float getSpeed_ratio() {
        return this.speed_ratio;
    }

    @NotNull
    public final String getVoice_type() {
        return this.voice_type;
    }

    public final float getVolume_ratio() {
        return this.volume_ratio;
    }

    public int hashCode() {
        return (((((((((((((((this.voice_type.hashCode() * 31) + Integer.hashCode(this.rate)) * 31) + this.encoding.hashCode()) * 31) + Integer.hashCode(this.compression_rate)) * 31) + Float.hashCode(this.speed_ratio)) * 31) + Float.hashCode(this.volume_ratio)) * 31) + Float.hashCode(this.pitch_ratio)) * 31) + this.emotion.hashCode()) * 31) + this.language.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.voice_type;
        int i = this.rate;
        String str2 = this.encoding;
        int i2 = this.compression_rate;
        float f = this.speed_ratio;
        float f2 = this.volume_ratio;
        float f3 = this.pitch_ratio;
        String str3 = this.emotion;
        String str4 = this.language;
        return "AudioConfig(voice_type=" + str + ", rate=" + i + ", encoding=" + str2 + ", compression_rate=" + i2 + ", speed_ratio=" + f + ", volume_ratio=" + f2 + ", pitch_ratio=" + f3 + ", emotion=" + str3 + ", language=" + str4 + ")";
    }

    public AudioConfig(@NotNull String str, int i, @NotNull String str2, int i2, float f, float f2, float f3, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "voice_type");
        Intrinsics.checkNotNullParameter(str2, "encoding");
        Intrinsics.checkNotNullParameter(str3, "emotion");
        Intrinsics.checkNotNullParameter(str4, "language");
        this.voice_type = str;
        this.rate = i;
        this.encoding = str2;
        this.compression_rate = i2;
        this.speed_ratio = f;
        this.volume_ratio = f2;
        this.pitch_ratio = f3;
        this.emotion = str3;
        this.language = str4;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AudioConfig(java.lang.String r10, int r11, java.lang.String r12, int r13, float r14, float r15, float r16, java.lang.String r17, java.lang.String r18, int r19, kotlin.jvm.internal.DefaultConstructorMarker r20) {
        /*
            r9 = this;
            r0 = r19
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0009
            java.lang.String r1 = "BV700_streaming"
            goto L_0x000a
        L_0x0009:
            r1 = r10
        L_0x000a:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0011
            r2 = 16000(0x3e80, float:2.2421E-41)
            goto L_0x0012
        L_0x0011:
            r2 = r11
        L_0x0012:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0019
            java.lang.String r3 = "ogg_opus"
            goto L_0x001a
        L_0x0019:
            r3 = r12
        L_0x001a:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0020
            r4 = 1
            goto L_0x0021
        L_0x0020:
            r4 = r13
        L_0x0021:
            r5 = r0 & 16
            r6 = 1065353216(0x3f800000, float:1.0)
            if (r5 == 0) goto L_0x0029
            r5 = r6
            goto L_0x002a
        L_0x0029:
            r5 = r14
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = r6
            goto L_0x0031
        L_0x0030:
            r7 = r15
        L_0x0031:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0036
            goto L_0x0038
        L_0x0036:
            r6 = r16
        L_0x0038:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x003f
            java.lang.String r8 = "neutral"
            goto L_0x0041
        L_0x003f:
            r8 = r17
        L_0x0041:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0048
            java.lang.String r0 = "cn"
            goto L_0x004a
        L_0x0048:
            r0 = r18
        L_0x004a:
            r10 = r1
            r11 = r2
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r7
            r16 = r6
            r17 = r8
            r18 = r0
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ai.ttsengine.engines.cloud.AudioConfig.<init>(java.lang.String, int, java.lang.String, int, float, float, float, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
