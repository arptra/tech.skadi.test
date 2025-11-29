package com.here.posclient.upload;

public interface UploadListener {
    void onUploadDataAvailable(int i);

    void onUploadFailed();

    void onUploaded();
}
