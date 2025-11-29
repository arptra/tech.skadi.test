package com.here.services.playback;

import android.content.Context;
import com.here.odnp.util.Log;
import com.here.services.HereLocationApiClient;
import com.here.services.internal.ServiceController;
import com.here.services.playback.TestTrackSimulationApi;
import com.here.services.playback.internal.MeasurementPlaybackClient;
import com.here.services.playback.internal.MeasurementPlaybackServicesController;

public class TestTrackSimulationProvider implements TestTrackSimulationApi {
    private static final String TAG = "services.playback.TestTrackSimulationProvider";
    final Context mContext;
    final ServiceController.Provider<MeasurementPlaybackServicesController> mProvider;

    public TestTrackSimulationProvider(Context context, ServiceController.Provider<MeasurementPlaybackServicesController> provider) {
        this.mContext = context;
        this.mProvider = provider;
    }

    private MeasurementPlaybackClient getPlaybackClient(HereLocationApiClient hereLocationApiClient) {
        MeasurementPlaybackServicesController controller = this.mProvider.getController(hereLocationApiClient);
        if (controller != null) {
            return controller.getMeasurementPlaybackClient();
        }
        Log.e(TAG, "getManager: controller is null, playback client instance not available", new Object[0]);
        return null;
    }

    public boolean startSimulation(HereLocationApiClient hereLocationApiClient, TestTrackSimulationApi.Options options, TestTrackSimulationApi.Listener listener) {
        if (options == null) {
            throw new IllegalArgumentException("options: is null");
        } else if (listener != null) {
            MeasurementPlaybackClient playbackClient = getPlaybackClient(hereLocationApiClient);
            if (playbackClient != null) {
                return playbackClient.startSimulation(listener, options.asBundle());
            }
            Log.e(TAG, "startSimulation: client is null", new Object[0]);
            return false;
        } else {
            throw new IllegalArgumentException("listener: is null");
        }
    }

    public void stopSimulation(HereLocationApiClient hereLocationApiClient) {
        MeasurementPlaybackClient playbackClient = getPlaybackClient(hereLocationApiClient);
        if (playbackClient == null) {
            Log.e(TAG, "stopSimulation: client is null", new Object[0]);
        } else {
            playbackClient.stopSimulation();
        }
    }
}
