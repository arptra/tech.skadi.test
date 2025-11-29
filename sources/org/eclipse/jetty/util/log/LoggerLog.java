package org.eclipse.jetty.util.log;

import java.lang.reflect.Method;

public class LoggerLog extends AbstractLogger {
    private volatile boolean _debug;
    private final Method _debugMAA;
    private final Method _debugMT;
    private final Method _getLoggerN;
    private final Method _getName;
    private final Method _infoMAA;
    private final Method _infoMT;
    private final Object _logger;
    private final Method _setDebugEnabledE;
    private final Method _warnMAA;
    private final Method _warnMT;

    public LoggerLog(Object obj) {
        Class<Object[]> cls = Object[].class;
        Class<Throwable> cls2 = Throwable.class;
        Class<String> cls3 = String.class;
        try {
            this._logger = obj;
            Class<?> cls4 = obj.getClass();
            this._debugMT = cls4.getMethod("debug", new Class[]{cls3, cls2});
            this._debugMAA = cls4.getMethod("debug", new Class[]{cls3, cls});
            this._infoMT = cls4.getMethod("info", new Class[]{cls3, cls2});
            this._infoMAA = cls4.getMethod("info", new Class[]{cls3, cls});
            this._warnMT = cls4.getMethod("warn", new Class[]{cls3, cls2});
            this._warnMAA = cls4.getMethod("warn", new Class[]{cls3, cls});
            Method method = cls4.getMethod("isDebugEnabled", (Class[]) null);
            this._setDebugEnabledE = cls4.getMethod("setDebugEnabled", new Class[]{Boolean.TYPE});
            this._getLoggerN = cls4.getMethod("getLogger", new Class[]{cls3});
            this._getName = cls4.getMethod("getName", (Class[]) null);
            this._debug = ((Boolean) method.invoke(obj, (Object[]) null)).booleanValue();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public void debug(String str, Object... objArr) {
        if (this._debug) {
            try {
                this._debugMAA.invoke(this._logger, objArr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String getName() {
        try {
            return (String) this._getName.invoke(this._logger, (Object[]) null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void ignore(Throwable th) {
        if (Log.isIgnored()) {
            warn(Log.IGNORED, th);
        }
    }

    public void info(String str, Object... objArr) {
        try {
            this._infoMAA.invoke(this._logger, objArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isDebugEnabled() {
        return this._debug;
    }

    public Logger newLogger(String str) {
        try {
            return new LoggerLog(this._getLoggerN.invoke(this._logger, new Object[]{str}));
        } catch (Exception e) {
            e.printStackTrace();
            return this;
        }
    }

    public void setDebugEnabled(boolean z) {
        try {
            this._setDebugEnabledE.invoke(this._logger, new Object[]{Boolean.valueOf(z)});
            this._debug = z;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void warn(String str, Object... objArr) {
        try {
            this._warnMAA.invoke(this._logger, objArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void info(Throwable th) {
        info("", th);
    }

    public void warn(Throwable th) {
        warn("", th);
    }

    public void debug(Throwable th) {
        debug("", th);
    }

    public void info(String str, Throwable th) {
        try {
            this._infoMT.invoke(this._logger, new Object[]{str, th});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void warn(String str, Throwable th) {
        try {
            this._warnMT.invoke(this._logger, new Object[]{str, th});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void debug(String str, Throwable th) {
        if (this._debug) {
            try {
                this._debugMT.invoke(this._logger, new Object[]{str, th});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
