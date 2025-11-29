package rxhttp;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import rxhttp.wrapper.coroutines.Await;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0002\u001a\u00028\u0000H@¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"rxhttp/AwaitTransformKt$repeat$2", "Lrxhttp/wrapper/coroutines/Await;", "c", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "a", "J", "getRemaining", "()J", "setRemaining", "(J)V", "remaining", "rxhttp"}, k = 1, mv = {1, 9, 0})
public final class AwaitTransformKt$repeat$2 implements Await<Object> {

    /* renamed from: a  reason: collision with root package name */
    public long f3523a;
    public final /* synthetic */ Await b;
    public final /* synthetic */ Function2 c;
    public final /* synthetic */ long d;

    /* JADX WARNING: Removed duplicated region for block: B:22:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b3 A[PHI: r14 
      PHI: (r14v2 java.lang.Object) = (r14v7 java.lang.Object), (r14v1 java.lang.Object) binds: [B:40:0x00b0, B:12:0x002f] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object c(kotlin.coroutines.Continuation r14) {
        /*
            r13 = this;
            boolean r0 = r14 instanceof rxhttp.AwaitTransformKt$repeat$2$await$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            rxhttp.AwaitTransformKt$repeat$2$await$1 r0 = (rxhttp.AwaitTransformKt$repeat$2$await$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            rxhttp.AwaitTransformKt$repeat$2$await$1 r0 = new rxhttp.AwaitTransformKt$repeat$2$await$1
            r0.<init>(r13, r14)
        L_0x0018:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r2 == 0) goto L_0x0054
            if (r2 == r7) goto L_0x004b
            if (r2 == r6) goto L_0x0041
            if (r2 == r5) goto L_0x003c
            if (r2 != r4) goto L_0x0034
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00b3
        L_0x0034:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x003c:
            java.lang.Object r13 = r0.L$0
            rxhttp.AwaitTransformKt$repeat$2 r13 = (rxhttp.AwaitTransformKt$repeat$2) r13
            goto L_0x0054
        L_0x0041:
            java.lang.Object r13 = r0.L$1
            java.lang.Object r2 = r0.L$0
            rxhttp.AwaitTransformKt$repeat$2 r2 = (rxhttp.AwaitTransformKt$repeat$2) r2
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x008c
        L_0x004b:
            java.lang.Object r13 = r0.L$0
            rxhttp.AwaitTransformKt$repeat$2 r13 = (rxhttp.AwaitTransformKt$repeat$2) r13
            kotlin.ResultKt.throwOnFailure(r14)
        L_0x0052:
            r2 = r13
            goto L_0x007a
        L_0x0054:
            kotlin.ResultKt.throwOnFailure(r14)
        L_0x0057:
            long r8 = r13.f3523a
            r10 = 0
            int r14 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r14 <= 0) goto L_0x00a6
            r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r14 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r14 == 0) goto L_0x006d
            r10 = -1
            long r8 = r8 + r10
            r13.f3523a = r8
        L_0x006d:
            rxhttp.wrapper.coroutines.Await r14 = r13.b
            r0.L$0 = r13
            r0.label = r7
            java.lang.Object r14 = r14.c(r0)
            if (r14 != r1) goto L_0x0052
            return r1
        L_0x007a:
            kotlin.jvm.functions.Function2 r13 = r2.c
            r0.L$0 = r2
            r0.L$1 = r14
            r0.label = r6
            java.lang.Object r13 = r13.invoke(r14, r0)
            if (r13 != r1) goto L_0x0089
            return r1
        L_0x0089:
            r12 = r14
            r14 = r13
            r13 = r12
        L_0x008c:
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            if (r14 == 0) goto L_0x0095
            return r13
        L_0x0095:
            long r13 = r2.d
            r0.L$0 = r2
            r0.L$1 = r3
            r0.label = r5
            java.lang.Object r13 = kotlinx.coroutines.DelayKt.b(r13, r0)
            if (r13 != r1) goto L_0x00a4
            return r1
        L_0x00a4:
            r13 = r2
            goto L_0x0057
        L_0x00a6:
            rxhttp.wrapper.coroutines.Await r13 = r13.b
            r0.L$0 = r3
            r0.label = r4
            java.lang.Object r14 = r13.c(r0)
            if (r14 != r1) goto L_0x00b3
            return r1
        L_0x00b3:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: rxhttp.AwaitTransformKt$repeat$2.c(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
