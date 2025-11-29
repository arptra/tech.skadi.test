package com.here.services.location;

import android.location.Location;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.posclient.PositioningFeature;
import com.here.posclient.UpdateOptions;
import com.here.services.Api;
import com.here.services.HereLocationApiClient;

public interface LocationApi {

    public static abstract class CommonOptions<T> implements Api.Options {
        protected int mClearDataItems = 0;
        protected long mIgnoredFreeTechnologies = 0;
        private boolean mStateless;

        public void apply(UpdateOptions updateOptions) {
            if (this.mStateless) {
                updateOptions.enableOptions(4096);
            }
            onApply(updateOptions);
        }

        public abstract void onApply(UpdateOptions updateOptions);

        public T setUseStatelessRequest(boolean z) {
            this.mStateless = z;
            return this;
        }
    }

    int availableFeatures(@NonNull HereLocationApiClient hereLocationApiClient);

    int enabledFeatures(@NonNull HereLocationApiClient hereLocationApiClient);

    @Nullable
    Location getLastLocation(HereLocationApiClient hereLocationApiClient);

    void stopLocationUpdates(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull LocationListener locationListener);

    void toggleFeature(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull PositioningFeature positioningFeature, boolean z);
}
