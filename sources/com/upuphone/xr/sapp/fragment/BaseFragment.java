package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.alibaba.fastjson.asm.Opcodes;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynet.strategy.discovery.advertiser.pack.AdvPackConstants;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$3;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$4;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$5;
import com.upuphone.xr.sapp.common.MzAccountManager;
import com.upuphone.xr.sapp.permission.PermissionHelper;
import com.upuphone.xr.sapp.utils.AccountExt;
import com.upuphone.xr.sapp.utils.ControlUtils;
import com.upuphone.xr.sapp.utils.DynamicAdapterUtils;
import com.upuphone.xr.sapp.utils.IMultiplePermissionResult;
import com.upuphone.xr.sapp.utils.IPermissionResult;
import com.upuphone.xr.sapp.utils.ModelIdExtKt;
import com.upuphone.xr.sapp.utils.OSHelper;
import com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.view.SuperGenericWindowView;
import com.upuphone.xr.sapp.vm.SuperViewModel;
import com.upuphone.xr.sapp.vm.internal.SuperMessageManger;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0016\u0018\u0000 S2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001TB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u0006J\u0019\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u0006J\r\u0010\u001b\u001a\u00020\u000e¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u000e¢\u0006\u0004\b\u001d\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001e\u0010\u0006J\u000f\u0010\u001f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001f\u0010\u0006J\r\u0010 \u001a\u00020\u000e¢\u0006\u0004\b \u0010\u001cJ\u001f\u0010#\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\tH\u0017¢\u0006\u0004\b#\u0010$J!\u0010'\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u0007¢\u0006\u0004\b)\u0010\u0006J\u0017\u0010+\u001a\u00020\u00072\b\b\u0002\u0010*\u001a\u00020\u000e¢\u0006\u0004\b+\u0010\u0011J/\u00101\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020-2\u0006\u00100\u001a\u00020-H\u0017¢\u0006\u0004\b1\u00102J7\u00105\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020-2\u000e\u00104\u001a\n\u0012\u0004\u0012\u00020-\u0018\u0001032\u0006\u00100\u001a\u00020-H\u0017¢\u0006\u0004\b5\u00106J\r\u00107\u001a\u00020\u000e¢\u0006\u0004\b7\u0010\u001cJ\r\u00109\u001a\u000208¢\u0006\u0004\b9\u0010:J%\u0010;\u001a\u00020\u00072\f\u00104\u001a\b\u0012\u0004\u0012\u00020-032\u0006\u00100\u001a\u00020-H\u0007¢\u0006\u0004\b;\u0010<R\u001b\u0010A\u001a\u00020=8BX\u0002¢\u0006\f\n\u0004\b#\u0010>\u001a\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010E\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010CR\u0016\u0010G\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010CR\"\u0010K\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bH\u0010C\u001a\u0004\bI\u0010\u001c\"\u0004\bJ\u0010\u0011R\"\u0010O\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bL\u0010C\u001a\u0004\bM\u0010\u001c\"\u0004\bN\u0010\u0011R\"\u0010Q\u001a\u00020\u000e8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\bP\u0010C\u001a\u0004\bQ\u0010\u001c\"\u0004\bR\u0010\u0011¨\u0006U"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/upuphone/xr/sapp/view/SuperGenericWindowView$IActionCallback;", "Lcom/upuphone/xr/sapp/utils/IPermissionResult;", "Lcom/upuphone/xr/sapp/utils/IMultiplePermissionResult;", "<init>", "()V", "", "z0", "", "step", "i0", "(I)V", "s0", "", "fullScreen", "l0", "(Z)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "h0", "()Z", "g0", "onPause", "onDestroy", "u0", "windowType", "actionType", "a", "(II)V", "", "data", "c", "(ILjava/lang/Object;)V", "k0", "check", "j0", "result", "", "reason", "permission", "tag", "w0", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "permissions", "y0", "(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V", "o0", "Landroid/content/Context;", "m0", "()Landroid/content/Context;", "v0", "([Ljava/lang/String;Ljava/lang/String;)V", "Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "Lkotlin/Lazy;", "n0", "()Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "viewModel", "b", "Z", "existPermissionView", "checkPwd", "d", "fragmentFullScreen", "e", "getNeedLoginDialog", "setNeedLoginDialog", "needLoginDialog", "f", "getCheckPermissions", "setCheckPermissions", "checkPermissions", "g", "isViewGlasses", "setViewGlasses", "h", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nBaseFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseFragment.kt\ncom/upuphone/xr/sapp/fragment/BaseFragment\n+ 2 GlobalViewStoreExt.kt\ncom/upuphone/xr/sapp/common/GlobalViewStoreExtKt\n*L\n1#1,429:1\n32#2,12:430\n*S KotlinDebug\n*F\n+ 1 BaseFragment.kt\ncom/upuphone/xr/sapp/fragment/BaseFragment\n*L\n64#1:430,12\n*E\n"})
public class BaseFragment extends Fragment implements SuperGenericWindowView.IActionCallback, IPermissionResult, IMultiplePermissionResult {
    public static final Companion h = new Companion((DefaultConstructorMarker) null);
    public static boolean i = true;

    /* renamed from: a  reason: collision with root package name */
    public final Lazy f6945a;
    public boolean b;
    public boolean c = true;
    public boolean d;
    public boolean e = true;
    public boolean f = true;
    public boolean g;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/BaseFragment$Companion;", "", "<init>", "()V", "", "CHECK_BT_PERMISSION", "I", "CHECK_BT_SWITCH", "CHECK_LOCATION_PERMISSION", "CHECK_LOCATION_SWITCH", "", "KEY_IS_VIEW_GLASSES", "Ljava/lang/String;", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public BaseFragment() {
        Class<SuperViewModel> cls = SuperViewModel.class;
        this.f6945a = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls), new GlobalViewStoreExtKt$cachedViewModels$3(cls.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
    }

    private final SuperViewModel n0() {
        return (SuperViewModel) this.f6945a.getValue();
    }

    private final void z0() {
        if (ModelIdExtKt.a(DynamicAdapterUtils.f7879a.a())) {
            boolean e2 = ControlUtils.f7858a.e();
            long currentTimeMillis = System.currentTimeMillis();
            SuperMessageManger.Companion companion = SuperMessageManger.m;
            Long x = companion.a().x();
            long longValue = x != null ? x.longValue() : 0;
            Long y = companion.a().y();
            long longValue2 = y != null ? y.longValue() : 0;
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("BaseFragment", "currentTimeMillis is: " + currentTimeMillis + " and sunrise is: " + longValue + " and sunset is: " + longValue2);
            if (e2 && longValue != 0 && longValue2 != 0) {
                if (longValue > currentTimeMillis || currentTimeMillis >= longValue2) {
                    companion.a().s0("sunset");
                } else {
                    companion.a().s0("sunrise");
                }
            }
        }
    }

    public void a(int i2, int i3) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("BaseFragment", "windowType: " + i2 + ", actionType: " + i3);
        if (i2 == 102) {
            this.b = false;
            if (i3 == 1101) {
                startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
            } else if (i3 == 1102) {
                n0().D0().put("location_switch", Boolean.TRUE);
                Boolean bool = BuildConfig.b;
                Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
                if (bool.booleanValue()) {
                    i0(2);
                } else {
                    i0(3);
                }
            }
        } else if (i2 == 110) {
            this.b = false;
            if (i3 == 1101) {
                startActivity(new Intent("android.settings.BLUETOOTH_SETTINGS"));
            } else if (i3 == 1102) {
                n0().D0().put("bluetooth_switch", Boolean.TRUE);
                Boolean bool2 = BuildConfig.b;
                Intrinsics.checkNotNullExpressionValue(bool2, "THIRD_PLATFOM");
                if (bool2.booleanValue()) {
                    i0(4);
                } else {
                    s0();
                }
            }
        } else if (i2 != 168) {
            switch (i2) {
                case AdvPackConstants.ADV_MODE_ACTIVE_NO_WINDOW:
                    this.b = false;
                    if (i3 == 1101) {
                        StaticMethodUtilsKt.p(this);
                        return;
                    } else if (i3 == 1102) {
                        n0().D0().put("location_permission", Boolean.TRUE);
                        i0(3);
                        return;
                    } else {
                        return;
                    }
                case 145:
                    this.b = false;
                    if (i3 == 1101) {
                        StaticMethodUtilsKt.p(this);
                        return;
                    } else if (i3 == 1102) {
                        n0().D0().put("location_permission", Boolean.TRUE);
                        i0(3);
                        return;
                    } else {
                        return;
                    }
                case 146:
                    this.b = false;
                    if (i3 == 1101) {
                        StaticMethodUtilsKt.p(this);
                        return;
                    } else if (i3 == 1102) {
                        n0().D0().put("location_permission", Boolean.TRUE);
                        i0(3);
                        return;
                    } else {
                        return;
                    }
                case 147:
                    this.b = false;
                    if (i3 == 1101) {
                        StaticMethodUtilsKt.p(this);
                        return;
                    } else if (i3 == 1102) {
                        n0().D0().put("bluetooth_permission", Boolean.TRUE);
                        return;
                    } else {
                        return;
                    }
                default:
                    switch (i2) {
                        case Opcodes.IF_ICMPGE:
                            this.b = false;
                            if (i3 == 1101) {
                                StaticMethodUtilsKt.p(this);
                                return;
                            } else if (i3 == 1102) {
                                n0().D0().put("location_permission", Boolean.TRUE);
                                i0(3);
                                return;
                            } else {
                                return;
                            }
                        case Opcodes.IF_ICMPGT:
                            this.b = false;
                            if (i3 == 1101) {
                                StaticMethodUtilsKt.p(this);
                                return;
                            } else if (i3 == 1102) {
                                n0().D0().put("location_permission", Boolean.TRUE);
                                i0(3);
                                return;
                            } else {
                                return;
                            }
                        case 164:
                            this.b = false;
                            if (i3 == 1101) {
                                StaticMethodUtilsKt.p(this);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
            }
        } else {
            this.b = false;
            if (i3 == 1101) {
                StaticMethodUtilsKt.p(this);
            }
        }
    }

    public void c(int i2, Object obj) {
    }

    public final boolean g0() {
        return StaticMethodUtilsKt.a(this, PermissionAndStateCheckUtils.f7907a.z());
    }

    public final boolean h0() {
        return StaticMethodUtilsKt.a(this, PermissionAndStateCheckUtils.f7907a.A());
    }

    public final void i0(int i2) {
        ULog.Delegate delegate = ULog.f6446a;
        boolean z = i;
        delegate.g("BaseFragment", "permissionCheck:" + z);
        if (!i) {
            delegate.g("BaseFragment", "permissionCheck: ignore");
        } else if (this.b) {
            delegate.g("BaseFragment", "isRequestPermission: true");
        } else {
            s0();
        }
    }

    public final void j0(boolean z) {
        i = z;
    }

    public final void k0() {
        this.d = true;
    }

    public final void l0(boolean z) {
        if (this.d) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("BaseFragment", "enter full screen = " + z);
        }
    }

    public final Context m0() {
        try {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            return requireContext;
        } catch (Exception e2) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e2.getMessage();
            delegate.a("GlassManagerFragment", "getBaseContext::error is: " + message);
            Context baseContext = MainApplication.k.f().getBaseContext();
            Intrinsics.checkNotNullExpressionValue(baseContext, "getBaseContext(...)");
            return baseContext;
        }
    }

    public final boolean o0() {
        return OSHelper.f7904a.d();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        boolean z = false;
        if (arguments != null) {
            z = arguments.getBoolean("is_view_glasses", false);
        }
        this.g = z;
    }

    public void onDestroy() {
        super.onDestroy();
        ULog.f6446a.g("BaseFragment", "onDestroy BaseFragment");
    }

    public void onPause() {
        super.onPause();
        l0(false);
    }

    public void onResume() {
        super.onResume();
        ULog.f6446a.g("BaseFragment", "onresume BaseFragment");
        z0();
        l0(true);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        view.setBackgroundColor(requireContext().getColor(R.color.device_connect_background));
    }

    public final void s0() {
        ULog.f6446a.g("BaseFragment", "launchNonMustPermission, 这里原来触发supperfragment权限请求");
    }

    public final boolean u0() {
        boolean z = !MzAccountManager.c.c();
        boolean z2 = !AccountExt.f7838a.b();
        Boolean bool = BuildConfig.b;
        Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
        return bool.booleanValue() ? z : z && z2;
    }

    public final void v0(String[] strArr, String str) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(str, "tag");
        PermissionHelper permissionHelper = PermissionHelper.f7819a;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        permissionHelper.r(requireActivity, strArr, false, new BaseFragment$requestMultiplePermissions$1(this, strArr, str));
    }

    public void w0(boolean z, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "reason");
        Intrinsics.checkNotNullParameter(str2, "permission");
        Intrinsics.checkNotNullParameter(str3, "tag");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("BaseFragment", "requestResult, result: " + z + ", reason: " + str + ", permission: permission, tag: " + str3);
    }

    public void y0(boolean z, String str, String[] strArr, String str2) {
        String str3;
        Intrinsics.checkNotNullParameter(str, "reason");
        Intrinsics.checkNotNullParameter(str2, "tag");
        ULog.Delegate delegate = ULog.f6446a;
        if (strArr != null) {
            str3 = Arrays.toString(strArr);
            Intrinsics.checkNotNullExpressionValue(str3, "toString(...)");
        } else {
            str3 = null;
        }
        delegate.g("BaseFragment", "requestResult, result: " + z + ", reason: " + str + ", permissions: " + str3 + ", tag: " + str2);
        if (Intrinsics.areEqual((Object) str2, (Object) "location_permission")) {
            this.b = false;
            if (z) {
                i0(3);
                return;
            }
            this.b = true;
            StaticMethodUtilsKt.C(this, CollectionsKt.arrayListOf(146), false, false);
        } else if (Intrinsics.areEqual((Object) str2, (Object) "bluetooth_permission")) {
            this.b = false;
            if (z) {
                s0();
                return;
            }
            this.b = true;
            StaticMethodUtilsKt.C(this, CollectionsKt.arrayListOf(147), false, false);
        }
    }
}
