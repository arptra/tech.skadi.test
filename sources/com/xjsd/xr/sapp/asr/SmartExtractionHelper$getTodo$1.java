package com.xjsd.xr.sapp.asr;

import com.meizu.common.util.LunarCalendar;
import com.xjsd.ai.assistant.net.ws.protocol.EndToEndServiceData;
import com.xjsd.xr.sapp.asr.SmartExtractionHelper;
import com.xjsd.xr.sapp.asr.callback.ISmartExCallback;
import com.xjsd.xr.sapp.asr.dao.SmartExTodo;
import com.xjsd.xr.sapp.asr.dao.SmartExtractionConfig;
import com.xjsd.xr.sapp.asr.utils.UlogExtKt;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.xr.sapp.asr.SmartExtractionHelper$getTodo$1", f = "SmartExtractionHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SmartExtractionHelper$getTodo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SmartExtractionConfig $config;
    int label;
    final /* synthetic */ SmartExtractionHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmartExtractionHelper$getTodo$1(SmartExtractionConfig smartExtractionConfig, SmartExtractionHelper smartExtractionHelper, Continuation<? super SmartExtractionHelper$getTodo$1> continuation) {
        super(2, continuation);
        this.$config = smartExtractionConfig;
        this.this$0 = smartExtractionHelper;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SmartExtractionHelper$getTodo$1(this.$config, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            UlogExtKt.logI("getTodo config=" + this.$config, "SmartExtractionHelper");
            SmartExtractionHelper smartExtractionHelper = this.this$0;
            SmartExtractionHelper.TodoWebSocket todoWebSocket = new SmartExtractionHelper.TodoWebSocket();
            SmartExtractionHelper smartExtractionHelper2 = this.this$0;
            SmartExtractionConfig smartExtractionConfig = this.$config;
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
            String replace$default = StringsKt.replace$default(uuid, LunarCalendar.DATE_SEPARATOR, "", false, 4, (Object) null);
            UlogExtKt.logI("getTodo sessionId=" + replace$default, "SmartExtractionHelper");
            if (todoWebSocket.connect(replace$default)) {
                EndToEndServiceData endToEndServiceData = new EndToEndServiceData();
                endToEndServiceData.setType("todos");
                endToEndServiceData.setPayload(smartExtractionConfig);
                Unit unit = Unit.INSTANCE;
                todoWebSocket.sendMsg(replace$default, endToEndServiceData);
            } else {
                UlogExtKt.logI("getTodo connect error", "SmartExtractionHelper");
                ISmartExCallback access$getMSmartExCallback$p = smartExtractionHelper2.mSmartExCallback;
                if (access$getMSmartExCallback$p != null) {
                    access$getMSmartExCallback$p.onTodo((SmartExTodo) null);
                }
            }
            smartExtractionHelper.mTotoSocket = todoWebSocket;
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SmartExtractionHelper$getTodo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
