package com.google.crypto.tink.subtle;

import com.google.crypto.tink.config.TinkFips;
import com.google.crypto.tink.prf.Prf;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;

@Immutable
public final class PrfHmacJce implements Prf {
    public static final TinkFips.AlgorithmFipsCompatibility FIPS = TinkFips.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    static final int MIN_KEY_SIZE_IN_BYTES = 16;
    /* access modifiers changed from: private */
    public final String algorithm;
    /* access modifiers changed from: private */
    public final Key key;
    private final ThreadLocal<Mac> localMac;
    private final int maxOutputLength;

    public PrfHmacJce(String str, Key key2) throws GeneralSecurityException {
        AnonymousClass1 r0 = new ThreadLocal<Mac>() {
            public Mac initialValue() {
                try {
                    Mac instance = EngineFactory.MAC.getInstance(PrfHmacJce.this.algorithm);
                    instance.init(PrfHmacJce.this.key);
                    return instance;
                } catch (GeneralSecurityException e) {
                    throw new IllegalStateException(e);
                }
            }
        };
        this.localMac = r0;
        if (FIPS.isCompatible()) {
            this.algorithm = str;
            this.key = key2;
            if (key2.getEncoded().length >= 16) {
                str.hashCode();
                char c = 65535;
                switch (str.hashCode()) {
                    case -1823053428:
                        if (str.equals("HMACSHA1")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 392315023:
                        if (str.equals("HMACSHA224")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 392315118:
                        if (str.equals("HMACSHA256")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 392316170:
                        if (str.equals("HMACSHA384")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 392317873:
                        if (str.equals("HMACSHA512")) {
                            c = 4;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        this.maxOutputLength = 20;
                        break;
                    case 1:
                        this.maxOutputLength = 28;
                        break;
                    case 2:
                        this.maxOutputLength = 32;
                        break;
                    case 3:
                        this.maxOutputLength = 48;
                        break;
                    case 4:
                        this.maxOutputLength = 64;
                        break;
                    default:
                        throw new NoSuchAlgorithmException("unknown Hmac algorithm: " + str);
                }
                r0.get();
                return;
            }
            throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
        }
        throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
    }

    public byte[] compute(byte[] bArr, int i) throws GeneralSecurityException {
        if (i <= this.maxOutputLength) {
            this.localMac.get().update(bArr);
            return Arrays.copyOf(this.localMac.get().doFinal(), i);
        }
        throw new InvalidAlgorithmParameterException("tag size too big");
    }

    public int getMaxOutputLength() {
        return this.maxOutputLength;
    }
}
