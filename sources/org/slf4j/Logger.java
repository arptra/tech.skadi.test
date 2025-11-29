package org.slf4j;

import org.slf4j.event.Level;
import org.slf4j.spi.DefaultLoggingEventBuilder;
import org.slf4j.spi.LoggingEventBuilder;
import org.slf4j.spi.NOPLoggingEventBuilder;

public interface Logger {
    LoggingEventBuilder atDebug() {
        return isDebugEnabled() ? makeLoggingEventBuilder(Level.DEBUG) : NOPLoggingEventBuilder.a();
    }

    LoggingEventBuilder atError() {
        return isErrorEnabled() ? makeLoggingEventBuilder(Level.ERROR) : NOPLoggingEventBuilder.a();
    }

    LoggingEventBuilder atInfo() {
        return isInfoEnabled() ? makeLoggingEventBuilder(Level.INFO) : NOPLoggingEventBuilder.a();
    }

    LoggingEventBuilder atLevel(Level level) {
        return isEnabledForLevel(level) ? makeLoggingEventBuilder(level) : NOPLoggingEventBuilder.a();
    }

    LoggingEventBuilder atTrace() {
        return isTraceEnabled() ? makeLoggingEventBuilder(Level.TRACE) : NOPLoggingEventBuilder.a();
    }

    LoggingEventBuilder atWarn() {
        return isWarnEnabled() ? makeLoggingEventBuilder(Level.WARN) : NOPLoggingEventBuilder.a();
    }

    void debug(String str);

    void debug(String str, Object obj);

    void debug(String str, Object obj, Object obj2);

    void debug(String str, Throwable th);

    void debug(String str, Object... objArr);

    void error(String str);

    void error(String str, Object obj);

    void error(String str, Object obj, Object obj2);

    void error(String str, Throwable th);

    void error(String str, Object... objArr);

    String getName();

    void info(String str);

    void info(String str, Object obj);

    void info(String str, Object obj, Object obj2);

    void info(String str, Throwable th);

    void info(String str, Object... objArr);

    boolean isDebugEnabled();

    boolean isDebugEnabled(Marker marker);

    boolean isEnabledForLevel(Level level) {
        int i = level.toInt();
        if (i == 0) {
            return isTraceEnabled();
        }
        if (i == 10) {
            return isDebugEnabled();
        }
        if (i == 20) {
            return isInfoEnabled();
        }
        if (i == 30) {
            return isWarnEnabled();
        }
        if (i == 40) {
            return isErrorEnabled();
        }
        throw new IllegalArgumentException("Level [" + level + "] not recognized.");
    }

    boolean isErrorEnabled();

    boolean isErrorEnabled(Marker marker);

    boolean isInfoEnabled();

    boolean isInfoEnabled(Marker marker);

    boolean isTraceEnabled();

    boolean isTraceEnabled(Marker marker);

    boolean isWarnEnabled();

    boolean isWarnEnabled(Marker marker);

    LoggingEventBuilder makeLoggingEventBuilder(Level level) {
        return new DefaultLoggingEventBuilder(this, level);
    }

    void trace(String str);

    void trace(String str, Object obj);

    void trace(String str, Object obj, Object obj2);

    void trace(String str, Throwable th);

    void trace(String str, Object... objArr);

    void warn(String str);

    void warn(String str, Object obj);

    void warn(String str, Object obj, Object obj2);

    void warn(String str, Throwable th);

    void warn(String str, Object... objArr);
}
