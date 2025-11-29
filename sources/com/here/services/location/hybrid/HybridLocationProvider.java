package com.here.services.location.hybrid;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.odnp.util.Log;
import com.here.services.HereLocationApiClient;
import com.here.services.location.LocationListener;
import com.here.services.location.LocationProviderBase;
import com.here.services.location.hybrid.HybridLocationApi;
import com.here.services.location.internal.IPositioning;
import com.here.services.location.internal.ListenerProxy;

public class HybridLocationProvider extends LocationProviderBase implements HybridLocationApi {
    private static final String TAG = "services.location.hybrid.HybridLocationProvider";

    public HybridLocationProvider(@NonNull Context context) {
    }

    public boolean requestSingleUpdate(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull HybridLocationApi.Options options, @NonNull LocationListener locationListener) {
        IPositioning positioning = getPositioning(hereLocationApiClient);
        if (positioning != null) {
            return positioning.requestSingleUpdate(options.build(), new ListenerProxy(locationListener));
        }
        Log.e(TAG, "requestSingleUpdate: IPositioning is null", new Object[0]);
        return false;
    }

    public boolean startLocationUpdates(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull HybridLocationApi.Options options, @NonNull LocationListener locationListener) {
        return startLocationUpdates(hereLocationApiClient, options, locationListener, (Looper) null);
    }

    public synchronized boolean startLocationUpdates(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull HybridLocationApi.Options options, @NonNull LocationListener locationListener, @Nullable Looper looper) {
        IPositioning positioning = getPositioning(hereLocationApiClient);
        if (positioning == null) {
            Log.e(TAG, "startLocationUpdates: IPositioning is null", new Object[0]);
            return false;
        }
        ListenerProxy listenerProxy = this.mListenerProxies.get(locationListener);
        if (listenerProxy == null) {
            listenerProxy = new ListenerProxy(locationListener, looper);
            this.mListenerProxies.put(locationListener, listenerProxy);
        }
        if (positioning.startPositionUpdates(options.build(), listenerProxy)) {
            return true;
        }
        this.mListenerProxies.remove(locationListener);
        return false;
    }
}
