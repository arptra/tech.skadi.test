package org.java_websocket;

import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;

@Deprecated
public class AbstractWrappedByteChannel implements WrappedByteChannel {

    /* renamed from: a  reason: collision with root package name */
    public final ByteChannel f3387a;

    public void a0() {
        ByteChannel byteChannel = this.f3387a;
        if (byteChannel instanceof WrappedByteChannel) {
            ((WrappedByteChannel) byteChannel).a0();
        }
    }

    public int b0(ByteBuffer byteBuffer) {
        ByteChannel byteChannel = this.f3387a;
        if (byteChannel instanceof WrappedByteChannel) {
            return ((WrappedByteChannel) byteChannel).b0(byteBuffer);
        }
        return 0;
    }

    public void close() {
        this.f3387a.close();
    }

    public boolean isOpen() {
        return this.f3387a.isOpen();
    }

    public int read(ByteBuffer byteBuffer) {
        return this.f3387a.read(byteBuffer);
    }

    public int write(ByteBuffer byteBuffer) {
        return this.f3387a.write(byteBuffer);
    }

    public boolean x() {
        ByteChannel byteChannel = this.f3387a;
        return (byteChannel instanceof WrappedByteChannel) && ((WrappedByteChannel) byteChannel).x();
    }

    public boolean y() {
        ByteChannel byteChannel = this.f3387a;
        return (byteChannel instanceof WrappedByteChannel) && ((WrappedByteChannel) byteChannel).y();
    }
}
