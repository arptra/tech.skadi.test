package com.honey.account.k2;

import android.view.View;
import com.honey.account.view.PersonalInfoActivity;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PersonalInfoActivity f9208a;

    public /* synthetic */ a(PersonalInfoActivity personalInfoActivity) {
        this.f9208a = personalInfoActivity;
    }

    public final void onClick(View view) {
        PersonalInfoActivity.showUpdateNickNameDialog$lambda$1(this.f9208a, view);
    }
}
