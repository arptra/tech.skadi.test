package com.upuphone.xr.sapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import com.honey.account.h8.ab;
import com.honey.account.h8.bb;
import com.honey.account.h8.cb;
import com.honey.account.h8.za;
import com.meizu.common.widget.MzButton;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.WakeupRecordFinishedFragmentBinding;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/WakeupRecordFinishedFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "j", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class WakeupRecordFinishedFragment extends BaseFragment {
    public static final Companion j = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/WakeupRecordFinishedFragment$Companion;", "", "()V", "PARAM_KEY_STATUS", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static final void E0(WakeupRecordFinishedFragment wakeupRecordFinishedFragment, View view) {
        Intrinsics.checkNotNullParameter(wakeupRecordFinishedFragment, "this$0");
        StaticMethodUtilsKt.x(wakeupRecordFinishedFragment, R.id.wakeupRecordMainFragment);
    }

    public static final void F0(WakeupRecordFinishedFragment wakeupRecordFinishedFragment, View view) {
        Intrinsics.checkNotNullParameter(wakeupRecordFinishedFragment, "this$0");
        StaticMethodUtilsKt.u(wakeupRecordFinishedFragment, R.id.voiceprintSrInfoFragment, R.id.voiceprintInfoFragment);
    }

    public static final void G0(WakeupRecordFinishedFragment wakeupRecordFinishedFragment, View view) {
        Intrinsics.checkNotNullParameter(wakeupRecordFinishedFragment, "this$0");
        StaticMethodUtilsKt.x(wakeupRecordFinishedFragment, R.id.wakeupRecordMainFragment);
    }

    public static final void H0(WakeupRecordFinishedFragment wakeupRecordFinishedFragment, View view) {
        Intrinsics.checkNotNullParameter(wakeupRecordFinishedFragment, "this$0");
        StaticMethodUtilsKt.u(wakeupRecordFinishedFragment, R.id.wakeupRecordingFragment, R.id.wakeupRecordMainFragment);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        WakeupRecordFinishedFragmentBinding c = WakeupRecordFinishedFragmentBinding.c(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        c.b.setOnClickListener(new za(this));
        c.d.setOnClickListener(new ab(this));
        Bundle arguments = getArguments();
        if (arguments == null || arguments.getBoolean("status")) {
            c.e.setAnimation(R.raw.record_success);
            c.g.setText(getString(R.string.vp_separate_role_recording_completed));
            c.f.setVisibility(8);
            c.d.setVisibility(8);
            MzButton mzButton = c.c;
            mzButton.setText(getString(R.string.done));
            mzButton.setOnClickListener(new bb(this));
        } else {
            c.e.setAnimation(R.raw.record_fail);
            c.g.setText(getString(R.string.vp_separate_role_recording_failed));
            c.f.setVisibility(0);
            c.d.setVisibility(8);
            MzButton mzButton2 = c.c;
            mzButton2.setText(getString(R.string.vp_separate_role_re_entry));
            mzButton2.setBackgroundResource(R.drawable.bg_sr_ic_re_entry_btn);
            mzButton2.setTextColor(requireContext().getColor(R.color.vp_separate_role_clear_confirm_bt));
            mzButton2.setOnClickListener(new cb(this));
        }
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new WakeupRecordFinishedFragment$onCreateView$5(c, (Continuation<? super WakeupRecordFinishedFragment$onCreateView$5>) null), 3, (Object) null);
        ConstraintLayout b = c.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        return b;
    }
}
