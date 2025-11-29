package com.xjsd.xr.sapp.asr;

import com.xjsd.xr.sapp.asr.ShortUnifiedAsrHelper;
import com.xjsd.xr.sapp.asr.utils.UlogExtKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.xr.sapp.asr.ShortUnifiedAsrHelper$pushAudio$1", f = "ShortUnifiedAsrHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ShortUnifiedAsrHelper$pushAudio$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $bytes;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ShortUnifiedAsrHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShortUnifiedAsrHelper$pushAudio$1(ShortUnifiedAsrHelper shortUnifiedAsrHelper, byte[] bArr, Continuation<? super ShortUnifiedAsrHelper$pushAudio$1> continuation) {
        super(2, continuation);
        this.this$0 = shortUnifiedAsrHelper;
        this.$bytes = bArr;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ShortUnifiedAsrHelper$pushAudio$1 shortUnifiedAsrHelper$pushAudio$1 = new ShortUnifiedAsrHelper$pushAudio$1(this.this$0, this.$bytes, continuation);
        shortUnifiedAsrHelper$pushAudio$1.L$0 = obj;
        return shortUnifiedAsrHelper$pushAudio$1;
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
                byte[] bArr = this.$bytes;
                Intrinsics.checkNotNullExpressionValue(Arrays.copyOf(bArr, bArr.length), "copyOf(this, size)");
                byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
                access$getMWebSocket$p.sendData(copyOf);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                UlogExtKt.logReachCount$default("sendRemoteData websocket is null", "ShortUnifiedAsrHelper", "pushAudioNullSocket", 0, 4, (Object) null);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ShortUnifiedAsrHelper$pushAudio$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
