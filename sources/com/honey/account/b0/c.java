package com.honey.account.b0;

import androidx.profileinstaller.ProfileInstaller;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProfileInstaller.DiagnosticsCallback f3007a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ c(ProfileInstaller.DiagnosticsCallback diagnosticsCallback, int i, Object obj) {
        this.f3007a = diagnosticsCallback;
        this.b = i;
        this.c = obj;
    }

    public final void run() {
        this.f3007a.a(this.b, this.c);
    }
}
