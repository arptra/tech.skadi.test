package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class MetadataList extends Table {

    public static final class Vector extends BaseVector {
    }

    public static MetadataList i(ByteBuffer byteBuffer) {
        return j(byteBuffer, new MetadataList());
    }

    public static MetadataList j(ByteBuffer byteBuffer, MetadataList metadataList) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return metadataList.g(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public MetadataList g(int i, ByteBuffer byteBuffer) {
        h(i, byteBuffer);
        return this;
    }

    public void h(int i, ByteBuffer byteBuffer) {
        c(i, byteBuffer);
    }

    public MetadataItem k(MetadataItem metadataItem, int i) {
        int b = b(6);
        if (b != 0) {
            return metadataItem.g(a(d(b) + (i * 4)), this.b);
        }
        return null;
    }

    public int l() {
        int b = b(6);
        if (b != 0) {
            return e(b);
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
}
