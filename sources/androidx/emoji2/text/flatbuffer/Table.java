package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.util.Comparator;

public class Table {

    /* renamed from: a  reason: collision with root package name */
    public int f1231a;
    public ByteBuffer b;
    public int c;
    public int d;
    public Utf8 e = Utf8.a();

    /* renamed from: androidx.emoji2.text.flatbuffer.Table$1  reason: invalid class name */
    class AnonymousClass1 implements Comparator<Integer> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ByteBuffer f1232a;
        public final /* synthetic */ Table b;

        /* renamed from: a */
        public int compare(Integer num, Integer num2) {
            return this.b.f(num, num2, this.f1232a);
        }
    }

    public int a(int i) {
        return i + this.b.getInt(i);
    }

    public int b(int i) {
        if (i < this.d) {
            return this.b.getShort(this.c + i);
        }
        return 0;
    }

    public void c(int i, ByteBuffer byteBuffer) {
        this.b = byteBuffer;
        if (byteBuffer != null) {
            this.f1231a = i;
            int i2 = i - byteBuffer.getInt(i);
            this.c = i2;
            this.d = this.b.getShort(i2);
            return;
        }
        this.f1231a = 0;
        this.c = 0;
        this.d = 0;
    }

    public int d(int i) {
        int i2 = i + this.f1231a;
        return i2 + this.b.getInt(i2) + 4;
    }

    public int e(int i) {
        int i2 = i + this.f1231a;
        return this.b.getInt(i2 + this.b.getInt(i2));
    }

    public int f(Integer num, Integer num2, ByteBuffer byteBuffer) {
        return 0;
    }
}
