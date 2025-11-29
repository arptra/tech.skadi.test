package rxhttp.wrapper.entity;

public class KeyValuePair {

    /* renamed from: a  reason: collision with root package name */
    public final String f3554a;
    public final Object b;
    public final boolean c;

    public String a() {
        return this.f3554a;
    }

    public Object b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof KeyValuePair)) {
            return false;
        }
        return ((KeyValuePair) obj).a().equals(a());
    }

    public int hashCode() {
        return this.f3554a.hashCode();
    }
}
