package com.upuphone.ar.translation.phone.vm;

import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.utils.PreferencesUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.vm.TranslatorMainViewModel$triggerShowNotRoleVprintTip$1$isShowNotRoleVpTip$1", f = "TranslatorMainViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TranslatorMainViewModel$triggerShowNotRoleVprintTip$1$isShowNotRoleVpTip$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;

    public TranslatorMainViewModel$triggerShowNotRoleVprintTip$1$isShowNotRoleVpTip$1(Continuation<? super TranslatorMainViewModel$triggerShowNotRoleVprintTip$1$isShowNotRoleVpTip$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TranslatorMainViewModel$triggerShowNotRoleVprintTip$1$isShowNotRoleVpTip$1(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            float[] roleVprint = TranslatorConstants.getRoleVprint();
            boolean e = PreferencesUtils.e();
            boolean z = false;
            if (!(roleVprint.length == 0)) {
                PreferencesUtils.q(false);
            }
            if (e && roleVprint.length == 0) {
                z = true;
            }
            return Boxing.boxBoolean(z);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((TranslatorMainViewModel$triggerShowNotRoleVprintTip$1$isShowNotRoleVpTip$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
