package io.netty.handler.flow;

import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayDeque;

public class FlowControlHandler extends ChannelDuplexHandler {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) FlowControlHandler.class);
    private ChannelConfig config;
    private RecyclableArrayDeque queue;
    private final boolean releaseMessages;
    private boolean shouldConsume;

    public static final class RecyclableArrayDeque extends ArrayDeque<Object> {
        private static final int DEFAULT_NUM_ELEMENTS = 2;
        private static final ObjectPool<RecyclableArrayDeque> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<RecyclableArrayDeque>() {
            public RecyclableArrayDeque newObject(ObjectPool.Handle<RecyclableArrayDeque> handle) {
                return new RecyclableArrayDeque(2, handle);
            }
        });
        private static final long serialVersionUID = 0;
        private final ObjectPool.Handle<RecyclableArrayDeque> handle;

        public static RecyclableArrayDeque newInstance() {
            return RECYCLER.get();
        }

        public void recycle() {
            clear();
            this.handle.recycle(this);
        }

        private RecyclableArrayDeque(int i, ObjectPool.Handle<RecyclableArrayDeque> handle2) {
            super(i);
            this.handle = handle2;
        }
    }

    public FlowControlHandler() {
        this(true);
    }

    private int dequeue(ChannelHandlerContext channelHandlerContext, int i) {
        Object poll;
        int i2 = 0;
        while (this.queue != null && ((i2 < i || this.config.isAutoRead()) && (poll = this.queue.poll()) != null)) {
            i2++;
            channelHandlerContext.fireChannelRead(poll);
        }
        RecyclableArrayDeque recyclableArrayDeque = this.queue;
        if (recyclableArrayDeque != null && recyclableArrayDeque.isEmpty()) {
            this.queue.recycle();
            this.queue = null;
            if (i2 > 0) {
                channelHandlerContext.fireChannelReadComplete();
            }
        }
        return i2;
    }

    private void destroy() {
        RecyclableArrayDeque recyclableArrayDeque = this.queue;
        if (recyclableArrayDeque != null) {
            if (!recyclableArrayDeque.isEmpty()) {
                logger.trace("Non-empty queue: {}", (Object) this.queue);
                if (this.releaseMessages) {
                    while (true) {
                        Object poll = this.queue.poll();
                        if (poll == null) {
                            break;
                        }
                        ReferenceCountUtil.safeRelease(poll);
                    }
                }
            }
            this.queue.recycle();
            this.queue = null;
        }
    }

    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        destroy();
        channelHandlerContext.fireChannelInactive();
    }

    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (this.queue == null) {
            this.queue = RecyclableArrayDeque.newInstance();
        }
        this.queue.offer(obj);
        boolean z = this.shouldConsume;
        this.shouldConsume = false;
        dequeue(channelHandlerContext, z ? 1 : 0);
    }

    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (isQueueEmpty()) {
            channelHandlerContext.fireChannelReadComplete();
        }
    }

    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.config = channelHandlerContext.channel().config();
    }

    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        super.handlerRemoved(channelHandlerContext);
        if (!isQueueEmpty()) {
            dequeue(channelHandlerContext, this.queue.size());
        }
        destroy();
    }

    public boolean isQueueEmpty() {
        RecyclableArrayDeque recyclableArrayDeque = this.queue;
        return recyclableArrayDeque == null || recyclableArrayDeque.isEmpty();
    }

    public void read(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (dequeue(channelHandlerContext, 1) == 0) {
            this.shouldConsume = true;
            channelHandlerContext.read();
        }
    }

    public FlowControlHandler(boolean z) {
        this.releaseMessages = z;
    }
}
