package org.slf4j.helpers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Queue;
import org.slf4j.Logger;
import org.slf4j.event.EventRecordingLogger;
import org.slf4j.event.Level;
import org.slf4j.event.LoggingEvent;
import org.slf4j.spi.LoggingEventBuilder;

public class SubstituteLogger implements Logger {

    /* renamed from: a  reason: collision with root package name */
    public final String f3463a;
    public volatile Logger b;
    public Boolean c;
    public Method d;
    public EventRecordingLogger e;
    public final Queue f;
    public final boolean g;

    public SubstituteLogger(String str, Queue queue, boolean z) {
        this.f3463a = str;
        this.f = queue;
        this.g = z;
    }

    public Logger b() {
        return this.b != null ? this.b : this.g ? NOPLogger.NOP_LOGGER : c();
    }

    public final Logger c() {
        if (this.e == null) {
            this.e = new EventRecordingLogger(this, this.f);
        }
        return this.e;
    }

    public boolean d() {
        Boolean bool = this.c;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            this.d = this.b.getClass().getMethod("log", new Class[]{LoggingEvent.class});
            this.c = Boolean.TRUE;
        } catch (NoSuchMethodException unused) {
            this.c = Boolean.FALSE;
        }
        return this.c.booleanValue();
    }

    public void debug(String str) {
        b().debug(str);
    }

    public boolean e() {
        return this.b instanceof NOPLogger;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f3463a.equals(((SubstituteLogger) obj).f3463a);
    }

    public void error(String str) {
        b().error(str);
    }

    public boolean f() {
        return this.b == null;
    }

    public void g(LoggingEvent loggingEvent) {
        if (d()) {
            try {
                this.d.invoke(this.b, new Object[]{loggingEvent});
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    public String getName() {
        return this.f3463a;
    }

    public void h(Logger logger) {
        this.b = logger;
    }

    public int hashCode() {
        return this.f3463a.hashCode();
    }

    public void info(String str) {
        b().info(str);
    }

    public boolean isDebugEnabled() {
        return b().isDebugEnabled();
    }

    public boolean isEnabledForLevel(Level level) {
        return b().isEnabledForLevel(level);
    }

    public boolean isErrorEnabled() {
        return b().isErrorEnabled();
    }

    public boolean isInfoEnabled() {
        return b().isInfoEnabled();
    }

    public boolean isTraceEnabled() {
        return b().isTraceEnabled();
    }

    public boolean isWarnEnabled() {
        return b().isWarnEnabled();
    }

    public LoggingEventBuilder makeLoggingEventBuilder(Level level) {
        return b().makeLoggingEventBuilder(level);
    }

    public void trace(String str) {
        b().trace(str);
    }

    public void warn(String str) {
        b().warn(str);
    }

    public void debug(String str, Object obj) {
        b().debug(str, obj);
    }

    public void error(String str, Object obj) {
        b().error(str, obj);
    }

    public void info(String str, Object obj) {
        b().info(str, obj);
    }

    public void trace(String str, Object obj) {
        b().trace(str, obj);
    }

    public void warn(String str, Object obj) {
        b().warn(str, obj);
    }

    public void debug(String str, Object obj, Object obj2) {
        b().debug(str, obj, obj2);
    }

    public void error(String str, Object obj, Object obj2) {
        b().error(str, obj, obj2);
    }

    public void info(String str, Object obj, Object obj2) {
        b().info(str, obj, obj2);
    }

    public void trace(String str, Object obj, Object obj2) {
        b().trace(str, obj, obj2);
    }

    public void warn(String str, Object obj, Object obj2) {
        b().warn(str, obj, obj2);
    }

    public void debug(String str, Object... objArr) {
        b().debug(str, objArr);
    }

    public void error(String str, Object... objArr) {
        b().error(str, objArr);
    }

    public void info(String str, Object... objArr) {
        b().info(str, objArr);
    }

    public void trace(String str, Object... objArr) {
        b().trace(str, objArr);
    }

    public void warn(String str, Object... objArr) {
        b().warn(str, objArr);
    }

    public void debug(String str, Throwable th) {
        b().debug(str, th);
    }

    public void error(String str, Throwable th) {
        b().error(str, th);
    }

    public void info(String str, Throwable th) {
        b().info(str, th);
    }

    public void trace(String str, Throwable th) {
        b().trace(str, th);
    }

    public void warn(String str, Throwable th) {
        b().warn(str, th);
    }
}
