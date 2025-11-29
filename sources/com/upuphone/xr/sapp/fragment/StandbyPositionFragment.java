package com.upuphone.xr.sapp.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import com.honey.account.h8.k9;
import com.honey.account.h8.l9;
import com.honey.account.h8.m9;
import com.honey.account.h8.n9;
import com.honey.account.h8.o9;
import com.honey.account.h8.p9;
import com.honey.account.h8.q9;
import com.honey.account.h8.r9;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.aspect.AspectHelper;
import com.upuphone.xr.sapp.aspect.ConnectCheckAspect;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$3;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$4;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$5;
import com.upuphone.xr.sapp.context.GlassInfoExtKt;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.databinding.FragmentStandbyPositionBinding;
import com.upuphone.xr.sapp.datatrack.AppDataTrackEvent;
import com.upuphone.xr.sapp.entity.StandbyWidgetOrderInfo;
import com.upuphone.xr.sapp.entity.StandbyWidgetOrderSubInfo;
import com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.DynamicAdapterUtils;
import com.upuphone.xr.sapp.utils.ModelIdExtKt;
import com.upuphone.xr.sapp.utils.PhoneTypeUtils;
import com.upuphone.xr.sapp.utils.VersionMatchHelper;
import com.upuphone.xr.sapp.view.CustomRadioButton;
import com.upuphone.xr.sapp.view.StandbyComponentBottomSheet;
import com.upuphone.xr.sapp.vm.DeviceControlModel;
import com.upuphone.xr.sapp.vm.SuperViewModel;
import com.upuphone.xr.sapp.vm.internal.SuperMessageManger;
import com.xjsd.xr.sapp.asr.utils.GsonHelper;
import flyme.support.v7.app.AlertDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.runtime.internal.Conversions;
import org.aspectj.runtime.reflect.Factory;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001~\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u0014\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0003J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0018\u0010\rJ'\u0010\u001d\u001a\u00020\u00042\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJC\u0010$\u001a\u00020\u00042\"\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00060\u001fj\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0006` 2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u001aH\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0004H\u0002¢\u0006\u0004\b&\u0010\u0003J'\u0010'\u001a\u00020\u00042\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001bH\u0002¢\u0006\u0004\b'\u0010\u001eJ3\u0010(\u001a\u00020\u00042\"\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00060\u001fj\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0006` H\u0002¢\u0006\u0004\b(\u0010)J'\u0010*\u001a\u00020\u00042\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001bH\u0002¢\u0006\u0004\b*\u0010\u001eJ/\u0010,\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u001a2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b,\u0010-J\u0017\u00100\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b0\u00101J;\u00103\u001a\u00020\u00042\u0006\u0010/\u001a\u0002022\"\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00060\u001fj\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0006` H\u0002¢\u0006\u0004\b3\u00104J\u0017\u00106\u001a\u00020\u00042\u0006\u00105\u001a\u00020\nH\u0002¢\u0006\u0004\b6\u0010\rJ\u000f\u00107\u001a\u00020\u0004H\u0002¢\u0006\u0004\b7\u0010\u0003J3\u00108\u001a\u00020\u00042\"\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00060\u001fj\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0006` H\u0002¢\u0006\u0004\b8\u0010)J+\u0010?\u001a\u0002022\u0006\u0010:\u001a\u0002092\b\u0010<\u001a\u0004\u0018\u00010;2\b\u0010>\u001a\u0004\u0018\u00010=H\u0016¢\u0006\u0004\b?\u0010@J!\u0010A\u001a\u00020\u00042\u0006\u0010/\u001a\u0002022\b\u0010>\u001a\u0004\u0018\u00010=H\u0016¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020\u0004H\u0016¢\u0006\u0004\bC\u0010\u0003J\u000f\u0010D\u001a\u00020\u0004H\u0016¢\u0006\u0004\bD\u0010\u0003R\"\u0010J\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010\u0012R\u0016\u0010M\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bO\u0010PR\u001b\u0010W\u001a\u00020R8BX\u0002¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR\u001b\u0010\\\u001a\u00020X8BX\u0002¢\u0006\f\n\u0004\bY\u0010T\u001a\u0004\bZ\u0010[R&\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0014\u0010a\u001a\u00020\u001a8\u0002XD¢\u0006\u0006\n\u0004\b_\u0010`R\u0014\u0010c\u001a\u00020\u001a8\u0002XD¢\u0006\u0006\n\u0004\bb\u0010`R\u0014\u0010e\u001a\u00020\u001a8\u0002XD¢\u0006\u0006\n\u0004\bd\u0010`R\u0014\u0010i\u001a\u00020f8\u0002XD¢\u0006\u0006\n\u0004\bg\u0010hR\u0014\u0010m\u001a\u00020j8\u0002XD¢\u0006\u0006\n\u0004\bk\u0010lR\u0014\u0010o\u001a\u00020j8\u0002XD¢\u0006\u0006\n\u0004\bn\u0010lR\u0014\u0010q\u001a\u00020j8\u0002XD¢\u0006\u0006\n\u0004\bp\u0010lR\u0014\u0010s\u001a\u00020j8\u0002XD¢\u0006\u0006\n\u0004\br\u0010lR\u0014\u0010u\u001a\u00020\u00068\u0002XD¢\u0006\u0006\n\u0004\bt\u0010FR\u0014\u0010w\u001a\u00020\u00068\u0002XD¢\u0006\u0006\n\u0004\bv\u0010FR\u0016\u0010y\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bx\u0010LR\u0014\u0010}\u001a\u00020z8\u0002X\u0004¢\u0006\u0006\n\u0004\b{\u0010|R\u0016\u0010\u0001\u001a\u00020~8\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/StandbyPositionFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "b1", "", "it", "F1", "(Ljava/lang/Integer;)V", "", "connect", "i1", "(Z)V", "initView", "initViewModel", "checkedId", "changePotion", "(I)V", "type", "r1", "v1", "g1", "isVisible", "A1", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "widgetList", "q1", "(Ljava/util/ArrayList;)V", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "widgetMap", "isRemove", "componentName", "e1", "(Ljava/util/LinkedHashMap;ZLjava/lang/String;)V", "o1", "p1", "y1", "(Ljava/util/LinkedHashMap;)V", "G1", "newComponentName", "Z0", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "Landroid/widget/ImageView;", "view", "c1", "(Landroid/widget/ImageView;)V", "Landroid/view/View;", "w1", "(Landroid/view/View;Ljava/util/LinkedHashMap;)V", "isShow", "E1", "h1", "B1", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "onDestroy", "j", "I", "k1", "()I", "x1", "positon", "k", "Z", "isConnect", "Lcom/upuphone/xr/sapp/databinding/FragmentStandbyPositionBinding;", "l", "Lcom/upuphone/xr/sapp/databinding/FragmentStandbyPositionBinding;", "binding", "Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "m", "Lkotlin/Lazy;", "n0", "()Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "viewModel", "Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "n", "j1", "()Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "mDeviceModel", "o", "Ljava/util/ArrayList;", "p", "Ljava/lang/String;", "alpha", "q", "scaleX", "r", "scaleY", "", "s", "J", "animDuration", "", "t", "F", "scaleAnimFrom", "u", "scaleAnimTo", "v", "alphaFrom", "w", "alphaTo", "x", "value_50", "y", "value_100", "z", "showNotSaveConfirmDialog", "Landroid/os/Handler;", "A", "Landroid/os/Handler;", "handler", "com/upuphone/xr/sapp/fragment/StandbyPositionFragment$componentChange$1", "B", "Lcom/upuphone/xr/sapp/fragment/StandbyPositionFragment$componentChange$1;", "componentChange", "C", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nStandbyPositionFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StandbyPositionFragment.kt\ncom/upuphone/xr/sapp/fragment/StandbyPositionFragment\n+ 2 GlobalViewStoreExt.kt\ncom/upuphone/xr/sapp/common/GlobalViewStoreExtKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,720:1\n32#2,12:721\n32#2,12:733\n256#3,2:745\n256#3,2:747\n256#3,2:749\n1855#4,2:751\n1855#4,2:753\n1855#4,2:755\n1855#4,2:757\n215#5,2:759\n*S KotlinDebug\n*F\n+ 1 StandbyPositionFragment.kt\ncom/upuphone/xr/sapp/fragment/StandbyPositionFragment\n*L\n76#1:721,12\n77#1:733,12\n193#1:745,2\n324#1:747,2\n325#1:749,2\n372#1:751,2\n377#1:753,2\n421#1:755,2\n444#1:757,2\n689#1:759,2\n*E\n"})
public final class StandbyPositionFragment extends BaseFragment {
    public static final Companion C = new Companion((DefaultConstructorMarker) null);
    public static /* synthetic */ JoinPoint.StaticPart D;
    public final Handler A;
    public final StandbyPositionFragment$componentChange$1 B;
    public volatile int j = -1;
    public boolean k = true;
    public FragmentStandbyPositionBinding l;
    public final Lazy m;
    public final Lazy n;
    public ArrayList o;
    public final String p;
    public final String q;
    public final String r;
    public final long s;
    public final float t;
    public final float u;
    public final float v;
    public final float w;
    public final int x;
    public final int y;
    public boolean z;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/StandbyPositionFragment$Companion;", "", "()V", "BOTTOM_CENTER", "", "BOTTOM_LEFT", "BOTTOM_RIGHT", "SEND_WEATHER_TIME_INTERVAL", "", "TAG", "", "TOP_LEFT", "TOP_RIGHT", "WHAT_CHANGE_POSITION", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    static {
        d1();
    }

    public StandbyPositionFragment() {
        Class<SuperViewModel> cls = SuperViewModel.class;
        this.m = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls), new GlobalViewStoreExtKt$cachedViewModels$3(cls.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
        Class<DeviceControlModel> cls2 = DeviceControlModel.class;
        this.n = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls2), new GlobalViewStoreExtKt$cachedViewModels$3(cls2.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
        this.o = new ArrayList();
        this.p = "alpha";
        this.q = "scaleX";
        this.r = "scaleY";
        this.s = 200;
        this.t = 0.9f;
        this.u = 1.0f;
        this.w = 1.0f;
        this.x = 50;
        this.y = 100;
        this.A = new Handler(Looper.getMainLooper(), new n9(this));
        this.B = new StandbyPositionFragment$componentChange$1(this);
    }

    public static final void C1(StandbyPositionFragment standbyPositionFragment, LinkedHashMap linkedHashMap, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(standbyPositionFragment, "this$0");
        Intrinsics.checkNotNullParameter(linkedHashMap, "$widgetMap");
        standbyPositionFragment.B.f(linkedHashMap);
        standbyPositionFragment.B.c(linkedHashMap);
    }

    public static final void D1(StandbyPositionFragment standbyPositionFragment, LinkedHashMap linkedHashMap, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(standbyPositionFragment, "this$0");
        Intrinsics.checkNotNullParameter(linkedHashMap, "$widgetMap");
        standbyPositionFragment.B.f(linkedHashMap);
        standbyPositionFragment.B.g();
    }

    /* access modifiers changed from: private */
    public final void F1(Integer num) {
        int i = (num != null && num.intValue() == 2) ? R.id.top_left : (num != null && num.intValue() == 3) ? R.id.top_right : (num != null && num.intValue() == 0) ? R.id.bottom_left : (num != null && num.intValue() == 1) ? R.id.bottom_right : (num != null && num.intValue() == 4) ? R.id.bottom_center : R.id.bottom_left;
        FragmentStandbyPositionBinding fragmentStandbyPositionBinding = this.l;
        if (fragmentStandbyPositionBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentStandbyPositionBinding = null;
        }
        fragmentStandbyPositionBinding.o.l(i, false);
    }

    public static /* synthetic */ void a1(StandbyPositionFragment standbyPositionFragment, String str, Boolean bool, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            bool = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        standbyPositionFragment.Z0(str, bool, str2);
    }

    private final void b1() {
        ULog.f6446a.a("StandbyPositionFragment", "addObserve");
        n0().G().observe(getViewLifecycleOwner(), new StandbyPositionFragment$sam$androidx_lifecycle_Observer$0(new StandbyPositionFragment$addObserve$1(this)));
        j1().L().observe(getViewLifecycleOwner(), new StandbyPositionFragment$sam$androidx_lifecycle_Observer$0(new StandbyPositionFragment$addObserve$2(this)));
        n0().H().observe(getViewLifecycleOwner(), new StandbyPositionFragment$sam$androidx_lifecycle_Observer$0(new StandbyPositionFragment$addObserve$3(this)));
    }

    @Keep
    private final void changePotion(int i) {
        int i2;
        if (i == R.id.top_left) {
            i2 = 2;
        } else if (i == R.id.top_right) {
            i2 = 3;
        } else {
            if (i != R.id.bottom_left) {
                if (i == R.id.bottom_right) {
                    i2 = 1;
                } else if (i == R.id.bottom_center) {
                    i2 = 4;
                }
            }
            i2 = 0;
        }
        if (this.j != i2) {
            this.j = i2;
            r1(i2);
        }
    }

    private static /* synthetic */ void d1() {
        Factory factory = new Factory("StandbyPositionFragment.kt", StandbyPositionFragment.class);
        D = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("12", "onChangeToPosition", "com.upuphone.xr.sapp.fragment.StandbyPositionFragment", "int", "type", "", "void"), 274);
    }

    public static final void f1(Function2 function2, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(function2, "$tmp0");
        function2.invoke(obj, obj2);
    }

    /* access modifiers changed from: private */
    public final void i1(boolean z2) {
        ULog.f6446a.a("StandbyPositionFragment", "enableUI connect:" + z2);
        this.k = z2;
        FragmentStandbyPositionBinding fragmentStandbyPositionBinding = null;
        if (z2) {
            FragmentStandbyPositionBinding fragmentStandbyPositionBinding2 = this.l;
            if (fragmentStandbyPositionBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentStandbyPositionBinding2 = null;
            }
            fragmentStandbyPositionBinding2.p.setAlpha(1.0f);
        } else {
            FragmentStandbyPositionBinding fragmentStandbyPositionBinding3 = this.l;
            if (fragmentStandbyPositionBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentStandbyPositionBinding3 = null;
            }
            fragmentStandbyPositionBinding3.p.setAlpha(0.5f);
        }
        FragmentStandbyPositionBinding fragmentStandbyPositionBinding4 = this.l;
        if (fragmentStandbyPositionBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentStandbyPositionBinding4 = null;
        }
        fragmentStandbyPositionBinding4.o.setEnabled(this.k);
        FragmentStandbyPositionBinding fragmentStandbyPositionBinding5 = this.l;
        if (fragmentStandbyPositionBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentStandbyPositionBinding5 = null;
        }
        fragmentStandbyPositionBinding5.w.setEnabled(this.k);
        if (!z2) {
            StandbyComponentBottomSheet a2 = StandbyComponentBottomSheet.e.a();
            if (a2 != null) {
                a2.dismiss();
            }
            FragmentStandbyPositionBinding fragmentStandbyPositionBinding6 = this.l;
            if (fragmentStandbyPositionBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentStandbyPositionBinding6 = null;
            }
            fragmentStandbyPositionBinding6.h.setBackground((Drawable) null);
            FragmentStandbyPositionBinding fragmentStandbyPositionBinding7 = this.l;
            if (fragmentStandbyPositionBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentStandbyPositionBinding = fragmentStandbyPositionBinding7;
            }
            fragmentStandbyPositionBinding.w.setTextColor(MainApplication.k.d().getResources().getColor(R.color.mz_theme_color_blue));
        }
    }

    private final void initView() {
        FragmentStandbyPositionBinding fragmentStandbyPositionBinding = this.l;
        FragmentStandbyPositionBinding fragmentStandbyPositionBinding2 = null;
        if (fragmentStandbyPositionBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentStandbyPositionBinding = null;
        }
        CustomRadioButton customRadioButton = fragmentStandbyPositionBinding.b;
        Intrinsics.checkNotNullExpressionValue(customRadioButton, "bottomCenter");
        customRadioButton.setVisibility(VersionMatchHelper.g(VersionMatchHelper.f7930a, true, false, false, (String) null, (String) null, GlassInfoExtKt.c(GlassInfoExtKt.d("1.1.1.115")), GlassInfoExtKt.c(GlassInfoExtKt.d("1.1.0.395")), 28, (Object) null) ? 0 : 8);
        if (ModelIdExtKt.a(DynamicAdapterUtils.f7879a.a())) {
            PhoneTypeUtils phoneTypeUtils = PhoneTypeUtils.f7912a;
            if (phoneTypeUtils.e() || phoneTypeUtils.c() || phoneTypeUtils.i()) {
                FragmentStandbyPositionBinding fragmentStandbyPositionBinding3 = this.l;
                if (fragmentStandbyPositionBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentStandbyPositionBinding3 = null;
                }
                fragmentStandbyPositionBinding3.s.setImageResource(R.drawable.standby_img_lt_air);
                FragmentStandbyPositionBinding fragmentStandbyPositionBinding4 = this.l;
                if (fragmentStandbyPositionBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentStandbyPositionBinding4 = null;
                }
                fragmentStandbyPositionBinding4.u.setImageResource(R.drawable.standby_img_rt_air);
                FragmentStandbyPositionBinding fragmentStandbyPositionBinding5 = this.l;
                if (fragmentStandbyPositionBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentStandbyPositionBinding5 = null;
                }
                fragmentStandbyPositionBinding5.r.setImageResource(R.drawable.standby_img_lb_air);
                FragmentStandbyPositionBinding fragmentStandbyPositionBinding6 = this.l;
                if (fragmentStandbyPositionBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentStandbyPositionBinding6 = null;
                }
                fragmentStandbyPositionBinding6.t.setImageResource(R.drawable.standby_img_rb_air);
                FragmentStandbyPositionBinding fragmentStandbyPositionBinding7 = this.l;
                if (fragmentStandbyPositionBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentStandbyPositionBinding7 = null;
                }
                fragmentStandbyPositionBinding7.q.setImageResource(R.drawable.standby_img_cb_air);
            } else {
                FragmentStandbyPositionBinding fragmentStandbyPositionBinding8 = this.l;
                if (fragmentStandbyPositionBinding8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentStandbyPositionBinding8 = null;
                }
                fragmentStandbyPositionBinding8.s.setImageResource(R.drawable.standby_img_lt_time);
                FragmentStandbyPositionBinding fragmentStandbyPositionBinding9 = this.l;
                if (fragmentStandbyPositionBinding9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentStandbyPositionBinding9 = null;
                }
                fragmentStandbyPositionBinding9.u.setImageResource(R.drawable.standby_img_rt_time);
                FragmentStandbyPositionBinding fragmentStandbyPositionBinding10 = this.l;
                if (fragmentStandbyPositionBinding10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentStandbyPositionBinding10 = null;
                }
                fragmentStandbyPositionBinding10.r.setImageResource(R.drawable.standby_img_lb_time);
                FragmentStandbyPositionBinding fragmentStandbyPositionBinding11 = this.l;
                if (fragmentStandbyPositionBinding11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentStandbyPositionBinding11 = null;
                }
                fragmentStandbyPositionBinding11.t.setImageResource(R.drawable.standby_img_rb_time);
                FragmentStandbyPositionBinding fragmentStandbyPositionBinding12 = this.l;
                if (fragmentStandbyPositionBinding12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentStandbyPositionBinding12 = null;
                }
                fragmentStandbyPositionBinding12.q.setImageResource(R.drawable.standby_img_cb_time);
            }
        }
        FragmentStandbyPositionBinding fragmentStandbyPositionBinding13 = this.l;
        if (fragmentStandbyPositionBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentStandbyPositionBinding13 = null;
        }
        fragmentStandbyPositionBinding13.n.setOnClickListener(new p9(this));
        FragmentStandbyPositionBinding fragmentStandbyPositionBinding14 = this.l;
        if (fragmentStandbyPositionBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentStandbyPositionBinding14 = null;
        }
        fragmentStandbyPositionBinding14.o.setOnTouchListener(new StandbyPositionFragment$initView$2(this));
        FragmentStandbyPositionBinding fragmentStandbyPositionBinding15 = this.l;
        if (fragmentStandbyPositionBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentStandbyPositionBinding15 = null;
        }
        fragmentStandbyPositionBinding15.o.setOnCheckedChangeListener(new StandbyPositionFragment$initView$3(this));
        FragmentStandbyPositionBinding fragmentStandbyPositionBinding16 = this.l;
        if (fragmentStandbyPositionBinding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentStandbyPositionBinding2 = fragmentStandbyPositionBinding16;
        }
        fragmentStandbyPositionBinding2.w.setOnClickListener(new q9(this));
    }

    private final void initViewModel() {
        SdkContext.f6675a.e().c().observe(getViewLifecycleOwner(), new StandbyPositionFragment$sam$androidx_lifecycle_Observer$0(new StandbyPositionFragment$initViewModel$1(this)));
    }

    private final DeviceControlModel j1() {
        return (DeviceControlModel) this.n.getValue();
    }

    public static final boolean l1(StandbyPositionFragment standbyPositionFragment, Message message) {
        Intrinsics.checkNotNullParameter(standbyPositionFragment, "this$0");
        Intrinsics.checkNotNullParameter(message, "it");
        FragmentActivity activity = standbyPositionFragment.getActivity();
        if (activity != null && !activity.isFinishing() && standbyPositionFragment.isAdded()) {
            if (message.what == 4001) {
                standbyPositionFragment.changePotion(message.arg1);
            } else {
                ULog.f6446a.a("StandbyPositionFragment", "invalid msg");
            }
        }
        return true;
    }

    public static final void m1(StandbyPositionFragment standbyPositionFragment, View view) {
        Intrinsics.checkNotNullParameter(standbyPositionFragment, "this$0");
        FragmentKt.a(standbyPositionFragment).T();
    }

    private final SuperViewModel n0() {
        return (SuperViewModel) this.m.getValue();
    }

    public static final void n1(StandbyPositionFragment standbyPositionFragment, View view) {
        Intrinsics.checkNotNullParameter(standbyPositionFragment, "this$0");
        if (!standbyPositionFragment.isAdded() || standbyPositionFragment.getView() == null) {
            ULog.f6446a.a("StandbyPositionFragment", "textEditOnClick -> fragment is not attached fragment");
            return;
        }
        StandbyComponentBottomSheet.Companion companion = StandbyComponentBottomSheet.e;
        Context requireContext = standbyPositionFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        companion.n(requireContext, standbyPositionFragment.o, standbyPositionFragment.B);
    }

    private final void r1(int i) {
        JoinPoint makeJP = Factory.makeJP(D, (Object) this, (Object) this, Conversions.intObject(i));
        t1(this, i, makeJP, ConnectCheckAspect.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    public static final /* synthetic */ void s1(StandbyPositionFragment standbyPositionFragment, int i, JoinPoint joinPoint) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("StandbyPositionFragment", "onChangeToPosition standby position = " + i);
        SuperMessageManger.m.a().v0(i);
    }

    public static final /* synthetic */ void t1(StandbyPositionFragment standbyPositionFragment, int i, JoinPoint joinPoint, ConnectCheckAspect connectCheckAspect, ProceedingJoinPoint proceedingJoinPoint) {
        Intrinsics.checkNotNullParameter(proceedingJoinPoint, "joinPoint");
        if (AspectHelper.INSTANCE.getDeviceConnect()) {
            s1(standbyPositionFragment, i, proceedingJoinPoint);
            return;
        }
        UToast.Companion companion = UToast.f6444a;
        MainApplication.Companion companion2 = MainApplication.k;
        MainApplication f = companion2.f();
        String string = companion2.f().getString(R.string.device_disconnect);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.d(f, string);
    }

    public static final void u1(StandbyPositionFragment standbyPositionFragment) {
        Intrinsics.checkNotNullParameter(standbyPositionFragment, "this$0");
        standbyPositionFragment.o1();
    }

    private final void v1() {
        ULog.f6446a.a("StandbyPositionFragment", "removeObserve");
        n0().G().removeObservers(getViewLifecycleOwner());
        j1().L().removeObservers(getViewLifecycleOwner());
        n0().H().removeObservers(getViewLifecycleOwner());
    }

    public static final void z1(Function2 function2, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(function2, "$tmp0");
        function2.invoke(obj, obj2);
    }

    public final void A1(boolean z2) {
        FragmentStandbyPositionBinding fragmentStandbyPositionBinding = this.l;
        FragmentStandbyPositionBinding fragmentStandbyPositionBinding2 = null;
        if (fragmentStandbyPositionBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentStandbyPositionBinding = null;
        }
        View view = fragmentStandbyPositionBinding.I;
        Intrinsics.checkNotNullExpressionValue(view, "viewLine");
        int i = 8;
        view.setVisibility(z2 ? 0 : 8);
        FragmentStandbyPositionBinding fragmentStandbyPositionBinding3 = this.l;
        if (fragmentStandbyPositionBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentStandbyPositionBinding2 = fragmentStandbyPositionBinding3;
        }
        TextView textView = fragmentStandbyPositionBinding2.D;
        Intrinsics.checkNotNullExpressionValue(textView, "tvGlassStandbyDesc");
        if (z2) {
            i = 0;
        }
        textView.setVisibility(i);
    }

    public final void B1(LinkedHashMap linkedHashMap) {
        if (this.z) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                ((Number) entry.getValue()).intValue();
                arrayList.add((String) entry.getKey());
            }
            ArrayList arrayList2 = this.o;
            StandbyComponentBottomSheet.Companion companion = StandbyComponentBottomSheet.e;
            arrayList2.remove(companion.f());
            this.o.remove(companion.b());
            if (Intrinsics.areEqual((Object) arrayList, (Object) this.o)) {
                FragmentStandbyPositionBinding fragmentStandbyPositionBinding = this.l;
                if (fragmentStandbyPositionBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentStandbyPositionBinding = null;
                }
                fragmentStandbyPositionBinding.w.setTextColor(MainApplication.k.d().getResources().getColor(R.color.mz_theme_color_blue));
                FragmentStandbyPositionBinding fragmentStandbyPositionBinding2 = this.l;
                if (fragmentStandbyPositionBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentStandbyPositionBinding2 = null;
                }
                fragmentStandbyPositionBinding2.h.setBackground((Drawable) null);
            } else if (!isAdded() || getView() == null) {
                ULog.f6446a.a("StandbyPositionFragment", "showNotSaveTipsDialog -> fragment is not attached fragment");
            } else {
                AlertDialog.Builder cancelable = new AlertDialog.Builder(requireContext()).setCancelable(false);
                MainApplication.Companion companion2 = MainApplication.k;
                cancelable.setMessage((CharSequence) companion2.d().getString(R.string.standby_not_save_tips)).setPositiveButton((CharSequence) companion2.d().getString(R.string.save), (DialogInterface.OnClickListener) new l9(this, linkedHashMap)).setNegativeButton((CharSequence) companion2.d().getString(R.string.standby_button_text_dont_save), (DialogInterface.OnClickListener) new m9(this, linkedHashMap)).show();
            }
        }
    }

    public final void E1(boolean z2) {
        FragmentStandbyPositionBinding fragmentStandbyPositionBinding = null;
        if (z2) {
            FragmentStandbyPositionBinding fragmentStandbyPositionBinding2 = this.l;
            if (fragmentStandbyPositionBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentStandbyPositionBinding2 = null;
            }
            fragmentStandbyPositionBinding2.v.setVisibility(0);
            FragmentStandbyPositionBinding fragmentStandbyPositionBinding3 = this.l;
            if (fragmentStandbyPositionBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentStandbyPositionBinding3 = null;
            }
            fragmentStandbyPositionBinding3.w.setVisibility(0);
            FragmentStandbyPositionBinding fragmentStandbyPositionBinding4 = this.l;
            if (fragmentStandbyPositionBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentStandbyPositionBinding4 = null;
            }
            fragmentStandbyPositionBinding4.i.setVisibility(0);
            FragmentStandbyPositionBinding fragmentStandbyPositionBinding5 = this.l;
            if (fragmentStandbyPositionBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentStandbyPositionBinding5 = null;
            }
            fragmentStandbyPositionBinding5.h.setVisibility(0);
            FragmentStandbyPositionBinding fragmentStandbyPositionBinding6 = this.l;
            if (fragmentStandbyPositionBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentStandbyPositionBinding6 = null;
            }
            fragmentStandbyPositionBinding6.x.setVisibility(0);
            FragmentStandbyPositionBinding fragmentStandbyPositionBinding7 = this.l;
            if (fragmentStandbyPositionBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentStandbyPositionBinding = fragmentStandbyPositionBinding7;
            }
            fragmentStandbyPositionBinding.j.setVisibility(0);
            return;
        }
        FragmentStandbyPositionBinding fragmentStandbyPositionBinding8 = this.l;
        if (fragmentStandbyPositionBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentStandbyPositionBinding8 = null;
        }
        fragmentStandbyPositionBinding8.v.setVisibility(8);
        FragmentStandbyPositionBinding fragmentStandbyPositionBinding9 = this.l;
        if (fragmentStandbyPositionBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentStandbyPositionBinding9 = null;
        }
        fragmentStandbyPositionBinding9.w.setVisibility(8);
        FragmentStandbyPositionBinding fragmentStandbyPositionBinding10 = this.l;
        if (fragmentStandbyPositionBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentStandbyPositionBinding10 = null;
        }
        fragmentStandbyPositionBinding10.i.setVisibility(8);
        FragmentStandbyPositionBinding fragmentStandbyPositionBinding11 = this.l;
        if (fragmentStandbyPositionBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentStandbyPositionBinding11 = null;
        }
        fragmentStandbyPositionBinding11.h.setVisibility(8);
        FragmentStandbyPositionBinding fragmentStandbyPositionBinding12 = this.l;
        if (fragmentStandbyPositionBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentStandbyPositionBinding12 = null;
        }
        fragmentStandbyPositionBinding12.x.setVisibility(8);
        FragmentStandbyPositionBinding fragmentStandbyPositionBinding13 = this.l;
        if (fragmentStandbyPositionBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentStandbyPositionBinding = fragmentStandbyPositionBinding13;
        }
        fragmentStandbyPositionBinding.j.setVisibility(8);
    }

    public final void G1(ArrayList arrayList) {
        StringBuilder sb = new StringBuilder("");
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            String str = (String) it.next();
            StandbyComponentBottomSheet.Companion companion = StandbyComponentBottomSheet.e;
            if (Intrinsics.areEqual((Object) str, (Object) companion.f())) {
                sb.append(companion.g());
            } else if (Intrinsics.areEqual((Object) str, (Object) companion.d())) {
                sb.append(companion.e());
            } else if (Intrinsics.areEqual((Object) str, (Object) companion.l())) {
                sb.append(companion.m());
            } else if (Intrinsics.areEqual((Object) str, (Object) companion.h())) {
                sb.append(companion.i());
            } else if (Intrinsics.areEqual((Object) str, (Object) companion.j())) {
                sb.append(companion.k());
            } else if (Intrinsics.areEqual((Object) str, (Object) companion.b())) {
                sb.append(companion.c());
            }
            if (i != arrayList.size() - 1) {
                sb.append(MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML);
            }
            i = i2;
        }
        ULog.Delegate delegate = ULog.f6446a;
        int size = arrayList.size();
        delegate.a("StandbyPositionFragment", "quantity:" + size + " type:" + sb);
        SdkContext.f6675a.d().reportEvent(AppDataTrackEvent.STANDBY_COMPONENT_CLICK, MapsKt.hashMapOf(TuplesKt.to("quantity", String.valueOf(arrayList.size())), TuplesKt.to("type", sb.toString())));
    }

    public final void Z0(String str, Boolean bool, String str2) {
        LinearLayout.LayoutParams layoutParams;
        ImageView imageView = new ImageView(MainApplication.k.f().getApplicationContext());
        StandbyComponentBottomSheet.Companion companion = StandbyComponentBottomSheet.e;
        if (Intrinsics.areEqual((Object) str, (Object) companion.d())) {
            imageView.setImageResource(R.drawable.icon_standby_bar_step);
        } else if (Intrinsics.areEqual((Object) str, (Object) companion.h())) {
            imageView.setImageResource(R.drawable.icon_standby_bar_temp);
        } else if (Intrinsics.areEqual((Object) str, (Object) companion.j())) {
            imageView.setImageResource(R.drawable.icon_standby_bar_weather);
        } else if (Intrinsics.areEqual((Object) str, (Object) companion.l())) {
            imageView.setImageResource(R.drawable.icon_standby_bar_date);
        }
        float f = getResources().getDisplayMetrics().density;
        int i = (int) (((float) this.y) * f);
        int i2 = (int) (f * ((float) this.x));
        FragmentStandbyPositionBinding fragmentStandbyPositionBinding = null;
        if (Intrinsics.areEqual((Object) str, (Object) companion.j())) {
            layoutParams = new LinearLayout.LayoutParams(i, i2);
            layoutParams.weight = 1.0f;
            layoutParams.gravity = 17;
        } else {
            layoutParams = new LinearLayout.LayoutParams(i2, i2);
            FragmentStandbyPositionBinding fragmentStandbyPositionBinding2 = this.l;
            if (fragmentStandbyPositionBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentStandbyPositionBinding2 = null;
            }
            layoutParams.setMargins((fragmentStandbyPositionBinding2.m.getMeasuredWidth() - (i2 * 2)) / 3, 0, 0, 0);
        }
        imageView.setLayoutParams(layoutParams);
        imageView.setTag(str);
        FragmentStandbyPositionBinding fragmentStandbyPositionBinding3 = this.l;
        if (fragmentStandbyPositionBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentStandbyPositionBinding = fragmentStandbyPositionBinding3;
        }
        fragmentStandbyPositionBinding.m.addView(imageView);
        if (!(bool == null && str2 == null) && Intrinsics.areEqual((Object) str2, (Object) str)) {
            Intrinsics.checkNotNull(bool);
            if (!bool.booleanValue()) {
                c1(imageView);
            }
        }
    }

    public final void c1(ImageView imageView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, this.q, new float[]{this.t, this.u});
        ofFloat.setDuration(this.s);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, this.r, new float[]{this.t, this.u});
        ofFloat2.setDuration(this.s);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, this.p, new float[]{this.v, this.w});
        ofFloat3.setDuration(this.s);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
        animatorSet.start();
    }

    public final void e1(LinkedHashMap linkedHashMap, boolean z2, String str) {
        ULog.f6446a.a("StandbyPositionFragment", "changeComponent:" + linkedHashMap);
        FragmentStandbyPositionBinding fragmentStandbyPositionBinding = null;
        if (z2) {
            FragmentStandbyPositionBinding fragmentStandbyPositionBinding2 = this.l;
            if (fragmentStandbyPositionBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentStandbyPositionBinding2 = null;
            }
            int childCount = fragmentStandbyPositionBinding2.m.getChildCount();
            for (int i = 0; i < childCount; i++) {
                FragmentStandbyPositionBinding fragmentStandbyPositionBinding3 = this.l;
                if (fragmentStandbyPositionBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentStandbyPositionBinding3 = null;
                }
                View childAt = fragmentStandbyPositionBinding3.m.getChildAt(i);
                if (Intrinsics.areEqual((Object) childAt.getTag().toString(), (Object) str)) {
                    Intrinsics.checkNotNull(childAt);
                    w1(childAt, linkedHashMap);
                    return;
                }
            }
            return;
        }
        FragmentStandbyPositionBinding fragmentStandbyPositionBinding4 = this.l;
        if (fragmentStandbyPositionBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentStandbyPositionBinding = fragmentStandbyPositionBinding4;
        }
        fragmentStandbyPositionBinding.m.removeAllViews();
        linkedHashMap.forEach(new r9(new StandbyPositionFragment$changeComponent$1(this, z2, str)));
    }

    public final void g1() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new StandbyPositionFragment$checkGlassAndRingInfo$1(this, (Continuation<? super StandbyPositionFragment$checkGlassAndRingInfo$1>) null), 3, (Object) null);
    }

    public final void h1() {
        boolean g = VersionMatchHelper.g(VersionMatchHelper.f7930a, false, false, false, GlassInfoExtKt.c(GlassInfoExtKt.d("Flyme AR 1.0.9.0.20240424_Air_FR")), (String) null, GlassInfoExtKt.c(GlassInfoExtKt.d("1.1.0.274")), (String) null, 86, (Object) null);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("StandbyPositionFragment", "checkStandbyComponentIsSupport isSupport:" + g);
        if (g) {
            SuperMessageManger.m.a().t();
        }
        E1(g);
    }

    public final int k1() {
        return this.j;
    }

    public final void o1() {
        FragmentStandbyPositionBinding fragmentStandbyPositionBinding = this.l;
        if (fragmentStandbyPositionBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentStandbyPositionBinding = null;
        }
        fragmentStandbyPositionBinding.m.removeAllViews();
        String str = (String) DataStoreUtils.j(DataStoreUtils.e.a(), "standby_widget_order", "", true, (Context) null, 8, (Object) null);
        if (str.length() > 0) {
            ArrayList<String> widgets = ((StandbyWidgetOrderInfo) GsonHelper.fromJson(str, StandbyWidgetOrderInfo.class)).getValue().getWidgets();
            StandbyComponentBottomSheet.Companion companion = StandbyComponentBottomSheet.e;
            widgets.remove(companion.f());
            widgets.remove(companion.b());
            for (String a1 : widgets) {
                a1(this, a1, (Boolean) null, (String) null, 6, (Object) null);
            }
            return;
        }
        ULog.f6446a.a("StandbyPositionFragment", "initWidgetBar 本地缓存的组件信息为空");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentStandbyPositionBinding c = FragmentStandbyPositionBinding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.l = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        ConstraintLayout b = c.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        return b;
    }

    public void onDestroy() {
        this.A.removeCallbacksAndMessages((Object) null);
        super.onDestroy();
    }

    public void onDestroyView() {
        super.onDestroyView();
        v1();
        StandbyComponentBottomSheet a2 = StandbyComponentBottomSheet.e.a();
        if (a2 != null) {
            a2.dismiss();
        }
        ULog.f6446a.a("StandbyPositionFragment", "onDestroyView");
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        k0();
        initView();
        initViewModel();
        SuperMessageManger.m.a().s();
        ULog.f6446a.a("StandbyPositionFragment", "onViewCreated");
        h1();
        b1();
        FragmentStandbyPositionBinding fragmentStandbyPositionBinding = this.l;
        if (fragmentStandbyPositionBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentStandbyPositionBinding = null;
        }
        fragmentStandbyPositionBinding.m.post(new k9(this));
    }

    public final void p1(ArrayList arrayList) {
        if (((String) DataStoreUtils.j(DataStoreUtils.e.a(), "standby_widget_order", "", true, (Context) null, 8, (Object) null)).length() == 0) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("StandbyPositionFragment", "initWidgetBarByObserver:本地组件缓存为空，需要从observer加载控件 widgetList:" + arrayList);
            if (!arrayList.isEmpty()) {
                FragmentStandbyPositionBinding fragmentStandbyPositionBinding = this.l;
                if (fragmentStandbyPositionBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentStandbyPositionBinding = null;
                }
                fragmentStandbyPositionBinding.m.removeAllViews();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    a1(this, (String) it.next(), (Boolean) null, (String) null, 6, (Object) null);
                }
                ArrayList arrayList2 = new ArrayList();
                StandbyComponentBottomSheet.Companion companion = StandbyComponentBottomSheet.e;
                arrayList2.add(companion.f());
                arrayList2.addAll(arrayList);
                arrayList2.add(companion.b());
                ULog.Delegate delegate2 = ULog.f6446a;
                delegate2.a("StandbyPositionFragment", "initWidgetBarByObserver:本地保存的列表顺序 list:" + arrayList2);
                DataStoreUtils.e.a().p("standby_widget_order", GsonHelper.toJson(new StandbyWidgetOrderInfo("set_standby_widget_lists", new StandbyWidgetOrderSubInfo(arrayList2))), true);
            }
        }
    }

    public final void q1(ArrayList arrayList) {
        FragmentStandbyPositionBinding fragmentStandbyPositionBinding = this.l;
        if (fragmentStandbyPositionBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentStandbyPositionBinding = null;
        }
        fragmentStandbyPositionBinding.m.removeAllViews();
        ArrayList<String> arrayList2 = new ArrayList<>();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add((String) it.next());
        }
        StandbyComponentBottomSheet.Companion companion = StandbyComponentBottomSheet.e;
        arrayList2.remove(companion.f());
        arrayList2.remove(companion.b());
        for (String a1 : arrayList2) {
            a1(this, a1, (Boolean) null, (String) null, 6, (Object) null);
        }
    }

    public final void w1(View view, LinkedHashMap linkedHashMap) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, this.p, new float[]{this.w, this.v});
        ofFloat.setDuration(this.s);
        ofFloat.addListener(new StandbyPositionFragment$removeViewAnimation$1(this, linkedHashMap));
        ofFloat.start();
    }

    public final void x1(int i) {
        this.j = i;
    }

    public final void y1(LinkedHashMap linkedHashMap) {
        ArrayList arrayList = new ArrayList();
        StandbyComponentBottomSheet.Companion companion = StandbyComponentBottomSheet.e;
        arrayList.add(companion.f());
        linkedHashMap.forEach(new o9(new StandbyPositionFragment$setStandbyWidgetOrder$1(arrayList)));
        arrayList.add(companion.b());
        StandbyWidgetOrderInfo standbyWidgetOrderInfo = new StandbyWidgetOrderInfo("set_standby_widget_lists", new StandbyWidgetOrderSubInfo(arrayList));
        StarryMessageHelper.p(StarryMessageHelper.f7799a, (byte[]) null, "system", standbyWidgetOrderInfo, new StandbyPositionFragment$setStandbyWidgetOrder$2(this, arrayList, standbyWidgetOrderInfo), (String) null, 17, (Object) null);
    }
}
