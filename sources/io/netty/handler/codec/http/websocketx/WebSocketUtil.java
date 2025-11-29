package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

final class WebSocketUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final FastThreadLocal<MessageDigest> MD5 = new FastThreadLocal<MessageDigest>() {
        public MessageDigest initialValue() throws Exception {
            try {
                return MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            } catch (NoSuchAlgorithmException unused) {
                throw new InternalError("MD5 not supported on this platform - Outdated?");
            }
        }
    };
    private static final FastThreadLocal<MessageDigest> SHA1 = new FastThreadLocal<MessageDigest>() {
        public MessageDigest initialValue() throws Exception {
            try {
                return MessageDigest.getInstance("SHA1");
            } catch (NoSuchAlgorithmException unused) {
                throw new InternalError("SHA-1 not supported on this platform - Outdated?");
            }
        }
    };

    private WebSocketUtil() {
    }

    @SuppressJava6Requirement(reason = "Guarded with java version check")
    public static String base64(byte[] bArr) {
        if (PlatformDependent.javaVersion() >= 8) {
            return Base64.getEncoder().encodeToString(bArr);
        }
        ByteBuf wrappedBuffer = Unpooled.wrappedBuffer(bArr);
        try {
            wrappedBuffer = io.netty.handler.codec.base64.Base64.encode(wrappedBuffer);
            return wrappedBuffer.toString(CharsetUtil.UTF_8);
        } catch (Throwable th) {
            throw th;
        } finally {
            wrappedBuffer.release();
        }
    }

    private static byte[] digest(FastThreadLocal<MessageDigest> fastThreadLocal, byte[] bArr) {
        MessageDigest messageDigest = fastThreadLocal.get();
        messageDigest.reset();
        return messageDigest.digest(bArr);
    }

    public static byte[] md5(byte[] bArr) {
        return digest(MD5, bArr);
    }

    public static byte[] randomBytes(int i) {
        byte[] bArr = new byte[i];
        PlatformDependent.threadLocalRandom().nextBytes(bArr);
        return bArr;
    }

    public static int randomNumber(int i, int i2) {
        return (int) (((double) i) + (PlatformDependent.threadLocalRandom().nextDouble() * ((double) (i2 - i))));
    }

    public static byte[] sha1(byte[] bArr) {
        return digest(SHA1, bArr);
    }
}
