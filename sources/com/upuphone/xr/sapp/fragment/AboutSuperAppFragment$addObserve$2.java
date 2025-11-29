package com.upuphone.xr.sapp.fragment;

import com.upuphone.star.httplib.HttpResult;
import com.upuphone.xr.sapp.utils.AppUpdateHelper;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.AboutSuperAppFragment$addObserve$2", f = "AboutSuperAppFragment.kt", i = {}, l = {240}, m = "invokeSuspend", n = {}, s = {})
public final class AboutSuperAppFragment$addObserve$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AboutSuperAppFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AboutSuperAppFragment$addObserve$2(AboutSuperAppFragment aboutSuperAppFragment, Continuation<? super AboutSuperAppFragment$addObserve$2> continuation) {
        super(2, continuation);
        this.this$0 = aboutSuperAppFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AboutSuperAppFragment$addObserve$2(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SharedFlow z = AppUpdateHelper.f7841a.z();
            final AboutSuperAppFragment aboutSuperAppFragment = this.this$0;
            AnonymousClass1 r1 = new FlowCollector() {
                /* renamed from: d */
                public final Object emit(HttpResult httpResult, Continuation continuation) {
                    aboutSuperAppFragment.Q0(httpResult);
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (z.collect(r1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AboutSuperAppFragment$addObserve$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
