package com.here.services.positioning.upload;

import com.here.posclient.Status;
import com.here.posclient.upload.UploadOptions;
import com.here.services.HereLocationApiClient;

public interface UploadApi {

    public interface Listener {
        void onUploadFailed();

        void onUploaded();
    }

    void cancelUpload(HereLocationApiClient hereLocationApiClient);

    Status subscribe(HereLocationApiClient hereLocationApiClient, Listener listener);

    Status upload(HereLocationApiClient hereLocationApiClient, UploadOptions uploadOptions);
}
