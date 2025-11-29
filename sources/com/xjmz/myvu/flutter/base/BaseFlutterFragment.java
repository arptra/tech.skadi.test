package com.xjmz.myvu.flutter.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$3;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$4;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$5;
import com.upuphone.xr.sapp.databinding.FlutterAllScreenLayoutBinding;
import com.upuphone.xr.sapp.vm.DeviceControlModel;
import com.xjmz.myvu.flutter.pigeon.AndroidAccountApi;
import com.xjmz.myvu.flutter.pigeon.AndroidAirGlassControlApi;
import com.xjmz.myvu.flutter.pigeon.AndroidAirGlassOtaApi;
import com.xjmz.myvu.flutter.pigeon.AndroidAppApi;
import com.xjmz.myvu.flutter.pigeon.AndroidAppUpdateApi;
import com.xjmz.myvu.flutter.pigeon.AndroidApplicationApi;
import com.xjmz.myvu.flutter.pigeon.AndroidBindingDeviceApi;
import com.xjmz.myvu.flutter.pigeon.AndroidConnectApi;
import com.xjmz.myvu.flutter.pigeon.AndroidDataTrackApi;
import com.xjmz.myvu.flutter.pigeon.AndroidIntentApi;
import com.xjmz.myvu.flutter.pigeon.AndroidLocationApi;
import com.xjmz.myvu.flutter.pigeon.AndroidLogApi;
import com.xjmz.myvu.flutter.pigeon.AndroidNavigatorRouteApi;
import com.xjmz.myvu.flutter.pigeon.AndroidPermissionApi;
import com.xjmz.myvu.flutter.pigeon.AndroidRing2MessageApi;
import com.xjmz.myvu.flutter.pigeon.AndroidRingStarryNetApi;
import com.xjmz.myvu.flutter.pigeon.AndroidSystemPropertyApi;
import com.xjmz.myvu.flutter.pigeon.AndroidViewGlassControlApi;
import com.xjmz.myvu.flutter.pigeon.impl.AccountApiHandler;
import com.xjmz.myvu.flutter.pigeon.impl.AirGlassControlApiHandler;
import com.xjmz.myvu.flutter.pigeon.impl.AirGlassOtaApiImpl;
import com.xjmz.myvu.flutter.pigeon.impl.AndroidAppUpdateApiImpl;
import com.xjmz.myvu.flutter.pigeon.impl.AndroidApplicationApiHandler;
import com.xjmz.myvu.flutter.pigeon.impl.AndroidLogApiHandler;
import com.xjmz.myvu.flutter.pigeon.impl.BindingDeviceApiHandler;
import com.xjmz.myvu.flutter.pigeon.impl.ConnectApiHandler;
import com.xjmz.myvu.flutter.pigeon.impl.DataTrackApiHandler;
import com.xjmz.myvu.flutter.pigeon.impl.FragmentAppApiHandler;
import com.xjmz.myvu.flutter.pigeon.impl.GlassSettingApiHandler;
import com.xjmz.myvu.flutter.pigeon.impl.IntentApiHandler;
import com.xjmz.myvu.flutter.pigeon.impl.LocationApiHandler;
import com.xjmz.myvu.flutter.pigeon.impl.NavigatorRouteApiImpl;
import com.xjmz.myvu.flutter.pigeon.impl.PermissionApiHandler;
import com.xjmz.myvu.flutter.pigeon.impl.Ring2MessageApiHandler;
import com.xjmz.myvu.flutter.pigeon.impl.RouteGuardApiHandler;
import com.xjmz.myvu.flutter.pigeon.impl.StarryNetApiHandler;
import com.xjmz.myvu.flutter.pigeon.impl.SystemPropertyApiHandler;
import com.xjmz.myvu.flutter.pigeon.impl.TipsApiHandler;
import com.xjmz.myvu.flutter.pigeon.impl.ViewGlassControlApiHandler;
import com.xjmz.myvu.modules.home.SearchGlassHandler;
import com.xjsd.ai.assistant.flutter.AndroidAssistantApi;
import com.xjsd.ai.assistant.flutter.AndroidAssistantApiHandler;
import io.flutter.embedding.android.FlutterEngineConfigurator;
import io.flutter.embedding.android.FlutterEngineProvider;
import io.flutter.embedding.android.FlutterFragment;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.BinaryMessenger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 d2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\bJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\fJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J+\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H\u0014¢\u0006\u0004\b\"\u0010#J/\u0010*\u001a\u00020\u00142\u0006\u0010%\u001a\u00020$2\u000e\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0&2\u0006\u0010)\u001a\u00020(H\u0017¢\u0006\u0004\b*\u0010+J)\u0010/\u001a\u00020\u00142\u0006\u0010%\u001a\u00020$2\u0006\u0010,\u001a\u00020$2\b\u0010.\u001a\u0004\u0018\u00010-H\u0017¢\u0006\u0004\b/\u00100J\r\u00102\u001a\u000201¢\u0006\u0004\b2\u00103J\r\u00105\u001a\u000204¢\u0006\u0004\b5\u00106J\r\u00108\u001a\u000207¢\u0006\u0004\b8\u00109J\r\u0010;\u001a\u00020:¢\u0006\u0004\b;\u0010<J\r\u0010>\u001a\u00020=¢\u0006\u0004\b>\u0010?J\r\u0010A\u001a\u00020@¢\u0006\u0004\bA\u0010BJ\r\u0010D\u001a\u00020C¢\u0006\u0004\bD\u0010EJ\u0017\u0010G\u001a\u00020\u00142\u0006\u0010F\u001a\u00020\u001cH\u0016¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\u0014H\u0016¢\u0006\u0004\bI\u0010\u0005J\u0015\u0010L\u001a\u00020\u00142\u0006\u0010K\u001a\u00020J¢\u0006\u0004\bL\u0010MJ\u001f\u0010P\u001a\u00020\u00142\u0006\u0010N\u001a\u00020$2\u0006\u0010O\u001a\u00020\nH\u0002¢\u0006\u0004\bP\u0010QR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010X\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u001b\u0010^\u001a\u00020Y8DX\u0002¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]R\u001b\u0010c\u001a\u00020_8DX\u0002¢\u0006\f\n\u0004\b`\u0010[\u001a\u0004\ba\u0010b¨\u0006f"}, d2 = {"Lcom/xjmz/myvu/flutter/base/BaseFlutterFragment;", "Landroidx/fragment/app/Fragment;", "Lio/flutter/embedding/android/FlutterEngineProvider;", "Lio/flutter/embedding/android/FlutterEngineConfigurator;", "<init>", "()V", "Lio/flutter/embedding/engine/FlutterEngine;", "s0", "()Lio/flutter/embedding/engine/FlutterEngine;", "getFlutterEngine", "", "getCachedEngineId", "()Ljava/lang/String;", "getCachedEngineGroupId", "getInitialRoute", "Landroid/content/Context;", "context", "provideFlutterEngine", "(Landroid/content/Context;)Lio/flutter/embedding/engine/FlutterEngine;", "flutterEngine", "", "configureFlutterEngine", "(Lio/flutter/embedding/engine/FlutterEngine;)V", "cleanUpFlutterEngine", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lio/flutter/embedding/android/FlutterFragment;", "j0", "()Lio/flutter/embedding/android/FlutterFragment;", "", "requestCode", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$FlutterAppApi;", "h0", "()Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$FlutterAppApi;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$FlutterConnectApi;", "k0", "()Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$FlutterConnectApi;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAccountApi$FlutterAccountApi;", "g0", "()Lcom/xjmz/myvu/flutter/pigeon/AndroidAccountApi$FlutterAccountApi;", "Lcom/xjsd/ai/assistant/flutter/AndroidAssistantApi$AssistantFlutterApi;", "i0", "()Lcom/xjsd/ai/assistant/flutter/AndroidAssistantApi$AssistantFlutterApi;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$FlutterRing1ConnectApi;", "u0", "()Lcom/xjmz/myvu/flutter/pigeon/AndroidConnectApi$FlutterRing1ConnectApi;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$FlutterGlassSettingApi;", "o0", "()Lcom/xjmz/myvu/flutter/pigeon/AndroidAppApi$FlutterGlassSettingApi;", "Lcom/xjmz/myvu/flutter/pigeon/AndroidBindingDeviceApi$FlutterRing2ConnectApi;", "v0", "()Lcom/xjmz/myvu/flutter/pigeon/AndroidBindingDeviceApi$FlutterRing2ConnectApi;", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "onDestroy", "", "isEnabled", "l0", "(Z)V", "layoutId", "fragmentTag", "w0", "(ILjava/lang/String;)V", "Lcom/upuphone/xr/sapp/databinding/FlutterAllScreenLayoutBinding;", "a", "Lcom/upuphone/xr/sapp/databinding/FlutterAllScreenLayoutBinding;", "layout", "b", "Lio/flutter/embedding/android/FlutterFragment;", "flutterFragment", "Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "c", "Lkotlin/Lazy;", "m0", "()Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "deviceControlModel", "Lcom/xjmz/myvu/modules/home/SearchGlassHandler;", "d", "n0", "()Lcom/xjmz/myvu/modules/home/SearchGlassHandler;", "searchGlassTimeoutHandler", "e", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nBaseFlutterFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseFlutterFragment.kt\ncom/xjmz/myvu/flutter/base/BaseFlutterFragment\n+ 2 GlobalViewStoreExt.kt\ncom/upuphone/xr/sapp/common/GlobalViewStoreExtKt\n*L\n1#1,260:1\n32#2,12:261\n*S KotlinDebug\n*F\n+ 1 BaseFlutterFragment.kt\ncom/xjmz/myvu/flutter/base/BaseFlutterFragment\n*L\n73#1:261,12\n*E\n"})
public abstract class BaseFlutterFragment extends Fragment implements FlutterEngineProvider, FlutterEngineConfigurator {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public FlutterAllScreenLayoutBinding f8246a;
    public FlutterFragment b;
    public final Lazy c;
    public final Lazy d = LazyKt.lazy(new BaseFlutterFragment$searchGlassTimeoutHandler$2(this));

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjmz/myvu/flutter/base/BaseFlutterFragment$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public BaseFlutterFragment() {
        Class<DeviceControlModel> cls = DeviceControlModel.class;
        this.c = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls), new GlobalViewStoreExtKt$cachedViewModels$3(cls.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
    }

    public void cleanUpFlutterEngine(FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("BaseFlutterFragment", "cleanUpFlutterEngine: " + flutterEngine);
        this.b = null;
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("BaseFlutterFragment", "configureFlutterEngine: " + flutterEngine);
        BinaryMessenger binaryMessenger = flutterEngine.getDartExecutor().getBinaryMessenger();
        Intrinsics.checkNotNullExpressionValue(binaryMessenger, "getBinaryMessenger(...)");
        AndroidLogApi.LogApi.m(binaryMessenger, new AndroidLogApiHandler());
        AndroidAppApi.AppApi.e(binaryMessenger, new FragmentAppApiHandler(this, m0()));
        AndroidConnectApi.ConnectApi.s(binaryMessenger, new ConnectApiHandler(m0(), k0(), n0(), new BaseFlutterFragment$configureFlutterEngine$1(this)));
        AndroidAccountApi.AccountApi.b(binaryMessenger, new AccountApiHandler(this));
        AndroidAssistantApi.AssistantHostApi.v(binaryMessenger, AndroidAssistantApiHandler.INSTANCE);
        AndroidBindingDeviceApi.BindingDeviceApi.a(binaryMessenger, new BindingDeviceApiHandler());
        AndroidAirGlassControlApi.AirGlassControlApi.h(binaryMessenger, AirGlassControlApiHandler.f8339a);
        AndroidViewGlassControlApi.ViewGlassControlApi.c(binaryMessenger, ViewGlassControlApiHandler.f8360a);
        AndroidPermissionApi.PermissionApi.b(binaryMessenger, new PermissionApiHandler());
        AndroidDataTrackApi.DataTrackApi.e(binaryMessenger, new DataTrackApiHandler());
        AndroidAppApi.TipsApi.e(binaryMessenger, new TipsApiHandler());
        AndroidAppApi.GlassSettingApi.e(binaryMessenger, new GlassSettingApiHandler());
        AndroidAppApi.RouteGuardApi.d(binaryMessenger, new RouteGuardApiHandler(this));
        AndroidRingStarryNetApi.StarryNetApi.r(binaryMessenger, new StarryNetApiHandler(this));
        AndroidRing2MessageApi.Ring2MessageSendApi.a(binaryMessenger, new Ring2MessageApiHandler(this));
        AndroidAirGlassOtaApi.AirGlassOtaApi.a(binaryMessenger, AirGlassOtaApiImpl.f8340a);
        AndroidNavigatorRouteApi.NavigatorRouteApi.b(binaryMessenger, NavigatorRouteApiImpl.f8350a);
        AndroidLocationApi.LocationApi.g(binaryMessenger, new LocationApiHandler(this));
        AndroidAppUpdateApi.AppUpdateApi.e(binaryMessenger, AndroidAppUpdateApiImpl.f8341a);
        AndroidApplicationApi.ApplicationApi.e(binaryMessenger, new AndroidApplicationApiHandler());
        AndroidSystemPropertyApi.SystemPropertyApi.c(binaryMessenger, new SystemPropertyApiHandler());
        AndroidIntentApi.IntentApi.c(binaryMessenger, new IntentApiHandler());
    }

    public final AndroidAccountApi.FlutterAccountApi g0() {
        return new AndroidAccountApi.FlutterAccountApi(s0().getDartExecutor().getBinaryMessenger());
    }

    public String getCachedEngineGroupId() {
        return "flutter_engine_group_home";
    }

    public String getCachedEngineId() {
        return null;
    }

    public final FlutterEngine getFlutterEngine() {
        FlutterFragment flutterFragment = this.b;
        if (flutterFragment != null) {
            return flutterFragment.getFlutterEngine();
        }
        return null;
    }

    public String getInitialRoute() {
        return null;
    }

    public final AndroidAppApi.FlutterAppApi h0() {
        return new AndroidAppApi.FlutterAppApi(s0().getDartExecutor().getBinaryMessenger());
    }

    public final AndroidAssistantApi.AssistantFlutterApi i0() {
        return new AndroidAssistantApi.AssistantFlutterApi(s0().getDartExecutor().getBinaryMessenger());
    }

    public FlutterFragment j0() {
        String cachedEngineId = getCachedEngineId();
        SimpleFlutterFragment a2 = cachedEngineId != null ? SimpleFlutterFragment.d.a(cachedEngineId) : SimpleFlutterFragment.d.b(getCachedEngineGroupId(), getInitialRoute());
        a2.i0(this);
        a2.h0(this);
        return a2;
    }

    public final AndroidConnectApi.FlutterConnectApi k0() {
        return new AndroidConnectApi.FlutterConnectApi(s0().getDartExecutor().getBinaryMessenger());
    }

    public final void l0(boolean z) {
        FlutterFragment flutterFragment = this.b;
        SimpleFlutterFragment simpleFlutterFragment = flutterFragment instanceof SimpleFlutterFragment ? (SimpleFlutterFragment) flutterFragment : null;
        if (simpleFlutterFragment != null) {
            simpleFlutterFragment.g0(z);
        }
    }

    public final DeviceControlModel m0() {
        return (DeviceControlModel) this.c.getValue();
    }

    public final SearchGlassHandler n0() {
        return (SearchGlassHandler) this.d.getValue();
    }

    public final AndroidAppApi.FlutterGlassSettingApi o0() {
        return new AndroidAppApi.FlutterGlassSettingApi(s0().getDartExecutor().getBinaryMessenger());
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        FlutterFragment flutterFragment = this.b;
        if (flutterFragment != null) {
            flutterFragment.onActivityResult(i, i2, intent);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ULog.f6446a.a("BaseFlutterFragment", "onCreateView");
        FlutterAllScreenLayoutBinding c2 = FlutterAllScreenLayoutBinding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
        this.f8246a = c2;
        FlutterAllScreenLayoutBinding flutterAllScreenLayoutBinding = null;
        if (c2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layout");
            c2 = null;
        }
        w0(c2.getRoot().getId(), getClass() + AccountConstantKt.DEFAULT_SEGMENT + getCachedEngineId());
        FlutterAllScreenLayoutBinding flutterAllScreenLayoutBinding2 = this.f8246a;
        if (flutterAllScreenLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layout");
        } else {
            flutterAllScreenLayoutBinding = flutterAllScreenLayoutBinding2;
        }
        FrameLayout b2 = flutterAllScreenLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
        return b2;
    }

    public void onDestroy() {
        super.onDestroy();
        n0().a();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        FlutterFragment flutterFragment = this.b;
        if (flutterFragment != null) {
            flutterFragment.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        ULog.f6446a.a("BaseFlutterFragment", "onSaveInstanceState");
    }

    public FlutterEngine provideFlutterEngine(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ULog.f6446a.a("BaseFlutterFragment", "provideFlutterEngine");
        return null;
    }

    public final FlutterEngine s0() {
        FlutterEngine flutterEngine;
        String cachedEngineId = getCachedEngineId();
        if (cachedEngineId == null || (flutterEngine = MainApplication.k.e().d(cachedEngineId)) == null) {
            FlutterFragment flutterFragment = this.b;
            flutterEngine = flutterFragment != null ? flutterFragment.getFlutterEngine() : null;
            Intrinsics.checkNotNull(flutterEngine);
        }
        return flutterEngine;
    }

    public final AndroidConnectApi.FlutterRing1ConnectApi u0() {
        return new AndroidConnectApi.FlutterRing1ConnectApi(s0().getDartExecutor().getBinaryMessenger());
    }

    public final AndroidBindingDeviceApi.FlutterRing2ConnectApi v0() {
        return new AndroidBindingDeviceApi.FlutterRing2ConnectApi(s0().getDartExecutor().getBinaryMessenger());
    }

    public final void w0(int i, String str) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        FlutterFragment flutterFragment = (FlutterFragment) childFragmentManager.p0(str);
        this.b = flutterFragment;
        if (flutterFragment == null) {
            ULog.f6446a.a("BaseFlutterFragment", "showFlutterFragment, flutterFragment is null");
            FlutterFragment j0 = j0();
            this.b = j0;
            childFragmentManager.s().u(i, j0, str).l();
            return;
        }
        ULog.f6446a.a("BaseFlutterFragment", "showFlutterFragment, flutterFragment is not null");
    }
}
