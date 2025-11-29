package io.netty.handler.codec.smtp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.MessageToMessageEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

public final class SmtpRequestEncoder extends MessageToMessageEncoder<Object> {
    private static final int CRLF_SHORT = 3338;
    private static final ByteBuf DOT_CRLF_BUFFER = Unpooled.unreleasableBuffer(Unpooled.directBuffer(3).writeByte(46).writeByte(13).writeByte(10)).asReadOnly();
    private static final byte SP = 32;
    private boolean contentExpected;

    private static void writeParameters(List<CharSequence> list, ByteBuf byteBuf, boolean z) {
        if (!list.isEmpty()) {
            if (z) {
                byteBuf.writeByte(32);
            }
            if (list instanceof RandomAccess) {
                int size = list.size() - 1;
                for (int i = 0; i < size; i++) {
                    ByteBufUtil.writeAscii(byteBuf, list.get(i));
                    byteBuf.writeByte(32);
                }
                ByteBufUtil.writeAscii(byteBuf, list.get(size));
                return;
            }
            Iterator<CharSequence> it = list.iterator();
            while (true) {
                ByteBufUtil.writeAscii(byteBuf, it.next());
                if (it.hasNext()) {
                    byteBuf.writeByte(32);
                } else {
                    return;
                }
            }
        }
    }

    public boolean acceptOutboundMessage(Object obj) throws Exception {
        return (obj instanceof SmtpRequest) || (obj instanceof SmtpContent);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void encode(io.netty.channel.ChannelHandlerContext r6, java.lang.Object r7, java.util.List<java.lang.Object> r8) throws java.lang.Exception {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.netty.handler.codec.smtp.SmtpRequest
            r1 = 0
            if (r0 == 0) goto L_0x0064
            r0 = r7
            io.netty.handler.codec.smtp.SmtpRequest r0 = (io.netty.handler.codec.smtp.SmtpRequest) r0
            boolean r2 = r5.contentExpected
            if (r2 == 0) goto L_0x0023
            io.netty.handler.codec.smtp.SmtpCommand r2 = r0.command()
            io.netty.handler.codec.smtp.SmtpCommand r3 = io.netty.handler.codec.smtp.SmtpCommand.RSET
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x001b
            r5.contentExpected = r1
            goto L_0x0023
        L_0x001b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "SmtpContent expected"
            r5.<init>(r6)
            throw r5
        L_0x0023:
            io.netty.buffer.ByteBufAllocator r6 = r6.alloc()
            io.netty.buffer.ByteBuf r6 = r6.buffer()
            r2 = 1
            io.netty.handler.codec.smtp.SmtpCommand r3 = r0.command()     // Catch:{ all -> 0x005c }
            r3.encode(r6)     // Catch:{ all -> 0x005c }
            io.netty.handler.codec.smtp.SmtpCommand r3 = r0.command()     // Catch:{ all -> 0x005c }
            io.netty.handler.codec.smtp.SmtpCommand r4 = io.netty.handler.codec.smtp.SmtpCommand.EMPTY     // Catch:{ all -> 0x005c }
            if (r3 == r4) goto L_0x003d
            r3 = r2
            goto L_0x003e
        L_0x003d:
            r3 = r1
        L_0x003e:
            java.util.List r4 = r0.parameters()     // Catch:{ all -> 0x005c }
            writeParameters(r4, r6, r3)     // Catch:{ all -> 0x005c }
            r3 = 3338(0xd0a, float:4.678E-42)
            io.netty.buffer.ByteBufUtil.writeShortBE(r6, r3)     // Catch:{ all -> 0x005c }
            r8.add(r6)     // Catch:{ all -> 0x005c }
            io.netty.handler.codec.smtp.SmtpCommand r0 = r0.command()     // Catch:{ all -> 0x005a }
            boolean r0 = r0.isContentExpected()     // Catch:{ all -> 0x005a }
            if (r0 == 0) goto L_0x0064
            r5.contentExpected = r2     // Catch:{ all -> 0x005a }
            goto L_0x0064
        L_0x005a:
            r5 = move-exception
            goto L_0x005e
        L_0x005c:
            r5 = move-exception
            r1 = r2
        L_0x005e:
            if (r1 == 0) goto L_0x0063
            r6.release()
        L_0x0063:
            throw r5
        L_0x0064:
            boolean r6 = r7 instanceof io.netty.handler.codec.smtp.SmtpContent
            if (r6 == 0) goto L_0x0092
            boolean r6 = r5.contentExpected
            if (r6 == 0) goto L_0x008a
            r6 = r7
            io.netty.handler.codec.smtp.SmtpContent r6 = (io.netty.handler.codec.smtp.SmtpContent) r6
            io.netty.buffer.ByteBuf r6 = r6.content()
            io.netty.buffer.ByteBuf r6 = r6.retain()
            r8.add(r6)
            boolean r6 = r7 instanceof io.netty.handler.codec.smtp.LastSmtpContent
            if (r6 == 0) goto L_0x0092
            io.netty.buffer.ByteBuf r6 = DOT_CRLF_BUFFER
            io.netty.buffer.ByteBuf r6 = r6.retainedDuplicate()
            r8.add(r6)
            r5.contentExpected = r1
            goto L_0x0092
        L_0x008a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "No SmtpContent expected"
            r5.<init>(r6)
            throw r5
        L_0x0092:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.smtp.SmtpRequestEncoder.encode(io.netty.channel.ChannelHandlerContext, java.lang.Object, java.util.List):void");
    }
}
