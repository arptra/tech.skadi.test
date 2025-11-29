package com.xjsd.ai.assistant.chatgpt.model;

import com.upuphone.xr.interconnect.entity.AccountInfo;
import com.xjsd.ai.assistant.chatgpt.util.AccountUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/upuphone/xr/interconnect/entity/AccountInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.chatgpt.model.DeviceRequestAssembler$accountUserInfo$1", f = "DeviceRequestAssembler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DeviceRequestAssembler$accountUserInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AccountInfo>, Object> {
    int label;

    public DeviceRequestAssembler$accountUserInfo$1(Continuation<? super DeviceRequestAssembler$accountUserInfo$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DeviceRequestAssembler$accountUserInfo$1(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return AccountUtil.f8401a.c();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super AccountInfo> continuation) {
        return ((DeviceRequestAssembler$accountUserInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
