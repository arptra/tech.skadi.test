package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public class ByteBufferReadWriteBuf implements ReadWriteBuf {

    /* renamed from: a  reason: collision with root package name */
    public final ByteBuffer f1221a;

    public String a(int i, int i2) {
        return Utf8Safe.c(this.f1221a, i, i2);
    }

    public byte get(int i) {
        return this.f1221a.get(i);
    }

    public double getDouble(int i) {
        return this.f1221a.getDouble(i);
    }

    public float getFloat(int i) {
        return this.f1221a.getFloat(i);
    }

    public int getInt(int i) {
        return this.f1221a.getInt(i);
    }

    public long getLong(int i) {
        return this.f1221a.getLong(i);
    }

    public short getShort(int i) {
        return this.f1221a.getShort(i);
    }
}
