package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.alibaba.fastjson.asm.Opcodes;
import com.honey.account.h8.db;
import com.honey.account.h8.eb;
import com.honey.account.h8.fb;
import com.honey.account.h8.gb;
import com.honey.account.h8.hb;
import com.upuphone.runasone.uupcast.CaptureType;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.context.PermissionContext;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.databinding.WakeupRecordHomeFragmentBinding;
import com.upuphone.xr.sapp.utils.ControlUtils;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.xjsd.ai.assistant.phone.helper.WakeupVoiceStorage;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 *2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J+\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0003J\u001f\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u0003J\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u0003J\u000f\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010\u0003J\u0010\u0010!\u001a\u00020 H@¢\u0006\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/WakeupRecordMainFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "U0", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onResume", "", "windowType", "actionType", "a", "(II)V", "", "inputText", "clickText", "Landroid/text/SpannableString;", "N0", "(Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;", "J0", "T0", "(I)V", "K0", "M0", "", "L0", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/upuphone/xr/sapp/databinding/WakeupRecordHomeFragmentBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/WakeupRecordHomeFragmentBinding;", "binding", "k", "Z", "conflictShowed", "l", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class WakeupRecordMainFragment extends BaseFragment {
    public static final Companion l = new Companion((DefaultConstructorMarker) null);
    public static final Lazy m = LazyKt.lazy(WakeupRecordMainFragment$Companion$isMeizu$2.INSTANCE);
    public WakeupRecordHomeFragmentBinding j;
    public boolean k;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\fR\u0014\u0010\u0012\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u0013\u0010\fR\u0014\u0010\u0014\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u0014\u0010\fR\u0014\u0010\u0016\u001a\u00020\u00158\u0002XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u0018\u0010\fR\u0014\u0010\u0019\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u0019\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/WakeupRecordMainFragment$Companion;", "", "<init>", "()V", "", "isMeizu$delegate", "Lkotlin/Lazy;", "b", "()Z", "isMeizu", "", "DOT_ID_CLEAR", "Ljava/lang/String;", "FLM_AUTHORITY_SVA_SETTINGS", "FLM_METHOD_NAME", "FLM_PARAM_SHARED_PREF_DATA_TYPE", "FLM_PARAM_SHARED_PREF_KEY", "FLM_PARAM_SHARED_PREF_NAME", "FLM_PKG_NAME_VOICE", "FLM_RETURN_FIELD", "FLM_VOICE_SETTING_ACTION", "", "FLM_WAKEUP_NO_CONFLICT_VERSION", "J", "PERMISSION_RECORD_AUDIO", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean b() {
            return ((Boolean) WakeupRecordMainFragment.m.getValue()).booleanValue();
        }

        public Companion() {
        }
    }

    public static final void O0(WakeupRecordMainFragment wakeupRecordMainFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(wakeupRecordMainFragment, "this$0");
        WakeupRecordHomeFragmentBinding wakeupRecordHomeFragmentBinding = wakeupRecordMainFragment.j;
        if (wakeupRecordHomeFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            wakeupRecordHomeFragmentBinding = null;
        }
        wakeupRecordHomeFragmentBinding.i.setEnabled(z);
    }

    public static final void P0(WakeupRecordMainFragment wakeupRecordMainFragment, View view) {
        Intrinsics.checkNotNullParameter(wakeupRecordMainFragment, "this$0");
        wakeupRecordMainFragment.U0();
    }

    public static final void Q0(WakeupRecordMainFragment wakeupRecordMainFragment, View view) {
        Intrinsics.checkNotNullParameter(wakeupRecordMainFragment, "this$0");
        StaticMethodUtilsKt.q(wakeupRecordMainFragment);
    }

    public static final void R0(WakeupRecordMainFragment wakeupRecordMainFragment, View view) {
        Intrinsics.checkNotNullParameter(wakeupRecordMainFragment, "this$0");
        wakeupRecordMainFragment.U0();
    }

    public static final void S0(WakeupRecordMainFragment wakeupRecordMainFragment, View view) {
        Intrinsics.checkNotNullParameter(wakeupRecordMainFragment, "this$0");
        wakeupRecordMainFragment.T0(190);
    }

    private final void U0() {
        SdkContext sdkContext = SdkContext.f6675a;
        if (sdkContext.f().a(new String[]{"android.permission.RECORD_AUDIO"})) {
            M0();
            return;
        }
        PermissionContext f = sdkContext.f();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        f.d(requireActivity, new String[]{"android.permission.RECORD_AUDIO"}, new HashMap(), new WakeupRecordMainFragment$startRecord$1(this));
    }

    public final void J0() {
        WakeupRecordHomeFragmentBinding wakeupRecordHomeFragmentBinding = null;
        if (WakeupVoiceStorage.INSTANCE.has()) {
            WakeupRecordHomeFragmentBinding wakeupRecordHomeFragmentBinding2 = this.j;
            if (wakeupRecordHomeFragmentBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                wakeupRecordHomeFragmentBinding2 = null;
            }
            wakeupRecordHomeFragmentBinding2.d.setVisibility(8);
            WakeupRecordHomeFragmentBinding wakeupRecordHomeFragmentBinding3 = this.j;
            if (wakeupRecordHomeFragmentBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                wakeupRecordHomeFragmentBinding = wakeupRecordHomeFragmentBinding3;
            }
            wakeupRecordHomeFragmentBinding.c.setVisibility(0);
            return;
        }
        WakeupRecordHomeFragmentBinding wakeupRecordHomeFragmentBinding4 = this.j;
        if (wakeupRecordHomeFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            wakeupRecordHomeFragmentBinding4 = null;
        }
        wakeupRecordHomeFragmentBinding4.d.setVisibility(0);
        WakeupRecordHomeFragmentBinding wakeupRecordHomeFragmentBinding5 = this.j;
        if (wakeupRecordHomeFragmentBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            wakeupRecordHomeFragmentBinding5 = null;
        }
        wakeupRecordHomeFragmentBinding5.c.setVisibility(8);
        if (ControlUtils.f7858a.E()) {
            WakeupRecordHomeFragmentBinding wakeupRecordHomeFragmentBinding6 = this.j;
            if (wakeupRecordHomeFragmentBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                wakeupRecordHomeFragmentBinding6 = null;
            }
            wakeupRecordHomeFragmentBinding6.e.setVisibility(8);
            WakeupRecordHomeFragmentBinding wakeupRecordHomeFragmentBinding7 = this.j;
            if (wakeupRecordHomeFragmentBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                wakeupRecordHomeFragmentBinding7 = null;
            }
            wakeupRecordHomeFragmentBinding7.g.setVisibility(8);
            WakeupRecordHomeFragmentBinding wakeupRecordHomeFragmentBinding8 = this.j;
            if (wakeupRecordHomeFragmentBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                wakeupRecordHomeFragmentBinding = wakeupRecordHomeFragmentBinding8;
            }
            wakeupRecordHomeFragmentBinding.i.setEnabled(true);
            return;
        }
        WakeupRecordHomeFragmentBinding wakeupRecordHomeFragmentBinding9 = this.j;
        if (wakeupRecordHomeFragmentBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            wakeupRecordHomeFragmentBinding9 = null;
        }
        wakeupRecordHomeFragmentBinding9.e.setVisibility(0);
        WakeupRecordHomeFragmentBinding wakeupRecordHomeFragmentBinding10 = this.j;
        if (wakeupRecordHomeFragmentBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            wakeupRecordHomeFragmentBinding = wakeupRecordHomeFragmentBinding10;
        }
        wakeupRecordHomeFragmentBinding.g.setVisibility(0);
    }

    public final void K0() {
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), Dispatchers.a(), (CoroutineStart) null, new WakeupRecordMainFragment$clearDot$1(this, (Continuation<? super WakeupRecordMainFragment$clearDot$1>) null), 2, (Object) null);
    }

    public final Object L0(Continuation continuation) {
        return BuildersKt.g(Dispatchers.b(), new WakeupRecordMainFragment$isFlmWakeupOn$2(this, (Continuation<? super WakeupRecordMainFragment$isFlmWakeupOn$2>) null), continuation);
    }

    public final void M0() {
        PackageManager packageManager;
        PackageInfo packageInfo;
        if (!l.b()) {
            StaticMethodUtilsKt.t(this, R.id.wakeupRecordingFragment);
            return;
        }
        long j2 = 0;
        try {
            Context context = getContext();
            if (!(context == null || (packageManager = context.getPackageManager()) == null || (packageInfo = packageManager.getPackageInfo("com.meizu.voiceassistant", 0)) == null)) {
                j2 = packageInfo.getLongVersionCode();
            }
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e.getMessage();
            delegate.a("WakeupRecordMainFragment", "Exception: " + message);
        }
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new WakeupRecordMainFragment$jumpByCondition$1(this, (Continuation<? super WakeupRecordMainFragment$jumpByCondition$1>) null), 3, (Object) null);
        ULog.Delegate delegate2 = ULog.f6446a;
        delegate2.a("WakeupRecordMainFragment", "flyme voice version: " + j2);
        if (j2 >= 1102010) {
            StaticMethodUtilsKt.t(this, R.id.wakeupRecordingFragment);
        } else if (Build.VERSION.SDK_INT >= 34) {
            Job unused2 = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new WakeupRecordMainFragment$jumpByCondition$2(this, (Continuation<? super WakeupRecordMainFragment$jumpByCondition$2>) null), 3, (Object) null);
        } else if (!this.k) {
            this.k = true;
            T0(Opcodes.IFNONNULL);
        } else {
            StaticMethodUtilsKt.t(this, R.id.wakeupRecordingFragment);
        }
    }

    public final SpannableString N0(String str, String str2) {
        Matcher matcher = Pattern.compile("[«»『』《》〈〉「」]?" + str2 + "[«»『』《》〈〉「」]?").matcher(str);
        FragmentActivity activity = getActivity();
        int color = activity != null ? activity.getColor(R.color.vp_separate_role_privacy_policy) : -16776961;
        SpannableString spannableString = new SpannableString(str);
        while (matcher.find()) {
            String group = matcher.group();
            int start = matcher.start();
            int end = matcher.end();
            ULog.Delegate delegate = ULog.f6446a;
            delegate.g("WakeupRecordMainFragment", "matchBookTitle group=" + group + ", start=" + start + ", end=" + end);
            Intrinsics.checkNotNull(group);
            if (StringsKt.contains$default((CharSequence) group, (CharSequence) str2, false, 2, (Object) null)) {
                spannableString.setSpan(new WakeupRecordMainFragment$makePrivacyDesc$1$1(this), start, end, 33);
                spannableString.setSpan(new ForegroundColorSpan(color), start, end, 34);
            }
        }
        return spannableString;
    }

    public final void T0(int i) {
        StaticMethodUtilsKt.H(this, CollectionsKt.arrayListOf(Integer.valueOf(i)), MapsKt.hashMapOf(TuplesKt.to(Integer.valueOf(i), ControlUtils.f7858a.f())), false, false, (Bundle) null, 16, (Object) null);
    }

    public void a(int i, int i2) {
        super.a(i, i2);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("WakeupRecordMainFragment", "button action window type: " + i + ", action type: " + i2);
        if (i2 == 1101) {
            if (i == 183) {
                StaticMethodUtilsKt.p(this);
            } else if (i == 185) {
                U0();
            } else if (i == 190) {
                WakeupVoiceStorage.INSTANCE.clear();
                J0();
                K0();
            } else if (i == 199) {
                Intent intent = new Intent("com.meizu.voiceassistant.action.VOICE_SETTING");
                intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
                startActivity(intent);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        WakeupRecordHomeFragmentBinding c = WakeupRecordHomeFragmentBinding.c(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.j = c;
        WakeupRecordHomeFragmentBinding wakeupRecordHomeFragmentBinding = null;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        AppCompatTextView appCompatTextView = c.g;
        String string = getString(R.string.wakeup_record_privacy);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(R.string.superapp_privacy_policy);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        appCompatTextView.setText(N0(string, string2));
        appCompatTextView.setMovementMethod(LinkMovementMethod.getInstance());
        appCompatTextView.setHighlightColor(0);
        WakeupRecordHomeFragmentBinding wakeupRecordHomeFragmentBinding2 = this.j;
        if (wakeupRecordHomeFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            wakeupRecordHomeFragmentBinding2 = null;
        }
        wakeupRecordHomeFragmentBinding2.e.setOnCheckedChangeListener(new db(this));
        WakeupRecordHomeFragmentBinding wakeupRecordHomeFragmentBinding3 = this.j;
        if (wakeupRecordHomeFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            wakeupRecordHomeFragmentBinding3 = null;
        }
        wakeupRecordHomeFragmentBinding3.i.setOnClickListener(new eb(this));
        WakeupRecordHomeFragmentBinding wakeupRecordHomeFragmentBinding4 = this.j;
        if (wakeupRecordHomeFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            wakeupRecordHomeFragmentBinding4 = null;
        }
        wakeupRecordHomeFragmentBinding4.b.setOnClickListener(new fb(this));
        WakeupRecordHomeFragmentBinding wakeupRecordHomeFragmentBinding5 = this.j;
        if (wakeupRecordHomeFragmentBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            wakeupRecordHomeFragmentBinding5 = null;
        }
        wakeupRecordHomeFragmentBinding5.h.setOnClickListener(new gb(this));
        WakeupRecordHomeFragmentBinding wakeupRecordHomeFragmentBinding6 = this.j;
        if (wakeupRecordHomeFragmentBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            wakeupRecordHomeFragmentBinding6 = null;
        }
        wakeupRecordHomeFragmentBinding6.k.setOnClickListener(new hb(this));
        WakeupRecordHomeFragmentBinding wakeupRecordHomeFragmentBinding7 = this.j;
        if (wakeupRecordHomeFragmentBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            wakeupRecordHomeFragmentBinding = wakeupRecordHomeFragmentBinding7;
        }
        ConstraintLayout b = wakeupRecordHomeFragmentBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        return b;
    }

    public void onResume() {
        super.onResume();
        J0();
    }
}
