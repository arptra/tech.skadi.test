package com.fm.sdk.deviceid;

import android.util.AndroidRuntimeException;
import java.security.MessageDigest;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f2832a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", org.extra.tools.a.f3359a, "b", "c", "d", "e", "f"};

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: byte} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r2v0, types: [byte, int] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(int r2, boolean r3) {
        /*
            if (r2 >= 0) goto L_0x0004
            int r2 = r2 + 256
        L_0x0004:
            int r0 = r2 / 16
            int r2 = r2 % 16
            if (r3 == 0) goto L_0x0020
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String[] r1 = f2832a
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
            java.lang.String[] r1 = f2832a
            r2 = r1[r2]
            r3.append(r2)
            r2 = r1[r0]
            goto L_0x0018
        L_0x002f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fm.sdk.deviceid.a.a(byte, boolean):java.lang.String");
    }

    public static String b(String str, String str2) {
        try {
            String str3 = new String(str);
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            return str2 == null ? c(instance.digest(str3.getBytes())) : c(instance.digest(str3.getBytes(str2)));
        } catch (Exception e) {
            throw new AndroidRuntimeException(e);
        }
    }

    public static String c(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte a2 : bArr) {
            sb.append(a(a2, true));
        }
        return sb.toString();
    }
}
