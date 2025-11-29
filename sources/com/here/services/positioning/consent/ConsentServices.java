package com.here.services.positioning.consent;

import android.content.Context;
import com.here.annotations.SuppressFBWarnings;
import com.here.odnp.util.Log;
import com.here.services.Api;
import com.here.services.HereLocationApiClient;
import com.here.services.internal.ServiceController;
import com.here.services.positioning.consent.internal.ConsentClient;
import com.here.services.positioning.consent.internal.ConsentServicesController;

public class ConsentServices {
    public static final Api<Api.Options.None> API = new Api<Api.Options.None>() {
        public ServiceController createController(Context context, Api.Options options) {
            Log.v(ConsentServices.TAG, "createController", new Object[0]);
            ConsentServicesController consentServicesController = new ConsentServicesController(ConsentClient.open(context));
            ConsentServices.ConsentProvider = new ConsentProvider(context, new ServiceController.Provider<ConsentServicesController>() {
                public ConsentServicesController getController(HereLocationApiClient hereLocationApiClient) {
                    try {
                        return (ConsentServicesController) hereLocationApiClient.getServiceController(ConsentServices.API);
                    } catch (Exception unused) {
                        return null;
                    }
                }
            });
            return consentServicesController;
        }
    };
    @SuppressFBWarnings({"NM_FIELD_NAMING_CONVENTION"})
    public static ConsentApi ConsentProvider = null;
    private static final String TAG = "services.positioning.ConsentServices";
}
