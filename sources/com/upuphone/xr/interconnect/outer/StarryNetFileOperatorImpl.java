package com.upuphone.xr.interconnect.outer;

import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.upuphone.xr.interconnect.api.StarryNetFileOperator;
import com.upuphone.xr.interconnect.common.IFileTransport;
import com.upuphone.xr.interconnect.entity.StarryNetFile;
import com.upuphone.xr.interconnect.listener.FileReceiver;
import com.upuphone.xr.interconnect.listener.SendFileListener;
import com.upuphone.xr.interconnect.util.DeDuplicateArrayList;
import com.xjsd.ai.assistant.protocol.CmdCode;
import java.util.List;

public class StarryNetFileOperatorImpl implements StarryNetFileOperator, SuperServiceStateListener {
    private static final String TAG = "StarryNetFileOperatorImpl";
    private String identifier;
    private List<FileReceiver> mFileReceivers = new DeDuplicateArrayList();
    private SuperServiceProvider mProvider;

    private void doRegisterFileReceiver(FileReceiver fileReceiver) {
        IFileTransport fileTransporter = this.mProvider.getFileTransporter();
        if (fileTransporter != null) {
            try {
                fileTransporter.registerFileReceiver(fileReceiver);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void cancelSendFile(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.d(TAG, "取消发送任务id不能为空");
            return;
        }
        IFileTransport fileTransporter = this.mProvider.getFileTransporter();
        if (fileTransporter != null) {
            try {
                fileTransporter.cancel(str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void onServiceConnected() {
        for (FileReceiver doRegisterFileReceiver : this.mFileReceivers) {
            doRegisterFileReceiver(doRegisterFileReceiver);
        }
    }

    public void onServiceDied() {
    }

    public void registerFileReceiver(FileReceiver fileReceiver) {
        if (fileReceiver == null) {
            Log.d(TAG, "unregisterFileReceiver param receiver is null");
            return;
        }
        this.mFileReceivers.add(fileReceiver);
        doRegisterFileReceiver(fileReceiver);
    }

    public void sendFile(StarryNetFile starryNetFile, SendFileListener sendFileListener) {
        if (starryNetFile == null) {
            Log.d(TAG, "发送的文件不能为空");
            try {
                sendFileListener.onFail("-1", CmdCode.CODE_WAKEUP_RECORDING);
            } catch (RemoteException unused) {
            }
        } else {
            starryNetFile.setSenderPkg(this.identifier);
            IFileTransport fileTransporter = this.mProvider.getFileTransporter();
            if (fileTransporter != null) {
                try {
                    fileTransporter.sendFile(starryNetFile, sendFileListener);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setIdentifier(String str) {
        this.identifier = str;
    }

    public void setProvider(SuperServiceProvider superServiceProvider) {
        this.mProvider = superServiceProvider;
    }

    public void unregisterFileReceiver(FileReceiver fileReceiver) {
        if (fileReceiver == null) {
            Log.d(TAG, "unregisterFileReceiver param receiver is null");
            return;
        }
        this.mFileReceivers.remove(fileReceiver);
        IFileTransport fileTransporter = this.mProvider.getFileTransporter();
        if (fileTransporter != null) {
            try {
                fileTransporter.unregisterFileReceiver(fileReceiver);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
