package org.slf4j;

import com.honey.account.qc.a;
import java.io.IOException;
import java.net.URL;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.event.SubstituteLoggingEvent;
import org.slf4j.helpers.NOP_FallbackServiceProvider;
import org.slf4j.helpers.SubstituteLogger;
import org.slf4j.helpers.SubstituteServiceProvider;
import org.slf4j.helpers.Util;
import org.slf4j.spi.SLF4JServiceProvider;

public final class LoggerFactory {

    /* renamed from: a  reason: collision with root package name */
    public static volatile int f3451a;
    public static final SubstituteServiceProvider b = new SubstituteServiceProvider();
    public static final NOP_FallbackServiceProvider c = new NOP_FallbackServiceProvider();
    public static boolean d = Util.f("slf4j.detectLoggerNameMismatch");
    public static volatile SLF4JServiceProvider e;
    public static final String[] f = {"2.0"};

    public static final void b() {
        try {
            List h = h();
            x(h);
            if (h == null || h.isEmpty()) {
                f3451a = 4;
                Util.c("No SLF4J providers were found.");
                Util.c("Defaulting to no-operation (NOP) logger implementation");
                Util.c("See https://www.slf4j.org/codes.html#noProviders for further details.");
                w(g());
            } else {
                e = (SLF4JServiceProvider) h.get(0);
                e.initialize();
                f3451a = 3;
                v(h);
            }
            s();
        } catch (Exception e2) {
            f(e2);
            throw new IllegalStateException("Unexpected initialization failure", e2);
        }
    }

    public static void c(SubstituteLoggingEvent substituteLoggingEvent, int i) {
        if (substituteLoggingEvent.c().d()) {
            d(i);
        } else if (!substituteLoggingEvent.c().e()) {
            e();
        }
    }

    public static void d(int i) {
        Util.c("A number (" + i + ") of logging calls during the initialization phase have been intercepted and are");
        Util.c("now being replayed. These are subject to the filtering rules of the underlying logging system.");
        Util.c("See also https://www.slf4j.org/codes.html#replay");
    }

    public static void e() {
        Util.c("The following set of substitute loggers may have been accessed");
        Util.c("during the initialization phase. Logging calls during this");
        Util.c("phase were not honored. However, subsequent logging calls to these");
        Util.c("loggers will work as normally expected.");
        Util.c("See also https://www.slf4j.org/codes.html#substituteLogger");
    }

    public static void f(Throwable th) {
        f3451a = 2;
        Util.d("Failed to instantiate SLF4J LoggerFactory", th);
    }

    public static Set g() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = LoggerFactory.class.getClassLoader();
            Enumeration<URL> systemResources = classLoader == null ? ClassLoader.getSystemResources("org/slf4j/impl/StaticLoggerBinder.class") : classLoader.getResources("org/slf4j/impl/StaticLoggerBinder.class");
            while (systemResources.hasMoreElements()) {
                linkedHashSet.add(systemResources.nextElement());
            }
        } catch (IOException e2) {
            Util.d("Error getting resources from path", e2);
        }
        return linkedHashSet;
    }

    public static List h() {
        ServiceLoader n = n(LoggerFactory.class.getClassLoader());
        ArrayList arrayList = new ArrayList();
        Iterator it = n.iterator();
        while (it.hasNext()) {
            y(arrayList, it);
        }
        return arrayList;
    }

    public static void i() {
        SubstituteServiceProvider substituteServiceProvider = b;
        synchronized (substituteServiceProvider) {
            try {
                substituteServiceProvider.e().d();
                for (SubstituteLogger substituteLogger : substituteServiceProvider.e().c()) {
                    substituteLogger.h(l(substituteLogger.getName()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static ILoggerFactory j() {
        return m().a();
    }

    public static Logger k(Class cls) {
        Class a2;
        Logger l = l(cls.getName());
        if (d && (a2 = Util.a()) != null && q(cls, a2)) {
            Util.c(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", new Object[]{l.getName(), a2.getName()}));
            Util.c("See https://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
        }
        return l;
    }

    public static Logger l(String str) {
        return j().getLogger(str);
    }

    public static SLF4JServiceProvider m() {
        if (f3451a == 0) {
            synchronized (LoggerFactory.class) {
                try {
                    if (f3451a == 0) {
                        f3451a = 1;
                        r();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        int i = f3451a;
        if (i == 1) {
            return b;
        }
        if (i == 2) {
            throw new IllegalStateException("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also https://www.slf4j.org/codes.html#unsuccessfulInit");
        } else if (i == 3) {
            return e;
        } else {
            if (i == 4) {
                return c;
            }
            throw new IllegalStateException("Unreachable code");
        }
    }

    public static ServiceLoader n(ClassLoader classLoader) {
        return System.getSecurityManager() == null ? ServiceLoader.load(SLF4JServiceProvider.class, classLoader) : (ServiceLoader) AccessController.doPrivileged(new a(classLoader));
    }

    public static boolean o(List list) {
        return list.size() > 1;
    }

    public static boolean q(Class cls, Class cls2) {
        return !cls2.isAssignableFrom(cls);
    }

    public static final void r() {
        b();
        if (f3451a == 3) {
            z();
        }
    }

    public static void s() {
        i();
        t();
        b.e().a();
    }

    public static void t() {
        LinkedBlockingQueue b2 = b.e().b();
        int size = b2.size();
        ArrayList<SubstituteLoggingEvent> arrayList = new ArrayList<>(128);
        int i = 0;
        while (b2.drainTo(arrayList, 128) != 0) {
            for (SubstituteLoggingEvent substituteLoggingEvent : arrayList) {
                u(substituteLoggingEvent);
                int i2 = i + 1;
                if (i == 0) {
                    c(substituteLoggingEvent, size);
                }
                i = i2;
            }
            arrayList.clear();
        }
    }

    public static void u(SubstituteLoggingEvent substituteLoggingEvent) {
        if (substituteLoggingEvent != null) {
            SubstituteLogger c2 = substituteLoggingEvent.c();
            String name = c2.getName();
            if (c2.f()) {
                throw new IllegalStateException("Delegate logger cannot be null at this state.");
            } else if (!c2.e()) {
                if (!c2.d()) {
                    Util.c(name);
                } else if (c2.isEnabledForLevel(substituteLoggingEvent.b())) {
                    c2.g(substituteLoggingEvent);
                }
            }
        }
    }

    public static void v(List list) {
        if (!list.isEmpty() && o(list)) {
            Util.c("Actual provider is of type [" + list.get(0) + "]");
        }
    }

    public static void w(Set set) {
        if (!set.isEmpty()) {
            Util.c("Class path contains SLF4J bindings targeting slf4j-api versions 1.7.x or earlier.");
            Iterator it = set.iterator();
            while (it.hasNext()) {
                Util.c("Ignoring binding found at [" + ((URL) it.next()) + "]");
            }
            Util.c("See https://www.slf4j.org/codes.html#ignoredBindings for an explanation.");
        }
    }

    public static void x(List list) {
        if (o(list)) {
            Util.c("Class path contains multiple SLF4J providers.");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Util.c("Found provider [" + ((SLF4JServiceProvider) it.next()) + "]");
            }
            Util.c("See https://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    public static void y(List list, Iterator it) {
        try {
            list.add((SLF4JServiceProvider) it.next());
        } catch (ServiceConfigurationError e2) {
            Util.c("A SLF4J service provider failed to instantiate:\n" + e2.getMessage());
        }
    }

    public static final void z() {
        try {
            String d2 = e.d();
            boolean z = false;
            for (String startsWith : f) {
                if (d2.startsWith(startsWith)) {
                    z = true;
                }
            }
            if (!z) {
                Util.c("The requested version " + d2 + " by your slf4j binding is not compatible with " + Arrays.asList(f).toString());
                Util.c("See https://www.slf4j.org/codes.html#version_mismatch for further details.");
            }
        } catch (NoSuchFieldError unused) {
        } catch (Throwable th) {
            Util.d("Unexpected problem occured during version sanity check", th);
        }
    }
}
