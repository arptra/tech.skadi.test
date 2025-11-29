package com.upuphone.xr.sapp.fragment;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.fragment.FragmentKt;
import com.alibaba.fastjson.asm.Opcodes;
import com.honey.account.h8.kb;
import com.meizu.common.widget.Switch;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentWiseNotifyBinding;
import com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager;
import com.upuphone.xr.sapp.monitor.notification.constants.ReminderType;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 )2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J+\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0003J/\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u0003J;\u0010#\u001a\u00020\u0004*\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u00152\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040!H\u0002¢\u0006\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/WiseNotifyFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "initView", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "", "result", "", "reason", "permission", "tag", "w0", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "C0", "Landroid/widget/TextView;", "", "res", "clickRes", "color", "Lkotlin/Function0;", "onClick", "E0", "(Landroid/widget/TextView;IILjava/lang/String;Lkotlin/jvm/functions/Function0;)V", "Lcom/upuphone/xr/sapp/databinding/FragmentWiseNotifyBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentWiseNotifyBinding;", "binding", "k", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nWiseNotifyFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WiseNotifyFragment.kt\ncom/upuphone/xr/sapp/fragment/WiseNotifyFragment\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,214:1\n256#2,2:215\n256#2,2:217\n*S KotlinDebug\n*F\n+ 1 WiseNotifyFragment.kt\ncom/upuphone/xr/sapp/fragment/WiseNotifyFragment\n*L\n74#1:215,2\n75#1:217,2\n*E\n"})
public final class WiseNotifyFragment extends BaseFragment {
    public static final Companion k = new Companion((DefaultConstructorMarker) null);
    public FragmentWiseNotifyBinding j;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/WiseNotifyFragment$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static final void D0(WiseNotifyFragment wiseNotifyFragment, View view) {
        Intrinsics.checkNotNullParameter(wiseNotifyFragment, "this$0");
        FragmentKt.a(wiseNotifyFragment).T();
    }

    public static /* synthetic */ void F0(WiseNotifyFragment wiseNotifyFragment, TextView textView, int i, int i2, String str, Function0 function0, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str = "#1368FB";
        }
        wiseNotifyFragment.E0(textView, i, i2, str, function0);
    }

    private final void initView() {
        ULog.f6446a.a("WiseNotifyFragment", "initView");
        FragmentWiseNotifyBinding fragmentWiseNotifyBinding = this.j;
        FragmentWiseNotifyBinding fragmentWiseNotifyBinding2 = null;
        if (fragmentWiseNotifyBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentWiseNotifyBinding = null;
        }
        fragmentWiseNotifyBinding.d.setOnClickListener(new kb(this));
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.c()), (CoroutineContext) null, (CoroutineStart) null, new WiseNotifyFragment$initView$2(this, (Continuation<? super WiseNotifyFragment$initView$2>) null), 3, (Object) null);
        FragmentWiseNotifyBinding fragmentWiseNotifyBinding3 = this.j;
        if (fragmentWiseNotifyBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentWiseNotifyBinding3 = null;
        }
        Switch switchR = fragmentWiseNotifyBinding3.q;
        SuperNotificationManager superNotificationManager = SuperNotificationManager.f7749a;
        switchR.setChecked(superNotificationManager.s(ReminderType.MSG_TYPE_REMINDER));
        FragmentWiseNotifyBinding fragmentWiseNotifyBinding4 = this.j;
        if (fragmentWiseNotifyBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentWiseNotifyBinding4 = null;
        }
        fragmentWiseNotifyBinding4.x.setChecked(superNotificationManager.s(ReminderType.MSG_TYPE_TAXI));
        FragmentWiseNotifyBinding fragmentWiseNotifyBinding5 = this.j;
        if (fragmentWiseNotifyBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentWiseNotifyBinding5 = null;
        }
        fragmentWiseNotifyBinding5.h.setChecked(superNotificationManager.s("MSG_TYPE_FLIGHT"));
        FragmentWiseNotifyBinding fragmentWiseNotifyBinding6 = this.j;
        if (fragmentWiseNotifyBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentWiseNotifyBinding6 = null;
        }
        Switch switchR2 = fragmentWiseNotifyBinding6.t;
        Intrinsics.checkNotNullExpressionValue(switchR2, "wiseNotifySwitch");
        GlobalExtKt.j(switchR2, WiseNotifyFragment$initView$3.INSTANCE);
        FragmentWiseNotifyBinding fragmentWiseNotifyBinding7 = this.j;
        if (fragmentWiseNotifyBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentWiseNotifyBinding7 = null;
        }
        Switch switchR3 = fragmentWiseNotifyBinding7.h;
        Intrinsics.checkNotNullExpressionValue(switchR3, "wiseNotifyFlightSwitch");
        GlobalExtKt.j(switchR3, WiseNotifyFragment$initView$4.INSTANCE);
        FragmentWiseNotifyBinding fragmentWiseNotifyBinding8 = this.j;
        if (fragmentWiseNotifyBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentWiseNotifyBinding8 = null;
        }
        Switch switchR4 = fragmentWiseNotifyBinding8.q;
        Intrinsics.checkNotNullExpressionValue(switchR4, "wiseNotifyScheduleSwitch");
        GlobalExtKt.j(switchR4, WiseNotifyFragment$initView$5.INSTANCE);
        FragmentWiseNotifyBinding fragmentWiseNotifyBinding9 = this.j;
        if (fragmentWiseNotifyBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentWiseNotifyBinding9 = null;
        }
        Switch switchR5 = fragmentWiseNotifyBinding9.x;
        Intrinsics.checkNotNullExpressionValue(switchR5, "wiseNotifyTaxiSwitch");
        GlobalExtKt.j(switchR5, WiseNotifyFragment$initView$6.INSTANCE);
        FragmentWiseNotifyBinding fragmentWiseNotifyBinding10 = this.j;
        if (fragmentWiseNotifyBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentWiseNotifyBinding10 = null;
        }
        AppCompatTextView appCompatTextView = fragmentWiseNotifyBinding10.m;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "wiseNotifyScheduleDesc");
        F0(this, appCompatTextView, R.string.wise_notify_schedule_desc, R.string.wise_notify_schedule_desc_click, (String) null, new WiseNotifyFragment$initView$7(this), 4, (Object) null);
        FragmentWiseNotifyBinding fragmentWiseNotifyBinding11 = this.j;
        if (fragmentWiseNotifyBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentWiseNotifyBinding11 = null;
        }
        AppCompatTextView appCompatTextView2 = fragmentWiseNotifyBinding11.p;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView2, "wiseNotifySchedulePermission");
        F0(this, appCompatTextView2, R.string.wise_notify_schedule_permission, R.string.wise_notify_schedule_permission_click, (String) null, new WiseNotifyFragment$initView$8(this), 4, (Object) null);
        FragmentWiseNotifyBinding fragmentWiseNotifyBinding12 = this.j;
        if (fragmentWiseNotifyBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentWiseNotifyBinding2 = fragmentWiseNotifyBinding12;
        }
        AppCompatTextView appCompatTextView3 = fragmentWiseNotifyBinding2.f;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView3, "wiseNotifyFlightDesc");
        F0(this, appCompatTextView3, R.string.wise_notify_flight_desc, R.string.wise_notify_flight_desc_click, (String) null, new WiseNotifyFragment$initView$9(this), 4, (Object) null);
    }

    public final void C0() {
        boolean a2 = StaticMethodUtilsKt.a(this, PermissionAndStateCheckUtils.f7907a.r());
        FragmentWiseNotifyBinding fragmentWiseNotifyBinding = this.j;
        FragmentWiseNotifyBinding fragmentWiseNotifyBinding2 = null;
        if (fragmentWiseNotifyBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentWiseNotifyBinding = null;
        }
        View view = fragmentWiseNotifyBinding.o;
        Intrinsics.checkNotNullExpressionValue(view, "wiseNotifySchedulePartition");
        int i = 8;
        view.setVisibility(a2 ^ true ? 0 : 8);
        FragmentWiseNotifyBinding fragmentWiseNotifyBinding3 = this.j;
        if (fragmentWiseNotifyBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentWiseNotifyBinding2 = fragmentWiseNotifyBinding3;
        }
        AppCompatTextView appCompatTextView = fragmentWiseNotifyBinding2.p;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "wiseNotifySchedulePermission");
        if (!a2) {
            i = 0;
        }
        appCompatTextView.setVisibility(i);
    }

    public final void E0(TextView textView, int i, int i2, String str, Function0 function0) {
        String string = textView.getResources().getString(i2);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = textView.getResources().getString(i);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!StringsKt.contains$default((CharSequence) string2, (CharSequence) string, false, 2, (Object) null)) {
            textView.setText(string2);
            return;
        }
        spannableStringBuilder.append(textView.getResources().getString(i));
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        String str2 = string;
        spannableStringBuilder.setSpan(new WiseNotifyFragment$spannableTxt$1(str, function0), StringsKt.indexOf$default((CharSequence) spannableStringBuilder2, str2, 0, false, 6, (Object) null), StringsKt.indexOf$default((CharSequence) spannableStringBuilder2, str2, 0, false, 6, (Object) null) + string.length(), 33);
        textView.setText(spannableStringBuilder);
        textView.setHighlightColor(0);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentWiseNotifyBinding c = FragmentWiseNotifyBinding.c(layoutInflater, viewGroup, false);
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
        C0();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView();
    }

    public void w0(boolean z, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "reason");
        Intrinsics.checkNotNullParameter(str2, "permission");
        Intrinsics.checkNotNullParameter(str3, "tag");
        super.w0(z, str, str2, str3);
        if (!z) {
            StaticMethodUtilsKt.I(this, CollectionsKt.arrayListOf(Integer.valueOf(Opcodes.IF_ICMPGT)), false, false, 6, (Object) null);
        }
    }
}
