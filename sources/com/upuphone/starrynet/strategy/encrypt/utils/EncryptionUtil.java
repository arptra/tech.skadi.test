package com.upuphone.starrynet.strategy.encrypt.utils;

import com.meizu.common.util.LunarCalendar;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.strategy.encrypt.bean.KeyPair;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.UUID;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyAgreement;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionUtil {
    public static final String KEY_ALGORITHM = "EC";
    public static final String KEY_ASYMMETRIC = "ECDH";
    public static final String KEY_SYMMETRIC_V1 = "AES/CBC/PKCS5Padding";
    public static final String KEY_SYMMETRIC_V2 = "AES/CTR/NoPadding";
    public static final String KEY_SYMMETRIC_V3 = "AES/GCM/NoPadding";
    private static final String TAG = "ECUtil";

    private EncryptionUtil() {
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (!(bArr == null || bArr2 == null)) {
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
                Cipher instance = Cipher.getInstance(KEY_SYMMETRIC_V3);
                instance.init(2, secretKeySpec, ivParameterSpec);
                return instance.doFinal(bArr);
            } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
                StLog.e(TAG, "decrypt error", e);
            }
        }
        return null;
    }

    public static byte[] decryptCTR(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (!(bArr == null || bArr2 == null)) {
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
                Cipher instance = Cipher.getInstance(KEY_SYMMETRIC_V2);
                instance.init(2, secretKeySpec, ivParameterSpec);
                return instance.doFinal(bArr);
            } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
                StLog.e(TAG, "decryptCTR error", e);
            }
        }
        return null;
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (!(bArr == null || bArr2 == null)) {
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
                Cipher instance = Cipher.getInstance(KEY_SYMMETRIC_V3);
                instance.init(1, secretKeySpec, ivParameterSpec);
                return instance.doFinal(bArr);
            } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
                StLog.e(TAG, "encrypt error", e);
            }
        }
        return null;
    }

    public static byte[] encryptCTR(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (!(bArr == null || bArr2 == null)) {
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
                Cipher instance = Cipher.getInstance(KEY_SYMMETRIC_V2);
                instance.init(1, secretKeySpec, ivParameterSpec);
                return instance.doFinal(bArr);
            } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
                StLog.e(TAG, "encryptCTR error", e);
            }
        }
        return null;
    }

    public static KeyPair generateECKeyPairByPublicKey(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(bArr);
        try {
            KeyFactory instance = KeyFactory.getInstance("EC");
            ECParameterSpec params = ((ECPublicKey) instance.generatePublic(x509EncodedKeySpec)).getParams();
            KeyPairGenerator instance2 = KeyPairGenerator.getInstance(instance.getAlgorithm());
            instance2.initialize(params);
            java.security.KeyPair generateKeyPair = instance2.generateKeyPair();
            return new KeyPair(((ECPrivateKey) generateKeyPair.getPrivate()).getEncoded(), ((ECPublicKey) generateKeyPair.getPublic()).getEncoded());
        } catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            StLog.e(TAG, "generateECKeyPairByPublicKey error", e);
            return null;
        }
    }

    public static String generateIV() {
        return UUID.randomUUID().toString().replace(LunarCalendar.DATE_SEPARATOR, "").substring(0, 16);
    }

    public static KeyPair generatorECKeyPair() {
        try {
            KeyPairGenerator instance = KeyPairGenerator.getInstance("EC");
            instance.initialize(256, new SecureRandom());
            java.security.KeyPair generateKeyPair = instance.generateKeyPair();
            return new KeyPair(((ECPrivateKey) generateKeyPair.getPrivate()).getEncoded(), ((ECPublicKey) generateKeyPair.getPublic()).getEncoded());
        } catch (NoSuchAlgorithmException e) {
            StLog.e(TAG, "generatorECKeyPair NoSuchAlgorithmException error", (Throwable) e);
            return null;
        }
    }

    public static byte[] getSecretKey(byte[] bArr, byte[] bArr2) {
        if (!(bArr == null || bArr2 == null)) {
            try {
                KeyFactory instance = KeyFactory.getInstance("EC");
                PublicKey generatePublic = instance.generatePublic(new X509EncodedKeySpec(bArr));
                PrivateKey generatePrivate = instance.generatePrivate(new PKCS8EncodedKeySpec(bArr2));
                KeyAgreement instance2 = KeyAgreement.getInstance("ECDH");
                instance2.init(generatePrivate);
                instance2.doPhase(generatePublic, true);
                return instance2.generateSecret();
            } catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException e) {
                StLog.e(TAG, "getSecretKey error", e);
            }
        }
        return null;
    }

    public static String getSymmetric(int i) {
        return i == 1 ? KEY_SYMMETRIC_V1 : i == 2 ? KEY_SYMMETRIC_V2 : KEY_SYMMETRIC_V3;
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        if (!(bArr == null || bArr2 == null)) {
            String symmetric = getSymmetric(i);
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
                Cipher instance = Cipher.getInstance(symmetric);
                instance.init(2, secretKeySpec, ivParameterSpec);
                return instance.doFinal(bArr);
            } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
                StLog.e(TAG, "decrypt error", e);
            }
        }
        return null;
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        if (!(bArr == null || bArr2 == null)) {
            String symmetric = getSymmetric(i);
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
                Cipher instance = Cipher.getInstance(symmetric);
                instance.init(1, secretKeySpec, ivParameterSpec);
                return instance.doFinal(bArr);
            } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
                StLog.e(TAG, "encrypt error", e);
            }
        }
        return null;
    }
}
