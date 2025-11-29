package com.upuphone.xr.interconnect.main.dispatcher;

import androidx.annotation.NonNull;
import com.upuphone.xr.interconnect.common.IFileReceiver;

public interface FileReceiverManager {
    void addReceiver(@NonNull String str, @NonNull IFileReceiver iFileReceiver);

    void removeReceiver(@NonNull String str, @NonNull IFileReceiver iFileReceiver);
}
