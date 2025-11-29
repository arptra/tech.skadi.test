package io.netty.util.internal.logging;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

class JdkLogger extends AbstractInternalLogger {
    static final String SELF = "io.netty.util.internal.logging.JdkLogger";
    static final String SUPER = AbstractInternalLogger.class.getName();
    private static final long serialVersionUID = -1767272577989225979L;
    final transient Logger logger;

    public JdkLogger(Logger logger2) {
        super(logger2.getName());
        this.logger = logger2;
    }

    private static void fillCallerData(String str, LogRecord logRecord) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int i = 0;
        while (true) {
            if (i >= stackTrace.length) {
                i = -1;
                break;
            }
            String className = stackTrace[i].getClassName();
            if (className.equals(str) || className.equals(SUPER)) {
                break;
            }
            i++;
        }
        while (true) {
            i++;
            if (i >= stackTrace.length) {
                i = -1;
                break;
            }
            String className2 = stackTrace[i].getClassName();
            if (!className2.equals(str) && !className2.equals(SUPER)) {
                break;
            }
        }
        if (i != -1) {
            StackTraceElement stackTraceElement = stackTrace[i];
            logRecord.setSourceClassName(stackTraceElement.getClassName());
            logRecord.setSourceMethodName(stackTraceElement.getMethodName());
        }
    }

    private void log(String str, Level level, String str2, Throwable th) {
        LogRecord logRecord = new LogRecord(level, str2);
        logRecord.setLoggerName(name());
        logRecord.setThrown(th);
        fillCallerData(str, logRecord);
        this.logger.log(logRecord);
    }

    public void debug(String str) {
        Logger logger2 = this.logger;
        Level level = Level.FINE;
        if (logger2.isLoggable(level)) {
            log(SELF, level, str, (Throwable) null);
        }
    }

    public void error(String str) {
        Logger logger2 = this.logger;
        Level level = Level.SEVERE;
        if (logger2.isLoggable(level)) {
            log(SELF, level, str, (Throwable) null);
        }
    }

    public void info(String str) {
        Logger logger2 = this.logger;
        Level level = Level.INFO;
        if (logger2.isLoggable(level)) {
            log(SELF, level, str, (Throwable) null);
        }
    }

    public boolean isDebugEnabled() {
        return this.logger.isLoggable(Level.FINE);
    }

    public boolean isErrorEnabled() {
        return this.logger.isLoggable(Level.SEVERE);
    }

    public boolean isInfoEnabled() {
        return this.logger.isLoggable(Level.INFO);
    }

    public boolean isTraceEnabled() {
        return this.logger.isLoggable(Level.FINEST);
    }

    public boolean isWarnEnabled() {
        return this.logger.isLoggable(Level.WARNING);
    }

    public void trace(String str) {
        Logger logger2 = this.logger;
        Level level = Level.FINEST;
        if (logger2.isLoggable(level)) {
            log(SELF, level, str, (Throwable) null);
        }
    }

    public void warn(String str) {
        Logger logger2 = this.logger;
        Level level = Level.WARNING;
        if (logger2.isLoggable(level)) {
            log(SELF, level, str, (Throwable) null);
        }
    }

    public void debug(String str, Object obj) {
        Logger logger2 = this.logger;
        Level level = Level.FINE;
        if (logger2.isLoggable(level)) {
            FormattingTuple format = MessageFormatter.format(str, obj);
            log(SELF, level, format.getMessage(), format.getThrowable());
        }
    }

    public void error(String str, Object obj) {
        Logger logger2 = this.logger;
        Level level = Level.SEVERE;
        if (logger2.isLoggable(level)) {
            FormattingTuple format = MessageFormatter.format(str, obj);
            log(SELF, level, format.getMessage(), format.getThrowable());
        }
    }

    public void info(String str, Object obj) {
        Logger logger2 = this.logger;
        Level level = Level.INFO;
        if (logger2.isLoggable(level)) {
            FormattingTuple format = MessageFormatter.format(str, obj);
            log(SELF, level, format.getMessage(), format.getThrowable());
        }
    }

    public void trace(String str, Object obj) {
        Logger logger2 = this.logger;
        Level level = Level.FINEST;
        if (logger2.isLoggable(level)) {
            FormattingTuple format = MessageFormatter.format(str, obj);
            log(SELF, level, format.getMessage(), format.getThrowable());
        }
    }

    public void warn(String str, Object obj) {
        Logger logger2 = this.logger;
        Level level = Level.WARNING;
        if (logger2.isLoggable(level)) {
            FormattingTuple format = MessageFormatter.format(str, obj);
            log(SELF, level, format.getMessage(), format.getThrowable());
        }
    }

    public void debug(String str, Object obj, Object obj2) {
        Logger logger2 = this.logger;
        Level level = Level.FINE;
        if (logger2.isLoggable(level)) {
            FormattingTuple format = MessageFormatter.format(str, obj, obj2);
            log(SELF, level, format.getMessage(), format.getThrowable());
        }
    }

    public void error(String str, Object obj, Object obj2) {
        Logger logger2 = this.logger;
        Level level = Level.SEVERE;
        if (logger2.isLoggable(level)) {
            FormattingTuple format = MessageFormatter.format(str, obj, obj2);
            log(SELF, level, format.getMessage(), format.getThrowable());
        }
    }

    public void info(String str, Object obj, Object obj2) {
        Logger logger2 = this.logger;
        Level level = Level.INFO;
        if (logger2.isLoggable(level)) {
            FormattingTuple format = MessageFormatter.format(str, obj, obj2);
            log(SELF, level, format.getMessage(), format.getThrowable());
        }
    }

    public void trace(String str, Object obj, Object obj2) {
        Logger logger2 = this.logger;
        Level level = Level.FINEST;
        if (logger2.isLoggable(level)) {
            FormattingTuple format = MessageFormatter.format(str, obj, obj2);
            log(SELF, level, format.getMessage(), format.getThrowable());
        }
    }

    public void warn(String str, Object obj, Object obj2) {
        Logger logger2 = this.logger;
        Level level = Level.WARNING;
        if (logger2.isLoggable(level)) {
            FormattingTuple format = MessageFormatter.format(str, obj, obj2);
            log(SELF, level, format.getMessage(), format.getThrowable());
        }
    }

    public void debug(String str, Object... objArr) {
        Logger logger2 = this.logger;
        Level level = Level.FINE;
        if (logger2.isLoggable(level)) {
            FormattingTuple arrayFormat = MessageFormatter.arrayFormat(str, objArr);
            log(SELF, level, arrayFormat.getMessage(), arrayFormat.getThrowable());
        }
    }

    public void error(String str, Object... objArr) {
        Logger logger2 = this.logger;
        Level level = Level.SEVERE;
        if (logger2.isLoggable(level)) {
            FormattingTuple arrayFormat = MessageFormatter.arrayFormat(str, objArr);
            log(SELF, level, arrayFormat.getMessage(), arrayFormat.getThrowable());
        }
    }

    public void info(String str, Object... objArr) {
        Logger logger2 = this.logger;
        Level level = Level.INFO;
        if (logger2.isLoggable(level)) {
            FormattingTuple arrayFormat = MessageFormatter.arrayFormat(str, objArr);
            log(SELF, level, arrayFormat.getMessage(), arrayFormat.getThrowable());
        }
    }

    public void trace(String str, Object... objArr) {
        Logger logger2 = this.logger;
        Level level = Level.FINEST;
        if (logger2.isLoggable(level)) {
            FormattingTuple arrayFormat = MessageFormatter.arrayFormat(str, objArr);
            log(SELF, level, arrayFormat.getMessage(), arrayFormat.getThrowable());
        }
    }

    public void warn(String str, Object... objArr) {
        Logger logger2 = this.logger;
        Level level = Level.WARNING;
        if (logger2.isLoggable(level)) {
            FormattingTuple arrayFormat = MessageFormatter.arrayFormat(str, objArr);
            log(SELF, level, arrayFormat.getMessage(), arrayFormat.getThrowable());
        }
    }

    public void debug(String str, Throwable th) {
        Logger logger2 = this.logger;
        Level level = Level.FINE;
        if (logger2.isLoggable(level)) {
            log(SELF, level, str, th);
        }
    }

    public void error(String str, Throwable th) {
        Logger logger2 = this.logger;
        Level level = Level.SEVERE;
        if (logger2.isLoggable(level)) {
            log(SELF, level, str, th);
        }
    }

    public void info(String str, Throwable th) {
        Logger logger2 = this.logger;
        Level level = Level.INFO;
        if (logger2.isLoggable(level)) {
            log(SELF, level, str, th);
        }
    }

    public void trace(String str, Throwable th) {
        Logger logger2 = this.logger;
        Level level = Level.FINEST;
        if (logger2.isLoggable(level)) {
            log(SELF, level, str, th);
        }
    }

    public void warn(String str, Throwable th) {
        Logger logger2 = this.logger;
        Level level = Level.WARNING;
        if (logger2.isLoggable(level)) {
            log(SELF, level, str, th);
        }
    }
}
