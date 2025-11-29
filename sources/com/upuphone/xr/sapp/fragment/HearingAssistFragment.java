package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.collection.ArrayMapKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import com.honey.account.h8.c5;
import com.honey.account.h8.d5;
import com.honey.account.h8.e5;
import com.honey.account.h8.f5;
import com.honey.account.h8.g5;
import com.honey.account.h8.h5;
import com.upuphone.ar.navi.lite.manger.NaviManager;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentHearingAssistBinding;
import com.upuphone.xr.sapp.datatrack.AppDataTrackEvent;
import com.upuphone.xr.sapp.datatrack.ReminderDataTrackEvent;
import com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.DataTrackUtil;
import com.upuphone.xr.sapp.utils.DynamicOperateUtil;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.view.CardItemView;
import com.upuphone.xr.sapp.vm.internal.SuperMessageManger;
import com.xjsd.ai.assistant.phone.helper.AssistantSettingUtils;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 22\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0003J\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u0003J\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b \u0010\u001fJ+\u0010(\u001a\u00020'2\u0006\u0010\"\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b(\u0010)J!\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020'2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0004H\u0016¢\u0006\u0004\b-\u0010\u0003R\u0016\u00101\u001a\u00020.8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b/\u00100¨\u00064"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/HearingAssistFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "initView", "I0", "L0", "N0", "V0", "T0", "P0", "M0", "", "isTTSPlay", "isCardDisplay", "d1", "(ZZ)V", "R0", "J0", "f1", "e1", "setFirst", "a1", "(Z)V", "b1", "c1", "Z0", "", "value", "X0", "(I)V", "Y0", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "Lcom/upuphone/xr/sapp/databinding/FragmentHearingAssistBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentHearingAssistBinding;", "binding", "k", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nHearingAssistFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HearingAssistFragment.kt\ncom/upuphone/xr/sapp/fragment/HearingAssistFragment\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,598:1\n256#2,2:599\n256#2,2:601\n256#2,2:603\n*S KotlinDebug\n*F\n+ 1 HearingAssistFragment.kt\ncom/upuphone/xr/sapp/fragment/HearingAssistFragment\n*L\n211#1:599,2\n411#1:601,2\n224#1:603,2\n*E\n"})
public final class HearingAssistFragment extends BaseFragment {
    public static final Companion k = new Companion((DefaultConstructorMarker) null);
    public FragmentHearingAssistBinding j;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/HearingAssistFragment$Companion;", "", "()V", "ASSIST_EVENT_NAME", "", "ASSIST_EVENT_STATUS", "ASSIST_EVENT_TYPE", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static final void K0(HearingAssistFragment hearingAssistFragment, View view) {
        Intrinsics.checkNotNullParameter(hearingAssistFragment, "this$0");
        StaticMethodUtilsKt.t(hearingAssistFragment, R.id.glassAppListFragment);
        DataStoreUtils.Companion companion = DataStoreUtils.e;
        int intValue = ((Number) DataStoreUtils.j(companion.a(), "applist_times", 1, true, (Context) null, 8, (Object) null)).intValue();
        DataTrackUtil.f7875a.i(ReminderDataTrackEvent.APP_GLASSES_SETTING, MapsKt.toMap(ArrayMapKt.a(TuplesKt.to("applist_times", String.valueOf(intValue)))));
        companion.a().p("applist_times", Integer.valueOf(intValue + 1), true);
    }

    public static final void O0(HearingAssistFragment hearingAssistFragment, View view) {
        Intrinsics.checkNotNullParameter(hearingAssistFragment, "this$0");
        FragmentHearingAssistBinding fragmentHearingAssistBinding = hearingAssistFragment.j;
        if (fragmentHearingAssistBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHearingAssistBinding = null;
        }
        boolean isChecked = fragmentHearingAssistBinding.e.getBinding().i.isChecked();
        FragmentHearingAssistBinding fragmentHearingAssistBinding2 = hearingAssistFragment.j;
        if (fragmentHearingAssistBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHearingAssistBinding2 = null;
        }
        fragmentHearingAssistBinding2.e.getBinding().i.setChecked(!isChecked);
        DataStoreUtils.Companion companion = DataStoreUtils.e;
        companion.a().p("hearing_assist_status", Boolean.valueOf(!isChecked), true);
        hearingAssistFragment.X0(isChecked ^ true ? 1 : 0);
        FragmentHearingAssistBinding fragmentHearingAssistBinding3 = hearingAssistFragment.j;
        if (fragmentHearingAssistBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHearingAssistBinding3 = null;
        }
        LinearLayout linearLayout = fragmentHearingAssistBinding3.h;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "hearingAssinstSet");
        FragmentHearingAssistBinding fragmentHearingAssistBinding4 = hearingAssistFragment.j;
        if (fragmentHearingAssistBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHearingAssistBinding4 = null;
        }
        linearLayout.setVisibility(fragmentHearingAssistBinding4.e.getBinding().i.isChecked() ? 0 : 8);
        boolean z = !isChecked;
        companion.a().p("hearing_assist_music_status", Boolean.valueOf(z), true);
        FragmentHearingAssistBinding fragmentHearingAssistBinding5 = hearingAssistFragment.j;
        if (fragmentHearingAssistBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHearingAssistBinding5 = null;
        }
        fragmentHearingAssistBinding5.i.getBinding().i.setChecked(z);
        hearingAssistFragment.Y0(z ? 1 : 0);
        FragmentHearingAssistBinding fragmentHearingAssistBinding6 = hearingAssistFragment.j;
        if (fragmentHearingAssistBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHearingAssistBinding6 = null;
        }
        hearingAssistFragment.a1(fragmentHearingAssistBinding6.e.getBinding().i.isChecked());
        hearingAssistFragment.b1();
        hearingAssistFragment.L0();
        FragmentHearingAssistBinding fragmentHearingAssistBinding7 = hearingAssistFragment.j;
        if (fragmentHearingAssistBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHearingAssistBinding7 = null;
        }
        if (fragmentHearingAssistBinding7.e.getBinding().i.isChecked()) {
            hearingAssistFragment.c1();
        } else {
            hearingAssistFragment.Z0();
        }
        hearingAssistFragment.I0();
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(hearingAssistFragment), (CoroutineContext) null, (CoroutineStart) null, new HearingAssistFragment$initHearingMode$1$1(hearingAssistFragment, (Continuation<? super HearingAssistFragment$initHearingMode$1$1>) null), 3, (Object) null);
    }

    public static final void Q0(HearingAssistFragment hearingAssistFragment, View view) {
        Intrinsics.checkNotNullParameter(hearingAssistFragment, "this$0");
        FragmentHearingAssistBinding fragmentHearingAssistBinding = hearingAssistFragment.j;
        FragmentHearingAssistBinding fragmentHearingAssistBinding2 = null;
        if (fragmentHearingAssistBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHearingAssistBinding = null;
        }
        boolean isChecked = fragmentHearingAssistBinding.l.getBinding().i.isChecked();
        FragmentHearingAssistBinding fragmentHearingAssistBinding3 = hearingAssistFragment.j;
        if (fragmentHearingAssistBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentHearingAssistBinding2 = fragmentHearingAssistBinding3;
        }
        fragmentHearingAssistBinding2.l.getBinding().i.setChecked(!isChecked);
        SuperNotificationManager.f7749a.J(!isChecked);
        DataStoreUtils.e.a().p("hearing_assist_notify_status", Boolean.valueOf(!isChecked), true);
    }

    public static final void S0(HearingAssistFragment hearingAssistFragment, View view) {
        Intrinsics.checkNotNullParameter(hearingAssistFragment, "this$0");
        FragmentHearingAssistBinding fragmentHearingAssistBinding = hearingAssistFragment.j;
        FragmentHearingAssistBinding fragmentHearingAssistBinding2 = null;
        if (fragmentHearingAssistBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHearingAssistBinding = null;
        }
        boolean isChecked = fragmentHearingAssistBinding.i.getBinding().i.isChecked();
        FragmentHearingAssistBinding fragmentHearingAssistBinding3 = hearingAssistFragment.j;
        if (fragmentHearingAssistBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentHearingAssistBinding2 = fragmentHearingAssistBinding3;
        }
        fragmentHearingAssistBinding2.i.getBinding().i.setChecked(!isChecked);
        DataStoreUtils.e.a().p("hearing_assist_music_status", Boolean.valueOf(!isChecked), true);
        hearingAssistFragment.Y0(isChecked ^ true ? 1 : 0);
        hearingAssistFragment.a1(false);
    }

    public static final void U0(HearingAssistFragment hearingAssistFragment, View view) {
        Intrinsics.checkNotNullParameter(hearingAssistFragment, "this$0");
        FragmentHearingAssistBinding fragmentHearingAssistBinding = hearingAssistFragment.j;
        FragmentHearingAssistBinding fragmentHearingAssistBinding2 = null;
        if (fragmentHearingAssistBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHearingAssistBinding = null;
        }
        boolean isChecked = fragmentHearingAssistBinding.k.getBinding().i.isChecked();
        FragmentHearingAssistBinding fragmentHearingAssistBinding3 = hearingAssistFragment.j;
        if (fragmentHearingAssistBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentHearingAssistBinding2 = fragmentHearingAssistBinding3;
        }
        fragmentHearingAssistBinding2.k.getBinding().i.setChecked(!isChecked);
        NaviManager.getInstance(hearingAssistFragment.requireContext()).setNaviVoiceState(hearingAssistFragment.requireContext(), !isChecked);
        DataStoreUtils.e.a().p("hearing_assist_navi_status", Boolean.valueOf(!isChecked), true);
    }

    public static final void W0(HearingAssistFragment hearingAssistFragment, View view) {
        Intrinsics.checkNotNullParameter(hearingAssistFragment, "this$0");
        StaticMethodUtilsKt.q(hearingAssistFragment);
    }

    private final void initView() {
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        FragmentHearingAssistBinding fragmentHearingAssistBinding = null;
        if (bool.booleanValue()) {
            FragmentHearingAssistBinding fragmentHearingAssistBinding2 = this.j;
            if (fragmentHearingAssistBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentHearingAssistBinding2 = null;
            }
            TextView textView = fragmentHearingAssistBinding2.j;
            String string = getString(R.string.myvu_hearing_mode_desp);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            textView.setText(StringsKt.replace$default(string, "QQ", "", false, 4, (Object) null));
            FragmentHearingAssistBinding fragmentHearingAssistBinding3 = this.j;
            if (fragmentHearingAssistBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentHearingAssistBinding = fragmentHearingAssistBinding3;
            }
            CardItemView cardItemView = fragmentHearingAssistBinding.i;
            String string2 = getString(R.string.myvu_hide_music_title);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            cardItemView.setCardTitleText(StringsKt.replace$default(string2, "QQ", "", false, 4, (Object) null));
        } else {
            FragmentHearingAssistBinding fragmentHearingAssistBinding4 = this.j;
            if (fragmentHearingAssistBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentHearingAssistBinding4 = null;
            }
            fragmentHearingAssistBinding4.j.setText(getString(R.string.myvu_hearing_mode_desp));
            FragmentHearingAssistBinding fragmentHearingAssistBinding5 = this.j;
            if (fragmentHearingAssistBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentHearingAssistBinding = fragmentHearingAssistBinding5;
            }
            fragmentHearingAssistBinding.i.setCardTitleText(getString(R.string.myvu_hide_music_title));
        }
        I0();
        L0();
        V0();
        N0();
        T0();
        P0();
        M0();
        R0();
        J0();
    }

    public final void I0() {
        boolean naviVoiceState = NaviManager.getInstance(requireContext()).getNaviVoiceState(requireContext());
        boolean m = SuperNotificationManager.f7749a.m();
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new HearingAssistFragment$getOrigainStatus$1(this, (Continuation<? super HearingAssistFragment$getOrigainStatus$1>) null), 3, (Object) null);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("HearingAssistFragment", "getOrigainStatus  naviVoiceState= " + naviVoiceState + " notificationBroadcast=" + m);
    }

    public final void J0() {
        FragmentHearingAssistBinding fragmentHearingAssistBinding = this.j;
        if (fragmentHearingAssistBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHearingAssistBinding = null;
        }
        fragmentHearingAssistBinding.b.setOnClickListener(new e5(this));
    }

    public final void L0() {
        DataStoreUtils.Companion companion = DataStoreUtils.e;
        DataStoreUtils a2 = companion.a();
        Boolean bool = Boolean.FALSE;
        boolean booleanValue = ((Boolean) DataStoreUtils.j(a2, "hearing_assist_status", bool, true, (Context) null, 8, (Object) null)).booleanValue();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.c("HearingAssistFragment", "initConfigStatus @@@@@@@@ isHearingAssistOpen=" + booleanValue);
        if (booleanValue) {
            DataStoreUtils a3 = companion.a();
            Boolean bool2 = Boolean.TRUE;
            boolean booleanValue2 = ((Boolean) DataStoreUtils.j(a3, "hearing_assist_navi_status_change", bool2, true, (Context) null, 8, (Object) null)).booleanValue();
            delegate.c("HearingAssistFragment", "initConfigStatus @@@@@@@@ naviVoiceChange=" + booleanValue2);
            if (booleanValue2) {
                companion.a().p("hearing_assist_navi_status", Boolean.valueOf(NaviManager.getInstance(requireContext()).getNaviVoiceState(requireContext())), true);
                companion.a().p("hearing_assist_navi_status_change", bool, true);
            }
            boolean booleanValue3 = ((Boolean) DataStoreUtils.j(companion.a(), "hearing_assist_notify_status_change", bool2, true, (Context) null, 8, (Object) null)).booleanValue();
            delegate.c("HearingAssistFragment", "initConfigStatus ######## notifyChange=" + booleanValue3);
            if (booleanValue3) {
                companion.a().o("hearing_assist_notify_status", Boolean.valueOf(SuperNotificationManager.f7749a.m()));
                companion.a().p("hearing_assist_notify_status_change", bool, true);
            }
            Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new HearingAssistFragment$initConfigStatus$1(this, (Continuation<? super HearingAssistFragment$initConfigStatus$1>) null), 3, (Object) null);
        }
    }

    public final void M0() {
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new HearingAssistFragment$initGptBroadcastResponse$1(this, (Continuation<? super HearingAssistFragment$initGptBroadcastResponse$1>) null), 3, (Object) null);
    }

    public final void N0() {
        boolean booleanValue = ((Boolean) DataStoreUtils.j(DataStoreUtils.e.a(), "hearing_assist_status", Boolean.FALSE, true, (Context) null, 8, (Object) null)).booleanValue();
        ULog.f6446a.g("HearingAssistFragment", "initHearingMode   Enter isHearingAssistOpen=" + booleanValue);
        FragmentHearingAssistBinding fragmentHearingAssistBinding = this.j;
        FragmentHearingAssistBinding fragmentHearingAssistBinding2 = null;
        if (fragmentHearingAssistBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHearingAssistBinding = null;
        }
        fragmentHearingAssistBinding.e.getBinding().i.setChecked(booleanValue);
        FragmentHearingAssistBinding fragmentHearingAssistBinding3 = this.j;
        if (fragmentHearingAssistBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHearingAssistBinding3 = null;
        }
        LinearLayout linearLayout = fragmentHearingAssistBinding3.h;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "hearingAssinstSet");
        linearLayout.setVisibility(booleanValue ? 0 : 8);
        FragmentHearingAssistBinding fragmentHearingAssistBinding4 = this.j;
        if (fragmentHearingAssistBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHearingAssistBinding4 = null;
        }
        fragmentHearingAssistBinding4.e.getBinding().i.setClickable(false);
        FragmentHearingAssistBinding fragmentHearingAssistBinding5 = this.j;
        if (fragmentHearingAssistBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentHearingAssistBinding2 = fragmentHearingAssistBinding5;
        }
        fragmentHearingAssistBinding2.e.setOnClickListener(new d5(this));
    }

    public final void P0() {
        boolean m = SuperNotificationManager.f7749a.m();
        FragmentHearingAssistBinding fragmentHearingAssistBinding = this.j;
        FragmentHearingAssistBinding fragmentHearingAssistBinding2 = null;
        if (fragmentHearingAssistBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHearingAssistBinding = null;
        }
        fragmentHearingAssistBinding.l.getBinding().i.setClickable(false);
        FragmentHearingAssistBinding fragmentHearingAssistBinding3 = this.j;
        if (fragmentHearingAssistBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHearingAssistBinding3 = null;
        }
        fragmentHearingAssistBinding3.l.getBinding().i.setChecked(m);
        FragmentHearingAssistBinding fragmentHearingAssistBinding4 = this.j;
        if (fragmentHearingAssistBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentHearingAssistBinding2 = fragmentHearingAssistBinding4;
        }
        fragmentHearingAssistBinding2.l.setOnClickListener(new g5(this));
    }

    public final void R0() {
        boolean booleanValue = ((Boolean) DataStoreUtils.j(DataStoreUtils.e.a(), "hearing_assist_music_status", Boolean.TRUE, true, (Context) null, 8, (Object) null)).booleanValue();
        FragmentHearingAssistBinding fragmentHearingAssistBinding = this.j;
        FragmentHearingAssistBinding fragmentHearingAssistBinding2 = null;
        if (fragmentHearingAssistBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHearingAssistBinding = null;
        }
        fragmentHearingAssistBinding.i.getBinding().i.setClickable(false);
        FragmentHearingAssistBinding fragmentHearingAssistBinding3 = this.j;
        if (fragmentHearingAssistBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHearingAssistBinding3 = null;
        }
        fragmentHearingAssistBinding3.i.getBinding().i.setChecked(booleanValue);
        FragmentHearingAssistBinding fragmentHearingAssistBinding4 = this.j;
        if (fragmentHearingAssistBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentHearingAssistBinding2 = fragmentHearingAssistBinding4;
        }
        fragmentHearingAssistBinding2.i.setOnClickListener(new f5(this));
    }

    public final void T0() {
        boolean naviVoiceState = NaviManager.getInstance(requireContext()).getNaviVoiceState(requireContext());
        FragmentHearingAssistBinding fragmentHearingAssistBinding = this.j;
        FragmentHearingAssistBinding fragmentHearingAssistBinding2 = null;
        if (fragmentHearingAssistBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHearingAssistBinding = null;
        }
        fragmentHearingAssistBinding.k.getBinding().i.setClickable(false);
        FragmentHearingAssistBinding fragmentHearingAssistBinding3 = this.j;
        if (fragmentHearingAssistBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHearingAssistBinding3 = null;
        }
        fragmentHearingAssistBinding3.k.getBinding().i.setChecked(naviVoiceState);
        FragmentHearingAssistBinding fragmentHearingAssistBinding4 = this.j;
        if (fragmentHearingAssistBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentHearingAssistBinding2 = fragmentHearingAssistBinding4;
        }
        fragmentHearingAssistBinding2.k.setOnClickListener(new c5(this));
    }

    public final void V0() {
        FragmentHearingAssistBinding fragmentHearingAssistBinding = this.j;
        if (fragmentHearingAssistBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHearingAssistBinding = null;
        }
        fragmentHearingAssistBinding.f.setOnClickListener(new h5(this));
    }

    public final void X0(int i) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("status", Integer.valueOf(i));
        DataTrackUtil.n(DataTrackUtil.f7875a, AppDataTrackEvent.APP_AUDITORY_ASSISTANCE, linkedHashMap, false, 4, (Object) null);
    }

    public final void Y0(int i) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("type", Integer.valueOf(i));
        DataTrackUtil.n(DataTrackUtil.f7875a, AppDataTrackEvent.APP_AUDITORY_ASSISTANCE, linkedHashMap, false, 4, (Object) null);
    }

    public final void Z0() {
        boolean naviVoiceState = NaviManager.getInstance(requireContext()).getNaviVoiceState(requireContext());
        DataStoreUtils.Companion companion = DataStoreUtils.e;
        boolean booleanValue = ((Boolean) DataStoreUtils.j(companion.a(), "hearing_assist_navi_status", Boolean.valueOf(naviVoiceState), true, (Context) null, 8, (Object) null)).booleanValue();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.o("HearingAssistFragment", "resetNotification  naviVoiceState=" + naviVoiceState + " naviVoiceStatus=" + booleanValue);
        NaviManager.getInstance(requireContext()).setNaviVoiceState(m0(), booleanValue);
        DataStoreUtils a2 = companion.a();
        Boolean bool = Boolean.TRUE;
        a2.p("hearing_assist_navi_status_change", bool, true);
        SuperNotificationManager superNotificationManager = SuperNotificationManager.f7749a;
        boolean m = superNotificationManager.m();
        boolean booleanValue2 = ((Boolean) DataStoreUtils.j(companion.a(), "hearing_assist_notify_status", Boolean.valueOf(m), true, (Context) null, 8, (Object) null)).booleanValue();
        delegate.o("HearingAssistFragment", "resetNotification  notificationBroadcast=" + m + " notificationStatus=" + booleanValue2);
        superNotificationManager.J(booleanValue2);
        companion.a().p("hearing_assist_notify_status_change", bool, true);
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new HearingAssistFragment$resetNotification$1(this, (Continuation<? super HearingAssistFragment$resetNotification$1>) null), 3, (Object) null);
    }

    public final void a1(boolean z) {
        String str = (String) DataStoreUtils.j(DataStoreUtils.e.a(), "sp_current_bond_device_id", "", true, (Context) null, 8, (Object) null);
        DynamicOperateUtil dynamicOperateUtil = DynamicOperateUtil.f7880a;
        String f = dynamicOperateUtil.f();
        if (z) {
            String E = f != null ? dynamicOperateUtil.E(f, "com.upuphone.ar.transcribe.glasses") : null;
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("HearingAssistFragment", "sendAppListMessage  setFirstList=" + E);
            if (E != null) {
                DynamicOperateUtil.B(dynamicOperateUtil, E, false, 2, (Object) null);
            }
        } else if (f != null) {
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.a("HearingAssistFragment", "sendAppListMessage  appList=" + f);
            DynamicOperateUtil.B(dynamicOperateUtil, f, false, 2, (Object) null);
        }
        dynamicOperateUtil.H(str);
    }

    public final void b1() {
        SuperMessageManger.m.a().i0();
    }

    public final void c1() {
        NaviManager.getInstance(requireContext()).setNaviVoiceState(m0(), false);
        SuperNotificationManager.f7749a.J(false);
        AssistantSettingUtils.b.c(m0(), "chat_gpt_tts_play", false);
        FragmentHearingAssistBinding fragmentHearingAssistBinding = this.j;
        FragmentHearingAssistBinding fragmentHearingAssistBinding2 = null;
        if (fragmentHearingAssistBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHearingAssistBinding = null;
        }
        fragmentHearingAssistBinding.k.getBinding().i.setChecked(false);
        FragmentHearingAssistBinding fragmentHearingAssistBinding3 = this.j;
        if (fragmentHearingAssistBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHearingAssistBinding3 = null;
        }
        fragmentHearingAssistBinding3.l.getBinding().i.setChecked(false);
        FragmentHearingAssistBinding fragmentHearingAssistBinding4 = this.j;
        if (fragmentHearingAssistBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentHearingAssistBinding2 = fragmentHearingAssistBinding4;
        }
        fragmentHearingAssistBinding2.c.getBinding().i.setChecked(false);
    }

    public final void d1(boolean z, boolean z2) {
        ULog.f6446a.a("HearingAssistFragment", "updateChatGptView-> isTTSPlay=" + z + " isCardDisplay=" + z2);
        FragmentHearingAssistBinding fragmentHearingAssistBinding = this.j;
        FragmentHearingAssistBinding fragmentHearingAssistBinding2 = null;
        if (fragmentHearingAssistBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHearingAssistBinding = null;
        }
        fragmentHearingAssistBinding.d.getBinding().i.setChecked(z2);
        FragmentHearingAssistBinding fragmentHearingAssistBinding3 = this.j;
        if (fragmentHearingAssistBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentHearingAssistBinding2 = fragmentHearingAssistBinding3;
        }
        CardItemView cardItemView = fragmentHearingAssistBinding2.c;
        cardItemView.setEnabled(z2);
        cardItemView.getBinding().b.setAlpha(cardItemView.isEnabled() ? 1.0f : 0.3f);
        if (!z2 && !z) {
            cardItemView.performClick();
        }
    }

    public final void e1() {
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new HearingAssistFragment$updateGptStatus$1(this, (Continuation<? super HearingAssistFragment$updateGptStatus$1>) null), 3, (Object) null);
    }

    public final void f1() {
        DataStoreUtils.Companion companion = DataStoreUtils.e;
        boolean booleanValue = ((Boolean) DataStoreUtils.j(companion.a(), "hearing_assist_status", Boolean.FALSE, true, (Context) null, 8, (Object) null)).booleanValue();
        ULog.f6446a.g("HearingAssistFragment", "updateViewStatus   Enter isHearingAssistOpen=" + booleanValue);
        FragmentHearingAssistBinding fragmentHearingAssistBinding = this.j;
        FragmentHearingAssistBinding fragmentHearingAssistBinding2 = null;
        if (fragmentHearingAssistBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHearingAssistBinding = null;
        }
        fragmentHearingAssistBinding.e.getBinding().i.setChecked(booleanValue);
        FragmentHearingAssistBinding fragmentHearingAssistBinding3 = this.j;
        if (fragmentHearingAssistBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHearingAssistBinding3 = null;
        }
        LinearLayout linearLayout = fragmentHearingAssistBinding3.h;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "hearingAssinstSet");
        linearLayout.setVisibility(booleanValue ? 0 : 8);
        FragmentHearingAssistBinding fragmentHearingAssistBinding4 = this.j;
        if (fragmentHearingAssistBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHearingAssistBinding4 = null;
        }
        fragmentHearingAssistBinding4.k.getBinding().i.setChecked(NaviManager.getInstance(requireContext()).getNaviVoiceState(requireContext()));
        FragmentHearingAssistBinding fragmentHearingAssistBinding5 = this.j;
        if (fragmentHearingAssistBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentHearingAssistBinding5 = null;
        }
        fragmentHearingAssistBinding5.l.getBinding().i.setChecked(SuperNotificationManager.f7749a.m());
        e1();
        boolean booleanValue2 = ((Boolean) DataStoreUtils.j(companion.a(), "hearing_assist_music_status", Boolean.TRUE, true, (Context) null, 8, (Object) null)).booleanValue();
        FragmentHearingAssistBinding fragmentHearingAssistBinding6 = this.j;
        if (fragmentHearingAssistBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentHearingAssistBinding2 = fragmentHearingAssistBinding6;
        }
        fragmentHearingAssistBinding2.i.getBinding().i.setChecked(booleanValue2);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentHearingAssistBinding c = FragmentHearingAssistBinding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.j = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        ConstraintLayout b = c.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        return b;
    }

    public void onResume() {
        super.onResume();
        ULog.f6446a.g("HearingAssistFragment", "initHearingMode  onResume Enter ");
        f1();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ULog.f6446a.g("HearingAssistFragment", "onViewCreated");
        initView();
    }
}
