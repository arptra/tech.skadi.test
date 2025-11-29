package com.honey.account.s4;

import android.widget.ScrollView;
import com.upuphone.ar.tici.phone.utils.ParagraphHelper;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ScrollView f5123a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    public /* synthetic */ d(ScrollView scrollView, int i, int i2) {
        this.f5123a = scrollView;
        this.b = i;
        this.c = i2;
    }

    public final void run() {
        ParagraphHelper.Companion.i(this.f5123a, this.b, this.c);
    }
}
