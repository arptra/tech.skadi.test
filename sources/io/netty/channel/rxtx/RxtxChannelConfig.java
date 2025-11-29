package io.netty.channel.rxtx;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelConfig;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;

@Deprecated
public interface RxtxChannelConfig extends ChannelConfig {

    public enum Databits {
        DATABITS_5(5),
        DATABITS_6(6),
        DATABITS_7(7),
        DATABITS_8(8);
        
        private final int value;

        private Databits(int i) {
            this.value = i;
        }

        public int value() {
            return this.value;
        }

        public static Databits valueOf(int i) {
            for (Databits databits : values()) {
                if (databits.value == i) {
                    return databits;
                }
            }
            throw new IllegalArgumentException("unknown " + Databits.class.getSimpleName() + " value: " + i);
        }
    }

    public enum Paritybit {
        NONE(0),
        ODD(1),
        EVEN(2),
        MARK(3),
        SPACE(4);
        
        private final int value;

        private Paritybit(int i) {
            this.value = i;
        }

        public int value() {
            return this.value;
        }

        public static Paritybit valueOf(int i) {
            for (Paritybit paritybit : values()) {
                if (paritybit.value == i) {
                    return paritybit;
                }
            }
            throw new IllegalArgumentException("unknown " + Paritybit.class.getSimpleName() + " value: " + i);
        }
    }

    public enum Stopbits {
        STOPBITS_1(1),
        STOPBITS_2(2),
        STOPBITS_1_5(3);
        
        private final int value;

        private Stopbits(int i) {
            this.value = i;
        }

        public int value() {
            return this.value;
        }

        public static Stopbits valueOf(int i) {
            for (Stopbits stopbits : values()) {
                if (stopbits.value == i) {
                    return stopbits;
                }
            }
            throw new IllegalArgumentException("unknown " + Stopbits.class.getSimpleName() + " value: " + i);
        }
    }

    int getBaudrate();

    Databits getDatabits();

    Paritybit getParitybit();

    int getReadTimeout();

    Stopbits getStopbits();

    int getWaitTimeMillis();

    boolean isDtr();

    boolean isRts();

    RxtxChannelConfig setAllocator(ByteBufAllocator byteBufAllocator);

    RxtxChannelConfig setAutoClose(boolean z);

    RxtxChannelConfig setAutoRead(boolean z);

    RxtxChannelConfig setBaudrate(int i);

    RxtxChannelConfig setConnectTimeoutMillis(int i);

    RxtxChannelConfig setDatabits(Databits databits);

    RxtxChannelConfig setDtr(boolean z);

    @Deprecated
    RxtxChannelConfig setMaxMessagesPerRead(int i);

    RxtxChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator);

    RxtxChannelConfig setParitybit(Paritybit paritybit);

    RxtxChannelConfig setReadTimeout(int i);

    RxtxChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator);

    RxtxChannelConfig setRts(boolean z);

    RxtxChannelConfig setStopbits(Stopbits stopbits);

    RxtxChannelConfig setWaitTimeMillis(int i);

    RxtxChannelConfig setWriteBufferHighWaterMark(int i);

    RxtxChannelConfig setWriteBufferLowWaterMark(int i);

    RxtxChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark);

    RxtxChannelConfig setWriteSpinCount(int i);
}
