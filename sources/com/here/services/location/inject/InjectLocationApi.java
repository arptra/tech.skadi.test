package com.here.services.location.inject;

import android.location.Location;
import androidx.annotation.NonNull;
import com.here.services.HereLocationApiClient;
import com.here.services.location.LocationApi;
import com.here.services.location.LocationListener;

public interface InjectLocationApi extends LocationApi {
    boolean injectLocation(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull Location location);

    boolean startInjectionUpdates(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull LocationListener locationListener);

    void stopInjectionUpdates(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull LocationListener locationListener);
}
