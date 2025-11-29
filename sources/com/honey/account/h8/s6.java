package com.honey.account.h8;

import android.graphics.drawable.Drawable;
import com.upuphone.xr.sapp.fragment.MineFragment;

public final /* synthetic */ class s6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MineFragment f4755a;
    public final /* synthetic */ Drawable b;

    public /* synthetic */ s6(MineFragment mineFragment, Drawable drawable) {
        this.f4755a = mineFragment;
        this.b = drawable;
    }

    public final void run() {
        MineFragment.e1(this.f4755a, this.b);
    }
}
