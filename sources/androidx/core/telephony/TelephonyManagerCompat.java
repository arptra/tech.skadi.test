package androidx.core.telephony;

import android.annotation.SuppressLint;
import android.telephony.TelephonyManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;

public class TelephonyManagerCompat {

    @RequiresApi
    public static class Api23Impl {
        @DoNotInline
        @SuppressLint({"MissingPermission"})
        @Nullable
        @RequiresPermission
        public static String a(TelephonyManager telephonyManager, int i) {
            return telephonyManager.getDeviceId(i);
        }
    }

    @RequiresApi
    public static class Api26Impl {
        @DoNotInline
        @SuppressLint({"MissingPermission"})
        @Nullable
        @RequiresPermission
        public static String a(TelephonyManager telephonyManager) {
            return telephonyManager.getImei();
        }
    }

    @RequiresApi
    public static class Api30Impl {
        @DoNotInline
        public static int a(TelephonyManager telephonyManager) {
            return telephonyManager.getSubscriptionId();
        }
    }
}
