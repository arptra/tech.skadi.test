package zmq.util;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.zeromq.ZMQ;
import zmq.Msg;

public class Wire {
    public static int a(ByteBuffer byteBuffer, int i) {
        return (byteBuffer.get(i + 1) & 255) | ((byteBuffer.get(i) & 255) << 8);
    }

    public static int b(ByteBuffer byteBuffer, int i) {
        return (byteBuffer.get(i + 3) & 255) | ((byteBuffer.get(i) & 255) << 24) | ((byteBuffer.get(i + 1) & 255) << 16) | ((byteBuffer.get(i + 2) & 255) << 8);
    }

    public static long c(ByteBuffer byteBuffer, int i) {
        return (((long) byteBuffer.get(i + 7)) & 255) | (((long) (byteBuffer.get(i) & 255)) << 56) | (((long) (byteBuffer.get(i + 1) & 255)) << 48) | (((long) (byteBuffer.get(i + 2) & 255)) << 40) | (((long) (byteBuffer.get(i + 3) & 255)) << 32) | (((long) (byteBuffer.get(i + 4) & 255)) << 24) | (((long) (byteBuffer.get(i + 5) & 255)) << 16) | (((long) (byteBuffer.get(i + 6) & 255)) << 8);
    }

    public static int d(ByteBuffer byteBuffer, String str) {
        return e(ZMQ.f, byteBuffer, str);
    }

    public static int e(Charset charset, ByteBuffer byteBuffer, String str) {
        int length = str.length();
        Utils.b(length < Integer.MAX_VALUE, "String must be smaller than 2^31-1 characters");
        i(byteBuffer, length);
        byteBuffer.put(str.getBytes(charset));
        return length + 4;
    }

    public static int f(ByteBuffer byteBuffer, String str) {
        return g(ZMQ.f, byteBuffer, str);
    }

    public static int g(Charset charset, ByteBuffer byteBuffer, String str) {
        int length = str.length();
        Utils.b(length < 256, "String must be strictly smaller than 256 characters");
        m(byteBuffer, length);
        byteBuffer.put(str.getBytes(charset));
        return length + 1;
    }

    public static Msg h(Msg msg, int i) {
        msg.x((byte) ((i >>> 8) & 255));
        msg.x((byte) (i & 255));
        return msg;
    }

    public static ByteBuffer i(ByteBuffer byteBuffer, int i) {
        byteBuffer.put((byte) ((i >>> 24) & 255));
        byteBuffer.put((byte) ((i >>> 16) & 255));
        byteBuffer.put((byte) ((i >>> 8) & 255));
        byteBuffer.put((byte) (i & 255));
        return byteBuffer;
    }

    public static Msg j(Msg msg, int i) {
        msg.x((byte) ((i >>> 24) & 255));
        msg.x((byte) ((i >>> 16) & 255));
        msg.x((byte) ((i >>> 8) & 255));
        msg.x((byte) (i & 255));
        return msg;
    }

    public static byte[] k(int i) {
        return new byte[]{(byte) ((i >>> 24) & 255), (byte) ((i >>> 16) & 255), (byte) ((i >>> 8) & 255), (byte) (i & 255)};
    }

    public static ByteBuffer l(ByteBuffer byteBuffer, long j) {
        byteBuffer.put((byte) ((int) ((j >>> 56) & 255)));
        byteBuffer.put((byte) ((int) ((j >>> 48) & 255)));
        byteBuffer.put((byte) ((int) ((j >>> 40) & 255)));
        byteBuffer.put((byte) ((int) ((j >>> 32) & 255)));
        byteBuffer.put((byte) ((int) ((j >>> 24) & 255)));
        byteBuffer.put((byte) ((int) ((j >>> 16) & 255)));
        byteBuffer.put((byte) ((int) ((j >>> 8) & 255)));
        byteBuffer.put((byte) ((int) (j & 255)));
        return byteBuffer;
    }

    public static ByteBuffer m(ByteBuffer byteBuffer, int i) {
        byteBuffer.put((byte) (i & 255));
        return byteBuffer;
    }
}
