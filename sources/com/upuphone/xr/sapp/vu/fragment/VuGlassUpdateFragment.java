package com.upuphone.xr.sapp.vu.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.honey.account.c9.o;
import com.honey.account.c9.p;
import com.honey.account.c9.q;
import com.honey.account.c9.r;
import com.honey.account.c9.s;
import com.meizu.common.app.LoadingDialog;
import com.meizu.common.widget.MzButton;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentVuGlassUpdateInfoBinding;
import com.upuphone.xr.sapp.databinding.LayVuGlassCheckUpdateErrorBinding;
import com.upuphone.xr.sapp.entity.DeviceInfo;
import com.upuphone.xr.sapp.fragment.BaseFragment;
import com.upuphone.xr.sapp.utils.AppUtils;
import com.upuphone.xr.sapp.utils.LoadingDialogUtils;
import com.upuphone.xr.sapp.utils.NetworkUtils;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.view.InstallingProgressView;
import com.upuphone.xr.sapp.vu.ota.VuUpdateInfo;
import com.upuphone.xr.sapp.vu.ota.VuUpdateStatus;
import com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil;
import com.upuphone.xr.sapp.vu.vm.VuGlassControlModel;
import com.upuphone.xr.sapp.vu.vm.VuGlassesDeviceInfoModel;
import com.upuphone.xr.sapp.vu.vm.VuGlassesOtaModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u00016\u0018\u0000 B2\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0003J\u000f\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u0003J\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010\u0003J\u000f\u0010 \u001a\u00020\u0004H\u0002¢\u0006\u0004\b \u0010\u0003J\u000f\u0010!\u001a\u00020\u0004H\u0002¢\u0006\u0004\b!\u0010\u0003J\u000f\u0010\"\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\"\u0010\u0003J\u000f\u0010#\u001a\u00020\u0004H\u0002¢\u0006\u0004\b#\u0010\u0003J\u000f\u0010$\u001a\u00020\u0004H\u0002¢\u0006\u0004\b$\u0010\u0003R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u001c\u00105\u001a\b\u0018\u000101R\u0002028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010=\u001a\u00020:8\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006D"}, d2 = {"Lcom/upuphone/xr/sapp/vu/fragment/VuGlassUpdateFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "initView", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "onDestroy", "M0", "V0", "N0", "W0", "U0", "Lcom/upuphone/xr/sapp/vu/ota/VuUpdateInfo;", "otaInfo", "T0", "(Lcom/upuphone/xr/sapp/vu/ota/VuUpdateInfo;)V", "R0", "S0", "Q0", "I0", "P0", "O0", "Lcom/meizu/common/app/LoadingDialog;", "j", "Lcom/meizu/common/app/LoadingDialog;", "checkingUpdateDialog", "Lcom/upuphone/xr/sapp/databinding/FragmentVuGlassUpdateInfoBinding;", "k", "Lcom/upuphone/xr/sapp/databinding/FragmentVuGlassUpdateInfoBinding;", "binding", "", "l", "Z", "needCheckUpdate", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "m", "Landroid/os/PowerManager$WakeLock;", "wakeLock", "com/upuphone/xr/sapp/vu/fragment/VuGlassUpdateFragment$networkCallback$1", "n", "Lcom/upuphone/xr/sapp/vu/fragment/VuGlassUpdateFragment$networkCallback$1;", "networkCallback", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassesOtaModel$UpdateInfoChangeListener;", "o", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassesOtaModel$UpdateInfoChangeListener;", "updateInfoChangeListener", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassesOtaModel$UpdateStatusChangeListener;", "p", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassesOtaModel$UpdateStatusChangeListener;", "updateStatusChangeListener", "q", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nVuGlassUpdateFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VuGlassUpdateFragment.kt\ncom/upuphone/xr/sapp/vu/fragment/VuGlassUpdateFragment\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,272:1\n256#2,2:273\n256#2,2:275\n256#2,2:277\n256#2,2:279\n256#2,2:281\n256#2,2:283\n256#2,2:285\n256#2,2:287\n256#2,2:289\n256#2,2:291\n256#2,2:293\n256#2,2:295\n256#2,2:297\n256#2,2:299\n256#2,2:301\n256#2,2:303\n256#2,2:305\n256#2,2:307\n256#2,2:309\n256#2,2:311\n256#2,2:313\n256#2,2:315\n256#2,2:317\n256#2,2:319\n256#2,2:321\n256#2,2:323\n256#2,2:325\n256#2,2:327\n256#2,2:329\n256#2,2:331\n256#2,2:333\n256#2,2:335\n256#2,2:337\n*S KotlinDebug\n*F\n+ 1 VuGlassUpdateFragment.kt\ncom/upuphone/xr/sapp/vu/fragment/VuGlassUpdateFragment\n*L\n202#1:273,2\n203#1:275,2\n204#1:277,2\n205#1:279,2\n206#1:281,2\n213#1:283,2\n214#1:285,2\n216#1:287,2\n219#1:289,2\n220#1:291,2\n225#1:293,2\n226#1:295,2\n227#1:297,2\n228#1:299,2\n229#1:301,2\n102#1:303,2\n129#1:305,2\n130#1:307,2\n131#1:309,2\n132#1:311,2\n133#1:313,2\n135#1:315,2\n136#1:317,2\n137#1:319,2\n138#1:321,2\n139#1:323,2\n153#1:325,2\n154#1:327,2\n157#1:329,2\n158#1:331,2\n159#1:333,2\n160#1:335,2\n161#1:337,2\n*E\n"})
public final class VuGlassUpdateFragment extends BaseFragment {
    public static final Companion q = new Companion((DefaultConstructorMarker) null);
    public LoadingDialog j;
    public FragmentVuGlassUpdateInfoBinding k;
    public boolean l;
    public PowerManager.WakeLock m;
    public final VuGlassUpdateFragment$networkCallback$1 n = new VuGlassUpdateFragment$networkCallback$1(this);
    public final VuGlassesOtaModel.UpdateInfoChangeListener o = new r(this);
    public final VuGlassesOtaModel.UpdateStatusChangeListener p = new s(this);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/vu/fragment/VuGlassUpdateFragment$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static final void J0(VuGlassUpdateFragment vuGlassUpdateFragment, View view) {
        Intrinsics.checkNotNullParameter(vuGlassUpdateFragment, "this$0");
        StaticMethodUtilsKt.q(vuGlassUpdateFragment);
    }

    public static final void K0(VuGlassUpdateFragment vuGlassUpdateFragment, View view) {
        Intrinsics.checkNotNullParameter(vuGlassUpdateFragment, "this$0");
        AppUtils appUtils = AppUtils.f7842a;
        FragmentActivity requireActivity = vuGlassUpdateFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        AppUtils.q(appUtils, requireActivity, 0, 2, (Object) null);
    }

    public static final void L0(VuGlassUpdateFragment vuGlassUpdateFragment, View view) {
        Intrinsics.checkNotNullParameter(vuGlassUpdateFragment, "this$0");
        vuGlassUpdateFragment.U0();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000e, code lost:
        if (r5.h() == true) goto L_0x0012;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void X0(com.upuphone.xr.sapp.vu.fragment.VuGlassUpdateFragment r4, com.upuphone.xr.sapp.vu.ota.VuUpdateInfo r5) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = 0
            if (r5 == 0) goto L_0x0011
            boolean r1 = r5.h()
            r2 = 1
            if (r1 != r2) goto L_0x0011
            goto L_0x0012
        L_0x0011:
            r2 = r0
        L_0x0012:
            com.upuphone.xr.sapp.databinding.FragmentVuGlassUpdateInfoBinding r1 = r4.k
            if (r1 != 0) goto L_0x001c
            java.lang.String r1 = "binding"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r1 = 0
        L_0x001c:
            com.upuphone.xr.sapp.databinding.LayVuGlassUpdateInfoBinding r1 = r1.d
            android.widget.LinearLayout r1 = r1.getRoot()
            java.lang.String r3 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            if (r2 == 0) goto L_0x002a
            goto L_0x002c
        L_0x002a:
            r0 = 8
        L_0x002c:
            r1.setVisibility(r0)
            if (r2 == 0) goto L_0x0038
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            r4.T0(r5)
            goto L_0x0048
        L_0x0038:
            if (r5 == 0) goto L_0x0045
            int r5 = r5.b()
            r0 = -1
            if (r5 != r0) goto L_0x0045
            r4.R0()
            goto L_0x0048
        L_0x0045:
            r4.S0()
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.fragment.VuGlassUpdateFragment.X0(com.upuphone.xr.sapp.vu.fragment.VuGlassUpdateFragment, com.upuphone.xr.sapp.vu.ota.VuUpdateInfo):void");
    }

    public static final void Y0(VuGlassUpdateFragment vuGlassUpdateFragment, VuUpdateStatus vuUpdateStatus) {
        Intrinsics.checkNotNullParameter(vuGlassUpdateFragment, "this$0");
        Intrinsics.checkNotNullParameter(vuUpdateStatus, "status");
        ULog.f6446a.a("VuGlassUpdateFragment", "update status change: " + vuUpdateStatus);
        if (vuUpdateStatus.b() == 1) {
            vuGlassUpdateFragment.Q0();
            return;
        }
        vuGlassUpdateFragment.I0();
        FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding = null;
        if (vuUpdateStatus.b() == 2) {
            FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding2 = vuGlassUpdateFragment.k;
            if (fragmentVuGlassUpdateInfoBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentVuGlassUpdateInfoBinding2 = null;
            }
            TextView textView = fragmentVuGlassUpdateInfoBinding2.d.h;
            Intrinsics.checkNotNullExpressionValue(textView, "tvLatestVersion");
            textView.setVisibility(0);
            FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding3 = vuGlassUpdateFragment.k;
            if (fragmentVuGlassUpdateInfoBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentVuGlassUpdateInfoBinding3 = null;
            }
            InstallingProgressView installingProgressView = fragmentVuGlassUpdateInfoBinding3.d.g;
            Intrinsics.checkNotNullExpressionValue(installingProgressView, "pbUpdate");
            installingProgressView.setVisibility(8);
            FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding4 = vuGlassUpdateFragment.k;
            if (fragmentVuGlassUpdateInfoBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentVuGlassUpdateInfoBinding4 = null;
            }
            TextView textView2 = fragmentVuGlassUpdateInfoBinding4.d.i;
            Intrinsics.checkNotNullExpressionValue(textView2, "tvUpdateStatus");
            textView2.setVisibility(8);
            FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding5 = vuGlassUpdateFragment.k;
            if (fragmentVuGlassUpdateInfoBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentVuGlassUpdateInfoBinding5 = null;
            }
            TextView textView3 = fragmentVuGlassUpdateInfoBinding5.d.j;
            Intrinsics.checkNotNullExpressionValue(textView3, "tvUpdateStatusDesc");
            textView3.setVisibility(8);
            FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding6 = vuGlassUpdateFragment.k;
            if (fragmentVuGlassUpdateInfoBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentVuGlassUpdateInfoBinding6 = null;
            }
            MzButton mzButton = fragmentVuGlassUpdateInfoBinding6.d.b;
            Intrinsics.checkNotNullExpressionValue(mzButton, "btnUpgrade");
            mzButton.setVisibility(0);
        } else {
            FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding7 = vuGlassUpdateFragment.k;
            if (fragmentVuGlassUpdateInfoBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentVuGlassUpdateInfoBinding7 = null;
            }
            TextView textView4 = fragmentVuGlassUpdateInfoBinding7.d.h;
            Intrinsics.checkNotNullExpressionValue(textView4, "tvLatestVersion");
            textView4.setVisibility(8);
            FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding8 = vuGlassUpdateFragment.k;
            if (fragmentVuGlassUpdateInfoBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentVuGlassUpdateInfoBinding8 = null;
            }
            InstallingProgressView installingProgressView2 = fragmentVuGlassUpdateInfoBinding8.d.g;
            Intrinsics.checkNotNullExpressionValue(installingProgressView2, "pbUpdate");
            installingProgressView2.setVisibility(0);
            FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding9 = vuGlassUpdateFragment.k;
            if (fragmentVuGlassUpdateInfoBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentVuGlassUpdateInfoBinding9 = null;
            }
            TextView textView5 = fragmentVuGlassUpdateInfoBinding9.d.i;
            Intrinsics.checkNotNullExpressionValue(textView5, "tvUpdateStatus");
            textView5.setVisibility(0);
            FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding10 = vuGlassUpdateFragment.k;
            if (fragmentVuGlassUpdateInfoBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentVuGlassUpdateInfoBinding10 = null;
            }
            TextView textView6 = fragmentVuGlassUpdateInfoBinding10.d.j;
            Intrinsics.checkNotNullExpressionValue(textView6, "tvUpdateStatusDesc");
            textView6.setVisibility(0);
            FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding11 = vuGlassUpdateFragment.k;
            if (fragmentVuGlassUpdateInfoBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentVuGlassUpdateInfoBinding11 = null;
            }
            MzButton mzButton2 = fragmentVuGlassUpdateInfoBinding11.d.b;
            Intrinsics.checkNotNullExpressionValue(mzButton2, "btnUpgrade");
            mzButton2.setVisibility(8);
        }
        if (vuUpdateStatus.b() == 3) {
            vuGlassUpdateFragment.P0();
            FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding12 = vuGlassUpdateFragment.k;
            if (fragmentVuGlassUpdateInfoBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentVuGlassUpdateInfoBinding12 = null;
            }
            fragmentVuGlassUpdateInfoBinding12.d.j.setText(vuGlassUpdateFragment.getString(R.string.view_updateing_tip));
            FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding13 = vuGlassUpdateFragment.k;
            if (fragmentVuGlassUpdateInfoBinding13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentVuGlassUpdateInfoBinding = fragmentVuGlassUpdateInfoBinding13;
            }
            fragmentVuGlassUpdateInfoBinding.d.i.setText(vuGlassUpdateFragment.getString(R.string.status_installing) + " " + vuUpdateStatus.a() + "%");
        } else if (vuUpdateStatus.b() == 4) {
            FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding14 = vuGlassUpdateFragment.k;
            if (fragmentVuGlassUpdateInfoBinding14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentVuGlassUpdateInfoBinding14 = null;
            }
            fragmentVuGlassUpdateInfoBinding14.d.j.setText(vuGlassUpdateFragment.getString(R.string.keep_glasses_connected));
            FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding15 = vuGlassUpdateFragment.k;
            if (fragmentVuGlassUpdateInfoBinding15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentVuGlassUpdateInfoBinding = fragmentVuGlassUpdateInfoBinding15;
            }
            fragmentVuGlassUpdateInfoBinding.d.i.setText(vuGlassUpdateFragment.getString(R.string.installing_rom));
        } else if (vuUpdateStatus.b() == 5) {
            vuGlassUpdateFragment.O0();
            if (Intrinsics.areEqual(vuUpdateStatus.a(), (Object) Boolean.TRUE)) {
                FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding16 = vuGlassUpdateFragment.k;
                if (fragmentVuGlassUpdateInfoBinding16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentVuGlassUpdateInfoBinding16 = null;
                }
                InstallingProgressView installingProgressView3 = fragmentVuGlassUpdateInfoBinding16.d.g;
                Intrinsics.checkNotNullExpressionValue(installingProgressView3, "pbUpdate");
                installingProgressView3.setVisibility(8);
                FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding17 = vuGlassUpdateFragment.k;
                if (fragmentVuGlassUpdateInfoBinding17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentVuGlassUpdateInfoBinding17 = null;
                }
                MzButton mzButton3 = fragmentVuGlassUpdateInfoBinding17.d.b;
                Intrinsics.checkNotNullExpressionValue(mzButton3, "btnUpgrade");
                mzButton3.setVisibility(8);
                FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding18 = vuGlassUpdateFragment.k;
                if (fragmentVuGlassUpdateInfoBinding18 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    fragmentVuGlassUpdateInfoBinding = fragmentVuGlassUpdateInfoBinding18;
                }
                fragmentVuGlassUpdateInfoBinding.d.i.setText(vuGlassUpdateFragment.getString(R.string.update_success));
                return;
            }
            FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding19 = vuGlassUpdateFragment.k;
            if (fragmentVuGlassUpdateInfoBinding19 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentVuGlassUpdateInfoBinding19 = null;
            }
            TextView textView7 = fragmentVuGlassUpdateInfoBinding19.d.h;
            Intrinsics.checkNotNullExpressionValue(textView7, "tvLatestVersion");
            textView7.setVisibility(0);
            FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding20 = vuGlassUpdateFragment.k;
            if (fragmentVuGlassUpdateInfoBinding20 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentVuGlassUpdateInfoBinding20 = null;
            }
            InstallingProgressView installingProgressView4 = fragmentVuGlassUpdateInfoBinding20.d.g;
            Intrinsics.checkNotNullExpressionValue(installingProgressView4, "pbUpdate");
            installingProgressView4.setVisibility(8);
            FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding21 = vuGlassUpdateFragment.k;
            if (fragmentVuGlassUpdateInfoBinding21 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentVuGlassUpdateInfoBinding21 = null;
            }
            MzButton mzButton4 = fragmentVuGlassUpdateInfoBinding21.d.b;
            Intrinsics.checkNotNullExpressionValue(mzButton4, "btnUpgrade");
            mzButton4.setVisibility(0);
            FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding22 = vuGlassUpdateFragment.k;
            if (fragmentVuGlassUpdateInfoBinding22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentVuGlassUpdateInfoBinding22 = null;
            }
            TextView textView8 = fragmentVuGlassUpdateInfoBinding22.d.i;
            Intrinsics.checkNotNullExpressionValue(textView8, "tvUpdateStatus");
            textView8.setVisibility(8);
            FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding23 = vuGlassUpdateFragment.k;
            if (fragmentVuGlassUpdateInfoBinding23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentVuGlassUpdateInfoBinding23 = null;
            }
            TextView textView9 = fragmentVuGlassUpdateInfoBinding23.d.j;
            Intrinsics.checkNotNullExpressionValue(textView9, "tvUpdateStatusDesc");
            textView9.setVisibility(8);
            FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding24 = vuGlassUpdateFragment.k;
            if (fragmentVuGlassUpdateInfoBinding24 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentVuGlassUpdateInfoBinding = fragmentVuGlassUpdateInfoBinding24;
            }
            fragmentVuGlassUpdateInfoBinding.d.b.setText(R.string.update_now);
        }
    }

    private final void initView() {
        FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding = this.k;
        FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding2 = null;
        if (fragmentVuGlassUpdateInfoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuGlassUpdateInfoBinding = null;
        }
        fragmentVuGlassUpdateInfoBinding.e.setOnClickListener(new o(this));
        FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding3 = this.k;
        if (fragmentVuGlassUpdateInfoBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuGlassUpdateInfoBinding3 = null;
        }
        fragmentVuGlassUpdateInfoBinding3.b.c.setOnClickListener(new p(this));
        FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding4 = this.k;
        if (fragmentVuGlassUpdateInfoBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentVuGlassUpdateInfoBinding2 = fragmentVuGlassUpdateInfoBinding4;
        }
        fragmentVuGlassUpdateInfoBinding2.d.b.setOnClickListener(new q(this));
        N0();
        M0();
    }

    public final void I0() {
        LoadingDialog loadingDialog = this.j;
        if (loadingDialog != null) {
            loadingDialog.dismiss();
        }
        this.j = null;
    }

    public final void M0() {
        VuGlassesOtaModel.f8117a.s(this.o);
    }

    public final void N0() {
        VuGlassesOtaModel.f8117a.r(this.p);
    }

    public final void O0() {
        PowerManager.WakeLock wakeLock = this.m;
        if (wakeLock != null && wakeLock.isHeld()) {
            try {
                Result.Companion companion = Result.Companion;
                ULog.f6446a.a("VuGlassUpdateFragment", "release wake lock");
                wakeLock.release();
                this.m = null;
                Result.m20constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.m20constructorimpl(ResultKt.createFailure(th));
            }
        }
    }

    public final void P0() {
        if (this.m == null) {
            this.m = ((PowerManager) requireActivity().getSystemService(PowerManager.class)).newWakeLock(536870918, "myvu:updating");
        }
        PowerManager.WakeLock wakeLock = this.m;
        Intrinsics.checkNotNull(wakeLock);
        if (!wakeLock.isHeld()) {
            try {
                Result.Companion companion = Result.Companion;
                ULog.f6446a.a("VuGlassUpdateFragment", "acquire wake lock");
                PowerManager.WakeLock wakeLock2 = this.m;
                Intrinsics.checkNotNull(wakeLock2);
                wakeLock2.acquire(250000);
                Result.m20constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.m20constructorimpl(ResultKt.createFailure(th));
            }
        }
    }

    public final void Q0() {
        if (this.j == null) {
            LoadingDialogUtils loadingDialogUtils = LoadingDialogUtils.f7895a;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            this.j = LoadingDialogUtils.b(loadingDialogUtils, requireContext, R.string.checking_update, 0, 0, false, 28, (Object) null);
        }
        LoadingDialog loadingDialog = this.j;
        if (loadingDialog != null) {
            loadingDialog.show();
        }
    }

    public final void R0() {
        this.l = true;
        FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding = this.k;
        FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding2 = null;
        if (fragmentVuGlassUpdateInfoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuGlassUpdateInfoBinding = null;
        }
        LinearLayout b = fragmentVuGlassUpdateInfoBinding.d.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        b.setVisibility(8);
        FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding3 = this.k;
        if (fragmentVuGlassUpdateInfoBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuGlassUpdateInfoBinding3 = null;
        }
        ConstraintLayout b2 = fragmentVuGlassUpdateInfoBinding3.c.getRoot();
        Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
        b2.setVisibility(8);
        FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding4 = this.k;
        if (fragmentVuGlassUpdateInfoBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentVuGlassUpdateInfoBinding2 = fragmentVuGlassUpdateInfoBinding4;
        }
        LayVuGlassCheckUpdateErrorBinding layVuGlassCheckUpdateErrorBinding = fragmentVuGlassUpdateInfoBinding2.b;
        LinearLayout b3 = layVuGlassCheckUpdateErrorBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(b3, "getRoot(...)");
        b3.setVisibility(0);
        layVuGlassCheckUpdateErrorBinding.d.setImageResource(R.mipmap.ic_network_error);
        layVuGlassCheckUpdateErrorBinding.e.setText(R.string.network_not_available_pls_check);
        Button button = layVuGlassCheckUpdateErrorBinding.b;
        Intrinsics.checkNotNullExpressionValue(button, "btnRetry");
        button.setVisibility(8);
        Button button2 = layVuGlassCheckUpdateErrorBinding.c;
        Intrinsics.checkNotNullExpressionValue(button2, "btnSetupNetwork");
        button2.setVisibility(0);
    }

    public final void S0() {
        FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding = this.k;
        FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding2 = null;
        if (fragmentVuGlassUpdateInfoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuGlassUpdateInfoBinding = null;
        }
        LinearLayout b = fragmentVuGlassUpdateInfoBinding.d.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        b.setVisibility(8);
        FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding3 = this.k;
        if (fragmentVuGlassUpdateInfoBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuGlassUpdateInfoBinding3 = null;
        }
        LinearLayout b2 = fragmentVuGlassUpdateInfoBinding3.b.getRoot();
        Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
        b2.setVisibility(8);
        FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding4 = this.k;
        if (fragmentVuGlassUpdateInfoBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuGlassUpdateInfoBinding4 = null;
        }
        ConstraintLayout b3 = fragmentVuGlassUpdateInfoBinding4.c.getRoot();
        Intrinsics.checkNotNullExpressionValue(b3, "getRoot(...)");
        b3.setVisibility(0);
        FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding5 = this.k;
        if (fragmentVuGlassUpdateInfoBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuGlassUpdateInfoBinding5 = null;
        }
        TextView textView = fragmentVuGlassUpdateInfoBinding5.c.d;
        Intrinsics.checkNotNullExpressionValue(textView, "tvGlassVersion");
        textView.setVisibility(0);
        FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding6 = this.k;
        if (fragmentVuGlassUpdateInfoBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentVuGlassUpdateInfoBinding2 = fragmentVuGlassUpdateInfoBinding6;
        }
        TextView textView2 = fragmentVuGlassUpdateInfoBinding2.c.c;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvGlassIsLatestVersion");
        textView2.setVisibility(0);
        VuGlassesDeviceInfoModel.f8112a.b().observe(getViewLifecycleOwner(), new VuGlassUpdateFragment$sam$androidx_lifecycle_Observer$0(new VuGlassUpdateFragment$showNoUpdate$1(this)));
    }

    public final void T0(VuUpdateInfo vuUpdateInfo) {
        FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding = this.k;
        FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding2 = null;
        if (fragmentVuGlassUpdateInfoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuGlassUpdateInfoBinding = null;
        }
        LinearLayout b = fragmentVuGlassUpdateInfoBinding.d.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        b.setVisibility(0);
        FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding3 = this.k;
        if (fragmentVuGlassUpdateInfoBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuGlassUpdateInfoBinding3 = null;
        }
        LinearLayout b2 = fragmentVuGlassUpdateInfoBinding3.b.getRoot();
        Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
        b2.setVisibility(8);
        FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding4 = this.k;
        if (fragmentVuGlassUpdateInfoBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuGlassUpdateInfoBinding4 = null;
        }
        ConstraintLayout b3 = fragmentVuGlassUpdateInfoBinding4.c.getRoot();
        Intrinsics.checkNotNullExpressionValue(b3, "getRoot(...)");
        b3.setVisibility(8);
        FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding5 = this.k;
        if (fragmentVuGlassUpdateInfoBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuGlassUpdateInfoBinding5 = null;
        }
        TextView textView = fragmentVuGlassUpdateInfoBinding5.d.i;
        Intrinsics.checkNotNullExpressionValue(textView, "tvUpdateStatus");
        textView.setVisibility(8);
        FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding6 = this.k;
        if (fragmentVuGlassUpdateInfoBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuGlassUpdateInfoBinding6 = null;
        }
        TextView textView2 = fragmentVuGlassUpdateInfoBinding6.d.j;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvUpdateStatusDesc");
        textView2.setVisibility(8);
        FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding7 = this.k;
        if (fragmentVuGlassUpdateInfoBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuGlassUpdateInfoBinding7 = null;
        }
        fragmentVuGlassUpdateInfoBinding7.d.h.setText(VuGlassesHidUtil.f8104a.h(vuUpdateInfo.g()));
        FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding8 = this.k;
        if (fragmentVuGlassUpdateInfoBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentVuGlassUpdateInfoBinding2 = fragmentVuGlassUpdateInfoBinding8;
        }
        fragmentVuGlassUpdateInfoBinding2.d.k.setText(vuUpdateInfo.d());
    }

    public final void U0() {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VuGlassUpdateFragment", "startUpdate");
        if (!VuGlassControlModel.f8109a.z()) {
            delegate.a("VuGlassUpdateFragment", "startUpdate not connected");
            StaticMethodUtilsKt.Y(this);
            return;
        }
        VuGlassesOtaModel.f8117a.J();
    }

    public final void V0() {
        VuGlassesOtaModel.f8117a.F(this.o);
    }

    public final void W0() {
        VuGlassesOtaModel.f8117a.E(this.p);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NetworkUtils.f7898a.o(this, this.n);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        if (this.k == null) {
            FragmentVuGlassUpdateInfoBinding c = FragmentVuGlassUpdateInfoBinding.c(layoutInflater, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
            this.k = c;
        }
        FragmentVuGlassUpdateInfoBinding fragmentVuGlassUpdateInfoBinding = this.k;
        if (fragmentVuGlassUpdateInfoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuGlassUpdateInfoBinding = null;
        }
        ConstraintLayout b = fragmentVuGlassUpdateInfoBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        return b;
    }

    public void onDestroy() {
        super.onDestroy();
        VuGlassesOtaModel.f8117a.H(true);
        I0();
        V0();
        W0();
        O0();
    }

    public void onStart() {
        super.onStart();
        DeviceInfo c = VuGlassesDeviceInfoModel.f8112a.c();
        if (c != null) {
            VuGlassesOtaModel.f8117a.u(c);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView();
        VuGlassesOtaModel.f8117a.H(false);
    }
}
