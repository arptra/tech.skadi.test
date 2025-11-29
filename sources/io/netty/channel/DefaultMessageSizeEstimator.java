package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.MessageSizeEstimator;
import io.netty.util.internal.ObjectUtil;

public final class DefaultMessageSizeEstimator implements MessageSizeEstimator {
    public static final MessageSizeEstimator DEFAULT = new DefaultMessageSizeEstimator(8);
    private final MessageSizeEstimator.Handle handle;

    public static final class HandleImpl implements MessageSizeEstimator.Handle {
        private final int unknownSize;

        public int size(Object obj) {
            if (obj instanceof ByteBuf) {
                return ((ByteBuf) obj).readableBytes();
            }
            if (obj instanceof ByteBufHolder) {
                return ((ByteBufHolder) obj).content().readableBytes();
            }
            if (obj instanceof FileRegion) {
                return 0;
            }
            return this.unknownSize;
        }

        private HandleImpl(int i) {
            this.unknownSize = i;
        }
    }

    public DefaultMessageSizeEstimator(int i) {
        ObjectUtil.checkPositiveOrZero(i, "unknownSize");
        this.handle = new HandleImpl(i);
    }

    public MessageSizeEstimator.Handle newHandle() {
        return this.handle;
    }
}
