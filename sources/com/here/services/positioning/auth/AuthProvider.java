package com.here.services.positioning.auth;

import android.content.Context;
import android.os.RemoteException;
import com.here.odnp.util.Log;
import com.here.posclient.Status;
import com.here.posclient.auth.AuthData;
import com.here.services.HereLocationApiClient;
import com.here.services.internal.ServiceController;
import com.here.services.positioning.auth.AuthApi;
import com.here.services.positioning.auth.internal.AuthClient;
import com.here.services.positioning.auth.internal.AuthListener;
import com.here.services.positioning.auth.internal.AuthServicesController;

public class AuthProvider implements AuthApi {
    private static final String TAG = "services.positioning.auth.AuthProvider";
    private final ServiceController.Provider<AuthServicesController> mProvider;

    public static class ListenerBridge extends AuthListener.Stub {
        final AuthApi.Listener mListener;

        public ListenerBridge(AuthApi.Listener listener) {
            this.mListener = listener;
        }

        public void onAuthDataRequested() throws RemoteException {
            AuthApi.Listener listener = this.mListener;
            if (listener != null) {
                listener.onAuthDataRequested();
            }
        }
    }

    public AuthProvider(Context context, ServiceController.Provider<AuthServicesController> provider) {
        if (provider != null) {
            this.mProvider = provider;
            return;
        }
        throw new IllegalArgumentException("provider is null");
    }

    public AuthClient getClient(HereLocationApiClient hereLocationApiClient) {
        AuthServicesController controller = this.mProvider.getController(hereLocationApiClient);
        if (controller != null) {
            return controller.getAuthClient();
        }
        Log.e(TAG, "getClient: controller is null, auth client instance not available", new Object[0]);
        return null;
    }

    public Status setAuthData(HereLocationApiClient hereLocationApiClient, AuthData authData) {
        AuthClient client = getClient(hereLocationApiClient);
        return client == null ? Status.UsageError : client.setAuthData(authData);
    }

    public Status subscribe(HereLocationApiClient hereLocationApiClient, AuthApi.Listener listener) {
        AuthClient client = getClient(hereLocationApiClient);
        return client == null ? Status.UsageError : client.subscribe(new ListenerBridge(listener));
    }
}
