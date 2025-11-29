package com.honey.account.b0;

import android.content.Context;
import androidx.profileinstaller.ProfileInstallerInitializer;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProfileInstallerInitializer f3008a;
    public final /* synthetic */ Context b;

    public /* synthetic */ d(ProfileInstallerInitializer profileInstallerInitializer, Context context) {
        this.f3008a = profileInstallerInitializer;
        this.b = context;
    }

    public final void run() {
        this.f3008a.h(this.b);
    }
}
