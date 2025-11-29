package com.xjmz.ai.vprint;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0013H\u0007R$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR$\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR$\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u0002\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u0002\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\tR$\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001e\u0010\u0002\u001a\u0004\b\u001f\u0010\u0007\"\u0004\b \u0010\t¨\u0006%"}, d2 = {"Lcom/xjmz/ai/vprint/VprintConfig;", "", "()V", "aecCfg", "", "getAecCfg$annotations", "getAecCfg", "()Ljava/lang/String;", "setAecCfg", "(Ljava/lang/String;)V", "embeddedModule", "getEmbeddedModule$annotations", "getEmbeddedModule", "setEmbeddedModule", "embeddedText", "getEmbeddedText$annotations", "getEmbeddedText", "setEmbeddedText", "embeddingSize", "", "getEmbeddingSize$annotations", "getEmbeddingSize", "()I", "setEmbeddingSize", "(I)V", "extractModule", "getExtractModule$annotations", "getExtractModule", "setExtractModule", "nnbeamCfg", "getNnbeamCfg$annotations", "getNnbeamCfg", "setNnbeamCfg", "init", "", "baseDir", "embedding_size", "vprint-sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VprintConfig {
    @NotNull
    public static final VprintConfig INSTANCE = new VprintConfig();
    @NotNull
    private static String aecCfg = "";
    @NotNull
    private static String embeddedModule = "";
    @NotNull
    private static String embeddedText = "";
    private static int embeddingSize = 64;
    @NotNull
    private static String extractModule = "";
    @NotNull
    private static String nnbeamCfg = "";

    private VprintConfig() {
    }

    @NotNull
    public static final String getAecCfg() {
        return aecCfg;
    }

    @JvmStatic
    public static /* synthetic */ void getAecCfg$annotations() {
    }

    @NotNull
    public static final String getEmbeddedModule() {
        return embeddedModule;
    }

    @JvmStatic
    public static /* synthetic */ void getEmbeddedModule$annotations() {
    }

    @NotNull
    public static final String getEmbeddedText() {
        return embeddedText;
    }

    @JvmStatic
    public static /* synthetic */ void getEmbeddedText$annotations() {
    }

    public static final int getEmbeddingSize() {
        return embeddingSize;
    }

    @JvmStatic
    public static /* synthetic */ void getEmbeddingSize$annotations() {
    }

    @NotNull
    public static final String getExtractModule() {
        return extractModule;
    }

    @JvmStatic
    public static /* synthetic */ void getExtractModule$annotations() {
    }

    @NotNull
    public static final String getNnbeamCfg() {
        return nnbeamCfg;
    }

    @JvmStatic
    public static /* synthetic */ void getNnbeamCfg$annotations() {
    }

    @JvmStatic
    public static final void init(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "baseDir");
        embeddedModule = str + "embedding.onnx";
        extractModule = str + "separate.onnx";
        embeddedText = str + "embedding.txt";
        embeddingSize = i;
        aecCfg = str + "res_agc3_drc0_g18.bin";
        nnbeamCfg = str + "nnbeam.onnx";
    }

    public static final void setAecCfg(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        aecCfg = str;
    }

    public static final void setEmbeddedModule(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        embeddedModule = str;
    }

    public static final void setEmbeddedText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        embeddedText = str;
    }

    public static final void setEmbeddingSize(int i) {
        embeddingSize = i;
    }

    public static final void setExtractModule(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        extractModule = str;
    }

    public static final void setNnbeamCfg(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        nnbeamCfg = str;
    }
}
