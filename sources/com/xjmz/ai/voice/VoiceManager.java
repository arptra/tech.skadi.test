package com.xjmz.ai.voice;

import android.content.Context;
import android.util.Log;
import com.xjmz.ai.vprint.NativeLib;
import com.xjmz.ai.vprint.Output;
import com.xjmz.ai.vprint.VprintConfig;
import java.io.File;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0017\n\u0002\b\u0003\u0018\u0000 Z2\u00020\u0001:\u0002Z[B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u0004J\u0006\u0010*\u001a\u00020+J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020$J\u001e\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u000202J\u0016\u00103\u001a\u00020&2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0004J&\u00104\u001a\u00020\u00042\u0006\u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u0004J\b\u00108\u001a\u00020+H\u0004J>\u00109\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\n2\u0006\u0010;\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020\n2\u0006\u0010>\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u0004J\u000e\u0010?\u001a\u00020+2\u0006\u0010@\u001a\u00020AJ\u0010\u0010B\u001a\u00020+2\b\b\u0002\u0010C\u001a\u00020\u0004J.\u0010D\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\n2\u0006\u0010;\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u0004J@\u0010D\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\n2\u0006\u0010;\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020\n2\u0006\u0010>\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u0004H\u0007J\u001e\u0010F\u001a\u00020&2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020H2\u0006\u0010J\u001a\u00020\u0004J\u000e\u0010K\u001a\u00020+2\u0006\u0010,\u001a\u00020$J\u001e\u0010L\u001a\u00020H2\u0006\u0010,\u001a\u00020$2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0004J \u0010M\u001a\u00020$2\u0006\u0010@\u001a\u00020A2\u0006\u0010N\u001a\u00020O2\b\b\u0002\u0010P\u001a\u00020QJ\u000e\u0010R\u001a\u00020&2\u0006\u0010,\u001a\u00020$J\u001e\u0010S\u001a\u00020$2\u0006\u0010@\u001a\u00020A2\u0006\u0010T\u001a\u00020\n2\u0006\u0010U\u001a\u00020\nJ&\u0010V\u001a\u00020+2\u0006\u0010#\u001a\u00020$2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u000202J6\u0010V\u001a\u00020+2\u0006\u0010#\u001a\u00020$2\u0006\u0010W\u001a\u00020H2\u0006\u0010X\u001a\u00020\u00042\u0006\u0010.\u001a\u00020Y2\u0006\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u000202J>\u0010V\u001a\u00020+2\u0006\u0010#\u001a\u00020$2\u0006\u0010W\u001a\u00020H2\u0006\u0010X\u001a\u00020\u00042\u0006\u0010.\u001a\u00020Y2\u0006\u0010I\u001a\u00020Y2\u0006\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u000202R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\fR\u0014\u0010\u0017\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\fR\u0014\u0010\u0019\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\fR\u0014\u0010\u001b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0014\u0010\u001d\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0014\u0010\u001f\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b \u0010\fR\u0014\u0010!\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\fR\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000¨\u0006\\"}, d2 = {"Lcom/xjmz/ai/voice/VoiceManager;", "", "()V", "SPKRECOG_EMBEDDING_SIZE", "", "getSPKRECOG_EMBEDDING_SIZE", "()I", "SPKRECOG_FEAT_DIM", "getSPKRECOG_FEAT_DIM", "SSP_AEC_CFG", "", "getSSP_AEC_CFG", "()Ljava/lang/String;", "SSP_EMBEDDING_SIZE", "getSSP_EMBEDDING_SIZE", "SSP_EMB_MODEL", "getSSP_EMB_MODEL", "SSP_EXTRACT_MODEL", "getSSP_EXTRACT_MODEL", "SSP_FEAT_DIM", "getSSP_FEAT_DIM", "SSP_NNBEAM_MODEL", "getSSP_NNBEAM_MODEL", "TAG", "getTAG", "UNAWARE_CONTENT_MODEL", "getUNAWARE_CONTENT_MODEL", "WAKEUP_EMBEDDING_SIZE", "getWAKEUP_EMBEDDING_SIZE", "WAKEUP_FEAT_DIM", "getWAKEUP_FEAT_DIM", "WAKEUP_MODEL", "getWAKEUP_MODEL", "WAKEUP_MODEL_EN", "getWAKEUP_MODEL_EN", "extractEngine", "", "CosineSimilarity", "", "enrollPath", "speakerPath", "embeddingSize", "deleteModel", "", "engine", "extractFrame", "data", "", "length", "output", "Lcom/xjmz/ai/vprint/Output;", "extractFrameSimilarity", "extractTarget", "src", "des", "featDim", "finalize", "getVprintEmb", "modulePath", "moduleType", "embeddingTxt", "voicePath", "embModelType", "init", "context", "Landroid/content/Context;", "initModel", "modelType", "registerSpeaker", "targetVoice", "similarity", "data1", "", "data2", "len", "spkRecogDelete", "spkRecogGetEmb", "spkRecogInit", "caseType", "Lcom/xjmz/ai/voice/SpeakerVerificationType;", "english", "", "spkRecogThreshold", "spkSSPInit", "registVoicePath", "embeddingTxtPath", "sspExtractFrame", "emb", "emb_size", "", "Companion", "SingleHolder", "vprint-sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VoiceManager {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int SPKRECOG_EMBEDDING_SIZE;
    private final int SPKRECOG_FEAT_DIM;
    @NotNull
    private final String SSP_AEC_CFG;
    private final int SSP_EMBEDDING_SIZE;
    @NotNull
    private final String SSP_EMB_MODEL;
    @NotNull
    private final String SSP_EXTRACT_MODEL;
    private final int SSP_FEAT_DIM;
    @NotNull
    private final String SSP_NNBEAM_MODEL;
    @NotNull
    private final String TAG;
    @NotNull
    private final String UNAWARE_CONTENT_MODEL;
    private final int WAKEUP_EMBEDDING_SIZE;
    private final int WAKEUP_FEAT_DIM;
    @NotNull
    private final String WAKEUP_MODEL;
    @NotNull
    private final String WAKEUP_MODEL_EN;
    private long extractEngine;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/xjmz/ai/voice/VoiceManager$Companion;", "", "()V", "getInstance", "Lcom/xjmz/ai/voice/VoiceManager;", "vprint-sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final VoiceManager getInstance() {
            return SingleHolder.INSTANCE.getHolder();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/xjmz/ai/voice/VoiceManager$SingleHolder;", "", "()V", "holder", "Lcom/xjmz/ai/voice/VoiceManager;", "getHolder", "()Lcom/xjmz/ai/voice/VoiceManager;", "vprint-sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class SingleHolder {
        @NotNull
        public static final SingleHolder INSTANCE = new SingleHolder();
        @NotNull
        private static final VoiceManager holder = new VoiceManager((DefaultConstructorMarker) null);

        private SingleHolder() {
        }

        @NotNull
        public final VoiceManager getHolder() {
            return holder;
        }
    }

    public /* synthetic */ VoiceManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    @NotNull
    public static final VoiceManager getInstance() {
        return Companion.getInstance();
    }

    public static /* synthetic */ void initModel$default(VoiceManager voiceManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        voiceManager.initModel(i);
    }

    public static /* synthetic */ long spkRecogInit$default(VoiceManager voiceManager, Context context, SpeakerVerificationType speakerVerificationType, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return voiceManager.spkRecogInit(context, speakerVerificationType, z);
    }

    public final float CosineSimilarity(@NotNull String str, @NotNull String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "enrollPath");
        Intrinsics.checkNotNullParameter(str2, "speakerPath");
        String str3 = this.TAG;
        Log.d(str3, "CosineSimilarity: enrollPath=" + str + ", speakerPath=" + str2);
        float CosineSimilarity = NativeLib.Companion.get().CosineSimilarity(str, str2, i);
        String str4 = this.TAG;
        Log.d(str4, "CosineSimilarity: ret=" + CosineSimilarity);
        return CosineSimilarity;
    }

    public final void deleteModel(long j) {
        Log.d(this.TAG, "deleteModel: 2");
        if (j != 0) {
            NativeLib.Companion.get().destroy(j);
        }
    }

    public final void extractFrame(@NotNull byte[] bArr, int i, @NotNull Output output) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        Intrinsics.checkNotNullParameter(output, "output");
        String str = this.TAG;
        Log.d(str, "extractFrame: length = " + i);
        NativeLib.Companion.get().extractFrame(this.extractEngine, bArr, i, output);
    }

    public final float extractFrameSimilarity(@NotNull byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        String str = this.TAG;
        Log.d(str, "extractFrameSimilarity: length=" + i);
        return NativeLib.Companion.get().extractFrameSimilarity(this.extractEngine, bArr, i);
    }

    public final int extractTarget(@NotNull String str, @NotNull String str2, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "src");
        Intrinsics.checkNotNullParameter(str2, "des");
        return NativeLib.Companion.get().extractTarget(this.extractEngine, str, str2, i, i2);
    }

    public final void finalize() throws Throwable {
        Log.d(this.TAG, "finalize");
        deleteModel();
    }

    public final int getSPKRECOG_EMBEDDING_SIZE() {
        return this.SPKRECOG_EMBEDDING_SIZE;
    }

    public final int getSPKRECOG_FEAT_DIM() {
        return this.SPKRECOG_FEAT_DIM;
    }

    @NotNull
    public final String getSSP_AEC_CFG() {
        return this.SSP_AEC_CFG;
    }

    public final int getSSP_EMBEDDING_SIZE() {
        return this.SSP_EMBEDDING_SIZE;
    }

    @NotNull
    public final String getSSP_EMB_MODEL() {
        return this.SSP_EMB_MODEL;
    }

    @NotNull
    public final String getSSP_EXTRACT_MODEL() {
        return this.SSP_EXTRACT_MODEL;
    }

    public final int getSSP_FEAT_DIM() {
        return this.SSP_FEAT_DIM;
    }

    @NotNull
    public final String getSSP_NNBEAM_MODEL() {
        return this.SSP_NNBEAM_MODEL;
    }

    @NotNull
    public final String getTAG() {
        return this.TAG;
    }

    @NotNull
    public final String getUNAWARE_CONTENT_MODEL() {
        return this.UNAWARE_CONTENT_MODEL;
    }

    public final int getVprintEmb(@NotNull String str, int i, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "modulePath");
        Intrinsics.checkNotNullParameter(str2, "embeddingTxt");
        Intrinsics.checkNotNullParameter(str3, "voicePath");
        Intrinsics.checkNotNullParameter(str4, "embModelType");
        String str5 = this.TAG;
        Log.d(str5, "getVprintEmb: modulePath=" + str + ", moduleType=" + i + ", embeddingTxt=" + str2 + ", voicePath=" + str3 + ", embModelType=" + str4);
        return NativeLib.Companion.get().extractEmb(str, str2, str3, i, str4, i2, i3);
    }

    public final int getWAKEUP_EMBEDDING_SIZE() {
        return this.WAKEUP_EMBEDDING_SIZE;
    }

    public final int getWAKEUP_FEAT_DIM() {
        return this.WAKEUP_FEAT_DIM;
    }

    @NotNull
    public final String getWAKEUP_MODEL() {
        return this.WAKEUP_MODEL;
    }

    @NotNull
    public final String getWAKEUP_MODEL_EN() {
        return this.WAKEUP_MODEL_EN;
    }

    public final void init(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SVResourceUtil.copyAssetsData(context);
    }

    public final void initModel(int i) {
        String str = this.TAG;
        Log.d(str, "initModel: modelType = " + i);
        if (VprintConfig.getExtractModule().length() == 0) {
            Log.e("VoiceManager", "initModel error!!!! extractModule为空");
        } else if (VprintConfig.getEmbeddedText().length() != 0 && new File(VprintConfig.getEmbeddedText()).exists()) {
            this.extractEngine = NativeLib.Companion.get().initModel(VprintConfig.getExtractModule(), VprintConfig.getNnbeamCfg(), VprintConfig.getAecCfg(), VprintConfig.getEmbeddedText(), i, VprintConfig.getEmbeddingSize());
        } else {
            Log.e("VoiceManager", "initModel error!!!! embeddedText为空");
        }
    }

    @Deprecated(message = "不建议使用此方法。")
    public final int registerSpeaker(@NotNull String str, int i, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "modulePath");
        Intrinsics.checkNotNullParameter(str2, "embeddingTxt");
        Intrinsics.checkNotNullParameter(str3, "voicePath");
        Intrinsics.checkNotNullParameter(str4, "embModelType");
        String str5 = this.TAG;
        Log.d(str5, "registerSpeaker: modulePath=" + str + ", moduleType=" + i + ", embeddingTxt=" + str2 + ", voicePath=" + str3 + ", embModelType=" + str4);
        return NativeLib.Companion.get().extractEmb(str, str2, str3, i, str4, i2, i3);
    }

    public final float similarity(@NotNull float[] fArr, @NotNull float[] fArr2, int i) {
        Intrinsics.checkNotNullParameter(fArr, "data1");
        Intrinsics.checkNotNullParameter(fArr2, "data2");
        Log.d(this.TAG, "similarity");
        float similarity = NativeLib.Companion.get().similarity(fArr, fArr2, i);
        String str = this.TAG;
        Log.d(str, "similarity: ret=" + similarity);
        return similarity;
    }

    public final void spkRecogDelete(long j) {
        Log.d(this.TAG, "spkRecogDelete");
        if (j != 0) {
            NativeLib.Companion.get().destroy(j);
            Log.d(this.TAG, "spkRecogDelete successfully");
        }
    }

    @NotNull
    public final float[] spkRecogGetEmb(long j, @NotNull byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        if (j != 0) {
            return NativeLib.Companion.get().spkRecogExtractEmb(j, bArr, i);
        }
        return new float[]{0.0f};
    }

    public final long spkRecogInit(@NotNull Context context, @NotNull SpeakerVerificationType speakerVerificationType, boolean z) {
        int i;
        int i2;
        String str;
        String str2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(speakerVerificationType, "caseType");
        if (speakerVerificationType == SpeakerVerificationType.SV_Wakeup) {
            if (z) {
                str2 = context.getFilesDir().getAbsolutePath() + this.WAKEUP_MODEL_EN;
            } else {
                str2 = context.getFilesDir().getAbsolutePath() + this.WAKEUP_MODEL;
            }
            i3 = this.WAKEUP_FEAT_DIM;
            i4 = this.WAKEUP_EMBEDDING_SIZE;
        } else if (speakerVerificationType == SpeakerVerificationType.SV_MultipleSpeakerVerify) {
            str2 = context.getFilesDir().getAbsolutePath() + this.UNAWARE_CONTENT_MODEL;
            i3 = this.SPKRECOG_FEAT_DIM;
            i4 = this.SPKRECOG_EMBEDDING_SIZE;
        } else if (speakerVerificationType == SpeakerVerificationType.SV_SSP_EMB) {
            str2 = context.getFilesDir().getAbsolutePath() + this.SSP_EMB_MODEL;
            i3 = this.SSP_FEAT_DIM;
            i4 = this.SSP_EMBEDDING_SIZE;
        } else if (speakerVerificationType == SpeakerVerificationType.SV_SSP_EXTRACT) {
            str2 = context.getFilesDir().getAbsolutePath() + this.SSP_EXTRACT_MODEL;
            i3 = this.SSP_FEAT_DIM;
            i4 = this.SSP_EMBEDDING_SIZE;
        } else {
            str = "";
            i2 = 0;
            i = 0;
            String str3 = context.getFilesDir().getAbsolutePath() + this.SSP_AEC_CFG;
            String str4 = context.getFilesDir().getAbsolutePath() + this.SSP_NNBEAM_MODEL;
            Log.d(this.TAG, "spkRecogInit: modulePath=" + str + ", featDim=" + i2 + ", embeddingSize=" + i + ", aecCfg=" + str3 + ", nnbeamCfg=" + str4);
            long spkRecogInit = NativeLib.Companion.get().spkRecogInit(str, str4, str3, i2, i);
            Log.d(this.TAG, "spkRecogInit successfully");
            return spkRecogInit;
        }
        str = str2;
        i2 = i3;
        i = i4;
        String str32 = context.getFilesDir().getAbsolutePath() + this.SSP_AEC_CFG;
        String str42 = context.getFilesDir().getAbsolutePath() + this.SSP_NNBEAM_MODEL;
        Log.d(this.TAG, "spkRecogInit: modulePath=" + str + ", featDim=" + i2 + ", embeddingSize=" + i + ", aecCfg=" + str32 + ", nnbeamCfg=" + str42);
        long spkRecogInit2 = NativeLib.Companion.get().spkRecogInit(str, str42, str32, i2, i);
        Log.d(this.TAG, "spkRecogInit successfully");
        return spkRecogInit2;
    }

    public final float spkRecogThreshold(long j) {
        Log.d(this.TAG, "wakeupThreshold");
        if (j != 0) {
            return NativeLib.Companion.get().spkRecogThreshold(j);
        }
        return 0.0f;
    }

    public final long spkSSPInit(@NotNull Context context, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        String str3 = str;
        Intrinsics.checkNotNullParameter(str3, "registVoicePath");
        Intrinsics.checkNotNullParameter(str2, "embeddingTxtPath");
        String str4 = context.getFilesDir().getAbsolutePath() + this.SSP_EMB_MODEL;
        int i = this.SSP_FEAT_DIM;
        int i2 = this.SSP_EMBEDDING_SIZE;
        String str5 = context.getFilesDir().getAbsolutePath() + this.SSP_EXTRACT_MODEL;
        String str6 = context.getFilesDir().getAbsolutePath() + this.SSP_NNBEAM_MODEL;
        Log.d(this.TAG, "spkSSPInit: embModulePath=" + str4 + ", featDim=" + i + ", embeddingSize=" + i2 + ", sspModulePath=" + str5);
        NativeLib.Companion companion = NativeLib.Companion;
        int i3 = i2;
        companion.get().extractEmb(str4, str2, str3, 0, "", i3, i);
        this.extractEngine = companion.get().initModel(str5, str6, context.getFilesDir().getAbsolutePath() + this.SSP_AEC_CFG, str2, 0, i3);
        Log.d(this.TAG, "spkSSPInit successfully");
        return this.extractEngine;
    }

    public final void sspExtractFrame(long j, @NotNull byte[] bArr, int i, @NotNull Output output) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        Intrinsics.checkNotNullParameter(output, "output");
        String str = this.TAG;
        Log.d(str, "extractFrame: length = " + i);
        NativeLib.Companion.get().extractFrame(j, bArr, i, output);
    }

    private VoiceManager() {
        this.TAG = "VoiceManager";
        this.WAKEUP_MODEL = "/vprint/campp/embedding_campp_wakeup_dim128.onnx";
        this.WAKEUP_MODEL_EN = "/vprint/campp/embedding_campp_wakeup_dim128_en.onnx";
        this.WAKEUP_EMBEDDING_SIZE = 128;
        this.WAKEUP_FEAT_DIM = 40;
        this.UNAWARE_CONTENT_MODEL = "/vprint/campp/tfmodel_jointrain_blank3_dfsmnCnn_auxNetPreTrain_cat_sigmoid_v1.onnx";
        this.SPKRECOG_EMBEDDING_SIZE = 192;
        this.SPKRECOG_FEAT_DIM = 80;
        this.SSP_EMB_MODEL = "/vprint/module0/embedding.onnx";
        this.SSP_EMBEDDING_SIZE = 64;
        this.SSP_EXTRACT_MODEL = "/vprint/module0/separate.onnx";
        this.SSP_AEC_CFG = "/vprint/module0/res_agc3_drc0_g18.bin";
        this.SSP_NNBEAM_MODEL = "/vprint/module0/nnbeam.onnx";
    }

    public final void deleteModel() {
        Log.d(this.TAG, "deleteModel");
        if (this.extractEngine != 0) {
            NativeLib.Companion.get().destroy(this.extractEngine);
            this.extractEngine = 0;
        }
    }

    public final int registerSpeaker(@NotNull String str, int i, @NotNull String str2, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "targetVoice");
        Intrinsics.checkNotNullParameter(str2, "embModelType");
        String str3 = this.TAG;
        Log.d(str3, "registerSpeaker: targetVoice = " + str + ", moduleType=" + i + ", embModelType=" + str2);
        if (VprintConfig.getEmbeddedModule().length() != 0) {
            return NativeLib.Companion.get().extractEmb(VprintConfig.getEmbeddedModule(), VprintConfig.getEmbeddedText(), str, i, str2, i2, i3);
        }
        Log.e("VoiceManager", "registerSpeaker error!!!! embeddedModule为空");
        return -1;
    }

    public final void sspExtractFrame(long j, @NotNull float[] fArr, int i, @NotNull short[] sArr, int i2, @NotNull Output output) {
        Intrinsics.checkNotNullParameter(fArr, "emb");
        Intrinsics.checkNotNullParameter(sArr, "data");
        Intrinsics.checkNotNullParameter(output, "output");
        String str = this.TAG;
        Log.d(str, "extractFrame: length = " + i2);
        NativeLib.Companion.get().sspExtractFrame(j, fArr, i, sArr, i2, output);
    }

    public final void sspExtractFrame(long j, @NotNull float[] fArr, int i, @NotNull short[] sArr, @NotNull short[] sArr2, int i2, @NotNull Output output) {
        Intrinsics.checkNotNullParameter(fArr, "emb");
        Intrinsics.checkNotNullParameter(sArr, "data");
        short[] sArr3 = sArr2;
        Intrinsics.checkNotNullParameter(sArr3, "data2");
        Output output2 = output;
        Intrinsics.checkNotNullParameter(output2, "output");
        String str = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("extractFrame: length = ");
        int i3 = i2;
        sb.append(i3);
        Log.d(str, sb.toString());
        NativeLib.Companion.get().sspExtractFrame2(j, fArr, i, sArr, sArr3, i3, output2);
    }
}
