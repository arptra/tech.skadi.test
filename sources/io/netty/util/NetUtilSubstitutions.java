package io.netty.util;

import com.oracle.svm.core.annotate.Alias;
import com.oracle.svm.core.annotate.InjectAccessors;
import com.oracle.svm.core.annotate.TargetClass;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;

@TargetClass(NetUtil.class)
final class NetUtilSubstitutions {
    @InjectAccessors(NetUtilLocalhostAccessor.class)
    @Alias
    public static InetAddress LOCALHOST;
    @InjectAccessors(NetUtilLocalhost4Accessor.class)
    @Alias
    public static Inet4Address LOCALHOST4;
    @InjectAccessors(NetUtilLocalhost6Accessor.class)
    @Alias
    public static Inet6Address LOCALHOST6;

    public static final class NetUtilLocalhost4Accessor {
        private NetUtilLocalhost4Accessor() {
        }

        public static Inet4Address get() {
            return NetUtilLocalhost4LazyHolder.LOCALHOST4;
        }

        public static void set(Inet4Address inet4Address) {
        }
    }

    public static final class NetUtilLocalhost4LazyHolder {
        /* access modifiers changed from: private */
        public static final Inet4Address LOCALHOST4 = NetUtilInitializations.createLocalhost4();

        private NetUtilLocalhost4LazyHolder() {
        }
    }

    public static final class NetUtilLocalhost6Accessor {
        private NetUtilLocalhost6Accessor() {
        }

        public static Inet6Address get() {
            return NetUtilLocalhost6LazyHolder.LOCALHOST6;
        }

        public static void set(Inet6Address inet6Address) {
        }
    }

    public static final class NetUtilLocalhost6LazyHolder {
        /* access modifiers changed from: private */
        public static final Inet6Address LOCALHOST6 = NetUtilInitializations.createLocalhost6();

        private NetUtilLocalhost6LazyHolder() {
        }
    }

    public static final class NetUtilLocalhostAccessor {
        private NetUtilLocalhostAccessor() {
        }

        public static InetAddress get() {
            return NetUtilLocalhostLazyHolder.LOCALHOST;
        }

        public static void set(InetAddress inetAddress) {
        }
    }

    public static final class NetUtilLocalhostLazyHolder {
        /* access modifiers changed from: private */
        public static final InetAddress LOCALHOST = NetUtilInitializations.determineLoopback(NetUtilLocalhost4LazyHolder.LOCALHOST4, NetUtilLocalhost6LazyHolder.LOCALHOST6).address();

        private NetUtilLocalhostLazyHolder() {
        }
    }

    private NetUtilSubstitutions() {
    }
}
