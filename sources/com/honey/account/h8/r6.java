package com.honey.account.h8;

import com.upuphone.xr.sapp.entity.AccountInfo;
import com.upuphone.xr.sapp.fragment.MineFragment;

public final /* synthetic */ class r6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MineFragment f4744a;
    public final /* synthetic */ AccountInfo b;

    public /* synthetic */ r6(MineFragment mineFragment, AccountInfo accountInfo) {
        this.f4744a = mineFragment;
        this.b = accountInfo;
    }

    public final void run() {
        MineFragment.d1(this.f4744a, this.b);
    }
}
