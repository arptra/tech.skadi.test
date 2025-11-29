package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.UncheckedBooleanSupplier;
import io.netty.util.internal.ObjectUtil;

public interface RecvByteBufAllocator {

    public static class DelegatingHandle implements Handle {
        private final Handle delegate;

        public DelegatingHandle(Handle handle) {
            this.delegate = (Handle) ObjectUtil.checkNotNull(handle, "delegate");
        }

        public ByteBuf allocate(ByteBufAllocator byteBufAllocator) {
            return this.delegate.allocate(byteBufAllocator);
        }

        public int attemptedBytesRead() {
            return this.delegate.attemptedBytesRead();
        }

        public boolean continueReading() {
            return this.delegate.continueReading();
        }

        public final Handle delegate() {
            return this.delegate;
        }

        public int guess() {
            return this.delegate.guess();
        }

        public void incMessagesRead(int i) {
            this.delegate.incMessagesRead(i);
        }

        public void lastBytesRead(int i) {
            this.delegate.lastBytesRead(i);
        }

        public void readComplete() {
            this.delegate.readComplete();
        }

        public void reset(ChannelConfig channelConfig) {
            this.delegate.reset(channelConfig);
        }

        public void attemptedBytesRead(int i) {
            this.delegate.attemptedBytesRead(i);
        }

        public int lastBytesRead() {
            return this.delegate.lastBytesRead();
        }
    }

    public interface ExtendedHandle extends Handle {
        boolean continueReading(UncheckedBooleanSupplier uncheckedBooleanSupplier);
    }

    @Deprecated
    public interface Handle {
        ByteBuf allocate(ByteBufAllocator byteBufAllocator);

        int attemptedBytesRead();

        void attemptedBytesRead(int i);

        boolean continueReading();

        int guess();

        void incMessagesRead(int i);

        int lastBytesRead();

        void lastBytesRead(int i);

        void readComplete();

        void reset(ChannelConfig channelConfig);
    }

    Handle newHandle();
}
