package io.netty.util.internal.logging;

import org.slf4j.Logger;

final class Slf4JLogger extends AbstractInternalLogger {
    private static final long serialVersionUID = 108038972685130825L;
    private final transient Logger logger;

    public Slf4JLogger(Logger logger2) {
        super(logger2.getName());
        this.logger = logger2;
    }

    public void debug(String str) {
        this.logger.debug(str);
    }

    public void error(String str) {
        this.logger.error(str);
    }

    public void info(String str) {
        this.logger.info(str);
    }

    public boolean isDebugEnabled() {
        return this.logger.isDebugEnabled();
    }

    public boolean isErrorEnabled() {
        return this.logger.isErrorEnabled();
    }

    public boolean isInfoEnabled() {
        return this.logger.isInfoEnabled();
    }

    public boolean isTraceEnabled() {
        return this.logger.isTraceEnabled();
    }

    public boolean isWarnEnabled() {
        return this.logger.isWarnEnabled();
    }

    public void trace(String str) {
        this.logger.trace(str);
    }

    public void warn(String str) {
        this.logger.warn(str);
    }

    public void debug(String str, Object obj) {
        this.logger.debug(str, obj);
    }

    public void error(String str, Object obj) {
        this.logger.error(str, obj);
    }

    public void info(String str, Object obj) {
        this.logger.info(str, obj);
    }

    public void trace(String str, Object obj) {
        this.logger.trace(str, obj);
    }

    public void warn(String str, Object obj) {
        this.logger.warn(str, obj);
    }

    public void debug(String str, Object obj, Object obj2) {
        this.logger.debug(str, obj, obj2);
    }

    public void error(String str, Object obj, Object obj2) {
        this.logger.error(str, obj, obj2);
    }

    public void info(String str, Object obj, Object obj2) {
        this.logger.info(str, obj, obj2);
    }

    public void trace(String str, Object obj, Object obj2) {
        this.logger.trace(str, obj, obj2);
    }

    public void warn(String str, Object... objArr) {
        this.logger.warn(str, objArr);
    }

    public void debug(String str, Object... objArr) {
        this.logger.debug(str, objArr);
    }

    public void error(String str, Object... objArr) {
        this.logger.error(str, objArr);
    }

    public void info(String str, Object... objArr) {
        this.logger.info(str, objArr);
    }

    public void trace(String str, Object... objArr) {
        this.logger.trace(str, objArr);
    }

    public void warn(String str, Object obj, Object obj2) {
        this.logger.warn(str, obj, obj2);
    }

    public void debug(String str, Throwable th) {
        this.logger.debug(str, th);
    }

    public void error(String str, Throwable th) {
        this.logger.error(str, th);
    }

    public void info(String str, Throwable th) {
        this.logger.info(str, th);
    }

    public void trace(String str, Throwable th) {
        this.logger.trace(str, th);
    }

    public void warn(String str, Throwable th) {
        this.logger.warn(str, th);
    }
}
