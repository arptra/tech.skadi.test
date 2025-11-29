package androidx.browser.customtabs;

import android.os.Bundle;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EngagementSignalsCallback f433a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Bundle c;

    public /* synthetic */ g(EngagementSignalsCallback engagementSignalsCallback, boolean z, Bundle bundle) {
        this.f433a = engagementSignalsCallback;
        this.b = z;
        this.c = bundle;
    }

    public final void run() {
        this.f433a.onSessionEnded(this.b, this.c);
    }
}
