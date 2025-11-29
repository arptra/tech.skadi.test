package org.zeromq.util;

import java.util.Map;
import org.zeromq.ZConfig;
import zmq.io.Metadata;

public class ZMetadata {

    /* renamed from: a  reason: collision with root package name */
    public final Metadata f3520a;

    public ZMetadata() {
        this(new Metadata());
    }

    public static ZMetadata b(ZConfig zConfig) {
        ZConfig c = zConfig.c("metadata");
        if (c == null) {
            return null;
        }
        ZMetadata zMetadata = new ZMetadata();
        for (Map.Entry entry : c.f().entrySet()) {
            zMetadata.c((String) entry.getKey(), (String) entry.getValue());
        }
        return zMetadata;
    }

    public final byte[] a() {
        return this.f3520a.a();
    }

    public final void c(String str, String str2) {
        this.f3520a.e(str, str2);
    }

    public boolean equals(Object obj) {
        return this.f3520a.equals(obj);
    }

    public int hashCode() {
        return this.f3520a.hashCode();
    }

    public String toString() {
        return this.f3520a.toString();
    }

    public ZMetadata(Metadata metadata) {
        this.f3520a = metadata;
    }
}
