package org.slf4j.helpers;

import org.slf4j.ILoggerFactory;
import org.slf4j.IMarkerFactory;
import org.slf4j.spi.MDCAdapter;
import org.slf4j.spi.SLF4JServiceProvider;

public class NOP_FallbackServiceProvider implements SLF4JServiceProvider {
    public static String d = "2.0.99";

    /* renamed from: a  reason: collision with root package name */
    public final ILoggerFactory f3462a = new NOPLoggerFactory();
    public final IMarkerFactory b = new BasicMarkerFactory();
    public final MDCAdapter c = new NOPMDCAdapter();

    public ILoggerFactory a() {
        return this.f3462a;
    }

    public IMarkerFactory b() {
        return this.b;
    }

    public MDCAdapter c() {
        return this.c;
    }

    public String d() {
        return d;
    }

    public void initialize() {
    }
}
