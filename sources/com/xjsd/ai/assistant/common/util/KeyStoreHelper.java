package com.xjsd.ai.assistant.common.util;

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

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u0007J\u0011\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u001d\u0010\u0010\u001a\u00020\u000f*\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J!\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0013\u0010\u0011J'\u0010\u0015\u001a\u00020\u0004*\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001a\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/xjsd/ai/assistant/common/util/KeyStoreHelper;", "", "<init>", "()V", "", "bytes", "b", "([B)[B", "a", "Ljavax/crypto/SecretKey;", "e", "()Ljavax/crypto/SecretKey;", "d", "", "littleEndian", "", "j", "([BZ)I", "l", "c", "size", "h", "(IIZ)[B", "value", "g", "(IZ)[B", "f", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class KeyStoreHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final KeyStoreHelper f8445a = new KeyStoreHelper();

    public static /* synthetic */ byte[] i(KeyStoreHelper keyStoreHelper, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 2;
        }
        if ((i3 & 2) != 0) {
            z = false;
        }
        return keyStoreHelper.h(i, i2, z);
    }

    public static /* synthetic */ int k(KeyStoreHelper keyStoreHelper, byte[] bArr, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return keyStoreHelper.j(bArr, z);
    }

    public final byte[] a(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        try {
            if (bArr.length != 0) {
                if (bArr.length > 2) {
                    byte[] bArr2 = null;
                    int k = k(this, ArraysKt.sliceArray(bArr, RangesKt.until(0, 2)), false, 1, (Object) null) + 2;
                    byte[] sliceArray = ArraysKt.sliceArray(bArr, RangesKt.until(2, k));
                    byte[] sliceArray2 = ArraysKt.sliceArray(bArr, RangesKt.until(k, bArr.length));
                    if (e() != null) {
                        Cipher instance = Cipher.getInstance(EncryptionUtil.KEY_SYMMETRIC_V3);
                        instance.init(2, f8445a.e(), new GCMParameterSpec(128, sliceArray));
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
            if (e() != null) {
                Cipher instance = Cipher.getInstance(EncryptionUtil.KEY_SYMMETRIC_V3);
                KeyStoreHelper keyStoreHelper = f8445a;
                instance.init(1, keyStoreHelper.e());
                byte[] iv = ((GCMParameterSpec) instance.getParameters().getParameterSpec(GCMParameterSpec.class)).getIV();
                byte[] i = i(keyStoreHelper, iv.length, 0, false, 3, (Object) null);
                Intrinsics.checkNotNull(iv);
                byte[] plus = ArraysKt.plus(i, iv);
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

    public final int c(byte[] bArr, boolean z) {
        byte b;
        int i;
        if (bArr.length != 4) {
            return 0;
        }
        if (z) {
            b = (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16);
            i = (bArr[3] & 255) << 24;
        } else {
            b = ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8);
            i = bArr[3] & 255;
        }
        return i | b;
    }

    public final SecretKey d() {
        KeyGenerator instance = KeyGenerator.getInstance("AES", "AndroidKeyStore");
        KeyGenParameterSpec build = new KeyGenParameterSpec.Builder("assistant_keystore_aes_alias", 3).setBlockModes(new String[]{"GCM"}).setEncryptionPaddings(new String[]{"NoPadding"}).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        instance.init(build);
        SecretKey generateKey = instance.generateKey();
        Intrinsics.checkNotNullExpressionValue(generateKey, "generateKey(...)");
        return generateKey;
    }

    public final SecretKey e() {
        KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
        instance.load((KeyStore.LoadStoreParameter) null);
        if (!instance.containsAlias("assistant_keystore_aes_alias")) {
            return d();
        }
        KeyStore.Entry entry = instance.getEntry("assistant_keystore_aes_alias", (KeyStore.ProtectionParameter) null);
        if (!(entry instanceof KeyStore.SecretKeyEntry)) {
            return null;
        }
        return ((KeyStore.SecretKeyEntry) entry).getSecretKey();
    }

    public final byte[] f(int i, boolean z) {
        if (z) {
            return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)};
        }
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public final byte[] g(int i, boolean z) {
        if (z) {
            return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255)};
        }
        return new byte[]{(byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public final byte[] h(int i, int i2, boolean z) {
        return (i2 == 2 || i2 == 4) ? (i2 != 2 || -32768 > i || i > 32767) ? f(i, z) : g(i, z) : new byte[0];
    }

    public final int j(byte[] bArr, boolean z) {
        return bArr.length == 2 ? l(bArr, z) : c(bArr, z);
    }

    public final int l(byte[] bArr, boolean z) {
        int i;
        int i2;
        if (bArr.length != 2) {
            return 0;
        }
        if (z) {
            i = bArr[0] & 255;
            i2 = (bArr[1] & 255) << 8;
        } else {
            i = (bArr[0] & 255) << 8;
            i2 = bArr[1] & 255;
        }
        return i2 | i;
    }
}
