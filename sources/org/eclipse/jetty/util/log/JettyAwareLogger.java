package org.eclipse.jetty.util.log;

import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.event.Level;
import org.slf4j.helpers.CheckReturnValue;
import org.slf4j.helpers.MessageFormatter;
import org.slf4j.spi.LocationAwareLogger;
import org.slf4j.spi.LoggingEventBuilder;

class JettyAwareLogger implements Logger {
    private static final int DEBUG = 10;
    private static final int ERROR = 40;
    private static final String FQCN = Slf4jLog.class.getName();
    private static final int INFO = 20;
    private static final int TRACE = 0;
    private static final int WARN = 30;
    private final LocationAwareLogger _logger;

    public JettyAwareLogger(LocationAwareLogger locationAwareLogger) {
        this._logger = locationAwareLogger;
    }

    private void log(Marker marker, int i, String str, Object[] objArr, Throwable th) {
        if (objArr == null) {
            this._logger.a(marker, FQCN, i, str, (Object[]) null, th);
            return;
        }
        if ((this._logger.isTraceEnabled() ? 0 : this._logger.isDebugEnabled() ? 10 : this._logger.isInfoEnabled() ? 20 : this._logger.isWarnEnabled() ? 30 : 40) <= i) {
            this._logger.a(marker, FQCN, i, MessageFormatter.a(str, objArr).b(), (Object[]) null, th);
        }
    }

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

    public void debug(String str) {
        log((Marker) null, 10, str, (Object[]) null, (Throwable) null);
    }

    public void error(String str) {
        log((Marker) null, 40, str, (Object[]) null, (Throwable) null);
    }

    public String getName() {
        return this._logger.getName();
    }

    public void info(String str) {
        log((Marker) null, 20, str, (Object[]) null, (Throwable) null);
    }

    public boolean isDebugEnabled() {
        return this._logger.isDebugEnabled();
    }

    public /* bridge */ /* synthetic */ boolean isEnabledForLevel(Level level) {
        return super.isEnabledForLevel(level);
    }

    public boolean isErrorEnabled() {
        return this._logger.isErrorEnabled();
    }

    public boolean isInfoEnabled() {
        return this._logger.isInfoEnabled();
    }

    public boolean isTraceEnabled() {
        return this._logger.isTraceEnabled();
    }

    public boolean isWarnEnabled() {
        return this._logger.isWarnEnabled();
    }

    public /* bridge */ /* synthetic */ LoggingEventBuilder makeLoggingEventBuilder(Level level) {
        return super.makeLoggingEventBuilder(level);
    }

    public String toString() {
        return this._logger.toString();
    }

    public void trace(String str) {
        log((Marker) null, 0, str, (Object[]) null, (Throwable) null);
    }

    public void warn(String str) {
        log((Marker) null, 30, str, (Object[]) null, (Throwable) null);
    }

    public void debug(String str, Object obj) {
        log((Marker) null, 10, str, new Object[]{obj}, (Throwable) null);
    }

    public void error(String str, Object obj) {
        log((Marker) null, 40, str, new Object[]{obj}, (Throwable) null);
    }

    public void info(String str, Object obj) {
        log((Marker) null, 20, str, new Object[]{obj}, (Throwable) null);
    }

    public boolean isDebugEnabled(Marker marker) {
        return this._logger.isDebugEnabled(marker);
    }

    public boolean isErrorEnabled(Marker marker) {
        return this._logger.isErrorEnabled(marker);
    }

    public boolean isInfoEnabled(Marker marker) {
        return this._logger.isInfoEnabled(marker);
    }

    public boolean isTraceEnabled(Marker marker) {
        return this._logger.isTraceEnabled(marker);
    }

    public boolean isWarnEnabled(Marker marker) {
        return this._logger.isWarnEnabled(marker);
    }

    public void trace(String str, Object obj) {
        log((Marker) null, 0, str, new Object[]{obj}, (Throwable) null);
    }

    public void warn(String str, Object obj) {
        log((Marker) null, 30, str, new Object[]{obj}, (Throwable) null);
    }

    public void debug(String str, Object obj, Object obj2) {
        log((Marker) null, 10, str, new Object[]{obj, obj2}, (Throwable) null);
    }

    public void error(String str, Object obj, Object obj2) {
        log((Marker) null, 40, str, new Object[]{obj, obj2}, (Throwable) null);
    }

    public void info(String str, Object obj, Object obj2) {
        log((Marker) null, 20, str, new Object[]{obj, obj2}, (Throwable) null);
    }

    public void trace(String str, Object obj, Object obj2) {
        log((Marker) null, 0, str, new Object[]{obj, obj2}, (Throwable) null);
    }

    public void warn(String str, Object[] objArr) {
        log((Marker) null, 30, str, objArr, (Throwable) null);
    }

    public void debug(String str, Object[] objArr) {
        log((Marker) null, 10, str, objArr, (Throwable) null);
    }

    public void error(String str, Object[] objArr) {
        log((Marker) null, 40, str, objArr, (Throwable) null);
    }

    public void info(String str, Object[] objArr) {
        log((Marker) null, 20, str, objArr, (Throwable) null);
    }

    public void trace(String str, Object[] objArr) {
        log((Marker) null, 0, str, objArr, (Throwable) null);
    }

    public void warn(String str, Object obj, Object obj2) {
        log((Marker) null, 30, str, new Object[]{obj, obj2}, (Throwable) null);
    }

    public void debug(String str, Throwable th) {
        log((Marker) null, 10, str, (Object[]) null, th);
    }

    public void error(String str, Throwable th) {
        log((Marker) null, 40, str, (Object[]) null, th);
    }

    public void info(String str, Throwable th) {
        log((Marker) null, 20, str, (Object[]) null, th);
    }

    public void trace(String str, Throwable th) {
        log((Marker) null, 0, str, (Object[]) null, th);
    }

    public void warn(String str, Throwable th) {
        log((Marker) null, 30, str, (Object[]) null, th);
    }

    public void debug(Marker marker, String str) {
        log(marker, 10, str, (Object[]) null, (Throwable) null);
    }

    public void error(Marker marker, String str) {
        log(marker, 40, str, (Object[]) null, (Throwable) null);
    }

    public void info(Marker marker, String str) {
        log(marker, 20, str, (Object[]) null, (Throwable) null);
    }

    public void trace(Marker marker, String str) {
        log(marker, 0, str, (Object[]) null, (Throwable) null);
    }

    public void warn(Marker marker, String str) {
        log(marker, 30, str, (Object[]) null, (Throwable) null);
    }

    public void debug(Marker marker, String str, Object obj) {
        log(marker, 10, str, new Object[]{obj}, (Throwable) null);
    }

    public void error(Marker marker, String str, Object obj) {
        log(marker, 40, str, new Object[]{obj}, (Throwable) null);
    }

    public void info(Marker marker, String str, Object obj) {
        log(marker, 20, str, new Object[]{obj}, (Throwable) null);
    }

    public void trace(Marker marker, String str, Object obj) {
        log(marker, 0, str, new Object[]{obj}, (Throwable) null);
    }

    public void warn(Marker marker, String str, Object obj) {
        log(marker, 30, str, new Object[]{obj}, (Throwable) null);
    }

    public void debug(Marker marker, String str, Object obj, Object obj2) {
        log(marker, 10, str, new Object[]{obj, obj2}, (Throwable) null);
    }

    public void error(Marker marker, String str, Object obj, Object obj2) {
        log(marker, 40, str, new Object[]{obj, obj2}, (Throwable) null);
    }

    public void info(Marker marker, String str, Object obj, Object obj2) {
        log(marker, 20, str, new Object[]{obj, obj2}, (Throwable) null);
    }

    public void trace(Marker marker, String str, Object obj, Object obj2) {
        log(marker, 0, str, new Object[]{obj, obj2}, (Throwable) null);
    }

    public void warn(Marker marker, String str, Object obj, Object obj2) {
        log(marker, 30, str, new Object[]{obj, obj2}, (Throwable) null);
    }

    public void debug(Marker marker, String str, Object[] objArr) {
        log(marker, 10, str, objArr, (Throwable) null);
    }

    public void error(Marker marker, String str, Object[] objArr) {
        log(marker, 40, str, objArr, (Throwable) null);
    }

    public void info(Marker marker, String str, Object[] objArr) {
        log(marker, 20, str, objArr, (Throwable) null);
    }

    public void trace(Marker marker, String str, Object[] objArr) {
        log(marker, 0, str, objArr, (Throwable) null);
    }

    public void warn(Marker marker, String str, Object[] objArr) {
        log(marker, 30, str, objArr, (Throwable) null);
    }

    public void debug(Marker marker, String str, Throwable th) {
        log(marker, 10, str, (Object[]) null, th);
    }

    public void error(Marker marker, String str, Throwable th) {
        log(marker, 40, str, (Object[]) null, th);
    }

    public void info(Marker marker, String str, Throwable th) {
        log(marker, 20, str, (Object[]) null, th);
    }

    public void trace(Marker marker, String str, Throwable th) {
        log(marker, 0, str, (Object[]) null, th);
    }

    public void warn(Marker marker, String str, Throwable th) {
        log(marker, 30, str, (Object[]) null, th);
    }
}
