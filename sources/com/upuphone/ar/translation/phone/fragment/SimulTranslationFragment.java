package com.upuphone.ar.translation.phone.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.honey.account.f5.r;
import com.honey.account.f5.s;
import com.honey.account.f5.t;
import com.honey.account.f5.u;
import com.honey.account.f5.v;
import com.honey.account.f5.w;
import com.honey.account.f5.x;
import com.honey.account.f5.y;
import com.honey.account.f5.z;
import com.upuphone.ar.translation.TranslationApp;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.ext.ActivityExtKt;
import com.upuphone.ar.translation.ext.ContextExtKt;
import com.upuphone.ar.translation.ext.DialogExtKt;
import com.upuphone.ar.translation.ext.InterconnectMsgCodExtKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.interconnect.entity.TranslationState;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.TranslationManager;
import com.upuphone.ar.translation.phone.adapter.SimulRunningAdapter;
import com.upuphone.ar.translation.phone.bean.LanguageBean;
import com.upuphone.ar.translation.phone.bean.OperateMessage;
import com.upuphone.ar.translation.phone.bean.SimulRunning;
import com.upuphone.ar.translation.phone.bean.TransStateEvent;
import com.upuphone.ar.translation.phone.bean.TranslationLanguage;
import com.upuphone.ar.translation.phone.databinding.FragmentSimulTranslationBinding;
import com.upuphone.ar.translation.phone.helper.RunningRecordHelper;
import com.upuphone.ar.translation.phone.view.TranslationLangDialog;
import com.upuphone.ar.translation.phone.vm.SimulTranslationViewModel;
import com.upuphone.ar.translation.statemachine.machine.TranslateStateManager;
import com.upuphone.ar.translation.utils.PreferencesUtils;
import flyme.support.v7.app.AlertDialog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0007*\u0001i\u0018\u0000 m2\u00020\u0001:\u0001nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0003J#\u0010\u0018\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b\"\u0010!J\u000f\u0010#\u001a\u00020\u000eH\u0002¢\u0006\u0004\b#\u0010\u0003J\u000f\u0010$\u001a\u00020\u000eH\u0002¢\u0006\u0004\b$\u0010\u0003J\u000f\u0010%\u001a\u00020\u000eH\u0003¢\u0006\u0004\b%\u0010\u0003J\u000f\u0010&\u001a\u00020\u000eH\u0003¢\u0006\u0004\b&\u0010\u0003J\u0017\u0010)\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020'H\u0002¢\u0006\u0004\b,\u0010*J\u0017\u0010/\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020-H\u0002¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u000eH\u0002¢\u0006\u0004\b1\u0010\u0003J\u000f\u00102\u001a\u00020\u000eH\u0002¢\u0006\u0004\b2\u0010\u0003J\u000f\u00103\u001a\u00020\u000eH\u0002¢\u0006\u0004\b3\u0010\u0003J\u000f\u00104\u001a\u00020\u000eH\u0002¢\u0006\u0004\b4\u0010\u0003J\u000f\u00105\u001a\u00020\u000eH\u0002¢\u0006\u0004\b5\u0010\u0003J\u000f\u00106\u001a\u00020\u000eH\u0002¢\u0006\u0004\b6\u0010\u0003J\u000f\u00107\u001a\u00020\u000eH\u0002¢\u0006\u0004\b7\u0010\u0003J\u0017\u0010:\u001a\u00020\u000e2\u0006\u00109\u001a\u000208H\u0002¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u000eH\u0003¢\u0006\u0004\b<\u0010\u0003J\u000f\u0010=\u001a\u00020\u000eH\u0002¢\u0006\u0004\b=\u0010\u0003J\u000f\u0010>\u001a\u00020\u000eH\u0002¢\u0006\u0004\b>\u0010\u0003J\u0017\u0010A\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020?H\u0002¢\u0006\u0004\bA\u0010BR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bD\u0010ER\u001b\u0010L\u001a\u00020G8BX\u0002¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010S\u001a\u00020'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010U\u001a\u00020'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bT\u0010RR\u0018\u0010Y\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010_\u001a\u00020'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b^\u0010RR\u0018\u0010c\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010f\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010h\u001a\u00020'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bg\u0010RR\u0014\u0010l\u001a\u00020i8\u0002X\u0004¢\u0006\u0006\n\u0004\bj\u0010k¨\u0006o"}, d2 = {"Lcom/upuphone/ar/translation/phone/fragment/SimulTranslationFragment;", "Lcom/upuphone/ar/translation/phone/fragment/TransBaseFragment;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "initView", "initData", "initListener", "T", "Lcom/upuphone/ar/translation/phone/bean/OperateMessage;", "operateMessage", "T0", "(Lcom/upuphone/ar/translation/phone/bean/OperateMessage;)V", "Lcom/upuphone/ar/translation/phone/bean/TransStateEvent;", "transStateEvent", "S0", "(Lcom/upuphone/ar/translation/phone/bean/TransStateEvent;)V", "Lcom/upuphone/ar/translation/interconnect/entity/TranslationState;", "transState", "R0", "(Lcom/upuphone/ar/translation/interconnect/entity/TranslationState;)V", "Q0", "initState", "q1", "r1", "s1", "", "isPaused", "o1", "(Z)V", "isAlpha", "p1", "Lcom/upuphone/ar/translation/phone/bean/TranslationLanguage;", "language", "c1", "(Lcom/upuphone/ar/translation/phone/bean/TranslationLanguage;)V", "d1", "l1", "n1", "k1", "m1", "e1", "Z0", "Lcom/upuphone/ar/translation/phone/bean/SimulRunning;", "simulRunning", "O0", "(Lcom/upuphone/ar/translation/phone/bean/SimulRunning;)V", "N0", "a1", "h1", "Landroidx/recyclerview/widget/LinearLayoutManager;", "manager", "j1", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "Lcom/upuphone/ar/translation/phone/databinding/FragmentSimulTranslationBinding;", "a", "Lcom/upuphone/ar/translation/phone/databinding/FragmentSimulTranslationBinding;", "mBinding", "Lcom/upuphone/ar/translation/phone/vm/SimulTranslationViewModel;", "b", "Lkotlin/Lazy;", "P0", "()Lcom/upuphone/ar/translation/phone/vm/SimulTranslationViewModel;", "mSimulTranslationVm", "", "c", "I", "mCurrentTransType", "d", "Z", "mIsTransRunning", "e", "mIsTransStopping", "Lcom/upuphone/ar/translation/phone/view/TranslationLangDialog;", "f", "Lcom/upuphone/ar/translation/phone/view/TranslationLangDialog;", "mTranslationLangDialog", "Lflyme/support/v7/app/AlertDialog;", "g", "Lflyme/support/v7/app/AlertDialog;", "mTransRunningDialog", "h", "mOppositeStartTrans", "Lcom/upuphone/ar/translation/phone/adapter/SimulRunningAdapter;", "i", "Lcom/upuphone/ar/translation/phone/adapter/SimulRunningAdapter;", "mAdapter", "j", "Landroidx/recyclerview/widget/LinearLayoutManager;", "mLayoutManager", "k", "mIsUserScrolling", "com/upuphone/ar/translation/phone/fragment/SimulTranslationFragment$mUiUpdateCallback$1", "l", "Lcom/upuphone/ar/translation/phone/fragment/SimulTranslationFragment$mUiUpdateCallback$1;", "mUiUpdateCallback", "m", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nSimulTranslationFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SimulTranslationFragment.kt\ncom/upuphone/ar/translation/phone/fragment/SimulTranslationFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,878:1\n106#2,15:879\n262#3,2:894\n262#3,2:896\n262#3,2:898\n262#3,2:900\n262#3,2:902\n262#3,2:904\n262#3,2:906\n262#3,2:908\n262#3,2:910\n262#3,2:912\n262#3,2:914\n262#3,2:916\n262#3,2:918\n262#3,2:920\n262#3,2:922\n262#3,2:924\n262#3,2:926\n262#3,2:928\n262#3,2:930\n262#3,2:932\n262#3,2:934\n262#3,2:936\n*S KotlinDebug\n*F\n+ 1 SimulTranslationFragment.kt\ncom/upuphone/ar/translation/phone/fragment/SimulTranslationFragment\n*L\n72#1:879,15\n419#1:894,2\n423#1:896,2\n425#1:898,2\n439#1:900,2\n441#1:902,2\n444#1:904,2\n449#1:906,2\n452#1:908,2\n454#1:910,2\n457#1:912,2\n460#1:914,2\n463#1:916,2\n488#1:918,2\n491#1:920,2\n494#1:922,2\n497#1:924,2\n501#1:926,2\n505#1:928,2\n507#1:930,2\n509#1:932,2\n518#1:934,2\n591#1:936,2\n*E\n"})
public final class SimulTranslationFragment extends TransBaseFragment {
    public static final Companion m = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public FragmentSimulTranslationBinding f6278a;
    public final Lazy b;
    public int c = 2;
    public boolean d;
    public boolean e;
    public TranslationLangDialog f;
    public AlertDialog g;
    public boolean h;
    public SimulRunningAdapter i;
    public LinearLayoutManager j;
    public boolean k;
    public final SimulTranslationFragment$mUiUpdateCallback$1 l = new SimulTranslationFragment$mUiUpdateCallback$1(this);

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/upuphone/ar/translation/phone/fragment/SimulTranslationFragment$Companion;", "", "<init>", "()V", "Lcom/upuphone/ar/translation/phone/fragment/SimulTranslationFragment;", "a", "()Lcom/upuphone/ar/translation/phone/fragment/SimulTranslationFragment;", "", "TAG", "Ljava/lang/String;", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SimulTranslationFragment a() {
            return new SimulTranslationFragment();
        }

        public Companion() {
        }
    }

    public SimulTranslationFragment() {
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new SimulTranslationFragment$special$$inlined$viewModels$default$2(new SimulTranslationFragment$special$$inlined$viewModels$default$1(this)));
        this.b = FragmentViewModelLazyKt.c(this, Reflection.getOrCreateKotlinClass(SimulTranslationViewModel.class), new SimulTranslationFragment$special$$inlined$viewModels$default$3(lazy), new SimulTranslationFragment$special$$inlined$viewModels$default$4((Function0) null, lazy), new SimulTranslationFragment$special$$inlined$viewModels$default$5(this, lazy));
    }

    private final void N0() {
        List f2;
        RunningRecordHelper o = TranslationManager.q.a().o();
        if (o != null && (f2 = o.f()) != null && !f2.isEmpty()) {
            P0().v();
            SimulRunningAdapter simulRunningAdapter = this.i;
            if (simulRunningAdapter != null) {
                simulRunningAdapter.r(f2);
            }
            a1();
        }
    }

    /* access modifiers changed from: private */
    public final void Q0(TranslationState translationState) {
        int extCode = translationState.getExtCode();
        String i2 = InterconnectMsgCodExtKt.i(extCode);
        LogExt.j("handleTransExtState extCode" + i2, "SimulTranslationFragment");
        if (InterconnectMsgCodExtKt.d(extCode)) {
            s1();
        } else if (InterconnectMsgCodExtKt.b(extCode)) {
            o1(true);
        } else if (InterconnectMsgCodExtKt.c(extCode)) {
            o1(false);
        }
    }

    /* access modifiers changed from: private */
    public final void R0(TranslationState translationState) {
        int transState = translationState.getTransState();
        String j2 = InterconnectMsgCodExtKt.j(transState);
        LogExt.j("handleTransState state" + j2, "SimulTranslationFragment");
        if (transState == 2) {
            s1();
        } else if (transState == 3) {
            q1();
        } else if (transState == 4) {
            r1();
        }
    }

    /* access modifiers changed from: private */
    public final void S0(TransStateEvent transStateEvent) {
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new SimulTranslationFragment$handleTranslateState$1(transStateEvent, this, (Continuation<? super SimulTranslationFragment$handleTranslateState$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void T0(OperateMessage operateMessage) {
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new SimulTranslationFragment$handleVariousMsg$1(operateMessage, this, (Continuation<? super SimulTranslationFragment$handleVariousMsg$1>) null), 3, (Object) null);
    }

    public static final void U0(SimulTranslationFragment simulTranslationFragment, View view) {
        Intrinsics.checkNotNullParameter(simulTranslationFragment, "this$0");
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding = simulTranslationFragment.f6278a;
        if (fragmentSimulTranslationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSimulTranslationBinding = null;
        }
        fragmentSimulTranslationBinding.m.playAnimation();
        simulTranslationFragment.P0().j();
    }

    public static final void V0(SimulTranslationFragment simulTranslationFragment, View view) {
        Intrinsics.checkNotNullParameter(simulTranslationFragment, "this$0");
        simulTranslationFragment.d1();
    }

    public static final void W0(SimulTranslationFragment simulTranslationFragment, View view) {
        Intrinsics.checkNotNullParameter(simulTranslationFragment, "this$0");
        simulTranslationFragment.d1();
    }

    public static final void X0(SimulTranslationFragment simulTranslationFragment, View view) {
        Intrinsics.checkNotNullParameter(simulTranslationFragment, "this$0");
        if (TranslatorConstants.isAirPro()) {
            simulTranslationFragment.l1();
        } else {
            simulTranslationFragment.k1();
        }
    }

    public static final void Y0(SimulTranslationFragment simulTranslationFragment, View view) {
        Intrinsics.checkNotNullParameter(simulTranslationFragment, "this$0");
        simulTranslationFragment.n1();
    }

    /* access modifiers changed from: private */
    public final void Z0() {
        LogExt.g("notifyTranslationStop 翻译Socket通道已经断开", "SimulTranslationFragment");
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new SimulTranslationFragment$notifyTranslationStop$1(this, (Continuation<? super SimulTranslationFragment$notifyTranslationStop$1>) null), 3, (Object) null);
    }

    private final void a1() {
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding = this.f6278a;
        if (fragmentSimulTranslationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSimulTranslationBinding = null;
        }
        fragmentSimulTranslationBinding.q.post(new y(this));
    }

    public static final void b1(SimulTranslationFragment simulTranslationFragment) {
        Intrinsics.checkNotNullParameter(simulTranslationFragment, "this$0");
        LinearLayoutManager linearLayoutManager = simulTranslationFragment.j;
        if (linearLayoutManager != null) {
            int itemCount = linearLayoutManager.getItemCount() - 1;
            View findViewByPosition = linearLayoutManager.findViewByPosition(itemCount);
            int bottom = findViewByPosition != null ? findViewByPosition.getBottom() : 0;
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding = simulTranslationFragment.f6278a;
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding2 = null;
            if (fragmentSimulTranslationBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSimulTranslationBinding = null;
            }
            RecyclerView recyclerView = fragmentSimulTranslationBinding.q;
            int height = (recyclerView.getHeight() - recyclerView.getPaddingBottom()) - bottom;
            if (simulTranslationFragment.k) {
                SimulTranslationViewModel P0 = simulTranslationFragment.P0();
                FragmentSimulTranslationBinding fragmentSimulTranslationBinding3 = simulTranslationFragment.f6278a;
                if (fragmentSimulTranslationBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                } else {
                    fragmentSimulTranslationBinding2 = fragmentSimulTranslationBinding3;
                }
                RecyclerView recyclerView2 = fragmentSimulTranslationBinding2.q;
                Intrinsics.checkNotNullExpressionValue(recyclerView2, "rvRecords");
                if (P0.l(recyclerView2) == itemCount) {
                    simulTranslationFragment.k = false;
                    if (bottom == 0) {
                        linearLayoutManager.scrollToPositionWithOffset(itemCount, 0);
                    } else if (height <= 0) {
                        linearLayoutManager.scrollToPositionWithOffset(itemCount, height);
                    }
                }
            } else if (bottom == 0) {
                linearLayoutManager.scrollToPositionWithOffset(itemCount, 0);
            } else if (height <= 0) {
                linearLayoutManager.scrollToPositionWithOffset(itemCount, height);
            }
        }
    }

    private final void d1() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (this.f == null) {
                this.f = new TranslationLangDialog(activity, new SimulTranslationFragment$showLanguageDialog$1$1(this));
            }
            TranslationLanguage translationLanguage = (TranslationLanguage) P0().n().getValue();
            if (translationLanguage != null) {
                LanguageBean src = translationLanguage.getSrc();
                LanguageBean dst = translationLanguage.getDst();
                LogExt.j("showLanguageDialog src=" + src + ", dst=" + dst, "SimulTranslationFragment");
                TranslationLangDialog translationLangDialog = this.f;
                if (translationLangDialog != null) {
                    translationLangDialog.v(src, dst);
                }
            }
            TranslationLangDialog translationLangDialog2 = this.f;
            if (translationLangDialog2 != null) {
                translationLangDialog2.A(ActivityExtKt.b(activity));
            }
            TranslationLangDialog translationLangDialog3 = this.f;
            if (translationLangDialog3 != null) {
                translationLangDialog3.show();
            }
        }
    }

    private final void e1() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            boolean z = true;
            if (this.c != 1) {
                z = false;
            }
            AlertDialog create = new AlertDialog.Builder(activity).setTitle(z ? R.string.tl_transcribe_running_start_translate : R.string.tl_translate_running_start_translate).setPositiveButton(R.string.tl_dialog_ok, (DialogInterface.OnClickListener) new w(this)).setNegativeButton(R.string.tl_dialog_cancel, (DialogInterface.OnClickListener) new x()).create();
            Intrinsics.checkNotNull(create);
            DialogExtKt.a(create);
            create.show();
            this.g = create;
        }
    }

    public static final void f1(SimulTranslationFragment simulTranslationFragment, DialogInterface dialogInterface, int i2) {
        Intrinsics.checkNotNullParameter(simulTranslationFragment, "this$0");
        TranslateStateManager p = TranslationManager.q.a().p();
        if (p != null) {
            p.y();
        }
        simulTranslationFragment.P0().x(simulTranslationFragment.c);
        simulTranslationFragment.h = true;
        simulTranslationFragment.c = 2;
        simulTranslationFragment.q1();
    }

    public static final void g1(DialogInterface dialogInterface, int i2) {
        dialogInterface.dismiss();
    }

    private final void h1() {
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding = this.f6278a;
        if (fragmentSimulTranslationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSimulTranslationBinding = null;
        }
        fragmentSimulTranslationBinding.q.post(new z(this));
    }

    public static final void i1(SimulTranslationFragment simulTranslationFragment) {
        Intrinsics.checkNotNullParameter(simulTranslationFragment, "this$0");
        LinearLayoutManager linearLayoutManager = simulTranslationFragment.j;
        if (linearLayoutManager == null) {
            return;
        }
        if (!simulTranslationFragment.k) {
            simulTranslationFragment.j1(linearLayoutManager);
            return;
        }
        SimulTranslationViewModel P0 = simulTranslationFragment.P0();
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding = simulTranslationFragment.f6278a;
        if (fragmentSimulTranslationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSimulTranslationBinding = null;
        }
        RecyclerView recyclerView = fragmentSimulTranslationBinding.q;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "rvRecords");
        if (P0.l(recyclerView) == linearLayoutManager.getItemCount() - 1) {
            simulTranslationFragment.k = false;
            simulTranslationFragment.j1(linearLayoutManager);
        }
    }

    private final void initData() {
        P0().p();
        initState();
    }

    private final void initListener() {
        TranslationApp.registerUiUpdateCallback$ar_translator_intlRelease("SimulTranslationFragment", this.l);
        P0().n().observe(getViewLifecycleOwner(), new SimulTranslationFragment$sam$androidx_lifecycle_Observer$0(new SimulTranslationFragment$initListener$1(this)));
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding = this.f6278a;
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding2 = null;
        if (fragmentSimulTranslationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSimulTranslationBinding = null;
        }
        fragmentSimulTranslationBinding.m.setOnClickListener(new r(this));
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding3 = this.f6278a;
        if (fragmentSimulTranslationBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSimulTranslationBinding3 = null;
        }
        fragmentSimulTranslationBinding3.g.setOnClickListener(new s(this));
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding4 = this.f6278a;
        if (fragmentSimulTranslationBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSimulTranslationBinding4 = null;
        }
        fragmentSimulTranslationBinding4.f.setOnClickListener(new t(this));
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding5 = this.f6278a;
        if (fragmentSimulTranslationBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSimulTranslationBinding5 = null;
        }
        fragmentSimulTranslationBinding5.b.setOnClickListener(new u(this));
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding6 = this.f6278a;
        if (fragmentSimulTranslationBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSimulTranslationBinding6 = null;
        }
        fragmentSimulTranslationBinding6.s.setOnClickListener(new v(this));
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding7 = this.f6278a;
        if (fragmentSimulTranslationBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentSimulTranslationBinding2 = fragmentSimulTranslationBinding7;
        }
        fragmentSimulTranslationBinding2.q.addOnScrollListener(new SimulTranslationFragment$initListener$7(this));
        P0().m().observe(getViewLifecycleOwner(), new SimulTranslationFragment$sam$androidx_lifecycle_Observer$0(new SimulTranslationFragment$initListener$8(this)));
    }

    private final void initState() {
        int m2 = PreferencesUtils.m();
        this.c = m2;
        LogExt.j("initState currentTransType=" + InterconnectMsgCodExtKt.k(m2), "SimulTranslationFragment");
        if (TranslationApp.isServiceOn()) {
            TranslateStateManager p = TranslationManager.q.a().p();
            boolean z = !(p != null ? p.e() : false);
            this.d = z;
            LogExt.j("initState isTransRunning=" + z, "SimulTranslationFragment");
        }
        boolean z2 = this.d;
        if (!z2) {
            this.c = 2;
        }
        if (this.c == 2) {
            if (!z2) {
                s1();
                return;
            }
            TranslateStateManager p2 = TranslationManager.q.a().p();
            if (p2 == null || !p2.g()) {
                r1();
            } else {
                q1();
            }
        }
    }

    private final void initView() {
        this.i = new SimulRunningAdapter(R.layout.item_simul_trans_running, new ArrayList());
        boolean z = false;
        this.j = new LinearLayoutManager(requireActivity(), 1, false);
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding = this.f6278a;
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding2 = null;
        if (fragmentSimulTranslationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSimulTranslationBinding = null;
        }
        fragmentSimulTranslationBinding.q.setLayoutManager(this.j);
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding3 = this.f6278a;
        if (fragmentSimulTranslationBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSimulTranslationBinding3 = null;
        }
        fragmentSimulTranslationBinding3.q.setItemAnimator((RecyclerView.ItemAnimator) null);
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding4 = this.f6278a;
        if (fragmentSimulTranslationBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSimulTranslationBinding4 = null;
        }
        fragmentSimulTranslationBinding4.q.setAdapter(this.i);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            z = ContextExtKt.f(activity);
        }
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding5 = this.f6278a;
        if (fragmentSimulTranslationBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentSimulTranslationBinding2 = fragmentSimulTranslationBinding5;
        }
        fragmentSimulTranslationBinding2.m.setScaleX(z ? -1.0f : 1.0f);
    }

    private final void j1(LinearLayoutManager linearLayoutManager) {
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding = this.f6278a;
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding2 = null;
        if (fragmentSimulTranslationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSimulTranslationBinding = null;
        }
        int computeVerticalScrollRange = fragmentSimulTranslationBinding.q.computeVerticalScrollRange();
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding3 = this.f6278a;
        if (fragmentSimulTranslationBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSimulTranslationBinding3 = null;
        }
        if (computeVerticalScrollRange >= fragmentSimulTranslationBinding3.q.getHeight()) {
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding4 = this.f6278a;
            if (fragmentSimulTranslationBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                fragmentSimulTranslationBinding2 = fragmentSimulTranslationBinding4;
            }
            SimulTranslationFragment$smoothScrollToBottomInternal$scroller$1 simulTranslationFragment$smoothScrollToBottomInternal$scroller$1 = new SimulTranslationFragment$smoothScrollToBottomInternal$scroller$1(fragmentSimulTranslationBinding2.q.getContext());
            simulTranslationFragment$smoothScrollToBottomInternal$scroller$1.setTargetPosition(linearLayoutManager.getItemCount() - 1);
            linearLayoutManager.startSmoothScroll(simulTranslationFragment$smoothScrollToBottomInternal$scroller$1);
        }
    }

    private final void l1() {
        if (!P0().r()) {
            P0().D(R.string.tl_toast_glass_disconnected_tap);
        } else if (TranslatorConstants.isAirOldLanguage()) {
            P0().D(R.string.tl_upgrade_glass_version_tips);
        } else if (this.e) {
            P0().D(R.string.tl_trans_start_abnormal);
        } else if (this.c != 2) {
            e1();
        } else {
            m1();
        }
    }

    /* access modifiers changed from: private */
    public final void m1() {
        this.c = 2;
        q1();
        P0().B();
        P0().w();
    }

    private final void n1() {
        TranslateStateManager p = TranslationManager.q.a().p();
        if (p != null) {
            p.y();
        }
        SimulTranslationViewModel.y(P0(), 0, 1, (Object) null);
        this.e = true;
    }

    private final void o1(boolean z) {
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding = null;
        if (TranslatorConstants.isAirPro()) {
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding2 = this.f6278a;
            if (fragmentSimulTranslationBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSimulTranslationBinding2 = null;
            }
            fragmentSimulTranslationBinding2.x.setText(getString(z ? R.string.tl_paused : R.string.tl_simultaneous_in_translate));
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding3 = this.f6278a;
            if (fragmentSimulTranslationBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                fragmentSimulTranslationBinding = fragmentSimulTranslationBinding3;
            }
            fragmentSimulTranslationBinding.x.requestLayout();
            return;
        }
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding4 = this.f6278a;
        if (fragmentSimulTranslationBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSimulTranslationBinding4 = null;
        }
        fragmentSimulTranslationBinding4.w.setText(getString(z ? R.string.tl_paused : R.string.tl_simultaneous_in_translate));
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding5 = this.f6278a;
        if (fragmentSimulTranslationBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentSimulTranslationBinding = fragmentSimulTranslationBinding5;
        }
        fragmentSimulTranslationBinding.w.requestLayout();
    }

    private final void p1(boolean z) {
        float f2 = z ? 0.25f : 1.0f;
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding = this.f6278a;
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding2 = null;
        if (fragmentSimulTranslationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSimulTranslationBinding = null;
        }
        fragmentSimulTranslationBinding.m.setAlpha(f2);
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding3 = this.f6278a;
        if (fragmentSimulTranslationBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSimulTranslationBinding3 = null;
        }
        fragmentSimulTranslationBinding3.y.setAlpha(f2);
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding4 = this.f6278a;
        if (fragmentSimulTranslationBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentSimulTranslationBinding2 = fragmentSimulTranslationBinding4;
        }
        fragmentSimulTranslationBinding2.v.setAlpha(f2);
    }

    private final void q1() {
        LogExt.g("updatePreparingUI ", "SimulTranslationFragment");
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding = this.f6278a;
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding2 = null;
        if (fragmentSimulTranslationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSimulTranslationBinding = null;
        }
        Group group = fragmentSimulTranslationBinding.i;
        Intrinsics.checkNotNullExpressionValue(group, "gpTransLang");
        group.setVisibility(0);
        p1(true);
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding3 = this.f6278a;
        if (fragmentSimulTranslationBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSimulTranslationBinding3 = null;
        }
        TextView textView = fragmentSimulTranslationBinding3.u;
        Intrinsics.checkNotNullExpressionValue(textView, "tvTransBtn");
        textView.setVisibility(8);
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding4 = this.f6278a;
        if (fragmentSimulTranslationBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSimulTranslationBinding4 = null;
        }
        LottieAnimationView lottieAnimationView = fragmentSimulTranslationBinding4.n;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "lottieTransLoading");
        lottieAnimationView.setVisibility(0);
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding5 = this.f6278a;
        if (fragmentSimulTranslationBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSimulTranslationBinding5 = null;
        }
        fragmentSimulTranslationBinding5.n.setRepeatCount(-1);
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding6 = this.f6278a;
        if (fragmentSimulTranslationBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentSimulTranslationBinding2 = fragmentSimulTranslationBinding6;
        }
        fragmentSimulTranslationBinding2.n.playAnimation();
    }

    private final void r1() {
        List data;
        LogExt.g("updateStartUI", "SimulTranslationFragment");
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding = null;
        if (TranslatorConstants.isAirPro()) {
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding2 = this.f6278a;
            if (fragmentSimulTranslationBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSimulTranslationBinding2 = null;
            }
            ConstraintLayout constraintLayout = fragmentSimulTranslationBinding2.c;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "clTransFunc");
            constraintLayout.setVisibility(8);
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding3 = this.f6278a;
            if (fragmentSimulTranslationBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSimulTranslationBinding3 = null;
            }
            LottieAnimationView lottieAnimationView = fragmentSimulTranslationBinding3.n;
            Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "lottieTransLoading");
            lottieAnimationView.setVisibility(8);
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding4 = this.f6278a;
            if (fragmentSimulTranslationBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSimulTranslationBinding4 = null;
            }
            fragmentSimulTranslationBinding4.n.cancelAnimation();
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding5 = this.f6278a;
            if (fragmentSimulTranslationBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSimulTranslationBinding5 = null;
            }
            ConstraintLayout constraintLayout2 = fragmentSimulTranslationBinding5.d;
            Intrinsics.checkNotNullExpressionValue(constraintLayout2, "clTransRunning");
            constraintLayout2.setVisibility(0);
            o1(false);
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding6 = this.f6278a;
            if (fragmentSimulTranslationBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSimulTranslationBinding6 = null;
            }
            fragmentSimulTranslationBinding6.p.setRepeatCount(-1);
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding7 = this.f6278a;
            if (fragmentSimulTranslationBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSimulTranslationBinding7 = null;
            }
            fragmentSimulTranslationBinding7.p.playAnimation();
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding8 = this.f6278a;
            if (fragmentSimulTranslationBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                fragmentSimulTranslationBinding = fragmentSimulTranslationBinding8;
            }
            LinearLayout linearLayout = fragmentSimulTranslationBinding.l;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "llRecords");
            linearLayout.setVisibility(0);
        } else {
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding9 = this.f6278a;
            if (fragmentSimulTranslationBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSimulTranslationBinding9 = null;
            }
            Group group = fragmentSimulTranslationBinding9.i;
            Intrinsics.checkNotNullExpressionValue(group, "gpTransLang");
            group.setVisibility(8);
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding10 = this.f6278a;
            if (fragmentSimulTranslationBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSimulTranslationBinding10 = null;
            }
            Group group2 = fragmentSimulTranslationBinding10.j;
            Intrinsics.checkNotNullExpressionValue(group2, "gpTransRunning");
            group2.setVisibility(0);
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding11 = this.f6278a;
            if (fragmentSimulTranslationBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSimulTranslationBinding11 = null;
            }
            fragmentSimulTranslationBinding11.o.setRepeatCount(-1);
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding12 = this.f6278a;
            if (fragmentSimulTranslationBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSimulTranslationBinding12 = null;
            }
            fragmentSimulTranslationBinding12.o.playAnimation();
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding13 = this.f6278a;
            if (fragmentSimulTranslationBinding13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSimulTranslationBinding13 = null;
            }
            TextView textView = fragmentSimulTranslationBinding13.u;
            Intrinsics.checkNotNullExpressionValue(textView, "tvTransBtn");
            textView.setVisibility(0);
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding14 = this.f6278a;
            if (fragmentSimulTranslationBinding14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSimulTranslationBinding14 = null;
            }
            fragmentSimulTranslationBinding14.u.setText(R.string.tl_simultaneous_stop);
            o1(false);
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding15 = this.f6278a;
            if (fragmentSimulTranslationBinding15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSimulTranslationBinding15 = null;
            }
            LottieAnimationView lottieAnimationView2 = fragmentSimulTranslationBinding15.n;
            Intrinsics.checkNotNullExpressionValue(lottieAnimationView2, "lottieTransLoading");
            lottieAnimationView2.setVisibility(8);
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding16 = this.f6278a;
            if (fragmentSimulTranslationBinding16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSimulTranslationBinding16 = null;
            }
            fragmentSimulTranslationBinding16.n.cancelAnimation();
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding17 = this.f6278a;
            if (fragmentSimulTranslationBinding17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                fragmentSimulTranslationBinding = fragmentSimulTranslationBinding17;
            }
            LinearLayout linearLayout2 = fragmentSimulTranslationBinding.l;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "llRecords");
            linearLayout2.setVisibility(8);
        }
        SimulRunningAdapter simulRunningAdapter = this.i;
        if (!(simulRunningAdapter == null || (data = simulRunningAdapter.getData()) == null)) {
            data.clear();
        }
        SimulRunningAdapter simulRunningAdapter2 = this.i;
        if (simulRunningAdapter2 != null) {
            simulRunningAdapter2.notifyDataSetChanged();
        }
        P0().t(false);
        N0();
        this.k = false;
        this.d = true;
    }

    /* access modifiers changed from: private */
    public final void s1() {
        List data;
        LogExt.g("updateStopUI", "SimulTranslationFragment");
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding = null;
        if (TranslatorConstants.isAirPro()) {
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding2 = this.f6278a;
            if (fragmentSimulTranslationBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSimulTranslationBinding2 = null;
            }
            ConstraintLayout constraintLayout = fragmentSimulTranslationBinding2.c;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "clTransFunc");
            constraintLayout.setVisibility(0);
            p1(false);
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding3 = this.f6278a;
            if (fragmentSimulTranslationBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSimulTranslationBinding3 = null;
            }
            LottieAnimationView lottieAnimationView = fragmentSimulTranslationBinding3.n;
            Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "lottieTransLoading");
            lottieAnimationView.setVisibility(8);
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding4 = this.f6278a;
            if (fragmentSimulTranslationBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSimulTranslationBinding4 = null;
            }
            fragmentSimulTranslationBinding4.n.cancelAnimation();
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding5 = this.f6278a;
            if (fragmentSimulTranslationBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSimulTranslationBinding5 = null;
            }
            TextView textView = fragmentSimulTranslationBinding5.u;
            Intrinsics.checkNotNullExpressionValue(textView, "tvTransBtn");
            textView.setVisibility(0);
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding6 = this.f6278a;
            if (fragmentSimulTranslationBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSimulTranslationBinding6 = null;
            }
            fragmentSimulTranslationBinding6.u.setText(R.string.tl_simultaneous_start);
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding7 = this.f6278a;
            if (fragmentSimulTranslationBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSimulTranslationBinding7 = null;
            }
            ConstraintLayout constraintLayout2 = fragmentSimulTranslationBinding7.d;
            Intrinsics.checkNotNullExpressionValue(constraintLayout2, "clTransRunning");
            constraintLayout2.setVisibility(8);
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding8 = this.f6278a;
            if (fragmentSimulTranslationBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSimulTranslationBinding8 = null;
            }
            fragmentSimulTranslationBinding8.p.cancelAnimation();
        } else {
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding9 = this.f6278a;
            if (fragmentSimulTranslationBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSimulTranslationBinding9 = null;
            }
            Group group = fragmentSimulTranslationBinding9.i;
            Intrinsics.checkNotNullExpressionValue(group, "gpTransLang");
            group.setVisibility(0);
            p1(false);
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding10 = this.f6278a;
            if (fragmentSimulTranslationBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSimulTranslationBinding10 = null;
            }
            Group group2 = fragmentSimulTranslationBinding10.j;
            Intrinsics.checkNotNullExpressionValue(group2, "gpTransRunning");
            group2.setVisibility(8);
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding11 = this.f6278a;
            if (fragmentSimulTranslationBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSimulTranslationBinding11 = null;
            }
            fragmentSimulTranslationBinding11.o.cancelAnimation();
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding12 = this.f6278a;
            if (fragmentSimulTranslationBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSimulTranslationBinding12 = null;
            }
            TextView textView2 = fragmentSimulTranslationBinding12.u;
            Intrinsics.checkNotNullExpressionValue(textView2, "tvTransBtn");
            textView2.setVisibility(0);
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding13 = this.f6278a;
            if (fragmentSimulTranslationBinding13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSimulTranslationBinding13 = null;
            }
            fragmentSimulTranslationBinding13.u.setText(R.string.tl_simultaneous_start);
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding14 = this.f6278a;
            if (fragmentSimulTranslationBinding14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSimulTranslationBinding14 = null;
            }
            LottieAnimationView lottieAnimationView2 = fragmentSimulTranslationBinding14.n;
            Intrinsics.checkNotNullExpressionValue(lottieAnimationView2, "lottieTransLoading");
            lottieAnimationView2.setVisibility(8);
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding15 = this.f6278a;
            if (fragmentSimulTranslationBinding15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSimulTranslationBinding15 = null;
            }
            fragmentSimulTranslationBinding15.n.cancelAnimation();
        }
        SimulRunningAdapter simulRunningAdapter = this.i;
        if (!(simulRunningAdapter == null || (data = simulRunningAdapter.getData()) == null)) {
            data.clear();
        }
        SimulRunningAdapter simulRunningAdapter2 = this.i;
        if (simulRunningAdapter2 != null) {
            simulRunningAdapter2.notifyDataSetChanged();
        }
        P0().t(false);
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding16 = this.f6278a;
        if (fragmentSimulTranslationBinding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentSimulTranslationBinding = fragmentSimulTranslationBinding16;
        }
        LinearLayout linearLayout = fragmentSimulTranslationBinding.l;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "llRecords");
        linearLayout.setVisibility(8);
        this.k = false;
        this.d = false;
        this.e = false;
    }

    public final void O0(SimulRunning simulRunning) {
        SimulRunningAdapter simulRunningAdapter = this.i;
        if (simulRunningAdapter != null) {
            P0().v();
            if (simulRunning.getItemUpdateType() == 1) {
                simulRunningAdapter.q(simulRunning);
                h1();
                return;
            }
            for (IndexedValue indexedValue : CollectionsKt.reversed(CollectionsKt.withIndex(simulRunningAdapter.getData()))) {
                int component1 = indexedValue.component1();
                SimulRunning simulRunning2 = (SimulRunning) indexedValue.component2();
                if (simulRunning.getItemUpdateIndex() == simulRunning2.getItemUpdateIndex()) {
                    LogExt.g("update[" + simulRunning + "], original=" + simulRunning2, "SimulTranslationFragment");
                    simulRunningAdapter.j0(component1, simulRunning);
                    h1();
                    return;
                }
            }
        }
    }

    public final SimulTranslationViewModel P0() {
        return (SimulTranslationViewModel) this.b.getValue();
    }

    public final void c1(TranslationLanguage translationLanguage) {
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding = this.f6278a;
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding2 = null;
        if (fragmentSimulTranslationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSimulTranslationBinding = null;
        }
        fragmentSimulTranslationBinding.y.setText(translationLanguage.getSrc().getLangName());
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding3 = this.f6278a;
        if (fragmentSimulTranslationBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSimulTranslationBinding3 = null;
        }
        fragmentSimulTranslationBinding3.v.setText(translationLanguage.getDst().getLangName());
        P0().v();
        if (!TranslatorConstants.isMicroSoftAsr()) {
            String langType = translationLanguage.getSrc().getLangType();
            String langType2 = translationLanguage.getDst().getLangType();
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding4 = this.f6278a;
            if (fragmentSimulTranslationBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                fragmentSimulTranslationBinding2 = fragmentSimulTranslationBinding4;
            }
            TextView textView = fragmentSimulTranslationBinding2.t;
            Intrinsics.checkNotNullExpressionValue(textView, "tvTransAutoTips");
            int i2 = 0;
            if (!((Intrinsics.areEqual((Object) langType, (Object) "cn") && Intrinsics.areEqual((Object) langType2, (Object) "cnen")) || (Intrinsics.areEqual((Object) langType, (Object) "cnen") && Intrinsics.areEqual((Object) langType2, (Object) "cn")))) {
                i2 = 8;
            }
            textView.setVisibility(i2);
        }
    }

    public final void k1() {
        if (!this.d) {
            l1();
        } else if (this.c != 2) {
            e1();
        } else {
            n1();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentSimulTranslationBinding c2 = FragmentSimulTranslationBinding.c(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
        this.f6278a = c2;
        if (c2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            c2 = null;
        }
        ConstraintLayout b2 = c2.getRoot();
        Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
        return b2;
    }

    public void onDestroyView() {
        super.onDestroyView();
        LogExt.j("onDestroyView 同传翻译页面销毁", "SimulTranslationFragment");
        P0().E();
        this.d = false;
        this.e = false;
        TranslationLangDialog translationLangDialog = this.f;
        if (translationLangDialog != null) {
            translationLangDialog.dismiss();
        }
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding = null;
        this.f = null;
        this.c = 2;
        AlertDialog alertDialog = this.g;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        this.g = null;
        this.h = false;
        this.k = false;
        TranslationApp.unRegisterUiUpdateCallback$ar_translator_intlRelease("SimulTranslationFragment");
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding2 = this.f6278a;
        if (fragmentSimulTranslationBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSimulTranslationBinding2 = null;
        }
        if (fragmentSimulTranslationBinding2.m.isAnimating()) {
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding3 = this.f6278a;
            if (fragmentSimulTranslationBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSimulTranslationBinding3 = null;
            }
            fragmentSimulTranslationBinding3.m.cancelAnimation();
        }
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding4 = this.f6278a;
        if (fragmentSimulTranslationBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSimulTranslationBinding4 = null;
        }
        if (fragmentSimulTranslationBinding4.o.isAnimating()) {
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding5 = this.f6278a;
            if (fragmentSimulTranslationBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSimulTranslationBinding5 = null;
            }
            fragmentSimulTranslationBinding5.o.cancelAnimation();
        }
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding6 = this.f6278a;
        if (fragmentSimulTranslationBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSimulTranslationBinding6 = null;
        }
        if (fragmentSimulTranslationBinding6.n.isAnimating()) {
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding7 = this.f6278a;
            if (fragmentSimulTranslationBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSimulTranslationBinding7 = null;
            }
            fragmentSimulTranslationBinding7.n.cancelAnimation();
        }
        FragmentSimulTranslationBinding fragmentSimulTranslationBinding8 = this.f6278a;
        if (fragmentSimulTranslationBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSimulTranslationBinding8 = null;
        }
        if (fragmentSimulTranslationBinding8.p.isAnimating()) {
            FragmentSimulTranslationBinding fragmentSimulTranslationBinding9 = this.f6278a;
            if (fragmentSimulTranslationBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                fragmentSimulTranslationBinding = fragmentSimulTranslationBinding9;
            }
            fragmentSimulTranslationBinding.p.cancelAnimation();
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView();
        initData();
        initListener();
    }
}
