package com.upuphone.xr.sapp.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.honey.account.h8.la;
import com.honey.account.h8.ma;
import com.honey.account.h8.na;
import com.honey.account.h8.oa;
import com.honey.account.h8.pa;
import com.honey.account.h8.qa;
import com.honey.account.h8.ra;
import com.honey.account.h8.sa;
import com.meizu.common.widget.MzButton;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.databinding.FragmentVoiceprintSepatateRoleBinding;
import com.upuphone.xr.sapp.permission.PermissionHelper;
import com.upuphone.xr.sapp.utils.AppUtils;
import com.upuphone.xr.sapp.utils.ControlUtils;
import com.upuphone.xr.sapp.utils.FlymeUtils;
import com.upuphone.xr.sapp.utils.NetworkUtils;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import flyme.support.v7.app.AlertDialog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\b\u0007*\u0001)\u0018\u0000 -2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u0019\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0003J\u001f\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u0003J\u000f\u0010\u001e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u0003J\u000f\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010\u0003J\u000f\u0010 \u001a\u00020\u0004H\u0002¢\u0006\u0004\b \u0010\u0003R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00170%8\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/VoiceprintSrInfoFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "initData", "initListener", "J0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "", "inputText", "clickText", "Landroid/text/SpannableString;", "O0", "(Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;", "P0", "Q0", "W0", "T0", "Lcom/upuphone/xr/sapp/databinding/FragmentVoiceprintSepatateRoleBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentVoiceprintSepatateRoleBinding;", "mBinding", "", "k", "[Ljava/lang/String;", "recordPermissions", "com/upuphone/xr/sapp/fragment/VoiceprintSrInfoFragment$clickableSpan$1", "l", "Lcom/upuphone/xr/sapp/fragment/VoiceprintSrInfoFragment$clickableSpan$1;", "clickableSpan", "m", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nVoiceprintSrInfoFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoiceprintSrInfoFragment.kt\ncom/upuphone/xr/sapp/fragment/VoiceprintSrInfoFragment\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,338:1\n256#2,2:339\n254#2:341\n256#2,2:342\n256#2,2:344\n256#2,2:346\n256#2,2:348\n256#2,2:350\n256#2,2:352\n256#2,2:354\n256#2,2:356\n*S KotlinDebug\n*F\n+ 1 VoiceprintSrInfoFragment.kt\ncom/upuphone/xr/sapp/fragment/VoiceprintSrInfoFragment\n*L\n221#1:339,2\n222#1:341\n223#1:342,2\n224#1:344,2\n226#1:346,2\n227#1:348,2\n231#1:350,2\n232#1:352,2\n234#1:354,2\n240#1:356,2\n*E\n"})
public final class VoiceprintSrInfoFragment extends BaseFragment {
    public static final Companion m = new Companion((DefaultConstructorMarker) null);
    public FragmentVoiceprintSepatateRoleBinding j;
    public final String[] k = {"android.permission.RECORD_AUDIO"};
    public final VoiceprintSrInfoFragment$clickableSpan$1 l = new VoiceprintSrInfoFragment$clickableSpan$1(this);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/VoiceprintSrInfoFragment$Companion;", "", "()V", "BOOK_TITLE_REGULAR", "", "ROLE_SEPARATION_VOICEPRINT_CLEAR", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    private final void J0() {
        ControlUtils controlUtils = ControlUtils.f7858a;
        boolean E = controlUtils.E();
        FragmentVoiceprintSepatateRoleBinding fragmentVoiceprintSepatateRoleBinding = this.j;
        FragmentVoiceprintSepatateRoleBinding fragmentVoiceprintSepatateRoleBinding2 = null;
        if (fragmentVoiceprintSepatateRoleBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentVoiceprintSepatateRoleBinding = null;
        }
        Group group = fragmentVoiceprintSepatateRoleBinding.c;
        Intrinsics.checkNotNullExpressionValue(group, "gpPrivacyPolicy");
        group.setVisibility(E ^ true ? 0 : 8);
        FragmentVoiceprintSepatateRoleBinding fragmentVoiceprintSepatateRoleBinding3 = this.j;
        if (fragmentVoiceprintSepatateRoleBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentVoiceprintSepatateRoleBinding3 = null;
        }
        Group group2 = fragmentVoiceprintSepatateRoleBinding3.c;
        Intrinsics.checkNotNullExpressionValue(group2, "gpPrivacyPolicy");
        if (group2.getVisibility() == 0) {
            FragmentVoiceprintSepatateRoleBinding fragmentVoiceprintSepatateRoleBinding4 = this.j;
            if (fragmentVoiceprintSepatateRoleBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentVoiceprintSepatateRoleBinding4 = null;
            }
            TextView textView = fragmentVoiceprintSepatateRoleBinding4.j;
            Intrinsics.checkNotNullExpressionValue(textView, "tvRecordVoiceprint");
            textView.setVisibility(0);
            FragmentVoiceprintSepatateRoleBinding fragmentVoiceprintSepatateRoleBinding5 = this.j;
            if (fragmentVoiceprintSepatateRoleBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentVoiceprintSepatateRoleBinding5 = null;
            }
            TextView textView2 = fragmentVoiceprintSepatateRoleBinding5.k;
            Intrinsics.checkNotNullExpressionValue(textView2, "tvRecordVoiceprint1");
            textView2.setVisibility(8);
        } else {
            FragmentVoiceprintSepatateRoleBinding fragmentVoiceprintSepatateRoleBinding6 = this.j;
            if (fragmentVoiceprintSepatateRoleBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentVoiceprintSepatateRoleBinding6 = null;
            }
            TextView textView3 = fragmentVoiceprintSepatateRoleBinding6.j;
            Intrinsics.checkNotNullExpressionValue(textView3, "tvRecordVoiceprint");
            textView3.setVisibility(8);
            FragmentVoiceprintSepatateRoleBinding fragmentVoiceprintSepatateRoleBinding7 = this.j;
            if (fragmentVoiceprintSepatateRoleBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentVoiceprintSepatateRoleBinding7 = null;
            }
            TextView textView4 = fragmentVoiceprintSepatateRoleBinding7.k;
            Intrinsics.checkNotNullExpressionValue(textView4, "tvRecordVoiceprint1");
            textView4.setVisibility(0);
        }
        boolean z = true;
        if (!(controlUtils.w().length == 0)) {
            FragmentVoiceprintSepatateRoleBinding fragmentVoiceprintSepatateRoleBinding8 = this.j;
            if (fragmentVoiceprintSepatateRoleBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentVoiceprintSepatateRoleBinding8 = null;
            }
            MzButton mzButton = fragmentVoiceprintSepatateRoleBinding8.g;
            Intrinsics.checkNotNullExpressionValue(mzButton, "mbtRecord");
            mzButton.setVisibility(8);
            FragmentVoiceprintSepatateRoleBinding fragmentVoiceprintSepatateRoleBinding9 = this.j;
            if (fragmentVoiceprintSepatateRoleBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                fragmentVoiceprintSepatateRoleBinding2 = fragmentVoiceprintSepatateRoleBinding9;
            }
            Group group3 = fragmentVoiceprintSepatateRoleBinding2.d;
            Intrinsics.checkNotNullExpressionValue(group3, "gpRecordMore");
            group3.setVisibility(0);
            return;
        }
        FragmentVoiceprintSepatateRoleBinding fragmentVoiceprintSepatateRoleBinding10 = this.j;
        if (fragmentVoiceprintSepatateRoleBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentVoiceprintSepatateRoleBinding10 = null;
        }
        MzButton mzButton2 = fragmentVoiceprintSepatateRoleBinding10.g;
        Intrinsics.checkNotNullExpressionValue(mzButton2, "mbtRecord");
        mzButton2.setVisibility(0);
        FragmentVoiceprintSepatateRoleBinding fragmentVoiceprintSepatateRoleBinding11 = this.j;
        if (fragmentVoiceprintSepatateRoleBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentVoiceprintSepatateRoleBinding11 = null;
        }
        MzButton mzButton3 = fragmentVoiceprintSepatateRoleBinding11.g;
        if (!E) {
            FragmentVoiceprintSepatateRoleBinding fragmentVoiceprintSepatateRoleBinding12 = this.j;
            if (fragmentVoiceprintSepatateRoleBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentVoiceprintSepatateRoleBinding12 = null;
            }
            z = fragmentVoiceprintSepatateRoleBinding12.b.isChecked();
        }
        mzButton3.setEnabled(z);
        FragmentVoiceprintSepatateRoleBinding fragmentVoiceprintSepatateRoleBinding13 = this.j;
        if (fragmentVoiceprintSepatateRoleBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentVoiceprintSepatateRoleBinding2 = fragmentVoiceprintSepatateRoleBinding13;
        }
        Group group4 = fragmentVoiceprintSepatateRoleBinding2.d;
        Intrinsics.checkNotNullExpressionValue(group4, "gpRecordMore");
        group4.setVisibility(8);
    }

    public static final void K0(VoiceprintSrInfoFragment voiceprintSrInfoFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(voiceprintSrInfoFragment, "this$0");
        FragmentVoiceprintSepatateRoleBinding fragmentVoiceprintSepatateRoleBinding = voiceprintSrInfoFragment.j;
        if (fragmentVoiceprintSepatateRoleBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentVoiceprintSepatateRoleBinding = null;
        }
        fragmentVoiceprintSepatateRoleBinding.g.setEnabled(z);
    }

    public static final void L0(VoiceprintSrInfoFragment voiceprintSrInfoFragment, View view) {
        Intrinsics.checkNotNullParameter(voiceprintSrInfoFragment, "this$0");
        PermissionHelper permissionHelper = PermissionHelper.f7819a;
        FragmentActivity requireActivity = voiceprintSrInfoFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        if (permissionHelper.n(requireActivity, voiceprintSrInfoFragment.k)) {
            voiceprintSrInfoFragment.W0();
            return;
        }
        FragmentActivity requireActivity2 = voiceprintSrInfoFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity(...)");
        permissionHelper.r(requireActivity2, voiceprintSrInfoFragment.k, true, new VoiceprintSrInfoFragment$initListener$3$1(voiceprintSrInfoFragment));
    }

    public static final void M0(VoiceprintSrInfoFragment voiceprintSrInfoFragment, View view) {
        Intrinsics.checkNotNullParameter(voiceprintSrInfoFragment, "this$0");
        voiceprintSrInfoFragment.Q0();
    }

    public static final void N0(VoiceprintSrInfoFragment voiceprintSrInfoFragment, View view) {
        Intrinsics.checkNotNullParameter(voiceprintSrInfoFragment, "this$0");
        voiceprintSrInfoFragment.W0();
    }

    public static final void R0(VoiceprintSrInfoFragment voiceprintSrInfoFragment, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(voiceprintSrInfoFragment, "this$0");
        voiceprintSrInfoFragment.P0();
        ControlUtils.t0(ControlUtils.f7858a, new float[0], (String) null, 2, (Object) null);
        voiceprintSrInfoFragment.J0();
        dialogInterface.dismiss();
    }

    public static final void S0(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }

    public static final void U0(FragmentActivity fragmentActivity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "$fActivity");
        AppUtils.q(AppUtils.f7842a, fragmentActivity, 0, 2, (Object) null);
        dialogInterface.dismiss();
    }

    public static final void V0(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }

    private final void initData() {
        FragmentVoiceprintSepatateRoleBinding fragmentVoiceprintSepatateRoleBinding = this.j;
        FragmentVoiceprintSepatateRoleBinding fragmentVoiceprintSepatateRoleBinding2 = null;
        if (fragmentVoiceprintSepatateRoleBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentVoiceprintSepatateRoleBinding = null;
        }
        TextView textView = fragmentVoiceprintSepatateRoleBinding.i;
        String string = getString(R.string.vp_separate_role_record_privacy_policy);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(R.string.superapp_privacy_policy);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        textView.setText(O0(string, string2));
        FragmentVoiceprintSepatateRoleBinding fragmentVoiceprintSepatateRoleBinding3 = this.j;
        if (fragmentVoiceprintSepatateRoleBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentVoiceprintSepatateRoleBinding3 = null;
        }
        fragmentVoiceprintSepatateRoleBinding3.i.setMovementMethod(LinkMovementMethod.getInstance());
        FragmentVoiceprintSepatateRoleBinding fragmentVoiceprintSepatateRoleBinding4 = this.j;
        if (fragmentVoiceprintSepatateRoleBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentVoiceprintSepatateRoleBinding4 = null;
        }
        fragmentVoiceprintSepatateRoleBinding4.b.setChecked(false);
        FragmentVoiceprintSepatateRoleBinding fragmentVoiceprintSepatateRoleBinding5 = this.j;
        if (fragmentVoiceprintSepatateRoleBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentVoiceprintSepatateRoleBinding2 = fragmentVoiceprintSepatateRoleBinding5;
        }
        fragmentVoiceprintSepatateRoleBinding2.g.setEnabled(false);
    }

    private final void initListener() {
        FragmentVoiceprintSepatateRoleBinding fragmentVoiceprintSepatateRoleBinding = this.j;
        FragmentVoiceprintSepatateRoleBinding fragmentVoiceprintSepatateRoleBinding2 = null;
        if (fragmentVoiceprintSepatateRoleBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentVoiceprintSepatateRoleBinding = null;
        }
        fragmentVoiceprintSepatateRoleBinding.h.i(new VoiceprintSrInfoFragment$initListener$1(this));
        FragmentVoiceprintSepatateRoleBinding fragmentVoiceprintSepatateRoleBinding3 = this.j;
        if (fragmentVoiceprintSepatateRoleBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentVoiceprintSepatateRoleBinding3 = null;
        }
        fragmentVoiceprintSepatateRoleBinding3.b.setOnCheckedChangeListener(new la(this));
        FragmentVoiceprintSepatateRoleBinding fragmentVoiceprintSepatateRoleBinding4 = this.j;
        if (fragmentVoiceprintSepatateRoleBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentVoiceprintSepatateRoleBinding4 = null;
        }
        fragmentVoiceprintSepatateRoleBinding4.g.setOnClickListener(new ma(this));
        FragmentVoiceprintSepatateRoleBinding fragmentVoiceprintSepatateRoleBinding5 = this.j;
        if (fragmentVoiceprintSepatateRoleBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentVoiceprintSepatateRoleBinding5 = null;
        }
        fragmentVoiceprintSepatateRoleBinding5.e.setOnClickListener(new na(this));
        FragmentVoiceprintSepatateRoleBinding fragmentVoiceprintSepatateRoleBinding6 = this.j;
        if (fragmentVoiceprintSepatateRoleBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentVoiceprintSepatateRoleBinding2 = fragmentVoiceprintSepatateRoleBinding6;
        }
        fragmentVoiceprintSepatateRoleBinding2.f.setOnClickListener(new oa(this));
    }

    public final SpannableString O0(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        Matcher matcher = Pattern.compile("[«»『』《》〈〉「」](.*?)[«»『』《》〈〉「」]").matcher(str3);
        FragmentActivity activity = getActivity();
        int color = activity != null ? activity.getColor(R.color.vp_separate_role_privacy_policy) : -16776961;
        SpannableString spannableString = new SpannableString(str3);
        boolean z = false;
        while (matcher.find()) {
            String group = matcher.group();
            int start = matcher.start();
            int end = matcher.end();
            ULog.Delegate delegate = ULog.f6446a;
            delegate.g("VoiceprintSrInfoFragment", "1. matchBookTitle group=" + group + ", start=" + start + ", end=" + end);
            Intrinsics.checkNotNull(group);
            if (StringsKt.contains$default((CharSequence) group, (CharSequence) str4, false, 2, (Object) null)) {
                spannableString.setSpan(this.l, start, end, 33);
                spannableString.setSpan(new ForegroundColorSpan(color), start, end, 34);
                z = true;
            }
        }
        if (!z && StringsKt.contains$default((CharSequence) str3, (CharSequence) str4, false, 2, (Object) null)) {
            int indexOf$default = StringsKt.indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
            while (indexOf$default != -1) {
                int length = indexOf$default + str2.length();
                ULog.Delegate delegate2 = ULog.f6446a;
                delegate2.g("VoiceprintSrInfoFragment", "2. matchBookTitle group=" + str4 + ", start=" + indexOf$default + ", end=" + length);
                spannableString.setSpan(this.l, indexOf$default, length, 33);
                spannableString.setSpan(new ForegroundColorSpan(color), indexOf$default, length, 34);
                indexOf$default = StringsKt.indexOf$default((CharSequence) str, str2, length, false, 4, (Object) null);
            }
        }
        return spannableString;
    }

    public final void P0() {
        SdkContext.f6675a.d().reportEvent("App_RoleSeparation_Voiceprint_Clear", MapsKt.hashMapOf(TuplesKt.to("vuid1", ControlUtils.f7858a.x())));
    }

    public final void Q0() {
        View decorView;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            AlertDialog create = new AlertDialog.Builder(activity).setTitle(R.string.vp_separate_role_clear_voiceprint).setMessage(R.string.vp_separate_role_clear_tip_content).setPositiveButton(R.string.vp_clear, (DialogInterface.OnClickListener) new ra(this)).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) new sa()).create();
            Window window = create.getWindow();
            if (!(window == null || (decorView = window.getDecorView()) == null)) {
                FlymeUtils.a(decorView, activity);
            }
            create.show();
            Button button = create.getButton(-1);
            if (button != null) {
                Intrinsics.checkNotNull(button);
                button.setBackground(ContextCompat.getDrawable(activity, R.drawable.bg_confirm_button_warning));
                button.setTextColor(ContextCompat.getColor(activity, R.color.vp_separate_role_clear_confirm_bt));
            }
        }
    }

    public final void T0() {
        View decorView;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            AlertDialog create = new AlertDialog.Builder(activity).setTitle(R.string.network_not_available_pls_check).setPositiveButton(R.string.network_setting, (DialogInterface.OnClickListener) new pa(activity)).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) new qa()).create();
            Window window = create.getWindow();
            if (!(window == null || (decorView = window.getDecorView()) == null)) {
                FlymeUtils.a(decorView, activity);
            }
            create.show();
        }
    }

    public final void W0() {
        if (NetworkUtils.f7898a.g()) {
            StaticMethodUtilsKt.t(this, R.id.voiceprintSrRecordFragment);
        } else {
            T0();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentVoiceprintSepatateRoleBinding c = FragmentVoiceprintSepatateRoleBinding.c(layoutInflater, viewGroup, false);
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
        J0();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initData();
        initListener();
    }
}
