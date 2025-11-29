package com.honey.account.h8;

import android.view.View;
import com.upuphone.xr.sapp.fragment.MiniDesktopFragment;

public final /* synthetic */ class d7 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MiniDesktopFragment f4573a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;

    public /* synthetic */ d7(MiniDesktopFragment miniDesktopFragment, String str, int i) {
        this.f4573a = miniDesktopFragment;
        this.b = str;
        this.c = i;
    }

    public final void onClick(View view) {
        MiniDesktopFragment.H0(this.f4573a, this.b, this.c, view);
    }
}
