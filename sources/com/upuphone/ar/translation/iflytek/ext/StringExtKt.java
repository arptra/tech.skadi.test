package com.upuphone.ar.translation.iflytek.ext;

import com.upuphone.ar.translation.ext.ByteArrayExtKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.xjsd.xr.sapp.asr.constants.AsrConstants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0011\u0010\u0001\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0019\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0006\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0002\u001a\u0011\u0010\u0007\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\u0002\u001a\u001b\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\bH\u0002¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\bH\u0002¢\u0006\u0004\b\u000b\u0010\n\u001a\u0011\u0010\f\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\f\u0010\u0002\u001a\u0011\u0010\r\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\r\u0010\u0002\u001a\u001b\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\bH\u0002¢\u0006\u0004\b\u000e\u0010\n\u001a\u001b\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\bH\u0002¢\u0006\u0004\b\u000f\u0010\n\u001a\u0011\u0010\u0010\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0010\u0010\u0002\u001a\u0013\u0010\u0012\u001a\u00020\u0000*\u00020\u0011H\u0000¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"", "j", "(Ljava/lang/String;)Ljava/lang/String;", "apiKey", "c", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "g", "d", "", "l", "()Ljava/util/Map;", "b", "h", "e", "i", "f", "k", "", "a", "(I)Ljava/lang/String;", "ar-translator_intlRelease"}, k = 2, mv = {1, 9, 0})
public final class StringExtKt {
    public static final String a(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "无效的通道类型" : "佩戴者通道" : "非佩戴者通道" : "双通道" : "无效的通道类型";
    }

    public static final Map b() {
        return MapsKt.mutableMapOf(TuplesKt.to("cn", "zh-CN"), TuplesKt.to("cnen", "en"), TuplesKt.to("en", "en"), TuplesKt.to("ja", "ja"), TuplesKt.to("fr", "fr"), TuplesKt.to("ko", "ko"), TuplesKt.to("ru", "ru"), TuplesKt.to("es", "es"), TuplesKt.to("vi", "vi"), TuplesKt.to("ms", "ms"), TuplesKt.to("th", "th"), TuplesKt.to("id", "id"), TuplesKt.to("it", "it"), TuplesKt.to("de", "de"), TuplesKt.to("ar", "ar"), TuplesKt.to("tr", "tr"));
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0076 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String c(java.lang.String r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "StringExt"
            java.lang.String r1 = "HmacSHA1加密异常！errorMsg="
            java.lang.String r2 = "HmacSHA1"
            java.lang.String r3 = "getBytes(...)"
            java.lang.String r4 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r4)
            java.lang.String r4 = "apiKey"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r4)
            r4 = 0
            javax.crypto.spec.SecretKeySpec r5 = new javax.crypto.spec.SecretKeySpec     // Catch:{ NoSuchAlgorithmException -> 0x003b, InvalidKeyException -> 0x0039 }
            java.nio.charset.Charset r6 = kotlin.text.Charsets.UTF_8     // Catch:{ NoSuchAlgorithmException -> 0x003b, InvalidKeyException -> 0x0039 }
            byte[] r8 = r8.getBytes(r6)     // Catch:{ NoSuchAlgorithmException -> 0x003b, InvalidKeyException -> 0x0039 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r3)     // Catch:{ NoSuchAlgorithmException -> 0x003b, InvalidKeyException -> 0x0039 }
            r5.<init>(r8, r2)     // Catch:{ NoSuchAlgorithmException -> 0x003b, InvalidKeyException -> 0x0039 }
            javax.crypto.Mac r8 = javax.crypto.Mac.getInstance(r2)     // Catch:{ NoSuchAlgorithmException -> 0x003b, InvalidKeyException -> 0x0039 }
            r8.init(r5)     // Catch:{ NoSuchAlgorithmException -> 0x003b, InvalidKeyException -> 0x0039 }
            byte[] r7 = r7.getBytes(r6)     // Catch:{ NoSuchAlgorithmException -> 0x003b, InvalidKeyException -> 0x0039 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r3)     // Catch:{ NoSuchAlgorithmException -> 0x003b, InvalidKeyException -> 0x0039 }
            byte[] r4 = r8.doFinal(r7)     // Catch:{ NoSuchAlgorithmException -> 0x003b, InvalidKeyException -> 0x0039 }
            r7 = 2
            byte[] r7 = android.util.Base64.encode(r4, r7)     // Catch:{ NoSuchAlgorithmException -> 0x003b, InvalidKeyException -> 0x0039 }
            goto L_0x006c
        L_0x0039:
            r7 = move-exception
            goto L_0x003d
        L_0x003b:
            r7 = move-exception
            goto L_0x0055
        L_0x003d:
            java.lang.String r7 = kotlin.ExceptionsKt.stackTraceToString(r7)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r1)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            com.upuphone.ar.translation.ext.LogExt.h(r7, r0)
        L_0x0053:
            r7 = r4
            goto L_0x006c
        L_0x0055:
            java.lang.String r7 = kotlin.ExceptionsKt.stackTraceToString(r7)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r1)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            com.upuphone.ar.translation.ext.LogExt.h(r7, r0)
            goto L_0x0053
        L_0x006c:
            if (r7 == 0) goto L_0x0076
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r0 = kotlin.text.Charsets.UTF_8
            r8.<init>(r7, r0)
            goto L_0x0078
        L_0x0076:
            java.lang.String r8 = ""
        L_0x0078:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.iflytek.ext.StringExtKt.c(java.lang.String, java.lang.String):java.lang.String");
    }

    public static final String d(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String str2 = (String) b().get(str);
        return str2 == null ? str : str2;
    }

    public static final String e(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String str2 = (String) f().get(str);
        return str2 == null ? str : str2;
    }

    public static final Map f() {
        return MapsKt.mutableMapOf(TuplesKt.to("zh-CN", "cmn-Hans-CN"), TuplesKt.to("en", "en-GB"), TuplesKt.to("ms", "ms-MY"), TuplesKt.to("ja", "ja-JP"), TuplesKt.to("ru", AsrConstants.SrcLangType.RU), TuplesKt.to("fr", "fr-FR"), TuplesKt.to("es", AsrConstants.SrcLangType.ES), TuplesKt.to("vi", AsrConstants.SrcLangType.VI), TuplesKt.to("th", "th-TH"), TuplesKt.to("id", "id-ID"), TuplesKt.to("ko", "ko-KR"), TuplesKt.to("it", "it-IT"), TuplesKt.to("de", "de-DE"), TuplesKt.to("ar", "ar-SA"));
    }

    public static final String g(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String str2 = (String) l().get(str);
        return str2 == null ? str : str2;
    }

    public static final String h(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String str2 = (String) i().get(str);
        return str2 == null ? str : str2;
    }

    public static final Map i() {
        return MapsKt.mutableMapOf(TuplesKt.to("cmn-Hans-CN", "zh-CN"), TuplesKt.to("en-GB", "en"), TuplesKt.to("ms-MY", "ms"), TuplesKt.to("ja-JP", "ja"), TuplesKt.to(AsrConstants.SrcLangType.RU, "ru"), TuplesKt.to("fr-FR", "fr"), TuplesKt.to(AsrConstants.SrcLangType.ES, "es"), TuplesKt.to(AsrConstants.SrcLangType.VI, "vi"), TuplesKt.to("th-TH", "th"), TuplesKt.to("id-ID", "id"), TuplesKt.to("ko-KR", "ko"), TuplesKt.to("it-IT", "it"), TuplesKt.to("de-DE", "de"), TuplesKt.to("ar-SA", "ar"));
    }

    public static final String j(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            instance.update(bytes);
            byte[] digest = instance.digest();
            Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
            return ByteArrayExtKt.b(digest);
        } catch (NoSuchAlgorithmException e) {
            String stackTraceToString = ExceptionsKt.stackTraceToString(e);
            LogExt.h("获取MD5加密对象失败！errorMsg=" + stackTraceToString, "StringExt");
            return "";
        }
    }

    public static final String k(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (StringsKt.isBlank(str)) {
            return "####";
        }
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        String b = ByteArrayExtKt.b(bytes);
        if (StringsKt.isBlank(b)) {
            return "####";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            sb.append(String.valueOf(b.charAt(i % b.length())));
            sb.append(charAt);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public static final Map l() {
        return MapsKt.mutableMapOf(TuplesKt.to("cn", "cmn-Hans-CN"), TuplesKt.to("cnen", "en-GB"), TuplesKt.to("en", "en-GB"), TuplesKt.to("ja", "ja-JP"), TuplesKt.to("fr", "fr-FR"), TuplesKt.to("ko", "ko-KR"), TuplesKt.to("ru", AsrConstants.SrcLangType.RU), TuplesKt.to("es", AsrConstants.SrcLangType.ES), TuplesKt.to("vi", AsrConstants.SrcLangType.VI), TuplesKt.to("ms", "ms-MY"), TuplesKt.to("th", "th-TH"), TuplesKt.to("id", "id-ID"), TuplesKt.to("it", "it-IT"), TuplesKt.to("de", "de-DE"), TuplesKt.to("ar", "ar-SA"), TuplesKt.to("tr", "tr-TR"));
    }
}
