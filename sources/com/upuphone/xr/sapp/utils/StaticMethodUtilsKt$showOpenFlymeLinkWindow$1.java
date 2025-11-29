package com.upuphone.xr.sapp.utils;

import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.asm.Opcodes;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.utils.GenericWindowResult;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.utils.StaticMethodUtilsKt$showOpenFlymeLinkWindow$1", f = "StaticMethodUtils.kt", i = {}, l = {856}, m = "invokeSuspend", n = {}, s = {})
public final class StaticMethodUtilsKt$showOpenFlymeLinkWindow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $this_showOpenFlymeLinkWindow;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StaticMethodUtilsKt$showOpenFlymeLinkWindow$1(FragmentActivity fragmentActivity, Continuation<? super StaticMethodUtilsKt$showOpenFlymeLinkWindow$1> continuation) {
        super(2, continuation);
        this.$this_showOpenFlymeLinkWindow = fragmentActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new StaticMethodUtilsKt$showOpenFlymeLinkWindow$1(this.$this_showOpenFlymeLinkWindow, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ULog.f6446a.a("MainApplication", "showOpenFlymeLinkWindow, start");
            FragmentActivity fragmentActivity = this.$this_showOpenFlymeLinkWindow;
            this.label = 1;
            obj = GenericWindowExtKt.b(fragmentActivity, Opcodes.PUTFIELD, (Object) null, false, false, this, 14, (Object) null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        GenericWindowResult.ButtonAction buttonAction = (GenericWindowResult.ButtonAction) obj;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("MainApplication", "showOpenFlymeLinkWindow, buttonAction: " + buttonAction);
        if (buttonAction.getActionType() != 1101) {
            return Unit.INSTANCE;
        }
        StaticMethodUtilsKt.L(this.$this_showOpenFlymeLinkWindow);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((StaticMethodUtilsKt$showOpenFlymeLinkWindow$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
