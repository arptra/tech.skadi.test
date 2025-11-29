package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.internal.ObjectUtil;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

public final class PemX509Certificate extends X509Certificate implements PemEncoded {
    private static final byte[] BEGIN_CERT;
    private static final byte[] END_CERT;
    private final ByteBuf content;

    static {
        Charset charset = CharsetUtil.US_ASCII;
        BEGIN_CERT = "-----BEGIN CERTIFICATE-----\n".getBytes(charset);
        END_CERT = "\n-----END CERTIFICATE-----\n".getBytes(charset);
    }

    private PemX509Certificate(ByteBuf byteBuf) {
        this.content = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "content");
    }

    private static ByteBuf append(ByteBufAllocator byteBufAllocator, boolean z, PemEncoded pemEncoded, int i, ByteBuf byteBuf) {
        ByteBuf content2 = pemEncoded.content();
        if (byteBuf == null) {
            byteBuf = newBuffer(byteBufAllocator, z, content2.readableBytes() * i);
        }
        byteBuf.writeBytes(content2.slice());
        return byteBuf;
    }

    private static ByteBuf newBuffer(ByteBufAllocator byteBufAllocator, boolean z, int i) {
        return z ? byteBufAllocator.directBuffer(i) : byteBufAllocator.buffer(i);
    }

    public static PemEncoded toPEM(ByteBufAllocator byteBufAllocator, boolean z, X509Certificate... x509CertificateArr) throws CertificateEncodingException {
        ObjectUtil.checkNonEmpty((T[]) x509CertificateArr, "chain");
        if (x509CertificateArr.length == 1) {
            X509Certificate x509Certificate = x509CertificateArr[0];
            if (x509Certificate instanceof PemEncoded) {
                return ((PemEncoded) x509Certificate).retain();
            }
        }
        ByteBuf byteBuf = null;
        try {
            int length = x509CertificateArr.length;
            int i = 0;
            while (i < length) {
                X509Certificate x509Certificate2 = x509CertificateArr[i];
                if (x509Certificate2 != null) {
                    byteBuf = x509Certificate2 instanceof PemEncoded ? append(byteBufAllocator, z, (PemEncoded) x509Certificate2, x509CertificateArr.length, byteBuf) : append(byteBufAllocator, z, x509Certificate2, x509CertificateArr.length, byteBuf);
                    i++;
                } else {
                    throw new IllegalArgumentException("Null element in chain: " + Arrays.toString(x509CertificateArr));
                }
            }
            return new PemValue(byteBuf, false);
        } catch (Throwable th) {
            if (byteBuf != null) {
                byteBuf.release();
            }
            throw th;
        }
    }

    public static PemX509Certificate valueOf(byte[] bArr) {
        return valueOf(Unpooled.wrappedBuffer(bArr));
    }

    public void checkValidity() {
        throw new UnsupportedOperationException();
    }

    public ByteBuf content() {
        int refCnt = refCnt();
        if (refCnt > 0) {
            return this.content;
        }
        throw new IllegalReferenceCountException(refCnt);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PemX509Certificate)) {
            return false;
        }
        return this.content.equals(((PemX509Certificate) obj).content);
    }

    public int getBasicConstraints() {
        throw new UnsupportedOperationException();
    }

    public Set<String> getCriticalExtensionOIDs() {
        throw new UnsupportedOperationException();
    }

    public byte[] getEncoded() {
        throw new UnsupportedOperationException();
    }

    public byte[] getExtensionValue(String str) {
        throw new UnsupportedOperationException();
    }

    public Principal getIssuerDN() {
        throw new UnsupportedOperationException();
    }

    public boolean[] getIssuerUniqueID() {
        throw new UnsupportedOperationException();
    }

    public boolean[] getKeyUsage() {
        throw new UnsupportedOperationException();
    }

    public Set<String> getNonCriticalExtensionOIDs() {
        throw new UnsupportedOperationException();
    }

    public Date getNotAfter() {
        throw new UnsupportedOperationException();
    }

    public Date getNotBefore() {
        throw new UnsupportedOperationException();
    }

    public PublicKey getPublicKey() {
        throw new UnsupportedOperationException();
    }

    public BigInteger getSerialNumber() {
        throw new UnsupportedOperationException();
    }

    public String getSigAlgName() {
        throw new UnsupportedOperationException();
    }

    public String getSigAlgOID() {
        throw new UnsupportedOperationException();
    }

    public byte[] getSigAlgParams() {
        throw new UnsupportedOperationException();
    }

    public byte[] getSignature() {
        throw new UnsupportedOperationException();
    }

    public Principal getSubjectDN() {
        throw new UnsupportedOperationException();
    }

    public boolean[] getSubjectUniqueID() {
        throw new UnsupportedOperationException();
    }

    public byte[] getTBSCertificate() {
        throw new UnsupportedOperationException();
    }

    public int getVersion() {
        throw new UnsupportedOperationException();
    }

    public boolean hasUnsupportedCriticalExtension() {
        throw new UnsupportedOperationException();
    }

    public int hashCode() {
        return this.content.hashCode();
    }

    public boolean isSensitive() {
        return false;
    }

    public int refCnt() {
        return this.content.refCnt();
    }

    public boolean release() {
        return this.content.release();
    }

    public String toString() {
        return this.content.toString(CharsetUtil.UTF_8);
    }

    public void verify(PublicKey publicKey) {
        throw new UnsupportedOperationException();
    }

    public static PemX509Certificate valueOf(ByteBuf byteBuf) {
        return new PemX509Certificate(byteBuf);
    }

    public void checkValidity(Date date) {
        throw new UnsupportedOperationException();
    }

    public boolean release(int i) {
        return this.content.release(i);
    }

    public void verify(PublicKey publicKey, String str) {
        throw new UnsupportedOperationException();
    }

    public PemX509Certificate copy() {
        return replace(this.content.copy());
    }

    public PemX509Certificate duplicate() {
        return replace(this.content.duplicate());
    }

    public PemX509Certificate replace(ByteBuf byteBuf) {
        return new PemX509Certificate(byteBuf);
    }

    public PemX509Certificate retainedDuplicate() {
        return replace(this.content.retainedDuplicate());
    }

    private static ByteBuf append(ByteBufAllocator byteBufAllocator, boolean z, X509Certificate x509Certificate, int i, ByteBuf byteBuf) throws CertificateEncodingException {
        ByteBuf wrappedBuffer = Unpooled.wrappedBuffer(x509Certificate.getEncoded());
        try {
            wrappedBuffer = SslUtils.toBase64(byteBufAllocator, wrappedBuffer);
            if (byteBuf == null) {
                byteBuf = newBuffer(byteBufAllocator, z, (BEGIN_CERT.length + wrappedBuffer.readableBytes() + END_CERT.length) * i);
            }
            byteBuf.writeBytes(BEGIN_CERT);
            byteBuf.writeBytes(wrappedBuffer);
            byteBuf.writeBytes(END_CERT);
            wrappedBuffer.release();
            return byteBuf;
        } catch (Throwable th) {
            throw th;
        } finally {
            wrappedBuffer.release();
        }
    }

    public PemX509Certificate retain() {
        this.content.retain();
        return this;
    }

    public PemX509Certificate touch() {
        this.content.touch();
        return this;
    }

    public PemX509Certificate retain(int i) {
        this.content.retain(i);
        return this;
    }

    public PemX509Certificate touch(Object obj) {
        this.content.touch(obj);
        return this;
    }
}
