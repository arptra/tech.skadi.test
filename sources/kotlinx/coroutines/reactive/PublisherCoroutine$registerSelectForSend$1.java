package kotlinx.coroutines.reactive;

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

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0000*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.reactive.PublisherCoroutine$registerSelectForSend$1", f = "Publish.kt", i = {}, l = {107}, m = "invokeSuspend", n = {}, s = {})
public final class PublisherCoroutine$registerSelectForSend$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SelectInstance<?> $select;
    int label;
    final /* synthetic */ PublisherCoroutine<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PublisherCoroutine$registerSelectForSend$1(PublisherCoroutine<? super T> publisherCoroutine, SelectInstance<?> selectInstance, Continuation<? super PublisherCoroutine$registerSelectForSend$1> continuation) {
        super(2, continuation);
        this.this$0 = publisherCoroutine;
        this.$select = selectInstance;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PublisherCoroutine$registerSelectForSend$1(this.this$0, this.$select, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex s1 = this.this$0.f;
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
        PublisherCoroutine<T> publisherCoroutine = this.this$0;
        Unit unit = Unit.INSTANCE;
        if (!selectInstance.e(publisherCoroutine, unit)) {
            Mutex.DefaultImpls.c(this.this$0.f, (Object) null, 1, (Object) null);
        }
        return unit;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PublisherCoroutine$registerSelectForSend$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
