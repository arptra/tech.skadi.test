package com.here.services.crowdsource;

import android.content.Context;
import com.here.annotations.SuppressFBWarnings;
import com.here.odnp.util.Log;
import com.here.services.Api;
import com.here.services.HereLocationApiClient;
import com.here.services.crowdsource.hd.HdWifiCollectionApi;
import com.here.services.crowdsource.hd.HdWifiCollectionProvider;
import com.here.services.crowdsource.hd.internal.HdWifiCollectionClient;
import com.here.services.crowdsource.hd.internal.HdWifiCollectionServicesController;
import com.here.services.internal.ServiceController;

public class CrowdsourceServices {
    public static final Api<Api.Options.None> API = new Api<Api.Options.None>() {
        public ServiceController createController(Context context, Api.Options options) {
            Log.v(CrowdsourceServices.TAG, "createController", new Object[0]);
            HdWifiCollectionServicesController hdWifiCollectionServicesController = new HdWifiCollectionServicesController(HdWifiCollectionClient.open(context));
            CrowdsourceServices.HdWifiCollectionProvider = new HdWifiCollectionProvider(context, new ServiceController.Provider<HdWifiCollectionServicesController>() {
                public HdWifiCollectionServicesController getController(HereLocationApiClient hereLocationApiClient) {
                    try {
                        return (HdWifiCollectionServicesController) hereLocationApiClient.getServiceController(CrowdsourceServices.API);
                    } catch (Exception unused) {
                        return null;
                    }
                }
            });
            return hdWifiCollectionServicesController;
        }
    };
    @SuppressFBWarnings({"NM_FIELD_NAMING_CONVENTION"})
    public static HdWifiCollectionApi HdWifiCollectionProvider = null;
    private static final String TAG = "services.crowdsource.CrowdsourceServices";
}
