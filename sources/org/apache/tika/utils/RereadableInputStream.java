package org.apache.tika.utils;

import io.netty.handler.codec.http.multipart.DiskFileUpload;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.attribute.FileAttribute;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;

public class RereadableInputStream extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    public final InputStream f3344a;
    public InputStream b;
    public final int c;
    public boolean d;
    public byte[] e;
    public int f;
    public int g;
    public File h;
    public boolean i;
    public OutputStream j;
    public final boolean k;

    public final void a() {
        InputStream inputStream = this.f3344a;
        InputStream inputStream2 = this.b;
        if (inputStream != inputStream2) {
            inputStream2.close();
        }
        if (this.k) {
            this.f3344a.close();
        }
    }

    public void b() {
        if (!this.i) {
            OutputStream outputStream = this.j;
            if (outputStream != null) {
                outputStream.close();
                this.j = null;
            }
            InputStream inputStream = this.b;
            if (inputStream != this.f3344a) {
                inputStream.close();
            }
            int max = Math.max(this.f, this.g);
            this.g = max;
            this.f = max;
            if (max > 0) {
                byte[] bArr = this.e;
                if (bArr != null) {
                    this.d = true;
                    this.b = new UnsynchronizedByteArrayInputStream(bArr, 0, max);
                    return;
                }
                this.b = new BufferedInputStream(new FileInputStream(this.h));
                return;
            }
            this.b = this.f3344a;
            return;
        }
        throw new IOException("Stream is already closed");
    }

    public final void c(int i2) {
        byte[] bArr = this.e;
        if (bArr != null) {
            int i3 = this.f;
            if (i3 == this.c) {
                this.h = Files.createTempFile("TIKA_streamstore_", DiskFileUpload.postfix, new FileAttribute[0]).toFile();
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.h));
                this.j = bufferedOutputStream;
                bufferedOutputStream.write(this.e, 0, this.f);
                this.j.write(i2);
                this.e = null;
                return;
            }
            this.f = i3 + 1;
            bArr[i3] = (byte) i2;
            return;
        }
        this.j.write(i2);
    }

    public void close() {
        a();
        OutputStream outputStream = this.j;
        if (outputStream != null) {
            outputStream.close();
            this.j = null;
        }
        super.close();
        File file = this.h;
        if (file != null) {
            file.delete();
        }
        this.i = true;
    }

    public int read() {
        InputStream inputStream;
        if (!this.i) {
            int read = this.b.read();
            if (read == -1 && (inputStream = this.b) != this.f3344a) {
                if (this.d) {
                    this.d = false;
                    inputStream.close();
                } else {
                    inputStream.close();
                    this.j = new BufferedOutputStream(new FileOutputStream(this.h, true));
                }
                InputStream inputStream2 = this.f3344a;
                this.b = inputStream2;
                read = inputStream2.read();
            }
            if (read != -1 && this.b == this.f3344a) {
                c(read);
            }
            return read;
        }
        throw new IOException("Stream is already closed");
    }
}
