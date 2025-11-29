package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.navigation.fragment.FragmentKt;
import com.honey.account.h8.ga;
import com.honey.account.h8.ha;
import com.honey.account.h8.ia;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.air.AirHelper;
import com.upuphone.xr.sapp.common.MzAccountManager;
import com.upuphone.xr.sapp.contract.AssistantTtsTimbreSelector;
import com.upuphone.xr.sapp.databinding.FragmentVoiceAssistantsSettingsBinding;
import com.upuphone.xr.sapp.glass.GlassHelper;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.DataTrackUtil;
import com.upuphone.xr.sapp.view.SettingView;
import com.xjsd.ai.assistant.connect.InterconnectAbility;
import com.xjsd.ai.assistant.connect.OnDeviceStateChangeListener;
import com.xjsd.ai.assistant.phone.helper.AssistantSettingUtils;
import com.xjsd.ai.assistant.phone.helper.VersionUtil;
import flyme.support.v7.app.AlertDialog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 T2\u00020\u0001:\u0003UVWB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u001b\u0010\u000f\u001a\u00020\u0004*\u00020\f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u0004\u0018\u00010\r*\u00020\rH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u0004\u0018\u00010\r*\u00020\rH\u0002¢\u0006\u0004\b\u0016\u0010\u0015J+\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\r2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u0003J\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ+\u0010'\u001a\u00020&2\u0006\u0010!\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b'\u0010(J!\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0004H\u0016¢\u0006\u0004\b,\u0010\u0003J\u000f\u0010-\u001a\u00020\u0004H\u0016¢\u0006\u0004\b-\u0010\u0003R\u0016\u00101\u001a\u00020.8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b/\u00100R\u001d\u00107\u001a\u0004\u0018\u0001028BX\u0002¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R$\u0010@\u001a\u00020\b2\u0006\u0010<\u001a\u00020\b8\u0002@BX\u000e¢\u0006\f\n\u0004\b=\u0010>\"\u0004\b?\u0010\u001fR\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010CR#\u0010J\u001a\n F*\u0004\u0018\u00010E0E8BX\u0002¢\u0006\f\n\u0004\bG\u00104\u001a\u0004\bH\u0010IR\u0016\u0010L\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u0010>R\u0016\u0010N\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u0010>R\u001b\u0010Q\u001a\u00020E8BX\u0002¢\u0006\f\n\u0004\bO\u00104\u001a\u0004\bP\u0010IR\u0014\u0010S\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\bR\u0010\n¨\u0006X"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/VoiceAssistantsSettingsFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "", "v0", "P0", "I0", "", "E0", "()Z", "F0", "Lcom/upuphone/xr/sapp/view/SettingView;", "", "mark", "L0", "(Lcom/upuphone/xr/sapp/view/SettingView;Ljava/lang/String;)V", "isChecked", "D0", "(Ljava/lang/String;Z)V", "y0", "(Ljava/lang/String;)Ljava/lang/String;", "z0", "eventName", "", "attributes", "K0", "(Ljava/lang/String;Ljava/util/Map;)V", "w0", "isServerError", "O0", "(Z)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onDestroyView", "Lcom/upuphone/xr/sapp/databinding/FragmentVoiceAssistantsSettingsBinding;", "a", "Lcom/upuphone/xr/sapp/databinding/FragmentVoiceAssistantsSettingsBinding;", "binding", "Lcom/xjsd/ai/assistant/connect/InterconnectAbility;", "b", "Lkotlin/Lazy;", "A0", "()Lcom/xjsd/ai/assistant/connect/InterconnectAbility;", "interconnectAbility", "Lcom/xjsd/ai/assistant/connect/OnDeviceStateChangeListener;", "c", "Lcom/xjsd/ai/assistant/connect/OnDeviceStateChangeListener;", "mInterConnectListener", "value", "d", "Z", "N0", "showTtsTimbreSet", "", "e", "I", "initSelect", "Lflyme/support/v7/app/AlertDialog;", "kotlin.jvm.PlatformType", "f", "C0", "()Lflyme/support/v7/app/AlertDialog;", "mLlmReplyDialog", "g", "hasCheckProtocol", "h", "hasAgreedProtocol", "i", "B0", "mErrorDialog", "G0", "isGlassConnected", "j", "AssistantDataEventType", "AssistantDataParameterType", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nVoiceAssistantsSettingsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoiceAssistantsSettingsFragment.kt\ncom/upuphone/xr/sapp/fragment/VoiceAssistantsSettingsFragment\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,518:1\n256#2,2:519\n256#2,2:521\n256#2,2:523\n256#2,2:525\n256#2,2:527\n*S KotlinDebug\n*F\n+ 1 VoiceAssistantsSettingsFragment.kt\ncom/upuphone/xr/sapp/fragment/VoiceAssistantsSettingsFragment\n*L\n79#1:519,2\n85#1:521,2\n130#1:523,2\n133#1:525,2\n139#1:527,2\n*E\n"})
public final class VoiceAssistantsSettingsFragment extends Fragment {
    public static final Companion j = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public FragmentVoiceAssistantsSettingsBinding f7014a;
    public final Lazy b = LazyKt.lazy(VoiceAssistantsSettingsFragment$interconnectAbility$2.INSTANCE);
    public final OnDeviceStateChangeListener c = new ga(this);
    public boolean d;
    public int e;
    public final Lazy f = LazyKt.lazy(new VoiceAssistantsSettingsFragment$mLlmReplyDialog$2(this));
    public boolean g;
    public boolean h;
    public final Lazy i = LazyKt.lazy(new VoiceAssistantsSettingsFragment$mErrorDialog$2(this));

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/VoiceAssistantsSettingsFragment$AssistantDataEventType;", "", "<init>", "()V", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AssistantDataEventType {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/VoiceAssistantsSettingsFragment$AssistantDataEventType$Companion;", "", "<init>", "()V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
        public static final class Companion {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ Companion f7015a = new Companion();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/VoiceAssistantsSettingsFragment$AssistantDataParameterType;", "", "<init>", "()V", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AssistantDataParameterType {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/VoiceAssistantsSettingsFragment$AssistantDataParameterType$Companion;", "", "<init>", "()V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
        public static final class Companion {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ Companion f7016a = new Companion();
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/VoiceAssistantsSettingsFragment$Companion;", "", "()V", "ITEM_DISABLE_ALPHA", "", "LLM_REPLY", "", "REPORT_EVENT", "", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    private final boolean G0() {
        return GlassHelper.f7049a.E();
    }

    public static final void H0(VoiceAssistantsSettingsFragment voiceAssistantsSettingsFragment, StarryNetDevice starryNetDevice, boolean z) {
        Intrinsics.checkNotNullParameter(voiceAssistantsSettingsFragment, "this$0");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("VoiceAssistantsFragment", "onStateChanged: 互联互通设备->" + starryNetDevice + ", isConnected->" + z);
        if (!z) {
            voiceAssistantsSettingsFragment.I0();
        }
        voiceAssistantsSettingsFragment.v0();
    }

    public static final void J0(VoiceAssistantsSettingsFragment voiceAssistantsSettingsFragment, View view) {
        Intrinsics.checkNotNullParameter(voiceAssistantsSettingsFragment, "this$0");
        FragmentKt.a(voiceAssistantsSettingsFragment).T();
    }

    public static final void M0(VoiceAssistantsSettingsFragment voiceAssistantsSettingsFragment, String str, SettingView settingView, View view) {
        Intrinsics.checkNotNullParameter(voiceAssistantsSettingsFragment, "this$0");
        Intrinsics.checkNotNullParameter(str, "$mark");
        Intrinsics.checkNotNullParameter(settingView, "$this_setItemClickListener");
        String y0 = voiceAssistantsSettingsFragment.y0(str);
        if (y0 != null) {
            voiceAssistantsSettingsFragment.K0("click_VoiceAssistantPage", MapsKt.mapOf(TuplesKt.to("type", y0)));
        }
        if (!voiceAssistantsSettingsFragment.G0()) {
            voiceAssistantsSettingsFragment.I0();
        } else if (Intrinsics.areEqual((Object) str, (Object) "tts_timbre")) {
            FragmentActivity requireActivity = voiceAssistantsSettingsFragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
            new AssistantTtsTimbreSelector(requireActivity).h();
        } else if (Intrinsics.areEqual((Object) str, (Object) "llm_reply")) {
            voiceAssistantsSettingsFragment.C0().show();
        } else {
            voiceAssistantsSettingsFragment.D0(str, !settingView.getBinding().f.isChecked());
        }
    }

    /* access modifiers changed from: private */
    public final void P0() {
        Context context = getContext();
        if (context != null) {
            Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new VoiceAssistantsSettingsFragment$updateUi$1$1(context, this, (Continuation<? super VoiceAssistantsSettingsFragment$updateUi$1$1>) null), 3, (Object) null);
        }
    }

    public final InterconnectAbility A0() {
        return (InterconnectAbility) this.b.getValue();
    }

    public final AlertDialog B0() {
        Object value = this.i.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (AlertDialog) value;
    }

    public final AlertDialog C0() {
        return (AlertDialog) this.f.getValue();
    }

    public final void D0(String str, boolean z) {
        AssistantSettingUtils.b.c(getContext(), str, z);
        String z0 = z0(str);
        if (z0 != null) {
            K0("status_VoiceAssistantPage", MapsKt.mapOf(TuplesKt.to(z0, z ? "1" : "0")));
        }
        if (Intrinsics.areEqual((Object) "chat_gpt_tts_play", (Object) str)) {
            DataStoreUtils.e.a().p("hearing_assist_gpt_tts_status_change", Boolean.TRUE, true);
        }
        if (Intrinsics.areEqual((Object) "chat_gpt_card_display", (Object) str)) {
            DataStoreUtils.e.a().p("hearing_assist_gpt_card_status_change", Boolean.TRUE, true);
        }
    }

    public final boolean E0() {
        StarryNetDevice x = GlassHelper.f7049a.x();
        if (x != null) {
            return AirHelper.b.I(x);
        }
        return false;
    }

    public final boolean F0() {
        StarryNetDevice x = GlassHelper.f7049a.x();
        if (x != null) {
            return AirHelper.b.K(x);
        }
        return false;
    }

    public final void I0() {
        UToast.Companion companion = UToast.f6444a;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        String string = getString(R.string.device_disconnect);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.d(requireContext, string);
    }

    public final void K0(String str, Map map) {
        DataTrackUtil.n(DataTrackUtil.f7875a, str, map, false, 4, (Object) null);
    }

    public final void L0(SettingView settingView, String str) {
        settingView.getBinding().f.setClickable(false);
        settingView.setOnClickListener(new ia(this, str, settingView));
    }

    public final void N0(boolean z) {
        this.d = z;
        FragmentVoiceAssistantsSettingsBinding fragmentVoiceAssistantsSettingsBinding = null;
        if (z) {
            FragmentVoiceAssistantsSettingsBinding fragmentVoiceAssistantsSettingsBinding2 = this.f7014a;
            if (fragmentVoiceAssistantsSettingsBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentVoiceAssistantsSettingsBinding2 = null;
            }
            fragmentVoiceAssistantsSettingsBinding2.c.setBackground(AppCompatResources.b(requireContext(), R.drawable.common_single_item_bg_rectangle));
            FragmentVoiceAssistantsSettingsBinding fragmentVoiceAssistantsSettingsBinding3 = this.f7014a;
            if (fragmentVoiceAssistantsSettingsBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentVoiceAssistantsSettingsBinding = fragmentVoiceAssistantsSettingsBinding3;
            }
            SettingView settingView = fragmentVoiceAssistantsSettingsBinding.f;
            Intrinsics.checkNotNullExpressionValue(settingView, "itemTtsTimbre");
            settingView.setVisibility(0);
            return;
        }
        FragmentVoiceAssistantsSettingsBinding fragmentVoiceAssistantsSettingsBinding4 = this.f7014a;
        if (fragmentVoiceAssistantsSettingsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVoiceAssistantsSettingsBinding4 = null;
        }
        fragmentVoiceAssistantsSettingsBinding4.c.setBackground(AppCompatResources.b(requireContext(), R.drawable.common_single_item_bg_bottom));
        FragmentVoiceAssistantsSettingsBinding fragmentVoiceAssistantsSettingsBinding5 = this.f7014a;
        if (fragmentVoiceAssistantsSettingsBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentVoiceAssistantsSettingsBinding = fragmentVoiceAssistantsSettingsBinding5;
        }
        SettingView settingView2 = fragmentVoiceAssistantsSettingsBinding.f;
        Intrinsics.checkNotNullExpressionValue(settingView2, "itemTtsTimbre");
        settingView2.setVisibility(8);
    }

    public final void O0(boolean z) {
        if (!B0().isShowing()) {
            B0().show();
        }
        View findViewById = B0().findViewById(R.id.tv_content);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById;
        if (z) {
            textView.setText(getString(R.string.service_error_pls_retry_later));
        } else {
            textView.setText(getString(R.string.network_error_pls_retry_later));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentVoiceAssistantsSettingsBinding c2 = FragmentVoiceAssistantsSettingsBinding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
        this.f7014a = c2;
        if (c2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c2 = null;
        }
        LinearLayout b2 = c2.getRoot();
        Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
        return b2;
    }

    public void onDestroyView() {
        super.onDestroyView();
        InterconnectAbility A0 = A0();
        if (A0 != null) {
            A0.unregisterOnDeviceStateChangeListener(this.c);
        }
    }

    public void onResume() {
        super.onResume();
        P0();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        v0();
        InterconnectAbility A0 = A0();
        if (A0 != null) {
            A0.registerOnDeviceStateChangeListener(this.c);
        }
        FragmentVoiceAssistantsSettingsBinding fragmentVoiceAssistantsSettingsBinding = this.f7014a;
        if (fragmentVoiceAssistantsSettingsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVoiceAssistantsSettingsBinding = null;
        }
        fragmentVoiceAssistantsSettingsBinding.b.setOnClickListener(new ha(this));
        FragmentVoiceAssistantsSettingsBinding fragmentVoiceAssistantsSettingsBinding2 = this.f7014a;
        if (fragmentVoiceAssistantsSettingsBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVoiceAssistantsSettingsBinding2 = null;
        }
        SettingView settingView = fragmentVoiceAssistantsSettingsBinding2.g;
        Intrinsics.checkNotNullExpressionValue(settingView, "itemVoiceWakeup");
        L0(settingView, "low_power_wakeup");
        FragmentVoiceAssistantsSettingsBinding fragmentVoiceAssistantsSettingsBinding3 = this.f7014a;
        if (fragmentVoiceAssistantsSettingsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVoiceAssistantsSettingsBinding3 = null;
        }
        SettingView settingView2 = fragmentVoiceAssistantsSettingsBinding3.h;
        Intrinsics.checkNotNullExpressionValue(settingView2, "itemVoiceWakeupOnScreenOff");
        L0(settingView2, "low_power_wakeup_screen_off");
        FragmentVoiceAssistantsSettingsBinding fragmentVoiceAssistantsSettingsBinding4 = this.f7014a;
        if (fragmentVoiceAssistantsSettingsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVoiceAssistantsSettingsBinding4 = null;
        }
        SettingView settingView3 = fragmentVoiceAssistantsSettingsBinding4.d;
        Intrinsics.checkNotNullExpressionValue(settingView3, "itemContinueDialog");
        L0(settingView3, "continuous_dialogue");
        FragmentVoiceAssistantsSettingsBinding fragmentVoiceAssistantsSettingsBinding5 = this.f7014a;
        if (fragmentVoiceAssistantsSettingsBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVoiceAssistantsSettingsBinding5 = null;
        }
        SettingView settingView4 = fragmentVoiceAssistantsSettingsBinding5.c;
        Intrinsics.checkNotNullExpressionValue(settingView4, "itemAsrDisplay");
        L0(settingView4, "asr_result_screen");
        FragmentVoiceAssistantsSettingsBinding fragmentVoiceAssistantsSettingsBinding6 = this.f7014a;
        if (fragmentVoiceAssistantsSettingsBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVoiceAssistantsSettingsBinding6 = null;
        }
        SettingView settingView5 = fragmentVoiceAssistantsSettingsBinding6.f;
        Intrinsics.checkNotNullExpressionValue(settingView5, "itemTtsTimbre");
        L0(settingView5, "tts_timbre");
        FragmentVoiceAssistantsSettingsBinding fragmentVoiceAssistantsSettingsBinding7 = this.f7014a;
        if (fragmentVoiceAssistantsSettingsBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVoiceAssistantsSettingsBinding7 = null;
        }
        SettingView settingView6 = fragmentVoiceAssistantsSettingsBinding7.e;
        Intrinsics.checkNotNullExpressionValue(settingView6, "itemLlmReply");
        L0(settingView6, "llm_reply");
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new VoiceAssistantsSettingsFragment$onViewCreated$2(this, (Continuation<? super VoiceAssistantsSettingsFragment$onViewCreated$2>) null), 3, (Object) null);
        w0();
    }

    public final void v0() {
        boolean E0 = E0();
        Boolean bool = BuildConfig.f6575a;
        ULog.f6446a.a("VoiceAssistantsFragment", "bindingViewByDevice: isAirGlass->" + E0 + ", isOversea->" + bool);
        boolean z = false;
        FragmentVoiceAssistantsSettingsBinding fragmentVoiceAssistantsSettingsBinding = null;
        if (!E0) {
            FragmentVoiceAssistantsSettingsBinding fragmentVoiceAssistantsSettingsBinding2 = this.f7014a;
            if (fragmentVoiceAssistantsSettingsBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentVoiceAssistantsSettingsBinding = fragmentVoiceAssistantsSettingsBinding2;
            }
            SettingView settingView = fragmentVoiceAssistantsSettingsBinding.h;
            Intrinsics.checkNotNullExpressionValue(settingView, "itemVoiceWakeupOnScreenOff");
            settingView.setVisibility(8);
            N0(false);
        } else if (F0()) {
            FragmentVoiceAssistantsSettingsBinding fragmentVoiceAssistantsSettingsBinding3 = this.f7014a;
            if (fragmentVoiceAssistantsSettingsBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentVoiceAssistantsSettingsBinding = fragmentVoiceAssistantsSettingsBinding3;
            }
            SettingView settingView2 = fragmentVoiceAssistantsSettingsBinding.h;
            Intrinsics.checkNotNullExpressionValue(settingView2, "itemVoiceWakeupOnScreenOff");
            settingView2.setVisibility(8);
            N0(!bool.booleanValue());
        } else {
            FragmentVoiceAssistantsSettingsBinding fragmentVoiceAssistantsSettingsBinding4 = this.f7014a;
            if (fragmentVoiceAssistantsSettingsBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentVoiceAssistantsSettingsBinding = fragmentVoiceAssistantsSettingsBinding4;
            }
            SettingView settingView3 = fragmentVoiceAssistantsSettingsBinding.h;
            Intrinsics.checkNotNullExpressionValue(settingView3, "itemVoiceWakeupOnScreenOff");
            settingView3.setVisibility(0);
            if (!bool.booleanValue() && VersionUtil.f8566a.c(com.meizu.account.oauth.BuildConfig.VERSION_NAME)) {
                z = true;
            }
            N0(z);
        }
    }

    public final void w0() {
        if (!this.g) {
            if (!MzAccountManager.c.c()) {
                ULog.f6446a.a("VoiceAssistantsFragment", "checkProtocolState: 未登录，不显示协议弹窗");
                return;
            }
            this.g = true;
            Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new VoiceAssistantsSettingsFragment$checkProtocolState$1(this, (Continuation<? super VoiceAssistantsSettingsFragment$checkProtocolState$1>) null), 3, (Object) null);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String y0(java.lang.String r2) {
        /*
            r1 = this;
            int r1 = r2.hashCode()
            r0 = 0
            switch(r1) {
                case -2089748325: goto L_0x0078;
                case -1948256433: goto L_0x0069;
                case -1904774376: goto L_0x0059;
                case -1536739064: goto L_0x004a;
                case -1406570633: goto L_0x003b;
                case -597320786: goto L_0x002c;
                case -137524663: goto L_0x001b;
                case 1320798916: goto L_0x000a;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0080
        L_0x000a:
            java.lang.String r1 = "low_power_wakeup"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x0014
            goto L_0x0080
        L_0x0014:
            r1 = 1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0087
        L_0x001b:
            java.lang.String r1 = "tts_timbre"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x0025
            goto L_0x0080
        L_0x0025:
            r1 = 8
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0087
        L_0x002c:
            java.lang.String r1 = "chat_gpt_card_display"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x0035
            goto L_0x0080
        L_0x0035:
            r1 = 6
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0087
        L_0x003b:
            java.lang.String r1 = "low_power_wakeup_screen_off"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x0044
            goto L_0x0080
        L_0x0044:
            r1 = 2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0087
        L_0x004a:
            java.lang.String r1 = "continuous_dialogue"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x0053
            goto L_0x0080
        L_0x0053:
            r1 = 3
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0087
        L_0x0059:
            java.lang.String r1 = "llm_reply"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x0062
            goto L_0x0080
        L_0x0062:
            r1 = 9
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0087
        L_0x0069:
            java.lang.String r1 = "asr_result_screen"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x0072
            goto L_0x0080
        L_0x0072:
            r1 = 4
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0087
        L_0x0078:
            java.lang.String r1 = "chat_gpt_tts_play"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x0082
        L_0x0080:
            r1 = r0
            goto L_0x0087
        L_0x0082:
            r1 = 5
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x0087:
            if (r1 == 0) goto L_0x008d
            java.lang.String r0 = r1.toString()
        L_0x008d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.fragment.VoiceAssistantsSettingsFragment.y0(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004c A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String z0(java.lang.String r1) {
        /*
            r0 = this;
            int r0 = r1.hashCode()
            switch(r0) {
                case -2089748325: goto L_0x0044;
                case -1948256433: goto L_0x0038;
                case -1536739064: goto L_0x002c;
                case -1406570633: goto L_0x0020;
                case -597320786: goto L_0x0014;
                case 1320798916: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x004c
        L_0x0008:
            java.lang.String r0 = "low_power_wakeup"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0011
            goto L_0x004c
        L_0x0011:
            java.lang.String r0 = "status_VT_Switch"
            goto L_0x0050
        L_0x0014:
            java.lang.String r0 = "chat_gpt_card_display"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x001d
            goto L_0x004c
        L_0x001d:
            java.lang.String r0 = "status_model_Switch"
            goto L_0x0050
        L_0x0020:
            java.lang.String r0 = "low_power_wakeup_screen_off"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0029
            goto L_0x004c
        L_0x0029:
            java.lang.String r0 = "status_VT_TurnOffScreen_Switch"
            goto L_0x0050
        L_0x002c:
            java.lang.String r0 = "continuous_dialogue"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0035
            goto L_0x004c
        L_0x0035:
            java.lang.String r0 = "status_ContinuousDialogue_Switch"
            goto L_0x0050
        L_0x0038:
            java.lang.String r0 = "asr_result_screen"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0041
            goto L_0x004c
        L_0x0041:
            java.lang.String r0 = "status_ASR_Switch"
            goto L_0x0050
        L_0x0044:
            java.lang.String r0 = "chat_gpt_tts_play"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x004e
        L_0x004c:
            r0 = 0
            goto L_0x0050
        L_0x004e:
            java.lang.String r0 = "status_TTS_Switch"
        L_0x0050:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.fragment.VoiceAssistantsSettingsFragment.z0(java.lang.String):java.lang.String");
    }
}
