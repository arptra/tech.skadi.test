package androidx.core.provider;

import android.util.Base64;
import androidx.core.util.Preconditions;
import com.meizu.common.util.LunarCalendar;
import java.util.List;

public final class FontRequest {

    /* renamed from: a  reason: collision with root package name */
    public final String f789a;
    public final String b;
    public final String c;
    public final List d;
    public final int e = 0;
    public final String f;

    public FontRequest(String str, String str2, String str3, List list) {
        this.f789a = (String) Preconditions.h(str);
        this.b = (String) Preconditions.h(str2);
        this.c = (String) Preconditions.h(str3);
        this.d = (List) Preconditions.h(list);
        this.f = a(str, str2, str3);
    }

    public final String a(String str, String str2, String str3) {
        return str + LunarCalendar.DATE_SEPARATOR + str2 + LunarCalendar.DATE_SEPARATOR + str3;
    }

    public List b() {
        return this.d;
    }

    public int c() {
        return this.e;
    }

    public String d() {
        return this.f;
    }

    public String e() {
        return this.f789a;
    }

    public String f() {
        return this.b;
    }

    public String g() {
        return this.c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f789a + ", mProviderPackage: " + this.b + ", mQuery: " + this.c + ", mCertificates:");
        for (int i = 0; i < this.d.size(); i++) {
            sb.append(" [");
            List list = (List) this.d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.e);
        return sb.toString();
    }
}
