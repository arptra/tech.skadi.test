package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.google.gson.Gson;
import com.honey.account.h8.a7;
import com.honey.account.h8.b7;
import com.honey.account.h8.o6;
import com.honey.account.h8.p6;
import com.honey.account.h8.q6;
import com.honey.account.h8.r6;
import com.honey.account.h8.s6;
import com.honey.account.h8.t6;
import com.honey.account.h8.u6;
import com.honey.account.h8.v6;
import com.honey.account.h8.w6;
import com.honey.account.h8.x6;
import com.honey.account.h8.y6;
import com.honey.account.h8.z6;
import com.upuphone.runasone.uupcast.CaptureType;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$3;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$4;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$5;
import com.upuphone.xr.sapp.common.MzAccountManager;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.contract.ProtocolActivity;
import com.upuphone.xr.sapp.databinding.FragmentMineBinding;
import com.upuphone.xr.sapp.datatrack.AppDataTrackEvent;
import com.upuphone.xr.sapp.entity.AccountInfo;
import com.upuphone.xr.sapp.entity.DeviceState;
import com.upuphone.xr.sapp.tips.TipsKey;
import com.upuphone.xr.sapp.tips.TipsManager;
import com.upuphone.xr.sapp.utils.AccountExt;
import com.upuphone.xr.sapp.utils.AppUpdateHelper;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.ImageSaveUtil;
import com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.utils.UserGuideHelper;
import com.upuphone.xr.sapp.utils.ViewExtKt;
import com.upuphone.xr.sapp.vm.DeviceControlModel;
import com.upuphone.xr.sapp.vm.Ring2ControlViewModel;
import com.upuphone.xr.sapp.vm.SuperViewModel;
import com.upuphone.xr.sapp.vu.vm.VuGlassControlModel;
import com.xjmz.myvu.account.AccountManager;
import com.xjmz.myvu.dialog.LoginFragmentDialog;
import com.xjmz.myvu.flutter.pigeon.AndroidConnectApi;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import kotlin.Deprecated;
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
import org.apache.commons.lang3.time.DateUtils;

@SourceDebugExtension({"SMAP\nMineFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MineFragment.kt\ncom/upuphone/xr/sapp/fragment/MineFragment\n+ 2 GlobalViewStoreExt.kt\ncom/upuphone/xr/sapp/common/GlobalViewStoreExtKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,367:1\n32#2,12:368\n32#2,12:380\n32#2,12:392\n256#3,2:404\n256#3,2:406\n256#3,2:408\n256#3,2:410\n256#3,2:412\n256#3,2:414\n256#3,2:416\n256#3,2:418\n256#3,2:420\n256#3,2:422\n256#3,2:424\n256#3,2:426\n256#3,2:428\n256#3,2:430\n*S KotlinDebug\n*F\n+ 1 MineFragment.kt\ncom/upuphone/xr/sapp/fragment/MineFragment\n*L\n73#1:368,12\n74#1:380,12\n75#1:392,12\n142#1:404,2\n144#1:406,2\n160#1:408,2\n163#1:410,2\n166#1:412,2\n169#1:414,2\n172#1:416,2\n354#1:418,2\n355#1:420,2\n364#1:422,2\n215#1:424,2\n229#1:426,2\n252#1:428,2\n253#1:430,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 I2\u00020\u0001:\u0001JB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0003J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001c\u0010\u0003J\u000f\u0010\u001d\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001d\u0010\u0003J\u000f\u0010\u001e\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001e\u0010\u0003J\u001b\u0010!\u001a\u00020\u000e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u000eH\u0002¢\u0006\u0004\b#\u0010\u0003J\u000f\u0010$\u001a\u00020\u000eH\u0002¢\u0006\u0004\b$\u0010\u0003J\u0019\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u000eH\u0002¢\u0006\u0004\b*\u0010\u0003J\u001f\u0010-\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020%H\u0002¢\u0006\u0004\b-\u0010.J\u0019\u00101\u001a\u00020\u000e2\b\u00100\u001a\u0004\u0018\u00010/H\u0002¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u000eH\u0002¢\u0006\u0004\b3\u0010\u0003R\u001b\u00109\u001a\u0002048BX\u0002¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001b\u0010>\u001a\u00020:8BX\u0002¢\u0006\f\n\u0004\b;\u00106\u001a\u0004\b<\u0010=R\u001b\u0010C\u001a\u00020?8BX\u0002¢\u0006\f\n\u0004\b@\u00106\u001a\u0004\bA\u0010BR\u001b\u0010H\u001a\u00020D8BX\u0002¢\u0006\f\n\u0004\bE\u00106\u001a\u0004\bF\u0010G¨\u0006K"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/MineFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "", "W0", "()Z", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "G0", "D0", "initView", "Lcom/upuphone/xr/sapp/entity/AccountInfo;", "accountInfo", "b1", "(Lcom/upuphone/xr/sapp/entity/AccountInfo;)V", "Y0", "L0", "", "urladdr", "Landroid/graphics/drawable/Drawable;", "V0", "(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;", "M0", "title", "url", "X0", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/upuphone/xr/sapp/entity/DeviceState;", "deviceState", "E0", "(Lcom/upuphone/xr/sapp/entity/DeviceState;)V", "F0", "Lcom/upuphone/xr/sapp/databinding/FragmentMineBinding;", "a", "Lkotlin/Lazy;", "I0", "()Lcom/upuphone/xr/sapp/databinding/FragmentMineBinding;", "binding", "Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "b", "getViewModel", "()Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "viewModel", "Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "c", "J0", "()Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "mDeviceModel", "Lcom/upuphone/xr/sapp/vm/Ring2ControlViewModel;", "d", "K0", "()Lcom/upuphone/xr/sapp/vm/Ring2ControlViewModel;", "mRing2ControlViewModel", "e", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@Deprecated(message = "个人中心已使用 flutter 重写，此页面废弃")
public final class MineFragment extends Fragment {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Lazy f6982a = LazyKt.lazy(new MineFragment$binding$2(this));
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/MineFragment$Companion;", "", "()V", "MYVU_COMMUNITY_URL", "", "MYVU_MALL_URL", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public MineFragment() {
        Class<SuperViewModel> cls = SuperViewModel.class;
        this.b = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls), new GlobalViewStoreExtKt$cachedViewModels$3(cls.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
        Class<DeviceControlModel> cls2 = DeviceControlModel.class;
        this.c = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls2), new GlobalViewStoreExtKt$cachedViewModels$3(cls2.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
        Class<Ring2ControlViewModel> cls3 = Ring2ControlViewModel.class;
        this.d = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls3), new GlobalViewStoreExtKt$cachedViewModels$3(cls3.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
    }

    private final void D0() {
        AppUpdateHelper.f7841a.B().observe(getViewLifecycleOwner(), new MineFragment$sam$androidx_lifecycle_Observer$0(new MineFragment$addObserve$1(this)));
        J0().M().observe(getViewLifecycleOwner(), new MineFragment$sam$androidx_lifecycle_Observer$0(new MineFragment$addObserve$2(this)));
        MzAccountManager.c.b().d().observe(getViewLifecycleOwner(), new MineFragment$sam$androidx_lifecycle_Observer$0(new MineFragment$addObserve$3(this)));
        VuGlassControlModel.f8109a.v().observe(getViewLifecycleOwner(), new MineFragment$sam$androidx_lifecycle_Observer$0(new MineFragment$addObserve$4(this)));
    }

    private final void G0() {
        I0().getRoot().postDelayed(new b7(this), 1000);
    }

    public static final void H0(MineFragment mineFragment) {
        Intrinsics.checkNotNullParameter(mineFragment, "this$0");
        mineFragment.b1(MzAccountManager.c.a());
    }

    private final DeviceControlModel J0() {
        return (DeviceControlModel) this.c.getValue();
    }

    private final Ring2ControlViewModel K0() {
        return (Ring2ControlViewModel) this.d.getValue();
    }

    public static final void N0(MineFragment mineFragment, View view) {
        Intrinsics.checkNotNullParameter(mineFragment, "this$0");
        SdkContext.f6675a.d().reportEvent(AppDataTrackEvent.APP_CLICK, MapsKt.hashMapOf(TuplesKt.to("status", "17")));
        String string = mineFragment.getString(R.string.myvu_mall);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        mineFragment.X0(string, "https://www.meizu.com/myvu");
    }

    public static final void O0(MineFragment mineFragment, View view) {
        Intrinsics.checkNotNullParameter(mineFragment, "this$0");
        SdkContext.f6675a.d().reportEvent(AppDataTrackEvent.APP_CLICK, MapsKt.hashMapOf(TuplesKt.to("status", "18")));
        String string = mineFragment.getString(R.string.myvu_community);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        mineFragment.X0(string, "https://www.meizu.cn/circle/223");
    }

    public static final void P0(MineFragment mineFragment, View view) {
        Intrinsics.checkNotNullParameter(mineFragment, "this$0");
        StaticMethodUtilsKt.q(mineFragment);
    }

    public static final void Q0(MineFragment mineFragment, View view) {
        Intrinsics.checkNotNullParameter(mineFragment, "this$0");
        StaticMethodUtilsKt.t(mineFragment, R.id.settingFragment);
    }

    public static final void R0(MineFragment mineFragment, View view) {
        Intrinsics.checkNotNullParameter(mineFragment, "this$0");
        StaticMethodUtilsKt.t(mineFragment, R.id.helpFeedbackFragment);
    }

    public static final void S0(MineFragment mineFragment, View view) {
        Intrinsics.checkNotNullParameter(mineFragment, "this$0");
        DataStoreUtils.Companion companion = DataStoreUtils.e;
        if (!((Boolean) DataStoreUtils.i(companion.a(), "check_device_help_action", Boolean.FALSE, (Context) null, 4, (Object) null)).booleanValue()) {
            companion.a().o("check_device_help_action", Boolean.TRUE);
            companion.a().o("check_device_help_time", Long.valueOf(System.currentTimeMillis()));
        }
        StaticMethodUtilsKt.t(mineFragment, R.id.deviceConnectHelpFragment);
    }

    public static final void T0(View view) {
        ULog.f6446a.c("MineFragment", "WTF, DeviceManage wrong");
    }

    public static final void U0(MineFragment mineFragment, View view) {
        String str;
        Intrinsics.checkNotNullParameter(mineFragment, "this$0");
        Bundle bundle = new Bundle();
        UserGuideHelper userGuideHelper = UserGuideHelper.f7928a;
        AndroidConnectApi.DeviceInfo deviceInfo = (AndroidConnectApi.DeviceInfo) mineFragment.J0().P().getValue();
        if (deviceInfo == null || (str = deviceInfo.d()) == null) {
            str = "";
        }
        Intrinsics.checkNotNull(str);
        bundle.putString("URL_KEY", userGuideHelper.e(str));
        DataStoreUtils a2 = DataStoreUtils.e.a();
        AndroidConnectApi.DeviceInfo deviceInfo2 = (AndroidConnectApi.DeviceInfo) mineFragment.J0().P().getValue();
        String d2 = deviceInfo2 != null ? deviceInfo2.d() : null;
        a2.o("TIPS_USER_GUIDE_" + d2, Boolean.TRUE);
        TipsManager.f7827a.d(TipsKey.TIPS_USER_GUIDE);
        StaticMethodUtilsKt.v(mineFragment, R.id.userGuideFragment, bundle);
    }

    public static final void Z0(MineFragment mineFragment, View view) {
        Intrinsics.checkNotNullParameter(mineFragment, "this$0");
        if (mineFragment.W0()) {
            ULog.f6446a.a("MineFragment", "jumpTo fail need account");
            mineFragment.L0();
            return;
        }
        StaticMethodUtilsKt.t(mineFragment, R.id.accountFragment);
    }

    public static final void a1(MineFragment mineFragment, View view) {
        Intrinsics.checkNotNullParameter(mineFragment, "this$0");
        if (mineFragment.W0()) {
            ULog.f6446a.a("MineFragment", "jumpTo fail need account");
            mineFragment.L0();
            return;
        }
        StaticMethodUtilsKt.t(mineFragment, R.id.accountFragment);
    }

    public static final void c1(AccountInfo accountInfo, MineFragment mineFragment) {
        Intrinsics.checkNotNullParameter(mineFragment, "this$0");
        if (accountInfo == null || !mineFragment.isAdded()) {
            mineFragment.I0().c.setClickable(true);
            mineFragment.I0().e.setClickable(true);
            mineFragment.I0().c.setText(R.string.un_login);
            mineFragment.I0().e.setImageResource(R.drawable.mine_account_photo);
            TextView textView = mineFragment.I0().d;
            Intrinsics.checkNotNullExpressionValue(textView, "accountPhone");
            textView.setVisibility(8);
            ImageFilterView imageFilterView = mineFragment.I0().f;
            Intrinsics.checkNotNullExpressionValue(imageFilterView, "accountPhotoCircle");
            imageFilterView.setVisibility(8);
        } else {
            mineFragment.I0().c.setClickable(false);
            mineFragment.I0().e.setClickable(false);
            ImageFilterView imageFilterView2 = mineFragment.I0().f;
            Intrinsics.checkNotNullExpressionValue(imageFilterView2, "accountPhotoCircle");
            imageFilterView2.setVisibility(0);
            FragmentActivity activity = mineFragment.getActivity();
            if (activity != null) {
                ImageSaveUtil imageSaveUtil = ImageSaveUtil.f7892a;
                File cacheDir = activity.getCacheDir();
                Bitmap a2 = imageSaveUtil.a(cacheDir + "/tmp.jpg");
                if (a2 == null) {
                    ULog.f6446a.a("MineFragment", "no catch");
                    mineFragment.I0().e.setImageResource(R.drawable.mine_account_photo);
                } else {
                    ULog.f6446a.a("MineFragment", "no have catch");
                    mineFragment.I0().e.setImageBitmap(a2);
                }
            }
            mineFragment.I0().c.setText(accountInfo.getNickname());
            mineFragment.I0().d.setText(accountInfo.getPhoneWithoutSensitivities());
            if (!BuildConfig.f6575a.booleanValue()) {
                TextView textView2 = mineFragment.I0().d;
                Intrinsics.checkNotNullExpressionValue(textView2, "accountPhone");
                textView2.setVisibility(0);
            }
            new Thread(new r6(mineFragment, accountInfo)).start();
        }
        mineFragment.Y0();
    }

    public static final void d1(MineFragment mineFragment, AccountInfo accountInfo) {
        Intrinsics.checkNotNullParameter(mineFragment, "this$0");
        Drawable V0 = mineFragment.V0(accountInfo.getIcon());
        if (V0 != null && mineFragment.isAdded()) {
            mineFragment.I0().getRoot().post(new s6(mineFragment, V0));
            FragmentActivity activity = mineFragment.getActivity();
            if (activity != null) {
                ImageSaveUtil imageSaveUtil = ImageSaveUtil.f7892a;
                Bitmap bitmap = ((BitmapDrawable) V0).getBitmap();
                Intrinsics.checkNotNullExpressionValue(bitmap, "getBitmap(...)");
                imageSaveUtil.b(bitmap, activity.getCacheDir() + "/tmp.jpg");
            }
        }
    }

    public static final void e1(MineFragment mineFragment, Drawable drawable) {
        Intrinsics.checkNotNullParameter(mineFragment, "this$0");
        Intrinsics.checkNotNullParameter(drawable, "$it");
        mineFragment.I0().e.setImageDrawable(drawable);
    }

    private final void initView() {
        int i;
        String str;
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        if (bool.booleanValue()) {
            I0().d.setVisibility(8);
        }
        ImageView imageView = I0().g;
        Intrinsics.checkNotNullExpressionValue(imageView, "btnBack");
        ViewExtKt.b(imageView, new t6(this));
        DataStoreUtils.Companion companion = DataStoreUtils.e;
        String str2 = (String) DataStoreUtils.i(companion.a(), "mz_account", "", (Context) null, 4, (Object) null);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("MineFragment", "data is: " + str2);
        if (str2.length() > 0) {
            I0().c.setText(((AccountInfo) new Gson().fromJson(str2, AccountInfo.class)).getNickname());
        }
        TextView textView = I0().l;
        Intrinsics.checkNotNullExpressionValue(textView, "helpFeedback");
        textView.setVisibility(8);
        Boolean bool2 = BuildConfig.b;
        Intrinsics.checkNotNullExpressionValue(bool2, "THIRD_PLATFOM");
        if (bool2.booleanValue()) {
            ConstraintLayout constraintLayout = I0().o;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "layConnectHelp");
            constraintLayout.setVisibility(0);
            PermissionAndStateCheckUtils permissionAndStateCheckUtils = PermissionAndStateCheckUtils.f7907a;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            boolean C = permissionAndStateCheckUtils.C(requireContext);
            DataStoreUtils a2 = companion.a();
            Boolean bool3 = Boolean.FALSE;
            boolean booleanValue = ((Boolean) DataStoreUtils.i(a2, "automatic-start", bool3, (Context) null, 4, (Object) null)).booleanValue();
            Boolean bool4 = bool3;
            boolean booleanValue2 = ((Boolean) DataStoreUtils.i(companion.a(), "lock-background", bool4, (Context) null, 4, (Object) null)).booleanValue();
            boolean booleanValue3 = ((Boolean) DataStoreUtils.i(companion.a(), "check_device_help_action", bool4, (Context) null, 4, (Object) null)).booleanValue();
            long currentTimeMillis = System.currentTimeMillis();
            long longValue = ((Number) DataStoreUtils.i(companion.a(), "check_device_help_time", 0L, (Context) null, 4, (Object) null)).longValue();
            delegate.a("MineFragment", "initView::ignoringBatteryOptimizations is: " + C + " autoStart is: " + booleanValue + " lock is: " + booleanValue2 + " checkState is: " + booleanValue3);
            if (C && booleanValue && booleanValue2) {
                ImageView imageView2 = I0().n;
                Intrinsics.checkNotNullExpressionValue(imageView2, "ivConnectHelp");
                imageView2.setVisibility(8);
            } else if (!booleanValue3) {
                ImageView imageView3 = I0().n;
                Intrinsics.checkNotNullExpressionValue(imageView3, "ivConnectHelp");
                i = 0;
                imageView3.setVisibility(0);
            } else if (currentTimeMillis - longValue >= DateUtils.MILLIS_PER_DAY) {
                ImageView imageView4 = I0().n;
                Intrinsics.checkNotNullExpressionValue(imageView4, "ivConnectHelp");
                imageView4.setVisibility(0);
                companion.a().o("check_device_help_action", bool3);
            } else {
                ImageView imageView5 = I0().n;
                Intrinsics.checkNotNullExpressionValue(imageView5, "ivConnectHelp");
                imageView5.setVisibility(8);
            }
            i = 0;
        } else {
            i = 0;
            ConstraintLayout constraintLayout2 = I0().o;
            Intrinsics.checkNotNullExpressionValue(constraintLayout2, "layConnectHelp");
            constraintLayout2.setVisibility(8);
        }
        Y0();
        I0().t.setVisibility(i);
        I0().t.setOnClickListener(new u6(this));
        I0().l.setOnClickListener(new v6(this));
        I0().o.setOnClickListener(new w6(this));
        TextView textView2 = I0().v;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvDeviceManage");
        ViewExtKt.b(textView2, new x6());
        b1(MzAccountManager.c.a());
        TextView textView3 = I0().k;
        UserGuideHelper userGuideHelper = UserGuideHelper.f7928a;
        AndroidConnectApi.DeviceInfo deviceInfo = (AndroidConnectApi.DeviceInfo) J0().P().getValue();
        if (deviceInfo == null || (str = deviceInfo.d()) == null) {
            str = "";
        }
        textView3.setText(userGuideHelper.d(str));
        I0().j.setOnClickListener(new y6(this));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0071, code lost:
        if (r7.booleanValue() != false) goto L_0x0075;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void E0(com.upuphone.xr.sapp.entity.DeviceState r7) {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
            if (r7 == 0) goto L_0x000d
            int r7 = r7.getState()
            r2 = 2
            if (r7 != r2) goto L_0x000d
            r7 = r0
            goto L_0x000e
        L_0x000d:
            r7 = r1
        L_0x000e:
            com.upuphone.xr.sapp.vm.Ring2ControlViewModel r2 = r6.K0()
            androidx.lifecycle.LiveData r2 = r2.k()
            java.lang.Object r2 = r2.getValue()
            com.upuphone.xr.sapp.entity.NetDevice r2 = (com.upuphone.xr.sapp.entity.NetDevice) r2
            if (r2 == 0) goto L_0x0023
            com.upuphone.xr.sapp.entity.ConnectState r2 = r2.getState()
            goto L_0x0024
        L_0x0023:
            r2 = 0
        L_0x0024:
            com.upuphone.xr.sapp.entity.ConnectState r3 = com.upuphone.xr.sapp.entity.ConnectState.CONNECTED
            if (r2 != r3) goto L_0x002a
            r2 = r0
            goto L_0x002b
        L_0x002a:
            r2 = r1
        L_0x002b:
            com.upuphone.xr.sapp.vm.DeviceControlModel r3 = r6.J0()
            androidx.lifecycle.LiveData r3 = r3.P()
            java.lang.Object r3 = r3.getValue()
            com.xjmz.myvu.flutter.pigeon.AndroidConnectApi$DeviceInfo r3 = (com.xjmz.myvu.flutter.pigeon.AndroidConnectApi.DeviceInfo) r3
            if (r3 == 0) goto L_0x0048
            java.lang.String r3 = r3.d()
            if (r3 == 0) goto L_0x0048
            boolean r3 = com.xjmz.myvu.ext.ConnectExtKt.h(r3)
            if (r3 != r0) goto L_0x0048
            r7 = r2
        L_0x0048:
            com.upuphone.xr.sapp.databinding.FragmentMineBinding r2 = r6.I0()
            androidx.constraintlayout.widget.ConstraintLayout r3 = r2.p
            java.lang.String r4 = "layGuideMain"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r4 = 8
            if (r7 == 0) goto L_0x0059
            r5 = r1
            goto L_0x005a
        L_0x0059:
            r5 = r4
        L_0x005a:
            r3.setVisibility(r5)
            androidx.constraintlayout.widget.ConstraintLayout r2 = r2.o
            java.lang.String r3 = "layConnectHelp"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            if (r7 == 0) goto L_0x0074
            java.lang.Boolean r7 = com.upuphone.xr.sapp.BuildConfig.b
            java.lang.String r3 = "THIRD_PLATFOM"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r3)
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x0074
            goto L_0x0075
        L_0x0074:
            r0 = r1
        L_0x0075:
            if (r0 == 0) goto L_0x0078
            goto L_0x0079
        L_0x0078:
            r1 = r4
        L_0x0079:
            r2.setVisibility(r1)
            r6.F0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.fragment.MineFragment.E0(com.upuphone.xr.sapp.entity.DeviceState):void");
    }

    public final void F0() {
        DeviceState deviceState = (DeviceState) J0().M().getValue();
        boolean z = true;
        int i = 0;
        boolean z2 = deviceState != null && deviceState.getState() == 2;
        boolean z3 = VuGlassControlModel.f8109a.v().getValue() != null;
        boolean z4 = !K0().j().isEmpty();
        TextView textView = I0().v;
        Intrinsics.checkNotNullExpressionValue(textView, "tvDeviceManage");
        if (!z2 && !z3 && !z4) {
            z = false;
        }
        if (!z) {
            i = 8;
        }
        textView.setVisibility(i);
    }

    public final FragmentMineBinding I0() {
        return (FragmentMineBinding) this.f6982a.getValue();
    }

    public final void L0() {
        LoginFragmentDialog.Companion companion = LoginFragmentDialog.d;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        companion.a(requireActivity);
    }

    public final void M0() {
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        if (bool.booleanValue()) {
            I0().r.setVisibility(8);
        } else {
            I0().r.setVisibility(0);
        }
        I0().q.setOnClickListener(new z6(this));
        I0().i.setOnClickListener(new a7(this));
    }

    public final Drawable V0(String str) {
        Drawable drawable;
        try {
            drawable = Drawable.createFromStream(new URL(str).openStream(), "image.jpg");
        } catch (IOException e2) {
            ULog.f6446a.a("MineFragment", e2.getMessage());
            drawable = null;
        }
        if (drawable == null) {
            ULog.f6446a.a("MineFragment", "null drawable");
        }
        return drawable;
    }

    public final boolean W0() {
        boolean z = !MzAccountManager.c.c();
        boolean z2 = !AccountExt.f7838a.b();
        Boolean bool = BuildConfig.b;
        Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
        return bool.booleanValue() ? z : z || z2;
    }

    public final void X0(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("enable_refresh", false);
        bundle.putString("title", str);
        bundle.putString("url", str2);
        Intent intent = new Intent(requireContext(), ProtocolActivity.class);
        intent.putExtra("data", bundle);
        intent.addFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
        requireContext().startActivity(intent);
    }

    public final void Y0() {
        I0().c.setOnClickListener(new p6(this));
        I0().e.setOnClickListener(new q6(this));
    }

    public final void b1(AccountInfo accountInfo) {
        try {
            I0().getRoot().post(new o6(accountInfo, this));
        } catch (Exception e2) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e2.getMessage();
            delegate.c("MineFragment", "e: " + message);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("MineFragment", "onActivityResult() called with: requestCode = " + i + ", resultCode = " + i2 + ", data = " + intent);
        if (i == 10000 || i == 10001) {
            AccountManager.f8217a.q(i2);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        LinearLayout b2 = I0().getRoot();
        Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
        return b2;
    }

    public void onResume() {
        super.onResume();
        G0();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        D0();
        initView();
        M0();
        E0((DeviceState) J0().M().getValue());
    }
}
