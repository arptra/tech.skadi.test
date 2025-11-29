package com.upuphone.xr.sapp.fragment;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.collection.ArrayMapKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.webkit.WebSettingsCompat;
import androidx.webkit.WebViewFeature;
import com.honey.account.h8.n4;
import com.honey.account.h8.o4;
import com.honey.account.h8.p4;
import com.honey.account.h8.r4;
import com.honey.account.h8.s4;
import com.honey.account.h8.t4;
import com.honey.account.h8.u4;
import com.honey.account.h8.v4;
import com.honey.account.h8.w4;
import com.ucar.vehiclesdk.MDevice;
import com.upuphone.runasone.uupcast.CaptureType;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.common.Constants;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$3;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$4;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$5;
import com.upuphone.xr.sapp.databinding.FragmentH5Binding;
import com.upuphone.xr.sapp.entity.H5Info;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.DataTrackUtil;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.utils.WebViewPool;
import com.upuphone.xr.sapp.view.BaseWebView;
import com.upuphone.xr.sapp.vm.SuperViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 R2\u00020\u0001:\u0002STB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0003J\u0017\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0018\u0010\u0016J\u000f\u0010\u0019\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0019\u0010\u0003J\u0017\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010 \u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\"\u0010\u0003J\u0017\u0010%\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b(\u0010)R\u001b\u00100\u001a\u00020+8BX\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0016\u00103\u001a\u00020\u001a8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00102R\u0018\u00108\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010C\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u001b\u0010L\u001a\u00020H8BX\u0002¢\u0006\f\n\u0004\bI\u0010-\u001a\u0004\bJ\u0010KR\u0016\u0010O\u001a\u00020#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010Q\u001a\u00020#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u0010N¨\u0006U"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/H5Fragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "onResume", "Lcom/upuphone/xr/sapp/entity/H5Info;", "h5Info", "P0", "(Lcom/upuphone/xr/sapp/entity/H5Info;)V", "R0", "J0", "V0", "", "phoneType", "F0", "(Ljava/lang/String;)V", "Landroid/webkit/WebChromeClient$CustomViewCallback;", "callback", "U0", "(Landroid/view/View;Landroid/webkit/WebChromeClient$CustomViewCallback;)V", "H0", "", "visible", "T0", "(Z)V", "Lcom/upuphone/xr/sapp/databinding/FragmentH5Binding;", "a", "Lcom/upuphone/xr/sapp/databinding/FragmentH5Binding;", "binding", "Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "b", "Lkotlin/Lazy;", "E0", "()Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "viewModel", "c", "Ljava/lang/String;", "url", "d", "appearanceState", "e", "Landroid/view/View;", "customView", "Landroid/widget/FrameLayout;", "f", "Landroid/widget/FrameLayout;", "fullscreenContainer", "Landroid/widget/FrameLayout$LayoutParams;", "g", "Landroid/widget/FrameLayout$LayoutParams;", "coverScreenParams", "h", "Landroid/webkit/WebChromeClient$CustomViewCallback;", "customViewCallback", "", "i", "I", "webviewScrollY", "Lcom/upuphone/xr/sapp/view/BaseWebView;", "j", "D0", "()Lcom/upuphone/xr/sapp/view/BaseWebView;", "mWebView", "k", "Z", "isNetLoss", "l", "isNetError", "m", "Companion", "FullscreenHolder", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nH5Fragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 H5Fragment.kt\ncom/upuphone/xr/sapp/fragment/H5Fragment\n+ 2 GlobalViewStoreExt.kt\ncom/upuphone/xr/sapp/common/GlobalViewStoreExtKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,451:1\n32#2,12:452\n256#3,2:464\n256#3,2:466\n256#3,2:468\n256#3,2:470\n256#3,2:472\n256#3,2:474\n256#3,2:476\n256#3,2:478\n256#3,2:480\n256#3,2:482\n256#3,2:484\n256#3,2:486\n256#3,2:488\n256#3,2:490\n256#3,2:492\n256#3,2:494\n256#3,2:496\n256#3,2:498\n*S KotlinDebug\n*F\n+ 1 H5Fragment.kt\ncom/upuphone/xr/sapp/fragment/H5Fragment\n*L\n65#1:452,12\n134#1:464,2\n135#1:466,2\n136#1:468,2\n149#1:470,2\n150#1:472,2\n151#1:474,2\n157#1:476,2\n163#1:478,2\n164#1:480,2\n165#1:482,2\n170#1:484,2\n171#1:486,2\n172#1:488,2\n394#1:490,2\n293#1:492,2\n308#1:494,2\n337#1:496,2\n424#1:498,2\n*E\n"})
public final class H5Fragment extends Fragment {
    public static final Companion m = new Companion((DefaultConstructorMarker) null);
    public static final Handler n = new Handler(Looper.getMainLooper(), new n4());

    /* renamed from: a  reason: collision with root package name */
    public FragmentH5Binding f6969a;
    public final Lazy b;
    public String c;
    public String d = "light";
    public View e;
    public FrameLayout f;
    public FrameLayout.LayoutParams g = new FrameLayout.LayoutParams(-1, -1);
    public WebChromeClient.CustomViewCallback h;
    public int i;
    public final Lazy j = LazyKt.lazy(new H5Fragment$mWebView$2(this));
    public boolean k = true;
    public boolean l;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/H5Fragment$Companion;", "", "<init>", "()V", "", "TAG", "Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/H5Fragment$FullscreenHolder;", "Landroid/widget/FrameLayout;", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onTouchEvent", "", "evt", "Landroid/view/MotionEvent;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class FullscreenHolder extends FrameLayout {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FullscreenHolder(@NotNull Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "ctx");
            setBackgroundColor(context.getResources().getColor(17170444));
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            Intrinsics.checkNotNullParameter(motionEvent, "evt");
            return true;
        }
    }

    public H5Fragment() {
        Class<SuperViewModel> cls = SuperViewModel.class;
        this.b = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls), new GlobalViewStoreExtKt$cachedViewModels$3(cls.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
    }

    /* access modifiers changed from: private */
    public final BaseWebView D0() {
        return (BaseWebView) this.j.getValue();
    }

    private final SuperViewModel E0() {
        return (SuperViewModel) this.b.getValue();
    }

    public static final boolean G0(Message message) {
        Intrinsics.checkNotNullParameter(message, "it");
        return true;
    }

    public static final void I0(H5Fragment h5Fragment) {
        Intrinsics.checkNotNullParameter(h5Fragment, "this$0");
        h5Fragment.D0().scrollTo(0, h5Fragment.i);
        FragmentH5Binding fragmentH5Binding = h5Fragment.f6969a;
        if (fragmentH5Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentH5Binding = null;
        }
        View view = fragmentH5Binding.f;
        Intrinsics.checkNotNullExpressionValue(view, "cover");
        view.setVisibility(8);
    }

    public static final void K0(H5Fragment h5Fragment) {
        Intrinsics.checkNotNullParameter(h5Fragment, "this$0");
        BaseWebView D0 = h5Fragment.D0();
        String str = h5Fragment.c;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("url");
            str = null;
        }
        D0.loadUrl(str);
        ULog.Delegate delegate = ULog.f6446a;
        String str3 = h5Fragment.c;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("url");
        } else {
            str2 = str3;
        }
        delegate.a("H5Fragment", "refreshlayout reload Url is: " + str2);
        n.postDelayed(new v4(h5Fragment), 10000);
    }

    public static final void L0(H5Fragment h5Fragment) {
        Intrinsics.checkNotNullParameter(h5Fragment, "this$0");
        FragmentH5Binding fragmentH5Binding = h5Fragment.f6969a;
        FragmentH5Binding fragmentH5Binding2 = null;
        if (fragmentH5Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentH5Binding = null;
        }
        if (fragmentH5Binding.l.h()) {
            FragmentH5Binding fragmentH5Binding3 = h5Fragment.f6969a;
            if (fragmentH5Binding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentH5Binding2 = fragmentH5Binding3;
            }
            fragmentH5Binding2.l.setRefreshing(false);
        }
    }

    public static final void M0(H5Info h5Info, H5Fragment h5Fragment, View view) {
        Intrinsics.checkNotNullParameter(h5Info, "$h5Info");
        Intrinsics.checkNotNullParameter(h5Fragment, "this$0");
        DataStoreUtils.e.a().o(h5Info.getPageType(), Boolean.TRUE);
        FragmentH5Binding fragmentH5Binding = h5Fragment.f6969a;
        FragmentH5Binding fragmentH5Binding2 = null;
        if (fragmentH5Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentH5Binding = null;
        }
        fragmentH5Binding.d.setEnabled(false);
        FragmentH5Binding fragmentH5Binding3 = h5Fragment.f6969a;
        if (fragmentH5Binding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentH5Binding2 = fragmentH5Binding3;
        }
        LinearLayout linearLayout = fragmentH5Binding2.m;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "tipSetOk");
        linearLayout.setVisibility(0);
        h5Fragment.V0();
        DataTrackUtil.f7875a.i("app_device_connection_assistant", MapsKt.toMap(ArrayMapKt.a(TuplesKt.to("autostart", "1"))));
    }

    public static final void N0(H5Fragment h5Fragment, H5Info h5Info, View view) {
        Intrinsics.checkNotNullParameter(h5Fragment, "this$0");
        Intrinsics.checkNotNullParameter(h5Info, "$h5Info");
        h5Fragment.F0(h5Info.getDeviceType());
    }

    public static final void O0(H5Info h5Info, H5Fragment h5Fragment, View view) {
        Intrinsics.checkNotNullParameter(h5Info, "$h5Info");
        Intrinsics.checkNotNullParameter(h5Fragment, "this$0");
        if (Intrinsics.areEqual((Object) h5Info.getPageType(), (Object) "automatic-start")) {
            h5Fragment.F0(h5Info.getDeviceType());
            return;
        }
        DataStoreUtils.e.a().o(h5Info.getPageType(), Boolean.TRUE);
        FragmentH5Binding fragmentH5Binding = h5Fragment.f6969a;
        FragmentH5Binding fragmentH5Binding2 = null;
        if (fragmentH5Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentH5Binding = null;
        }
        fragmentH5Binding.e.setEnabled(false);
        FragmentH5Binding fragmentH5Binding3 = h5Fragment.f6969a;
        if (fragmentH5Binding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentH5Binding3 = null;
        }
        LinearLayout linearLayout = fragmentH5Binding3.m;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "tipSetOk");
        linearLayout.setVisibility(0);
        Context context = h5Fragment.getContext();
        if (context != null) {
            FragmentH5Binding fragmentH5Binding4 = h5Fragment.f6969a;
            if (fragmentH5Binding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentH5Binding2 = fragmentH5Binding4;
            }
            fragmentH5Binding2.e.setBackground(ContextCompat.getDrawable(context, R.drawable.help_long_button_bg_low));
        }
        h5Fragment.V0();
        DataTrackUtil.f7875a.i("app_device_connection_assistant", MapsKt.toMap(ArrayMapKt.a(TuplesKt.to("lock_background", "1"))));
    }

    public static final void Q0(H5Fragment h5Fragment, View view) {
        Intrinsics.checkNotNullParameter(h5Fragment, "this$0");
        if (h5Fragment.k) {
            Intent intent = new Intent("android.settings.SETTINGS");
            FragmentActivity activity = h5Fragment.getActivity();
            if (activity != null) {
                activity.startActivity(intent);
                return;
            }
            return;
        }
        FragmentH5Binding fragmentH5Binding = h5Fragment.f6969a;
        String str = null;
        if (fragmentH5Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentH5Binding = null;
        }
        fragmentH5Binding.l.setVisibility(0);
        FragmentH5Binding fragmentH5Binding2 = h5Fragment.f6969a;
        if (fragmentH5Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentH5Binding2 = null;
        }
        fragmentH5Binding2.g.setVisibility(8);
        BaseWebView D0 = h5Fragment.D0();
        String str2 = h5Fragment.c;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("url");
        } else {
            str = str2;
        }
        D0.loadUrl(str);
        h5Fragment.l = false;
    }

    public static final void S0(H5Fragment h5Fragment, View view) {
        Intrinsics.checkNotNullParameter(h5Fragment, "this$0");
        StaticMethodUtilsKt.q(h5Fragment);
    }

    public static final void W0(H5Fragment h5Fragment) {
        Intrinsics.checkNotNullParameter(h5Fragment, "this$0");
        FragmentH5Binding fragmentH5Binding = h5Fragment.f6969a;
        if (fragmentH5Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentH5Binding = null;
        }
        LinearLayout linearLayout = fragmentH5Binding.m;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "tipSetOk");
        linearLayout.setVisibility(8);
    }

    public final void F0(String str) {
        switch (str.hashCode()) {
            case -1206476313:
                if (str.equals("huawei")) {
                    StaticMethodUtilsKt.r(this, "com.huawei.systemmanager");
                    return;
                }
                break;
            case -759499589:
                if (str.equals(MDevice.MANUFACTURERS_XIAOMI)) {
                    StaticMethodUtilsKt.p(this);
                    return;
                }
                break;
            case 99462250:
                if (str.equals("honor")) {
                    Intent intent = new Intent();
                    intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
                    intent.setComponent(new ComponentName("com.hihonor.systemmanager", "com.hihonor.systemmanager.startupmgr.ui.StartupNormalAppListActivity"));
                    Context requireContext = requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                    StaticMethodUtilsKt.U(requireContext, intent);
                    return;
                }
                break;
            case 103777484:
                if (str.equals(MDevice.MANUFACTURERS_MEIZU)) {
                    Intent intent2 = new Intent();
                    intent2.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
                    intent2.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.SecurityMainActivity"));
                    Context requireContext2 = requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
                    StaticMethodUtilsKt.U(requireContext2, intent2);
                    return;
                }
                break;
            case 1864941562:
                if (str.equals("samsung")) {
                    StaticMethodUtilsKt.r(this, "com.samsung.android.sm_cn");
                    return;
                }
                break;
        }
        StaticMethodUtilsKt.p(this);
    }

    public final void H0() {
        if (this.e != null) {
            try {
                T0(true);
                View decorView = requireActivity().getWindow().getDecorView();
                Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.widget.FrameLayout");
                ((FrameLayout) decorView).removeView(this.f);
                this.f = null;
                this.e = null;
                WebChromeClient.CustomViewCallback customViewCallback = this.h;
                if (customViewCallback != null) {
                    customViewCallback.onCustomViewHidden();
                }
                ULog.Delegate delegate = ULog.f6446a;
                int i2 = this.i;
                delegate.a("H5Fragment", "hideCustomView webviewScrollY is: " + i2);
                D0().setVisibility(0);
                D0().postDelayed(new o4(this), 150);
            } catch (Exception e2) {
                ULog.Delegate delegate2 = ULog.f6446a;
                String message = e2.getMessage();
                delegate2.a("H5Fragment", "hideCustomView::e is: " + message);
            }
        }
    }

    public final void J0(H5Info h5Info) {
        FragmentH5Binding fragmentH5Binding = this.f6969a;
        FragmentH5Binding fragmentH5Binding2 = null;
        if (fragmentH5Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentH5Binding = null;
        }
        fragmentH5Binding.d.setOnClickListener(new r4(h5Info, this));
        FragmentH5Binding fragmentH5Binding3 = this.f6969a;
        if (fragmentH5Binding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentH5Binding3 = null;
        }
        fragmentH5Binding3.j.setOnClickListener(new s4(this, h5Info));
        FragmentH5Binding fragmentH5Binding4 = this.f6969a;
        if (fragmentH5Binding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentH5Binding4 = null;
        }
        fragmentH5Binding4.e.setOnClickListener(new t4(h5Info, this));
        FragmentH5Binding fragmentH5Binding5 = this.f6969a;
        if (fragmentH5Binding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentH5Binding2 = fragmentH5Binding5;
        }
        fragmentH5Binding2.l.setOnRefreshListener(new u4(this));
    }

    /* JADX WARNING: Removed duplicated region for block: B:97:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01f5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void P0(com.upuphone.xr.sapp.entity.H5Info r19) {
        /*
            r18 = this;
            r0 = r18
            com.upuphone.xr.sapp.databinding.FragmentH5Binding r1 = r0.f6969a
            java.lang.String r2 = "binding"
            r3 = 0
            if (r1 != 0) goto L_0x000d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r1 = r3
        L_0x000d:
            androidx.swiperefreshlayout.widget.SwipeRefreshLayout r1 = r1.l
            com.upuphone.xr.sapp.view.BaseWebView r4 = r18.D0()
            android.widget.RelativeLayout$LayoutParams r5 = new android.widget.RelativeLayout$LayoutParams
            r6 = -1
            r5.<init>(r6, r6)
            r1.addView(r4, r5)
            com.upuphone.xr.sapp.view.BaseWebView r1 = r18.D0()
            r1.setLifecycleOwner(r0)
            com.upuphone.xr.sapp.databinding.FragmentH5Binding r1 = r0.f6969a
            if (r1 != 0) goto L_0x002b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r1 = r3
        L_0x002b:
            android.widget.TextView r1 = r1.b
            java.lang.String r4 = r19.getPageType()
            int r5 = r4.hashCode()
            r6 = 678601488(0x2872a310, float:1.3469057E-14)
            r7 = 0
            java.lang.String r8 = "gotoSetting"
            java.lang.String r9 = "completeTv"
            java.lang.String r10 = "completeTvLong"
            r11 = 8
            if (r5 == r6) goto L_0x0134
            r6 = 936738368(0x37d57e40, float:2.5450368E-5)
            if (r5 == r6) goto L_0x0091
            r6 = 981473401(0x3a801879, float:9.772918E-4)
            if (r5 == r6) goto L_0x004f
            goto L_0x013c
        L_0x004f:
            java.lang.String r5 = "glass_guide"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0059
            goto L_0x013c
        L_0x0059:
            com.upuphone.xr.sapp.databinding.FragmentH5Binding r4 = r0.f6969a
            if (r4 != 0) goto L_0x0061
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r4 = r3
        L_0x0061:
            com.meizu.common.widget.MzButton r4 = r4.d
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r9)
            r4.setVisibility(r11)
            com.upuphone.xr.sapp.databinding.FragmentH5Binding r4 = r0.f6969a
            if (r4 != 0) goto L_0x0071
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r4 = r3
        L_0x0071:
            com.meizu.common.widget.MzButton r4 = r4.j
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r8)
            r4.setVisibility(r11)
            com.upuphone.xr.sapp.databinding.FragmentH5Binding r4 = r0.f6969a
            if (r4 != 0) goto L_0x0081
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r4 = r3
        L_0x0081:
            com.meizu.common.widget.MzButton r4 = r4.e
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r10)
            r4.setVisibility(r11)
            int r4 = com.upuphone.xr.sapp.R.string.usage_guidelines
            java.lang.String r4 = r0.getString(r4)
            goto L_0x01ea
        L_0x0091:
            java.lang.String r5 = "automatic-start"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x009b
            goto L_0x013c
        L_0x009b:
            com.upuphone.xr.sapp.utils.DataStoreUtils$Companion r4 = com.upuphone.xr.sapp.utils.DataStoreUtils.e
            com.upuphone.xr.sapp.utils.DataStoreUtils r12 = r4.a()
            java.lang.Boolean r14 = java.lang.Boolean.FALSE
            r16 = 4
            r17 = 0
            java.lang.String r13 = "automatic-start"
            r15 = 0
            java.lang.Object r4 = com.upuphone.xr.sapp.utils.DataStoreUtils.i(r12, r13, r14, r15, r16, r17)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            com.upuphone.xr.sapp.databinding.FragmentH5Binding r5 = r0.f6969a
            if (r5 != 0) goto L_0x00bc
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r5 = r3
        L_0x00bc:
            com.meizu.common.widget.MzButton r5 = r5.d
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r9)
            r6 = r4 ^ 1
            if (r6 == 0) goto L_0x00c7
            r6 = r7
            goto L_0x00c8
        L_0x00c7:
            r6 = r11
        L_0x00c8:
            r5.setVisibility(r6)
            com.upuphone.xr.sapp.databinding.FragmentH5Binding r5 = r0.f6969a
            if (r5 != 0) goto L_0x00d3
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r5 = r3
        L_0x00d3:
            com.meizu.common.widget.MzButton r5 = r5.j
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r8)
            r6 = r4 ^ 1
            if (r6 == 0) goto L_0x00de
            r6 = r7
            goto L_0x00df
        L_0x00de:
            r6 = r11
        L_0x00df:
            r5.setVisibility(r6)
            com.upuphone.xr.sapp.databinding.FragmentH5Binding r5 = r0.f6969a
            if (r5 != 0) goto L_0x00ea
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r5 = r3
        L_0x00ea:
            com.meizu.common.widget.MzButton r5 = r5.e
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r10)
            if (r4 == 0) goto L_0x00f2
            goto L_0x00f3
        L_0x00f2:
            r7 = r11
        L_0x00f3:
            r5.setVisibility(r7)
            if (r4 == 0) goto L_0x012c
            com.upuphone.xr.sapp.databinding.FragmentH5Binding r4 = r0.f6969a
            if (r4 != 0) goto L_0x0100
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r4 = r3
        L_0x0100:
            com.meizu.common.widget.MzButton r4 = r4.e
            android.content.Context r5 = r18.getContext()
            if (r5 == 0) goto L_0x010f
            int r6 = com.upuphone.xr.sapp.R.string.go_to_set
            java.lang.String r5 = r5.getString(r6)
            goto L_0x0110
        L_0x010f:
            r5 = r3
        L_0x0110:
            r4.setText(r5)
            android.content.Context r4 = r18.getContext()
            if (r4 == 0) goto L_0x012c
            com.upuphone.xr.sapp.databinding.FragmentH5Binding r5 = r0.f6969a
            if (r5 != 0) goto L_0x0121
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r5 = r3
        L_0x0121:
            com.meizu.common.widget.MzButton r5 = r5.e
            int r6 = com.upuphone.xr.sapp.R.drawable.help_long_button_bg_high
            android.graphics.drawable.Drawable r4 = androidx.core.content.ContextCompat.getDrawable(r4, r6)
            r5.setBackground(r4)
        L_0x012c:
            int r4 = com.upuphone.xr.sapp.R.string.text_how_to_open_auto_start
            java.lang.String r4 = r0.getString(r4)
            goto L_0x01ea
        L_0x0134:
            java.lang.String r5 = "lock-background"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0170
        L_0x013c:
            com.upuphone.xr.sapp.databinding.FragmentH5Binding r4 = r0.f6969a
            if (r4 != 0) goto L_0x0144
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r4 = r3
        L_0x0144:
            com.meizu.common.widget.MzButton r4 = r4.d
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r9)
            r4.setVisibility(r11)
            com.upuphone.xr.sapp.databinding.FragmentH5Binding r4 = r0.f6969a
            if (r4 != 0) goto L_0x0154
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r4 = r3
        L_0x0154:
            com.meizu.common.widget.MzButton r4 = r4.j
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r8)
            r4.setVisibility(r11)
            com.upuphone.xr.sapp.databinding.FragmentH5Binding r4 = r0.f6969a
            if (r4 != 0) goto L_0x0164
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r4 = r3
        L_0x0164:
            com.meizu.common.widget.MzButton r4 = r4.e
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r10)
            r4.setVisibility(r11)
            java.lang.String r4 = ""
            goto L_0x01ea
        L_0x0170:
            com.upuphone.xr.sapp.utils.DataStoreUtils$Companion r4 = com.upuphone.xr.sapp.utils.DataStoreUtils.e
            com.upuphone.xr.sapp.utils.DataStoreUtils r12 = r4.a()
            java.lang.Boolean r14 = java.lang.Boolean.FALSE
            r16 = 4
            r17 = 0
            java.lang.String r13 = "lock-background"
            r15 = 0
            java.lang.Object r4 = com.upuphone.xr.sapp.utils.DataStoreUtils.i(r12, r13, r14, r15, r16, r17)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            com.upuphone.xr.sapp.databinding.FragmentH5Binding r5 = r0.f6969a
            if (r5 != 0) goto L_0x0191
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r5 = r3
        L_0x0191:
            com.meizu.common.widget.MzButton r5 = r5.d
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r9)
            r5.setVisibility(r11)
            com.upuphone.xr.sapp.databinding.FragmentH5Binding r5 = r0.f6969a
            if (r5 != 0) goto L_0x01a1
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r5 = r3
        L_0x01a1:
            com.meizu.common.widget.MzButton r5 = r5.j
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r8)
            r5.setVisibility(r11)
            com.upuphone.xr.sapp.databinding.FragmentH5Binding r5 = r0.f6969a
            if (r5 != 0) goto L_0x01b1
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r5 = r3
        L_0x01b1:
            com.meizu.common.widget.MzButton r5 = r5.e
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r10)
            r5.setVisibility(r7)
            android.content.Context r5 = r18.getContext()
            if (r5 == 0) goto L_0x01d2
            com.upuphone.xr.sapp.databinding.FragmentH5Binding r6 = r0.f6969a
            if (r6 != 0) goto L_0x01c7
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r6 = r3
        L_0x01c7:
            com.meizu.common.widget.MzButton r6 = r6.e
            int r7 = com.upuphone.xr.sapp.R.drawable.help_long_button_bg_high
            android.graphics.drawable.Drawable r5 = androidx.core.content.ContextCompat.getDrawable(r5, r7)
            r6.setBackground(r5)
        L_0x01d2:
            if (r4 == 0) goto L_0x01e4
            com.upuphone.xr.sapp.databinding.FragmentH5Binding r4 = r0.f6969a
            if (r4 != 0) goto L_0x01dc
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r4 = r3
        L_0x01dc:
            com.meizu.common.widget.MzButton r4 = r4.e
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r10)
            r4.setVisibility(r11)
        L_0x01e4:
            int r4 = com.upuphone.xr.sapp.R.string.text_how_to_lock_background
            java.lang.String r4 = r0.getString(r4)
        L_0x01ea:
            r1.setText(r4)
            com.upuphone.xr.sapp.databinding.FragmentH5Binding r1 = r0.f6969a
            if (r1 != 0) goto L_0x01f5
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            goto L_0x01f6
        L_0x01f5:
            r3 = r1
        L_0x01f6:
            android.widget.TextView r1 = r3.h
            com.honey.account.h8.q4 r2 = new com.honey.account.h8.q4
            r2.<init>(r0)
            r1.setOnClickListener(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.fragment.H5Fragment.P0(com.upuphone.xr.sapp.entity.H5Info):void");
    }

    public final void R0(H5Info h5Info) {
        this.d = (getResources().getConfiguration().uiMode & 48) == 32 ? "dark" : "light";
        WebSettings settings = D0().getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "getSettings(...)");
        int i2 = 2;
        String str = null;
        D0().setLayerType(2, (Paint) null);
        settings.setJavaScriptEnabled(true);
        if (WebViewFeature.a("ALGORITHMIC_DARKENING")) {
            WebSettingsCompat.b(settings, true);
        } else {
            ULog.f6446a.o("H5Fragment", "AlgorithmicDarkening is not Allowed");
        }
        D0().setWebChromeClient(new H5Fragment$initWebView$webChromeClient$1(this));
        D0().setWebViewClient(new H5Fragment$initWebView$1(this, settings));
        D0().setBackgroundColor(0);
        settings.setDomStorageEnabled(true);
        settings.setBlockNetworkImage(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        if (!bool.booleanValue()) {
            i2 = 1;
        }
        String str2 = Constants.f6657a.a() + h5Info.getPageType() + "?brand=" + h5Info.getDeviceType() + "&model=" + h5Info.getDeviceModel() + "&xrModel=XGA020C&os=Android&area=" + i2;
        this.c = str2;
        ULog.Delegate delegate = ULog.f6446a;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("url");
            str2 = null;
        }
        delegate.a("H5Fragment", "initWebView url is: " + str2);
        BaseWebView D0 = D0();
        String str3 = this.c;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("url");
        } else {
            str = str3;
        }
        D0.loadUrl(str);
    }

    public final void T0(boolean z) {
        requireActivity().getWindow().setFlags(z ? 0 : 1024, 1024);
    }

    public final void U0(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        if (this.e == null) {
            FragmentH5Binding fragmentH5Binding = this.f6969a;
            if (fragmentH5Binding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentH5Binding = null;
            }
            View view2 = fragmentH5Binding.f;
            Intrinsics.checkNotNullExpressionValue(view2, "cover");
            view2.setVisibility(0);
            this.g.setMargins(0, 0, 0, E0().e0());
            View decorView = requireActivity().getWindow().getDecorView();
            Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.widget.FrameLayout");
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            FullscreenHolder fullscreenHolder = new FullscreenHolder(requireContext);
            this.f = fullscreenHolder;
            fullscreenHolder.addView(view, this.g);
            ((FrameLayout) decorView).addView(this.f, this.g);
            this.e = view;
            T0(false);
            this.h = customViewCallback;
            this.i = D0().getScrollY();
        } else if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
        }
    }

    public final void V0() {
        n.postDelayed(new w4(this), 1000);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentH5Binding c2 = FragmentH5Binding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
        this.f6969a = c2;
        if (c2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c2 = null;
        }
        ConstraintLayout b2 = c2.getRoot();
        Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
        return b2;
    }

    public void onDestroyView() {
        super.onDestroyView();
        n.removeCallbacksAndMessages((Object) null);
        WebViewPool.e.a().i(D0());
    }

    public void onResume() {
        super.onResume();
        FragmentH5Binding fragmentH5Binding = this.f6969a;
        String str = null;
        if (fragmentH5Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentH5Binding = null;
        }
        fragmentH5Binding.l.setVisibility(0);
        FragmentH5Binding fragmentH5Binding2 = this.f6969a;
        if (fragmentH5Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentH5Binding2 = null;
        }
        fragmentH5Binding2.g.setVisibility(8);
        ULog.Delegate delegate = ULog.f6446a;
        String str2 = this.c;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("url");
            str2 = null;
        }
        delegate.a("H5Fragment", "initWebView url is: " + str2);
        BaseWebView D0 = D0();
        String str3 = this.c;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("url");
        } else {
            str = str3;
        }
        D0.loadUrl(str);
        this.l = false;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        FragmentH5Binding fragmentH5Binding = null;
        H5Info h5Info = arguments != null ? (H5Info) arguments.getParcelable("h5_info") : null;
        if (h5Info != null) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("H5Fragment", "onViewCreated h5Info is: " + h5Info);
            P0(h5Info);
            R0(h5Info);
            J0(h5Info);
        }
        FragmentH5Binding fragmentH5Binding2 = this.f6969a;
        if (fragmentH5Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentH5Binding = fragmentH5Binding2;
        }
        fragmentH5Binding.b.setOnClickListener(new p4(this));
    }
}
