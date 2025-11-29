package com.honey.account.h8;

import com.upuphone.xr.sapp.entity.AccountInfo;
import com.upuphone.xr.sapp.fragment.MineFragment;

public final /* synthetic */ class o6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AccountInfo f4709a;
    public final /* synthetic */ MineFragment b;

    public /* synthetic */ o6(AccountInfo accountInfo, MineFragment mineFragment) {
        this.f4709a = accountInfo;
        this.b = mineFragment;
    }

    public final void run() {
        MineFragment.c1(this.f4709a, this.b);
    }
}
