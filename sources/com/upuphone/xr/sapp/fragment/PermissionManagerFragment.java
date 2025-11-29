package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.alibaba.fastjson.asm.Opcodes;
import com.google.gson.Gson;
import com.here.odnp.config.OdnpConfigStatic;
import com.honey.account.h8.a8;
import com.honey.account.h8.c8;
import com.honey.account.h8.d8;
import com.honey.account.h8.e8;
import com.honey.account.h8.f8;
import com.honey.account.h8.g8;
import com.honey.account.h8.h8;
import com.honey.account.h8.i8;
import com.honey.account.h8.j8;
import com.honey.account.h8.k8;
import com.honey.account.h8.l8;
import com.honey.account.h8.s7;
import com.honey.account.h8.t7;
import com.honey.account.h8.u7;
import com.honey.account.h8.v7;
import com.honey.account.h8.w7;
import com.honey.account.h8.x7;
import com.honey.account.h8.y7;
import com.honey.account.h8.z7;
import com.honey.account.view.web.WebJs;
import com.meizu.common.widget.MzButton;
import com.upuphone.ar.tici.phone.utils.StoragePermission;
import com.upuphone.runasone.uupcast.CaptureType;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$3;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$4;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$5;
import com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding;
import com.upuphone.xr.sapp.entity.PermissionManageItem;
import com.upuphone.xr.sapp.entity.PermissionNote;
import com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper;
import com.upuphone.xr.sapp.permission.Permission;
import com.upuphone.xr.sapp.permission.PermissionHelper;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.GenericWindowManger;
import com.upuphone.xr.sapp.utils.HuaWeiFeatureParser;
import com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils;
import com.upuphone.xr.sapp.utils.PermissionManageComparator;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.utils.ViewExtKt;
import com.upuphone.xr.sapp.vm.DeviceControlModel;
import com.upuphone.xr.sapp.vm.SuperViewModel;
import com.xjmz.myvu.dialog.NormalTwoBtnDialog;
import com.xjmz.myvu.ext.ConnectExtKt;
import com.xjsd.ai.assistant.skill.call.util.PopBackgroundPermissionUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000£\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0007*\u0001f\u0018\u0000 j2\u00020\u0001:\u0001kB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0003J!\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0003J\u001f\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u0003J\u000f\u0010\u001c\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u001c\u0010\u0003J'\u0010!\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\rH\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0006H\u0002¢\u0006\u0004\b#\u0010\u0003J\u000f\u0010$\u001a\u00020\u0006H\u0002¢\u0006\u0004\b$\u0010\u0003J\u000f\u0010%\u001a\u00020\u0006H\u0002¢\u0006\u0004\b%\u0010\u0003J\u000f\u0010&\u001a\u00020\u0006H\u0002¢\u0006\u0004\b&\u0010\u0003J\u000f\u0010'\u001a\u00020\u0006H\u0002¢\u0006\u0004\b'\u0010\u0003J\u000f\u0010(\u001a\u00020\u001fH\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u001fH\u0002¢\u0006\u0004\b*\u0010)J\u000f\u0010+\u001a\u00020\u001fH\u0002¢\u0006\u0004\b+\u0010)J\u000f\u0010,\u001a\u00020\u0006H\u0002¢\u0006\u0004\b,\u0010\u0003J\u000f\u0010-\u001a\u00020\u0006H\u0002¢\u0006\u0004\b-\u0010\u0003J\u000f\u0010.\u001a\u00020\u0006H\u0002¢\u0006\u0004\b.\u0010\u0003J\u0017\u00102\u001a\u0002012\u0006\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0006H\u0002¢\u0006\u0004\b4\u0010\u0003J\u000f\u00105\u001a\u00020\u0006H\u0002¢\u0006\u0004\b5\u0010\u0003JK\u0010>\u001a\u00020\u00062\f\u00107\u001a\b\u0012\u0004\u0012\u00020/062\b\u00109\u001a\u0004\u0018\u0001082\u0006\u0010:\u001a\u00020\u00152\n\b\u0002\u0010;\u001a\u0004\u0018\u0001082\u000e\b\u0002\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00060<H\u0002¢\u0006\u0004\b>\u0010?R\u0014\u0010B\u001a\u00020\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u001b\u0010H\u001a\u00020C8BX\u0002¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u001b\u0010M\u001a\u00020I8BX\u0002¢\u0006\f\n\u0004\bJ\u0010E\u001a\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010T\u001a\u00020\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010V\u001a\u00020\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bU\u0010SR\u001b\u0010[\u001a\u00020W8BX\u0002¢\u0006\f\n\u0004\bX\u0010E\u001a\u0004\bY\u0010ZR\u001a\u0010`\u001a\b\u0012\u0004\u0012\u00020]0\\8\u0002X\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u001b\u0010e\u001a\u00020a8BX\u0002¢\u0006\f\n\u0004\bb\u0010E\u001a\u0004\bc\u0010dR\u0016\u0010i\u001a\u00020f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bg\u0010h¨\u0006l"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/PermissionManagerFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onResume", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "", "windowType", "actionType", "a", "(II)V", "c1", "initView", "initListener", "Lcom/upuphone/xr/sapp/permission/Permission;", "permission", "", "hasPermission", "d1", "(Lcom/upuphone/xr/sapp/permission/Permission;ZLandroid/view/View;)V", "Q1", "P1", "h1", "j1", "i1", "H1", "()Z", "n1", "f1", "J1", "K1", "I1", "", "text", "Landroid/text/SpannableString;", "O1", "(Ljava/lang/String;)Landroid/text/SpannableString;", "N1", "g1", "", "permissions", "Lcom/upuphone/xr/sapp/entity/PermissionNote;", "permissionNote", "rejectWindowType", "rejectPermissionNote", "Lkotlin/Function0;", "jumpAction", "L1", "([Ljava/lang/String;Lcom/upuphone/xr/sapp/entity/PermissionNote;ILcom/upuphone/xr/sapp/entity/PermissionNote;Lkotlin/jvm/functions/Function0;)V", "j", "I", "defaultBottomHeight", "Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "k", "Lkotlin/Lazy;", "n0", "()Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "viewModel", "Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "l", "k1", "()Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "mDeviceModel", "Lcom/upuphone/xr/sapp/databinding/FragmentPermissionManagerBinding;", "m", "Lcom/upuphone/xr/sapp/databinding/FragmentPermissionManagerBinding;", "binding", "n", "Z", "userTrigger", "o", "isClearData", "Lcom/upuphone/ar/tici/phone/utils/StoragePermission;", "p", "m1", "()Lcom/upuphone/ar/tici/phone/utils/StoragePermission;", "storagePermission", "", "Lcom/upuphone/xr/sapp/entity/PermissionManageItem;", "q", "Ljava/util/List;", "permissionManageItems", "Lcom/upuphone/xr/sapp/utils/PermissionManageComparator;", "r", "l1", "()Lcom/upuphone/xr/sapp/utils/PermissionManageComparator;", "permissionManageComparator", "com/upuphone/xr/sapp/fragment/PermissionManagerFragment$handler$1", "s", "Lcom/upuphone/xr/sapp/fragment/PermissionManagerFragment$handler$1;", "handler", "t", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nPermissionManagerFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PermissionManagerFragment.kt\ncom/upuphone/xr/sapp/fragment/PermissionManagerFragment\n+ 2 GlobalViewStoreExt.kt\ncom/upuphone/xr/sapp/common/GlobalViewStoreExtKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,905:1\n32#2,12:906\n32#2,12:918\n256#3,2:930\n256#3,2:932\n256#3,2:934\n256#3,2:936\n256#3,2:938\n256#3,2:940\n256#3,2:942\n1855#4,2:944\n*S KotlinDebug\n*F\n+ 1 PermissionManagerFragment.kt\ncom/upuphone/xr/sapp/fragment/PermissionManagerFragment\n*L\n86#1:906,12\n87#1:918,12\n200#1:930,2\n206#1:932,2\n224#1:934,2\n265#1:936,2\n295#1:938,2\n302#1:940,2\n322#1:942,2\n646#1:944,2\n*E\n"})
public final class PermissionManagerFragment extends BaseFragment {
    public static final Companion t = new Companion((DefaultConstructorMarker) null);
    public final int j = StaticMethodUtilsKt.h(32.0f);
    public final Lazy k;
    public final Lazy l;
    public FragmentPermissionManagerBinding m;
    public boolean n;
    public boolean o;
    public final Lazy p;
    public final List q;
    public final Lazy r;
    public PermissionManagerFragment$handler$1 s;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/PermissionManagerFragment$Companion;", "", "()V", "CLEAN_CONTACT_FAILED", "", "NAVI_NOTIFICATION_RESIDENT", "", "NOTIFICATION_RESIDENT", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public PermissionManagerFragment() {
        Class<SuperViewModel> cls = SuperViewModel.class;
        this.k = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls), new GlobalViewStoreExtKt$cachedViewModels$3(cls.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
        Class<DeviceControlModel> cls2 = DeviceControlModel.class;
        this.l = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls2), new GlobalViewStoreExtKt$cachedViewModels$3(cls2.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
        this.p = LazyKt.lazy(new PermissionManagerFragment$storagePermission$2(this));
        this.q = new ArrayList();
        this.r = LazyKt.lazy(PermissionManagerFragment$permissionManageComparator$2.INSTANCE);
        this.s = new PermissionManagerFragment$handler$1(this, Looper.getMainLooper());
    }

    public static final void A1(PermissionManagerFragment permissionManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(permissionManagerFragment, "this$0");
        ULog.f6446a.a("PermissionManagerFragment", "click phoneAndDial");
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding = permissionManagerFragment.m;
        if (fragmentPermissionManagerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPermissionManagerBinding = null;
        }
        if (fragmentPermissionManagerBinding.u.getIconStarted()) {
            StaticMethodUtilsKt.p(permissionManagerFragment);
            return;
        }
        PermissionAndStateCheckUtils permissionAndStateCheckUtils = PermissionAndStateCheckUtils.f7907a;
        String[] q2 = permissionAndStateCheckUtils.q();
        PermissionHelper permissionHelper = PermissionHelper.f7819a;
        Context requireContext = permissionManagerFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        M1(permissionManagerFragment, q2, permissionHelper.e(requireContext, permissionAndStateCheckUtils.q()), 168, (PermissionNote) null, (Function0) null, 24, (Object) null);
    }

    public static final void B1(PermissionManagerFragment permissionManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(permissionManagerFragment, "this$0");
        ULog.f6446a.a("PermissionManagerFragment", "click readContact, ");
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding = permissionManagerFragment.m;
        if (fragmentPermissionManagerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPermissionManagerBinding = null;
        }
        if (fragmentPermissionManagerBinding.w.getIconStarted()) {
            StaticMethodUtilsKt.p(permissionManagerFragment);
            return;
        }
        PermissionAndStateCheckUtils permissionAndStateCheckUtils = PermissionAndStateCheckUtils.f7907a;
        String[] n2 = permissionAndStateCheckUtils.n();
        PermissionHelper permissionHelper = PermissionHelper.f7819a;
        Context requireContext = permissionManagerFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        M1(permissionManagerFragment, n2, permissionHelper.e(requireContext, permissionAndStateCheckUtils.n()), 145, (PermissionNote) null, (Function0) null, 24, (Object) null);
    }

    public static final void C1(PermissionManagerFragment permissionManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(permissionManagerFragment, "this$0");
        ULog.f6446a.a("PermissionManagerFragment", "click callLog");
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding = permissionManagerFragment.m;
        if (fragmentPermissionManagerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPermissionManagerBinding = null;
        }
        if (fragmentPermissionManagerBinding.h.getIconStarted()) {
            StaticMethodUtilsKt.p(permissionManagerFragment);
            return;
        }
        PermissionAndStateCheckUtils permissionAndStateCheckUtils = PermissionAndStateCheckUtils.f7907a;
        String[] m2 = permissionAndStateCheckUtils.m();
        PermissionHelper permissionHelper = PermissionHelper.f7819a;
        Context requireContext = permissionManagerFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        PermissionNote e = permissionHelper.e(requireContext, permissionAndStateCheckUtils.m());
        String string = permissionManagerFragment.getString(R.string.calllog_permission_tittle);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = permissionManagerFragment.getString(R.string.flyme_internal_app_permission_read_call_log_text);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        M1(permissionManagerFragment, m2, e, 2008, new PermissionNote(string, string2), (Function0) null, 16, (Object) null);
    }

    public static final void D1(PermissionManagerFragment permissionManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(permissionManagerFragment, "this$0");
        ULog.f6446a.a("PermissionManagerFragment", "click location, ");
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding = permissionManagerFragment.m;
        if (fragmentPermissionManagerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPermissionManagerBinding = null;
        }
        if (fragmentPermissionManagerBinding.n.getIconStarted()) {
            StaticMethodUtilsKt.p(permissionManagerFragment);
            return;
        }
        PermissionAndStateCheckUtils permissionAndStateCheckUtils = PermissionAndStateCheckUtils.f7907a;
        String[] A = permissionAndStateCheckUtils.A();
        PermissionHelper permissionHelper = PermissionHelper.f7819a;
        Context requireContext = permissionManagerFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        M1(permissionManagerFragment, A, permissionHelper.e(requireContext, permissionAndStateCheckUtils.A()), 146, (PermissionNote) null, (Function0) null, 24, (Object) null);
    }

    public static final void E1(PermissionManagerFragment permissionManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(permissionManagerFragment, "this$0");
        ULog.f6446a.a("PermissionManagerFragment", "click bluetooth, ");
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding = permissionManagerFragment.m;
        if (fragmentPermissionManagerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPermissionManagerBinding = null;
        }
        if (fragmentPermissionManagerBinding.f.getIconStarted()) {
            StaticMethodUtilsKt.p(permissionManagerFragment);
            return;
        }
        PermissionAndStateCheckUtils permissionAndStateCheckUtils = PermissionAndStateCheckUtils.f7907a;
        String[] z = permissionAndStateCheckUtils.z();
        PermissionHelper permissionHelper = PermissionHelper.f7819a;
        Context requireContext = permissionManagerFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        M1(permissionManagerFragment, z, permissionHelper.e(requireContext, permissionAndStateCheckUtils.z()), 147, (PermissionNote) null, (Function0) null, 24, (Object) null);
    }

    public static final void F1(PermissionManagerFragment permissionManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(permissionManagerFragment, "this$0");
        ULog.f6446a.a("PermissionManagerFragment", "click notificationRight, ");
        permissionManagerFragment.K1();
    }

    public static final boolean G1(View view, MotionEvent motionEvent) {
        return true;
    }

    public static /* synthetic */ void M1(PermissionManagerFragment permissionManagerFragment, String[] strArr, PermissionNote permissionNote, int i, PermissionNote permissionNote2, Function0 function0, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            permissionNote2 = null;
        }
        PermissionNote permissionNote3 = permissionNote2;
        if ((i2 & 16) != 0) {
            function0 = new PermissionManagerFragment$requestPermission$1(permissionManagerFragment);
        }
        permissionManagerFragment.L1(strArr, permissionNote, i, permissionNote3, function0);
    }

    private final SpannableString O1(String str) {
        SpannableString spannableString = new SpannableString(str);
        PermissionManagerFragment$setClickSpan$1 permissionManagerFragment$setClickSpan$1 = new PermissionManagerFragment$setClickSpan$1(this);
        String string = getString(R.string.clear_data);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, string, 0, false, 6, (Object) null);
        String string2 = getString(R.string.clear_data);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        spannableString.setSpan(permissionManagerFragment$setClickSpan$1, indexOf$default, StringsKt.indexOf$default((CharSequence) str, string2, 0, false, 6, (Object) null) + getString(R.string.clear_data).length(), 34);
        TextAppearanceSpan textAppearanceSpan = new TextAppearanceSpan(requireContext(), R.style.TextAppearance_AppCompat_BoldLink);
        String string3 = getString(R.string.clear_data);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        int indexOf$default2 = StringsKt.indexOf$default((CharSequence) str, string3, 0, false, 6, (Object) null);
        String string4 = getString(R.string.clear_data);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        spannableString.setSpan(textAppearanceSpan, indexOf$default2, StringsKt.indexOf$default((CharSequence) str, string4, 0, false, 6, (Object) null) + getString(R.string.clear_data).length(), 18);
        return spannableString;
    }

    private final void c1() {
        n0().s().observe(getViewLifecycleOwner(), new PermissionManagerFragment$sam$androidx_lifecycle_Observer$0(new PermissionManagerFragment$addObserver$1(this)));
    }

    public static final boolean e1(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    private final void initListener() {
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding = this.m;
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding2 = null;
        if (fragmentPermissionManagerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPermissionManagerBinding = null;
        }
        fragmentPermissionManagerBinding.q.getBinding().i.setClickable(false);
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding3 = this.m;
        if (fragmentPermissionManagerBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPermissionManagerBinding3 = null;
        }
        fragmentPermissionManagerBinding3.t.setOnClickListener(new s7(this));
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding4 = this.m;
        if (fragmentPermissionManagerBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPermissionManagerBinding4 = null;
        }
        fragmentPermissionManagerBinding4.o.getBinding().j.setOnClickListener(new l8(this));
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding5 = this.m;
        if (fragmentPermissionManagerBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPermissionManagerBinding5 = null;
        }
        fragmentPermissionManagerBinding5.q.setOnClickListener(new t7(this));
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding6 = this.m;
        if (fragmentPermissionManagerBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPermissionManagerBinding6 = null;
        }
        fragmentPermissionManagerBinding6.u.getBinding().j.setOnClickListener(new u7(this));
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding7 = this.m;
        if (fragmentPermissionManagerBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPermissionManagerBinding7 = null;
        }
        fragmentPermissionManagerBinding7.w.getBinding().j.setOnClickListener(new v7(this));
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding8 = this.m;
        if (fragmentPermissionManagerBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPermissionManagerBinding8 = null;
        }
        MzButton mzButton = fragmentPermissionManagerBinding8.h.getBinding().j;
        Intrinsics.checkNotNullExpressionValue(mzButton, "startIcon");
        ViewExtKt.b(mzButton, new w7(this));
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding9 = this.m;
        if (fragmentPermissionManagerBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPermissionManagerBinding9 = null;
        }
        fragmentPermissionManagerBinding9.n.getBinding().j.setOnClickListener(new x7(this));
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding10 = this.m;
        if (fragmentPermissionManagerBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPermissionManagerBinding10 = null;
        }
        fragmentPermissionManagerBinding10.f.getBinding().j.setOnClickListener(new y7(this));
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding11 = this.m;
        if (fragmentPermissionManagerBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPermissionManagerBinding11 = null;
        }
        fragmentPermissionManagerBinding11.r.getBinding().j.setOnClickListener(new z7(this));
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding12 = this.m;
        if (fragmentPermissionManagerBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPermissionManagerBinding12 = null;
        }
        fragmentPermissionManagerBinding12.e.getBinding().j.setOnClickListener(new a8(this));
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding13 = this.m;
        if (fragmentPermissionManagerBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPermissionManagerBinding13 = null;
        }
        fragmentPermissionManagerBinding13.g.getBinding().j.setOnClickListener(new d8(this));
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding14 = this.m;
        if (fragmentPermissionManagerBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPermissionManagerBinding14 = null;
        }
        MzButton mzButton2 = fragmentPermissionManagerBinding14.x.getBinding().j;
        Intrinsics.checkNotNullExpressionValue(mzButton2, "startIcon");
        ViewExtKt.b(mzButton2, new e8(this));
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding15 = this.m;
        if (fragmentPermissionManagerBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPermissionManagerBinding15 = null;
        }
        MzButton mzButton3 = fragmentPermissionManagerBinding15.i.getBinding().j;
        Intrinsics.checkNotNullExpressionValue(mzButton3, "startIcon");
        ViewExtKt.b(mzButton3, new f8(this));
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding16 = this.m;
        if (fragmentPermissionManagerBinding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPermissionManagerBinding16 = null;
        }
        fragmentPermissionManagerBinding16.v.getBinding().j.setOnClickListener(new g8(this));
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding17 = this.m;
        if (fragmentPermissionManagerBinding17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPermissionManagerBinding17 = null;
        }
        fragmentPermissionManagerBinding17.z.getBinding().j.setOnClickListener(new h8(this));
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding18 = this.m;
        if (fragmentPermissionManagerBinding18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPermissionManagerBinding18 = null;
        }
        fragmentPermissionManagerBinding18.k.getBinding().j.setOnClickListener(new i8(this));
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding19 = this.m;
        if (fragmentPermissionManagerBinding19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPermissionManagerBinding19 = null;
        }
        fragmentPermissionManagerBinding19.c.getBinding().j.setOnClickListener(new j8(this));
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding20 = this.m;
        if (fragmentPermissionManagerBinding20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentPermissionManagerBinding2 = fragmentPermissionManagerBinding20;
        }
        fragmentPermissionManagerBinding2.b.getBinding().j.setOnClickListener(new k8(this));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x0532  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x054a  */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x0565  */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x056a  */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x0578  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initView() {
        /*
            r16 = this;
            r0 = r16
            com.upuphone.xr.sapp.utils.DynamicAdapterUtils r1 = com.upuphone.xr.sapp.utils.DynamicAdapterUtils.f7879a
            java.lang.String r1 = r1.a()
            boolean r1 = com.upuphone.xr.sapp.utils.ModelIdExtKt.a(r1)
            java.lang.String r2 = "binding"
            if (r1 == 0) goto L_0x0024
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r1 = r0.m
            if (r1 != 0) goto L_0x0018
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r1 = 0
        L_0x0018:
            com.upuphone.xr.sapp.view.CardItemView r1 = r1.w
            int r4 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_contacts_text
            java.lang.String r4 = r0.getString(r4)
            r1.setCardSubTitle((java.lang.String) r4)
            goto L_0x005f
        L_0x0024:
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r1 = r0.m
            if (r1 != 0) goto L_0x002c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r1 = 0
        L_0x002c:
            com.upuphone.xr.sapp.view.CardItemView r1 = r1.w
            r1.d()
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r1 = r0.m
            if (r1 != 0) goto L_0x0039
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r1 = 0
        L_0x0039:
            com.upuphone.xr.sapp.view.CardItemView r1 = r1.w
            int r4 = com.upuphone.xr.sapp.R.string.read_address_book_note
            java.lang.String r4 = r0.getString(r4)
            java.lang.String r5 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            android.text.SpannableString r4 = r0.O1(r4)
            r1.setCardSubTitle((android.text.SpannableString) r4)
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r1 = r0.m
            if (r1 != 0) goto L_0x0055
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r1 = 0
        L_0x0055:
            androidx.constraintlayout.widget.ConstraintLayout r1 = r1.j
            com.honey.account.h8.b8 r4 = new com.honey.account.h8.b8
            r4.<init>()
            r1.setOnTouchListener(r4)
        L_0x005f:
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r1 = r0.m
            if (r1 != 0) goto L_0x0067
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r1 = 0
        L_0x0067:
            com.upuphone.xr.sapp.view.CardItemView r1 = r1.o
            boolean r4 = r16.n1()
            r1.setStartIconState(r4)
            java.lang.Boolean r1 = com.upuphone.xr.sapp.BuildConfig.b
            java.lang.String r4 = "THIRD_PLATFOM"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            boolean r5 = r1.booleanValue()
            r6 = 1
            r7 = 0
            if (r5 == 0) goto L_0x00d5
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r5 = r0.m
            if (r5 != 0) goto L_0x0087
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r5 = 0
        L_0x0087:
            com.upuphone.xr.sapp.view.CardItemView r5 = r5.o
            int r8 = com.upuphone.xr.sapp.R.string.notification_connect_note
            java.lang.String r8 = r0.getString(r8)
            r5.setCardSubTitle((java.lang.String) r8)
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r5 = r0.m
            if (r5 != 0) goto L_0x009a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r5 = 0
        L_0x009a:
            com.upuphone.xr.sapp.view.CardItemView r5 = r5.q
            int r8 = com.upuphone.xr.sapp.R.string.notification_resident_bar_note
            java.lang.String r8 = r0.getString(r8)
            r5.setCardSubTitle((java.lang.String) r8)
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r5 = r0.m
            if (r5 != 0) goto L_0x00ad
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r5 = 0
        L_0x00ad:
            com.upuphone.xr.sapp.view.CardItemView r5 = r5.q
            com.upuphone.xr.sapp.utils.DataStoreUtils$Companion r8 = com.upuphone.xr.sapp.utils.DataStoreUtils.e
            com.upuphone.xr.sapp.utils.DataStoreUtils r9 = r8.a()
            java.lang.Boolean r11 = java.lang.Boolean.TRUE
            r13 = 4
            r14 = 0
            java.lang.String r10 = "notification_resident"
            r12 = 0
            java.lang.Object r8 = com.upuphone.xr.sapp.utils.DataStoreUtils.i(r9, r10, r11, r12, r13, r14)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x00d0
            boolean r8 = r16.n1()
            if (r8 == 0) goto L_0x00d0
            r8 = r6
            goto L_0x00d1
        L_0x00d0:
            r8 = r7
        L_0x00d1:
            r5.setSwitchState(r8)
            goto L_0x012a
        L_0x00d5:
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r5 = r0.m
            if (r5 != 0) goto L_0x00dd
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r5 = 0
        L_0x00dd:
            com.upuphone.xr.sapp.view.CardItemView r5 = r5.o
            int r8 = com.upuphone.xr.sapp.R.string.notification_note
            java.lang.String r8 = r0.getString(r8)
            r5.setCardSubTitle((java.lang.String) r8)
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r5 = r0.m
            if (r5 != 0) goto L_0x00f0
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r5 = 0
        L_0x00f0:
            com.upuphone.xr.sapp.view.CardItemView r5 = r5.q
            int r8 = com.upuphone.xr.sapp.R.string.notification_resident_bar_navi_note
            java.lang.String r8 = r0.getString(r8)
            r5.setCardSubTitle((java.lang.String) r8)
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r5 = r0.m
            if (r5 != 0) goto L_0x0103
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r5 = 0
        L_0x0103:
            com.upuphone.xr.sapp.view.CardItemView r5 = r5.q
            com.upuphone.xr.sapp.utils.DataStoreUtils$Companion r8 = com.upuphone.xr.sapp.utils.DataStoreUtils.e
            com.upuphone.xr.sapp.utils.DataStoreUtils r9 = r8.a()
            java.lang.Boolean r11 = java.lang.Boolean.TRUE
            r13 = 4
            r14 = 0
            java.lang.String r10 = "navi_notification_resident"
            r12 = 0
            java.lang.Object r8 = com.upuphone.xr.sapp.utils.DataStoreUtils.i(r9, r10, r11, r12, r13, r14)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x0126
            boolean r8 = r16.n1()
            if (r8 == 0) goto L_0x0126
            r8 = r6
            goto L_0x0127
        L_0x0126:
            r8 = r7
        L_0x0127:
            r5.setSwitchState(r8)
        L_0x012a:
            com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils r5 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a
            java.lang.String[] r8 = r5.q()
            boolean r8 = com.upuphone.xr.sapp.utils.StaticMethodUtilsKt.a(r0, r8)
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r9 = r0.m
            if (r9 != 0) goto L_0x013c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r9 = 0
        L_0x013c:
            com.upuphone.xr.sapp.view.CardItemView r9 = r9.u
            r9.setStartIconState(r8)
            com.upuphone.xr.sapp.permission.Permission r9 = com.upuphone.xr.sapp.permission.Permission.CallPhone
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r10 = r0.m
            if (r10 != 0) goto L_0x014b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r10 = 0
        L_0x014b:
            com.upuphone.xr.sapp.view.CardItemView r10 = r10.u
            java.lang.String r11 = "phoneAndDial"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            r0.d1(r9, r8, r10)
            java.lang.String[] r8 = r5.n()
            boolean r8 = com.upuphone.xr.sapp.utils.StaticMethodUtilsKt.a(r0, r8)
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r9 = r0.m
            if (r9 != 0) goto L_0x0165
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r9 = 0
        L_0x0165:
            com.upuphone.xr.sapp.view.CardItemView r9 = r9.w
            r9.setStartIconState(r8)
            com.upuphone.xr.sapp.permission.Permission r9 = com.upuphone.xr.sapp.permission.Permission.ReadContact
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r10 = r0.m
            if (r10 != 0) goto L_0x0174
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r10 = 0
        L_0x0174:
            com.upuphone.xr.sapp.view.CardItemView r10 = r10.w
            java.lang.String r11 = "readContact"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            r0.d1(r9, r8, r10)
            java.lang.Boolean r8 = com.upuphone.xr.sapp.BuildConfig.f6575a
            java.lang.String r9 = "COUNTRY_INTL"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            boolean r9 = r8.booleanValue()
            java.lang.String r10 = "callLog"
            r11 = 8
            if (r9 == 0) goto L_0x01a0
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r9 = r0.m
            if (r9 != 0) goto L_0x0197
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r9 = 0
        L_0x0197:
            com.upuphone.xr.sapp.view.CardItemView r9 = r9.h
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            r9.setVisibility(r11)
            goto L_0x01d7
        L_0x01a0:
            java.lang.String[] r9 = r5.m()
            boolean r9 = com.upuphone.xr.sapp.utils.StaticMethodUtilsKt.a(r0, r9)
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r12 = r0.m
            if (r12 != 0) goto L_0x01b0
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r12 = 0
        L_0x01b0:
            com.upuphone.xr.sapp.view.CardItemView r12 = r12.h
            r12.setStartIconState(r9)
            com.upuphone.xr.sapp.permission.Permission r12 = com.upuphone.xr.sapp.permission.Permission.CallLog
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r13 = r0.m
            if (r13 != 0) goto L_0x01bf
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r13 = 0
        L_0x01bf:
            com.upuphone.xr.sapp.view.CardItemView r13 = r13.h
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r10)
            r0.d1(r12, r9, r13)
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r9 = r0.m
            if (r9 != 0) goto L_0x01cf
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r9 = 0
        L_0x01cf:
            com.upuphone.xr.sapp.view.CardItemView r9 = r9.h
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            r9.setVisibility(r7)
        L_0x01d7:
            boolean r9 = r16.o0()
            if (r9 == 0) goto L_0x01e8
            android.content.Context r9 = r16.requireContext()
            int r10 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_location_text_android_r
            java.lang.String r9 = r9.getString(r10)
            goto L_0x01f2
        L_0x01e8:
            android.content.Context r9 = r16.requireContext()
            int r10 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_location_text
            java.lang.String r9 = r9.getString(r10)
        L_0x01f2:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r10 = r0.m
            if (r10 != 0) goto L_0x01fd
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r10 = 0
        L_0x01fd:
            com.upuphone.xr.sapp.view.CardItemView r10 = r10.n
            r10.setCardSubTitle((java.lang.String) r9)
            boolean r9 = r16.h0()
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r10 = r0.m
            if (r10 != 0) goto L_0x020e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r10 = 0
        L_0x020e:
            com.upuphone.xr.sapp.view.CardItemView r10 = r10.n
            r10.setStartIconState(r9)
            com.upuphone.xr.sapp.permission.Permission r10 = com.upuphone.xr.sapp.permission.Permission.Location
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r12 = r0.m
            if (r12 != 0) goto L_0x021d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r12 = 0
        L_0x021d:
            com.upuphone.xr.sapp.view.CardItemView r12 = r12.n
            java.lang.String r13 = "location"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r13)
            r0.d1(r10, r9, r12)
            com.upuphone.xr.sapp.utils.OSHelper r9 = com.upuphone.xr.sapp.utils.OSHelper.f7904a
            boolean r10 = r9.d()
            java.lang.String r12 = "bluetooth"
            if (r10 != 0) goto L_0x0254
            boolean r10 = r16.g0()
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r13 = r0.m
            if (r13 != 0) goto L_0x023d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r13 = 0
        L_0x023d:
            com.upuphone.xr.sapp.view.CardItemView r13 = r13.f
            r13.setStartIconState(r10)
            com.upuphone.xr.sapp.permission.Permission r13 = com.upuphone.xr.sapp.permission.Permission.Bluetooth
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r14 = r0.m
            if (r14 != 0) goto L_0x024c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r14 = 0
        L_0x024c:
            com.upuphone.xr.sapp.view.CardItemView r14 = r14.f
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r12)
            r0.d1(r13, r10, r14)
        L_0x0254:
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r10 = r0.m
            if (r10 != 0) goto L_0x025c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r10 = 0
        L_0x025c:
            com.upuphone.xr.sapp.view.CardItemView r10 = r10.f
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r12)
            boolean r12 = r9.d()
            r12 = r12 ^ r6
            if (r12 == 0) goto L_0x026a
            r12 = r7
            goto L_0x026b
        L_0x026a:
            r12 = r11
        L_0x026b:
            r10.setVisibility(r12)
            android.content.Context r10 = r16.getContext()
            if (r10 == 0) goto L_0x0279
            boolean r10 = r5.g(r10)
            goto L_0x027a
        L_0x0279:
            r10 = r7
        L_0x027a:
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r12 = r0.m
            if (r12 != 0) goto L_0x0282
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r12 = 0
        L_0x0282:
            com.upuphone.xr.sapp.view.CardItemView r12 = r12.r
            r12.setStartIconState(r10)
            com.upuphone.xr.sapp.permission.Permission r12 = com.upuphone.xr.sapp.permission.Permission.NotificationListener
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r13 = r0.m
            if (r13 != 0) goto L_0x0291
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r13 = 0
        L_0x0291:
            com.upuphone.xr.sapp.view.CardItemView r13 = r13.r
            java.lang.String r14 = "notificationRight"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)
            r0.d1(r12, r10, r13)
            com.upuphone.ar.tici.phone.utils.StoragePermission r10 = r16.m1()
            boolean r10 = r10.e()
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r12 = r0.m
            if (r12 != 0) goto L_0x02ab
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r12 = 0
        L_0x02ab:
            com.upuphone.xr.sapp.view.CardItemView r12 = r12.k
            r12.setStartIconState(r10)
            com.upuphone.xr.sapp.permission.Permission r12 = com.upuphone.xr.sapp.permission.Permission.FileAccess
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r13 = r0.m
            if (r13 != 0) goto L_0x02ba
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r13 = 0
        L_0x02ba:
            com.upuphone.xr.sapp.view.CardItemView r13 = r13.k
            java.lang.String r14 = "fileRead"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)
            r0.d1(r12, r10, r13)
            boolean r10 = r16.H1()
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r12 = r0.m
            if (r12 != 0) goto L_0x02d0
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r12 = 0
        L_0x02d0:
            com.upuphone.xr.sapp.view.CardItemView r12 = r12.e
            r12.setStartIconState(r10)
            com.upuphone.xr.sapp.permission.Permission r12 = com.upuphone.xr.sapp.permission.Permission.Accessibility
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r13 = r0.m
            if (r13 != 0) goto L_0x02df
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r13 = 0
        L_0x02df:
            com.upuphone.xr.sapp.view.CardItemView r13 = r13.e
            java.lang.String r15 = "barrierFree"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r15)
            r0.d1(r12, r10, r13)
            com.upuphone.xr.sapp.vu.utils.ArSpaceUtil r10 = com.upuphone.xr.sapp.vu.utils.ArSpaceUtil.f8089a
            boolean r10 = r10.i()
            if (r10 == 0) goto L_0x02f8
            int r10 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_microphone_vivo_text
            java.lang.String r10 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r10)
            goto L_0x02fe
        L_0x02f8:
            int r10 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_microphone_text
            java.lang.String r10 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r10)
        L_0x02fe:
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r12 = r0.m
            if (r12 != 0) goto L_0x0306
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r12 = 0
        L_0x0306:
            com.upuphone.xr.sapp.view.CardItemView r12 = r12.x
            r12.setCardSubTitle((java.lang.String) r10)
            com.upuphone.xr.sapp.permission.PermissionHelper r10 = com.upuphone.xr.sapp.permission.PermissionHelper.f7819a
            android.content.Context r12 = r16.requireContext()
            java.lang.String r13 = "requireContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r13)
            java.lang.String[] r15 = r5.y()
            boolean r12 = r10.n(r12, r15)
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r15 = r0.m
            if (r15 != 0) goto L_0x0326
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r15 = 0
        L_0x0326:
            com.upuphone.xr.sapp.view.CardItemView r15 = r15.x
            r15.setStartIconState(r12)
            com.upuphone.xr.sapp.permission.Permission r15 = com.upuphone.xr.sapp.permission.Permission.RecordAudio
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r3 = r0.m
            if (r3 != 0) goto L_0x0335
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r3 = 0
        L_0x0335:
            com.upuphone.xr.sapp.view.CardItemView r3 = r3.x
            java.lang.String r11 = "recordAudio"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r11)
            r0.d1(r15, r12, r3)
            android.content.Context r3 = r16.requireContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r13)
            java.lang.String[] r11 = r5.u()
            boolean r3 = r10.n(r3, r11)
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r11 = r0.m
            if (r11 != 0) goto L_0x0356
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r11 = 0
        L_0x0356:
            com.upuphone.xr.sapp.view.CardItemView r11 = r11.i
            r11.setStartIconState(r3)
            com.upuphone.xr.sapp.permission.Permission r11 = com.upuphone.xr.sapp.permission.Permission.Camera
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r12 = r0.m
            if (r12 != 0) goto L_0x0365
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r12 = 0
        L_0x0365:
            com.upuphone.xr.sapp.view.CardItemView r12 = r12.i
            java.lang.String r15 = "camera"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r15)
            r0.d1(r11, r3, r12)
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r3 = r0.m
            if (r3 != 0) goto L_0x0377
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r3 = 0
        L_0x0377:
            com.upuphone.xr.sapp.view.CardItemView r3 = r3.v
            java.lang.String r11 = "photo"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r11)
            boolean r12 = r8.booleanValue()
            r12 = r12 ^ r6
            if (r12 == 0) goto L_0x0387
            r12 = r7
            goto L_0x0389
        L_0x0387:
            r12 = 8
        L_0x0389:
            r3.setVisibility(r12)
            android.content.Context r3 = r16.requireContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r13)
            java.lang.String[] r12 = r5.l()
            boolean r3 = r10.n(r3, r12)
            boolean r9 = r9.e()
            if (r9 == 0) goto L_0x03a8
            int r9 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_storage_text
            java.lang.String r9 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r9)
            goto L_0x03ae
        L_0x03a8:
            int r9 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_media_visual_text
            java.lang.String r9 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r9)
        L_0x03ae:
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r12 = r0.m
            if (r12 != 0) goto L_0x03b6
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r12 = 0
        L_0x03b6:
            com.upuphone.xr.sapp.view.CardItemView r12 = r12.v
            r12.setCardSubTitle((java.lang.String) r9)
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r9 = r0.m
            if (r9 != 0) goto L_0x03c3
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r9 = 0
        L_0x03c3:
            com.upuphone.xr.sapp.view.CardItemView r9 = r9.v
            r9.setStartIconState(r3)
            com.upuphone.xr.sapp.permission.Permission r9 = com.upuphone.xr.sapp.permission.Permission.Album
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r12 = r0.m
            if (r12 != 0) goto L_0x03d2
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r12 = 0
        L_0x03d2:
            com.upuphone.xr.sapp.view.CardItemView r12 = r12.v
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r11)
            r0.d1(r9, r3, r12)
            java.lang.String[] r3 = r5.r()
            boolean r3 = com.upuphone.xr.sapp.utils.StaticMethodUtilsKt.a(r0, r3)
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r9 = r0.m
            if (r9 != 0) goto L_0x03ea
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r9 = 0
        L_0x03ea:
            com.upuphone.xr.sapp.view.CardItemView r9 = r9.g
            r9.setStartIconState(r3)
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r9 = r0.m
            if (r9 != 0) goto L_0x03f7
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r9 = 0
        L_0x03f7:
            com.upuphone.xr.sapp.view.CardItemView r9 = r9.g
            android.content.Context r11 = r16.requireContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r13)
            java.lang.String[] r5 = r5.r()
            com.upuphone.xr.sapp.entity.PermissionNote r5 = r10.e(r11, r5)
            if (r5 == 0) goto L_0x040f
            java.lang.String r5 = r5.getContent()
            goto L_0x0410
        L_0x040f:
            r5 = 0
        L_0x0410:
            r9.setCardSubTitle((java.lang.String) r5)
            com.upuphone.xr.sapp.permission.Permission r5 = com.upuphone.xr.sapp.permission.Permission.Calendar
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r9 = r0.m
            if (r9 != 0) goto L_0x041d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r9 = 0
        L_0x041d:
            com.upuphone.xr.sapp.view.CardItemView r9 = r9.g
            java.lang.String r10 = "calendar"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            r0.d1(r5, r3, r9)
            com.xjsd.ai.assistant.skill.call.util.PopBackgroundPermissionUtil r3 = com.xjsd.ai.assistant.skill.call.util.PopBackgroundPermissionUtil.f8680a
            android.content.Context r5 = r16.requireContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r13)
            boolean r5 = r3.f(r5)
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r9 = r0.m
            if (r9 != 0) goto L_0x043c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r9 = 0
        L_0x043c:
            com.upuphone.xr.sapp.view.CardItemView r9 = r9.b
            r9.setStartIconState(r5)
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r9 = r0.m
            if (r9 != 0) goto L_0x0449
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r9 = 0
        L_0x0449:
            com.upuphone.xr.sapp.view.CardItemView r9 = r9.b
            java.lang.String r10 = "alertWindow"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            boolean r11 = r1.booleanValue()
            if (r11 == 0) goto L_0x045b
            r11 = r7
            goto L_0x045d
        L_0x045b:
            r11 = 8
        L_0x045d:
            r9.setVisibility(r11)
            com.upuphone.xr.sapp.permission.Permission r9 = com.upuphone.xr.sapp.permission.Permission.AlertWindow
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r11 = r0.m
            if (r11 != 0) goto L_0x046a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r11 = 0
        L_0x046a:
            com.upuphone.xr.sapp.view.CardItemView r11 = r11.b
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r10)
            r0.d1(r9, r5, r11)
            android.content.Context r5 = r16.requireContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r13)
            boolean r3 = r3.g(r5)
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r5 = r0.m
            if (r5 != 0) goto L_0x0485
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r5 = 0
        L_0x0485:
            com.upuphone.xr.sapp.view.CardItemView r5 = r5.c
            r5.setStartIconState(r3)
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r5 = r0.m
            if (r5 != 0) goto L_0x0492
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r5 = 0
        L_0x0492:
            com.upuphone.xr.sapp.view.CardItemView r5 = r5.c
            java.lang.String r9 = "appInOverLay"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x04a4
            r1 = r7
            goto L_0x04a6
        L_0x04a4:
            r1 = 8
        L_0x04a6:
            r5.setVisibility(r1)
            com.upuphone.xr.sapp.permission.Permission r1 = com.upuphone.xr.sapp.permission.Permission.AppOverlay
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r4 = r0.m
            if (r4 != 0) goto L_0x04b3
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r4 = 0
        L_0x04b3:
            com.upuphone.xr.sapp.view.CardItemView r4 = r4.c
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r9)
            r0.d1(r1, r3, r4)
            com.upuphone.xr.sapp.utils.PhoneTypeUtils r1 = com.upuphone.xr.sapp.utils.PhoneTypeUtils.f7912a
            boolean r1 = r1.c()
            java.lang.String r3 = "sport"
            if (r1 == 0) goto L_0x050b
            com.upuphone.xr.sapp.monitor.sport.mz.PedoUtil r1 = com.upuphone.xr.sapp.monitor.sport.mz.PedoUtil.f7798a
            android.content.Context r4 = r16.requireContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r13)
            boolean r1 = r1.d(r4)
            if (r1 == 0) goto L_0x050b
            com.upuphone.xr.sapp.utils.HuaWeiFeatureParser r1 = com.upuphone.xr.sapp.utils.HuaWeiFeatureParser.b()
            boolean r1 = r1.g()
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r4 = r0.m
            if (r4 != 0) goto L_0x04e4
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r4 = 0
        L_0x04e4:
            com.upuphone.xr.sapp.view.CardItemView r4 = r4.z
            r4.setStartIconState(r1)
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r4 = r0.m
            if (r4 != 0) goto L_0x04f1
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r4 = 0
        L_0x04f1:
            com.upuphone.xr.sapp.view.CardItemView r4 = r4.z
            r4.setVisibility(r7)
            com.upuphone.xr.sapp.permission.Permission r4 = com.upuphone.xr.sapp.permission.Permission.SportsHealth
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r5 = r0.m
            if (r5 != 0) goto L_0x0500
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r5 = 0
        L_0x0500:
            com.upuphone.xr.sapp.view.CardItemView r5 = r5.z
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r3)
            r0.d1(r4, r1, r5)
            r4 = 8
            goto L_0x052c
        L_0x050b:
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r1 = r0.m
            if (r1 != 0) goto L_0x0513
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r1 = 0
        L_0x0513:
            com.upuphone.xr.sapp.view.CardItemView r1 = r1.z
            r4 = 8
            r1.setVisibility(r4)
            com.upuphone.xr.sapp.permission.Permission r1 = com.upuphone.xr.sapp.permission.Permission.SportsHealth
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r5 = r0.m
            if (r5 != 0) goto L_0x0524
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r5 = 0
        L_0x0524:
            com.upuphone.xr.sapp.view.CardItemView r5 = r5.z
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r3)
            r0.d1(r1, r6, r5)
        L_0x052c:
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 30
            if (r1 < r3) goto L_0x054a
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r1 = r0.m
            if (r1 != 0) goto L_0x053a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r1 = 0
        L_0x053a:
            com.upuphone.xr.sapp.view.CardItemView r1 = r1.k
            android.content.res.Resources r3 = r16.getResources()
            int r5 = com.upuphone.xr.sapp.R.string.file_read_title_new
            java.lang.String r3 = r3.getString(r5)
            r1.setTitleText(r3)
            goto L_0x0561
        L_0x054a:
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r1 = r0.m
            if (r1 != 0) goto L_0x0552
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r1 = 0
        L_0x0552:
            com.upuphone.xr.sapp.view.CardItemView r1 = r1.k
            android.content.res.Resources r3 = r16.getResources()
            int r5 = com.upuphone.xr.sapp.R.string.file_read_title_old
            java.lang.String r3 = r3.getString(r5)
            r1.setTitleText(r3)
        L_0x0561:
            com.upuphone.xr.sapp.databinding.FragmentPermissionManagerBinding r1 = r0.m
            if (r1 != 0) goto L_0x056a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r3 = 0
            goto L_0x056b
        L_0x056a:
            r3 = r1
        L_0x056b:
            com.upuphone.xr.sapp.view.CardItemView r1 = r3.k
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r14)
            boolean r2 = r8.booleanValue()
            r2 = r2 ^ r6
            if (r2 == 0) goto L_0x0578
            goto L_0x0579
        L_0x0578:
            r7 = r4
        L_0x0579:
            r1.setVisibility(r7)
            r16.Q1()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.fragment.PermissionManagerFragment.initView():void");
    }

    /* access modifiers changed from: private */
    public final DeviceControlModel k1() {
        return (DeviceControlModel) this.l.getValue();
    }

    private final SuperViewModel n0() {
        return (SuperViewModel) this.k.getValue();
    }

    public static final void o1(PermissionManagerFragment permissionManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(permissionManagerFragment, "this$0");
        StaticMethodUtilsKt.q(permissionManagerFragment);
    }

    public static final void p1(PermissionManagerFragment permissionManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(permissionManagerFragment, "this$0");
        ULog.f6446a.a("PermissionManagerFragment", "click barrierFree, ");
        permissionManagerFragment.I1();
    }

    public static final void q1(PermissionManagerFragment permissionManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(permissionManagerFragment, "this$0");
        ULog.f6446a.a("PermissionManagerFragment", "click calendar, ");
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding = permissionManagerFragment.m;
        if (fragmentPermissionManagerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPermissionManagerBinding = null;
        }
        if (fragmentPermissionManagerBinding.g.getIconStarted()) {
            StaticMethodUtilsKt.p(permissionManagerFragment);
            return;
        }
        PermissionAndStateCheckUtils permissionAndStateCheckUtils = PermissionAndStateCheckUtils.f7907a;
        String[] r2 = permissionAndStateCheckUtils.r();
        PermissionHelper permissionHelper = PermissionHelper.f7819a;
        Context requireContext = permissionManagerFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        M1(permissionManagerFragment, r2, permissionHelper.e(requireContext, permissionAndStateCheckUtils.r()), Opcodes.IF_ICMPGT, (PermissionNote) null, (Function0) null, 24, (Object) null);
    }

    public static final void r1(PermissionManagerFragment permissionManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(permissionManagerFragment, "this$0");
        ULog.f6446a.a("PermissionManagerFragment", "click recordAudio");
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding = permissionManagerFragment.m;
        if (fragmentPermissionManagerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPermissionManagerBinding = null;
        }
        if (fragmentPermissionManagerBinding.x.getIconStarted()) {
            StaticMethodUtilsKt.p(permissionManagerFragment);
            return;
        }
        PermissionAndStateCheckUtils permissionAndStateCheckUtils = PermissionAndStateCheckUtils.f7907a;
        String[] y = permissionAndStateCheckUtils.y();
        PermissionHelper permissionHelper = PermissionHelper.f7819a;
        Context requireContext = permissionManagerFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        M1(permissionManagerFragment, y, permissionHelper.e(requireContext, permissionAndStateCheckUtils.y()), 200, (PermissionNote) null, (Function0) null, 24, (Object) null);
    }

    public static final void s1(PermissionManagerFragment permissionManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(permissionManagerFragment, "this$0");
        ULog.f6446a.a("PermissionManagerFragment", "click camera");
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding = permissionManagerFragment.m;
        if (fragmentPermissionManagerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPermissionManagerBinding = null;
        }
        if (fragmentPermissionManagerBinding.i.getIconStarted()) {
            StaticMethodUtilsKt.p(permissionManagerFragment);
            return;
        }
        PermissionAndStateCheckUtils permissionAndStateCheckUtils = PermissionAndStateCheckUtils.f7907a;
        String[] u = permissionAndStateCheckUtils.u();
        PermissionHelper permissionHelper = PermissionHelper.f7819a;
        Context requireContext = permissionManagerFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        M1(permissionManagerFragment, u, permissionHelper.e(requireContext, permissionAndStateCheckUtils.u()), 201, (PermissionNote) null, (Function0) null, 24, (Object) null);
    }

    public static final void t1(PermissionManagerFragment permissionManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(permissionManagerFragment, "this$0");
        ULog.f6446a.a("PermissionManagerFragment", "click photo");
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding = permissionManagerFragment.m;
        if (fragmentPermissionManagerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPermissionManagerBinding = null;
        }
        if (fragmentPermissionManagerBinding.v.getIconStarted()) {
            StaticMethodUtilsKt.p(permissionManagerFragment);
            return;
        }
        PermissionAndStateCheckUtils permissionAndStateCheckUtils = PermissionAndStateCheckUtils.f7907a;
        String[] l2 = permissionAndStateCheckUtils.l();
        PermissionHelper permissionHelper = PermissionHelper.f7819a;
        Context requireContext = permissionManagerFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        M1(permissionManagerFragment, l2, permissionHelper.e(requireContext, permissionAndStateCheckUtils.l()), 164, (PermissionNote) null, (Function0) null, 24, (Object) null);
    }

    public static final void u1(PermissionManagerFragment permissionManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(permissionManagerFragment, "this$0");
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding = permissionManagerFragment.m;
        if (fragmentPermissionManagerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPermissionManagerBinding = null;
        }
        if (fragmentPermissionManagerBinding.z.getIconStarted()) {
            NormalTwoBtnDialog.Companion companion = NormalTwoBtnDialog.k;
            FragmentActivity requireActivity = permissionManagerFragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
            String string = permissionManagerFragment.getString(R.string.close_huawei_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String string2 = permissionManagerFragment.getString(R.string.close_huawei_content);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            String string3 = permissionManagerFragment.getString(R.string.btn_close);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            String string4 = permissionManagerFragment.getString(R.string.cancel);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            NormalTwoBtnDialog.Companion.b(companion, requireActivity, string, string2, string3, string4, new PermissionManagerFragment$initListener$15$1(permissionManagerFragment), (Function0) null, (Function0) null, false, false, OdnpConfigStatic.UPLOAD_MEDIUM_PRIORITY_DURATION_MINUTES, (Object) null);
            return;
        }
        HuaWeiFeatureParser.b().i(permissionManagerFragment.requireActivity());
    }

    public static final void v1(PermissionManagerFragment permissionManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(permissionManagerFragment, "this$0");
        ULog.f6446a.a("PermissionManagerFragment", "click fileRead, ");
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding = permissionManagerFragment.m;
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding2 = null;
        if (fragmentPermissionManagerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPermissionManagerBinding = null;
        }
        if (!fragmentPermissionManagerBinding.k.getIconStarted()) {
            permissionManagerFragment.m1().j();
        } else if (Build.VERSION.SDK_INT >= 30) {
            FragmentPermissionManagerBinding fragmentPermissionManagerBinding3 = permissionManagerFragment.m;
            if (fragmentPermissionManagerBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentPermissionManagerBinding2 = fragmentPermissionManagerBinding3;
            }
            fragmentPermissionManagerBinding2.k.setTitleText(permissionManagerFragment.getResources().getString(R.string.file_read_title_new));
            permissionManagerFragment.requireContext().startActivity(new Intent("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION"));
        } else {
            StaticMethodUtilsKt.p(permissionManagerFragment);
        }
    }

    public static final void w1(PermissionManagerFragment permissionManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(permissionManagerFragment, "this$0");
        PopBackgroundPermissionUtil popBackgroundPermissionUtil = PopBackgroundPermissionUtil.f8680a;
        FragmentActivity requireActivity = permissionManagerFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        popBackgroundPermissionUtil.m(requireActivity, 10086);
    }

    public static final void x1(PermissionManagerFragment permissionManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(permissionManagerFragment, "this$0");
        PopBackgroundPermissionUtil popBackgroundPermissionUtil = PopBackgroundPermissionUtil.f8680a;
        FragmentActivity requireActivity = permissionManagerFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        popBackgroundPermissionUtil.m(requireActivity, 10086);
    }

    public static final void y1(PermissionManagerFragment permissionManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(permissionManagerFragment, "this$0");
        ULog.Delegate delegate = ULog.f6446a;
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding = permissionManagerFragment.m;
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding2 = null;
        if (fragmentPermissionManagerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPermissionManagerBinding = null;
        }
        delegate.a("PermissionManagerFragment", "click notification, iconStarted: " + fragmentPermissionManagerBinding.o.getIconStarted() + " ");
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding3 = permissionManagerFragment.m;
        if (fragmentPermissionManagerBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentPermissionManagerBinding2 = fragmentPermissionManagerBinding3;
        }
        if (fragmentPermissionManagerBinding2.o.getIconStarted()) {
            StaticMethodUtilsKt.p(permissionManagerFragment);
        } else if (Build.VERSION.SDK_INT >= 33) {
            M1(permissionManagerFragment, new String[]{"android.permission.POST_NOTIFICATIONS"}, (PermissionNote) null, 142, (PermissionNote) null, new PermissionManagerFragment$initListener$2$1(permissionManagerFragment), 8, (Object) null);
        } else {
            StaticMethodUtilsKt.C(permissionManagerFragment, CollectionsKt.arrayListOf(101), false, false);
        }
    }

    public static final void z1(PermissionManagerFragment permissionManagerFragment, View view) {
        Intrinsics.checkNotNullParameter(permissionManagerFragment, "this$0");
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding = permissionManagerFragment.m;
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding2 = null;
        if (fragmentPermissionManagerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPermissionManagerBinding = null;
        }
        boolean isChecked = fragmentPermissionManagerBinding.q.getBinding().i.isChecked();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("PermissionManagerFragment", "click notificationResidentBar switch， isChecked: " + isChecked + "， userTrigger： " + permissionManagerFragment.n + " ");
        if (!isChecked) {
            FragmentPermissionManagerBinding fragmentPermissionManagerBinding3 = permissionManagerFragment.m;
            if (fragmentPermissionManagerBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentPermissionManagerBinding3 = null;
            }
            if (!fragmentPermissionManagerBinding3.o.getIconStarted()) {
                UToast.Companion companion = UToast.f6444a;
                Context requireContext = permissionManagerFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                companion.b(requireContext, R.string.enable_notification_right_first);
                return;
            }
            delegate.a("PermissionManagerFragment", "NOTIFICATION_RESIDENT true ");
            FragmentPermissionManagerBinding fragmentPermissionManagerBinding4 = permissionManagerFragment.m;
            if (fragmentPermissionManagerBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentPermissionManagerBinding2 = fragmentPermissionManagerBinding4;
            }
            fragmentPermissionManagerBinding2.q.getBinding().i.setChecked(true);
            Boolean bool = BuildConfig.b;
            Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
            if (!bool.booleanValue()) {
                permissionManagerFragment.j1();
            } else if (ConnectExtKt.a() != null) {
                permissionManagerFragment.P1();
            }
        } else {
            StaticMethodUtilsKt.I(permissionManagerFragment, CollectionsKt.arrayListOf(Integer.valueOf(Opcodes.IF_ICMPEQ)), false, false, 6, (Object) null);
        }
    }

    public final boolean H1() {
        int i;
        String string;
        try {
            i = Settings.Secure.getInt(requireContext().getContentResolver(), "accessibility_enabled");
        } catch (Settings.SettingNotFoundException e) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e.getMessage();
            delegate.g("PermissionManagerFragment", "错误信息为：" + message);
            i = 0;
        }
        if (i != 1 || (string = Settings.Secure.getString(requireContext().getContentResolver(), "enabled_accessibility_services")) == null) {
            return false;
        }
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String lowerCase = string.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String packageName = requireContext().getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        String lowerCase2 = packageName.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        return StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) lowerCase2, false, 2, (Object) null);
    }

    public final void I1() {
        try {
            Intent intent = new Intent("android.settings.ACCESSIBILITY_SETTINGS");
            intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
            startActivity(intent);
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.o("PermissionManagerFragment", "jumpBarrierPage e:" + e);
            StaticMethodUtilsKt.p(this);
        }
    }

    public final void J1() {
        Intent intent = new Intent();
        try {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", requireContext().getPackageName());
            requireContext().startActivity(intent);
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.o("PermissionManagerFragment", "jumpNotificationPage e:" + e);
            StaticMethodUtilsKt.p(this);
        }
    }

    public final void K1() {
        try {
            startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.o("PermissionManagerFragment", "jumpNotifyListenerPage e:" + e);
            StaticMethodUtilsKt.p(this);
        }
    }

    public final void L1(String[] strArr, PermissionNote permissionNote, int i, PermissionNote permissionNote2, Function0 function0) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new PermissionManagerFragment$requestPermission$2(strArr, permissionNote, activity, i, permissionNote2, function0, (Continuation<? super PermissionManagerFragment$requestPermission$2>) null), 3, (Object) null);
        }
    }

    public final void N1() {
        ULog.f6446a.g("PermissionManagerFragment", "send clean message");
        StarryMessageHelper starryMessageHelper = StarryMessageHelper.f7799a;
        String json = new Gson().toJson((Object) MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "system"), TuplesKt.to("data", MapsKt.hashMapOf(TuplesKt.to(WebJs.ACTION, "contact_clean")))));
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        StarryMessageHelper.r(starryMessageHelper, json, (byte[]) null, (SendMessageListener) null, (String) null, 14, (Object) null);
    }

    public final void P1() {
        MainApplication.k.k(false);
        DataStoreUtils.e.a().o("notification_resident", Boolean.TRUE);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        StaticMethodUtilsKt.V(requireContext);
    }

    public final void Q1() {
        CollectionsKt.sortWith(this.q, l1());
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding = this.m;
        if (fragmentPermissionManagerBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentPermissionManagerBinding = null;
        }
        fragmentPermissionManagerBinding.l.removeAllViews();
        for (PermissionManageItem permissionManageItem : this.q) {
            FragmentPermissionManagerBinding fragmentPermissionManagerBinding2 = this.m;
            if (fragmentPermissionManagerBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentPermissionManagerBinding2 = null;
            }
            fragmentPermissionManagerBinding2.l.addView(permissionManageItem.getView());
        }
    }

    public void a(int i, int i2) {
        FragmentPermissionManagerBinding fragmentPermissionManagerBinding = null;
        if (i2 == 1101) {
            if (i == 142) {
                J1();
            } else if (i == 144) {
                StaticMethodUtilsKt.p(this);
            } else if (i == 159) {
                FragmentPermissionManagerBinding fragmentPermissionManagerBinding2 = this.m;
                if (fragmentPermissionManagerBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    fragmentPermissionManagerBinding = fragmentPermissionManagerBinding2;
                }
                fragmentPermissionManagerBinding.q.getBinding().i.setChecked(false);
                Boolean bool = BuildConfig.b;
                Intrinsics.checkNotNullExpressionValue(bool, "THIRD_PLATFOM");
                if (bool.booleanValue()) {
                    h1();
                } else {
                    i1();
                }
            }
        } else if (i == 159) {
            FragmentPermissionManagerBinding fragmentPermissionManagerBinding3 = this.m;
            if (fragmentPermissionManagerBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentPermissionManagerBinding = fragmentPermissionManagerBinding3;
            }
            fragmentPermissionManagerBinding.q.setSwitchState(true);
        }
    }

    public final void d1(Permission permission, boolean z, View view) {
        this.q.removeIf(new c8(new PermissionManagerFragment$addPermissionManageItem$1(permission)));
        this.q.add(new PermissionManageItem(permission, z, view));
    }

    public final boolean f1() {
        return NotificationManagerCompat.g(MainApplication.k.f()).a();
    }

    public final void g1() {
        ULog.f6446a.g("PermissionManagerFragment", "cleanContactFailed");
        GenericWindowManger.c.a().j(Opcodes.IF_ACMPNE);
        UToast.Companion companion = UToast.f6444a;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        companion.b(requireContext, R.string.clean_contact_failed);
    }

    public final void h1() {
        DataStoreUtils.e.a().o("notification_resident", Boolean.FALSE);
        Intent intent = new Intent("clear_notification");
        intent.putExtra("close_by_permission", true);
        requireContext().sendBroadcast(intent);
    }

    public final void i1() {
        DataStoreUtils.e.a().o("navi_notification_resident", Boolean.FALSE);
        Intent intent = new Intent("navi_background_notification");
        intent.putExtra("enable", false);
        requireContext().sendBroadcast(intent);
    }

    public final void j1() {
        DataStoreUtils.e.a().o("navi_notification_resident", Boolean.TRUE);
        Intent intent = new Intent("navi_background_notification");
        intent.putExtra("enable", true);
        requireContext().sendBroadcast(intent);
    }

    public final PermissionManageComparator l1() {
        return (PermissionManageComparator) this.r.getValue();
    }

    public final StoragePermission m1() {
        return (StoragePermission) this.p.getValue();
    }

    public final boolean n1() {
        return Build.VERSION.SDK_INT >= 33 ? StaticMethodUtilsKt.b(this, "android.permission.POST_NOTIFICATIONS") : f1();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentPermissionManagerBinding c = FragmentPermissionManagerBinding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.m = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        return c.getRoot();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.s.removeCallbacksAndMessages((Object) null);
    }

    public void onResume() {
        super.onResume();
        ULog.f6446a.g("PermissionManagerFragment", "onResume");
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new PermissionManagerFragment$onResume$1(this, (Continuation<? super PermissionManagerFragment$onResume$1>) null), 3, (Object) null);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initListener();
        c1();
    }
}
