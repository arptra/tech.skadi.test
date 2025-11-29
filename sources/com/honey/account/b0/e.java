package com.honey.account.b0;

import android.content.Context;
import androidx.profileinstaller.ProfileInstallerInitializer;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f3009a;

    public /* synthetic */ e(Context context) {
        this.f3009a = context;
    }

    public final void run() {
        ProfileInstallerInitializer.k(this.f3009a);
    }
}
