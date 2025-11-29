package com.here.services.positioning.upload;

import android.content.Context;
import android.os.RemoteException;
import com.here.odnp.util.Log;
import com.here.posclient.Status;
import com.here.posclient.upload.UploadOptions;
import com.here.services.HereLocationApiClient;
import com.here.services.internal.ServiceController;
import com.here.services.positioning.upload.UploadApi;
import com.here.services.positioning.upload.internal.UploadClient;
import com.here.services.positioning.upload.internal.UploadListener;
import com.here.services.positioning.upload.internal.UploadServicesController;

public class UploadProvider implements UploadApi {
    private static final String TAG = "services.positioning.upload.UploadProvider";
    private final ServiceController.Provider<UploadServicesController> mProvider;

    public static class ListenerBridge extends UploadListener.Stub {
        final UploadApi.Listener mListener;

        public ListenerBridge(UploadApi.Listener listener) {
            this.mListener = listener;
        }

        public void onUploadFailed() throws RemoteException {
            UploadApi.Listener listener = this.mListener;
            if (listener != null) {
                listener.onUploadFailed();
            }
        }

        public void onUploaded() throws RemoteException {
            UploadApi.Listener listener = this.mListener;
            if (listener != null) {
                listener.onUploaded();
            }
        }
    }

    public UploadProvider(Context context, ServiceController.Provider<UploadServicesController> provider) {
        if (provider != null) {
            this.mProvider = provider;
            return;
        }
        throw new IllegalArgumentException("provider is null");
    }

    public void cancelUpload(HereLocationApiClient hereLocationApiClient) {
        UploadClient client = getClient(hereLocationApiClient);
        if (client != null) {
            client.cancelUpload();
        }
    }

    public UploadClient getClient(HereLocationApiClient hereLocationApiClient) {
        UploadServicesController controller = this.mProvider.getController(hereLocationApiClient);
        if (controller != null) {
            return controller.getUploadClient();
        }
        Log.e(TAG, "getClient: controller is null, upload client instance not available", new Object[0]);
        return null;
    }

    public Status subscribe(HereLocationApiClient hereLocationApiClient, UploadApi.Listener listener) {
        UploadClient client = getClient(hereLocationApiClient);
        return client == null ? Status.UsageError : client.subscribe(new ListenerBridge(listener));
    }

    public Status upload(HereLocationApiClient hereLocationApiClient, UploadOptions uploadOptions) {
        UploadClient client = getClient(hereLocationApiClient);
        return client == null ? Status.UsageError : client.upload(uploadOptions);
    }
}
