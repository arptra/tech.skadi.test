package com.here.services.playback;

import android.content.Context;
import com.here.annotations.SuppressFBWarnings;
import com.here.services.Api;
import com.here.services.HereLocationApiClient;
import com.here.services.internal.ServiceController;
import com.here.services.playback.internal.MeasurementPlaybackClient;
import com.here.services.playback.internal.MeasurementPlaybackServicesController;

public class MeasurementPlaybackServices {
    public static final Api<Api.Options.None> API = new Api<Api.Options.None>() {
        @SuppressFBWarnings({"ST_WRITE_TO_STATIC_FROM_INSTANCE_METHOD"})
        public ServiceController createController(Context context, Api.Options options) {
            try {
                MeasurementPlaybackClient measurementPlaybackClient = new MeasurementPlaybackClient(context);
                if (measurementPlaybackClient.initialize()) {
                    MeasurementPlaybackServicesController measurementPlaybackServicesController = new MeasurementPlaybackServicesController(measurementPlaybackClient);
                    MeasurementPlaybackServices.MeasurementPlayback = new MeasurementPlaybackProvider(context, new ServiceController.Provider<MeasurementPlaybackServicesController>() {
                        public MeasurementPlaybackServicesController getController(HereLocationApiClient hereLocationApiClient) {
                            try {
                                return (MeasurementPlaybackServicesController) hereLocationApiClient.getServiceController(MeasurementPlaybackServices.API);
                            } catch (Exception unused) {
                                return null;
                            }
                        }
                    });
                    MeasurementPlaybackServices.TestTrackSimulation = new TestTrackSimulationProvider(context, new ServiceController.Provider<MeasurementPlaybackServicesController>() {
                        public MeasurementPlaybackServicesController getController(HereLocationApiClient hereLocationApiClient) {
                            try {
                                return (MeasurementPlaybackServicesController) hereLocationApiClient.getServiceController(MeasurementPlaybackServices.API);
                            } catch (Exception unused) {
                                return null;
                            }
                        }
                    });
                    return measurementPlaybackServicesController;
                }
                throw new Exception("MeasurementPlaybackClient initialization failed");
            } catch (Exception unused) {
                return null;
            }
        }
    };
    @SuppressFBWarnings({"NM_FIELD_NAMING_CONVENTION"})
    public static MeasurementPlaybackApi MeasurementPlayback = null;
    private static final String TAG = "services.playback.MeasurementPlaybackServices";
    @SuppressFBWarnings({"NM_FIELD_NAMING_CONVENTION"})
    public static TestTrackSimulationApi TestTrackSimulation;
}
