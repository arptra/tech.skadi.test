package androidx.preference;

import java.util.Set;

public abstract class PreferenceDataStore {
    public boolean a(String str, boolean z) {
        return z;
    }

    public float b(String str, float f) {
        return f;
    }

    public int c(String str, int i) {
        return i;
    }

    public long d(String str, long j) {
        return j;
    }

    public String e(String str, String str2) {
        return str2;
    }

    public Set f(String str, Set set) {
        return set;
    }

    public void g(String str, boolean z) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void h(String str, float f) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void i(String str, int i) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void j(String str, long j) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void k(String str, String str2) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void l(String str, Set set) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }
}
