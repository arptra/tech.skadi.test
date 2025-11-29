package androidx.emoji2.text.flatbuffer;

import java.util.Comparator;

public class FlexBuffersBuilder {

    /* renamed from: a  reason: collision with root package name */
    public final ReadWriteBuf f1228a;

    /* renamed from: androidx.emoji2.text.flatbuffer.FlexBuffersBuilder$1  reason: invalid class name */
    public class AnonymousClass1 implements Comparator<Value> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FlexBuffersBuilder f1229a;

        /* renamed from: a */
        public int compare(Value value, Value value2) {
            byte b;
            byte b2;
            int i = value.f1230a;
            int i2 = value2.f1230a;
            do {
                b = this.f1229a.f1228a.get(i);
                b2 = this.f1229a.f1228a.get(i2);
                if (b == 0) {
                    return b - b2;
                }
                i++;
                i2++;
            } while (b == b2);
            return b - b2;
        }
    }

    public static class Value {

        /* renamed from: a  reason: collision with root package name */
        public int f1230a;
    }
}
