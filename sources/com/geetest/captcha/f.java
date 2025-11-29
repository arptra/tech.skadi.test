package com.geetest.captcha;

import android.content.Context;

public final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g f2853a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ v c;
    public final /* synthetic */ z d;

    public f(g gVar, Context context, v vVar, z zVar) {
        this.f2853a = gVar;
        this.b = context;
        this.c = vVar;
        this.d = zVar;
    }

    public final void run() {
        try {
            this.f2853a.b(this.b, this.c, this.d);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
