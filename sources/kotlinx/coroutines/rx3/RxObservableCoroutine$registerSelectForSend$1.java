package kotlinx.coroutines.rx3;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.sync.Mutex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H@"}, d2 = {"<anonymous>", "", "T", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.rx3.RxObservableCoroutine$registerSelectForSend$1", f = "RxObservable.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, s = {})
public final class RxObservableCoroutine$registerSelectForSend$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SelectInstance<?> $select;
    int label;
    final /* synthetic */ RxObservableCoroutine<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RxObservableCoroutine$registerSelectForSend$1(RxObservableCoroutine<T> rxObservableCoroutine, SelectInstance<?> selectInstance, Continuation<? super RxObservableCoroutine$registerSelectForSend$1> continuation) {
        super(2, continuation);
        this.this$0 = rxObservableCoroutine;
        this.$select = selectInstance;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RxObservableCoroutine$registerSelectForSend$1(this.this$0, this.$select, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex s1 = this.this$0.e;
            this.label = 1;
            if (Mutex.DefaultImpls.a(s1, (Object) null, this, 1, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        SelectInstance<?> selectInstance = this.$select;
        RxObservableCoroutine<T> rxObservableCoroutine = this.this$0;
        Unit unit = Unit.INSTANCE;
        if (!selectInstance.e(rxObservableCoroutine, unit)) {
            Mutex.DefaultImpls.c(this.this$0.e, (Object) null, 1, (Object) null);
        }
        return unit;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RxObservableCoroutine$registerSelectForSend$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
