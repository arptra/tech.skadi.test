package org.slf4j.helpers;

import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.event.Level;
import org.slf4j.spi.LoggingEventBuilder;

public abstract class MarkerIgnoringBase extends NamedLoggerBase implements Logger {
    private static final long serialVersionUID = 9044267456635152283L;

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

    public abstract /* synthetic */ void debug(String str);

    public abstract /* synthetic */ void debug(String str, Object obj);

    public abstract /* synthetic */ void debug(String str, Object obj, Object obj2);

    public abstract /* synthetic */ void debug(String str, Throwable th);

    public abstract /* synthetic */ void debug(String str, Object... objArr);

    public void debug(Marker marker, String str) {
        debug(str);
    }

    public abstract /* synthetic */ void error(String str);

    public abstract /* synthetic */ void error(String str, Object obj);

    public abstract /* synthetic */ void error(String str, Object obj, Object obj2);

    public abstract /* synthetic */ void error(String str, Throwable th);

    public abstract /* synthetic */ void error(String str, Object... objArr);

    public void error(Marker marker, String str) {
        error(str);
    }

    public /* bridge */ /* synthetic */ String getName() {
        return super.getName();
    }

    public abstract /* synthetic */ void info(String str);

    public abstract /* synthetic */ void info(String str, Object obj);

    public abstract /* synthetic */ void info(String str, Object obj, Object obj2);

    public abstract /* synthetic */ void info(String str, Throwable th);

    public abstract /* synthetic */ void info(String str, Object... objArr);

    public void info(Marker marker, String str) {
        info(str);
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

    public String toString() {
        return getClass().getName() + "(" + getName() + ")";
    }

    public abstract /* synthetic */ void trace(String str);

    public abstract /* synthetic */ void trace(String str, Object obj);

    public abstract /* synthetic */ void trace(String str, Object obj, Object obj2);

    public abstract /* synthetic */ void trace(String str, Throwable th);

    public abstract /* synthetic */ void trace(String str, Object... objArr);

    public void trace(Marker marker, String str) {
        trace(str);
    }

    public abstract /* synthetic */ void warn(String str);

    public abstract /* synthetic */ void warn(String str, Object obj);

    public abstract /* synthetic */ void warn(String str, Object obj, Object obj2);

    public abstract /* synthetic */ void warn(String str, Throwable th);

    public abstract /* synthetic */ void warn(String str, Object... objArr);

    public void warn(Marker marker, String str) {
        warn(str);
    }

    public void debug(Marker marker, String str, Object obj) {
        debug(str, obj);
    }

    public void error(Marker marker, String str, Object obj) {
        error(str, obj);
    }

    public void info(Marker marker, String str, Object obj) {
        info(str, obj);
    }

    public void trace(Marker marker, String str, Object obj) {
        trace(str, obj);
    }

    public void warn(Marker marker, String str, Object obj) {
        warn(str, obj);
    }

    public void debug(Marker marker, String str, Object obj, Object obj2) {
        debug(str, obj, obj2);
    }

    public void error(Marker marker, String str, Object obj, Object obj2) {
        error(str, obj, obj2);
    }

    public void info(Marker marker, String str, Object obj, Object obj2) {
        info(str, obj, obj2);
    }

    public void trace(Marker marker, String str, Object obj, Object obj2) {
        trace(str, obj, obj2);
    }

    public void warn(Marker marker, String str, Object obj, Object obj2) {
        warn(str, obj, obj2);
    }

    public void debug(Marker marker, String str, Object... objArr) {
        debug(str, objArr);
    }

    public void error(Marker marker, String str, Object... objArr) {
        error(str, objArr);
    }

    public void info(Marker marker, String str, Object... objArr) {
        info(str, objArr);
    }

    public void trace(Marker marker, String str, Object... objArr) {
        trace(str, objArr);
    }

    public void warn(Marker marker, String str, Object... objArr) {
        warn(str, objArr);
    }

    public void debug(Marker marker, String str, Throwable th) {
        debug(str, th);
    }

    public void error(Marker marker, String str, Throwable th) {
        error(str, th);
    }

    public void info(Marker marker, String str, Throwable th) {
        info(str, th);
    }

    public void trace(Marker marker, String str, Throwable th) {
        trace(str, th);
    }

    public void warn(Marker marker, String str, Throwable th) {
        warn(str, th);
    }
}
