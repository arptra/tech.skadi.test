package com.upuphone.xr.interconnect.inner;

import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.StarryNetFileOperator;
import com.upuphone.xr.interconnect.entity.StarryNetFile;
import com.upuphone.xr.interconnect.listener.FileReceiver;
import com.upuphone.xr.interconnect.listener.SendFileListener;

class InnerFileOperator implements StarryNetFileOperator {
    private static final String TAG = "InnerFileOperator";
    private String pkgName;

    public InnerFileOperator(String str) {
        this.pkgName = str;
    }

    public void cancelSendFile(String str) {
        InterconnectManager.getInstance().getStarryNetFileTransfer().cancel(str);
    }

    public void registerFileReceiver(FileReceiver fileReceiver) {
        if (fileReceiver != null) {
            InterconnectManager.getInstance().getMainDispatcher().addReceiver(this.pkgName, fileReceiver);
        }
    }

    public void sendFile(StarryNetFile starryNetFile, SendFileListener sendFileListener) {
        starryNetFile.setSenderPkg(this.pkgName);
        InterconnectManager.getInstance().getStarryNetFileTransfer().sendFile(starryNetFile, sendFileListener);
    }

    public void unregisterFileReceiver(FileReceiver fileReceiver) {
        if (fileReceiver != null) {
            InterconnectManager.getInstance().getMainDispatcher().removeReceiver(this.pkgName, fileReceiver);
        }
    }
}
