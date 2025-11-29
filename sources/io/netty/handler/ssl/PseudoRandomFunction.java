package io.netty.handler.ssl;

import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

final class PseudoRandomFunction {
    private PseudoRandomFunction() {
    }

    private static byte[] concat(byte[] bArr, byte[] bArr2) {
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length + bArr2.length);
        System.arraycopy(bArr2, 0, copyOf, bArr.length, bArr2.length);
        return copyOf;
    }

    public static byte[] hash(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, String str) {
        ObjectUtil.checkPositiveOrZero(i, "length");
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(bArr, str));
            int ceil = (int) Math.ceil(((double) i) / ((double) instance.getMacLength()));
            byte[] bArr4 = EmptyArrays.EMPTY_BYTES;
            byte[] concat = concat(bArr2, bArr3);
            byte[] bArr5 = concat;
            for (int i2 = 0; i2 < ceil; i2++) {
                bArr5 = instance.doFinal(bArr5);
                bArr4 = concat(bArr4, instance.doFinal(concat(bArr5, concat)));
            }
            return Arrays.copyOf(bArr4, i);
        } catch (GeneralSecurityException e) {
            throw new IllegalArgumentException("Could not find algo: " + str, e);
        }
    }
}
