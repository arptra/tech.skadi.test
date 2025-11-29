package com.honey.account.utils.encrypt;

import com.geetest.sdk.s;
import com.google.common.net.HttpHeaders;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.extra.tools.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u001a\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0002\u001a\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u001a\u0010\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u0005\u001a \u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b\u001a\u0010\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u0005\u001a\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u0002\"\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0003¨\u0006\u0014"}, d2 = {"hexDigits", "", "", "[Ljava/lang/String;", "MD5Encode", "", "origin", "encoding", "byteArrayToHexString", "b", "beginPos", "", "length", "byteArrayToHexStringLittleEnding", "byteToHexString", "", "bigEnding", "", "hexStringToByteArray", "s", "CoreLibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class MD5Kt {
    @NotNull
    private static final String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", a.f3359a, "b", "c", "d", "e", "f"};

    @Nullable
    public static final String MD5Encode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, HttpHeaders.ReferrerPolicyValues.ORIGIN);
        return MD5Encode(str, (String) null);
    }

    @Nullable
    public static final String byteArrayToHexString(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "b");
        StringBuffer stringBuffer = new StringBuffer();
        for (byte byteToHexString : bArr) {
            stringBuffer.append(byteToHexString(byteToHexString, true));
        }
        return stringBuffer.toString();
    }

    @Nullable
    public static final String byteArrayToHexStringLittleEnding(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "b");
        StringBuffer stringBuffer = new StringBuffer();
        for (byte byteToHexString : bArr) {
            stringBuffer.append(byteToHexString(byteToHexString, false));
        }
        return stringBuffer.toString();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: byte} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r2v0, types: [byte, int] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.lang.String byteToHexString(int r2, boolean r3) {
        /*
            if (r2 >= 0) goto L_0x0004
            int r2 = r2 + 256
        L_0x0004:
            int r0 = r2 / 16
            int r2 = r2 % 16
            if (r3 == 0) goto L_0x0020
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String[] r1 = hexDigits
            r0 = r1[r0]
            r3.append(r0)
            r2 = r1[r2]
        L_0x0018:
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            goto L_0x002f
        L_0x0020:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String[] r1 = hexDigits
            r2 = r1[r2]
            r3.append(r2)
            r2 = r1[r0]
            goto L_0x0018
        L_0x002f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.honey.account.utils.encrypt.MD5Kt.byteToHexString(byte, boolean):java.lang.String");
    }

    @Nullable
    public static final byte[] hexStringToByteArray(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, s.f);
        if (str.length() % 2 == 0) {
            byte[] bArr = new byte[(str.length() / 2)];
            int i = 0;
            while (i < str.length()) {
                int i2 = i / 2;
                int i3 = i + 1;
                char charAt = str.charAt(i);
                i += 2;
                char charAt2 = str.charAt(i3);
                bArr[i2] = (byte) Integer.decode("0x" + charAt + charAt2).intValue();
            }
            return bArr;
        }
        throw new RuntimeException("Error Hex String length");
    }

    @Nullable
    public static final String MD5Encode(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, HttpHeaders.ReferrerPolicyValues.ORIGIN);
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            if (str2 == null) {
                byte[] bytes = str.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                byte[] digest = instance.digest(bytes);
                Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
                return byteArrayToHexString(digest);
            }
            Charset forName = Charset.forName(str2);
            Intrinsics.checkNotNullExpressionValue(forName, "forName(...)");
            byte[] bytes2 = str.getBytes(forName);
            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
            byte[] digest2 = instance.digest(bytes2);
            Intrinsics.checkNotNullExpressionValue(digest2, "digest(...)");
            return byteArrayToHexString(digest2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Nullable
    public static final String byteArrayToHexString(@NotNull byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "b");
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = i2 + i;
        while (i < i3) {
            stringBuffer.append(byteToHexString(bArr[i], true));
            i++;
        }
        return stringBuffer.toString();
    }

    @Nullable
    public static final byte[] MD5Encode(@Nullable byte[] bArr) {
        try {
            return MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(bArr);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
