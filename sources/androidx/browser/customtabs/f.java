package androidx.browser.customtabs;

import android.os.Bundle;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EngagementSignalsCallback f432a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Bundle c;

    public /* synthetic */ f(EngagementSignalsCallback engagementSignalsCallback, int i, Bundle bundle) {
        this.f432a = engagementSignalsCallback;
        this.b = i;
        this.c = bundle;
    }

    public final void run() {
        this.f432a.onGreatestScrollPercentageIncreased(this.b, this.c);
    }
}
