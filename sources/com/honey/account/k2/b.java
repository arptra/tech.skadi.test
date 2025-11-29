package com.honey.account.k2;

import android.view.View;
import com.honey.account.view.PersonalInfoActivity;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PersonalInfoActivity f9209a;

    public /* synthetic */ b(PersonalInfoActivity personalInfoActivity) {
        this.f9209a = personalInfoActivity;
    }

    public final void onClick(View view) {
        PersonalInfoActivity.showUpdateNickNameDialog$lambda$2(this.f9209a, view);
    }
}
