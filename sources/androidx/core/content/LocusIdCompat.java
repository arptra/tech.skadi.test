package androidx.core.content;

import android.content.LocusId;
import androidx.annotation.RequiresApi;

public final class LocusIdCompat {

    /* renamed from: a  reason: collision with root package name */
    public final String f688a;
    public final LocusId b;

    @RequiresApi
    public static class Api29Impl {
    }

    public final String a() {
        int length = this.f688a.length();
        return length + "_chars";
    }

    public LocusId b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || LocusIdCompat.class != obj.getClass()) {
            return false;
        }
        LocusIdCompat locusIdCompat = (LocusIdCompat) obj;
        String str = this.f688a;
        return str == null ? locusIdCompat.f688a == null : str.equals(locusIdCompat.f688a);
    }

    public int hashCode() {
        String str = this.f688a;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "LocusIdCompat[" + a() + "]";
    }
}
