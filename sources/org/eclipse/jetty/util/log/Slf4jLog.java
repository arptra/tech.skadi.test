package org.eclipse.jetty.util.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LocationAwareLogger;

public class Slf4jLog extends AbstractLogger {
    private final Logger _logger;

    public Slf4jLog() throws Exception {
        this("org.eclipse.jetty.util.log");
    }

    public void debug(String str, Object... objArr) {
        this._logger.debug(str, objArr);
    }

    public String getName() {
        return this._logger.getName();
    }

    public void ignore(Throwable th) {
        if (Log.isIgnored()) {
            warn(Log.IGNORED, th);
        }
    }

    public void info(String str, Object... objArr) {
        this._logger.info(str, objArr);
    }

    public boolean isDebugEnabled() {
        return this._logger.isDebugEnabled();
    }

    public Logger newLogger(String str) {
        return new Slf4jLog(str);
    }

    public void setDebugEnabled(boolean z) {
        warn("setDebugEnabled not implemented", null, null);
    }

    public String toString() {
        return this._logger.toString();
    }

    public void warn(String str, Object... objArr) {
        this._logger.warn(str, objArr);
    }

    public Slf4jLog(String str) {
        Logger l = LoggerFactory.l(str);
        if (l instanceof LocationAwareLogger) {
            this._logger = new JettyAwareLogger((LocationAwareLogger) l);
        } else {
            this._logger = l;
        }
    }

    public void debug(Throwable th) {
        debug("", th);
    }

    public void info(Throwable th) {
        info("", th);
    }

    public void warn(Throwable th) {
        warn("", th);
    }

    public void debug(String str, Throwable th) {
        this._logger.debug(str, th);
    }

    public void info(String str, Throwable th) {
        this._logger.info(str, th);
    }

    public void warn(String str, Throwable th) {
        this._logger.warn(str, th);
    }
}
