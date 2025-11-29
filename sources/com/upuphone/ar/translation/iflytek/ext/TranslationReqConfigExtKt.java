package com.upuphone.ar.translation.iflytek.ext;

import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.iflytek.entity.TranslationReqConfig;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/upuphone/ar/translation/iflytek/entity/TranslationReqConfig;", "", "a", "(Lcom/upuphone/ar/translation/iflytek/entity/TranslationReqConfig;)Ljava/lang/String;", "ar-translator_intlRelease"}, k = 2, mv = {1, 9, 0})
public final class TranslationReqConfigExtKt {
    public static final String a(TranslationReqConfig translationReqConfig) {
        Intrinsics.checkNotNullParameter(translationReqConfig, "<this>");
        LogExt.j("TransReqConfig:: " + translationReqConfig, "TranslationReqConfig");
        String ts = translationReqConfig.getTs();
        String valueOf = (ts == null || StringsKt.isBlank(ts)) ? String.valueOf(System.currentTimeMillis() / 1000) : translationReqConfig.getTs();
        LogExt.j("reqTime:: " + valueOf, "TranslationReqConfig");
        StringBuilder sb = new StringBuilder();
        String appid = translationReqConfig.getAppid();
        String j = StringExtKt.j(appid + valueOf);
        LogExt.j("md5Str:: " + j, "TranslationReqConfig");
        String c = StringExtKt.c(j, translationReqConfig.getApiKey());
        LogExt.j("hmacStr:: " + c, "TranslationReqConfig");
        String encode = URLEncoder.encode(c, "utf-8");
        LogExt.j("signa:: " + encode, "TranslationReqConfig");
        sb.append(translationReqConfig.getBaseUrl());
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        int i = 2;
        if (!StringsKt.endsWith$default(sb2, "?", false, 2, (Object) null)) {
            sb.append("?");
        }
        String appid2 = translationReqConfig.getAppid();
        sb.append("appid=" + appid2);
        sb.append("&ts=" + valueOf);
        String signa = translationReqConfig.getSigna();
        if (signa == null || StringsKt.isBlank(signa)) {
            sb.append("&signa=" + encode);
        } else {
            String signa2 = translationReqConfig.getSigna();
            sb.append("&signa=" + signa2);
        }
        String lang = translationReqConfig.getLang();
        sb.append("&lang=" + lang);
        if (!Intrinsics.areEqual((Object) translationReqConfig.getTargetLang(), (Object) translationReqConfig.getLang())) {
            String transType = translationReqConfig.getTransType();
            if (transType == null) {
                transType = "normal";
            }
            sb.append("&transType=" + transType);
            Integer transStrategy = translationReqConfig.getTransStrategy();
            if (transStrategy != null) {
                i = transStrategy.intValue();
            }
            sb.append("&transStrategy=" + i);
            String targetLang = translationReqConfig.getTargetLang();
            sb.append("&targetLang=" + targetLang);
        }
        String punc = translationReqConfig.getPunc();
        if (punc != null) {
            sb.append("&punc=" + punc);
        }
        String pd = translationReqConfig.getPd();
        if (pd != null) {
            sb.append("&pd=" + pd);
        }
        Integer vadMdn = translationReqConfig.getVadMdn();
        if (vadMdn != null) {
            int intValue = vadMdn.intValue();
            sb.append("&vadMdn=" + intValue);
        }
        Integer roleType = translationReqConfig.getRoleType();
        if (roleType != null) {
            int intValue2 = roleType.intValue();
            sb.append("&roleType=" + intValue2);
        }
        String sb3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
        return sb3;
    }
}
