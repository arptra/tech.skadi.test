package zmq.pipe;

class YQueue<T> {

    /* renamed from: a  reason: collision with root package name */
    public Chunk f3651a;
    public int b;
    public Chunk c;
    public int d;
    public Chunk e;
    public int f;
    public volatile Chunk g;
    public final int h;
    public int i = 0;

    public static class Chunk<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Object[] f3652a;
        public final int[] b;
        public Chunk c;
        public Chunk d;

        public Chunk(int i, int i2) {
            this.f3652a = new Object[i];
            this.b = new int[i];
            for (int i3 = 0; i3 != this.f3652a.length; i3++) {
                this.b[i3] = i2;
                i2++;
            }
        }
    }

    public YQueue(int i2) {
        this.h = i2;
        Chunk chunk = new Chunk(i2, 0);
        this.f3651a = chunk;
        this.i += i2;
        this.b = 0;
        this.d = 0;
        this.c = chunk;
        this.g = chunk;
        this.e = this.f3651a;
        this.f = 1;
    }

    public Object a() {
        return this.c.f3652a[this.d];
    }

    public int b() {
        return this.c.b[this.d];
    }

    public Object c() {
        return this.f3651a.f3652a[this.b];
    }

    public int d() {
        return this.f3651a.b[this.b];
    }

    public Object e() {
        Chunk chunk = this.f3651a;
        Object[] objArr = chunk.f3652a;
        int i2 = this.b;
        Object obj = objArr[i2];
        objArr[i2] = null;
        int i3 = i2 + 1;
        this.b = i3;
        if (i3 == this.h) {
            Chunk chunk2 = chunk.d;
            this.f3651a = chunk2;
            chunk2.c = null;
            this.b = 0;
        }
        return obj;
    }

    public void f(Object obj) {
        this.c.f3652a[this.d] = obj;
        this.c = this.e;
        int i2 = this.f;
        this.d = i2;
        int i3 = i2 + 1;
        this.f = i3;
        if (i3 == this.h) {
            Chunk chunk = this.g;
            if (chunk != this.f3651a) {
                this.g = this.g.d;
                Chunk chunk2 = this.e;
                chunk2.d = chunk;
                chunk.c = chunk2;
            } else {
                this.e.d = new Chunk(this.h, this.i);
                this.i += this.h;
                Chunk chunk3 = this.e;
                chunk3.d.c = chunk3;
            }
            this.e = this.e.d;
            this.f = 0;
        }
    }

    public void g() {
        int i2 = this.d;
        if (i2 > 0) {
            this.d = i2 - 1;
        } else {
            this.d = this.h - 1;
            this.c = this.c.c;
        }
        int i3 = this.f;
        if (i3 > 0) {
            this.f = i3 - 1;
            return;
        }
        this.f = this.h - 1;
        Chunk chunk = this.e.c;
        this.e = chunk;
        chunk.d = null;
    }
}
