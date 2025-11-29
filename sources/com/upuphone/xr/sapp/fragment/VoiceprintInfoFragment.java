package com.upuphone.xr.sapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.honey.account.h8.ja;
import com.honey.account.h8.ka;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentVoiceprintInfoBinding;
import com.upuphone.xr.sapp.utils.ControlUtils;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.xjsd.ai.assistant.phone.helper.WakeupVoiceStorage;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0003R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/VoiceprintInfoFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "initListener", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "C0", "Lcom/upuphone/xr/sapp/databinding/FragmentVoiceprintInfoBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentVoiceprintInfoBinding;", "mBinding", "k", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class VoiceprintInfoFragment extends BaseFragment {
    public static final Companion k = new Companion((DefaultConstructorMarker) null);
    public FragmentVoiceprintInfoBinding j;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/VoiceprintInfoFragment$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static final void D0(VoiceprintInfoFragment voiceprintInfoFragment, View view) {
        Intrinsics.checkNotNullParameter(voiceprintInfoFragment, "this$0");
        StaticMethodUtilsKt.t(voiceprintInfoFragment, R.id.wakeupRecordMainFragment);
    }

    public static final void E0(VoiceprintInfoFragment voiceprintInfoFragment, View view) {
        Intrinsics.checkNotNullParameter(voiceprintInfoFragment, "this$0");
        StaticMethodUtilsKt.t(voiceprintInfoFragment, R.id.voiceprintSrInfoFragment);
    }

    private final void initListener() {
        FragmentVoiceprintInfoBinding fragmentVoiceprintInfoBinding = this.j;
        FragmentVoiceprintInfoBinding fragmentVoiceprintInfoBinding2 = null;
        if (fragmentVoiceprintInfoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentVoiceprintInfoBinding = null;
        }
        fragmentVoiceprintInfoBinding.d.i(new VoiceprintInfoFragment$initListener$1(this));
        FragmentVoiceprintInfoBinding fragmentVoiceprintInfoBinding3 = this.j;
        if (fragmentVoiceprintInfoBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentVoiceprintInfoBinding3 = null;
        }
        fragmentVoiceprintInfoBinding3.c.setOnClickListener(new ja(this));
        FragmentVoiceprintInfoBinding fragmentVoiceprintInfoBinding4 = this.j;
        if (fragmentVoiceprintInfoBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentVoiceprintInfoBinding2 = fragmentVoiceprintInfoBinding4;
        }
        fragmentVoiceprintInfoBinding2.b.setOnClickListener(new ka(this));
    }

    public final void C0() {
        float[] w = ControlUtils.f7858a.w();
        FragmentVoiceprintInfoBinding fragmentVoiceprintInfoBinding = this.j;
        FragmentVoiceprintInfoBinding fragmentVoiceprintInfoBinding2 = null;
        if (fragmentVoiceprintInfoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentVoiceprintInfoBinding = null;
        }
        fragmentVoiceprintInfoBinding.b.setRightContent(getString((w.length == 0) ^ true ? R.string.vp_voiceprint_already_entered : R.string.vp_voiceprint_not_entered));
        FragmentVoiceprintInfoBinding fragmentVoiceprintInfoBinding3 = this.j;
        if (fragmentVoiceprintInfoBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentVoiceprintInfoBinding2 = fragmentVoiceprintInfoBinding3;
        }
        fragmentVoiceprintInfoBinding2.c.setRightContent(WakeupVoiceStorage.INSTANCE.has() ? getString(R.string.vp_voiceprint_already_entered) : getString(R.string.vp_voiceprint_not_entered));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentVoiceprintInfoBinding c = FragmentVoiceprintInfoBinding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.j = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            c = null;
        }
        ConstraintLayout b = c.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        return b;
    }

    public void onResume() {
        super.onResume();
        C0();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initListener();
    }
}
