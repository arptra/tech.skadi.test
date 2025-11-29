package com.xjsd.ai.assistant.phone.session.utils;

import androidx.lifecycle.Lifecycle;
import com.honey.account.x.c;
import com.xjsd.ai.assistant.phone.session.Session;
import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aE\u0010\n\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012'\u0010\t\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003¢\u0006\u0002\b\bH@¢\u0006\u0004\b\n\u0010\u000b\u001aE\u0010\f\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012'\u0010\t\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003¢\u0006\u0002\b\bH@¢\u0006\u0004\b\f\u0010\u000b\"\u0015\u0010\u0010\u001a\u00020\u0004*\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/Lifecycle$State;", "state", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "block", "b", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "c", "Lcom/xjsd/ai/assistant/phone/session/Session;", "a", "(Lcom/xjsd/ai/assistant/phone/session/Session;)Lkotlinx/coroutines/CoroutineScope;", "sessionScope", "ar-assistant_intlRelease"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nSeesionExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SeesionExtensions.kt\ncom/xjsd/ai/assistant/phone/session/utils/SeesionExtensionsKt\n+ 2 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n*L\n1#1,135:1\n48#2,4:136\n*S KotlinDebug\n*F\n+ 1 SeesionExtensions.kt\ncom/xjsd/ai/assistant/phone/session/utils/SeesionExtensionsKt\n*L\n122#1:136,4\n*E\n"})
public final class SeesionExtensionsKt {
    public static final CoroutineScope a(Session session) {
        CoroutineScope a2;
        Intrinsics.checkNotNullParameter(session, "<this>");
        do {
            Object obj = session.c().get();
            CoroutineScope coroutineScope = obj instanceof CoroutineScope ? (CoroutineScope) obj : null;
            if (coroutineScope != null) {
                return coroutineScope;
            }
            a2 = CoroutineScopeKt.a(SupervisorKt.b((Job) null, 1, (Object) null).plus(new CoroutineName(RtspHeaders.Names.SESSION)).plus(Dispatchers.b()).plus(new SeesionExtensionsKt$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.a0)));
        } while (!c.a(session.c(), (Object) null, a2));
        return a2;
    }

    public static final Object b(Lifecycle lifecycle, Lifecycle.State state, Function2 function2, Continuation continuation) {
        if (state == Lifecycle.State.INITIALIZED) {
            throw new IllegalArgumentException("onLifecycleRepeat cannot start work with the INITIALIZED lifecycle state.".toString());
        } else if (lifecycle.b() == Lifecycle.State.DESTROYED) {
            return Unit.INSTANCE;
        } else {
            Object f = CoroutineScopeKt.f(new SeesionExtensionsKt$onLifecycleRepeat$3(lifecycle, state, function2, (Continuation<? super SeesionExtensionsKt$onLifecycleRepeat$3>) null), continuation);
            return f == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? f : Unit.INSTANCE;
        }
    }

    public static final Object c(Lifecycle lifecycle, Lifecycle.State state, Function2 function2, Continuation continuation) {
        if (!lifecycle.b().isAtLeast(state)) {
            return Unit.INSTANCE;
        }
        Object f = CoroutineScopeKt.f(new SeesionExtensionsKt$runOnLifecycle$2(function2, (Continuation<? super SeesionExtensionsKt$runOnLifecycle$2>) null), continuation);
        return f == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? f : Unit.INSTANCE;
    }
}
