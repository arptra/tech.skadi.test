package org.slf4j.helpers;

import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.event.Level;
import org.slf4j.spi.LoggingEventBuilder;

public class NOPLogger extends NamedLoggerBase implements Logger {
    public static final NOPLogger NOP_LOGGER = new NOPLogger();
    private static final long serialVersionUID = -517220405410904473L;

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

    public final void debug(String str) {
    }

    public final void error(String str) {
    }

    public String getName() {
        return "NOP";
    }

    public final void info(String str) {
    }

    public final boolean isDebugEnabled() {
        return false;
    }

    public /* bridge */ /* synthetic */ boolean isEnabledForLevel(Level level) {
        return super.isEnabledForLevel(level);
    }

    public final boolean isErrorEnabled() {
        return false;
    }

    public final boolean isInfoEnabled() {
        return false;
    }

    public final boolean isTraceEnabled() {
        return false;
    }

    public final boolean isWarnEnabled() {
        return false;
    }

    public /* bridge */ /* synthetic */ LoggingEventBuilder makeLoggingEventBuilder(Level level) {
        return super.makeLoggingEventBuilder(level);
    }

    public final void trace(String str) {
    }

    public final void warn(String str) {
    }

    public final void debug(String str, Object obj) {
    }

    public final void error(String str, Object obj) {
    }

    public final void info(String str, Object obj) {
    }

    public final boolean isDebugEnabled(Marker marker) {
        return false;
    }

    public final boolean isErrorEnabled(Marker marker) {
        return false;
    }

    public boolean isInfoEnabled(Marker marker) {
        return false;
    }

    public final boolean isTraceEnabled(Marker marker) {
        return false;
    }

    public final boolean isWarnEnabled(Marker marker) {
        return false;
    }

    public final void trace(String str, Object obj) {
    }

    public final void warn(String str, Object obj) {
    }

    public final void debug(String str, Object obj, Object obj2) {
    }

    public final void error(String str, Object obj, Object obj2) {
    }

    public final void info(String str, Object obj, Object obj2) {
    }

    public final void trace(String str, Object obj, Object obj2) {
    }

    public final void warn(String str, Object obj, Object obj2) {
    }

    public final void debug(String str, Throwable th) {
    }

    public final void error(String str, Throwable th) {
    }

    public final void info(String str, Throwable th) {
    }

    public final void trace(String str, Throwable th) {
    }

    public final void warn(String str, Throwable th) {
    }

    public final void debug(String str, Object... objArr) {
    }

    public final void error(String str, Object... objArr) {
    }

    public final void info(String str, Object... objArr) {
    }

    public final void trace(String str, Object... objArr) {
    }

    public final void warn(String str, Object... objArr) {
    }

    public final void debug(Marker marker, String str) {
    }

    public final void error(Marker marker, String str) {
    }

    public final void info(Marker marker, String str) {
    }

    public final void trace(Marker marker, String str) {
    }

    public final void warn(Marker marker, String str) {
    }

    public final void debug(Marker marker, String str, Object obj) {
    }

    public final void error(Marker marker, String str, Object obj) {
    }

    public final void info(Marker marker, String str, Object obj) {
    }

    public final void trace(Marker marker, String str, Object obj) {
    }

    public final void warn(Marker marker, String str, Object obj) {
    }

    public final void debug(Marker marker, String str, Object obj, Object obj2) {
    }

    public final void error(Marker marker, String str, Object obj, Object obj2) {
    }

    public final void info(Marker marker, String str, Object obj, Object obj2) {
    }

    public final void trace(Marker marker, String str, Object obj, Object obj2) {
    }

    public final void warn(Marker marker, String str, Object obj, Object obj2) {
    }

    public final void debug(Marker marker, String str, Throwable th) {
    }

    public final void error(Marker marker, String str, Throwable th) {
    }

    public final void info(Marker marker, String str, Throwable th) {
    }

    public final void trace(Marker marker, String str, Throwable th) {
    }

    public final void warn(Marker marker, String str, Throwable th) {
    }

    public final void debug(Marker marker, String str, Object... objArr) {
    }

    public final void error(Marker marker, String str, Object... objArr) {
    }

    public final void info(Marker marker, String str, Object... objArr) {
    }

    public final void trace(Marker marker, String str, Object... objArr) {
    }

    public final void warn(Marker marker, String str, Object... objArr) {
    }
}
