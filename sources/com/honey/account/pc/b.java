package com.honey.account.pc;

import org.libpag.PAGFile;
import org.libpag.PAGImageView;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PAGImageView f3227a;
    public final /* synthetic */ String b;
    public final /* synthetic */ float c;
    public final /* synthetic */ PAGFile.LoadListener d;

    public /* synthetic */ b(PAGImageView pAGImageView, String str, float f, PAGFile.LoadListener loadListener) {
        this.f3227a = pAGImageView;
        this.b = str;
        this.c = f;
        this.d = loadListener;
    }

    public final void run() {
        this.f3227a.a(this.b, this.c, this.d);
    }
}
