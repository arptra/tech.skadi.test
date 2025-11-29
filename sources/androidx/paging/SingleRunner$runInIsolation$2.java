package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.SingleRunner$runInIsolation$2", f = "SingleRunner.kt", i = {0, 1}, l = {53, 59, 61, 61}, m = "invokeSuspend", n = {"myJob", "myJob"}, s = {"L$0", "L$0"})
public final class SingleRunner$runInIsolation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
    final /* synthetic */ int $priority;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SingleRunner this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleRunner$runInIsolation$2(SingleRunner singleRunner, int i, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super SingleRunner$runInIsolation$2> continuation) {
        super(2, continuation);
        this.this$0 = singleRunner;
        this.$priority = i;
        this.$block = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SingleRunner$runInIsolation$2 singleRunner$runInIsolation$2 = new SingleRunner$runInIsolation$2(this.this$0, this.$priority, this.$block, continuation);
        singleRunner$runInIsolation$2.L$0 = obj;
        return singleRunner$runInIsolation$2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x008d A[RETURN] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x003c
            if (r1 == r5) goto L_0x0034
            if (r1 == r4) goto L_0x002a
            if (r1 == r3) goto L_0x0025
            if (r1 == r2) goto L_0x001c
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x001c:
            java.lang.Object r8 = r8.L$0
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x00a0
        L_0x0025:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x00a1
        L_0x002a:
            java.lang.Object r1 = r8.L$0
            kotlinx.coroutines.Job r1 = (kotlinx.coroutines.Job) r1
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x0032 }
            goto L_0x007c
        L_0x0032:
            r9 = move-exception
            goto L_0x008e
        L_0x0034:
            java.lang.Object r1 = r8.L$0
            kotlinx.coroutines.Job r1 = (kotlinx.coroutines.Job) r1
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0067
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.Object r9 = r8.L$0
            kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
            kotlin.coroutines.CoroutineContext r9 = r9.getCoroutineContext()
            kotlinx.coroutines.Job$Key r1 = kotlinx.coroutines.Job.b0
            kotlin.coroutines.CoroutineContext$Element r9 = r9.get(r1)
            if (r9 == 0) goto L_0x00a4
            kotlinx.coroutines.Job r9 = (kotlinx.coroutines.Job) r9
            androidx.paging.SingleRunner r1 = r8.this$0
            androidx.paging.SingleRunner$Holder r1 = r1.f1635a
            int r6 = r8.$priority
            r8.L$0 = r9
            r8.label = r5
            java.lang.Object r1 = r1.b(r6, r9, r8)
            if (r1 != r0) goto L_0x0064
            return r0
        L_0x0064:
            r7 = r1
            r1 = r9
            r9 = r7
        L_0x0067:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x00a1
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r9 = r8.$block     // Catch:{ all -> 0x0032 }
            r8.L$0 = r1     // Catch:{ all -> 0x0032 }
            r8.label = r4     // Catch:{ all -> 0x0032 }
            java.lang.Object r9 = r9.invoke(r8)     // Catch:{ all -> 0x0032 }
            if (r9 != r0) goto L_0x007c
            return r0
        L_0x007c:
            androidx.paging.SingleRunner r9 = r8.this$0
            androidx.paging.SingleRunner$Holder r9 = r9.f1635a
            r2 = 0
            r8.L$0 = r2
            r8.label = r3
            java.lang.Object r8 = r9.a(r1, r8)
            if (r8 != r0) goto L_0x00a1
            return r0
        L_0x008e:
            androidx.paging.SingleRunner r3 = r8.this$0
            androidx.paging.SingleRunner$Holder r3 = r3.f1635a
            r8.L$0 = r9
            r8.label = r2
            java.lang.Object r8 = r3.a(r1, r8)
            if (r8 != r0) goto L_0x009f
            return r0
        L_0x009f:
            r8 = r9
        L_0x00a0:
            throw r8
        L_0x00a1:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x00a4:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "Internal error. coroutineScope should've created a job."
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SingleRunner$runInIsolation$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SingleRunner$runInIsolation$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
