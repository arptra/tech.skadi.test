package io.ktor.util.pipeline;

import io.ktor.utils.io.ExceptionUtilsJvmKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0003\n\u0002\b\u0004\u001a\u001d\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"", "cause", "a", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)Ljava/lang/Throwable;", "ktor-utils"}, k = 2, mv = {1, 8, 0})
public final class StackTraceRecoverJvmKt {
    public static final Throwable a(Throwable th, Throwable th2) {
        Throwable e;
        Intrinsics.checkNotNullParameter(th, "<this>");
        if (th2 == null || Intrinsics.areEqual((Object) th.getCause(), (Object) th2) || (e = ExceptionUtilsJvmKt.e(th, th2)) == null) {
            return th;
        }
        e.setStackTrace(th.getStackTrace());
        return e;
    }
}
