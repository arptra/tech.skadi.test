package androidx.browser.customtabs;

import android.os.Bundle;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EngagementSignalsCallback f428a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Bundle c;

    public /* synthetic */ b(EngagementSignalsCallback engagementSignalsCallback, boolean z, Bundle bundle) {
        this.f428a = engagementSignalsCallback;
        this.b = z;
        this.c = bundle;
    }

    public final void run() {
        this.f428a.onSessionEnded(this.b, this.c);
    }
}
