package rxhttp.wrapper.entity;

public class Progress<T> {

    /* renamed from: a  reason: collision with root package name */
    public final long f3557a;
    public final long b;
    public final long c;
    public Object d;

    public Progress(Object obj) {
        this(0, 0, 0);
        this.d = obj;
    }

    public long a() {
        return this.f3557a;
    }

    public float b() {
        long j = this.b;
        if (j == -1) {
            return 0.0f;
        }
        if (j >= 0) {
            long j2 = this.f3557a;
            if (j2 <= j) {
                return (((float) j2) * 1.0f) / ((float) j);
            }
            throw new IllegalArgumentException("totalSize can't be greater than totalSize, currentSize=" + this.f3557a + " totalSize=" + this.b);
        }
        throw new IllegalArgumentException("totalSize must be greater than 0, but it was " + this.b);
    }

    public Object c() {
        return this.d;
    }

    public long d() {
        return this.b;
    }

    public String toString() {
        return "Progress{fraction=" + b() + ", currentSize=" + this.f3557a + ", totalSize=" + this.b + ", speed=" + this.c + '}';
    }

    public Progress(long j, long j2, long j3) {
        this.f3557a = j;
        this.b = j2;
        this.c = j3;
    }
}
