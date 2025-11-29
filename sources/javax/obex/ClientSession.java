package javax.obex;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class ClientSession extends ObexSession {
    public boolean c;
    public boolean d;
    public byte[] e = null;
    public int f = 256;
    public boolean g;
    public final InputStream h;
    public final OutputStream i;

    public ClientSession(ObexTransport obexTransport) {
        this.h = obexTransport.a();
        this.i = obexTransport.b();
        this.c = true;
        this.g = false;
    }

    public void c() {
        this.c = false;
        this.h.close();
        this.i.close();
    }

    public HeaderSet d(HeaderSet headerSet) {
        byte[] bArr;
        int i2;
        f();
        if (!this.d) {
            k();
            if (headerSet != null) {
                byte[] bArr2 = headerSet.s;
                if (bArr2 != null) {
                    byte[] bArr3 = new byte[16];
                    this.b = bArr3;
                    System.arraycopy(bArr2, 0, bArr3, 0, 16);
                }
                bArr = ObexHelper.f(headerSet, false);
                i2 = bArr.length + 4;
            } else {
                bArr = null;
                i2 = 4;
            }
            byte[] bArr4 = new byte[i2];
            bArr4[0] = 16;
            bArr4[1] = 0;
            bArr4[2] = -1;
            bArr4[3] = -2;
            if (bArr != null) {
                System.arraycopy(bArr, 0, bArr4, 4, bArr.length);
            }
            if (i2 + 3 <= 65534) {
                HeaderSet headerSet2 = new HeaderSet();
                h(128, bArr4, headerSet2, (PrivateInputStream) null);
                if (headerSet2.w == 160) {
                    this.d = true;
                }
                l();
                return headerSet2;
            }
            throw new IOException("Packet size exceeds max packet size");
        }
        throw new IOException("Already connected to server");
    }

    public HeaderSet e(HeaderSet headerSet) {
        byte[] bArr;
        if (this.d) {
            k();
            f();
            if (headerSet != null) {
                byte[] bArr2 = headerSet.s;
                if (bArr2 != null) {
                    byte[] bArr3 = new byte[16];
                    this.b = bArr3;
                    System.arraycopy(bArr2, 0, bArr3, 0, 16);
                }
                byte[] bArr4 = this.e;
                if (bArr4 != null) {
                    byte[] bArr5 = new byte[4];
                    headerSet.v = bArr5;
                    System.arraycopy(bArr4, 0, bArr5, 0, 4);
                }
                bArr = ObexHelper.f(headerSet, false);
                if (bArr.length + 3 > this.f) {
                    throw new IOException("Packet size exceeds max packet size");
                }
            } else {
                byte[] bArr6 = this.e;
                if (bArr6 != null) {
                    byte[] bArr7 = new byte[5];
                    bArr7[0] = -53;
                    System.arraycopy(bArr6, 0, bArr7, 1, 4);
                    bArr = bArr7;
                } else {
                    bArr = null;
                }
            }
            HeaderSet headerSet2 = new HeaderSet();
            h(129, bArr, headerSet2, (PrivateInputStream) null);
            synchronized (this) {
                this.d = false;
                l();
            }
            return headerSet2;
        }
        throw new IOException("Not connected to the server");
    }

    public synchronized void f() {
        if (!this.c) {
            throw new IOException("Connection closed");
        }
    }

    public Operation g(HeaderSet headerSet) {
        if (this.d) {
            k();
            f();
            if (headerSet == null) {
                headerSet = new HeaderSet();
            } else {
                byte[] bArr = headerSet.s;
                if (bArr != null) {
                    byte[] bArr2 = new byte[16];
                    this.b = bArr2;
                    System.arraycopy(bArr, 0, bArr2, 0, 16);
                }
            }
            byte[] bArr3 = this.e;
            if (bArr3 != null) {
                byte[] bArr4 = new byte[4];
                headerSet.v = bArr4;
                System.arraycopy(bArr3, 0, bArr4, 0, 4);
            }
            return new ClientOperation(this.f, this, headerSet, true);
        }
        throw new IOException("Not connected to the server");
    }

    public boolean h(int i2, byte[] bArr, HeaderSet headerSet, PrivateInputStream privateInputStream) {
        byte[] bArr2;
        if (bArr == null || bArr.length + 3 <= 65534) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write((byte) i2);
            if (bArr == null) {
                byteArrayOutputStream.write(0);
                byteArrayOutputStream.write(3);
            } else {
                byteArrayOutputStream.write((byte) ((bArr.length + 3) >> 8));
                byteArrayOutputStream.write((byte) (bArr.length + 3));
                byteArrayOutputStream.write(bArr);
            }
            this.i.write(byteArrayOutputStream.toByteArray());
            this.i.flush();
            headerSet.w = this.h.read();
            int read = (this.h.read() << 8) | this.h.read();
            if (read <= 65534) {
                if (read > 3) {
                    if (i2 == 128) {
                        this.h.read();
                        this.h.read();
                        int read2 = (this.h.read() << 8) + this.h.read();
                        this.f = read2;
                        if (read2 > 64512) {
                            this.f = 64512;
                        }
                        if (read <= 7) {
                            return true;
                        }
                        int i3 = read - 7;
                        bArr2 = new byte[i3];
                        int read3 = this.h.read(bArr2);
                        while (read3 != i3) {
                            read3 += this.h.read(bArr2, read3, i3 - read3);
                        }
                    } else {
                        int i4 = read - 3;
                        bArr2 = new byte[i4];
                        int read4 = this.h.read(bArr2);
                        while (read4 != i4) {
                            read4 += this.h.read(bArr2, read4, i4 - read4);
                        }
                        if (i2 == 255) {
                            return true;
                        }
                    }
                    byte[] j = ObexHelper.j(headerSet, bArr2);
                    if (!(privateInputStream == null || j == null)) {
                        privateInputStream.b(j, 1);
                    }
                    byte[] bArr3 = headerSet.v;
                    if (bArr3 != null) {
                        byte[] bArr4 = new byte[4];
                        this.e = bArr4;
                        System.arraycopy(bArr3, 0, bArr4, 0, 4);
                    }
                    byte[] bArr5 = headerSet.u;
                    if (bArr5 != null && !b(bArr5)) {
                        l();
                        throw new IOException("Authentication Failed");
                    } else if (headerSet.w == 193 && headerSet.t != null && a(headerSet)) {
                        byteArrayOutputStream.write(78);
                        byteArrayOutputStream.write((byte) ((headerSet.u.length + 3) >> 8));
                        byteArrayOutputStream.write((byte) (headerSet.u.length + 3));
                        byteArrayOutputStream.write(headerSet.u);
                        headerSet.t = null;
                        headerSet.u = null;
                        int size = byteArrayOutputStream.size() - 3;
                        byte[] bArr6 = new byte[size];
                        System.arraycopy(byteArrayOutputStream.toByteArray(), 3, bArr6, 0, size);
                        return h(i2, bArr6, headerSet, privateInputStream);
                    }
                }
                return true;
            }
            throw new IOException("Packet received exceeds packet size limit");
        }
        throw new IOException("header too large ");
    }

    public void i(Authenticator authenticator) {
        if (authenticator != null) {
            this.f3691a = authenticator;
            return;
        }
        throw new IOException("Authenticator may not be null");
    }

    public HeaderSet j(HeaderSet headerSet, boolean z, boolean z2) {
        if (this.d) {
            k();
            f();
            if (headerSet == null) {
                headerSet = new HeaderSet();
            } else {
                byte[] bArr = headerSet.s;
                if (bArr != null) {
                    byte[] bArr2 = new byte[16];
                    this.b = bArr2;
                    System.arraycopy(bArr, 0, bArr2, 0, 16);
                }
            }
            byte[] bArr3 = headerSet.s;
            if (bArr3 != null) {
                byte[] bArr4 = new byte[16];
                this.b = bArr4;
                System.arraycopy(bArr3, 0, bArr4, 0, 16);
            }
            byte[] bArr5 = this.e;
            if (bArr5 != null) {
                byte[] bArr6 = new byte[4];
                headerSet.v = bArr6;
                System.arraycopy(bArr5, 0, bArr6, 0, 4);
            }
            byte[] f2 = ObexHelper.f(headerSet, false);
            int length = f2.length + 2;
            if (length <= this.f) {
                if (!z2) {
                    z |= true;
                }
                byte[] bArr7 = new byte[length];
                bArr7[0] = z ? (byte) 1 : 0;
                bArr7[1] = 0;
                System.arraycopy(f2, 0, bArr7, 2, f2.length);
                HeaderSet headerSet2 = new HeaderSet();
                h(133, bArr7, headerSet2, (PrivateInputStream) null);
                l();
                return headerSet2;
            }
            throw new IOException("Packet size exceeds max packet size");
        }
        throw new IOException("Not connected to the server");
    }

    public final synchronized void k() {
        if (!this.g) {
            this.g = true;
        } else {
            throw new IOException("OBEX request is already being performed");
        }
    }

    public synchronized void l() {
        this.g = false;
    }
}
