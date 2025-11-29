package androidx.emoji2.text;

import androidx.annotation.AnyThread;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UShort;

@RequiresApi
@AnyThread
@RestrictTo
class MetadataListReader {

    public static class ByteBufferReader implements OpenTypeReader {

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuffer f1208a;

        public ByteBufferReader(ByteBuffer byteBuffer) {
            this.f1208a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        public void a(int i) {
            ByteBuffer byteBuffer = this.f1208a;
            byteBuffer.position(byteBuffer.position() + i);
        }

        public int b() {
            return this.f1208a.getInt();
        }

        public long c() {
            return MetadataListReader.c(this.f1208a.getInt());
        }

        public long getPosition() {
            return (long) this.f1208a.position();
        }

        public int readUnsignedShort() {
            return MetadataListReader.d(this.f1208a.getShort());
        }
    }

    public static class InputStreamOpenTypeReader implements OpenTypeReader {

        /* renamed from: a  reason: collision with root package name */
        public final byte[] f1209a;
        public final ByteBuffer b;
        public final InputStream c;
        public long d;

        public void a(int i) {
            while (i > 0) {
                int skip = (int) this.c.skip((long) i);
                if (skip >= 1) {
                    i -= skip;
                    this.d += (long) skip;
                } else {
                    throw new IOException("Skip didn't move at least 1 byte forward");
                }
            }
        }

        public int b() {
            this.b.position(0);
            d(4);
            return this.b.getInt();
        }

        public long c() {
            this.b.position(0);
            d(4);
            return MetadataListReader.c(this.b.getInt());
        }

        public final void d(int i) {
            if (this.c.read(this.f1209a, 0, i) == i) {
                this.d += (long) i;
                return;
            }
            throw new IOException("read failed");
        }

        public long getPosition() {
            return this.d;
        }

        public int readUnsignedShort() {
            this.b.position(0);
            d(2);
            return MetadataListReader.d(this.b.getShort());
        }
    }

    public static class OffsetInfo {

        /* renamed from: a  reason: collision with root package name */
        public final long f1210a;
        public final long b;

        public OffsetInfo(long j, long j2) {
            this.f1210a = j;
            this.b = j2;
        }

        public long a() {
            return this.f1210a;
        }
    }

    public interface OpenTypeReader {
        void a(int i);

        int b();

        long c();

        long getPosition();

        int readUnsignedShort();
    }

    public static OffsetInfo a(OpenTypeReader openTypeReader) {
        long j;
        openTypeReader.a(4);
        int readUnsignedShort = openTypeReader.readUnsignedShort();
        if (readUnsignedShort <= 100) {
            openTypeReader.a(6);
            int i = 0;
            while (true) {
                if (i >= readUnsignedShort) {
                    j = -1;
                    break;
                }
                int b = openTypeReader.b();
                openTypeReader.a(4);
                j = openTypeReader.c();
                openTypeReader.a(4);
                if (1835365473 == b) {
                    break;
                }
                i++;
            }
            if (j != -1) {
                openTypeReader.a((int) (j - openTypeReader.getPosition()));
                openTypeReader.a(12);
                long c = openTypeReader.c();
                for (int i2 = 0; ((long) i2) < c; i2++) {
                    int b2 = openTypeReader.b();
                    long c2 = openTypeReader.c();
                    long c3 = openTypeReader.c();
                    if (1164798569 == b2 || 1701669481 == b2) {
                        return new OffsetInfo(c2 + j, c3);
                    }
                }
            }
            throw new IOException("Cannot read metadata.");
        }
        throw new IOException("Cannot read metadata.");
    }

    public static MetadataList b(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position((int) a(new ByteBufferReader(duplicate)).a());
        return MetadataList.i(duplicate);
    }

    public static long c(int i) {
        return ((long) i) & 4294967295L;
    }

    public static int d(short s) {
        return s & UShort.MAX_VALUE;
    }
}
