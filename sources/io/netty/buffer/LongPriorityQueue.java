package io.netty.buffer;

import java.util.Arrays;

final class LongPriorityQueue {
    public static final int NO_VALUE = -1;
    private long[] array = new long[9];
    private int size;

    private void lift(int i) {
        while (i > 1) {
            int i2 = i >> 1;
            if (subord(i2, i)) {
                swap(i, i2);
                i = i2;
            } else {
                return;
            }
        }
    }

    private void sink(int i) {
        while (true) {
            int i2 = i << 1;
            int i3 = this.size;
            if (i2 <= i3) {
                if (i2 < i3) {
                    int i4 = i2 + 1;
                    if (subord(i2, i4)) {
                        i2 = i4;
                    }
                }
                if (subord(i, i2)) {
                    swap(i, i2);
                    i = i2;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private boolean subord(int i, int i2) {
        long[] jArr = this.array;
        return jArr[i] > jArr[i2];
    }

    private void swap(int i, int i2) {
        long[] jArr = this.array;
        long j = jArr[i];
        jArr[i] = jArr[i2];
        jArr[i2] = j;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void offer(long j) {
        if (j != -1) {
            int i = this.size + 1;
            this.size = i;
            long[] jArr = this.array;
            if (i == jArr.length) {
                this.array = Arrays.copyOf(jArr, ((jArr.length - 1) * 2) + 1);
            }
            long[] jArr2 = this.array;
            int i2 = this.size;
            jArr2[i2] = j;
            lift(i2);
            return;
        }
        throw new IllegalArgumentException("The NO_VALUE (-1) cannot be added to the queue.");
    }

    public long peek() {
        if (this.size == 0) {
            return -1;
        }
        return this.array[1];
    }

    public long poll() {
        int i = this.size;
        if (i == 0) {
            return -1;
        }
        long[] jArr = this.array;
        long j = jArr[1];
        jArr[1] = jArr[i];
        jArr[i] = 0;
        this.size = i - 1;
        sink(1);
        return j;
    }

    public void remove(long j) {
        int i = 1;
        while (true) {
            int i2 = this.size;
            if (i <= i2) {
                long[] jArr = this.array;
                if (jArr[i] == j) {
                    this.size = i2 - 1;
                    jArr[i] = jArr[i2];
                    lift(i);
                    sink(i);
                    return;
                }
                i++;
            } else {
                return;
            }
        }
    }
}
