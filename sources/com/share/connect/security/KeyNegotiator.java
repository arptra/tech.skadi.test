package com.share.connect.security;

import android.content.Context;
import android.security.keystore.KeyGenParameterSpec;
import androidx.room.Room;
import com.easy.logger.EasyLog;
import com.google.crypto.tink.subtle.Bytes;
import com.google.crypto.tink.subtle.Hkdf;
import com.ucar.protocol.security.SecurityManager;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.AlgorithmParameters;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class KeyNegotiator {
    public static volatile PeerDatabase d;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f9904a;
    public byte[] b;
    public KeyPair c;

    public static class ProtoResult {
    }

    public KeyNegotiator(Context context) {
        t(context);
    }

    public static void d(String str) {
        KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
        instance.load((KeyStore.LoadStoreParameter) null);
        instance.deleteEntry(str);
    }

    public static int s() {
        return 1537;
    }

    public static void t(Context context) {
        if (d == null) {
            synchronized (KeyNegotiator.class) {
                try {
                    if (d == null) {
                        d = (PeerDatabase) Room.a(context, PeerDatabase.class, "peer.db").c().d();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static void v(byte[] bArr, String str) {
        try {
            d(str);
            d.d().a(new String(bArr, StandardCharsets.UTF_8));
        } catch (Exception e) {
            EasyLog.d("KeyNegotiator", "removePeer Exception", e);
        }
    }

    public boolean a(Key key, byte[] bArr) {
        if (this.c == null || key == null) {
            return false;
        }
        KeyAgreement instance = KeyAgreement.getInstance("ECDH");
        instance.init(this.c.getPrivate());
        instance.doPhase(key, true);
        byte[] computeHkdf = Hkdf.computeHkdf("HMACSHA256", instance.generateSecret(), MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256).digest(bArr), u("session_key"), 16);
        SecurityManager.g(computeHkdf, "session_key");
        SecurityManager.g(computeHkdf, "uibc_session_key");
        return true;
    }

    public byte[] b(String str) {
        return Base64.getDecoder().decode(str);
    }

    public final ECPublicKey c(String str, byte[] bArr) {
        AlgorithmParameters instance = AlgorithmParameters.getInstance("EC");
        instance.init(new ECGenParameterSpec(str));
        ECParameterSpec eCParameterSpec = (ECParameterSpec) instance.getParameterSpec(ECParameterSpec.class);
        int bitLength = eCParameterSpec.getOrder().bitLength() / 8;
        if (bArr.length == bitLength * 2) {
            return (ECPublicKey) KeyFactory.getInstance("EC").generatePublic(new ECPublicKeySpec(new ECPoint(new BigInteger(1, Arrays.copyOfRange(bArr, 0, bitLength)), new BigInteger(1, Arrays.copyOfRange(bArr, bitLength, bitLength + bitLength))), eCParameterSpec));
        }
        throw new RuntimeException("encoded key with wrong size");
    }

    public String e(byte[] bArr) {
        return Base64.getEncoder().encodeToString(bArr);
    }

    public byte[] f(ECPublicKey eCPublicKey) {
        int bitLength = eCPublicKey.getParams().getOrder().bitLength() / 8;
        byte[] bArr = new byte[(bitLength * 2)];
        byte[] byteArray = eCPublicKey.getW().getAffineX().toByteArray();
        if (byteArray.length <= bitLength) {
            System.arraycopy(byteArray, 0, bArr, bitLength - byteArray.length, byteArray.length);
        } else if (byteArray.length == bitLength + 1 && byteArray[0] == 0) {
            System.arraycopy(byteArray, 1, bArr, 0, bitLength);
        } else {
            throw new RuntimeException("x coordinate with wrong size: len=" + byteArray.length);
        }
        byte[] byteArray2 = eCPublicKey.getW().getAffineY().toByteArray();
        if (byteArray2.length <= bitLength) {
            System.arraycopy(byteArray2, 0, bArr, (bitLength + bitLength) - byteArray2.length, byteArray2.length);
        } else if (byteArray2.length == bitLength + 1 && byteArray2[0] == 0) {
            System.arraycopy(byteArray2, 1, bArr, bitLength, bitLength);
        } else {
            throw new RuntimeException("y coordinate with wrong size: len=" + byteArray2.length);
        }
        return bArr;
    }

    public ECPublicKey g() {
        KeyPairGenerator instance = KeyPairGenerator.getInstance("EC");
        instance.initialize(new ECGenParameterSpec("secp256r1"));
        KeyPair generateKeyPair = instance.generateKeyPair();
        this.c = generateKeyPair;
        return (ECPublicKey) generateKeyPair.getPublic();
    }

    public ECPublicKey h(String str) {
        KeyPairGenerator instance = KeyPairGenerator.getInstance("EC", "AndroidKeyStore");
        instance.initialize(new KeyGenParameterSpec.Builder(str, 12).setAlgorithmParameterSpec(new ECGenParameterSpec("secp256r1")).setDigests(new String[]{MessageDigestAlgorithms.SHA_256}).build());
        return (ECPublicKey) instance.generateKeyPair().getPublic();
    }

    public byte[] i(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = this.f9904a;
        if (bArr3 == null || bArr3.length < 6) {
            throw new Exception("pin is empty or too short when requested");
        }
        Mac instance = Mac.getInstance("HmacSHA256");
        instance.init(new SecretKeySpec(MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256).digest(Bytes.concat(bArr2, this.f9904a)), "HmacSHA256"));
        return instance.doFinal(bArr);
    }

    public byte[] j(int i) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[i];
        this.b = bArr;
        secureRandom.nextBytes(bArr);
        return this.b;
    }

    public byte[] k(String str, byte[] bArr, byte[] bArr2) {
        KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
        instance.load((KeyStore.LoadStoreParameter) null);
        KeyStore.Entry entry = instance.getEntry(str, (KeyStore.ProtectionParameter) null);
        if (entry instanceof KeyStore.PrivateKeyEntry) {
            PrivateKey privateKey = ((KeyStore.PrivateKeyEntry) entry).getPrivateKey();
            Signature instance2 = Signature.getInstance("SHA256withECDSA");
            instance2.initSign(privateKey);
            instance2.update(Bytes.concat(bArr, bArr2));
            return instance2.sign();
        }
        throw new RuntimeException("sign key not exist or invalid : " + str);
    }

    public Peer l() {
        return d.d().getLast();
    }

    public byte[] m() {
        return this.b;
    }

    public Peer n(byte[] bArr) {
        return d.d().get(new String(bArr, StandardCharsets.UTF_8));
    }

    public ECPublicKey o(byte[] bArr, byte[] bArr2, byte[] bArr3, PublicKey publicKey) {
        if (publicKey == null) {
            return null;
        }
        Signature instance = Signature.getInstance("SHA256withECDSA");
        instance.initVerify(publicKey);
        instance.update(Bytes.concat(bArr, bArr2));
        if (instance.verify(bArr3)) {
            return c("secp256r1", bArr);
        }
        return null;
    }

    public ECPublicKey p(byte[] bArr) {
        return c("secp256r1", bArr);
    }

    public ECPublicKey q(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        if (Arrays.equals(bArr4, i(Bytes.concat(bArr, bArr2), bArr3))) {
            return c("secp256r1", bArr);
        }
        return null;
    }

    public byte[] r() {
        return this.f9904a;
    }

    public byte[] u(String str) {
        if (str == null) {
            return null;
        }
        return str.getBytes(StandardCharsets.UTF_8);
    }

    public boolean w(byte[] bArr, byte[] bArr2) {
        Peer peer = new Peer();
        peer.f9905a = new String(bArr, StandardCharsets.UTF_8);
        peer.b = e(bArr2);
        peer.c = System.currentTimeMillis() / 1000;
        d.d().b(peer);
        return true;
    }

    public void x(byte[] bArr) {
        this.f9904a = bArr;
    }

    public boolean y(byte[] bArr) {
        return d.d().c(new String(bArr, StandardCharsets.UTF_8)) > 0;
    }
}
