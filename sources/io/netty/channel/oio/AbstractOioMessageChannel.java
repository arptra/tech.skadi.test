package io.netty.channel.oio;

import io.netty.channel.Channel;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public abstract class AbstractOioMessageChannel extends AbstractOioChannel {
    private final List<Object> readBuf = new ArrayList();

    public AbstractOioMessageChannel(Channel channel) {
        super(channel);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        r5 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doRead() {
        /*
            r10 = this;
            boolean r0 = r10.readPending
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            r10.readPending = r0
            io.netty.channel.ChannelConfig r1 = r10.config()
            io.netty.channel.ChannelPipeline r2 = r10.pipeline()
            io.netty.channel.Channel$Unsafe r3 = r10.unsafe()
            io.netty.channel.RecvByteBufAllocator$Handle r3 = r3.recvBufAllocHandle()
            r3.reset(r1)
        L_0x001b:
            r4 = 1
            java.util.List<java.lang.Object> r5 = r10.readBuf     // Catch:{ all -> 0x0035 }
            int r5 = r10.doReadMessages(r5)     // Catch:{ all -> 0x0035 }
            if (r5 != 0) goto L_0x0025
            goto L_0x0032
        L_0x0025:
            if (r5 >= 0) goto L_0x0029
            r5 = r4
            goto L_0x0033
        L_0x0029:
            r3.incMessagesRead(r5)     // Catch:{ all -> 0x0035 }
            boolean r5 = r3.continueReading()     // Catch:{ all -> 0x0035 }
            if (r5 != 0) goto L_0x001b
        L_0x0032:
            r5 = r0
        L_0x0033:
            r6 = 0
            goto L_0x0038
        L_0x0035:
            r5 = move-exception
            r6 = r5
            r5 = r0
        L_0x0038:
            java.util.List<java.lang.Object> r7 = r10.readBuf
            int r7 = r7.size()
            if (r7 <= 0) goto L_0x005d
            r8 = r0
        L_0x0041:
            if (r8 >= r7) goto L_0x0051
            r10.readPending = r0
            java.util.List<java.lang.Object> r9 = r10.readBuf
            java.lang.Object r9 = r9.get(r8)
            r2.fireChannelRead(r9)
            int r8 = r8 + 1
            goto L_0x0041
        L_0x0051:
            java.util.List<java.lang.Object> r0 = r10.readBuf
            r0.clear()
            r3.readComplete()
            r2.fireChannelReadComplete()
            r0 = r4
        L_0x005d:
            if (r6 == 0) goto L_0x0069
            boolean r3 = r6 instanceof java.io.IOException
            if (r3 == 0) goto L_0x0064
            goto L_0x0065
        L_0x0064:
            r4 = r5
        L_0x0065:
            r2.fireExceptionCaught(r6)
            r5 = r4
        L_0x0069:
            if (r5 == 0) goto L_0x0081
            boolean r0 = r10.isOpen()
            if (r0 == 0) goto L_0x0096
            io.netty.channel.Channel$Unsafe r0 = r10.unsafe()
            io.netty.channel.Channel$Unsafe r10 = r10.unsafe()
            io.netty.channel.ChannelPromise r10 = r10.voidPromise()
            r0.close(r10)
            goto L_0x0096
        L_0x0081:
            boolean r2 = r10.readPending
            if (r2 != 0) goto L_0x0093
            boolean r1 = r1.isAutoRead()
            if (r1 != 0) goto L_0x0093
            if (r0 != 0) goto L_0x0096
            boolean r0 = r10.isActive()
            if (r0 == 0) goto L_0x0096
        L_0x0093:
            r10.read()
        L_0x0096:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.oio.AbstractOioMessageChannel.doRead():void");
    }

    public abstract int doReadMessages(List<Object> list) throws Exception;
}
