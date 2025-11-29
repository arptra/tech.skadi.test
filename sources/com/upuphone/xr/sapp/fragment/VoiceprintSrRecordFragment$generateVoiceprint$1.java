package com.upuphone.xr.sapp.fragment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nVoiceprintSrRecordFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoiceprintSrRecordFragment.kt\ncom/upuphone/xr/sapp/fragment/VoiceprintSrRecordFragment$generateVoiceprint$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,598:1\n256#2,2:599\n256#2,2:601\n256#2,2:603\n256#2,2:605\n*S KotlinDebug\n*F\n+ 1 VoiceprintSrRecordFragment.kt\ncom/upuphone/xr/sapp/fragment/VoiceprintSrRecordFragment$generateVoiceprint$1\n*L\n469#1:599,2\n480#1:601,2\n482#1:603,2\n486#1:605,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.VoiceprintSrRecordFragment$generateVoiceprint$1", f = "VoiceprintSrRecordFragment.kt", i = {0, 1}, l = {456, 482}, m = "invokeSuspend", n = {"dialog", "dialog"}, s = {"L$1", "L$0"})
public final class VoiceprintSrRecordFragment$generateVoiceprint$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ VoiceprintSrRecordFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoiceprintSrRecordFragment$generateVoiceprint$1(VoiceprintSrRecordFragment voiceprintSrRecordFragment, Continuation<? super VoiceprintSrRecordFragment$generateVoiceprint$1> continuation) {
        super(2, continuation);
        this.this$0 = voiceprintSrRecordFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VoiceprintSrRecordFragment$generateVoiceprint$1(this.this$0, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0150  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r14.label
            r2 = 8
            r3 = 2
            r4 = 0
            r5 = 1
            r6 = 0
            if (r1 == 0) goto L_0x0033
            if (r1 == r5) goto L_0x0027
            if (r1 != r3) goto L_0x001f
            java.lang.Object r0 = r14.L$1
            android.view.View r0 = (android.view.View) r0
            java.lang.Object r14 = r14.L$0
            com.meizu.common.app.LoadingDialog r14 = (com.meizu.common.app.LoadingDialog) r14
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0148
        L_0x001f:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x0027:
            java.lang.Object r1 = r14.L$1
            com.meizu.common.app.LoadingDialog r1 = (com.meizu.common.app.LoadingDialog) r1
            java.lang.Object r7 = r14.L$0
            com.upuphone.xr.sapp.fragment.VoiceprintSrRecordFragment r7 = (com.upuphone.xr.sapp.fragment.VoiceprintSrRecordFragment) r7
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x006d
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r15)
            com.upuphone.xr.sapp.fragment.VoiceprintSrRecordFragment r15 = r14.this$0
            androidx.fragment.app.FragmentActivity r15 = r15.getActivity()
            if (r15 == 0) goto L_0x0182
            com.upuphone.xr.sapp.fragment.VoiceprintSrRecordFragment r7 = r14.this$0
            com.meizu.common.app.LoadingDialog r1 = new com.meizu.common.app.LoadingDialog
            r1.<init>(r15)
            int r15 = com.upuphone.xr.sapp.R.string.vp_separate_role_generate_wait_tip
            r1.setMessage((int) r15)
            int r15 = com.upuphone.xr.sapp.R.color.vp_separate_role_generate_wait_tip
            r1.setMessageTextColorResource(r15)
            int r15 = com.upuphone.xr.sapp.R.drawable.vp_separate_role_generate_wait_bg
            r1.setBackgroundDrawableResource(r15)
            r1.show()
            kotlinx.coroutines.CoroutineDispatcher r15 = kotlinx.coroutines.Dispatchers.b()
            com.upuphone.xr.sapp.fragment.VoiceprintSrRecordFragment$generateVoiceprint$1$1$vpSrFloatArr$1 r8 = new com.upuphone.xr.sapp.fragment.VoiceprintSrRecordFragment$generateVoiceprint$1$1$vpSrFloatArr$1
            r8.<init>(r7, r6)
            r14.L$0 = r7
            r14.L$1 = r1
            r14.label = r5
            java.lang.Object r15 = kotlinx.coroutines.BuildersKt.g(r15, r8, r14)
            if (r15 != r0) goto L_0x006d
            return r0
        L_0x006d:
            float[] r15 = (float[]) r15
            com.upuphone.xr.sapp.vm.RoleVprintViewModel r8 = r7.e1()
            androidx.lifecycle.LiveData r8 = r8.I()
            java.lang.Object r8 = r8.getValue()
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            if (r8 != 0) goto L_0x0083
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
        L_0x0083:
            boolean r8 = r8.booleanValue()
            java.lang.String r9 = java.util.Arrays.toString(r15)
            java.lang.String r10 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "generateVoiceprint roleVprintSuccess="
            r11.append(r12)
            r11.append(r8)
            java.lang.String r12 = ", vpSrFloatArr="
            r11.append(r12)
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            r7.m1(r9)
            com.upuphone.xr.sapp.databinding.FragmentVoiceprintSepatateRoleRecordBinding r9 = r7.k
            java.lang.String r11 = "mBinding"
            if (r9 != 0) goto L_0x00b9
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)
            r9 = r6
        L_0x00b9:
            com.upuphone.xr.sapp.view.SappTitleBar r9 = r9.e
            int r12 = com.upuphone.xr.sapp.R.string.word_exit
            java.lang.String r12 = r7.getString(r12)
            java.lang.String r13 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r13)
            r9.setBackText(r12)
            com.upuphone.xr.sapp.databinding.FragmentVoiceprintSepatateRoleRecordBinding r9 = r7.k
            if (r9 != 0) goto L_0x00d3
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)
            r9 = r6
        L_0x00d3:
            com.upuphone.xr.sapp.databinding.FragmentVoiceprintSrRecordingBinding r9 = r9.b
            androidx.constraintlayout.widget.ConstraintLayout r9 = r9.getRoot()
            java.lang.String r12 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r12)
            r9.setVisibility(r2)
            int r9 = r15.length
            if (r9 != 0) goto L_0x00e6
            r9 = r5
            goto L_0x00e7
        L_0x00e6:
            r9 = r4
        L_0x00e7:
            r9 = r9 ^ r5
            if (r9 == 0) goto L_0x0156
            if (r8 == 0) goto L_0x0156
            java.util.UUID r8 = java.util.UUID.randomUUID()
            java.lang.String r8 = r8.toString()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r10)
            com.upuphone.xr.sapp.utils.ControlUtils r9 = com.upuphone.xr.sapp.utils.ControlUtils.f7858a
            r9.s0(r15, r8)
            com.upuphone.xr.sapp.vm.RoleVprintViewModel r15 = r7.e1()
            r15.b0(r8)
            r9.r0(r5)
            com.upuphone.xr.sapp.databinding.FragmentVoiceprintSepatateRoleRecordBinding r15 = r7.k
            if (r15 != 0) goto L_0x0110
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)
            r15 = r6
        L_0x0110:
            com.upuphone.xr.sapp.databinding.FragmentVoiceprintSrRecordingCompletedBinding r15 = r15.c
            androidx.constraintlayout.widget.ConstraintLayout r15 = r15.getRoot()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r12)
            r15.setVisibility(r4)
            com.upuphone.xr.sapp.databinding.FragmentVoiceprintSepatateRoleRecordBinding r15 = r7.k
            if (r15 != 0) goto L_0x0126
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)
            r15 = r6
        L_0x0126:
            com.upuphone.xr.sapp.databinding.FragmentVoiceprintSrRecordingCompletedBinding r15 = r15.c
            com.meizu.common.widget.MzButton r15 = r15.d
            java.lang.String r5 = "mbtWake"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r5)
            kotlinx.coroutines.CoroutineDispatcher r5 = kotlinx.coroutines.Dispatchers.b()
            com.upuphone.xr.sapp.fragment.VoiceprintSrRecordFragment$generateVoiceprint$1$1$1 r7 = new com.upuphone.xr.sapp.fragment.VoiceprintSrRecordFragment$generateVoiceprint$1$1$1
            r7.<init>(r6)
            r14.L$0 = r1
            r14.L$1 = r15
            r14.label = r3
            java.lang.Object r14 = kotlinx.coroutines.BuildersKt.g(r5, r7, r14)
            if (r14 != r0) goto L_0x0145
            return r0
        L_0x0145:
            r0 = r15
            r15 = r14
            r14 = r1
        L_0x0148:
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L_0x0151
            r2 = r4
        L_0x0151:
            r0.setVisibility(r2)
            r1 = r14
            goto L_0x017f
        L_0x0156:
            com.upuphone.xr.sapp.databinding.FragmentVoiceprintSepatateRoleRecordBinding r14 = r7.k
            if (r14 != 0) goto L_0x0160
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)
            goto L_0x0161
        L_0x0160:
            r6 = r14
        L_0x0161:
            com.upuphone.xr.sapp.databinding.FragmentVoiceprintSrRecordingFailedBinding r14 = r6.d
            androidx.constraintlayout.widget.ConstraintLayout r14 = r14.getRoot()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r12)
            r14.setVisibility(r4)
            com.upuphone.xr.sapp.vm.RoleVprintViewModel r14 = r7.e1()
            com.upuphone.xr.sapp.vm.RoleVprintViewModel r15 = r7.e1()
            boolean r15 = r15.R()
            if (r15 == 0) goto L_0x017c
            r3 = 3
        L_0x017c:
            r14.a0(r3)
        L_0x017f:
            r1.dismiss()
        L_0x0182:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.fragment.VoiceprintSrRecordFragment$generateVoiceprint$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VoiceprintSrRecordFragment$generateVoiceprint$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
