package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.util.UncheckedBooleanSupplier;
import io.netty.util.internal.ObjectUtil;

public abstract class DefaultMaxMessagesRecvByteBufAllocator implements MaxMessagesRecvByteBufAllocator {
    /* access modifiers changed from: private */
    public final boolean ignoreBytesRead;
    private volatile int maxMessagesPerRead;
    /* access modifiers changed from: private */
    public volatile boolean respectMaybeMoreData;

    public abstract class MaxMessageHandle implements RecvByteBufAllocator.ExtendedHandle {
        /* access modifiers changed from: private */
        public int attemptedBytesRead;
        private ChannelConfig config;
        private final UncheckedBooleanSupplier defaultMaybeMoreSupplier = new UncheckedBooleanSupplier() {
            public boolean get() {
                return MaxMessageHandle.this.attemptedBytesRead == MaxMessageHandle.this.lastBytesRead;
            }
        };
        /* access modifiers changed from: private */
        public int lastBytesRead;
        private int maxMessagePerRead;
        private final boolean respectMaybeMoreData;
        private int totalBytesRead;
        private int totalMessages;

        public MaxMessageHandle() {
            this.respectMaybeMoreData = DefaultMaxMessagesRecvByteBufAllocator.this.respectMaybeMoreData;
        }

        public ByteBuf allocate(ByteBufAllocator byteBufAllocator) {
            return byteBufAllocator.ioBuffer(guess());
        }

        public int attemptedBytesRead() {
            return this.attemptedBytesRead;
        }

        public boolean continueReading() {
            return continueReading(this.defaultMaybeMoreSupplier);
        }

        public final void incMessagesRead(int i) {
            this.totalMessages += i;
        }

        public void lastBytesRead(int i) {
            this.lastBytesRead = i;
            if (i > 0) {
                this.totalBytesRead += i;
            }
        }

        public void readComplete() {
        }

        public void reset(ChannelConfig channelConfig) {
            this.config = channelConfig;
            this.maxMessagePerRead = DefaultMaxMessagesRecvByteBufAllocator.this.maxMessagesPerRead();
            this.totalBytesRead = 0;
            this.totalMessages = 0;
        }

        public final int totalBytesRead() {
            int i = this.totalBytesRead;
            if (i < 0) {
                return Integer.MAX_VALUE;
            }
            return i;
        }

        public void attemptedBytesRead(int i) {
            this.attemptedBytesRead = i;
        }

        public boolean continueReading(UncheckedBooleanSupplier uncheckedBooleanSupplier) {
            return this.config.isAutoRead() && (!this.respectMaybeMoreData || uncheckedBooleanSupplier.get()) && this.totalMessages < this.maxMessagePerRead && (DefaultMaxMessagesRecvByteBufAllocator.this.ignoreBytesRead || this.totalBytesRead > 0);
        }

        public final int lastBytesRead() {
            return this.lastBytesRead;
        }
    }

    public DefaultMaxMessagesRecvByteBufAllocator() {
        this(1);
    }

    public int maxMessagesPerRead() {
        return this.maxMessagesPerRead;
    }

    public DefaultMaxMessagesRecvByteBufAllocator respectMaybeMoreData(boolean z) {
        this.respectMaybeMoreData = z;
        return this;
    }

    public DefaultMaxMessagesRecvByteBufAllocator(int i) {
        this(i, false);
    }

    public MaxMessagesRecvByteBufAllocator maxMessagesPerRead(int i) {
        ObjectUtil.checkPositive(i, "maxMessagesPerRead");
        this.maxMessagesPerRead = i;
        return this;
    }

    public final boolean respectMaybeMoreData() {
        return this.respectMaybeMoreData;
    }

    public DefaultMaxMessagesRecvByteBufAllocator(int i, boolean z) {
        this.respectMaybeMoreData = true;
        this.ignoreBytesRead = z;
        maxMessagesPerRead(i);
    }
}
