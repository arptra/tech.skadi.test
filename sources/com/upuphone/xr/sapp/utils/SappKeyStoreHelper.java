package com.upuphone.xr.sapp.utils;

import android.security.keystore.KeyGenParameterSpec;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynet.strategy.encrypt.utils.EncryptionUtil;
import java.security.KeyStore;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u0007J\u0011\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/upuphone/xr/sapp/utils/SappKeyStoreHelper;", "", "<init>", "()V", "", "bytes", "b", "([B)[B", "a", "Ljavax/crypto/SecretKey;", "d", "()Ljavax/crypto/SecretKey;", "c", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class SappKeyStoreHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final SappKeyStoreHelper f7913a = new SappKeyStoreHelper();

    public final byte[] a(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        try {
            if (bArr.length != 0) {
                if (bArr.length > 2) {
                    byte[] bArr2 = null;
                    int k = SappArrayExtKt.k(ArraysKt.sliceArray(bArr, RangesKt.until(0, 2)), false, 1, (Object) null) + 2;
                    byte[] sliceArray = ArraysKt.sliceArray(bArr, RangesKt.until(2, k));
                    byte[] sliceArray2 = ArraysKt.sliceArray(bArr, RangesKt.until(k, bArr.length));
                    if (d() != null) {
                        Cipher instance = Cipher.getInstance(EncryptionUtil.KEY_SYMMETRIC_V3);
                        instance.init(2, f7913a.d(), new GCMParameterSpec(128, sliceArray));
                        bArr2 = instance.doFinal(sliceArray2);
                    }
                    return bArr2 == null ? new byte[0] : bArr2;
                }
            }
            return new byte[0];
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            String stackTraceToString = ExceptionsKt.stackTraceToString(e);
            delegate.c("SappKeyStoreHelper", "aesDecryptData error=" + stackTraceToString);
            return new byte[0];
        }
    }

    public final byte[] b(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        try {
            if (bArr.length == 0) {
                return new byte[0];
            }
            if (d() != null) {
                Cipher instance = Cipher.getInstance(EncryptionUtil.KEY_SYMMETRIC_V3);
                instance.init(1, f7913a.d());
                byte[] iv = ((GCMParameterSpec) instance.getParameters().getParameterSpec(GCMParameterSpec.class)).getIV();
                byte[] h = SappArrayExtKt.h(iv.length, 0, false, 3, (Object) null);
                Intrinsics.checkNotNull(iv);
                byte[] plus = ArraysKt.plus(h, iv);
                byte[] doFinal = instance.doFinal(bArr);
                Intrinsics.checkNotNullExpressionValue(doFinal, "doFinal(...)");
                byte[] plus2 = ArraysKt.plus(plus, doFinal);
                if (plus2 != null) {
                    return plus2;
                }
            }
            return new byte[0];
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            String stackTraceToString = ExceptionsKt.stackTraceToString(e);
            delegate.c("SappKeyStoreHelper", "aesEncryptData error=" + stackTraceToString);
            return new byte[0];
        }
    }

    public final SecretKey c() {
        KeyGenerator instance = KeyGenerator.getInstance("AES", "AndroidKeyStore");
        KeyGenParameterSpec build = new KeyGenParameterSpec.Builder("myvu_keystore_aes_alias", 3).setBlockModes(new String[]{"GCM"}).setEncryptionPaddings(new String[]{"NoPadding"}).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        instance.init(build);
        SecretKey generateKey = instance.generateKey();
        Intrinsics.checkNotNullExpressionValue(generateKey, "generateKey(...)");
        return generateKey;
    }

    public final SecretKey d() {
        KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
        instance.load((KeyStore.LoadStoreParameter) null);
        if (!instance.containsAlias("myvu_keystore_aes_alias")) {
            return c();
        }
        KeyStore.Entry entry = instance.getEntry("myvu_keystore_aes_alias", (KeyStore.ProtectionParameter) null);
        if (!(entry instanceof KeyStore.SecretKeyEntry)) {
            return null;
        }
        return ((KeyStore.SecretKeyEntry) entry).getSecretKey();
    }
}
