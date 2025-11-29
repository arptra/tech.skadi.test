package com.here.services.positioning.analytics;

import android.content.Context;
import com.here.annotations.SuppressFBWarnings;
import com.here.odnp.util.Log;
import com.here.services.Api;
import com.here.services.HereLocationApiClient;
import com.here.services.internal.ServiceController;
import com.here.services.positioning.analytics.internal.UsageTrackingClient;
import com.here.services.positioning.analytics.internal.UsageTrackingServicesController;

public class UsageTrackingServices {
    public static final Api<Api.Options.None> API = new Api<Api.Options.None>() {
        public ServiceController createController(Context context, Api.Options options) {
            Log.v(UsageTrackingServices.TAG, "createController", new Object[0]);
            UsageTrackingServicesController usageTrackingServicesController = new UsageTrackingServicesController(UsageTrackingClient.open(context));
            UsageTrackingServices.UsageTrackingProvider = new UsageTrackingProvider(context, new ServiceController.Provider<UsageTrackingServicesController>() {
                public UsageTrackingServicesController getController(HereLocationApiClient hereLocationApiClient) {
                    try {
                        return (UsageTrackingServicesController) hereLocationApiClient.getServiceController(UsageTrackingServices.API);
                    } catch (Exception unused) {
                        return null;
                    }
                }
            });
            return usageTrackingServicesController;
        }
    };
    private static final String TAG = "services.positioning.UsageTrackingServices";
    @SuppressFBWarnings({"NM_FIELD_NAMING_CONVENTION"})
    public static UsageTrackingApi UsageTrackingProvider;
}
