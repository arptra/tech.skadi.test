package com.flyme.xjfms.ums.sign.jdk.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.extra.tools.a;

public class MD5Util {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f2829a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", a.f3359a, "b", "c", "d", "e", "f"};
    public static ThreadLocal b = new ThreadLocal<MessageDigest>() {
        /* renamed from: a */
        public MessageDigest initialValue() {
            try {
                return MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            } catch (NoSuchAlgorithmException unused) {
                throw new IllegalStateException("no md5 algorythm found");
            }
        }
    };

    public static String a(String str) {
        return b(str, (String) null);
    }

    public static String b(String str, String str2) {
        try {
            String str3 = new String(str);
            MessageDigest messageDigest = (MessageDigest) b.get();
            return str2 == null ? c(messageDigest.digest(str3.getBytes())) : c(messageDigest.digest(str3.getBytes(str2)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String c(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte d : bArr) {
            stringBuffer.append(d(d, true));
        }
        return stringBuffer.toString();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: byte} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r2v0, types: [byte, int] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String d(int r2, boolean r3) {
        /*
            if (r2 >= 0) goto L_0x0004
            int r2 = r2 + 256
        L_0x0004:
            int r0 = r2 / 16
            int r2 = r2 % 16
            if (r3 == 0) goto L_0x0020
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String[] r1 = f2829a
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
            java.lang.String[] r1 = f2829a
            r2 = r1[r2]
            r3.append(r2)
            r2 = r1[r0]
            goto L_0x0018
        L_0x002f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flyme.xjfms.ums.sign.jdk.utils.MD5Util.d(byte, boolean):java.lang.String");
    }
}
