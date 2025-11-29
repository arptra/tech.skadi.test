package com.upuphone.ar.translation.iflytek;

import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.iflytek.IFlyAsrHelper;
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
import okhttp3.WebSocket;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.iflytek.IFlyAsrHelper$sendRemoteAudioData$1", f = "IFlyAsrHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class IFlyAsrHelper$sendRemoteAudioData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $data;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ IFlyAsrHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IFlyAsrHelper$sendRemoteAudioData$1(IFlyAsrHelper iFlyAsrHelper, byte[] bArr, Continuation<? super IFlyAsrHelper$sendRemoteAudioData$1> continuation) {
        super(2, continuation);
        this.this$0 = iFlyAsrHelper;
        this.$data = bArr;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IFlyAsrHelper$sendRemoteAudioData$1 iFlyAsrHelper$sendRemoteAudioData$1 = new IFlyAsrHelper$sendRemoteAudioData$1(this.this$0, this.$data, continuation);
        iFlyAsrHelper$sendRemoteAudioData$1.L$0 = obj;
        return iFlyAsrHelper$sendRemoteAudioData$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Unit unit;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            if (this.this$0.c == 1 || this.this$0.c == 2) {
                WebSocket p = this.this$0.d;
                if (p != null) {
                    IFlyAsrHelper iFlyAsrHelper = this.this$0;
                    byte[] bArr = this.$data;
                    IFlyAsrHelper.WebSocketState q = iFlyAsrHelper.g;
                    if (q == null || !q.c()) {
                        LogExt.e("sendRemoteAudioData 当前WebSocket传输数据通道未连接无法发送数据", "IFlyAsrHelper", "sendRemoteDataNotStarted", 50);
                    } else {
                        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                        if (p.send(ByteString.Companion.of(copyOf, 0, copyOf.length))) {
                            iFlyAsrHelper.h = true;
                        } else {
                            LogExt.h("sendRemoteAudioData 发送远端数据给讯飞服务器异常", "IFlyAsrHelper");
                        }
                    }
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    LogExt.e("sendRemoteAudioData websocket is null", "IFlyAsrHelper", "sendRemoteAudioData", 50);
                }
                return Unit.INSTANCE;
            }
            LogExt.j("sendRemoteAudioData 发送远端音频消息异常", "IFlyAsrHelper");
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((IFlyAsrHelper$sendRemoteAudioData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
