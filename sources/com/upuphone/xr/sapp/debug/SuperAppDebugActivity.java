package com.upuphone.xr.sapp.debug;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.honey.account.f8.a;
import com.honey.account.f8.b;
import com.honey.account.f8.c;
import com.honey.account.f8.d;
import com.honey.account.f8.e;
import com.honey.account.f8.f;
import com.honey.account.f8.g;
import com.honey.account.f8.h;
import com.honey.account.f8.i;
import com.upuphone.star.common.phone.UBaseActivity;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.FeedbackActivity;
import com.upuphone.xr.sapp.config.NetConfig;
import com.upuphone.xr.sapp.databinding.ActivityDebugInfoBinding;
import com.upuphone.xr.sapp.glass.GlassLogUpdateHelper;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.DynamicOperateUtil;
import com.upuphone.xr.sapp.vm.internal.SuperMessageManger;
import com.xjmz.myvu.account.DebugLoginActivity;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001 \u0018\u0000 $2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0010\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\tJ\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/upuphone/xr/sapp/debug/SuperAppDebugActivity;", "Lcom/upuphone/star/common/phone/UBaseActivity;", "<init>", "()V", "", "initView", "", "log", "S0", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "", "isOpen", "T0", "(Ljava/lang/Boolean;)V", "text", "W0", "H0", "V0", "J0", "()Ljava/lang/String;", "Lcom/upuphone/xr/sapp/databinding/ActivityDebugInfoBinding;", "a", "Lcom/upuphone/xr/sapp/databinding/ActivityDebugInfoBinding;", "binding", "Landroid/os/Handler;", "b", "Landroid/os/Handler;", "mHandler", "com/upuphone/xr/sapp/debug/SuperAppDebugActivity$shareListener$1", "c", "Lcom/upuphone/xr/sapp/debug/SuperAppDebugActivity$shareListener$1;", "shareListener", "d", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class SuperAppDebugActivity extends UBaseActivity {
    public static final Companion d = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public ActivityDebugInfoBinding f6930a;
    public final Handler b = new Handler();
    public final SuperAppDebugActivity$shareListener$1 c = new SuperAppDebugActivity$shareListener$1(this);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/xr/sapp/debug/SuperAppDebugActivity$Companion;", "", "()V", "KEY_OPEN_FORCE_MULTI_DEVICE", "", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static final void I0(SuperAppDebugActivity superAppDebugActivity) {
        Intrinsics.checkNotNullParameter(superAppDebugActivity, "this$0");
        superAppDebugActivity.c.onError((String) null, 998);
    }

    public static final void K0(SuperAppDebugActivity superAppDebugActivity, View view) {
        Intrinsics.checkNotNullParameter(superAppDebugActivity, "this$0");
        superAppDebugActivity.finish();
    }

    public static final void L0(SuperAppDebugActivity superAppDebugActivity, View view) {
        Intrinsics.checkNotNullParameter(superAppDebugActivity, "this$0");
        superAppDebugActivity.finish();
    }

    public static final void M0(SuperAppDebugActivity superAppDebugActivity, View view) {
        Intrinsics.checkNotNullParameter(superAppDebugActivity, "this$0");
        superAppDebugActivity.startActivity(new Intent(superAppDebugActivity, FeedbackActivity.class));
    }

    public static final void N0(SuperAppDebugActivity superAppDebugActivity, View view) {
        Intrinsics.checkNotNullParameter(superAppDebugActivity, "this$0");
        ActivityDebugInfoBinding activityDebugInfoBinding = superAppDebugActivity.f6930a;
        ActivityDebugInfoBinding activityDebugInfoBinding2 = null;
        if (activityDebugInfoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDebugInfoBinding = null;
        }
        activityDebugInfoBinding.e.b.setEnabled(false);
        ActivityDebugInfoBinding activityDebugInfoBinding3 = superAppDebugActivity.f6930a;
        if (activityDebugInfoBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityDebugInfoBinding2 = activityDebugInfoBinding3;
        }
        activityDebugInfoBinding2.e.b.setText("Processing");
        superAppDebugActivity.W0("Start dump");
        superAppDebugActivity.H0();
    }

    public static final void O0(SuperAppDebugActivity superAppDebugActivity, View view) {
        Intrinsics.checkNotNullParameter(superAppDebugActivity, "this$0");
        DataStoreUtils.Companion companion = DataStoreUtils.e;
        boolean booleanValue = ((Boolean) DataStoreUtils.i(companion.a(), "KEY_OPEN_FORCE_MULTI_DEVICE", Boolean.FALSE, (Context) null, 4, (Object) null)).booleanValue();
        companion.a().o("KEY_OPEN_FORCE_MULTI_DEVICE", Boolean.valueOf(!booleanValue));
        superAppDebugActivity.T0(Boolean.valueOf(!booleanValue));
    }

    public static final void P0(SuperAppDebugActivity superAppDebugActivity, View view) {
        Intrinsics.checkNotNullParameter(superAppDebugActivity, "this$0");
        ULog.Delegate delegate = ULog.f6446a;
        String absolutePath = superAppDebugActivity.getFilesDir().getAbsolutePath();
        delegate.a("SuperAppDebugActivity", "loadSoBtn-> " + absolutePath);
        String absolutePath2 = superAppDebugActivity.getFilesDir().getAbsolutePath();
        System.load(absolutePath2 + "/libneonui_shared.so");
        String absolutePath3 = superAppDebugActivity.getFilesDir().getAbsolutePath();
        System.load(absolutePath3 + "/libneonuijni_public.so");
        String absolutePath4 = superAppDebugActivity.getFilesDir().getAbsolutePath();
        System.load(absolutePath4 + "/libAMapSDK_NAVI_v9_8_2.so");
    }

    public static final void Q0(SuperAppDebugActivity superAppDebugActivity, View view) {
        Intrinsics.checkNotNullParameter(superAppDebugActivity, "this$0");
        DebugLoginActivity.c.a(superAppDebugActivity);
    }

    public static final void R0(View view) {
    }

    /* access modifiers changed from: private */
    public final void S0(String str) {
        ULog.f6446a.a("SuperAppDebugActivity", str);
    }

    public static /* synthetic */ void U0(SuperAppDebugActivity superAppDebugActivity, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = null;
        }
        superAppDebugActivity.T0(bool);
    }

    private final void initView() {
        ActivityDebugInfoBinding activityDebugInfoBinding = this.f6930a;
        if (activityDebugInfoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDebugInfoBinding = null;
        }
        activityDebugInfoBinding.m.setText(J0());
        ActivityDebugInfoBinding activityDebugInfoBinding2 = this.f6930a;
        if (activityDebugInfoBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDebugInfoBinding2 = null;
        }
        activityDebugInfoBinding2.b.setOnClickListener(new a(this));
        ActivityDebugInfoBinding activityDebugInfoBinding3 = this.f6930a;
        if (activityDebugInfoBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDebugInfoBinding3 = null;
        }
        activityDebugInfoBinding3.n.setOnClickListener(new b(this));
        ActivityDebugInfoBinding activityDebugInfoBinding4 = this.f6930a;
        if (activityDebugInfoBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDebugInfoBinding4 = null;
        }
        Spinner spinner = activityDebugInfoBinding4.j;
        String[] strArr = {"china_prod", "china_uat", "intl_prod", "intl_uat"};
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, 17367048, strArr);
        arrayAdapter.setDropDownViewResource(17367049);
        spinner.setAdapter(arrayAdapter);
        int indexOf = ArraysKt.indexOf((T[]) strArr, NetConfig.f6666a.j());
        if (indexOf < 0) {
            indexOf = 0;
        }
        spinner.setSelection(indexOf);
        spinner.setOnItemSelectedListener(new SuperAppDebugActivity$initView$3$1(strArr, this));
        ActivityDebugInfoBinding activityDebugInfoBinding5 = this.f6930a;
        if (activityDebugInfoBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDebugInfoBinding5 = null;
        }
        activityDebugInfoBinding5.c.setOnClickListener(new c(this));
        ActivityDebugInfoBinding activityDebugInfoBinding6 = this.f6930a;
        if (activityDebugInfoBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDebugInfoBinding6 = null;
        }
        activityDebugInfoBinding6.e.b.setOnClickListener(new d(this));
        ActivityDebugInfoBinding activityDebugInfoBinding7 = this.f6930a;
        if (activityDebugInfoBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDebugInfoBinding7 = null;
        }
        activityDebugInfoBinding7.f.b.setOnClickListener(new e(this));
        ActivityDebugInfoBinding activityDebugInfoBinding8 = this.f6930a;
        if (activityDebugInfoBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDebugInfoBinding8 = null;
        }
        activityDebugInfoBinding8.i.setOnClickListener(new f(this));
        ActivityDebugInfoBinding activityDebugInfoBinding9 = this.f6930a;
        if (activityDebugInfoBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDebugInfoBinding9 = null;
        }
        activityDebugInfoBinding9.k.setOnClickListener(new g(this));
        ActivityDebugInfoBinding activityDebugInfoBinding10 = this.f6930a;
        if (activityDebugInfoBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityDebugInfoBinding10 = null;
        }
        activityDebugInfoBinding10.l.setOnClickListener(new h());
        U0(this, (Boolean) null, 1, (Object) null);
    }

    public final void H0() {
        if (DynamicOperateUtil.f7880a.h() >= 3) {
            GlassLogUpdateHelper.e.a().d(this.c);
            SuperMessageManger.m.a().p("/data/data/com.upuphone.star.launcher.intl/files/ulog/");
            this.b.removeCallbacksAndMessages((Object) null);
            this.b.postDelayed(new i(this), 10000);
            return;
        }
        S0("requestGlassLog::glass version low can not support");
        V0();
    }

    public final String J0() {
        return "互联互通SDK版本（内置）： 2.8.44 \n互联互通SDK版本（国内三方）：2.8.44 \n互联互通SDK版本（海外）：2.8.44 \n构建版本信息：branch=STARV_MP7_INTL_20250423，hash=32026939b，构建时间=20250423_2049 \n";
    }

    public final void T0(Boolean bool) {
        ActivityDebugInfoBinding activityDebugInfoBinding = null;
        if (bool == null) {
            boolean booleanValue = ((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), "KEY_OPEN_FORCE_MULTI_DEVICE", Boolean.FALSE, (Context) null, 4, (Object) null)).booleanValue();
            ActivityDebugInfoBinding activityDebugInfoBinding2 = this.f6930a;
            if (activityDebugInfoBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityDebugInfoBinding = activityDebugInfoBinding2;
            }
            TextView textView = activityDebugInfoBinding.f.d;
            textView.setText("是否打开: " + booleanValue);
            return;
        }
        ActivityDebugInfoBinding activityDebugInfoBinding3 = this.f6930a;
        if (activityDebugInfoBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityDebugInfoBinding = activityDebugInfoBinding3;
        }
        TextView textView2 = activityDebugInfoBinding.f.d;
        textView2.setText("是否打开: " + bool);
    }

    public final void V0() {
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new SuperAppDebugActivity$startDump$1(this, (Continuation<? super SuperAppDebugActivity$startDump$1>) null), 3, (Object) null);
    }

    public final void W0(String str) {
        Toast.makeText(this, str, 0).show();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityDebugInfoBinding c2 = ActivityDebugInfoBinding.c(LayoutInflater.from(this));
        Intrinsics.checkNotNull(c2);
        this.f6930a = c2;
        setContentView((View) c2.getRoot());
        initView();
    }
}
