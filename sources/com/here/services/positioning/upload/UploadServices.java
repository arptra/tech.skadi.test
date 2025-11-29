package com.here.services.positioning.upload;

import android.content.Context;
import com.here.annotations.SuppressFBWarnings;
import com.here.odnp.util.Log;
import com.here.services.Api;
import com.here.services.HereLocationApiClient;
import com.here.services.internal.ServiceController;
import com.here.services.positioning.upload.internal.UploadClient;
import com.here.services.positioning.upload.internal.UploadServicesController;

public class UploadServices {
    public static final Api<Api.Options.None> API = new Api<Api.Options.None>() {
        public ServiceController createController(Context context, Api.Options options) {
            Log.v(UploadServices.TAG, "createController", new Object[0]);
            UploadServicesController uploadServicesController = new UploadServicesController(UploadClient.open(context));
            UploadServices.UploadProvider = new UploadProvider(context, new ServiceController.Provider<UploadServicesController>() {
                public UploadServicesController getController(HereLocationApiClient hereLocationApiClient) {
                    try {
                        return (UploadServicesController) hereLocationApiClient.getServiceController(UploadServices.API);
                    } catch (Exception unused) {
                        return null;
                    }
                }
            });
            return uploadServicesController;
        }
    };
    private static final String TAG = "services.positioning.UploadServices";
    @SuppressFBWarnings({"NM_FIELD_NAMING_CONVENTION"})
    public static UploadApi UploadProvider;
}
