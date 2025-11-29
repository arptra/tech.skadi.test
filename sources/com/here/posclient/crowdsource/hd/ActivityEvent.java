package com.here.posclient.crowdsource.hd;

import android.os.Bundle;
import com.here.odnp.util.Log;

public class ActivityEvent {
    private static final String KEY_DATA_UPLOAD_SIZE = "size";
    private static final String KEY_TYPE = "type";
    private static final String KEY_WIFI_SCAN_INTERVAL = "interval";
    private static final String TAG = "posclient.crowdsource.hd.ActivityEvent";

    /* renamed from: com.here.posclient.crowdsource.hd.ActivityEvent$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$here$posclient$crowdsource$hd$ActivityEvent$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.here.posclient.crowdsource.hd.ActivityEvent$Type[] r0 = com.here.posclient.crowdsource.hd.ActivityEvent.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$here$posclient$crowdsource$hd$ActivityEvent$Type = r0
                com.here.posclient.crowdsource.hd.ActivityEvent$Type r1 = com.here.posclient.crowdsource.hd.ActivityEvent.Type.DataUploadStarted     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$here$posclient$crowdsource$hd$ActivityEvent$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                com.here.posclient.crowdsource.hd.ActivityEvent$Type r1 = com.here.posclient.crowdsource.hd.ActivityEvent.Type.DataUploadStopped     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$here$posclient$crowdsource$hd$ActivityEvent$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.here.posclient.crowdsource.hd.ActivityEvent$Type r1 = com.here.posclient.crowdsource.hd.ActivityEvent.Type.SensorUseStarted     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$here$posclient$crowdsource$hd$ActivityEvent$Type     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.here.posclient.crowdsource.hd.ActivityEvent$Type r1 = com.here.posclient.crowdsource.hd.ActivityEvent.Type.SensorUseStopped     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$here$posclient$crowdsource$hd$ActivityEvent$Type     // Catch:{ NoSuchFieldError -> 0x003e }
                com.here.posclient.crowdsource.hd.ActivityEvent$Type r1 = com.here.posclient.crowdsource.hd.ActivityEvent.Type.WifiScanStarted     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$here$posclient$crowdsource$hd$ActivityEvent$Type     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.here.posclient.crowdsource.hd.ActivityEvent$Type r1 = com.here.posclient.crowdsource.hd.ActivityEvent.Type.WifiScanStopped     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$here$posclient$crowdsource$hd$ActivityEvent$Type     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.here.posclient.crowdsource.hd.ActivityEvent$Type r1 = com.here.posclient.crowdsource.hd.ActivityEvent.Type.DailyQuotaReached     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.here.posclient.crowdsource.hd.ActivityEvent.AnonymousClass1.<clinit>():void");
        }
    }

    public static class Builder {
        private final Bundle mBundle = new Bundle();

        public Bundle build() {
            return this.mBundle;
        }

        public Builder setType(Type type) {
            this.mBundle.putString("type", type.name());
            return this;
        }

        public Builder setUploadSize(long j) {
            this.mBundle.putLong(ActivityEvent.KEY_DATA_UPLOAD_SIZE, j);
            return this;
        }

        public Builder setWifiScanInterval(long j) {
            this.mBundle.putLong(ActivityEvent.KEY_WIFI_SCAN_INTERVAL, j);
            return this;
        }
    }

    public enum Type {
        DataUploadStarted,
        DataUploadStopped,
        SensorUseStarted,
        SensorUseStopped,
        WifiScanStarted,
        WifiScanStopped,
        DailyQuotaReached
    }

    public static void dispatch(Bundle bundle, IActivityEventDispatcher iActivityEventDispatcher) {
        try {
            switch (AnonymousClass1.$SwitchMap$com$here$posclient$crowdsource$hd$ActivityEvent$Type[Type.valueOf(bundle.getString("type")).ordinal()]) {
                case 1:
                    iActivityEventDispatcher.onDataUploadStarted();
                    return;
                case 2:
                    iActivityEventDispatcher.onDataUploadStopped(bundle.getLong(KEY_DATA_UPLOAD_SIZE, 0));
                    return;
                case 3:
                    iActivityEventDispatcher.onSensorUseStarted();
                    return;
                case 4:
                    iActivityEventDispatcher.onSensorUseStopped();
                    return;
                case 5:
                    iActivityEventDispatcher.onWifiScanStarted(bundle.getLong(KEY_WIFI_SCAN_INTERVAL, 0));
                    return;
                case 6:
                    iActivityEventDispatcher.onWifiScanStopped();
                    return;
                case 7:
                    iActivityEventDispatcher.onDailyQuotaReached();
                    return;
                default:
                    return;
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            Log.e(TAG, "dispatch: error", e);
        }
    }
}
