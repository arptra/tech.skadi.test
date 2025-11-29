package com.google.crypto.tink.subtle;

import com.upuphone.starrynet.strategy.pair.ble.RingSecurityPair;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

abstract class ChaCha20Base implements IndCpaCipher {
    public static final int BLOCK_SIZE_IN_BYTES = 64;
    public static final int BLOCK_SIZE_IN_INTS = 16;
    public static final int KEY_SIZE_IN_BYTES = 32;
    public static final int KEY_SIZE_IN_INTS = 8;
    private static final int[] SIGMA = toIntArray(new byte[]{101, 120, RingSecurityPair.OPCODE_RING_PAIR, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107});
    private final int initialCounter;
    int[] key;

    public ChaCha20Base(byte[] bArr, int i) throws InvalidKeyException {
        if (bArr.length == 32) {
            this.key = toIntArray(bArr);
            this.initialCounter = i;
            return;
        }
        throw new InvalidKeyException("The key length in bytes must be 32.");
    }

    private void process(byte[] bArr, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws GeneralSecurityException {
        int remaining = byteBuffer2.remaining();
        int i = remaining / 64;
        int i2 = i + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            ByteBuffer chacha20Block = chacha20Block(bArr, this.initialCounter + i3);
            if (i3 == i) {
                Bytes.xor(byteBuffer, byteBuffer2, chacha20Block, remaining % 64);
            } else {
                Bytes.xor(byteBuffer, byteBuffer2, chacha20Block, 64);
            }
        }
    }

    public static void quarterRound(int[] iArr, int i, int i2, int i3, int i4) {
        int i5 = iArr[i] + iArr[i2];
        iArr[i] = i5;
        int rotateLeft = rotateLeft(i5 ^ iArr[i4], 16);
        iArr[i4] = rotateLeft;
        int i6 = iArr[i3] + rotateLeft;
        iArr[i3] = i6;
        int rotateLeft2 = rotateLeft(iArr[i2] ^ i6, 12);
        iArr[i2] = rotateLeft2;
        int i7 = iArr[i] + rotateLeft2;
        iArr[i] = i7;
        int rotateLeft3 = rotateLeft(iArr[i4] ^ i7, 8);
        iArr[i4] = rotateLeft3;
        int i8 = iArr[i3] + rotateLeft3;
        iArr[i3] = i8;
        iArr[i2] = rotateLeft(iArr[i2] ^ i8, 7);
    }

    private static int rotateLeft(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    public static void setSigmaAndKey(int[] iArr, int[] iArr2) {
        int[] iArr3 = SIGMA;
        System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
        System.arraycopy(iArr2, 0, iArr, iArr3.length, 8);
    }

    public static void shuffleState(int[] iArr) {
        int[] iArr2 = iArr;
        for (int i = 0; i < 10; i++) {
            quarterRound(iArr2, 0, 4, 8, 12);
            quarterRound(iArr2, 1, 5, 9, 13);
            quarterRound(iArr2, 2, 6, 10, 14);
            quarterRound(iArr2, 3, 7, 11, 15);
            quarterRound(iArr2, 0, 5, 10, 15);
            quarterRound(iArr2, 1, 6, 11, 12);
            quarterRound(iArr2, 2, 7, 8, 13);
            quarterRound(iArr2, 3, 4, 9, 14);
        }
    }

    public static int[] toIntArray(byte[] bArr) {
        IntBuffer asIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        return iArr;
    }

    public ByteBuffer chacha20Block(byte[] bArr, int i) {
        int[] createInitialState = createInitialState(toIntArray(bArr), i);
        int[] iArr = (int[]) createInitialState.clone();
        shuffleState(iArr);
        for (int i2 = 0; i2 < createInitialState.length; i2++) {
            createInitialState[i2] = createInitialState[i2] + iArr[i2];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(createInitialState, 0, 16);
        return order;
    }

    public abstract int[] createInitialState(int[] iArr, int i);

    public byte[] decrypt(byte[] bArr) throws GeneralSecurityException {
        return decrypt(ByteBuffer.wrap(bArr));
    }

    public byte[] encrypt(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length <= Integer.MAX_VALUE - nonceSizeInBytes()) {
            ByteBuffer allocate = ByteBuffer.allocate(nonceSizeInBytes() + bArr.length);
            encrypt(allocate, bArr);
            return allocate.array();
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    public abstract int nonceSizeInBytes();

    public byte[] decrypt(ByteBuffer byteBuffer) throws GeneralSecurityException {
        if (byteBuffer.remaining() >= nonceSizeInBytes()) {
            byte[] bArr = new byte[nonceSizeInBytes()];
            byteBuffer.get(bArr);
            ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
            process(bArr, allocate, byteBuffer);
            return allocate.array();
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    public void encrypt(ByteBuffer byteBuffer, byte[] bArr) throws GeneralSecurityException {
        if (byteBuffer.remaining() - nonceSizeInBytes() >= bArr.length) {
            byte[] randBytes = Random.randBytes(nonceSizeInBytes());
            byteBuffer.put(randBytes);
            process(randBytes, byteBuffer, ByteBuffer.wrap(bArr));
            return;
        }
        throw new IllegalArgumentException("Given ByteBuffer output is too small");
    }
}
