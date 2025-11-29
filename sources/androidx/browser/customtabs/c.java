package androidx.browser.customtabs;

import android.os.Bundle;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EngagementSignalsCallback f429a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Bundle c;

    public /* synthetic */ c(EngagementSignalsCallback engagementSignalsCallback, int i, Bundle bundle) {
        this.f429a = engagementSignalsCallback;
        this.b = i;
        this.c = bundle;
    }

    public final void run() {
        this.f429a.onGreatestScrollPercentageIncreased(this.b, this.c);
    }
}
