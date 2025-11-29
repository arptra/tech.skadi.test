package com.honey.account.s4;

import android.widget.ScrollView;
import android.widget.TextView;
import com.upuphone.ar.tici.phone.utils.ParagraphHelper;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ScrollView f5122a;
    public final /* synthetic */ TextView b;
    public final /* synthetic */ int c;

    public /* synthetic */ c(ScrollView scrollView, TextView textView, int i) {
        this.f5122a = scrollView;
        this.b = textView;
        this.c = i;
    }

    public final void run() {
        ParagraphHelper.Companion.h(this.f5122a, this.b, this.c);
    }
}
