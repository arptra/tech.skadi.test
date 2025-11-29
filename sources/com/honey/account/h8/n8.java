package com.honey.account.h8;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.upuphone.xr.sapp.fragment.PhoneNotifyFragment;

public final /* synthetic */ class n8 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LinearLayoutManager f4699a;
    public final /* synthetic */ PhoneNotifyFragment b;

    public /* synthetic */ n8(LinearLayoutManager linearLayoutManager, PhoneNotifyFragment phoneNotifyFragment) {
        this.f4699a = linearLayoutManager;
        this.b = phoneNotifyFragment;
    }

    public final void run() {
        PhoneNotifyFragment.c1(this.f4699a, this.b);
    }
}
