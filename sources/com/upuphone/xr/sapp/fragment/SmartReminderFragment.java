package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Layout;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alibaba.fastjson.asm.Opcodes;
import com.honey.account.h8.h9;
import com.honey.account.h8.i9;
import com.honey.account.h8.j9;
import com.meizu.common.widget.Switch;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.context.GlassInfoExtKt;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.databinding.FragmentSmartReminderBinding;
import com.upuphone.xr.sapp.datatrack.ReminderDataTrackEvent;
import com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.utils.VersionMatchHelper;
import com.upuphone.xr.sapp.view.CardItemView;
import com.upuphone.xr.sapp.view.GenericMenuView;
import com.upuphone.xr.sapp.view.LinearGradientForegroundSpan;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 O2\u00020\u0001:\u0001PB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0003J\u001f\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ7\u0010$\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00072\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010!2\u0006\u0010#\u001a\u00020\u0007H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0004H\u0002¢\u0006\u0004\b&\u0010\u0003J\u000f\u0010'\u001a\u00020\u0004H\u0002¢\u0006\u0004\b'\u0010\u0003J\u000f\u0010(\u001a\u00020\u0004H\u0002¢\u0006\u0004\b(\u0010\u0003J\u000f\u0010)\u001a\u00020\u0007H\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0004H\u0002¢\u0006\u0004\b+\u0010\u0003J\u000f\u0010,\u001a\u00020\u001eH\u0002¢\u0006\u0004\b,\u0010-R\u0016\u00101\u001a\u00020.8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b/\u00100R!\u00108\u001a\b\u0012\u0004\u0012\u000203028BX\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010A\u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010>R\u0016\u0010C\u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010>R\u0016\u0010E\u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bD\u0010>R!\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00070!8BX\u0002¢\u0006\f\n\u0004\bF\u00105\u001a\u0004\bG\u0010HR\u0016\u0010K\u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010>R\u001c\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00070!8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bL\u0010M¨\u0006Q"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/SmartReminderFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "initView", "initData", "", "text", "Landroid/text/SpannableString;", "W0", "(Ljava/lang/String;)Landroid/text/SpannableString;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "", "windowType", "actionType", "a", "(II)V", "", "result", "reason", "", "permissions", "tag", "y0", "(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V", "X0", "U0", "N0", "M0", "()Ljava/lang/String;", "V0", "T0", "()Z", "Lcom/upuphone/xr/sapp/databinding/FragmentSmartReminderBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentSmartReminderBinding;", "binding", "", "Lcom/upuphone/xr/sapp/view/GenericMenuView$MenuItem;", "k", "Lkotlin/Lazy;", "P0", "()Ljava/util/List;", "selectArray", "Lcom/upuphone/xr/sapp/view/GenericMenuView;", "l", "Lcom/upuphone/xr/sapp/view/GenericMenuView;", "dialog", "m", "Z", "dialFlag", "n", "contactFlag", "o", "readCallFlag", "p", "readPhoneStateFlag", "q", "O0", "()[Ljava/lang/String;", "appPermission", "r", "mIsRequest", "s", "[Ljava/lang/String;", "broadcastPauseArray", "t", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nSmartReminderFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SmartReminderFragment.kt\ncom/upuphone/xr/sapp/fragment/SmartReminderFragment\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,489:1\n256#2,2:490\n256#2,2:494\n256#2,2:496\n1855#3,2:492\n*S KotlinDebug\n*F\n+ 1 SmartReminderFragment.kt\ncom/upuphone/xr/sapp/fragment/SmartReminderFragment\n*L\n132#1:490,2\n185#1:494,2\n230#1:496,2\n140#1:492,2\n*E\n"})
public final class SmartReminderFragment extends BaseFragment {
    public static final Companion t = new Companion((DefaultConstructorMarker) null);
    public FragmentSmartReminderBinding j;
    public final Lazy k = LazyKt.lazy(new SmartReminderFragment$selectArray$2(this));
    public GenericMenuView l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public final Lazy q = LazyKt.lazy(SmartReminderFragment$appPermission$2.INSTANCE);
    public boolean r;
    public String[] s;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/SmartReminderFragment$Companion;", "", "()V", "CALL_PERMISSION_TAG", "", "REQ_CONTACT_TAG", "REQ_DIAL_TAG", "REQ_READ_CALL_TAG", "REQ_READ_PHONE_STATE_TAG", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* access modifiers changed from: private */
    public final List P0() {
        return (List) this.k.getValue();
    }

    public static final void Q0(SmartReminderFragment smartReminderFragment, View view) {
        Intrinsics.checkNotNullParameter(smartReminderFragment, "this$0");
        StaticMethodUtilsKt.q(smartReminderFragment);
    }

    public static final void R0(SmartReminderFragment smartReminderFragment) {
        Intrinsics.checkNotNullParameter(smartReminderFragment, "this$0");
        FragmentSmartReminderBinding fragmentSmartReminderBinding = smartReminderFragment.j;
        if (fragmentSmartReminderBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSmartReminderBinding = null;
        }
        TextView textView = fragmentSmartReminderBinding.f;
        String string = smartReminderFragment.getString(R.string.no_answer_call_alert_subtitle_off);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        textView.setText(smartReminderFragment.W0(string));
    }

    public static final void S0(SmartReminderFragment smartReminderFragment, View view) {
        Intrinsics.checkNotNullParameter(smartReminderFragment, "this$0");
        if (StaticMethodUtilsKt.a(smartReminderFragment, smartReminderFragment.O0())) {
            SuperNotificationManager.f7749a.H(true);
            smartReminderFragment.X0();
            return;
        }
        smartReminderFragment.U0();
    }

    private final SpannableString W0(String str) {
        SpannableString spannableString = new SpannableString(str);
        try {
            SmartReminderFragment$setClickSpan$1 smartReminderFragment$setClickSpan$1 = new SmartReminderFragment$setClickSpan$1(this);
            String string = getString(R.string.span_string);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            int indexOf$default = StringsKt.indexOf$default((CharSequence) str, string, 0, false, 6, (Object) null);
            String string2 = getString(R.string.span_string);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            spannableString.setSpan(smartReminderFragment$setClickSpan$1, indexOf$default, StringsKt.indexOf$default((CharSequence) str, string2, 0, false, 6, (Object) null) + getString(R.string.span_string).length() + 1, 34);
            int[] iArr = {getResources().getColor(R.color.color_gradient_star), getResources().getColor(R.color.color_gradient_end)};
            String string3 = getString(R.string.span_string);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            int indexOf$default2 = StringsKt.indexOf$default((CharSequence) str, string3, 0, false, 6, (Object) null);
            int length = getString(R.string.span_string).length() + indexOf$default2 + 1;
            FragmentSmartReminderBinding fragmentSmartReminderBinding = this.j;
            FragmentSmartReminderBinding fragmentSmartReminderBinding2 = null;
            if (fragmentSmartReminderBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentSmartReminderBinding = null;
            }
            int lineCount = fragmentSmartReminderBinding.f.getLineCount();
            FragmentSmartReminderBinding fragmentSmartReminderBinding3 = this.j;
            if (fragmentSmartReminderBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentSmartReminderBinding2 = fragmentSmartReminderBinding3;
            }
            Layout layout = fragmentSmartReminderBinding2.f.getLayout();
            for (int i = 0; i < lineCount; i++) {
                int lineStart = layout.getLineStart(i);
                int lineEnd = layout.getLineEnd(i);
                if (indexOf$default2 > lineStart && length < lineEnd) {
                    spannableString.setSpan(new LinearGradientForegroundSpan(iArr), indexOf$default2, length, 18);
                } else if (lineStart <= indexOf$default2 && indexOf$default2 <= lineEnd) {
                    spannableString.setSpan(new LinearGradientForegroundSpan(iArr), indexOf$default2, lineEnd, 18);
                } else if (indexOf$default2 <= lineStart && length >= lineEnd) {
                    spannableString.setSpan(new LinearGradientForegroundSpan(iArr), lineStart, lineEnd, 18);
                } else if (lineStart <= length && length <= lineEnd) {
                    spannableString.setSpan(new LinearGradientForegroundSpan(iArr), lineStart, length, 18);
                }
            }
        } catch (Exception e) {
            ULog.f6446a.c("SmartReminderFragment", "setClickSpan e : " + e.getMessage());
        }
        return spannableString;
    }

    private final void initData() {
        FragmentSmartReminderBinding fragmentSmartReminderBinding = this.j;
        FragmentSmartReminderBinding fragmentSmartReminderBinding2 = null;
        if (fragmentSmartReminderBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSmartReminderBinding = null;
        }
        TextView textView = fragmentSmartReminderBinding.A;
        Resources resources = getResources();
        SuperNotificationManager superNotificationManager = SuperNotificationManager.f7749a;
        textView.setText(resources.getString(superNotificationManager.C() ? R.string.word_open : R.string.word_close));
        FragmentSmartReminderBinding fragmentSmartReminderBinding3 = this.j;
        if (fragmentSmartReminderBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentSmartReminderBinding2 = fragmentSmartReminderBinding3;
        }
        fragmentSmartReminderBinding2.L.setText(getResources().getString(superNotificationManager.q() ? R.string.word_open : R.string.word_close));
    }

    private final void initView() {
        String string = getString(R.string.broadcast_pause_type1);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(R.string.broadcast_pause_type2);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = getString(R.string.broadcast_pause_type3);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = getString(R.string.broadcast_pause_type4);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        String string5 = getString(R.string.broadcast_pause_type5);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        this.s = new String[]{string, string2, string3, string4, string5};
        SdkContext.f6675a.d().reportEvent(ReminderDataTrackEvent.APP_REMIND_SET, new HashMap());
        FragmentSmartReminderBinding fragmentSmartReminderBinding = this.j;
        FragmentSmartReminderBinding fragmentSmartReminderBinding2 = null;
        if (fragmentSmartReminderBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSmartReminderBinding = null;
        }
        fragmentSmartReminderBinding.b.setOnClickListener(new h9(this));
        FragmentSmartReminderBinding fragmentSmartReminderBinding3 = this.j;
        if (fragmentSmartReminderBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSmartReminderBinding3 = null;
        }
        ConstraintLayout constraintLayout = fragmentSmartReminderBinding3.K;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "wiseNotifyItem");
        int i = 8;
        constraintLayout.setVisibility(SuperNotificationManager.f7749a.E() ? 0 : 8);
        FragmentSmartReminderBinding fragmentSmartReminderBinding4 = this.j;
        if (fragmentSmartReminderBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSmartReminderBinding4 = null;
        }
        ConstraintLayout constraintLayout2 = fragmentSmartReminderBinding4.K;
        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "wiseNotifyItem");
        GlobalExtKt.l(constraintLayout2, StaticMethodUtilsKt.i(this), new SmartReminderFragment$initView$2(this));
        FragmentSmartReminderBinding fragmentSmartReminderBinding5 = this.j;
        if (fragmentSmartReminderBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSmartReminderBinding5 = null;
        }
        ConstraintLayout constraintLayout3 = fragmentSmartReminderBinding5.m;
        Intrinsics.checkNotNullExpressionValue(constraintLayout3, "notifySetting");
        GlobalExtKt.l(constraintLayout3, StaticMethodUtilsKt.i(this), new SmartReminderFragment$initView$3(this));
        for (GenericMenuView.MenuItem menuItem : P0()) {
            if (SuperNotificationManager.f7749a.o() == ((long) menuItem.c())) {
                menuItem.d(true);
                FragmentSmartReminderBinding fragmentSmartReminderBinding6 = this.j;
                if (fragmentSmartReminderBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentSmartReminderBinding6 = null;
                }
                fragmentSmartReminderBinding6.i.setText(menuItem.a());
            }
        }
        FragmentSmartReminderBinding fragmentSmartReminderBinding7 = this.j;
        if (fragmentSmartReminderBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSmartReminderBinding7 = null;
        }
        ConstraintLayout constraintLayout4 = fragmentSmartReminderBinding7.j;
        Intrinsics.checkNotNullExpressionValue(constraintLayout4, "notifyDismissItem");
        GlobalExtKt.d(constraintLayout4, new SmartReminderFragment$initView$5(this));
        FragmentSmartReminderBinding fragmentSmartReminderBinding8 = this.j;
        if (fragmentSmartReminderBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSmartReminderBinding8 = null;
        }
        Switch switchR = fragmentSmartReminderBinding8.u;
        SuperNotificationManager superNotificationManager = SuperNotificationManager.f7749a;
        switchR.setChecked(superNotificationManager.m());
        FragmentSmartReminderBinding fragmentSmartReminderBinding9 = this.j;
        if (fragmentSmartReminderBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSmartReminderBinding9 = null;
        }
        Switch switchR2 = fragmentSmartReminderBinding9.u;
        Intrinsics.checkNotNullExpressionValue(switchR2, "phoneBroadcastSwitch");
        GlobalExtKt.j(switchR2, new SmartReminderFragment$initView$6(this));
        FragmentSmartReminderBinding fragmentSmartReminderBinding10 = this.j;
        if (fragmentSmartReminderBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSmartReminderBinding10 = null;
        }
        ConstraintLayout constraintLayout5 = fragmentSmartReminderBinding10.y;
        Intrinsics.checkNotNullExpressionValue(constraintLayout5, "phoneNotifyBroadcastLay");
        GlobalExtKt.l(constraintLayout5, StaticMethodUtilsKt.i(this), new SmartReminderFragment$initView$7(this));
        FragmentSmartReminderBinding fragmentSmartReminderBinding11 = this.j;
        if (fragmentSmartReminderBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSmartReminderBinding11 = null;
        }
        ConstraintLayout constraintLayout6 = fragmentSmartReminderBinding11.s;
        Intrinsics.checkNotNullExpressionValue(constraintLayout6, "phoneBroadcastPauseLay");
        constraintLayout6.setVisibility(T0() && superNotificationManager.m() ? 0 : 8);
        int n2 = superNotificationManager.n() - 1;
        FragmentSmartReminderBinding fragmentSmartReminderBinding12 = this.j;
        if (fragmentSmartReminderBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSmartReminderBinding12 = null;
        }
        TextView textView = fragmentSmartReminderBinding12.t;
        String[] strArr = this.s;
        if (strArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("broadcastPauseArray");
            strArr = null;
        }
        textView.setText(strArr[n2]);
        FragmentSmartReminderBinding fragmentSmartReminderBinding13 = this.j;
        if (fragmentSmartReminderBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSmartReminderBinding13 = null;
        }
        ConstraintLayout constraintLayout7 = fragmentSmartReminderBinding13.s;
        Intrinsics.checkNotNullExpressionValue(constraintLayout7, "phoneBroadcastPauseLay");
        GlobalExtKt.l(constraintLayout7, StaticMethodUtilsKt.i(this), new SmartReminderFragment$initView$8(this));
        FragmentSmartReminderBinding fragmentSmartReminderBinding14 = this.j;
        if (fragmentSmartReminderBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSmartReminderBinding14 = null;
        }
        fragmentSmartReminderBinding14.D.setChecked(superNotificationManager.l());
        FragmentSmartReminderBinding fragmentSmartReminderBinding15 = this.j;
        if (fragmentSmartReminderBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSmartReminderBinding15 = null;
        }
        Switch switchR3 = fragmentSmartReminderBinding15.D;
        Intrinsics.checkNotNullExpressionValue(switchR3, "phoneScreenSwitch");
        GlobalExtKt.j(switchR3, SmartReminderFragment$initView$9.INSTANCE);
        FragmentSmartReminderBinding fragmentSmartReminderBinding16 = this.j;
        if (fragmentSmartReminderBinding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSmartReminderBinding16 = null;
        }
        ConstraintLayout constraintLayout8 = fragmentSmartReminderBinding16.z;
        Intrinsics.checkNotNullExpressionValue(constraintLayout8, "phoneNotifyScreen");
        GlobalExtKt.l(constraintLayout8, StaticMethodUtilsKt.i(this), new SmartReminderFragment$initView$10(this));
        FragmentSmartReminderBinding fragmentSmartReminderBinding17 = this.j;
        if (fragmentSmartReminderBinding17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSmartReminderBinding17 = null;
        }
        ConstraintLayout constraintLayout9 = fragmentSmartReminderBinding17.G;
        Intrinsics.checkNotNullExpressionValue(constraintLayout9, "phoneUsingLay");
        GlobalExtKt.l(constraintLayout9, StaticMethodUtilsKt.i(this), new SmartReminderFragment$initView$11(this));
        FragmentSmartReminderBinding fragmentSmartReminderBinding18 = this.j;
        if (fragmentSmartReminderBinding18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSmartReminderBinding18 = null;
        }
        Switch switchR4 = fragmentSmartReminderBinding18.H;
        Intrinsics.checkNotNullExpressionValue(switchR4, "phoneUsingSwitch");
        GlobalExtKt.j(switchR4, SmartReminderFragment$initView$12.INSTANCE);
        FragmentSmartReminderBinding fragmentSmartReminderBinding19 = this.j;
        if (fragmentSmartReminderBinding19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSmartReminderBinding19 = null;
        }
        fragmentSmartReminderBinding19.H.setChecked(superNotificationManager.w());
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.c()), (CoroutineContext) null, (CoroutineStart) null, new SmartReminderFragment$initView$13(this, (Continuation<? super SmartReminderFragment$initView$13>) null), 3, (Object) null);
        FragmentSmartReminderBinding fragmentSmartReminderBinding20 = this.j;
        if (fragmentSmartReminderBinding20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSmartReminderBinding20 = null;
        }
        ConstraintLayout constraintLayout10 = fragmentSmartReminderBinding20.l;
        Intrinsics.checkNotNullExpressionValue(constraintLayout10, "notifyMissCall");
        if (!superNotificationManager.B()) {
            i = 0;
        }
        constraintLayout10.setVisibility(i);
        FragmentSmartReminderBinding fragmentSmartReminderBinding21 = this.j;
        if (fragmentSmartReminderBinding21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSmartReminderBinding21 = null;
        }
        fragmentSmartReminderBinding21.e.getBinding().i.setClickable(false);
        FragmentSmartReminderBinding fragmentSmartReminderBinding22 = this.j;
        if (fragmentSmartReminderBinding22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSmartReminderBinding22 = null;
        }
        CardItemView cardItemView = fragmentSmartReminderBinding22.e;
        Intrinsics.checkNotNullExpressionValue(cardItemView, "noAnswerCallAlertOn");
        GlobalExtKt.l(cardItemView, StaticMethodUtilsKt.i(this), new SmartReminderFragment$initView$14(this));
        FragmentSmartReminderBinding fragmentSmartReminderBinding23 = this.j;
        if (fragmentSmartReminderBinding23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSmartReminderBinding23 = null;
        }
        fragmentSmartReminderBinding23.f.setMovementMethod(LinkMovementMethod.getInstance());
        FragmentSmartReminderBinding fragmentSmartReminderBinding24 = this.j;
        if (fragmentSmartReminderBinding24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSmartReminderBinding24 = null;
        }
        fragmentSmartReminderBinding24.f.setHighlightColor(0);
        FragmentSmartReminderBinding fragmentSmartReminderBinding25 = this.j;
        if (fragmentSmartReminderBinding25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSmartReminderBinding25 = null;
        }
        fragmentSmartReminderBinding25.f.post(new i9(this));
        FragmentSmartReminderBinding fragmentSmartReminderBinding26 = this.j;
        if (fragmentSmartReminderBinding26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentSmartReminderBinding2 = fragmentSmartReminderBinding26;
        }
        fragmentSmartReminderBinding2.o.setOnClickListener(new j9(this));
        X0();
    }

    public final String M0() {
        return (StaticMethodUtilsKt.b(this, "android.permission.CALL_PHONE") || this.m) ? (StaticMethodUtilsKt.b(this, "android.permission.READ_PHONE_STATE") || this.p) ? (StaticMethodUtilsKt.b(this, "android.permission.READ_CONTACTS") || this.n) ? (StaticMethodUtilsKt.b(this, "android.permission.READ_CALL_LOG") || this.o) ? "" : "req_read_call_tag" : "req_contact_tag" : "req_read_phone_state_tag" : "req_dial_tag";
    }

    public final void N0() {
        this.p = false;
        this.n = false;
        this.o = false;
        this.m = false;
    }

    public final String[] O0() {
        return (String[]) this.q.getValue();
    }

    public final boolean T0() {
        return VersionMatchHelper.g(VersionMatchHelper.f7930a, true, false, false, GlassInfoExtKt.c(GlassInfoExtKt.d("Flyme AR 1.0.9.0.20240424_Air_FR")), (String) null, GlassInfoExtKt.c(GlassInfoExtKt.d("1.1.0.274")), GlassInfoExtKt.c(GlassInfoExtKt.d("1.1.0.395")), 22, (Object) null);
    }

    public final void U0() {
        this.r = true;
        v0(O0(), "call_permission_tag");
    }

    public final void V0() {
        String M0 = M0();
        switch (M0.hashCode()) {
            case -147911476:
                if (M0.equals("req_dial_tag")) {
                    StaticMethodUtilsKt.C(this, CollectionsKt.arrayListOf(168), false, false);
                    return;
                }
                return;
            case 1032068531:
                if (M0.equals("req_read_phone_state_tag")) {
                    StaticMethodUtilsKt.C(this, CollectionsKt.arrayListOf(168), false, false);
                    return;
                }
                return;
            case 1164778714:
                if (M0.equals("req_contact_tag")) {
                    StaticMethodUtilsKt.C(this, CollectionsKt.arrayListOf(145), false, false);
                    return;
                }
                return;
            case 2000709857:
                if (M0.equals("req_read_call_tag")) {
                    StaticMethodUtilsKt.C(this, CollectionsKt.arrayListOf(Integer.valueOf(Opcodes.IF_ICMPGE)), false, false);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void X0() {
        SuperNotificationManager superNotificationManager = SuperNotificationManager.f7749a;
        boolean k2 = superNotificationManager.k();
        FragmentSmartReminderBinding fragmentSmartReminderBinding = null;
        if (StaticMethodUtilsKt.a(this, O0())) {
            if (k2) {
                FragmentSmartReminderBinding fragmentSmartReminderBinding2 = this.j;
                if (fragmentSmartReminderBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentSmartReminderBinding2 = null;
                }
                fragmentSmartReminderBinding2.e.setSwitchState(true);
                FragmentSmartReminderBinding fragmentSmartReminderBinding3 = this.j;
                if (fragmentSmartReminderBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentSmartReminderBinding3 = null;
                }
                fragmentSmartReminderBinding3.d.setVisibility(8);
                FragmentSmartReminderBinding fragmentSmartReminderBinding4 = this.j;
                if (fragmentSmartReminderBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    fragmentSmartReminderBinding = fragmentSmartReminderBinding4;
                }
                fragmentSmartReminderBinding.e.setVisibility(0);
            } else {
                FragmentSmartReminderBinding fragmentSmartReminderBinding5 = this.j;
                if (fragmentSmartReminderBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentSmartReminderBinding5 = null;
                }
                fragmentSmartReminderBinding5.e.setSwitchState(false);
                FragmentSmartReminderBinding fragmentSmartReminderBinding6 = this.j;
                if (fragmentSmartReminderBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentSmartReminderBinding6 = null;
                }
                fragmentSmartReminderBinding6.d.setVisibility(8);
                FragmentSmartReminderBinding fragmentSmartReminderBinding7 = this.j;
                if (fragmentSmartReminderBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    fragmentSmartReminderBinding = fragmentSmartReminderBinding7;
                }
                fragmentSmartReminderBinding.e.setVisibility(0);
            }
            superNotificationManager.H(k2);
            return;
        }
        FragmentSmartReminderBinding fragmentSmartReminderBinding8 = this.j;
        if (fragmentSmartReminderBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSmartReminderBinding8 = null;
        }
        fragmentSmartReminderBinding8.e.setVisibility(8);
        FragmentSmartReminderBinding fragmentSmartReminderBinding9 = this.j;
        if (fragmentSmartReminderBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentSmartReminderBinding = fragmentSmartReminderBinding9;
        }
        fragmentSmartReminderBinding.d.setVisibility(0);
    }

    public void a(int i, int i2) {
        super.a(i, i2);
        if (i2 == 1102) {
            if (i == 145) {
                this.n = true;
            } else if (i == 162) {
                this.o = true;
            } else if (i == 168) {
                this.p = true;
                this.m = true;
            }
            V0();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentSmartReminderBinding c = FragmentSmartReminderBinding.c(layoutInflater, viewGroup, false);
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
        PermissionAndStateCheckUtils.f7907a.h(this);
        initData();
        X0();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView();
    }

    public void y0(boolean z, String str, String[] strArr, String str2) {
        Intrinsics.checkNotNullParameter(str, "reason");
        Intrinsics.checkNotNullParameter(str2, "tag");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("SmartReminderFragment", "result: " + z + ", reason: " + str + ", permission: " + strArr + ", tag: " + str2);
        Boolean bool = BuildConfig.b;
        Object i = DataStoreUtils.i(DataStoreUtils.e.a(), str2, Boolean.FALSE, (Context) null, 4, (Object) null);
        StringBuilder sb = new StringBuilder();
        sb.append("third: ");
        sb.append(bool);
        sb.append(", tag store: ");
        sb.append(i);
        delegate.g("SmartReminderFragment", sb.toString());
        if (!z) {
            N0();
            V0();
        }
    }
}
