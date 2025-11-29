package com.upuphone.xr.sapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.honey.account.h8.ib;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.WakeupRecordingFragmentBinding;
import com.upuphone.xr.sapp.pag.LibPag;
import com.upuphone.xr.sapp.pag.PagParam;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.libpag.PAGImageView;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 32\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0003J\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u0003J1\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001b2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u001b8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010)R\u001b\u00102\u001a\u00020-8BX\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101¨\u00065"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/WakeupRecordingFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onPause", "onStop", "onDestroy", "", "broadcast", "N0", "(Z)V", "O0", "Landroid/view/animation/Animation;", "anim", "Lkotlin/Function0;", "action", "L0", "(Landroid/view/View;Landroid/view/animation/Animation;Lkotlin/jvm/functions/Function0;)V", "Lcom/upuphone/xr/sapp/databinding/WakeupRecordingFragmentBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/WakeupRecordingFragmentBinding;", "binding", "k", "Landroid/view/animation/Animation;", "wordOutAnim", "l", "Z", "isBroadcasting", "m", "isFailedOnce", "Lcom/upuphone/xr/sapp/vm/WakeupRecordingViewmodel;", "n", "Lkotlin/Lazy;", "J0", "()Lcom/upuphone/xr/sapp/vm/WakeupRecordingViewmodel;", "viewModel", "o", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nWakeupRecordingFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WakeupRecordingFragment.kt\ncom/upuphone/xr/sapp/fragment/WakeupRecordingFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n*L\n1#1,216:1\n106#2,15:217\n*S KotlinDebug\n*F\n+ 1 WakeupRecordingFragment.kt\ncom/upuphone/xr/sapp/fragment/WakeupRecordingFragment\n*L\n43#1:217,15\n*E\n"})
public final class WakeupRecordingFragment extends BaseFragment {
    public static final Companion o = new Companion((DefaultConstructorMarker) null);
    public WakeupRecordingFragmentBinding j;
    public Animation k;
    public boolean l;
    public boolean m;
    public final Lazy n;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/WakeupRecordingFragment$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public WakeupRecordingFragment() {
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new WakeupRecordingFragment$special$$inlined$viewModels$default$2(new WakeupRecordingFragment$special$$inlined$viewModels$default$1(this)));
        this.n = FragmentViewModelLazyKt.c(this, Reflection.getOrCreateKotlinClass(WakeupRecordingViewmodel.class), new WakeupRecordingFragment$special$$inlined$viewModels$default$3(lazy), new WakeupRecordingFragment$special$$inlined$viewModels$default$4((Function0) null, lazy), new WakeupRecordingFragment$special$$inlined$viewModels$default$5(this, lazy));
    }

    public static final void K0(WakeupRecordingFragment wakeupRecordingFragment, View view) {
        Intrinsics.checkNotNullParameter(wakeupRecordingFragment, "this$0");
        StaticMethodUtilsKt.q(wakeupRecordingFragment);
    }

    public static /* synthetic */ void M0(WakeupRecordingFragment wakeupRecordingFragment, View view, Animation animation, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        wakeupRecordingFragment.L0(view, animation, function0);
    }

    public final WakeupRecordingViewmodel J0() {
        return (WakeupRecordingViewmodel) this.n.getValue();
    }

    public final void L0(View view, Animation animation, Function0 function0) {
        animation.setAnimationListener(new WakeupRecordingFragment$playAnimation$1$1(function0));
        view.startAnimation(animation);
    }

    public final void N0(boolean z) {
        if (this.l != z) {
            this.l = z;
            WakeupRecordingFragmentBinding wakeupRecordingFragmentBinding = this.j;
            WakeupRecordingFragmentBinding wakeupRecordingFragmentBinding2 = null;
            if (wakeupRecordingFragmentBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                wakeupRecordingFragmentBinding = null;
            }
            wakeupRecordingFragmentBinding.e.setVisibility(0);
            WakeupRecordingFragmentBinding wakeupRecordingFragmentBinding3 = this.j;
            if (wakeupRecordingFragmentBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                wakeupRecordingFragmentBinding3 = null;
            }
            PAGImageView pAGImageView = wakeupRecordingFragmentBinding3.e;
            Intrinsics.checkNotNullExpressionValue(pAGImageView, "voiceAnimation");
            LibPag.a(pAGImageView, new PagParam(this.l ? "record_broadcast_bmp.pag" : "record_listen_bmp.pag", Integer.MAX_VALUE));
            if (this.l) {
                WakeupRecordingFragmentBinding wakeupRecordingFragmentBinding4 = this.j;
                if (wakeupRecordingFragmentBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    wakeupRecordingFragmentBinding2 = wakeupRecordingFragmentBinding4;
                }
                PAGImageView pAGImageView2 = wakeupRecordingFragmentBinding2.e;
                Intrinsics.checkNotNullExpressionValue(pAGImageView2, "voiceAnimation");
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.0f, 0.27f, 0.85f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setDuration(233);
                Unit unit = Unit.INSTANCE;
                M0(this, pAGImageView2, scaleAnimation, (Function0) null, 4, (Object) null);
            }
        }
    }

    public final void O0() {
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), Dispatchers.a(), (CoroutineStart) null, new WakeupRecordingFragment$vibrate$1(this, (Continuation<? super WakeupRecordingFragment$vibrate$1>) null), 2, (Object) null);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.wakeup_word_enter);
        Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(...)");
        this.k = loadAnimation;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        WakeupRecordingFragmentBinding c = WakeupRecordingFragmentBinding.c(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.j = c;
        WakeupRecordingFragmentBinding wakeupRecordingFragmentBinding = null;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        c.b.setOnClickListener(new ib(this));
        WakeupRecordingFragmentBinding wakeupRecordingFragmentBinding2 = this.j;
        if (wakeupRecordingFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            wakeupRecordingFragmentBinding2 = null;
        }
        wakeupRecordingFragmentBinding2.c.setText("1/5");
        N0(true);
        WakeupRecordingFragmentBinding wakeupRecordingFragmentBinding3 = this.j;
        if (wakeupRecordingFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            wakeupRecordingFragmentBinding3 = null;
        }
        AppCompatTextView appCompatTextView = wakeupRecordingFragmentBinding3.f;
        Animation animation = this.k;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wordOutAnim");
            animation = null;
        }
        appCompatTextView.startAnimation(animation);
        WakeupRecordingFragmentBinding wakeupRecordingFragmentBinding4 = this.j;
        if (wakeupRecordingFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            wakeupRecordingFragmentBinding = wakeupRecordingFragmentBinding4;
        }
        ConstraintLayout b = wakeupRecordingFragmentBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        return b;
    }

    public void onDestroy() {
        super.onDestroy();
        J0().S();
    }

    public void onPause() {
        super.onPause();
        J0().Z();
        StaticMethodUtilsKt.x(this, R.id.wakeupRecordMainFragment);
    }

    public void onStop() {
        super.onStop();
        WakeupRecordingFragmentBinding wakeupRecordingFragmentBinding = this.j;
        if (wakeupRecordingFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            wakeupRecordingFragmentBinding = null;
        }
        wakeupRecordingFragmentBinding.e.pause();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new WakeupRecordingFragment$onViewCreated$1(this, (Continuation<? super WakeupRecordingFragment$onViewCreated$1>) null), 3, (Object) null);
    }
}
