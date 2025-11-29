package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.config.TinkFips;
import com.google.crypto.tink.subtle.EngineWrapper;
import com.google.crypto.tink.subtle.Enums;
import com.google.errorprone.annotations.Immutable;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.Cipher;

@Immutable
public final class RsaSsaPssSignJce implements PublicKeySign {
    public static final TinkFips.AlgorithmFipsCompatibility FIPS = TinkFips.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private static final String RAW_RSA_ALGORITHM = "RSA/ECB/NOPADDING";
    private final Enums.HashType mgf1Hash;
    private final RSAPrivateCrtKey privateKey;
    private final RSAPublicKey publicKey;
    private final int saltLength;
    private final Enums.HashType sigHash;

    public RsaSsaPssSignJce(RSAPrivateCrtKey rSAPrivateCrtKey, Enums.HashType hashType, Enums.HashType hashType2, int i) throws GeneralSecurityException {
        if (FIPS.isCompatible()) {
            Validators.validateSignatureHash(hashType);
            Validators.validateRsaModulusSize(rSAPrivateCrtKey.getModulus().bitLength());
            Validators.validateRsaPublicExponent(rSAPrivateCrtKey.getPublicExponent());
            this.privateKey = rSAPrivateCrtKey;
            this.publicKey = (RSAPublicKey) EngineFactory.KEY_FACTORY.getInstance("RSA").generatePublic(new RSAPublicKeySpec(rSAPrivateCrtKey.getModulus(), rSAPrivateCrtKey.getPublicExponent()));
            this.sigHash = hashType;
            this.mgf1Hash = hashType2;
            this.saltLength = i;
            return;
        }
        throw new GeneralSecurityException("Can not use RSA PSS in FIPS-mode, as BoringCrypto module is not available.");
    }

    private byte[] emsaPssEncode(byte[] bArr, int i) throws GeneralSecurityException {
        Validators.validateSignatureHash(this.sigHash);
        MessageDigest instance = EngineFactory.MESSAGE_DIGEST.getInstance(SubtleUtil.toDigestAlgo(this.sigHash));
        byte[] digest = instance.digest(bArr);
        int digestLength = instance.getDigestLength();
        int i2 = ((i - 1) / 8) + 1;
        int i3 = this.saltLength;
        if (i2 >= digestLength + i3 + 2) {
            byte[] randBytes = Random.randBytes(i3);
            int i4 = digestLength + 8;
            byte[] bArr2 = new byte[(this.saltLength + i4)];
            System.arraycopy(digest, 0, bArr2, 8, digestLength);
            System.arraycopy(randBytes, 0, bArr2, i4, randBytes.length);
            byte[] digest2 = instance.digest(bArr2);
            int i5 = (i2 - digestLength) - 1;
            byte[] bArr3 = new byte[i5];
            int i6 = this.saltLength;
            bArr3[((i2 - i6) - digestLength) - 2] = 1;
            System.arraycopy(randBytes, 0, bArr3, ((i2 - i6) - digestLength) - 1, randBytes.length);
            byte[] mgf1 = SubtleUtil.mgf1(digest2, i5, this.mgf1Hash);
            byte[] bArr4 = new byte[i5];
            for (int i7 = 0; i7 < i5; i7++) {
                bArr4[i7] = (byte) (bArr3[i7] ^ mgf1[i7]);
            }
            for (int i8 = 0; ((long) i8) < (((long) i2) * 8) - ((long) i); i8++) {
                int i9 = i8 / 8;
                bArr4[i9] = (byte) ((~(1 << (7 - (i8 % 8)))) & bArr4[i9]);
            }
            int i10 = digestLength + i5;
            byte[] bArr5 = new byte[(i10 + 1)];
            System.arraycopy(bArr4, 0, bArr5, 0, i5);
            System.arraycopy(digest2, 0, bArr5, i5, digest2.length);
            bArr5[i10] = -68;
            return bArr5;
        }
        throw new GeneralSecurityException("encoding error");
    }

    private byte[] rsasp1(byte[] bArr) throws GeneralSecurityException {
        EngineFactory<EngineWrapper.TCipher, Cipher> engineFactory = EngineFactory.CIPHER;
        Cipher instance = engineFactory.getInstance(RAW_RSA_ALGORITHM);
        instance.init(2, this.privateKey);
        byte[] doFinal = instance.doFinal(bArr);
        Cipher instance2 = engineFactory.getInstance(RAW_RSA_ALGORITHM);
        instance2.init(1, this.publicKey);
        if (new BigInteger(1, bArr).equals(new BigInteger(1, instance2.doFinal(doFinal)))) {
            return doFinal;
        }
        throw new RuntimeException("Security bug: RSA signature computation error");
    }

    public byte[] sign(byte[] bArr) throws GeneralSecurityException {
        return rsasp1(emsaPssEncode(bArr, this.publicKey.getModulus().bitLength() - 1));
    }
}
