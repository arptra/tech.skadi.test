package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.util.UncheckedBooleanSupplier;
import io.netty.util.internal.ObjectUtil;
import java.util.AbstractMap;
import java.util.Map;

public class DefaultMaxBytesRecvByteBufAllocator implements MaxBytesRecvByteBufAllocator {
    private volatile int maxBytesPerIndividualRead;
    private volatile int maxBytesPerRead;

    public final class HandleImpl implements RecvByteBufAllocator.ExtendedHandle {
        /* access modifiers changed from: private */
        public int attemptBytesRead;
        private int bytesToRead;
        private final UncheckedBooleanSupplier defaultMaybeMoreSupplier;
        private int individualReadMax;
        /* access modifiers changed from: private */
        public int lastBytesRead;

        private HandleImpl() {
            this.defaultMaybeMoreSupplier = new UncheckedBooleanSupplier() {
                public boolean get() {
                    return HandleImpl.this.attemptBytesRead == HandleImpl.this.lastBytesRead;
                }
            };
        }

        public ByteBuf allocate(ByteBufAllocator byteBufAllocator) {
            return byteBufAllocator.ioBuffer(guess());
        }

        public void attemptedBytesRead(int i) {
            this.attemptBytesRead = i;
        }

        public boolean continueReading() {
            return continueReading(this.defaultMaybeMoreSupplier);
        }

        public int guess() {
            return Math.min(this.individualReadMax, this.bytesToRead);
        }

        public void incMessagesRead(int i) {
        }

        public void lastBytesRead(int i) {
            this.lastBytesRead = i;
            this.bytesToRead -= i;
        }

        public void readComplete() {
        }

        public void reset(ChannelConfig channelConfig) {
            this.bytesToRead = DefaultMaxBytesRecvByteBufAllocator.this.maxBytesPerRead();
            this.individualReadMax = DefaultMaxBytesRecvByteBufAllocator.this.maxBytesPerIndividualRead();
        }

        public int attemptedBytesRead() {
            return this.attemptBytesRead;
        }

        public boolean continueReading(UncheckedBooleanSupplier uncheckedBooleanSupplier) {
            return this.bytesToRead > 0 && uncheckedBooleanSupplier.get();
        }

        public int lastBytesRead() {
            return this.lastBytesRead;
        }
    }

    public DefaultMaxBytesRecvByteBufAllocator() {
        this(65536, 65536);
    }

    private static void checkMaxBytesPerReadPair(int i, int i2) {
        ObjectUtil.checkPositive(i, "maxBytesPerRead");
        ObjectUtil.checkPositive(i2, "maxBytesPerIndividualRead");
        if (i < i2) {
            throw new IllegalArgumentException("maxBytesPerRead cannot be less than maxBytesPerIndividualRead (" + i2 + "): " + i);
        }
    }

    public RecvByteBufAllocator.Handle newHandle() {
        return new HandleImpl();
    }

    public DefaultMaxBytesRecvByteBufAllocator(int i, int i2) {
        checkMaxBytesPerReadPair(i, i2);
        this.maxBytesPerRead = i;
        this.maxBytesPerIndividualRead = i2;
    }

    public int maxBytesPerIndividualRead() {
        return this.maxBytesPerIndividualRead;
    }

    public int maxBytesPerRead() {
        return this.maxBytesPerRead;
    }

    public synchronized Map.Entry<Integer, Integer> maxBytesPerReadPair() {
        return new AbstractMap.SimpleEntry(Integer.valueOf(this.maxBytesPerRead), Integer.valueOf(this.maxBytesPerIndividualRead));
    }

    public DefaultMaxBytesRecvByteBufAllocator maxBytesPerIndividualRead(int i) {
        ObjectUtil.checkPositive(i, "maxBytesPerIndividualRead");
        synchronized (this) {
            try {
                int maxBytesPerRead2 = maxBytesPerRead();
                if (i <= maxBytesPerRead2) {
                    this.maxBytesPerIndividualRead = i;
                } else {
                    throw new IllegalArgumentException("maxBytesPerIndividualRead cannot be greater than maxBytesPerRead (" + maxBytesPerRead2 + "): " + i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this;
    }

    public DefaultMaxBytesRecvByteBufAllocator maxBytesPerRead(int i) {
        ObjectUtil.checkPositive(i, "maxBytesPerRead");
        synchronized (this) {
            try {
                int maxBytesPerIndividualRead2 = maxBytesPerIndividualRead();
                if (i >= maxBytesPerIndividualRead2) {
                    this.maxBytesPerRead = i;
                } else {
                    throw new IllegalArgumentException("maxBytesPerRead cannot be less than maxBytesPerIndividualRead (" + maxBytesPerIndividualRead2 + "): " + i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this;
    }

    public DefaultMaxBytesRecvByteBufAllocator maxBytesPerReadPair(int i, int i2) {
        checkMaxBytesPerReadPair(i, i2);
        synchronized (this) {
            this.maxBytesPerRead = i;
            this.maxBytesPerIndividualRead = i2;
        }
        return this;
    }
}
