package org.slf4j;

import java.io.Closeable;
import java.util.Map;
import org.slf4j.helpers.NOPMDCAdapter;
import org.slf4j.helpers.Util;
import org.slf4j.spi.MDCAdapter;
import org.slf4j.spi.SLF4JServiceProvider;

public class MDC {

    /* renamed from: a  reason: collision with root package name */
    public static MDCAdapter f3452a;

    public static class MDCCloseable implements Closeable {

        /* renamed from: a  reason: collision with root package name */
        public final String f3453a;

        public void close() {
            MDC.c(this.f3453a);
        }
    }

    static {
        SLF4JServiceProvider m = LoggerFactory.m();
        if (m != null) {
            f3452a = m.c();
            return;
        }
        Util.c("Failed to find provider.");
        Util.c("Defaulting to no-operation MDCAdapter implementation.");
        f3452a = new NOPMDCAdapter();
    }

    public static void a() {
        MDCAdapter mDCAdapter = f3452a;
        if (mDCAdapter != null) {
            mDCAdapter.clear();
            return;
        }
        throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }

    public static Map b() {
        MDCAdapter mDCAdapter = f3452a;
        if (mDCAdapter != null) {
            return mDCAdapter.a();
        }
        throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }

    public static void c(String str) {
        if (str != null) {
            MDCAdapter mDCAdapter = f3452a;
            if (mDCAdapter != null) {
                mDCAdapter.remove(str);
                return;
            }
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        throw new IllegalArgumentException("key parameter cannot be null");
    }

    public static void d(Map map) {
        MDCAdapter mDCAdapter = f3452a;
        if (mDCAdapter != null) {
            mDCAdapter.b(map);
            return;
        }
        throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }
}
