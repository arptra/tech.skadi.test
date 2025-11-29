package com.here.posclient.ext;

import com.here.posclient.upload.UploadListener;
import com.here.posclient.upload.UploadOptions;

public class Upload {
    private Upload() {
    }

    public static native void cancelUpload();

    public static native int subscribe(UploadListener uploadListener);

    public static native void unsubscribe();

    public static native int upload(UploadOptions uploadOptions);
}
