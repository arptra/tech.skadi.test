package com.upuphone.xr.sapp.fragment;

import android.os.SystemClock;
import android.widget.TextView;
import com.meizu.common.widget.MzButton;
import com.upuphone.xr.sapp.databinding.FragmentVoiceprintSepatateRoleRecordBinding;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nVoiceprintSrRecordFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoiceprintSrRecordFragment.kt\ncom/upuphone/xr/sapp/fragment/VoiceprintSrRecordFragment$handleAsrOpened$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,598:1\n256#2,2:599\n256#2,2:601\n*S KotlinDebug\n*F\n+ 1 VoiceprintSrRecordFragment.kt\ncom/upuphone/xr/sapp/fragment/VoiceprintSrRecordFragment$handleAsrOpened$1\n*L\n356#1:599,2\n357#1:601,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.VoiceprintSrRecordFragment$handleAsrOpened$1", f = "VoiceprintSrRecordFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VoiceprintSrRecordFragment$handleAsrOpened$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ VoiceprintSrRecordFragment this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.xr.sapp.fragment.VoiceprintSrRecordFragment$handleAsrOpened$1$1", f = "VoiceprintSrRecordFragment.kt", i = {}, l = {370}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.xr.sapp.fragment.VoiceprintSrRecordFragment$handleAsrOpened$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(voiceprintSrRecordFragment2, continuation);
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0026  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0042  */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 1
                if (r1 == 0) goto L_0x0017
                if (r1 != r2) goto L_0x000f
                kotlin.ResultKt.throwOnFailure(r6)
                goto L_0x0031
            L_0x000f:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L_0x0017:
                kotlin.ResultKt.throwOnFailure(r6)
            L_0x001a:
                com.upuphone.xr.sapp.fragment.VoiceprintSrRecordFragment r6 = r8
                int r6 = r6.n
                if (r6 < 0) goto L_0x0042
                r1 = 21
                if (r6 >= r1) goto L_0x0042
                r5.label = r2
                r3 = 1000(0x3e8, double:4.94E-321)
                java.lang.Object r6 = kotlinx.coroutines.DelayKt.b(r3, r5)
                if (r6 != r0) goto L_0x0031
                return r0
            L_0x0031:
                com.upuphone.xr.sapp.fragment.VoiceprintSrRecordFragment r6 = r8
                int r1 = r6.n
                int r1 = r1 + -1
                r6.n = r1
                com.upuphone.xr.sapp.fragment.VoiceprintSrRecordFragment r6 = r8
                r6.h1()
                goto L_0x001a
            L_0x0042:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.fragment.VoiceprintSrRecordFragment$handleAsrOpened$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoiceprintSrRecordFragment$handleAsrOpened$1(VoiceprintSrRecordFragment voiceprintSrRecordFragment, Continuation<? super VoiceprintSrRecordFragment$handleAsrOpened$1> continuation) {
        super(2, continuation);
        this.this$0 = voiceprintSrRecordFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VoiceprintSrRecordFragment$handleAsrOpened$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.p1();
            FragmentVoiceprintSepatateRoleRecordBinding H0 = this.this$0.k;
            if (H0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                H0 = null;
            }
            TextView textView = H0.b.e;
            Intrinsics.checkNotNullExpressionValue(textView, "tvCountdown");
            textView.setVisibility(0);
            FragmentVoiceprintSepatateRoleRecordBinding H02 = this.this$0.k;
            if (H02 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                H02 = null;
            }
            MzButton mzButton = H02.b.b;
            Intrinsics.checkNotNullExpressionValue(mzButton, "mbtNext");
            mzButton.setVisibility(8);
            FragmentVoiceprintSepatateRoleRecordBinding H03 = this.this$0.k;
            if (H03 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                H03 = null;
            }
            H03.b.b.setEnabled(false);
            this.this$0.n = 20;
            this.this$0.h1();
            this.this$0.m = new byte[0];
            this.this$0.e1().k0();
            this.this$0.q = SystemClock.elapsedRealtime();
            Job M0 = this.this$0.o;
            if (M0 != null) {
                Job.DefaultImpls.a(M0, (CancellationException) null, 1, (Object) null);
            }
            this.this$0.o = null;
            VoiceprintSrRecordFragment voiceprintSrRecordFragment = this.this$0;
            CoroutineScope I0 = voiceprintSrRecordFragment.l;
            final VoiceprintSrRecordFragment voiceprintSrRecordFragment2 = this.this$0;
            voiceprintSrRecordFragment.o = BuildersKt__Builders_commonKt.d(I0, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VoiceprintSrRecordFragment$handleAsrOpened$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
