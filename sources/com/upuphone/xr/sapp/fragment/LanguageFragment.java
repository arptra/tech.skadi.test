package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.asm.Opcodes;
import com.honey.account.h8.q5;
import com.honey.account.h8.r5;
import com.honey.account.h8.s5;
import com.honey.account.h8.t5;
import com.meizu.common.util.LunarCalendar;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.adapter.LanguageAdapter;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$3;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$4;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$5;
import com.upuphone.xr.sapp.databinding.FragmentLanguageBinding;
import com.upuphone.xr.sapp.entity.LanguageMode;
import com.upuphone.xr.sapp.glass.GlassUpdateHelper;
import com.upuphone.xr.sapp.utils.AppUpdateHelper;
import com.upuphone.xr.sapp.utils.ControlUtils;
import com.upuphone.xr.sapp.utils.DynamicAdapterUtils;
import com.upuphone.xr.sapp.utils.GenericWindowManger;
import com.upuphone.xr.sapp.utils.LanguageHelper;
import com.upuphone.xr.sapp.utils.ModelIdExtKt;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.vm.DeviceControlModel;
import com.upuphone.xr.sapp.vm.SuperViewModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 R2\u00020\u0001:\u0001SB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J+\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001d\u0010\u0003J\u000f\u0010\u001e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001e\u0010\u0003J\u000f\u0010\u001f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001f\u0010\u0003J\u001f\u0010#\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0004H\u0002¢\u0006\u0004\b%\u0010\u0003J\u0017\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u000bH\u0002¢\u0006\u0004\b'\u0010\u000eR\u0016\u0010+\u001a\u00020(8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b)\u0010*R\u001b\u00101\u001a\u00020,8BX\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001b\u00106\u001a\u0002028BX\u0002¢\u0006\f\n\u0004\b3\u0010.\u001a\u0004\b4\u00105R\u0014\u0010:\u001a\u0002078\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010=\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020\u000b8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b>\u0010?R\u001e\u0010E\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010A8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010K\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010<R\u0016\u0010M\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u0010<R\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u0010P¨\u0006T"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/LanguageFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseConnectCheckFragment;", "<init>", "()V", "", "A0", "", "connect", "S0", "(Z)V", "initView", "", "lan", "V0", "(Ljava/lang/String;)V", "R0", "D0", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", "onDestroyView", "", "windowType", "actionType", "a", "(II)V", "P0", "language", "U0", "Lcom/upuphone/xr/sapp/databinding/FragmentLanguageBinding;", "k", "Lcom/upuphone/xr/sapp/databinding/FragmentLanguageBinding;", "binding", "Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "l", "Lkotlin/Lazy;", "n0", "()Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "viewModel", "Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "m", "C0", "()Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "mDeviceModel", "Landroid/os/Handler;", "n", "Landroid/os/Handler;", "delayHandler", "o", "Z", "isAir", "p", "Ljava/lang/String;", "selectLan", "", "Lcom/upuphone/xr/sapp/entity/LanguageMode;", "q", "Ljava/util/List;", "supportLanguage", "Lcom/upuphone/xr/sapp/adapter/LanguageAdapter;", "r", "Lcom/upuphone/xr/sapp/adapter/LanguageAdapter;", "adapter", "s", "loadingShow", "t", "isConnect", "", "u", "J", "showTime", "v", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nLanguageFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LanguageFragment.kt\ncom/upuphone/xr/sapp/fragment/LanguageFragment\n+ 2 GlobalViewStoreExt.kt\ncom/upuphone/xr/sapp/common/GlobalViewStoreExtKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,265:1\n32#2,12:266\n32#2,12:278\n288#3,2:290\n*S KotlinDebug\n*F\n+ 1 LanguageFragment.kt\ncom/upuphone/xr/sapp/fragment/LanguageFragment\n*L\n44#1:266,12\n45#1:278,12\n121#1:290,2\n*E\n"})
public final class LanguageFragment extends BaseConnectCheckFragment {
    public static final Companion v = new Companion((DefaultConstructorMarker) null);
    public FragmentLanguageBinding k;
    public final Lazy l;
    public final Lazy m;
    public final Handler n = new Handler(Looper.getMainLooper());
    public final boolean o = InterconnectManager.getInstance().getStarryNetDeviceManager().isAir();
    public String p;
    public List q;
    public LanguageAdapter r;
    public boolean s;
    public boolean t = true;
    public long u;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/LanguageFragment$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public LanguageFragment() {
        Class<SuperViewModel> cls = SuperViewModel.class;
        this.l = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls), new GlobalViewStoreExtKt$cachedViewModels$3(cls.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
        Class<DeviceControlModel> cls2 = DeviceControlModel.class;
        this.m = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls2), new GlobalViewStoreExtKt$cachedViewModels$3(cls2.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
    }

    private final void A0() {
        n0().F().observe(getViewLifecycleOwner(), new LanguageFragment$sam$androidx_lifecycle_Observer$0(new LanguageFragment$addObserve$1(this)));
        C0().L().observe(getViewLifecycleOwner(), new LanguageFragment$sam$androidx_lifecycle_Observer$0(new LanguageFragment$addObserve$2(this)));
    }

    private final DeviceControlModel C0() {
        return (DeviceControlModel) this.m.getValue();
    }

    private final void D0() {
        n0().F().removeObservers(getViewLifecycleOwner());
        C0().L().removeObservers(getViewLifecycleOwner());
    }

    public static final void O0(LanguageFragment languageFragment) {
        Intrinsics.checkNotNullParameter(languageFragment, "this$0");
        try {
            if (languageFragment.s) {
                languageFragment.R0();
                UToast.Companion companion = UToast.f6444a;
                Context requireContext = languageFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                String string = languageFragment.getString(R.string.switch_language_fail);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                companion.d(requireContext, string);
            }
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e.getMessage();
            delegate.c("LanguageFragment", "dismiss error " + message);
        }
    }

    public static final void Q0(LanguageFragment languageFragment) {
        Intrinsics.checkNotNullParameter(languageFragment, "this$0");
        languageFragment.R0();
    }

    private final void R0() {
        ULog.f6446a.a("LanguageFragment", "dismissLoading()");
        GenericWindowManger.c.a().j(150);
        this.n.removeCallbacksAndMessages((Object) null);
        this.s = false;
    }

    /* access modifiers changed from: private */
    public final void S0(boolean z) {
        this.t = z;
        FragmentLanguageBinding fragmentLanguageBinding = null;
        if (z) {
            FragmentLanguageBinding fragmentLanguageBinding2 = this.k;
            if (fragmentLanguageBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentLanguageBinding = fragmentLanguageBinding2;
            }
            fragmentLanguageBinding.d.setAlpha(1.0f);
            return;
        }
        FragmentLanguageBinding fragmentLanguageBinding3 = this.k;
        if (fragmentLanguageBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentLanguageBinding = fragmentLanguageBinding3;
        }
        fragmentLanguageBinding.d.setAlpha(0.5f);
        if (this.s) {
            R0();
            UToast.Companion companion = UToast.f6444a;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            String string = getString(R.string.switch_language_disconnect);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.d(requireContext, string);
        }
    }

    public static final void T0(LanguageFragment languageFragment, View view) {
        Intrinsics.checkNotNullParameter(languageFragment, "this$0");
        FragmentKt.a(languageFragment).T();
    }

    /* access modifiers changed from: private */
    public final void V0(String str) {
        if (GlassUpdateHelper.b.b1()) {
            StaticMethodUtilsKt.O(this);
        } else if (!AppUpdateHelper.f7841a.u()) {
            this.p = str;
            if (ModelIdExtKt.a(DynamicAdapterUtils.f7879a.a())) {
                ULog.Delegate delegate = ULog.f6446a;
                String str2 = this.p;
                String str3 = null;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("selectLan");
                    str2 = null;
                }
                delegate.a("LanguageFragment", "switch language to: " + str2);
                String str4 = this.p;
                if (str4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("selectLan");
                } else {
                    str3 = str4;
                }
                U0(str3);
                if (!this.s) {
                    StaticMethodUtilsKt.C(this, CollectionsKt.arrayListOf(150), false, false);
                    this.u = System.currentTimeMillis();
                    this.s = true;
                    this.n.postDelayed(new r5(this), 10000);
                    return;
                }
                return;
            }
            StaticMethodUtilsKt.I(this, CollectionsKt.arrayListOf(Integer.valueOf(Opcodes.FCMPL)), false, false, 6, (Object) null);
        }
    }

    public static final void W0(LanguageFragment languageFragment) {
        Intrinsics.checkNotNullParameter(languageFragment, "this$0");
        try {
            if (languageFragment.s) {
                languageFragment.R0();
                UToast.Companion companion = UToast.f6444a;
                Context requireContext = languageFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                String string = languageFragment.getString(R.string.switch_language_fail);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                companion.d(requireContext, string);
            }
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e.getMessage();
            delegate.c("LanguageFragment", "dismiss error " + message);
        }
    }

    private final void initView() {
        Object obj;
        FragmentLanguageBinding fragmentLanguageBinding = this.k;
        FragmentLanguageBinding fragmentLanguageBinding2 = null;
        if (fragmentLanguageBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentLanguageBinding = null;
        }
        fragmentLanguageBinding.b.setOnClickListener(new q5(this));
        List a2 = LanguageHelper.f7894a.a();
        this.q = a2;
        Intrinsics.checkNotNull(a2);
        Iterator it = a2.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((LanguageMode) obj).getLanguage(), (Object) ControlUtils.f7858a.y())) {
                break;
            }
        }
        LanguageMode languageMode = (LanguageMode) obj;
        if (languageMode != null) {
            languageMode.setSelectState(true);
        }
        List list = this.q;
        Intrinsics.checkNotNull(list);
        LanguageAdapter languageAdapter = new LanguageAdapter(list);
        this.r = languageAdapter;
        Intrinsics.checkNotNull(languageAdapter);
        languageAdapter.k(new LanguageFragment$initView$4(this));
        FragmentLanguageBinding fragmentLanguageBinding3 = this.k;
        if (fragmentLanguageBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentLanguageBinding3 = null;
        }
        fragmentLanguageBinding3.c.setLayoutManager(new LinearLayoutManager(requireContext()));
        FragmentLanguageBinding fragmentLanguageBinding4 = this.k;
        if (fragmentLanguageBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentLanguageBinding2 = fragmentLanguageBinding4;
        }
        fragmentLanguageBinding2.c.setAdapter(this.r);
    }

    private final SuperViewModel n0() {
        return (SuperViewModel) this.l.getValue();
    }

    public final void P0() {
        if (this.s) {
            long currentTimeMillis = System.currentTimeMillis() - this.u;
            if (currentTimeMillis < 1000) {
                this.n.postDelayed(new s5(this), ((long) 1000) - currentTimeMillis);
            } else {
                R0();
            }
        }
    }

    public final void U0(String str) {
        try {
            List split$default = StringsKt.split$default((CharSequence) str, new String[]{LunarCalendar.DATE_SEPARATOR}, false, 0, 6, (Object) null);
            ControlUtils controlUtils = ControlUtils.f7858a;
            String packageName = requireContext().getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
            controlUtils.V(packageName, (String) split$default.get(0), (String) split$default.get(1));
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e.getMessage();
            delegate.c("LanguageFragment", "sendChangeLanguage::e is: " + message);
        }
    }

    public void a(int i, int i2) {
        super.a(i, i2);
        if (i == 149 && i2 == 1101) {
            ULog.Delegate delegate = ULog.f6446a;
            String str = this.p;
            String str2 = null;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectLan");
                str = null;
            }
            delegate.a("LanguageFragment", "switch language to: " + str);
            String str3 = this.p;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectLan");
            } else {
                str2 = str3;
            }
            U0(str2);
            if (!this.s) {
                StaticMethodUtilsKt.C(this, CollectionsKt.arrayListOf(150), false, false);
                this.u = System.currentTimeMillis();
                this.s = true;
                this.n.postDelayed(new t5(this), 10000);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentLanguageBinding c = FragmentLanguageBinding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.k = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        ConstraintLayout b = c.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        return b;
    }

    public void onDestroyView() {
        super.onDestroyView();
        ControlUtils.f7858a.j(requireContext().getPackageName());
        this.n.removeCallbacksAndMessages((Object) null);
        ULog.f6446a.a("LanguageFragment", "onDestroyView");
    }

    public void onPause() {
        super.onPause();
        D0();
    }

    public void onResume() {
        super.onResume();
        A0();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView();
        ControlUtils.f7858a.j(requireContext().getPackageName());
        ULog.f6446a.a("LanguageFragment", "onViewCreated");
    }
}
