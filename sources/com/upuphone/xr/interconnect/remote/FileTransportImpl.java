package com.upuphone.xr.interconnect.remote;

import android.os.Binder;
import com.honey.account.z7.h;
import com.honey.account.z7.i;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.common.IFileReceiver;
import com.upuphone.xr.interconnect.common.IFileSendListener;
import com.upuphone.xr.interconnect.common.IFileTransport;
import com.upuphone.xr.interconnect.entity.StarryNetFile;
import com.upuphone.xr.interconnect.ipc.IpcClientManager;
import com.upuphone.xr.interconnect.util.DeDuplicateCopyOnWriteArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileTransportImpl extends IFileTransport.Stub implements BinderClientDiedCallback {
    private static final String TAG = "FileTransportImpl";
    private Map<Integer, List<IFileReceiver>> mFileReceiverListMap = new HashMap();

    public FileTransportImpl() {
        IpcClientManager.INSTANCE.addListener(this);
    }

    public void cancel(String str) {
        InterconnectManager.getInstance().getStarryNetFileTransfer().cancel(str);
    }

    public void onClientDied(BinderClient binderClient) {
        List<IFileReceiver> remove = this.mFileReceiverListMap.remove(Integer.valueOf(binderClient.getId()));
        if (remove != null && remove.size() > 0) {
            for (IFileReceiver removeReceiver : remove) {
                InterconnectManager.getInstance().getMainDispatcher().removeReceiver(binderClient.getPackageName(), removeReceiver);
            }
        }
    }

    public void registerFileReceiver(IFileReceiver iFileReceiver) {
        if (iFileReceiver != null) {
            int callingPid = Binder.getCallingPid();
            List list = this.mFileReceiverListMap.get(Integer.valueOf(callingPid));
            if (list == null) {
                list = new DeDuplicateCopyOnWriteArrayList();
                this.mFileReceiverListMap.put(Integer.valueOf(callingPid), list);
            }
            list.add(iFileReceiver);
            IpcClientManager.INSTANCE.useAppId(callingPid, new h(iFileReceiver));
        }
    }

    public void sendFile(StarryNetFile starryNetFile, IFileSendListener iFileSendListener) {
        InterconnectManager.getInstance().getStarryNetFileTransfer().sendFile(starryNetFile, iFileSendListener);
    }

    public void unregisterFileReceiver(IFileReceiver iFileReceiver) {
        if (iFileReceiver != null) {
            int callingPid = Binder.getCallingPid();
            List list = this.mFileReceiverListMap.get(Integer.valueOf(callingPid));
            if (list != null) {
                list.remove(iFileReceiver);
            }
            IpcClientManager.INSTANCE.useAppId(callingPid, new i(iFileReceiver));
        }
    }
}
