package org.eclipse.jetty.util.log;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Log {
    public static final String EXCEPTION = "EXCEPTION ";
    public static final String IGNORED = "IGNORED ";
    private static Logger LOG;
    public static boolean __ignored;
    private static boolean __initialized;
    public static String __logClass;
    private static final ConcurrentMap<String, Logger> __loggers = new ConcurrentHashMap();
    protected static Properties __props = new Properties();

    static {
        AccessController.doPrivileged(new PrivilegedAction<Object>() {
            /* JADX WARNING: Removed duplicated region for block: B:20:0x004e  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object run() {
                /*
                    r6 = this;
                    java.lang.String r6 = "jetty-logging.properties"
                    r0 = 1
                    java.lang.Class<org.eclipse.jetty.util.log.Log> r1 = org.eclipse.jetty.util.log.Log.class
                    java.net.URL r6 = org.eclipse.jetty.util.Loader.getResource(r1, r6, r0)
                    r0 = 0
                    if (r6 == 0) goto L_0x0040
                    java.io.InputStream r1 = r6.openStream()     // Catch:{ IOException -> 0x0020, all -> 0x001e }
                    java.util.Properties r2 = org.eclipse.jetty.util.log.Log.__props     // Catch:{ IOException -> 0x001c }
                    r2.load(r1)     // Catch:{ IOException -> 0x001c }
                L_0x0015:
                    org.eclipse.jetty.util.IO.close((java.io.InputStream) r1)
                    goto L_0x0040
                L_0x0019:
                    r6 = move-exception
                    r0 = r1
                    goto L_0x003c
                L_0x001c:
                    r2 = move-exception
                    goto L_0x0022
                L_0x001e:
                    r6 = move-exception
                    goto L_0x003c
                L_0x0020:
                    r2 = move-exception
                    r1 = r0
                L_0x0022:
                    java.io.PrintStream r3 = java.lang.System.err     // Catch:{ all -> 0x0019 }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0019 }
                    r4.<init>()     // Catch:{ all -> 0x0019 }
                    java.lang.String r5 = "Unable to load "
                    r4.append(r5)     // Catch:{ all -> 0x0019 }
                    r4.append(r6)     // Catch:{ all -> 0x0019 }
                    java.lang.String r6 = r4.toString()     // Catch:{ all -> 0x0019 }
                    r3.println(r6)     // Catch:{ all -> 0x0019 }
                    r2.printStackTrace(r3)     // Catch:{ all -> 0x0019 }
                    goto L_0x0015
                L_0x003c:
                    org.eclipse.jetty.util.IO.close((java.io.InputStream) r0)
                    throw r6
                L_0x0040:
                    java.util.Properties r6 = java.lang.System.getProperties()
                    java.util.Enumeration r6 = r6.propertyNames()
                L_0x0048:
                    boolean r1 = r6.hasMoreElements()
                    if (r1 == 0) goto L_0x0060
                    java.lang.Object r1 = r6.nextElement()
                    java.lang.String r1 = (java.lang.String) r1
                    java.lang.String r2 = java.lang.System.getProperty(r1)
                    if (r2 == 0) goto L_0x0048
                    java.util.Properties r3 = org.eclipse.jetty.util.log.Log.__props
                    r3.setProperty(r1, r2)
                    goto L_0x0048
                L_0x0060:
                    java.util.Properties r6 = org.eclipse.jetty.util.log.Log.__props
                    java.lang.String r1 = "org.eclipse.jetty.util.log.class"
                    java.lang.String r2 = "org.eclipse.jetty.util.log.Slf4jLog"
                    java.lang.String r6 = r6.getProperty(r1, r2)
                    org.eclipse.jetty.util.log.Log.__logClass = r6
                    java.util.Properties r6 = org.eclipse.jetty.util.log.Log.__props
                    java.lang.String r1 = "org.eclipse.jetty.util.log.IGNORED"
                    java.lang.String r2 = "false"
                    java.lang.String r6 = r6.getProperty(r1, r2)
                    boolean r6 = java.lang.Boolean.parseBoolean(r6)
                    org.eclipse.jetty.util.log.Log.__ignored = r6
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.log.Log.AnonymousClass1.run():java.lang.Object");
            }
        });
    }

    @Deprecated
    public static void debug(Throwable th) {
        if (isDebugEnabled()) {
            LOG.debug(EXCEPTION, th);
        }
    }

    @Deprecated
    public static Logger getLog() {
        initialized();
        return LOG;
    }

    public static Logger getLogger(Class<?> cls) {
        return getLogger(cls.getName());
    }

    public static Map<String, Logger> getLoggers() {
        return Collections.unmodifiableMap(__loggers);
    }

    public static ConcurrentMap<String, Logger> getMutableLoggers() {
        return __loggers;
    }

    public static Logger getRootLogger() {
        initialized();
        return LOG;
    }

    @Deprecated
    public static void ignore(Throwable th) {
        if (initialized()) {
            LOG.ignore(th);
        }
    }

    @Deprecated
    public static void info(String str) {
        if (initialized()) {
            LOG.info(str, new Object[0]);
        }
    }

    private static void initStandardLogging(Throwable th) {
        if (th != null && __ignored) {
            th.printStackTrace();
        }
        if (LOG == null) {
            StdErrLog stdErrLog = new StdErrLog();
            LOG = stdErrLog;
            stdErrLog.debug("Logging to {} via {}", stdErrLog, StdErrLog.class.getName());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0015, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r0 = org.eclipse.jetty.util.Loader.loadClass(org.eclipse.jetty.util.log.Log.class, __logClass);
        r2 = LOG;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0025, code lost:
        if (r2 == null) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002f, code lost:
        if (r2.getClass().equals(r0) != false) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0032, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0034, code lost:
        r2 = (org.eclipse.jetty.util.log.Logger) r0.newInstance();
        LOG = r2;
        r2.debug("Logging to {} via {}", r2, r0.getName());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004a, code lost:
        initStandardLogging(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean initialized() {
        /*
            org.eclipse.jetty.util.log.Logger r0 = LOG
            r1 = 1
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            java.lang.Class<org.eclipse.jetty.util.log.Log> r0 = org.eclipse.jetty.util.log.Log.class
            monitor-enter(r0)
            boolean r2 = __initialized     // Catch:{ all -> 0x0016 }
            r3 = 0
            if (r2 == 0) goto L_0x0018
            org.eclipse.jetty.util.log.Logger r2 = LOG     // Catch:{ all -> 0x0016 }
            if (r2 == 0) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            r1 = r3
        L_0x0014:
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            return r1
        L_0x0016:
            r1 = move-exception
            goto L_0x0054
        L_0x0018:
            __initialized = r1     // Catch:{ all -> 0x0016 }
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            java.lang.Class<org.eclipse.jetty.util.log.Log> r0 = org.eclipse.jetty.util.log.Log.class
            java.lang.String r2 = __logClass     // Catch:{ all -> 0x0032 }
            java.lang.Class r0 = org.eclipse.jetty.util.Loader.loadClass(r0, r2)     // Catch:{ all -> 0x0032 }
            org.eclipse.jetty.util.log.Logger r2 = LOG     // Catch:{ all -> 0x0032 }
            if (r2 == 0) goto L_0x0034
            java.lang.Class r2 = r2.getClass()     // Catch:{ all -> 0x0032 }
            boolean r2 = r2.equals(r0)     // Catch:{ all -> 0x0032 }
            if (r2 != 0) goto L_0x004d
            goto L_0x0034
        L_0x0032:
            r0 = move-exception
            goto L_0x004a
        L_0x0034:
            java.lang.Object r2 = r0.newInstance()     // Catch:{ all -> 0x0032 }
            org.eclipse.jetty.util.log.Logger r2 = (org.eclipse.jetty.util.log.Logger) r2     // Catch:{ all -> 0x0032 }
            LOG = r2     // Catch:{ all -> 0x0032 }
            java.lang.String r4 = "Logging to {} via {}"
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x0032 }
            java.lang.Object[] r0 = new java.lang.Object[]{r2, r0}     // Catch:{ all -> 0x0032 }
            r2.debug((java.lang.String) r4, (java.lang.Object[]) r0)     // Catch:{ all -> 0x0032 }
            goto L_0x004d
        L_0x004a:
            initStandardLogging(r0)
        L_0x004d:
            org.eclipse.jetty.util.log.Logger r0 = LOG
            if (r0 == 0) goto L_0x0052
            goto L_0x0053
        L_0x0052:
            r1 = r3
        L_0x0053:
            return r1
        L_0x0054:
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.log.Log.initialized():boolean");
    }

    @Deprecated
    public static boolean isDebugEnabled() {
        if (!initialized()) {
            return false;
        }
        return LOG.isDebugEnabled();
    }

    public static boolean isIgnored() {
        return __ignored;
    }

    public static void setLog(Logger logger) {
        LOG = logger;
    }

    public static void setLogToParent(String str) {
        ClassLoader classLoader = Log.class.getClassLoader();
        if (classLoader == null || classLoader.getParent() == null) {
            setLog(getLogger(str));
            return;
        }
        try {
            setLog(new LoggerLog(classLoader.getParent().loadClass("org.eclipse.jetty.util.log.Log").getMethod("getLogger", new Class[]{String.class}).invoke((Object) null, new Object[]{str})));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public static void warn(String str) {
        if (initialized()) {
            LOG.warn(str, new Object[0]);
        }
    }

    public static Logger getLogger(String str) {
        if (!initialized()) {
            return null;
        }
        if (str == null) {
            return LOG;
        }
        Logger logger = __loggers.get(str);
        return logger == null ? LOG.getLogger(str) : logger;
    }

    @Deprecated
    public static void debug(String str) {
        if (initialized()) {
            LOG.debug(str, new Object[0]);
        }
    }

    @Deprecated
    public static void info(String str, Object obj) {
        if (initialized()) {
            LOG.info(str, obj);
        }
    }

    @Deprecated
    public static void warn(String str, Object obj) {
        if (initialized()) {
            LOG.warn(str, obj);
        }
    }

    @Deprecated
    public static void debug(String str, Object obj) {
        if (initialized()) {
            LOG.debug(str, obj);
        }
    }

    @Deprecated
    public static void info(String str, Object obj, Object obj2) {
        if (initialized()) {
            LOG.info(str, obj, obj2);
        }
    }

    @Deprecated
    public static void warn(String str, Object obj, Object obj2) {
        if (initialized()) {
            LOG.warn(str, obj, obj2);
        }
    }

    @Deprecated
    public static void debug(String str, Object obj, Object obj2) {
        if (initialized()) {
            LOG.debug(str, obj, obj2);
        }
    }

    @Deprecated
    public static void warn(String str, Throwable th) {
        if (initialized()) {
            LOG.warn(str, th);
        }
    }

    @Deprecated
    public static void warn(Throwable th) {
        if (initialized()) {
            LOG.warn(EXCEPTION, th);
        }
    }
}
