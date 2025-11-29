package com.honey.account.m2;

import android.view.View;
import com.honey.account.view.login.base.LoginActivity;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LoginActivity f9213a;
    public final /* synthetic */ Function0 b;

    public /* synthetic */ c(LoginActivity loginActivity, Function0 function0) {
        this.f9213a = loginActivity;
        this.b = function0;
    }

    public final void onClick(View view) {
        LoginActivity.showAgreementDialog$lambda$5(this.f9213a, this.b, view);
    }
}
