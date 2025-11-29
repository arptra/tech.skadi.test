package com.honey.account.b0;

import android.content.Context;
import androidx.profileinstaller.ProfileInstaller;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f3010a;

    public /* synthetic */ f(Context context) {
        this.f3010a = context;
    }

    public final void run() {
        ProfileInstaller.i(this.f3010a);
    }
}
