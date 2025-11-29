package io.ktor.utils.io.core;

import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001b\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0003\u0010\u0004\"\u001d\u0010\t\u001a\u0004\u0018\u00010\u00058BX\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b*\n\u0010\u000b\"\u00020\n2\u00020\n¨\u0006\f"}, d2 = {"", "other", "", "a", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)V", "Ljava/lang/reflect/Method;", "Lkotlin/Lazy;", "b", "()Ljava/lang/reflect/Method;", "AddSuppressedMethod", "Ljava/io/Closeable;", "Closeable", "ktor-io"}, k = 2, mv = {1, 8, 0})
public final class CloseableJVMKt {

    /* renamed from: a  reason: collision with root package name */
    public static final Lazy f9089a = LazyKt.lazy(CloseableJVMKt$AddSuppressedMethod$2.INSTANCE);

    public static final void a(Throwable th, Throwable th2) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        Intrinsics.checkNotNullParameter(th2, "other");
        Method b = b();
        if (b != null) {
            b.invoke(th, new Object[]{th2});
        }
    }

    public static final Method b() {
        return (Method) f9089a.getValue();
    }
}
