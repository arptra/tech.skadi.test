package com.upuphone.xr.sapp.vu.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import com.here.posclient.analytics.TrackerEvent;
import com.honey.account.c9.a0;
import com.honey.account.c9.b0;
import com.honey.account.c9.c0;
import com.honey.account.c9.d0;
import com.honey.account.c9.e0;
import com.honey.account.c9.t;
import com.honey.account.c9.u;
import com.honey.account.c9.v;
import com.honey.account.c9.w;
import com.honey.account.c9.x;
import com.honey.account.c9.y;
import com.honey.account.c9.z;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.annotation.FastClickCheck;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.aspect.FastClickAspect;
import com.upuphone.xr.sapp.contract.ContractEntry;
import com.upuphone.xr.sapp.contract.ProtocolType;
import com.upuphone.xr.sapp.databinding.FragmentVuGlassesManagerBinding;
import com.upuphone.xr.sapp.fragment.BaseFragment;
import com.upuphone.xr.sapp.utils.ControlUtils;
import com.upuphone.xr.sapp.utils.GenericWindowManger;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.view.GenericMenuView;
import com.upuphone.xr.sapp.vu.utils.VuGlassesHidManager;
import com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil;
import com.upuphone.xr.sapp.vu.utils.VuWebViewUtils;
import com.upuphone.xr.sapp.vu.vm.VuArSpacePreferenceModel;
import com.upuphone.xr.sapp.vu.vm.VuGlassControlModel;
import com.upuphone.xr.sapp.vu.vm.VuGlassesLanguageModel;
import com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel;
import com.upuphone.xr.sapp.vu.vm.VuGlassesPreferenceModel;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.runtime.reflect.Factory;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 Q2\u00020\u0001:\u0001RB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0003J!\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0003J!\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u0015¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0006H\u0002¢\u0006\u0004\b#\u0010\u0003J\u000f\u0010$\u001a\u00020\u0006H\u0002¢\u0006\u0004\b$\u0010\u0003J\u000f\u0010%\u001a\u00020\u0006H\u0002¢\u0006\u0004\b%\u0010\u0003J\u000f\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0006H\u0003¢\u0006\u0004\b)\u0010\u0003J\u000f\u0010*\u001a\u00020\u0006H\u0003¢\u0006\u0004\b*\u0010\u0003J\u000f\u0010+\u001a\u00020\u0006H\u0003¢\u0006\u0004\b+\u0010\u0003J\u000f\u0010,\u001a\u00020\u0006H\u0003¢\u0006\u0004\b,\u0010\u0003J\u000f\u0010-\u001a\u00020\u0006H\u0003¢\u0006\u0004\b-\u0010\u0003J\u000f\u0010.\u001a\u00020\u0006H\u0003¢\u0006\u0004\b.\u0010\u0003J\u000f\u0010/\u001a\u00020\u0006H\u0003¢\u0006\u0004\b/\u0010\u0003J\u000f\u00100\u001a\u00020\u0006H\u0003¢\u0006\u0004\b0\u0010\u0003J\u000f\u00101\u001a\u00020\u0006H\u0003¢\u0006\u0004\b1\u0010\u0003R\u0016\u00105\u001a\u0002028\u0002@\u0002X.¢\u0006\u0006\n\u0004\b3\u00104R\u001b\u0010;\u001a\u0002068BX\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001b\u0010@\u001a\u00020<8BX\u0002¢\u0006\f\n\u0004\b=\u00108\u001a\u0004\b>\u0010?R\u001b\u0010E\u001a\u00020A8BX\u0002¢\u0006\f\n\u0004\bB\u00108\u001a\u0004\bC\u0010DR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010M\u001a\u00020J8\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010P\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bN\u0010O¨\u0006S"}, d2 = {"Lcom/upuphone/xr/sapp/vu/fragment/VuGlassesManagerFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onStop", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "", "windowType", "", "data", "c", "(ILjava/lang/Object;)V", "", "Lcom/upuphone/xr/sapp/view/GenericMenuView$MenuItem;", "S0", "()Ljava/util/List;", "seconds", "", "T0", "(I)Ljava/lang/String;", "B1", "initView", "W0", "", "A1", "()Z", "onClickGlassName", "onClickGlassLanSet", "onClickDisplayModeSet", "onClickGlassScreenOff", "onClickDefaultOpenModeSet", "onClickAntiShake", "onClickAboutGlasses", "onClickAdapterDevices", "onClickGlassUpdate", "Lcom/upuphone/xr/sapp/databinding/FragmentVuGlassesManagerBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentVuGlassesManagerBinding;", "binding", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassesLanguageModel;", "k", "Lkotlin/Lazy;", "getLanguageViewModel", "()Lcom/upuphone/xr/sapp/vu/vm/VuGlassesLanguageModel;", "languageViewModel", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassesPreferenceModel;", "l", "U0", "()Lcom/upuphone/xr/sapp/vu/vm/VuGlassesPreferenceModel;", "glassesPreferenceModel", "Lcom/upuphone/xr/sapp/vu/vm/VuArSpacePreferenceModel;", "m", "R0", "()Lcom/upuphone/xr/sapp/vu/vm/VuArSpacePreferenceModel;", "arSpacePreferenceModel", "Lcom/upuphone/xr/sapp/view/GenericMenuView;", "n", "Lcom/upuphone/xr/sapp/view/GenericMenuView;", "screenOffView", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassesOtaModel$UpdateInfoChangeListener;", "o", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassesOtaModel$UpdateInfoChangeListener;", "hasUpdateListener", "p", "I", "sleepTime", "q", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nVuGlassesManagerFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VuGlassesManagerFragment.kt\ncom/upuphone/xr/sapp/vu/fragment/VuGlassesManagerFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,307:1\n172#2,9:308\n172#2,9:317\n172#2,9:326\n1#3:335\n256#4,2:336\n*S KotlinDebug\n*F\n+ 1 VuGlassesManagerFragment.kt\ncom/upuphone/xr/sapp/vu/fragment/VuGlassesManagerFragment\n*L\n46#1:308,9\n47#1:317,9\n48#1:326,9\n51#1:336,2\n*E\n"})
public final class VuGlassesManagerFragment extends BaseFragment {
    public static final Companion q = new Companion((DefaultConstructorMarker) null);
    public static /* synthetic */ JoinPoint.StaticPart r;
    public static /* synthetic */ JoinPoint.StaticPart s;
    public static /* synthetic */ JoinPoint.StaticPart t;
    public static /* synthetic */ JoinPoint.StaticPart u;
    public static /* synthetic */ JoinPoint.StaticPart v;
    public static /* synthetic */ JoinPoint.StaticPart w;
    public static /* synthetic */ JoinPoint.StaticPart x;
    public static /* synthetic */ JoinPoint.StaticPart y;
    public static /* synthetic */ JoinPoint.StaticPart z;
    public FragmentVuGlassesManagerBinding j;
    public final Lazy k = FragmentViewModelLazyKt.c(this, Reflection.getOrCreateKotlinClass(VuGlassesLanguageModel.class), new VuGlassesManagerFragment$special$$inlined$activityViewModels$default$1(this), new VuGlassesManagerFragment$special$$inlined$activityViewModels$default$2((Function0) null, this), new VuGlassesManagerFragment$special$$inlined$activityViewModels$default$3(this));
    public final Lazy l = FragmentViewModelLazyKt.c(this, Reflection.getOrCreateKotlinClass(VuGlassesPreferenceModel.class), new VuGlassesManagerFragment$special$$inlined$activityViewModels$default$4(this), new VuGlassesManagerFragment$special$$inlined$activityViewModels$default$5((Function0) null, this), new VuGlassesManagerFragment$special$$inlined$activityViewModels$default$6(this));
    public final Lazy m = FragmentViewModelLazyKt.c(this, Reflection.getOrCreateKotlinClass(VuArSpacePreferenceModel.class), new VuGlassesManagerFragment$special$$inlined$activityViewModels$default$7(this), new VuGlassesManagerFragment$special$$inlined$activityViewModels$default$8((Function0) null, this), new VuGlassesManagerFragment$special$$inlined$activityViewModels$default$9(this));
    public GenericMenuView n;
    public final VuGlassesOtaModel.UpdateInfoChangeListener o = new t(this);
    public int p = 30;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/vu/fragment/VuGlassesManagerFragment$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    static {
        Q0();
    }

    private final boolean A1() {
        if (getContext() != null && !VuGlassControlModel.f8109a.z()) {
            StaticMethodUtilsKt.a0(this);
            return false;
        } else if (VuGlassesOtaModel.f8117a.A()) {
            StaticMethodUtilsKt.O(this);
            return false;
        } else if (VuGlassesHidUtil.f8104a.e() == 1) {
            return true;
        } else {
            VuGlassesHidManager.x(VuGlassesHidManager.f8100a, (VuGlassesHidManager.UsbOpenResultListener) null, false, 3, (Object) null);
            return false;
        }
    }

    private static /* synthetic */ void Q0() {
        Factory factory = new Factory("VuGlassesManagerFragment.kt", VuGlassesManagerFragment.class);
        r = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "onClickGlassName", "com.upuphone.xr.sapp.vu.fragment.VuGlassesManagerFragment", "", "", "", "void"), 195);
        s = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "onClickGlassLanSet", "com.upuphone.xr.sapp.vu.fragment.VuGlassesManagerFragment", "", "", "", "void"), (int) TrackerEvent.RadioMapOnDemandOutdoor);
        t = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "onClickDisplayModeSet", "com.upuphone.xr.sapp.vu.fragment.VuGlassesManagerFragment", "", "", "", "void"), 218);
        u = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "onClickGlassScreenOff", "com.upuphone.xr.sapp.vu.fragment.VuGlassesManagerFragment", "", "", "", "void"), 225);
        v = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "onClickDefaultOpenModeSet", "com.upuphone.xr.sapp.vu.fragment.VuGlassesManagerFragment", "", "", "", "void"), 248);
        w = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "onClickAntiShake", "com.upuphone.xr.sapp.vu.fragment.VuGlassesManagerFragment", "", "", "", "void"), 255);
        x = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "onClickAboutGlasses", "com.upuphone.xr.sapp.vu.fragment.VuGlassesManagerFragment", "", "", "", "void"), 262);
        y = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "onClickAdapterDevices", "com.upuphone.xr.sapp.vu.fragment.VuGlassesManagerFragment", "", "", "", "void"), 269);
        z = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "onClickGlassUpdate", "com.upuphone.xr.sapp.vu.fragment.VuGlassesManagerFragment", "", "", "", "void"), 281);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0020, code lost:
        if (r3.h() == true) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void V0(com.upuphone.xr.sapp.vu.fragment.VuGlassesManagerFragment r2, com.upuphone.xr.sapp.vu.ota.VuUpdateInfo r3) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            com.upuphone.xr.sapp.databinding.FragmentVuGlassesManagerBinding r2 = r2.j
            if (r2 != 0) goto L_0x0010
            java.lang.String r2 = "binding"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r2 = 0
        L_0x0010:
            android.widget.TextView r2 = r2.q
            java.lang.String r0 = "tvGlassUpdateBadge"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            r0 = 0
            if (r3 == 0) goto L_0x0023
            boolean r3 = r3.h()
            r1 = 1
            if (r3 != r1) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r1 = r0
        L_0x0024:
            if (r1 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r0 = 8
        L_0x0029:
            r2.setVisibility(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.fragment.VuGlassesManagerFragment.V0(com.upuphone.xr.sapp.vu.fragment.VuGlassesManagerFragment, com.upuphone.xr.sapp.vu.ota.VuUpdateInfo):void");
    }

    private final void W0() {
        VuGlassControlModel.f8109a.v().observe(getViewLifecycleOwner(), new VuGlassesManagerFragment$sam$androidx_lifecycle_Observer$0(new VuGlassesManagerFragment$initObserve$1(this)));
        U0().g().observe(getViewLifecycleOwner(), new VuGlassesManagerFragment$sam$androidx_lifecycle_Observer$0(new VuGlassesManagerFragment$initObserve$2(this)));
        U0().f().observe(getViewLifecycleOwner(), new VuGlassesManagerFragment$sam$androidx_lifecycle_Observer$0(new VuGlassesManagerFragment$initObserve$3(this)));
        R0().d().observe(getViewLifecycleOwner(), new VuGlassesManagerFragment$sam$androidx_lifecycle_Observer$0(new VuGlassesManagerFragment$initObserve$4(this)));
        R0().c().observe(getViewLifecycleOwner(), new VuGlassesManagerFragment$sam$androidx_lifecycle_Observer$0(new VuGlassesManagerFragment$initObserve$5(this)));
        VuGlassesOtaModel.f8117a.s(this.o);
    }

    public static final void X0(VuGlassesManagerFragment vuGlassesManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(vuGlassesManagerFragment, "this$0");
        StaticMethodUtilsKt.q(vuGlassesManagerFragment);
    }

    public static final void Y0(VuGlassesManagerFragment vuGlassesManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(vuGlassesManagerFragment, "this$0");
        ContractEntry contractEntry = ContractEntry.f6691a;
        FragmentActivity requireActivity = vuGlassesManagerFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        ContractEntry.w(contractEntry, requireActivity, ProtocolType.GLASS_VIEW_UP, (String) null, 4, (Object) null);
    }

    public static final void Z0(VuGlassesManagerFragment vuGlassesManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(vuGlassesManagerFragment, "this$0");
        ULog.f6446a.a("VuGlassesManagerFragment", "click frequentlyAsked");
        String c = VuWebViewUtils.f8107a.c();
        String string = vuGlassesManagerFragment.getString(R.string.frequently_asked);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Bundle bundle = new Bundle();
        bundle.putString("h5_url", c);
        bundle.putString("h5_title", string);
        StaticMethodUtilsKt.v(vuGlassesManagerFragment, R.id.commonH5Fragment, bundle);
    }

    public static final void a1(VuGlassesManagerFragment vuGlassesManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(vuGlassesManagerFragment, "this$0");
        vuGlassesManagerFragment.onClickGlassName();
    }

    public static final void b1(VuGlassesManagerFragment vuGlassesManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(vuGlassesManagerFragment, "this$0");
        vuGlassesManagerFragment.onClickDisplayModeSet();
    }

    public static final void c1(VuGlassesManagerFragment vuGlassesManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(vuGlassesManagerFragment, "this$0");
        vuGlassesManagerFragment.onClickGlassScreenOff();
    }

    public static final void d1(VuGlassesManagerFragment vuGlassesManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(vuGlassesManagerFragment, "this$0");
        vuGlassesManagerFragment.onClickDefaultOpenModeSet();
    }

    public static final void e1(VuGlassesManagerFragment vuGlassesManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(vuGlassesManagerFragment, "this$0");
        vuGlassesManagerFragment.onClickAntiShake();
    }

    public static final void f1(VuGlassesManagerFragment vuGlassesManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(vuGlassesManagerFragment, "this$0");
        vuGlassesManagerFragment.onClickAboutGlasses();
    }

    public static final void g1(VuGlassesManagerFragment vuGlassesManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(vuGlassesManagerFragment, "this$0");
        vuGlassesManagerFragment.onClickAdapterDevices();
    }

    public static final void h1(VuGlassesManagerFragment vuGlassesManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(vuGlassesManagerFragment, "this$0");
        vuGlassesManagerFragment.onClickGlassUpdate();
    }

    public static final /* synthetic */ void i1(VuGlassesManagerFragment vuGlassesManagerFragment, JoinPoint joinPoint) {
        boolean A1 = vuGlassesManagerFragment.A1();
        Boolean valueOf = Boolean.valueOf(A1);
        if (!A1) {
            valueOf = null;
        }
        if (valueOf != null) {
            StaticMethodUtilsKt.t(vuGlassesManagerFragment, R.id.vuAboutGlassFragment);
        }
    }

    private final void initView() {
        FragmentVuGlassesManagerBinding fragmentVuGlassesManagerBinding = this.j;
        FragmentVuGlassesManagerBinding fragmentVuGlassesManagerBinding2 = null;
        if (fragmentVuGlassesManagerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuGlassesManagerBinding = null;
        }
        fragmentVuGlassesManagerBinding.p.setOnClickListener(new w(this));
        FragmentVuGlassesManagerBinding fragmentVuGlassesManagerBinding3 = this.j;
        if (fragmentVuGlassesManagerBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuGlassesManagerBinding3 = null;
        }
        fragmentVuGlassesManagerBinding3.i.c();
        FragmentVuGlassesManagerBinding fragmentVuGlassesManagerBinding4 = this.j;
        if (fragmentVuGlassesManagerBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuGlassesManagerBinding4 = null;
        }
        fragmentVuGlassesManagerBinding4.i.setOnClickListener(new y(this));
        FragmentVuGlassesManagerBinding fragmentVuGlassesManagerBinding5 = this.j;
        if (fragmentVuGlassesManagerBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuGlassesManagerBinding5 = null;
        }
        fragmentVuGlassesManagerBinding5.g.setOnClickListener(new z(this));
        FragmentVuGlassesManagerBinding fragmentVuGlassesManagerBinding6 = this.j;
        if (fragmentVuGlassesManagerBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuGlassesManagerBinding6 = null;
        }
        fragmentVuGlassesManagerBinding6.e.setOnClickListener(new a0(this));
        FragmentVuGlassesManagerBinding fragmentVuGlassesManagerBinding7 = this.j;
        if (fragmentVuGlassesManagerBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuGlassesManagerBinding7 = null;
        }
        fragmentVuGlassesManagerBinding7.f.setOnClickListener(new b0(this));
        FragmentVuGlassesManagerBinding fragmentVuGlassesManagerBinding8 = this.j;
        if (fragmentVuGlassesManagerBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuGlassesManagerBinding8 = null;
        }
        fragmentVuGlassesManagerBinding8.d.getBinding().i.setClickable(false);
        FragmentVuGlassesManagerBinding fragmentVuGlassesManagerBinding9 = this.j;
        if (fragmentVuGlassesManagerBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuGlassesManagerBinding9 = null;
        }
        fragmentVuGlassesManagerBinding9.d.setOnClickListener(new c0(this));
        FragmentVuGlassesManagerBinding fragmentVuGlassesManagerBinding10 = this.j;
        if (fragmentVuGlassesManagerBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuGlassesManagerBinding10 = null;
        }
        fragmentVuGlassesManagerBinding10.b.setOnClickListener(new d0(this));
        FragmentVuGlassesManagerBinding fragmentVuGlassesManagerBinding11 = this.j;
        if (fragmentVuGlassesManagerBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuGlassesManagerBinding11 = null;
        }
        fragmentVuGlassesManagerBinding11.c.setOnClickListener(new e0(this));
        FragmentVuGlassesManagerBinding fragmentVuGlassesManagerBinding12 = this.j;
        if (fragmentVuGlassesManagerBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuGlassesManagerBinding12 = null;
        }
        fragmentVuGlassesManagerBinding12.l.setOnClickListener(new u(this));
        FragmentVuGlassesManagerBinding fragmentVuGlassesManagerBinding13 = this.j;
        if (fragmentVuGlassesManagerBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuGlassesManagerBinding13 = null;
        }
        fragmentVuGlassesManagerBinding13.n.setOnClickListener(new v(this));
        FragmentVuGlassesManagerBinding fragmentVuGlassesManagerBinding14 = this.j;
        if (fragmentVuGlassesManagerBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentVuGlassesManagerBinding2 = fragmentVuGlassesManagerBinding14;
        }
        fragmentVuGlassesManagerBinding2.h.setOnClickListener(new x(this));
    }

    public static final /* synthetic */ void j1(VuGlassesManagerFragment vuGlassesManagerFragment, JoinPoint joinPoint, FastClickAspect fastClickAspect, ProceedingJoinPoint proceedingJoinPoint) {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !fastClickAspect.isFastClick(fastClickCheck.interval())) {
            i1(vuGlassesManagerFragment, proceedingJoinPoint);
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    public static final /* synthetic */ void k1(VuGlassesManagerFragment vuGlassesManagerFragment, JoinPoint joinPoint) {
        String a2 = VuWebViewUtils.f8107a.a();
        String string = vuGlassesManagerFragment.getString(R.string.adapter_devices);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Bundle bundle = new Bundle();
        bundle.putString("h5_url", a2);
        bundle.putString("h5_title", string);
        StaticMethodUtilsKt.v(vuGlassesManagerFragment, R.id.commonH5Fragment, bundle);
    }

    public static final /* synthetic */ void l1(VuGlassesManagerFragment vuGlassesManagerFragment, JoinPoint joinPoint, FastClickAspect fastClickAspect, ProceedingJoinPoint proceedingJoinPoint) {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !fastClickAspect.isFastClick(fastClickCheck.interval())) {
            k1(vuGlassesManagerFragment, proceedingJoinPoint);
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    public static final /* synthetic */ void m1(VuGlassesManagerFragment vuGlassesManagerFragment, JoinPoint joinPoint) {
        boolean A1 = vuGlassesManagerFragment.A1();
        Boolean valueOf = Boolean.valueOf(A1);
        FragmentVuGlassesManagerBinding fragmentVuGlassesManagerBinding = null;
        if (!A1) {
            valueOf = null;
        }
        if (valueOf != null) {
            VuArSpacePreferenceModel R0 = vuGlassesManagerFragment.R0();
            FragmentVuGlassesManagerBinding fragmentVuGlassesManagerBinding2 = vuGlassesManagerFragment.j;
            if (fragmentVuGlassesManagerBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentVuGlassesManagerBinding = fragmentVuGlassesManagerBinding2;
            }
            R0.e(!fragmentVuGlassesManagerBinding.d.getSwitchState());
        }
    }

    public static final /* synthetic */ void n1(VuGlassesManagerFragment vuGlassesManagerFragment, JoinPoint joinPoint, FastClickAspect fastClickAspect, ProceedingJoinPoint proceedingJoinPoint) {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !fastClickAspect.isFastClick(fastClickCheck.interval())) {
            m1(vuGlassesManagerFragment, proceedingJoinPoint);
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    public static final /* synthetic */ void o1(VuGlassesManagerFragment vuGlassesManagerFragment, JoinPoint joinPoint) {
        boolean A1 = vuGlassesManagerFragment.A1();
        Boolean valueOf = Boolean.valueOf(A1);
        if (!A1) {
            valueOf = null;
        }
        if (valueOf != null) {
            StaticMethodUtilsKt.t(vuGlassesManagerFragment, R.id.vuDefaultOpenModeFragment);
        }
    }

    @Keep
    @FastClickCheck
    private final void onClickAboutGlasses() {
        JoinPoint makeJP = Factory.makeJP(x, this, this);
        j1(this, makeJP, FastClickAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    @Keep
    @FastClickCheck
    private final void onClickAdapterDevices() {
        JoinPoint makeJP = Factory.makeJP(y, this, this);
        l1(this, makeJP, FastClickAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    @Keep
    @FastClickCheck
    private final void onClickAntiShake() {
        JoinPoint makeJP = Factory.makeJP(w, this, this);
        n1(this, makeJP, FastClickAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    @Keep
    @FastClickCheck
    private final void onClickDefaultOpenModeSet() {
        JoinPoint makeJP = Factory.makeJP(v, this, this);
        p1(this, makeJP, FastClickAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    @Keep
    @FastClickCheck
    private final void onClickDisplayModeSet() {
        JoinPoint makeJP = Factory.makeJP(t, this, this);
        r1(this, makeJP, FastClickAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    @Keep
    @FastClickCheck
    private final void onClickGlassLanSet() {
        JoinPoint makeJP = Factory.makeJP(s, this, this);
        t1(this, makeJP, FastClickAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    @Keep
    @FastClickCheck
    private final void onClickGlassName() {
        JoinPoint makeJP = Factory.makeJP(r, this, this);
        v1(this, makeJP, FastClickAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    @Keep
    @FastClickCheck
    private final void onClickGlassScreenOff() {
        JoinPoint makeJP = Factory.makeJP(u, this, this);
        x1(this, makeJP, FastClickAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    @Keep
    @FastClickCheck
    private final void onClickGlassUpdate() {
        JoinPoint makeJP = Factory.makeJP(z, this, this);
        z1(this, makeJP, FastClickAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    public static final /* synthetic */ void p1(VuGlassesManagerFragment vuGlassesManagerFragment, JoinPoint joinPoint, FastClickAspect fastClickAspect, ProceedingJoinPoint proceedingJoinPoint) {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !fastClickAspect.isFastClick(fastClickCheck.interval())) {
            o1(vuGlassesManagerFragment, proceedingJoinPoint);
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    public static final /* synthetic */ void q1(VuGlassesManagerFragment vuGlassesManagerFragment, JoinPoint joinPoint) {
        boolean A1 = vuGlassesManagerFragment.A1();
        Boolean valueOf = Boolean.valueOf(A1);
        if (!A1) {
            valueOf = null;
        }
        if (valueOf != null) {
            StaticMethodUtilsKt.t(vuGlassesManagerFragment, R.id.vuDisplayModeFragment);
        }
    }

    public static final /* synthetic */ void r1(VuGlassesManagerFragment vuGlassesManagerFragment, JoinPoint joinPoint, FastClickAspect fastClickAspect, ProceedingJoinPoint proceedingJoinPoint) {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !fastClickAspect.isFastClick(fastClickCheck.interval())) {
            q1(vuGlassesManagerFragment, proceedingJoinPoint);
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    public static final /* synthetic */ void s1(VuGlassesManagerFragment vuGlassesManagerFragment, JoinPoint joinPoint) {
        boolean A1 = vuGlassesManagerFragment.A1();
        Boolean valueOf = Boolean.valueOf(A1);
        if (!A1) {
            valueOf = null;
        }
        if (valueOf != null) {
            StaticMethodUtilsKt.t(vuGlassesManagerFragment, R.id.languageFragment);
        }
    }

    public static final /* synthetic */ void t1(VuGlassesManagerFragment vuGlassesManagerFragment, JoinPoint joinPoint, FastClickAspect fastClickAspect, ProceedingJoinPoint proceedingJoinPoint) {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !fastClickAspect.isFastClick(fastClickCheck.interval())) {
            s1(vuGlassesManagerFragment, proceedingJoinPoint);
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    public static final /* synthetic */ void u1(VuGlassesManagerFragment vuGlassesManagerFragment, JoinPoint joinPoint) {
        String str;
        boolean A1 = vuGlassesManagerFragment.A1();
        Boolean valueOf = Boolean.valueOf(A1);
        if (!A1) {
            valueOf = null;
        }
        if (valueOf != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("gravity", 17);
            VuGlassControlModel.ViewGlassesInfo viewGlassesInfo = (VuGlassControlModel.ViewGlassesInfo) VuGlassControlModel.f8109a.v().getValue();
            if (viewGlassesInfo == null || (str = viewGlassesInfo.b()) == null) {
                str = "";
            }
            StaticMethodUtilsKt.B(vuGlassesManagerFragment, CollectionsKt.arrayListOf(Integer.valueOf(MzContactsContract.MzSearchSnippetColumns.SEARCH_WEIGHT_CONTENT)), MapsKt.hashMapOf(new Pair(Integer.valueOf(MzContactsContract.MzSearchSnippetColumns.SEARCH_WEIGHT_CONTENT), str)), false, true, bundle);
        }
    }

    public static final /* synthetic */ void v1(VuGlassesManagerFragment vuGlassesManagerFragment, JoinPoint joinPoint, FastClickAspect fastClickAspect, ProceedingJoinPoint proceedingJoinPoint) {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !fastClickAspect.isFastClick(fastClickCheck.interval())) {
            u1(vuGlassesManagerFragment, proceedingJoinPoint);
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    public static final /* synthetic */ void w1(VuGlassesManagerFragment vuGlassesManagerFragment, JoinPoint joinPoint) {
        Context context;
        FragmentActivity activity;
        boolean A1 = vuGlassesManagerFragment.A1();
        Boolean valueOf = Boolean.valueOf(A1);
        if (!A1) {
            valueOf = null;
        }
        if (valueOf != null && (context = vuGlassesManagerFragment.getContext()) != null && (activity = vuGlassesManagerFragment.getActivity()) != null) {
            GenericMenuView genericMenuView = new GenericMenuView(context, vuGlassesManagerFragment.S0(), false, new VuGlassesManagerFragment$onClickGlassScreenOff$2$1$1(vuGlassesManagerFragment), vuGlassesManagerFragment.getString(R.string.auto_sleep));
            vuGlassesManagerFragment.n = genericMenuView;
            Intrinsics.checkNotNull(activity);
            genericMenuView.h(activity);
        }
    }

    public static final /* synthetic */ void x1(VuGlassesManagerFragment vuGlassesManagerFragment, JoinPoint joinPoint, FastClickAspect fastClickAspect, ProceedingJoinPoint proceedingJoinPoint) {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !fastClickAspect.isFastClick(fastClickCheck.interval())) {
            w1(vuGlassesManagerFragment, proceedingJoinPoint);
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    public static final /* synthetic */ void y1(VuGlassesManagerFragment vuGlassesManagerFragment, JoinPoint joinPoint) {
        if (!VuGlassControlModel.f8109a.z()) {
            StaticMethodUtilsKt.a0(vuGlassesManagerFragment);
        } else {
            StaticMethodUtilsKt.t(vuGlassesManagerFragment, R.id.vuGlassUpdateFragment);
        }
    }

    public static final /* synthetic */ void z1(VuGlassesManagerFragment vuGlassesManagerFragment, JoinPoint joinPoint, FastClickAspect fastClickAspect, ProceedingJoinPoint proceedingJoinPoint) {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !fastClickAspect.isFastClick(fastClickCheck.interval())) {
            y1(vuGlassesManagerFragment, proceedingJoinPoint);
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    public final void B1() {
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), Dispatchers.b(), (CoroutineStart) null, new VuGlassesManagerFragment$updatePreference$1(this, (Continuation<? super VuGlassesManagerFragment$updatePreference$1>) null), 2, (Object) null);
    }

    public final VuArSpacePreferenceModel R0() {
        return (VuArSpacePreferenceModel) this.m.getValue();
    }

    public final List S0() {
        ArrayList arrayList = new ArrayList();
        ControlUtils controlUtils = ControlUtils.f7858a;
        boolean z2 = false;
        arrayList.add(new GenericMenuView.MenuItem(controlUtils.v(30), 30, this.p == 30));
        arrayList.add(new GenericMenuView.MenuItem(controlUtils.v(60), 60, this.p == 60));
        String v2 = controlUtils.v(120);
        if (this.p == 120) {
            z2 = true;
        }
        arrayList.add(new GenericMenuView.MenuItem(v2, 120, z2));
        return arrayList;
    }

    public final String T0(int i) {
        int i2 = i / 60;
        if (i2 == 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(GlobalExtKt.h(R.string.control_auto_screen_off_sec), Arrays.copyOf(new Object[]{String.valueOf(i)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        } else if (i2 == 1) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format(GlobalExtKt.h(R.string.control_auto_screen_off_min), Arrays.copyOf(new Object[]{String.valueOf(i2)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            return format2;
        } else {
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            String format3 = String.format(GlobalExtKt.h(R.string.control_auto_screen_off_mins), Arrays.copyOf(new Object[]{String.valueOf(i2)}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
            return format3;
        }
    }

    public final VuGlassesPreferenceModel U0() {
        return (VuGlassesPreferenceModel) this.l.getValue();
    }

    public void c(int i, Object obj) {
        String str;
        super.c(i, obj);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("VuGlassesManagerFragment", "jumpAction: windowTYpe: " + i + ", data: " + obj);
        if (i == 10002 && (str = (String) obj) != null && !StringsKt.isBlank(str)) {
            Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new VuGlassesManagerFragment$jumpAction$1(str, (Continuation<? super VuGlassesManagerFragment$jumpAction$1>) null), 3, (Object) null);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        if (this.j == null) {
            FragmentVuGlassesManagerBinding c = FragmentVuGlassesManagerBinding.c(layoutInflater, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
            this.j = c;
        }
        FragmentVuGlassesManagerBinding fragmentVuGlassesManagerBinding = this.j;
        if (fragmentVuGlassesManagerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuGlassesManagerBinding = null;
        }
        ConstraintLayout b = fragmentVuGlassesManagerBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        return b;
    }

    public void onDestroyView() {
        super.onDestroyView();
        VuGlassesOtaModel.f8117a.F(this.o);
    }

    public void onStop() {
        super.onStop();
        GenericWindowManger.c.a().j(MzContactsContract.MzSearchSnippetColumns.SEARCH_WEIGHT_CONTENT);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        B1();
        initView();
        W0();
    }
}
