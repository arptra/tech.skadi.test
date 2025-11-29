package com.honey.account.n;

import android.location.Location;
import java.util.function.Consumer;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ androidx.core.util.Consumer f3071a;

    public /* synthetic */ a(androidx.core.util.Consumer consumer) {
        this.f3071a = consumer;
    }

    public final void accept(Object obj) {
        this.f3071a.accept((Location) obj);
    }
}
