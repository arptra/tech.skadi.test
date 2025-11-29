package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.FlowExtKt$simpleRunningReduce$1", f = "FlowExt.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
public final class FlowExtKt$simpleRunningReduce$1 extends SuspendLambda implements Function2<FlowCollector<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<Object, Object, Continuation<Object>, Object> $operation;
    final /* synthetic */ Flow<Object> $this_simpleRunningReduce;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowExtKt$simpleRunningReduce$1(Flow<Object> flow, Function3<Object, Object, ? super Continuation<Object>, ? extends Object> function3, Continuation<? super FlowExtKt$simpleRunningReduce$1> continuation) {
        super(2, continuation);
        this.$this_simpleRunningReduce = flow;
        this.$operation = function3;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowExtKt$simpleRunningReduce$1 flowExtKt$simpleRunningReduce$1 = new FlowExtKt$simpleRunningReduce$1(this.$this_simpleRunningReduce, this.$operation, continuation);
        flowExtKt$simpleRunningReduce$1.L$0 = obj;
        return flowExtKt$simpleRunningReduce$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final FlowCollector flowCollector = (FlowCollector) this.L$0;
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = FlowExtKt.f1535a;
            Flow<Object> flow = this.$this_simpleRunningReduce;
            final Function3<Object, Object, Continuation<Object>, Object> function3 = this.$operation;
            AnonymousClass1 r4 = new FlowCollector() {
                /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
                /* JADX WARNING: Removed duplicated region for block: B:23:0x007e A[RETURN] */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final java.lang.Object emit(T r8, kotlin.coroutines.Continuation r9) {
                    /*
                        r7 = this;
                        boolean r0 = r9 instanceof androidx.paging.FlowExtKt$simpleRunningReduce$1$1$emit$1
                        if (r0 == 0) goto L_0x0013
                        r0 = r9
                        androidx.paging.FlowExtKt$simpleRunningReduce$1$1$emit$1 r0 = (androidx.paging.FlowExtKt$simpleRunningReduce$1$1$emit$1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L_0x0013
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L_0x0018
                    L_0x0013:
                        androidx.paging.FlowExtKt$simpleRunningReduce$1$1$emit$1 r0 = new androidx.paging.FlowExtKt$simpleRunningReduce$1$1$emit$1
                        r0.<init>(r7, r9)
                    L_0x0018:
                        java.lang.Object r9 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L_0x0040
                        if (r2 == r4) goto L_0x0034
                        if (r2 != r3) goto L_0x002c
                        kotlin.ResultKt.throwOnFailure(r9)
                        goto L_0x007f
                    L_0x002c:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L_0x0034:
                        java.lang.Object r7 = r0.L$1
                        kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
                        java.lang.Object r8 = r0.L$0
                        androidx.paging.FlowExtKt$simpleRunningReduce$1$1 r8 = (androidx.paging.FlowExtKt$simpleRunningReduce$1.AnonymousClass1) r8
                        kotlin.ResultKt.throwOnFailure(r9)
                        goto L_0x0065
                    L_0x0040:
                        kotlin.ResultKt.throwOnFailure(r9)
                        kotlin.jvm.internal.Ref$ObjectRef r9 = r1
                        T r2 = r9.element
                        java.lang.Object r5 = androidx.paging.FlowExtKt.f1535a
                        if (r2 != r5) goto L_0x004e
                        goto L_0x0069
                    L_0x004e:
                        kotlin.jvm.functions.Function3 r2 = r5
                        kotlin.jvm.internal.Ref$ObjectRef r5 = r1
                        T r5 = r5.element
                        r0.L$0 = r7
                        r0.L$1 = r9
                        r0.label = r4
                        java.lang.Object r8 = r2.invoke(r5, r8, r0)
                        if (r8 != r1) goto L_0x0061
                        return r1
                    L_0x0061:
                        r6 = r8
                        r8 = r7
                        r7 = r9
                        r9 = r6
                    L_0x0065:
                        r6 = r9
                        r9 = r7
                        r7 = r8
                        r8 = r6
                    L_0x0069:
                        r9.element = r8
                        kotlinx.coroutines.flow.FlowCollector r8 = r7
                        kotlin.jvm.internal.Ref$ObjectRef r7 = r1
                        T r7 = r7.element
                        r9 = 0
                        r0.L$0 = r9
                        r0.L$1 = r9
                        r0.label = r3
                        java.lang.Object r7 = r8.emit(r7, r0)
                        if (r7 != r1) goto L_0x007f
                        return r1
                    L_0x007f:
                        kotlin.Unit r7 = kotlin.Unit.INSTANCE
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.paging.FlowExtKt$simpleRunningReduce$1.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            };
            this.label = 1;
            if (flow.collect(r4, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<Object> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((FlowExtKt$simpleRunningReduce$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
