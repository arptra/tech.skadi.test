package androidx.core.telephony;

import android.telephony.SubscriptionManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

@RequiresApi
public class SubscriptionManagerCompat {

    @RequiresApi
    public static class Api29Impl {
        @DoNotInline
        public static int a(int i) {
            return SubscriptionManager.getSlotIndex(i);
        }
    }
}
