package com.upuphone.ai.ttsengine.base.utils;

import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/upuphone/ai/ttsengine/base/utils/StringUtils;", "", "<init>", "()V", "", "message", "c", "(Ljava/lang/String;)Ljava/lang/String;", "", "bytes", "", "split", "a", "([BZ)Ljava/lang/String;", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class StringUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final StringUtils f5530a = new StringUtils();

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String a(byte[] r5, boolean r6) {
        /*
            java.lang.String r0 = "bytes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            int r1 = r5.length
            r2 = 0
        L_0x000c:
            if (r2 >= r1) goto L_0x0030
            byte r3 = r5[r2]
            if (r3 >= 0) goto L_0x0014
            int r3 = r3 + 256
        L_0x0014:
            r4 = 16
            if (r3 >= r4) goto L_0x001d
            java.lang.String r4 = "0"
            r0.append(r4)
        L_0x001d:
            if (r6 == 0) goto L_0x0026
            if (r2 <= 0) goto L_0x0026
            r4 = 58
            r0.append(r4)
        L_0x0026:
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r0.append(r3)
            int r2 = r2 + 1
            goto L_0x000c
        L_0x0030:
            java.lang.String r5 = r0.toString()
            java.lang.String r6 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            java.util.Locale r6 = java.util.Locale.getDefault()
            java.lang.String r0 = "getDefault(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            java.lang.String r5 = r5.toUpperCase(r6)
            java.lang.String r6 = "toUpperCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ai.ttsengine.base.utils.StringUtils.a(byte[], boolean):java.lang.String");
    }

    public static /* synthetic */ String b(byte[] bArr, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return a(bArr, z);
    }

    public static final String c(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            Intrinsics.checkNotNullExpressionValue(instance, "getInstance(...)");
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            byte[] digest = instance.digest(bytes);
            Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
            return b(digest, false, 2, (Object) null);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
