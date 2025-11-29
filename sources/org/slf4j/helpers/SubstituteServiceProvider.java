package org.slf4j.helpers;

import org.slf4j.ILoggerFactory;
import org.slf4j.IMarkerFactory;
import org.slf4j.spi.MDCAdapter;
import org.slf4j.spi.SLF4JServiceProvider;

public class SubstituteServiceProvider implements SLF4JServiceProvider {

    /* renamed from: a  reason: collision with root package name */
    public final SubstituteLoggerFactory f3465a = new SubstituteLoggerFactory();
    public final IMarkerFactory b = new BasicMarkerFactory();
    public final MDCAdapter c = new BasicMDCAdapter();

    public ILoggerFactory a() {
        return this.f3465a;
    }

    public IMarkerFactory b() {
        return this.b;
    }

    public MDCAdapter c() {
        return this.c;
    }

    public String d() {
        throw new UnsupportedOperationException();
    }

    public SubstituteLoggerFactory e() {
        return this.f3465a;
    }

    public void initialize() {
    }
}
