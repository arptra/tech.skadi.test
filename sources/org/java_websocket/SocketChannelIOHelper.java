package org.java_websocket;

import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;

public class SocketChannelIOHelper {
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0070 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(org.java_websocket.WebSocketImpl r4, java.nio.channels.ByteChannel r5) {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.util.concurrent.BlockingQueue r1 = r4.b
            java.lang.Object r1 = r1.peek()
            java.nio.ByteBuffer r1 = (java.nio.ByteBuffer) r1
            if (r1 != 0) goto L_0x001f
            boolean r1 = r5 instanceof org.java_websocket.WrappedByteChannel
            if (r1 == 0) goto L_0x0038
            r1 = r5
            org.java_websocket.WrappedByteChannel r1 = (org.java_websocket.WrappedByteChannel) r1
            boolean r2 = r1.x()
            if (r2 == 0) goto L_0x0039
            r1.a0()
            goto L_0x0039
        L_0x001f:
            r5.write(r1)
            int r1 = r1.remaining()
            if (r1 <= 0) goto L_0x0029
            return r0
        L_0x0029:
            java.util.concurrent.BlockingQueue r1 = r4.b
            r1.poll()
            java.util.concurrent.BlockingQueue r1 = r4.b
            java.lang.Object r1 = r1.peek()
            java.nio.ByteBuffer r1 = (java.nio.ByteBuffer) r1
            if (r1 != 0) goto L_0x001f
        L_0x0038:
            r1 = 0
        L_0x0039:
            java.util.concurrent.BlockingQueue r2 = r4.b
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0066
            boolean r2 = r4.A()
            if (r2 == 0) goto L_0x0066
            org.java_websocket.drafts.Draft r2 = r4.s()
            if (r2 == 0) goto L_0x0066
            org.java_websocket.drafts.Draft r2 = r4.s()
            org.java_websocket.enums.Role r2 = r2.l()
            if (r2 == 0) goto L_0x0066
            org.java_websocket.drafts.Draft r2 = r4.s()
            org.java_websocket.enums.Role r2 = r2.l()
            org.java_websocket.enums.Role r3 = org.java_websocket.enums.Role.SERVER
            if (r2 != r3) goto L_0x0066
            r4.e()
        L_0x0066:
            if (r1 == 0) goto L_0x0070
            org.java_websocket.WrappedByteChannel r5 = (org.java_websocket.WrappedByteChannel) r5
            boolean r4 = r5.x()
            if (r4 != 0) goto L_0x0071
        L_0x0070:
            r0 = 1
        L_0x0071:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.java_websocket.SocketChannelIOHelper.a(org.java_websocket.WebSocketImpl, java.nio.channels.ByteChannel):boolean");
    }

    public static boolean b(ByteBuffer byteBuffer, WebSocketImpl webSocketImpl, ByteChannel byteChannel) {
        byteBuffer.clear();
        int read = byteChannel.read(byteBuffer);
        byteBuffer.flip();
        if (read != -1) {
            return read != 0;
        }
        webSocketImpl.m();
        return false;
    }

    public static boolean c(ByteBuffer byteBuffer, WebSocketImpl webSocketImpl, WrappedByteChannel wrappedByteChannel) {
        byteBuffer.clear();
        int b0 = wrappedByteChannel.b0(byteBuffer);
        byteBuffer.flip();
        if (b0 != -1) {
            return wrappedByteChannel.y();
        }
        webSocketImpl.m();
        return false;
    }
}
