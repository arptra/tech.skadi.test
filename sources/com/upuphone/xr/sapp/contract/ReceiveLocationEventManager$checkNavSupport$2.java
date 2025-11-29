package com.upuphone.xr.sapp.contract;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.MainApplication;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.contract.ReceiveLocationEventManager$checkNavSupport$2", f = "ReceiveLocationEventManager.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
public final class ReceiveLocationEventManager$checkNavSupport$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $countryCode;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReceiveLocationEventManager$checkNavSupport$2(String str, Continuation<? super ReceiveLocationEventManager$checkNavSupport$2> continuation) {
        super(2, continuation);
        this.$countryCode = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ReceiveLocationEventManager$checkNavSupport$2(this.$countryCode, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher b = Dispatchers.b();
            ReceiveLocationEventManager$checkNavSupport$2$naviSupport$1 receiveLocationEventManager$checkNavSupport$2$naviSupport$1 = new ReceiveLocationEventManager$checkNavSupport$2$naviSupport$1(this.$countryCode, (Continuation<? super ReceiveLocationEventManager$checkNavSupport$2$naviSupport$1>) null);
            this.label = 1;
            obj = BuildersKt.g(b, receiveLocationEventManager$checkNavSupport$2$naviSupport$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        ReceiveLocationEventManager.f6703a.h(MainApplication.k.d(), booleanValue);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("ReceiveLocationEventManager", "checkNaviRegionSupport " + booleanValue);
        return Boxing.boxBoolean(booleanValue);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((ReceiveLocationEventManager$checkNavSupport$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
