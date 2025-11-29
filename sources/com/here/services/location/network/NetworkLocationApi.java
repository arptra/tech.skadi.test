package com.here.services.location.network;

import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.posclient.UpdateOptions;
import com.here.services.HereLocationApiClient;
import com.here.services.activity.RecognizedActivity;
import com.here.services.location.LocationApi;
import com.here.services.location.LocationListener;
import java.util.List;
import java.util.concurrent.TimeUnit;

public interface NetworkLocationApi extends LocationApi {

    public static class Options extends LocationApi.CommonOptions<Options> {
        public static final long DEFAULT_DESIRED_INTERVAL = 30000;
        public static final long DEFAULT_SMALLEST_INTERVAL = 200;
        public static final long MIN_DESIRED_INTERVAL = TimeUnit.SECONDS.toMillis(30);
        public static final long MIN_SMALLEST_INTERVAL = 200;
        protected boolean mAlwaysUseRequestedOption = false;
        long mDesiredInterval = 30000;
        long mSmallestInterval = 200;
        boolean mUseCache = true;
        boolean mUseCell = true;
        boolean mUseDetailedOfflineWlan = true;
        boolean mUseOffline = true;
        boolean mUseWifi = true;

        public static class NetworkPositioningOptions extends com.here.services.location.internal.Options {
            public NetworkPositioningOptions(Options options) {
                options.apply(getUpdateOptions().setMediumPowerOptions().setAlwaysUseRequestedOptions(options.mAlwaysUseRequestedOption).setIgnoredFreeTechnologies(options.mIgnoredFreeTechnologies).setClearDataItems(options.mClearDataItems));
            }
        }

        public com.here.services.location.internal.Options build() {
            return new NetworkPositioningOptions(this);
        }

        public void onApply(UpdateOptions updateOptions) {
            updateOptions.setSmallestUpdateInterval(this.mSmallestInterval).setDesiredUpdateInterval(this.mDesiredInterval);
            if (!this.mUseCell) {
                updateOptions.disableTechnologies(12);
            }
            if (!this.mUseWifi) {
                updateOptions.disableTechnologies(2);
            }
            if (!this.mUseCache) {
                updateOptions.disableSources(16);
                updateOptions.disableSources(1);
                updateOptions.disableSources(128);
            }
            if (!this.mUseOffline) {
                updateOptions.disableSources(4);
            }
            if (!this.mUseDetailedOfflineWlan) {
                updateOptions.disableOptions(12);
            }
        }

        @NonNull
        public Options setDesiredInterval(long j) {
            if (j > 0) {
                this.mDesiredInterval = Math.max(MIN_DESIRED_INTERVAL, j);
            } else {
                this.mDesiredInterval = 0;
            }
            this.mSmallestInterval = Math.min(this.mSmallestInterval, this.mDesiredInterval);
            return this;
        }

        @NonNull
        public Options setSmallestInterval(long j) {
            if (j > 0) {
                this.mSmallestInterval = Math.max(200, j);
            } else {
                this.mSmallestInterval = 0;
            }
            this.mDesiredInterval = Math.max(this.mSmallestInterval, this.mDesiredInterval);
            return this;
        }

        @NonNull
        public Options setUseCache(boolean z) {
            this.mUseCache = z;
            return this;
        }

        @NonNull
        public Options setUseCell(boolean z) {
            this.mUseCell = z;
            return this;
        }

        @NonNull
        public Options setUseDetailedOfflineWlan(boolean z) {
            this.mUseDetailedOfflineWlan = z;
            return this;
        }

        @NonNull
        public Options setUseOffline(boolean z) {
            this.mUseOffline = z;
            return this;
        }

        @NonNull
        public Options setUseWifi(boolean z) {
            this.mUseWifi = z;
            return this;
        }
    }

    boolean injectActivityRecognition(@NonNull HereLocationApiClient hereLocationApiClient, @Nullable List<RecognizedActivity> list);

    boolean requestSingleUpdate(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull Options options, @NonNull LocationListener locationListener);

    boolean startLocationUpdates(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull Options options, @NonNull LocationListener locationListener);

    boolean startLocationUpdates(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull Options options, @NonNull LocationListener locationListener, @Nullable Looper looper);
}
