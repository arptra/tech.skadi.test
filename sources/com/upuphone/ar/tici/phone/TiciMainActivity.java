package com.upuphone.ar.tici.phone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import com.airbnb.lottie.LottieAnimationView;
import com.honey.account.p4.h0;
import com.honey.account.p4.i0;
import com.honey.account.p4.j0;
import com.honey.account.p4.k0;
import com.honey.account.p4.l0;
import com.honey.account.p4.m0;
import com.honey.account.p4.n0;
import com.honey.account.p4.o0;
import com.honey.account.p4.p0;
import com.honey.account.p4.q0;
import com.honey.account.p4.r0;
import com.honey.account.p4.s0;
import com.honey.account.p4.t0;
import com.honey.account.p4.u0;
import com.meizu.common.widget.MzButton;
import com.upuphone.ar.tici.R;
import com.upuphone.ar.tici.databinding.TiciMainActivityLayoutBinding;
import com.upuphone.ar.tici.phone.data.OpenTiciFrom;
import com.upuphone.ar.tici.phone.data.OpenTiciResult;
import com.upuphone.ar.tici.phone.data.ParagraphProgress;
import com.upuphone.ar.tici.phone.data.TiciInfo;
import com.upuphone.ar.tici.phone.data.TiciInfoKt;
import com.upuphone.ar.tici.phone.db.entity.TiciEntity;
import com.upuphone.ar.tici.phone.db.entity.TiciEntityKt;
import com.upuphone.ar.tici.phone.starrynet.msg.CheckTiciStateReply;
import com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReply;
import com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReplyV2;
import com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReplyV3;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import com.upuphone.ar.tici.phone.utils.ConstantsKt;
import com.upuphone.ar.tici.phone.utils.LottieExtKt;
import com.upuphone.ar.tici.phone.utils.SpUtilKt;
import com.upuphone.ar.tici.phone.viewmodel.TiciMainViewModel;
import com.upuphone.runasone.uupcast.CaptureType;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.sapp.utils.ViewExtKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 X2\u00020\u0001:\u0001YB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u0003J\u0019\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u0003J\u0017\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u001f\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b,\u0010-J'\u00101\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\bH\u0002¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0004H\u0002¢\u0006\u0004\b3\u0010\u0003J\u0019\u00106\u001a\u00020\u00042\b\u00105\u001a\u0004\u0018\u000104H\u0014¢\u0006\u0004\b6\u00107J\u001f\u0010;\u001a\u00020\b2\u0006\u00108\u001a\u00020\u001f2\u0006\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u0004H\u0014¢\u0006\u0004\b=\u0010\u0003R\u001b\u0010C\u001a\u00020>8BX\u0002¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u001b\u0010H\u001a\u00020D8BX\u0002¢\u0006\f\n\u0004\bE\u0010@\u001a\u0004\bF\u0010GR\u0014\u0010L\u001a\u00020I8\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010O\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u001a\u0010T\u001a\b\u0012\u0004\u0012\u00020Q0P8\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010W\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\bU\u0010V¨\u0006Z"}, d2 = {"Lcom/upuphone/ar/tici/phone/TiciMainActivity;", "Lcom/upuphone/ar/tici/phone/BaseTiciActivity;", "<init>", "()V", "", "initViews", "initViewModels", "D1", "", "changed", "k1", "(Z)V", "Lcom/upuphone/ar/tici/phone/data/OpenTiciResult;", "result", "i1", "(Lcom/upuphone/ar/tici/phone/data/OpenTiciResult;)V", "Lcom/upuphone/ar/tici/phone/starrynet/msg/OpenTiciMsgReply;", "f1", "(Lcom/upuphone/ar/tici/phone/starrynet/msg/OpenTiciMsgReply;)V", "Lcom/upuphone/ar/tici/phone/starrynet/msg/OpenTiciMsgReplyV2;", "g1", "(Lcom/upuphone/ar/tici/phone/starrynet/msg/OpenTiciMsgReplyV2;)V", "Lcom/upuphone/ar/tici/phone/starrynet/msg/OpenTiciMsgReplyV3;", "h1", "(Lcom/upuphone/ar/tici/phone/starrynet/msg/OpenTiciMsgReplyV3;)V", "B1", "", "duration", "a1", "(J)Z", "Z0", "", "index", "l1", "(I)V", "page", "m1", "(II)V", "Lcom/upuphone/ar/tici/phone/starrynet/msg/CheckTiciStateReply;", "ticiState", "E1", "(Lcom/upuphone/ar/tici/phone/starrynet/msg/CheckTiciStateReply;)V", "Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;", "ticiEntity", "j1", "(Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;)V", "isGlassesTiciRunning", "isAutoTiciRunning", "isAutoTiciFinish", "Y0", "(ZZZ)V", "C1", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "keyCode", "Landroid/view/KeyEvent;", "event", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "onDestroy", "Lcom/upuphone/ar/tici/databinding/TiciMainActivityLayoutBinding;", "b", "Lkotlin/Lazy;", "d1", "()Lcom/upuphone/ar/tici/databinding/TiciMainActivityLayoutBinding;", "layout", "Lcom/upuphone/ar/tici/phone/viewmodel/TiciMainViewModel;", "c", "e1", "()Lcom/upuphone/ar/tici/phone/viewmodel/TiciMainViewModel;", "vm", "Lcom/upuphone/ar/tici/phone/TiciAppViewModel;", "d", "Lcom/upuphone/ar/tici/phone/TiciAppViewModel;", "appViewModel", "e", "J", "lastKeyEventTime", "", "Lcom/upuphone/ar/tici/phone/starrynet/msg/ParagraphItem;", "f", "Ljava/util/List;", "ticiContentLines", "c1", "()Z", "blockTiciProgress", "g", "Companion", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTiciMainActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciMainActivity.kt\ncom/upuphone/ar/tici/phone/TiciMainActivity\n+ 2 ActivityViewModelLazy.kt\nandroidx/activity/ActivityViewModelLazyKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n+ 4 ContextExt.kt\ncom/upuphone/xr/sapp/utils/ContextExtKt\n*L\n1#1,760:1\n75#2,13:761\n260#3:774\n262#3,2:775\n262#3,2:777\n19#4,9:779\n19#4,9:788\n*S KotlinDebug\n*F\n+ 1 TiciMainActivity.kt\ncom/upuphone/ar/tici/phone/TiciMainActivity\n*L\n64#1:761,13\n710#1:774\n709#1:775,2\n711#1:777,2\n96#1:779,9\n102#1:788,9\n*E\n"})
public final class TiciMainActivity extends BaseTiciActivity {
    public static final Companion g = new Companion((DefaultConstructorMarker) null);
    public final Lazy b = LazyKt.lazy(new TiciMainActivity$layout$2(this));
    public final Lazy c = new ViewModelLazy(Reflection.getOrCreateKotlinClass(TiciMainViewModel.class), new TiciMainActivity$special$$inlined$viewModels$default$2(this), new TiciMainActivity$special$$inlined$viewModels$default$1(this), new TiciMainActivity$special$$inlined$viewModels$default$3((Function0) null, this));
    public final TiciAppViewModel d = TiciApp.b.c();
    public long e;
    public final List f = new ArrayList();

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/ar/tici/phone/TiciMainActivity$Companion;", "", "()V", "REQUEST_CHOOSE_FILE_ACTIVITY", "", "TAG", "", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static final void A1(TiciMainActivity ticiMainActivity, View view) {
        Intrinsics.checkNotNullParameter(ticiMainActivity, "this$0");
        CommonExtKt.e("btnClose click", "TiciMainActivity");
        ticiMainActivity.d.D();
    }

    /* access modifiers changed from: private */
    public final void E1(CheckTiciStateReply checkTiciStateReply) {
        CommonExtKt.e("syncGlassTiciState, ticiState: " + checkTiciStateReply, "TiciMainActivity");
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TiciMainActivity$syncGlassTiciState$1(checkTiciStateReply, this, (Continuation<? super TiciMainActivity$syncGlassTiciState$1>) null), 3, (Object) null);
    }

    private final void Z0() {
        e1().k();
    }

    public static /* synthetic */ boolean b1(TiciMainActivity ticiMainActivity, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 300;
        }
        return ticiMainActivity.a1(j);
    }

    /* access modifiers changed from: private */
    public final boolean c1() {
        return e1().p() || TiciApp.b.c().w0();
    }

    private final void initViewModels() {
        e1().t().observe(this, new h0(new TiciMainActivity$initViewModels$1(this)));
        e1().q().observe(this, new m0(new TiciMainActivity$initViewModels$2(this)));
        e1().v().observe(this, new n0(new TiciMainActivity$initViewModels$3(this)));
        e1().s().observe(this, new o0(new TiciMainActivity$initViewModels$4(this)));
        this.d.F().observe(this, new p0(new TiciMainActivity$initViewModels$5(this)));
        this.d.K().observe(this, new q0(new TiciMainActivity$initViewModels$6(this)));
        this.d.I().observe(this, new r0(new TiciMainActivity$initViewModels$7(this)));
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TiciMainActivity$initViewModels$8(this, (Continuation<? super TiciMainActivity$initViewModels$8>) null), 3, (Object) null);
        Job unused2 = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TiciMainActivity$initViewModels$9(this, (Continuation<? super TiciMainActivity$initViewModels$9>) null), 3, (Object) null);
        Job unused3 = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TiciMainActivity$initViewModels$10(this, (Continuation<? super TiciMainActivity$initViewModels$10>) null), 3, (Object) null);
        Job unused4 = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TiciMainActivity$initViewModels$11(this, (Continuation<? super TiciMainActivity$initViewModels$11>) null), 3, (Object) null);
        Job unused5 = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TiciMainActivity$initViewModels$12(this, (Continuation<? super TiciMainActivity$initViewModels$12>) null), 3, (Object) null);
        Job unused6 = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TiciMainActivity$initViewModels$13(this, (Continuation<? super TiciMainActivity$initViewModels$13>) null), 3, (Object) null);
        Job unused7 = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TiciMainActivity$initViewModels$14(this, (Continuation<? super TiciMainActivity$initViewModels$14>) null), 3, (Object) null);
        Job unused8 = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TiciMainActivity$initViewModels$15(this, (Continuation<? super TiciMainActivity$initViewModels$15>) null), 3, (Object) null);
        Job unused9 = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TiciMainActivity$initViewModels$16(this, (Continuation<? super TiciMainActivity$initViewModels$16>) null), 3, (Object) null);
        Job unused10 = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TiciMainActivity$initViewModels$17(this, (Continuation<? super TiciMainActivity$initViewModels$17>) null), 3, (Object) null);
        Job unused11 = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TiciMainActivity$initViewModels$18(this, (Continuation<? super TiciMainActivity$initViewModels$18>) null), 3, (Object) null);
        Job unused12 = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TiciMainActivity$initViewModels$19(this, (Continuation<? super TiciMainActivity$initViewModels$19>) null), 3, (Object) null);
        Job unused13 = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TiciMainActivity$initViewModels$20(this, (Continuation<? super TiciMainActivity$initViewModels$20>) null), 3, (Object) null);
    }

    private final void initViews() {
        ViewExtKt.b(d1().v.getBackImg(), new s0(this));
        ViewExtKt.b(d1().v.getFolderImg(), new t0(this));
        ViewExtKt.b(d1().v.getSettingImg(), new u0(this));
        MzButton mzButton = d1().o;
        Intrinsics.checkNotNullExpressionValue(mzButton, "startTiciBtn");
        ViewExtKt.b(mzButton, new i0(this));
        ImageView imageView = d1().b;
        Intrinsics.checkNotNullExpressionValue(imageView, "autoTiciBtn");
        ViewExtKt.b(imageView, new j0(this));
        d1().w.setOnScrollListener(new TiciMainActivity$initViews$6(this));
        d1().u.setOnTouchListener(new k0(this));
        d1().u.setOnSeekBarChangeListener(new TiciMainActivity$initViews$8(this));
        d1().j.addAnimatorListener(new TiciMainActivity$initViews$9(this));
        ImageView imageView2 = d1().c;
        Intrinsics.checkNotNullExpressionValue(imageView2, "btnClose");
        ViewExtKt.b(imageView2, new l0(this));
    }

    /* access modifiers changed from: private */
    public final void l1(int i) {
        CommonExtKt.b("highlight, index: " + i, "TiciMainActivity");
        e1().A(i, false);
        if (!this.d.s0()) {
            CommonExtKt.b("highlight, refresh ticiState", "TiciMainActivity");
            TiciMainViewModel.m(e1(), 0, 1, (Object) null);
        }
    }

    public static final void n1(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void o1(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void p1(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public static final void q1(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void r1(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void s1(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void t1(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public static final void u1(TiciMainActivity ticiMainActivity, View view) {
        Intrinsics.checkNotNullParameter(ticiMainActivity, "this$0");
        ticiMainActivity.finish();
    }

    public static final void v1(TiciMainActivity ticiMainActivity, View view) {
        Intrinsics.checkNotNullParameter(ticiMainActivity, "this$0");
        Intent intent = new Intent(ticiMainActivity, TiciHistoryActivity.class);
        if (!(ticiMainActivity instanceof Activity)) {
            intent.addFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
        }
        ticiMainActivity.startActivity(intent);
    }

    public static final void w1(TiciMainActivity ticiMainActivity, View view) {
        Intrinsics.checkNotNullParameter(ticiMainActivity, "this$0");
        if (TiciApp.b.d()) {
            Intent intent = new Intent(ticiMainActivity, TiciSettingActivity.class);
            if (!(ticiMainActivity instanceof Activity)) {
                intent.addFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
            }
            ticiMainActivity.startActivity(intent);
        }
    }

    public static final void x1(TiciMainActivity ticiMainActivity, View view) {
        Intrinsics.checkNotNullParameter(ticiMainActivity, "this$0");
        CommonExtKt.e("startTiciBtn-> click", "TiciMainActivity");
        if (TiciApp.b.d()) {
            ticiMainActivity.D1();
        }
    }

    public static final void y1(TiciMainActivity ticiMainActivity, View view) {
        Intrinsics.checkNotNullParameter(ticiMainActivity, "this$0");
        TiciApp ticiApp = TiciApp.b;
        if (ticiApp.d()) {
            StarryNetDevice connectXrDevice = ticiApp.q().getConnectXrDevice();
            CommonExtKt.e("autoTiciBtn-> click. " + ticiMainActivity.d.s0() + ", device: " + connectXrDevice, "TiciMainActivity");
            if (connectXrDevice == null) {
                CommonExtKt.j(ticiMainActivity, R.string.tici_disconnect_toast, 0, 2, (Object) null);
                return;
            }
            TiciInfo r = ticiMainActivity.e1().r();
            if (r != null) {
                ParagraphProgress paragraphProgress = (ParagraphProgress) ticiMainActivity.e1().q().getValue();
                if (r.isReachLast(paragraphProgress != null ? paragraphProgress.getProgress() : 0) && !ticiMainActivity.d.o0() && ticiMainActivity.d1().j.getProgress() == 0.0f) {
                    ticiMainActivity.e1().A(0, true);
                }
                ticiMainActivity.d.E0(false);
                boolean z = !ticiMainActivity.d.o0();
                ticiMainActivity.d.F0(z);
                ticiApp.q().sendAutoTiciState(z);
                return;
            }
            CommonExtKt.e("initViews-> 当前没有在运行的内容，这是一个错误", "TiciMainActivity");
            ticiMainActivity.d.G0(false);
            ticiMainActivity.d.F0(false);
        }
    }

    public static final boolean z1(TiciMainActivity ticiMainActivity, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(ticiMainActivity, "this$0");
        if (ticiMainActivity.c1()) {
            CommonExtKt.e("ticiProgress-> onTouch, blockTiciProgress=true", "TiciMainActivity");
            return true;
        }
        TiciApp ticiApp = TiciApp.b;
        if (ticiApp.j()) {
            StarryNetDevice connectXrDevice = ticiApp.q().getConnectXrDevice();
            CommonExtKt.e("ticiProgress-> onTouch, device: " + connectXrDevice, "TiciMainActivity");
            if (connectXrDevice == null) {
                if (motionEvent.getAction() == 0) {
                    CommonExtKt.j(ticiMainActivity, R.string.tici_disconnect_toast, 0, 2, (Object) null);
                }
                return true;
            }
        }
        return false;
    }

    public final void B1() {
        TiciMainViewModel.F(e1(), (Long) null, (Integer) null, true, true, 3, (Object) null);
        LottieAnimationView lottieAnimationView = d1().j;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "lottieAutoTici");
        LottieExtKt.e(lottieAnimationView, SpUtilKt.k());
        d1().j.setProgress(0.0f);
    }

    public final void C1() {
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TiciMainActivity$runDataMigrationAndLoadContent$1(this, (Continuation<? super TiciMainActivity$runDataMigrationAndLoadContent$1>) null), 3, (Object) null);
    }

    public final void D1() {
        if (TiciApp.b.q().getConnectXrDevice() == null) {
            CommonExtKt.e("startTici, connectedDevice is null", "TiciMainActivity");
            CommonExtKt.j(this, R.string.tici_disconnect_toast, 0, 2, (Object) null);
            return;
        }
        TiciInfo r = e1().r();
        if (r == null) {
            CommonExtKt.d("startTici, currentTxtInfo is null", "TiciMainActivity", (Throwable) null, 2, (Object) null);
        } else {
            TiciAppViewModel.N0(this.d, TiciInfoKt.b(r), OpenTiciFrom.TiciHomePage, false, true, (Integer) null, (Integer) null, 52, (Object) null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0092, code lost:
        if (r3.getVisibility() == 0) goto L_0x0094;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Y0(boolean r8, boolean r9, boolean r10) {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "changeStartTiciBtnState-> isGlassesTiciRunning: "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r1 = ", isAutoTiciRunning: "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r1 = ", isAutoTiciFinish: "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "TiciMainActivity"
            com.upuphone.ar.tici.phone.utils.CommonExtKt.e(r0, r1)
            int r0 = com.upuphone.ar.tici.phone.utils.SpUtilKt.j()
            java.lang.String r1 = "startTiciBtn"
            if (r8 == 0) goto L_0x003b
            com.upuphone.ar.tici.databinding.TiciMainActivityLayoutBinding r2 = r7.d1()
            com.meizu.common.widget.MzButton r2 = r2.o
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            com.upuphone.ar.tici.phone.utils.CommonExtKt.f(r2)
            goto L_0x0047
        L_0x003b:
            com.upuphone.ar.tici.databinding.TiciMainActivityLayoutBinding r2 = r7.d1()
            com.meizu.common.widget.MzButton r2 = r2.o
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            com.upuphone.ar.tici.phone.utils.CommonExtKt.g(r2)
        L_0x0047:
            java.lang.String r1 = "lottieAutoTiciPause"
            java.lang.String r2 = "lottieAutoTici"
            java.lang.String r3 = "ticiModeManualIcon"
            java.lang.String r4 = "autoTiciBtn"
            if (r0 == 0) goto L_0x00fe
            r5 = 1
            if (r0 == r5) goto L_0x0056
            goto L_0x012e
        L_0x0056:
            com.upuphone.ar.tici.databinding.TiciMainActivityLayoutBinding r0 = r7.d1()
            android.widget.ImageView r0 = r0.t
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            com.upuphone.ar.tici.phone.utils.CommonExtKt.f(r0)
            if (r9 == 0) goto L_0x006e
            com.upuphone.ar.tici.databinding.TiciMainActivityLayoutBinding r0 = r7.d1()
            com.airbnb.lottie.LottieAnimationView r0 = r0.j
            r0.resumeAnimation()
            goto L_0x0077
        L_0x006e:
            com.upuphone.ar.tici.databinding.TiciMainActivityLayoutBinding r0 = r7.d1()
            com.airbnb.lottie.LottieAnimationView r0 = r0.j
            r0.pauseAnimation()
        L_0x0077:
            com.upuphone.ar.tici.databinding.TiciMainActivityLayoutBinding r0 = r7.d1()
            com.airbnb.lottie.LottieAnimationView r0 = r0.j
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            r2 = 0
            if (r9 == 0) goto L_0x0094
            com.upuphone.ar.tici.databinding.TiciMainActivityLayoutBinding r3 = r7.d1()
            androidx.constraintlayout.widget.ConstraintLayout r3 = r3.s
            java.lang.String r6 = "ticiLoadingView"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r6)
            int r3 = r3.getVisibility()
            if (r3 != 0) goto L_0x0095
        L_0x0094:
            r5 = r2
        L_0x0095:
            r3 = 8
            if (r5 == 0) goto L_0x009b
            r5 = r2
            goto L_0x009c
        L_0x009b:
            r5 = r3
        L_0x009c:
            r0.setVisibility(r5)
            com.upuphone.ar.tici.databinding.TiciMainActivityLayoutBinding r0 = r7.d1()
            com.airbnb.lottie.LottieAnimationView r0 = r0.k
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r1 = r9 ^ 1
            if (r1 == 0) goto L_0x00ad
            goto L_0x00ae
        L_0x00ad:
            r2 = r3
        L_0x00ae:
            r0.setVisibility(r2)
            if (r8 == 0) goto L_0x00d0
            com.upuphone.ar.tici.databinding.TiciMainActivityLayoutBinding r0 = r7.d1()
            android.widget.ImageView r0 = r0.b
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            com.upuphone.ar.tici.phone.utils.CommonExtKt.g(r0)
            if (r9 == 0) goto L_0x00c4
            int r9 = com.upuphone.ar.tici.R.drawable.tici_auto_pause
            goto L_0x00c6
        L_0x00c4:
            int r9 = com.upuphone.ar.tici.R.drawable.tici_auto_play
        L_0x00c6:
            com.upuphone.ar.tici.databinding.TiciMainActivityLayoutBinding r0 = r7.d1()
            android.widget.ImageView r0 = r0.b
            r0.setImageResource(r9)
            goto L_0x00dc
        L_0x00d0:
            com.upuphone.ar.tici.databinding.TiciMainActivityLayoutBinding r9 = r7.d1()
            android.widget.ImageView r9 = r9.b
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r4)
            com.upuphone.ar.tici.phone.utils.CommonExtKt.f(r9)
        L_0x00dc:
            if (r10 != 0) goto L_0x00e0
            if (r8 != 0) goto L_0x00ea
        L_0x00e0:
            com.upuphone.ar.tici.databinding.TiciMainActivityLayoutBinding r8 = r7.d1()
            com.airbnb.lottie.LottieAnimationView r8 = r8.j
            r9 = 0
            r8.setProgress(r9)
        L_0x00ea:
            com.upuphone.ar.tici.databinding.TiciMainActivityLayoutBinding r8 = r7.d1()
            com.airbnb.lottie.LottieAnimationView r8 = r8.k
            com.upuphone.ar.tici.databinding.TiciMainActivityLayoutBinding r7 = r7.d1()
            com.airbnb.lottie.LottieAnimationView r7 = r7.j
            float r7 = r7.getProgress()
            r8.setProgress(r7)
            goto L_0x012e
        L_0x00fe:
            com.upuphone.ar.tici.databinding.TiciMainActivityLayoutBinding r8 = r7.d1()
            com.airbnb.lottie.LottieAnimationView r8 = r8.j
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r2)
            com.upuphone.ar.tici.phone.utils.CommonExtKt.f(r8)
            com.upuphone.ar.tici.databinding.TiciMainActivityLayoutBinding r8 = r7.d1()
            com.airbnb.lottie.LottieAnimationView r8 = r8.k
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r1)
            com.upuphone.ar.tici.phone.utils.CommonExtKt.f(r8)
            com.upuphone.ar.tici.databinding.TiciMainActivityLayoutBinding r8 = r7.d1()
            android.widget.ImageView r8 = r8.t
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r3)
            com.upuphone.ar.tici.phone.utils.CommonExtKt.g(r8)
            com.upuphone.ar.tici.databinding.TiciMainActivityLayoutBinding r7 = r7.d1()
            android.widget.ImageView r7 = r7.b
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r4)
            com.upuphone.ar.tici.phone.utils.CommonExtKt.f(r7)
        L_0x012e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.TiciMainActivity.Y0(boolean, boolean, boolean):void");
    }

    public final boolean a1(long j) {
        if (System.currentTimeMillis() - this.e <= j) {
            return false;
        }
        this.e = System.currentTimeMillis();
        return true;
    }

    public final TiciMainActivityLayoutBinding d1() {
        return (TiciMainActivityLayoutBinding) this.b.getValue();
    }

    public final TiciMainViewModel e1() {
        return (TiciMainViewModel) this.c.getValue();
    }

    public final void f1(OpenTiciMsgReply openTiciMsgReply) {
        String fileKey = openTiciMsgReply.getFileKey();
        CommonExtKt.e("handleOpenTiciReply, fileKey: " + fileKey, "TiciMainActivity");
        Long b2 = TiciEntityKt.b(openTiciMsgReply.getFileKey());
        if (b2 != null) {
            e1().w(b2.longValue());
            return;
        }
        CommonExtKt.d("handleOpenTiciReply, can`t parse tici id", "TiciMainActivity", (Throwable) null, 2, (Object) null);
    }

    public final void g1(OpenTiciMsgReplyV2 openTiciMsgReplyV2) {
        String fileKey = openTiciMsgReplyV2.getFileKey();
        CommonExtKt.e("handleOpenTiciReplyV2, fileKey: " + fileKey, "TiciMainActivity");
        Long b2 = TiciEntityKt.b(openTiciMsgReplyV2.getFileKey());
        if (b2 != null) {
            e1().w(b2.longValue());
            return;
        }
        CommonExtKt.d("handleOpenTiciReplyV2, can`t parse tici id", "TiciMainActivity", (Throwable) null, 2, (Object) null);
    }

    public final void h1(OpenTiciMsgReplyV3 openTiciMsgReplyV3) {
        String fileKey = openTiciMsgReplyV3.getFileKey();
        CommonExtKt.e("handleOpenTiciReplyV3, fileKey: " + fileKey, "TiciMainActivity");
        Long b2 = TiciEntityKt.b(openTiciMsgReplyV3.getFileKey());
        if (b2 != null) {
            e1().w(b2.longValue());
            return;
        }
        CommonExtKt.d("handleOpenTiciReplyV3, can`t parse tici id", "TiciMainActivity", (Throwable) null, 2, (Object) null);
    }

    public final void i1(OpenTiciResult openTiciResult) {
        CommonExtKt.e("handleOpenTiciResult, result: " + openTiciResult, "TiciMainActivity");
        int a2 = openTiciResult.a();
        if (a2 == ConstantsKt.g()) {
            if (openTiciResult.b() == OpenTiciFrom.ResetToDefaultTici) {
                CommonExtKt.j(this, R.string.tici_reset_tici_file_success, 0, 2, (Object) null);
            }
            if (this.d.R().getValue() != null) {
                this.d.G0(true);
                this.d.F0(true);
                this.d.E0(false);
            }
        } else if (a2 == ConstantsKt.e()) {
        } else {
            if (openTiciResult.b() == OpenTiciFrom.ResetToDefaultTici) {
                CommonExtKt.j(this, R.string.tici_operation_failed_pls_try_again, 0, 2, (Object) null);
            } else if (openTiciResult.a() == ConstantsKt.f()) {
                CommonExtKt.j(this, R.string.tici_unknown_file_encoding, 0, 2, (Object) null);
            } else {
                CommonExtKt.j(this, R.string.tici_failed_tips, 0, 2, (Object) null);
            }
        }
    }

    public final void j1(TiciEntity ticiEntity) {
        String simpleString = ticiEntity.toSimpleString();
        CommonExtKt.b("handleResetTiciFile, ticiEntity: " + simpleString, "TiciMainActivity");
        TiciMainViewModel.F(e1(), Long.valueOf(ticiEntity.getId()), (Integer) null, false, false, 14, (Object) null);
    }

    public final void k1(boolean z) {
        CommonExtKt.e("handleSettingChanged, changed: " + z, "TiciMainActivity");
        this.d.F0(false);
        if (z) {
            long k = SpUtilKt.k();
            CommonExtKt.e("handleSettingChanged, ticiSpeed: " + k, "TiciMainActivity");
            LottieAnimationView lottieAnimationView = d1().j;
            Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "lottieAutoTici");
            LottieExtKt.e(lottieAnimationView, SpUtilKt.k());
            d1().j.setProgress(0.0f);
            e1().l(300);
        }
    }

    public final void m1(int i, int i2) {
        CommonExtKt.b("highlightByPage, page: " + i + ", index: " + i2, "TiciMainActivity");
        TiciMainViewModel.y(e1(), i, i2, false, 4, (Object) null);
        if (!this.d.s0()) {
            CommonExtKt.b("highlightByPage, refresh ticiState", "TiciMainActivity");
            TiciMainViewModel.m(e1(), 0, 1, (Object) null);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CommonExtKt.e("onCreate-> ", "TiciMainActivity");
        this.d.u0().set(true);
        setContentView((View) d1().getRoot());
        initViews();
        initViewModels();
        Z0();
        C1();
    }

    public void onDestroy() {
        super.onDestroy();
        CommonExtKt.e("onDestroy-> ", "TiciMainActivity");
        this.d.u0().set(false);
        TiciApp.b.e();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "event");
        CommonExtKt.e("onKeyDown, event: " + keyEvent, "TiciMainActivity");
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 24) {
            TiciApp ticiApp = TiciApp.b;
            if (ticiApp.j()) {
                StarryNetDevice connectXrDevice = ticiApp.q().getConnectXrDevice();
                CommonExtKt.e("onKeyDown-> 音量上, device: " + connectXrDevice, "TiciMainActivity");
                if (connectXrDevice == null) {
                    CommonExtKt.j(this, R.string.tici_disconnect_toast, 0, 2, (Object) null);
                    return true;
                }
            }
            if (this.d.K().getValue() != null) {
                CommonExtKt.e("onKeyDown-> 音量上, loading", "TiciMainActivity");
                return true;
            }
            if (b1(this, 0, 1, (Object) null)) {
                TiciMainViewModel.D(e1(), -1, false, 2, (Object) null);
            }
            return true;
        } else if (keyCode != 25) {
            return super.onKeyDown(i, keyEvent);
        } else {
            TiciApp ticiApp2 = TiciApp.b;
            if (ticiApp2.j()) {
                StarryNetDevice connectXrDevice2 = ticiApp2.q().getConnectXrDevice();
                CommonExtKt.e("onKeyDown-> 音量下, device: " + connectXrDevice2, "TiciMainActivity");
                if (connectXrDevice2 == null) {
                    CommonExtKt.j(this, R.string.tici_disconnect_toast, 0, 2, (Object) null);
                    return true;
                }
            }
            if (this.d.K().getValue() != null) {
                CommonExtKt.e("onKeyDown-> 音量下, loading", "TiciMainActivity");
                return true;
            }
            if (b1(this, 0, 1, (Object) null)) {
                TiciMainViewModel.D(e1(), 1, false, 2, (Object) null);
            }
            return true;
        }
    }
}
