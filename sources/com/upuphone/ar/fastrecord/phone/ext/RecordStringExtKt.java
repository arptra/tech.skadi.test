package com.upuphone.ar.fastrecord.phone.ext;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u001a\u0012\u0010\u0003\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"HMAC_SHA1_ALGORITHM", "", "TAG", "shortHandGetHmac", "apiKey", "shortHandIntlSha256", "shortHandMd5", "shortHandMixedLogData", "ar-fastrecord_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class RecordStringExtKt {
    @NotNull
    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
    @NotNull
    private static final String TAG = "StringExt";

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0076 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x006e  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String shortHandGetHmac(@org.jetbrains.annotations.NotNull java.lang.String r7, @org.jetbrains.annotations.NotNull java.lang.String r8) {
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
            javax.crypto.spec.SecretKeySpec r5 = new javax.crypto.spec.SecretKeySpec     // Catch:{ NoSuchAlgorithmException -> 0x003b, Exception -> 0x0039 }
            java.nio.charset.Charset r6 = kotlin.text.Charsets.UTF_8     // Catch:{ NoSuchAlgorithmException -> 0x003b, Exception -> 0x0039 }
            byte[] r8 = r8.getBytes(r6)     // Catch:{ NoSuchAlgorithmException -> 0x003b, Exception -> 0x0039 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r3)     // Catch:{ NoSuchAlgorithmException -> 0x003b, Exception -> 0x0039 }
            r5.<init>(r8, r2)     // Catch:{ NoSuchAlgorithmException -> 0x003b, Exception -> 0x0039 }
            javax.crypto.Mac r8 = javax.crypto.Mac.getInstance(r2)     // Catch:{ NoSuchAlgorithmException -> 0x003b, Exception -> 0x0039 }
            r8.init(r5)     // Catch:{ NoSuchAlgorithmException -> 0x003b, Exception -> 0x0039 }
            byte[] r7 = r7.getBytes(r6)     // Catch:{ NoSuchAlgorithmException -> 0x003b, Exception -> 0x0039 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r3)     // Catch:{ NoSuchAlgorithmException -> 0x003b, Exception -> 0x0039 }
            byte[] r4 = r8.doFinal(r7)     // Catch:{ NoSuchAlgorithmException -> 0x003b, Exception -> 0x0039 }
            r7 = 2
            byte[] r7 = android.util.Base64.encode(r4, r7)     // Catch:{ NoSuchAlgorithmException -> 0x003b, Exception -> 0x0039 }
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
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r7, r0)
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
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r7, r0)
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
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ext.RecordStringExtKt.shortHandGetHmac(java.lang.String, java.lang.String):java.lang.String");
    }

    @NotNull
    public static final String shortHandIntlSha256(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            byte[] bytes = ("RhdNS`Z?" + str).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            instance.update(bytes);
            byte[] digest = instance.digest();
            Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
            return RecordByteArrayExtKt.shortHandToHexString(digest);
        } catch (NoSuchAlgorithmException e) {
            String stackTraceToString = ExceptionsKt.stackTraceToString(e);
            LogExt.logE("获取Sha256加密对象失败！errorMsg=" + stackTraceToString, TAG);
            return "";
        }
    }

    @NotNull
    public static final String shortHandMd5(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            instance.update(bytes);
            byte[] digest = instance.digest();
            Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
            return RecordByteArrayExtKt.shortHandToHexString(digest);
        } catch (Exception e) {
            String stackTraceToString = ExceptionsKt.stackTraceToString(e);
            LogExt.logE("获取MD5加密对象失败！errorMsg=" + stackTraceToString, TAG);
            return "";
        }
    }

    @NotNull
    public static final String shortHandMixedLogData(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (StringsKt.isBlank(str)) {
            return "####";
        }
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        String shortHandToHexString = RecordByteArrayExtKt.shortHandToHexString(bytes);
        if (StringsKt.isBlank(shortHandToHexString)) {
            return "####";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            sb.append(String.valueOf(shortHandToHexString.charAt(i % shortHandToHexString.length())));
            sb.append(charAt);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }
}
