package com.upuphone.ar.fastrecord.phone.ui.viewmodel.history;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordHistoryAsrOperator$startCheckFinishPrePareJob$1", f = "FastRecordHistoryAsrOperator.kt", i = {}, l = {1037}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordHistoryAsrOperator$startCheckFinishPrePareJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $callback;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ FastRecordHistoryAsrOperator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordHistoryAsrOperator$startCheckFinishPrePareJob$1(FastRecordHistoryAsrOperator fastRecordHistoryAsrOperator, Function0<Unit> function0, Continuation<? super FastRecordHistoryAsrOperator$startCheckFinishPrePareJob$1> continuation) {
        super(2, continuation);
        this.this$0 = fastRecordHistoryAsrOperator;
        this.$callback = function0;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordHistoryAsrOperator$startCheckFinishPrePareJob$1(this.this$0, this.$callback, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0034  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 1
            if (r1 == 0) goto L_0x0023
            if (r1 != r2) goto L_0x001b
            int r1 = r9.I$1
            int r3 = r9.I$0
            java.lang.Object r4 = r9.L$1
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            java.lang.Object r5 = r9.L$0
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordHistoryAsrOperator r5 = (com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordHistoryAsrOperator) r5
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0047
        L_0x001b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0023:
            kotlin.ResultKt.throwOnFailure(r10)
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordHistoryAsrOperator r10 = r9.this$0
            kotlin.jvm.functions.Function0<kotlin.Unit> r1 = r9.$callback
            r3 = 2147483647(0x7fffffff, float:NaN)
            r4 = 0
            r5 = r10
            r8 = r4
            r4 = r1
            r1 = r8
        L_0x0032:
            if (r1 >= r3) goto L_0x0066
            r9.L$0 = r5
            r9.L$1 = r4
            r9.I$0 = r3
            r9.I$1 = r1
            r9.label = r2
            r6 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.b(r6, r9)
            if (r10 != r0) goto L_0x0047
            return r0
        L_0x0047:
            boolean r10 = r5.isFinishPrePareAsrSocket
            if (r10 == 0) goto L_0x0064
            r4.invoke()
            java.lang.String r10 = "checkFinishPrePareJob?.cancel()"
            java.lang.String r6 = "FastRecordHistoryAsrOperator"
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logE(r10, r6)
            kotlinx.coroutines.Job r10 = r5.checkFinishPrePareJob
            r6 = 0
            if (r10 == 0) goto L_0x0061
            kotlinx.coroutines.Job.DefaultImpls.a(r10, r6, r2, r6)
        L_0x0061:
            r5.checkFinishPrePareJob = r6
        L_0x0064:
            int r1 = r1 + r2
            goto L_0x0032
        L_0x0066:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordHistoryAsrOperator$startCheckFinishPrePareJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordHistoryAsrOperator$startCheckFinishPrePareJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
