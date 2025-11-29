package com.geetest.captcha;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.upuphone.starrynet.strategy.encrypt.utils.EncryptionUtil;
import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public final class i {
    public static String a(Context context, String str) {
        String str2;
        byte[] bytes = str.getBytes();
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            instance.update(bytes);
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < digest.length; i++) {
                char[] cArr = m.f2873a;
                sb.append(cArr[(digest[i] >> 4) & 15]);
                sb.append(cArr[digest[i] & 15]);
            }
            str2 = sb.toString();
        } catch (Exception unused) {
            str2 = null;
        }
        if (g(str2)) {
            return null;
        }
        c(context, "gt_fp", str2);
        return str2;
    }

    public static String b(String str) {
        return new String(Base64.decode(str, 0));
    }

    public static void c(Context context, String str, String str2) {
        try {
            context.getSharedPreferences("gt_fp", 0).edit().putString(str, str2).apply();
        } catch (Exception unused) {
        }
    }

    public static byte[] d() {
        char[] charArray = new String(Base64.decode("MzAzMDMwMzAzMDMwMzAzMDMwMzAzMDMwMzAzMDMwMzA=", 0)).toCharArray();
        int length = charArray.length / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            int digit = Character.digit(charArray[i2 + 1], 16) | (Character.digit(charArray[i2], 16) << 4);
            if (digit > 127) {
                digit -= 256;
            }
            bArr[i] = (byte) digit;
        }
        return bArr;
    }

    public static byte[] e(String str, String str2) {
        String str3 = new String(d());
        byte[] bytes = str.getBytes("utf-8");
        byte[] bytes2 = str2.getBytes("utf-8");
        Class<byte[]> cls = byte[].class;
        Object newInstance = Class.forName(b("amF2YXguY3J5cHRvLnNwZWMuSXZQYXJhbWV0ZXJTcGVj")).getConstructor(new Class[]{cls}).newInstance(new Object[]{str3.getBytes("utf-8")});
        Class<String> cls2 = String.class;
        Object newInstance2 = Class.forName(b("amF2YXguY3J5cHRvLnNwZWMuU2VjcmV0S2V5U3BlYw==")).getConstructor(new Class[]{cls, cls2}).newInstance(new Object[]{bytes2, "AES"});
        Class<?> cls3 = Class.forName(b("amF2YXguY3J5cHRvLkNpcGhlcg=="));
        Object invoke = cls3.getMethod("getInstance", new Class[]{cls2}).invoke(cls3, new Object[]{EncryptionUtil.KEY_SYMMETRIC_V1});
        cls3.getMethod("init", new Class[]{Integer.TYPE, Key.class, AlgorithmParameterSpec.class}).invoke(invoke, new Object[]{1, newInstance2, newInstance});
        return (byte[]) cls3.getMethod("doFinal", new Class[]{cls}).invoke(invoke, new Object[]{bytes});
    }

    public static byte[] f(byte[] bArr, String str) {
        byte[] bytes = str.getBytes("utf-8");
        Class<byte[]> cls = byte[].class;
        Object newInstance = Class.forName(b("amF2YXguY3J5cHRvLnNwZWMuSXZQYXJhbWV0ZXJTcGVj")).getConstructor(new Class[]{cls}).newInstance(new Object[]{d()});
        Class<String> cls2 = String.class;
        Object newInstance2 = Class.forName(b("amF2YXguY3J5cHRvLnNwZWMuU2VjcmV0S2V5U3BlYw==")).getConstructor(new Class[]{cls, cls2}).newInstance(new Object[]{bytes, "AES"});
        Class<?> cls3 = Class.forName(b("amF2YXguY3J5cHRvLkNpcGhlcg=="));
        Object invoke = cls3.getMethod("getInstance", new Class[]{cls2}).invoke(cls3, new Object[]{EncryptionUtil.KEY_SYMMETRIC_V1});
        cls3.getMethod("init", new Class[]{Integer.TYPE, Key.class, AlgorithmParameterSpec.class}).invoke(invoke, new Object[]{2, newInstance2, newInstance});
        return (byte[]) cls3.getMethod("doFinal", new Class[]{cls}).invoke(invoke, new Object[]{bArr});
    }

    public static boolean g(String str) {
        return TextUtils.isEmpty(str) || "$unknown".equals(str);
    }
}
