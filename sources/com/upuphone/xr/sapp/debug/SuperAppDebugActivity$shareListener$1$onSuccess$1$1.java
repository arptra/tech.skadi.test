package com.upuphone.xr.sapp.debug;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.debug.SuperAppDebugActivity$shareListener$1$onSuccess$1$1", f = "SuperAppDebugActivity.kt", i = {}, l = {169}, m = "invokeSuspend", n = {}, s = {})
public final class SuperAppDebugActivity$shareListener$1$onSuccess$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Uri $receiveUri;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SuperAppDebugActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuperAppDebugActivity$shareListener$1$onSuccess$1$1(SuperAppDebugActivity superAppDebugActivity, Uri uri, Continuation<? super SuperAppDebugActivity$shareListener$1$onSuccess$1$1> continuation) {
        super(2, continuation);
        this.this$0 = superAppDebugActivity;
        this.$receiveUri = uri;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SuperAppDebugActivity$shareListener$1$onSuccess$1$1 superAppDebugActivity$shareListener$1$onSuccess$1$1 = new SuperAppDebugActivity$shareListener$1$onSuccess$1$1(this.this$0, this.$receiveUri, continuation);
        superAppDebugActivity$shareListener$1$onSuccess$1$1.L$0 = obj;
        return superAppDebugActivity$shareListener$1$onSuccess$1$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Deferred b = BuildersKt__Builders_commonKt.b((CoroutineScope) this.L$0, (CoroutineContext) null, (CoroutineStart) null, new SuperAppDebugActivity$shareListener$1$onSuccess$1$1$async$1(this.this$0, this.$receiveUri, (Continuation<? super SuperAppDebugActivity$shareListener$1$onSuccess$1$1$async$1>) null), 3, (Object) null);
            this.label = 1;
            if (b.c(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.V0();
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SuperAppDebugActivity$shareListener$1$onSuccess$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
