package rxhttp;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import rxhttp.wrapper.coroutines.Await;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0002\u001a\u00028\u0000H@¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"rxhttp/AwaitTransformKt$retry$2", "Lrxhttp/wrapper/coroutines/Await;", "c", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "a", "J", "getRetryTime", "()J", "setRetryTime", "(J)V", "retryTime", "rxhttp"}, k = 1, mv = {1, 9, 0})
public final class AwaitTransformKt$retry$2 implements Await<Object> {

    /* renamed from: a  reason: collision with root package name */
    public long f3524a;
    public final /* synthetic */ Await b;
    public final /* synthetic */ Function2 c;
    public final /* synthetic */ long d;

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00be A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00bf A[PHI: r13 
      PHI: (r13v2 java.lang.Object) = (r13v3 java.lang.Object), (r13v6 java.lang.Object), (r13v1 java.lang.Object), (r13v1 java.lang.Object) binds: [B:42:0x00bc, B:25:0x0070, B:19:?, B:12:0x002f] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object c(kotlin.coroutines.Continuation r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof rxhttp.AwaitTransformKt$retry$2$await$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            rxhttp.AwaitTransformKt$retry$2$await$1 r0 = (rxhttp.AwaitTransformKt$retry$2$await$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            rxhttp.AwaitTransformKt$retry$2$await$1 r0 = new rxhttp.AwaitTransformKt$retry$2$await$1
            r0.<init>(r12, r13)
        L_0x0018:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r2 == 0) goto L_0x0063
            if (r2 == r7) goto L_0x0056
            if (r2 == r6) goto L_0x0045
            if (r2 == r5) goto L_0x003c
            if (r2 != r4) goto L_0x0034
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00bf
        L_0x0034:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x003c:
            java.lang.Object r12 = r0.L$0
            rxhttp.AwaitTransformKt$retry$2 r12 = (rxhttp.AwaitTransformKt$retry$2) r12
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00b4
        L_0x0045:
            long r6 = r0.J$0
            java.lang.Object r12 = r0.L$1
            java.lang.Throwable r12 = (java.lang.Throwable) r12
            java.lang.Object r2 = r0.L$0
            rxhttp.AwaitTransformKt$retry$2 r2 = (rxhttp.AwaitTransformKt$retry$2) r2
            kotlin.ResultKt.throwOnFailure(r13)
            r11 = r2
            r2 = r13
            r13 = r11
            goto L_0x0096
        L_0x0056:
            java.lang.Object r12 = r0.L$0
            rxhttp.AwaitTransformKt$retry$2 r12 = (rxhttp.AwaitTransformKt$retry$2) r12
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ all -> 0x005e }
            goto L_0x00bf
        L_0x005e:
            r13 = move-exception
            r11 = r13
            r13 = r12
            r12 = r11
            goto L_0x0073
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r13)
            rxhttp.wrapper.coroutines.Await r13 = r12.b     // Catch:{ all -> 0x005e }
            r0.L$0 = r12     // Catch:{ all -> 0x005e }
            r0.label = r7     // Catch:{ all -> 0x005e }
            java.lang.Object r13 = r13.c(r0)     // Catch:{ all -> 0x005e }
            if (r13 != r1) goto L_0x00bf
            return r1
        L_0x0073:
            long r7 = r13.f3524a
            r9 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 == 0) goto L_0x0084
            r9 = 1
            long r9 = r7 - r9
            r13.f3524a = r9
        L_0x0084:
            kotlin.jvm.functions.Function2 r2 = r13.c
            r0.L$0 = r13
            r0.L$1 = r12
            r0.J$0 = r7
            r0.label = r6
            java.lang.Object r2 = r2.invoke(r12, r0)
            if (r2 != r1) goto L_0x0095
            return r1
        L_0x0095:
            r6 = r7
        L_0x0096:
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x00c0
            if (r2 == 0) goto L_0x00c0
            long r6 = r13.d
            r0.L$0 = r13
            r0.L$1 = r3
            r0.label = r5
            java.lang.Object r12 = kotlinx.coroutines.DelayKt.b(r6, r0)
            if (r12 != r1) goto L_0x00b3
            return r1
        L_0x00b3:
            r12 = r13
        L_0x00b4:
            r0.L$0 = r3
            r0.label = r4
            java.lang.Object r13 = r12.c(r0)
            if (r13 != r1) goto L_0x00bf
            return r1
        L_0x00bf:
            return r13
        L_0x00c0:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: rxhttp.AwaitTransformKt$retry$2.c(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
