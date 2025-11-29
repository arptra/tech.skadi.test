package com.here.services.location.network;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.here.odnp.util.Log;
import com.here.posclient.ActivityType;
import com.here.posclient.sensors.GeneralActivityResult;
import com.here.services.HereLocationApiClient;
import com.here.services.activity.RecognizedActivity;
import com.here.services.location.LocationListener;
import com.here.services.location.LocationProviderBase;
import com.here.services.location.internal.IPositioning;
import com.here.services.location.internal.ListenerProxy;
import com.here.services.location.network.NetworkLocationApi;
import java.util.List;

public class NetworkLocationProvider extends LocationProviderBase implements NetworkLocationApi {
    private static final String TAG = "services.location.network.NetworkLocationProvider";

    public NetworkLocationProvider(@NonNull Context context) {
    }

    private GeneralActivityResult getMostProbableActivity(List<RecognizedActivity> list) {
        if (list == null || list.size() <= 0) {
            return new GeneralActivityResult(ActivityType.Unknown, 1.0f, SystemClock.elapsedRealtime());
        }
        RecognizedActivity recognizedActivity = null;
        for (RecognizedActivity next : list) {
            if (recognizedActivity == null || recognizedActivity.getConfidence() < next.getConfidence()) {
                recognizedActivity = next;
            }
        }
        return new GeneralActivityResult(recognizedActivity.getActivityType() == RecognizedActivity.ActivityType.Stationary ? ActivityType.Stationary : ActivityType.Unknown, recognizedActivity.getConfidence(), recognizedActivity.getElapsedRealTimeMs());
    }

    public boolean injectActivityRecognition(@NonNull HereLocationApiClient hereLocationApiClient, @Nullable List<RecognizedActivity> list) {
        IPositioning positioning = getPositioning(hereLocationApiClient);
        if (positioning != null) {
            return positioning.injectActivity(getMostProbableActivity(list));
        }
        Log.e(TAG, "injectActivityRecognition: IPositioning is null", new Object[0]);
        return false;
    }

    public boolean requestSingleUpdate(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull NetworkLocationApi.Options options, @NonNull LocationListener locationListener) {
        IPositioning positioning = getPositioning(hereLocationApiClient);
        if (positioning != null) {
            return positioning.requestSingleUpdate(options.build(), new ListenerProxy(locationListener));
        }
        Log.e(TAG, "requestSingleUpdate: IPositioning is null", new Object[0]);
        return false;
    }

    public synchronized boolean startLocationUpdates(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull NetworkLocationApi.Options options, @NonNull LocationListener locationListener) {
        return startLocationUpdates(hereLocationApiClient, options, locationListener, (Looper) null);
    }

    public synchronized boolean startLocationUpdates(@NonNull HereLocationApiClient hereLocationApiClient, @NonNull NetworkLocationApi.Options options, @NonNull LocationListener locationListener, @Nullable Looper looper) {
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
