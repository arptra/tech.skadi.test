package com.xjsd.ai.assistant.flutter;

import com.xjsd.ai.assistant.core.util.DotUtil;
import com.xjsd.ai.assistant.flutter.AndroidAssistantApi;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.flutter.AndroidAssistantApiHandler$connectCloud$1", f = "AndroidAssistantApiHandler.kt", i = {}, l = {208}, m = "invokeSuspend", n = {}, s = {})
public final class AndroidAssistantApiHandler$connectCloud$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $convertSessionId;
    final /* synthetic */ AndroidAssistantApi.Result<Boolean> $result;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidAssistantApiHandler$connectCloud$1(String str, AndroidAssistantApi.Result<Boolean> result, Continuation<? super AndroidAssistantApiHandler$connectCloud$1> continuation) {
        super(2, continuation);
        this.$convertSessionId = str;
        this.$result = result;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AndroidAssistantApiHandler$connectCloud$1(this.$convertSessionId, this.$result, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AndroidAssistantApiHandler androidAssistantApiHandler = AndroidAssistantApiHandler.INSTANCE;
            this.label = 1;
            obj = androidAssistantApiHandler.connectServer(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        DotUtil.a("flutter_ws_connect", "连接耗时", TuplesKt.to(AssistantConstants.Key.SESSION_ID, this.$convertSessionId), TuplesKt.to("connectCode", Boxing.boxInt(AndroidAssistantApiHandler.INSTANCE.getCloudErrorCode())));
        this.$result.success(Boxing.boxBoolean(booleanValue));
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AndroidAssistantApiHandler$connectCloud$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
