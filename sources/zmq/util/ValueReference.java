package zmq.util;

public class ValueReference<V> {

    /* renamed from: a  reason: collision with root package name */
    public Object f3674a;

    public ValueReference(Object obj) {
        this.f3674a = obj;
    }

    public final Object a() {
        return this.f3674a;
    }

    public final void b(Object obj) {
        this.f3674a = obj;
    }

    public String toString() {
        Object obj = this.f3674a;
        return obj == null ? "null" : obj.toString();
    }

    public ValueReference() {
    }
}
