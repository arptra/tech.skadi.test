package org.apache.tika.config;

import org.apache.tika.parser.ParseContext;

public class TikaTaskTimeout {

    /* renamed from: a  reason: collision with root package name */
    public final long f4142a;

    public static long b(ParseContext parseContext, long j) {
        TikaTaskTimeout tikaTaskTimeout = (TikaTaskTimeout) parseContext.get(TikaTaskTimeout.class);
        return tikaTaskTimeout == null ? j : tikaTaskTimeout.a();
    }

    public long a() {
        return this.f4142a;
    }
}
