package com.xjmz.myvu.account;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.honey.account.o9.c;
import com.honey.account.o9.d;
import com.honey.account.o9.e;
import com.honey.account.o9.f;
import com.honey.account.o9.g;
import com.honey.account.o9.h;
import com.honey.account.o9.i;
import com.honey.account.o9.j;
import com.honey.account.o9.k;
import com.upuphone.xr.sapp.common.MzAccountManager;
import com.upuphone.xr.sapp.contract.AssistantUserGuideDialogController;
import com.upuphone.xr.sapp.databinding.DebugLoginActivityBinding;
import com.upuphone.xr.sapp.entity.AccountInfo;
import com.upuphone.xr.sapp.utils.DynamicAdapterUtils;
import com.upuphone.xr.sapp.utils.HttpRequestUtil;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0015¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000f8FX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/xjmz/myvu/account/DebugLoginActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Lcom/upuphone/xr/sapp/databinding/DebugLoginActivityBinding;", "a", "Lkotlin/Lazy;", "C0", "()Lcom/upuphone/xr/sapp/databinding/DebugLoginActivityBinding;", "binding", "Lcom/upuphone/star/httplib/HttpInstance;", "b", "getHttp", "()Lcom/upuphone/star/httplib/HttpInstance;", "http", "c", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class DebugLoginActivity extends AppCompatActivity {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Lazy f8220a = LazyKt.lazy(new DebugLoginActivity$binding$2(this));
    public final Lazy b = LazyKt.lazy(DebugLoginActivity$http$2.INSTANCE);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/xjmz/myvu/account/DebugLoginActivity$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "a", "(Landroid/content/Context;)V", "", "TAG", "Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, DebugLoginActivity.class));
        }

        public Companion() {
        }
    }

    public static final void D0(DebugLoginActivity debugLoginActivity, View view) {
        Intrinsics.checkNotNullParameter(debugLoginActivity, "this$0");
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(debugLoginActivity), Dispatchers.b(), (CoroutineStart) null, new DebugLoginActivity$onCreate$1$1(debugLoginActivity, (Continuation<? super DebugLoginActivity$onCreate$1$1>) null), 2, (Object) null);
    }

    public static final void E0(DebugLoginActivity debugLoginActivity, View view) {
        Intrinsics.checkNotNullParameter(debugLoginActivity, "this$0");
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(debugLoginActivity), Dispatchers.b(), (CoroutineStart) null, new DebugLoginActivity$onCreate$2$1(debugLoginActivity, (Continuation<? super DebugLoginActivity$onCreate$2$1>) null), 2, (Object) null);
    }

    public static final void F0(DebugLoginActivity debugLoginActivity, View view) {
        Intrinsics.checkNotNullParameter(debugLoginActivity, "this$0");
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(debugLoginActivity), Dispatchers.b(), (CoroutineStart) null, new DebugLoginActivity$onCreate$3$1((Continuation<? super DebugLoginActivity$onCreate$3$1>) null), 2, (Object) null);
    }

    public static final void G0(DebugLoginActivity debugLoginActivity, View view) {
        Intrinsics.checkNotNullParameter(debugLoginActivity, "this$0");
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(debugLoginActivity), (CoroutineContext) null, (CoroutineStart) null, new DebugLoginActivity$onCreate$4$1((Continuation<? super DebugLoginActivity$onCreate$4$1>) null), 3, (Object) null);
    }

    public static final void H0(View view) {
        AccountInfo a2 = MzAccountManager.c.a();
        String a3 = DynamicAdapterUtils.f7879a.a();
        HttpRequestUtil httpRequestUtil = HttpRequestUtil.f7890a;
        Intrinsics.checkNotNull(a2);
        httpRequestUtil.s("myvu_pp", a2.getId(), a3, (String) null, new DebugLoginActivity$onCreate$5$1());
    }

    public static final void I0(DebugLoginActivity debugLoginActivity, View view) {
        Intrinsics.checkNotNullParameter(debugLoginActivity, "this$0");
        AccountInfo a2 = MzAccountManager.c.a();
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(debugLoginActivity), Dispatchers.b(), (CoroutineStart) null, new DebugLoginActivity$onCreate$6$1(a2 != null ? a2.getId() : null, (Continuation<? super DebugLoginActivity$onCreate$6$1>) null), 2, (Object) null);
    }

    public static final void J0(DebugLoginActivity debugLoginActivity, View view) {
        Intrinsics.checkNotNullParameter(debugLoginActivity, "this$0");
        new AssistantUserGuideDialogController(debugLoginActivity).l(1);
    }

    public static final void K0(DebugLoginActivity debugLoginActivity, View view) {
        Intrinsics.checkNotNullParameter(debugLoginActivity, "this$0");
        new AssistantUserGuideDialogController(debugLoginActivity).l(2);
    }

    public static final void L0(View view) {
        HttpRequestUtil.f7890a.k();
    }

    public final DebugLoginActivityBinding C0() {
        return (DebugLoginActivityBinding) this.f8220a.getValue();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) C0().getRoot());
        C0().f.setOnClickListener(new c(this));
        C0().g.setOnClickListener(new d(this));
        C0().c.setOnClickListener(new e(this));
        C0().e.setOnClickListener(new f(this));
        C0().j.setOnClickListener(new g());
        C0().k.setOnClickListener(new h(this));
        C0().b.setOnClickListener(new i(this));
        C0().d.setOnClickListener(new j(this));
        C0().i.setOnClickListener(new k());
    }
}
