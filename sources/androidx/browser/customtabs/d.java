package androidx.browser.customtabs;

import android.os.Bundle;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EngagementSignalsCallback f430a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Bundle c;

    public /* synthetic */ d(EngagementSignalsCallback engagementSignalsCallback, boolean z, Bundle bundle) {
        this.f430a = engagementSignalsCallback;
        this.b = z;
        this.c = bundle;
    }

    public final void run() {
        this.f430a.onVerticalScrollEvent(this.b, this.c);
    }
}
