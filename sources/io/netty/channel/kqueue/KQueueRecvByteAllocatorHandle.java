package io.netty.channel.kqueue;

import com.here.posclient.UpdateOptions;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelConfig;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.unix.PreferredDirectByteBufAllocator;
import io.netty.util.UncheckedBooleanSupplier;

final class KQueueRecvByteAllocatorHandle extends RecvByteBufAllocator.DelegatingHandle implements RecvByteBufAllocator.ExtendedHandle {
    private final UncheckedBooleanSupplier defaultMaybeMoreDataSupplier = new UncheckedBooleanSupplier() {
        public boolean get() {
            return KQueueRecvByteAllocatorHandle.this.maybeMoreDataToRead();
        }
    };
    private long numberBytesPending;
    private boolean overrideGuess;
    private final PreferredDirectByteBufAllocator preferredDirectByteBufAllocator = new PreferredDirectByteBufAllocator();
    private boolean readEOF;

    public KQueueRecvByteAllocatorHandle(RecvByteBufAllocator.ExtendedHandle extendedHandle) {
        super(extendedHandle);
    }

    private int guess0() {
        return (int) Math.min(this.numberBytesPending, UpdateOptions.SOURCE_ANY);
    }

    public ByteBuf allocate(ByteBufAllocator byteBufAllocator) {
        this.preferredDirectByteBufAllocator.updateAllocator(byteBufAllocator);
        return this.overrideGuess ? this.preferredDirectByteBufAllocator.ioBuffer(guess0()) : delegate().allocate(this.preferredDirectByteBufAllocator);
    }

    public boolean continueReading(UncheckedBooleanSupplier uncheckedBooleanSupplier) {
        return ((RecvByteBufAllocator.ExtendedHandle) delegate()).continueReading(uncheckedBooleanSupplier);
    }

    public int guess() {
        return this.overrideGuess ? guess0() : delegate().guess();
    }

    public boolean isReadEOF() {
        return this.readEOF;
    }

    public void lastBytesRead(int i) {
        long j = 0;
        if (i >= 0) {
            j = Math.max(0, this.numberBytesPending - ((long) i));
        }
        this.numberBytesPending = j;
        delegate().lastBytesRead(i);
    }

    public boolean maybeMoreDataToRead() {
        return this.numberBytesPending != 0;
    }

    public void numberBytesPending(long j) {
        this.numberBytesPending = j;
    }

    public void readEOF() {
        this.readEOF = true;
    }

    public void reset(ChannelConfig channelConfig) {
        this.overrideGuess = ((KQueueChannelConfig) channelConfig).getRcvAllocTransportProvidesGuess();
        delegate().reset(channelConfig);
    }

    public boolean continueReading() {
        return continueReading(this.defaultMaybeMoreDataSupplier);
    }
}
