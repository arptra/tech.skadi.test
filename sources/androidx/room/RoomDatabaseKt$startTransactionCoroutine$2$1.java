package androidx.room;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "R", "run"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class RoomDatabaseKt$startTransactionCoroutine$2$1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CoroutineContext f1753a;
    public final /* synthetic */ CancellableContinuation b;
    public final /* synthetic */ RoomDatabase c;
    public final /* synthetic */ Function2 d;

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.room.RoomDatabaseKt$startTransactionCoroutine$2$1$1", f = "RoomDatabaseExt.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.room.RoomDatabaseKt$startTransactionCoroutine$2$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(roomDatabase, cancellableContinuation, function2, continuation);
            r0.L$0 = obj;
            return r0;
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Continuation continuation;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineContext.Element element = ((CoroutineScope) this.L$0).getCoroutineContext().get(ContinuationInterceptor.Key);
                Intrinsics.checkNotNull(element);
                CoroutineContext a2 = RoomDatabaseKt.b(roomDatabase, (ContinuationInterceptor) element);
                CancellableContinuation<Object> cancellableContinuation = cancellableContinuation;
                Result.Companion companion = Result.Companion;
                Function2<CoroutineScope, Continuation<Object>, Object> function2 = function2;
                this.L$0 = cancellableContinuation;
                this.label = 1;
                obj = BuildersKt.g(a2, function2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                continuation = cancellableContinuation;
            } else if (i == 1) {
                continuation = (Continuation) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            continuation.resumeWith(Result.m20constructorimpl(obj));
            return Unit.INSTANCE;
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public RoomDatabaseKt$startTransactionCoroutine$2$1(CoroutineContext coroutineContext, CancellableContinuation cancellableContinuation, RoomDatabase roomDatabase, Function2 function2) {
        this.f1753a = coroutineContext;
        this.b = cancellableContinuation;
        this.c = roomDatabase;
        this.d = function2;
    }

    public final void run() {
        try {
            CoroutineContext minusKey = this.f1753a.minusKey(ContinuationInterceptor.Key);
            final RoomDatabase roomDatabase = this.c;
            final CancellableContinuation cancellableContinuation = this.b;
            final Function2 function2 = this.d;
            BuildersKt.e(minusKey, new AnonymousClass1((Continuation<? super AnonymousClass1>) null));
        } catch (Throwable th) {
            this.b.e(th);
        }
    }
}
