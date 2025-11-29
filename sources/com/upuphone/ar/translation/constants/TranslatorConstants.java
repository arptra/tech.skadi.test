package com.upuphone.ar.translation.constants;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings;
import androidx.lifecycle.LiveData;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.interconnect.TransInterConnectManager;
import com.upuphone.ar.translation.utils.GsonUtils;
import com.upuphone.ar.translation.utils.LanguageUtils;
import com.upuphone.xr.interconnect.entity.AccountInfo;
import com.upuphone.xr.interconnect.entity.NaviLocationInfo;
import com.upuphone.xr.sapp.context.IGlassInfo;
import com.upuphone.xr.sapp.context.IPhoneCallStatus;
import com.upuphone.xr.sapp.context.SdkContext;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001:\u00066789:;B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\nH\u0007J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\b\u0010\u001b\u001a\u00020\u001aH\u0007J\b\u0010\u001c\u001a\u00020\nH\u0007J\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\b\u0010\u001f\u001a\u00020\nH\u0007J\b\u0010 \u001a\u00020\u0004H\u0007J\n\u0010!\u001a\u0004\u0018\u00010\"H\u0007J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$H\u0007J\b\u0010&\u001a\u00020'H\u0007J\u0014\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0)H\u0002J\b\u0010*\u001a\u00020+H\u0007J\b\u0010,\u001a\u00020+H\u0007J\b\u0010-\u001a\u00020+H\u0007J\b\u0010.\u001a\u00020+H\u0007J\b\u0010/\u001a\u00020+H\u0007J\b\u00100\u001a\u00020+H\u0007J\b\u00101\u001a\u00020+H\u0007J\b\u00102\u001a\u00020+H\u0007J\b\u00103\u001a\u00020+H\u0007J\b\u00104\u001a\u00020+H\u0007J\b\u00105\u001a\u00020+H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/upuphone/ar/translation/constants/TranslatorConstants;", "", "()V", "AIR_LANGUAGE_VERSION_ADAPTER", "", "DELETE_TRANS_RECORD", "NOTIFY_TRANS_RECORDS", "RECORD_DIALOGUE_RUNNING", "RECORD_SIMUL_RUNNING", "SOCKET_ASR_APP_NAME", "", "SYSTEM_TIME_CHANGED", "TAG", "TAG_PREFIX", "TRANSFER_TRANS_RECORD", "TRANSLATION_APP_VERSION_CODE", "TRANSLATION_RECORD_ITEM_ID", "TRANSLATION_SERVICE_ACTION", "TRANSLATION_SERVICE_CLASS", "TRANS_SOCKET_CLOSED", "UPDATE_TRANS_RECORD", "getAccountId", "getAccountInfo", "Lcom/upuphone/xr/interconnect/entity/AccountInfo;", "getAndroidId", "context", "Landroid/content/Context;", "getContext", "getDefaultLanguage", "getGlassInfo", "Lcom/upuphone/xr/sapp/context/IGlassInfo;", "getGlassLanguage", "getGlassVersion", "getLocationInfo", "Lcom/upuphone/xr/interconnect/entity/NaviLocationInfo;", "getPhoneCallStatus", "Landroidx/lifecycle/LiveData;", "Lcom/upuphone/xr/sapp/context/IPhoneCallStatus;", "getRoleVprint", "", "glassLangMap", "", "isAir", "", "isAirOldLanguage", "isAirOldLanguageVersion", "isAirPro", "isAssistantRunning", "isConcept", "isIntlVersion", "isMicroSoftAsr", "isMono", "isSelfPhoneThird", "isStar", "BroadcastAudioType", "CallAudioContent", "GlassModel", "IflytekCallbackMark", "SocketChannel", "TransRecordType", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TranslatorConstants {
    private static final int AIR_LANGUAGE_VERSION_ADAPTER = 2;
    public static final int DELETE_TRANS_RECORD = 1000;
    @NotNull
    public static final TranslatorConstants INSTANCE = new TranslatorConstants();
    public static final int NOTIFY_TRANS_RECORDS = 1001;
    public static final int RECORD_DIALOGUE_RUNNING = 1003;
    public static final int RECORD_SIMUL_RUNNING = 1004;
    @NotNull
    public static final String SOCKET_ASR_APP_NAME = "com.xjmz.ar.translator";
    public static final int SYSTEM_TIME_CHANGED = 1006;
    @NotNull
    private static final String TAG = "TranslatorConstants";
    @NotNull
    public static final String TAG_PREFIX = "TrsP-";
    @NotNull
    public static final String TRANSFER_TRANS_RECORD = "transfer_trans_record";
    public static final int TRANSLATION_APP_VERSION_CODE = 1;
    @NotNull
    public static final String TRANSLATION_RECORD_ITEM_ID = "trans_record_item_id";
    @NotNull
    public static final String TRANSLATION_SERVICE_ACTION = "com.upuphone.ar.translation.phone.action";
    @NotNull
    public static final String TRANSLATION_SERVICE_CLASS = "com.upuphone.ar.translation.phone.TranslationService";
    public static final int TRANS_SOCKET_CLOSED = 1002;
    public static final int UPDATE_TRANS_RECORD = 1005;

    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.CLASS, AnnotationTarget.VALUE_PARAMETER})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/upuphone/ar/translation/constants/TranslatorConstants$BroadcastAudioType;", "", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface BroadcastAudioType {
        @NotNull
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final int STANDARD_FEMALE = 2;
        public static final int STANDARD_MALE = 1;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/ar/translation/constants/TranslatorConstants$BroadcastAudioType$Companion;", "", "()V", "STANDARD_FEMALE", "", "STANDARD_MALE", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int STANDARD_FEMALE = 2;
            public static final int STANDARD_MALE = 1;

            private Companion() {
            }
        }
    }

    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.CLASS, AnnotationTarget.VALUE_PARAMETER})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/upuphone/ar/translation/constants/TranslatorConstants$CallAudioContent;", "", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface CallAudioContent {
        @NotNull
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final int ORIGINAL = 2;
        public static final int TRANSLATED = 1;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/ar/translation/constants/TranslatorConstants$CallAudioContent$Companion;", "", "()V", "ORIGINAL", "", "TRANSLATED", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int ORIGINAL = 2;
            public static final int TRANSLATED = 1;

            private Companion() {
            }
        }
    }

    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.CLASS, AnnotationTarget.VALUE_PARAMETER})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/upuphone/ar/translation/constants/TranslatorConstants$GlassModel;", "", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface GlassModel {
        @NotNull
        public static final Companion Companion = Companion.$$INSTANCE;
        @NotNull
        public static final String MODEL_ID_AIR = "1003";
        @NotNull
        public static final String MODEL_ID_AIR_PRO = "1004";
        @NotNull
        public static final String MODEL_ID_STAR = "1002";
        @NotNull
        public static final String MODEL_ID_STAR_CONCEPT = "1001";

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/upuphone/ar/translation/constants/TranslatorConstants$GlassModel$Companion;", "", "()V", "MODEL_ID_AIR", "", "MODEL_ID_AIR_PRO", "MODEL_ID_STAR", "MODEL_ID_STAR_CONCEPT", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            @NotNull
            public static final String MODEL_ID_AIR = "1003";
            @NotNull
            public static final String MODEL_ID_AIR_PRO = "1004";
            @NotNull
            public static final String MODEL_ID_STAR = "1002";
            @NotNull
            public static final String MODEL_ID_STAR_CONCEPT = "1001";

            private Companion() {
            }
        }
    }

    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.CLASS, AnnotationTarget.VALUE_PARAMETER})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/upuphone/ar/translation/constants/TranslatorConstants$IflytekCallbackMark;", "", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface IflytekCallbackMark {
        @NotNull
        public static final Companion Companion = Companion.$$INSTANCE;
        @NotNull
        public static final String TRANSLATE_INIT_CHANNEL = "PhoneChannelInitHandlerImpl";
        @NotNull
        public static final String TRANSLATE_MANAGER_PHONE = "translate_manager_phone";

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/ar/translation/constants/TranslatorConstants$IflytekCallbackMark$Companion;", "", "()V", "TRANSLATE_INIT_CHANNEL", "", "TRANSLATE_MANAGER_PHONE", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            @NotNull
            public static final String TRANSLATE_INIT_CHANNEL = "PhoneChannelInitHandlerImpl";
            @NotNull
            public static final String TRANSLATE_MANAGER_PHONE = "translate_manager_phone";

            private Companion() {
            }
        }
    }

    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.CLASS, AnnotationTarget.VALUE_PARAMETER})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/upuphone/ar/translation/constants/TranslatorConstants$SocketChannel;", "", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface SocketChannel {
        @NotNull
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final int INVALID = -1;
        public static final int PROXIMAL = 2;
        public static final int REMOTE = 1;
        public static final int REMOTE_PROXIMAL = 3;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/upuphone/ar/translation/constants/TranslatorConstants$SocketChannel$Companion;", "", "()V", "INVALID", "", "PROXIMAL", "REMOTE", "REMOTE_PROXIMAL", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int INVALID = -1;
            public static final int PROXIMAL = 2;
            public static final int REMOTE = 1;
            public static final int REMOTE_PROXIMAL = 3;

            private Companion() {
            }
        }
    }

    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.CLASS, AnnotationTarget.VALUE_PARAMETER})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/upuphone/ar/translation/constants/TranslatorConstants$TransRecordType;", "", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface TransRecordType {
        @NotNull
        public static final String ALL_RECORDS = "all_records";
        @NotNull
        public static final Companion Companion = Companion.$$INSTANCE;
        @NotNull
        public static final String DIALOG_TRANS_RECORDS = "dialog_trans_records";
        @NotNull
        public static final String SIMUL_TRANS_RECORDS = "simul_trans_records";
        @NotNull
        public static final String TRANSCRIBE_RECORDS = "transcribe_records";

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/upuphone/ar/translation/constants/TranslatorConstants$TransRecordType$Companion;", "", "()V", "ALL_RECORDS", "", "DIALOG_TRANS_RECORDS", "SIMUL_TRANS_RECORDS", "TRANSCRIBE_RECORDS", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            @NotNull
            public static final String ALL_RECORDS = "all_records";
            @NotNull
            public static final String DIALOG_TRANS_RECORDS = "dialog_trans_records";
            @NotNull
            public static final String SIMUL_TRANS_RECORDS = "simul_trans_records";
            @NotNull
            public static final String TRANSCRIBE_RECORDS = "transcribe_records";

            private Companion() {
            }
        }
    }

    private TranslatorConstants() {
    }

    @JvmStatic
    @NotNull
    public static final String getAccountId() {
        AccountInfo accountInfo = getAccountInfo();
        String str = accountInfo != null ? accountInfo.id : null;
        return str == null ? "" : str;
    }

    @JvmStatic
    @Nullable
    public static final AccountInfo getAccountInfo() {
        String a2 = SdkContext.f6675a.b().a();
        if (!StringsKt.isBlank(a2)) {
            return (AccountInfo) GsonUtils.a(a2, AccountInfo.class);
        }
        LogExt.j("getAccountInfo accountInfo is null", TAG);
        return null;
    }

    @JvmStatic
    @NotNull
    @SuppressLint({"HardwareIds"})
    public static final String getAndroidId(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @JvmStatic
    @NotNull
    public static final Context getContext() {
        return SdkContext.f6675a.c().getContext();
    }

    @JvmStatic
    @NotNull
    public static final String getDefaultLanguage() {
        String str = isIntlVersion() ? "cnen" : "cn";
        Map<String, String> glassLangMap = INSTANCE.glassLangMap();
        if (glassLangMap.isEmpty()) {
            return str;
        }
        String glassLanguage = getGlassLanguage();
        for (Map.Entry next : glassLangMap.entrySet()) {
            String str2 = (String) next.getValue();
            if (Intrinsics.areEqual((Object) glassLanguage, (Object) (String) next.getKey())) {
                return LanguageUtils.f6366a.d().contains(str2) ? str2 : str;
            }
        }
        return str;
    }

    @JvmStatic
    @NotNull
    public static final String getGlassLanguage() {
        return SdkContext.f6675a.e().d();
    }

    @JvmStatic
    public static final int getGlassVersion() {
        return TransInterConnectManager.y.a().o();
    }

    @JvmStatic
    @Nullable
    public static final NaviLocationInfo getLocationInfo() {
        return TransInterConnectManager.y.a().p();
    }

    @JvmStatic
    @NotNull
    public static final LiveData<IPhoneCallStatus> getPhoneCallStatus() {
        return SdkContext.f6675a.c().h();
    }

    @JvmStatic
    @NotNull
    public static final float[] getRoleVprint() {
        float[] fArr = new float[128];
        for (int i = 0; i < 128; i++) {
            fArr[i] = 0.0f;
        }
        return fArr;
    }

    private final Map<String, String> glassLangMap() {
        return MapsKt.hashMapOf(TuplesKt.to("zh-CN", "cn"), TuplesKt.to("en-US", "cnen"), TuplesKt.to("ms-MY", "ms"), TuplesKt.to("th-TH", "th"), TuplesKt.to("id-ID", "id"), TuplesKt.to("fr-FR", "fr"), TuplesKt.to("de-DE", "de"), TuplesKt.to("it-IT", "it"), TuplesKt.to("tr-TR", "tr"), TuplesKt.to("ko-KR", "ko"), TuplesKt.to("ja-JP", "ja"), TuplesKt.to("ar-SA", "ar"));
    }

    @JvmStatic
    public static final boolean isAir() {
        return TransInterConnectManager.y.a().s() || SdkContext.f6675a.e().isAir();
    }

    @JvmStatic
    public static final boolean isAirOldLanguage() {
        return isAir() && isAirOldLanguageVersion();
    }

    @JvmStatic
    public static final boolean isAirOldLanguageVersion() {
        int glassVersion = getGlassVersion();
        return glassVersion != 0 && glassVersion <= 2;
    }

    @JvmStatic
    public static final boolean isAirPro() {
        return TransInterConnectManager.y.a().t() || SdkContext.f6675a.e().isAirPro();
    }

    @JvmStatic
    public static final boolean isAssistantRunning() {
        return SdkContext.f6675a.c().d();
    }

    @JvmStatic
    public static final boolean isConcept() {
        return TransInterConnectManager.y.a().u();
    }

    @JvmStatic
    public static final boolean isIntlVersion() {
        return SdkContext.f6675a.c().e();
    }

    @JvmStatic
    public static final boolean isMicroSoftAsr() {
        return isIntlVersion() || isAirPro();
    }

    @JvmStatic
    public static final boolean isMono() {
        return isAir() || isAirPro();
    }

    @JvmStatic
    public static final boolean isSelfPhoneThird() {
        return TransInterConnectManager.y.a().x() || SdkContext.f6675a.c().f();
    }

    @JvmStatic
    public static final boolean isStar() {
        return TransInterConnectManager.y.a().y();
    }

    @Nullable
    public final IGlassInfo getGlassInfo() {
        return SdkContext.f6675a.e().a();
    }
}
