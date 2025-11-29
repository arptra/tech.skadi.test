package com.honey.account.ac;

import org.apache.commons.lang3.concurrent.TimedSemaphore;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TimedSemaphore f7120a;

    public /* synthetic */ b(TimedSemaphore timedSemaphore) {
        this.f7120a = timedSemaphore;
    }

    public final void run() {
        this.f7120a.endOfPeriod();
    }
}
