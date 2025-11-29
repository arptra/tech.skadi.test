package com.here.services.playback;

import android.content.Context;
import android.os.Handler;
import com.here.odnp.util.Log;
import com.here.services.HereLocationApiClient;
import com.here.services.internal.ServiceController;
import com.here.services.playback.MeasurementPlaybackApi;
import com.here.services.playback.internal.MeasurementPlaybackClient;
import com.here.services.playback.internal.MeasurementPlaybackServicesController;

public class MeasurementPlaybackProvider implements MeasurementPlaybackApi {
    private static final String TAG = "services.playback.MeasurementPlaybackProvider";
    private final Handler mHandler = new Handler();
    private ListenerProxy mListenerProxy;
    final ServiceController.Provider<MeasurementPlaybackServicesController> mProvider;

    public static class ListenerProxy implements MeasurementPlaybackClient.IPlaybackStateListener {
        final String mFilename;
        final MeasurementPlaybackApi.Listener mPlaybackListener;

        public ListenerProxy(MeasurementPlaybackApi.Listener listener, String str) {
            this.mPlaybackListener = listener;
            this.mFilename = str;
        }

        public void onPlaybackFinished(String str) {
            if (this.mFilename.equals(str)) {
                this.mPlaybackListener.onPlaybackFinished();
            }
        }

        public void onPlaybackStarted(String str) {
            if (this.mFilename.equals(str)) {
                this.mPlaybackListener.onPlaybackStarted();
            }
        }
    }

    public MeasurementPlaybackProvider(Context context, ServiceController.Provider<MeasurementPlaybackServicesController> provider) {
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

    public void playback(HereLocationApiClient hereLocationApiClient, MeasurementPlaybackApi.Options options, final MeasurementPlaybackApi.Listener listener) {
        if (options == null) {
            throw new IllegalArgumentException("options are null");
        } else if (listener != null) {
            try {
                MeasurementPlaybackClient playbackClient = getPlaybackClient(hereLocationApiClient);
                if (playbackClient != null) {
                    if (this.mListenerProxy != null) {
                        stop(hereLocationApiClient);
                    }
                    ListenerProxy listenerProxy = new ListenerProxy(listener, options.mPlaybackFile.getAbsolutePath());
                    this.mListenerProxy = listenerProxy;
                    playbackClient.startNetworkMeasurementPlayback((MeasurementPlaybackClient.IPlaybackStateListener) listenerProxy, options.asPlaybackOptions());
                    return;
                }
                throw new RuntimeException("playbackClient is null");
            } catch (Exception unused) {
                if (!this.mHandler.post(new Runnable() {
                    public void run() {
                        listener.onPlaybackError(MeasurementPlaybackApi.Listener.Error.General);
                    }
                })) {
                    Log.w(TAG, "playback: direct call to listener", new Object[0]);
                    listener.onPlaybackError(MeasurementPlaybackApi.Listener.Error.General);
                }
                this.mListenerProxy = null;
            }
        } else {
            throw new IllegalArgumentException("listener is null");
        }
    }

    public void stop(HereLocationApiClient hereLocationApiClient) {
        try {
            MeasurementPlaybackClient playbackClient = getPlaybackClient(hereLocationApiClient);
            if (playbackClient == null) {
                Log.e(TAG, "stop: playbackClient is null", new Object[0]);
                return;
            }
            playbackClient.stopNetworkMeasurementPlayback();
            this.mListenerProxy = null;
        } finally {
            this.mListenerProxy = null;
        }
    }
}
