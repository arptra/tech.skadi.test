package com.honey.account.h8;

import com.upuphone.xr.sapp.entity.AccountInfo;
import com.upuphone.xr.sapp.fragment.AccountFragment;

public final /* synthetic */ class f0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AccountFragment f4591a;
    public final /* synthetic */ AccountInfo b;

    public /* synthetic */ f0(AccountFragment accountFragment, AccountInfo accountInfo) {
        this.f4591a = accountFragment;
        this.b = accountInfo;
    }

    public final void run() {
        AccountFragment.d1(this.f4591a, this.b);
    }
}
