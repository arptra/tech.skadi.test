package rxhttp.wrapper.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@SourceDebugExtension({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n1#1,113:1\n51#2,5:114\n*E\n"})
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CallFlow$onProgress$$inlined$mapNotNull$1 implements Flow<T> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Flow f3547a;
    public final /* synthetic */ Function2 b;

    public CallFlow$onProgress$$inlined$mapNotNull$1(Flow flow, Function2 function2) {
        this.f3547a = flow;
        this.b = function2;
    }

    public Object collect(final FlowCollector flowCollector, Continuation continuation) {
        Flow flow = this.f3547a;
        final Function2 function2 = this.b;
        Object collect = flow.collect(new FlowCollector() {
            /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
            /* JADX WARNING: Removed duplicated region for block: B:23:0x006e  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof rxhttp.wrapper.coroutines.CallFlow$onProgress$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r7
                    rxhttp.wrapper.coroutines.CallFlow$onProgress$$inlined$mapNotNull$1$2$1 r0 = (rxhttp.wrapper.coroutines.CallFlow$onProgress$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L_0x0018
                L_0x0013:
                    rxhttp.wrapper.coroutines.CallFlow$onProgress$$inlined$mapNotNull$1$2$1 r0 = new rxhttp.wrapper.coroutines.CallFlow$onProgress$$inlined$mapNotNull$1$2$1
                    r0.<init>(r5, r7)
                L_0x0018:
                    java.lang.Object r7 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L_0x0040
                    if (r2 == r4) goto L_0x0034
                    if (r2 != r3) goto L_0x002c
                    kotlin.ResultKt.throwOnFailure(r7)
                    goto L_0x007c
                L_0x002c:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L_0x0034:
                    java.lang.Object r5 = r0.L$1
                    rxhttp.wrapper.entity.Progress r5 = (rxhttp.wrapper.entity.Progress) r5
                    java.lang.Object r6 = r0.L$0
                    kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
                    kotlin.ResultKt.throwOnFailure(r7)
                    goto L_0x0066
                L_0x0040:
                    kotlin.ResultKt.throwOnFailure(r7)
                    kotlinx.coroutines.flow.FlowCollector r7 = r3
                    rxhttp.wrapper.entity.Progress r6 = (rxhttp.wrapper.entity.Progress) r6
                    java.lang.Object r2 = r6.c()
                    if (r2 != 0) goto L_0x0068
                    kotlin.jvm.functions.Function2 r5 = r2
                    r0.L$0 = r7
                    r0.L$1 = r6
                    r0.label = r4
                    r2 = 6
                    kotlin.jvm.internal.InlineMarker.mark((int) r2)
                    java.lang.Object r5 = r5.invoke(r6, r0)
                    r2 = 7
                    kotlin.jvm.internal.InlineMarker.mark((int) r2)
                    if (r5 != r1) goto L_0x0064
                    return r1
                L_0x0064:
                    r5 = r6
                    r6 = r7
                L_0x0066:
                    r7 = r6
                    r6 = r5
                L_0x0068:
                    java.lang.Object r5 = r6.c()
                    if (r5 == 0) goto L_0x007c
                    r6 = 0
                    r0.L$0 = r6
                    r0.L$1 = r6
                    r0.label = r3
                    java.lang.Object r5 = r7.emit(r5, r0)
                    if (r5 != r1) goto L_0x007c
                    return r1
                L_0x007c:
                    kotlin.Unit r5 = kotlin.Unit.INSTANCE
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: rxhttp.wrapper.coroutines.CallFlow$onProgress$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }
}
