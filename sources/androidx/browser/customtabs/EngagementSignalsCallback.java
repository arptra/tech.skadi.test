package androidx.browser.customtabs;

import android.os.Bundle;

public interface EngagementSignalsCallback {
    void onGreatestScrollPercentageIncreased(int i, Bundle bundle) {
    }

    void onSessionEnded(boolean z, Bundle bundle) {
    }

    void onVerticalScrollEvent(boolean z, Bundle bundle) {
    }
}
