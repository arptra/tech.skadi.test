package com.here.services.positioning.auth;

import android.content.Context;
import com.here.annotations.SuppressFBWarnings;
import com.here.odnp.util.Log;
import com.here.services.Api;
import com.here.services.HereLocationApiClient;
import com.here.services.internal.ServiceController;
import com.here.services.positioning.auth.internal.AuthClient;
import com.here.services.positioning.auth.internal.AuthServicesController;

public class AuthServices {
    public static final Api<Api.Options.None> API = new Api<Api.Options.None>() {
        public ServiceController createController(Context context, Api.Options options) {
            Log.v(AuthServices.TAG, "createController", new Object[0]);
            AuthServicesController authServicesController = new AuthServicesController(AuthClient.open(context));
            AuthServices.AuthProvider = new AuthProvider(context, new ServiceController.Provider<AuthServicesController>() {
                public AuthServicesController getController(HereLocationApiClient hereLocationApiClient) {
                    try {
                        return (AuthServicesController) hereLocationApiClient.getServiceController(AuthServices.API);
                    } catch (Exception unused) {
                        return null;
                    }
                }
            });
            return authServicesController;
        }
    };
    @SuppressFBWarnings({"NM_FIELD_NAMING_CONVENTION"})
    public static AuthApi AuthProvider = null;
    private static final String TAG = "services.positioning.AuthServices";
}
