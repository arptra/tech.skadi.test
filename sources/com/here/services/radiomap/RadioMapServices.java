package com.here.services.radiomap;

import android.content.Context;
import com.here.annotations.SuppressFBWarnings;
import com.here.odnp.util.Log;
import com.here.services.Api;
import com.here.services.HereLocationApiClient;
import com.here.services.internal.ServiceController;
import com.here.services.internal.ServiceNotFoundException;
import com.here.services.radiomap.internal.IRadioMapManager;
import com.here.services.radiomap.internal.RadioMapManager;
import com.here.services.radiomap.internal.RadioMapServicesController;
import com.here.services.radiomap.manager.RadioMapManagerApi;
import com.here.services.radiomap.manager.RadioMapManagerProvider;

public class RadioMapServices {
    public static final Api<Api.Options.None> API = new Api<Api.Options.None>() {
        public ServiceController createController(Context context, Api.Options options) {
            Log.v(RadioMapServices.TAG, "createController", new Object[0]);
            try {
                IRadioMapManager open = RadioMapManager.open(context);
                if (open != null) {
                    RadioMapServicesController radioMapServicesController = new RadioMapServicesController(open);
                    RadioMapServices.RadioMapManager = new RadioMapManagerProvider(context, new ServiceController.Provider<RadioMapServicesController>() {
                        public RadioMapServicesController getController(HereLocationApiClient hereLocationApiClient) {
                            try {
                                return (RadioMapServicesController) hereLocationApiClient.getServiceController(RadioMapServices.API);
                            } catch (Exception unused) {
                                return null;
                            }
                        }
                    });
                    return radioMapServicesController;
                }
                throw new ServiceNotFoundException();
            } catch (ServiceNotFoundException unused) {
                return null;
            }
        }
    };
    @SuppressFBWarnings({"NM_FIELD_NAMING_CONVENTION"})
    public static RadioMapManagerApi RadioMapManager = null;
    private static final String TAG = "services.radiomap.RadioMapServices";
}
