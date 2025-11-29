package com.upuphone.xr.interconnect.main.dispatcher;

import androidx.annotation.NonNull;
import com.upuphone.xr.interconnect.business.messenger.IpcMessageDispatcher;
import com.upuphone.xr.interconnect.business.messenger.MainMessageDispatcher;
import com.upuphone.xr.interconnect.common.IFileReceiver;
import com.upuphone.xr.interconnect.entity.StarryNetFile;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class MainDispatcher implements FileReceiverManager, FileTransportEventDispatcher {
    private static final String TAG = "MainDispatcher";
    private FileTransportEventDispatcherImpl mFileTransportDelegate = new FileTransportEventDispatcherImpl();
    private CopyOnWriteArraySet<MessageDispatcher> mMessageDispatcherList = new CopyOnWriteArraySet<>();

    public void addMessageDispatcher(MessageDispatcher messageDispatcher) {
        ILog.i(TAG, "addMessageDispatcher--" + messageDispatcher);
        this.mMessageDispatcherList.add(messageDispatcher);
        ILog.i(TAG, "MessageDispatcher list--" + this.mMessageDispatcherList);
    }

    public void addReceiver(@NonNull String str, @NonNull IFileReceiver iFileReceiver) {
        this.mFileTransportDelegate.addReceiver(str, iFileReceiver);
    }

    public void clear() {
        ILog.d(TAG, "所有远程client已断连，清理相关数据");
        ArrayList arrayList = new ArrayList();
        Iterator<MessageDispatcher> it = this.mMessageDispatcherList.iterator();
        while (it.hasNext()) {
            MessageDispatcher next = it.next();
            if (next instanceof IpcMessageDispatcher) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            this.mMessageDispatcherList.removeAll(arrayList);
        }
    }

    public void dispatch(StarryNetMessage starryNetMessage) {
        MainMessageDispatcher.INSTANCE.dispatch(TAG, starryNetMessage, this.mMessageDispatcherList);
    }

    public void dispatchFailEvent(String str, String str2, int i) {
        this.mFileTransportDelegate.dispatchFailEvent(str, str2, i);
    }

    public void dispatchProgressChangedEvent(String str, String str2, int i) {
        this.mFileTransportDelegate.dispatchProgressChangedEvent(str, str2, i);
    }

    public void dispatchStartEvent(String str, String str2, StarryNetFile starryNetFile) {
        this.mFileTransportDelegate.dispatchStartEvent(str, str2, starryNetFile);
    }

    public void dispatchSuccessEvent(String str, String str2, String str3) {
        this.mFileTransportDelegate.dispatchSuccessEvent(str, str2, str3);
    }

    public void notifyDiedEvent(StarryNetMessage starryNetMessage) {
        dispatch(starryNetMessage);
    }

    public void removeMessageDispatcher(MessageDispatcher messageDispatcher) {
        this.mMessageDispatcherList.remove(messageDispatcher);
    }

    public void removeReceiver(@NonNull String str, @NonNull IFileReceiver iFileReceiver) {
        this.mFileTransportDelegate.removeReceiver(str, iFileReceiver);
    }
}
