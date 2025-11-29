package com.upuphone.xr.sapp.fragment;

import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.honey.account.h8.ta;
import com.honey.account.h8.va;
import com.honey.account.h8.wa;
import com.honey.account.h8.xa;
import com.honey.account.h8.ya;
import com.meizu.common.widget.MzButton;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.RoleVprintActivity;
import com.upuphone.xr.sapp.databinding.FragmentVoiceprintSepatateRoleRecordBinding;
import com.upuphone.xr.sapp.pag.LibPag;
import com.upuphone.xr.sapp.pag.PagParam;
import com.upuphone.xr.sapp.utils.NetworkUtils;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.view.SappTitleBar;
import com.upuphone.xr.sapp.vm.RoleVprintViewModel;
import com.xjsd.xr.sapp.asr.dao.AsrResult;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.libpag.PAGImageView;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001R\u0018\u0000 Z2\u00020\u00012\u00020\u0002:\u0001[B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u0019\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0012\u0010\u0004J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0018\u001a\u00020\u0005*\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001a\u0010\u0004J\u000f\u0010\u001b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001b\u0010\u0004J\u000f\u0010\u001c\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001c\u0010\u0004J\u0019\u0010\u001f\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J+\u0010&\u001a\u00020%2\u0006\u0010\"\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b&\u0010'J!\u0010)\u001a\u00020\u00052\u0006\u0010(\u001a\u00020%2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0005H\u0016¢\u0006\u0004\b+\u0010\u0004R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00102\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u001b\u0010D\u001a\u00020?8BX\u0002¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010O\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010Q\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u0010NR\u0014\u0010U\u001a\u00020R8\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010Y\u001a\u00020V8\u0016X\u0005¢\u0006\u0006\u001a\u0004\bW\u0010X¨\u0006\\"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/VoiceprintSrRecordFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "", "initView", "initData", "initListener", "initViewModels", "q1", "", "isNetworkError", "r1", "(Z)V", "f1", "h1", "n1", "d1", "Lcom/xjsd/xr/sapp/asr/dao/AsrResult;", "asrResult", "g1", "(Lcom/xjsd/xr/sapp/asr/dao/AsrResult;)V", "", "m1", "(Ljava/lang/String;)V", "o1", "p1", "c1", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "Lcom/upuphone/xr/sapp/databinding/FragmentVoiceprintSepatateRoleRecordBinding;", "k", "Lcom/upuphone/xr/sapp/databinding/FragmentVoiceprintSepatateRoleRecordBinding;", "mBinding", "l", "Lkotlinx/coroutines/CoroutineScope;", "mIoScope", "", "m", "[B", "mAudioBytes", "", "n", "I", "mRecordSeconds", "Lkotlinx/coroutines/Job;", "o", "Lkotlinx/coroutines/Job;", "mRecordTimingJob", "Lcom/upuphone/xr/sapp/vm/RoleVprintViewModel;", "p", "Lkotlin/Lazy;", "e1", "()Lcom/upuphone/xr/sapp/vm/RoleVprintViewModel;", "mRoleVprintVm", "", "q", "J", "mAsrResultTime", "Landroid/os/Vibrator;", "r", "Landroid/os/Vibrator;", "mVibrator", "s", "Z", "mIsAppForeground", "t", "mIsAppBackgroundStopTts", "com/upuphone/xr/sapp/fragment/VoiceprintSrRecordFragment$mRoleVpObserver$1", "u", "Lcom/upuphone/xr/sapp/fragment/VoiceprintSrRecordFragment$mRoleVpObserver$1;", "mRoleVpObserver", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "v", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nVoiceprintSrRecordFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoiceprintSrRecordFragment.kt\ncom/upuphone/xr/sapp/fragment/VoiceprintSrRecordFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,598:1\n106#2,15:599\n256#3,2:614\n256#3,2:616\n256#3,2:618\n256#3,2:620\n256#3,2:622\n256#3,2:624\n256#3,2:626\n256#3,2:628\n*S KotlinDebug\n*F\n+ 1 VoiceprintSrRecordFragment.kt\ncom/upuphone/xr/sapp/fragment/VoiceprintSrRecordFragment\n*L\n70#1:599,15\n109#1:614,2\n113#1:616,2\n298#1:618,2\n300#1:620,2\n302#1:622,2\n543#1:624,2\n555#1:626,2\n567#1:628,2\n*E\n"})
public final class VoiceprintSrRecordFragment extends BaseFragment implements CoroutineScope {
    public static final Companion v = new Companion((DefaultConstructorMarker) null);
    public final /* synthetic */ CoroutineScope j = CoroutineScopeKt.b();
    public FragmentVoiceprintSepatateRoleRecordBinding k;
    public final CoroutineScope l = CoroutineScopeKt.a(SupervisorKt.b((Job) null, 1, (Object) null).plus(Dispatchers.b()));
    public byte[] m = new byte[0];
    public int n;
    public Job o;
    public final Lazy p;
    public long q;
    public Vibrator r;
    public boolean s;
    public boolean t;
    public final VoiceprintSrRecordFragment$mRoleVpObserver$1 u;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/VoiceprintSrRecordFragment$Companion;", "", "()V", "FIVE_THOUSAND_MILLISECOND", "", "ONE_THOUSAND_MILLISECOND", "RECORD_SECONDS", "", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public VoiceprintSrRecordFragment() {
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new VoiceprintSrRecordFragment$special$$inlined$viewModels$default$2(new VoiceprintSrRecordFragment$special$$inlined$viewModels$default$1(this)));
        this.p = FragmentViewModelLazyKt.c(this, Reflection.getOrCreateKotlinClass(RoleVprintViewModel.class), new VoiceprintSrRecordFragment$special$$inlined$viewModels$default$3(lazy), new VoiceprintSrRecordFragment$special$$inlined$viewModels$default$4((Function0) null, lazy), new VoiceprintSrRecordFragment$special$$inlined$viewModels$default$5(this, lazy));
        this.u = new VoiceprintSrRecordFragment$mRoleVpObserver$1(this);
    }

    public static final void i1(VoiceprintSrRecordFragment voiceprintSrRecordFragment, View view) {
        Intrinsics.checkNotNullParameter(voiceprintSrRecordFragment, "this$0");
        voiceprintSrRecordFragment.d1();
    }

    private final void initListener() {
        FragmentVoiceprintSepatateRoleRecordBinding fragmentVoiceprintSepatateRoleRecordBinding = this.k;
        FragmentVoiceprintSepatateRoleRecordBinding fragmentVoiceprintSepatateRoleRecordBinding2 = null;
        if (fragmentVoiceprintSepatateRoleRecordBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentVoiceprintSepatateRoleRecordBinding = null;
        }
        fragmentVoiceprintSepatateRoleRecordBinding.e.k(new VoiceprintSrRecordFragment$initListener$1(this));
        FragmentActivity activity = getActivity();
        if (activity != null) {
            OnBackPressedDispatcherKt.a(activity.getOnBackPressedDispatcher(), this, true, new VoiceprintSrRecordFragment$initListener$2$1(this, activity));
        }
        FragmentVoiceprintSepatateRoleRecordBinding fragmentVoiceprintSepatateRoleRecordBinding3 = this.k;
        if (fragmentVoiceprintSepatateRoleRecordBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentVoiceprintSepatateRoleRecordBinding3 = null;
        }
        fragmentVoiceprintSepatateRoleRecordBinding3.b.b.setOnClickListener(new va(this));
        FragmentVoiceprintSepatateRoleRecordBinding fragmentVoiceprintSepatateRoleRecordBinding4 = this.k;
        if (fragmentVoiceprintSepatateRoleRecordBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentVoiceprintSepatateRoleRecordBinding4 = null;
        }
        fragmentVoiceprintSepatateRoleRecordBinding4.c.d.setOnClickListener(new wa(this));
        FragmentVoiceprintSepatateRoleRecordBinding fragmentVoiceprintSepatateRoleRecordBinding5 = this.k;
        if (fragmentVoiceprintSepatateRoleRecordBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentVoiceprintSepatateRoleRecordBinding5 = null;
        }
        fragmentVoiceprintSepatateRoleRecordBinding5.c.c.setOnClickListener(new xa(this));
        FragmentVoiceprintSepatateRoleRecordBinding fragmentVoiceprintSepatateRoleRecordBinding6 = this.k;
        if (fragmentVoiceprintSepatateRoleRecordBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentVoiceprintSepatateRoleRecordBinding2 = fragmentVoiceprintSepatateRoleRecordBinding6;
        }
        fragmentVoiceprintSepatateRoleRecordBinding2.d.c.setOnClickListener(new ya(this));
    }

    private final void initView() {
        getLifecycle().a(this.u);
        FragmentVoiceprintSepatateRoleRecordBinding fragmentVoiceprintSepatateRoleRecordBinding = this.k;
        FragmentVoiceprintSepatateRoleRecordBinding fragmentVoiceprintSepatateRoleRecordBinding2 = null;
        if (fragmentVoiceprintSepatateRoleRecordBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentVoiceprintSepatateRoleRecordBinding = null;
        }
        ConstraintLayout b = fragmentVoiceprintSepatateRoleRecordBinding.b.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        int i = 0;
        b.setVisibility(0);
        FragmentVoiceprintSepatateRoleRecordBinding fragmentVoiceprintSepatateRoleRecordBinding3 = this.k;
        if (fragmentVoiceprintSepatateRoleRecordBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentVoiceprintSepatateRoleRecordBinding3 = null;
        }
        SappTitleBar sappTitleBar = fragmentVoiceprintSepatateRoleRecordBinding3.e;
        String string = getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        sappTitleBar.setBackText(string);
        o1();
        FragmentVoiceprintSepatateRoleRecordBinding fragmentVoiceprintSepatateRoleRecordBinding4 = this.k;
        if (fragmentVoiceprintSepatateRoleRecordBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentVoiceprintSepatateRoleRecordBinding2 = fragmentVoiceprintSepatateRoleRecordBinding4;
        }
        MzButton mzButton = fragmentVoiceprintSepatateRoleRecordBinding2.c.d;
        Intrinsics.checkNotNullExpressionValue(mzButton, "mbtWake");
        if (!(!BuildConfig.f6575a.booleanValue())) {
            i = 8;
        }
        mzButton.setVisibility(i);
    }

    public static final void j1(VoiceprintSrRecordFragment voiceprintSrRecordFragment, View view) {
        Intrinsics.checkNotNullParameter(voiceprintSrRecordFragment, "this$0");
        int i = R.id.wakeupRecordMainFragment;
        FragmentActivity activity = voiceprintSrRecordFragment.getActivity();
        StaticMethodUtilsKt.u(voiceprintSrRecordFragment, i, activity != null ? activity instanceof RoleVprintActivity ? R.id.voiceprintSrInfoFragment : R.id.voiceprintInfoFragment : R.id.voiceprintInfoFragment);
    }

    public static final void k1(VoiceprintSrRecordFragment voiceprintSrRecordFragment, View view) {
        Intrinsics.checkNotNullParameter(voiceprintSrRecordFragment, "this$0");
        StaticMethodUtilsKt.q(voiceprintSrRecordFragment);
    }

    public static final void l1(VoiceprintSrRecordFragment voiceprintSrRecordFragment, View view) {
        Intrinsics.checkNotNullParameter(voiceprintSrRecordFragment, "this$0");
        if (NetworkUtils.f7898a.g()) {
            voiceprintSrRecordFragment.q1();
            return;
        }
        FragmentActivity activity = voiceprintSrRecordFragment.getActivity();
        if (activity != null) {
            voiceprintSrRecordFragment.e1().g0(activity);
        }
    }

    public static /* synthetic */ void s1(VoiceprintSrRecordFragment voiceprintSrRecordFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        voiceprintSrRecordFragment.r1(z);
    }

    public final void c1() {
        FragmentVoiceprintSepatateRoleRecordBinding fragmentVoiceprintSepatateRoleRecordBinding = this.k;
        FragmentVoiceprintSepatateRoleRecordBinding fragmentVoiceprintSepatateRoleRecordBinding2 = null;
        if (fragmentVoiceprintSepatateRoleRecordBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentVoiceprintSepatateRoleRecordBinding = null;
        }
        PAGImageView pAGImageView = fragmentVoiceprintSepatateRoleRecordBinding.b.c;
        Intrinsics.checkNotNullExpressionValue(pAGImageView, "pagRecord");
        pAGImageView.setVisibility(8);
        FragmentVoiceprintSepatateRoleRecordBinding fragmentVoiceprintSepatateRoleRecordBinding3 = this.k;
        if (fragmentVoiceprintSepatateRoleRecordBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentVoiceprintSepatateRoleRecordBinding2 = fragmentVoiceprintSepatateRoleRecordBinding3;
        }
        fragmentVoiceprintSepatateRoleRecordBinding2.b.c.clearAnimation();
    }

    public final void d1() {
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new VoiceprintSrRecordFragment$generateVoiceprint$1(this, (Continuation<? super VoiceprintSrRecordFragment$generateVoiceprint$1>) null), 3, (Object) null);
    }

    public final RoleVprintViewModel e1() {
        return (RoleVprintViewModel) this.p.getValue();
    }

    public final void f1() {
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new VoiceprintSrRecordFragment$handleAsrOpened$1(this, (Continuation<? super VoiceprintSrRecordFragment$handleAsrOpened$1>) null), 3, (Object) null);
    }

    public final void g1(AsrResult asrResult) {
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new VoiceprintSrRecordFragment$handleAsrResult$1(asrResult, this, (Continuation<? super VoiceprintSrRecordFragment$handleAsrResult$1>) null), 3, (Object) null);
    }

    public CoroutineContext getCoroutineContext() {
        return this.j.getCoroutineContext();
    }

    public final void h1() {
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new VoiceprintSrRecordFragment$handleRecordCompleted$1(this, (Continuation<? super VoiceprintSrRecordFragment$handleRecordCompleted$1>) null), 3, (Object) null);
    }

    public final void initData() {
        Vibrator vibrator;
        e1().Q();
        RoleVprintViewModel e1 = e1();
        String string = getString(R.string.vp_separate_role_spoken_word_tip);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        e1.X(string);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (Build.VERSION.SDK_INT >= 31) {
                Object systemService = activity.getSystemService("vibrator_manager");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.VibratorManager");
                vibrator = ta.a(systemService).getDefaultVibrator();
            } else {
                Object systemService2 = activity.getSystemService("vibrator");
                Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.os.Vibrator");
                vibrator = (Vibrator) systemService2;
            }
            this.r = vibrator;
        }
    }

    public final void initViewModels() {
        e1().L().observe(getViewLifecycleOwner(), new VoiceprintSrRecordFragment$sam$androidx_lifecycle_Observer$0(new VoiceprintSrRecordFragment$initViewModels$1(this)));
        e1().K().observe(getViewLifecycleOwner(), new VoiceprintSrRecordFragment$sam$androidx_lifecycle_Observer$0(new VoiceprintSrRecordFragment$initViewModels$2(this)));
        e1().H().observe(getViewLifecycleOwner(), new VoiceprintSrRecordFragment$sam$androidx_lifecycle_Observer$0(new VoiceprintSrRecordFragment$initViewModels$3(this)));
        e1().G().observe(getViewLifecycleOwner(), new VoiceprintSrRecordFragment$sam$androidx_lifecycle_Observer$0(new VoiceprintSrRecordFragment$initViewModels$4(this)));
    }

    public final void m1(String str) {
        ULog.f6446a.g("VoiceprintSrRecordFragment", str);
    }

    public final void n1() {
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new VoiceprintSrRecordFragment$notHearTip$1(this, (Continuation<? super VoiceprintSrRecordFragment$notHearTip$1>) null), 3, (Object) null);
    }

    public final void o1() {
        FragmentVoiceprintSepatateRoleRecordBinding fragmentVoiceprintSepatateRoleRecordBinding = this.k;
        FragmentVoiceprintSepatateRoleRecordBinding fragmentVoiceprintSepatateRoleRecordBinding2 = null;
        if (fragmentVoiceprintSepatateRoleRecordBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentVoiceprintSepatateRoleRecordBinding = null;
        }
        PAGImageView pAGImageView = fragmentVoiceprintSepatateRoleRecordBinding.b.c;
        Intrinsics.checkNotNullExpressionValue(pAGImageView, "pagRecord");
        pAGImageView.setVisibility(0);
        FragmentVoiceprintSepatateRoleRecordBinding fragmentVoiceprintSepatateRoleRecordBinding3 = this.k;
        if (fragmentVoiceprintSepatateRoleRecordBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentVoiceprintSepatateRoleRecordBinding3 = null;
        }
        fragmentVoiceprintSepatateRoleRecordBinding3.b.c.clearAnimation();
        FragmentVoiceprintSepatateRoleRecordBinding fragmentVoiceprintSepatateRoleRecordBinding4 = this.k;
        if (fragmentVoiceprintSepatateRoleRecordBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentVoiceprintSepatateRoleRecordBinding2 = fragmentVoiceprintSepatateRoleRecordBinding4;
        }
        PAGImageView pAGImageView2 = fragmentVoiceprintSepatateRoleRecordBinding2.b.c;
        Intrinsics.checkNotNullExpressionValue(pAGImageView2, "pagRecord");
        LibPag.a(pAGImageView2, new PagParam("record_listen_bmp.pag", -1));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentVoiceprintSepatateRoleRecordBinding c = FragmentVoiceprintSepatateRoleRecordBinding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.k = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            c = null;
        }
        ConstraintLayout b = c.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        return b;
    }

    public void onDestroyView() {
        super.onDestroyView();
        getLifecycle().d(this.u);
        c1();
        this.m = new byte[0];
        Job job = this.o;
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        this.o = null;
        this.n = 0;
        e1().o0();
        this.q = 0;
        this.r = null;
        this.s = false;
        this.t = false;
        CoroutineScopeKt.e(this.l, (CancellationException) null, 1, (Object) null);
        CoroutineScopeKt.e(this, (CancellationException) null, 1, (Object) null);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView();
        initData();
        initListener();
        initViewModels();
    }

    public final void p1() {
        FragmentVoiceprintSepatateRoleRecordBinding fragmentVoiceprintSepatateRoleRecordBinding = this.k;
        FragmentVoiceprintSepatateRoleRecordBinding fragmentVoiceprintSepatateRoleRecordBinding2 = null;
        if (fragmentVoiceprintSepatateRoleRecordBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentVoiceprintSepatateRoleRecordBinding = null;
        }
        PAGImageView pAGImageView = fragmentVoiceprintSepatateRoleRecordBinding.b.c;
        Intrinsics.checkNotNullExpressionValue(pAGImageView, "pagRecord");
        pAGImageView.setVisibility(0);
        FragmentVoiceprintSepatateRoleRecordBinding fragmentVoiceprintSepatateRoleRecordBinding3 = this.k;
        if (fragmentVoiceprintSepatateRoleRecordBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentVoiceprintSepatateRoleRecordBinding3 = null;
        }
        fragmentVoiceprintSepatateRoleRecordBinding3.b.c.clearAnimation();
        FragmentVoiceprintSepatateRoleRecordBinding fragmentVoiceprintSepatateRoleRecordBinding4 = this.k;
        if (fragmentVoiceprintSepatateRoleRecordBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentVoiceprintSepatateRoleRecordBinding2 = fragmentVoiceprintSepatateRoleRecordBinding4;
        }
        PAGImageView pAGImageView2 = fragmentVoiceprintSepatateRoleRecordBinding2.b.c;
        Intrinsics.checkNotNullExpressionValue(pAGImageView2, "pagRecord");
        LibPag.a(pAGImageView2, new PagParam("record_broadcast_bmp.pag", -1));
    }

    public final void q1() {
        FragmentVoiceprintSepatateRoleRecordBinding fragmentVoiceprintSepatateRoleRecordBinding = this.k;
        FragmentVoiceprintSepatateRoleRecordBinding fragmentVoiceprintSepatateRoleRecordBinding2 = null;
        if (fragmentVoiceprintSepatateRoleRecordBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentVoiceprintSepatateRoleRecordBinding = null;
        }
        ConstraintLayout b = fragmentVoiceprintSepatateRoleRecordBinding.d.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        b.setVisibility(8);
        FragmentVoiceprintSepatateRoleRecordBinding fragmentVoiceprintSepatateRoleRecordBinding3 = this.k;
        if (fragmentVoiceprintSepatateRoleRecordBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentVoiceprintSepatateRoleRecordBinding3 = null;
        }
        ConstraintLayout b2 = fragmentVoiceprintSepatateRoleRecordBinding3.b.getRoot();
        Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
        b2.setVisibility(0);
        FragmentVoiceprintSepatateRoleRecordBinding fragmentVoiceprintSepatateRoleRecordBinding4 = this.k;
        if (fragmentVoiceprintSepatateRoleRecordBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentVoiceprintSepatateRoleRecordBinding4 = null;
        }
        MzButton mzButton = fragmentVoiceprintSepatateRoleRecordBinding4.b.b;
        Intrinsics.checkNotNullExpressionValue(mzButton, "mbtNext");
        mzButton.setVisibility(8);
        FragmentVoiceprintSepatateRoleRecordBinding fragmentVoiceprintSepatateRoleRecordBinding5 = this.k;
        if (fragmentVoiceprintSepatateRoleRecordBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentVoiceprintSepatateRoleRecordBinding5 = null;
        }
        fragmentVoiceprintSepatateRoleRecordBinding5.b.b.setEnabled(false);
        FragmentVoiceprintSepatateRoleRecordBinding fragmentVoiceprintSepatateRoleRecordBinding6 = this.k;
        if (fragmentVoiceprintSepatateRoleRecordBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentVoiceprintSepatateRoleRecordBinding6 = null;
        }
        SappTitleBar sappTitleBar = fragmentVoiceprintSepatateRoleRecordBinding6.e;
        String string = getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        sappTitleBar.setBackText(string);
        FragmentVoiceprintSepatateRoleRecordBinding fragmentVoiceprintSepatateRoleRecordBinding7 = this.k;
        if (fragmentVoiceprintSepatateRoleRecordBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentVoiceprintSepatateRoleRecordBinding7 = null;
        }
        fragmentVoiceprintSepatateRoleRecordBinding7.b.g.setText(getString(R.string.vp_separate_role_spoken_word_tip));
        FragmentVoiceprintSepatateRoleRecordBinding fragmentVoiceprintSepatateRoleRecordBinding8 = this.k;
        if (fragmentVoiceprintSepatateRoleRecordBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentVoiceprintSepatateRoleRecordBinding2 = fragmentVoiceprintSepatateRoleRecordBinding8;
        }
        TextView textView = fragmentVoiceprintSepatateRoleRecordBinding2.b.f;
        textView.setText(getString(R.string.vp_separate_role_spoken_words));
        textView.setTextColor(textView.getContext().getColor(R.color.vp_separate_role_use_mic_title));
        o1();
        RoleVprintViewModel e1 = e1();
        String string2 = getString(R.string.vp_separate_role_spoken_word_tip);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        e1.X(string2);
    }

    public final void r1(boolean z) {
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new VoiceprintSrRecordFragment$startRecordFailed$1(this, z, (Continuation<? super VoiceprintSrRecordFragment$startRecordFailed$1>) null), 3, (Object) null);
    }
}
