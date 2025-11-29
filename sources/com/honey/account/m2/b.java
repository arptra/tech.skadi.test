package com.honey.account.m2;

import android.view.View;
import com.honey.account.view.login.base.LoginActivity;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LoginActivity f9212a;

    public /* synthetic */ b(LoginActivity loginActivity) {
        this.f9212a = loginActivity;
    }

    public final void onClick(View view) {
        LoginActivity.showAgreementDialog$lambda$4(this.f9212a, view);
    }
}
