package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class MetadataItem extends Table {

    public static final class Vector extends BaseVector {
    }

    public MetadataItem g(int i, ByteBuffer byteBuffer) {
        h(i, byteBuffer);
        return this;
    }

    public void h(int i, ByteBuffer byteBuffer) {
        c(i, byteBuffer);
    }

    public int i(int i) {
        int b = b(16);
        if (b != 0) {
            return this.b.getInt(d(b) + (i * 4));
        }
        return 0;
    }

    public int j() {
        int b = b(16);
        if (b != 0) {
            return e(b);
        }
        return 0;
    }

    public boolean k() {
        int b = b(6);
        return (b == 0 || this.b.get(b + this.f1231a) == 0) ? false : true;
    }

    public short l() {
        int b = b(14);
        if (b != 0) {
            return this.b.getShort(b + this.f1231a);
        }
        return 0;
    }

    public int m() {
        int b = b(4);
        if (b != 0) {
            return this.b.getInt(b + this.f1231a);
        }
        return 0;
    }

    public short n() {
        int b = b(8);
        if (b != 0) {
            return this.b.getShort(b + this.f1231a);
        }
        return 0;
    }

    public short o() {
        int b = b(12);
        if (b != 0) {
            return this.b.getShort(b + this.f1231a);
        }
        return 0;
    }
}
