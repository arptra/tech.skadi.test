package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.CharsetUtil;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.internal.ObjectUtil;
import java.nio.charset.Charset;
import java.security.PrivateKey;

public final class PemPrivateKey extends AbstractReferenceCounted implements PrivateKey, PemEncoded {
    private static final byte[] BEGIN_PRIVATE_KEY;
    private static final byte[] END_PRIVATE_KEY;
    private static final String PKCS8_FORMAT = "PKCS#8";
    private static final long serialVersionUID = 7978017465645018936L;
    private final ByteBuf content;

    static {
        Charset charset = CharsetUtil.US_ASCII;
        BEGIN_PRIVATE_KEY = "-----BEGIN PRIVATE KEY-----\n".getBytes(charset);
        END_PRIVATE_KEY = "\n-----END PRIVATE KEY-----\n".getBytes(charset);
    }

    private PemPrivateKey(ByteBuf byteBuf) {
        this.content = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "content");
    }

    public static PemEncoded toPEM(ByteBufAllocator byteBufAllocator, boolean z, PrivateKey privateKey) {
        if (privateKey instanceof PemEncoded) {
            return ((PemEncoded) privateKey).retain();
        }
        byte[] encoded = privateKey.getEncoded();
        if (encoded != null) {
            return toPEM(byteBufAllocator, z, encoded);
        }
        throw new IllegalArgumentException(privateKey.getClass().getName() + " does not support encoding");
    }

    public static PemPrivateKey valueOf(byte[] bArr) {
        return valueOf(Unpooled.wrappedBuffer(bArr));
    }

    public ByteBuf content() {
        int refCnt = refCnt();
        if (refCnt > 0) {
            return this.content;
        }
        throw new IllegalReferenceCountException(refCnt);
    }

    public void deallocate() {
        SslUtils.zerooutAndRelease(this.content);
    }

    public void destroy() {
        release(refCnt());
    }

    public String getAlgorithm() {
        throw new UnsupportedOperationException();
    }

    public byte[] getEncoded() {
        throw new UnsupportedOperationException();
    }

    public String getFormat() {
        return PKCS8_FORMAT;
    }

    public boolean isDestroyed() {
        return refCnt() == 0;
    }

    public boolean isSensitive() {
        return true;
    }

    public static PemPrivateKey valueOf(ByteBuf byteBuf) {
        return new PemPrivateKey(byteBuf);
    }

    public PemPrivateKey copy() {
        return replace(this.content.copy());
    }

    public PemPrivateKey duplicate() {
        return replace(this.content.duplicate());
    }

    public PemPrivateKey replace(ByteBuf byteBuf) {
        return new PemPrivateKey(byteBuf);
    }

    public PemPrivateKey retainedDuplicate() {
        return replace(this.content.retainedDuplicate());
    }

    public static PemEncoded toPEM(ByteBufAllocator byteBufAllocator, boolean z, byte[] bArr) {
        ByteBuf wrappedBuffer = Unpooled.wrappedBuffer(bArr);
        try {
            wrappedBuffer = SslUtils.toBase64(byteBufAllocator, wrappedBuffer);
            byte[] bArr2 = BEGIN_PRIVATE_KEY;
            int length = bArr2.length + wrappedBuffer.readableBytes();
            byte[] bArr3 = END_PRIVATE_KEY;
            int length2 = length + bArr3.length;
            wrappedBuffer = z ? byteBufAllocator.directBuffer(length2) : byteBufAllocator.buffer(length2);
            wrappedBuffer.writeBytes(bArr2);
            wrappedBuffer.writeBytes(wrappedBuffer);
            wrappedBuffer.writeBytes(bArr3);
            return new PemValue(wrappedBuffer, true);
        } catch (Throwable th) {
            throw th;
        } finally {
            SslUtils.zerooutAndRelease(wrappedBuffer);
        }
    }

    public PemPrivateKey retain() {
        return (PemPrivateKey) super.retain();
    }

    public PemPrivateKey touch() {
        this.content.touch();
        return this;
    }

    public PemPrivateKey retain(int i) {
        return (PemPrivateKey) super.retain(i);
    }

    public PemPrivateKey touch(Object obj) {
        this.content.touch(obj);
        return this;
    }
}
