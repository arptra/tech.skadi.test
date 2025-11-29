package com.upuphone.xr.sapp.fragment;

import android.view.View;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.databinding.FragmentHearingAssistBinding;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.xjsd.ai.assistant.phone.helper.AssistantSettingUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.HearingAssistFragment$initGptBroadcastResponse$1", f = "HearingAssistFragment.kt", i = {}, l = {300, 321}, m = "invokeSuspend", n = {}, s = {})
public final class HearingAssistFragment$initGptBroadcastResponse$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HearingAssistFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HearingAssistFragment$initGptBroadcastResponse$1(HearingAssistFragment hearingAssistFragment, Continuation<? super HearingAssistFragment$initGptBroadcastResponse$1> continuation) {
        super(2, continuation);
        this.this$0 = hearingAssistFragment;
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(HearingAssistFragment hearingAssistFragment, View view) {
        FragmentHearingAssistBinding G0 = hearingAssistFragment.j;
        FragmentHearingAssistBinding fragmentHearingAssistBinding = null;
        if (G0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            G0 = null;
        }
        boolean isChecked = G0.c.getBinding().i.isChecked();
        FragmentHearingAssistBinding G02 = hearingAssistFragment.j;
        if (G02 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentHearingAssistBinding = G02;
        }
        fragmentHearingAssistBinding.c.getBinding().i.setChecked(!isChecked);
        AssistantSettingUtils.b.c(hearingAssistFragment.m0(), "chat_gpt_tts_play", !isChecked);
        DataStoreUtils.e.a().p("hearing_assist_gpt_tts_status", Boolean.valueOf(!isChecked), true);
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$1(HearingAssistFragment hearingAssistFragment, View view) {
        FragmentHearingAssistBinding G0 = hearingAssistFragment.j;
        FragmentHearingAssistBinding fragmentHearingAssistBinding = null;
        if (G0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            G0 = null;
        }
        boolean isChecked = G0.d.getBinding().i.isChecked();
        FragmentHearingAssistBinding G02 = hearingAssistFragment.j;
        if (G02 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            G02 = null;
        }
        G02.d.getBinding().i.setChecked(!isChecked);
        ULog.Delegate delegate = ULog.f6446a;
        StringBuilder sb = new StringBuilder();
        sb.append("initGptBroadcastResponse setOnClickListener -> !checked=");
        sb.append(!isChecked);
        delegate.a("HearingAssistFragment", sb.toString());
        AssistantSettingUtils.b.c(hearingAssistFragment.m0(), "chat_gpt_card_display", !isChecked);
        FragmentHearingAssistBinding G03 = hearingAssistFragment.j;
        if (G03 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentHearingAssistBinding = G03;
        }
        hearingAssistFragment.d1(fragmentHearingAssistBinding.c.getBinding().i.isChecked(), !isChecked);
        DataStoreUtils.e.a().p("hearing_assist_gpt_card_status", Boolean.valueOf(!isChecked), true);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new HearingAssistFragment$initGptBroadcastResponse$1(this.this$0, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d4  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 0
            r3 = 2
            r4 = 1
            r5 = 0
            java.lang.String r6 = "binding"
            if (r1 == 0) goto L_0x0023
            if (r1 == r4) goto L_0x001f
            if (r1 != r3) goto L_0x0017
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0094
        L_0x0017:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x001f:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0037
        L_0x0023:
            kotlin.ResultKt.throwOnFailure(r8)
            com.xjsd.ai.assistant.common.data.DataStoreUtils r8 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a
            com.upuphone.xr.sapp.fragment.HearingAssistFragment r1 = r7.this$0
            android.content.Context r1 = r1.m0()
            r7.label = r4
            java.lang.Object r8 = r8.l(r1, r7)
            if (r8 != r0) goto L_0x0037
            return r0
        L_0x0037:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            com.upuphone.xr.sapp.fragment.HearingAssistFragment r1 = r7.this$0
            com.upuphone.xr.sapp.databinding.FragmentHearingAssistBinding r1 = r1.j
            if (r1 != 0) goto L_0x0049
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r1 = r5
        L_0x0049:
            com.upuphone.xr.sapp.view.CardItemView r1 = r1.c
            com.upuphone.xr.sapp.databinding.CardItemLayoutBinding r1 = r1.getBinding()
            com.meizu.common.widget.Switch r1 = r1.i
            r1.setChecked(r8)
            com.upuphone.xr.sapp.fragment.HearingAssistFragment r8 = r7.this$0
            com.upuphone.xr.sapp.databinding.FragmentHearingAssistBinding r8 = r8.j
            if (r8 != 0) goto L_0x0060
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r8 = r5
        L_0x0060:
            com.upuphone.xr.sapp.view.CardItemView r8 = r8.c
            com.upuphone.xr.sapp.databinding.CardItemLayoutBinding r8 = r8.getBinding()
            com.meizu.common.widget.Switch r8 = r8.i
            r8.setClickable(r2)
            com.upuphone.xr.sapp.fragment.HearingAssistFragment r8 = r7.this$0
            com.upuphone.xr.sapp.databinding.FragmentHearingAssistBinding r8 = r8.j
            if (r8 != 0) goto L_0x0077
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r8 = r5
        L_0x0077:
            com.upuphone.xr.sapp.view.CardItemView r8 = r8.c
            com.upuphone.xr.sapp.fragment.HearingAssistFragment r1 = r7.this$0
            com.upuphone.xr.sapp.fragment.c r4 = new com.upuphone.xr.sapp.fragment.c
            r4.<init>(r1)
            r8.setOnClickListener(r4)
            com.xjsd.ai.assistant.common.data.DataStoreUtils r8 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a
            com.upuphone.xr.sapp.fragment.HearingAssistFragment r1 = r7.this$0
            android.content.Context r1 = r1.m0()
            r7.label = r3
            java.lang.Object r8 = r8.k(r1, r7)
            if (r8 != r0) goto L_0x0094
            return r0
        L_0x0094:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            com.upuphone.xr.sapp.fragment.HearingAssistFragment r0 = r7.this$0
            com.upuphone.xr.sapp.databinding.FragmentHearingAssistBinding r0 = r0.j
            if (r0 != 0) goto L_0x00a6
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r0 = r5
        L_0x00a6:
            com.upuphone.xr.sapp.view.CardItemView r0 = r0.d
            com.upuphone.xr.sapp.databinding.CardItemLayoutBinding r0 = r0.getBinding()
            com.meizu.common.widget.Switch r0 = r0.i
            r0.setChecked(r8)
            com.upuphone.xr.sapp.fragment.HearingAssistFragment r8 = r7.this$0
            com.upuphone.xr.sapp.databinding.FragmentHearingAssistBinding r8 = r8.j
            if (r8 != 0) goto L_0x00bd
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r8 = r5
        L_0x00bd:
            com.upuphone.xr.sapp.view.CardItemView r8 = r8.d
            com.upuphone.xr.sapp.databinding.CardItemLayoutBinding r8 = r8.getBinding()
            com.meizu.common.widget.Switch r8 = r8.i
            r8.setClickable(r2)
            com.upuphone.xr.sapp.fragment.HearingAssistFragment r8 = r7.this$0
            com.upuphone.xr.sapp.databinding.FragmentHearingAssistBinding r8 = r8.j
            if (r8 != 0) goto L_0x00d4
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            goto L_0x00d5
        L_0x00d4:
            r5 = r8
        L_0x00d5:
            com.upuphone.xr.sapp.view.CardItemView r8 = r5.d
            com.upuphone.xr.sapp.fragment.HearingAssistFragment r7 = r7.this$0
            com.upuphone.xr.sapp.fragment.d r0 = new com.upuphone.xr.sapp.fragment.d
            r0.<init>(r7)
            r8.setOnClickListener(r0)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.fragment.HearingAssistFragment$initGptBroadcastResponse$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((HearingAssistFragment$initGptBroadcastResponse$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
