package com.upuphone.ar.translation.statemachine.handler;

import android.content.Context;
import com.upuphone.ar.translation.constants.GlassVersionHelper;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.iflytek.entity.TransConfig;
import com.upuphone.ar.translation.iflytek.ext.StringExtKt;
import com.upuphone.ar.translation.interconnect.entity.InterConnectDevice;
import com.upuphone.ar.translation.interconnect.entity.StartTrans;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.helper.InterConnectHelper;
import com.upuphone.ar.translation.utils.LanguageUtils;
import com.upuphone.ar.translation.utils.PreferencesUtils;
import com.xjsd.xr.sapp.asr.constants.AsrConstants;
import com.xjsd.xr.sapp.asr.dao.AsrRequestConfig;
import com.xjsd.xr.sapp.asr.dao.TtsConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\rJ-\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J7\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0018\u001a\u00020\u0013¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010!\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J'\u0010%\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u001fH\u0002¢\u0006\u0004\b%\u0010&J'\u0010)\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u001fH\u0002¢\u0006\u0004\b)\u0010&J\u0017\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b.\u0010-J\u0017\u0010/\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b/\u00100J\u001f\u00101\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u001fH\u0002¢\u0006\u0004\b1\u00102J\u001f\u00103\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u001fH\u0002¢\u0006\u0004\b3\u00102JS\u00109\u001a\u0004\u0018\u0001082\b\b\u0002\u00104\u001a\u00020\u00132\b\b\u0002\u0010\u0018\u001a\u00020\u00132\b\b\u0002\u00105\u001a\u00020\u001f2\b\b\u0003\u00106\u001a\u00020*2\b\b\u0002\u00107\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b9\u0010:J'\u0010;\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u0013H\u0002¢\u0006\u0004\b;\u0010<J\u0017\u0010=\u001a\u00020*2\u0006\u00105\u001a\u00020\u001fH\u0003¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020*2\u0006\u00105\u001a\u00020\u001fH\u0002¢\u0006\u0004\b?\u0010>J\u001f\u0010A\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\u001f2\u0006\u0010@\u001a\u00020*H\u0002¢\u0006\u0004\bA\u0010BJ\u0017\u0010C\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\u001fH\u0002¢\u0006\u0004\bC\u0010D¨\u0006E"}, d2 = {"Lcom/upuphone/ar/translation/statemachine/handler/AsrServerChannelUtils;", "", "<init>", "()V", "Lcom/upuphone/ar/translation/interconnect/entity/StartTrans;", "startTrans", "t", "(Lcom/upuphone/ar/translation/interconnect/entity/StartTrans;)Lcom/upuphone/ar/translation/interconnect/entity/StartTrans;", "u", "b", "()Lcom/upuphone/ar/translation/interconnect/entity/StartTrans;", "Lcom/upuphone/ar/translation/iflytek/entity/TransConfig;", "r", "(Lcom/upuphone/ar/translation/interconnect/entity/StartTrans;)Lcom/upuphone/ar/translation/iflytek/entity/TransConfig;", "p", "Landroid/content/Context;", "context", "Lcom/xjsd/xr/sapp/asr/dao/AsrRequestConfig$RecognizeData;", "recognizeData", "", "isTelephoneTrans", "Lcom/xjsd/xr/sapp/asr/dao/AsrRequestConfig;", "s", "(Landroid/content/Context;Lcom/upuphone/ar/translation/interconnect/entity/StartTrans;Lcom/xjsd/xr/sapp/asr/dao/AsrRequestConfig$RecognizeData;Z)Lcom/xjsd/xr/sapp/asr/dao/AsrRequestConfig;", "isInitTts", "q", "(Landroid/content/Context;Lcom/upuphone/ar/translation/interconnect/entity/StartTrans;Lcom/xjsd/xr/sapp/asr/dao/AsrRequestConfig$RecognizeData;ZZ)Lcom/xjsd/xr/sapp/asr/dao/AsrRequestConfig;", "k", "(Landroid/content/Context;)Lcom/xjsd/xr/sapp/asr/dao/AsrRequestConfig$RecognizeData;", "o", "(Lcom/upuphone/ar/translation/interconnect/entity/StartTrans;)Z", "", "transcribeSrc", "w", "(Lcom/upuphone/ar/translation/interconnect/entity/StartTrans;Ljava/lang/String;)Lcom/upuphone/ar/translation/interconnect/entity/StartTrans;", "dialogTransSrc", "dialogTransDst", "g", "(Lcom/upuphone/ar/translation/interconnect/entity/StartTrans;Ljava/lang/String;Ljava/lang/String;)Lcom/upuphone/ar/translation/interconnect/entity/StartTrans;", "simulTransSrc", "simulTransDst", "v", "", "transType", "a", "(I)Lcom/upuphone/ar/translation/interconnect/entity/StartTrans;", "d", "f", "(Ljava/lang/String;)Lcom/upuphone/ar/translation/interconnect/entity/StartTrans;", "e", "(Ljava/lang/String;Ljava/lang/String;)Lcom/upuphone/ar/translation/interconnect/entity/StartTrans;", "c", "isNeedTts", "language", "role", "isTtsBytes", "Lcom/xjsd/xr/sapp/asr/dao/TtsConfig;", "l", "(ZZLjava/lang/String;IZLandroid/content/Context;Z)Lcom/xjsd/xr/sapp/asr/dao/TtsConfig;", "i", "(Landroid/content/Context;Ljava/lang/String;Z)Ljava/lang/String;", "h", "(Ljava/lang/String;)I", "j", "broadcastType", "n", "(Ljava/lang/String;I)Ljava/lang/String;", "m", "(Ljava/lang/String;)Ljava/lang/String;", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AsrServerChannelUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final AsrServerChannelUtils f6352a = new AsrServerChannelUtils();

    public final StartTrans a(int i) {
        LogExt.j("createAirOldConfigInfo transType=" + i, "XunFeiChannelHandler");
        if (i == 1) {
            i = 2;
        }
        return new StartTrans(i, "cn", "cnen", false, 0, false, 0, 120, (DefaultConstructorMarker) null);
    }

    public final StartTrans b() {
        int m = PreferencesUtils.m();
        StartTrans a2 = TranslatorConstants.isAirOldLanguage() ? a(m) : d(m);
        LogExt.j("createConfigInfo startTrans=" + a2, "XunFeiChannelHandler");
        return a2;
    }

    public final StartTrans c(String str, String str2) {
        return new StartTrans(3, str, str2, false, 0, false, 0, 120, (DefaultConstructorMarker) null);
    }

    public final StartTrans d(int i) {
        LanguageUtils.StoredLanguage g = LanguageUtils.g();
        String d = g.d();
        String c = g.c();
        String e = g.e();
        String b = g.b();
        String a2 = g.a();
        LogExt.j("createNewConfigInfo 同传翻译[src=" + d + ", dst=" + c + "], 转写[src=" + e + "],对话翻译[src=" + b + ", dst=" + a2 + "]", "XunFeiChannelHandler");
        return i != 1 ? i != 2 ? i != 3 ? e(d, c) : c(b, a2) : e(d, c) : f(e);
    }

    public final StartTrans e(String str, String str2) {
        return TranslatorConstants.isMicroSoftAsr() ? new StartTrans(2, str, str2, false, 0, false, 0, 120, (DefaultConstructorMarker) null) : Intrinsics.areEqual((Object) "cnen", (Object) str) ? new StartTrans(2, str2, str, false, 0, false, 0, 120, (DefaultConstructorMarker) null) : new StartTrans(2, str, str2, false, 0, false, 0, 120, (DefaultConstructorMarker) null);
    }

    public final StartTrans f(String str) {
        return Intrinsics.areEqual((Object) "cnen", (Object) str) ? new StartTrans(1, "en", "en", false, 0, false, 0, 120, (DefaultConstructorMarker) null) : new StartTrans(1, str, str, false, 0, false, 0, 120, (DefaultConstructorMarker) null);
    }

    public final StartTrans g(StartTrans startTrans, String str, String str2) {
        String str3;
        String str4;
        LogExt.j("dialogTransChannelConfig [src=" + str + ", dst=" + str2 + "], startTrans=" + startTrans, "XunFeiChannelHandler");
        String src = startTrans.getSrc();
        String dst = startTrans.getDst();
        if (!Intrinsics.areEqual((Object) src, (Object) str) || !Intrinsics.areEqual((Object) dst, (Object) str2)) {
            str4 = str;
            str3 = str2;
        } else {
            str4 = src;
            str3 = dst;
        }
        return new StartTrans(startTrans.getTransType(), str4, str3, false, 0, false, 0, 120, (DefaultConstructorMarker) null);
    }

    public final int h(String str) {
        switch (str.hashCode()) {
            case 3201:
                if (str.equals("de")) {
                    return R.string.tl_telephone_trans_remind_other_user_de;
                }
                break;
            case 3241:
                if (str.equals("en")) {
                    return R.string.tl_telephone_trans_remind_other_user_en;
                }
                break;
            case 3246:
                if (str.equals("es")) {
                    return R.string.tl_telephone_trans_remind_other_user_es;
                }
                break;
            case 3276:
                if (str.equals("fr")) {
                    return R.string.tl_telephone_trans_remind_other_user_fr;
                }
                break;
            case 3355:
                if (str.equals("id")) {
                    return R.string.tl_telephone_trans_remind_other_user_id;
                }
                break;
            case 3371:
                if (str.equals("it")) {
                    return R.string.tl_telephone_trans_remind_other_user_it;
                }
                break;
            case 3383:
                if (str.equals("ja")) {
                    return R.string.tl_telephone_trans_remind_other_user_ja;
                }
                break;
            case 3428:
                if (str.equals("ko")) {
                    return R.string.tl_telephone_trans_remind_other_user_ko;
                }
                break;
            case 3494:
                if (str.equals("ms")) {
                    return R.string.tl_telephone_trans_remind_other_user_ms;
                }
                break;
            case 3651:
                if (str.equals("ru")) {
                    return R.string.tl_telephone_trans_remind_other_user_ru;
                }
                break;
            case 3700:
                if (str.equals("th")) {
                    return R.string.tl_telephone_trans_remind_other_user_th;
                }
                break;
            case 3763:
                if (str.equals("vi")) {
                    return R.string.tl_telephone_trans_remind_other_user_vi;
                }
                break;
            case 115813226:
                if (str.equals("zh-CN")) {
                    return R.string.tl_telephone_trans_remind_other_user_cn;
                }
                break;
        }
        return R.string.tl_telephone_trans_remind_other_user_en;
    }

    public final String i(Context context, String str, boolean z) {
        if (!z) {
            return "";
        }
        String string = context.getString(GlassVersionHelper.INSTANCE.getGlassVersionCode() >= 1 ? j(str) : h(str));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public final int j(String str) {
        switch (str.hashCode()) {
            case 3121:
                if (str.equals("ar")) {
                    return R.string.tl_telephone_trans_remind_other_user_ar_new;
                }
                break;
            case 3201:
                if (str.equals("de")) {
                    return R.string.tl_telephone_trans_remind_other_user_de_new;
                }
                break;
            case 3241:
                if (str.equals("en")) {
                    return R.string.tl_telephone_trans_remind_other_user_en_new;
                }
                break;
            case 3246:
                if (str.equals("es")) {
                    return R.string.tl_telephone_trans_remind_other_user_es_new;
                }
                break;
            case 3276:
                if (str.equals("fr")) {
                    return R.string.tl_telephone_trans_remind_other_user_fr_new;
                }
                break;
            case 3355:
                if (str.equals("id")) {
                    return R.string.tl_telephone_trans_remind_other_user_id_new;
                }
                break;
            case 3371:
                if (str.equals("it")) {
                    return R.string.tl_telephone_trans_remind_other_user_it_new;
                }
                break;
            case 3383:
                if (str.equals("ja")) {
                    return R.string.tl_telephone_trans_remind_other_user_ja_new;
                }
                break;
            case 3428:
                if (str.equals("ko")) {
                    return R.string.tl_telephone_trans_remind_other_user_ko_new;
                }
                break;
            case 3494:
                if (str.equals("ms")) {
                    return R.string.tl_telephone_trans_remind_other_user_ms_new;
                }
                break;
            case 3651:
                if (str.equals("ru")) {
                    return R.string.tl_telephone_trans_remind_other_user_ru_new;
                }
                break;
            case 3700:
                if (str.equals("th")) {
                    return R.string.tl_telephone_trans_remind_other_user_th_new;
                }
                break;
            case 3763:
                if (str.equals("vi")) {
                    return R.string.tl_telephone_trans_remind_other_user_vi_new;
                }
                break;
            case 115813226:
                if (str.equals("zh-CN")) {
                    return R.string.tl_telephone_trans_remind_other_user_cn_new;
                }
                break;
        }
        return R.string.tl_telephone_trans_remind_other_user_en_new;
    }

    public final AsrRequestConfig.RecognizeData k(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String accountId = TranslatorConstants.getAccountId();
        String androidId = TranslatorConstants.getAndroidId(context);
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        return new AsrRequestConfig.RecognizeData(accountId, androidId, TranslatorConstants.SOCKET_ASR_APP_NAME, uuid, 0, 16, (DefaultConstructorMarker) null);
    }

    public final TtsConfig l(boolean z, boolean z2, String str, int i, boolean z3, Context context, boolean z4) {
        if (!z4 || !z) {
            return null;
        }
        int i2 = 1;
        int h = i == 1 ? PreferencesUtils.h() : PreferencesUtils.g();
        TtsConfig.Builder audioFormat = new TtsConfig.Builder().voiceId(n(str, h)).text(i(context, str, z2)).audioFormat("ogg_opus");
        if (!z3) {
            i2 = 2;
        }
        return audioFormat.returnFormat(i2).compressionRate(5).language(m(str)).gender(h == 2 ? "female" : "male").textType("plain").build();
    }

    public final String m(String str) {
        String str2;
        switch (str.hashCode()) {
            case 3121:
                str2 = "ar";
                if (!str.equals(str2)) {
                    return "en";
                }
                break;
            case 3201:
                str2 = "de";
                if (!str.equals(str2)) {
                    return "en";
                }
                break;
            case 3241:
                boolean equals = str.equals("en");
                return "en";
            case 3246:
                return !str.equals("es") ? "en" : "esmx";
            case 3276:
                str2 = "fr";
                if (!str.equals(str2)) {
                    return "en";
                }
                break;
            case 3355:
                str2 = "id";
                if (!str.equals(str2)) {
                    return "en";
                }
                break;
            case 3371:
                str2 = "it";
                if (!str.equals(str2)) {
                    return "en";
                }
                break;
            case 3383:
                str2 = "ja";
                if (!str.equals(str2)) {
                    return "en";
                }
                break;
            case 3428:
                str2 = "ko";
                if (!str.equals(str2)) {
                    return "en";
                }
                break;
            case 3494:
                str2 = "ms";
                if (!str.equals(str2)) {
                    return "en";
                }
                break;
            case 3651:
                str2 = "ru";
                if (!str.equals(str2)) {
                    return "en";
                }
                break;
            case 3700:
                str2 = "th";
                if (!str.equals(str2)) {
                    return "en";
                }
                break;
            case 3763:
                str2 = "vi";
                if (!str.equals(str2)) {
                    return "en";
                }
                break;
            case 115813226:
                return !str.equals("zh-CN") ? "en" : "cn";
            default:
                return "en";
        }
        return str2;
    }

    public final String n(String str, int i) {
        if (TranslatorConstants.isIntlVersion()) {
            return "google";
        }
        if (i != 1) {
            return "BV700_streaming";
        }
        int hashCode = str.hashCode();
        if (hashCode != 3241) {
            if (hashCode != 3383) {
                if (hashCode == 115813226) {
                    boolean equals = str.equals("zh-CN");
                }
            } else if (str.equals("ja")) {
                return "BV524_streaming";
            }
        } else if (str.equals("en")) {
            return "BV504_streaming";
        }
        return "BV002_streaming";
    }

    public final boolean o(StartTrans startTrans) {
        Intrinsics.checkNotNullParameter(startTrans, "startTrans");
        if (TranslatorConstants.isIntlVersion()) {
            return true;
        }
        ArrayList arrayListOf = CollectionsKt.arrayListOf("cn", "cnen", "en", "ja");
        return arrayListOf.contains(startTrans.getSrc()) && arrayListOf.contains(startTrans.getDst());
    }

    public final TransConfig p(StartTrans startTrans) {
        String str;
        Intrinsics.checkNotNullParameter(startTrans, "startTrans");
        String src = startTrans.getSrc();
        String dst = startTrans.getDst();
        if (!Intrinsics.areEqual((Object) dst, (Object) "cnen") || startTrans.getTransType() == 1) {
            str = src;
            src = dst;
        } else {
            str = dst;
        }
        return new TransConfig("null", "null", "null", startTrans.getTransType() == 1 ? str : src, str);
    }

    public final AsrRequestConfig q(Context context, StartTrans startTrans, AsrRequestConfig.RecognizeData recognizeData, boolean z, boolean z2) {
        String str;
        AsrRequestConfig.RecognizeData recognizeData2 = recognizeData;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(startTrans, "startTrans");
        Intrinsics.checkNotNullParameter(recognizeData2, "recognizeData");
        String e = StringExtKt.e(StringExtKt.d(startTrans.getDst()));
        String e2 = startTrans.getTransType() == 1 ? StringExtKt.e(StringExtKt.d(startTrans.getDst())) : StringExtKt.h(StringExtKt.g(startTrans.getSrc()));
        AsrRequestConfig.Builder deviceId = new AsrRequestConfig.Builder().srcLang(e).dstLang(e2).deviceId(TranslatorConstants.getAndroidId(context));
        InterConnectDevice b = InterConnectHelper.c.a().b();
        if (b == null || (str = b.getDeviceId()) == null) {
            str = "default-xr-12345";
        }
        return deviceId.iotDeviceId(str).supplier(AsrConstants.ASR_MICROSOFT).appName(TranslatorConstants.SOCKET_ASR_APP_NAME).data(new AsrRequestConfig.RequestData("pcm", 0, 0, 0, (List) null, false, 62, (DefaultConstructorMarker) null)).recognizeData(recognizeData2).accountId(TranslatorConstants.getAccountId()).tts(l(true, z2, e2, 2, true, context, z)).role(0).concatenationStratey(1).build();
    }

    public final TransConfig r(StartTrans startTrans) {
        Intrinsics.checkNotNullParameter(startTrans, "startTrans");
        return new TransConfig("null", "null", "null", startTrans.getSrc(), startTrans.getTransType() == 1 ? startTrans.getSrc() : startTrans.getDst());
    }

    public final AsrRequestConfig s(Context context, StartTrans startTrans, AsrRequestConfig.RecognizeData recognizeData, boolean z) {
        String str;
        AsrRequestConfig.RecognizeData recognizeData2 = recognizeData;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(startTrans, "startTrans");
        Intrinsics.checkNotNullParameter(recognizeData2, "recognizeData");
        String g = StringExtKt.g(startTrans.getSrc());
        int i = 1;
        String g2 = startTrans.getTransType() == 1 ? StringExtKt.g(startTrans.getSrc()) : StringExtKt.d(startTrans.getDst());
        AsrRequestConfig.Builder deviceId = new AsrRequestConfig.Builder().srcLang(g).dstLang(g2).deviceId(TranslatorConstants.getAndroidId(context));
        InterConnectDevice b = InterConnectHelper.c.a().b();
        if (b == null || (str = b.getDeviceId()) == null) {
            str = "default-xr-12345";
        }
        AsrRequestConfig.Builder role = deviceId.iotDeviceId(str).supplier(AsrConstants.ASR_MICROSOFT).appName(TranslatorConstants.SOCKET_ASR_APP_NAME).data(new AsrRequestConfig.RequestData("pcm", 0, 0, 0, (List) null, false, 62, (DefaultConstructorMarker) null)).recognizeData(recognizeData2).accountId(TranslatorConstants.getAccountId()).tts(l(PreferencesUtils.i() == 1, false, g2, 1, true, context, z)).role(1);
        if (startTrans.getTransType() != 3) {
            i = 0;
        }
        return role.concatenationStratey(Integer.valueOf(i)).build();
    }

    public final StartTrans t(StartTrans startTrans) {
        Intrinsics.checkNotNullParameter(startTrans, "startTrans");
        StartTrans startTrans2 = new StartTrans(startTrans.getTransType() == 1 ? 2 : startTrans.getTransType(), "cn", "cnen", false, 0, false, 0, 120, (DefaultConstructorMarker) null);
        LogExt.j("setAirOldChannelConfig startTrans=" + startTrans + ", update startTrans=" + startTrans2, "XunFeiChannelHandler");
        return startTrans2;
    }

    public final StartTrans u(StartTrans startTrans) {
        Intrinsics.checkNotNullParameter(startTrans, "startTrans");
        LanguageUtils.StoredLanguage g = LanguageUtils.g();
        String d = g.d();
        String c = g.c();
        String e = g.e();
        String b = g.b();
        String a2 = g.a();
        LogExt.j("setNewChannelConfig 同传翻译[src=" + d + ", dst=" + c + "], 转写[src=" + e + "],对话翻译[src=" + b + ", dst=" + a2 + "]", "XunFeiChannelHandler");
        int transType = startTrans.getTransType();
        StartTrans v = transType != 1 ? transType != 2 ? transType != 3 ? v(startTrans, d, c) : g(startTrans, b, a2) : v(startTrans, d, c) : w(startTrans, e);
        LogExt.j("setNewChannelConfig startTrans=" + startTrans + ", update startTrans=" + v, "XunFeiChannelHandler");
        return v;
    }

    public final StartTrans v(StartTrans startTrans, String str, String str2) {
        String str3;
        LogExt.j("simulTransChannelConfig [src=" + str + ", dst=" + str2 + "], startTrans=" + startTrans, "XunFeiChannelHandler");
        String src = startTrans.getSrc();
        String dst = startTrans.getDst();
        if (!Intrinsics.areEqual((Object) src, (Object) str) || !Intrinsics.areEqual((Object) dst, (Object) str2)) {
            src = str;
            str3 = str2;
        } else {
            str3 = dst;
        }
        return TranslatorConstants.isMicroSoftAsr() ? new StartTrans(startTrans.getTransType(), src, str3, false, 0, false, 0, 120, (DefaultConstructorMarker) null) : Intrinsics.areEqual((Object) src, (Object) "cnen") ? new StartTrans(startTrans.getTransType(), str3, src, false, 0, false, 0, 120, (DefaultConstructorMarker) null) : new StartTrans(startTrans.getTransType(), src, str3, false, 0, false, 0, 120, (DefaultConstructorMarker) null);
    }

    public final StartTrans w(StartTrans startTrans, String str) {
        LogExt.j("transcribeChannelConfig [src=" + str + "], startTrans=" + startTrans, "XunFeiChannelHandler");
        if (!Intrinsics.areEqual((Object) startTrans.getSrc(), (Object) startTrans.getDst()) || !Intrinsics.areEqual((Object) startTrans.getSrc(), (Object) str)) {
            return new StartTrans(startTrans.getTransType(), str, str, false, 0, false, 0, 120, (DefaultConstructorMarker) null);
        }
        String src = Intrinsics.areEqual((Object) startTrans.getSrc(), (Object) "cnen") ? "en" : startTrans.getSrc();
        return new StartTrans(startTrans.getTransType(), src, src, false, 0, false, 0, 120, (DefaultConstructorMarker) null);
    }
}
