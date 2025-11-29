package com.xjmz.myvu.modules.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$3;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$4;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$5;
import com.upuphone.xr.sapp.common.MzAccountManager;
import com.upuphone.xr.sapp.context.GlassInfoExtKt;
import com.upuphone.xr.sapp.context.IGlassInfo;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.entity.AccountInfo;
import com.upuphone.xr.sapp.entity.PermissionDesp;
import com.upuphone.xr.sapp.glass.GlassUpdateHelper;
import com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager;
import com.upuphone.xr.sapp.monitor.sport.mz.PedoUtil;
import com.upuphone.xr.sapp.tips.TipsKey;
import com.upuphone.xr.sapp.tips.TipsKeyKt;
import com.upuphone.xr.sapp.tips.TipsManager;
import com.upuphone.xr.sapp.tips.TipsManagerKt;
import com.upuphone.xr.sapp.unicron.UnicronUpdateHelper;
import com.upuphone.xr.sapp.utils.AppUpdateHelper;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.DeviceCaptifyHelper;
import com.upuphone.xr.sapp.utils.GetRing2DeviceInfoUtils;
import com.upuphone.xr.sapp.utils.HuaWeiFeatureParser;
import com.upuphone.xr.sapp.utils.NetConfigChangeHelper;
import com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils;
import com.upuphone.xr.sapp.utils.PhoneTypeUtils;
import com.upuphone.xr.sapp.utils.SingleLiveData;
import com.upuphone.xr.sapp.utils.StarryNetHelper;
import com.upuphone.xr.sapp.utils.UserGuideHelper;
import com.upuphone.xr.sapp.view.SuperGenericWindowView;
import com.upuphone.xr.sapp.vm.SuperViewModel;
import com.upuphone.xr.sapp.vu.vm.VuGlassesBaseModel;
import com.xjmz.myvu.common.AccountVoidResult;
import com.xjmz.myvu.common.AirGlassControlResult;
import com.xjmz.myvu.common.AppApiVoidResult;
import com.xjmz.myvu.dialog.NormalTwoBtnDialog;
import com.xjmz.myvu.ext.ConnectExtKt;
import com.xjmz.myvu.ext.DeviceInfoExtKt;
import com.xjmz.myvu.flutter.AccountInfoExtKt;
import com.xjmz.myvu.flutter.base.BaseFlutterFragment;
import com.xjmz.myvu.flutter.pigeon.AndroidAccountApi;
import com.xjmz.myvu.flutter.pigeon.AndroidAirGlassControlApi;
import com.xjmz.myvu.flutter.pigeon.AndroidAppApi;
import com.xjmz.myvu.flutter.pigeon.AndroidAppUpdateApi;
import com.xjmz.myvu.flutter.pigeon.AndroidBindingDeviceApi;
import com.xjmz.myvu.flutter.pigeon.AndroidConnectApi;
import com.xjmz.myvu.permissions.PermissionAndStateHelper;
import com.xjsd.ai.assistant.flutter.AndroidAssistantApiHandler;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.BinaryMessenger;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.apache.commons.lang3.BooleanUtils;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 n2\u00020\u00012\u00020\u0002:\u0001oB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u001e\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH@¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\u0004J\u0019\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001a\u0010\u0004J\u000f\u0010\u001b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001b\u0010\u0004J\u0017\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001f\u0010\u0004J\u001b\u0010\"\u001a\u00020\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0007H\u0016¢\u0006\u0004\b$\u0010%J\u0019\u0010(\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b(\u0010)J!\u0010,\u001a\u00020\u00052\u0006\u0010+\u001a\u00020*2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0005H\u0016¢\u0006\u0004\b.\u0010\u0004J\u000f\u0010/\u001a\u00020\u0005H\u0016¢\u0006\u0004\b/\u0010\u0004J\u000f\u00100\u001a\u00020\u0005H\u0016¢\u0006\u0004\b0\u0010\u0004J\u000f\u00101\u001a\u00020\u0005H\u0016¢\u0006\u0004\b1\u0010\u0004J\u001f\u00105\u001a\u00020\u00052\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u000202H\u0016¢\u0006\u0004\b5\u00106J!\u00109\u001a\u00020\u00052\u0006\u00103\u001a\u0002022\b\u00108\u001a\u0004\u0018\u000107H\u0016¢\u0006\u0004\b9\u0010:J\r\u0010;\u001a\u00020\u0005¢\u0006\u0004\b;\u0010\u0004J)\u0010?\u001a\u00020\u00052\u0006\u0010<\u001a\u0002022\u0006\u0010=\u001a\u0002022\b\u00108\u001a\u0004\u0018\u00010>H\u0016¢\u0006\u0004\b?\u0010@J\r\u0010A\u001a\u00020\u0005¢\u0006\u0004\bA\u0010\u0004R\u001b\u0010G\u001a\u00020B8BX\u0002¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010L\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u0010IR\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u001b\u0010U\u001a\u00020Q8BX\u0002¢\u0006\f\n\u0004\bR\u0010D\u001a\u0004\bS\u0010TR\u001a\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00070V8\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u001b\u0010^\u001a\u00020Z8BX\u0002¢\u0006\f\n\u0004\b[\u0010D\u001a\u0004\b\\\u0010]R\u001b\u0010c\u001a\u00020_8BX\u0002¢\u0006\f\n\u0004\b`\u0010D\u001a\u0004\ba\u0010bR\u001b\u0010h\u001a\u00020d8BX\u0002¢\u0006\f\n\u0004\be\u0010D\u001a\u0004\bf\u0010gR\u001b\u0010m\u001a\u00020i8BX\u0002¢\u0006\f\n\u0004\bj\u0010D\u001a\u0004\bk\u0010l¨\u0006p"}, d2 = {"Lcom/xjmz/myvu/modules/home/HomeFragment;", "Lcom/xjmz/myvu/flutter/base/BaseFlutterFragment;", "Lcom/upuphone/xr/sapp/view/SuperGenericWindowView$IActionCallback;", "<init>", "()V", "", "W0", "", "deviceType", "U0", "(Ljava/lang/String;)V", "T0", "", "Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$DeviceInfo;", "devices", "", "i1", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initViewModel", "P0", "g1", "Lcom/upuphone/xr/sapp/entity/AccountInfo;", "accountInfo", "d1", "(Lcom/upuphone/xr/sapp/entity/AccountInfo;)V", "S0", "f1", "Q0", "deviceInfo", "R0", "(Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$DeviceInfo;)V", "h1", "Lcom/upuphone/xr/sapp/context/IGlassInfo;", "glassInfo", "j1", "(Lcom/upuphone/xr/sapp/context/IGlassInfo;)V", "getCachedEngineId", "()Ljava/lang/String;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onStop", "onDestroy", "onDestroyView", "", "windowType", "actionType", "a", "(II)V", "", "data", "c", "(ILjava/lang/Object;)V", "e1", "requestCode", "resultCode", "Landroid/content/Intent;", "onActivityResult", "(IILandroid/content/Intent;)V", "V0", "Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "f", "Lkotlin/Lazy;", "a1", "()Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "superViewModel", "g", "Z", "shouldNotifyNativeReady", "h", "isBizInitialized", "Lkotlinx/coroutines/Job;", "i", "Lkotlinx/coroutines/Job;", "historyDevicesJob", "Lcom/xjmz/myvu/permissions/PermissionAndStateHelper;", "j", "Z0", "()Lcom/xjmz/myvu/permissions/PermissionAndStateHelper;", "permissionAndStateHelper", "", "k", "Ljava/util/Set;", "checkedNpsDevice", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$TipsFlutterApi;", "l", "b1", "()Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$TipsFlutterApi;", "tipsApi", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAirGlassControlApi$FlutterAirGlassControlApi;", "m", "X0", "()Lcom/xjmz/myvu/flutter/pigeon/AndroidAirGlassControlApi$FlutterAirGlassControlApi;", "airGlassControlApi", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAppUpdateApi$FlutterAppUpdateApi;", "n", "Y0", "()Lcom/xjmz/myvu/flutter/pigeon/AndroidAppUpdateApi$FlutterAppUpdateApi;", "flutterAppUpdateApi", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassesBaseModel;", "o", "c1", "()Lcom/upuphone/xr/sapp/vu/vm/VuGlassesBaseModel;", "viewGlassesModel", "p", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nHomeFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HomeFragment.kt\ncom/xjmz/myvu/modules/home/HomeFragment\n+ 2 GlobalViewStoreExt.kt\ncom/upuphone/xr/sapp/common/GlobalViewStoreExtKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,704:1\n32#2,12:705\n1855#3,2:717\n1549#3:730\n1620#3,3:731\n1747#3,3:734\n1747#3,3:737\n314#4,11:719\n*S KotlinDebug\n*F\n+ 1 HomeFragment.kt\ncom/xjmz/myvu/modules/home/HomeFragment\n*L\n111#1:705,12\n323#1:717,2\n542#1:730\n542#1:731,3\n544#1:734,3\n546#1:737,3\n353#1:719,11\n*E\n"})
public final class HomeFragment extends BaseFlutterFragment implements SuperGenericWindowView.IActionCallback {
    public static final Companion p = new Companion((DefaultConstructorMarker) null);
    public static int q = 3;
    public final Lazy f;
    public boolean g;
    public boolean h;
    public Job i;
    public final Lazy j = LazyKt.lazy(new HomeFragment$permissionAndStateHelper$2(this));
    public final Set k = new LinkedHashSet();
    public final Lazy l = LazyKt.lazy(new HomeFragment$tipsApi$2(this));
    public final Lazy m = LazyKt.lazy(new HomeFragment$airGlassControlApi$2(this));
    public final Lazy n = LazyKt.lazy(new HomeFragment$flutterAppUpdateApi$2(this));
    public final Lazy o = LazyKt.lazy(new HomeFragment$viewGlassesModel$2(this));

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/xjmz/myvu/modules/home/HomeFragment$Companion;", "", "()V", "PERMISSION_BATTERY_REQUEST_CODE", "", "SYNC_HISTORY_DEVICES_RETRY_MAX", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public HomeFragment() {
        Class<SuperViewModel> cls = SuperViewModel.class;
        this.f = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls), new GlobalViewStoreExtKt$cachedViewModels$3(cls.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
    }

    /* access modifiers changed from: private */
    public final SuperViewModel a1() {
        return (SuperViewModel) this.f.getValue();
    }

    private final void initViewModel() {
        m0().M().observe(getViewLifecycleOwner(), new HomeFragment$sam$androidx_lifecycle_Observer$0(new HomeFragment$initViewModel$1(this)));
        a1().n().observe(getViewLifecycleOwner(), new HomeFragment$sam$androidx_lifecycle_Observer$0(new HomeFragment$initViewModel$2(this)));
        m0().L().observe(getViewLifecycleOwner(), new HomeFragment$sam$androidx_lifecycle_Observer$0(new HomeFragment$initViewModel$3(this)));
        m0().P().observe(getViewLifecycleOwner(), new HomeFragment$sam$androidx_lifecycle_Observer$0(new HomeFragment$initViewModel$4(this)));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new HomeFragment$initViewModel$5(this, (Continuation<? super HomeFragment$initViewModel$5>) null), 3, (Object) null);
        a1().y().observe(getViewLifecycleOwner(), new HomeFragment$sam$androidx_lifecycle_Observer$0(new HomeFragment$initViewModel$6(this)));
        a1().M0().observe(getViewLifecycleOwner(), new HomeFragment$sam$androidx_lifecycle_Observer$0(new HomeFragment$initViewModel$7(this)));
        a1().K0().observe(getViewLifecycleOwner(), new HomeFragment$sam$androidx_lifecycle_Observer$0(new HomeFragment$initViewModel$8(this)));
        MzAccountManager.c.b().d().observe(getViewLifecycleOwner(), new HomeFragment$sam$androidx_lifecycle_Observer$0(new HomeFragment$initViewModel$9(this)));
        a1().H0().observe(getViewLifecycleOwner(), new HomeFragment$sam$androidx_lifecycle_Observer$0(new HomeFragment$initViewModel$10(this)));
        a1().Z().observe(getViewLifecycleOwner(), new HomeFragment$sam$androidx_lifecycle_Observer$0(new HomeFragment$initViewModel$11(this)));
        SingleLiveData k2 = a1().k();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        k2.observe(viewLifecycleOwner2, new HomeFragment$sam$androidx_lifecycle_Observer$0(HomeFragment$initViewModel$12.INSTANCE));
        SdkContext.f6675a.e().b().observe(getViewLifecycleOwner(), new HomeFragment$sam$androidx_lifecycle_Observer$0(new HomeFragment$initViewModel$13(this)));
        AppUpdateHelper.f7841a.B().observe(getViewLifecycleOwner(), new HomeFragment$sam$androidx_lifecycle_Observer$0(new HomeFragment$initViewModel$14(this)));
    }

    public static /* synthetic */ void k1(HomeFragment homeFragment, IGlassInfo iGlassInfo, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            iGlassInfo = null;
        }
        homeFragment.j1(iGlassInfo);
    }

    public final void P0() {
        a1().G0().observe(getViewLifecycleOwner(), new HomeFragment$sam$androidx_lifecycle_Observer$0(new HomeFragment$addPrivacyAgreeObserve$1(this)));
    }

    public final void Q0() {
        if (PhoneTypeUtils.f7912a.c()) {
            PedoUtil pedoUtil = PedoUtil.f7798a;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            if (pedoUtil.d(requireContext)) {
                ULog.Delegate delegate = ULog.f6446a;
                delegate.a("HomeFragment", "checkHuaWeiSport");
                HuaWeiFeatureParser.b().f(requireActivity());
                boolean g2 = HuaWeiFeatureParser.b().g();
                boolean c = HuaWeiFeatureParser.b().c();
                if (!g2 && c) {
                    NormalTwoBtnDialog.Companion companion = NormalTwoBtnDialog.k;
                    FragmentActivity requireActivity = requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
                    String string = getString(R.string.sports_health_title);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    String string2 = getString(R.string.sports_health_tips);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    String string3 = getString(R.string.open_notification);
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    String string4 = getString(R.string.cancel);
                    Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                    NormalTwoBtnDialog.Companion.b(companion, requireActivity, string, string2, string3, string4, new HomeFragment$checkHuaWeiSport$1(this), HomeFragment$checkHuaWeiSport$2.INSTANCE, (Function0) null, false, false, 896, (Object) null);
                }
                if (HuaWeiFeatureParser.b().g()) {
                    delegate.a("HomeFragment", "checkHuaWeiSport getStepCount");
                    HuaWeiFeatureParser.b().e(requireActivity());
                }
            }
        }
    }

    public final void R0(AndroidConnectApi.DeviceInfo deviceInfo) {
        if (!this.k.contains(deviceInfo.d())) {
            Set set = this.k;
            String d = deviceInfo.d();
            Intrinsics.checkNotNullExpressionValue(d, "getModelId(...)");
            set.add(d);
            String d2 = deviceInfo.d();
            Intrinsics.checkNotNullExpressionValue(d2, "getModelId(...)");
            if (ConnectExtKt.k(d2)) {
                Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), Dispatchers.b(), (CoroutineStart) null, new HomeFragment$checkNps$1((Continuation<? super HomeFragment$checkNps$1>) null), 2, (Object) null);
                return;
            }
            String d3 = deviceInfo.d();
            Intrinsics.checkNotNullExpressionValue(d3, "getModelId(...)");
            if (ConnectExtKt.e(d3)) {
                Job unused2 = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), Dispatchers.b(), (CoroutineStart) null, new HomeFragment$checkNps$2((Continuation<? super HomeFragment$checkNps$2>) null), 2, (Object) null);
                return;
            }
            String d4 = deviceInfo.d();
            Intrinsics.checkNotNullExpressionValue(d4, "getModelId(...)");
            if (ConnectExtKt.j(d4)) {
                Job unused3 = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), Dispatchers.b(), (CoroutineStart) null, new HomeFragment$checkNps$3(this, (Continuation<? super HomeFragment$checkNps$3>) null), 2, (Object) null);
            }
        }
    }

    public final void S0() {
        Boolean bool = (Boolean) a1().n().getValue();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("HomeFragment", "checkPermissionAndState, isAndroidNaviVisible: " + bool);
        if (!Intrinsics.areEqual((Object) bool, (Object) Boolean.TRUE)) {
            List<AndroidConnectApi.DeviceInfo> b = ConnectExtKt.b();
            ArrayList<String> arrayList = new ArrayList<>(CollectionsKt.collectionSizeOrDefault(b, 10));
            for (AndroidConnectApi.DeviceInfo d : b) {
                arrayList.add(d.d());
            }
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.a("HomeFragment", "checkPermissionAndState, deviceHistory: " + arrayList);
            if (!arrayList.isEmpty()) {
                for (String str : arrayList) {
                    Intrinsics.checkNotNull(str);
                    if (ConnectExtKt.e(str)) {
                        PermissionAndStateHelper.n(Z0(), false, 1, (Object) null);
                        return;
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                for (String areEqual : arrayList) {
                    if (Intrinsics.areEqual((Object) areEqual, (Object) "view")) {
                        V0();
                        return;
                    }
                }
            }
            ULog.f6446a.a("HomeFragment", "checkPermissionAndState, unknown device");
        }
    }

    public final void T0() {
        PermissionAndStateCheckUtils permissionAndStateCheckUtils = PermissionAndStateCheckUtils.f7907a;
        String a2 = permissionAndStateCheckUtils.a(this);
        if (a2.length() == 0) {
            TipsManager.f7827a.d(TipsKey.TIPS_PERMISSION);
        }
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("HomeFragment", "checkPermissionTips " + a2);
        if (TipsKeyKt.b() && a2.length() > 0) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            PermissionDesp s = permissionAndStateCheckUtils.s(requireContext, a2);
            String string = getString(R.string.go_open);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String str = "";
            if (Intrinsics.areEqual((Object) a2, (Object) "meizu_sport_not_install")) {
                string = str;
            }
            if (!Intrinsics.areEqual((Object) a2, (Object) "meizu_sport_not_authorize") || PhoneTypeUtils.f7912a.c()) {
                str = string;
            }
            AndroidAppApi.HomeTips a3 = TipsKeyKt.a(TipsKey.TIPS_PERMISSION).d(MapsKt.mapOf(TuplesKt.to("title", s.getTitle()), TuplesKt.to("content", s.getContent()), TuplesKt.to("showBtn", String.valueOf(str.length() > 0)), TuplesKt.to("btnContent", str), TuplesKt.to("showDel", BooleanUtils.TRUE))).a();
            Intrinsics.checkNotNullExpressionValue(a3, "build(...)");
            TipsManagerKt.a(a3, new HomeFragment$checkPermissionTips$1(a2, this));
        }
    }

    public final void U0(String str) {
        String str2 = "TIPS_USER_GUIDE_" + str;
        boolean booleanValue = ((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), str2, Boolean.FALSE, (Context) null, 4, (Object) null)).booleanValue();
        boolean b = DeviceCaptifyHelper.f7877a.b();
        TipsManager tipsManager = TipsManager.f7827a;
        TipsKey tipsKey = TipsKey.TIPS_USER_GUIDE;
        tipsManager.d(tipsKey);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("HomeFragment", "checkUserGuide deviceType:" + str + " guideClick:" + booleanValue + " isCaptify:" + b);
        if (b) {
            delegate.g("HomeFragment", "Air Intl Captify UserGuide Not Support");
        } else if (!booleanValue && !ConnectExtKt.g(str) && !ConnectExtKt.k(str)) {
            AndroidAppApi.HomeTips a2 = TipsKeyKt.a(tipsKey).d(MapsKt.mapOf(TuplesKt.to("title", UserGuideHelper.f7928a.d(str)), TuplesKt.to("showBtn", BooleanUtils.TRUE), TuplesKt.to("btnContent", getString(R.string.lookup_startegy)), TuplesKt.to("showDel", BooleanUtils.FALSE))).a();
            Intrinsics.checkNotNullExpressionValue(a2, "build(...)");
            TipsManagerKt.a(a2, new HomeFragment$checkUserGuide$1(str2, this, str));
        }
    }

    public final void V0() {
        Z0().p();
    }

    public final void W0() {
        AndroidAssistantApiHandler.INSTANCE.bindFlutterApi(i0());
        TipsManager.f7827a.g(b1());
        e1();
        k1(this, (IGlassInfo) null, 1, (Object) null);
        NetConfigChangeHelper.f7897a.a(h0());
        GetRing2DeviceInfoUtils.f7887a.b(v0());
    }

    public final AndroidAirGlassControlApi.FlutterAirGlassControlApi X0() {
        return (AndroidAirGlassControlApi.FlutterAirGlassControlApi) this.m.getValue();
    }

    public final AndroidAppUpdateApi.FlutterAppUpdateApi Y0() {
        return (AndroidAppUpdateApi.FlutterAppUpdateApi) this.n.getValue();
    }

    public final PermissionAndStateHelper Z0() {
        return (PermissionAndStateHelper) this.j.getValue();
    }

    public void a(int i2, int i3) {
        c1().a(i2, i3);
    }

    public final AndroidAppApi.TipsFlutterApi b1() {
        return (AndroidAppApi.TipsFlutterApi) this.l.getValue();
    }

    public void c(int i2, Object obj) {
        c1().c(i2, obj);
    }

    public final VuGlassesBaseModel c1() {
        return (VuGlassesBaseModel) this.o.getValue();
    }

    public final void d1(AccountInfo accountInfo) {
        if (accountInfo != null) {
            g0().d(AccountInfoExtKt.a(accountInfo), new AccountVoidResult());
        } else {
            g0().d((AndroidAccountApi.Account) null, new AccountVoidResult());
        }
    }

    public final void e1() {
        Job job = this.i;
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        this.i = null;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("HomeFragment", "notifyHistoryDevices() " + true);
        List<AndroidConnectApi.DeviceInfo> b = ConnectExtKt.b();
        for (AndroidConnectApi.DeviceInfo a2 : b) {
            ULog.Delegate delegate2 = ULog.f6446a;
            String a3 = DeviceInfoExtKt.a(a2);
            delegate2.g("HomeFragment", "notifyHistoryDevices() called: " + a3);
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        this.i = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new HomeFragment$notifyHistoryDevices$2(this, b, (Continuation<? super HomeFragment$notifyHistoryDevices$2>) null), 3, (Object) null);
    }

    public final void f1() {
        ULog.Delegate delegate = ULog.f6446a;
        boolean z = this.h;
        delegate.a("HomeFragment", "onPermissionAndStateEnd, isBizInitialized: " + z);
        if (!this.h) {
            this.h = true;
            StarryNetHelper.f7917a.f();
            GlassUpdateHelper.b.h1();
            UnicronUpdateHelper.b.O();
            SuperNotificationManager.f7749a.y();
            Q0();
            T0();
        }
    }

    public final void g1() {
        a1().G0().removeObservers(getViewLifecycleOwner());
    }

    public String getCachedEngineId() {
        return "main_engine";
    }

    public final void h1() {
        if (getFlutterEngine() == null) {
            ULog.f6446a.a("HomeFragment", "requestRingNpsExist->  getFlutterEngine object is null.");
            return;
        }
        FlutterEngine flutterEngine = getFlutterEngine();
        DartExecutor dartExecutor = flutterEngine != null ? flutterEngine.getDartExecutor() : null;
        if (dartExecutor == null) {
            ULog.f6446a.a("HomeFragment", "requestRingNpsExist->  dartExecutor object is null.");
            return;
        }
        BinaryMessenger binaryMessenger = dartExecutor.getBinaryMessenger();
        Intrinsics.checkNotNullExpressionValue(binaryMessenger, "getBinaryMessenger(...)");
        ULog.f6446a.a("HomeFragment", "requestRingNpsExist-> Enter:");
        new AndroidBindingDeviceApi.FlutterRing2ConnectApi(binaryMessenger).c(new HomeFragment$requestRingNpsExist$1(this));
    }

    public final Object i1(List list, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.x();
        ULog.f6446a.g("HomeFragment", "notifyHistoryDevices() sendHistory");
        k0().j(list, new HomeFragment$sendHistory$2$1(cancellableContinuationImpl));
        Object u = cancellableContinuationImpl.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u;
    }

    public final void j1(IGlassInfo iGlassInfo) {
        SdkContext sdkContext = SdkContext.f6675a;
        IGlassInfo a2 = sdkContext.e().a();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("HomeFragment", "setupTici, glassInfo: " + iGlassInfo + ", glassInfoOrCache: " + a2);
        boolean isAirPro = sdkContext.e().isAirPro();
        StringBuilder sb = new StringBuilder();
        sb.append("setupTici, isAirPro: ");
        sb.append(isAirPro);
        delegate.g("HomeFragment", sb.toString());
        boolean z = true;
        if (!isAirPro && (a2 == null || GlassInfoExtKt.j(GlassInfoExtKt.c(GlassInfoExtKt.d(a2.getRomVersion())), GlassInfoExtKt.c(GlassInfoExtKt.d("Flyme AR 1.0.1.45.20231222_Air_FR"))) < 0)) {
            z = false;
        }
        delegate.g("HomeFragment", "setupTici, enableTici: " + z);
        X0().d(Boolean.valueOf(z), new AirGlassControlResult());
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("HomeFragment", "requestCode:" + i2 + ",resultCode:" + i3 + ",data:" + intent);
        if (i2 == 101) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new HomeFragment$onActivityResult$1(this, (Continuation<? super HomeFragment$onActivityResult$1>) null), 3, (Object) null);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ULog.f6446a.a("HomeFragment", "onCreate-> ");
        this.g = true;
        getLifecycle().a(new HomeFragment$onCreate$1(this));
        c1().onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
        c1().onDestroy();
    }

    public void onDestroyView() {
        super.onDestroyView();
        g1();
    }

    public void onResume() {
        super.onResume();
        c1().onResume();
    }

    public void onStop() {
        super.onStop();
        c1().onStop();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("HomeFragment", "onViewCreated()");
        initViewModel();
        P0();
        W0();
        if (this.g) {
            delegate.a("HomeFragment", "onViewCreated-> onChannelReady");
            this.g = false;
            h0().g(new AppApiVoidResult());
        }
        c1().b();
    }
}
