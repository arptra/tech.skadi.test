package com.xjmz.myvu.dialog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.honey.account.p9.a;
import com.honey.account.p9.b;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentLoginBinding;
import com.upuphone.xr.sapp.utils.NetworkUtils;
import com.xjmz.myvu.account.AccountManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/xjmz/myvu/dialog/LoginFragmentDialog;", "Lcom/xjmz/myvu/dialog/GlobalDialogFragment;", "Landroid/view/View;", "dialogView", "<init>", "(Landroid/view/View;)V", "", "initView", "()V", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Lcom/upuphone/xr/sapp/databinding/FragmentLoginBinding;", "c", "Lcom/upuphone/xr/sapp/databinding/FragmentLoginBinding;", "binding", "d", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class LoginFragmentDialog extends GlobalDialogFragment {
    public static final Companion d = new Companion((DefaultConstructorMarker) null);
    public FragmentLoginBinding c;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/xjmz/myvu/dialog/LoginFragmentDialog$Companion;", "", "<init>", "()V", "Landroidx/fragment/app/FragmentActivity;", "rootActivity", "", "a", "(Landroidx/fragment/app/FragmentActivity;)V", "", "TAG", "Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(FragmentActivity fragmentActivity) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "rootActivity");
            if (!AccountManager.f8217a.r()) {
                View inflate = fragmentActivity.getLayoutInflater().inflate(R.layout.fragment_login, (ViewGroup) null, false);
                Intrinsics.checkNotNull(inflate);
                new LoginFragmentDialog(inflate).show(fragmentActivity.getSupportFragmentManager(), (String) null);
                return;
            }
            ULog.f6446a.g("LoginFragmentDialog", "show() current is in login process!");
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoginFragmentDialog(View view) {
        super(view, false, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(view, "dialogView");
        FragmentLoginBinding a2 = FragmentLoginBinding.a(view);
        Intrinsics.checkNotNullExpressionValue(a2, "bind(...)");
        this.c = a2;
    }

    private final void initView() {
        this.c.c.setOnClickListener(new a(this));
        this.c.d.setOnClickListener(new b(this));
    }

    public static final void l0(LoginFragmentDialog loginFragmentDialog, View view) {
        Intrinsics.checkNotNullParameter(loginFragmentDialog, "this$0");
        loginFragmentDialog.dismiss();
    }

    public static final void m0(LoginFragmentDialog loginFragmentDialog, View view) {
        Intrinsics.checkNotNullParameter(loginFragmentDialog, "this$0");
        if (NetworkUtils.f7898a.g()) {
            Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(loginFragmentDialog), (CoroutineContext) null, (CoroutineStart) null, new LoginFragmentDialog$initView$2$1(loginFragmentDialog, (Continuation<? super LoginFragmentDialog$initView$2$1>) null), 3, (Object) null);
            return;
        }
        UToast.Companion companion = UToast.f6444a;
        Context requireContext = loginFragmentDialog.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        String string = loginFragmentDialog.getString(R.string.http_req_no_network);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.d(requireContext, string);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("LoginFragmentDialog", "onActivityResult() : requestCode = " + i + ", resultCode = " + i2 + ", data = " + intent);
        if (i == 10000 || i == 10001) {
            AccountManager.f8217a.q(i2);
            dismiss();
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView();
    }
}
