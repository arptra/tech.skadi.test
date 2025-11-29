package zmq.util;

import com.google.common.primitives.SignedBytes;
import com.upuphone.starrynet.strategy.message.payload.handler.RingDataUtil;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.nio.ByteBuffer;
import okio.Utf8;

public class Z85 {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f3675a = {0, 68, 0, 84, 83, 82, 72, 0, 75, 76, 70, 65, 0, Utf8.REPLACEMENT_BYTE, 62, 69, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, SignedBytes.MAX_POWER_OF_TWO, 0, 73, 66, 74, 71, 81, BinaryMemcacheOpcodes.GATKQ, 37, 38, 39, RingDataUtil.OPCODE_SET_GET_RING_NAME, RingDataUtil.OPCODE_QUERY_ALGO_STATE, 42, 43, HttpConstants.COMMA, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, HttpConstants.COLON, HttpConstants.SEMICOLON, 60, 61, 77, 0, 78, 67, 0, 0, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 79, 0, 80, 0, 0};

    public static byte[] a(String str) {
        if (str.length() % 5 != 0) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate((str.length() * 4) / 5);
        int length = str.length();
        int i = 0;
        long j = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            j = (j * 85) + ((long) (f3675a[str.charAt(i) - ' '] & 255));
            if (i3 % 5 == 0) {
                int i4 = 16777216;
                while (i4 != 0) {
                    allocate.put(i2, (byte) ((int) ((j / ((long) i4)) % 256)));
                    i4 /= 256;
                    i2++;
                }
                j = 0;
            }
            i = i3;
        }
        return allocate.array();
    }

    public static String b(byte[] bArr, int i) {
        if (i % 4 != 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        long j = 0;
        while (i2 < i) {
            int i3 = i2 + 1;
            j = (j * 256) + ((long) (bArr[i2] & 255));
            if (i3 % 4 == 0) {
                for (int i4 = 52200625; i4 != 0; i4 /= 85) {
                    sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ.-:+=^!/*?&<>()[]{}@%$#".charAt((int) ((j / ((long) i4)) % 85)));
                }
                j = 0;
            }
            i2 = i3;
        }
        return sb.toString();
    }
}
