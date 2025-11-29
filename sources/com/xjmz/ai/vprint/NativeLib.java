package com.xjmz.ai.vprint;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0010\u0017\n\u0002\b\u0004\u0018\u0000 42\u00020\u0001:\u000245B\u0005¢\u0006\u0002\u0010\u0002J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH J\u0011\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH JA\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH J)\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH J!\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000bH J1\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J9\u0010#\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH J\u000e\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\u0004J!\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010\u001a\u001a\u00020\u000bH J!\u0010,\u001a\u00020*2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000bH J1\u0010-\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH J\u0011\u0010.\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u000eH J9\u0010/\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u00100\u001a\u00020*2\u0006\u00101\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u0002022\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH JA\u00103\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u00100\u001a\u00020*2\u0006\u00101\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u0002022\u0006\u0010+\u001a\u0002022\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/xjmz/ai/vprint/NativeLib;", "", "()V", "nativeCallback", "Lcom/xjmz/ai/vprint/NativeLib$OnNativeCallback;", "CosineSimilarity", "", "enrollEmbPath", "", "speakerEmbPath", "embeddingSize", "", "destroy", "selfAddr", "", "extractEmb", "modelPath", "embeddingTxt", "wavPath", "modelType", "embModelType", "featDim", "extractFrame", "engine", "data", "", "len", "output", "Lcom/xjmz/ai/vprint/Output;", "extractFrameSimilarity", "extractTarget", "targetPath", "handleResult", "", "type", "initModel", "nnbeamCfg", "aecCfg", "setNativeCallback", "callback", "similarity", "data1", "", "data2", "spkRecogExtractEmb", "spkRecogInit", "spkRecogThreshold", "sspExtractFrame", "emb", "emb_size", "", "sspExtractFrame2", "Companion", "OnNativeCallback", "vprint-sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NativeLib {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Nullable
    public static NativeLib instance;
    @Nullable
    private OnNativeCallback nativeCallback;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0004R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/xjmz/ai/vprint/NativeLib$Companion;", "", "()V", "instance", "Lcom/xjmz/ai/vprint/NativeLib;", "getInstance", "()Lcom/xjmz/ai/vprint/NativeLib;", "get", "vprint-sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final NativeLib getInstance() {
            if (NativeLib.instance == null) {
                NativeLib.instance = new NativeLib();
            }
            return NativeLib.instance;
        }

        @NotNull
        public final NativeLib get() {
            NativeLib instance = getInstance();
            Intrinsics.checkNotNull(instance);
            return instance;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/xjmz/ai/vprint/NativeLib$OnNativeCallback;", "", "onResult", "", "type", "", "data", "", "vprint-sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface OnNativeCallback {
        void onResult(int i, @NotNull byte[] bArr);
    }

    static {
        System.loadLibrary("vprint_sdk");
    }

    public final native float CosineSimilarity(@NotNull String str, @NotNull String str2, int i);

    public final native int destroy(long j);

    public final native int extractEmb(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, @NotNull String str4, int i2, int i3);

    public final native int extractFrame(long j, @NotNull byte[] bArr, int i, @NotNull Output output);

    public final native float extractFrameSimilarity(long j, @NotNull byte[] bArr, int i);

    public final native int extractTarget(long j, @NotNull String str, @NotNull String str2, int i, int i2);

    public final void handleResult(int i, @Nullable byte[] bArr) {
        OnNativeCallback onNativeCallback;
        if (bArr != null && bArr.length > 0 && (onNativeCallback = this.nativeCallback) != null) {
            onNativeCallback.onResult(i, bArr);
        }
    }

    public final native long initModel(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i, int i2);

    public final void setNativeCallback(@NotNull OnNativeCallback onNativeCallback) {
        Intrinsics.checkNotNullParameter(onNativeCallback, "callback");
        this.nativeCallback = onNativeCallback;
    }

    public final native float similarity(@NotNull float[] fArr, @NotNull float[] fArr2, int i);

    @NotNull
    public final native float[] spkRecogExtractEmb(long j, @NotNull byte[] bArr, int i);

    public final native long spkRecogInit(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, int i2);

    public final native float spkRecogThreshold(long j);

    public final native int sspExtractFrame(long j, @NotNull float[] fArr, int i, @NotNull short[] sArr, int i2, @NotNull Output output);

    public final native int sspExtractFrame2(long j, @NotNull float[] fArr, int i, @NotNull short[] sArr, @NotNull short[] sArr2, int i2, @NotNull Output output);
}
