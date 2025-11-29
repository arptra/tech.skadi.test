package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.honey.account.h8.t9;
import com.honey.account.h8.u9;
import com.honey.account.h8.v9;
import com.honey.account.h8.w9;
import com.honey.account.h8.x9;
import com.honey.account.h8.y9;
import com.meizu.common.widget.CircularProgressButton;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$3;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$4;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$5;
import com.upuphone.xr.sapp.context.SdkContext;
import com.upuphone.xr.sapp.databinding.FragmentTouchpadBinding;
import com.upuphone.xr.sapp.dialog.TouchpadDialog;
import com.upuphone.xr.sapp.glass.GlassHelper;
import com.upuphone.xr.sapp.glass.GlassScreenShotHelper;
import com.upuphone.xr.sapp.glass.GlassUpdateHelper;
import com.upuphone.xr.sapp.utils.AppUpdateHelper;
import com.upuphone.xr.sapp.utils.AppUtils;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.DimensExtKt;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.utils.TouchpadUtil;
import com.upuphone.xr.sapp.utils.ViewExtKt;
import com.upuphone.xr.sapp.vm.SuperViewModel;
import com.xjsd.ai.assistant.protocol.CmdCode;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \\2\u00020\u0001:\u0001]B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u0003J\u001f\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010\"\u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0004H\u0002¢\u0006\u0004\b$\u0010\u0003J\u0019\u0010'\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0004H\u0016¢\u0006\u0004\b)\u0010\u0003J\u000f\u0010*\u001a\u00020\u0004H\u0016¢\u0006\u0004\b*\u0010\u0003J+\u00100\u001a\u00020/2\u0006\u0010,\u001a\u00020+2\b\u0010.\u001a\u0004\u0018\u00010-2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b0\u00101J!\u00102\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020/2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b2\u00103J\u001f\u00106\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u0015H\u0016¢\u0006\u0004\b6\u0010\u0019J\u000f\u00107\u001a\u00020\u0004H\u0016¢\u0006\u0004\b7\u0010\u0003J\u000f\u00108\u001a\u00020\u0004H\u0016¢\u0006\u0004\b8\u0010\u0003R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010E\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bD\u0010BR\u0016\u0010H\u001a\u00020 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010K\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u0010JR\u0016\u0010O\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bN\u0010JR\u0016\u0010Q\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u0010JR\u001b\u0010W\u001a\u00020R8BX\u0002¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR\u0018\u0010[\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bY\u0010Z¨\u0006^"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/TouchpadFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "initView", "initViewModel", "Lcom/meizu/common/widget/CircularProgressButton;", "view", "O0", "(Lcom/meizu/common/widget/CircularProgressButton;)V", "N0", "", "M0", "()Z", "T0", "U0", "Landroid/view/MotionEvent;", "event", "S0", "(Landroid/view/MotionEvent;)V", "", "x", "y", "V0", "(II)V", "R0", "", "distanceX", "distanceY", "Q0", "(FF)I", "", "delayTime", "c1", "(J)V", "L0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "onPause", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "windowType", "actionType", "a", "onDestroyView", "onDestroy", "Lcom/upuphone/xr/sapp/databinding/FragmentTouchpadBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentTouchpadBinding;", "binding", "Landroid/view/GestureDetector;", "k", "Landroid/view/GestureDetector;", "mGestureDetector", "l", "Z", "isFirst", "m", "isScroll", "n", "J", "scrollBeginTime", "o", "F", "scrollBeginX", "p", "scrollBeginY", "q", "scrollEndX", "r", "scrollEndY", "Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "s", "Lkotlin/Lazy;", "P0", "()Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "mSuperViewModel", "Lkotlinx/coroutines/Job;", "t", "Lkotlinx/coroutines/Job;", "resetProgressButtonJob", "u", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTouchpadFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TouchpadFragment.kt\ncom/upuphone/xr/sapp/fragment/TouchpadFragment\n+ 2 GlobalViewStoreExt.kt\ncom/upuphone/xr/sapp/common/GlobalViewStoreExtKt\n*L\n1#1,495:1\n32#2,12:496\n*S KotlinDebug\n*F\n+ 1 TouchpadFragment.kt\ncom/upuphone/xr/sapp/fragment/TouchpadFragment\n*L\n71#1:496,12\n*E\n"})
public final class TouchpadFragment extends BaseFragment {
    public static final Companion u = new Companion((DefaultConstructorMarker) null);
    public FragmentTouchpadBinding j;
    public GestureDetector k;
    public boolean l = true;
    public boolean m;
    public long n;
    public float o;
    public float p;
    public float q;
    public float r;
    public final Lazy s;
    public Job t;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/TouchpadFragment$Companion;", "", "()V", "GLASS_SHOT_MIN_VERSION", "", "MEMORY_OCCUPATION_CHECK", "TAG", "", "TOUCHPAD_FIRST", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.meizu.common.widget.CircularProgressButton$State[] r0 = com.meizu.common.widget.CircularProgressButton.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.meizu.common.widget.CircularProgressButton$State r1 = com.meizu.common.widget.CircularProgressButton.State.IDLE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.meizu.common.widget.CircularProgressButton$State r1 = com.meizu.common.widget.CircularProgressButton.State.PROGRESS     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.fragment.TouchpadFragment.WhenMappings.<clinit>():void");
        }
    }

    public TouchpadFragment() {
        Class<SuperViewModel> cls = SuperViewModel.class;
        this.s = GlobalViewStoreExtKt.a(this, Reflection.getOrCreateKotlinClass(cls), new GlobalViewStoreExtKt$cachedViewModels$3(cls.getName()), new GlobalViewStoreExtKt$cachedViewModels$4((Function0<? extends CreationExtras>) null, this), new GlobalViewStoreExtKt$cachedViewModels$5(this));
    }

    public static final void W0(TouchpadFragment touchpadFragment, View view) {
        Intrinsics.checkNotNullParameter(touchpadFragment, "this$0");
        StaticMethodUtilsKt.q(touchpadFragment);
    }

    public static final void X0(TouchpadFragment touchpadFragment, View view) {
        Intrinsics.checkNotNullParameter(touchpadFragment, "this$0");
        FragmentActivity activity = touchpadFragment.getActivity();
        if (activity != null) {
            Context requireContext = touchpadFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            new TouchpadDialog(requireContext).o(activity);
        }
        if (touchpadFragment.l) {
            touchpadFragment.T0();
        }
    }

    public static final boolean Y0(TouchpadFragment touchpadFragment, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(touchpadFragment, "this$0");
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        if (GlassHelper.f7049a.y() == null) {
            if (motionEvent.getAction() == 0) {
                UToast.Companion companion = UToast.f6444a;
                Context requireContext = touchpadFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                companion.b(requireContext, R.string.device_disconnect);
            }
            return true;
        } else if (GlassUpdateHelper.b.b1()) {
            StaticMethodUtilsKt.O(touchpadFragment);
            return true;
        } else if (AppUpdateHelper.f7841a.u()) {
            return true;
        } else {
            touchpadFragment.S0(motionEvent);
            return true;
        }
    }

    public static final boolean Z0(View view, MotionEvent motionEvent) {
        return true;
    }

    public static final void a1(TouchpadFragment touchpadFragment, View view) {
        Intrinsics.checkNotNullParameter(touchpadFragment, "this$0");
        touchpadFragment.T0();
    }

    public static final void b1(TouchpadFragment touchpadFragment, CircularProgressButton circularProgressButton, View view) {
        Intrinsics.checkNotNullParameter(touchpadFragment, "this$0");
        Intrinsics.checkNotNullParameter(circularProgressButton, "$this_apply");
        if (!GlassHelper.f7049a.E()) {
            UToast.Companion companion = UToast.f6444a;
            Context requireContext = touchpadFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            companion.b(requireContext, R.string.device_disconnect);
        } else if (GlassUpdateHelper.b.b1()) {
            StaticMethodUtilsKt.O(touchpadFragment);
        } else if (!AppUpdateHelper.f7841a.u()) {
            touchpadFragment.O0(circularProgressButton);
        }
    }

    public static /* synthetic */ void d1(TouchpadFragment touchpadFragment, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j2 = 0;
        }
        touchpadFragment.c1(j2);
    }

    private final void initView() {
        CircularProgressButton circularProgressButton;
        ImageView imageView;
        ConstraintLayout constraintLayout;
        ImageView imageView2;
        ImageView imageView3;
        TextView textView;
        FragmentTouchpadBinding fragmentTouchpadBinding = this.j;
        if (!(fragmentTouchpadBinding == null || (textView = fragmentTouchpadBinding.l) == null)) {
            ViewExtKt.b(textView, new t9(this));
        }
        FragmentTouchpadBinding fragmentTouchpadBinding2 = this.j;
        if (!(fragmentTouchpadBinding2 == null || (imageView3 = fragmentTouchpadBinding2.j) == null)) {
            imageView3.setOnClickListener(new u9(this));
        }
        FragmentTouchpadBinding fragmentTouchpadBinding3 = this.j;
        if (!(fragmentTouchpadBinding3 == null || (imageView2 = fragmentTouchpadBinding3.e) == null)) {
            imageView2.setOnTouchListener(new v9(this));
        }
        FragmentTouchpadBinding fragmentTouchpadBinding4 = this.j;
        if (!(fragmentTouchpadBinding4 == null || (constraintLayout = fragmentTouchpadBinding4.h) == null)) {
            constraintLayout.setOnTouchListener(new w9());
        }
        boolean booleanValue = ((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), "touchpad_first_open", Boolean.TRUE, (Context) null, 4, (Object) null)).booleanValue();
        this.l = booleanValue;
        ConstraintLayout constraintLayout2 = null;
        if (booleanValue) {
            FragmentTouchpadBinding fragmentTouchpadBinding5 = this.j;
            if (fragmentTouchpadBinding5 != null) {
                constraintLayout2 = fragmentTouchpadBinding5.h;
            }
            if (constraintLayout2 != null) {
                constraintLayout2.setVisibility(0);
            }
            FragmentTouchpadBinding fragmentTouchpadBinding6 = this.j;
            if (!(fragmentTouchpadBinding6 == null || (imageView = fragmentTouchpadBinding6.g) == null)) {
                imageView.setOnClickListener(new x9(this));
            }
        } else {
            FragmentTouchpadBinding fragmentTouchpadBinding7 = this.j;
            if (fragmentTouchpadBinding7 != null) {
                constraintLayout2 = fragmentTouchpadBinding7.h;
            }
            if (constraintLayout2 != null) {
                constraintLayout2.setVisibility(8);
            }
        }
        FragmentTouchpadBinding fragmentTouchpadBinding8 = this.j;
        if (fragmentTouchpadBinding8 != null && (circularProgressButton = fragmentTouchpadBinding8.d) != null) {
            circularProgressButton.setIndeterminateProgressMode(false);
            circularProgressButton.setProgressStrokeWidth(DimensExtKt.b(2));
            circularProgressButton.setShowCenterIcon(true);
            circularProgressButton.setProgressCenterIcon(ContextCompat.getDrawable(circularProgressButton.getContext(), R.drawable.screen_shot_center));
            ViewExtKt.a(circularProgressButton, 250, new y9(this, circularProgressButton));
        }
    }

    private final void initViewModel() {
        GlassScreenShotHelper.b.y().observe(getViewLifecycleOwner(), new TouchpadFragment$sam$androidx_lifecycle_Observer$0(new TouchpadFragment$initViewModel$1(this)));
        SdkContext.f6675a.e().c().observe(getViewLifecycleOwner(), new TouchpadFragment$sam$androidx_lifecycle_Observer$0(new TouchpadFragment$initViewModel$2(this)));
    }

    public final void L0() {
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TouchpadFragment$checkScreenshotStatus$1(this, (Continuation<? super TouchpadFragment$checkScreenshotStatus$1>) null), 3, (Object) null);
    }

    public final boolean M0() {
        long j2;
        try {
            j2 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBytes();
        } catch (Exception e) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("TouchpadFragment", "screenshot transmit PreCheck, getDataDirectory availableBytes error: " + e);
            j2 = 0;
        }
        return j2 >= 307200;
    }

    public final void N0(CircularProgressButton circularProgressButton) {
        ULog.Delegate delegate = ULog.f6446a;
        CircularProgressButton.State state = circularProgressButton.getState();
        int progress = circularProgressButton.getProgress();
        delegate.a("TouchpadFragment", "clickScreenShotButton, state: " + state + ", progress: " + progress);
        CircularProgressButton.State state2 = circularProgressButton.getState();
        int i = state2 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[state2.ordinal()];
        if (i == 1) {
            circularProgressButton.setBackground((Drawable) null);
            circularProgressButton.setState(CircularProgressButton.State.PROGRESS, false, false);
            circularProgressButton.setProgress(1, false);
            GlassScreenShotHelper.N(GlassScreenShotHelper.b, 0, 1, (Object) null);
        } else if (i != 2) {
            delegate.a("TouchpadFragment", "clickScreenShotButton, ignore");
        } else {
            GlassScreenShotHelper.b.O();
            d1(this, 0, 1, (Object) null);
        }
    }

    public final void O0(CircularProgressButton circularProgressButton) {
        if (P0().R()) {
            UToast.Companion companion = UToast.f6444a;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            String string = requireContext().getString(R.string.scence_disallow_screenshot);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.d(requireContext, string);
        } else if (!M0()) {
            ULog.f6446a.g("TouchpadFragment", "screenshot transmit PreCheck failed, no enough storage");
            StaticMethodUtilsKt.C(this, CollectionsKt.arrayListOf(Integer.valueOf(CmdCode.CODE_DELAY_LISTENING)), false, false);
        } else {
            N0(circularProgressButton);
        }
    }

    public final SuperViewModel P0() {
        return (SuperViewModel) this.s.getValue();
    }

    public final int Q0(float f, float f2) {
        return Math.abs(f) > Math.abs(f2) ? f > 0.0f ? 22 : 21 : f2 > 0.0f ? 20 : 19;
    }

    public final void R0() {
        if (this.m) {
            float f = this.q - this.o;
            float f2 = this.r - this.p;
            long currentTimeMillis = System.currentTimeMillis() - this.n;
            ULog.Delegate delegate = ULog.f6446a;
            delegate.g("TouchpadFragment", "distanceX: " + f + ", distanceY: " + f2 + ", duration: " + currentTimeMillis);
            if (Math.abs(f) > 100.0f || Math.abs(f2) > 100.0f) {
                float f3 = (float) currentTimeMillis;
                TouchpadUtil.f7927a.d(Q0(f, f2), this.o, this.p, this.q, this.r, f / f3, f2 / f3);
            }
            this.m = false;
        }
    }

    public final void S0(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int i = action & 255;
        GestureDetector gestureDetector = null;
        if (i == 0) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.g("TouchpadFragment", "gesture mode: action down事件, x: " + x + ", y: " + y);
            GestureDetector gestureDetector2 = this.k;
            if (gestureDetector2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGestureDetector");
            } else {
                gestureDetector = gestureDetector2;
            }
            gestureDetector.onTouchEvent(motionEvent);
            V0(x, y);
        } else if (i == 1) {
            GestureDetector gestureDetector3 = this.k;
            if (gestureDetector3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGestureDetector");
            } else {
                gestureDetector = gestureDetector3;
            }
            gestureDetector.onTouchEvent(motionEvent);
            R0();
        } else if (i == 2) {
            GestureDetector gestureDetector4 = this.k;
            if (gestureDetector4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGestureDetector");
            } else {
                gestureDetector = gestureDetector4;
            }
            gestureDetector.onTouchEvent(motionEvent);
        }
    }

    public final void T0() {
        FragmentTouchpadBinding fragmentTouchpadBinding = this.j;
        ConstraintLayout constraintLayout = fragmentTouchpadBinding != null ? fragmentTouchpadBinding.h : null;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
        DataStoreUtils.e.a().o("touchpad_first_open", Boolean.FALSE);
    }

    public final void U0() {
        this.k = new GestureDetector(getContext(), new TouchpadFragment$initGestureDetector$1(this));
    }

    public final void V0(int i, int i2) {
        this.o = (float) i;
        this.p = (float) i2;
        this.n = System.currentTimeMillis();
    }

    public void a(int i, int i2) {
        super.a(i, i2);
        if (i != 118) {
            if (i == 179 && i2 == 1101) {
                StaticMethodUtilsKt.t(this, R.id.glassUpdateInfoActivity);
            }
        } else if (i2 == 1101) {
            AppUtils appUtils = AppUtils.f7842a;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            appUtils.r(requireContext);
        }
    }

    public final void c1(long j2) {
        Job job = this.t;
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        this.t = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new TouchpadFragment$resetProgressButton$1(this, j2, (Continuation<? super TouchpadFragment$resetProgressButton$1>) null), 3, (Object) null);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ULog.f6446a.g("TouchpadFragment", "onCreate");
        k0();
        U0();
        TouchpadUtil.f7927a.e();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ULog.f6446a.g("TouchpadFragment", "onCreateView");
        if (this.j == null) {
            this.j = FragmentTouchpadBinding.c(layoutInflater, viewGroup, false);
        }
        FragmentTouchpadBinding fragmentTouchpadBinding = this.j;
        Intrinsics.checkNotNull(fragmentTouchpadBinding);
        ConstraintLayout constraintLayout = fragmentTouchpadBinding.c;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "root");
        return constraintLayout;
    }

    public void onDestroy() {
        super.onDestroy();
        ULog.f6446a.g("TouchpadFragment", "onDestroy");
        this.j = null;
    }

    public void onDestroyView() {
        super.onDestroyView();
        ULog.f6446a.g("TouchpadFragment", "onDestroyView");
        if (this.l) {
            T0();
        }
        TouchpadUtil.f7927a.f();
    }

    public void onPause() {
        ULog.f6446a.g("TouchpadFragment", "onPause");
        super.onPause();
    }

    public void onResume() {
        ULog.f6446a.g("TouchpadFragment", "onResume");
        super.onResume();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ULog.f6446a.g("TouchpadFragment", "onViewCreated");
        initView();
        initViewModel();
    }
}
