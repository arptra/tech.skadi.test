package com.here.odnp.posclient.upload;

import com.here.odnp.posclient.ICloseableSession;
import com.here.posclient.Status;
import com.here.posclient.upload.UploadListener;
import com.here.posclient.upload.UploadOptions;

public interface IUploadSession extends ICloseableSession {
    void cancelUpload();

    Status subscribe(UploadListener uploadListener);

    Status unsubscribe(UploadListener uploadListener);

    Status upload(UploadOptions uploadOptions);
}
