package com.upuphone.star.httplib;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.Call;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u0002\u0004\n\u0002\b\u0019¨\u0006\u0004"}, d2 = {"Lokhttp3/Call;", "Lokhttp3/Response;", "a", "(Lokhttp3/Call;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "super-http-lib_release"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nCallExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CallExt.kt\ncom/upuphone/star/httplib/CallExtKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,30:1\n314#2,11:31\n*S KotlinDebug\n*F\n+ 1 CallExt.kt\ncom/upuphone/star/httplib/CallExtKt\n*L\n15#1:31,11\n*E\n"})
public final class CallExtKt {
    public static final Object a(Call call, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.x();
        cancellableContinuationImpl.E(new CallExtKt$awaitResponse$2$1(call));
        call.enqueue(new CallExtKt$awaitResponse$2$2(cancellableContinuationImpl));
        Object u = cancellableContinuationImpl.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u;
    }
}
