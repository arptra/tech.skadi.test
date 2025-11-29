package androidx.versionedparcelable;

import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.versionedparcelable.VersionedParcel;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

@RestrictTo
class VersionedParcelStream extends VersionedParcel {
    public static final Charset m = Charset.forName("UTF-16");
    public final DataInputStream d;
    public final DataOutputStream e;
    public DataInputStream f;
    public DataOutputStream g;
    public FieldBuffer h;
    public boolean i;
    public int j = 0;
    public int k = -1;
    public int l = -1;

    public static class FieldBuffer {

        /* renamed from: a  reason: collision with root package name */
        public final ByteArrayOutputStream f1908a;
        public final DataOutputStream b;
        public final int c;
        public final DataOutputStream d;

        public FieldBuffer(int i, DataOutputStream dataOutputStream) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.f1908a = byteArrayOutputStream;
            this.b = new DataOutputStream(byteArrayOutputStream);
            this.c = i;
            this.d = dataOutputStream;
        }

        public void a() {
            this.b.flush();
            int size = this.f1908a.size();
            this.d.writeInt((this.c << 16) | (size >= 65535 ? 65535 : size));
            if (size >= 65535) {
                this.d.writeInt(size);
            }
            this.f1908a.writeTo(this.d);
        }
    }

    public VersionedParcelStream(InputStream inputStream, OutputStream outputStream, ArrayMap arrayMap, ArrayMap arrayMap2, ArrayMap arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        DataOutputStream dataOutputStream = null;
        DataInputStream dataInputStream = inputStream != null ? new DataInputStream(new FilterInputStream(inputStream) {
            public int read() {
                VersionedParcelStream versionedParcelStream = VersionedParcelStream.this;
                int i = versionedParcelStream.l;
                if (i == -1 || versionedParcelStream.j < i) {
                    int read = super.read();
                    VersionedParcelStream.this.j++;
                    return read;
                }
                throw new IOException();
            }

            public long skip(long j) {
                VersionedParcelStream versionedParcelStream = VersionedParcelStream.this;
                int i = versionedParcelStream.l;
                if (i == -1 || versionedParcelStream.j < i) {
                    long skip = super.skip(j);
                    if (skip > 0) {
                        VersionedParcelStream.this.j += (int) skip;
                    }
                    return skip;
                }
                throw new IOException();
            }

            public int read(byte[] bArr, int i, int i2) {
                VersionedParcelStream versionedParcelStream = VersionedParcelStream.this;
                int i3 = versionedParcelStream.l;
                if (i3 == -1 || versionedParcelStream.j < i3) {
                    int read = super.read(bArr, i, i2);
                    if (read > 0) {
                        VersionedParcelStream.this.j += read;
                    }
                    return read;
                }
                throw new IOException();
            }
        }) : null;
        this.d = dataInputStream;
        dataOutputStream = outputStream != null ? new DataOutputStream(outputStream) : dataOutputStream;
        this.e = dataOutputStream;
        this.f = dataInputStream;
        this.g = dataOutputStream;
    }

    public void A(byte[] bArr) {
        if (bArr != null) {
            try {
                this.g.writeInt(bArr.length);
                this.g.write(bArr);
            } catch (IOException e2) {
                throw new VersionedParcel.ParcelException(e2);
            }
        } else {
            this.g.writeInt(-1);
        }
    }

    public void C(CharSequence charSequence) {
        if (!this.i) {
            throw new RuntimeException("CharSequence cannot be written to an OutputStream");
        }
    }

    public void E(int i2) {
        try {
            this.g.writeInt(i2);
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public void G(Parcelable parcelable) {
        if (!this.i) {
            throw new RuntimeException("Parcelables cannot be written to an OutputStream");
        }
    }

    public void I(String str) {
        if (str != null) {
            try {
                byte[] bytes = str.getBytes(m);
                this.g.writeInt(bytes.length);
                this.g.write(bytes);
            } catch (IOException e2) {
                throw new VersionedParcel.ParcelException(e2);
            }
        } else {
            this.g.writeInt(-1);
        }
    }

    public void a() {
        FieldBuffer fieldBuffer = this.h;
        if (fieldBuffer != null) {
            try {
                if (fieldBuffer.f1908a.size() != 0) {
                    this.h.a();
                }
                this.h = null;
            } catch (IOException e2) {
                throw new VersionedParcel.ParcelException(e2);
            }
        }
    }

    public VersionedParcel b() {
        return new VersionedParcelStream(this.f, this.g, this.f1906a, this.b, this.c);
    }

    public boolean f() {
        return true;
    }

    public boolean g() {
        try {
            return this.f.readBoolean();
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public byte[] i() {
        try {
            int readInt = this.f.readInt();
            if (readInt <= 0) {
                return null;
            }
            byte[] bArr = new byte[readInt];
            this.f.readFully(bArr);
            return bArr;
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public CharSequence k() {
        return null;
    }

    public boolean m(int i2) {
        while (true) {
            try {
                int i3 = this.k;
                if (i3 == i2) {
                    return true;
                }
                if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                    return false;
                }
                int i4 = this.j;
                int i5 = this.l;
                if (i4 < i5) {
                    this.d.skip((long) (i5 - i4));
                }
                this.l = -1;
                int readInt = this.d.readInt();
                this.j = 0;
                int i6 = readInt & 65535;
                if (i6 == 65535) {
                    i6 = this.d.readInt();
                }
                this.k = (readInt >> 16) & 65535;
                this.l = i6;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    public int o() {
        try {
            return this.f.readInt();
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public Parcelable q() {
        return null;
    }

    public String s() {
        try {
            int readInt = this.f.readInt();
            if (readInt <= 0) {
                return null;
            }
            byte[] bArr = new byte[readInt];
            this.f.readFully(bArr);
            return new String(bArr, m);
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }

    public void w(int i2) {
        a();
        FieldBuffer fieldBuffer = new FieldBuffer(i2, this.e);
        this.h = fieldBuffer;
        this.g = fieldBuffer.b;
    }

    public void x(boolean z, boolean z2) {
        if (z) {
            this.i = z2;
            return;
        }
        throw new RuntimeException("Serialization of this object is not allowed");
    }

    public void y(boolean z) {
        try {
            this.g.writeBoolean(z);
        } catch (IOException e2) {
            throw new VersionedParcel.ParcelException(e2);
        }
    }
}
