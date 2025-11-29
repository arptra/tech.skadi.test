package com.xjsd.ai.assistant.phone.helper;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.PreferencesKt;
import com.xjsd.ai.assistant.common.data.DataStoreUtilsKt;
import com.xjsd.ai.assistant.core.ContextHelper;
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
@DebugMetadata(c = "com.xjsd.ai.assistant.phone.helper.AssistantSettingsHelper$storeOriginSettings$1", f = "AssistantSettingsHelper.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, s = {})
public final class AssistantSettingsHelper$storeOriginSettings$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $value;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AssistantSettingsHelper$storeOriginSettings$1(int i, Continuation<? super AssistantSettingsHelper$storeOriginSettings$1> continuation) {
        super(2, continuation);
        this.$value = i;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AssistantSettingsHelper$storeOriginSettings$1(this.$value, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String c = AssistantSettingsHelper.b;
            if (c != null) {
                int i2 = this.$value;
                Context a2 = ContextHelper.a();
                Intrinsics.checkNotNull(a2);
                DataStore a3 = DataStoreUtilsKt.a(a2);
                AssistantSettingsHelper$storeOriginSettings$1$1$1 assistantSettingsHelper$storeOriginSettings$1$1$1 = new AssistantSettingsHelper$storeOriginSettings$1$1$1(c, i2, (Continuation<? super AssistantSettingsHelper$storeOriginSettings$1$1$1>) null);
                this.label = 1;
                if (PreferencesKt.a(a3, assistantSettingsHelper$storeOriginSettings$1$1$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AssistantSettingsHelper$storeOriginSettings$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
