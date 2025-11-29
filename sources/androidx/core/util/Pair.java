package androidx.core.util;

public class Pair<F, S> {

    /* renamed from: a  reason: collision with root package name */
    public final Object f847a;
    public final Object b;

    public Pair(Object obj, Object obj2) {
        this.f847a = obj;
        this.b = obj2;
    }

    public static Pair a(Object obj, Object obj2) {
        return new Pair(obj, obj2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return ObjectsCompat.a(pair.f847a, this.f847a) && ObjectsCompat.a(pair.b, this.b);
    }

    public int hashCode() {
        Object obj = this.f847a;
        int i = 0;
        int hashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.b;
        if (obj2 != null) {
            i = obj2.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "Pair{" + this.f847a + " " + this.b + "}";
    }
}
