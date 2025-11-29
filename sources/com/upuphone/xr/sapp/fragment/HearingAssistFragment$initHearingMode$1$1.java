package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import com.upuphone.xr.sapp.databinding.FragmentHearingAssistBinding;
import com.xjsd.ai.assistant.common.data.DataStoreUtils;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.HearingAssistFragment$initHearingMode$1$1", f = "HearingAssistFragment.kt", i = {}, l = {250}, m = "invokeSuspend", n = {}, s = {})
public final class HearingAssistFragment$initHearingMode$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HearingAssistFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HearingAssistFragment$initHearingMode$1$1(HearingAssistFragment hearingAssistFragment, Continuation<? super HearingAssistFragment$initHearingMode$1$1> continuation) {
        super(2, continuation);
        this.this$0 = hearingAssistFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new HearingAssistFragment$initHearingMode$1$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DataStoreUtils dataStoreUtils = DataStoreUtils.f8415a;
            Context m0 = this.this$0.m0();
            this.label = 1;
            obj = dataStoreUtils.k(m0, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        FragmentHearingAssistBinding G0 = this.this$0.j;
        FragmentHearingAssistBinding fragmentHearingAssistBinding = null;
        if (G0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            G0 = null;
        }
        G0.d.getBinding().i.setChecked(booleanValue);
        HearingAssistFragment hearingAssistFragment = this.this$0;
        FragmentHearingAssistBinding G02 = hearingAssistFragment.j;
        if (G02 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            G02 = null;
        }
        hearingAssistFragment.d1(G02.e.getBinding().i.isChecked(), booleanValue);
        if (!booleanValue) {
            FragmentHearingAssistBinding G03 = this.this$0.j;
            if (G03 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentHearingAssistBinding = G03;
            }
            fragmentHearingAssistBinding.c.getBinding().i.setChecked(true);
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((HearingAssistFragment$initHearingMode$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
