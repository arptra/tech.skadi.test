package com.upuphone.xr.sapp.fragment;

import com.upuphone.xr.sapp.entity.GlassFontSize;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.FontSizeFragment$showToggleHint$1", f = "FontSizeFragment.kt", i = {}, l = {155, 157}, m = "invokeSuspend", n = {}, s = {})
public final class FontSizeFragment$showToggleHint$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GlassFontSize $selectFont;
    int label;
    final /* synthetic */ FontSizeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FontSizeFragment$showToggleHint$1(FontSizeFragment fontSizeFragment, GlassFontSize glassFontSize, Continuation<? super FontSizeFragment$showToggleHint$1> continuation) {
        super(2, continuation);
        this.this$0 = fontSizeFragment;
        this.$selectFont = glassFontSize;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FontSizeFragment$showToggleHint$1(this.this$0, this.$selectFont, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x008c  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            java.lang.String r2 = "getPackageName(...)"
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0020
            if (r1 == r4) goto L_0x001c
            if (r1 != r3) goto L_0x0014
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0084
        L_0x0014:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x001c:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0067
        L_0x0020:
            kotlin.ResultKt.throwOnFailure(r7)
            com.upuphone.xr.sapp.utils.ControlUtils r7 = com.upuphone.xr.sapp.utils.ControlUtils.f7858a
            com.upuphone.xr.sapp.fragment.FontSizeFragment r1 = r6.this$0
            android.content.Context r1 = r1.m0()
            java.lang.String r1 = r1.getPackageName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            com.upuphone.xr.sapp.entity.GlassFontSize r5 = r6.$selectFont
            r7.T(r1, r5)
            com.upuphone.xr.sapp.utils.DataTrackUtil r7 = com.upuphone.xr.sapp.utils.DataTrackUtil.f7875a
            com.upuphone.xr.sapp.entity.GlassFontSize r1 = r6.$selectFont
            int r1 = r1.ordinal()
            int r1 = r1 + r4
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r5 = "status"
            kotlin.Pair r1 = kotlin.TuplesKt.to(r5, r1)
            kotlin.Pair[] r1 = new kotlin.Pair[]{r1}
            java.util.HashMap r1 = kotlin.collections.MapsKt.hashMapOf(r1)
            java.lang.String r5 = "anti_shake"
            r7.i(r5, r1)
            com.upuphone.xr.sapp.fragment.FontSizeFragment r7 = r6.this$0
            r7.showLoading()
            r6.label = r4
            r4 = 2000(0x7d0, double:9.88E-321)
            java.lang.Object r7 = kotlinx.coroutines.DelayKt.b(r4, r6)
            if (r7 != r0) goto L_0x0067
            return r0
        L_0x0067:
            com.upuphone.xr.sapp.utils.ControlUtils r7 = com.upuphone.xr.sapp.utils.ControlUtils.f7858a
            com.upuphone.xr.sapp.fragment.FontSizeFragment r1 = r6.this$0
            android.content.Context r1 = r1.m0()
            java.lang.String r1 = r1.getPackageName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r7.J(r1)
            r6.label = r3
            r1 = 10000(0x2710, double:4.9407E-320)
            java.lang.Object r7 = kotlinx.coroutines.DelayKt.b(r1, r6)
            if (r7 != r0) goto L_0x0084
            return r0
        L_0x0084:
            com.upuphone.xr.sapp.fragment.FontSizeFragment r7 = r6.this$0
            com.meizu.common.app.LoadingDialog r7 = r7.m
            if (r7 == 0) goto L_0x00b6
            com.upuphone.xr.sapp.fragment.FontSizeFragment r6 = r6.this$0
            boolean r7 = r7.isShowing()
            if (r7 == 0) goto L_0x00b6
            com.meizu.common.app.LoadingDialog r7 = r6.m
            if (r7 == 0) goto L_0x009d
            r7.dismiss()
        L_0x009d:
            com.upuphone.star.common.phone.UToast$Companion r7 = com.upuphone.star.common.phone.UToast.f6444a
            android.content.Context r0 = r6.requireContext()
            java.lang.String r1 = "requireContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            int r1 = com.upuphone.xr.sapp.R.string.switch_language_fail
            java.lang.String r6 = r6.getString(r1)
            java.lang.String r1 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)
            r7.d(r0, r6)
        L_0x00b6:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.fragment.FontSizeFragment$showToggleHint$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FontSizeFragment$showToggleHint$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
