package io.netty.handler.codec.serialization;

import io.netty.channel.ChannelHandler;
import io.netty.handler.codec.MessageToByteEncoder;
import java.io.Serializable;

@ChannelHandler.Sharable
public class ObjectEncoder extends MessageToByteEncoder<Serializable> {
    private static final byte[] LENGTH_PLACEHOLDER = new byte[4];

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void encode(io.netty.channel.ChannelHandlerContext r3, java.io.Serializable r4, io.netty.buffer.ByteBuf r5) throws java.lang.Exception {
        /*
            r2 = this;
            int r2 = r5.writerIndex()
            io.netty.buffer.ByteBufOutputStream r3 = new io.netty.buffer.ByteBufOutputStream
            r3.<init>(r5)
            r0 = 0
            byte[] r1 = LENGTH_PLACEHOLDER     // Catch:{ all -> 0x002b }
            r3.write((byte[]) r1)     // Catch:{ all -> 0x002b }
            io.netty.handler.codec.serialization.CompactObjectOutputStream r1 = new io.netty.handler.codec.serialization.CompactObjectOutputStream     // Catch:{ all -> 0x002b }
            r1.<init>(r3)     // Catch:{ all -> 0x002b }
            r1.writeObject(r4)     // Catch:{ all -> 0x0028 }
            r1.flush()     // Catch:{ all -> 0x0028 }
            r1.close()
            int r3 = r5.writerIndex()
            int r3 = r3 - r2
            int r3 = r3 + -4
            r5.setInt(r2, r3)
            return
        L_0x0028:
            r2 = move-exception
            r0 = r1
            goto L_0x002c
        L_0x002b:
            r2 = move-exception
        L_0x002c:
            if (r0 == 0) goto L_0x0032
            r0.close()
            goto L_0x0035
        L_0x0032:
            r3.close()
        L_0x0035:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.serialization.ObjectEncoder.encode(io.netty.channel.ChannelHandlerContext, java.io.Serializable, io.netty.buffer.ByteBuf):void");
    }
}
