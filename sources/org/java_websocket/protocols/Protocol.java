package org.java_websocket.protocols;

import com.meizu.common.widget.MzContactsContract;
import java.util.regex.Pattern;

public class Protocol implements IProtocol {
    public static final Pattern b = Pattern.compile(" ");
    public static final Pattern c = Pattern.compile(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);

    /* renamed from: a  reason: collision with root package name */
    public final String f3402a;

    public Protocol(String str) {
        if (str != null) {
            this.f3402a = str;
            return;
        }
        throw new IllegalArgumentException();
    }

    public IProtocol a() {
        return new Protocol(c());
    }

    public boolean b(String str) {
        if ("".equals(this.f3402a)) {
            return true;
        }
        for (String equals : c.split(b.matcher(str).replaceAll(""))) {
            if (this.f3402a.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public String c() {
        return this.f3402a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f3402a.equals(((Protocol) obj).f3402a);
    }

    public int hashCode() {
        return this.f3402a.hashCode();
    }

    public String toString() {
        return c();
    }
}
