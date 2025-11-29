package com.honey.account.uc;

import android.view.View;
import sdk.meizu.account.factor.authentication.sdk.data.BasicInfoType;
import sdk.meizu.account.factor.authentication.sdk.fragment.basic.adapter.ValidateListAdapter;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ValidateListAdapter f3232a;
    public final /* synthetic */ int b;
    public final /* synthetic */ BasicInfoType c;

    public /* synthetic */ a(ValidateListAdapter validateListAdapter, int i, BasicInfoType basicInfoType) {
        this.f3232a = validateListAdapter;
        this.b = i;
        this.c = basicInfoType;
    }

    public final void onClick(View view) {
        ValidateListAdapter.onBindViewHolder$lambda$1$lambda$0(this.f3232a, this.b, this.c, view);
    }
}
