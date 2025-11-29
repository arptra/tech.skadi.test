package com.upuphone.xr.sapp.guide.wifi;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.LinearGradient;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import com.honey.account.l8.a;
import com.honey.account.l8.b;
import com.honey.account.l8.c;
import com.honey.account.l8.d;
import com.honey.account.l8.e;
import com.honey.account.l8.f;
import com.honey.account.l8.g;
import com.honey.account.view.web.WebJs;
import com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager;
import com.upuphone.runasone.uupcast.CaptureType;
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
import com.upuphone.xr.sapp.databinding.FragmentWifiSettingBinding;
import com.upuphone.xr.sapp.fragment.BaseFragment;
import com.upuphone.xr.sapp.glass.GlassHelper;
import com.upuphone.xr.sapp.guide.adapter.WifiListAdapter;
import com.upuphone.xr.sapp.guide.model.PasswordInfo;
import com.upuphone.xr.sapp.guide.model.WifiInfoModel;
import com.upuphone.xr.sapp.guide.wifi.utils.CustomLinearLayoutManager;
import com.upuphone.xr.sapp.guide.wifi.utils.WifiErrorUtils;
import com.upuphone.xr.sapp.utils.CastExtKt;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.PhoneTypeUtils;
import com.upuphone.xr.sapp.utils.SingleLiveData;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.vm.DeviceControlModel;
import com.upuphone.xr.sapp.vm.SuperViewModel;
import com.upuphone.xr.sapp.vm.WifiViewModel;
import com.upuphone.xr.sapp.vm.internal.SuperMessageManger;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import flyme.support.v7.widget.MzRecyclerView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.runtime.internal.Conversions;
import org.aspectj.runtime.reflect.Factory;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0010\n\u0002\u0010!\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\b\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002rv\u0018\u0000 ~2\u00020\u00012\u00020\u0002:\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0004J7\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0017¢\u0006\u0004\b\u001f\u0010 J!\u0010$\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00182\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b$\u0010%J\u001f\u0010'\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u0018H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u001cH\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0007H\u0002¢\u0006\u0004\b,\u0010\u0004J\u000f\u0010-\u001a\u00020\u0007H\u0002¢\u0006\u0004\b-\u0010\u0004J\u000f\u0010.\u001a\u00020\u0007H\u0002¢\u0006\u0004\b.\u0010\u0004J\u0017\u00100\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u001cH\u0002¢\u0006\u0004\b0\u0010+J\u000f\u00101\u001a\u00020\u0007H\u0002¢\u0006\u0004\b1\u0010\u0004J\u000f\u00102\u001a\u00020\u0007H\u0002¢\u0006\u0004\b2\u0010\u0004J\u001d\u00105\u001a\u00020\u00072\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u001a03H\u0002¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u0007H\u0002¢\u0006\u0004\b7\u0010\u0004J!\u0010:\u001a\u00020\u00072\b\u00108\u001a\u0004\u0018\u00010\u00162\u0006\u00109\u001a\u00020\u0018H\u0002¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u0007H\u0002¢\u0006\u0004\b<\u0010\u0004J'\u0010=\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u00020\u0007H\u0002¢\u0006\u0004\b?\u0010\u0004J\u001f\u0010@\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b@\u0010AJ\u0017\u0010C\u001a\u00020\u00072\u0006\u0010#\u001a\u00020BH\u0002¢\u0006\u0004\bC\u0010DJ\u000f\u0010E\u001a\u00020\u0007H\u0002¢\u0006\u0004\bE\u0010\u0004J\u0017\u0010F\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001cH\u0002¢\u0006\u0004\bF\u0010+J\u000f\u0010G\u001a\u00020\u0007H\u0002¢\u0006\u0004\bG\u0010\u0004R\u0016\u0010K\u001a\u00020H8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u001b\u0010U\u001a\u00020P8BX\u0002¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR\u001b\u0010Z\u001a\u00020V8BX\u0002¢\u0006\f\n\u0004\bW\u0010R\u001a\u0004\bX\u0010YR\u001b\u0010_\u001a\u00020[8BX\u0002¢\u0006\f\n\u0004\b\\\u0010R\u001a\u0004\b]\u0010^R\u0018\u0010b\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010e\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010h\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010l\u001a\u00020i8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010n\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bm\u0010dR\u0016\u0010q\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u0014\u0010u\u001a\u00020r8\u0002X\u0004¢\u0006\u0006\n\u0004\bs\u0010tR\u0014\u0010y\u001a\u00020v8\u0002X\u0004¢\u0006\u0006\n\u0004\bw\u0010xR\u0014\u0010}\u001a\u00020z8\u0002X\u0004¢\u0006\u0006\n\u0004\b{\u0010|¨\u0006\u0001"}, d2 = {"Lcom/upuphone/xr/sapp/guide/wifi/WifiSettingFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "Lcom/upuphone/xr/sapp/guide/adapter/WifiListAdapter$IWifiListClickCallback;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onDestroyView", "", "action", "", "position", "Lcom/upuphone/xr/sapp/guide/model/WifiInfoModel;", "info", "", "refresh", "connect", "wifiClickCallback", "(Ljava/lang/String;ILcom/upuphone/xr/sapp/guide/model/WifiInfoModel;ZZ)V", "windowType", "", "data", "c", "(ILjava/lang/Object;)V", "actionType", "a", "(II)V", "isChecked", "e1", "(Z)V", "v1", "t1", "n1", "wifiState", "b1", "y1", "initView", "", "list", "c1", "(Ljava/util/List;)V", "m1", "change", "errorCode", "k1", "(Ljava/lang/String;I)V", "x1", "A1", "(Ljava/lang/String;ILcom/upuphone/xr/sapp/guide/model/WifiInfoModel;)Z", "l1", "z1", "(Lcom/upuphone/xr/sapp/guide/model/WifiInfoModel;I)V", "Lcom/upuphone/xr/sapp/guide/model/PasswordInfo;", "f1", "(Lcom/upuphone/xr/sapp/guide/model/PasswordInfo;)V", "Z0", "g1", "u1", "Lcom/upuphone/xr/sapp/databinding/FragmentWifiSettingBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentWifiSettingBinding;", "binding", "Lcom/upuphone/xr/sapp/guide/adapter/WifiListAdapter;", "k", "Lcom/upuphone/xr/sapp/guide/adapter/WifiListAdapter;", "mWifiListAdapter", "Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "l", "Lkotlin/Lazy;", "i1", "()Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "mSuperViewModel", "Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "m", "h1", "()Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "mDeviceModel", "Lcom/upuphone/xr/sapp/vm/WifiViewModel;", "n", "j1", "()Lcom/upuphone/xr/sapp/vm/WifiViewModel;", "mWifiViewModel", "o", "Lcom/upuphone/xr/sapp/guide/model/PasswordInfo;", "mCurrentConnectWifiInfo", "p", "I", "mCurrentConnectWifiPosition", "q", "Lcom/upuphone/xr/sapp/guide/model/WifiInfoModel;", "mInfo", "", "r", "J", "mRequestWifiListTime", "s", "mRetryTime", "t", "Z", "mRetryAutoConnect", "com/upuphone/xr/sapp/guide/wifi/WifiSettingFragment$connectListener$1", "u", "Lcom/upuphone/xr/sapp/guide/wifi/WifiSettingFragment$connectListener$1;", "connectListener", "com/upuphone/xr/sapp/guide/wifi/WifiSettingFragment$mSwitchCallback$1", "v", "Lcom/upuphone/xr/sapp/guide/wifi/WifiSettingFragment$mSwitchCallback$1;", "mSwitchCallback", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "w", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "mSwitchAutoCallback", "x", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nWifiSettingFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WifiSettingFragment.kt\ncom/upuphone/xr/sapp/guide/wifi/WifiSettingFragment\n+ 2 GlobalViewStoreExt.kt\ncom/upuphone/xr/sapp/common/GlobalViewStoreExtKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,735:1\n32#2,12:736\n32#2,12:748\n32#2,12:760\n256#3,2:772\n256#3,2:774\n256#3,2:776\n256#3,2:778\n1855#4,2:780\n*S KotlinDebug\n*F\n+ 1 WifiSettingFragment.kt\ncom/upuphone/xr/sapp/guide/wifi/WifiSettingFragment\n*L\n75#1:736,12\n76#1:748,12\n77#1:760,12\n389#1:772,2\n390#1:774,2\n434#1:776,2\n435#1:778,2\n458#1:780,2\n*E\n"})
public final class WifiSettingFragment extends BaseFragment implements WifiListAdapter.IWifiListClickCallback {
    public static final Companion x = new Companion((DefaultConstructorMarker) null);
    public static final Handler y = new Handler(Looper.getMainLooper());
    public static /* synthetic */ JoinPoint.StaticPart z;
    public FragmentWifiSettingBinding j;
    public WifiListAdapter k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public PasswordInfo o;
    public int p = -1;
    public WifiInfoModel q;
    public long r;
    public int s;
    public boolean t;
    public final WifiSettingFragment$connectListener$1 u = new WifiSettingFragment$connectListener$1(this);
    public final WifiSettingFragment$mSwitchCallback$1 v = new WifiSettingFragment$mSwitchCallback$1(this);
    public final CompoundButton.OnCheckedChangeListener w = new a(this);

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/upuphone/xr/sapp/guide/wifi/WifiSettingFragment$Companion;", "", "<init>", "()V", "Landroid/os/Handler;", "mDelayHandler", "Landroid/os/Handler;", "a", "()Landroid/os/Handler;", "getMDelayHandler$annotations", "", "AUTO_REQUEST_WIFI_LIST_TIME", "J", "REQUEST_WIFI_LIST_TIMEOUT", "", "TAG", "Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Handler a() {
            return WifiSettingFragment.y;
        }

        public Companion() {
        }
    }

    static {
        a1();
    }

    public WifiSettingFragment() {
        Class<SuperViewModel> cls = SuperViewModel.class;
        this.l = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls), new GlobalViewStoreExtKt$cachedViewModels$3(cls.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
        Class<DeviceControlModel> cls2 = DeviceControlModel.class;
        this.m = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls2), new GlobalViewStoreExtKt$cachedViewModels$3(cls2.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
        Class<WifiViewModel> cls3 = WifiViewModel.class;
        this.n = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls3), new GlobalViewStoreExtKt$cachedViewModels$3(cls3.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
    }

    public static final /* synthetic */ void B1(WifiSettingFragment wifiSettingFragment, String str, int i, WifiInfoModel wifiInfoModel, boolean z2, boolean z3, JoinPoint joinPoint) {
        Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
        Intrinsics.checkNotNullParameter(wifiInfoModel, "info");
        ULog.f6446a.a("WifiSettingFragment", "do clickCallback");
        if (z3) {
            UToast.Companion companion = UToast.f6444a;
            Context requireContext = wifiSettingFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            String string = wifiSettingFragment.getString(R.string.wait_wifi_connect);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.d(requireContext, string);
        } else if (z2) {
            UToast.Companion companion2 = UToast.f6444a;
            Context requireContext2 = wifiSettingFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
            String string2 = wifiSettingFragment.getString(R.string.wait_wifi_connect);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            companion2.d(requireContext2, string2);
        } else if (!wifiSettingFragment.A1(str, i, wifiInfoModel)) {
            int hashCode = str.hashCode();
            if (hashCode != -1190396462) {
                if (hashCode != 391582084) {
                    if (hashCode == 951351530 && str.equals("connect")) {
                        wifiSettingFragment.z1(wifiInfoModel, i);
                    }
                } else if (str.equals("action_research")) {
                    wifiSettingFragment.s = 0;
                    y.removeCallbacksAndMessages((Object) null);
                    WifiListAdapter wifiListAdapter = wifiSettingFragment.k;
                    if (wifiListAdapter != null) {
                        wifiListAdapter.G();
                    }
                    wifiSettingFragment.v1();
                }
            } else if (str.equals("ignore")) {
                WifiListAdapter wifiListAdapter2 = wifiSettingFragment.k;
                if (wifiListAdapter2 == null || !wifiListAdapter2.u()) {
                    WifiListAdapter wifiListAdapter3 = wifiSettingFragment.k;
                    if (wifiListAdapter3 == null || !wifiListAdapter3.t()) {
                        SuperMessageManger.m.a().g0(wifiInfoModel.getSSid(), "", "req_change_wifi_state", "2");
                        return;
                    }
                    UToast.Companion companion3 = UToast.f6444a;
                    Context requireContext3 = wifiSettingFragment.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext(...)");
                    String string3 = wifiSettingFragment.getString(R.string.wait_wifi_connect);
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    companion3.d(requireContext3, string3);
                    return;
                }
                UToast.Companion companion4 = UToast.f6444a;
                Context requireContext4 = wifiSettingFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext4, "requireContext(...)");
                String string4 = wifiSettingFragment.getString(R.string.wait_wifi_connect);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                companion4.d(requireContext4, string4);
            }
        }
    }

    public static final /* synthetic */ void C1(WifiSettingFragment wifiSettingFragment, String str, int i, WifiInfoModel wifiInfoModel, boolean z2, boolean z3, JoinPoint joinPoint, ConnectCheckAspect connectCheckAspect, ProceedingJoinPoint proceedingJoinPoint) {
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        if (AspectHelper.INSTANCE.getDeviceConnect()) {
            B1(wifiSettingFragment, str, i, wifiInfoModel, z2, z3, proceedingJoinPoint);
            return;
        }
        UToast.Companion companion = UToast.f6444a;
        MainApplication.Companion companion2 = MainApplication.k;
        MainApplication f = companion2.f();
        String string = companion2.f().getString(R.string.device_disconnect);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.d(f, string);
    }

    public static final /* synthetic */ void E1(WifiSettingFragment wifiSettingFragment, String str, int i, WifiInfoModel wifiInfoModel, boolean z2, boolean z3, JoinPoint joinPoint, FastClickAspect fastClickAspect, ProceedingJoinPoint proceedingJoinPoint) {
        FastClickCheck fastClickCheck;
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        Signature signature = proceedingJoinPoint.getSignature();
        Intrinsics.checkNotNull(signature, "null cannot be cast to non-null type org.aspectj.lang.reflect.MethodSignature");
        Method method = ((MethodSignature) signature).getMethod();
        Class cls = FastClickCheck.class;
        if (!method.isAnnotationPresent(cls) || (fastClickCheck = (FastClickCheck) method.getAnnotation(cls)) == null || !fastClickAspect.isFastClick(fastClickCheck.interval())) {
            C1(wifiSettingFragment, str, i, wifiInfoModel, z2, z3, proceedingJoinPoint, ConnectCheckAspect.aspectOf(), (ProceedingJoinPoint) proceedingJoinPoint);
        } else {
            ULog.f6446a.a("FastClickViewAspect", "fast double click,break");
        }
    }

    private final void Z0() {
        h1().L().observe(getViewLifecycleOwner(), new WifiSettingFragment$sam$androidx_lifecycle_Observer$0(new WifiSettingFragment$addObserve$1(this)));
    }

    private static /* synthetic */ void a1() {
        Factory factory = new Factory("WifiSettingFragment.kt", WifiSettingFragment.class);
        z = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("1", "wifiClickCallback", "com.upuphone.xr.sapp.guide.wifi.WifiSettingFragment", "java.lang.String:int:com.upuphone.xr.sapp.guide.model.WifiInfoModel:boolean:boolean", "action:position:info:refresh:connect", "", "void"), 0);
    }

    public static final void d1(WifiSettingFragment wifiSettingFragment) {
        WifiListAdapter wifiListAdapter;
        Intrinsics.checkNotNullParameter(wifiSettingFragment, "this$0");
        WifiListAdapter wifiListAdapter2 = wifiSettingFragment.k;
        if (wifiListAdapter2 != null && !wifiListAdapter2.t() && (wifiListAdapter = wifiSettingFragment.k) != null && !wifiListAdapter.u()) {
            WifiListAdapter wifiListAdapter3 = wifiSettingFragment.k;
            if (wifiListAdapter3 != null) {
                wifiListAdapter3.H(true);
            }
            WifiListAdapter wifiListAdapter4 = wifiSettingFragment.k;
            if (wifiListAdapter4 != null) {
                wifiListAdapter4.notifyDataSetChanged();
            }
            wifiSettingFragment.v1();
        }
    }

    /* access modifiers changed from: private */
    public final void g1(boolean z2) {
        FragmentWifiSettingBinding fragmentWifiSettingBinding = null;
        if (z2) {
            FragmentWifiSettingBinding fragmentWifiSettingBinding2 = this.j;
            if (fragmentWifiSettingBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentWifiSettingBinding = fragmentWifiSettingBinding2;
            }
            fragmentWifiSettingBinding.f.setAlpha(1.0f);
            return;
        }
        FragmentWifiSettingBinding fragmentWifiSettingBinding3 = this.j;
        if (fragmentWifiSettingBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentWifiSettingBinding = fragmentWifiSettingBinding3;
        }
        fragmentWifiSettingBinding.f.setAlpha(0.5f);
    }

    private final DeviceControlModel h1() {
        return (DeviceControlModel) this.m.getValue();
    }

    /* access modifiers changed from: private */
    public final SuperViewModel i1() {
        return (SuperViewModel) this.l.getValue();
    }

    private final void initView() {
        CustomLinearLayoutManager customLinearLayoutManager = new CustomLinearLayoutManager(requireContext());
        FragmentWifiSettingBinding fragmentWifiSettingBinding = this.j;
        FragmentWifiSettingBinding fragmentWifiSettingBinding2 = null;
        if (fragmentWifiSettingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentWifiSettingBinding = null;
        }
        fragmentWifiSettingBinding.h.setLayoutManager(customLinearLayoutManager);
        customLinearLayoutManager.setSmoothScrollbarEnabled(true);
        this.k = new WifiListAdapter(customLinearLayoutManager, this, this.v, this.w);
        FragmentWifiSettingBinding fragmentWifiSettingBinding3 = this.j;
        if (fragmentWifiSettingBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentWifiSettingBinding3 = null;
        }
        fragmentWifiSettingBinding3.h.setAdapter(this.k);
        FragmentWifiSettingBinding fragmentWifiSettingBinding4 = this.j;
        if (fragmentWifiSettingBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentWifiSettingBinding4 = null;
        }
        TextView textView = fragmentWifiSettingBinding4.d;
        Intrinsics.checkNotNullExpressionValue(textView, "gotoApSettingEnd");
        StaticMethodUtilsKt.K(textView, (LinearGradient) null);
        boolean booleanValue = ((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), "is_wifi_enable", Boolean.FALSE, (Context) null, 4, (Object) null)).booleanValue();
        FragmentWifiSettingBinding fragmentWifiSettingBinding5 = this.j;
        if (fragmentWifiSettingBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentWifiSettingBinding5 = null;
        }
        LinearLayout linearLayout = fragmentWifiSettingBinding5.i;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "wifiSwitchCloseUi");
        int i = 8;
        linearLayout.setVisibility(booleanValue ^ true ? 0 : 8);
        FragmentWifiSettingBinding fragmentWifiSettingBinding6 = this.j;
        if (fragmentWifiSettingBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentWifiSettingBinding6 = null;
        }
        LinearLayout linearLayout2 = fragmentWifiSettingBinding6.c;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "gotoApSetting");
        if (booleanValue) {
            i = 0;
        }
        linearLayout2.setVisibility(i);
        WifiListAdapter wifiListAdapter = this.k;
        if (wifiListAdapter != null) {
            wifiListAdapter.G();
        }
        FragmentWifiSettingBinding fragmentWifiSettingBinding7 = this.j;
        if (fragmentWifiSettingBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentWifiSettingBinding2 = fragmentWifiSettingBinding7;
        }
        fragmentWifiSettingBinding2.getRoot().getViewTreeObserver().addOnGlobalLayoutListener(new WifiSettingFragment$initView$1(this));
    }

    private final void n1() {
        FragmentWifiSettingBinding fragmentWifiSettingBinding = this.j;
        FragmentWifiSettingBinding fragmentWifiSettingBinding2 = null;
        if (fragmentWifiSettingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentWifiSettingBinding = null;
        }
        fragmentWifiSettingBinding.getRoot().setOnTouchListener(new c(this));
        FragmentWifiSettingBinding fragmentWifiSettingBinding3 = this.j;
        if (fragmentWifiSettingBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentWifiSettingBinding3 = null;
        }
        fragmentWifiSettingBinding3.g.setOnTouchListener(new d(this));
        FragmentWifiSettingBinding fragmentWifiSettingBinding4 = this.j;
        if (fragmentWifiSettingBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentWifiSettingBinding4 = null;
        }
        fragmentWifiSettingBinding4.b.setOnClickListener(new e(this));
        FragmentWifiSettingBinding fragmentWifiSettingBinding5 = this.j;
        if (fragmentWifiSettingBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentWifiSettingBinding2 = fragmentWifiSettingBinding5;
        }
        fragmentWifiSettingBinding2.c.setOnClickListener(new f(this));
    }

    public static final boolean o1(WifiSettingFragment wifiSettingFragment, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(wifiSettingFragment, "this$0");
        WifiListAdapter wifiListAdapter = wifiSettingFragment.k;
        if (wifiListAdapter == null) {
            return false;
        }
        wifiListAdapter.F(-1);
        return false;
    }

    public static final boolean p1(WifiSettingFragment wifiSettingFragment, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(wifiSettingFragment, "this$0");
        FragmentWifiSettingBinding fragmentWifiSettingBinding = wifiSettingFragment.j;
        FragmentWifiSettingBinding fragmentWifiSettingBinding2 = null;
        if (fragmentWifiSettingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentWifiSettingBinding = null;
        }
        MzRecyclerView mzRecyclerView = fragmentWifiSettingBinding.h;
        float f = 0.0f;
        float x2 = motionEvent != null ? motionEvent.getX() : 0.0f;
        if (motionEvent != null) {
            f = motionEvent.getY();
        }
        View findChildViewUnder = mzRecyclerView.findChildViewUnder(x2, f);
        int i = -1;
        if (findChildViewUnder != null) {
            FragmentWifiSettingBinding fragmentWifiSettingBinding3 = wifiSettingFragment.j;
            if (fragmentWifiSettingBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentWifiSettingBinding2 = fragmentWifiSettingBinding3;
            }
            RecyclerView.ViewHolder childViewHolder = fragmentWifiSettingBinding2.h.getChildViewHolder(findChildViewUnder);
            if (childViewHolder != null) {
                Intrinsics.checkNotNull(childViewHolder);
                i = childViewHolder.getAdapterPosition();
            }
        }
        WifiListAdapter wifiListAdapter = wifiSettingFragment.k;
        if (wifiListAdapter == null) {
            return false;
        }
        wifiListAdapter.F(i);
        return false;
    }

    public static final void q1(WifiSettingFragment wifiSettingFragment, View view) {
        Intrinsics.checkNotNullParameter(wifiSettingFragment, "this$0");
        WifiListAdapter wifiListAdapter = wifiSettingFragment.k;
        if (wifiListAdapter != null) {
            wifiListAdapter.F(-1);
        }
        StaticMethodUtilsKt.q(wifiSettingFragment);
    }

    public static final void r1(WifiSettingFragment wifiSettingFragment, View view) {
        Intrinsics.checkNotNullParameter(wifiSettingFragment, "this$0");
        WifiListAdapter wifiListAdapter = wifiSettingFragment.k;
        if (wifiListAdapter != null) {
            wifiListAdapter.F(-1);
        }
        wifiSettingFragment.y1();
    }

    public static final void s1(WifiSettingFragment wifiSettingFragment, CompoundButton compoundButton, boolean z2) {
        WifiListAdapter wifiListAdapter;
        Intrinsics.checkNotNullParameter(wifiSettingFragment, "this$0");
        WifiListAdapter wifiListAdapter2 = wifiSettingFragment.k;
        if (wifiListAdapter2 == null || true != wifiListAdapter2.u() || !z2) {
            WifiListAdapter wifiListAdapter3 = wifiSettingFragment.k;
            if (wifiListAdapter3 == null || true != wifiListAdapter3.t() || !z2) {
                DataStoreUtils.e.a().o("wifi_auto_connect", Boolean.valueOf(z2));
                String f = wifiSettingFragment.j1().f();
                if (!z2 || !Intrinsics.areEqual((Object) f, (Object) "<unknown ssid>")) {
                    wifiSettingFragment.e1(z2);
                    WifiListAdapter wifiListAdapter4 = wifiSettingFragment.k;
                    if (wifiListAdapter4 != null) {
                        wifiListAdapter4.I(true, 7, 1, true);
                    }
                } else {
                    UToast.Companion companion = UToast.f6444a;
                    Context requireContext = wifiSettingFragment.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                    String string = wifiSettingFragment.getString(R.string.no_wifi_check);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    companion.d(requireContext, string);
                }
            } else {
                UToast.Companion companion2 = UToast.f6444a;
                Context requireContext2 = wifiSettingFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
                String string2 = wifiSettingFragment.getString(R.string.wait_wifi_refresh);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                companion2.d(requireContext2, string2);
                WifiListAdapter wifiListAdapter5 = wifiSettingFragment.k;
                if (wifiListAdapter5 != null) {
                    wifiListAdapter5.I(false, 7, 1, true);
                }
            }
        } else {
            UToast.Companion companion3 = UToast.f6444a;
            Context requireContext3 = wifiSettingFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext(...)");
            String string3 = wifiSettingFragment.getString(R.string.wait_list_refresh);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            companion3.d(requireContext3, string3);
            WifiListAdapter wifiListAdapter6 = wifiSettingFragment.k;
            if (wifiListAdapter6 != null) {
                wifiListAdapter6.I(false, 7, 1, true);
            }
        }
        if (!z2 && (wifiListAdapter = wifiSettingFragment.k) != null) {
            wifiListAdapter.I(false, 7, 1, true);
        }
    }

    private final void u1() {
        h1().L().removeObservers(getViewLifecycleOwner());
    }

    public static final void w1(WifiSettingFragment wifiSettingFragment) {
        Intrinsics.checkNotNullParameter(wifiSettingFragment, "this$0");
        WifiListAdapter wifiListAdapter = wifiSettingFragment.k;
        if (wifiListAdapter != null) {
            wifiListAdapter.setData(new ArrayList());
        }
    }

    public final boolean A1(String str, int i, WifiInfoModel wifiInfoModel) {
        String a2 = CastExtKt.a();
        boolean booleanValue = ((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), "action_not_show_p2p_connect_wifi", Boolean.FALSE, (Context) null, 4, (Object) null)).booleanValue();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("WifiSettingFragment", "castingAppId is: " + a2 + " and notShow is: " + booleanValue);
        if (!Intrinsics.areEqual((Object) str, (Object) "connect") || a2 == null || booleanValue) {
            return false;
        }
        String string = Intrinsics.areEqual((Object) a2, (Object) AssistantConstants.PKG_NAME_KUAISHOU) ? getString(R.string.kuaishou) : Intrinsics.areEqual((Object) a2, (Object) AssistantConstants.PKG_NAME_DOUYIN) ? getString(R.string.tiktok_web) : getString(R.string.screen);
        Intrinsics.checkNotNull(string);
        StaticMethodUtilsKt.H(this, CollectionsKt.arrayListOf(137), MapsKt.hashMapOf(TuplesKt.to(137, string)), false, false, (Bundle) null, 28, (Object) null);
        this.p = i;
        this.q = wifiInfoModel;
        return true;
    }

    public void a(int i, int i2) {
        super.a(i, i2);
        if (i != 137) {
            if (i == 138 && i2 == 1101) {
                WifiListAdapter wifiListAdapter = this.k;
                if (wifiListAdapter != null) {
                    wifiListAdapter.I(false, 6, 0, false);
                }
                SuperMessageManger.m.a().B0(false);
            }
        } else if (i2 == 1101) {
            l1();
        } else {
            this.p = -1;
            this.q = null;
        }
    }

    public final void b1(boolean z2) {
        FragmentWifiSettingBinding fragmentWifiSettingBinding = null;
        y.removeCallbacksAndMessages((Object) null);
        DataStoreUtils.e.a().o("is_wifi_enable", Boolean.valueOf(z2));
        int i = 0;
        this.s = 0;
        FragmentWifiSettingBinding fragmentWifiSettingBinding2 = this.j;
        if (fragmentWifiSettingBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentWifiSettingBinding2 = null;
        }
        LinearLayout linearLayout = fragmentWifiSettingBinding2.i;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "wifiSwitchCloseUi");
        linearLayout.setVisibility(z2 ^ true ? 0 : 8);
        FragmentWifiSettingBinding fragmentWifiSettingBinding3 = this.j;
        if (fragmentWifiSettingBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentWifiSettingBinding = fragmentWifiSettingBinding3;
        }
        LinearLayout linearLayout2 = fragmentWifiSettingBinding.c;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "gotoApSetting");
        if (!z2) {
            i = 8;
        }
        linearLayout2.setVisibility(i);
        WifiListAdapter wifiListAdapter = this.k;
        if (wifiListAdapter != null) {
            wifiListAdapter.G();
        }
        if (z2) {
            v1();
        } else {
            this.r = 0;
        }
    }

    public void c(int i, Object obj) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("WifiSettingFragment", "jumpAction::data is: " + obj);
        if (i != 114) {
            if (i != 137 || !(obj instanceof Integer)) {
                return;
            }
            if (Intrinsics.areEqual(obj, (Object) 2)) {
                DataStoreUtils.e.a().o("action_not_show_p2p_connect_wifi", Boolean.TRUE);
            } else if (Intrinsics.areEqual(obj, (Object) 1)) {
                DataStoreUtils.e.a().o("action_not_show_p2p_connect_wifi", Boolean.FALSE);
            }
        } else if (obj instanceof PasswordInfo) {
            f1((PasswordInfo) obj);
        }
    }

    public final void c1(List list) {
        this.s = 0;
        Z0();
        String f = j1().f();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            WifiInfoModel wifiInfoModel = (WifiInfoModel) it.next();
            if (Intrinsics.areEqual((Object) StringsKt.replace$default(f, "\"", "", false, 4, (Object) null), (Object) wifiInfoModel.getSSid())) {
                wifiInfoModel.setPhoneConnectWifi(true);
            }
        }
        ULog.f6446a.a("WifiSettingFragment", "changeWifiUI::list size is: " + list.size());
        WifiListAdapter wifiListAdapter = this.k;
        if (wifiListAdapter != null) {
            wifiListAdapter.setData(list);
        }
        FragmentWifiSettingBinding fragmentWifiSettingBinding = this.j;
        if (fragmentWifiSettingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentWifiSettingBinding = null;
        }
        fragmentWifiSettingBinding.h.smoothScrollToPosition(0);
        Handler handler = y;
        handler.removeCallbacksAndMessages((Object) null);
        SuperMessageManger.m.a().r();
        if (!list.isEmpty()) {
            handler.postDelayed(new g(this), 10000);
        }
    }

    public final void e1(boolean z2) {
        WifiListAdapter wifiListAdapter = this.k;
        Boolean valueOf = wifiListAdapter != null ? Boolean.valueOf(wifiListAdapter.o()) : null;
        if (z2 && Intrinsics.areEqual((Object) Boolean.FALSE, (Object) valueOf)) {
            j1().d();
        }
    }

    public final void f1(PasswordInfo passwordInfo) {
        try {
            WifiListAdapter wifiListAdapter = this.k;
            if (wifiListAdapter != null) {
                if (wifiListAdapter.u()) {
                    UToast.Companion companion = UToast.f6444a;
                    Context requireContext = requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                    String string = getString(R.string.wait_wifi_connect);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    companion.d(requireContext, string);
                    return;
                }
            }
            WifiListAdapter wifiListAdapter2 = this.k;
            if (wifiListAdapter2 == null || !wifiListAdapter2.t()) {
                x1();
                this.p = passwordInfo.getMIndex();
                this.o = passwordInfo;
                SuperMessageManger.m.a().g0(passwordInfo.getMSid(), passwordInfo.getMPassword(), "req_change_wifi_state", "0");
                WifiListAdapter wifiListAdapter3 = this.k;
                if (wifiListAdapter3 != null) {
                    wifiListAdapter3.L(this.p, 3);
                    return;
                }
                return;
            }
            UToast.Companion companion2 = UToast.f6444a;
            Context requireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
            String string2 = getString(R.string.wait_wifi_connect);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            companion2.d(requireContext2, string2);
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e.getMessage();
            delegate.c("WifiSettingFragment", "connectWifi::e: " + message);
        }
    }

    public final WifiViewModel j1() {
        return (WifiViewModel) this.n.getValue();
    }

    public final void k1(String str, int i) {
        WifiListAdapter wifiListAdapter;
        x1();
        if (i == 100 && (wifiListAdapter = this.k) != null) {
            wifiListAdapter.H(false);
        }
        String b = WifiErrorUtils.f7100a.a().b(str, i);
        if (b.length() > 0) {
            UToast.Companion companion = UToast.f6444a;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            companion.d(requireContext, b);
        }
    }

    public final void l1() {
        WifiInfoModel wifiInfoModel = this.q;
        if (wifiInfoModel != null) {
            z1(wifiInfoModel, this.p);
        }
    }

    public final void m1() {
        x1();
        PasswordInfo passwordInfo = this.o;
        if (passwordInfo != null) {
            passwordInfo.setMState(-1);
            Bundle bundle = new Bundle();
            bundle.putInt("gravity", 17);
            StaticMethodUtilsKt.B(this, CollectionsKt.arrayListOf(114), MapsKt.hashMapOf(TuplesKt.to(114, passwordInfo)), false, false, bundle);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentWifiSettingBinding c = FragmentWifiSettingBinding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.j = c;
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
        u1();
        y.removeCallbacksAndMessages((Object) null);
        j1().h().removeObservers(getViewLifecycleOwner());
        j1().g().removeObservers(getViewLifecycleOwner());
        i1().K().removeObservers(getViewLifecycleOwner());
        i1().P0().removeObservers(getViewLifecycleOwner());
        i1().O0().removeObservers(getViewLifecycleOwner());
        i1().L().removeObservers(getViewLifecycleOwner());
    }

    public void onResume() {
        super.onResume();
        ULog.f6446a.a("WifiSettingFragment", "onResume");
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView();
        n1();
        t1();
        WifiListAdapter wifiListAdapter = this.k;
        if (wifiListAdapter != null && wifiListAdapter.v(6, 0)) {
            v1();
        }
    }

    public final void t1() {
        SingleLiveData h = j1().h();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        h.observe(viewLifecycleOwner, new WifiSettingFragment$sam$androidx_lifecycle_Observer$0(new WifiSettingFragment$registerObserve$1(this)));
        SingleLiveData g = j1().g();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        g.observe(viewLifecycleOwner2, new WifiSettingFragment$sam$androidx_lifecycle_Observer$0(new WifiSettingFragment$registerObserve$2(this)));
        SingleLiveData K = i1().K();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        K.observe(viewLifecycleOwner3, new WifiSettingFragment$sam$androidx_lifecycle_Observer$0(new WifiSettingFragment$registerObserve$3(this)));
        SingleLiveData P0 = i1().P0();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        P0.observe(viewLifecycleOwner4, new WifiSettingFragment$sam$androidx_lifecycle_Observer$0(new WifiSettingFragment$registerObserve$4(this)));
        SingleLiveData O0 = i1().O0();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        O0.observe(viewLifecycleOwner5, new WifiSettingFragment$sam$androidx_lifecycle_Observer$0(new WifiSettingFragment$registerObserve$5(this)));
        i1().L().observe(getViewLifecycleOwner(), new WifiSettingFragment$sam$androidx_lifecycle_Observer$0(new WifiSettingFragment$registerObserve$6(this)));
        GlassHelper.f7049a.k(this, this.u);
    }

    public final void v1() {
        Handler handler = y;
        handler.removeCallbacksAndMessages((Object) null);
        long currentTimeMillis = System.currentTimeMillis();
        this.r = currentTimeMillis;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("WifiSettingFragment", "requestWifiList mRequestWifiListTime is: " + currentTimeMillis);
        SuperMessageManger.m.a().D();
        handler.postDelayed(new b(this), TiciStarryMsgManager.MAX_TIME_OUT);
    }

    @ConnectCheck
    @Keep
    @FastClickCheck
    public void wifiClickCallback(@NotNull String str, int i, @NotNull WifiInfoModel wifiInfoModel, boolean z2, boolean z3) {
        WifiInfoModel wifiInfoModel2 = wifiInfoModel;
        JoinPoint makeJP = Factory.makeJP(z, (Object) this, (Object) this, new Object[]{str, Conversions.intObject(i), wifiInfoModel2, Conversions.booleanObject(z2), Conversions.booleanObject(z3)});
        E1(this, str, i, wifiInfoModel2, z2, z3, makeJP, FastClickAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    public final void x1() {
        WifiListAdapter wifiListAdapter = this.k;
        if (wifiListAdapter != null) {
            wifiListAdapter.L(this.p, 0);
        }
    }

    public final void y1() {
        Intent intent = new Intent();
        intent.setFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
        ComponentName componentName = new ComponentName("com.android.settings", "com.android.settings.Settings$TetherSettingsActivity");
        if (PhoneTypeUtils.f7912a.c()) {
            componentName = new ComponentName("com.android.settings", "com.android.settings.Settings$WirelessSettingsActivity");
        }
        intent.setComponent(componentName);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        StaticMethodUtilsKt.U(requireContext, intent);
    }

    public final void z1(WifiInfoModel wifiInfoModel, int i) {
        if (wifiInfoModel.getItemType() != 3 || !wifiInfoModel.getNeedPassword()) {
            f1(new PasswordInfo(wifiInfoModel.getSSid(), "", 0, i));
        } else if (!wifiInfoModel.isPhoneConnectWifi() || j1().e() == null) {
            PasswordInfo passwordInfo = new PasswordInfo(wifiInfoModel.getSSid(), "", 0, i);
            Bundle bundle = new Bundle();
            bundle.putInt("gravity", 17);
            StaticMethodUtilsKt.B(this, CollectionsKt.arrayListOf(114), MapsKt.hashMapOf(TuplesKt.to(114, passwordInfo)), false, false, bundle);
        }
    }
}
