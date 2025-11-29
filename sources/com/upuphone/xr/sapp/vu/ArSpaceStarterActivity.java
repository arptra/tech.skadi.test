package com.upuphone.xr.sapp.vu;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.honey.account.b9.a;
import com.honey.account.b9.b;
import com.honey.account.b9.c;
import com.honey.account.b9.d;
import com.honey.account.b9.e;
import com.honey.account.b9.f;
import com.honey.account.b9.g;
import com.honey.account.b9.h;
import com.honey.account.b9.i;
import com.honey.account.b9.j;
import com.honey.account.b9.k;
import com.honey.account.b9.l;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.vu.arspace.ArSpaceBridger;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0003R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/upuphone/xr/sapp/vu/ArSpaceStarterActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "H0", "L0", "Q0", "V0", "", "file", "Z0", "(Ljava/lang/String;)V", "S0", "F0", "X0", "T0", "Lcom/upuphone/xr/sapp/vu/arspace/ArSpaceBridger;", "a", "Lcom/upuphone/xr/sapp/vu/arspace/ArSpaceBridger;", "arSpaceBridger", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ArSpaceStarterActivity extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    public ArSpaceBridger f8019a;

    public static final void G0(ArSpaceStarterActivity arSpaceStarterActivity, View view) {
        Intrinsics.checkNotNullParameter(arSpaceStarterActivity, "this$0");
        ArSpaceBridger arSpaceBridger = arSpaceStarterActivity.f8019a;
        if (arSpaceBridger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("arSpaceBridger");
            arSpaceBridger = null;
        }
        String B = arSpaceBridger.B();
        Log.d("ArSpaceStarterActivity", "language: " + B);
    }

    public static final void I0(int i) {
        Log.d("ArSpaceStarterActivity", "brightness changed: " + i);
    }

    public static final void J0(ArSpaceStarterActivity arSpaceStarterActivity, View view) {
        Intrinsics.checkNotNullParameter(arSpaceStarterActivity, "this$0");
        ArSpaceBridger arSpaceBridger = arSpaceStarterActivity.f8019a;
        if (arSpaceBridger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("arSpaceBridger");
            arSpaceBridger = null;
        }
        int A = arSpaceBridger.A();
        Log.d("ArSpaceStarterActivity", "brightness: " + A);
    }

    public static final void K0(ArSpaceStarterActivity arSpaceStarterActivity, View view) {
        Intrinsics.checkNotNullParameter(arSpaceStarterActivity, "this$0");
        ArSpaceBridger arSpaceBridger = arSpaceStarterActivity.f8019a;
        if (arSpaceBridger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("arSpaceBridger");
            arSpaceBridger = null;
        }
        arSpaceBridger.G(20);
    }

    public static final void M0(ArSpaceStarterActivity arSpaceStarterActivity, View view) {
        Intrinsics.checkNotNullParameter(arSpaceStarterActivity, "this$0");
        ArSpaceBridger arSpaceBridger = arSpaceStarterActivity.f8019a;
        if (arSpaceBridger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("arSpaceBridger");
            arSpaceBridger = null;
        }
        arSpaceBridger.D(new b());
    }

    public static final void N0(int i, String str) {
        Log.d("ArSpaceStarterActivity", "getSportInfo code: " + i + ", data: " + str);
    }

    public static final void O0(ArSpaceStarterActivity arSpaceStarterActivity, View view) {
        Intrinsics.checkNotNullParameter(arSpaceStarterActivity, "this$0");
        ArSpaceBridger arSpaceBridger = arSpaceStarterActivity.f8019a;
        if (arSpaceBridger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("arSpaceBridger");
            arSpaceBridger = null;
        }
        arSpaceBridger.C(new c());
    }

    public static final void P0(int i, String str) {
        Log.d("ArSpaceStarterActivity", "getWeather code: " + i + ", data: " + str);
    }

    public static final void R0(ArSpaceStarterActivity arSpaceStarterActivity, boolean z) {
        Intrinsics.checkNotNullParameter(arSpaceStarterActivity, "this$0");
        Log.d("ArSpaceStarterActivity", "exit ar space");
        arSpaceStarterActivity.finish();
    }

    public static final void U0(ArSpaceStarterActivity arSpaceStarterActivity, View view) {
        Intrinsics.checkNotNullParameter(arSpaceStarterActivity, "this$0");
        Log.d("ArSpaceStarterActivity", "request permission");
        ArSpaceBridger arSpaceBridger = arSpaceStarterActivity.f8019a;
        if (arSpaceBridger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("arSpaceBridger");
            arSpaceBridger = null;
        }
        arSpaceBridger.F("request_tag", "test permission", "test permission detail", new String[]{"android.permission.CAMERA"});
    }

    public static final void W0(ArSpaceStarterActivity arSpaceStarterActivity, View view) {
        Intrinsics.checkNotNullParameter(arSpaceStarterActivity, "this$0");
        ArSpaceBridger arSpaceBridger = arSpaceStarterActivity.f8019a;
        if (arSpaceBridger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("arSpaceBridger");
            arSpaceBridger = null;
        }
        arSpaceBridger.y();
    }

    public static final void Y0(boolean z) {
        Log.d("ArSpaceStarterActivity", "wear state: " + z);
    }

    public final void F0() {
        findViewById(R.id.get_language).setOnClickListener(new h(this));
    }

    public final void H0() {
        ArSpaceBridger arSpaceBridger = this.f8019a;
        if (arSpaceBridger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("arSpaceBridger");
            arSpaceBridger = null;
        }
        arSpaceBridger.I(new a());
        findViewById(R.id.get_brightness).setOnClickListener(new d(this));
        findViewById(R.id.set_brightness).setOnClickListener(new e(this));
    }

    public final void L0() {
        findViewById(R.id.get_weather).setOnClickListener(new k(this));
        findViewById(R.id.get_steps).setOnClickListener(new l(this));
    }

    public final void Q0() {
        ArSpaceBridger arSpaceBridger = this.f8019a;
        if (arSpaceBridger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("arSpaceBridger");
            arSpaceBridger = null;
        }
        arSpaceBridger.L(new i(this));
    }

    public final void S0() {
        ArSpaceBridger arSpaceBridger = this.f8019a;
        ArSpaceBridger arSpaceBridger2 = null;
        if (arSpaceBridger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("arSpaceBridger");
            arSpaceBridger = null;
        }
        arSpaceBridger.H(new ArSpaceStarterActivity$setupKey$1());
        ArSpaceBridger arSpaceBridger3 = this.f8019a;
        if (arSpaceBridger3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("arSpaceBridger");
        } else {
            arSpaceBridger2 = arSpaceBridger3;
        }
        arSpaceBridger2.N(new ArSpaceStarterActivity$setupKey$2());
    }

    public final void T0() {
        ArSpaceBridger arSpaceBridger = this.f8019a;
        if (arSpaceBridger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("arSpaceBridger");
            arSpaceBridger = null;
        }
        arSpaceBridger.M(new ArSpaceStarterActivity$setupPermission$1());
        findViewById(R.id.get_permission).setOnClickListener(new f(this));
    }

    public final void V0() {
        ArSpaceBridger arSpaceBridger = this.f8019a;
        if (arSpaceBridger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("arSpaceBridger");
            arSpaceBridger = null;
        }
        arSpaceBridger.J(new ArSpaceStarterActivity$setupScreenRecord$1(this));
        findViewById(R.id.screenshot).setOnClickListener(new j(this));
    }

    public final void X0() {
        ArSpaceBridger arSpaceBridger = this.f8019a;
        if (arSpaceBridger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("arSpaceBridger");
            arSpaceBridger = null;
        }
        arSpaceBridger.K(new g());
    }

    public final void Z0(String str) {
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new ArSpaceStarterActivity$showScreenCapture$1(this, str, (Continuation<? super ArSpaceStarterActivity$showScreenCapture$1>) null), 3, (Object) null);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_ar_space_starter);
        this.f8019a = new ArSpaceBridger(this, new ArSpaceStarterActivity$onCreate$listener$1());
        H0();
        L0();
        Q0();
        V0();
        S0();
        F0();
        X0();
        T0();
    }

    public void onDestroy() {
        super.onDestroy();
        ArSpaceBridger arSpaceBridger = this.f8019a;
        ArSpaceBridger arSpaceBridger2 = null;
        if (arSpaceBridger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("arSpaceBridger");
            arSpaceBridger = null;
        }
        arSpaceBridger.E();
        ArSpaceBridger arSpaceBridger3 = this.f8019a;
        if (arSpaceBridger3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("arSpaceBridger");
        } else {
            arSpaceBridger2 = arSpaceBridger3;
        }
        arSpaceBridger2.z();
    }
}
