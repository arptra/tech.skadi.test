package com.geetest.sdk;

import android.util.Base64;
import com.upuphone.starrynet.strategy.encrypt.utils.EncryptionUtil;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

final class i {
    public static String a(String str) {
        return new String(Base64.decode(str, 0));
    }

    public static byte[] b() {
        return o.b(new String(Base64.decode("MzAzMDMwMzAzMDMwMzAzMDMwMzAzMDMwMzAzMDMwMzA=", 0)));
    }

    public static byte[] c(String str, String str2) {
        return d(str, str2, new String(b()));
    }

    public static byte[] d(String str, String str2, String str3) {
        return g(str.getBytes("utf-8"), str2.getBytes("utf-8"), str3.getBytes("utf-8"));
    }

    public static byte[] e(byte[] bArr, String str) {
        return f(bArr, str.getBytes("utf-8"), b());
    }

    public static byte[] f(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        Class<byte[]> cls = byte[].class;
        Object newInstance = Class.forName(a("amF2YXguY3J5cHRvLnNwZWMuSXZQYXJhbWV0ZXJTcGVj")).getConstructor(new Class[]{cls}).newInstance(new Object[]{bArr3});
        Class<String> cls2 = String.class;
        Object newInstance2 = Class.forName(a("amF2YXguY3J5cHRvLnNwZWMuU2VjcmV0S2V5U3BlYw==")).getConstructor(new Class[]{cls, cls2}).newInstance(new Object[]{bArr2, "AES"});
        Class<?> cls3 = Class.forName(a("amF2YXguY3J5cHRvLkNpcGhlcg=="));
        Object invoke = cls3.getMethod("getInstance", new Class[]{cls2}).invoke(cls3, new Object[]{EncryptionUtil.KEY_SYMMETRIC_V1});
        cls3.getMethod("init", new Class[]{Integer.TYPE, Key.class, AlgorithmParameterSpec.class}).invoke(invoke, new Object[]{2, newInstance2, newInstance});
        return (byte[]) cls3.getMethod("doFinal", new Class[]{cls}).invoke(invoke, new Object[]{bArr});
    }

    public static byte[] g(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        Class<byte[]> cls = byte[].class;
        Object newInstance = Class.forName(a("amF2YXguY3J5cHRvLnNwZWMuSXZQYXJhbWV0ZXJTcGVj")).getConstructor(new Class[]{cls}).newInstance(new Object[]{bArr3});
        Class<String> cls2 = String.class;
        Object newInstance2 = Class.forName(a("amF2YXguY3J5cHRvLnNwZWMuU2VjcmV0S2V5U3BlYw==")).getConstructor(new Class[]{cls, cls2}).newInstance(new Object[]{bArr2, "AES"});
        Class<?> cls3 = Class.forName(a("amF2YXguY3J5cHRvLkNpcGhlcg=="));
        Object invoke = cls3.getMethod("getInstance", new Class[]{cls2}).invoke(cls3, new Object[]{EncryptionUtil.KEY_SYMMETRIC_V1});
        cls3.getMethod("init", new Class[]{Integer.TYPE, Key.class, AlgorithmParameterSpec.class}).invoke(invoke, new Object[]{1, newInstance2, newInstance});
        return (byte[]) cls3.getMethod("doFinal", new Class[]{cls}).invoke(invoke, new Object[]{bArr});
    }
}
