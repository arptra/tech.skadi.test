package org.slf4j.helpers;

import org.slf4j.Marker;
import org.slf4j.event.Level;
import org.slf4j.spi.LoggingEventBuilder;

public abstract class LegacyAbstractLogger extends AbstractLogger {
    private static final long serialVersionUID = -7041884104854048950L;

    @CheckReturnValue
    public /* bridge */ /* synthetic */ LoggingEventBuilder atDebug() {
        return super.atDebug();
    }

    @CheckReturnValue
    public /* bridge */ /* synthetic */ LoggingEventBuilder atError() {
        return super.atError();
    }

    @CheckReturnValue
    public /* bridge */ /* synthetic */ LoggingEventBuilder atInfo() {
        return super.atInfo();
    }

    @CheckReturnValue
    public /* bridge */ /* synthetic */ LoggingEventBuilder atLevel(Level level) {
        return super.atLevel(level);
    }

    @CheckReturnValue
    public /* bridge */ /* synthetic */ LoggingEventBuilder atTrace() {
        return super.atTrace();
    }

    @CheckReturnValue
    public /* bridge */ /* synthetic */ LoggingEventBuilder atWarn() {
        return super.atWarn();
    }

    public abstract /* synthetic */ boolean isDebugEnabled();

    public boolean isDebugEnabled(Marker marker) {
        return isDebugEnabled();
    }

    public /* bridge */ /* synthetic */ boolean isEnabledForLevel(Level level) {
        return super.isEnabledForLevel(level);
    }

    public abstract /* synthetic */ boolean isErrorEnabled();

    public boolean isErrorEnabled(Marker marker) {
        return isErrorEnabled();
    }

    public abstract /* synthetic */ boolean isInfoEnabled();

    public boolean isInfoEnabled(Marker marker) {
        return isInfoEnabled();
    }

    public abstract /* synthetic */ boolean isTraceEnabled();

    public boolean isTraceEnabled(Marker marker) {
        return isTraceEnabled();
    }

    public abstract /* synthetic */ boolean isWarnEnabled();

    public boolean isWarnEnabled(Marker marker) {
        return isWarnEnabled();
    }

    public /* bridge */ /* synthetic */ LoggingEventBuilder makeLoggingEventBuilder(Level level) {
        return super.makeLoggingEventBuilder(level);
    }
}
