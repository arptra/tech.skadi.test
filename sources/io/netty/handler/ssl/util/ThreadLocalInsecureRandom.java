package io.netty.handler.ssl.util;

import io.netty.util.internal.PlatformDependent;
import java.security.SecureRandom;
import java.util.Random;

final class ThreadLocalInsecureRandom extends SecureRandom {
    private static final SecureRandom INSTANCE = new ThreadLocalInsecureRandom();
    private static final long serialVersionUID = -8209473337192526191L;

    private ThreadLocalInsecureRandom() {
    }

    public static SecureRandom current() {
        return INSTANCE;
    }

    private static Random random() {
        return PlatformDependent.threadLocalRandom();
    }

    public byte[] generateSeed(int i) {
        byte[] bArr = new byte[i];
        random().nextBytes(bArr);
        return bArr;
    }

    public String getAlgorithm() {
        return "insecure";
    }

    public boolean nextBoolean() {
        return random().nextBoolean();
    }

    public void nextBytes(byte[] bArr) {
        random().nextBytes(bArr);
    }

    public double nextDouble() {
        return random().nextDouble();
    }

    public float nextFloat() {
        return random().nextFloat();
    }

    public double nextGaussian() {
        return random().nextGaussian();
    }

    public int nextInt() {
        return random().nextInt();
    }

    public long nextLong() {
        return random().nextLong();
    }

    public void setSeed(long j) {
    }

    public int nextInt(int i) {
        return random().nextInt(i);
    }

    public void setSeed(byte[] bArr) {
    }
}
