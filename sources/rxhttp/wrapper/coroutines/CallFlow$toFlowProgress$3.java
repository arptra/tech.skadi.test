package rxhttp.wrapper.coroutines;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rxhttp.CallFactoryExtKt;
import rxhttp.wrapper.BodyParamFactory;
import rxhttp.wrapper.entity.Progress;
import rxhttp.wrapper.parse.Parser;
import rxhttp.wrapper.parse.StreamParser;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/channels/ProducerScope;", "Lrxhttp/wrapper/entity/Progress;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "rxhttp.wrapper.coroutines.CallFlow$toFlowProgress$3", f = "CallFlow.kt", i = {0}, l = {72}, m = "invokeSuspend", n = {"$this$channelFlow"}, s = {"L$0"})
public final class CallFlow$toFlowProgress$3 extends SuspendLambda implements Function2<ProducerScope<? super Progress<T>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $minPeriod;
    final /* synthetic */ Ref.ObjectRef<Parser<?>> $streamParser;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CallFlow<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CallFlow$toFlowProgress$3(Ref.ObjectRef<Parser<?>> objectRef, int i, CallFlow<T> callFlow, Continuation<? super CallFlow$toFlowProgress$3> continuation) {
        super(2, continuation);
        this.$streamParser = objectRef;
        this.$minPeriod = i;
        this.this$0 = callFlow;
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(ProducerScope producerScope, long j, long j2, long j3) {
        producerScope.q(new Progress(j, j2, j3));
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        CallFlow$toFlowProgress$3 callFlow$toFlowProgress$3 = new CallFlow$toFlowProgress$3(this.$streamParser, this.$minPeriod, this.this$0, continuation);
        callFlow$toFlowProgress$3.L$0 = obj;
        return callFlow$toFlowProgress$3;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ProducerScope producerScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope2 = (ProducerScope) this.L$0;
            a aVar = new a(producerScope2);
            T t = this.$streamParser.element;
            if (t instanceof StreamParser) {
                ((StreamParser) t).b(this.$minPeriod, aVar);
            } else if (this.this$0.f3546a instanceof BodyParamFactory) {
                ((BodyParamFactory) this.this$0.f3546a).c().u(this.$minPeriod, aVar);
            }
            CallAwait a2 = CallFactoryExtKt.a(this.this$0.f3546a, this.this$0.b);
            this.L$0 = producerScope2;
            this.label = 1;
            Object c = a2.c(this);
            if (c == coroutine_suspended) {
                return coroutine_suspended;
            }
            ProducerScope producerScope3 = producerScope2;
            obj = c;
            producerScope = producerScope3;
        } else if (i == 1) {
            producerScope = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        producerScope.q(new Progress(obj));
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super Progress<T>> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CallFlow$toFlowProgress$3) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
