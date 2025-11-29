package org.greenrobot.eventbus;

import java.io.PrintStream;
import java.util.logging.Level;
import org.greenrobot.eventbus.android.AndroidComponents;

public interface Logger {

    public static class Default {
        public static Logger a() {
            return AndroidComponents.a() ? AndroidComponents.b().f3381a : new SystemOutLogger();
        }
    }

    public static class JavaLogger implements Logger {

        /* renamed from: a  reason: collision with root package name */
        public final java.util.logging.Logger f3372a;

        public void a(Level level, String str) {
            this.f3372a.log(level, str);
        }

        public void b(Level level, String str, Throwable th) {
            this.f3372a.log(level, str, th);
        }
    }

    public static class SystemOutLogger implements Logger {
        public void a(Level level, String str) {
            PrintStream printStream = System.out;
            printStream.println("[" + level + "] " + str);
        }

        public void b(Level level, String str, Throwable th) {
            PrintStream printStream = System.out;
            printStream.println("[" + level + "] " + str);
            th.printStackTrace(printStream);
        }
    }

    void a(Level level, String str);

    void b(Level level, String str, Throwable th);
}
