package com.upuphone.ar.tici.phone;

import com.upuphone.ar.tici.phone.data.TiciInfo;
import com.upuphone.ar.tici.phone.starrynet.msg.ParagraphItem;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TiciMainActivity f5911a;
    public final /* synthetic */ TiciInfo b;
    public final /* synthetic */ ParagraphItem c;

    public /* synthetic */ b(TiciMainActivity ticiMainActivity, TiciInfo ticiInfo, ParagraphItem paragraphItem) {
        this.f5911a = ticiMainActivity;
        this.b = ticiInfo;
        this.c = paragraphItem;
    }

    public final void run() {
        TiciMainActivity$initViewModels$2.invoke$lambda$3(this.f5911a, this.b, this.c);
    }
}
