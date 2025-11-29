package com.google.android.gms.internal.mlkit_common;

import java.util.Iterator;
import java.util.Set;

public final class zzar {
    public static int zza(Set set) {
        Iterator it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i += next != null ? next.hashCode() : 0;
        }
        return i;
    }
}
