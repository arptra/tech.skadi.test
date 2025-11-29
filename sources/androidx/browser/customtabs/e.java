package androidx.browser.customtabs;

import android.os.Bundle;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EngagementSignalsCallback f431a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Bundle c;

    public /* synthetic */ e(EngagementSignalsCallback engagementSignalsCallback, boolean z, Bundle bundle) {
        this.f431a = engagementSignalsCallback;
        this.b = z;
        this.c = bundle;
    }

    public final void run() {
        this.f431a.onVerticalScrollEvent(this.b, this.c);
    }
}
