package com.bumptech.glide.disklrucache;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

class StrictLineReader implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final InputStream f2437a;
    public final Charset b;
    public byte[] c;
    public int d;
    public int e;

    public StrictLineReader(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public final void b() {
        InputStream inputStream = this.f2437a;
        byte[] bArr = this.c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.d = 0;
            this.e = read;
            return;
        }
        throw new EOFException();
    }

    public boolean c() {
        return this.e == -1;
    }

    public void close() {
        synchronized (this.f2437a) {
            try {
                if (this.c != null) {
                    this.c = null;
                    this.f2437a.close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String d() {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.f2437a) {
            try {
                if (this.c != null) {
                    if (this.d >= this.e) {
                        b();
                    }
                    for (int i3 = this.d; i3 != this.e; i3++) {
                        byte[] bArr2 = this.c;
                        if (bArr2[i3] == 10) {
                            int i4 = this.d;
                            if (i3 != i4) {
                                i2 = i3 - 1;
                                if (bArr2[i2] == 13) {
                                    String str = new String(bArr2, i4, i2 - i4, this.b.name());
                                    this.d = i3 + 1;
                                    return str;
                                }
                            }
                            i2 = i3;
                            String str2 = new String(bArr2, i4, i2 - i4, this.b.name());
                            this.d = i3 + 1;
                            return str2;
                        }
                    }
                    AnonymousClass1 r1 = new ByteArrayOutputStream((this.e - this.d) + 80) {
                        public String toString() {
                            int i = this.count;
                            if (i > 0 && this.buf[i - 1] == 13) {
                                i--;
                            }
                            try {
                                return new String(this.buf, 0, i, StrictLineReader.this.b.name());
                            } catch (UnsupportedEncodingException e) {
                                throw new AssertionError(e);
                            }
                        }
                    };
                    loop1:
                    while (true) {
                        byte[] bArr3 = this.c;
                        int i5 = this.d;
                        r1.write(bArr3, i5, this.e - i5);
                        this.e = -1;
                        b();
                        i = this.d;
                        while (true) {
                            if (i != this.e) {
                                bArr = this.c;
                                if (bArr[i] == 10) {
                                    break loop1;
                                }
                                i++;
                            }
                        }
                    }
                    int i6 = this.d;
                    if (i != i6) {
                        r1.write(bArr, i6, i - i6);
                    }
                    this.d = i + 1;
                    String byteArrayOutputStream = r1.toString();
                    return byteArrayOutputStream;
                }
                throw new IOException("LineReader is closed");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public StrictLineReader(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        } else if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(Util.f2439a)) {
            this.f2437a = inputStream;
            this.b = charset;
            this.c = new byte[i];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }
}
