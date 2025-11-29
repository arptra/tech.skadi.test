package androidx.constraintlayout.core.parser;

import com.meizu.common.util.LunarCalendar;
import kotlin.jvm.internal.LongCompanionObject;

public class CLElement {

    /* renamed from: a  reason: collision with root package name */
    public final char[] f514a;
    public long b;
    public long c;
    public int d;

    public int a() {
        return this.d;
    }

    public String b() {
        String cls = getClass().toString();
        return cls.substring(cls.lastIndexOf(46) + 1);
    }

    public String toString() {
        long j = this.b;
        long j2 = this.c;
        if (j > j2 || j2 == LongCompanionObject.MAX_VALUE) {
            return getClass() + " (INVALID, " + this.b + LunarCalendar.DATE_SEPARATOR + this.c + ")";
        }
        String substring = new String(this.f514a).substring((int) this.b, ((int) this.c) + 1);
        return b() + " (" + this.b + " : " + this.c + ") <<" + substring + ">>";
    }
}
