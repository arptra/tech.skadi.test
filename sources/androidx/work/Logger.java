package androidx.work;

import android.util.Log;
import androidx.annotation.RestrictTo;

@RestrictTo
public abstract class Logger {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f2062a = new Object();
    public static volatile Logger b = null;
    public static final int c = 20;

    public static class LogcatLogger extends Logger {
        public final int d;

        public LogcatLogger(int i) {
            super(i);
            this.d = i;
        }

        public void a(String str, String str2) {
            if (this.d <= 3) {
                Log.d(str, str2);
            }
        }

        public void b(String str, String str2, Throwable th) {
            if (this.d <= 3) {
                Log.d(str, str2, th);
            }
        }

        public void c(String str, String str2) {
            if (this.d <= 6) {
                Log.e(str, str2);
            }
        }

        public void d(String str, String str2, Throwable th) {
            if (this.d <= 6) {
                Log.e(str, str2, th);
            }
        }

        public void f(String str, String str2) {
            if (this.d <= 4) {
                Log.i(str, str2);
            }
        }

        public void g(String str, String str2, Throwable th) {
            if (this.d <= 4) {
                Log.i(str, str2, th);
            }
        }

        public void j(String str, String str2) {
            if (this.d <= 2) {
                Log.v(str, str2);
            }
        }

        public void k(String str, String str2) {
            if (this.d <= 5) {
                Log.w(str, str2);
            }
        }

        public void l(String str, String str2, Throwable th) {
            if (this.d <= 5) {
                Log.w(str, str2, th);
            }
        }
    }

    public Logger(int i) {
    }

    public static Logger e() {
        Logger logger;
        synchronized (f2062a) {
            try {
                if (b == null) {
                    b = new LogcatLogger(3);
                }
                logger = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return logger;
    }

    public static void h(Logger logger) {
        synchronized (f2062a) {
            b = logger;
        }
    }

    public static String i(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(23);
        sb.append("WM-");
        int i = c;
        if (length >= i) {
            sb.append(str.substring(0, i));
        } else {
            sb.append(str);
        }
        return sb.toString();
    }

    public abstract void a(String str, String str2);

    public abstract void b(String str, String str2, Throwable th);

    public abstract void c(String str, String str2);

    public abstract void d(String str, String str2, Throwable th);

    public abstract void f(String str, String str2);

    public abstract void g(String str, String str2, Throwable th);

    public abstract void j(String str, String str2);

    public abstract void k(String str, String str2);

    public abstract void l(String str, String str2, Throwable th);
}
