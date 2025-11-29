package org.apache.tika.parser.digest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import org.apache.tika.exception.TikaException;
import org.apache.tika.io.BoundedInputStream;
import org.apache.tika.io.TemporaryResources;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.DigestingParser;
import org.apache.tika.parser.ParseContext;

public class InputStreamDigester implements DigestingParser.Digester {

    /* renamed from: a  reason: collision with root package name */
    public final String f3258a;
    public final String b;
    public final DigestingParser.Encoder c;
    public final int d;

    public static MessageDigest g(MessageDigest messageDigest, InputStream inputStream) {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read <= -1) {
                return messageDigest;
            }
            messageDigest.update(bArr, 0, read);
        }
    }

    public void a(InputStream inputStream, Metadata metadata, ParseContext parseContext) {
        TikaInputStream a2 = TikaInputStream.a(inputStream);
        if (a2 != null && a2.T()) {
            if ((a2.T() ? a2.w() : -1) > ((long) this.d)) {
                b(a2.u(), metadata);
                return;
            }
        }
        BoundedInputStream boundedInputStream = new BoundedInputStream((long) this.d, inputStream);
        boundedInputStream.mark(this.d + 1);
        boolean c2 = c(boundedInputStream, metadata);
        boundedInputStream.reset();
        if (!c2) {
            if (a2 != null) {
                b(a2.u(), metadata);
                return;
            }
            TemporaryResources temporaryResources = new TemporaryResources();
            try {
                b(TikaInputStream.g(inputStream, temporaryResources, metadata).u(), metadata);
                try {
                } catch (TikaException e) {
                    throw new IOException(e);
                }
            } finally {
                try {
                    temporaryResources.dispose();
                } catch (TikaException e2) {
                    throw new IOException(e2);
                }
            }
        }
    }

    public final void b(File file, Metadata metadata) {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            c(fileInputStream, metadata);
            fileInputStream.close();
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public final boolean c(InputStream inputStream, Metadata metadata) {
        MessageDigest f = f();
        g(f, inputStream);
        byte[] digest = f.digest();
        if ((inputStream instanceof BoundedInputStream) && ((BoundedInputStream) inputStream).a()) {
            return false;
        }
        metadata.set(d(), this.c.encode(digest));
        return true;
    }

    public final String d() {
        return "X-TIKA:digest:" + this.b;
    }

    public Provider e() {
        return null;
    }

    public final MessageDigest f() {
        try {
            Provider e = e();
            return e == null ? MessageDigest.getInstance(this.f3258a) : MessageDigest.getInstance(this.f3258a, e);
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalArgumentException(e2);
        }
    }
}
