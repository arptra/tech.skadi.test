package com.upuphone.xr.sapp.guide.connectui;

import com.upuphone.xr.sapp.guide.model.ConnectResult;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AddGlassFragment f7094a;
    public final /* synthetic */ ConnectResult b;

    public /* synthetic */ a(AddGlassFragment addGlassFragment, ConnectResult connectResult) {
        this.f7094a = addGlassFragment;
        this.b = connectResult;
    }

    public final void run() {
        AddGlassFragment$searchGlass$2.invoke$lambda$1$lambda$0(this.f7094a, this.b);
    }
}
