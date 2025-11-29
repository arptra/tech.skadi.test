package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.CombinedChannelDuplexHandler;
import io.netty.handler.codec.PrematureChannelClosureException;
import io.netty.handler.codec.memcache.LastMemcacheContent;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public final class BinaryMemcacheClientCodec extends CombinedChannelDuplexHandler<BinaryMemcacheResponseDecoder, BinaryMemcacheRequestEncoder> {
    /* access modifiers changed from: private */
    public final boolean failOnMissingResponse;
    /* access modifiers changed from: private */
    public final AtomicLong requestResponseCounter;

    public final class Decoder extends BinaryMemcacheResponseDecoder {
        public Decoder(int i) {
            super(i);
        }

        public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
            super.channelInactive(channelHandlerContext);
            if (BinaryMemcacheClientCodec.this.failOnMissingResponse) {
                long j = BinaryMemcacheClientCodec.this.requestResponseCounter.get();
                if (j > 0) {
                    channelHandlerContext.fireExceptionCaught(new PrematureChannelClosureException("channel gone inactive with " + j + " missing response(s)"));
                }
            }
        }

        public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
            super.decode(channelHandlerContext, byteBuf, list);
            if (BinaryMemcacheClientCodec.this.failOnMissingResponse) {
                int size = list.size();
                for (int size2 = list.size(); size2 < size; size2++) {
                    if (list.get(size2) instanceof LastMemcacheContent) {
                        BinaryMemcacheClientCodec.this.requestResponseCounter.decrementAndGet();
                    }
                }
            }
        }
    }

    public final class Encoder extends BinaryMemcacheRequestEncoder {
        private Encoder() {
        }

        public void encode(ChannelHandlerContext channelHandlerContext, Object obj, List<Object> list) throws Exception {
            super.encode(channelHandlerContext, obj, list);
            if (BinaryMemcacheClientCodec.this.failOnMissingResponse && (obj instanceof LastMemcacheContent)) {
                BinaryMemcacheClientCodec.this.requestResponseCounter.incrementAndGet();
            }
        }
    }

    public BinaryMemcacheClientCodec() {
        this(8192);
    }

    public BinaryMemcacheClientCodec(int i) {
        this(i, false);
    }

    public BinaryMemcacheClientCodec(int i, boolean z) {
        this.requestResponseCounter = new AtomicLong();
        this.failOnMissingResponse = z;
        init(new Decoder(i), new Encoder());
    }
}
