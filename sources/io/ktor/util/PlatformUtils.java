package io.ktor.util;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u0012\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0015\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\bR\u0017\u0010\u0018\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0017\u0010\b¨\u0006\u0019"}, d2 = {"Lio/ktor/util/PlatformUtils;", "", "<init>", "()V", "", "b", "Z", "a", "()Z", "IS_BROWSER", "c", "getIS_NODE", "IS_NODE", "d", "getIS_JVM", "IS_JVM", "e", "getIS_NATIVE", "IS_NATIVE", "f", "getIS_DEVELOPMENT_MODE", "IS_DEVELOPMENT_MODE", "g", "getIS_NEW_MM_ENABLED", "IS_NEW_MM_ENABLED", "ktor-utils"}, k = 1, mv = {1, 8, 0})
public final class PlatformUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final PlatformUtils f9037a;
    public static final boolean b;
    public static final boolean c;
    public static final boolean d;
    public static final boolean e;
    public static final boolean f;
    public static final boolean g;

    static {
        PlatformUtils platformUtils = new PlatformUtils();
        f9037a = platformUtils;
        boolean z = false;
        b = PlatformUtilsJvmKt.a(platformUtils) == Platform.Browser;
        c = PlatformUtilsJvmKt.a(platformUtils) == Platform.Node;
        d = PlatformUtilsJvmKt.a(platformUtils) == Platform.Jvm;
        if (PlatformUtilsJvmKt.a(platformUtils) == Platform.Native) {
            z = true;
        }
        e = z;
        f = PlatformUtilsJvmKt.b(platformUtils);
        g = PlatformUtilsJvmKt.c(platformUtils);
    }

    public final boolean a() {
        return b;
    }
}
