package com.honey.account.r1;

import android.view.View;
import com.google.android.material.snackbar.Snackbar;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Snackbar f9799a;
    public final /* synthetic */ View.OnClickListener b;

    public /* synthetic */ a(Snackbar snackbar, View.OnClickListener onClickListener) {
        this.f9799a = snackbar;
        this.b = onClickListener;
    }

    public final void onClick(View view) {
        this.f9799a.lambda$setAction$0(this.b, view);
    }
}
