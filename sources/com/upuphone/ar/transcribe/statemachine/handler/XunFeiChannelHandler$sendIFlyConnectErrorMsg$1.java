package com.upuphone.ar.transcribe.statemachine.handler;

import android.content.Context;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.utils.NetworkUtils;
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
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.transcribe.statemachine.handler.XunFeiChannelHandler$sendIFlyConnectErrorMsg$1", f = "XunFeiChannelHandler.kt", i = {}, l = {191}, m = "invokeSuspend", n = {}, s = {})
public final class XunFeiChannelHandler$sendIFlyConnectErrorMsg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ XunFeiChannelHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public XunFeiChannelHandler$sendIFlyConnectErrorMsg$1(XunFeiChannelHandler xunFeiChannelHandler, Continuation<? super XunFeiChannelHandler$sendIFlyConnectErrorMsg$1> continuation) {
        super(2, continuation);
        this.this$0 = xunFeiChannelHandler;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new XunFeiChannelHandler$sendIFlyConnectErrorMsg$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.b(100, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NetworkUtils networkUtils = NetworkUtils.f6189a;
        Context b = this.this$0.b;
        final XunFeiChannelHandler xunFeiChannelHandler = this.this$0;
        networkUtils.b(b, new Function1<Boolean, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                int i = z ? 0 : -1;
                LogExt.d("sendIFlyConnectErrorMsg: netCode=" + i, "XunFeiChannelHandler");
                xunFeiChannelHandler.f6165a.y(i);
            }
        });
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((XunFeiChannelHandler$sendIFlyConnectErrorMsg$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
