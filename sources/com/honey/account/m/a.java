package com.honey.account.m;

import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ResourcesCompat.FontCallback f3069a;
    public final /* synthetic */ Typeface b;

    public /* synthetic */ a(ResourcesCompat.FontCallback fontCallback, Typeface typeface) {
        this.f3069a = fontCallback;
        this.b = typeface;
    }

    public final void run() {
        this.f3069a.d(this.b);
    }
}
