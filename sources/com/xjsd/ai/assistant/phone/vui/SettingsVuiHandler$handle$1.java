package com.xjsd.ai.assistant.phone.vui;

import android.content.Context;
import com.xjsd.ai.assistant.common.data.DataStoreUtils;
import com.xjsd.ai.assistant.phone.helper.AssistantSettingUtils;
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
@DebugMetadata(c = "com.xjsd.ai.assistant.phone.vui.SettingsVuiHandler$handle$1", f = "SettingsVuiHandler.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
public final class SettingsVuiHandler$handle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SettingsVuiHandler$handle$1(Context context, Continuation<? super SettingsVuiHandler$handle$1> continuation) {
        super(2, continuation);
        this.$context = context;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SettingsVuiHandler$handle$1(this.$context, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DataStoreUtils dataStoreUtils = DataStoreUtils.f8415a;
            Context context = this.$context;
            Intrinsics.checkNotNullExpressionValue(context, "$context");
            this.label = 1;
            obj = dataStoreUtils.i(context, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int intValue = ((Number) obj).intValue();
        AssistantSettingUtils.b.d(this.$context, intValue == 4 ? 0 : intValue + 1);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SettingsVuiHandler$handle$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
