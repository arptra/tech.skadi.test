package io.ktor.http.content;

import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a1\u0010\u0005\u001a\u00020\u00022\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\t\u001a1\u0010\n\u001a\u00020\u00022\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0000H@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0006\"\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u000b8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "block", "c", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "b", "()Z", "d", "Ljava/lang/reflect/Method;", "a", "Lkotlin/Lazy;", "()Ljava/lang/reflect/Method;", "isParkingAllowedFunction", "ktor-http"}, k = 2, mv = {1, 8, 0})
public final class BlockingBridgeKt {

    /* renamed from: a  reason: collision with root package name */
    public static final Lazy f8986a = LazyKt.lazy(BlockingBridgeKt$isParkingAllowedFunction$2.INSTANCE);

    public static final Method a() {
        return (Method) f8986a.getValue();
    }

    public static final boolean b() {
        boolean z;
        Method a2 = a();
        if (a2 == null) {
            return false;
        }
        try {
            z = Intrinsics.areEqual(a2.invoke((Object) null, (Object[]) null), (Object) Boolean.TRUE);
        } catch (Throwable unused) {
            z = false;
        }
        return z;
    }

    public static final Object c(Function1 function1, Continuation continuation) {
        if (b()) {
            Object invoke = function1.invoke(continuation);
            return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
        }
        Object d = d(function1, continuation);
        return d == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? d : Unit.INSTANCE;
    }

    public static final Object d(Function1 function1, Continuation continuation) {
        Object g = BuildersKt.g(Dispatchers.b(), new BlockingBridgeKt$withBlockingAndRedispatch$2(function1, (Continuation<? super BlockingBridgeKt$withBlockingAndRedispatch$2>) null), continuation);
        return g == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? g : Unit.INSTANCE;
    }
}
