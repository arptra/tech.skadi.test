package com.honey.account.pc;

import org.libpag.PAGFile;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f3226a;
    public final /* synthetic */ PAGFile.LoadListener b;

    public /* synthetic */ a(String str, PAGFile.LoadListener loadListener) {
        this.f3226a = str;
        this.b = loadListener;
    }

    public final void run() {
        PAGFile.a(this.f3226a, this.b);
    }
}
