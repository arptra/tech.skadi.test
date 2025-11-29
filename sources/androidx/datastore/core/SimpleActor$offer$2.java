package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.SimpleActor$offer$2", f = "SimpleActor.kt", i = {}, l = {122, 122}, m = "invokeSuspend", n = {}, s = {})
public final class SimpleActor$offer$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ SimpleActor<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimpleActor$offer$2(SimpleActor<T> simpleActor, Continuation<? super SimpleActor$offer$2> continuation) {
        super(2, continuation);
        this.this$0 = simpleActor;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SimpleActor$offer$2(this.this$0, continuation);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0055 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0061 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006e  */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0062
        L_0x0012:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x001a:
            java.lang.Object r1 = r5.L$0
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0056
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
            java.util.concurrent.atomic.AtomicInteger r6 = r6.d
            int r6 = r6.get()
            if (r6 <= 0) goto L_0x0033
            r6 = r3
            goto L_0x0034
        L_0x0033:
            r6 = 0
        L_0x0034:
            if (r6 == 0) goto L_0x0071
        L_0x0036:
            androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
            kotlinx.coroutines.CoroutineScope r6 = r6.f1018a
            kotlinx.coroutines.CoroutineScopeKt.g(r6)
            androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
            kotlin.jvm.functions.Function2 r1 = r6.b
            androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
            kotlinx.coroutines.channels.Channel r6 = r6.c
            r5.L$0 = r1
            r5.label = r3
            java.lang.Object r6 = r6.K(r5)
            if (r6 != r0) goto L_0x0056
            return r0
        L_0x0056:
            r4 = 0
            r5.L$0 = r4
            r5.label = r2
            java.lang.Object r6 = r1.invoke(r6, r5)
            if (r6 != r0) goto L_0x0062
            return r0
        L_0x0062:
            androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
            java.util.concurrent.atomic.AtomicInteger r6 = r6.d
            int r6 = r6.decrementAndGet()
            if (r6 != 0) goto L_0x0036
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x0071:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "Check failed."
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SimpleActor$offer$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SimpleActor$offer$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
