package zmq.util;

public final class Errno {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal f3670a = new ThreadLocal<Integer>() {
        /* renamed from: a */
        public Integer initialValue() {
            return 0;
        }
    };

    public int a() {
        return ((Integer) f3670a.get()).intValue();
    }

    public boolean b(int i) {
        return a() == i;
    }

    public void c(int i) {
        f3670a.set(Integer.valueOf(i));
    }

    public String toString() {
        return "Errno[" + a() + "]";
    }
}
