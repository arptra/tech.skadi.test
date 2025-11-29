package com.honey.account.f1;

import com.google.android.material.carousel.CarouselLayoutManager;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CarouselLayoutManager f9723a;

    public /* synthetic */ a(CarouselLayoutManager carouselLayoutManager) {
        this.f9723a = carouselLayoutManager;
    }

    public final void run() {
        this.f9723a.refreshKeylineState();
    }
}
