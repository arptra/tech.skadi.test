package io.netty.handler.ssl.util;

import io.netty.util.internal.ObjectUtil;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.SignatureException;
import java.util.Date;
import javax.security.cert.CertificateException;
import javax.security.cert.CertificateExpiredException;
import javax.security.cert.CertificateNotYetValidException;
import javax.security.cert.X509Certificate;

public final class LazyJavaxX509Certificate extends X509Certificate {
    private final byte[] bytes;
    private X509Certificate wrapped;

    public LazyJavaxX509Certificate(byte[] bArr) {
        this.bytes = (byte[]) ObjectUtil.checkNotNull(bArr, "bytes");
    }

    private X509Certificate unwrap() {
        X509Certificate x509Certificate = this.wrapped;
        if (x509Certificate != null) {
            return x509Certificate;
        }
        try {
            X509Certificate instance = X509Certificate.getInstance(this.bytes);
            this.wrapped = instance;
            return instance;
        } catch (CertificateException e) {
            throw new IllegalStateException(e);
        }
    }

    public void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
        unwrap().checkValidity();
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    public byte[] getEncoded() {
        return (byte[]) this.bytes.clone();
    }

    public Principal getIssuerDN() {
        return unwrap().getIssuerDN();
    }

    public Date getNotAfter() {
        return unwrap().getNotAfter();
    }

    public Date getNotBefore() {
        return unwrap().getNotBefore();
    }

    public PublicKey getPublicKey() {
        return unwrap().getPublicKey();
    }

    public BigInteger getSerialNumber() {
        return unwrap().getSerialNumber();
    }

    public String getSigAlgName() {
        return unwrap().getSigAlgName();
    }

    public String getSigAlgOID() {
        return unwrap().getSigAlgOID();
    }

    public byte[] getSigAlgParams() {
        return unwrap().getSigAlgParams();
    }

    public Principal getSubjectDN() {
        return unwrap().getSubjectDN();
    }

    public int getVersion() {
        return unwrap().getVersion();
    }

    public String toString() {
        return unwrap().toString();
    }

    public void verify(PublicKey publicKey) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        unwrap().verify(publicKey);
    }

    public void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
        unwrap().checkValidity(date);
    }

    public void verify(PublicKey publicKey, String str) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        unwrap().verify(publicKey, str);
    }
}
