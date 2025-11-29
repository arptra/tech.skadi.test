package com.bumptech.glide.util;

public class MultiClassKey {

    /* renamed from: a  reason: collision with root package name */
    public Class f2748a;
    public Class b;
    public Class c;

    public MultiClassKey() {
    }

    public void a(Class cls, Class cls2, Class cls3) {
        this.f2748a = cls;
        this.b = cls2;
        this.c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MultiClassKey multiClassKey = (MultiClassKey) obj;
        return this.f2748a.equals(multiClassKey.f2748a) && this.b.equals(multiClassKey.b) && Util.e(this.c, multiClassKey.c);
    }

    public int hashCode() {
        int hashCode = ((this.f2748a.hashCode() * 31) + this.b.hashCode()) * 31;
        Class cls = this.c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f2748a + ", second=" + this.b + '}';
    }

    public MultiClassKey(Class cls, Class cls2, Class cls3) {
        a(cls, cls2, cls3);
    }
}
