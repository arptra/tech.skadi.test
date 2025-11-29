package com.upuphone.star.fota.phone.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lokhttp3/Call;", "Lkotlin/Result;", "Lokhttp3/Response;", "a", "(Lokhttp3/Call;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ar-fota-lib_release"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nCallExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CallExt.kt\ncom/upuphone/star/fota/phone/utils/CallExtKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,50:1\n314#2,11:51\n314#2,11:62\n*S KotlinDebug\n*F\n+ 1 CallExt.kt\ncom/upuphone/star/fota/phone/utils/CallExtKt\n*L\n15#1:51,11\n35#1:62,11\n*E\n"})
public final class CallExtKt {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(okhttp3.Call r4, kotlin.coroutines.Continuation r5) {
        /*
            boolean r0 = r5 instanceof com.upuphone.star.fota.phone.utils.CallExtKt$awaitResponseResult$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.upuphone.star.fota.phone.utils.CallExtKt$awaitResponseResult$1 r0 = (com.upuphone.star.fota.phone.utils.CallExtKt$awaitResponseResult$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.star.fota.phone.utils.CallExtKt$awaitResponseResult$1 r0 = new com.upuphone.star.fota.phone.utils.CallExtKt$awaitResponseResult$1
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r4 = r0.L$0
            okhttp3.Call r4 = (okhttp3.Call) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0068
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.L$0 = r4
            r0.label = r3
            kotlinx.coroutines.CancellableContinuationImpl r5 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r0)
            r5.<init>(r2, r3)
            r5.x()
            com.upuphone.star.fota.phone.utils.CallExtKt$awaitResponseResult$2$1 r2 = new com.upuphone.star.fota.phone.utils.CallExtKt$awaitResponseResult$2$1
            r2.<init>(r4)
            r5.E(r2)
            com.upuphone.star.fota.phone.utils.CallExtKt$awaitResponseResult$2$2 r2 = new com.upuphone.star.fota.phone.utils.CallExtKt$awaitResponseResult$2$2
            r2.<init>(r5)
            r4.enqueue(r2)
            java.lang.Object r5 = r5.u()
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r5 != r4) goto L_0x0065
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
        L_0x0065:
            if (r5 != r1) goto L_0x0068
            return r1
        L_0x0068:
            kotlin.Result r5 = (kotlin.Result) r5
            java.lang.Object r4 = r5.m29unboximpl()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.star.fota.phone.utils.CallExtKt.a(okhttp3.Call, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
