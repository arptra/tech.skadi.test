package com.google.android.material.datepicker;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DateFormatTextWatcher f9670a;
    public final /* synthetic */ long b;

    public /* synthetic */ b(DateFormatTextWatcher dateFormatTextWatcher, long j) {
        this.f9670a = dateFormatTextWatcher;
        this.b = j;
    }

    public final void run() {
        this.f9670a.lambda$createRangeErrorCallback$1(this.b);
    }
}
