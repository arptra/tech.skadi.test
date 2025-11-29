package com.here.odnp.posclient.upload;

import android.content.Context;
import androidx.annotation.NonNull;

public interface IUploadScheduler {
    void close();

    void dataUploaded(@NonNull Context context);

    void schedule(@NonNull Context context, int i);
}
