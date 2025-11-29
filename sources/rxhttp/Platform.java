package rxhttp;

import android.util.Log;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import rxhttp.wrapper.utils.LogUtil;

public class Platform {

    /* renamed from: a  reason: collision with root package name */
    public static final Platform f3525a = a();

    public static final class Android extends Platform {
        public Android() {
            super();
        }

        public boolean c() {
            return true;
        }

        public void d(String str, String str2) {
            h(3, str, str2);
        }

        public void e(String str, String str2) {
            h(6, str, str2);
        }

        public void f(String str, Throwable th) {
            i(th, str);
        }

        public void g(String str, String str2) {
            h(4, str, str2);
        }

        public final void h(int i, String str, String str2) {
            int i2 = 0;
            while (str2.getBytes().length > 3072) {
                String str3 = new String(str2.getBytes(), 0, 3072);
                String substring = str3.substring(0, str3.length() - 1);
                Log.println(i, str, substring);
                if (LogUtil.i()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("<---------------------------------- Segment ");
                    i2++;
                    sb.append(i2);
                    sb.append(" ---------------------------------->");
                    Log.v(str, sb.toString());
                    str2 = str2.substring(substring.length());
                } else {
                    return;
                }
            }
            if (str2.length() > 0) {
                Log.println(i, str, str2);
            }
        }

        public final void i(Throwable th, String str) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            printWriter.flush();
            String stringWriter2 = stringWriter.toString();
            int length = stringWriter2.length();
            int i = 0;
            while (i < length) {
                int indexOf = stringWriter2.indexOf(10, i);
                if (indexOf == -1) {
                    indexOf = length;
                }
                h(6, str, stringWriter2.substring(i, indexOf));
                i = indexOf + 1;
            }
        }
    }

    public static Platform a() {
        try {
            Class.forName("android.os.Build");
            return new Android();
        } catch (ClassNotFoundException unused) {
            return new Platform();
        }
    }

    public static Platform b() {
        return f3525a;
    }

    public boolean c() {
        return false;
    }

    public void d(String str, String str2) {
        PrintStream printStream = System.out;
        printStream.println(str + ": " + str2);
    }

    public void e(String str, String str2) {
        PrintStream printStream = System.out;
        printStream.println(str + ": " + str2);
    }

    public void f(String str, Throwable th) {
        th.printStackTrace();
    }

    public void g(String str, String str2) {
        PrintStream printStream = System.out;
        printStream.println(str + ": " + str2);
    }

    public Platform() {
    }
}
