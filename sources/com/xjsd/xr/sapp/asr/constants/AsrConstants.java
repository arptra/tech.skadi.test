package com.xjsd.xr.sapp.asr.constants;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b%\bÆ\u0002\u0018\u00002\u00020\u0001:\u0013!\"#$%&'()*+,-./0123B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0004H\u0000¢\u0006\u0002\b R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/xjsd/xr/sapp/asr/constants/AsrConstants;", "", "()V", "ASR_GOOGLE", "", "ASR_MICROSOFT", "ASR_RESULT_SUCCESS", "ASR_TTS_SUCCESS", "AUDIO_AMR_WB", "AUDIO_OPUS", "AUDIO_PCM", "AUDIO_WAV", "CANCEL_AUDIO", "CANCEL_AUDIO_SUCCESS", "DUAL_CHANNEL", "", "END_AUDIO", "INVALID_CHANNEL", "PROXIMAL_CHANNEL", "REMOTE_CHANNEL", "SYNC_AUDIO_INFO", "SYNC_AUDIO_INFO_SUCCESS", "TRANSLATION_RESULT_SUCCESS", "WEB_DOM", "WEB_DOM_DEV", "WEB_DOM_FAT", "WEB_DOM_UAT", "WEB_INTL", "WEB_INTL_DEV", "WEB_INTL_UAT", "getAsrUrl", "serverType", "getAsrUrl$asr_release", "AccessChannel", "AsrFuncType", "AsrRole", "AsrSupplier", "AudioType", "DstLangType", "LanguageType", "SrcLangType", "TTSAudioFormat", "TTSTimbre", "TtsGender", "TtsLanguage", "TtsReturnFormat", "TtsTextType", "UnifiedFunctionType", "UnifiedServiceResponseType", "UnifiedServiceType", "WebRequestEvent", "WebServer", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AsrConstants {
    @NotNull
    public static final String ASR_GOOGLE = "google";
    @NotNull
    public static final String ASR_MICROSOFT = "microsoft";
    @NotNull
    public static final String ASR_RESULT_SUCCESS = "asr_result_success";
    @NotNull
    public static final String ASR_TTS_SUCCESS = "asr_tts_success";
    @NotNull
    public static final String AUDIO_AMR_WB = "amr_wb";
    @NotNull
    public static final String AUDIO_OPUS = "opus";
    @NotNull
    public static final String AUDIO_PCM = "pcm";
    @NotNull
    public static final String AUDIO_WAV = "wav";
    @NotNull
    public static final String CANCEL_AUDIO = "cancel_audio";
    @NotNull
    public static final String CANCEL_AUDIO_SUCCESS = "cancel_audio_success";
    public static final int DUAL_CHANNEL = 1;
    @NotNull
    public static final String END_AUDIO = "end_audio";
    @NotNull
    public static final AsrConstants INSTANCE = new AsrConstants();
    public static final int INVALID_CHANNEL = 0;
    public static final int PROXIMAL_CHANNEL = 3;
    public static final int REMOTE_CHANNEL = 2;
    @NotNull
    public static final String SYNC_AUDIO_INFO = "sync_audio_info";
    @NotNull
    public static final String SYNC_AUDIO_INFO_SUCCESS = "sync_audio_info_success";
    @NotNull
    public static final String TRANSLATION_RESULT_SUCCESS = "translation_result_success";
    @NotNull
    public static final String WEB_DOM = "domestic";
    @NotNull
    public static final String WEB_DOM_DEV = "domestic_dev";
    @NotNull
    public static final String WEB_DOM_FAT = "domestic_fat";
    @NotNull
    public static final String WEB_DOM_UAT = "domestic_uat";
    @NotNull
    public static final String WEB_INTL = "international";
    @NotNull
    public static final String WEB_INTL_DEV = "international_dev";
    @NotNull
    public static final String WEB_INTL_UAT = "international_uat";

    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.PROPERTY, AnnotationTarget.FUNCTION, AnnotationTarget.TYPE})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/xjsd/xr/sapp/asr/constants/AsrConstants$AccessChannel;", "", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface AccessChannel {
    }

    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.VALUE_PARAMETER})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/xjsd/xr/sapp/asr/constants/AsrConstants$AsrFuncType;", "", "Companion", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface AsrFuncType {
        @NotNull
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final int DIALOGUE_TRANS = 1;
        public static final int NOT_DIALOGUE_TRANS = 0;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/xjsd/xr/sapp/asr/constants/AsrConstants$AsrFuncType$Companion;", "", "()V", "DIALOGUE_TRANS", "", "NOT_DIALOGUE_TRANS", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int DIALOGUE_TRANS = 1;
            public static final int NOT_DIALOGUE_TRANS = 0;

            private Companion() {
            }
        }
    }

    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.VALUE_PARAMETER})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/xjsd/xr/sapp/asr/constants/AsrConstants$AsrRole;", "", "Companion", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface AsrRole {
        @NotNull
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final int PROXIMAL = 0;
        public static final int REMOTE = 1;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/xjsd/xr/sapp/asr/constants/AsrConstants$AsrRole$Companion;", "", "()V", "PROXIMAL", "", "REMOTE", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int PROXIMAL = 0;
            public static final int REMOTE = 1;

            private Companion() {
            }
        }
    }

    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.VALUE_PARAMETER})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/xjsd/xr/sapp/asr/constants/AsrConstants$AsrSupplier;", "", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface AsrSupplier {
    }

    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.VALUE_PARAMETER})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/xjsd/xr/sapp/asr/constants/AsrConstants$AudioType;", "", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface AudioType {
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/xjsd/xr/sapp/asr/constants/AsrConstants$DstLangType;", "", "()V", "AR", "", "CN", "DE", "EN", "ES", "FR", "ID", "IT", "JA", "KO", "MS", "RU", "TH", "TR", "VI", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DstLangType {
        @NotNull
        public static final String AR = "ar";
        @NotNull
        public static final String CN = "zh-CN";
        @NotNull
        public static final String DE = "de";
        @NotNull
        public static final String EN = "en";
        @NotNull
        public static final String ES = "es";
        @NotNull
        public static final String FR = "fr";
        @NotNull
        public static final String ID = "id";
        @NotNull
        public static final DstLangType INSTANCE = new DstLangType();
        @NotNull
        public static final String IT = "it";
        @NotNull
        public static final String JA = "ja";
        @NotNull
        public static final String KO = "ko";
        @NotNull
        public static final String MS = "ms";
        @NotNull
        public static final String RU = "ru";
        @NotNull
        public static final String TH = "th";
        @NotNull
        public static final String TR = "tr";
        @NotNull
        public static final String VI = "vi";

        private DstLangType() {
        }
    }

    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.VALUE_PARAMETER})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/xjsd/xr/sapp/asr/constants/AsrConstants$LanguageType;", "", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface LanguageType {
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/xjsd/xr/sapp/asr/constants/AsrConstants$SrcLangType;", "", "()V", "AR", "", "CN", "DE", "EN", "ES", "FR", "ID", "IT", "JA", "KO", "MS", "RU", "TH", "TR", "VI", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SrcLangType {
        @NotNull
        public static final String AR = "ar-SA";
        @NotNull
        public static final String CN = "cmn-Hans-CN";
        @NotNull
        public static final String DE = "de-DE";
        @NotNull
        public static final String EN = "en-GB";
        @NotNull
        public static final String ES = "es-ES";
        @NotNull
        public static final String FR = "fr-FR";
        @NotNull
        public static final String ID = "id-ID";
        @NotNull
        public static final SrcLangType INSTANCE = new SrcLangType();
        @NotNull
        public static final String IT = "it-IT";
        @NotNull
        public static final String JA = "ja-JP";
        @NotNull
        public static final String KO = "ko-KR";
        @NotNull
        public static final String MS = "ms-MY";
        @NotNull
        public static final String RU = "ru-RU";
        @NotNull
        public static final String TH = "th-TH";
        @NotNull
        public static final String TR = "tr-TR";
        @NotNull
        public static final String VI = "vi-VN";

        private SrcLangType() {
        }
    }

    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.VALUE_PARAMETER})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/xjsd/xr/sapp/asr/constants/AsrConstants$TTSAudioFormat;", "", "Companion", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface TTSAudioFormat {
        @NotNull
        public static final Companion Companion = Companion.$$INSTANCE;
        @NotNull
        public static final String FLAC = "flac";
        @NotNull
        public static final String MP3 = "mp3";
        @NotNull
        public static final String OGG_OPUS = "ogg_opus";
        @NotNull
        public static final String PCM = "pcm";
        @NotNull
        public static final String WAV = "wav";

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/xjsd/xr/sapp/asr/constants/AsrConstants$TTSAudioFormat$Companion;", "", "()V", "FLAC", "", "MP3", "OGG_OPUS", "PCM", "WAV", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            @NotNull
            public static final String FLAC = "flac";
            @NotNull
            public static final String MP3 = "mp3";
            @NotNull
            public static final String OGG_OPUS = "ogg_opus";
            @NotNull
            public static final String PCM = "pcm";
            @NotNull
            public static final String WAV = "wav";

            private Companion() {
            }
        }
    }

    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.VALUE_PARAMETER})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/xjsd/xr/sapp/asr/constants/AsrConstants$TTSTimbre;", "", "Companion", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface TTSTimbre {
        @NotNull
        public static final String BYTE_DANCE_CANCAN = "BV700_streaming";
        @NotNull
        public static final String BYTE_DANCE_CHINESE_FEMALE = "BV001_streaming";
        @NotNull
        public static final String BYTE_DANCE_CHINESE_MALE = "BV002_streaming";
        @NotNull
        public static final String BYTE_DANCE_JACKSON = "BV504_streaming";
        @NotNull
        public static final String BYTE_DANCE_JAPANESE_MALE = "BV524_streaming";
        @NotNull
        public static final String CUTE_BOY = "cute-boy";
        @NotNull
        public static final Companion Companion = Companion.$$INSTANCE;
        @NotNull
        public static final String FEMALE_TM = "female-tianmei";
        @NotNull
        public static final String FEMALE_YJ = "female-yujie";
        @NotNull
        public static final String GOOGLE = "google";
        @NotNull
        public static final String YOUNG_MAN = "male-qn-qingse";

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/xjsd/xr/sapp/asr/constants/AsrConstants$TTSTimbre$Companion;", "", "()V", "BYTE_DANCE_CANCAN", "", "BYTE_DANCE_CHINESE_FEMALE", "BYTE_DANCE_CHINESE_MALE", "BYTE_DANCE_JACKSON", "BYTE_DANCE_JAPANESE_MALE", "CUTE_BOY", "FEMALE_TM", "FEMALE_YJ", "GOOGLE", "YOUNG_MAN", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            @NotNull
            public static final String BYTE_DANCE_CANCAN = "BV700_streaming";
            @NotNull
            public static final String BYTE_DANCE_CHINESE_FEMALE = "BV001_streaming";
            @NotNull
            public static final String BYTE_DANCE_CHINESE_MALE = "BV002_streaming";
            @NotNull
            public static final String BYTE_DANCE_JACKSON = "BV504_streaming";
            @NotNull
            public static final String BYTE_DANCE_JAPANESE_MALE = "BV524_streaming";
            @NotNull
            public static final String CUTE_BOY = "cute-boy";
            @NotNull
            public static final String FEMALE_TM = "female-tianmei";
            @NotNull
            public static final String FEMALE_YJ = "female-yujie";
            @NotNull
            public static final String GOOGLE = "google";
            @NotNull
            public static final String YOUNG_MAN = "male-qn-qingse";

            private Companion() {
            }
        }
    }

    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.VALUE_PARAMETER})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/xjsd/xr/sapp/asr/constants/AsrConstants$TtsGender;", "", "Companion", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface TtsGender {
        @NotNull
        public static final Companion Companion = Companion.$$INSTANCE;
        @NotNull
        public static final String FEMALE = "female";
        @NotNull
        public static final String MALE = "male";

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/xjsd/xr/sapp/asr/constants/AsrConstants$TtsGender$Companion;", "", "()V", "FEMALE", "", "MALE", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            @NotNull
            public static final String FEMALE = "female";
            @NotNull
            public static final String MALE = "male";

            private Companion() {
            }
        }
    }

    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.VALUE_PARAMETER})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/xjsd/xr/sapp/asr/constants/AsrConstants$TtsLanguage;", "", "Companion", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface TtsLanguage {
        @NotNull
        public static final String AR = "ar";
        @NotNull
        public static final String CN = "cn";
        @NotNull
        public static final Companion Companion = Companion.$$INSTANCE;
        @NotNull
        public static final String DE = "de";
        @NotNull
        public static final String EN = "en";
        @NotNull
        public static final String ESMX = "esmx";
        @NotNull
        public static final String FIL = "fil";
        @NotNull
        public static final String FR = "fr";
        @NotNull
        public static final String ID = "id";
        @NotNull
        public static final String IT = "it";
        @NotNull
        public static final String JA = "ja";
        @NotNull
        public static final String KO = "ko";
        @NotNull
        public static final String MS = "ms";
        @NotNull
        public static final String PTBR = "ptbr";
        @NotNull
        public static final String RU = "ru";
        @NotNull
        public static final String TH = "th";
        @NotNull
        public static final String VI = "vi";

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/xjsd/xr/sapp/asr/constants/AsrConstants$TtsLanguage$Companion;", "", "()V", "AR", "", "CN", "DE", "EN", "ESMX", "FIL", "FR", "ID", "IT", "JA", "KO", "MS", "PTBR", "RU", "TH", "VI", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            @NotNull
            public static final String AR = "ar";
            @NotNull
            public static final String CN = "cn";
            @NotNull
            public static final String DE = "de";
            @NotNull
            public static final String EN = "en";
            @NotNull
            public static final String ESMX = "esmx";
            @NotNull
            public static final String FIL = "fil";
            @NotNull
            public static final String FR = "fr";
            @NotNull
            public static final String ID = "id";
            @NotNull
            public static final String IT = "it";
            @NotNull
            public static final String JA = "ja";
            @NotNull
            public static final String KO = "ko";
            @NotNull
            public static final String MS = "ms";
            @NotNull
            public static final String PTBR = "ptbr";
            @NotNull
            public static final String RU = "ru";
            @NotNull
            public static final String TH = "th";
            @NotNull
            public static final String VI = "vi";

            private Companion() {
            }
        }
    }

    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.VALUE_PARAMETER})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/xjsd/xr/sapp/asr/constants/AsrConstants$TtsReturnFormat;", "", "Companion", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface TtsReturnFormat {
        public static final int BYTE_ARR = 1;
        @NotNull
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final int HEX_STR = 2;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/xjsd/xr/sapp/asr/constants/AsrConstants$TtsReturnFormat$Companion;", "", "()V", "BYTE_ARR", "", "HEX_STR", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int BYTE_ARR = 1;
            public static final int HEX_STR = 2;

            private Companion() {
            }
        }
    }

    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.VALUE_PARAMETER})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/xjsd/xr/sapp/asr/constants/AsrConstants$TtsTextType;", "", "Companion", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface TtsTextType {
        @NotNull
        public static final Companion Companion = Companion.$$INSTANCE;
        @NotNull
        public static final String PLAIN = "plain";
        @NotNull
        public static final String SSML = "ssml";

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/xjsd/xr/sapp/asr/constants/AsrConstants$TtsTextType$Companion;", "", "()V", "PLAIN", "", "SSML", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            @NotNull
            public static final String PLAIN = "plain";
            @NotNull
            public static final String SSML = "ssml";

            private Companion() {
            }
        }
    }

    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.VALUE_PARAMETER})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/xjsd/xr/sapp/asr/constants/AsrConstants$UnifiedFunctionType;", "", "Companion", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface UnifiedFunctionType {
        public static final int ASR = 3;
        @NotNull
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final int SHORT_ASR = 1;
        public static final int SMART_EXTRACTION = 4;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/xjsd/xr/sapp/asr/constants/AsrConstants$UnifiedFunctionType$Companion;", "", "()V", "ASR", "", "SHORT_ASR", "SMART_EXTRACTION", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int ASR = 3;
            public static final int SHORT_ASR = 1;
            public static final int SMART_EXTRACTION = 4;

            private Companion() {
            }
        }
    }

    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.VALUE_PARAMETER})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/xjsd/xr/sapp/asr/constants/AsrConstants$UnifiedServiceResponseType;", "", "Companion", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface UnifiedServiceResponseType {
        @NotNull
        public static final String ASR_RESULT = "asr_result";
        @NotNull
        public static final Companion Companion = Companion.$$INSTANCE;
        @NotNull
        public static final String INFINITE_ASR_RESULT = "infinite-asr-result";
        @NotNull
        public static final String SENSITIVE_REQUEST = "sensitive_request";
        @NotNull
        public static final String SENSITIVE_RESULT = "sensitive_result";
        @NotNull
        public static final String SUMMARY_RESULT = "llm_summary_result";
        @NotNull
        public static final String TODO_RESULT = "llm_todos_result";

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/xjsd/xr/sapp/asr/constants/AsrConstants$UnifiedServiceResponseType$Companion;", "", "()V", "ASR_RESULT", "", "INFINITE_ASR_RESULT", "SENSITIVE_REQUEST", "SENSITIVE_RESULT", "SUMMARY_RESULT", "TODO_RESULT", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            @NotNull
            public static final String ASR_RESULT = "asr_result";
            @NotNull
            public static final String INFINITE_ASR_RESULT = "infinite-asr-result";
            @NotNull
            public static final String SENSITIVE_REQUEST = "sensitive_request";
            @NotNull
            public static final String SENSITIVE_RESULT = "sensitive_result";
            @NotNull
            public static final String SUMMARY_RESULT = "llm_summary_result";
            @NotNull
            public static final String TODO_RESULT = "llm_todos_result";

            private Companion() {
            }
        }
    }

    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.VALUE_PARAMETER})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/xjsd/xr/sapp/asr/constants/AsrConstants$UnifiedServiceType;", "", "Companion", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface UnifiedServiceType {
        @NotNull
        public static final String ASR = "asr";
        @NotNull
        public static final Companion Companion = Companion.$$INSTANCE;
        @NotNull
        public static final String SUMMARY = "summary";
        @NotNull
        public static final String TODOS = "todos";
        @NotNull
        public static final String TTS = "tts";

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/xjsd/xr/sapp/asr/constants/AsrConstants$UnifiedServiceType$Companion;", "", "()V", "ASR", "", "SUMMARY", "TODOS", "TTS", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            @NotNull
            public static final String ASR = "asr";
            @NotNull
            public static final String SUMMARY = "summary";
            @NotNull
            public static final String TODOS = "todos";
            @NotNull
            public static final String TTS = "tts";

            private Companion() {
            }
        }
    }

    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.VALUE_PARAMETER})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/xjsd/xr/sapp/asr/constants/AsrConstants$WebRequestEvent;", "", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface WebRequestEvent {
    }

    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.VALUE_PARAMETER})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/xjsd/xr/sapp/asr/constants/AsrConstants$WebServer;", "", "asr_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface WebServer {
    }

    private AsrConstants() {
    }

    @NotNull
    public final String getAsrUrl$asr_release(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "serverType");
        switch (str.hashCode()) {
            case -1205261596:
                return !str.equals(WEB_INTL_DEV) ? "wss://km.myvu.cn/asr-api/ws" : "wss://kmsa-dev.myvu.cn/asr-api/ws";
            case -1205245385:
                return !str.equals(WEB_INTL_UAT) ? "wss://km.myvu.cn/asr-api/ws" : "wss://kmsa-uat.myvu.cn/asr-api/ws";
            case 1133429022:
                boolean equals = str.equals(WEB_DOM);
                return "wss://km.myvu.cn/asr-api/ws";
            case 1847178612:
                return !str.equals(WEB_DOM_DEV) ? "wss://km.myvu.cn/asr-api/ws" : "wss://km-dev.myvu.cn/asr-api/ws";
            case 1847180408:
                return !str.equals(WEB_DOM_FAT) ? "wss://km.myvu.cn/asr-api/ws" : "wss://km-fat.myvu.cn/asr-api/ws";
            case 1847194823:
                return !str.equals(WEB_DOM_UAT) ? "wss://km.myvu.cn/asr-api/ws" : "wss://km-uat.myvu.cn/asr-api/ws";
            case 2064805518:
                return !str.equals(WEB_INTL) ? "wss://km.myvu.cn/asr-api/ws" : "wss://kmsa.myvu.cn/asr-api/ws";
            default:
                return "wss://km.myvu.cn/asr-api/ws";
        }
    }
}
