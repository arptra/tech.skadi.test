package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1", f = "RemoteMediatorAccessor.kt", i = {}, l = {386}, m = "invokeSuspend", n = {}, s = {})
public final class RemoteMediatorAccessImpl$launchBoundary$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RemoteMediatorAccessImpl<Key, Value> this$0;

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Key", "", "Value"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1", f = "RemoteMediatorAccessor.kt", i = {0}, l = {393}, m = "invokeSuspend", n = {"loadType"}, s = {"L$0"})
    /* renamed from: androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        @NotNull
        public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
            return new AnonymousClass1(remoteMediatorAccessImpl, continuation);
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0054  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0063  */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 1
                if (r1 == 0) goto L_0x001b
                if (r1 != r2) goto L_0x0013
                java.lang.Object r1 = r5.L$0
                androidx.paging.LoadType r1 = (androidx.paging.LoadType) r1
                kotlin.ResultKt.throwOnFailure(r6)
                goto L_0x004e
            L_0x0013:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L_0x001b:
                kotlin.ResultKt.throwOnFailure(r6)
            L_0x001e:
                androidx.paging.RemoteMediatorAccessImpl<Key, Value> r6 = r3
                androidx.paging.AccessorStateHolder r6 = r6.c
                androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$1 r1 = androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1.AnonymousClass1.AnonymousClass1.INSTANCE
                java.lang.Object r6 = r6.b(r1)
                kotlin.Pair r6 = (kotlin.Pair) r6
                if (r6 != 0) goto L_0x0031
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            L_0x0031:
                java.lang.Object r1 = r6.component1()
                androidx.paging.LoadType r1 = (androidx.paging.LoadType) r1
                java.lang.Object r6 = r6.component2()
                androidx.paging.PagingState r6 = (androidx.paging.PagingState) r6
                androidx.paging.RemoteMediatorAccessImpl<Key, Value> r3 = r3
                androidx.paging.RemoteMediator r3 = r3.b
                r5.L$0 = r1
                r5.label = r2
                java.lang.Object r6 = r3.c(r1, r6, r5)
                if (r6 != r0) goto L_0x004e
                return r0
            L_0x004e:
                androidx.paging.RemoteMediator$MediatorResult r6 = (androidx.paging.RemoteMediator.MediatorResult) r6
                boolean r3 = r6 instanceof androidx.paging.RemoteMediator.MediatorResult.Success
                if (r3 == 0) goto L_0x0063
                androidx.paging.RemoteMediatorAccessImpl<Key, Value> r3 = r3
                androidx.paging.AccessorStateHolder r3 = r3.c
                androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$2 r4 = new androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$2
                r4.<init>(r1, r6)
                r3.b(r4)
                goto L_0x001e
            L_0x0063:
                boolean r3 = r6 instanceof androidx.paging.RemoteMediator.MediatorResult.Error
                if (r3 == 0) goto L_0x001e
                androidx.paging.RemoteMediatorAccessImpl<Key, Value> r3 = r3
                androidx.paging.AccessorStateHolder r3 = r3.c
                androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$3 r4 = new androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$3
                r4.<init>(r1, r6)
                r3.b(r4)
                goto L_0x001e
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Nullable
        public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RemoteMediatorAccessImpl$launchBoundary$1(RemoteMediatorAccessImpl<Key, Value> remoteMediatorAccessImpl, Continuation<? super RemoteMediatorAccessImpl$launchBoundary$1> continuation) {
        super(2, continuation);
        this.this$0 = remoteMediatorAccessImpl;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RemoteMediatorAccessImpl$launchBoundary$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SingleRunner g = this.this$0.d;
            final RemoteMediatorAccessImpl<Key, Value> remoteMediatorAccessImpl = this.this$0;
            AnonymousClass1 r1 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.label = 1;
            if (g.b(1, r1, this) == coroutine_suspended) {
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
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RemoteMediatorAccessImpl$launchBoundary$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
