package com.honey.account.ua;

import flyme.support.v7.app.palette.ColorManager;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7625a;

    public /* synthetic */ c(int i) {
        this.f7625a = i;
    }

    public final void run() {
        ColorManager.getInstance().setCurrentColor(this.f7625a);
    }
}
