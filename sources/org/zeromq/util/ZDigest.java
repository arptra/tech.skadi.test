package org.zeromq.util;

import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class ZDigest {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f3519a;
    public final MessageDigest b;

    public ZDigest(byte[] bArr) {
        this.f3519a = bArr;
        try {
            this.b = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_1);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] a() {
        return this.b.digest();
    }

    public ZDigest b(InputStream inputStream) {
        int read = inputStream.read(this.f3519a);
        while (read != -1) {
            this.b.update(this.f3519a, 0, read);
            read = inputStream.read(this.f3519a);
        }
        return this;
    }
}
