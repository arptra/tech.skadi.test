package rxhttp.wrapper.coroutines;

import com.upuphone.starrynet.payload.PayloadConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.AbstractFlow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import rxhttp.wrapper.BodyParamFactory;
import rxhttp.wrapper.CallFactory;
import rxhttp.wrapper.parse.OkResponseParser;
import rxhttp.wrapper.parse.Parser;
import rxhttp.wrapper.parse.StreamParser;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH@¢\u0006\u0004\b\f\u0010\rJQ\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2(\u0010\u0015\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0011¢\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\u00162\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lrxhttp/wrapper/coroutines/CallFlow;", "T", "Lkotlinx/coroutines/flow/AbstractFlow;", "Lrxhttp/wrapper/CallFactory;", "callFactory", "Lrxhttp/wrapper/parse/Parser;", "parser", "<init>", "(Lrxhttp/wrapper/CallFactory;Lrxhttp/wrapper/parse/Parser;)V", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "e", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "capacity", "minPeriod", "Lkotlin/Function2;", "Lrxhttp/wrapper/entity/Progress;", "Lkotlin/coroutines/Continuation;", "", "progress", "Lkotlinx/coroutines/flow/Flow;", "h", "(IILkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "j", "(II)Lkotlinx/coroutines/flow/Flow;", "a", "Lrxhttp/wrapper/CallFactory;", "b", "Lrxhttp/wrapper/parse/Parser;", "rxhttp"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nCallFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CallFlow.kt\nrxhttp/wrapper/coroutines/CallFlow\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,76:1\n60#2:77\n63#2:81\n50#3:78\n55#3:80\n107#4:79\n1#5:82\n*S KotlinDebug\n*F\n+ 1 CallFlow.kt\nrxhttp/wrapper/coroutines/CallFlow\n*L\n48#1:77\n48#1:81\n48#1:78\n48#1:80\n48#1:79\n*E\n"})
public final class CallFlow<T> extends AbstractFlow<T> {

    /* renamed from: a  reason: collision with root package name */
    public final CallFactory f3546a;
    public final Parser b;

    public CallFlow(CallFactory callFactory, Parser parser) {
        Intrinsics.checkNotNullParameter(callFactory, "callFactory");
        Intrinsics.checkNotNullParameter(parser, "parser");
        this.f3546a = callFactory;
        this.b = parser;
    }

    public static /* synthetic */ Flow i(CallFlow callFlow, int i, int i2, Function2 function2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 2;
        }
        if ((i3 & 2) != 0) {
            i2 = 500;
        }
        return callFlow.h(i, i2, function2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: kotlinx.coroutines.flow.FlowCollector} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object e(kotlinx.coroutines.flow.FlowCollector r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof rxhttp.wrapper.coroutines.CallFlow$collectSafely$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            rxhttp.wrapper.coroutines.CallFlow$collectSafely$1 r0 = (rxhttp.wrapper.coroutines.CallFlow$collectSafely$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            rxhttp.wrapper.coroutines.CallFlow$collectSafely$1 r0 = new rxhttp.wrapper.coroutines.CallFlow$collectSafely$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005f
        L_0x002c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0034:
            java.lang.Object r5 = r0.L$0
            r6 = r5
            kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0053
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r7)
            rxhttp.wrapper.CallFactory r7 = r5.f3546a
            rxhttp.wrapper.parse.Parser r5 = r5.b
            rxhttp.wrapper.coroutines.CallAwait r5 = rxhttp.CallFactoryExtKt.a(r7, r5)
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r5.c(r0)
            if (r7 != r1) goto L_0x0053
            return r1
        L_0x0053:
            r5 = 0
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r5 = r6.emit(r7, r0)
            if (r5 != r1) goto L_0x005f
            return r1
        L_0x005f:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: rxhttp.wrapper.coroutines.CallFlow.e(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Flow h(int i, int i2, Function2 function2) {
        Intrinsics.checkNotNullParameter(function2, PayloadConstant.PARAMS_KEY_INT_OTA_PROGRESS);
        return new CallFlow$onProgress$$inlined$mapNotNull$1(j(i, i2), function2);
    }

    public final Flow j(int i, int i2) {
        T t;
        if (2 > i || i >= 101) {
            throw new IllegalArgumentException(("capacity must be in [2..100], but it was " + i).toString());
        } else if (i2 > 0) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = this.b;
            while (true) {
                t = objectRef.element;
                if (!(t instanceof OkResponseParser)) {
                    break;
                }
                T t2 = ((OkResponseParser) t).f3563a;
                Intrinsics.checkNotNullExpressionValue(t2, "parser");
                objectRef.element = t2;
            }
            if ((t instanceof StreamParser) || (this.f3546a instanceof BodyParamFactory)) {
                return FlowKt.d(FlowKt.i(new CallFlow$toFlowProgress$3(objectRef, i2, this, (Continuation<? super CallFlow$toFlowProgress$3>) null)), i, BufferOverflow.DROP_OLDEST);
            }
            throw new UnsupportedOperationException("parser is " + objectRef.element.getClass().getName() + ", callFactory is " + this.f3546a.getClass().getName());
        } else {
            throw new IllegalArgumentException(("minPeriod must be between 0 and Int.MAX_VALUE, but it was " + i2).toString());
        }
    }
}
