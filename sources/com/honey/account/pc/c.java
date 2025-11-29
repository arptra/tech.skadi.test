package com.honey.account.pc;

import org.libpag.PAGFile;
import org.libpag.PAGView;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PAGView f3228a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PAGFile.LoadListener c;

    public /* synthetic */ c(PAGView pAGView, String str, PAGFile.LoadListener loadListener) {
        this.f3228a = pAGView;
        this.b = str;
        this.c = loadListener;
    }

    public final void run() {
        this.f3228a.a(this.b, this.c);
    }
}
