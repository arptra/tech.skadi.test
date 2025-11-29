package com.upuphone.xr.sapp.fragment;

import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.upuphone.xr.sapp.databinding.FragmentWiseNotifyBinding;
import com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager;
import com.upuphone.xr.sapp.monitor.schedule.ScheduleDataSyncManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.WiseNotifyFragment$initView$2", f = "WiseNotifyFragment.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
public final class WiseNotifyFragment$initView$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WiseNotifyFragment this$0;

    @SourceDebugExtension({"SMAP\nWiseNotifyFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WiseNotifyFragment.kt\ncom/upuphone/xr/sapp/fragment/WiseNotifyFragment$initView$2$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,214:1\n256#2,2:215\n256#2,2:217\n256#2,2:219\n256#2,2:221\n*S KotlinDebug\n*F\n+ 1 WiseNotifyFragment.kt\ncom/upuphone/xr/sapp/fragment/WiseNotifyFragment$initView$2$1\n*L\n87#1:215,2\n88#1:217,2\n90#1:219,2\n91#1:221,2\n*E\n"})
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.xr.sapp.fragment.WiseNotifyFragment$initView$2$1", f = "WiseNotifyFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.xr.sapp.fragment.WiseNotifyFragment$initView$2$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(wiseNotifyFragment, continuation);
            r0.Z$0 = ((Boolean) obj).booleanValue();
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) (Continuation) obj2);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                boolean z = this.Z$0;
                FragmentWiseNotifyBinding B0 = wiseNotifyFragment.j;
                FragmentWiseNotifyBinding fragmentWiseNotifyBinding = null;
                if (B0 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    B0 = null;
                }
                B0.t.setChecked(z);
                FragmentWiseNotifyBinding B02 = wiseNotifyFragment.j;
                if (B02 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    B02 = null;
                }
                TextView textView = B02.k;
                Intrinsics.checkNotNullExpressionValue(textView, "wiseNotifyListTips");
                int i = 8;
                textView.setVisibility(z ? 0 : 8);
                FragmentWiseNotifyBinding B03 = wiseNotifyFragment.j;
                if (B03 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    B03 = null;
                }
                ConstraintLayout constraintLayout = B03.l;
                Intrinsics.checkNotNullExpressionValue(constraintLayout, "wiseNotifySchedule");
                boolean z2 = true;
                constraintLayout.setVisibility(z && ScheduleDataSyncManager.f7777a.i() ? 0 : 8);
                FragmentWiseNotifyBinding B04 = wiseNotifyFragment.j;
                if (B04 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    B04 = null;
                }
                ConstraintLayout constraintLayout2 = B04.u;
                Intrinsics.checkNotNullExpressionValue(constraintLayout2, "wiseNotifyTaxi");
                constraintLayout2.setVisibility(z ? 0 : 8);
                FragmentWiseNotifyBinding B05 = wiseNotifyFragment.j;
                if (B05 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    fragmentWiseNotifyBinding = B05;
                }
                ConstraintLayout constraintLayout3 = fragmentWiseNotifyBinding.e;
                Intrinsics.checkNotNullExpressionValue(constraintLayout3, "wiseNotifyFlight");
                if (!z || !SuperNotificationManager.f7749a.D()) {
                    z2 = false;
                }
                if (z2) {
                    i = 0;
                }
                constraintLayout3.setVisibility(i);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        public final Object invoke(boolean z, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WiseNotifyFragment$initView$2(WiseNotifyFragment wiseNotifyFragment, Continuation<? super WiseNotifyFragment$initView$2> continuation) {
        super(2, continuation);
        this.this$0 = wiseNotifyFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WiseNotifyFragment$initView$2(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MutableSharedFlow r = SuperNotificationManager.f7749a.r();
            final WiseNotifyFragment wiseNotifyFragment = this.this$0;
            AnonymousClass1 r1 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.label = 1;
            if (FlowKt.k(r, r1, this) == coroutine_suspended) {
                return coroutine_suspended;
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
        return ((WiseNotifyFragment$initView$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
