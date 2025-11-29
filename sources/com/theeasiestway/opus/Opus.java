package com.theeasiestway.opus;

import android.util.Log;
import com.theeasiestway.opus.Constants;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0017\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH J\u0013\u0010\u0005\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0006H J\"\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eJ+\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000eH J+\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000eH J\"\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J!\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000eH J\u0006\u0010\u0015\u001a\u00020\u0016J\u0011\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0004H J\u0006\u0010\u0017\u001a\u00020\u0016J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fJ#\u0010\u0018\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u000eH J#\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u000eH J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bJ)\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000eH J\u0006\u0010\u001c\u001a\u00020\u0016J\u0011\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0004H J\u000e\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0019\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u000eH J\u000e\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"J\u0019\u0010 \u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u000eH J\t\u0010#\u001a\u00020\u0004H J\u0011\u0010$\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0004H R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/theeasiestway/opus/Opus;", "", "()V", "handle", "", "convert", "", "bytes", "", "shorts", "decode", "frameSize", "Lcom/theeasiestway/opus/Constants$FrameSize;", "fec", "", "decoderInit", "sampleRate", "Lcom/theeasiestway/opus/Constants$SampleRate;", "channels", "Lcom/theeasiestway/opus/Constants$Channels;", "numChannels", "decoderRelease", "", "destroy", "encode", "encoderInit", "application", "Lcom/theeasiestway/opus/Constants$Application;", "encoderRelease", "encoderSetBitrate", "bitrate", "Lcom/theeasiestway/opus/Constants$Bitrate;", "encoderSetComplexity", "complexity", "Lcom/theeasiestway/opus/Constants$Complexity;", "nativeCreateCodec", "nativeDestroyCodec", "Companion", "opus_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Opus {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "Opus";
    private long handle = nativeCreateCodec();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/theeasiestway/opus/Opus$Companion;", "", "()V", "TAG", "", "opus_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        try {
            System.loadLibrary("easyopus");
        } catch (Exception e) {
            Log.e(TAG, "Couldn't load opus library: " + e);
        }
    }

    private final native byte[] decode(long j, byte[] bArr, int i, int i2);

    private final native short[] decode(long j, short[] sArr, int i, int i2);

    public static /* synthetic */ byte[] decode$default(Opus opus, byte[] bArr, Constants.FrameSize frameSize, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return opus.decode(bArr, frameSize, i);
    }

    private final native int decoderInit(long j, int i, int i2);

    private final native void decoderRelease(long j);

    private final native byte[] encode(long j, byte[] bArr, int i);

    private final native short[] encode(long j, short[] sArr, int i);

    private final native int encoderInit(long j, int i, int i2, int i3);

    private final native void encoderRelease(long j);

    private final native int encoderSetBitrate(long j, int i);

    private final native int encoderSetComplexity(long j, int i);

    private final native long nativeCreateCodec();

    private final native void nativeDestroyCodec(long j);

    @Nullable
    public final native byte[] convert(@NotNull short[] sArr);

    @Nullable
    public final native short[] convert(@NotNull byte[] bArr);

    @Nullable
    public final byte[] decode(@NotNull byte[] bArr, @NotNull Constants.FrameSize frameSize, int i) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        Intrinsics.checkNotNullParameter(frameSize, "frameSize");
        return decode(this.handle, bArr, frameSize.getV(), i);
    }

    public final int decoderInit(@NotNull Constants.SampleRate sampleRate, @NotNull Constants.Channels channels) {
        Intrinsics.checkNotNullParameter(sampleRate, "sampleRate");
        Intrinsics.checkNotNullParameter(channels, "channels");
        return decoderInit(this.handle, sampleRate.getV(), channels.getV());
    }

    public final void decoderRelease() {
        decoderRelease(this.handle);
    }

    public final void destroy() {
        Log.i(TAG, "释放Opus产生的数据 handle=" + this.handle);
        long j = this.handle;
        if (j != 0) {
            nativeDestroyCodec(j);
            this.handle = 0;
        }
    }

    @Nullable
    public final byte[] encode(@NotNull byte[] bArr, @NotNull Constants.FrameSize frameSize) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        Intrinsics.checkNotNullParameter(frameSize, "frameSize");
        return encode(this.handle, bArr, frameSize.getV());
    }

    public final int encoderInit(@NotNull Constants.SampleRate sampleRate, @NotNull Constants.Channels channels, @NotNull Constants.Application application) {
        Intrinsics.checkNotNullParameter(sampleRate, "sampleRate");
        Intrinsics.checkNotNullParameter(channels, "channels");
        Intrinsics.checkNotNullParameter(application, VuiModelType.APPLICATION);
        return encoderInit(this.handle, sampleRate.getV(), channels.getV(), application.getV());
    }

    public final void encoderRelease() {
        encoderRelease(this.handle);
    }

    public final int encoderSetBitrate(@NotNull Constants.Bitrate bitrate) {
        Intrinsics.checkNotNullParameter(bitrate, "bitrate");
        return encoderSetBitrate(this.handle, bitrate.getV());
    }

    public final int encoderSetComplexity(@NotNull Constants.Complexity complexity) {
        Intrinsics.checkNotNullParameter(complexity, "complexity");
        return encoderSetComplexity(this.handle, complexity.getV());
    }

    public static /* synthetic */ short[] decode$default(Opus opus, short[] sArr, Constants.FrameSize frameSize, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return opus.decode(sArr, frameSize, i);
    }

    @Nullable
    public final short[] decode(@NotNull short[] sArr, @NotNull Constants.FrameSize frameSize, int i) {
        Intrinsics.checkNotNullParameter(sArr, "shorts");
        Intrinsics.checkNotNullParameter(frameSize, "frameSize");
        return decode(this.handle, sArr, frameSize.getV(), i);
    }

    @Nullable
    public final short[] encode(@NotNull short[] sArr, @NotNull Constants.FrameSize frameSize) {
        Intrinsics.checkNotNullParameter(sArr, "shorts");
        Intrinsics.checkNotNullParameter(frameSize, "frameSize");
        return encode(this.handle, sArr, frameSize.getV());
    }
}
