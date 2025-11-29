package org.slf4j;

import org.slf4j.helpers.BasicMarkerFactory;
import org.slf4j.helpers.Util;
import org.slf4j.spi.SLF4JServiceProvider;

public class MarkerFactory {

    /* renamed from: a  reason: collision with root package name */
    public static IMarkerFactory f3454a;

    static {
        SLF4JServiceProvider m = LoggerFactory.m();
        if (m != null) {
            f3454a = m.b();
            return;
        }
        Util.c("Failed to find provider");
        Util.c("Defaulting to BasicMarkerFactory.");
        f3454a = new BasicMarkerFactory();
    }
}
