package org.apache.tika.io;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import org.apache.commons.io.input.TaggedInputStream;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.utils.StringUtils;

public class TikaInputStream extends TaggedInputStream {

    /* renamed from: a  reason: collision with root package name */
    public final TemporaryResources f9660a;
    public InputStreamFactory b;
    public Path c;
    public long d;
    public long e;
    public long f;
    public Object g;
    public int h;
    public byte[] i;
    public String j;

    public TikaInputStream(Path path) {
        super(new BufferedInputStream(Files.newInputStream(path, new OpenOption[0])));
        this.e = 0;
        this.f = -1;
        this.h = 0;
        this.j = null;
        this.c = path;
        this.f9660a = new TemporaryResources();
        this.d = Files.size(path);
        this.j = FilenameUtils.b(path.getFileName().toString());
    }

    public static TikaInputStream a(InputStream inputStream) {
        if (inputStream instanceof TikaInputStream) {
            return (TikaInputStream) inputStream;
        }
        return null;
    }

    public static TikaInputStream b(File file) {
        return c(file, new Metadata());
    }

    public static TikaInputStream c(File file, Metadata metadata) {
        if (StringUtils.a(metadata.get("resourceName"))) {
            metadata.set("resourceName", file.getName());
        }
        metadata.set("Content-Length", Long.toString(file.length()));
        return new TikaInputStream(file);
    }

    public static TikaInputStream d(InputStream inputStream) {
        return g(inputStream, new TemporaryResources(), (Metadata) null);
    }

    public static TikaInputStream g(InputStream inputStream, TemporaryResources temporaryResources, Metadata metadata) {
        if (inputStream == null) {
            throw new NullPointerException("The Stream must not be null");
        } else if (inputStream instanceof TikaInputStream) {
            return (TikaInputStream) inputStream;
        } else {
            return new TikaInputStream(!inputStream.markSupported() ? new BufferedInputStream(inputStream) : inputStream, temporaryResources, -1, s(metadata));
        }
    }

    public static TikaInputStream i(Path path) {
        return j(path, new Metadata());
    }

    public static TikaInputStream j(Path path, Metadata metadata) {
        if (StringUtils.a(metadata.get("resourceName"))) {
            metadata.set("resourceName", path.getFileName().toString());
        }
        metadata.set("Content-Length", Long.toString(Files.size(path)));
        return new TikaInputStream(path);
    }

    public static TikaInputStream n(InputStreamFactory inputStreamFactory, TemporaryResources temporaryResources) {
        TikaInputStream g2 = g(inputStreamFactory.a(), temporaryResources, (Metadata) null);
        g2.b = inputStreamFactory;
        return g2;
    }

    public static TikaInputStream o(byte[] bArr) {
        return r(bArr, new Metadata());
    }

    public static TikaInputStream r(byte[] bArr, Metadata metadata) {
        metadata.set("Content-Length", Integer.toString(bArr.length));
        return new TikaInputStream(new UnsynchronizedByteArrayInputStream(bArr), new TemporaryResources(), (long) bArr.length, s(metadata));
    }

    public static String s(Metadata metadata) {
        return metadata == null ? "" : FilenameUtils.b(metadata.get("resourceName"));
    }

    public Path J() {
        return N(-1);
    }

    public Path N(int i2) {
        BoundedInputStream boundedInputStream;
        if (this.c == null) {
            if (this.e <= 0) {
                Path d2 = this.f9660a.d(this.j);
                if (i2 > -1) {
                    mark(i2);
                    try {
                        boundedInputStream = new BoundedInputStream((long) i2, this);
                        Files.copy(boundedInputStream, d2, new CopyOption[]{StandardCopyOption.REPLACE_EXISTING});
                        if (boundedInputStream.a()) {
                            boundedInputStream.close();
                            reset();
                            return null;
                        }
                        boundedInputStream.close();
                        reset();
                    } catch (Throwable th) {
                        reset();
                        throw th;
                    }
                } else {
                    Files.copy(this, d2, new CopyOption[]{StandardCopyOption.REPLACE_EXISTING});
                }
                this.c = d2;
                InputStream newInputStream = Files.newInputStream(d2, new OpenOption[0]);
                this.f9660a.b(newInputStream);
                final InputStream inputStream = this.in;
                this.in = new BufferedInputStream(newInputStream) {
                    public void close() {
                        inputStream.close();
                    }
                };
                this.d = Files.size(this.c);
                this.e = 0;
                this.f = -1;
            } else {
                throw new IOException("Stream is already being read");
            }
        }
        return this.c;
        throw th;
    }

    public long S() {
        return this.e;
    }

    public boolean T() {
        return this.c != null;
    }

    public boolean U() {
        return this.d != -1;
    }

    public void afterRead(int i2) {
        if (i2 != -1) {
            this.e += (long) i2;
            return;
        }
        int i3 = this.h + 1;
        this.h = i3;
        if (i3 > 1000) {
            throw new IOException("Read too many -1 (EOFs); there could be an infinite loop.If you think your file is not corrupt, please open an issue on Tika's JIRA");
        }
    }

    public void c0(Object obj) {
        this.g = obj;
        if (obj instanceof Closeable) {
            this.f9660a.b((Closeable) obj);
        }
    }

    public void close() {
        this.c = null;
        this.f = -1;
        this.f9660a.b(this.in);
        this.f9660a.close();
    }

    public void mark(int i2) {
        super.mark(i2);
        this.f = this.e;
    }

    public boolean markSupported() {
        return true;
    }

    public void reset() {
        super.reset();
        this.e = this.f;
        this.f = -1;
        this.h = 0;
    }

    public long skip(long j2) {
        if (this.i == null) {
            this.i = new byte[4096];
        }
        long a2 = IOUtils.a(this.in, j2, this.i);
        this.e += a2;
        return a2;
    }

    public String toString() {
        String str;
        if (T()) {
            str = "TikaInputStream of " + this.c.toString();
        } else {
            str = "TikaInputStream of " + this.in.toString();
        }
        if (this.g == null) {
            return str;
        }
        return str + " (in " + this.g + ")";
    }

    public File u() {
        return J().toFile();
    }

    public InputStreamFactory v() {
        return this.b;
    }

    public long w() {
        if (this.d == -1) {
            J();
        }
        return this.d;
    }

    public Object z() {
        return this.g;
    }

    public TikaInputStream(File file) {
        super(new BufferedInputStream(new FileInputStream(file)));
        this.e = 0;
        this.f = -1;
        this.h = 0;
        this.j = null;
        this.c = file.toPath();
        this.f9660a = new TemporaryResources();
        this.d = file.length();
        this.j = FilenameUtils.b(this.c.getFileName().toString());
    }

    public TikaInputStream(InputStream inputStream, TemporaryResources temporaryResources, long j2, String str) {
        super(inputStream);
        this.e = 0;
        this.f = -1;
        this.h = 0;
        this.c = null;
        this.f9660a = temporaryResources;
        this.d = j2;
        this.j = str;
    }
}
