package com.xingin.xhssharesdk.a;

import java.util.Arrays;

public final class z {
    public static final z d = new z(0, new int[0], new Object[0]);

    /* renamed from: a  reason: collision with root package name */
    public final int f8152a;
    public final int[] b;
    public final Object[] c;

    public z(int i, int[] iArr, Object[] objArr) {
        this.f8152a = i;
        this.b = iArr;
        this.c = objArr;
    }

    public static z a(z zVar, z zVar2) {
        int i = zVar.f8152a + zVar2.f8152a;
        int[] copyOf = Arrays.copyOf(zVar.b, i);
        System.arraycopy(zVar2.b, 0, copyOf, zVar.f8152a, zVar2.f8152a);
        Object[] copyOf2 = Arrays.copyOf(zVar.c, i);
        System.arraycopy(zVar2.c, 0, copyOf2, zVar.f8152a, zVar2.f8152a);
        return new z(i, copyOf, copyOf2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return this.f8152a == zVar.f8152a && Arrays.equals(this.b, zVar.b) && Arrays.deepEquals(this.c, zVar.c);
    }

    public final int hashCode() {
        int hashCode = Arrays.hashCode(this.b);
        return Arrays.deepHashCode(this.c) + ((hashCode + ((this.f8152a + 527) * 31)) * 31);
    }
}
