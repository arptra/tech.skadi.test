package com.geetest.sdk;

import android.util.Base64;
import com.upuphone.starrynet.strategy.encrypt.utils.EncryptionUtil;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

public final class ak {
    public static String a(String str) {
        return new String(Base64.decode(str, 0));
    }

    public static byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        Class<byte[]> cls = byte[].class;
        Object newInstance = Class.forName(a("amF2YXguY3J5cHRvLnNwZWMuSXZQYXJhbWV0ZXJTcGVj")).getConstructor(new Class[]{cls}).newInstance(new Object[]{bArr3});
        Class<String> cls2 = String.class;
        Object newInstance2 = Class.forName(a("amF2YXguY3J5cHRvLnNwZWMuU2VjcmV0S2V5U3BlYw==")).getConstructor(new Class[]{cls, cls2}).newInstance(new Object[]{bArr2, "AES"});
        Class<?> cls3 = Class.forName(a("amF2YXguY3J5cHRvLkNpcGhlcg=="));
        Object invoke = cls3.getMethod("getInstance", new Class[]{cls2}).invoke(cls3, new Object[]{EncryptionUtil.KEY_SYMMETRIC_V1});
        cls3.getMethod("init", new Class[]{Integer.TYPE, Key.class, AlgorithmParameterSpec.class}).invoke(invoke, new Object[]{1, newInstance2, newInstance});
        return (byte[]) cls3.getMethod("doFinal", new Class[]{cls}).invoke(invoke, new Object[]{bArr});
    }

    public static String c(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            byte[] b = b(bArr, bArr2, bArr3);
            byte[] bArr4 = new byte[(bArr3.length + bArr2.length + b.length)];
            System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
            System.arraycopy(bArr2, 0, bArr4, bArr3.length, bArr2.length);
            System.arraycopy(b, 0, bArr4, bArr3.length + bArr2.length, b.length);
            return Base64.encodeToString(bArr4, 0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
