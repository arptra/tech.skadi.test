package com.here.services.location.hybrid;

import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.posclient.UpdateOptions;
import com.here.services.Api;
import com.here.services.HereLocationApiClient;
import com.here.services.location.LocationApi;
import com.here.services.location.LocationListener;

public interface HybridLocationApi extends LocationApi {

    public static class GnssOptions implements Api.Options {
        long mDisabledTechnologies = 0;
        boolean mGnssEnabled = true;
        boolean mHDGnssEnabled = false;

        /* access modifiers changed from: private */
        public void apply(@NonNull UpdateOptions updateOptions) {
            if (!this.mGnssEnabled) {
                updateOptions.disableTechnologies(1);
                this.mDisabledTechnologies = 1;
                updateOptions.disableSources(64);
                updateOptions.disableSources(1024);
            } else if (!this.mHDGnssEnabled) {
                updateOptions.disableSources(1024);
            }
        }

        @NonNull
        public GnssOptions setEnabled(boolean z) {
            this.mGnssEnabled = z;
            return this;
        }

        @NonNull
        public GnssOptions setHDGnssEnabled(boolean z) {
            this.mHDGnssEnabled = z;
            return this;
        }
    }

    public static class NetworkLocationOptions implements Api.Options {
        boolean mCellEnabled = true;
        long mDisabledTechnologies = 0;
        boolean mOfflineEnabled = true;
        boolean mOnlineEnabled = true;
        boolean mWifiEnabled = true;

        /* access modifiers changed from: private */
        public void apply(UpdateOptions updateOptions) {
            if (isEnabled()) {
                if (!this.mOnlineEnabled) {
                    updateOptions.disableSources(18);
                }
                if (!this.mOfflineEnabled) {
                    updateOptions.disableSources(4);
                }
                if (!this.mCellEnabled) {
                    updateOptions.disableTechnologies(12);
                    this.mDisabledTechnologies = 12;
                    return;
                }
                return;
            }
            updateOptions.disableTechnologies(12);
            this.mDisabledTechnologies = 12;
            updateOptions.disableSources(22);
        }

        public boolean isEnabled() {
            return (this.mOfflineEnabled || this.mOnlineEnabled) && (this.mCellEnabled || this.mWifiEnabled);
        }

        @NonNull
        public NetworkLocationOptions setCellEnabled(boolean z) {
            this.mCellEnabled = z;
            return this;
        }

        @NonNull
        public NetworkLocationOptions setEnabled(boolean z) {
            this.mOnlineEnabled = z;
            this.mOfflineEnabled = z;
            this.mCellEnabled = z;
            this.mWifiEnabled = z;
            return this;
        }

        @NonNull
        public NetworkLocationOptions setOfflineEnabled(boolean z) {
            this.mOfflineEnabled = z;
            return this;
        }

        @NonNull
        public NetworkLocationOptions setOnlineEnabled(boolean z) {
            this.mOnlineEnabled = z;
            return this;
        }

        @NonNull
        public NetworkLocationOptions setWifiEnabled(boolean z) {
            this.mWifiEnabled = z;
            return this;
        }
    }

    public static class Options extends LocationApi.CommonOptions<Options> {
        public static final long DEFAULT_DESIRED_INTERVAL = 100;
        public static final long DEFAULT_SMALLEST_INTERVAL = 100;
        public static final long MIN_DESIRED_INTERVAL = 100;
        public static final long MIN_SMALLEST_INTERVAL = 100;
        long mDesiredInterval = DEFAULT_DESIRED_INTERVAL;
        GnssOptions mGnnsOptions = new GnssOptions();
        boolean mIgnoreAllDisabledFreeTechnologies = false;
        NetworkLocationOptions mNetworkLocationOptions = new NetworkLocationOptions();
        SensorOptions mSensorOptions = new SensorOptions();
        long mSmallestInterval = 100;

        public static class HybridPositioningOptions extends com.here.services.location.internal.Options {
            public HybridPositioningOptions(Options options) {
                options.apply(getUpdateOptions().setHybridPositioningOptions());
            }
        }

        public com.here.services.location.internal.Options build() {
            return new HybridPositioningOptions(this);
        }

        public void onApply(UpdateOptions updateOptions) {
            this.mSensorOptions.apply(updateOptions);
            this.mGnnsOptions.apply(updateOptions);
            this.mNetworkLocationOptions.apply(updateOptions);
            this.mIgnoredFreeTechnologies = 0;
            if (this.mIgnoreAllDisabledFreeTechnologies) {
                long j = this.mSensorOptions.mDisabledTechnologies;
                this.mIgnoredFreeTechnologies = j;
                long j2 = j | this.mGnnsOptions.mDisabledTechnologies;
                this.mIgnoredFreeTechnologies = j2;
                this.mIgnoredFreeTechnologies = j2 | this.mNetworkLocationOptions.mDisabledTechnologies;
            }
            if (!this.mNetworkLocationOptions.mWifiEnabled) {
                updateOptions.disableTechnologies(2);
                if (this.mIgnoreAllDisabledFreeTechnologies) {
                    this.mIgnoredFreeTechnologies = 2 | this.mIgnoredFreeTechnologies;
                }
            }
            if (this.mGnnsOptions.mGnssEnabled && !this.mNetworkLocationOptions.isEnabled()) {
                updateOptions.disableSources(128);
            }
            updateOptions.setSmallestUpdateInterval(this.mSmallestInterval).setDesiredUpdateInterval(this.mDesiredInterval).setIgnoredFreeTechnologies(this.mIgnoredFreeTechnologies);
        }

        @NonNull
        public Options setDesiredInterval(long j) {
            long max = Math.max(100, j);
            this.mDesiredInterval = max;
            this.mSmallestInterval = Math.min(this.mSmallestInterval, max);
            return this;
        }

        @NonNull
        public Options setGnnsOptions(@NonNull GnssOptions gnssOptions) {
            this.mGnnsOptions = gnssOptions;
            return this;
        }

        @NonNull
        public Options setIgnoreAllDisabledFreeTechnologies(boolean z) {
            this.mIgnoreAllDisabledFreeTechnologies = z;
            return this;
        }

        @NonNull
        public Options setNetworkLocationOptions(@NonNull NetworkLocationOptions networkLocationOptions) {
            this.mNetworkLocationOptions = networkLocationOptions;
            return this;
        }

        @NonNull
        public Options setSensorOptions(@NonNull SensorOptions sensorOptions) {
            this.mSensorOptions = sensorOptions;
            return this;
        }

        @NonNull
        public Options setSmallestInterval(long j) {
            long max = Math.max(100, j);
            this.mSmallestInterval = max;
            this.mDesiredInterval = Math.max(this.mDesiredInterval, max);
            return this;
        }
    }

    public static class SensorOptions implements Api.Options {
        long mDisabledTechnologies = 0;
        boolean mEnabled = true;

        /* access modifiers changed from: private */
        public void apply(@NonNull UpdateOptions updateOptions) {
            if (!this.mEnabled) {
                updateOptions.disableTechnologies(256);
                this.mDisabledTechnologies = 256;
            }
        }

        @NonNull
        public SensorOptions setEnabled(boolean z) {
            this.mEnabled = z;
            return this;
        }
    }

    boolean requestSingleUpdate(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull Options options, @NonNull LocationListener locationListener);

    boolean startLocationUpdates(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull Options options, @NonNull LocationListener locationListener);

    boolean startLocationUpdates(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull Options options, @NonNull LocationListener locationListener, @Nullable Looper looper);
}
