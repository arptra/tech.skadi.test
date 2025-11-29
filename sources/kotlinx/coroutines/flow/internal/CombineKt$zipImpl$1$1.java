package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\u00020\u0005H@"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1", f = "Combine.kt", i = {0}, l = {126}, m = "invokeSuspend", n = {"second"}, s = {"L$0"})
final class CombineKt$zipImpl$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<Object> $flow;
    final /* synthetic */ Flow<Object> $flow2;
    final /* synthetic */ FlowCollector<Object> $this_unsafeFlow;
    final /* synthetic */ Function3<Object, Object, Continuation<Object>, Object> $transform;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CombineKt$zipImpl$1$1(FlowCollector<Object> flowCollector, Flow<Object> flow, Flow<Object> flow2, Function3<Object, Object, ? super Continuation<Object>, ? extends Object> function3, Continuation<? super CombineKt$zipImpl$1$1> continuation) {
        super(2, continuation);
        this.$this_unsafeFlow = flowCollector;
        this.$flow2 = flow;
        this.$flow = flow2;
        this.$transform = function3;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        CombineKt$zipImpl$1$1 combineKt$zipImpl$1$1 = new CombineKt$zipImpl$1$1(this.$this_unsafeFlow, this.$flow2, this.$flow, this.$transform, continuation);
        combineKt$zipImpl$1$1.L$0 = obj;
        return combineKt$zipImpl$1$1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: kotlinx.coroutines.channels.ReceiveChannel} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r20) {
        /*
            r19 = this;
            r8 = r19
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r9 = 1
            r10 = 0
            if (r1 == 0) goto L_0x0026
            if (r1 != r9) goto L_0x001e
            java.lang.Object r0 = r8.L$0
            r1 = r0
            kotlinx.coroutines.channels.ReceiveChannel r1 = (kotlinx.coroutines.channels.ReceiveChannel) r1
            kotlin.ResultKt.throwOnFailure(r20)     // Catch:{ AbortFlowException -> 0x001b }
            goto L_0x008b
        L_0x0018:
            r0 = move-exception
            goto L_0x00a4
        L_0x001b:
            r0 = move-exception
            goto L_0x009b
        L_0x001e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0026:
            kotlin.ResultKt.throwOnFailure(r20)
            java.lang.Object r1 = r8.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1 r5 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1
            kotlinx.coroutines.flow.Flow<java.lang.Object> r2 = r8.$flow2
            r5.<init>(r2, r10)
            r6 = 3
            r7 = 0
            r3 = 0
            r4 = 0
            r2 = r1
            kotlinx.coroutines.channels.ReceiveChannel r7 = kotlinx.coroutines.channels.ProduceKt.d(r2, r3, r4, r5, r6, r7)
            kotlinx.coroutines.CompletableJob r2 = kotlinx.coroutines.JobKt__JobKt.b(r10, r9, r10)
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.channels.SendChannel<*>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7, r3)
            r3 = r7
            kotlinx.coroutines.channels.SendChannel r3 = (kotlinx.coroutines.channels.SendChannel) r3
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$1 r4 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$1
            kotlinx.coroutines.flow.FlowCollector<java.lang.Object> r5 = r8.$this_unsafeFlow
            r4.<init>(r2, r5)
            r3.p(r4)
            kotlin.coroutines.CoroutineContext r13 = r1.getCoroutineContext()     // Catch:{ AbortFlowException -> 0x0098, all -> 0x0095 }
            java.lang.Object r14 = kotlinx.coroutines.internal.ThreadContextKt.b(r13)     // Catch:{ AbortFlowException -> 0x0098, all -> 0x0095 }
            kotlin.coroutines.CoroutineContext r1 = r1.getCoroutineContext()     // Catch:{ AbortFlowException -> 0x0098, all -> 0x0095 }
            kotlin.coroutines.CoroutineContext r1 = r1.plus(r2)     // Catch:{ AbortFlowException -> 0x0098, all -> 0x0095 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ AbortFlowException -> 0x0098, all -> 0x0095 }
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2 r4 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2     // Catch:{ AbortFlowException -> 0x0098, all -> 0x0095 }
            kotlinx.coroutines.flow.Flow<java.lang.Object> r12 = r8.$flow     // Catch:{ AbortFlowException -> 0x0098, all -> 0x0095 }
            kotlinx.coroutines.flow.FlowCollector<java.lang.Object> r3 = r8.$this_unsafeFlow     // Catch:{ AbortFlowException -> 0x0098, all -> 0x0095 }
            kotlin.jvm.functions.Function3<java.lang.Object, java.lang.Object, kotlin.coroutines.Continuation<java.lang.Object>, java.lang.Object> r5 = r8.$transform     // Catch:{ AbortFlowException -> 0x0098, all -> 0x0095 }
            r18 = 0
            r11 = r4
            r15 = r7
            r16 = r3
            r17 = r5
            r11.<init>(r12, r13, r14, r15, r16, r17, r18)     // Catch:{ AbortFlowException -> 0x0098, all -> 0x0095 }
            r8.L$0 = r7     // Catch:{ AbortFlowException -> 0x0098, all -> 0x0095 }
            r8.label = r9     // Catch:{ AbortFlowException -> 0x0098, all -> 0x0095 }
            r3 = 0
            r6 = 4
            r11 = 0
            r5 = r19
            r12 = r7
            r7 = r11
            java.lang.Object r1 = kotlinx.coroutines.flow.internal.ChannelFlowKt.d(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ AbortFlowException -> 0x0092, all -> 0x008f }
            if (r1 != r0) goto L_0x008a
            return r0
        L_0x008a:
            r1 = r12
        L_0x008b:
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.a(r1, r10, r9, r10)
            goto L_0x00a1
        L_0x008f:
            r0 = move-exception
        L_0x0090:
            r1 = r12
            goto L_0x00a4
        L_0x0092:
            r0 = move-exception
        L_0x0093:
            r1 = r12
            goto L_0x009b
        L_0x0095:
            r0 = move-exception
            r12 = r7
            goto L_0x0090
        L_0x0098:
            r0 = move-exception
            r12 = r7
            goto L_0x0093
        L_0x009b:
            kotlinx.coroutines.flow.FlowCollector<java.lang.Object> r2 = r8.$this_unsafeFlow     // Catch:{ all -> 0x0018 }
            kotlinx.coroutines.flow.internal.FlowExceptions_commonKt.a(r0, r2)     // Catch:{ all -> 0x0018 }
            goto L_0x008b
        L_0x00a1:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x00a4:
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.a(r1, r10, r9, r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CombineKt$zipImpl$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
