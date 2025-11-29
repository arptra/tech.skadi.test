package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.alibaba.fastjson.asm.Opcodes;
import com.honey.account.h8.j1;
import com.honey.account.h8.k1;
import com.honey.account.h8.l1;
import com.honey.account.h8.m1;
import com.honey.account.h8.n1;
import com.honey.account.h8.o1;
import com.honey.account.h8.p1;
import com.honey.account.h8.q1;
import com.honey.account.h8.r1;
import com.honey.account.h8.s1;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.annotation.ConnectCheck;
import com.upuphone.xr.annotation.FastClickCheck;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.aspect.AspectHelper;
import com.upuphone.xr.sapp.aspect.ConnectCheckAspect;
import com.upuphone.xr.sapp.aspect.FastClickAspect;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$3;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$4;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$5;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.databinding.FragmentControlBinding;
import com.upuphone.xr.sapp.datatrack.ReminderDataTrackEvent;
import com.upuphone.xr.sapp.entity.UnicronBatteryInfo;
import com.upuphone.xr.sapp.glass.GlassUpdateHelper;
import com.upuphone.xr.sapp.utils.AppUpdateHelper;
import com.upuphone.xr.sapp.utils.ControlUtils;
import com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.utils.ViewExtKt;
import com.upuphone.xr.sapp.view.CardItemView;
import com.upuphone.xr.sapp.view.GenericMenuView;
import com.upuphone.xr.sapp.view.SuperGenericWindowView;
import com.upuphone.xr.sapp.vm.DeviceControlModel;
import com.upuphone.xr.sapp.vm.SuperViewModel;
import io.netty.handler.codec.dns.DnsRecord;
import java.lang.reflect.Method;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.runtime.reflect.Factory;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 S2\u00020\u00012\u00020\u0002:\u0001TB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0017\u0010\u0004J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001c\u0010\u0004J\u0017\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001e\u0010\tJ+\u0010&\u001a\u00020%2\u0006\u0010 \u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b&\u0010'J!\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0007H\u0016¢\u0006\u0004\b+\u0010\u0004J\u000f\u0010,\u001a\u00020\u0007H\u0016¢\u0006\u0004\b,\u0010\u0004J\u000f\u0010-\u001a\u00020\u0007H\u0016¢\u0006\u0004\b-\u0010\u0004J)\u00103\u001a\u00020\u00072\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020.2\b\u00102\u001a\u0004\u0018\u000101H\u0016¢\u0006\u0004\b3\u00104J\u001f\u00107\u001a\u00020\u00072\u0006\u00105\u001a\u00020.2\u0006\u00106\u001a\u00020.H\u0016¢\u0006\u0004\b7\u00108J!\u0010:\u001a\u00020\u00072\u0006\u00105\u001a\u00020.2\b\u00102\u001a\u0004\u0018\u000109H\u0016¢\u0006\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u001b\u0010H\u001a\u00020C8BX\u0002¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u001b\u0010M\u001a\u00020I8BX\u0002¢\u0006\f\n\u0004\bJ\u0010E\u001a\u0004\bK\u0010LR\u0014\u0010P\u001a\u00020\u00058\u0002XD¢\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010R\u001a\u00020\u00058\u0002XD¢\u0006\u0006\n\u0004\bQ\u0010O¨\u0006U"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/ControlFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "Lcom/upuphone/xr/sapp/view/SuperGenericWindowView$IActionCallback;", "<init>", "()V", "", "enable", "", "K1", "(Z)V", "L1", "I1", "N1", "Q0", "initView", "onClickDisturbModel", "onClickAirModel", "onClickNetworkSetting", "onClickNotifyCard", "onClickVoiceManager", "onClickCommonSetting", "onClickGlassScreenOff", "onClickTouchPad", "N0", "Lcom/upuphone/xr/sapp/entity/UnicronBatteryInfo;", "batteryInfo", "M1", "(Lcom/upuphone/xr/sapp/entity/UnicronBatteryInfo;)V", "J1", "state", "P0", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", "onDestroyView", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "windowType", "actionType", "a", "(II)V", "", "c", "(ILjava/lang/Object;)V", "Lcom/upuphone/xr/sapp/databinding/FragmentControlBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentControlBinding;", "binding", "k", "I", "mHeight", "Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "l", "Lkotlin/Lazy;", "n0", "()Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "viewModel", "Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "m", "R0", "()Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "mDeviceModel", "n", "Z", "defaultEnable", "o", "develop", "p", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nControlFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ControlFragment.kt\ncom/upuphone/xr/sapp/fragment/ControlFragment\n+ 2 GlobalViewStoreExt.kt\ncom/upuphone/xr/sapp/common/GlobalViewStoreExtKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,422:1\n32#2,12:423\n32#2,12:435\n256#3,2:447\n256#3,2:449\n256#3,2:451\n256#3,2:453\n256#3,2:455\n256#3,2:457\n*S KotlinDebug\n*F\n+ 1 ControlFragment.kt\ncom/upuphone/xr/sapp/fragment/ControlFragment\n*L\n52#1:423,12\n53#1:435,12\n111#1:447,2\n113#1:449,2\n114#1:451,2\n115#1:453,2\n364#1:455,2\n365#1:457,2\n*E\n"})
public final class ControlFragment extends BaseFragment implements SuperGenericWindowView.IActionCallback {
    public static final Companion p = new Companion((DefaultConstructorMarker) null);
    public static /* synthetic */ JoinPoint.StaticPart q;
    public static /* synthetic */ JoinPoint.StaticPart r;
    public static /* synthetic */ JoinPoint.StaticPart s;
    public static /* synthetic */ JoinPoint.StaticPart t;
    public static /* synthetic */ JoinPoint.StaticPart u;
    public static /* synthetic */ JoinPoint.StaticPart v;
    public static /* synthetic */ JoinPoint.StaticPart w;
    public static /* synthetic */ JoinPoint.StaticPart x;
    public FragmentControlBinding j;
    public int k;
    public final Lazy l;
    public final Lazy m;
    public final boolean n;
    public final boolean o;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/ControlFragment$Companion;", "", "()V", "PERMISSION_NOTIFICATION_REQUEST_CODE", "", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    static {
        O0();
    }

    public ControlFragment() {
        Class<SuperViewModel> cls = SuperViewModel.class;
        this.l = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls), new GlobalViewStoreExtKt$cachedViewModels$3(cls.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
        Class<DeviceControlModel> cls2 = DeviceControlModel.class;
        this.m = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls2), new GlobalViewStoreExtKt$cachedViewModels$3(cls2.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
    }

    public static final /* synthetic */ void A1(ControlFragment controlFragment, JoinPoint joinPoint) {
        if (GlassUpdateHelper.b.b1()) {
            StaticMethodUtilsKt.O(controlFragment);
        } else {
            AppUpdateHelper.f7841a.u();
        }
    }

    public static final /* synthetic */ void B1(ControlFragment controlFragment, JoinPoint joinPoint, ConnectCheckAspect connectCheckAspect, ProceedingJoinPoint proceedingJoinPoint) {
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        if (AspectHelper.INSTANCE.getDeviceConnect()) {
            A1(controlFragment, proceedingJoinPoint);
            return;
        }
        UToast.Companion companion = UToast.f6444a;
        MainApplication.Companion companion2 = MainApplication.k;
        MainApplication f = companion2.f();
        String string = companion2.f().getString(R.string.device_disconnect);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.d(f, string);
    }

    public static final /* synthetic */ void D1(ControlFragment controlFragment, JoinPoint joinPoint, FastClickAspect fastClickAspect, ProceedingJoinPoint proceedingJoinPoint) {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !fastClickAspect.isFastClick(fastClickCheck.interval())) {
            B1(controlFragment, proceedingJoinPoint, ConnectCheckAspect.aspectOf(), (ProceedingJoinPoint) proceedingJoinPoint);
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    public static final /* synthetic */ void E1(ControlFragment controlFragment, JoinPoint joinPoint) {
        if (GlassUpdateHelper.b.b1()) {
            StaticMethodUtilsKt.O(controlFragment);
        } else if (!AppUpdateHelper.f7841a.u()) {
            StaticMethodUtilsKt.t(controlFragment, R.id.voiceAssistantsFragment);
        }
    }

    public static final /* synthetic */ void F1(ControlFragment controlFragment, JoinPoint joinPoint, ConnectCheckAspect connectCheckAspect, ProceedingJoinPoint proceedingJoinPoint) {
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        if (AspectHelper.INSTANCE.getDeviceConnect()) {
            E1(controlFragment, proceedingJoinPoint);
            return;
        }
        UToast.Companion companion = UToast.f6444a;
        MainApplication.Companion companion2 = MainApplication.k;
        MainApplication f = companion2.f();
        String string = companion2.f().getString(R.string.device_disconnect);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.d(f, string);
    }

    public static final /* synthetic */ void H1(ControlFragment controlFragment, JoinPoint joinPoint, FastClickAspect fastClickAspect, ProceedingJoinPoint proceedingJoinPoint) {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !fastClickAspect.isFastClick(fastClickCheck.interval())) {
            F1(controlFragment, proceedingJoinPoint, ConnectCheckAspect.aspectOf(), (ProceedingJoinPoint) proceedingJoinPoint);
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    private final void J1() {
        n0().r().removeObservers(getViewLifecycleOwner());
        n0().E0().removeObservers(getViewLifecycleOwner());
        n0().m().removeObservers(getViewLifecycleOwner());
        n0().q().removeObservers(getViewLifecycleOwner());
        n0().K0().removeObservers(getViewLifecycleOwner());
    }

    private final void N0() {
        n0().r().observe(getViewLifecycleOwner(), new ControlFragment$sam$androidx_lifecycle_Observer$0(new ControlFragment$addObserve$1(this)));
        n0().E0().observe(getViewLifecycleOwner(), new ControlFragment$sam$androidx_lifecycle_Observer$0(new ControlFragment$addObserve$2(this)));
        n0().m().observe(getViewLifecycleOwner(), new ControlFragment$sam$androidx_lifecycle_Observer$0(new ControlFragment$addObserve$3(this)));
        n0().q().observe(getViewLifecycleOwner(), new ControlFragment$sam$androidx_lifecycle_Observer$0(new ControlFragment$addObserve$4(this)));
        n0().K0().observe(getViewLifecycleOwner(), new ControlFragment$sam$androidx_lifecycle_Observer$0(new ControlFragment$addObserve$5(this)));
    }

    private static /* synthetic */ void O0() {
        Factory factory = new Factory("ControlFragment.kt", ControlFragment.class);
        q = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "onClickDisturbModel", "com.upuphone.xr.sapp.fragment.ControlFragment", "", "", "", "void"), (int) Opcodes.IFNONNULL);
        r = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "onClickAirModel", "com.upuphone.xr.sapp.fragment.ControlFragment", "", "", "", "void"), 216);
        s = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "onClickNetworkSetting", "com.upuphone.xr.sapp.fragment.ControlFragment", "", "", "", "void"), 239);
        t = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "onClickNotifyCard", "com.upuphone.xr.sapp.fragment.ControlFragment", "", "", "", "void"), (int) DnsRecord.CLASS_NONE);
        u = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "onClickVoiceManager", "com.upuphone.xr.sapp.fragment.ControlFragment", "", "", "", "void"), 273);
        v = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "onClickCommonSetting", "com.upuphone.xr.sapp.fragment.ControlFragment", "", "", "", "void"), 288);
        w = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "onClickGlassScreenOff", "com.upuphone.xr.sapp.fragment.ControlFragment", "", "", "", "void"), 295);
        x = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "onClickTouchPad", "com.upuphone.xr.sapp.fragment.ControlFragment", "", "", "", "void"), 325);
    }

    private final DeviceControlModel R0() {
        return (DeviceControlModel) this.m.getValue();
    }

    public static final void S0(ControlFragment controlFragment, View view) {
        Intrinsics.checkNotNullParameter(controlFragment, "this$0");
        controlFragment.onClickDisturbModel();
    }

    public static final void T0(ControlFragment controlFragment, View view) {
        Intrinsics.checkNotNullParameter(controlFragment, "this$0");
        controlFragment.onClickAirModel();
    }

    public static final void U0(ControlFragment controlFragment, View view) {
        Intrinsics.checkNotNullParameter(controlFragment, "this$0");
        controlFragment.onClickNetworkSetting();
    }

    public static final void V0(ControlFragment controlFragment, View view) {
        Intrinsics.checkNotNullParameter(controlFragment, "this$0");
        controlFragment.onClickNotifyCard();
    }

    public static final void W0(ControlFragment controlFragment, View view) {
        Intrinsics.checkNotNullParameter(controlFragment, "this$0");
        controlFragment.onClickVoiceManager();
    }

    public static final boolean X0(ControlFragment controlFragment, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(controlFragment, "this$0");
        if (motionEvent.getAction() != 0) {
            return false;
        }
        if (!AspectHelper.INSTANCE.getDeviceConnect()) {
            StaticMethodUtilsKt.Y(controlFragment);
            return true;
        } else if (!GlassUpdateHelper.b.b1()) {
            return AppUpdateHelper.f7841a.u();
        } else {
            StaticMethodUtilsKt.O(controlFragment);
            return true;
        }
    }

    public static final void Y0(ControlFragment controlFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(controlFragment, "this$0");
        controlFragment.n0().h(z);
    }

    public static final void Z0(ControlFragment controlFragment, View view) {
        Intrinsics.checkNotNullParameter(controlFragment, "this$0");
        controlFragment.onClickCommonSetting();
    }

    public static final void a1(ControlFragment controlFragment, View view) {
        Intrinsics.checkNotNullParameter(controlFragment, "this$0");
        controlFragment.onClickGlassScreenOff();
    }

    public static final void b1(ControlFragment controlFragment, View view) {
        Intrinsics.checkNotNullParameter(controlFragment, "this$0");
        controlFragment.onClickTouchPad();
    }

    public static final /* synthetic */ void c1(ControlFragment controlFragment, JoinPoint joinPoint) {
        if (GlassUpdateHelper.b.b1()) {
            StaticMethodUtilsKt.O(controlFragment);
        } else if (!AppUpdateHelper.f7841a.u()) {
            FragmentControlBinding fragmentControlBinding = controlFragment.j;
            FragmentControlBinding fragmentControlBinding2 = null;
            if (fragmentControlBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentControlBinding = null;
            }
            if (!fragmentControlBinding.b.isSelected()) {
                StaticMethodUtilsKt.C(controlFragment, CollectionsKt.arrayListOf(111), true, true);
                return;
            }
            FragmentControlBinding fragmentControlBinding3 = controlFragment.j;
            if (fragmentControlBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentControlBinding2 = fragmentControlBinding3;
            }
            controlFragment.P0(!fragmentControlBinding2.b.isSelected());
        }
    }

    public static final /* synthetic */ void d1(ControlFragment controlFragment, JoinPoint joinPoint, ConnectCheckAspect connectCheckAspect, ProceedingJoinPoint proceedingJoinPoint) {
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        if (AspectHelper.INSTANCE.getDeviceConnect()) {
            c1(controlFragment, proceedingJoinPoint);
            return;
        }
        UToast.Companion companion = UToast.f6444a;
        MainApplication.Companion companion2 = MainApplication.k;
        MainApplication f = companion2.f();
        String string = companion2.f().getString(R.string.device_disconnect);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.d(f, string);
    }

    public static final /* synthetic */ void f1(ControlFragment controlFragment, JoinPoint joinPoint, FastClickAspect fastClickAspect, ProceedingJoinPoint proceedingJoinPoint) {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !fastClickAspect.isFastClick(fastClickCheck.interval())) {
            d1(controlFragment, proceedingJoinPoint, ConnectCheckAspect.aspectOf(), (ProceedingJoinPoint) proceedingJoinPoint);
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    public static final /* synthetic */ void h1(ControlFragment controlFragment, JoinPoint joinPoint, ConnectCheckAspect connectCheckAspect, ProceedingJoinPoint proceedingJoinPoint) {
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        if (AspectHelper.INSTANCE.getDeviceConnect()) {
            StaticMethodUtilsKt.t(controlFragment, R.id.commonSettingFragment);
            return;
        }
        UToast.Companion companion = UToast.f6444a;
        MainApplication.Companion companion2 = MainApplication.k;
        MainApplication f = companion2.f();
        String string = companion2.f().getString(R.string.device_disconnect);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.d(f, string);
    }

    private final void initView() {
        L1();
        FragmentControlBinding fragmentControlBinding = this.j;
        FragmentControlBinding fragmentControlBinding2 = null;
        if (fragmentControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentControlBinding = null;
        }
        fragmentControlBinding.i.setOnClickListener(new j1(this));
        FragmentControlBinding fragmentControlBinding3 = this.j;
        if (fragmentControlBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentControlBinding3 = null;
        }
        fragmentControlBinding3.b.setOnClickListener(new k1(this));
        FragmentControlBinding fragmentControlBinding4 = this.j;
        if (fragmentControlBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentControlBinding4 = null;
        }
        fragmentControlBinding4.h.setOnClickListener(new l1(this));
        FragmentControlBinding fragmentControlBinding5 = this.j;
        if (fragmentControlBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentControlBinding5 = null;
        }
        fragmentControlBinding5.l.setOnClickListener(new m1(this));
        FragmentControlBinding fragmentControlBinding6 = this.j;
        if (fragmentControlBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentControlBinding6 = null;
        }
        fragmentControlBinding6.m.setOnClickListener(new n1(this));
        FragmentControlBinding fragmentControlBinding7 = this.j;
        if (fragmentControlBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentControlBinding7 = null;
        }
        fragmentControlBinding7.k.setSwitchOnTouchListener(new o1(this));
        FragmentControlBinding fragmentControlBinding8 = this.j;
        if (fragmentControlBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentControlBinding8 = null;
        }
        fragmentControlBinding8.k.setSwitchListener(new p1(this));
        FragmentControlBinding fragmentControlBinding9 = this.j;
        if (fragmentControlBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentControlBinding9 = null;
        }
        CardItemView cardItemView = fragmentControlBinding9.j;
        Intrinsics.checkNotNullExpressionValue(cardItemView, "normalCard");
        ViewExtKt.b(cardItemView, new q1(this));
        GlassUpdateHelper.b.C0().observe(getViewLifecycleOwner(), new ControlFragment$sam$androidx_lifecycle_Observer$0(new ControlFragment$initView$9(this)));
        FragmentControlBinding fragmentControlBinding10 = this.j;
        if (fragmentControlBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentControlBinding10 = null;
        }
        fragmentControlBinding10.c.setOnClickListener(new r1(this));
        FragmentControlBinding fragmentControlBinding11 = this.j;
        if (fragmentControlBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentControlBinding2 = fragmentControlBinding11;
        }
        fragmentControlBinding2.u.setOnClickListener(new s1(this));
    }

    public static final /* synthetic */ void j1(ControlFragment controlFragment, JoinPoint joinPoint, FastClickAspect fastClickAspect, ProceedingJoinPoint proceedingJoinPoint) {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !fastClickAspect.isFastClick(fastClickCheck.interval())) {
            h1(controlFragment, proceedingJoinPoint, ConnectCheckAspect.aspectOf(), (ProceedingJoinPoint) proceedingJoinPoint);
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    public static final /* synthetic */ void k1(ControlFragment controlFragment, JoinPoint joinPoint) {
        if (GlassUpdateHelper.b.b1()) {
            StaticMethodUtilsKt.O(controlFragment);
        } else if (!AppUpdateHelper.f7841a.u()) {
            FragmentControlBinding fragmentControlBinding = controlFragment.j;
            FragmentControlBinding fragmentControlBinding2 = null;
            if (fragmentControlBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentControlBinding = null;
            }
            boolean z = !fragmentControlBinding.i.isSelected();
            FragmentControlBinding fragmentControlBinding3 = controlFragment.j;
            if (fragmentControlBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentControlBinding2 = fragmentControlBinding3;
            }
            fragmentControlBinding2.i.setSelected(z);
            ControlUtils controlUtils = ControlUtils.f7858a;
            String packageName = controlFragment.requireContext().getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
            controlUtils.X(packageName, z);
        }
    }

    public static final /* synthetic */ void l1(ControlFragment controlFragment, JoinPoint joinPoint, ConnectCheckAspect connectCheckAspect, ProceedingJoinPoint proceedingJoinPoint) {
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        if (AspectHelper.INSTANCE.getDeviceConnect()) {
            k1(controlFragment, proceedingJoinPoint);
            return;
        }
        UToast.Companion companion = UToast.f6444a;
        MainApplication.Companion companion2 = MainApplication.k;
        MainApplication f = companion2.f();
        String string = companion2.f().getString(R.string.device_disconnect);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.d(f, string);
    }

    private final SuperViewModel n0() {
        return (SuperViewModel) this.l.getValue();
    }

    public static final /* synthetic */ void n1(ControlFragment controlFragment, JoinPoint joinPoint, FastClickAspect fastClickAspect, ProceedingJoinPoint proceedingJoinPoint) {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !fastClickAspect.isFastClick(fastClickCheck.interval())) {
            l1(controlFragment, proceedingJoinPoint, ConnectCheckAspect.aspectOf(), (ProceedingJoinPoint) proceedingJoinPoint);
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    public static final /* synthetic */ void o1(ControlFragment controlFragment, JoinPoint joinPoint) {
        Context context;
        FragmentActivity activity;
        if (GlassUpdateHelper.b.b1()) {
            StaticMethodUtilsKt.O(controlFragment);
        } else if (!AppUpdateHelper.f7841a.u() && (context = controlFragment.getContext()) != null && (activity = controlFragment.getActivity()) != null) {
            GenericMenuView genericMenuView = new GenericMenuView(context, ControlUtils.f7858a.r(), false, new ControlFragment$onClickGlassScreenOff$1$1$1(controlFragment), (String) null, 16, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNull(activity);
            genericMenuView.h(activity);
        }
    }

    @ConnectCheck
    @Keep
    @FastClickCheck
    private final void onClickAirModel() {
        JoinPoint makeJP = Factory.makeJP(r, this, this);
        f1(this, makeJP, FastClickAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    @ConnectCheck
    @Keep
    @FastClickCheck
    private final void onClickCommonSetting() {
        JoinPoint makeJP = Factory.makeJP(v, this, this);
        j1(this, makeJP, FastClickAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    @ConnectCheck
    @Keep
    @FastClickCheck
    private final void onClickDisturbModel() {
        JoinPoint makeJP = Factory.makeJP(q, this, this);
        n1(this, makeJP, FastClickAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    @ConnectCheck
    @Keep
    @FastClickCheck
    private final void onClickGlassScreenOff() {
        JoinPoint makeJP = Factory.makeJP(w, this, this);
        r1(this, makeJP, FastClickAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    @ConnectCheck
    @Keep
    @FastClickCheck
    private final void onClickNetworkSetting() {
        JoinPoint makeJP = Factory.makeJP(s, this, this);
        t1(this, makeJP, FastClickAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    @ConnectCheck
    @Keep
    @FastClickCheck
    private final void onClickNotifyCard() {
        JoinPoint makeJP = Factory.makeJP(t, this, this);
        z1(this, makeJP, FastClickAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    @ConnectCheck
    @Keep
    @FastClickCheck
    private final void onClickTouchPad() {
        JoinPoint makeJP = Factory.makeJP(x, this, this);
        D1(this, makeJP, FastClickAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    @ConnectCheck
    @Keep
    @FastClickCheck
    private final void onClickVoiceManager() {
        JoinPoint makeJP = Factory.makeJP(u, this, this);
        H1(this, makeJP, FastClickAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    public static final /* synthetic */ void p1(ControlFragment controlFragment, JoinPoint joinPoint, ConnectCheckAspect connectCheckAspect, ProceedingJoinPoint proceedingJoinPoint) {
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        if (AspectHelper.INSTANCE.getDeviceConnect()) {
            o1(controlFragment, proceedingJoinPoint);
            return;
        }
        UToast.Companion companion = UToast.f6444a;
        MainApplication.Companion companion2 = MainApplication.k;
        MainApplication f = companion2.f();
        String string = companion2.f().getString(R.string.device_disconnect);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.d(f, string);
    }

    public static final /* synthetic */ void r1(ControlFragment controlFragment, JoinPoint joinPoint, FastClickAspect fastClickAspect, ProceedingJoinPoint proceedingJoinPoint) {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !fastClickAspect.isFastClick(fastClickCheck.interval())) {
            p1(controlFragment, proceedingJoinPoint, ConnectCheckAspect.aspectOf(), (ProceedingJoinPoint) proceedingJoinPoint);
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    public static final /* synthetic */ void t1(ControlFragment controlFragment, JoinPoint joinPoint, FastClickAspect fastClickAspect, ProceedingJoinPoint proceedingJoinPoint) {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !fastClickAspect.isFastClick(fastClickCheck.interval())) {
            v1(controlFragment, proceedingJoinPoint, ConnectCheckAspect.aspectOf(), (ProceedingJoinPoint) proceedingJoinPoint);
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    public static final /* synthetic */ void u1(ControlFragment controlFragment, JoinPoint joinPoint) {
        if (GlassUpdateHelper.b.b1()) {
            StaticMethodUtilsKt.O(controlFragment);
        } else if (!AppUpdateHelper.f7841a.u()) {
            StaticMethodUtilsKt.t(controlFragment, R.id.wifiSettingFragment);
        }
    }

    public static final /* synthetic */ void v1(ControlFragment controlFragment, JoinPoint joinPoint, ConnectCheckAspect connectCheckAspect, ProceedingJoinPoint proceedingJoinPoint) {
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        if (AspectHelper.INSTANCE.getDeviceConnect()) {
            u1(controlFragment, proceedingJoinPoint);
            return;
        }
        UToast.Companion companion = UToast.f6444a;
        MainApplication.Companion companion2 = MainApplication.k;
        MainApplication f = companion2.f();
        String string = companion2.f().getString(R.string.device_disconnect);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.d(f, string);
    }

    public static final /* synthetic */ void w1(ControlFragment controlFragment, JoinPoint joinPoint) {
        if (GlassUpdateHelper.b.b1()) {
            StaticMethodUtilsKt.O(controlFragment);
        } else if (!AppUpdateHelper.f7841a.u()) {
            PermissionAndStateCheckUtils permissionAndStateCheckUtils = PermissionAndStateCheckUtils.f7907a;
            Context requireContext = controlFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            if (!permissionAndStateCheckUtils.g(requireContext)) {
                StaticMethodUtilsKt.I(controlFragment, CollectionsKt.arrayListOf(107), false, false, 6, (Object) null);
                return;
            }
            StaticMethodUtilsKt.t(controlFragment, R.id.notifyFragment);
        }
    }

    public static final /* synthetic */ void x1(ControlFragment controlFragment, JoinPoint joinPoint, ConnectCheckAspect connectCheckAspect, ProceedingJoinPoint proceedingJoinPoint) {
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        if (AspectHelper.INSTANCE.getDeviceConnect()) {
            w1(controlFragment, proceedingJoinPoint);
            return;
        }
        UToast.Companion companion = UToast.f6444a;
        MainApplication.Companion companion2 = MainApplication.k;
        MainApplication f = companion2.f();
        String string = companion2.f().getString(R.string.device_disconnect);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.d(f, string);
    }

    public static final /* synthetic */ void z1(ControlFragment controlFragment, JoinPoint joinPoint, FastClickAspect fastClickAspect, ProceedingJoinPoint proceedingJoinPoint) {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !fastClickAspect.isFastClick(fastClickCheck.interval())) {
            x1(controlFragment, proceedingJoinPoint, ConnectCheckAspect.aspectOf(), (ProceedingJoinPoint) proceedingJoinPoint);
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    public final void I1() {
        R0().L().observe(getViewLifecycleOwner(), new ControlFragment$sam$androidx_lifecycle_Observer$0(new ControlFragment$registerDeviceConnectCallback$1(this)));
    }

    public final void K1(boolean z) {
        FragmentControlBinding fragmentControlBinding = this.j;
        if (fragmentControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentControlBinding = null;
        }
        fragmentControlBinding.t.setAlpha(z ? 1.0f : 0.5f);
    }

    public final void L1() {
        FragmentControlBinding fragmentControlBinding = this.j;
        FragmentControlBinding fragmentControlBinding2 = null;
        if (fragmentControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentControlBinding = null;
        }
        CardItemView cardItemView = fragmentControlBinding.k;
        Intrinsics.checkNotNullExpressionValue(cardItemView, "notifyCallVoiceAdjust");
        int i = 8;
        cardItemView.setVisibility(this.o ? 0 : 8);
        FragmentControlBinding fragmentControlBinding3 = this.j;
        if (fragmentControlBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentControlBinding3 = null;
        }
        ConstraintLayout constraintLayout = fragmentControlBinding3.q;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "ringItem");
        constraintLayout.setVisibility(this.o ? 0 : 8);
        FragmentControlBinding fragmentControlBinding4 = this.j;
        if (fragmentControlBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentControlBinding4 = null;
        }
        ConstraintLayout constraintLayout2 = fragmentControlBinding4.b;
        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "airModel");
        constraintLayout2.setVisibility(this.o ? 0 : 8);
        FragmentControlBinding fragmentControlBinding5 = this.j;
        if (fragmentControlBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentControlBinding2 = fragmentControlBinding5;
        }
        ConstraintLayout constraintLayout3 = fragmentControlBinding2.i;
        Intrinsics.checkNotNullExpressionValue(constraintLayout3, "noDisturbModel");
        if (this.o) {
            i = 0;
        }
        constraintLayout3.setVisibility(i);
    }

    public final void M1(UnicronBatteryInfo unicronBatteryInfo) {
        String str;
        FragmentControlBinding fragmentControlBinding = this.j;
        FragmentControlBinding fragmentControlBinding2 = null;
        if (fragmentControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentControlBinding = null;
        }
        fragmentControlBinding.o.setProgress(unicronBatteryInfo.getCapacity());
        FragmentControlBinding fragmentControlBinding3 = this.j;
        if (fragmentControlBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentControlBinding3 = null;
        }
        ProgressBar progressBar = fragmentControlBinding3.o;
        Intrinsics.checkNotNullExpressionValue(progressBar, "ringBatteryProgress");
        int i = 8;
        progressBar.setVisibility(unicronBatteryInfo.isConnect() ? 0 : 8);
        FragmentControlBinding fragmentControlBinding4 = this.j;
        if (fragmentControlBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentControlBinding4 = null;
        }
        ImageView imageView = fragmentControlBinding4.n;
        Intrinsics.checkNotNullExpressionValue(imageView, "ringBatteryBg");
        if (unicronBatteryInfo.isConnect()) {
            i = 0;
        }
        imageView.setVisibility(i);
        FragmentControlBinding fragmentControlBinding5 = this.j;
        if (fragmentControlBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentControlBinding5 = null;
        }
        TextView textView = fragmentControlBinding5.p;
        if (unicronBatteryInfo.isConnect()) {
            str = unicronBatteryInfo.getCapacity() + "%";
        } else {
            str = getString(R.string.unconnected);
        }
        textView.setText(str);
        Drawable b = AppCompatResources.b(requireContext(), unicronBatteryInfo.getCapacity() <= 5 ? R.drawable.progress_battery_low : unicronBatteryInfo.getCapacity() <= 15 ? R.drawable.progress_battery_low_15 : R.drawable.progress_battery_normal);
        FragmentControlBinding fragmentControlBinding6 = this.j;
        if (fragmentControlBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentControlBinding6 = null;
        }
        fragmentControlBinding6.o.setIndeterminateDrawable(b);
        FragmentControlBinding fragmentControlBinding7 = this.j;
        if (fragmentControlBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentControlBinding2 = fragmentControlBinding7;
        }
        fragmentControlBinding2.o.setProgressDrawable(b);
    }

    public final void N1() {
        FragmentControlBinding fragmentControlBinding = this.j;
        FragmentControlBinding fragmentControlBinding2 = null;
        if (fragmentControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentControlBinding = null;
        }
        ConstraintLayout constraintLayout = fragmentControlBinding.i;
        ControlUtils controlUtils = ControlUtils.f7858a;
        constraintLayout.setSelected(controlUtils.D());
        FragmentControlBinding fragmentControlBinding3 = this.j;
        if (fragmentControlBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentControlBinding3 = null;
        }
        fragmentControlBinding3.b.setSelected(controlUtils.d());
        FragmentControlBinding fragmentControlBinding4 = this.j;
        if (fragmentControlBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentControlBinding4 = null;
        }
        fragmentControlBinding4.k.setSwitchState(controlUtils.C());
        FragmentControlBinding fragmentControlBinding5 = this.j;
        if (fragmentControlBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentControlBinding2 = fragmentControlBinding5;
        }
        fragmentControlBinding2.c.setCardSubTitle(controlUtils.u());
    }

    public final void P0(boolean z) {
        FragmentControlBinding fragmentControlBinding = this.j;
        if (fragmentControlBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentControlBinding = null;
        }
        fragmentControlBinding.b.setSelected(z);
        ControlUtils controlUtils = ControlUtils.f7858a;
        String packageName = requireContext().getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        controlUtils.U(packageName, z);
    }

    public final void Q0() {
        ControlUtils controlUtils = ControlUtils.f7858a;
        controlUtils.j(requireContext().getPackageName());
        controlUtils.l(requireContext().getPackageName());
        String packageName = requireContext().getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        controlUtils.c(packageName);
        controlUtils.t(requireContext().getPackageName());
        controlUtils.j(requireContext().getPackageName());
    }

    public void a(int i, int i2) {
        if (i != 111) {
            return;
        }
        if (i2 == 1101) {
            P0(true);
        } else if (i2 == 1102) {
            ULog.f6446a.a("AccountFragment", "WINDOW_TYPE_AIR_MODE_OPEN...取消");
        }
    }

    public void c(int i, Object obj) {
        if (i == 107) {
            startActivityForResult(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"), 300);
            SdkContext.f6675a.d().reportEvent(ReminderDataTrackEvent.APP_CLICK_REMIND_POP, new HashMap());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("ControlFragment", "onActivityResult::requestCode is: " + i + " and resultCode is: " + i2);
        if (i == 300) {
            PermissionAndStateCheckUtils permissionAndStateCheckUtils = PermissionAndStateCheckUtils.f7907a;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            if (permissionAndStateCheckUtils.g(requireContext)) {
                StaticMethodUtilsKt.t(this, R.id.notifyFragment);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentControlBinding c = FragmentControlBinding.c(getLayoutInflater(), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.j = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        ScrollView b = c.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        return b;
    }

    public void onDestroyView() {
        super.onDestroyView();
        ULog.f6446a.a("ControlFragment", "onDestroyView");
        J1();
    }

    public void onPause() {
        super.onPause();
        R0().L().removeObservers(getViewLifecycleOwner());
    }

    public void onResume() {
        super.onResume();
        I1();
        Q0();
        N1();
        if (this.k > 0) {
            FragmentControlBinding fragmentControlBinding = null;
            if (n0().h0() == 0) {
                SuperViewModel n0 = n0();
                int i = this.k;
                FragmentControlBinding fragmentControlBinding2 = this.j;
                if (fragmentControlBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentControlBinding2 = null;
                }
                n0.a1(i - fragmentControlBinding2.d.getHeight());
            }
            FragmentControlBinding fragmentControlBinding3 = this.j;
            if (fragmentControlBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentControlBinding = fragmentControlBinding3;
            }
            ViewGroup.LayoutParams layoutParams = fragmentControlBinding.e.getLayoutParams();
            ULog.f6446a.a("ControlFragment", "do onResume:: mHeight is: " + this.k + " and mReSizeHeight is: " + n0().h0());
            layoutParams.height = n0().h0();
            this.k = 0;
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView();
        K1(this.n);
        N0();
    }
}
