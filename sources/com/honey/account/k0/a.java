package com.honey.account.k0;

import androidx.work.impl.StartStopToken;
import androidx.work.impl.background.greedy.TimeLimiter;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TimeLimiter f3066a;
    public final /* synthetic */ StartStopToken b;

    public /* synthetic */ a(TimeLimiter timeLimiter, StartStopToken startStopToken) {
        this.f3066a = timeLimiter;
        this.b = startStopToken;
    }

    public final void run() {
        TimeLimiter.d(this.f3066a, this.b);
    }
}
