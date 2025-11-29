package com.upuphone.ar.tici.phone;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.honey.account.p4.a1;
import com.honey.account.p4.b1;
import com.honey.account.p4.c1;
import com.honey.account.p4.d1;
import com.honey.account.p4.e1;
import com.honey.account.p4.f1;
import com.honey.account.p4.g1;
import com.honey.account.p4.h1;
import com.honey.account.p4.i1;
import com.honey.account.p4.j1;
import com.honey.account.p4.k1;
import com.honey.account.p4.l1;
import com.honey.account.p4.z0;
import com.meizu.common.widget.MzSeekBar;
import com.upuphone.ar.tici.R;
import com.upuphone.ar.tici.databinding.TiciSettingBinding;
import com.upuphone.ar.tici.phone.starrynet.msg.ChangeTiciModeMsg;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import com.upuphone.ar.tici.phone.utils.LottieExtKt;
import com.upuphone.ar.tici.phone.utils.SpUtilKt;
import com.upuphone.ar.tici.phone.utils.TiciDataTrack;
import com.upuphone.ar.tici.phone.widget.TiciScreenLocationView;
import com.upuphone.ar.tici.phone.widget.TiciSettingCardItem;
import com.upuphone.ar.tici.phone.widget.TiciTitleBar;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.sapp.context.GlassInfoExtKt;
import com.upuphone.xr.sapp.context.IGlassInfo;
import com.upuphone.xr.sapp.context.SdkContext;
import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 ;2\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0003J!\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u0003J'\u0010\"\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\rH\u0002¢\u0006\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020$8BX\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020+0*8\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R+\u0010\f\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u000b8B@BX\u0002¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0014\u00108\u001a\u00020\u00118BX\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0014\u0010:\u001a\u00020\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b9\u00103¨\u0006="}, d2 = {"Lcom/upuphone/ar/tici/phone/TiciSettingActivity;", "Lcom/upuphone/ar/tici/phone/BaseTiciActivity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "initView", "initViewModel", "", "ticiMode", "", "needSaveSp", "L0", "(IZ)V", "", "ticiSpeed", "max", "e1", "(JI)I", "progress", "d1", "(II)J", "", "k1", "(J)Ljava/lang/String;", "i1", "(IJ)V", "g1", "isNotificationVisible", "isScreenLocationVisible", "isDoNotDisturbVisible", "h1", "(ZZZ)V", "Lcom/upuphone/ar/tici/databinding/TiciSettingBinding;", "b", "Lkotlin/Lazy;", "N0", "()Lcom/upuphone/ar/tici/databinding/TiciSettingBinding;", "layout", "Landroid/util/SparseArray;", "Lcom/upuphone/ar/tici/phone/widget/TiciSettingCardItem;", "c", "Landroid/util/SparseArray;", "checkViewType", "<set-?>", "d", "Lkotlin/properties/ReadWriteProperty;", "getTiciMode", "()I", "f1", "(I)V", "O0", "()J", "totalProgress", "P0", "totalProgressSeconds", "e", "Companion", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTiciSettingActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciSettingActivity.kt\ncom/upuphone/ar/tici/phone/TiciSettingActivity\n+ 2 Delegates.kt\nkotlin/properties/Delegates\n+ 3 View.kt\nandroidx/core/view/ViewKt\n+ 4 SparseArray.kt\nandroidx/core/util/SparseArrayKt\n*L\n1#1,447:1\n33#2,3:448\n262#3,2:451\n262#3,2:453\n262#3,2:459\n262#3,2:461\n262#3,2:463\n262#3,2:465\n260#3:467\n260#3:468\n76#4,4:455\n*S KotlinDebug\n*F\n+ 1 TiciSettingActivity.kt\ncom/upuphone/ar/tici/phone/TiciSettingActivity\n*L\n64#1:448,3\n89#1:451,2\n90#1:453,2\n290#1:459,2\n430#1:461,2\n431#1:463,2\n432#1:465,2\n433#1:467\n440#1:468\n283#1:455,4\n*E\n"})
public final class TiciSettingActivity extends BaseTiciActivity {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);
    public static final /* synthetic */ KProperty[] f = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(TiciSettingActivity.class, "ticiMode", "getTiciMode()I", 0))};
    public final Lazy b = LazyKt.lazy(new TiciSettingActivity$layout$2(this));
    public final SparseArray c = new SparseArray();
    public final ReadWriteProperty d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/tici/phone/TiciSettingActivity$Companion;", "", "()V", "TAG", "", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public TiciSettingActivity() {
        Delegates delegates = Delegates.INSTANCE;
        this.d = new TiciSettingActivity$special$$inlined$observable$1(-1, this);
    }

    public static /* synthetic */ void M0(TiciSettingActivity ticiSettingActivity, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        ticiSettingActivity.L0(i, z);
    }

    public static final void Q0(TiciSettingActivity ticiSettingActivity, View view) {
        Intrinsics.checkNotNullParameter(ticiSettingActivity, "this$0");
        TiciApp ticiApp = TiciApp.b;
        StarryNetDevice connectXrDevice = ticiApp.q().getConnectXrDevice();
        CommonExtKt.e("ResetTiciFile clicked, device: " + connectXrDevice, "TiciSettingActivity");
        if (connectXrDevice == null) {
            CommonExtKt.j(ticiSettingActivity, R.string.tici_disconnect_toast, 0, 2, (Object) null);
        } else {
            ticiApp.c().C0();
        }
    }

    public static final boolean R0(TiciSettingActivity ticiSettingActivity, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(ticiSettingActivity, "this$0");
        if (TiciApp.b.q().getConnectXrDevice() != null) {
            return false;
        }
        if (motionEvent.getAction() != 0) {
            return true;
        }
        CommonExtKt.j(ticiSettingActivity, R.string.tici_disconnect_toast, 0, 2, (Object) null);
        return true;
    }

    public static final void S0(TiciSettingActivity ticiSettingActivity, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(ticiSettingActivity, "this$0");
        CommonExtKt.e("NotificationSetting.switchButton: isChecked: " + z, "TiciSettingActivity");
        SpUtilKt.q(z);
        j1(ticiSettingActivity, 0, 0, 3, (Object) null);
        TiciDataTrack ticiDataTrack = TiciDataTrack.f6001a;
        ticiDataTrack.c("app_prompt_notice", MapsKt.mapOf(TuplesKt.to("notice", Integer.valueOf(ticiDataTrack.b(ticiSettingActivity)))));
    }

    public static final boolean T0(TiciSettingActivity ticiSettingActivity, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(ticiSettingActivity, "this$0");
        if (TiciApp.b.q().getConnectXrDevice() != null) {
            return false;
        }
        if (motionEvent.getAction() != 0) {
            return true;
        }
        CommonExtKt.j(ticiSettingActivity, R.string.tici_disconnect_toast, 0, 2, (Object) null);
        return true;
    }

    public static final void U0(TiciSettingActivity ticiSettingActivity, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(ticiSettingActivity, "this$0");
        CommonExtKt.e("DoNotDisturbSetting.switchButton: isChecked: " + z, "TiciSettingActivity");
        SpUtilKt.q(z ^ true);
        j1(ticiSettingActivity, 0, 0, 3, (Object) null);
        TiciDataTrack ticiDataTrack = TiciDataTrack.f6001a;
        ticiDataTrack.c("app_prompt_notice", MapsKt.mapOf(TuplesKt.to("notice", Integer.valueOf(ticiDataTrack.b(ticiSettingActivity)))));
    }

    public static final void V0(TiciSettingActivity ticiSettingActivity, View view) {
        Intrinsics.checkNotNullParameter(ticiSettingActivity, "this$0");
        ticiSettingActivity.onBackPressed();
    }

    public static final void W0(TiciSettingActivity ticiSettingActivity, View view) {
        Intrinsics.checkNotNullParameter(ticiSettingActivity, "this$0");
        StarryNetDevice connectXrDevice = TiciApp.b.q().getConnectXrDevice();
        CommonExtKt.e("TiciModeManual clicked. device: " + connectXrDevice, "TiciSettingActivity");
        if (connectXrDevice == null) {
            CommonExtKt.j(ticiSettingActivity, R.string.tici_disconnect_toast, 0, 2, (Object) null);
            return;
        }
        ticiSettingActivity.f1(0);
        TiciDataTrack ticiDataTrack = TiciDataTrack.f6001a;
        ticiDataTrack.c("app_prompt_mode", MapsKt.mapOf(TuplesKt.to(RtspHeaders.Values.MODE, Integer.valueOf(ticiDataTrack.a(ticiSettingActivity)))));
    }

    public static final void X0(TiciSettingActivity ticiSettingActivity, View view) {
        Intrinsics.checkNotNullParameter(ticiSettingActivity, "this$0");
        StarryNetDevice connectXrDevice = TiciApp.b.q().getConnectXrDevice();
        CommonExtKt.e("TiciModeAuto clicked. device: " + connectXrDevice, "TiciSettingActivity");
        if (connectXrDevice == null) {
            CommonExtKt.j(ticiSettingActivity, R.string.tici_disconnect_toast, 0, 2, (Object) null);
            return;
        }
        ticiSettingActivity.f1(1);
        TiciDataTrack ticiDataTrack = TiciDataTrack.f6001a;
        ticiDataTrack.c("app_prompt_mode", MapsKt.mapOf(TuplesKt.to(RtspHeaders.Values.MODE, Integer.valueOf(ticiDataTrack.a(ticiSettingActivity)))));
    }

    public static final void Y0(TiciSettingActivity ticiSettingActivity, View view) {
        Intrinsics.checkNotNullParameter(ticiSettingActivity, "this$0");
        StarryNetDevice connectXrDevice = TiciApp.b.q().getConnectXrDevice();
        CommonExtKt.e("TiciModeAI clicked. device: " + connectXrDevice, "TiciSettingActivity");
        if (connectXrDevice == null) {
            CommonExtKt.j(ticiSettingActivity, R.string.tici_disconnect_toast, 0, 2, (Object) null);
        } else {
            CommonExtKt.k("开发中", ticiSettingActivity, 0, 2, (Object) null);
        }
    }

    public static final void Z0(LottieAnimationView lottieAnimationView, long j) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "$this_apply");
        LottieExtKt.e(lottieAnimationView, j);
    }

    public static final boolean a1(TiciSettingActivity ticiSettingActivity, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(ticiSettingActivity, "this$0");
        if (TiciApp.b.q().getConnectXrDevice() != null) {
            return false;
        }
        if (motionEvent.getAction() != 0) {
            return true;
        }
        CommonExtKt.j(ticiSettingActivity, R.string.tici_disconnect_toast, 0, 2, (Object) null);
        return true;
    }

    public static final void b1(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public static final void c1(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void initView() {
        TiciTitleBar ticiTitleBar = N0().j;
        ticiTitleBar.getFolderImg().setVisibility(8);
        ticiTitleBar.getSettingImg().setVisibility(8);
        ticiTitleBar.getBackImg().setOnClickListener(new z0(this));
        N0().h.setOnClickListener(new e1(this));
        N0().f.setOnClickListener(new f1(this));
        N0().e.setOnClickListener(new g1(this));
        this.c.put(0, N0().h);
        this.c.put(1, N0().f);
        this.c.put(2, N0().e);
        L0(SpUtilKt.j(), false);
        long k = SpUtilKt.k();
        N0().g.k.setText(k1(k));
        LottieAnimationView lottieAnimationView = N0().g.d;
        lottieAnimationView.addAnimatorListener(new TiciSettingActivity$initView$5$1(this));
        lottieAnimationView.post(new h1(lottieAnimationView, k));
        MzSeekBar mzSeekBar = N0().g.e;
        mzSeekBar.setOnTouchListener(new i1(this));
        mzSeekBar.setMax(P0());
        mzSeekBar.setProgress(e1(k, mzSeekBar.getMax()));
        mzSeekBar.setOnSeekBarChangeListener(new TiciSettingActivity$initView$6$2(this, mzSeekBar));
        N0().d.setOnClickListener(new j1(this));
        N0().c.getSwitchButton().setChecked(SpUtilKt.g());
        N0().c.getSwitchButton().setOnTouchListener(new k1(this));
        N0().c.getSwitchButton().setOnCheckedChangeListener(new l1(this));
        N0().b.getSwitchButton().setChecked(SpUtilKt.b());
        N0().b.getSwitchButton().setOnTouchListener(new a1(this));
        N0().b.getSwitchButton().setOnCheckedChangeListener(new d1(this));
        N0().i.setItemClickListener(new TiciSettingActivity$initView$12(this));
        N0().i.n(SpUtilKt.h());
    }

    private final void initViewModel() {
        TiciApp.b.c().Q().observe(this, new b1(new TiciSettingActivity$initViewModel$1(this)));
        SdkContext.f6675a.e().b().observe(this, new c1(new TiciSettingActivity$initViewModel$2(this)));
    }

    public static /* synthetic */ void j1(TiciSettingActivity ticiSettingActivity, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = SpUtilKt.j();
        }
        if ((i2 & 2) != 0) {
            j = SpUtilKt.k();
        }
        ticiSettingActivity.i1(i, j);
    }

    public final void L0(int i, boolean z) {
        CommonExtKt.e("checkTiciMode, ticiMode: " + i, "TiciSettingActivity");
        SparseArray sparseArray = this.c;
        int size = sparseArray.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            int keyAt = sparseArray.keyAt(i3);
            TiciSettingCardItem ticiSettingCardItem = (TiciSettingCardItem) sparseArray.valueAt(i3);
            if (keyAt == i) {
                ticiSettingCardItem.setItemType(2);
            } else {
                ticiSettingCardItem.setItemType(0);
            }
        }
        ConstraintLayout b2 = N0().g.getRoot();
        Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
        if (!(i == 1)) {
            i2 = 8;
        }
        b2.setVisibility(i2);
        if (i == 1) {
            LottieAnimationView lottieAnimationView = N0().g.d;
            Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "lottieSpeedClock");
            LottieExtKt.c(lottieAnimationView);
        }
        if (z) {
            SpUtilKt.t(i);
            j1(this, i, 0, 2, (Object) null);
        }
    }

    public final TiciSettingBinding N0() {
        return (TiciSettingBinding) this.b.getValue();
    }

    public final long O0() {
        return 55000;
    }

    public final int P0() {
        return MathKt.roundToInt(((float) O0()) / ((float) 1000));
    }

    public final long d1(int i, int i2) {
        return MathKt.roundToLong(((float) 60000) - (((float) O0()) * (((float) i) / ((float) i2))));
    }

    public final int e1(long j, int i) {
        return MathKt.roundToInt((((float) (60000 - j)) / ((float) O0())) * ((float) i));
    }

    public final void f1(int i) {
        this.d.setValue(this, f[0], Integer.valueOf(i));
    }

    public final void g1() {
        String str;
        String str2;
        SdkContext sdkContext = SdkContext.f6675a;
        IGlassInfo a2 = sdkContext.e().a();
        CommonExtKt.e("setupUIByGlassInfo, glassInfo: " + a2, "TiciSettingActivity");
        boolean z = false;
        if (a2 == null || GlassInfoExtKt.i(a2)) {
            h1(false, false, false);
            return;
        }
        boolean isAirPro = sdkContext.e().isAirPro();
        CommonExtKt.e("setupUIByGlassInfo, isAirPro: " + isAirPro, "TiciSettingActivity");
        String c2 = GlassInfoExtKt.c(GlassInfoExtKt.d(a2.getRomVersion()));
        CommonExtKt.e("setupUIByGlassInfo, glassVersion: " + c2, "TiciSettingActivity");
        boolean z2 = true;
        if (isAirPro) {
            if (GlassInfoExtKt.j(c2, "1.1.3") >= 0) {
                z = true;
            }
            h1(!z, true, z);
            return;
        }
        if (GlassInfoExtKt.f(a2)) {
            str2 = GlassInfoExtKt.c(GlassInfoExtKt.d("Flyme AR 1.0.4.12.20240329_Air_FR"));
            str = GlassInfoExtKt.c(GlassInfoExtKt.d("Flyme AR 1.0.6.3.20240424_Air_FR"));
        } else if (GlassInfoExtKt.g(a2) || GlassInfoExtKt.e(a2)) {
            str2 = GlassInfoExtKt.c(GlassInfoExtKt.d("1.0.2.76"));
            str = GlassInfoExtKt.c(GlassInfoExtKt.d("1.0.3.76"));
        } else {
            str2 = null;
            str = null;
        }
        boolean z3 = str2 != null && GlassInfoExtKt.j(c2, str2) >= 0;
        if (str == null || GlassInfoExtKt.j(c2, str) < 0) {
            z2 = false;
        }
        h1(z3, z2, false);
    }

    public final void h1(boolean z, boolean z2, boolean z3) {
        CommonExtKt.e("setupUIItemVisible, isNotificationVisible: " + z + ", isScreenLocationVisible: " + z2 + ", isDoNotDisturbVisible: " + z3, "TiciSettingActivity");
        TiciScreenLocationView ticiScreenLocationView = N0().i;
        Intrinsics.checkNotNullExpressionValue(ticiScreenLocationView, "ticiScreenLocationView");
        int i = 8;
        ticiScreenLocationView.setVisibility(z2 ? 0 : 8);
        TiciSettingCardItem ticiSettingCardItem = N0().c;
        Intrinsics.checkNotNullExpressionValue(ticiSettingCardItem, "layNotificationSetting");
        ticiSettingCardItem.setVisibility(z ? 0 : 8);
        TiciSettingCardItem ticiSettingCardItem2 = N0().b;
        Intrinsics.checkNotNullExpressionValue(ticiSettingCardItem2, "layDoNotDisturbSetting");
        if (z3) {
            i = 0;
        }
        ticiSettingCardItem2.setVisibility(i);
        TiciScreenLocationView ticiScreenLocationView2 = N0().i;
        Intrinsics.checkNotNullExpressionValue(ticiScreenLocationView2, "ticiScreenLocationView");
        if (ticiScreenLocationView2.getVisibility() == 0) {
            N0().c.setBackgroundResource(com.upuphone.xr.sapp.common.R.drawable.card_item_middle_rectangle_selector);
            N0().b.setBackgroundResource(com.upuphone.xr.sapp.common.R.drawable.card_item_middle_rectangle_selector);
        } else {
            N0().c.setBackgroundResource(com.upuphone.xr.sapp.common.R.drawable.card_item_top_round_selector);
            N0().b.setBackgroundResource(com.upuphone.xr.sapp.common.R.drawable.card_item_top_round_selector);
        }
        TiciScreenLocationView ticiScreenLocationView3 = N0().i;
        Intrinsics.checkNotNullExpressionValue(ticiScreenLocationView3, "ticiScreenLocationView");
        if (ticiScreenLocationView3.getVisibility() != 0) {
            TiciSettingCardItem ticiSettingCardItem3 = N0().c;
            Intrinsics.checkNotNullExpressionValue(ticiSettingCardItem3, "layNotificationSetting");
            if (ticiSettingCardItem3.getVisibility() != 0) {
                TiciSettingCardItem ticiSettingCardItem4 = N0().b;
                Intrinsics.checkNotNullExpressionValue(ticiSettingCardItem4, "layDoNotDisturbSetting");
                if (ticiSettingCardItem4.getVisibility() != 0) {
                    N0().d.setBackgroundResource(com.upuphone.xr.sapp.common.R.drawable.card_item_full_round_selector);
                    return;
                }
            }
        }
        N0().d.setBackgroundResource(com.upuphone.xr.sapp.common.R.drawable.card_item_bottom_round_selector);
    }

    public final void i1(int i, long j) {
        boolean b2 = SpUtilKt.b();
        int h = SpUtilKt.h();
        CommonExtKt.e("syncTiciSettingToGlass, ticiMode: " + i + ", ticiSpeed: " + j + ", blockNotification: " + b2 + ", screenLocation: " + h, "TiciSettingActivity");
        TiciApp ticiApp = TiciApp.b;
        ticiApp.q().sendChangeTiciMode(new ChangeTiciModeMsg(i, j, Boolean.valueOf(b2), Integer.valueOf(h)));
        ticiApp.c().S0(true);
    }

    public final String k1(long j) {
        String string = getString(R.string.tici_speed_desc_param, new Object[]{String.valueOf(MathKt.roundToInt(((double) 4200) / (((double) j) / ((double) 1000))))});
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) N0().getRoot());
        initView();
        initViewModel();
        TiciApp ticiApp = TiciApp.b;
        ticiApp.c().S0(false);
        ticiApp.q().sendAutoTiciState(false);
        g1();
    }
}
