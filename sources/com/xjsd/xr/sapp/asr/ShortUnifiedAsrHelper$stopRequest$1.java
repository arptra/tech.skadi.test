package com.xjsd.xr.sapp.asr;

import com.xjsd.xr.sapp.asr.ShortUnifiedAsrHelper;
import com.xjsd.xr.sapp.asr.utils.UlogExtKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.xr.sapp.asr.ShortUnifiedAsrHelper$stopRequest$1", f = "ShortUnifiedAsrHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ShortUnifiedAsrHelper$stopRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ShortUnifiedAsrHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShortUnifiedAsrHelper$stopRequest$1(ShortUnifiedAsrHelper shortUnifiedAsrHelper, Continuation<? super ShortUnifiedAsrHelper$stopRequest$1> continuation) {
        super(2, continuation);
        this.this$0 = shortUnifiedAsrHelper;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ShortUnifiedAsrHelper$stopRequest$1 shortUnifiedAsrHelper$stopRequest$1 = new ShortUnifiedAsrHelper$stopRequest$1(this.this$0, continuation);
        shortUnifiedAsrHelper$stopRequest$1.L$0 = obj;
        return shortUnifiedAsrHelper$stopRequest$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Unit unit;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ShortUnifiedAsrHelper.AsrWebSocket access$getMWebSocket$p = this.this$0.mWebSocket;
            if (access$getMWebSocket$p != null) {
                ShortUnifiedAsrHelper shortUnifiedAsrHelper = this.this$0;
                UlogExtKt.logI("stopRequest 关闭websocket通道", "ShortUnifiedAsrHelper");
                shortUnifiedAsrHelper.mWebSocket = null;
                shortUnifiedAsrHelper.mAsrRequest = null;
                CoroutineScopeKt.e(shortUnifiedAsrHelper.mFeedCoroutine, (CancellationException) null, 1, (Object) null);
                access$getMWebSocket$p.disconnect();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                UlogExtKt.logE$default("stopRequest websocket is null", "ShortUnifiedAsrHelper", (Throwable) null, 2, (Object) null);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ShortUnifiedAsrHelper$stopRequest$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
