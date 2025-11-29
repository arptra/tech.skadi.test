package com.upuphone.xr.interconnect.api;

import com.upuphone.xr.interconnect.entity.StarryNetFile;
import com.upuphone.xr.interconnect.listener.FileReceiver;
import com.upuphone.xr.interconnect.listener.SendFileListener;

public interface StarryNetFileOperator {
    void cancelSendFile(String str);

    void registerFileReceiver(FileReceiver fileReceiver);

    void sendFile(StarryNetFile starryNetFile, SendFileListener sendFileListener);

    void unregisterFileReceiver(FileReceiver fileReceiver);
}
