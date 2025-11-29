package com.upuphone.xr.sapp.fragment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.HearingAssistFragment$updateGptStatus$1", f = "HearingAssistFragment.kt", i = {1}, l = {428, 432}, m = "invokeSuspend", n = {"isChatGptTTSPlay"}, s = {"Z$0"})
public final class HearingAssistFragment$updateGptStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    boolean Z$0;
    int label;
    final /* synthetic */ HearingAssistFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HearingAssistFragment$updateGptStatus$1(HearingAssistFragment hearingAssistFragment, Continuation<? super HearingAssistFragment$updateGptStatus$1> continuation) {
        super(2, continuation);
        this.this$0 = hearingAssistFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new HearingAssistFragment$updateGptStatus$1(this.this$0, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008d  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 2
            r3 = 0
            java.lang.String r4 = "binding"
            r5 = 1
            if (r1 == 0) goto L_0x0023
            if (r1 == r5) goto L_0x001f
            if (r1 != r2) goto L_0x0017
            boolean r0 = r7.Z$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0069
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
            r7.label = r5
            java.lang.Object r8 = r8.l(r1, r7)
            if (r8 != r0) goto L_0x0037
            return r0
        L_0x0037:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            com.upuphone.xr.sapp.fragment.HearingAssistFragment r1 = r7.this$0
            com.upuphone.xr.sapp.databinding.FragmentHearingAssistBinding r1 = r1.j
            if (r1 != 0) goto L_0x0049
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r1 = r3
        L_0x0049:
            com.upuphone.xr.sapp.view.CardItemView r1 = r1.c
            com.upuphone.xr.sapp.databinding.CardItemLayoutBinding r1 = r1.getBinding()
            com.meizu.common.widget.Switch r1 = r1.i
            r1.setChecked(r8)
            com.xjsd.ai.assistant.common.data.DataStoreUtils r1 = com.xjsd.ai.assistant.common.data.DataStoreUtils.f8415a
            com.upuphone.xr.sapp.fragment.HearingAssistFragment r6 = r7.this$0
            android.content.Context r6 = r6.m0()
            r7.Z$0 = r8
            r7.label = r2
            java.lang.Object r1 = r1.k(r6, r7)
            if (r1 != r0) goto L_0x0067
            return r0
        L_0x0067:
            r0 = r8
            r8 = r1
        L_0x0069:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            com.upuphone.xr.sapp.fragment.HearingAssistFragment r1 = r7.this$0
            com.upuphone.xr.sapp.databinding.FragmentHearingAssistBinding r1 = r1.j
            if (r1 != 0) goto L_0x007b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r1 = r3
        L_0x007b:
            com.upuphone.xr.sapp.view.CardItemView r1 = r1.d
            com.upuphone.xr.sapp.databinding.CardItemLayoutBinding r1 = r1.getBinding()
            com.meizu.common.widget.Switch r1 = r1.i
            r1.setChecked(r8)
            com.upuphone.xr.sapp.fragment.HearingAssistFragment r1 = r7.this$0
            r1.d1(r0, r8)
            if (r8 != 0) goto L_0x00a5
            com.upuphone.xr.sapp.fragment.HearingAssistFragment r7 = r7.this$0
            com.upuphone.xr.sapp.databinding.FragmentHearingAssistBinding r7 = r7.j
            if (r7 != 0) goto L_0x0099
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            goto L_0x009a
        L_0x0099:
            r3 = r7
        L_0x009a:
            com.upuphone.xr.sapp.view.CardItemView r7 = r3.c
            com.upuphone.xr.sapp.databinding.CardItemLayoutBinding r7 = r7.getBinding()
            com.meizu.common.widget.Switch r7 = r7.i
            r7.setChecked(r5)
        L_0x00a5:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.fragment.HearingAssistFragment$updateGptStatus$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((HearingAssistFragment$updateGptStatus$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
