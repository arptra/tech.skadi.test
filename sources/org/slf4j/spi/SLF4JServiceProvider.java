package org.slf4j.spi;

import org.slf4j.ILoggerFactory;
import org.slf4j.IMarkerFactory;

public interface SLF4JServiceProvider {
    ILoggerFactory a();

    IMarkerFactory b();

    MDCAdapter c();

    String d();

    void initialize();
}
